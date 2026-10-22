package stepos.hook;

import android.app.AccessControlManager;
import android.app.ActivityThread;
import android.app.AppOpsManager;
import android.app.CtaOpCodes;
import android.app.CtaPackageLists;
import android.app.CtaPermissionGate;
import android.app.CtaPermissionNotifier;
import android.content.ClipData;
import android.content.ContentProvider;
import android.content.Context;
import android.content.ContextExt;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.permission.IStepOSAccessControlManager;
import android.permission.IStepOSPermissionService;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.applock.RemoteAccessControlProxy;
import com.stepos.permission.RemoteStepOSPermissionProxy;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes.dex */
public class StepOSPermissionImpl implements StepOSPermissionStub {
    private static final String PKG = "com.taobao.taobao";
    private static final String RULE1 = "[^A-Za-z0-9_\\s\\./-=+【~@：、（&%#][A-Za-z0-9]{11}[^A-Za-z0-9_\\s\\./=]";
    private static final int RULE_CACHE_MAX = 64;
    private static final String TAG = "StepOSPermissionImpl";
    private static final ConcurrentHashMap<String, List<Pattern>> sRulePatternCache = new ConcurrentHashMap<>();
    private static final String RULE2 = "[一-龥]";
    private static final Pattern RULE2_PATTERN = Pattern.compile(RULE2);

    public boolean isSystemSignatures(String packageName) {
        return CtaPackageLists.isSystemSignatures(packageName);
    }

    public RemoteStepOSPermissionProxy newRemoteStepOSPermissionProxy() {
        return new RemoteStepOSPermissionProxy(this) { // from class: stepos.hook.StepOSPermissionImpl.1
            public int matchUriToOp(String authority) {
                return CtaOpCodes.matchUriToOp(authority);
            }

            public boolean isGranted(int privilege, String callingPkg, int uid, int pid) {
                return CtaPermissionGate.isGranted(privilege, callingPkg, uid, pid);
            }
        };
    }

    public RemoteAccessControlProxy newRemoteAccessControlProxy(final Context context) {
        final IBinder b = ServiceManager.getService(ContextExt.ACCESS_CONTROL_SERVICE);
        return new RemoteAccessControlProxy(this) { // from class: stepos.hook.StepOSPermissionImpl.2
            AccessControlManager accessControlManager;
            IStepOSAccessControlManager service;

            {
                this.service = IStepOSAccessControlManager.Stub.asInterface(b);
                this.accessControlManager = new AccessControlManager(context, this.service);
            }

            public boolean isConnected() {
                return (this.service == null || this.accessControlManager == null) ? false : true;
            }

            public boolean reconnect() {
                this.service = IStepOSAccessControlManager.Stub.asInterface(b);
                this.accessControlManager = new AccessControlManager(context, this.service);
                return isConnected();
            }

            public boolean getSwitchStatus() {
                return this.accessControlManager.getSwitchStatus();
            }

            public List<String> getPackageNameWithStatus() {
                return this.accessControlManager.getPackageNameWithStatus();
            }
        };
    }

    public boolean isCurrentLockApp(ContentProvider dst, Uri uri, String callingPkg, int mMyUid) {
        return AccessControlManager.isCurentLockApp(dst, uri, callingPkg, mMyUid);
    }

    public boolean isAppUnlocked(String packageName) {
        IStepOSAccessControlManager accessControlService = IStepOSAccessControlManager.Stub.asInterface(ServiceManager.getService(ContextExt.ACCESS_CONTROL_SERVICE));
        if (accessControlService != null) {
            try {
                return accessControlService.isAppUnlocked(packageName) == 0;
            } catch (RemoteException e) {
                return false;
            }
        }
        return false;
    }

    public boolean isUriReadAllow(ContentProvider dst, Uri uri, String callingPkg, int myUid) {
        return AccessControlManager.isUriReadAllow(dst, uri, callingPkg, myUid);
    }

