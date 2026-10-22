package com.bytedanceos.common.ad;

import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ui.listener.AppStateHelper;

/* JADX INFO: loaded from: classes2.dex */
public class Ad {
    private static volatile Ad sInstance;
    private long mLastElapsedTime;

    private Ad() {
        this.mLastElapsedTime = 0;
    }

    public static /* synthetic */ long access$002(Ad r10, long r11) {
        r10.mLastElapsedTime = r11;
        return r11;
    }

    public static Ad getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(Ad.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new Ad();     // Catch: Throwable -> L9
    L11:
        monitor-exit(Ad.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void init() {
        AppStateHelper.getInstance().addListener(new AnonymousClass1(this));
    }

    public boolean isTimeAd() {
        if ((System.currentTimeMillis() - this.mLastElapsedTime) <= AdConstant.SPLASH_AD_INTERVAL) goto L5;
        return true;
    L5:
        return false;
    }
}
