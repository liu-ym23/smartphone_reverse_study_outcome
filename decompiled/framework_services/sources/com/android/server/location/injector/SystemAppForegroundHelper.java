package com.android.server.location.injector;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.SysOptBridge;
import com.android.server.location.IAppForegroundHelperOptEx;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAppForegroundHelper extends AppForegroundHelper {
    private ActivityManager mActivityManager;
    private final Context mContext;
    IAppForegroundHelperOptEx mOptEx;

    public static /* synthetic */ void $r8$lambda$UCfitvFhYxwpzpERUdvbWiHsEkc(SystemAppForegroundHelper r0, int r1, boolean r2) {
        r0.lambda$onAppForegroundChanged$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$kCA01rHRoDFHvlSG_pyah-tjHeE, reason: not valid java name */
    public static /* synthetic */ void m5376$r8$lambda$kCA01rHRoDFHvlSG_pyahtjHeE(SystemAppForegroundHelper r0, int r1, int r2) {
        r0.onAppForegroundChanged(r1, r2);
    }

    public SystemAppForegroundHelper(Context context) {
        this.mContext = context;
    }

    public void onSystemReady() {
        if (this.mActivityManager == null) goto L5;
        return;
    L5:
        ActivityManager r0 = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        r0.getClass();
        this.mActivityManager = r0;
        this.mActivityManager.addOnUidImportanceListener(new SystemAppForegroundHelper$$ExternalSyntheticLambda0(this), 125);
        this.mOptEx = SysOptBridge.getFactory().getAppForegroundHelperOptEx();
        this.mOptEx.init(this);
        this.mOptEx.onSystemReady();
    }

    private void onAppForegroundChanged(final int uid, int importance) {
        final boolean foreground = AppForegroundHelper.isForeground(importance);
        FgThread.getHandler().post(new SystemAppForegroundHelper$$ExternalSyntheticLambda1(this, uid, foreground));
    }

    private /* synthetic */ void lambda$onAppForegroundChanged$0(int uid, boolean foreground) {
        notifyAppForeground(uid, foreground);
    }

    @Override // com.android.server.location.injector.AppForegroundHelper
    public boolean isAppForeground(int uid) {
        if (this.mActivityManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        long identity = Binder.clearCallingIdentity();
        boolean r2 = AppForegroundHelper.isForeground(this.mActivityManager.getUidImportance(uid));     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return r2;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }
}
