package android.app;

import android.content.ContentProvider;
import android.content.Context;
import android.content.ContextExt;
import android.content.Intent;
import android.content.IntentExt;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.BuildExt;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.permission.IStepOSAccessControlManager;
import java.util.List;

/* loaded from: classes.dex */
public class AccessControlManager {
    public static final String ACCESS_CONTROL_INTENT = "stepos.intent.action.CONFIRM_PASSWORD";
    private static final boolean DEBUG = false;
    public static final String KEY_PACKAGE_NAME = "stepos.security:access.package";
    public static final String KEY_PASSWORD_FROM = "password_from";
    public static final int PASSWORD_FROM_APP_LOCK = 2;
    private static final String TAG = "AppLocker";
    private final Context mContext;
    private IStepOSAccessControlManager mService;

    public static Intent getAccessControlIntent(String packageName) {
        AccessControlIntent.sInstance.putExtra(KEY_PACKAGE_NAME, packageName);
        AccessControlIntent.sInstance.putExtra(KEY_PASSWORD_FROM, 2);
        return AccessControlIntent.sInstance;
    }

    private static class AccessControlIntent {
        static Intent sInstance = new Intent(AccessControlManager.ACCESS_CONTROL_INTENT);

        private AccessControlIntent() {
        }

        static {
            sInstance.setFlags(IntentExt.STEPOS_FLAG_SPLIT_MODE);
        }
    }

    public AccessControlManager(Context context, IStepOSAccessControlManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public boolean isPopupUnlockingActivity(String szIdentifier, Intent itIntent) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.isPopupUnlockingActivity(szIdentifier, itIntent);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAppProtected(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.isAppProtected(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAppProtected2(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.isAppProtected2(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte isAppUnlocked(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            byte byRet = this.mService.isAppUnlocked(szPackageName);
            return byRet;
        } catch (Exception e) {
            e.printStackTrace();
            return (byte) -1;
        }
    }

    public boolean getSwitchStatus() {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.getSwitchStatus();
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setSwitchStatus(boolean b) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.setSwitchStatus(b);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveAppList() {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.saveAppList();
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatus(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.updateStatus(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resetStatus() {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.resetStatus();
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addPackageName(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.addPackageName(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delPackageName(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.delPackageName(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addClassName(String szClassName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.addClassName(szClassName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delClassName(String szClassName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.delClassName(szClassName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getPackageName() {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            List list = this.mService.getPackageName();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getPackageNameWithStatus() {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            List list = this.mService.getPackageNameWithStatus();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkAccessControl(String szPackageName) {
        if (this.mService == null) {
            logw("AccessControlService not running");
        }
        try {
            boolean bRet = this.mService.isAppProtected(szPackageName);
            return bRet;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isCurentLockApp(ContentProvider dst, Uri uri, String callingPkg, int mMyUid) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        String ownerPackage;
        boolean bRet;
        String[] believePackages;
        IStepOSAccessControlManager mAccessControlManager = IStepOSAccessControlManager.Stub.asInterface(ServiceManager.getService(ContextExt.ACCESS_CONTROL_SERVICE));
        int uid = Binder.getCallingUid();
        try {
            if (UserHandle.isSameApp(uid, mMyUid)) {
                return false;
            }
            if (mAccessControlManager == null) {
                logw("R isCurentLockApp mAccessControlManager == null  uri:" + uri + "  callingPkg : " + callingPkg + " mMyUid: " + mMyUid);
                return false;
            }
            if (!mAccessControlManager.getSwitchStatus()) {
                logw("R isCurentLockApp mAccessControlManager.getSwitchStatus() == false  uri:" + uri + "  callingPkg : " + callingPkg + " mMyUid: " + mMyUid);
                return false;
            }
            String name = uri.getAuthority();
            if (name == null) {
                logw("R isCurentLockApp name == null  uri:" + uri + "  callingPkg : " + callingPkg + " mMyUid: " + mMyUid);
                return false;
            }
            ProviderInfo cpi = null;
            try {
                cpi = AppGlobals.getPackageManager().resolveContentProvider(name, 0L, UserHandle.myUserId());
            } catch (RemoteException ex) {
                logw("remoteEx: " + ex);
            }
            if (cpi == null) {
                return false;
            }
            int ownerPackageId = dst.getContext().getResources().getIdentifier("ownerPackage", "string", cpi.packageName);
            if (ownerPackageId <= 0) {
                ownerPackage = null;
            } else {
                ownerPackage = dst.getContext().getResources().getString(ownerPackageId);
            }
            String ownerPackage2 = cpi.packageName;
            byte byRet = mAccessControlManager.isAppUnlocked(ownerPackage2);
            if (-1 == byRet) {
                byte byRet2 = mAccessControlManager.isAppUnlocked(ownerPackage);
                if (-1 == byRet2 || 1 == byRet2) {
                    bRet = false;
                } else {
                    bRet = true;
                }
            } else if (1 == byRet) {
                bRet = false;
            } else {
                bRet = true;
            }
            if (ownerPackage != null && ownerPackage.equals(callingPkg)) {
                bRet = false;
            }
            if ("com.tencent.mm.sdk.plugin.provider".equalsIgnoreCase(name) && "com.tencent.mm".equalsIgnoreCase(cpi.packageName)) {
                bRet = false;
            }
            if ("com.stepos.safe".equalsIgnoreCase(cpi.packageName)) {
                bRet = false;
            }
            boolean bRet2 = ("com.android.mms".equalsIgnoreCase(cpi.packageName) || "com.android.providers.telephony".equalsIgnoreCase(cpi.packageName)) ? false : bRet;
            try {
                ApplicationInfo ai = dst.getContext().getPackageManager().getApplicationInfo(cpi.packageName, 128);
                if (ai != null && ai.metaData != null) {
                    boolean needAccessData = ai.metaData.getBoolean("needAccessData", true);
                    if (!needAccessData) {
                        bRet2 = false;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                logw("getApplicationInfo failed for " + cpi.packageName + ": " + e);
            }
            int believePackageId = dst.getContext().getResources().getIdentifier("believePackages", "array", cpi.packageName);
            if (believePackageId > 0 && (believePackages = dst.getContext().getResources().getStringArray(believePackageId)) != null) {
                for (String str : believePackages) {
                    if (str.equals(callingPkg)) {
                        bRet2 = false;
                    }
                }
            }
            return bRet2;
        } catch (RemoteException e2) {
            logw("isCurentLockApp RemoteException " + e2.getMessage());
            return false;
        }
    }

    public static boolean isUriReadAllow(ContentProvider dst, Uri uri, String callingPkg, int myUid) {
        String name;
        int op;
        if (BuildExt.isProductInternational()) {
            return true;
        }
        int uid = Binder.getCallingUid();
        if (UserHandle.isSameApp(uid, myUid) || (name = uri.getAuthority()) == null || (op = CtaOpCodes.matchUriToOp(name)) == -1) {
            return true;
        }
        return CtaPermissionGate.isGranted(op, callingPkg, Binder.getCallingUid(), Binder.getCallingPid());
    }

    private static void logw(String msg) {
    }
}
