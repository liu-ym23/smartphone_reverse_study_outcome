package com.android.server.location.injector;

import android.app.AppOpsManager;
import android.content.Context;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAppOpsHelper extends AppOpsHelper {
    private AppOpsManager mAppOps;
    private final Context mContext;

    public static /* synthetic */ void $r8$lambda$dkvV9ErqRUvUhFKYCKm0OGHp7dQ(SystemAppOpsHelper r0, String r1) {
        r0.lambda$onSystemReady$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$nvkNbjGehQgduXV6waQG27WlKTE(SystemAppOpsHelper r0, String r1, String r2) {
        r0.lambda$onSystemReady$1(r1, r2);
    }

    public SystemAppOpsHelper(Context context) {
        this.mContext = context;
    }

    public void onSystemReady() {
        if (this.mAppOps == null) goto L5;
        return;
    L5:
        AppOpsManager r0 = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        r0.getClass();
        this.mAppOps = r0;
        this.mAppOps.startWatchingMode(0, null, 1, new SystemAppOpsHelper$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$onSystemReady$0(String packageName) {
        notifyAppOpChanged(packageName);
    }

    private /* synthetic */ void lambda$onSystemReady$1(String op, final String packageName) {
        FgThread.getHandler().post(new SystemAppOpsHelper$$ExternalSyntheticLambda0(this, packageName));
    }

    @Override // com.android.server.location.injector.AppOpsHelper
    public boolean startOpNoThrow(int appOp, CallerIdentity callerIdentity) {
        boolean r1 = false;
        if (this.mAppOps == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        if (this.mAppOps.startOpNoThrow(appOp, callerIdentity.getUid(), callerIdentity.getPackageName(), false, callerIdentity.getAttributionTag(), callerIdentity.getListenerId()) != 0) goto L12;
        r1 = true;
    L12:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L14:
        th = move-exception;
        Throwable r13 = th;
    L18:
        Binder.restoreCallingIdentity(identity);
        throw r13;
    L16:
        th = move-exception;
        r13 = th;
        goto L18
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.AppOpsHelper
    public void finishOp(int appOp, CallerIdentity callerIdentity) {
        if (this.mAppOps == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        this.mAppOps.finishOp(appOp, callerIdentity.getUid(), callerIdentity.getPackageName(), callerIdentity.getAttributionTag());     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.AppOpsHelper
    public boolean checkOpNoThrow(int appOp, CallerIdentity callerIdentity) {
        boolean r1 = false;
        if (this.mAppOps == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        if (this.mAppOps.checkOpNoThrow(appOp, callerIdentity.getUid(), callerIdentity.getPackageName()) != 0) goto L10;
        r1 = true;
    L10:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.AppOpsHelper
    public boolean noteOp(int appOp, CallerIdentity callerIdentity) {
        boolean r1 = false;
        if (this.mAppOps == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        if (this.mAppOps.noteOp(appOp, callerIdentity.getUid(), callerIdentity.getPackageName(), callerIdentity.getAttributionTag(), callerIdentity.getListenerId()) != 0) goto L12;
        r1 = true;
    L12:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L14:
        th = move-exception;
        Throwable r12 = th;
    L18:
        Binder.restoreCallingIdentity(identity);
        throw r12;
    L16:
        th = move-exception;
        r12 = th;
        goto L18
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.AppOpsHelper
    public boolean noteOpNoThrow(int appOp, CallerIdentity callerIdentity) {
        boolean r1 = false;
        if (this.mAppOps == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        if (this.mAppOps.noteOpNoThrow(appOp, callerIdentity.getUid(), callerIdentity.getPackageName(), callerIdentity.getAttributionTag(), callerIdentity.getListenerId()) != 0) goto L12;
        r1 = true;
    L12:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L14:
        th = move-exception;
        Throwable r12 = th;
    L18:
        Binder.restoreCallingIdentity(identity);
        throw r12;
    L16:
        th = move-exception;
        r12 = th;
        goto L18
    L5:
        r0 = false;
        goto L6
    }
}
