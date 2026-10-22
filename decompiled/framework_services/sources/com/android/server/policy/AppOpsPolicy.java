package com.android.server.policy;

import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.SyncNotedAppOp;
import android.app.role.RoleManager;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManagerInternal;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PackageTagsList;
import android.os.Process;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.service.voice.VoiceInteractionManagerInternal;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.function.DodecFunction;
import com.android.internal.util.function.HexConsumer;
import com.android.internal.util.function.HexFunction;
import com.android.internal.util.function.NonaFunction;
import com.android.internal.util.function.QuadFunction;
import com.android.internal.util.function.UndecFunction;
import com.android.server.LocalServices;
import com.android.server.pm.Settings;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class AppOpsPolicy implements AppOpsManagerInternal.CheckOpsDelegate {
    private static final String ACTIVITY_RECOGNITION_TAGS = "android:activity_recognition_allow_listed_tags";
    private static final String ACTIVITY_RECOGNITION_TAGS_SEPARATOR = ";";
    private static final String LOG_TAG = null;
    private static final boolean SYSPROP_HOTWORD_DETECTION_SERVICE_REQUIRED = false;
    private final ConcurrentHashMap<Integer, PackageTagsList> mActivityRecognitionTags;
    private final Context mContext;
    private final boolean mIsHotwordDetectionServiceRequired;
    private final ConcurrentHashMap<Integer, PackageTagsList> mLocationTags;
    private final Object mLock;
    private final SparseArray<PackageTagsList> mPerUidLocationTags;
    private final RoleManager mRoleManager;
    private final IBinder mToken;
    private final VoiceInteractionManagerInternal mVoiceInteractionManagerInternal;

    public static /* synthetic */ void $r8$lambda$gxkrPEeLHT1_QPplunPoH4a1dCY(AppOpsPolicy r0, String r1, UserHandle r2) {
        r0.lambda$new$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$laOMxe-XDRkQA64xS88xc0B7in4, reason: not valid java name */
    public static /* synthetic */ void m7122$r8$lambda$laOMxeXDRkQA64xS88xc0B7in4(AppOpsPolicy r0, int r1, PackageTagsList r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRoleManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ RoleManager m7123$$Nest$fgetmRoleManager(AppOpsPolicy r0) {
        return r0.mRoleManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActivityRecognizerTags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7124$$Nest$mupdateActivityRecognizerTags(AppOpsPolicy r0, String r1) {
        r0.updateActivityRecognizerTags(r1);
    }

    static {
        LOG_TAG = AppOpsPolicy.class.getName();
        SYSPROP_HOTWORD_DETECTION_SERVICE_REQUIRED = SystemProperties.getBoolean("ro.hotword.detection_service_required", false);
    }

    public AppOpsPolicy(Context context) {
        this.mLock = new Object();
        this.mToken = new Binder();
        this.mLocationTags = new ConcurrentHashMap();
        this.mPerUidLocationTags = new SparseArray();
        this.mActivityRecognitionTags = new ConcurrentHashMap();
        this.mContext = context;
        this.mRoleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        this.mVoiceInteractionManagerInternal = (VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class);
        this.mIsHotwordDetectionServiceRequired = isHotwordDetectionServiceRequired(this.mContext.getPackageManager());
        LocationManagerInternal locationManagerInternal = (LocationManagerInternal) LocalServices.getService(LocationManagerInternal.class);
        if (locationManagerInternal == null) goto L5;
        locationManagerInternal.setLocationPackageTagsListener(new AppOpsPolicy$$ExternalSyntheticLambda0(this));
    L5:
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        context.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.SYSTEM, intentFilter, null, null);
        this.mRoleManager.addOnRoleHoldersChangedListenerAsUser(context.getMainExecutor(), new AppOpsPolicy$$ExternalSyntheticLambda1(this), UserHandle.SYSTEM);
        initializeActivityRecognizersTags();
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.telephony") == false) goto L8;
        return;
    L8:
        if (pm.hasSystemFeature("android.hardware.microphone") == false) goto L10;
        return;
    L10:
        if (pm.hasSystemFeature("android.software.telecom") == true) goto L15;
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOps.setUserRestrictionForUser(100, true, this.mToken, null, -1);
        appOps.setUserRestrictionForUser(101, true, this.mToken, null, -1);
        return;
    }

    private /* synthetic */ void lambda$new$0(int uid, PackageTagsList packageTagsList) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (packageTagsList.isEmpty() == false) goto L9;
        this.mPerUidLocationTags.remove(uid);     // Catch: Throwable -> L7
    L10:
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L7
        PackageTagsList.Builder appIdTags = new PackageTagsList.Builder(1);     // Catch: Throwable -> L7
        int size = this.mPerUidLocationTags.size();     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= size) goto L16;
        if (UserHandle.getAppId(this.mPerUidLocationTags.keyAt(i)) != appId) goto L15;
        appIdTags.add(this.mPerUidLocationTags.valueAt(i));     // Catch: Throwable -> L7
    L15:
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L16:
        updateAllowListedTagsForPackageLocked(appId, appIdTags.build(), this.mLocationTags);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mPerUidLocationTags.set(uid, packageTagsList);     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ void lambda$new$1(String roleName, UserHandle user) {
        if ("android.app.role.SYSTEM_ACTIVITY_RECOGNIZER".equals(roleName) == false) goto L6;
        initializeActivityRecognizersTags();
        return;
    }

    public static int getVoiceActivationOp() {
        return 102;
    }

    public static boolean isHotwordDetectionServiceRequired(PackageManager pm) {
        if (pm.hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
        return false;
    L5:
        if (pm.hasSystemFeature("android.software.leanback") == false) goto L8;
        return false;
    L8:
        return SYSPROP_HOTWORD_DETECTION_SERVICE_REQUIRED;
    }

    public int checkOperation(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw, HexFunction<Integer, Integer, String, String, Integer, Boolean, Integer> superImpl) {
        return ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(resolveUid(code, uid)), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(raw))).intValue();
    }

    public int checkAudioOperation(int code, int usage, int uid, String packageName, QuadFunction<Integer, Integer, Integer, String, Integer> superImpl) {
        return ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(usage), Integer.valueOf(uid), packageName)).intValue();
    }

    public SyncNotedAppOp noteOperation(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount, NonaFunction<Integer, Integer, String, String, Integer, Boolean, String, Boolean, Integer, SyncNotedAppOp> superImpl) {
        return (SyncNotedAppOp) superImpl.apply(Integer.valueOf(resolveDatasourceOp(code, uid, packageName, attributionTag)), Integer.valueOf(resolveUid(code, uid)), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(notedCount));
    }

    public SyncNotedAppOp noteProxyOperation(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, HexFunction<Integer, AttributionSource, Boolean, String, Boolean, Boolean, SyncNotedAppOp> superImpl) {
        return (SyncNotedAppOp) superImpl.apply(Integer.valueOf(resolveDatasourceOp(code, attributionSource.getUid(), attributionSource.getPackageName(), attributionSource.getAttributionTag())), attributionSource, Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skipProxyOperation));
    }

    public SyncNotedAppOp startOperation(IBinder token, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId, DodecFunction<IBinder, Integer, Integer, String, String, Integer, Boolean, Boolean, String, Boolean, Integer, Integer, SyncNotedAppOp> superImpl) {
        return (SyncNotedAppOp) superImpl.apply(token, Integer.valueOf(resolveDatasourceOp(code, uid, packageName, attributionTag)), Integer.valueOf(resolveUid(code, uid)), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(attributionFlags), Integer.valueOf(attributionChainId));
    }

    public SyncNotedAppOp startProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId, UndecFunction<IBinder, Integer, AttributionSource, Boolean, Boolean, String, Boolean, Boolean, Integer, Integer, Integer, SyncNotedAppOp> superImpl) {
        return (SyncNotedAppOp) superImpl.apply(clientId, Integer.valueOf(resolveDatasourceOp(code, attributionSource.getUid(), attributionSource.getPackageName(), attributionSource.getAttributionTag())), attributionSource, Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skipProxyOperation), Integer.valueOf(proxyAttributionFlags), Integer.valueOf(proxiedAttributionFlags), Integer.valueOf(attributionChainId));
    }

    public void finishOperation(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, HexConsumer<IBinder, Integer, Integer, String, String, Integer> superImpl) {
        superImpl.accept(clientId, Integer.valueOf(resolveDatasourceOp(code, uid, packageName, attributionTag)), Integer.valueOf(resolveUid(code, uid)), packageName, attributionTag, Integer.valueOf(virtualDeviceId));
    }

    public void finishProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation, QuadFunction<IBinder, Integer, AttributionSource, Boolean, Void> superImpl) {
        superImpl.apply(clientId, Integer.valueOf(resolveDatasourceOp(code, attributionSource.getUid(), attributionSource.getPackageName(), attributionSource.getAttributionTag())), attributionSource, Boolean.valueOf(skipProxyOperation));
    }

    public void dumpTags(PrintWriter writer) {
        if (this.mLocationTags.isEmpty() == true) goto L6;
        writer.println("  AppOps policy location tags:");
        writeTags(this.mLocationTags, writer);
        writer.println();
    L6:
        if (this.mActivityRecognitionTags.isEmpty() == true) goto L9;
        writer.println("  AppOps policy activity recognition tags:");
        writeTags(this.mActivityRecognitionTags, writer);
        writer.println();
        return;
    }

    private void writeTags(Map<Integer, PackageTagsList> tags, PrintWriter writer) {
        int counter = 0;
        Iterator<Map.Entry<Integer, PackageTagsList>> r1 = tags.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Integer, PackageTagsList> tagEntry = r1.next();
        writer.print("    #");
        int counter2 = counter + 1;
        writer.print(counter);
        writer.print(": ");
        writer.print(tagEntry.getKey().toString());
        writer.print("=");
        tagEntry.getValue().dump(writer);
        counter = counter2;
        goto L4
    }

    private int resolveDatasourceOp(int code, int uid, String packageName, String attributionTag) {
        int code2 = resolveSandboxedServiceOp(resolveRecordAudioOp(code, uid), uid);
        if (attributionTag != null) goto L5;
        return code2;
    L5:
        int resolvedCode = resolveLocationOp(code2);
        if (resolvedCode != code2) goto L8;
        int resolvedCode2 = resolveArOp(code2);
        if (resolvedCode2 != code2) goto L13;
    L15:
        return code2;
    L13:
        if (isDatasourceAttributionTag(uid, packageName, attributionTag, this.mActivityRecognitionTags) == false) goto L15;
        return resolvedCode2;
    L8:
        if (isDatasourceAttributionTag(uid, packageName, attributionTag, this.mLocationTags) == false) goto L15;
        return resolvedCode;
    }

    private void initializeActivityRecognizersTags() {
        List<String> activityRecognizers = this.mRoleManager.getRoleHolders("android.app.role.SYSTEM_ACTIVITY_RECOGNIZER");
        int recognizerCount = activityRecognizers.size();
        if (recognizerCount <= 0) goto L8;
        int i = 0;
    L5:
        if (i >= recognizerCount) goto L11;
        String activityRecognizer = activityRecognizers.get(i);
        updateActivityRecognizerTags(activityRecognizer);
        i = i + 1;
        goto L5
    L11:
        return;
    L8:
        clearActivityRecognitionTags();
    }

    private void clearActivityRecognitionTags() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActivityRecognitionTags.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateActivityRecognizerTags(String activityRecognizer) {
        Intent intent = new Intent("android.intent.action.ACTIVITY_RECOGNIZER");
        intent.setPackage(activityRecognizer);
        ResolveInfo resolvedService = this.mContext.getPackageManager().resolveServiceAsUser(intent, 819332, 0);
        if (resolvedService != null) goto L5;
    L21:
        Log.w(LOG_TAG, "Service recognizer doesn't handle android.intent.action.ACTIVITY_RECOGNIZER, ignoring!");
        return;
    L5:
        if (resolvedService.serviceInfo == null) goto L21;
        Bundle metaData = resolvedService.serviceInfo.metaData;
        if (metaData != null) goto L10;
        return;
    L10:
        String tagsList = metaData.getString(ACTIVITY_RECOGNITION_TAGS);
        if (TextUtils.isEmpty(tagsList) == true) goto L20;
        PackageTagsList packageTagsList = new PackageTagsList.Builder(1).add(resolvedService.serviceInfo.packageName, Arrays.asList(tagsList.split(ACTIVITY_RECOGNITION_TAGS_SEPARATOR))).build();
        Object r6 = this.mLock;
        monitor-enter(r6);
        updateAllowListedTagsForPackageLocked(UserHandle.getAppId(resolvedService.serviceInfo.applicationInfo.uid), packageTagsList, this.mActivityRecognitionTags);     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static void updateAllowListedTagsForPackageLocked(int appId, PackageTagsList packageTagsList, ConcurrentHashMap<Integer, PackageTagsList> datastore) {
        datastore.put(Integer.valueOf(appId), packageTagsList);
    }

    private static boolean isDatasourceAttributionTag(int uid, String packageName, String attributionTag, Map<Integer, PackageTagsList> mappedOps) {
        PackageTagsList appIdTags = mappedOps.get(Integer.valueOf(UserHandle.getAppId(uid)));
        if (appIdTags != null) goto L5;
    L7:
        return false;
    L5:
        if (appIdTags.contains(packageName, attributionTag) == false) goto L7;
        return true;
    }

    private static int resolveLocationOp(int code) {
        switch(code) {
            case 0: goto L6;
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        return code;
    L4:
        return 108;
    L6:
        return 109;
    }

    private static int resolveArOp(int code) {
        if (code != 79) goto L6;
        return 113;
    L6:
        return code;
    }

    private int resolveRecordAudioOp(int code, int uid) {
        if (code == 102) goto L5;
        return code;
    L5:
        if (this.mIsHotwordDetectionServiceRequired == true) goto L7;
        return code;
    L7:
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = this.mVoiceInteractionManagerInternal.getHotwordDetectionServiceIdentity();
        if (hotwordDetectionServiceIdentity != null) goto L10;
        return 27;
    L10:
        if (uid != hotwordDetectionServiceIdentity.getIsolatedUid()) goto L15;
        return code;
    L15:
        return 27;
    }

    private int resolveSandboxedServiceOp(int code, int uid) {
        if (Process.isIsolated(uid) == true) goto L5;
    L20:
        return code;
    L5:
        if (code != 27) goto L7;
    L9:
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = this.mVoiceInteractionManagerInternal.getHotwordDetectionServiceIdentity();
        if (hotwordDetectionServiceIdentity != null) goto L12;
    L19:
        return code;
    L12:
        if (uid != hotwordDetectionServiceIdentity.getIsolatedUid()) goto L19;
        switch(code) {
            case 26: goto L17;
            case 27: goto L15;
            default: goto L19;
        };
    L15:
        return 135;
    L17:
        return 134;
    L7:
        if (code == 26) goto L9;
        goto L9
    }

    private int resolveUid(int code, int uid) {
        if (Process.isIsolated(uid) == true) goto L5;
        return uid;
    L5:
        if (code != 27) goto L7;
    L10:
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = this.mVoiceInteractionManagerInternal.getHotwordDetectionServiceIdentity();
        if (hotwordDetectionServiceIdentity != null) goto L13;
        return uid;
    L13:
        if (uid == hotwordDetectionServiceIdentity.getIsolatedUid()) goto L15;
        return uid;
    L15:
        return hotwordDetectionServiceIdentity.getOwnerUid();
    L7:
        if (code == 102) goto L10;
        if (code == 26) goto L10;
        return uid;
    }
}
