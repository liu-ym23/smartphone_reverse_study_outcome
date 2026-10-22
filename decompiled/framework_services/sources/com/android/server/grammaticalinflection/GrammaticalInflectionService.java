package com.android.server.grammaticalinflection;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.GrammaticalInflectionManager;
import android.app.IGrammaticalInflectionManager;
import android.content.AttributionSource;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Environment;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserManager;
import android.permission.PermissionManager;
import android.util.AtomicFile;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class GrammaticalInflectionService extends SystemService {
    private static final String ATTR_NAME = "grammatical_gender";
    private static final String GRAMMATICAL_GENDER_PROPERTY = "persist.sys.grammatical_gender";
    private static final String GRAMMATICAL_INFLECTION_ENABLED = "i18n.grammatical_Inflection.enabled";
    private static final String TAG = "GrammaticalInflection";
    private static final String TAG_GRAMMATICAL_INFLECTION = "grammatical_inflection";
    private static final String USER_SETTINGS_FILE_NAME = "user_settings.xml";
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private final GrammaticalInflectionBackupHelper mBackupHelper;
    private GrammaticalInflectionBinderService mBinderService;
    private Context mContext;
    private final SparseIntArray mGrammaticalGenderCache;
    private final Object mLock;
    private PackageManagerInternal mPackageManagerInternal;
    private PermissionManager mPermissionManager;

    private final class GrammaticalInflectionBinderService extends IGrammaticalInflectionManager.Stub {
        final /* synthetic */ GrammaticalInflectionService this$0;

        /* synthetic */ GrammaticalInflectionBinderService(GrammaticalInflectionService r1, GrammaticalInflectionServiceIA r2) {
            this(r1);
        }

        private GrammaticalInflectionBinderService(GrammaticalInflectionService r1) {
            this.this$0 = r1;
        }

        public void setRequestedApplicationGrammaticalGender(String appPackageName, int userId, int gender) {
            this.this$0.setRequestedApplicationGrammaticalGender(appPackageName, userId, gender);
        }

        public void setSystemWideGrammaticalGender(int grammaticalGender, int userId) {
            GrammaticalInflectionService.m4256$$Nest$menforceCallerPermissions(this.this$0);
            this.this$0.setSystemWideGrammaticalGender(grammaticalGender, userId);
        }

        public int getSystemGrammaticalGender(AttributionSource attributionSource, int userId) {
            if (GrammaticalInflectionUtils.checkSystemGrammaticalGenderPermission(GrammaticalInflectionService.m4254$$Nest$fgetmPermissionManager(this.this$0), attributionSource) == false) goto L10;
            if (GrammaticalInflectionService.m4257$$Nest$smcheckSystemTermsOfAddressIsEnabled() == true) goto L11;
            return 0;
        L11:
            return this.this$0.getSystemGrammaticalGender(userId);
        L10:
            throw new SecurityException("AttributionSource: " + attributionSource + " does not have READ_SYSTEM_GRAMMATICAL_GENDER permission.");
        }

        public int peekSystemGrammaticalGenderByUserId(AttributionSource attributionSource, int userId) {
            if (GrammaticalInflectionService.m4255$$Nest$mcanGetSystemGrammaticalGender(this.this$0, attributionSource) == true) goto L7;
            return 0;
        L7:
            return this.this$0.getSystemGrammaticalGender(userId);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new GrammaticalInflectionShellCommand(GrammaticalInflectionService.m4252$$Nest$fgetmBinderService(this.this$0), GrammaticalInflectionService.m4253$$Nest$fgetmContext(this.this$0).getAttributionSource()).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    private final class GrammaticalInflectionManagerInternalImpl extends GrammaticalInflectionManagerInternal {
        final /* synthetic */ GrammaticalInflectionService this$0;

        /* synthetic */ GrammaticalInflectionManagerInternalImpl(GrammaticalInflectionService r1, GrammaticalInflectionServiceIA r2) {
            this(r1);
        }

        private GrammaticalInflectionManagerInternalImpl(GrammaticalInflectionService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public byte[] getBackupPayload(int userId) {
            GrammaticalInflectionService.m4256$$Nest$menforceCallerPermissions(this.this$0);
            return GrammaticalInflectionService.m4251$$Nest$fgetmBackupHelper(this.this$0).getBackupPayload(userId);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public void stageAndApplyRestoredPayload(byte[] payload, int userId) {
            GrammaticalInflectionService.m4251$$Nest$fgetmBackupHelper(this.this$0).stageAndApplyRestoredPayload(payload, userId);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public byte[] getSystemBackupPayload(int userId) {
            GrammaticalInflectionService.m4256$$Nest$menforceCallerPermissions(this.this$0);
            return GrammaticalInflectionService.m4251$$Nest$fgetmBackupHelper(this.this$0).getSystemBackupPayload(userId);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public void applyRestoredSystemPayload(byte[] payload, int userId) {
            GrammaticalInflectionService.m4251$$Nest$fgetmBackupHelper(this.this$0).applyRestoredSystemPayload(payload, userId);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public int getSystemGrammaticalGender(int userId) {
            if (GrammaticalInflectionService.m4257$$Nest$smcheckSystemTermsOfAddressIsEnabled() == true) goto L7;
            return 0;
        L7:
            return this.this$0.getSystemGrammaticalGender(userId);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public int mergedFinalSystemGrammaticalGender() {
            int systemGrammaticalGender = getSystemGrammaticalGender(GrammaticalInflectionService.m4253$$Nest$fgetmContext(this.this$0).getUserId());
            if (systemGrammaticalGender != 0) goto L6;
            systemGrammaticalGender = getGrammaticalGenderFromDeveloperSettings();
        L6:
            if (systemGrammaticalGender != (-1)) goto L9;
            return 0;
        L9:
            return systemGrammaticalGender;
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public int getGrammaticalGenderFromDeveloperSettings() {
            return SystemProperties.getInt(GrammaticalInflectionService.GRAMMATICAL_GENDER_PROPERTY, 0);
        }

        @Override // com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal
        public boolean canGetSystemGrammaticalGender(int uid) {
            if (uid != 1000) goto L6;
            return true;
        L6:
            AttributionSource attributionSource = new AttributionSource.Builder(uid).build();
            return GrammaticalInflectionService.m4255$$Nest$mcanGetSystemGrammaticalGender(this.this$0, attributionSource);
        }
    }

    public static /* synthetic */ void $r8$lambda$sWnJ5Api2DUCiEAZO1zYUXFfRbI(GrammaticalInflectionService r0, SystemService.TargetUser r1) {
        r0.lambda$onUserUnlocked$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ GrammaticalInflectionBackupHelper m4251$$Nest$fgetmBackupHelper(GrammaticalInflectionService r0) {
        return r0.mBackupHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinderService, reason: not valid java name */
    static /* bridge */ /* synthetic */ GrammaticalInflectionBinderService m4252$$Nest$fgetmBinderService(GrammaticalInflectionService r0) {
        return r0.mBinderService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4253$$Nest$fgetmContext(GrammaticalInflectionService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionManager m4254$$Nest$fgetmPermissionManager(GrammaticalInflectionService r0) {
        return r0.mPermissionManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mcanGetSystemGrammaticalGender, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4255$$Nest$mcanGetSystemGrammaticalGender(GrammaticalInflectionService r0, AttributionSource r1) {
        return r0.canGetSystemGrammaticalGender(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCallerPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4256$$Nest$menforceCallerPermissions(GrammaticalInflectionService r0) {
        r0.enforceCallerPermissions();
    }

    /* JADX INFO: renamed from: -$$Nest$smcheckSystemTermsOfAddressIsEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4257$$Nest$smcheckSystemTermsOfAddressIsEnabled() {
        return checkSystemTermsOfAddressIsEnabled();
    }

    public GrammaticalInflectionService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mGrammaticalGenderCache = new SparseIntArray();
        this.mContext = context;
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mBackupHelper = new GrammaticalInflectionBackupHelper(this.mContext.getAttributionSource(), this, context.getPackageManager());
        this.mBinderService = new GrammaticalInflectionBinderService(this, null);
        this.mPermissionManager = (PermissionManager) context.getSystemService(PermissionManager.class);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(TAG_GRAMMATICAL_INFLECTION, this.mBinderService);
        LocalServices.addService(GrammaticalInflectionManagerInternal.class, new GrammaticalInflectionManagerInternalImpl(this, null));
    }

    protected int getApplicationGrammaticalGender(String appPackageName, int userId) {
        ActivityTaskManagerInternal.PackageConfig appConfig = this.mActivityTaskManagerInternal.getApplicationConfig(appPackageName, userId);
        if (appConfig != null) goto L5;
        return 0;
    L5:
        if (appConfig.mGrammaticalGender != null) goto L8;
        return 0;
    L8:
        return appConfig.mGrammaticalGender.intValue();
    }

    protected void setRequestedApplicationGrammaticalGender(String appPackageName, int userId, int gender) {
        int preValue = getApplicationGrammaticalGender(appPackageName, userId);
        ActivityTaskManagerInternal.PackageConfigurationUpdater updater = this.mActivityTaskManagerInternal.createPackageConfigurationUpdater(appPackageName, userId);
        boolean r3 = true;
        if (SystemProperties.getBoolean(GRAMMATICAL_INFLECTION_ENABLED, true) == true) goto L7;
        if (preValue == 0) goto L16;
        Log.d(TAG, "Clearing the user's grammatical gender setting");
        updater.setGrammaticalGender(0).commit();
        return;
    L16:
        return;
    L7:
        int uid = this.mPackageManagerInternal.getPackageUid(appPackageName, 0, userId);
        if (gender == 0) goto L10;
        boolean r5 = true;
    L11:
        if (preValue != 0) goto L14;
        r3 = false;
    L14:
        FrameworkStatsLog.write(FrameworkStatsLog.APPLICATION_GRAMMATICAL_INFLECTION_CHANGED, 2, uid, r5, r3);
        updater.setGrammaticalGender(gender).commit();
        return;
    L10:
        r5 = false;
        goto L11
    }

    protected void setSystemWideGrammaticalGender(int grammaticalGender, int userId) {
    L17:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (checkSystemTermsOfAddressIsEnabled() == true) goto L6;
        Trace.endSection();
        return;
    L6:
        Trace.beginSection("GrammaticalInflectionService.setSystemWideGrammaticalGender");     // Catch: Throwable -> L17
        if (GrammaticalInflectionManager.VALID_GRAMMATICAL_GENDER_VALUES.contains(Integer.valueOf(grammaticalGender)) == false) goto L44;
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L11;
    L24:
        File file = getGrammaticalGenderFile(userId);     // Catch: Throwable -> L17
        Object r1 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
        AtomicFile atomicFile = new AtomicFile(file);     // Catch: Throwable -> L33
        FileOutputStream stream = null;
        stream = atomicFile.startWrite();     // Catch: Throwable -> L33 IOException -> L35
        stream.write(toXmlByteArray(grammaticalGender, stream));     // Catch: Throwable -> L33 IOException -> L35
        atomicFile.finishWrite(stream);     // Catch: Throwable -> L33 IOException -> L35
        this.mGrammaticalGenderCache.put(userId, grammaticalGender);     // Catch: Throwable -> L33 IOException -> L35
        monitor-exit(r1);     // Catch: Throwable -> L33
        updateConfiguration(grammaticalGender, userId);     // Catch: Throwable -> L17
        Trace.endSection();
        return;
    L35:
        e = move-exception;
        Log.e(TAG, "Failed to write file " + atomicFile, e);     // Catch: Throwable -> L33
        if (stream == null) goto L40;
        atomicFile.failWrite(stream);     // Catch: Throwable -> L33
    L40:
        throw new RuntimeException(e);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L11:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L24;
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        int currentUser = ActivityManager.getCurrentUser();     // Catch: Throwable -> L21
        if (userId != currentUser) goto L19;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L17
        goto L24
    L19:
        Log.w(TAG, "Only current user is allowed to update GrammaticalInflection if visible background users are enabled. Current User" + currentUser + ". Calling User: " + userId);     // Catch: Throwable -> L21
        throw new SecurityException("Only current user is allowed to update GrammaticalInflection.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L44:
        throw new IllegalArgumentException("Unknown grammatical gender");     // Catch: Throwable -> L17
    }

    private static void updateConfiguration(int grammaticalGender, int userId) {
        Configuration config = new Configuration();     // Catch: RemoteException -> L10
        int preValue = config.getGrammaticalGender();     // Catch: RemoteException -> L10
        config.setGrammaticalGender(grammaticalGender);     // Catch: RemoteException -> L10
        ActivityTaskManager.getService().updateConfiguration(config);     // Catch: RemoteException -> L10
        boolean r2 = false;
        if (grammaticalGender == 0) goto L5;
        boolean r4 = true;
    L6:
        if (preValue == 0) goto L8;
        r2 = true;
    L8:
        FrameworkStatsLog.write(FrameworkStatsLog.SYSTEM_GRAMMATICAL_INFLECTION_CHANGED, 1, userId, r4, r2);     // Catch: RemoteException -> L10
        GrammaticalInflectionBackupHelper.notifyBackupManager();     // Catch: RemoteException -> L10
        return;
    L5:
        r4 = false;
    L10:
        e = move-exception;
        Log.w(TAG, "Can not update configuration", e);
    }

    public int getSystemGrammaticalGender(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int grammaticalGender = this.mGrammaticalGenderCache.get(userId);     // Catch: Throwable -> L10
        if (grammaticalGender >= 0) goto L7;
        int r2 = 0;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = grammaticalGender;
    L10:
        th = move-exception;
        throw th;
    }

    private static File getGrammaticalGenderFile(int userId) {
        File dir = new File(Environment.getDataSystemCeDirectory(userId), TAG_GRAMMATICAL_INFLECTION);
        return new File(dir, USER_SETTINGS_FILE_NAME);
    }

    private static byte[] toXmlByteArray(int grammaticalGender, FileOutputStream fileStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TypedXmlSerializer out = Xml.resolveSerializer(fileStream);
        out.setOutput(outputStream, StandardCharsets.UTF_8.name());
        out.startDocument(null, true);
        out.startTag(null, TAG_GRAMMATICAL_INFLECTION);
        out.attributeInt(null, ATTR_NAME, grammaticalGender);
        out.endTag(null, TAG_GRAMMATICAL_INFLECTION);
        out.endDocument();
        return outputStream.toByteArray();
    }

    private static int getGrammaticalGenderFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        XmlUtils.nextElement(parser);
    L4:
        if (parser.getEventType() == 1) goto L10;
        String tagName = parser.getName();
        if (TAG_GRAMMATICAL_INFLECTION.equals(tagName) == true) goto L8;
        XmlUtils.nextElement(parser);
        goto L4
    L8:
        return parser.getAttributeInt(null, ATTR_NAME);
    L10:
        return 0;
    }

    private void enforceCallerPermissions() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L5;
        return;
    L5:
        if (callingUid == 2000) goto L10;
        if (callingUid == 0) goto L11;
        this.mContext.enforceCallingOrSelfPermission("android.permission.CHANGE_CONFIGURATION", "Caller must be system, shell, root or hold CHANGE_CONFIGURATION permission.");
        return;
    L11:
        return;
    }

    private static boolean checkSystemTermsOfAddressIsEnabled() {
        return true;
    }

    private boolean canGetSystemGrammaticalGender(AttributionSource attributionSource) {
        if (checkSystemTermsOfAddressIsEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (GrammaticalInflectionUtils.checkSystemGrammaticalGenderPermission(this.mPermissionManager, attributionSource) == false) goto L7;
        return true;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(final SystemService.TargetUser user) {
        if (checkSystemTermsOfAddressIsEnabled() == true) goto L5;
        return;
    L5:
        IoThread.getHandler().post(new GrammaticalInflectionService$$ExternalSyntheticLambda0(this, user));
    }

    private /* synthetic */ void lambda$onUserUnlocked$0(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        File file = getGrammaticalGenderFile(userId);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (file.exists() == true) goto L12;
        Log.d(TAG, "User " + userId + " doesn't have the grammatical gender file.");     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mGrammaticalGenderCache.indexOfKey(userId) < 0) goto L35;
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L35:
        FileInputStream in = new FileInputStream(file);     // Catch: Throwable -> L9 Throwable -> L21
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L23
        int grammaticalGender = getGrammaticalGenderFromXml(parser);     // Catch: Throwable -> L23
        this.mGrammaticalGenderCache.put(userId, grammaticalGender);     // Catch: Throwable -> L23
        in.close();     // Catch: Throwable -> L9 Throwable -> L21 Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L9
        updateConfiguration(grammaticalGender, userId);
        return;
    L23:
        th = move-exception;
        in.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L9 Throwable -> L21 Throwable -> L21
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Throwable -> L21 Throwable -> L21
    L21:
        e = move-exception;
        Log.e(TAG, "Failed to parse XML configuration from " + file, e);     // Catch: Throwable -> L9
    }
}
