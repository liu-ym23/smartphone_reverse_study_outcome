package com.bytedance.android.live.revlink.impl.lynxcontainer;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final void a(b r100, FrameLayout.LayoutParams r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "lynxViewParams");
        Intrinsics.checkNotNullParameter(r101, "lp");
        if (r100.q() <= 0) goto L5;
        int r104 = s1.f(r100.q());
    L7:
        if (r100.a() <= 0) goto L9;
        int r105 = s1.f(r100.a());
    L10:
        r101.width = r104;
        r101.height = r105;
        int r106 = r100.c();
        if (r106 == 2) goto L15;
        if (r106 == 3) goto L14;
        int r107 = 3;
    L16:
        int r108 = r100.p();
        if (r108 == 2) goto L21;
        if (r108 == 3) goto L20;
        int r109 = 48;
    L22:
        r101.gravity = r107 | r109;
        r101.leftMargin = s1.f(r100.h());
        r101.topMargin = s1.f(r100.l());
        r101.rightMargin = s1.f(r100.j());
        r101.bottomMargin = s1.f(r100.f());
        return;
    L20:
        r109 = 80;
        goto L22
    L21:
        r109 = 16;
        goto L22
    L14:
        r107 = 5;
        goto L16
    L15:
        r107 = 1;
        goto L16
    L9:
        r105 = (int) (r100.b() * r103);
        goto L10
    L5:
        r104 = (int) (r100.r() * r102);
        goto L7
    }
}
