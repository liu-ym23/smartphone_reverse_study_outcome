package com.bytedance.android.window.shop.home.presenter;

import android.animation.Animator;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbsWindowFloatPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f188260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f188261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f188262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f188263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f188264i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsWindowFloatPresenter f188265a;

        public a(AbsWindowFloatPresenter r100) {
            this.f188265a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((h2) this.f188265a.f188262g.getValue()).onClick();
        }
    }

    public abstract boolean D();

    public abstract h2 E();

    public abstract i2 F();

    public final i2 G() {
        return (i2) this.f188261f.getValue();
    }

    public void K(int r100) {
    }

    public final LifecycleOwner I() {
        Fragment r100 = this.f188260e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ECQuickUtilKt.a(u());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        if (Intrinsics.areEqual(this.f188263h, Boolean.TRUE) == true) goto L5;
    L40:
        int r100 = 4;
    L42:
        if (y().getVisibility() == r100) goto L59;
        y().setVisibility(r100);
        if (r100 != 0) goto L56;
        View r101 = y();
        Integer r102 = (Integer) G().a().getValue();
        if (r102 == null) goto L51;
        if (r102.intValue() != 0) goto L51;
    L54:
        float r103 = 1.0f;
    L55:
        r101.setAlpha(r103);
        ((h2) this.f188262g.getValue()).a();
    L57:
        K(y().getVisibility());
        return;
    L51:
        if (G().a().getValue() == 0) goto L54;
        r103 = 0.5f;
        goto L55
    L56:
        ((h2) this.f188262g.getValue()).onHidden();
        goto L57
    L59:
        return;
    L5:
        if (D() == false) goto L40;
        r100 = 0;
        if (G().f().getValue() == 0) goto L37;
        T r104 = G().f().getValue();
        if ((r104 instanceof Pair) == false) goto L24;
        Pair r105 = (Pair) r104;
        if ((r105.getFirst() instanceof Integer) == false) goto L24;
        if ((r105.getSecond() instanceof Integer) == false) goto L24;
        Object r106 = r105.getFirst();
        if (r106 == null) goto L22;
        float r107 = Math.abs(((Integer) r106).intValue()) + G().d();
        Object r108 = r105.getSecond();
        if (r108 == null) goto L20;
        float r109 = r107 / Math.abs(((Integer) r108).intValue());
    L34:
        if (r109 > 0.95f) goto L37;
        boolean r110 = false;
    L38:
        if (r110 == false) goto L40;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L24:
        if ((r104 instanceof Triple) == false) goto L32;
        Triple r111 = (Triple) r104;
        if ((r111.getThird() instanceof Float) == false) goto L32;
        Object r112 = r111.getThird();
        if (r112 == null) goto L31;
        r109 = ((Float) r112).floatValue();
        goto L34
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L32:
        r109 = 0.0f;
    L37:
        r110 = true;
        goto L38
    }

    public AbsWindowFloatPresenter() {
        this.f188261f = LazyKt.lazy(new AbsWindowFloatPresenter$viewModelAdapter$2(this));
        this.f188262g = LazyKt.lazy(new AbsWindowFloatPresenter$behavior$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public void A(QModel r100) {
        this.f188263h = Boolean.TRUE;
        y().setOnClickListener(new a(this));
        G().f().a(I(), new com.bytedance.android.window.shop.home.presenter.a(this), false);
        zn.b r101 = G().b();
        if (r101 == null) goto L5;
        r101.a(I(), new b(this), false);
    L5:
        G().a().a(I(), new d(this), false);
    }
}
