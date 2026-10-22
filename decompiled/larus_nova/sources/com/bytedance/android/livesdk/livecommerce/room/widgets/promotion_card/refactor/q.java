package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f152505a;

    static {
        f152505a = true;
    }

    public static boolean a(long r100, long r101) {
        Handler r102 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
        long r103 = SystemClock.elapsedRealtime();
        if (r101 > r100) goto L5;
    L9:
        return false;
    L5:
        if (r103 < r100) goto L9;
        if (r103 > r101) goto L9;
        return true;
    }
}
