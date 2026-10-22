package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ECShopAbsFloatPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f183856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f183857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f183858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f183859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f183860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f183861j;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAbsFloatPresenter f183862a;

        public a(ECShopAbsFloatPresenter r100) {
            this.f183862a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if ((!Intrinsics.areEqual(this.f183862a.f183859h, Boolean.TRUE)) == true) goto L7;
            this.f183862a.Q();
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAbsFloatPresenter f183863a;

        public b(ECShopAbsFloatPresenter r100) {
            this.f183863a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if ((!Intrinsics.areEqual(this.f183863a.f183859h, Boolean.TRUE)) == true) goto L7;
            this.f183863a.Q();
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAbsFloatPresenter f183864a;

        public c(ECShopAbsFloatPresenter r100) {
            this.f183864a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if ((!Intrinsics.areEqual(this.f183864a.f183859h, Boolean.TRUE)) == false) goto L5;
            return;
        L5:
            if (this.f183864a.y().getVisibility() != 0) goto L20;
            Animator r102 = this.f183864a.f183860i;
            if (r102 == null) goto L10;
            r102.cancel();
        L10:
            ECShopAbsFloatPresenter r103 = this.f183864a;
            float[] r104 = new float[2];
            r104[0] = r103.y().getAlpha();
            if (r101 != null) goto L14;
        L16:
            float r105 = 0.5f;
        L17:
            r104[1] = r105;
            ValueAnimator r106 = ValueAnimator.ofFloat(r104);
            r106.setDuration(300);
            r106.addUpdateListener(new com.bytedance.android.shopping.store.home.presenter.c(this));
            r106.start();
            Unit r107 = Unit.INSTANCE;
            r103.f183860i = r106;
            return;
        L14:
            if (r101.intValue() != 0) goto L16;
            r105 = 1.0f;
            goto L17
        }
    }

    public abstract boolean D();

    public abstract z3 E();

    public abstract a4 F();

    public final a4 G() {
        return (a4) this.f183857f.getValue();
    }

    public void O(int r100) {
    }

    public final LifecycleOwner I() {
        Fragment r100 = this.f183856e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final ECStoreViewModel N() {
        Fragment r100 = this.f183856e;
        if (r100 == null) goto L7;
        u().getClass();
        return (ECStoreViewModel) QContext.h(ECStoreViewModel.class, r100);
    L7:
        return (ECStoreViewModel) ECQuickUtilKt.c(u(), ECStoreViewModel.class);
    }

    public final void Q() {
        if (Intrinsics.areEqual(this.f183859h, Boolean.TRUE) == true) goto L5;
    L22:
        int r100 = 4;
    L24:
        if (y().getVisibility() == r100) goto L41;
        y().setVisibility(r100);
        if (r100 != 0) goto L38;
        View r101 = y();
        Integer r102 = G().a().getValue();
        if (r102 == null) goto L33;
        if (r102.intValue() != 0) goto L33;
    L36:
        float r103 = 1.0f;
    L37:
        r101.setAlpha(r103);
        ((z3) this.f183858g.getValue()).a();
    L39:
        O(y().getVisibility());
        return;
    L33:
        if (G().a().getValue() == null) goto L36;
        r103 = 0.5f;
        goto L37
    L38:
        ((z3) this.f183858g.getValue()).onHidden();
        goto L39
    L41:
        return;
    L5:
        if (D() == false) goto L22;
        jm.a<Float> r104 = G().c();
        Float r105 = null;
        if (r104 == null) goto L9;
        Float r106 = r104.getValue();
    L10:
        r100 = 0;
        if (r106 == null) goto L19;
        jm.a<Float> r107 = G().c();
        if (r107 == null) goto L16;
        r105 = r107.getValue();
    L16:
        if (com.bytedance.android.shopping.extensions.k.d(r105) > 0.95f) goto L19;
        boolean r108 = false;
    L20:
        if (r108 == false) goto L22;
    L19:
        r108 = true;
        goto L20
    L9:
        r106 = null;
        goto L10
    }

    public ECShopAbsFloatPresenter() {
        this.f183857f = LazyKt.lazy(new ECShopAbsFloatPresenter$viewModelAdapter$2(this));
        this.f183858g = LazyKt.lazy(new ECShopAbsFloatPresenter$behavior$2(this));
        this.f183861j = LazyKt.lazy(new ECShopAbsFloatPresenter$topTipsH$2(this));
    }

    public final void K() {
        jm.a<Float> r100 = G().c();
        if (r100 == null) goto L5;
        r100.a(I(), new a(this), false);
    L5:
        jm.a<Pair<Integer, Integer>> r101 = G().b();
        if (r101 == null) goto L8;
        r101.a(I(), new b(this), false);
    L8:
        G().a().a(I(), new c(this), false);
    }

    public ECShopAbsFloatPresenter(Fragment r100) {
        this();
        this.f183856e = r100;
    }
}
