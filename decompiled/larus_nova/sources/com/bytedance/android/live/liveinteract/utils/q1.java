package com.bytedance.android.live.liveinteract.utils;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes46.dex */
public final class q1 {
    public static void a(final View r100, final int[] r101) {
        if (r100 == null) goto L12;
    L7:
        e = move-exception;
        ALogger.e("MultiLinkViewUtil", "expendTouchArea error", e);
        return;
    L4:
        if (r101.length != 4) goto L13;
        final View r102 = (View) r100.getParent();     // Catch: Exception -> L7
        r102.post(new p1(r100, r101, r102));     // Catch: Exception -> L7
        return;
    L13:
        return;
    }
}
