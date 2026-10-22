package com.android.server.wm;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.system.Os;
import android.system.OsConstants;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class AppWarnings {
    private static final String CONFIG_FILE_NAME = "packages-warnings.xml";
    public static final int FLAG_HIDE_COMPILE_SDK = 2;
    public static final int FLAG_HIDE_DEPRECATED_ABI = 8;
    public static final int FLAG_HIDE_DEPRECATED_SDK = 4;
    public static final int FLAG_HIDE_DISPLAY_SIZE = 1;
    public static final int FLAG_HIDE_PAGE_SIZE_MISMATCH = 16;
    private static final String TAG = "AppWarnings";
    private final ArraySet<ComponentName> mAlwaysShowUnsupportedCompileSdkWarningActivities;
    private final ActivityTaskManagerService mAtm;
    private final AtomicFile mConfigFile;
    private SparseArray<DeprecatedAbiDialog> mDeprecatedAbiDialogs;
    private SparseArray<DeprecatedTargetSdkVersionDialog> mDeprecatedTargetSdkVersionDialogs;
    private final ArrayMap<Pair<Integer, String>, Integer> mPackageFlags;
    private SparseArray<PageSizeMismatchDialog> mPageSizeMismatchDialogs;
    private final UiHandler mUiHandler;
    private SparseArray<UnsupportedCompileSdkDialog> mUnsupportedCompileSdkDialogs;
    private SparseArray<UnsupportedDisplaySizeDialog> mUnsupportedDisplaySizeDialogs;
    private UserManagerInternal mUserManagerInternal;
    private final WriteConfigTask mWriteConfigTask;

    static class BaseDialog {
        private BroadcastReceiver mCloseReceiver;
        AlertDialog mDialog;
        final AppWarnings mManager;
        final String mPackageName;
        final Context mUiContext;
        final int mUserId;

        BaseDialog(AppWarnings manager, Context uiContext, String packageName, int userId) {
            this.mManager = manager;
            this.mUiContext = uiContext;
            this.mPackageName = packageName;
            this.mUserId = userId;
        }

        void show() {
            if (this.mDialog != null) goto L6;
            return;
        L6:
            if (this.mCloseReceiver != null) goto L8;
            this.mCloseReceiver = new AnonymousClass1(this);
            this.mUiContext.registerReceiver(this.mCloseReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
        L8:
            Slog.w(AppWarnings.TAG, "Showing " + getClass().getSimpleName() + " for package " + this.mPackageName);
            this.mDialog.show();
        }

        void dismiss() {
            if (this.mDialog != null) goto L6;
            return;
        L6:
            if (this.mCloseReceiver == null) goto L8;
            this.mUiContext.unregisterReceiver(this.mCloseReceiver);
            this.mCloseReceiver = null;
        L8:
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    private final class UiHandler extends Handler {
        private static final int MSG_HIDE_DIALOGS_FOR_PACKAGE = 4;
        private static final int MSG_HIDE_UNSUPPORTED_DISPLAY_SIZE_DIALOG = 2;
        private static final int MSG_SHOW_DEPRECATED_ABI_DIALOG = 6;
        private static final int MSG_SHOW_DEPRECATED_TARGET_SDK_DIALOG = 5;
        private static final int MSG_SHOW_PAGE_SIZE_APP_MISMATCH_DIALOG = 7;
        private static final int MSG_SHOW_UNSUPPORTED_COMPILE_SDK_DIALOG = 3;
        private static final int MSG_SHOW_UNSUPPORTED_DISPLAY_SIZE_DIALOG = 1;
        final /* synthetic */ AppWarnings this$0;

        public UiHandler(AppWarnings r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            ActivityRecord ar = (ActivityRecord) msg.obj;
            AppWarnings.m9734$$Nest$mshowPageSizeMismatchDialogUiThread(this.this$0, ar);
            return;
        L6:
            ActivityRecord ar2 = (ActivityRecord) msg.obj;
            AppWarnings.m9732$$Nest$mshowDeprecatedAbiDialogUiThread(this.this$0, ar2);
            return;
        L7:
            ActivityRecord ar3 = (ActivityRecord) msg.obj;
            AppWarnings.m9733$$Nest$mshowDeprecatedTargetSdkDialogUiThread(this.this$0, ar3);
            return;
        L8:
            String name = (String) msg.obj;
            int userId = msg.arg1;
            AppWarnings.m9730$$Nest$mhideDialogsForPackageUiThread(this.this$0, name, userId);
            return;
        L9:
            ActivityRecord ar4 = (ActivityRecord) msg.obj;
            AppWarnings.m9735$$Nest$mshowUnsupportedCompileSdkDialogUiThread(this.this$0, ar4);
            return;
        L10:
            AppWarnings.m9731$$Nest$mhideUnsupportedDisplaySizeDialogUiThread(this.this$0);
            return;
        L11:
            ActivityRecord ar5 = (ActivityRecord) msg.obj;
            AppWarnings.m9736$$Nest$mshowUnsupportedDisplaySizeDialogUiThread(this.this$0, ar5);
            return;
        }

        public void showUnsupportedDisplaySizeDialog(ActivityRecord r) {
            removeMessages(1);
            obtainMessage(1, r).sendToTarget();
        }

        public void hideUnsupportedDisplaySizeDialog() {
            removeMessages(2);
            sendEmptyMessage(2);
        }

        public void showUnsupportedCompileSdkDialog(ActivityRecord r) {
            removeMessages(3);
            obtainMessage(3, r).sendToTarget();
        }

        public void showDeprecatedTargetDialog(ActivityRecord r) {
            removeMessages(5);
            obtainMessage(5, r).sendToTarget();
        }

        public void showDeprecatedAbiDialog(ActivityRecord r) {
            removeMessages(6);
            obtainMessage(6, r).sendToTarget();
        }

        public void hideDialogsForPackage(String name, int userId) {
            obtainMessage(4, userId, 0, name).sendToTarget();
        }

        public void showPageSizeMismatchDialog(ActivityRecord r) {
            removeMessages(7);
            obtainMessage(7, r).sendToTarget();
        }
    }

    private final class WriteConfigTask implements Runnable {
        private static final long WRITE_CONFIG_DELAY_MS = 10000;
        final AtomicReference<ArrayMap<Pair<Integer, String>, Integer>> mPendingPackageFlags;
        final /* synthetic */ AppWarnings this$0;

        /* synthetic */ WriteConfigTask(AppWarnings r1, AppWarningsIA r2) {
            this(r1);
        }

        private WriteConfigTask(AppWarnings r1) {
            this.this$0 = r1;
            this.mPendingPackageFlags = new AtomicReference();
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayMap<Pair<Integer, String>, Integer> packageFlags = this.mPendingPackageFlags.getAndSet(null);
            if (packageFlags == null) goto L6;
            AppWarnings.m9737$$Nest$mwriteConfigToFile(this.this$0, packageFlags);
            return;
        }

        void schedule() {
            if (this.mPendingPackageFlags.getAndSet(new ArrayMap(AppWarnings.m9727$$Nest$fgetmPackageFlags(this.this$0))) != null) goto L6;
            IoThread.getHandler().postDelayed(this, 10000);
            return;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$H4JMXMIkLrrC65qIRbXEOcg8UtQ(String r0) {
        return lambda$showDeprecatedAbiDialogIfNeeded$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9727$$Nest$fgetmPackageFlags(AppWarnings r0) {
        return r0.mPackageFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ UiHandler m9728$$Nest$fgetmUiHandler(AppWarnings r0) {
        return r0.mUiHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAllPackageFlagsForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9729$$Nest$mclearAllPackageFlagsForUser(AppWarnings r0, int r1) {
        r0.clearAllPackageFlagsForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideDialogsForPackageUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9730$$Nest$mhideDialogsForPackageUiThread(AppWarnings r0, String r1, int r2) {
        r0.hideDialogsForPackageUiThread(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideUnsupportedDisplaySizeDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9731$$Nest$mhideUnsupportedDisplaySizeDialogUiThread(AppWarnings r0) {
        r0.hideUnsupportedDisplaySizeDialogUiThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mshowDeprecatedAbiDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9732$$Nest$mshowDeprecatedAbiDialogUiThread(AppWarnings r0, ActivityRecord r1) {
        r0.showDeprecatedAbiDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowDeprecatedTargetSdkDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9733$$Nest$mshowDeprecatedTargetSdkDialogUiThread(AppWarnings r0, ActivityRecord r1) {
        r0.showDeprecatedTargetSdkDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowPageSizeMismatchDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9734$$Nest$mshowPageSizeMismatchDialogUiThread(AppWarnings r0, ActivityRecord r1) {
        r0.showPageSizeMismatchDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowUnsupportedCompileSdkDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9735$$Nest$mshowUnsupportedCompileSdkDialogUiThread(AppWarnings r0, ActivityRecord r1) {
        r0.showUnsupportedCompileSdkDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowUnsupportedDisplaySizeDialogUiThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9736$$Nest$mshowUnsupportedDisplaySizeDialogUiThread(AppWarnings r0, ActivityRecord r1) {
        r0.showUnsupportedDisplaySizeDialogUiThread(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteConfigToFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9737$$Nest$mwriteConfigToFile(AppWarnings r0, ArrayMap r1) {
        r0.writeConfigToFile(r1);
    }

    void alwaysShowUnsupportedCompileSdkWarning(ComponentName activity) {
        this.mAlwaysShowUnsupportedCompileSdkWarningActivities.add(activity);
    }

    public AppWarnings(ActivityTaskManagerService atm, Context uiContext, Handler handler, Handler uiHandler, File systemDir) {
        this.mPackageFlags = new ArrayMap();
        this.mAlwaysShowUnsupportedCompileSdkWarningActivities = new ArraySet();
        this.mAtm = atm;
        this.mWriteConfigTask = new WriteConfigTask(this, null);
        this.mUiHandler = new UiHandler(this, uiHandler.getLooper());
        this.mConfigFile = new AtomicFile(new File(systemDir, CONFIG_FILE_NAME), "warnings-config");
    }

    void onSystemReady() {
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        readConfigFromFileAmsThread();
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L5;
        return;
    L5:
        this.mUserManagerInternal.addUserLifecycleListener(new AnonymousClass1(this));
    }

    public void showUnsupportedDisplaySizeDialogIfNeeded(ActivityRecord r) {
        DisplayContent dc = r.getDisplayContent();
        if (dc != null) goto L5;
        Configuration config = this.mAtm.getGlobalConfiguration();
    L7:
        if (config.densityDpi != DisplayMetrics.DENSITY_DEVICE_STABLE) goto L9;
        return;
    L9:
        if (r.info.applicationInfo.requiresSmallestWidthDp <= config.smallestScreenWidthDp) goto L13;
        this.mUiHandler.showUnsupportedDisplaySizeDialog(r);
        return;
    L13:
        return;
    L5:
        config = dc.getConfiguration();
        goto L7
    }

    public void showUnsupportedCompileSdkDialogIfNeeded(ActivityRecord r) {
        if (r.info.applicationInfo.compileSdkVersion != 0) goto L5;
        return;
    L5:
        if (r.info.applicationInfo.compileSdkVersionCodename != null) goto L8;
        return;
    L8:
        if (this.mAlwaysShowUnsupportedCompileSdkWarningActivities.contains(r.mActivityComponent) == true) goto L10;
        return;
    L10:
        int compileSdk = r.info.applicationInfo.compileSdkVersion;
        int platformSdk = Build.VERSION.SDK_INT;
        boolean isCompileSdkPreview = !"REL".equals(r.info.applicationInfo.compileSdkVersionCodename);
        boolean isPlatformSdkPreview = !"REL".equals(Build.VERSION.CODENAME);
        if (isCompileSdkPreview == false) goto L13;
        if (compileSdk >= platformSdk) goto L13;
    L20:
        this.mUiHandler.showUnsupportedCompileSdkDialog(r);
        return;
    L13:
        if (isPlatformSdkPreview == false) goto L15;
        if (platformSdk < compileSdk) goto L20;
    L15:
        if (isCompileSdkPreview == false) goto L23;
        if (isPlatformSdkPreview == false) goto L24;
        if (platformSdk == compileSdk) goto L19;
        return;
    L19:
        if (Build.VERSION.CODENAME.equals(r.info.applicationInfo.compileSdkVersionCodename) == false) goto L20;
        return;
    L24:
        return;
    }

    public void showDeprecatedTargetDialogIfNeeded(ActivityRecord r) {
        boolean disableDeprecatedTargetSdkDialog = SystemProperties.getBoolean("debug.wm.disable_deprecated_target_sdk_dialog", false);
        if (r.info.applicationInfo.targetSdkVersion >= Build.VERSION.MIN_SUPPORTED_TARGET_SDK_INT) goto L7;
        if (disableDeprecatedTargetSdkDialog == true) goto L8;
        this.mUiHandler.showDeprecatedTargetDialog(r);
        return;
    L8:
        return;
    }

    public void showDeprecatedAbiDialogIfNeeded(ActivityRecord r) {
        boolean is64BitDevice = true;
        if ((r.info.applicationInfo.privateFlagsExt & 32) == 0) goto L5;
        boolean isUsingAbiOverride = true;
    L6:
        if (isUsingAbiOverride == false) goto L8;
        return;
    L8:
        boolean disableDeprecatedAbiDialog = SystemProperties.getBoolean("debug.wm.disable_deprecated_abi_dialog", false);
        if (disableDeprecatedAbiDialog == false) goto L11;
        return;
    L11:
        String appPrimaryAbi = r.info.applicationInfo.primaryCpuAbi;
        String appSecondaryAbi = r.info.applicationInfo.secondaryCpuAbi;
        if (appPrimaryAbi == null) goto L17;
        if (appSecondaryAbi != null) goto L17;
        if (appPrimaryAbi.contains("64") == true) goto L17;
        boolean appContainsOnly32bitLibraries = true;
    L19:
        if (ArrayUtils.find(Build.SUPPORTED_ABIS, new AppWarnings$$ExternalSyntheticLambda0()) != null) goto L22;
        is64BitDevice = false;
    L22:
        if (is64BitDevice == false) goto L26;
        if (appContainsOnly32bitLibraries == false) goto L27;
        this.mUiHandler.showDeprecatedAbiDialog(r);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        appContainsOnly32bitLibraries = false;
        goto L19
    L5:
        isUsingAbiOverride = false;
        goto L6
    }

    private static /* synthetic */ boolean lambda$showDeprecatedAbiDialogIfNeeded$0(String abi) {
        return abi.contains("64");
    }

    public void showPageSizeMismatchDialogIfNeeded(ActivityRecord r) {
        boolean is16KbDevice = false;
        boolean appCompatEnabled = SystemProperties.getBoolean("bionic.linker.16kb.app_compat.enabled", false);
        if (appCompatEnabled == false) goto L6;
        return;
    L6:
        if (Os.sysconf(OsConstants._SC_PAGESIZE) != 16384) goto L8;
        is16KbDevice = true;
    L8:
        if (is16KbDevice == false) goto L11;
        this.mUiHandler.showPageSizeMismatchDialog(r);
        return;
    }

    public void onStartActivity(ActivityRecord r) {
        showUnsupportedCompileSdkDialogIfNeeded(r);
        showUnsupportedDisplaySizeDialogIfNeeded(r);
        showDeprecatedTargetDialogIfNeeded(r);
        showDeprecatedAbiDialogIfNeeded(r);
        showPageSizeMismatchDialogIfNeeded(r);
    }

    public void onResumeActivity(ActivityRecord r) {
        showUnsupportedDisplaySizeDialogIfNeeded(r);
    }

    public void onPackageDataCleared(String name, int userId) {
        removePackageAndHideDialogs(name, userId);
    }

    public void onPackageUninstalled(String name, int userId) {
        removePackageAndHideDialogs(name, userId);
    }

    public void onDensityChanged() {
        this.mUiHandler.hideUnsupportedDisplaySizeDialog();
    }

    private void removePackageAndHideDialogs(String name, int userId) {
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L5;
        int userId2 = 0;
    L6:
        this.mUiHandler.hideDialogsForPackage(name, userId2);
        ArrayMap<Pair<Integer, String>, Integer> r0 = this.mPackageFlags;
        monitor-enter(r0);
        Pair<Integer, String> packageKey = Pair.create(Integer.valueOf(userId2), name);     // Catch: Throwable -> L11
        if (this.mPackageFlags.remove(packageKey) == null) goto L13;
        this.mWriteConfigTask.schedule();     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        userId2 = this.mUserManagerInternal.getProfileParentId(userId);
        goto L6
    }

    private void hideUnsupportedDisplaySizeDialogUiThread() {
        if (this.mUnsupportedDisplaySizeDialogs != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mUnsupportedDisplaySizeDialogs.size()) goto L9;
        this.mUnsupportedDisplaySizeDialogs.valueAt(i).dismiss();
        i = i + 1;
        goto L7
    L9:
        this.mUnsupportedDisplaySizeDialogs.clear();
    }

    private void showUnsupportedDisplaySizeDialogUiThread(ActivityRecord ar) {
        int userId = getUserIdForActivity(ar);
        if (this.mUnsupportedDisplaySizeDialogs == null) goto L8;
        UnsupportedDisplaySizeDialog unsupportedDisplaySizeDialog = this.mUnsupportedDisplaySizeDialogs.get(userId);
        if (unsupportedDisplaySizeDialog == null) goto L8;
        unsupportedDisplaySizeDialog.dismiss();
        this.mUnsupportedDisplaySizeDialogs.remove(userId);
    L8:
        if (hasPackageFlag(userId, ar.packageName, 1) == true) goto L14;
        UnsupportedDisplaySizeDialog unsupportedDisplaySizeDialog2 = new UnsupportedDisplaySizeDialog(this, getUiContextForActivity(ar), ar.info.applicationInfo, userId);
        unsupportedDisplaySizeDialog2.show();
        if (this.mUnsupportedDisplaySizeDialogs != null) goto L12;
        this.mUnsupportedDisplaySizeDialogs = new SparseArray();
    L12:
        this.mUnsupportedDisplaySizeDialogs.put(userId, unsupportedDisplaySizeDialog2);
        return;
    }

    private void showUnsupportedCompileSdkDialogUiThread(ActivityRecord ar) {
        int userId = getUserIdForActivity(ar);
        if (this.mUnsupportedCompileSdkDialogs == null) goto L8;
        UnsupportedCompileSdkDialog unsupportedCompileSdkDialog = this.mUnsupportedCompileSdkDialogs.get(userId);
        if (unsupportedCompileSdkDialog == null) goto L8;
        unsupportedCompileSdkDialog.dismiss();
        this.mUnsupportedCompileSdkDialogs.remove(userId);
    L8:
        if (hasPackageFlag(userId, ar.packageName, 2) == true) goto L14;
        UnsupportedCompileSdkDialog unsupportedCompileSdkDialog2 = new UnsupportedCompileSdkDialog(this, getUiContextForActivity(ar), ar.info.applicationInfo, userId);
        unsupportedCompileSdkDialog2.show();
        if (this.mUnsupportedCompileSdkDialogs != null) goto L12;
        this.mUnsupportedCompileSdkDialogs = new SparseArray();
    L12:
        this.mUnsupportedCompileSdkDialogs.put(userId, unsupportedCompileSdkDialog2);
        return;
    }

    private void showDeprecatedTargetSdkDialogUiThread(ActivityRecord ar) {
        int userId = getUserIdForActivity(ar);
        if (this.mDeprecatedTargetSdkVersionDialogs == null) goto L8;
        DeprecatedTargetSdkVersionDialog deprecatedTargetSdkVersionDialog = this.mDeprecatedTargetSdkVersionDialogs.get(userId);
        if (deprecatedTargetSdkVersionDialog == null) goto L8;
        deprecatedTargetSdkVersionDialog.dismiss();
        this.mDeprecatedTargetSdkVersionDialogs.remove(userId);
    L8:
        if (hasPackageFlag(userId, ar.packageName, 4) == true) goto L14;
        DeprecatedTargetSdkVersionDialog deprecatedTargetSdkVersionDialog2 = new DeprecatedTargetSdkVersionDialog(this, getUiContextForActivity(ar), ar.info.applicationInfo, userId);
        deprecatedTargetSdkVersionDialog2.show();
        if (this.mDeprecatedTargetSdkVersionDialogs != null) goto L12;
        this.mDeprecatedTargetSdkVersionDialogs = new SparseArray();
    L12:
        this.mDeprecatedTargetSdkVersionDialogs.put(userId, deprecatedTargetSdkVersionDialog2);
        return;
    }

    private void showDeprecatedAbiDialogUiThread(ActivityRecord ar) {
        int userId = getUserIdForActivity(ar);
        if (this.mDeprecatedAbiDialogs == null) goto L8;
        DeprecatedAbiDialog deprecatedAbiDialog = this.mDeprecatedAbiDialogs.get(userId);
        if (deprecatedAbiDialog == null) goto L8;
        deprecatedAbiDialog.dismiss();
        this.mDeprecatedAbiDialogs.remove(userId);
    L8:
        if (hasPackageFlag(userId, ar.packageName, 8) == true) goto L14;
        DeprecatedAbiDialog deprecatedAbiDialog2 = new DeprecatedAbiDialog(this, getUiContextForActivity(ar), ar.info.applicationInfo, userId);
        deprecatedAbiDialog2.show();
        if (this.mDeprecatedAbiDialogs != null) goto L12;
        this.mDeprecatedAbiDialogs = new SparseArray();
    L12:
        this.mDeprecatedAbiDialogs.put(userId, deprecatedAbiDialog2);
        return;
    }

    private void showPageSizeMismatchDialogUiThread(ActivityRecord ar) {
        String warning = this.mAtm.mContext.getPackageManager().getPageSizeCompatWarningMessage(ar.info.packageName);
        if (warning != null) goto L5;
        return;
    L5:
        int userId = getUserIdForActivity(ar);
        if (this.mPageSizeMismatchDialogs == null) goto L11;
        PageSizeMismatchDialog pageSizeMismatchDialog = this.mPageSizeMismatchDialogs.get(userId);
        if (pageSizeMismatchDialog == null) goto L11;
        pageSizeMismatchDialog.dismiss();
        this.mPageSizeMismatchDialogs.remove(userId);
    L11:
        if (hasPackageFlag(userId, ar.packageName, 16) == true) goto L17;
        final Context context = getUiContextForActivity(ar);
        final int r1 = context.getThemeResId();
        PageSizeMismatchDialog pageSizeMismatchDialog2 = new PageSizeMismatchDialog(this, new AnonymousClass2(this, context, r1), ar.info.applicationInfo, userId, warning);
        pageSizeMismatchDialog2.show();
        if (this.mPageSizeMismatchDialogs != null) goto L15;
        this.mPageSizeMismatchDialogs = new SparseArray();
    L15:
        this.mPageSizeMismatchDialogs.put(userId, pageSizeMismatchDialog2);
        return;
    }

    private void hideDialogsForPackageUiThread(String name, int userId) {
        if (this.mUnsupportedDisplaySizeDialogs == null) goto L11;
        UnsupportedDisplaySizeDialog unsupportedDisplaySizeDialog = this.mUnsupportedDisplaySizeDialogs.get(userId);
        if (unsupportedDisplaySizeDialog == null) goto L11;
        if (name != null) goto L8;
    L9:
        unsupportedDisplaySizeDialog.dismiss();
        this.mUnsupportedDisplaySizeDialogs.remove(userId);
        goto L11
    L8:
        if (name.equals(unsupportedDisplaySizeDialog.mPackageName) == true) goto L9;
    L11:
        if (this.mUnsupportedCompileSdkDialogs == null) goto L19;
        UnsupportedCompileSdkDialog unsupportedCompileSdkDialog = this.mUnsupportedCompileSdkDialogs.get(userId);
        if (unsupportedCompileSdkDialog == null) goto L19;
        if (name != null) goto L16;
    L17:
        unsupportedCompileSdkDialog.dismiss();
        this.mUnsupportedCompileSdkDialogs.remove(userId);
        goto L19
    L16:
        if (name.equals(unsupportedCompileSdkDialog.mPackageName) == true) goto L17;
    L19:
        if (this.mDeprecatedTargetSdkVersionDialogs == null) goto L27;
        DeprecatedTargetSdkVersionDialog deprecatedTargetSdkVersionDialog = this.mDeprecatedTargetSdkVersionDialogs.get(userId);
        if (deprecatedTargetSdkVersionDialog == null) goto L27;
        if (name != null) goto L24;
    L25:
        deprecatedTargetSdkVersionDialog.dismiss();
        this.mDeprecatedTargetSdkVersionDialogs.remove(userId);
        goto L27
    L24:
        if (name.equals(deprecatedTargetSdkVersionDialog.mPackageName) == true) goto L25;
    L27:
        if (this.mDeprecatedAbiDialogs == null) goto L35;
        DeprecatedAbiDialog deprecatedAbiDialog = this.mDeprecatedAbiDialogs.get(userId);
        if (deprecatedAbiDialog == null) goto L35;
        if (name != null) goto L32;
    L33:
        deprecatedAbiDialog.dismiss();
        this.mDeprecatedAbiDialogs.remove(userId);
        goto L35
    L32:
        if (name.equals(deprecatedAbiDialog.mPackageName) == true) goto L33;
    L35:
        if (this.mPageSizeMismatchDialogs == null) goto L43;
        PageSizeMismatchDialog pageSizeMismatchDialog = this.mPageSizeMismatchDialogs.get(userId);
        if (pageSizeMismatchDialog == null) goto L44;
        if (name != null) goto L40;
    L41:
        pageSizeMismatchDialog.dismiss();
        this.mPageSizeMismatchDialogs.remove(userId);
        return;
    L40:
        if (name.equals(pageSizeMismatchDialog.mPackageName) == true) goto L41;
        return;
    L44:
        return;
    }

    boolean hasPackageFlag(int userId, String name, int flag) {
        if ((getPackageFlags(userId, name) & flag) != flag) goto L5;
        return true;
    L5:
        return false;
    }

    void setPackageFlag(int userId, String name, int flag, boolean enabled) {
        ArrayMap<Pair<Integer, String>, Integer> r0 = this.mPackageFlags;
        monitor-enter(r0);
        int curFlags = getPackageFlags(userId, name);     // Catch: Throwable -> L12
        if (enabled == false) goto L7;
        int newFlags = curFlags | flag;     // Catch: Throwable -> L12
    L8:
        if (curFlags == newFlags) goto L16;
        Pair<Integer, String> packageKey = Pair.create(Integer.valueOf(userId), name);     // Catch: Throwable -> L12
        if (newFlags == 0) goto L14;
        this.mPackageFlags.put(packageKey, Integer.valueOf(newFlags));     // Catch: Throwable -> L12
    L15:
        this.mWriteConfigTask.schedule();     // Catch: Throwable -> L12
        goto L16
    L14:
        this.mPackageFlags.remove(packageKey);     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        newFlags = (~flag) & curFlags;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private int getPackageFlags(int userId, String packageName) {
        ArrayMap<Pair<Integer, String>, Integer> r0 = this.mPackageFlags;
        monitor-enter(r0);
        Pair<Integer, String> packageKey = Pair.create(Integer.valueOf(userId), packageName);     // Catch: Throwable -> L7
        int r2 = this.mPackageFlags.getOrDefault(packageKey, 0).intValue();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearAllPackageFlagsForUser(int userId) {
        ArrayMap<Pair<Integer, String>, Integer> r0 = this.mPackageFlags;
        monitor-enter(r0);
        boolean hasPackageFlagsForUser = false;
        int i = this.mPackageFlags.size() - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L14;
        Pair<Integer, String> key = this.mPackageFlags.keyAt(i);     // Catch: Throwable -> L10
        if (((Integer) key.first).intValue() != userId) goto L12;
        hasPackageFlagsForUser = true;
        this.mPackageFlags.remove(key);     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        if (hasPackageFlagsForUser == false) goto L16;
        this.mWriteConfigTask.schedule();     // Catch: Throwable -> L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int getUserIdForActivity(ActivityRecord ar) {
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L7;
        return 0;
    L7:
        if (ar.mUserId != 0) goto L11;
        return getUserAssignedToDisplay(ar.mDisplayContent.getDisplayId());
    L11:
        return this.mUserManagerInternal.getProfileParentId(ar.mUserId);
    }

    private Context getUiContextForActivity(ActivityRecord ar) {
        if (UserManager.isVisibleBackgroundUsersEnabled() == false) goto L5;
        DisplayContent dc = ar.mDisplayContent;
        Context systemUiContext = dc.getDisplayPolicy().getSystemUiContext();
        int assignedUser = getUserAssignedToDisplay(dc.getDisplayId());
        Context uiContextForUser = systemUiContext.createContextAsUser(new UserHandle(assignedUser), 0);
        return uiContextForUser;
    L5:
        if (UserManager.isHeadlessSystemUserMode() == false) goto L7;
        Context uiContextForCurrentUser = this.mAtm.getUiContext().createContextAsUser(new UserHandle(this.mAtm.getCurrentUserId()), 0);
        return uiContextForCurrentUser;
    L7:
        return this.mAtm.getUiContext();
    }

    private int getUserAssignedToDisplay(int displayId) {
        return this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
    }

    private void writeConfigToFile(ArrayMap<Pair<Integer, String>, Integer> packageFlags) {
        FileOutputStream fos = null;
        fos = this.mConfigFile.startWrite();     // Catch: IOException -> L11
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L11
        out.startDocument(null, true);     // Catch: IOException -> L11
        out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: IOException -> L11
        out.startTag(null, "packages");     // Catch: IOException -> L11
        int i = 0;
    L5:
        if (i >= packageFlags.size()) goto L13;
        Pair<Integer, String> key = packageFlags.keyAt(i);     // Catch: IOException -> L11
        int userId = ((Integer) key.first).intValue();     // Catch: IOException -> L11
        String packageName = (String) key.second;     // Catch: IOException -> L11
        int mode = packageFlags.valueAt(i).intValue();     // Catch: IOException -> L11
        if (mode == 0) goto L10;
        out.startTag(null, Settings.ATTR_PACKAGE);     // Catch: IOException -> L11
        out.attributeInt(null, "user", userId);     // Catch: IOException -> L11
        out.attribute(null, "name", packageName);     // Catch: IOException -> L11
        out.attributeInt(null, "flags", mode);     // Catch: IOException -> L11
        out.endTag(null, Settings.ATTR_PACKAGE);     // Catch: IOException -> L11
    L10:
        i = i + 1;     // Catch: IOException -> L11
        goto L5
    L13:
        out.endTag(null, "packages");     // Catch: IOException -> L11
        out.endDocument();     // Catch: IOException -> L11
        this.mConfigFile.finishWrite(fos);     // Catch: IOException -> L11
        return;
    L11:
        e1 = move-exception;
        Slog.w(TAG, "Error writing package metadata", e1);
        if (fos == null) goto L24;
        this.mConfigFile.failWrite(fos);
        return;
    }

    private void readConfigFromFileAmsThread() {
        FileInputStream fis = null;
    L12:
        th = move-exception;
        Throwable r2 = th;
    L97:
        if (fis == null) goto L129;
        fis.close();     // Catch: IOException -> L100
        throw r2;
    L101:
        throw r2;
    L129:
        throw r2;
    L14:
        e = e;
    L84:
        if (fis == null) goto L86;
        Slog.w(TAG, "Error reading package metadata", e);     // Catch: Throwable -> L12
    L86:
        if (fis == null) goto L126;
        fis.close();     // Catch: IOException -> L89
    L109:
        return;
    L126:
        return;
    L16:
        e = e;
    L92:
        Slog.w(TAG, "Error reading package metadata", e);     // Catch: Throwable -> L12
        if (fis == null) goto L127;
        fis.close();     // Catch: IOException -> L89
        goto L109
    L127:
        return;
    L4:
        fis = this.mConfigFile.openRead();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        int r0 = parser.getEventType();     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
    L7:
        int eventType = r0;
        int r1 = 2;
        if (eventType == 2) goto L18;
        if (eventType == 1) goto L18;
        r0 = parser.next();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
    L18:
        if (eventType != 1) goto L24;
        if (fis == null) goto L123;
        fis.close();     // Catch: IOException -> L22
        return;
    L23:
        return;
    L123:
        return;
    L24:
        String tagName = parser.getName();     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        if ("packages".equals(tagName) == false) goto L76;
        int eventType2 = parser.next();     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        int eventType3 = 0;
    L27:
        if (eventType2 != r1) goto L69;
        String tagName2 = parser.getName();     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        if (parser.getDepth() == r1) goto L31;
        FileInputStream fis2 = fis;
    L113:
        eventType2 = parser.next();     // Catch: Throwable -> L52 IOException -> L54 XmlPullParserException -> L56
        if (eventType2 == 1) goto L72;
        fis = fis2;
        r1 = 2;
        goto L27
    L72:
        if (eventType3 == 0) goto L77;
        this.mWriteConfigTask.schedule();     // Catch: Throwable -> L52 IOException -> L54 XmlPullParserException -> L56
    L77:
        if (fis2 == null) goto L125;
        fis2.close();     // Catch: IOException -> L80
    L125:
        return;
    L54:
        e = e;
        fis = fis2;
    L56:
        e = e;
        fis = fis2;
    L52:
        th = move-exception;
        r2 = th;
        fis = fis2;
        goto L97
    L31:
        if (Settings.ATTR_PACKAGE.equals(tagName2) == false) goto L67;
        int userId = parser.getAttributeInt(null, "user", ProcessList.INVALID_ADJ);     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        String name = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        if (name == null) goto L66;
        int r15 = 0;
        int flagsInt = parser.getAttributeInt(null, "flags", 0);     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        if (userId == (-10000)) goto L38;
        Pair<Integer, String> packageKey = Pair.create(Integer.valueOf(userId), name);     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        this.mPackageFlags.put(packageKey, Integer.valueOf(flagsInt));     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        fis2 = fis;
        goto L113
    L38:
        eventType3 = 1;
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L43;
        Pair<Integer, String> packageKey2 = Pair.create(0, name);     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        this.mPackageFlags.put(packageKey2, Integer.valueOf(flagsInt));     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        fis2 = fis;
        goto L113
    L43:
        UserInfo[] users = this.mUserManagerInternal.getUserInfos();     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        int r14 = users.length;     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
    L44:
        if (r15 >= r14) goto L64;
        UserInfo userInfo = users[r15];     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        if (userInfo.isFull() == false) goto L51;
        Pair<Integer, String> packageKey3 = Pair.create(Integer.valueOf(userInfo.id), name);     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
        ArrayMap<Pair<Integer, String>, Integer> r3 = this.mPackageFlags;     // Catch: Throwable -> L58 IOException -> L60 XmlPullParserException -> L62
    L50:
        r3.put(packageKey3, Integer.valueOf(flagsInt));     // Catch: Throwable -> L52 IOException -> L54 XmlPullParserException -> L56
    L51:
        r15 = r15 + 1;     // Catch: Throwable -> L52 IOException -> L54 XmlPullParserException -> L56
        fis = fis;
        goto L44
    L64:
        fis2 = fis;
        goto L113
    L66:
        fis2 = fis;
        goto L113
    L67:
        fis2 = fis;
        goto L113
    L69:
        fis2 = fis;
        goto L113
    L76:
        fis2 = fis;
    L60:
        e = e;
    L62:
        e = e;
    L58:
        th = move-exception;
        r2 = th;
    }
}
