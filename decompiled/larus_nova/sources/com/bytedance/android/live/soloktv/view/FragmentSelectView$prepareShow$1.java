package com.bytedance.android.live.soloktv.view;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2;
import com.larus.apm.impl.protector.RunnableProtector;
import fd2.a0;

/* JADX INFO: loaded from: classes7.dex */
public final class FragmentSelectView$prepareShow$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentSelectView f101697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f101698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f101699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f101700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0 f101701e;

    public FragmentSelectView$prepareShow$1(FragmentSelectView r100, long r101, long r102, boolean r103, a0 r104) {
        this.f101697a = r100;
        this.f101698b = r101;
        this.f101699c = r102;
        this.f101700d = r103;
        this.f101701e = r104;
    }

    public final void a() {
        fd2.l r100 = FragmentSelectView.b(this.f101697a);
        if (r100 == null) goto L5;
        final KtvScrollLyricViewV2 r101 = r100.getRenderView();
    L6:
        fd2.l r102 = FragmentSelectView.b(this.f101697a);
        if (r102 == null) goto L9;
        r102.c(new AnonymousClass1(this, r101));
    L9:
        fd2.l r103 = FragmentSelectView.b(this.f101697a);
        if (r103 == null) goto L12;
        r103.k(this.f101701e);
    L12:
        fd2.l r104 = FragmentSelectView.b(this.f101697a);
        if (r104 == null) goto L15;
        r104.p();
    L15:
        if (r101 == null) goto L24;
        ViewGroup r105 = this.f101697a.f101675e;
        if (r105 == null) goto L19;
        r105.addView(r101, new ViewGroup.LayoutParams(-1, -2));
    L19:
        NotInterceptMoveNestedScrollView r106 = this.f101697a.f101677g;
        if (r106 == null) goto L22;
        r106.setScrollChildView(r101);
    L22:
        r101.setFocusable(false);
        return;
    L24:
        return;
    L5:
        r101 = null;
        goto L6
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
