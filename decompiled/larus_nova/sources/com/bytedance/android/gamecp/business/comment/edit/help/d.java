package com.bytedance.android.gamecp.business.comment.edit.help;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f52134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f52135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f52136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f52137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Integer> f52138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52139f;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f52134a == true) goto L5;
        return;
    L5:
        int[] r100 = new int[2];
        this.f52136c.getLocationInWindow(r100);
        int r101 = r100[1] + this.f52136c.getHeight();
        e r102 = this.f52135b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelLocation");
    L8:
        int r103 = r102.f52141b - r101;
        e r104 = this.f52135b;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelLocation");
    L11:
        int r105 = r104.f52140a - r103;
        e r106 = this.f52135b;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelLocation");
    L14:
        Math.min(r105, r106.f52140a);
        if (r103 >= 0) goto L24;
        if (r103 < 0) goto L19;
        return;
    L19:
        if (Math.abs(r103) >= this.f52139f) goto L23;
        Math.abs(r103);
        return;
    L23:
        return;
    }

    public d(View r100, ConstraintLayout r101, Function0 r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "inputPanelContainer");
        Intrinsics.checkNotNullParameter(r102, "fetchMinPanelHeight");
        this.f52136c = r100;
        this.f52137d = r101;
        this.f52138e = r102;
        this.f52139f = r103;
        r100.post(new c(this));
    }
}
