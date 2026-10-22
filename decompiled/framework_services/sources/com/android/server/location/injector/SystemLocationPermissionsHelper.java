package com.android.server.location.injector;

import android.content.Context;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemLocationPermissionsHelper extends LocationPermissionsHelper {
    private final Context mContext;
    private boolean mInited;

    /* JADX INFO: renamed from: $r8$lambda$69whf7fxrgt3X1t-xmayB69ehXk, reason: not valid java name */
    public static /* synthetic */ void m5377$r8$lambda$69whf7fxrgt3X1txmayB69ehXk(SystemLocationPermissionsHelper r0, int r1) {
        r0.lambda$onSystemReady$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$tARrIpyJNn5uQPhL2s0tm7Ev13I(SystemLocationPermissionsHelper r0, int r1) {
        r0.lambda$onSystemReady$1(r1);
    }

    public SystemLocationPermissionsHelper(Context context, AppOpsHelper appOps) {
        super(appOps);
        this.mContext = context;
    }

    public void onSystemReady() {
        if (this.mInited == false) goto L5;
        return;
    L5:
        this.mContext.getPackageManager().addOnPermissionsChangeListener(new SystemLocationPermissionsHelper$$ExternalSyntheticLambda0(this));
        this.mInited = true;
    }

    private /* synthetic */ void lambda$onSystemReady$0(int uid) {
        notifyLocationPermissionsChanged(uid);
    }

    private /* synthetic */ void lambda$onSystemReady$1(final int uid) {
        FgThread.getHandler().post(new SystemLocationPermissionsHelper$$ExternalSyntheticLambda1(this, uid));
    }

    @Override // com.android.server.location.injector.LocationPermissionsHelper
    protected boolean hasPermission(String permission, CallerIdentity callerIdentity) {
        long identity = Binder.clearCallingIdentity();
        if (this.mContext.checkPermission(permission, callerIdentity.getPid(), callerIdentity.getUid()) != 0) goto L6;
        boolean r2 = true;
    L7:
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
