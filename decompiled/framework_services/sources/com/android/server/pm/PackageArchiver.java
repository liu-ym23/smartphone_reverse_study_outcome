package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedActivityInfo;
import android.content.pm.ArchivedActivityParcel;
import android.content.pm.ArchivedPackageInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.pm.VersionedPackage;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.IBinder;
import android.os.ParcelableException;
import android.os.RemoteException;
import android.os.SELinux;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ExceptionUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserState;
import com.android.server.pm.pkg.PackageUserStateInternal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes2.dex */
public class PackageArchiver {
    private static final String ACTION_UNARCHIVE_DIALOG = "com.android.intent.action.UNARCHIVE_DIALOG";
    private static final String ACTION_UNARCHIVE_ERROR_DIALOG = "com.android.intent.action.UNARCHIVE_ERROR_DIALOG";
    private static final String ARCHIVE_ICONS_DIR = "package_archiver";
    private static final boolean DEBUG = true;
    private static final int DEFAULT_UNARCHIVE_FOREGROUND_TIMEOUT_MS = 120000;
    private static final String EXTRA_INSTALLER_PACKAGE_NAME = "com.android.content.pm.extra.UNARCHIVE_INSTALLER_PACKAGE_NAME";
    private static final String EXTRA_INSTALLER_TITLE = "com.android.content.pm.extra.UNARCHIVE_INSTALLER_TITLE";
    private static final String EXTRA_REQUIRED_BYTES = "com.android.content.pm.extra.UNARCHIVE_EXTRA_REQUIRED_BYTES";
    public static final String EXTRA_UNARCHIVE_INTENT_SENDER = "android.content.pm.extra.UNARCHIVE_INTENT_SENDER";
    private static final PorterDuffColorFilter OPACITY_LAYER_FILTER = null;
    private static final String TAG = "PackageArchiverService";
    private AppOpsManager mAppOpsManager;
    private final AppStateHelper mAppStateHelper;
    private final Context mContext;
    private LauncherApps mLauncherApps;
    private final Map<Pair<Integer, String>, IntentSender> mLauncherIntentSenders;
    private final PackageManagerService mPm;
    private UserManager mUserManager;

    private static class FixedSizeBitmapDrawable extends BitmapDrawable {
        FixedSizeBitmapDrawable(Bitmap bitmap) {
            super(null, bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return getBitmap().getWidth();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return getBitmap().getWidth();
        }
    }

    private class UnarchiveIntentSender extends IIntentSender.Stub {
        final /* synthetic */ PackageArchiver this$0;

        /* synthetic */ UnarchiveIntentSender(PackageArchiver r1, PackageArchiverIA r2) {
            this(r1);
        }

        private UnarchiveIntentSender(PackageArchiver r1) {
            this.this$0 = r1;
        }

