package com.bytedance.android.live.broadcastgame.xplay;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static final Rect a(j r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$makeRect");
        Rect r104 = new Rect();
        boolean r105 = true;
        if ((r103 & 4) == 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L8;
        r104.left = r101;
        r104.right = r101 + r100.f62186a;
    L16:
        if ((r103 & 8) == 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L21;
        r104.top = r102;
        r104.bottom = r102 + r100.f62187b;
    L28:
        return r104;
    L21:
        if ((r103 & 2) != 0) goto L24;
        r105 = false;
    L24:
        if (r105 == false) goto L26;
        int r108 = r100.f62187b;
        int r109 = r102 - (r108 / 2);
        r104.top = r109;
        r104.bottom = r109 + r108;
        goto L28
    L26:
        r104.top = r102 - r100.f62187b;
        r104.bottom = r102;
        goto L28
    L18:
        r107 = false;
        goto L19
    L8:
        if ((r103 & 1) == 0) goto L10;
        boolean r110 = true;
    L11:
        if (r110 == false) goto L13;
        int r111 = r100.f62186a;
        int r112 = r101 - (r111 / 2);
        r104.left = r112;
        r104.right = r112 + r111;
        goto L16
    L13:
        r104.left = r101 - r100.f62186a;
        r104.right = r101;
        goto L16
    L10:
        r110 = false;
        goto L11
    L5:
        r106 = false;
        goto L6
    }
}