    public boolean checkAccessControl(String packageName) {
        IStepOSAccessControlManager accessControlService = IStepOSAccessControlManager.Stub.asInterface(ServiceManager.getService(ContextExt.ACCESS_CONTROL_SERVICE));
        if (accessControlService == null) {
            return false;
        }
        try {
            return accessControlService.checkAccessControl(packageName);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void askAppOpOperation(int uid, String packageName, int op) {
        CtaPermissionNotifier.askOpsOperation(uid, packageName, op);
    }

    public void injectNoteProxyOp(AppOpsManager manager, String op, String packageName, int uid, String tag, String message) {
        if (manager != null && op != null) {
            manager.noteProxyOp(op, packageName, uid, tag, message);
        }
    }

    public boolean isGranted(String opPackageName, int op, int callingUid, int callingPid) {
        return CtaPermissionGate.isGranted(op, opPackageName, callingUid, callingPid);
    }

    public boolean isGranted(int privilege, int uid, int pid) {
        return CtaPermissionGate.isGranted(privilege, uid, pid);
    }

    public boolean isAccountPermissionGranted(String opPackageName, int callingUid, int callingPid) {
        return CtaPermissionGate.isGranted(104, opPackageName, callingUid, callingPid);
    }

    public boolean isSendMmsPermissionGranted(String opPackageName, int callingUid, int callingPid) {
        return noteOpGranted(67, opPackageName, callingUid);
    }

    public boolean isBluethoothPermissionGranted(String opPackageName, int callingUid, int callingPid) {
        return CtaPermissionGate.isGranted(77, opPackageName, callingUid, callingPid);
    }

    public boolean isWifiPermissionGranted(String opPackageName, int callingUid, int callingPid) {
        return CtaPermissionGate.isGranted(68, opPackageName, callingUid, callingPid);
    }

    public boolean isMMSPermissionGranted(String opPackageName, int callingUid, int callingPid) {
        return noteOpGranted(67, opPackageName, callingUid);
    }

    public boolean isSensorGranted(int uid, int pid) {
        String[] pkgs = ActivityThread.currentApplication().getPackageManager().getPackagesForUid(uid);
        String packageName = (pkgs == null || pkgs.length == 0) ? null : pkgs[0];
        return noteOpGranted(78, packageName, uid);
    }

    public boolean isReceivedSmsGranted(int uid, int pid) {
        return CtaPermissionGate.isGranted(114, uid, pid);
    }

    public int getQueryPackagesPermissionState(int callUid, int callPid) {
        String[] pkgs = ActivityThread.currentApplication().getPackageManager().getPackagesForUid(callUid);
        String packageName = (pkgs == null || pkgs.length == 0) ? null : pkgs[0];
        return noteOpGranted(56, packageName, callUid) ? 1 : -1;
    }

    public boolean isGrantAiClipboardPermission(Context context, String pkg) {
        int res = getAppCategory(context, pkg);
        return res == 0;
    }

    public boolean checkAirRulesMatch(Context mContext, ClipData primaryClip, String pkg) {
        CharSequence text;
        if (primaryClip == null || (text = primaryClip.getItemAt(0).getText()) == null || text.isEmpty()) {
            return false;
        }
        int res = getAppCategory(mContext, pkg);
        if (res != 0) {
            return false;
        }
        String rules = Settings.Secure.getString(mContext.getContentResolver(), StepOSSettingsKeys.SECURE_CLIPBOARD_RULE_NAME_SETTINGS + pkg);
        if (rules == null || rules.isEmpty()) {
            if (!PKG.equals(pkg)) {
                return false;
            }
            rules = RULE1;
        }
        List<Pattern> patterns = getOrBuildPatterns(pkg, rules);
        String content = text.toString();
        for (Pattern p : patterns) {
            if (p.matcher(content).find()) {
                return true;
            }
        }
        return PKG.equals(pkg) && RULE2_PATTERN.matcher(content).find();
    }

    private static List<Pattern> getOrBuildPatterns(String pkg, String rules) {
        String cacheKey = pkg + (char) 0 + rules;
        List<Pattern> cached = sRulePatternCache.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        String[] items = rules.split("\\|\\|\\|");
        ArrayList<Pattern> compiled = new ArrayList<>(items.length);
        for (String regex : items) {
            try {
                compiled.add(Pattern.compile(regex));
            } catch (PatternSyntaxException e) {
            }
        }
        if (sRulePatternCache.size() >= 64) {
            sRulePatternCache.clear();
        }
        sRulePatternCache.put(cacheKey, compiled);
        return compiled;
    }

    private static int getAppCategory(Context context, String pkg) {
        String opName = pkg + "_op_200";
        AppOpsManager mAom = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        return mAom.getAppCategory(opName);
    }

    private boolean noteOpGranted(int op, String packageName, int uid) {
        if (TextUtils.isEmpty(packageName) || uid == 1000) {
            return true;
        }
        try {
            IStepOSPermissionService service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
            if (service == null) {
                return true;
            }
            int ret = service.noteIntentOperation(op, uid, packageName, new Intent());
            return ret == 0;
        } catch (Exception e) {
            return true;
        }
    }
}
