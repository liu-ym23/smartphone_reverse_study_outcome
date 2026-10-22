package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.view.ECWindowRemoteVideoView;
import com.bytedance.android.ec.window.base.view.ECWindowVideoView;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.bytedance.android.window.shop.innerflow.widget.ControllerType;
import com.bytedance.android.window.shop.innerflow.widget.ECControllerViewGroup;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowVideoElementPresenter extends d<wp3.g> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<ControllerState, Integer> f189124r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<ControllerState, Integer> f189125s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f189126t = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wp3.g f189127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f189128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f189129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f189130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f189131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f189132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f189133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f189134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f189135o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final vp.c f189136p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final vp.c f189137q;

    public static final class a {
        public a() {
        }

        public static ControllerState a(ControllerState r100) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            int r101 = h.f189157a[r100.ordinal()];
            if (r101 == 1) goto L10;
            if (r101 != 2) goto L8;
            return ControllerState.ENABLED;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return ControllerState.DISABLED;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowInnerFlowVideoElementPresenter f189138a;

        public b(ECWindowInnerFlowVideoElementPresenter r100) {
            this.f189138a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ControllerState r101 = (ControllerState) r100;
            Intrinsics.checkNotNullParameter(r101, "newState");
            this.f189138a.F().c(ControllerType.BARRAGE, r101);
            this.f189138a.I(r101);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowInnerFlowVideoElementPresenter f189139a;

        public c(ECWindowInnerFlowVideoElementPresenter r100) {
            this.f189139a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ControllerState r101 = (ControllerState) r100;
            Intrinsics.checkNotNullParameter(r101, "newState");
            this.f189139a.F().c(ControllerType.VOLUME, r101);
            this.f189139a.K(r101);
        }
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        this.f189127g = null;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r100 = G();
        r100.getClass();
        r100.B();
        r100.z();
        ((QLiveData) this.f189129i.getValue()).f(this.f189135o);
        ((QLiveData) this.f189130j.getValue()).f(this.f189134n);
    }

    public final ECControllerViewGroup F() {
        return (ECControllerViewGroup) this.f189131k.getValue();
    }

    public final com.bytedance.android.ec.window.base.utils.playable.impl.video.d G() {
        return (com.bytedance.android.ec.window.base.utils.playable.impl.video.d) this.f189133m.getValue();
    }

    static {
        f189126t = new a();
        ControllerState r100 = ControllerState.ENABLED;
        ControllerState r101 = ControllerState.DISABLED;
        f189124r = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, Integer.valueOf(R.drawable.ec_shop_ic_volumn_on)), TuplesKt.to(r101, Integer.valueOf(R.drawable.ec_shop_ic_volumn_off))});
        f189125s = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, Integer.valueOf(R.drawable.ec_shop_ic_barrage_on)), TuplesKt.to(r101, Integer.valueOf(R.drawable.ec_shop_ic_barrage_off))});
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.g r110) {
        wp3.g r111 = r110;
        this.f189136p.f556543a = G();
        this.f189127g = r111;
        ControllerState r100 = (ControllerState) ((QLiveData) this.f189129i.getValue()).a();
        if (r100 != null) goto L5;
        r100 = ControllerState.ENABLED;
    L5:
        K(r100);
        ECControllerViewGroup r101 = F();
        ControllerType r102 = ControllerType.VOLUME;
        r101.c(r102, r100);
        if (r111 == null) goto L10;
        String r112 = r111.f560588b;
        if (r112 == null) goto L10;
        com.bytedance.android.ec.window.base.utils.playable.impl.video.d r103 = G();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r112, "source");
        r103.f49753c = r112;
    L10:
        List<? extends ControllerType> r104 = CollectionsKt.mutableListOf(new ControllerType[]{r102});
        wp3.g r105 = this.f189127g;
        if (r105 == null) goto L16;
        if (r105.f560587a != true) goto L16;
        r104.add(ControllerType.BARRAGE);
    L16:
        if (F().b(r104) == true) goto L26;
        F().removeAllViews();
        Iterator<T> r106 = r104.iterator();
    L19:
        if (r106.hasNext() == false) goto L26;
        ControllerType r107 = (ControllerType) r106.next();
        if (r107 != ControllerType.VOLUME) goto L24;
        F().a(r107, f189124r, ControllerState.ENABLED, new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1(f189126t), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$2(this), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$3(this));
    L24:
        if (r107 != ControllerType.BARRAGE) goto L19;
        F().a(r107, f189125s, ControllerState.ENABLED, new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$4(f189126t), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$5(this), new ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$6(this));
    L26:
        ((QLiveData) this.f189129i.getValue()).c(ECQuickUtilKt.a(u()), this.f189135o, true);
        ((QLiveData) this.f189130j.getValue()).c(ECQuickUtilKt.a(u()), this.f189134n, true);
        wp3.g r113 = this.f189127g;
        if (r113 == null) goto L56;
        String r108 = r113.f560589c;
        if (r108 == null) goto L31;
        ((ECWindowRemoteVideoView) this.f189132l.getValue()).setCoverUrl(r108);
    L31:
        ECWindowRemoteVideoView r109 = (ECWindowRemoteVideoView) this.f189132l.getValue();
        ViewGroup.LayoutParams r114 = ((ECWindowRemoteVideoView) this.f189132l.getValue()).getLayoutParams();
        if (r114 == null) goto L55;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        int r116 = r113.f560590d;
        int r117 = r113.f560591e;
        if (r116 <= 0) goto L43;
        if (r117 <= 0) goto L40;
        float r118 = r116 / r117;
        if (r118 > 1.3333334f) goto L40;
        if (r118 < 0.75f) goto L43;
        String r119 = "H," + r116 + ':' + r117;
    L45:
        r115.dimensionRatio = r119;
        Unit r120 = Unit.INSTANCE;
        r109.setLayoutParams(r115);
        ECWindowRemoteVideoView r121 = (ECWindowRemoteVideoView) this.f189132l.getValue();
        wp3.g r122 = this.f189127g;
        if (r122 == null) goto L64;
        float r123 = r122.f560590d / r122.f560591e;
        if (r123 <= 1.3333334f) goto L52;
        r121.setScaleType(ECWindowVideoView.ScaleType.FIT_CENTER);
    L52:
        if (r123 >= 0.75f) goto L62;
        r121.setScaleType(ECWindowVideoView.ScaleType.CENTER_CROP);
        return;
    L62:
        return;
    L64:
        return;
    L40:
        r119 = "H,4:3";
    L43:
        r119 = "H,3:4";
        goto L45
    L55:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void I(ControllerState r100) {
        if (r100 != ControllerState.DISABLED) goto L8;
        vp.c r101 = this.f189137q;
        if (r101 == null) goto L13;
        r101.stopPlay();
        return;
    L13:
        return;
    L8:
        if (G().isPlaying() == false) goto L15;
        vp.c r102 = this.f189137q;
        if (r102 == null) goto L16;
        r102.startPlay();
        return;
    L16:
        return;
    }

    public final void K(ControllerState r100) {
        int r101 = i.f189158a[r100.ordinal()];
        if (r101 != 1) goto L5;
        ECVideoPlayer r102 = G().b();
        if (r102 == null) goto L16;
        r102.o(false);
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L17;
        ECVideoPlayer r103 = G().b();
        if (r103 == null) goto L14;
        r103.o(true);
        return;
    L14:
        return;
    }

    public ECWindowInnerFlowVideoElementPresenter(vp.c r100, vp.c r101) {
        Intrinsics.checkNotNullParameter(r100, "videoPlayerProxy");
        super(yp3.h.f568704a);
        this.f189136p = r100;
        this.f189137q = r101;
        this.f189128h = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$viewModel$2(this));
        this.f189129i = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$volumeState$2(this));
        this.f189130j = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$barrageState$2(this));
        this.f189131k = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$controllerGroup$2(this));
        this.f189132l = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$videoView$2(this));
        this.f189133m = LazyKt.lazy(new ECWindowInnerFlowVideoElementPresenter$ecVideoViewPlayable$2(this));
        this.f189134n = new b(this);
        this.f189135o = new c(this);
    }
}
