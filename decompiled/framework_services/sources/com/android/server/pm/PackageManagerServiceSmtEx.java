package com.android.server.pm;

import android.R;
import android.app.AlertDialog;
import android.app.AppGlobals;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.IPackageManagerSmtEx;
import android.content.pm.PackageManagerInternalSmtEx;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import com.android.server.am.IProcessIntercept;
import com.android.server.notification.NotificationShellCmd;
import com.android.server.pm.permission.ObricPermissionCheckHelper;
import com.obric.oui.framework.material.MaterialConfigCore;
import com.obric.oui.framework.material.MaterialTokenCore;
import com.obric.oui.framework.material.OMaterialHelperCore;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceSmtEx extends PackageManagerServiceSmtBase {
    private static final String ACTION_BOOM_LIST_CHANGED = "textboom_app_ocr_status_changed_intent";
    protected static final String ACTION_PREFERRED_ACTIVITY_CLEAR = "android.intent.action.smt.ACTION_PREFERRED_ACTIVITY_CLEAR";
    private static final String ACTION_SYNC_DATA_FINISH = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH";
    private static final String ACTION_SYNC_DATA_FINISH_FEED_BACK = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK";
    protected static final String ADB_INSTALL_DEBUGGABLE_KEY = "persist.sys.install_debuggable";
    private static final float ADB_INSTALL_DIALOG_CORNER_RADIUS_DP = 36.0f;
    static final int ADB_INSTALL_NEW_PACKAGE = 1025;
    private static final String ADB_INSTALL_SETTING_KEY = "persist.sys.adb_install";
    protected static final String PERMISSION_PREFERRED_ACTIVITY = "com.android.permission.smt.PREFERRED_ACTIVITY";
    private static final String PKG_LAUNCHER_3 = "com.android.launcher3";
    private static final String PKG_POWERSAVE_LAUNCHER = "com.bytedanceos.powersaving.launcher";
    private static final String PKG_SMT_LAUNCHER = "com.bytedanceos.launcher";
    protected static final String PREFERRED_MIMETYPE_LIST = "preferred_mimetype_list";
    protected static final String PREFERRED_PKG = "package";
    private static final String SM_READ_SYNC_DATA_URI = "content://com.bytedanceos.datasync/sync_datas";
    private static final String SYNC_TASK_APPSTORE_RECOMMEND_LIST = "appstore_recommend_list";
    private static final BroadcastReceiver mSyncFinishReceiver = null;
    private static final String sAppStoreRecommendListData = "{\"body\":{\"3gp\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"avi\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"flv\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"mkv\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"mp4\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"mov\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"wmv\":[\"com.mxtech.videoplayer.ad\",\"com.moliplayer.android\",\"com.tencent.research.drop\"],\"xls\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"xlsx\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"ppt\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"pptx\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"doc\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"docx\":[\"cn.wps.moffice_eng\",\"com.mobisystems.office\",\"com.infraware.office.link\"],\"pdf\":[\"com.Foxit.Mobile.PDF\",\"cn.wps.moffice_eng\"],\"rar\":[\"com.estrongs.android.pop\",\"xcxin.filexpert\"],\"zip\":[\"com.estrongs.android.pop\",\"xcxin.filexpert\"],\"x-gzip\":[\"com.estrongs.android.pop\",\"xcxin.filexpert\"],\"geo\":[\"com.autonavi.minimap\",\"com.baidu.BaiduMap\",\"com.tencent.map\"]},\"head\":{\"code\":0,\"message\":\"\"}}";
    private static final String sAppStoreRecommendListFileName = "appstore_recommended_apps.json";
    private static final String sAppStoreRecommendListFilePath = "/data/system/appstore_recommended_apps.json";
    private static final HashMap<String, List<String>> sAppStoreRecommendPackageMap = null;
    protected boolean mAdbInstallDebuggable;
    private AlertDialog mAdbInstallDialog;
    protected String mAdbInstallSetting;
    private IPackageManagerSmtEx mIPackageManagerSmtEx;
    private boolean mIsAdbInstallWarning;
    final ArrayList<InstallingSession> mPendingAdbInstalls;
    ComponentName mSearchPackageComponentName;
    ResolveInfo mSearchPackageInfo;

    protected class IPackageManagerSmtExImpl extends IPackageManagerSmtExBase {
        final /* synthetic */ PackageManagerServiceSmtEx this$0;

        protected IPackageManagerSmtExImpl(PackageManagerServiceSmtEx this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public Map getChosenActivities(int userId) {
            return this.this$0.getChosenActivities(userId);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public int getPackageActiveState(String packageName, int userId) {
            return this.this$0.getPackageActiveState(packageName, userId);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public void setTaskPersist(String packageName, boolean enable, int userId) {
            this.this$0.setTaskPersist(packageName, enable, userId);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public void clearPreferredActivities(Intent intent) {
            this.this$0.clearPreferredActivities(intent);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public int getAlwaysPreferredActivities(List<IntentFilter> outFilters, List<ComponentName> outActivities, String packageName) {
            return this.this$0.getAlwaysPreferredActivities(outFilters, outActivities, packageName);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public void updateChosenActivities(String componentName, int code, int userId) {
            this.this$0.updateChosenActivities(componentName, code, userId);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public boolean isTaskPersistUid(int uid, int userId) {
            return this.this$0.isTaskPersistUid(uid, userId);
        }

        @Override // com.android.server.pm.IPackageManagerSmtExBase
        public void setPackageActiveState(String packageName, boolean active, int userId) {
            this.this$0.setPackageActiveState(packageName, active, userId);
        }
    }

    protected class PackageManagerInternalImplSmtEx extends PackageManagerInternalSmtEx {
        final /* synthetic */ PackageManagerServiceSmtEx this$0;

        protected PackageManagerInternalImplSmtEx(PackageManagerServiceSmtEx this$0) {
            this.this$0 = this$0;
        }

        public boolean isPackageLocked(String packageName, int userId) {
            return this.this$0.isPackageLocked(packageName, userId);
        }
    }

    public static /* synthetic */ void $r8$lambda$ILujpKcJCGrTXWZFsCXWPtlyacM(PackageManagerServiceSmtEx r0, DialogInterface r1) {
        r0.lambda$showAdbConfirmDlg$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$Lpo2hJp_WY2oZr6YNExyCXUC5GI(PackageManagerServiceSmtEx r0, ArrayList r1, DialogInterface r2, int r3) {
        r0.lambda$showAdbConfirmDlg$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$geZTEgJXOdkO033gqca7bxE8cmc(PackageManagerServiceSmtEx r0, ArrayList r1, DialogInterface r2, int r3) {
        r0.lambda$showAdbConfirmDlg$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smquerySyncDataByTaskName, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pair m6869$$Nest$smquerySyncDataByTaskName(Context r0, String r1) {
        return querySyncDataByTaskName(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smsaveToStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6870$$Nest$smsaveToStorage(String r0, byte[] r1) {
        return saveToStorage(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateAppStoreRecommendPackageData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6871$$Nest$smupdateAppStoreRecommendPackageData(String r0) {
        updateAppStoreRecommendPackageData(r0);
    }

    protected PackageManagerServiceSmtEx(PackageManagerService pmService, PackageManagerServiceMonitorEx pmServiceMonitorEx, DexOptHelper dexOptHelper) {
        super(pmService, pmServiceMonitorEx, dexOptHelper);
        this.mPendingAdbInstalls = new ArrayList();
        this.mIsAdbInstallWarning = false;
        this.mAdbInstallSetting = null;
        this.mAdbInstallDebuggable = false;
        this.mIPackageManagerSmtEx = new IPackageManagerSmtExImpl(this);
    }

    public int getUserOrietationAsUser(String packageName, String userOrientationActivity, int userId) {
        return -1;
    }

    public boolean setUserOrientationAsUser(String packageName, int userOrientation, String userOrientationActivity, int userId) {
        return false;
    }

    public void clearUserOrientationAsUser(int userId) {
    }

    static ResolveInfo getChooseBestResolveInfo(int userId, ResolveInfo resolveInfo) {
        if (userId == 0) goto L5;
        ResolveInfo ri = new ResolveInfo(resolveInfo);
        ri.activityInfo = new ActivityInfo(ri.activityInfo);
        ActivityInfo r1 = ri.activityInfo;
        r1.applicationInfo = new ApplicationInfo(ri.activityInfo.applicationInfo);
        ApplicationInfo r2 = ri.activityInfo.applicationInfo;
        r2.uid = UserHandle.getUid(userId, UserHandle.getAppId(ri.activityInfo.applicationInfo.uid));
        return ri;
    L5:
        return null;
    }

    public void unlockAllPackages(int userId) {
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "unlock package");
        PackageManagerTracedLock r8 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        int size = this.mPmService.mSettings.getSmtEx().mAllLockedPackages.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L9;
        int user = this.mPmService.mSettings.getSmtEx().mAllLockedPackages.keyAt(i);     // Catch: Throwable -> L7
        this.mPmService.mSettings.getSmtEx().unlockAllPackagesLPw(user);     // Catch: Throwable -> L7
        this.mPmService.scheduleWritePackageRestrictions(user);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        reportUnlockedPackageChanged(null);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public HashMap<String, Integer> getChosenActivities(int userId) {
        if (ObricPermissionCheckHelper.isSystemApp(this.mPmService.mContext, Binder.getCallingUid()) == false) goto L7;
        return this.mPmService.mSettings.getSmtEx().editChosenActivitiesLPw(userId);
    L7:
        throw new SecurityException("getChosenActivities is not allowed");
    }

    private void reportUnlockedPackageChanged(String packages) {
        final Intent it = new Intent("android.content.pm.action.sm_PACKAGE_LOCKED");
        it.putExtra("android.content.pm.action.sm_PACKAGES", packages);
        it.addFlags(128);
        this.mPmService.mHandler.post(new AnonymousClass1(this, it));
    }

    public void setPackageActiveState(String packageName, boolean active, int userId) {
        if (this.mPmService.mUserManager.exists(userId) == true) goto L5;
        return;
    L5:
        int uid = Binder.getCallingUid();
        int permission = this.mPmService.mContext.checkCallingOrSelfPermission("android.permission.CHANGE_COMPONENT_ENABLED_STATE");
        if (permission != 0) goto L9;
        boolean r0 = true;
    L8:
        boolean allowedByPermission = r0;
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(uid, userId, true, false, "stop package");
        PackageManagerTracedLock r9 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        if (this.mPmService.mSettings.getSmtEx().setPackageActiveStateLPw(this.mPmService, packageName, active, allowedByPermission, uid, userId) == false) goto L22;
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L20
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L25:
        th = move-exception;
        Throwable r11 = th;
    L31:
        monitor-exit(r9);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r11;
    L27:
        th = move-exception;
        r11 = th;
    L20:
        th = move-exception;
        r11 = th;
    L29:
        th = move-exception;
        r11 = th;
        goto L31
    L9:
        r0 = false;
        goto L8
    }

    public int getPackageActiveState(String packageName, int userId) {
        UserManagerService userManagerService = this.mPmService.mUserManager;
        if (userManagerService.exists(userId) == true) goto L6;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "user not exist for " + userId);
        return 0;
    L6:
        Binder.getCallingUid();
        PackageManagerTracedLock r2 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        int r3 = this.mPmService.mSettings.getSmtEx().getPackageActiveStateLPw(packageName, userId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean hasLockedPackages(int userId) {
        return this.mPmService.mSettings.getSmtEx().hasLockedPackages(userId);
    }

    public void setTaskPersist(String packageName, boolean enable, int userId) {
        if (packageName != null) goto L4;
        return;
    L4:
        int callingUid = Binder.getCallingUid();
        if (ObricPermissionCheckHelper.isSystemApp(this.mPmService.mContext, callingUid) == true) goto L8;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "setTaskPersist, uid not system app");
        return;
    L8:
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "persist task");
        ApplicationInfo app = this.mPmService.snapshotComputer().getApplicationInfo(packageName, 0, userId);
        int uid = -1;
        if (app == null) goto L11;
        uid = app.uid;
    L11:
        int uid2 = uid;
        PackageManagerTracedLock r5 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        TaskPersistUtil.getInstance().setTaskPersist(packageName, enable, userId, uid2);     // Catch: Throwable -> L17
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void clearPreferredActivities(Intent intent) {
        int callingUserId = UserHandle.getCallingUserId();
        if (ObricPermissionCheckHelper.isSystemApp(this.mPmService.mContext, Binder.getCallingUid()) == false) goto L45;
        PackageManagerTracedLock r6 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        PreferredIntentResolver pir = this.mPmService.mSettings.mPreferredActivities.get(callingUserId);     // Catch: Throwable -> L35
        if (pir == null) goto L38;
        List<R> r13 = pir.queryIntent(this.mPmService.snapshotComputer(), intent, intent.getType(), true, callingUserId);     // Catch: Throwable -> L33
        if (r13 == 0) goto L38;
        if (r13.size() <= 0) goto L38;
        List<ResolveInfo> query = this.mPmService.snapshotComputer().queryIntentActivitiesInternal(intent, intent.resolveTypeIfNeeded(this.mPmService.mContext.getContentResolver()), 65600, callingUserId);     // Catch: Throwable -> L20
        int match = 0;
        int N = query.size();     // Catch: Throwable -> L20
        int j = 0;
    L16:
        if (j >= N) goto L23;
        ResolveInfo ri = query.get(j);     // Catch: Throwable -> L20
        if (ri.match <= match) goto L22;
        match = ri.match;     // Catch: Throwable -> L20
    L22:
        j = j + 1;     // Catch: Throwable -> L20
        goto L16
    L23:
        int match2 = match & 268369920;     // Catch: Throwable -> L20
        int M = r13.size();     // Catch: Throwable -> L20
        boolean changed = false;
        int i = 0;
    L24:
        if (i >= M) goto L31;
        PreferredActivity pa = (PreferredActivity) r13.get(i);     // Catch: Throwable -> L20
        if (pa.mPref.mMatch != match2) goto L29;
        pir.removeFilter(pa);     // Catch: Throwable -> L20
        changed = true;
    L29:
        i = i + 1;     // Catch: Throwable -> L20
        goto L24
    L31:
        if (changed == false) goto L38;
        this.mPmService.scheduleWritePackageRestrictions(callingUserId);     // Catch: Throwable -> L20
    L33:
        th = move-exception;
        Throwable r14 = th;
    L41:
        monitor-exit(r6);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r14;
    L38:
        monitor-exit(r6);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L20:
        th = move-exception;
        r14 = th;
    L35:
        th = move-exception;
        r14 = th;
        goto L41
    L45:
        throw new SecurityException("clearPreferredActivities is not allowed");
    }

    public void unlockPackage(String packageName, int userId) {
        if (packageName != null) goto L4;
        return;
    L4:
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "unlock package");
        PackageManagerTracedLock r9 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        String[] packages = packageName.split(";");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= packages.length) goto L12;
        this.mPmService.mSettings.getSmtEx().unlockPackageLPw(packages[i], userId);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L10
        reportUnlockedPackageChanged(packageName);     // Catch: Throwable -> L10
        monitor-exit(r9);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void sessionUnlockPackageLPw(String packageName, int userId) {
        if (packageName != null) goto L4;
        return;
    L4:
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "session unlock package");
        PackageManagerTracedLock r9 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        String[] packages = packageName.split(";");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= packages.length) goto L12;
        this.mPmService.mSettings.getSmtEx().sessionUnlockPackageLPw(packageName, userId);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L10
        reportLockedPackageChanged(packageName);     // Catch: Throwable -> L10
        monitor-exit(r9);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void reportLockedPackageChanged(String packages) {
        final Intent it = new Intent("android.content.pm.action.sm_PACKAGE_LOCKED");
        it.putExtra("android.content.pm.action.sm_PACKAGES", packages);
        it.addFlags(128);
        this.mPmService.mHandler.post(new AnonymousClass2(this, it));
    }

    public int getAlwaysPreferredActivities(List<IntentFilter> outFilters, List<ComponentName> outActivities, String packageName) {
        int userId = UserHandle.getCallingUserId();
        if (ObricPermissionCheckHelper.isSystemApp(this.mPmService.mContext, Binder.getCallingUid()) == false) goto L32;
        PackageManagerTracedLock r2 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        PreferredIntentResolver pir = this.mPmService.mSettings.mPreferredActivities.get(userId);     // Catch: Throwable -> L16
        if (pir == null) goto L25;
        Iterator<F> r4 = pir.filterIterator();     // Catch: Throwable -> L16
    L10:
        if (r4.hasNext() == false) goto L25;
        PreferredActivity pa = (PreferredActivity) r4.next();     // Catch: Throwable -> L16
        if (packageName == null) goto L19;
        if (pa.mPref.mComponent.getPackageName().equals(packageName) == false) goto L10;
    L19:
        if (pa.mPref.mAlways == false) goto L10;
        if (outFilters == null) goto L22;
        outFilters.add(new IntentFilter(pa.mFilter));     // Catch: Throwable -> L16
    L22:
        if (outActivities == null) goto L10;
        outActivities.add(pa.mPref.mComponent);     // Catch: Throwable -> L16
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L32:
        throw new SecurityException("getAlwaysPreferredActivities is not allowed");
    }

    public boolean isPackageLocked(String packageName, int userId) {
        PackageManagerTracedLock r0 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mPmService.mSettings.getSmtEx().isPackageLockedLPw(packageName, userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void updateChosenActivities(String componentName, int code, int userId) {
        int callingUid = Binder.getCallingUid();
        if (ObricPermissionCheckHelper.isSystemApp(this.mPmService.mContext, callingUid) == false) goto L7;
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "add chosen activity");
        this.mPmService.mSettings.getSmtEx().updateChosenActivities(componentName, code, userId);
        this.mPmService.scheduleWritePackageRestrictions(userId);
        return;
    L7:
        throw new SecurityException("updateChosenActivities is not allowed");
    }

    public void lockPackage(String packageName, int userId) {
        if (packageName != null) goto L4;
        return;
    L4:
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "lock package");
        PackageManagerTracedLock r9 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        String[] packages = packageName.split(";");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= packages.length) goto L12;
        this.mPmService.mSettings.getSmtEx().lockPackageLPw(packages[i], userId);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L10
        reportUnlockedPackageChanged(packageName);     // Catch: Throwable -> L10
        monitor-exit(r9);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean isPackageAlreadyLocked(String packageName, int userId) {
        PackageManagerTracedLock r0 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mPmService.mSettings.getSmtEx().isPackageAlreadyLockedLPw(packageName, userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void sessionUnlockAllPackages(int userId) {
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "session unlock all package");
        PackageManagerTracedLock r8 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        int size = this.mPmService.mSettings.getSmtEx().mAllLockedPackages.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L9;
        int user = this.mPmService.mSettings.getSmtEx().mAllLockedPackages.keyAt(i);     // Catch: Throwable -> L7
        this.mPmService.mSettings.getSmtEx().sessionUnlockAllPackagesLPw(user);     // Catch: Throwable -> L7
        this.mPmService.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        reportUnlockedPackageChanged(null);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void clearSessionUnlockPackages(int userId) {
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "clear session unlocked package");
        StringBuilder sb = new StringBuilder();
        PackageManagerTracedLock r5 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        HashSet<String> packages = this.mPmService.mSettings.getSmtEx().getSessionUnlockedPackagesLPw();     // Catch: Throwable -> L12
        this.mPmService.mSettings.getSmtEx().clearSessionUnlockPackageLPw();     // Catch: Throwable -> L12
        if (packages != null) goto L7;
    L14:
        this.mPmService.mSettings.getSmtEx().clearSessionUnlockPackageLPw();     // Catch: Throwable -> L12
        reportLockedPackageChanged(sb.toString());     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        if (packages.isEmpty() == true) goto L14;
        Iterator<String> r0 = packages.iterator();     // Catch: Throwable -> L12
    L10:
        if (r0.hasNext() == false) goto L14;
        String s = r0.next();     // Catch: Throwable -> L12
        sb.append(s);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean isTaskPersistUid(int uid, int userId) {
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "persist task");
        return TaskPersistUtil.getInstance().isTaskPersistUid(uid);
    }

    public boolean isCustomizedStatusBarEnable(String packageName) {
        return isCustomizedStatusBarEnableInternal(packageName, 0);
    }

    private boolean isCustomizedStatusBarEnableInternal(String packageName, int userId) {
        if (packageName != null) goto L5;
        return false;
    L5:
        return false;
    }

    public void postPreferredActivityClearBroadcast(ArrayList<PreferredActivity> removed, String packageName) {
        if (packageName == null) goto L15;
        ArrayList<String> mimeTypeList = new ArrayList();
        int i = 0;
    L5:
        if (i >= removed.size()) goto L10;
        PreferredActivity pa = removed.get(i);
        if (pa.countDataTypes() <= 0) goto L9;
        mimeTypeList.add(pa.getDataType(0));
    L9:
        i = i + 1;
        goto L5
    L10:
        final Intent intent = new Intent(ACTION_PREFERRED_ACTIVITY_CLEAR);
        intent.putExtra("package", packageName);
        intent.putStringArrayListExtra(PREFERRED_MIMETYPE_LIST, mimeTypeList);
        Slog.i(PackageManagerServiceMonitorEx.TAG, "PreferredMimeTypeList pkg " + packageName + " mimetype list " + mimeTypeList);
        this.mPmService.mHandler.post(new AnonymousClass3(this, intent));
        return;
    }

    void findPreferredActivityChangeSendBroadcast(String packageName, int userId, PreferredActivity pa) {
        if (pa != null) goto L5;
        return;
    L5:
        if (pa.hasCategory("android.intent.category.HOME") == true) goto L7;
        return;
    L7:
        if (pa.hasCategory("android.intent.category.DEFAULT") == true) goto L9;
        return;
    L9:
        if (pa.hasAction("android.intent.action.MAIN") == true) goto L11;
        return;
    L11:
        if (packageName != null) goto L18;
        if (pa.mPref.mComponent == null) goto L15;
        String r1 = pa.mPref.mComponent.getPackageName();
    L16:
        packageName = r1;
        goto L18
    L15:
        r1 = null;
    L18:
        if (PKG_SMT_LAUNCHER.equals(packageName) == false) goto L20;
        return;
    L20:
        if (PKG_LAUNCHER_3.equals(packageName) == true) goto L27;
        sendLauncherChangedBroadcast(null, userId);
        return;
    }

    void checkAddPreferredActivitySendBroadcast(IntentFilter filter, ComponentName activity, boolean always, int userId) {
        if (always == true) goto L4;
        return;
    L4:
        if (filter.hasCategory("android.intent.category.HOME") == true) goto L6;
        return;
    L6:
        if (filter.hasCategory("android.intent.category.DEFAULT") == true) goto L8;
        return;
    L8:
        if (filter.hasAction("android.intent.action.MAIN") == false) goto L14;
        sendLauncherChangedBroadcast(activity, userId);
        return;
    }

    void sendLauncherChangedBroadcast(final ComponentName cn, final int userId) {
        this.mPmService.mHandler.post(new AnonymousClass4(this, cn, userId));
    }

    private boolean isPowerSaveMode() {
        PowerManager pm = (PowerManager) this.mPmService.mContext.getSystemService("power");
        return pm.getSmtEx().isFeaturePhoneMode();
    }

    ResolveInfo getResolveInfo(Intent intent, List<ResolveInfo> query) {
        if (intent.hasCategory("android.intent.category.HOME") == true) goto L5;
        return null;
    L5:
        if ("android.intent.action.MAIN".equals(intent.getAction()) == false) goto L51;
        boolean deviceProvisioned = false;
        if (android.provider.Settings.Global.getInt(this.mPmService.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L9;
        deviceProvisioned = true;
    L9:
        boolean isPowerSaveMode = isPowerSaveMode();
        boolean found = false;
        ResolveInfo ri = null;
        Iterator<ResolveInfo> r4 = query.iterator();
    L11:
        if (r4.hasNext() == false) goto L31;
        ResolveInfo info = r4.next();
        if (info.activityInfo.isEnabled() == false) goto L11;
        String pkgName = info.activityInfo.applicationInfo.packageName;
        if (deviceProvisioned == false) goto L17;
        if (isPowerSaveMode == false) goto L24;
        if (PKG_POWERSAVE_LAUNCHER.equals(pkgName) == false) goto L24;
        found = true;
        ri = info;
    L24:
        if (PKG_SMT_LAUNCHER.equals(pkgName) == true) goto L27;
        if (PKG_LAUNCHER_3.equals(pkgName) == false) goto L11;
    L27:
        found = true;
        ri = info;
        if (isPowerSaveMode == true) goto L11;
    L17:
        if ("com.bytedanceos.setupwizard".equals(pkgName) == false) goto L11;
        found = true;
        ri = info;
    L31:
        if (found == false) goto L33;
        return ri;
    L33:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "find preferred failed for " + intent);
        return null;
    L51:
        return null;
    }

    protected void handlePackageHandlerMessage(Message msg) {
        switch(msg.what) {
            case 1025: goto L6;
            default: goto L4;
        };
    L4:
        handleMessageSmt(msg);
        return;
    L6:
        if (msg.obj == null) goto L9;
        InstallingSession params = (InstallingSession) msg.obj;
        int idx = this.mPendingAdbInstalls.size();
        this.mPendingAdbInstalls.add(idx, params);
    L9:
        if (this.mIsAdbInstallWarning == false) goto L11;
        return;
    L11:
        if (0 != 0) goto L17;
        ArrayList<InstallingSession> list = new ArrayList();
        int i = 0;
    L14:
        if (i >= this.mPendingAdbInstalls.size()) goto L16;
        list.add(this.mPendingAdbInstalls.get(i));
        i = i + 1;
        goto L14
    L16:
        showAdbConfirmDlg(list);
    L17:
        this.mPendingAdbInstalls.clear();
    }

    protected boolean warningFromAdb() {
        return SystemProperties.getBoolean(ADB_INSTALL_SETTING_KEY, true);
    }

    protected void showAdbConfirmDlg(final ArrayList<InstallingSession> installList) {
        if (installList.size() != 1) goto L9;
        InstallingSession params = installList.get(0);
        if (params.getExt().getLabel() == null) goto L7;
        String appName = params.getExt().getLabel().toString();
    L8:
        CharSequence message = this.mPmService.mContext.getString(R.string.lockscreen_failed_attempts_now_wiping, new Object[]{appName});
    L20:
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mPmService.mContext).setView(R.layout.side_fps_toast).setTitle(R.string.lockscreen_forgot_pattern_button_text).setMessage(message).setCancelable(false).setOnDismissListener(new PackageManagerServiceSmtEx$$ExternalSyntheticLambda0(this)).setPositiveButton(R.string.app_category_game, new PackageManagerServiceSmtEx$$ExternalSyntheticLambda1(this, installList)).setNegativeButton(R.string.emailTypeCustom, new PackageManagerServiceSmtEx$$ExternalSyntheticLambda2(this, installList));
        this.mAdbInstallDialog = builder.create();
        Window w = this.mAdbInstallDialog.getWindow();
        w.setType(NotificationShellCmd.NOTIFICATION_ID);
        w.addFlags(2097152);
        w.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams attrs = w.getAttributes();
        attrs.token = null;
        attrs.setTitle("AdbInstall");
        attrs.gravity = 80;
        attrs.flags |= 512;
        attrs.y = this.mPmService.mContext.getResources().getDimensionPixelOffset(R.dimen.keyguard_avatar_name_size);
        attrs.setFitInsetsSides(0);
        w.setAttributes(attrs);
        this.mAdbInstallDialog.show();
        applyAdbInstallDialogMaterial(this.mAdbInstallDialog);
        this.mIsAdbInstallWarning = true;
        return;
    L7:
        appName = "";
        goto L8
    L9:
        StringBuilder sb = new StringBuilder();
        sb.append(this.mPmService.mContext.getString(R.string.lockscreen_failed_attempts_almost_glogin));
        sb.append("\n");
        int N = installList.size();
        int i = 0;
    L10:
        if (i >= N) goto L15;
        sb.append("[:ic:]");
        InstallingSession param = installList.get(i);
        sb.append(param.getExt().getLabel());
        if (i >= (N - 1)) goto L14;
        sb.append("\n");
    L14:
        i = i + 1;
        goto L10
    L15:
        SpannableStringBuilder ssb = new SpannableStringBuilder(sb.toString());
        Pattern pattern = Pattern.compile("\\[\\:ic\\:\\]*");
        Matcher matcher = pattern.matcher(sb.toString());
    L17:
        if (matcher.find() == false) goto L19;
        ssb.setSpan(new ImageSpan(this.mPmService.mContext, R.drawable.ic_popup_sync_2, 1), matcher.start(), matcher.end(), 33);
        goto L17
    L19:
        message = ssb;
        goto L20
    }

    private /* synthetic */ void lambda$showAdbConfirmDlg$0(DialogInterface dialog) {
        this.mIsAdbInstallWarning = false;
        if (this.mPendingAdbInstalls.size() > 0) goto L5;
        return;
    L5:
        if (this.mPmService.mHandler.hasMessages(1025) == true) goto L9;
        this.mPmService.mHandler.sendEmptyMessage(1025);
        return;
    }

    private /* synthetic */ void lambda$showAdbConfirmDlg$1(ArrayList installList, DialogInterface dialog, int which) {
        this.mAdbInstallDialog.dismiss();
        Iterator r0 = installList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        InstallingSession params = (InstallingSession) r0.next();
        params.installStage();
        goto L4
    }

    private /* synthetic */ void lambda$showAdbConfirmDlg$2(ArrayList installList, DialogInterface dialog, int which) {
        this.mAdbInstallDialog.dismiss();
        Iterator r0 = installList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        InstallingSession params = (InstallingSession) r0.next();
        if (params.mObserver == null) goto L4;
        params.mObserver.onPackageInstalled("", IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SYNCADAPTER_OR_NOTILISTENER, null, null);     // Catch: RemoteException -> L9
        goto L4
    }

    private void applyAdbInstallDialogMaterial(AlertDialog dialog) {
        Slog.i(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: start");
        if (dialog != null) goto L6;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing dialog");
        return;
    L6:
        Window window = dialog.getWindow();
        if (window != null) goto L10;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing window");
        return;
    L10:
        View decorView = window.getDecorView();
        if (decorView != null) goto L14;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing decorView");
        return;
    L14:
        View materialSurface = findAdbInstallDialogMaterialSurface(decorView);
        if (materialSurface != null) goto L18;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing material surface");
        return;
    L18:
        Context context = materialSurface.getContext();
        if (context != null) goto L23;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing material surface context");
        return;
    L23:
        if (OMaterialHelperCore.isObricMaterialEnabled(context, "AdbInstallDialog") == true) goto L37;
        return;
    L37:
        boolean isLight = OMaterialHelperCore.isLightMode(context);     // Catch: RuntimeException -> L31
        MaterialConfigCore[] materials = copyModalMaterials(isLight);     // Catch: RuntimeException -> L31
        if (materials == null) goto L33;
        if (materials.length == 0) goto L33;
        configureAdbInstallDialogMaterialSurface(context, materialSurface);     // Catch: RuntimeException -> L31
        OMaterialHelperCore.setMaterials(materialSurface, 3, materials);     // Catch: RuntimeException -> L31
        materialSurface.invalidate();     // Catch: RuntimeException -> L31
        Slog.i(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: applied OUI_Bg_Modal material, isLight=" + isLight);     // Catch: RuntimeException -> L31
        return;
    L33:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: missing OUI_Bg_Modal token");     // Catch: RuntimeException -> L31
        return;
    L31:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "applyAdbInstallDialogMaterial: material setup failed", e);
    }

    private static View findAdbInstallDialogMaterialSurface(View rootView) {
        View customContainer = rootView.findViewById(R.id.custom);
        if (customContainer == null) goto L8;
        View customParentPanel = customContainer.findViewById(R.id.scroll_exit_layout);
        if (customParentPanel == null) goto L8;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "findAdbInstallDialogMaterialSurface: using custom parentPanel");
        return customParentPanel;
    L8:
        View parentPanel = rootView.findViewById(R.id.scroll_exit_layout);
        if (parentPanel == null) goto L12;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "findAdbInstallDialogMaterialSurface: using dialog parentPanel");
        return parentPanel;
    L12:
        View contentView = rootView.findViewById(R.id.content);
        if (contentView == null) goto L15;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "findAdbInstallDialogMaterialSurface: using content root");
    L15:
        if (contentView == null) goto L18;
        return contentView;
    L18:
        return rootView;
    }

    private static void configureAdbInstallDialogMaterialSurface(Context context, View materialSurface) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setColor(0);
        background.setCornerRadius(OMaterialHelperCore.dpToPx(context, ADB_INSTALL_DIALOG_CORNER_RADIUS_DP));
        materialSurface.setBackground(background);
        materialSurface.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        materialSurface.setClipToOutline(true);
        Slog.i(PackageManagerServiceMonitorEx.TAG, "configureAdbInstallDialogMaterialSurface: configured transparent rounded surface");
    }

    private static MaterialConfigCore[] copyModalMaterials(boolean isLight) {
        return OMaterialHelperCore.copyMaterials((MaterialConfigCore[]) MaterialTokenCore.OUI_Bg_Modal.invoke(Boolean.valueOf(isLight)));
    }

    boolean checkSystemApp(final IPackageDeleteObserver2 observer, final String packageName, int uid) {
        if (uid == 2000) goto L7;
        if (uid == 0) goto L7;
        if (uid >= 10000) goto L7;
        return false;
    L7:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "deletePackage " + packageName + "from uid=" + uid);
        boolean failed = false;
        PackageManagerTracedLock r1 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        PackageSetting ps = this.mPmService.mSettings.mPackages.get(packageName);     // Catch: Throwable -> L14
        if (ps != null) goto L12;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (failed == false) goto L28;
        this.mPmService.mHandler.post(new AnonymousClass5(this, observer, packageName));
        return true;
    L28:
        return false;
    L12:
        if (ps.isUpdatedSystemApp() == false) goto L16;
        failed = true;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    boolean checkSmtApp(int callingUid, int callingUserId) {
        if (callingUid != this.mPmService.snapshotComputer().getPackageUid(PKG_LAUNCHER_3, 0, callingUserId)) goto L5;
        return true;
    L5:
        if (callingUid != this.mPmService.snapshotComputer().getPackageUid("com.bytedanceos.gamestore", 0, callingUserId)) goto L7;
        return true;
    L7:
        if (callingUid != this.mPmService.snapshotComputer().getPackageUid("com.obric.appstore", 0, callingUserId)) goto L9;
        return true;
    L9:
        if (callingUid != this.mPmService.snapshotComputer().getPackageUid("com.obric.filemanager", 0, callingUserId)) goto L11;
        return true;
    L11:
        if (callingUid != this.mPmService.snapshotComputer().getPackageUid("com.lbt.gms", 0, callingUserId)) goto L13;
        return true;
    L13:
        if (callingUid == this.mPmService.snapshotComputer().getPackageUid("com.obric.security", 0, callingUserId)) goto L23;
        return false;
    L23:
        return true;
    }

    void queryIntentActivitiesInternalSmtEx(Intent intent, int userId, List<ResolveInfo> result) {
        List<String> packages = getRecommendedPackages(intent);
        if (result != null) goto L5;
    L12:
        if (packages == null) goto L35;
        if (packages.size() <= 0) goto L35;
        if (this.mSearchPackageInfo != null) goto L32;
        Intent searchIntent = new Intent("com.bytedanceos.appstore.search_packages");
        searchIntent.setPackage("com.obric.appstore");
        this.mSearchPackageInfo = AppGlobals.getPackageManager().resolveIntent(searchIntent, searchIntent.resolveTypeIfNeeded(this.mPmService.mContext.getContentResolver()), 0, userId);     // Catch: Exception -> L22
    L28:
        if (this.mSearchPackageInfo == null) goto L32;
        this.mSearchPackageInfo.isDefault = true;
        this.mSearchPackageInfo.getSmtEx().isSearchPackagesInfo = true;
        this.mSearchPackageComponentName = new ComponentName(this.mSearchPackageInfo.activityInfo.packageName, this.mSearchPackageInfo.activityInfo.name);
    L22:
        e = move-exception;
        Exception e = e;
    L26:
        e.printStackTrace();
    L24:
        e = move-exception;
        e = e;
    L32:
        if (this.mSearchPackageInfo == null) goto L42;
        result.add(this.mSearchPackageInfo);
        return;
    L42:
        return;
    L35:
        return;
    L5:
        if (result.size() > 1) goto L41;
        if (result.size() != 1) goto L12;
        if ("com.tencent.mobileqq".equals(result.get(0).activityInfo.packageName) == true) goto L12;
        return;
    }

    public List<String> getRecommendedPackages(Intent intent) {
        if ("android.intent.action.VIEW".equals(intent.getAction()) == true) goto L5;
        return null;
    L5:
        if (intent.getComponent() == null) goto L7;
        return null;
    L7:
        if (intent.getPackage() != null) goto L30;
        Uri uri = intent.getData();
        if (uri != null) goto L11;
        return null;
    L11:
        if ("file".equals(uri.getScheme()) == false) goto L24;
        String path = uri.getLastPathSegment();
        if (path != null) goto L15;
        return null;
    L15:
        if (path.length() <= 0) goto L33;
        int dot = path.lastIndexOf(46);
        if (dot > (-1)) goto L19;
        return null;
    L19:
        if (dot >= (path.length() - 1)) goto L35;
        String suffix = path.substring(dot + 1);
        List<String> rec = getRecommendedPackages(suffix);
        return rec;
    L35:
        return null;
    L33:
        return null;
    L24:
        if ("geo".equals(uri.getScheme()) == false) goto L36;
        List<String> rec2 = getRecommendedPackages("geo");
        return rec2;
    L36:
        return null;
    L30:
        return null;
    }

    public List<String> getRecommendedPackages(String suffix) {
        long callingId = Binder.clearCallingIdentity();
        List<String> r2 = getRecommendedPackagesInternal(suffix);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingId);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    private List<String> getRecommendedPackagesInternal(String suffix) {
        List<String> list = getAppStoreRecommendPackageList(suffix);
        if (list == null) goto L12;
        List<String> result = new ArrayList();
        Iterator<String> r2 = list.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String pkg = r2.next();
        if (this.mPmService.snapshotComputer().isPackageAvailable(pkg, 0) == true) goto L6;
        result.add(pkg);
        goto L6
    L11:
        return result;
    L12:
        return null;
    }

    public IPackageManagerSmtEx getISmtEx() {
        return this.mIPackageManagerSmtEx;
    }

    static {
        sAppStoreRecommendPackageMap = new HashMap();
        mSyncFinishReceiver = new AnonymousClass6();
    }

    public static List<String> getAppStoreRecommendPackageList(String category) {
        HashMap<String, List<String>> r0 = sAppStoreRecommendPackageMap;
        monitor-enter(r0);
        List<String> r1 = sAppStoreRecommendPackageMap.get(category);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void atSystemReadyBeginning(Context context, Handler handler) {
        registerReceiver(context, handler);
        initAppStoreRecommendList();
    }

    protected void clearStatement(Context context) {
    L9:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "clearApp statementservice err=" + e.getMessage());
        return;
    L4:
        if (this.mPmService.isDeviceUpgrading() == true) goto L6;
        return;
    L6:
        if (SystemProperties.getInt("persist.sys.statement.clear", 0) != 0) goto L17;
        context.getPackageManager().clearApplicationUserData("com.android.statementservice", null);     // Catch: Exception -> L9
        SystemProperties.set("persist.sys.statement.clear", "1");     // Catch: Exception -> L9
        return;
    }

    private static void registerReceiver(Context context, Handler handler) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_SYNC_DATA_FINISH);
        context.registerReceiver(mSyncFinishReceiver, filter, "bytedanceos.expandservice.data_sync", handler, 2);
    }

    private static void initAppStoreRecommendList() {
        File file = new File(sAppStoreRecommendListFilePath);     // Catch: IOException -> L30
        if (file.exists() == false) goto L27;
        byte[] buffer = new byte[4096];     // Catch: IOException -> L30
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     // Catch: IOException -> L30
        FileInputStream fis = new FileInputStream(file);     // Catch: Throwable -> L15
    L37:
        int len = fis.read(buffer);     // Catch: Throwable -> L9
        if (len == (-1)) goto L11;
        baos.write(buffer, 0, len);     // Catch: Throwable -> L9
        goto L37
    L11:
        String data = baos.toString(StandardCharsets.UTF_8);     // Catch: Throwable -> L9
        fis.close();     // Catch: Throwable -> L15
        baos.close();     // Catch: IOException -> L30
    L28:
        updateAppStoreRecommendPackageData(data);     // Catch: IOException -> L30
        return;
    L9:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L15
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        baos.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L30
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
        goto L26
    L27:
        data = sAppStoreRecommendListData;
    L30:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to initialize app store recommend list", e);
    }

    private static void updateAppStoreRecommendPackageData(String data) {
        HashMap<String, List<String>> map = new HashMap();
        JSONObject object = new JSONObject(data);     // Catch: Exception -> L15
        JSONObject body = object.optJSONObject("body");     // Catch: Exception -> L15
        if (body == null) goto L23;
        Set<String> keys = body.keySet();     // Catch: Exception -> L15
        Iterator<String> r4 = keys.iterator();     // Catch: Exception -> L15
    L6:
        if (r4.hasNext() == false) goto L23;
        String key = r4.next();     // Catch: Exception -> L15
        JSONArray array = body.optJSONArray(key);     // Catch: Exception -> L15
        if (array == null) goto L6;
        HashSet<String> sets = new HashSet();     // Catch: Exception -> L15
        int length = array.length();     // Catch: Exception -> L15
        int i = 0;
    L11:
        if (i >= length) goto L18;
        String pkg = array.getString(i);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(pkg) == true) goto L17;
        sets.add(pkg);     // Catch: Exception -> L15
    L17:
        i = i + 1;     // Catch: Exception -> L15
        goto L11
    L18:
        map.put(key, new ArrayList(sets));     // Catch: Exception -> L15
    L23:
        if (map.size() <= 0) goto L32;
        HashMap<String, List<String>> r1 = sAppStoreRecommendPackageMap;
        monitor-enter(r1);
        sAppStoreRecommendPackageMap.clear();     // Catch: Throwable -> L29
        sAppStoreRecommendPackageMap.putAll(map);     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L32:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private static Pair<byte[], Intent> querySyncDataByTaskName(Context context, String name) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse(SM_READ_SYNC_DATA_URI);
        String[] params = {name};
        Cursor cursor = resolver.query(uri, null, null, params, null);
        byte[] data = null;
        Intent feedback = new Intent(ACTION_SYNC_DATA_FINISH_FEED_BACK);
        if (cursor != null) goto L25;
    L21:
        if (cursor == null) goto L24;
    L18:
        cursor.close();
    L24:
        return new Pair(data, feedback);
    L25:
        int md5Index = cursor.getColumnIndex("md5");     // Catch: Throwable -> L9 Exception -> L11
        int dataIndex = cursor.getColumnIndex("data");     // Catch: Throwable -> L9 Exception -> L11
        if (cursor.moveToFirst() == false) goto L13;
    L6:
        data = cursor.getBlob(dataIndex);     // Catch: Throwable -> L9 Exception -> L11
        String md5 = cursor.getString(md5Index);     // Catch: Throwable -> L9 Exception -> L11
        feedback.putExtra("md5", md5);     // Catch: Throwable -> L9 Exception -> L11
        feedback.putExtra("name", name);     // Catch: Throwable -> L9 Exception -> L11
        if (cursor.moveToNext() == true) goto L6;
    L13:
        if (data == null) goto L21;
        Log.i(PackageManagerServiceMonitorEx.TAG, "read data from provider! data: " + new String(data, StandardCharsets.UTF_8));     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        data = null;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        cursor.close();
        throw th;
    }

    private static boolean saveToStorage(String path, byte[] data) {
        FileOutputStream fos = null;
        fos = new FileOutputStream(path, false);     // Catch: Throwable -> L7 Exception -> L9
        ByteArrayInputStream bais = new ByteArrayInputStream(data);     // Catch: Throwable -> L7 Exception -> L9
        byte[] buf = new byte[4096];     // Catch: Throwable -> L7 Exception -> L9
    L4:
        int count = bais.read(buf);     // Catch: Throwable -> L7 Exception -> L9
        if (count <= 0) goto L11;
        fos.write(buf, 0, count);     // Catch: Throwable -> L7 Exception -> L9
        goto L4
    L11:
        fos.flush();     // Catch: Throwable -> L7 Exception -> L9
        bais.close();     // Catch: Throwable -> L7 Exception -> L9
    L37:
        fos.close();     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        if (fos != null) goto L35;
    L26:
        return false;
    L35:
        fos.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L7:
        th = move-exception;
        if (fos != null) goto L39;
    L32:
        throw th;
    L39:
        fos.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }
}
