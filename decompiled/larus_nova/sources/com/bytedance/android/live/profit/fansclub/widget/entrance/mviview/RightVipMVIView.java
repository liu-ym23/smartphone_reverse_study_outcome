package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu0.i0;
import eu0.q0;
import eu0.r0;
import eu0.s0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class RightVipMVIView extends com.bytedance.android.anya.d<eu0.f, i0, eu0.h> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f87464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Interpolator f87465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Interpolator f87466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Interpolator f87467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f87468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<Animator> f87469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f87470n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RelativeLayout f87471o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HSImageView f87472p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HSImageView f87473q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f87474r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataCenter f87475s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f87476t;

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f87470n.setOnClickListener(new w0(new RightVipMVIView$onAttach$1(this), 1000));
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r100 = fu0.b.a(this.f87475s);
        if (r100 == null) goto L5;
        boolean r101 = r100.A();
    L6:
        View r102 = this.f87470n;
        if (r101 == false) goto L9;
        int r103 = R.string.ttlive_live_subscribe_desc;
    L10:
        r3.c(r102, s1.B(r103), true);
        return;
    L9:
        r103 = R.string.ttlive_live_subscribe_join;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public final void p() {
        com.bytedance.android.live.revenue.common.o.a(this.f87473q);
        Iterator<Animator> r100 = this.f87469m.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Animator r101 = r100.next();
        r101.removeAllListeners();
        if (r101.isRunning() == false) goto L4;
        r101.cancel();
        goto L4
    L8:
        this.f87469m.clear();
        this.f87471o.setAlpha(1.0f);
        this.f87471o.getBackground().setAlpha(255);
        this.f87472p.setScaleX(1.0f);
        this.f87472p.setScaleY(1.0f);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        p();
        this.f87464h.clear();
    }

    public final Context getContext() {
        return this.f87474r;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<eu0.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        RightVipMVIView$bindToParent$1 r101 = RightVipMVIView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(com.bytedance.android.anya.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof q0) == false) goto L6;
        AnimatorSet r101 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{1.0f, 0.9f});
        r101.setDuration(150);
        r101.setInterpolator(this.f87465i);
        AnimatorSet r102 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{0.9f, 1.06f});
        r102.setDuration(200);
        r102.setInterpolator(this.f87465i);
        AnimatorSet r103 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{1.06f, 1.0f});
        r103.setDuration(150);
        r103.setInterpolator(this.f87465i);
        AnimatorSet r104 = new AnimatorSet();
        r104.playSequentially(new Animator[]{r101, r102, r103});
        r104.start();
        this.f87469m.add(r104);
        Unit r105 = Unit.INSTANCE;
        this.f87468l = r104;
        RxUtilKt.c(Observable.timer(1300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this)), this.f87464h);
    L11:
        return true;
    L6:
        if ((r100 instanceof s0) == false) goto L9;
        ObjectAnimator r106 = ObjectAnimator.ofInt(this.f87471o.getBackground(), "alpha", new int[]{255, 77, 255, 77, 255, 77, 255});
        r106.setDuration(9000);
        r106.setInterpolator(new LinearInterpolator());
        r106.start();
        this.f87469m.add(r106);
        Unit r107 = Unit.INSTANCE;
        goto L11
    L9:
        if ((r100 instanceof r0) == false) goto L13;
        this.f87471o.setBackground(s1.m(R.drawable.ttlive_user_info_vip_background_active));
        ObjectAnimator r108 = ObjectAnimator.ofInt(this.f87471o.getBackground(), "alpha", new int[]{25, 255});
        r108.setDuration(750);
        r108.start();
        this.f87469m.add(r108);
        Unit r109 = Unit.INSTANCE;
        goto L11
    L13:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r110, MVIState r111) {
        i0 r112 = (i0) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r112, "state");
        com.bytedance.android.anya.internal.r r100 = r112.f473984a;
        KProperty[] r101 = i0.f473983g;
        KProperty r102 = r101[0];
        r100.getClass();
        Object r103 = r110.f41740c.a(r100);
        int r104 = 8;
        if (r103 == null) goto L9;
        r110.f41739b.f41563a.invoke(r100);
        boolean r105 = ((Boolean) r103).booleanValue();
        ViewGroup r106 = this.f87476t;
        if (r105 == false) goto L7;
        int r107 = 0;
    L8:
        r106.setVisibility(r107);
        goto L9
    L7:
        r107 = 8;
    L9:
        com.bytedance.android.anya.internal.r r108 = r112.c();
        Object r109 = r110.f41740c.a(r108);
        if (r109 == null) goto L16;
        r110.f41739b.f41563a.invoke(r108);
        int r113 = ((Number) r109).intValue();
        HSImageView r114 = this.f87472p;
        r114.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        if (r113 == 0) goto L16;
        if (r113 == (-1)) goto L16;
        Intrinsics.checkNotNullParameter(r114, "$this$bindImage");
        ImageLoader.bindDrawableResource(r114, r113);
    L16:
        com.bytedance.android.anya.internal.r r115 = r112.f473986c;
        KProperty r116 = r101[2];
        r115.getClass();
        Object r117 = r110.f41740c.a(r115);
        if (r117 == null) goto L22;
        r110.f41739b.f41563a.invoke(r115);
        boolean r118 = ((Boolean) r117).booleanValue();
        HSImageView r119 = this.f87472p;
        if (r118 == false) goto L21;
        r104 = 0;
    L21:
        r119.setVisibility(r104);
    L22:
        com.bytedance.android.anya.internal.r r120 = r112.b();
        Object r121 = r110.f41740c.a(r120);
        if (r121 == null) goto L27;
        r110.f41739b.f41563a.invoke(r120);
        int r122 = ((Number) r121).intValue();
        if (r122 == 0) goto L27;
        this.f87471o.setBackground(s1.m(r122));
    L27:
        com.bytedance.android.anya.internal.r r123 = r112.a();
        Object r124 = r110.f41740c.a(r123);
        if (r124 == null) goto L38;
        r110.f41739b.f41563a.invoke(r123);
        int r125 = j.f87541a[((EntranceAnimState) r124).ordinal()];
        if (r125 == 1) goto L37;
        if (r125 != 2) goto L33;
        AbstractDraweeController r126 = Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q("/revenue/entrance/ttlive_user_vip_activate_shining.webp")).setControllerListener(new l(this)).setAutoPlayAnimations(true).build();
        HSImageView r127 = this.f87473q;
        r127.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r127.setController(r126);
        r127.setVisibility(0);
        final AnimatorSet r128 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{1.0f, 0.4f});
        r128.setDuration(200);
        r128.setInterpolator(this.f87465i);
        final ObjectAnimator r129 = ObjectAnimator.ofFloat(this.f87472p, "alpha", new float[]{1.0f, 0.0f});
        r129.setDuration(50);
        AnimatorSet r130 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.b(r130, new RightVipMVIView$playActivateHidingAnim$$inlined$apply$lambda$1(this, r128, r129));
        r130.playSequentially(new Animator[]{r128, r129});
        r130.start();
        this.f87469m.add(r130);
        Unit r131 = Unit.INSTANCE;
        goto L38
    L33:
        if (r125 == 3) goto L35;
        p();
        goto L38
    L35:
        final AnimatorSet r132 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{0.4f, 1.04f});
        r132.setDuration(250);
        r132.setInterpolator(this.f87466j);
        final AnimatorSet r133 = com.bytedance.android.live.revenue.common.e.c(this.f87472p, new float[]{1.04f, 0.98f, 1.005f, 1.0f});
        r133.setDuration(450);
        r133.setInterpolator(this.f87467k);
        final ObjectAnimator r134 = ObjectAnimator.ofFloat(this.f87472p, "alpha", new float[]{0.0f, 1.0f});
        r134.setDuration(100);
        AnimatorSet r135 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.b(r135, new RightVipMVIView$playActivateShowingAnim$$inlined$apply$lambda$1(this, r132, r134, r133));
        r135.play(r132).with(r134).before(r133);
        r135.start();
        this.f87469m.add(r135);
        Unit r136 = Unit.INSTANCE;
        goto L38
    L37:
        AbstractDraweeController r137 = Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q("/revenue/entrance/ttlive_user_vip_follow_anim.webp")).setAutoPlayAnimations(true).setControllerListener(new o(this)).build();
        HSImageView r138 = this.f87473q;
        r138.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r138.setController(r137);
        ObjectAnimator r139 = ObjectAnimator.ofFloat(this.f87471o, "alpha", new float[]{0.0f, 1.0f});
        r139.setDuration(300);
        r139.start();
        this.f87469m.add(r139);
        Unit r140 = Unit.INSTANCE;
    L38:
        com.bytedance.android.anya.internal.r r141 = r112.f473989f;
        KProperty r142 = r101[5];
        r141.getClass();
        Object r143 = r110.f41740c.a(r141);
        if (r143 == null) goto L42;
        r110.f41739b.f41563a.invoke(r141);
        HSImageView r144 = this.f87472p;
        r144.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        Intrinsics.checkNotNullParameter(r144, "$this$bindImage");
        ImageLoader.bindImage(r144, (py.k) r143);
        return;
    }

    public RightVipMVIView(Context r100, DataCenter r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "containerView");
        this.f87474r = r100;
        this.f87475s = r101;
        this.f87476t = r102;
        this.f87464h = new CompositeDisposable();
        this.f87465i = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        this.f87466j = PathInterpolatorCompat.create(0.26f, 0.44f, 0.48f, 1.0f);
        this.f87467k = PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f);
        this.f87469m = new ArrayList();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_user_info_mvi_right_vip, r102, true);
        this.f87470n = r103;
        this.f87471o = (RelativeLayout) r103.findViewById(R.id.vip_icon_layout);
        this.f87472p = (HSImageView) r103.findViewById(R.id.vip_icon);
        this.f87473q = (HSImageView) r103.findViewById(R.id.vip_icon_animator);
    }
}
