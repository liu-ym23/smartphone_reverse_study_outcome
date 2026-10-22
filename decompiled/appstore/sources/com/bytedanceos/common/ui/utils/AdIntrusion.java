package com.bytedanceos.common.ui.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.bytedanceos.common.ui.SplashActivity;
import com.bytedanceos.common.ui.listener.AppStateHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AdIntrusion {
    private static volatile AdIntrusion sInstance;
    private boolean isEnable;

    private AdIntrusion() {
        this.isEnable = false;
    }

    public static /* synthetic */ void a(AdIntrusion r10, Activity r11) {
        r10.lambda$intrudeSplash$0(r11);
    }

    public static AdIntrusion getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(AdIntrusion.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AdIntrusion();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AdIntrusion.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private /* synthetic */ void lambda$intrudeSplash$0(Activity r10) {
        startSplash(r10);
        r10.overridePendingTransition(0, 0);
    }

    private void startSplash(Activity r10) {
        Intent r11 = new Intent(r10, SplashActivity.class);
        r11.putExtra(SplashActivity.EXTRA_INTRUSION, true);
        r10.startActivity(r11);
    }

    public void intrudeSplash(final Activity r10) {
        if ((r10 instanceof SplashActivity) == false) goto L6;
        return;
    L6:
        if (AppStateHelper.getInstance().isHotBoot() == false) goto L8;
        new Handler(r10.getMainLooper()).postDelayed(new a(this, r10), 200);
        return;
    L8:
        startSplash(r10);
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean r10) {
        this.isEnable = r10;
    }
}
