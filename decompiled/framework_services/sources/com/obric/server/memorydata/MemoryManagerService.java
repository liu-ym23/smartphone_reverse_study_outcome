package com.obric.server.memorydata;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.wm.WindowManagerService;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.List;
import obric.memorydata.IMemoryActionCallback;
import obric.memorydata.IMemoryManagerService;
import obric.memorydata.IScenePerceptionCallback;
import obric.memorydata.ISystemEventCallback;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryManagerService extends IMemoryManagerService.Stub {
    private static final Uri AUTHORITY_URI = null;
    private static final String DOUBAO_ENTERPRISE = "doubao_account_is_enterprise";
    private static final boolean LOG = true;
    private static final String MEMORY_ACTIVITY = "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity";
    private static final String MEMORY_PKG = "com.larus.nova";
    private static final int MEMORY_STATE_DISABLED = 0;
    private static final int MEMORY_STATE_ENABLED = 1;
    private static final int MEMORY_STATE_UNINSTALLED = -1;
    public static final String METHOD_DISABLE_ASSIST = "disableAssist";
    public static final String METHOD_ENABLE_ASSIST = "enableAssist";
    public static final String METHOD_SHOW_ENABLE_DIALOG = "showDialog";
    public static final String METHOD_SHOW_INSTALL_DIALOG = "showInstallDialog";
    public static final String RESULT_KEY = "result";
    private static final String TAG = "MemoryManagerService";
    private final Context mContext;
    private IMemoryActionCallback mMemoryActionCallback;
    private IScenePerceptionCallback mScenePerceptionCallback;
    private IBinder.DeathRecipient mScenePerceptionCallbackDeathRecipient;
    private boolean mScenePerceptionCallbackDeathRecipientLinked;
    private final Object mScenePerceptionCallbackLock;
    private ISystemEventCallback mSystemEventCallback;
    MemoryManagerService memoryManagerService;

    /* JADX INFO: renamed from: $r8$lambda$LyTbTwQQA9oXzfgiPi4x-J7PSpU, reason: not valid java name */
    public static /* synthetic */ void m10578$r8$lambda$LyTbTwQQA9oXzfgiPi4xJ7PSpU(MemoryManagerService r0, IScenePerceptionCallback r1) {
        r0.lambda$registerScenePerceptionCallback$0(r1);
    }

    static {
        AUTHORITY_URI = Uri.parse("content://obric.assist.management");
    }

    public MemoryManagerService(Context context) {
        this.mScenePerceptionCallbackLock = new Object();
        this.memoryManagerService = null;
        this.mContext = context;
    }

    public void doMemoryAction(int from, Bundle extras) throws RemoteException {
        slogI("doMemoryAction, from: " + from);
        switch(from) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L4:
        boolean callerValid = false;
    L9:
        if (callerValid == true) goto L11;
        slogW("doMemoryAction, caller is invalid");
        return;
    L11:
        if (from != 4) goto L13;
    L14:
        int state = checkAppState();
        slogI("check app state = " + state);
        switch(state) {
            case -1: goto L22;
            case 0: goto L20;
            default: goto L17;
        };
    L20:
        showEnableDialog();
        return;
    L22:
        showInstallDialog();
        return;
    L17:
        if (this.mMemoryActionCallback == null) goto L19;
        this.mMemoryActionCallback.onAction(from, extras);
        return;
    L19:
        slogW("doMemoryAction, no callback");
        return;
    L13:
        if (from != 3) goto L17;
    L5:
        callerValid = checkCallingUidSystem(Binder.getCallingUid());
        goto L9
    L6:
        callerValid = checkCallingForeground(Binder.getCallingUid());
        goto L9
    L7:
        callerValid = checkCallingSignature(Binder.getCallingUid());
        goto L9
    }

    private boolean callMethod(String method) {
        ContentProviderClient client = null;
        long token = Binder.clearCallingIdentity();
        client = this.mContext.getContentResolver().acquireUnstableContentProviderClient(AUTHORITY_URI);     // Catch: Throwable -> L10 Exception -> L12
        if (client == null) goto L14;
        Bundle result = client.call(method, null, null);     // Catch: Throwable -> L10 Exception -> L12
        if (result == null) goto L14;
        boolean value = result.getBoolean(RESULT_KEY, false);     // Catch: Throwable -> L10 Exception -> L12
        slogI("call result = " + value);     // Catch: Throwable -> L10 Exception -> L12
        client.close();
        Binder.restoreCallingIdentity(token);
        return value;
    L14:
        if (client == null) goto L16;
    L15:
        client.close();
    L16:
        Binder.restoreCallingIdentity(token);
        return false;
    L10:
        th = move-exception;
        if (client == null) goto L24;
        client.close();
    L24:
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        e = move-exception;
        slogW("call remote method error! method=" + method, e);     // Catch: Throwable -> L10
        if (client == null) goto L16;
        goto L16
    }

    private boolean showEnableDialog() {
        return callMethod(METHOD_SHOW_ENABLE_DIALOG);
    }

    private boolean showInstallDialog() {
        return callMethod(METHOD_SHOW_INSTALL_DIALOG);
    }

    public void registerMemoryActionCallback(IMemoryActionCallback callback) {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "registerMemoryActionCallback()") == false) goto L6;
        this.mMemoryActionCallback = callback;
        return;
    }

    public void reportSystemEvent(int event, int state, Bundle extras) throws RemoteException {
        if (this.mSystemEventCallback == null) goto L13;
        slogI("reportSystemEvent, event: " + event + ", state: " + state);
        switch(event) {
            case 0: goto L7;
            default: goto L6;
        };
    L6:
        boolean callerValid = false;
    L9:
        if (callerValid == false) goto L11;
        this.mSystemEventCallback.onEvent(event, state, extras);
        return;
    L11:
        slogW("reportSystemEvent, caller is invalid");
        return;
    L7:
        callerValid = checkCallingSignature(Binder.getCallingUid());
        goto L9
    }

    public void registerSystemEventCallback(ISystemEventCallback callback) {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "registerSystemEventCallback()") == false) goto L6;
        this.mSystemEventCallback = callback;
        return;
    }

    public void unregisterMemoryActionCallback() {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "unregisterMemoryActionCallback()") == false) goto L6;
        this.mMemoryActionCallback = null;
        return;
    }

    public void unregisterSystemEventCallback() {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "unregisterSystemEventCallback()") == false) goto L6;
        this.mSystemEventCallback = null;
        return;
    }

    public void registerScenePerceptionCallback(final IScenePerceptionCallback callback) {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "registerScenePerceptionCallback()") == false) goto L24;
        Object r0 = this.mScenePerceptionCallbackLock;
        monitor-enter(r0);
        clearScenePerceptionCallbackLocked();     // Catch: Throwable -> L10
        if (callback != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        IBinder binder = callback.asBinder();     // Catch: Throwable -> L10
        IBinder.DeathRecipient deathRecipient = new MemoryManagerService$$ExternalSyntheticLambda0(this, callback);     // Catch: Throwable -> L10
        this.mScenePerceptionCallback = callback;     // Catch: Throwable -> L10
        this.mScenePerceptionCallbackDeathRecipient = deathRecipient;     // Catch: Throwable -> L10
        binder.linkToDeath(deathRecipient, 0);     // Catch: Throwable -> L10 RemoteException -> L16
        this.mScenePerceptionCallbackDeathRecipientLinked = true;     // Catch: Throwable -> L10 RemoteException -> L16
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L16:
        e = move-exception;
        slogW("registerScenePerceptionCallback, callback already died", e);     // Catch: Throwable -> L10
        if (isSameScenePerceptionCallbackLocked(callback) == false) goto L20;
        this.mScenePerceptionCallback = null;     // Catch: Throwable -> L10
        this.mScenePerceptionCallbackDeathRecipient = null;     // Catch: Throwable -> L10
        this.mScenePerceptionCallbackDeathRecipientLinked = false;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$registerScenePerceptionCallback$0(IScenePerceptionCallback callback) {
        Object r0 = this.mScenePerceptionCallbackLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isSameScenePerceptionCallbackLocked(callback) == false) goto L9;
        slogW("scene perception callback binder died");     // Catch: Throwable -> L7
        this.mScenePerceptionCallback = null;     // Catch: Throwable -> L7
        this.mScenePerceptionCallbackDeathRecipient = null;     // Catch: Throwable -> L7
        this.mScenePerceptionCallbackDeathRecipientLinked = false;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void unregisterScenePerceptionCallback() {
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "unregisterScenePerceptionCallback()") == false) goto L12;
        Object r0 = this.mScenePerceptionCallbackLock;
        monitor-enter(r0);
        clearScenePerceptionCallbackLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void reportScenePerceptionEvent(int type, Bundle bundle) throws RemoteException {
        Object r0 = this.mScenePerceptionCallbackLock;
        monitor-enter(r0);
        IScenePerceptionCallback callback = this.mScenePerceptionCallback;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (callback == null) goto L30;
        slogI("reportScenePerceptionEvent, type: " + type);     // Catch: Throwable -> L10 RemoteException -> L12
        if (checkCallingUidSystem(Binder.getCallingUid()) == false) goto L14;
        callback.onAction(type, bundle);     // Catch: Throwable -> L10 RemoteException -> L12
    L25:
        return;
    L14:
        slogW("reportScenePerceptionEvent, caller is invalid");     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        slogW("reportScenePerceptionEvent, callback error", e);
        clearScenePerceptionCallback(callback);
        return;
    L10:
        e = move-exception;
        slogW("reportScenePerceptionEvent, error", e);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void clearScenePerceptionCallback(IScenePerceptionCallback callback) {
        Object r0 = this.mScenePerceptionCallbackLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isSameScenePerceptionCallbackLocked(callback) == false) goto L9;
        clearScenePerceptionCallbackLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void clearScenePerceptionCallbackLocked() {
        if (this.mScenePerceptionCallback != null) goto L5;
    L9:
        this.mScenePerceptionCallback = null;
        this.mScenePerceptionCallbackDeathRecipient = null;
        this.mScenePerceptionCallbackDeathRecipientLinked = false;
        return;
    L5:
        if (this.mScenePerceptionCallbackDeathRecipient == null) goto L9;
        if (this.mScenePerceptionCallbackDeathRecipientLinked == false) goto L9;
        this.mScenePerceptionCallback.asBinder().unlinkToDeath(this.mScenePerceptionCallbackDeathRecipient, 0);
        goto L9
    }

    private boolean isSameScenePerceptionCallbackLocked(IScenePerceptionCallback callback) {
        if (this.mScenePerceptionCallback == null) goto L8;
        if (callback == null) goto L8;
        if (this.mScenePerceptionCallback.asBinder() != callback.asBinder()) goto L8;
        return true;
    L8:
        return false;
    }

    public void doScenePerceptionAction(int type, Bundle bundle) throws RemoteException {
        slogI("doScenePerceptionAction");     // Catch: Throwable -> L10
        if (checkCallingPermission("com.obric.memorydata.permission.MEMORY_MANAGER", "doScenePerceptionAction()") == false) goto L14;
        switch(type) {
            case 1: goto L6;
            default: goto L20;
        };     // Catch: Throwable -> L10
    L6:
        WindowManagerService windowManagerService = (WindowManagerService) ServiceManager.getService("window");     // Catch: Throwable -> L10
        if (windowManagerService != null) goto L12;
        slogW("doScenePerceptionAction, windowManagerService is null");     // Catch: Throwable -> L10
        return;
    L12:
        windowManagerService.getObricExt().requestScenePerception(bundle);     // Catch: Throwable -> L10
        return;
    L20:
        return;
    L14:
        slogW("doScenePerceptionAction, caller is invalid");     // Catch: Throwable -> L10
        return;
    L10:
        e = move-exception;
        slogW("doScenePerceptionAction, error", e);
    }

    public static void start(Context context, TimingsTraceAndSlog t) {
        t.traceBegin(TAG);     // Catch: Throwable -> L5
        ServiceManager.addService("memorydata", new MemoryManagerService(context));     // Catch: Throwable -> L5
        t.traceEnd();     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "***********************************************");
        Slog.wtf(TAG, "BOOT FAILURE starting MemoryManagerService", e);
    }

    private boolean checkCallingPermission(String permission, String func) {
        if (this.mContext.checkCallingPermission(permission) != 0) goto L6;
        return true;
    L6:
        if (ObricPermissionCheckHelper.isSystemApp(this.mContext, Binder.getCallingUid()) == false) goto L9;
        slogW(String.format("Permission Denial: %s from pid=%d, uid=%d requires %s, fallback to system app", new Object[]{func, Integer.valueOf(Binder.getCallingPid()), Integer.valueOf(Binder.getCallingUid()), permission}));
        return true;
    L9:
        slogW(String.format("Permission Denial: %s from pid=%d, uid=%d requires %s", new Object[]{func, Integer.valueOf(Binder.getCallingPid()), Integer.valueOf(Binder.getCallingUid()), permission}));
        return false;
    }

    private boolean checkCallingUidSystem(int uid) {
        if (uid != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkCallingSignature(int uid) {
        String callerPackageName = getPackageNameForUid(uid);
        if (callerPackageName != null) goto L5;
    L8:
        slogW("Signature Denial: " + callerPackageName);
        return false;
    L5:
        if (isPlatformSigned(callerPackageName) == false) goto L8;
        return true;
    }

    private boolean checkCallingForeground(int uid) {
        String callerPackageName = getPackageNameForUid(uid);
        String topPackageName = getTopAppPackage();
        if (callerPackageName != null) goto L5;
    L8:
        slogW("Foreground Denial: " + callerPackageName + ", " + topPackageName);
        return false;
    L5:
        if (callerPackageName.equals(topPackageName) == false) goto L8;
        return true;
    }

    private String getPackageNameForUid(int uid) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);     // Catch: Exception -> L8
        if (packages != null) goto L5;
        return null;
    L5:
        if (packages.length <= 0) goto L17;
        return packages[0];
    L17:
        return null;
    L8:
        e = move-exception;
        slogW("Failed to get package name for uid", e);
        return null;
    }

    private String getTopAppPackage() {
        long token = Binder.clearCallingIdentity();
        List<ActivityManager.RunningTaskInfo> tasks = ActivityTaskManager.getInstance().getTasks(1);     // Catch: Throwable -> L10 Exception -> L12
        if (tasks != null) goto L6;
    L14:
        Binder.restoreCallingIdentity(token);
        return null;
    L6:
        if (tasks.isEmpty() == true) goto L14;
        String r3 = tasks.get(0).topActivity.getPackageName();     // Catch: Throwable -> L10 Exception -> L12
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        e = move-exception;
        slogW("Failed to get top app", e);     // Catch: Throwable -> L10
        goto L14
    }

    private boolean isPlatformSigned(String packageName) {
        if (this.mContext.getPackageManager().checkSignatures(packageName, PackageManagerService.PLATFORM_PACKAGE_NAME) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMemoryEnabled() {
        slogI("isMemoryEnabled");
        boolean r1 = false;
        if (this.mContext != null) goto L5;
    L46:
        return false;
    L5:
        if (checkCallingSignature(Binder.getCallingUid()) == false) goto L7;
    L9:
        long token = Binder.clearCallingIdentity();
        KeyguardManager keyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);     // Catch: Throwable -> L17 Exception -> L19
        if (keyguardManager != null) goto L13;
    L21:
        int appState = checkAppState();     // Catch: Throwable -> L17 Exception -> L19
        slogI("appState: " + appState);     // Catch: Throwable -> L17 Exception -> L19
        if (appState == 1) goto L27;
        Binder.restoreCallingIdentity(token);
        return false;
    L27:
        if (isEnterpriseAccount() == false) goto L30;
        Binder.restoreCallingIdentity(token);
        return false;
    L30:
        PackageManager pm = this.mContext.getPackageManager();     // Catch: Throwable -> L17 Exception -> L19
        ComponentName cn = new ComponentName(MEMORY_PKG, MEMORY_ACTIVITY);     // Catch: Throwable -> L17 Exception -> L19
        int state = pm.getComponentEnabledSetting(cn);     // Catch: Throwable -> L17 Exception -> L19
        slogI("state: " + state);     // Catch: Throwable -> L17 Exception -> L19
        if (state != 2) goto L34;
    L38:
        Binder.restoreCallingIdentity(token);
        return r1;
    L34:
        if (state == 3) goto L38;
        if (state == 4) goto L38;
        r1 = true;
        goto L38
    L13:
        if (keyguardManager.isKeyguardLocked() == false) goto L21;
        slogI("memory disabled when keyguard is locked");     // Catch: Throwable -> L17 Exception -> L19
        Binder.restoreCallingIdentity(token);
        return false;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L19:
        e = move-exception;
        slogW("check memory enabled error", e);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(token);
        return false;
    L7:
        if (checkCallingForeground(Binder.getCallingUid()) == true) goto L9;
        goto L9
    }

    private boolean isEnterpriseAccount() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), DOUBAO_ENTERPRISE, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int checkAppState() {
        ApplicationInfo r1 = this.mContext.getPackageManager().getApplicationInfo(MEMORY_PKG, 128);     // Catch: PackageManager.NameNotFoundException -> L6
        if (r1 == null) goto L14;
        return r1.enabled ? 1 : 0;
    L14:
        return -1;
    L9:
        slogW("memory not installed");
        return -1;
    }

    private static void slogW(String msg, Throwable tr) {
        Slog.w(TAG, msg, tr);
    }

    private static void slogW(String msg) {
        Slog.w(TAG, msg);
    }

    private static void slogI(String msg) {
        Slog.i(TAG, msg);
    }
}
