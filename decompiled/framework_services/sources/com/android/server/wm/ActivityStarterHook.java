package com.android.server.wm;

import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.IApplicationThread;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.mifavor.MFVUtils;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.server.LocalServices;
import com.zte.ctsutils.CtsUtils;
import com.zte.feature.Feature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ActivityStarterHook {
    public static final String CALLED_FROM_DOUBLEAPP_RESOLVER = "called_from_doubleapp_resolver";
    public static final String CALLED_FROM_HEARTSERVICE = "start_from_heartservice_app_lock";
    public static final List<String> CALLING_PACKAGES_NOT_CHOOSE = null;
    public static final String CAR_DISPLAY_NAME = "vehicle_cast_virtual_display";
    public static final String CAR_DISPLAY_NAME2 = "com_zte_car_minimap";
    public static final boolean DEBUG_DOUBLEAPP = false;
    public static final String DOUBLEAPP_CALLING_PACKAGE = "doubleapp_calling_package";
    public static final String DOUBLEAPP_INTENT = "doubleLay_intent";
    public static final String DOUBLEAPP_PACKAGE_NAME = "doubleapp_package_name";
    public static final int DOUBLEAPP_STATE = 2;
    public static final int IDLE_STATE = 0;
    public static final String[] LOGIN_CLASS_NAMES = null;
    public static final int LOGIN_STATE = 1;
    public static final long MAX_VALIDATE_INTERVAL_LOGIN = 70000;
    public static final String NOT_SHOW_DOUBLE_CHOOSE_DIALOG = "not_show_double_choose_dialog";
    private static final String TAG = "ActivityStarterHook_ActivityStarterMifavor";
    public static final List<String> TARGET_PACKAGES_NOT_CHOOSE = null;
    public static final String USERID_CALLED_FROM_DOUBLEAPP_RESOLVER = "userId_called_from_doubleapp_resolver";
    public static ActivityManagerInternal mActivityManagerInternal = null;
    public static String mCachedPackageName = null;
    public static String mCachedTargetClassName = null;
    public static int mCachedUserId = 0;
    public static final String mDoubleAppPackageName = "com.zte.cn.doubleapp";
    public static List<String> mDoubleAppPackageNames = null;
    public static final String mDoubleAppResolverClassName = "com.zte.cn.doubleapp.activity.DoubleAppResolverActivity";
    public static boolean mIsDoubleAppEnabled;
    public static long mLastLoginStartTime;
    public static Object mLock;
    public static Object mLockAmi;
    public static Object mLockPackageName;
    public static Object mLockResolver;
    public static boolean mNotShowWechat;
    public static ActivityInfo mResolverActivityInfo;
    public static int mState;

    public static class ResolveInfoWraper {
        public ResolveInfo mResolveInfo;
        public int mUserId;

        public ResolveInfoWraper(ResolveInfo info, int userId) {
            this.mResolveInfo = info;
            this.mUserId = userId;
        }
    }

    ActivityStarterHook() {
    }

    static {
        if (Log.isLoggable("DoubleApp", 2) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG_DOUBLEAPP = r0;
        LOGIN_CLASS_NAMES = new String[]{"com.tencent.mm.plugin.base.stub.WXEntryActivity", "com.taobao.android.auth.AuthEntranceActivity", "com.alipay.mobile.quinox.SchemeLauncherActivity", "com.tencent.open.agent.AgentActivity"};
        mLastLoginStartTime = SystemClock.uptimeMillis();
        mCachedTargetClassName = null;
        mDoubleAppPackageNames = new ArrayList();
        mIsDoubleAppEnabled = false;
        mResolverActivityInfo = null;
        mCachedUserId = 0;
        mCachedPackageName = null;
        mState = 0;
        mNotShowWechat = false;
        mLock = new Object();
        mLockPackageName = new Object();
        mLockResolver = new Object();
        mLockAmi = new Object();
        mActivityManagerInternal = null;
        CALLING_PACKAGES_NOT_CHOOSE = new AnonymousClass1();
        TARGET_PACKAGES_NOT_CHOOSE = new AnonymousClass2();
        return;
    L5:
        if (Log.isLoggable("DoubleApp", 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    static int resolveActivity_DoubleApp(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor, Intent intent, String callingPackage, int userId, IApplicationThread caller) {
        return 0;
    }

    public static Intent makeNewIntent_DoubleAppp(Intent intent, int userId) {
        ComponentName componentName = intent.getComponent();     // Catch: Exception -> L6
        if (componentName == null) goto L8;
        String className = componentName.getClassName();     // Catch: Exception -> L6
    L10:
        if (mDoubleAppResolverClassName.equals(className) == false) goto L18;
        Intent realIntent = (Intent) intent.getExtra(DOUBLEAPP_INTENT, null);     // Catch: Exception -> L6
        String callingPackage = intent.getStringExtra(DOUBLEAPP_CALLING_PACKAGE);     // Catch: Exception -> L6
        int flags = intent.getFlags();     // Catch: Exception -> L6
        intent = new Intent();     // Catch: Exception -> L6
        intent.setComponent(componentName);     // Catch: Exception -> L6
        intent.putExtra(DOUBLEAPP_INTENT, realIntent);     // Catch: Exception -> L6
        intent.putExtra(DOUBLEAPP_CALLING_PACKAGE, callingPackage);     // Catch: Exception -> L6
        intent.setFlags(flags);     // Catch: Exception -> L6
        Log.d(TAG, "resolveActivity realIntent:" + realIntent + ",callingPackage:" + callingPackage + ",intent:" + intent);     // Catch: Exception -> L6
        return intent;
    L18:
        return intent;
    L8:
        className = "";
    L6:
        e = move-exception;
        Log.e(TAG, "resolveActivity userId: " + userId + ", intent: " + intent + ",e:" + e);
        return intent;
    }

    public static int restoreCallingUid_DoubleAppp(int userId, Intent intent, String callingPackage, int resolvedCallingUid) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        if (userId == 0) goto L8;
        if (userId == 999) goto L8;
        return resolvedCallingUid;
    L8:
        if (mDoubleAppPackageName.equals(callingPackage) == false) goto L13;
        int resolvedCallingUid2 = intent.getIntExtra("real_calling_uid", resolvedCallingUid);
        Log.d(TAG, "resolvedCallingUid: " + resolvedCallingUid2);
        return resolvedCallingUid2;
    L13:
        return resolvedCallingUid;
    L11:
        return resolvedCallingUid;
    }

    public static String restorePackageName_DoubleAppp(int userId, Intent intent, String callingPackage, String packageName) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L11;
        if (userId == 0) goto L8;
        if (userId == 999) goto L8;
        return packageName;
    L8:
        if (mDoubleAppPackageName.equals(callingPackage) == false) goto L13;
        String packageName2 = (String) intent.getExtra("real_target_pkg", packageName);
        Log.d(TAG, "packageName: " + packageName2);
        return packageName2;
    L13:
        return packageName;
    L11:
        return packageName;
    }

    public static ResolveInfoWraper resolveActivity_fallback_DoubleApp(ActivityStarter.Request request, int callingUid, int realCallingUid, int filterCallingUid, int realCallingPid, String callingPackage, int userId, ResolveInfo resolveInfo, String resolvedType, ActivityTaskSupervisor supervisor, Intent intent) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L30;
        int userId2 = userId;
        if (userId2 != 999) goto L31;
        if (resolveInfo != null) goto L31;
        ResolveInfo resolveInfo2 = supervisor.resolveIntent(intent, resolvedType, 0, 0, ActivityStarter.computeResolveFilterUid(callingUid, realCallingUid, filterCallingUid), realCallingPid);
        if (resolveInfo2 != null) goto L10;
        ResolveInfo resolveInfo3 = request.resolveIntentForLockedOrStoppedProfiles(supervisor);
    L11:
        if (resolveInfo3 == null) goto L33;
        boolean isNotShowChooseDialogApps = false;
        String id = "";
        Intent tempIntent = new Intent(intent);     // Catch: Exception -> L19
        id = tempIntent.getIdentifier();     // Catch: Exception -> L19
        isNotShowChooseDialogApps = tempIntent.hasExtra(CALLED_FROM_HEARTSERVICE);     // Catch: Exception -> L19
        if (isNotShowChooseDialogApps == true) goto L22;
        if (id == null) goto L21;
        if (id.contains("WindowReply") == true) goto L22;
    L21:
        boolean isNoNeedFallback = false;
    L26:
        if (isNoNeedFallback == true) goto L28;
        userId2 = 0;
        Log.d(TAG, "debug_999_fallback resolveActivity 999 fallback to 0 for :" + intent + ",iSNotShowChooseDialogApps:" + isNotShowChooseDialogApps + ",id:" + id + ",callingPackage:" + callingPackage);
        goto L33
    L28:
        resolveInfo3 = null;
        Log.d(TAG, "debug_999_fallback resolveActivity keep 999 for :" + intent + ",iSNotShowChooseDialogApps:" + isNotShowChooseDialogApps + ",id:" + id + ",callingPackage:" + callingPackage);
    L22:
        isNoNeedFallback = true;
    L19:
        e = move-exception;
        Log.e(TAG, "hasExtra, Exception e: " + e);
        isNoNeedFallback = false;
    L33:
        return new ResolveInfoWraper(resolveInfo3, userId2);
    L10:
        resolveInfo3 = resolveInfo2;
    L31:
        resolveInfo3 = resolveInfo;
        goto L33
    L30:
        userId2 = userId;
        goto L31
    }

    private static List<ResolveInfo> getResolveInfosForUserId(ActivityTaskManagerService service, Intent intent, int userId) {
        List resolveInfos = new ArrayList();
        Context r1 = service.mContext;     // Catch: Exception -> L18
        monitor-enter(r1);     // Catch: Exception -> L18
        List resolveInfosTemp = service.mContext.getPackageManager().queryIntentActivitiesAsUser(intent, 65536, userId);     // Catch: Throwable -> L11
        if (resolveInfosTemp == null) goto L9;
        resolveInfos = resolveInfosTemp;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L15:
        if (DEBUG_DOUBLEAPP == false) goto L24;
        Log.d(TAG, "resolveInfos: " + resolveInfos + " for user: " + userId);     // Catch: Exception -> L18
    L24:
        return resolveInfos;
    L9:
        if (DEBUG_DOUBLEAPP == false) goto L13;
        Log.d(TAG, "queryIntentActivitiesAsUser return null  for user: " + userId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.e(TAG, "getResolveInfosForUserId excep, intent:" + intent + ",userId:" + userId + ",e:" + e);
        goto L24
    }

    private static void getDoubleAppInfo(ActivityTaskManagerService service) {
        Context r1 = service.mContext;     // Catch: Exception -> L20
        monitor-enter(r1);     // Catch: Exception -> L20
        ContentResolver cr = service.mContext.getContentResolver();     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        String doubleAppPackageNames = Settings.Global.getString(cr, DOUBLEAPP_PACKAGE_NAME);     // Catch: Exception -> L20
        Object r2 = mLockPackageName;     // Catch: Exception -> L20
        monitor-enter(r2);     // Catch: Exception -> L20
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L10:
        if (TextUtils.isEmpty(doubleAppPackageNames) == true) goto L16;
        String[] doubleAppPackages = doubleAppPackageNames.replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "").split(",");     // Catch: Throwable -> L14
        mDoubleAppPackageNames = Arrays.asList(doubleAppPackages);     // Catch: Throwable -> L14
        if (DEBUG_DOUBLEAPP == false) goto L16;
        Log.d(TAG, "mDoubleAppPackageNames.size: " + mDoubleAppPackageNames.size());     // Catch: Throwable -> L14
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
    L32:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e(TAG, "getDoubleAppInfo e:" + e);
    }

    private static void makeNewIntent(Intent intent, String callingPackage, ComponentName cn, int callerAppUserId, String targetPackageName) {
        Intent tempIntent = new Intent(intent);
        tempIntent.putExtra("real_calling_userId", callerAppUserId);
        int real_calling_uid = -1;
        real_calling_uid = AppGlobals.getPackageManager().getPackageUid(callingPackage, 0, callerAppUserId);     // Catch: RemoteException -> L8
        if (real_calling_uid == (-1)) goto L6;
    L10:
        tempIntent.putExtra("real_calling_uid", real_calling_uid);     // Catch: RemoteException -> L8
    L13:
        tempIntent.putExtra("real_target_pkg", targetPackageName);
        intent.putExtra(DOUBLEAPP_INTENT, tempIntent);
        intent.putExtra(DOUBLEAPP_CALLING_PACKAGE, callingPackage);
        intent.setComponent(cn);
        if (DEBUG_DOUBLEAPP == false) goto L19;
        Log.d(TAG, "NEW intent " + intent + ",callerAppUserId:" + callerAppUserId + ",real_calling_uid:" + real_calling_uid + ",callingPackage:" + callingPackage + ",targetPackageName:" + targetPackageName);
        return;
    L19:
        return;
    L6:
        if (callerAppUserId != 999) goto L10;
        callerAppUserId = 0;
        real_calling_uid = AppGlobals.getPackageManager().getPackageUid(callingPackage, 0, 0);     // Catch: RemoteException -> L8
        Log.d(TAG, "getPackageUid 999 fallback to 0  for :" + callingPackage);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "makeNewIntent, RemoteException e = " + e);
        goto L13
    }

    private static boolean isDoubleAppComponentEnabled(ComponentName cn) {
        mResolverActivityInfo = AppGlobals.getPackageManager().getActivityInfo(cn, 0, 0);     // Catch: RemoteException -> L8
        if (mResolverActivityInfo != null) goto L6;
        return false;
    L6:
        return true;
    L8:
        e = move-exception;
        Log.e(TAG, "isDoubleAppComponentEnabled, RemoteException e = " + e);
        return false;
    }

    private static boolean isComponentEnabled(ComponentName cn, int userId) {
        ActivityInfo ai = AppGlobals.getPackageManager().getActivityInfo(cn, 0, userId);     // Catch: RemoteException -> L9
        Log.d(TAG, "isComponentEnabled ai = " + ai + " userId = " + userId);     // Catch: RemoteException -> L9
        if (ai == null) goto L8;
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        Log.e(TAG, "isComponentEnabled, RemoteException e = " + e);
        return false;
    }

    private static boolean isSystemApp(ApplicationInfo appInfo) {
        if (appInfo != null) goto L5;
        return false;
    L5:
        if ((appInfo.flags & 1) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((appInfo.flags & 128) != 0) goto L8;
        return false;
    }

    private static boolean isSystemApp(ActivityInfo activityInfo) {
        if (activityInfo != null) goto L5;
        return false;
    L5:
        if (activityInfo.applicationInfo == null) goto L9;
        boolean isSystem = isSystemApp(activityInfo.applicationInfo);
        return isSystem;
    L9:
        return false;
    }

    public static boolean isPlatformApp(String packageName) {
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pmInternal == null) goto L7;
        if (packageName == null) goto L8;
        boolean isPlatformApp = pmInternal.isPlatformSigned(packageName);
        return isPlatformApp;
    L8:
        return false;
    L7:
        return false;
    }

    private static boolean isCtsTesting(String callingPackageName, String calledPackageName) {
        boolean isCts = Feature.getCtsRunningStatus();
        if (isCts == false) goto L5;
    L10:
        return true;
    L5:
        if (CtsUtils.isCtsPackage(callingPackageName) == true) goto L10;
        if (CtsUtils.isCtsPackage(calledPackageName) == true) goto L10;
        return false;
    }
}
