package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowCroppedStyleAnimationPresenter extends AbsECWindowPresenter {
    public static final /* synthetic */ int B = 0;
    public boolean A;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f188267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f188268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f188269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f188270p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f188271q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f188272r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f188273s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f188274t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f188275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f188276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f188277w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f188278x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f188279y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f188280z;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter f188281a;

        public a(ECWindowCroppedStyleAnimationPresenter r100) {
            this.f188281a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((uq3.a) r100).f551202a == null) goto L11;
            ECWindowCroppedStyleAnimationPresenter r101 = this.f188281a;
            View r102 = com.bytedance.android.ec.window.base.utils.c.a((ViewGroup) r101.f188269o.getValue(), ECWindowCroppedStyleAnimationPresenter$initUIOnce$1.INSTANCE);
            if (r102 == null) goto L9;
            r101.f188275u = r102;
            r101.c0().post(new l(r101));
        L9:
            this.f188281a.O().getCollapseProgress().observe(this.f188281a.U(), new m(this));
            this.f188281a.c0().post(new n(this));
            return;
        }
    }

    public final ViewGroup b0() {
        return (ViewGroup) this.f188267m.getValue();
    }

    public final ViewGroup c0() {
        return (ViewGroup) this.f188268n.getValue();
    }

    public final ViewGroup d0() {
        return (ViewGroup) this.f188270p.getValue();
    }

    public final View e0() {
        return (View) this.f188271q.getValue();
    }

    public ECWindowCroppedStyleAnimationPresenter() {
        this.f188267m = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$croppedHeaderContainer$2(this));
        this.f188268n = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$fullscreenHeaderContainer$2(this));
        this.f188269o = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$headerContainer$2(this));
        this.f188270p = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$pinListContainer$2(this));
        this.f188271q = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$topbarContainer$2(this));
        this.f188272r = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$bgContainer$2(this));
        this.f188273s = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$adjustCard$2(this));
        this.f188274t = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$tabContainer$2(this));
    }

    public static final void Z(ECWindowCroppedStyleAnimationPresenter r100) {
        r100.f188279y = r100.f188277w - r100.f188278x;
        wg.a.d((View) r100.f188273s.getValue(), r100.f188279y);
        ((View) r100.f188274t.getValue()).setTranslationY(-r100.f188279y);
        r100.d0().setTranslationY(-r100.f188279y);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        wg.a.f(b0(), 0, G(), 0, 0);
        ViewExtensionsKt.g(b0(), 20.0f, 20.0f, 0.0f, 0.0f);
        b0().setVisibility(0);
        O().getHeaderResponse().a(U(), new a(this), false);
    }

    public final void a0(float r100) {
        if (this.A == false) goto L5;
        b0().setVisibility(0);
        this.A = false;
    L5:
        c0().setVisibility(0);
        c0().setAlpha(r100);
        e0().setVisibility(0);
        e0().setAlpha(r100);
        View r101 = this.f188275u;
        if (r101 == null) goto L8;
        r101.setAlpha(1 - r100);
    L8:
        float r102 = 1 - r100;
        ((View) this.f188274t.getValue()).setTranslationY(-(this.f188279y * r102));
        d0().setTranslationY(-(this.f188279y * r102));
    }
}
