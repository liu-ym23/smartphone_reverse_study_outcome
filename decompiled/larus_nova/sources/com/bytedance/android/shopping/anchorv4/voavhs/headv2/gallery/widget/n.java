package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabIndicatorScrollView f169541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f169542b;

    public n(TabIndicatorScrollView r100, b r101) {
        this.f169541a = r100;
        this.f169542b = r101;
    }

    public final void a() {
        TabIndicatorScrollView r100 = this.f169541a;
        int r101 = TabIndicatorScrollView.f169460f;
        r100.a();
        View r102 = this.f169541a.f169461a;
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.f169542b != null) goto L8;
    L12:
        this.f169541a.b();
        return;
    L8:
        if (r102.getMeasuredWidth() <= this.f169541a.getWidth()) goto L12;
        int r103 = (this.f169542b.getLeft() + (this.f169542b.getWidth() / 2)) - (this.f169541a.getWidth() / 2);
        TabIndicatorScrollView r104 = this.f169541a;
        r104.getClass();
        r104.smoothScrollTo(RangesKt.coerceIn(r103, 0, RangesKt.coerceAtLeast(r102.getMeasuredWidth() - r104.getWidth(), 0)), 0);
        this.f169541a.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
