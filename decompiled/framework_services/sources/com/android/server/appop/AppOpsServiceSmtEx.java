package com.android.server.appop;

import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Build;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.app.IAppOpsServiceSmtEx;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.PackageStateInternal;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsServiceSmtEx extends IAppOpsServiceSmtEx.Stub {
    private static final String TAG = "AppOpsServiceSmtEx";
    private static final int UID_ANY = 2;
    protected boolean mEnabled;
    private boolean mIsMute;
    private Pair<String, Integer> mLastMuteApp;
    private final HashMap<String, Integer> mMutedApps;
    private AppOpsService mService;

    public AppOpsServiceSmtEx(AppOpsService service) {
        this.mEnabled = true;
        this.mMutedApps = new HashMap();
        this.mLastMuteApp = null;
        this.mIsMute = false;
        this.mService = service;
    }

    public boolean setEnabled(boolean enable) {
        this.mService.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        AppOpsService r0 = this.mService;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Build.IS_USER == false) goto L14;
        if (Build.IS_DEBUGGABLE == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L14:
        if (this.mEnabled == enable) goto L16;
        this.mEnabled = enable;     // Catch: Throwable -> L11
        this.mService.scheduleFastWriteLocked();     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return this.mEnabled;
    }

    public boolean getEnabled() {
        if (Build.IS_USER == false) goto L9;
        if (Build.IS_DEBUGGABLE == true) goto L9;
        return true;
    L9:
        return this.mEnabled;
    }

    protected boolean canIgnoreCheckOp(int code, int uid, String packageName) {
        boolean ignore = false;
        if (code == 23) goto L5;
        return false;
    L5:
        if (packageName == null) goto L19;
        long ident = Binder.clearCallingIdentity();
        PackageStateInternal state = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageStateInternal(packageName);     // Catch: Throwable -> L10
        if (state == null) goto L13;
        ignore = state.isSystem();     // Catch: Throwable -> L10
    L13:
        if (ignore == false) goto L15;
        Slog.d("AppOps", "canIgnoreCheckOp: allowing code " + code + " uid " + uid + " package " + packageName + " isSystem " + ignore);     // Catch: Throwable -> L10
    L15:
        Binder.restoreCallingIdentity(ident);
        return ignore;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L19:
        return false;
    }

    public boolean isMutedApp(int uid, String packageName) {
        HashMap<String, Integer> r0 = this.mMutedApps;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsMute == true) goto L7;
    L13:
        boolean r1 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        if (this.mLastMuteApp == null) goto L13;
        if (((String) this.mLastMuteApp.first).equals(packageName) == false) goto L13;
        r1 = true;
        goto L14
    }
}
