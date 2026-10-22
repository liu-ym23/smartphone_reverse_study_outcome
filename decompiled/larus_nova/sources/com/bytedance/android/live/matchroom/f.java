package com.bytedance.android.live.matchroom;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f82876a;

    public static final class a {
    }

    static {
    }

    public f(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "playerVisibleRect");
        this.f82876a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        if (r100 == null) goto L7;
        Rect r102 = new Rect();
        r102.set(this.f82876a);
        r102.left -= 5;
        r102.right += 5;
        r102.top -= 5;
        r102.bottom += 5;
        if (r101 == null) goto L8;
        r101.setRoundRect(r102, 0.0f);
        return;
    L8:
        return;
    }
}