        public void send(int code, Intent intent, String resolvedType, IBinder whitelistToken, IIntentReceiver finishedReceiver, String requiredPermission, Bundle options) throws RemoteException {
            int status = intent.getExtras().getInt("android.content.pm.extra.UNARCHIVE_STATUS", -1);
            if (status != 0) goto L5;
            return;
        L5:
            Intent extraIntent = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT", Intent.class);
            UserHandle user = (UserHandle) intent.getParcelableExtra("android.intent.extra.USER", UserHandle.class);
            if (extraIntent == null) goto L12;
            if (user != null) goto L9;
            return;
        L9:
            if (PackageArchiver.m6719$$Nest$fgetmAppStateHelper(this.this$0).isAppTopVisible(PackageArchiver.m6721$$Nest$mgetCurrentLauncherPackageName(this.this$0, user.getIdentifier())) == false) goto L14;
            extraIntent.setFlags(268435456);
            PackageArchiver.m6720$$Nest$fgetmContext(this.this$0).startActivityAsUser(extraIntent, user);
            return;
        L14:
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$0gd8Ah2iIVI3h6Png4EppIlTZZs(PackageArchiver r0, String r1, UserHandle r2, String r3, int r4) {
        r0.lambda$requestUnarchive$7(r1, r2, r3, r4);
    }

    public static /* synthetic */ List $r8$lambda$1oYflwPwHhqY2bUNyOzbuiKphG4(PackageArchiver r0, String r1, int r2) {
        return r0.lambda$getLauncherActivityInfos$10(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$3EBsOLpXGHRhzT57YWxNN-wXFYI, reason: not valid java name */
    public static /* synthetic */ ParceledListSlice m6716$r8$lambda$3EBsOLpXGHRhzT57YWxNNwXFYI(PackageArchiver r0, Intent r1, int r2) {
        return r0.lambda$verifySupportsUnarchival$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$8jaZ4z71lnZ42I-QFfGiHMyUOcc, reason: not valid java name */
    public static /* synthetic */ void m6717$r8$lambda$8jaZ4z71lnZ42IQFfGiHMyUOcc(PackageArchiver r0, IntentSender r1, String r2, Intent r3) {
        r0.lambda$requestUnarchiveConfirmation$8(r1, r2, r3);
    }

    public static /* synthetic */ Boolean $r8$lambda$BDHK3QGfnRL2IfqgYuBxdby_waE(PackageArchiver r0, int r1, String r2) {
        return r0.lambda$isAppOptedOutOfArchiving$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$IRziqMMKXRGs6Wvg4xbDipmfMIY(PackageArchiver r0, ApplicationInfo r1, String r2, int r3, String r4, List r5, CompletableFuture r6) {
        r0.lambda$createAndStoreArchiveState$3(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Integer $r8$lambda$JRYpYKkDtSAC6PjGIMBe2YrbluI(PackageArchiver r0, String r1, String r2, String r3, IntentSender r4, int r5) {
        return r0.lambda$requestUnarchive$6(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$MW5IulJusOuH5ua9LPbDolVhJpI(PackageArchiver r0, int r1) {
        r0.lambda$createDraftSession$9(r1);
    }

    public static /* synthetic */ Void $r8$lambda$UNSE9vbDrfErSJXbViY_4TSX_u4(PackageArchiver r0, String r1, IntentSender r2, Throwable r3) {
        return r0.lambda$requestArchive$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$iKI8DsLnVekLjZkXI25s-efrO7U, reason: not valid java name */
    public static /* synthetic */ void m6718$r8$lambda$iKI8DsLnVekLjZkXI25sefrO7U(PackageArchiver r0, String r1, PackageInstaller.SessionInfo r2) {
        r0.lambda$requestUnarchiveOnActivityStart$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kYGgq6m69BMNar5oOISFeqK8gFo(PackageArchiver r0, String r1, String r2, int r3, IntentSender r4, int r5, int r6, int r7, Void r8) {
        r0.lambda$requestArchive$0(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppStateHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppStateHelper m6719$$Nest$fgetmAppStateHelper(PackageArchiver r0) {
        return r0.mAppStateHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6720$$Nest$fgetmContext(PackageArchiver r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentLauncherPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6721$$Nest$mgetCurrentLauncherPackageName(PackageArchiver r0, int r1) {
        return r0.getCurrentLauncherPackageName(r1);
    }

    static {
        OPACITY_LAYER_FILTER = new PorterDuffColorFilter(Color.argb(0.5f, 0.0f, 0.0f, 0.0f), PorterDuff.Mode.SRC_ATOP);
    }

    PackageArchiver(Context context, PackageManagerService mPm) {
        this.mContext = context;
        this.mPm = mPm;
        this.mAppStateHelper = new AppStateHelper(this.mContext);
        this.mLauncherIntentSenders = new HashMap();
    }

    public static boolean isArchived(PackageUserState userState) {
        if (userState.getArchiveState() != null) goto L5;
    L7:
        return false;
    L5:
        if (userState.isInstalled() == true) goto L7;
        return true;
    }

    public static boolean isArchivingEnabled() {
        return true;
    }

    void requestArchive(String packageName, String callerPackageName, IntentSender intentSender, UserHandle userHandle) {
        requestArchive(packageName, callerPackageName, 0, intentSender, userHandle);
    }

    void requestArchive(final String packageName, String callerPackageName, int flags, final IntentSender intentSender, UserHandle userHandle) {
        packageName.getClass();
        callerPackageName.getClass();
        intentSender.getClass();
        userHandle.getClass();
        Slog.i(TAG, TextUtils.formatSimple("Requested archival of package %s for user %s.", new Object[]{packageName, Integer.valueOf(userHandle.getIdentifier())}));
        Computer snapshot = this.mPm.snapshotComputer();
        final int binderUserId = userHandle.getIdentifier();
        final int binderUid = Binder.getCallingUid();
        final int binderPid = Binder.getCallingPid();
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(binderUid) == true) goto L5;
        String r12 = callerPackageName;
        verifyCaller(snapshot.getPackageUid(r12, 0, binderUserId), binderUid);
    L6:
        int r13 = 0;
        if ((flags & 2) == 0) goto L9;
        boolean r0 = true;
    L10:
        boolean deleteAllUsers = r0;
        if (deleteAllUsers == false) goto L13;
        int[] r1 = this.mPm.mInjector.getUserManagerInternal().getUserIds();
    L14:
        int[] users = r1;
        int r2 = users.length;
        int userId = 0;
    L15:
        if (userId >= r2) goto L17;
        int r7 = userId;
        int userId2 = users[r7];
        snapshot.enforceCrossUserPermission(binderUid, userId2, true, true, "archiveApp");
        userId = r7 + 1;
        goto L15
    L17:
        verifyUninstallPermissions();
        CompletableFuture<Void>[] archiveStateStored = new CompletableFuture[users.length];
        int i = 0;
        int size = users.length;     // Catch: PackageManager.NameNotFoundException -> L29
    L19:
        if (i >= size) goto L25;
        archiveStateStored[i] = createAndStoreArchiveState(packageName, users[i]);     // Catch: PackageManager.NameNotFoundException -> L22
        i = i + 1;
    L22:
        e = e;
    L31:
        Slog.e(TAG, TextUtils.formatSimple("Failed to archive %s with message %s", new Object[]{packageName, e.getMessage()}));
        throw new ParcelableException(e);
    L25:
        if (deleteAllUsers == false) goto L27;
        r13 = 2;
    L27:
        final int deleteFlags = r13 | 17;
        final String r3 = r12;
        CompletableFuture.allOf(archiveStateStored).thenAccept(new PackageArchiver$$ExternalSyntheticLambda7(this, packageName, r3, deleteFlags, intentSender, binderUserId, binderUid, binderPid)).exceptionally(new PackageArchiver$$ExternalSyntheticLambda8(this, packageName, intentSender));
        return;
    L29:
        e = e;
        goto L31
    L13:
        r1 = new int[]{binderUserId};
        goto L14
    L9:
        r0 = false;
        goto L10
    L5:
        r12 = callerPackageName;
        goto L6
    }

    private /* synthetic */ void lambda$requestArchive$0(String packageName, String callerPackageName, int deleteFlags, IntentSender intentSender, int binderUserId, int binderUid, int binderPid, Void ignored) {
        this.mPm.mInstallerService.uninstall(new VersionedPackage(packageName, -1), callerPackageName, deleteFlags, intentSender, binderUserId, binderUid, binderPid);
    }

    private /* synthetic */ Void lambda$requestArchive$1(String packageName, IntentSender intentSender, Throwable e) {
        Slog.e(TAG, TextUtils.formatSimple("Failed to archive %s with message %s", new Object[]{packageName, e.getMessage()}));
        sendFailureStatus(intentSender, packageName, e.getMessage());
        return null;
    }

    public int requestUnarchiveOnActivityStart(Intent intent, String callerPackageName, int userId, int callingUid) {
        final String packageName = getPackageNameFromIntent(intent);
        if (packageName != null) goto L6;
        Slog.e(TAG, "packageName cannot be null for unarchival!");
        return -92;
    L6:
        if (callerPackageName != null) goto L10;
        Slog.e(TAG, "callerPackageName cannot be null for unarchival!");
        return -92;
    L10:
        if (isCallerQualifiedForUnarchival(callerPackageName, callingUid, userId) == true) goto L41;
        Slog.e(TAG, TextUtils.formatSimple("callerPackageName: %s does not qualify for unarchival of package: %s!", new Object[]{callerPackageName, packageName}));
        return -94;
    L41:
    L35:
        t = th;
    L37:
        Slog.e(TAG, TextUtils.formatSimple("Unexpected error occurred while unarchiving package %s: %s.", new Object[]{packageName, t.getLocalizedMessage()}));
    L38:
        return 102;
    L16:
        if (getAppOpsManager().checkOp(146, callingUid, callerPackageName) != 0) goto L18;
        boolean openAppDetailsIfOngoingUnarchival = true;
    L19:
        if (openAppDetailsIfOngoingUnarchival == true) goto L43;
    L26:
        Slog.i(TAG, TextUtils.formatSimple("Unarchival is starting for: %s", new Object[]{packageName}));     // Catch: Throwable -> L35
        IntentSender r4 = getOrCreateLauncherListener(userId, packageName);     // Catch: Throwable -> L35
        boolean r6 = true;
        UserHandle r5 = UserHandle.of(userId);     // Catch: Throwable -> L35
        if (getAppOpsManager().checkOp(146, callingUid, callerPackageName) == 0) goto L39;
        r6 = false;
    L39:
        requestUnarchive(packageName, callerPackageName, r4, r5, r6);     // Catch: Throwable -> L33
    L33:
        t = th;
        goto L37
    L43:
        final PackageInstaller.SessionInfo activeUnarchivalSession = getActiveUnarchivalSession(packageName, userId);     // Catch: Throwable -> L24
        if (activeUnarchivalSession == null) goto L26;
        this.mPm.mHandler.post(new PackageArchiver$$ExternalSyntheticLambda9(this, packageName, activeUnarchivalSession));     // Catch: Throwable -> L24
        return 102;
    L24:
        t = th;
        goto L37
    L18:
        openAppDetailsIfOngoingUnarchival = false;
        goto L19
    }

    private /* synthetic */ void lambda$requestUnarchiveOnActivityStart$2(String packageName, PackageInstaller.SessionInfo activeUnarchivalSession) {
        Slog.i(TAG, "Opening app details page for ongoing unarchival of: " + packageName);
        getLauncherApps().startPackageInstallerSessionDetailsActivity(activeUnarchivalSession, null, null);
    }

    private boolean isCallerQualifiedForUnarchival(String callerPackageName, int callingUid, int userId) {
        if (callingUid != 2000) goto L5;
        return true;
    L5:
        String currentLauncherPackageName = getCurrentLauncherPackageName(getParentUserId(userId));
        if (currentLauncherPackageName != null) goto L8;
    L10:
        Slog.w(TAG, TextUtils.formatSimple("Requester of unarchival: %s is not the default launcher package: %s.", new Object[]{callerPackageName, currentLauncherPackageName}));
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal ps = snapshot.getPackageStateInternal(callerPackageName);
        if (ps != null) goto L13;
    L15:
        boolean isSystem = false;
    L16:
        if (isSystem == false) goto L21;
        if (isLauncherApp(snapshot, callerPackageName, userId) == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (ps.isSystem() == false) goto L15;
        isSystem = true;
        goto L16
    L8:
        if (TextUtils.equals(callerPackageName, currentLauncherPackageName) == false) goto L10;
        return true;
    }

    private boolean isLauncherApp(Computer snapshot, String packageName, int userId) {
        Intent intent = snapshot.getHomeIntent();
        intent.setPackage(packageName);
        List<ResolveInfo> launcherActivities = snapshot.queryIntentActivitiesInternal(intent, null, 0, userId);
        return !launcherActivities.isEmpty();
    }

    private int getParentUserId(int userId) {
        UserInfo profileParent = getUserManager().getProfileParent(userId);
        if (profileParent != null) goto L6;
        return userId;
    L6:
        return profileParent.id;
    }

    public boolean isIntentResolvedToArchivedApp(Intent intent, int userId) {
        String packageName = getPackageNameFromIntent(intent);
        if (packageName != null) goto L5;
    L23:
        return false;
    L5:
        if (intent.getComponent() == null) goto L23;
        PackageState packageState = this.mPm.snapshotComputer().getPackageStateInternal(packageName);
        if (packageState != null) goto L10;
        return false;
    L10:
        PackageUserState userState = packageState.getUserStateOrDefault(userId);
        if (isArchived(userState) == true) goto L13;
        return false;
    L13:
        List<ArchiveState.ArchiveActivityInfo> archiveActivityInfoList = userState.getArchiveState().getActivityInfos();
        int i = 0;
    L15:
        if (i >= archiveActivityInfoList.size()) goto L21;
        if (archiveActivityInfoList.get(i).getOriginalComponentName().equals(intent.getComponent()) == true) goto L18;
        i = i + 1;
        goto L15
    L18:
        return true;
    L21:
        Slog.e(TAG, TextUtils.formatSimple("Package: %s is archived but component to start main activity cannot be found!", new Object[]{packageName}));
        return false;
    }

    void clearArchiveState(String packageName, int userId) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        clearArchiveState(ps, userId);
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    void clearArchiveState(PackageSetting ps, int userId) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        if (ps == null) goto L21;
    L19:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L6:
        if (ps.getUserStateOrDefault(userId).getArchiveState() == null) goto L21;
        Slog.e(TAG, "Clearing archive states for " + ps.getPackageName());     // Catch: Throwable -> L19
        ps.setArchiveState(null, userId);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        File iconsDir = getIconsDir(ps.getPackageName(), userId);
        if (iconsDir.exists() == true) goto L15;
        Slog.e(TAG, "Icons are already deleted at " + iconsDir.getAbsolutePath());
        return;
    L15:
        if (FileUtils.deleteContentsAndDir(iconsDir) == true) goto L17;
        Slog.e(TAG, "Failed to clean up archive files for " + ps.getPackageName());
        return;
    L17:
        Slog.e(TAG, "Deleted icons at " + iconsDir.getAbsolutePath());
        return;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    }

    private String getCurrentLauncherPackageName(int userId) {
        ComponentName defaultLauncherComponent = this.mPm.snapshotComputer().getDefaultHomeActivity(userId);
        if (defaultLauncherComponent != null) goto L5;
        return null;
    L5:
        return defaultLauncherComponent.getPackageName();
    }

    private boolean isCallingPackageValid(String callingPackage, int callingUid, int userId) {
        int packageUid = this.mPm.snapshotComputer().getPackageUid(callingPackage, 0, userId);
        if (packageUid == callingUid) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Calling package: %s does not belong to uid: %d", new Object[]{callingPackage, Integer.valueOf(callingUid)}));
        return false;
    L6:
        return true;
    }

    private IntentSender getOrCreateLauncherListener(int userId, String packageName) {
        Pair<Integer, String> key = Pair.create(Integer.valueOf(userId), packageName);
        Map<Pair<Integer, String>, IntentSender> r1 = this.mLauncherIntentSenders;
        monitor-enter(r1);
        IntentSender intentSender = this.mLauncherIntentSenders.get(key);     // Catch: Throwable -> L8
        if (intentSender == null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return intentSender;
    L10:
        IntentSender unarchiveIntentSender = new IntentSender(new UnarchiveIntentSender(this, null));     // Catch: Throwable -> L8
        this.mLauncherIntentSenders.put(key, unarchiveIntentSender);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return unarchiveIntentSender;
    L8:
        th = move-exception;
        throw th;
    }

    private CompletableFuture<Void> createAndStoreArchiveState(final String packageName, final int userId) throws PackageManager.NameNotFoundException {
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal ps = getPackageState(packageName, snapshot, Binder.getCallingUid(), userId);
        verifyNotSystemApp(ps.getFlags());
        verifyInstalled(ps, userId);
        final String responsibleInstallerPackage = getResponsibleInstallerPackage(ps);
        final ApplicationInfo installerInfo = verifyInstaller(snapshot, responsibleInstallerPackage, userId);
        verifyOptOutStatus(packageName, UserHandle.getUid(userId, UserHandle.getUid(userId, ps.getAppId())));
        final List<LauncherActivityInfo> mainActivities = getLauncherActivityInfos(ps.getPackageName(), userId);
        final CompletableFuture<Void> archiveStateStored = new CompletableFuture();
        this.mPm.mHandler.post(new PackageArchiver$$ExternalSyntheticLambda2(this, installerInfo, responsibleInstallerPackage, userId, packageName, mainActivities, archiveStateStored));
        return archiveStateStored;
    }

    private /* synthetic */ void lambda$createAndStoreArchiveState$3(ApplicationInfo installerInfo, String responsibleInstallerPackage, int userId, String packageName, List mainActivities, CompletableFuture archiveStateStored) {
        String installerTitle = getResponsibleInstallerTitle(this.mContext, installerInfo, responsibleInstallerPackage, userId);     // Catch: Throwable -> L4
        ArchiveState archiveState = createArchiveStateInternal(packageName, userId, mainActivities, installerTitle);     // Catch: Throwable -> L4
        storeArchiveState(packageName, archiveState, userId);     // Catch: Throwable -> L4
        archiveStateStored.complete(null);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        archiveStateStored.completeExceptionally(e);
    }

    ArchiveState createArchiveState(ArchivedPackageParcel archivedPackage, int userId, String installerPackage, String responsibleInstallerTitle) {
        int r2 = userId;
        ApplicationInfo installerInfo = this.mPm.snapshotComputer().getApplicationInfo(installerPackage, 0, r2);
        ArchiveState r6 = null;
        if (installerInfo != null) goto L6;
        Slog.e(TAG, "Couldn't find installer " + installerPackage);
        return null;
    L6:
        if (responsibleInstallerTitle != null) goto L9;
        Slog.e(TAG, "Couldn't get the title of the installer");
        return null;
    L9:
        int iconSize = ((ActivityManager) this.mContext.getSystemService(ActivityManager.class)).getLauncherLargeIconSize();
        ArchivedPackageInfo info = new ArchivedPackageInfo(archivedPackage);
        String packageName = info.getPackageName();     // Catch: IOException -> L17
        List<ArchivedActivityInfo> mainActivities = info.getLauncherActivities();     // Catch: IOException -> L17
        List<ArchiveState.ArchiveActivityInfo> archiveActivityInfos = new ArrayList(mainActivities.size());     // Catch: IOException -> L17
        int i = 0;
        int size = mainActivities.size();     // Catch: IOException -> L17
    L11:
        if (i >= size) goto L19;
        ArchivedActivityInfo mainActivity = mainActivities.get(i);     // Catch: IOException -> L17
        ArchiveState r16 = r6;
        Path iconPath = storeAdaptiveDrawable(packageName, mainActivity.getIcon(), r2, (i * 2) + 0, iconSize);     // Catch: IOException -> L15
        Path monochromePath = storeAdaptiveDrawable(packageName, mainActivity.getMonochromeIcon(), r2, (i * 2) + 1, iconSize);     // Catch: IOException -> L15
        String packageName2 = packageName;
        String packageName3 = mainActivity.getLabel().toString();     // Catch: IOException -> L15
        ArchiveState.ArchiveActivityInfo activityInfo = new ArchiveState.ArchiveActivityInfo(packageName3, mainActivity.getComponentName(), iconPath, monochromePath);     // Catch: IOException -> L15
        archiveActivityInfos.add(activityInfo);     // Catch: IOException -> L15
        i = i + 1;     // Catch: IOException -> L15
        r2 = userId;
        r6 = r16;
        packageName = packageName2;
    L15:
        e = e;
    L21:
        Slog.e(TAG, "Failed to create archive state", e);
        return r16;
    L19:
        r16 = r6;
        return new ArchiveState(archiveActivityInfos, responsibleInstallerTitle);
    L17:
        e = e;
        r16 = r6;
        goto L21
    }

    ArchiveState createArchiveStateInternal(String packageName, int userId, List<LauncherActivityInfo> mainActivities, String installerTitle) throws IOException {
        int iconSize = ((ActivityManager) this.mContext.getSystemService(ActivityManager.class)).getLauncherLargeIconSize();
        List<ArchiveState.ArchiveActivityInfo> archiveActivityInfos = new ArrayList(mainActivities.size());
        int size = mainActivities.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        LauncherActivityInfo mainActivity = mainActivities.get(i);
        String packageName2 = packageName;
        int userId2 = userId;
        Path iconPath = storeIcon(packageName2, mainActivity, userId2, (i * 2) + 0, iconSize);
        ArchiveState.ArchiveActivityInfo activityInfo = new ArchiveState.ArchiveActivityInfo(mainActivity.getLabel().toString(), mainActivity.getComponentName(), iconPath, null);
        archiveActivityInfos.add(activityInfo);
        i = i + 1;
        packageName = packageName2;
        userId = userId2;
        goto L3
    L6:
        return new ArchiveState(archiveActivityInfos, installerTitle);
    }

    Path storeIcon(String packageName, LauncherActivityInfo mainActivity, int userId, int index, int iconSize) throws IOException {
        int iconResourceId = mainActivity.getActivityInfo().getIconResource();
        if (iconResourceId != 0) goto L7;
        return null;
    L7:
        return storeDrawable(packageName, mainActivity.getIcon(0), userId, index, iconSize);
    }

    private static Path storeDrawable(String packageName, Drawable iconDrawable, int userId, int index, int iconSize) throws IOException {
        if (iconDrawable != null) goto L5;
        return null;
    L5:
        File iconsDir = createIconsDir(packageName, userId);
        File iconFile = new File(iconsDir, index + ".png");
        Bitmap icon = ArchivedActivityInfo.drawableToBitmap(iconDrawable, iconSize);
        FileOutputStream out = new FileOutputStream(iconFile);
    L14:
        th = move-exception;
        out.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L7:
        if (icon.compress(Bitmap.CompressFormat.PNG, 100, out) == false) goto L17;
        out.flush();     // Catch: Throwable -> L14
        out.close();
        if (iconFile.exists() == false) goto L13;
        Slog.i(TAG, "Stored icon at " + iconFile.getAbsolutePath());
    L13:
        return iconFile.toPath();
    L17:
        throw new IOException(TextUtils.formatSimple("Failure to store icon file %s", new Object[]{iconFile.getAbsolutePath()}));     // Catch: Throwable -> L14
    }

    private static Path storeAdaptiveDrawable(String packageName, Drawable iconDrawable, int userId, int index, int iconSize) throws IOException {
        if (iconDrawable != null) goto L6;
        return null;
    L6:
        if ((iconDrawable instanceof BitmapDrawable) == false) goto L8;
        Bitmap icon = ((BitmapDrawable) iconDrawable).getBitmap();
        Drawable iconDrawable2 = new FixedSizeBitmapDrawable(icon);
    L9:
        float inset = AdaptiveIconDrawable.getExtraInsetFraction();
        float inset2 = inset / ((2.0f * inset) + 1.0f);
        Drawable d = new AdaptiveIconDrawable(new ColorDrawable(AudioFormat.MAIN_MASK), new InsetDrawable(iconDrawable2, inset2, inset2, inset2, inset2));
        return storeDrawable(packageName, d, userId, index, iconSize);
    L8:
        iconDrawable2 = iconDrawable;
        goto L9
    }

    private ApplicationInfo verifyInstaller(Computer snapshot, String installerPackageName, int userId) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(installerPackageName) == true) goto L17;
        if (Binder.getCallingUid() != 2000) goto L7;
    L11:
        ApplicationInfo appInfo = snapshot.getApplicationInfo(installerPackageName, 0, userId);
        if (appInfo == null) goto L15;
        return appInfo;
    L15:
        throw new PackageManager.NameNotFoundException("Failed to obtain Installer info");
    L7:
        if (verifySupportsUnarchival(installerPackageName, userId) == true) goto L11;
        throw new PackageManager.NameNotFoundException("Installer does not support unarchival");
    L17:
        throw new PackageManager.NameNotFoundException("No installer found");
    }

    public boolean verifySupportsUnarchival(String installerPackage, final int userId) {
        if (TextUtils.isEmpty(installerPackage) == false) goto L5;
        return false;
    L5:
        final Intent intent = new Intent("android.intent.action.UNARCHIVE_PACKAGE").setPackage(installerPackage);
        ParceledListSlice<ResolveInfo> intentReceivers = (ParceledListSlice) Binder.withCleanCallingIdentity(new PackageArchiver$$ExternalSyntheticLambda1(this, intent, userId));
        if (intentReceivers != null) goto L8;
        return false;
    L8:
        if (intentReceivers.getList().isEmpty() == true) goto L12;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ ParceledListSlice lambda$verifySupportsUnarchival$4(Intent intent, int userId) throws Exception {
        return this.mPm.queryIntentReceivers(this.mPm.snapshotComputer(), intent, null, 0, userId);
    }

    private void verifyNotSystemApp(int flags) throws PackageManager.NameNotFoundException {
        if ((flags & 1) != 0) goto L8;
        if ((flags & 128) != 0) goto L8;
        return;
    L8:
        throw new PackageManager.NameNotFoundException("System apps cannot be archived.");
    }

    private void verifyInstalled(PackageStateInternal ps, int userId) throws PackageManager.NameNotFoundException {
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L6;
        return;
    L6:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("%s is not installed.", new Object[]{ps.getPackageName()}));
    }

    public boolean isAppArchivable(String packageName, UserHandle user) {
        packageName.getClass();
        user.getClass();
        Computer snapshot = this.mPm.snapshotComputer();
        int userId = user.getIdentifier();
        int binderUid = Binder.getCallingUid();
        snapshot.enforceCrossUserPermission(binderUid, userId, true, true, "isAppArchivable");
        PackageStateInternal ps = getPackageState(packageName, this.mPm.snapshotComputer(), Binder.getCallingUid(), userId);     // Catch: PackageManager.NameNotFoundException -> L17
        if ((ps.getFlags() & 1) == 0) goto L7;
    L16:
        return false;
    L7:
        if ((ps.getFlags() & 128) != 0) goto L16;
        if (isAppOptedOutOfArchiving(packageName, UserHandle.getUid(userId, ps.getAppId())) == false) goto L20;
        return false;
    L20:
        verifyInstaller(snapshot, getResponsibleInstallerPackage(ps), userId);     // Catch: PackageManager.NameNotFoundException -> L14
        getLauncherActivityInfos(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L14
        return true;
    L15:
        return false;
    L17:
        e = move-exception;
        throw new ParcelableException(e);
    }

    private boolean isAppOptedOutOfArchiving(final String packageName, final int uid) {
        return ((Boolean) Binder.withCleanCallingIdentity(new PackageArchiver$$ExternalSyntheticLambda0(this, uid, packageName))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isAppOptedOutOfArchiving$5(int uid, String packageName) throws Exception {
        boolean r1 = true;
        if (getAppOpsManager().checkOpNoThrow(97, uid, packageName) == 1) goto L7;
        r1 = false;
    L7:
        return Boolean.valueOf(r1);
    }

    private void verifyOptOutStatus(String packageName, int uid) throws PackageManager.NameNotFoundException {
        if (isAppOptedOutOfArchiving(packageName, uid) == true) goto L6;
        return;
    L6:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("The app %s is opted out of archiving.", new Object[]{packageName}));
    }

    void requestUnarchive(String packageName, String callerPackageName, IntentSender statusReceiver, UserHandle userHandle) {
        requestUnarchive(packageName, callerPackageName, statusReceiver, userHandle, false);
    }

    private void requestUnarchive(final String packageName, final String callerPackageName, final IntentSender statusReceiver, final UserHandle userHandle, boolean showUnarchivalConfirmation) {
        packageName.getClass();
        callerPackageName.getClass();
        statusReceiver.getClass();
        userHandle.getClass();
        Computer snapshot = this.mPm.snapshotComputer();
        final int userId = userHandle.getIdentifier();
        int binderUid = Binder.getCallingUid();
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(binderUid) == true) goto L5;
        verifyCaller(snapshot.getPackageUid(callerPackageName, 0, userId), binderUid);
    L5:
        snapshot.enforceCrossUserPermission(binderUid, userId, true, true, "unarchiveApp");
        PackageStateInternal ps = getPackageState(packageName, snapshot, binderUid, userId);     // Catch: PackageManager.NameNotFoundException -> L35
        PackageStateInternal callerPs = getPackageState(callerPackageName, snapshot, binderUid, userId);     // Catch: PackageManager.NameNotFoundException -> L35
        verifyArchived(ps, userId);     // Catch: PackageManager.NameNotFoundException -> L35
        final String installerPackage = getResponsibleInstallerPackage(ps);
        if (installerPackage == null) goto L34;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != 0) goto L12;
        boolean r0 = true;
    L13:
        boolean hasInstallPackages = r0;
        boolean hasRequestInstallPackages = callerPs.getAndroidPackage().getRequestedPermissions().contains("android.permission.REQUEST_INSTALL_PACKAGES");
        if (hasInstallPackages == true) goto L19;
        if (hasRequestInstallPackages == true) goto L19;
        throw new SecurityException("You need the com.android.permission.INSTALL_PACKAGES or com.android.permission.REQUEST_INSTALL_PACKAGES permission to request an unarchival.");
    L19:
        if (hasInstallPackages == false) goto L31;
        if (showUnarchivalConfirmation == true) goto L31;
        final int draftSessionId = ((Integer) Binder.withCleanCallingIdentity(new PackageArchiver$$ExternalSyntheticLambda4(this, packageName, installerPackage, callerPackageName, statusReceiver, userId))).intValue();     // Catch: RuntimeException -> L25
        this.mPm.mHandler.post(new PackageArchiver$$ExternalSyntheticLambda5(this, packageName, userHandle, installerPackage, draftSessionId));
        return;
    L25:
        e = move-exception;
        if ((e.getCause() instanceof IOException) == true) goto L29;
        throw e;
    L29:
        throw ExceptionUtils.wrap((IOException) e.getCause());
    L31:
        requestUnarchiveConfirmation(packageName, statusReceiver, userHandle);
        return;
    L12:
        r0 = false;
        goto L13
    L34:
        throw new ParcelableException(new PackageManager.NameNotFoundException(TextUtils.formatSimple("No installer found to unarchive app %s.", new Object[]{packageName})));
    L35:
        e = move-exception;
        throw new ParcelableException(e);
    }

    private /* synthetic */ Integer lambda$requestUnarchive$6(String packageName, String installerPackage, String callerPackageName, IntentSender statusReceiver, int userId) throws Exception {
        return Integer.valueOf(createDraftSession(packageName, installerPackage, callerPackageName, statusReceiver, userId));
    }

    private /* synthetic */ void lambda$requestUnarchive$7(String packageName, UserHandle userHandle, String installerPackage, int draftSessionId) {
        Slog.i(TAG, "Starting app unarchival for: " + packageName);
        unarchiveInternal(packageName, userHandle, installerPackage, draftSessionId);
    }

    private PackageInstaller.SessionInfo getActiveUnarchivalSession(String packageName, int userId) {
        List<PackageInstaller.SessionInfo> activeSessions = this.mPm.mInstallerService.getAllSessions(userId).getList();
        int idx = 0;
    L4:
        if (idx >= activeSessions.size()) goto L15;
        PackageInstaller.SessionInfo activeSession = activeSessions.get(idx);
        if (TextUtils.equals(activeSession.appPackageName, packageName) == false) goto L14;
        if (activeSession.userId != userId) goto L14;
        if (activeSession.active == false) goto L14;
        if (activeSession.isUnarchival() == false) goto L14;
        return activeSession;
    L14:
        idx = idx + 1;
        goto L4
    L15:
        return null;
    }

    private void requestUnarchiveConfirmation(final String packageName, final IntentSender statusReceiver, UserHandle user) {
        Intent dialogIntent = new Intent(ACTION_UNARCHIVE_DIALOG);
        dialogIntent.putExtra(EXTRA_UNARCHIVE_INTENT_SENDER, statusReceiver);
        dialogIntent.putExtra("android.content.pm.extra.PACKAGE_NAME", packageName);
        final Intent broadcastIntent = new Intent();
        broadcastIntent.putExtra("android.content.pm.extra.PACKAGE_NAME", packageName);
        broadcastIntent.putExtra("android.content.pm.extra.UNARCHIVE_STATUS", -1);
        broadcastIntent.putExtra("android.intent.extra.INTENT", dialogIntent);
        broadcastIntent.putExtra("android.intent.extra.USER", user);
        this.mPm.mHandler.post(new PackageArchiver$$ExternalSyntheticLambda6(this, statusReceiver, packageName, broadcastIntent));
    }

    private /* synthetic */ void lambda$requestUnarchiveConfirmation$8(IntentSender statusReceiver, String packageName, Intent broadcastIntent) {
        sendIntent(statusReceiver, packageName, "", broadcastIntent);
    }

    private void verifyUninstallPermissions() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DELETE_PACKAGES") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REQUEST_DELETE_PACKAGES") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("You need the com.android.permission.DELETE_PACKAGES or com.android.permission.REQUEST_DELETE_PACKAGES permission to request an archival.");
    }

    private int createDraftSession(String packageName, String installerPackage, String callerPackageName, IntentSender statusReceiver, int userId) throws IOException {
        Computer snapshot = this.mPm.snapshotComputer();
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        sessionParams.setAppPackageName(packageName);
        sessionParams.setAppLabel(this.mContext.getString(17042265));
        String launcherPackageName = getCurrentLauncherPackageName(userId);
        if (launcherPackageName == null) goto L5;
        int r3 = snapshot.getPackageUid(launcherPackageName, 0, userId);
    L6:
        int launcherUid = r3;
        UserHandle r4 = UserHandle.of(userId);
        if (launcherPackageName != null) goto L9;
        String r7 = callerPackageName;
    L10:
        sessionParams.setAppIcon(getArchivedAppIcon(packageName, r4, isOverlayEnabled(launcherUid, r7)));
        sessionParams.installFlags = 1610612736;
        int installerUid = snapshot.getPackageUid(installerPackage, 0, userId);
        int existingSessionId = this.mPm.mInstallerService.getExistingDraftSessionId(installerUid, sessionParams, userId);
        if (existingSessionId == (-1)) goto L14;
        attachListenerToSession(statusReceiver, existingSessionId, userId);
        return existingSessionId;
    L14:
        final int sessionId = this.mPm.mInstallerService.createSessionInternal(sessionParams, installerPackage, this.mContext.getAttributionTag(), installerUid, userId);
        attachListenerToSession(statusReceiver, sessionId, userId);
        this.mPm.mHandler.postDelayed(new PackageArchiver$$ExternalSyntheticLambda10(this, sessionId), getUnarchiveForegroundTimeout());
        return sessionId;
    L9:
        r7 = launcherPackageName;
        goto L10
    L5:
        r3 = 1000;
        goto L6
    }

    private /* synthetic */ void lambda$createDraftSession$9(int sessionId) {
        this.mPm.mInstallerService.cleanupDraftIfUnclaimed(sessionId);
    }

    private void attachListenerToSession(IntentSender statusReceiver, int existingSessionId, int userId) {
        PackageInstallerSession session = this.mPm.mInstallerService.getSession(existingSessionId);
        int status = session.getUnarchivalStatus();
        if (status != 0) goto L7;
        notifyUnarchivalListener(0, session.getInstallerPackageName(), session.params.appPackageName, 0, null, Set.of(statusReceiver), userId);
        return;
    L7:
        if (status != (-1)) goto L11;
        session.registerUnarchivalListener(statusReceiver);
        return;
    L11:
        throw new IllegalStateException(TextUtils.formatSimple("Session %s has unarchive status%s but is still active.", new Object[]{Integer.valueOf(session.sessionId), Integer.valueOf(status)}));
    }

    public Bitmap getArchivedAppIcon(String packageName, UserHandle user, String callingPackageName) {
        return getArchivedAppIcon(packageName, user, isOverlayEnabled(Binder.getCallingUid(), callingPackageName));
    }

    private Bitmap getArchivedAppIcon(String packageName, UserHandle user, boolean isOverlayEnabled) {
        packageName.getClass();
        user.getClass();
        Computer snapshot = this.mPm.snapshotComputer();
        int callingUid = Binder.getCallingUid();
        int userId = user.getIdentifier();
        PackageStateInternal ps = getPackageState(packageName, snapshot, callingUid, userId);     // Catch: PackageManager.NameNotFoundException -> L15
        ArchiveState archiveState = getAnyArchiveState(ps, userId);
        if (archiveState != null) goto L7;
    L14:
        return null;
    L7:
        if (archiveState.getActivityInfos().size() == 0) goto L14;
        Bitmap icon = decodeIcon(archiveState.getActivityInfos().get(0));
        if (icon == null) goto L20;
        if (isOverlayEnabled == true) goto L13;
        return icon;
    L13:
        return includeCloudOverlay(icon);
    L20:
        return icon;
    L15:
        e = move-exception;
        Slog.e(TAG, TextUtils.formatSimple("Package %s couldn't be found.", new Object[]{packageName}), e);
        return null;
    }

    private boolean isOverlayEnabled(int callingUid, String packageName) {
        if (getAppOpsManager().checkOp(145, callingUid, packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private ArchiveState getAnyArchiveState(PackageStateInternal ps, int userId) {
        PackageUserStateInternal userState = ps.getUserStateOrDefault(userId);
        if (isArchived(userState) == true) goto L5;
        int i = 0;
    L8:
        if (i >= ps.getUserStates().size()) goto L14;
        PackageUserStateInternal userState2 = ps.getUserStates().valueAt(i);
        if (isArchived(userState2) == true) goto L12;
        i = i + 1;
        goto L8
    L12:
        return userState2.getArchiveState();
    L14:
        return null;
    L5:
        return userState.getArchiveState();
    }

    Bitmap decodeIcon(ArchiveState.ArchiveActivityInfo activityInfo) {
        Path iconBitmap = activityInfo.getIconBitmap();
        if (iconBitmap != null) goto L5;
        return null;
    L5:
        Bitmap bitmap = BitmapFactory.decodeFile(iconBitmap.toString());
        if (bitmap != null) goto L9;
        Slog.e(TAG, "Archived icon cannot be decoded " + iconBitmap.toAbsolutePath());
        return null;
    L9:
        return bitmap;
    }

    Bitmap includeCloudOverlay(Bitmap bitmap) {
        Drawable cloudDrawable = this.mContext.getResources().getDrawable(R.drawable.btn_cab_done_focused_holo_dark, this.mContext.getTheme());
        if (cloudDrawable != null) goto L6;
        Slog.e(TAG, "Unable to locate cloud overlay for archived app!");
        return bitmap;
    L6:
        BitmapDrawable appIconDrawable = new BitmapDrawable(this.mContext.getResources(), bitmap);
        appIconDrawable.setColorFilter(OPACITY_LAYER_FILTER);
        appIconDrawable.setBounds(0, 0, cloudDrawable.getIntrinsicWidth(), cloudDrawable.getIntrinsicHeight());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{appIconDrawable, cloudDrawable});
        int iconSize = ((ActivityManager) this.mContext.getSystemService(ActivityManager.class)).getLauncherLargeIconSize();
        Bitmap appIconWithCloudOverlay = ArchivedActivityInfo.drawableToBitmap(layerDrawable, iconSize);
        if (bitmap == null) goto L9;
        bitmap.recycle();
    L9:
        return appIconWithCloudOverlay;
    }

    private void verifyArchived(PackageStateInternal ps, int userId) throws PackageManager.NameNotFoundException {
        PackageUserStateInternal userState = ps.getUserStateOrDefault(userId);
        if (isArchived(userState) == false) goto L6;
        return;
    L6:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("Package %s is not currently archived.", new Object[]{ps.getPackageName()}));
    }

    private void unarchiveInternal(String packageName, UserHandle userHandle, String installerPackage, int unarchiveId) {
        int userId = userHandle.getIdentifier();
        Intent unarchiveIntent = new Intent("android.intent.action.UNARCHIVE_PACKAGE");
        unarchiveIntent.addFlags(268435456);
        unarchiveIntent.putExtra("android.content.pm.extra.UNARCHIVE_ID", unarchiveId);
        unarchiveIntent.putExtra("android.content.pm.extra.UNARCHIVE_PACKAGE_NAME", packageName);
        if (userId != (-1)) goto L5;
        boolean r4 = true;
    L6:
        unarchiveIntent.putExtra("android.content.pm.extra.UNARCHIVE_ALL_USERS", r4);
        unarchiveIntent.setPackage(installerPackage);
        if (userId != (-1)) goto L9;
        UserHandle userForUnarchival = UserHandle.of(this.mPm.mUserManager.getCurrentUserId());
    L10:
        this.mContext.sendOrderedBroadcastAsUser(unarchiveIntent, userForUnarchival, null, -1, createUnarchiveOptions(), null, null, 0, null, null);
        return;
    L9:
        userForUnarchival = userHandle;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    List<LauncherActivityInfo> getLauncherActivityInfos(final String packageName, final int userId) throws PackageManager.NameNotFoundException {
        List<LauncherActivityInfo> mainActivities = (List) Binder.withCleanCallingIdentity(new PackageArchiver$$ExternalSyntheticLambda3(this, packageName, userId));
        if (mainActivities.isEmpty() == true) goto L6;
        return mainActivities;
    L6:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("The app %s does not have a main activity.", new Object[]{packageName}));
    }

    private /* synthetic */ List lambda$getLauncherActivityInfos$10(String packageName, int userId) throws Exception {
        return getLauncherApps().getActivityList(packageName, new UserHandle(userId));
    }

    private Bundle createUnarchiveOptions() {
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setTemporaryAppAllowlist(getUnarchiveForegroundTimeout(), 0, 328, "");
        return options.toBundle();
    }

    private static int getUnarchiveForegroundTimeout() {
        return DEFAULT_UNARCHIVE_FOREGROUND_TIMEOUT_MS;
    }

    private static String getResponsibleInstallerPackage(InstallSource installSource) {
        if (TextUtils.isEmpty(installSource.mUpdateOwnerPackageName) == false) goto L6;
        return installSource.mInstallerPackageName;
    L6:
        return installSource.mUpdateOwnerPackageName;
    }

    private static String getResponsibleInstallerTitle(Context context, ApplicationInfo appInfo, String responsibleInstallerPackage, int userId) throws PackageManager.NameNotFoundException {
        Context userContext = context.createPackageContextAsUser(responsibleInstallerPackage, 0, new UserHandle(userId));
        return appInfo.loadLabel(userContext.getPackageManager()).toString();
    }

    static String getResponsibleInstallerPackage(PackageStateInternal ps) {
        return getResponsibleInstallerPackage(ps.getInstallSource());
    }

    static SparseArray<String> getResponsibleInstallerTitles(Context context, Computer snapshot, InstallSource installSource, int requestUserId, int[] allUserIds) {
        String responsibleInstallerPackage = getResponsibleInstallerPackage(installSource);
        SparseArray<String> responsibleInstallerTitles = new SparseArray();
        if (requestUserId == (-1)) goto L10;
        ApplicationInfo responsibleInstallerInfo = snapshot.getApplicationInfo(responsibleInstallerPackage, 0, requestUserId);     // Catch: PackageManager.NameNotFoundException -> L8
        if (responsibleInstallerInfo != null) goto L7;
        return null;
    L7:
        String title = getResponsibleInstallerTitle(context, responsibleInstallerInfo, responsibleInstallerPackage, requestUserId);     // Catch: PackageManager.NameNotFoundException -> L8
        responsibleInstallerTitles.put(requestUserId, title);     // Catch: PackageManager.NameNotFoundException -> L8
    L19:
        return responsibleInstallerTitles;
    L10:
        int i = 0;
    L12:
        if (i >= allUserIds.length) goto L19;
        int userId = allUserIds[i];     // Catch: PackageManager.NameNotFoundException -> L8
        ApplicationInfo responsibleInstallerInfo2 = snapshot.getApplicationInfo(responsibleInstallerPackage, 0, userId);     // Catch: PackageManager.NameNotFoundException -> L8
        if (responsibleInstallerInfo2 == null) goto L17;
        String title2 = getResponsibleInstallerTitle(context, responsibleInstallerInfo2, responsibleInstallerPackage, userId);     // Catch: PackageManager.NameNotFoundException -> L8
        responsibleInstallerTitles.put(userId, title2);     // Catch: PackageManager.NameNotFoundException -> L8
    L17:
        i = i + 1;
        goto L12
    L21:
        return null;
    }

    void notifyUnarchivalListener(int status, String installerPackageName, String appPackageName, long requiredStorageBytes, PendingIntent userActionIntent, Set<IntentSender> unarchiveIntentSenders, int userId) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.putExtra("android.content.pm.extra.PACKAGE_NAME", appPackageName);
        broadcastIntent.putExtra("android.content.pm.extra.UNARCHIVE_STATUS", status);
        if (status == 0) goto L9;
        Intent dialogIntent = createErrorDialogIntent(status, installerPackageName, appPackageName, requiredStorageBytes, userActionIntent, userId);
        if (dialogIntent != null) goto L7;
        return;
    L7:
        broadcastIntent.putExtra("android.intent.extra.INTENT", dialogIntent);
        broadcastIntent.putExtra("android.intent.extra.USER", UserHandle.of(userId));
    L9:
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setPendingIntentBackgroundActivityStartMode(2);
        Iterator<IntentSender> r12 = unarchiveIntentSenders.iterator();
    L11:
        if (r12.hasNext() == false) goto L51;
        IntentSender intentSender = r12.next();
        Intent broadcastIntent2 = broadcastIntent;
        intentSender.sendIntent(this.mContext, 0, broadcastIntent2, null, options.toBundle(), null, null);     // Catch: Throwable -> L24 IntentSender.SendIntentException -> L26
        Map<Pair<Integer, String>, IntentSender> r2 = this.mLauncherIntentSenders;
        monitor-enter(r2);
        this.mLauncherIntentSenders.remove(Pair.create(Integer.valueOf(userId), appPackageName));     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
    L39:
        broadcastIntent = broadcastIntent2;
    L21:
        th = move-exception;
        throw th;
    L24:
        th = th;
    L43:
        Map<Pair<Integer, String>, IntentSender> r3 = this.mLauncherIntentSenders;
        monitor-enter(r3);
        this.mLauncherIntentSenders.remove(Pair.create(Integer.valueOf(userId), r4));     // Catch: Throwable -> L48
        monitor-exit(r3);     // Catch: Throwable -> L48
        throw th;
    L48:
        th = move-exception;
        throw th;
    L26:
        e = e;
    L33:
        Slog.e(TAG, TextUtils.formatSimple("Failed to send unarchive intent", new Object[0]), e);     // Catch: Throwable -> L24
        Map<Pair<Integer, String>, IntentSender> r4 = this.mLauncherIntentSenders;
        monitor-enter(r4);
        this.mLauncherIntentSenders.remove(Pair.create(Integer.valueOf(userId), r4));     // Catch: Throwable -> L40
        monitor-exit(r4);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L30:
        e = e;
        broadcastIntent2 = broadcastIntent;
    L28:
        th = th;
        goto L43
    }

    private Intent createErrorDialogIntent(int status, String installerPackageName, String appPackageName, long requiredStorageBytes, PendingIntent userActionIntent, int userId) {
        Intent dialogIntent = new Intent(ACTION_UNARCHIVE_ERROR_DIALOG);
        dialogIntent.putExtra("android.content.pm.extra.UNARCHIVE_STATUS", status);
        dialogIntent.putExtra("android.intent.extra.USER", UserHandle.of(userId));
        if (requiredStorageBytes <= 0) goto L5;
        dialogIntent.putExtra(EXTRA_REQUIRED_BYTES, requiredStorageBytes);
    L5:
        if (userActionIntent == null) goto L7;
        dialogIntent.putExtra("android.intent.extra.INTENT", userActionIntent);
    L7:
        dialogIntent.putExtra(EXTRA_INSTALLER_PACKAGE_NAME, installerPackageName);
        String installerTitle = getInstallerTitle(appPackageName, userId);
        if (installerTitle != null) goto L11;
        return null;
    L11:
        dialogIntent.putExtra(EXTRA_INSTALLER_TITLE, installerTitle);
        return dialogIntent;
    }

    private String getInstallerTitle(String appPackageName, int userId) {
        PackageStateInternal packageState = getPackageState(appPackageName, this.mPm.snapshotComputer(), 1000, userId);     // Catch: PackageManager.NameNotFoundException -> L10
        ArchiveState archiveState = packageState.getUserStateOrDefault(userId).getArchiveState();
        if (archiveState != null) goto L9;
        Slog.e(TAG, TextUtils.formatSimple("notifyUnarchivalListener: App not archived %s.", new Object[]{appPackageName}));
        return null;
    L9:
        return archiveState.getInstallerTitle();
    L10:
        e = move-exception;
        Slog.e(TAG, TextUtils.formatSimple("notifyUnarchivalListener: Couldn't fetch package state for %s.", new Object[]{appPackageName}), e);
        return null;
    }

    private static PackageStateInternal getPackageState(String packageName, Computer snapshot, int callingUid, int userId) throws PackageManager.NameNotFoundException {
        PackageStateInternal ps = snapshot.getPackageStateFiltered(packageName, callingUid, userId);
        if (ps == null) goto L6;
        return ps;
    L6:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("Package %s not found.", new Object[]{packageName}));
    }

    private LauncherApps getLauncherApps() {
        if (this.mLauncherApps != null) goto L6;
        this.mLauncherApps = (LauncherApps) this.mContext.getSystemService(LauncherApps.class);
    L6:
        return this.mLauncherApps;
    }

    private AppOpsManager getAppOpsManager() {
        if (this.mAppOpsManager != null) goto L6;
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
    L6:
        return this.mAppOpsManager;
    }

    private UserManager getUserManager() {
        if (this.mUserManager != null) goto L6;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
    L6:
        return this.mUserManager;
    }

    private void storeArchiveState(String packageName, ArchiveState archiveState, int userId) throws PackageManager.NameNotFoundException {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting packageSetting = getPackageSettingLocked(packageName, userId);     // Catch: Throwable -> L8
        packageSetting.modifyUserState(userId).setArchiveState(archiveState);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private PackageSetting getPackageSettingLocked(String packageName, int userId) throws PackageManager.NameNotFoundException {
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);
        if (ps == null) goto L8;
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L8;
        return ps;
    L8:
        throw new PackageManager.NameNotFoundException(TextUtils.formatSimple("Package %s not found.", new Object[]{packageName}));
    }

    private void sendFailureStatus(IntentSender statusReceiver, String packageName, String message) {
        Slog.d(TAG, TextUtils.formatSimple("Failed to archive %s with message %s", new Object[]{packageName, message}));
        Intent intent = new Intent();
        intent.putExtra("android.content.pm.extra.PACKAGE_NAME", packageName);
        intent.putExtra("android.content.pm.extra.STATUS", 1);
        intent.putExtra("android.content.pm.extra.STATUS_MESSAGE", message);
        sendIntent(statusReceiver, packageName, message, intent);
    }

    private void sendIntent(IntentSender statusReceiver, String packageName, String message, Intent intent) {
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L8
        options.setPendingIntentBackgroundActivityStartMode(2);     // Catch: IntentSender.SendIntentException -> L8
        statusReceiver.sendIntent(this.mContext, 0, intent, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L6
        return;
    L6:
        e = move-exception;
        IntentSender.SendIntentException e = e;
    L10:
        Slog.e(TAG, TextUtils.formatSimple("Failed to send status for %s with message %s", new Object[]{packageName, message}), e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    private static void verifyCaller(int providedUid, int binderUid) {
        if (providedUid != binderUid) goto L5;
        return;
    L5:
        throw new SecurityException(TextUtils.formatSimple("The UID %s of callerPackageName set by the caller doesn't match the caller's actual UID %s.", new Object[]{Integer.valueOf(providedUid), Integer.valueOf(binderUid)}));
    }

    private static File createIconsDir(String packageName, int userId) throws IOException {
        File iconsDir = getIconsDir(packageName, userId);
        if (iconsDir.isDirectory() == true) goto L9;
        iconsDir.delete();
        iconsDir.mkdirs();
        if (iconsDir.isDirectory() == false) goto L8;
        Slog.i(TAG, "Created icons directory at " + iconsDir.getAbsolutePath());
        goto L9
    L8:
        throw new IOException("Unable to create directory " + iconsDir);
    L9:
        SELinux.restorecon(iconsDir);
        return iconsDir;
    }

    private static File getIconsDir(String packageName, int userId) {
        return new File(new File(Environment.getDataSystemCeDirectory(userId), ARCHIVE_ICONS_DIR), packageName);
    }

    private static byte[] bytesFromBitmapFile(Path path) throws IOException {
        if (path != null) goto L6;
        return null;
    L6:
        return ArchivedActivityInfo.bytesFromBitmap(BitmapFactory.decodeFile(path.toString()));
    }

    private static String getPackageNameFromIntent(Intent intent) {
        if (intent != null) goto L6;
        return null;
    L6:
        if (intent.getPackage() == null) goto L10;
        return intent.getPackage();
    L10:
        if (intent.getComponent() != null) goto L12;
        return null;
    L12:
        return intent.getComponent().getPackageName();
    }

    static ArchivedActivityParcel[] createArchivedActivities(ArchiveState archiveState) throws IOException {
        List<ArchiveState.ArchiveActivityInfo> infos = archiveState.getActivityInfos();
        if (infos == null) goto L20;
        if (infos.isEmpty() == true) goto L20;
        List<ArchivedActivityParcel> activities = new ArrayList(infos.size());
        int i = 0;
        int size = infos.size();
    L7:
        if (i >= size) goto L14;
        ArchiveState.ArchiveActivityInfo info = infos.get(i);
        if (info == null) goto L12;
        ArchivedActivityParcel archivedActivity = new ArchivedActivityParcel();
        archivedActivity.title = info.getTitle();
        archivedActivity.originalComponentName = info.getOriginalComponentName();
        archivedActivity.iconBitmap = bytesFromBitmapFile(info.getIconBitmap());
        archivedActivity.monochromeIconBitmap = bytesFromBitmapFile(info.getMonochromeIconBitmap());
        activities.add(archivedActivity);
    L12:
        i = i + 1;
        goto L7
    L14:
        if (activities.isEmpty() == true) goto L18;
        return (ArchivedActivityParcel[]) activities.toArray(new ArchivedActivityParcel[activities.size()]);
    L18:
        throw new IllegalArgumentException("Failed to extract title and icon of main activities");
    L20:
        throw new IllegalArgumentException("No activities in archive state");
    }

    static ArchivedActivityParcel[] createArchivedActivities(List<LauncherActivityInfo> infos, int iconSize) throws IOException {
        if (infos == null) goto L23;
        if (infos.isEmpty() == true) goto L23;
        List<ArchivedActivityParcel> activities = new ArrayList(infos.size());
        int i = 0;
        int size = infos.size();
    L6:
        if (i >= size) goto L17;
        LauncherActivityInfo info = infos.get(i);
        if (info == null) goto L15;
        ArchivedActivityParcel archivedActivity = new ArchivedActivityParcel();
        archivedActivity.title = info.getLabel().toString();
        archivedActivity.originalComponentName = info.getComponentName();
        if (info.getActivityInfo().getIconResource() != 0) goto L13;
        byte[] r5 = null;
    L14:
        archivedActivity.iconBitmap = r5;
        archivedActivity.monochromeIconBitmap = null;
        activities.add(archivedActivity);
        goto L15
    L13:
        r5 = ArchivedActivityInfo.bytesFromBitmap(ArchivedActivityInfo.drawableToBitmap(info.getIcon(0), iconSize));
    L15:
        i = i + 1;
        goto L6
    L17:
        if (activities.isEmpty() == true) goto L21;
        return (ArchivedActivityParcel[]) activities.toArray(new ArchivedActivityParcel[activities.size()]);
    L21:
        throw new IllegalArgumentException("Failed to extract title and icon of main activities");
    L23:
        throw new IllegalArgumentException("No launcher activities");
    }
}
