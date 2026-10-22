package com.bytedance.android.shopping.anchorv4.components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.PdpTaskManager;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.LengthenedCompatDraweeView;
import com.bytedance.android.shopping.anchorv4.voavhs.headgausee.HeadGaussItemView;
import com.bytedance.android.shopping.anchorv4.widgets.WireFrameViewV2;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class WireframeComponent extends b73.a implements a73.n, com.bytedance.android.shopping.anchorv4.vm.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f166044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f166045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LengthenedCompatDraweeView f166046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f166047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f166048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f166049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f166050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HeadGaussItemView f166051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Pair<String, Boolean> f166052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f166053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f166054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnchorV4VM f166055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.containers.g f166056o;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WireframeComponent f166057a;

        public a(WireframeComponent r100) {
            this.f166057a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            System.currentTimeMillis();
            this.f166057a.f166054m.setVisibility(8);
            this.f166057a.n0(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            System.currentTimeMillis();
            super.onAnimationStart(r100);
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f166058a;

        public static final class a<T> implements com.bytedance.android.ec.core.utils.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f166059a;

            public a(ObservableEmitter r100) {
                this.f166059a = r100;
            }

            @Override // com.bytedance.android.ec.core.utils.o
            public final void accept(Object r100) {
                Bitmap r101 = (Bitmap) r100;
                if (this.f166059a.isDisposed() == true) goto L8;
                if (r101 == null) goto L6;
                this.f166059a.onNext(r101);
                return;
            L6:
                this.f166059a.onError(new Throwable("load bitmap error"));
                return;
            }
        }

        public b(String r100) {
            this.f166058a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Bitmap> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            ECLiveImageUtils.f(this.f166058a, new a(r100));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WireframeComponent f166060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f166061b;

        public c(WireframeComponent r100, boolean r101) {
            this.f166060a = r100;
            this.f166061b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f166061b == true) goto L5;
            WireframeComponent.i0(this.f166060a, r101);
        L5:
            WireframeComponent r102 = this.f166060a;
            r102.getClass();
            if (PdpPerfOpt.b().l() == false) goto L9;
            r102.f166055n.setWireframeBitmap(CloseableReference.of(r101, SimpleBitmapReleaser.getInstance()));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f166062a = null;

        static {
            f166062a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WireframeComponent f166063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f166064b;

        public e(WireframeComponent r100, int r101) {
            this.f166063a = r100;
            this.f166064b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LengthenedCompatDraweeView r100 = this.f166063a.f166046e;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.setVisibility(4);     // Catch: Throwable -> L7
        L5:
            this.f166063a.m0(this.f166064b);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.e
    public final void L() {
    }

    @Override // a73.n
    public final void G() {
        if (this.f166055n.controlParams().f167733c == false) goto L9;
        ViewGroup r100 = this.f166054m;
        if (r100 == null) goto L7;
        r100.setVisibility(8);
    L7:
        n0(false);
        return;
    L9:
        ViewGroup r101 = this.f166054m;
        if (r101 == null) goto L15;
        if (r101.getVisibility() != 8) goto L15;
        return;
    L15:
        if (PdpPerfOpt.h() == true) goto L27;
        System.currentTimeMillis();
        ViewGroup r102 = this.f166054m;
        if (r102 == null) goto L32;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L33;
        ViewPropertyAnimator r104 = r103.alpha(0.0f);
        if (r104 == null) goto L34;
        ViewPropertyAnimator r105 = r104.setDuration(300);
        if (r105 == null) goto L35;
        ViewPropertyAnimator r106 = r105.setListener(new a(this));
        if (r106 == null) goto L36;
        r106.start();
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L27:
        ViewGroup r107 = this.f166054m;
        if (r107 == null) goto L30;
        r107.setVisibility(8);
    L30:
        n0(false);
    }

    @Override // a73.n
    public final LiveData<Boolean> c0() {
        return this.f166044c;
    }

    public static final void j0(WireframeComponent r100) {
        View r101 = r100.f166049h;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
    L11:
        r100.G();
        r100.f166055n.pageStatus().f167748n = false;
        return;
    L10:
        if (r100.f166055n.pageStatus().E == true) goto L11;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.e
    public final void M(int r100) {
        Lazy r101 = UIUtils.f45548a;
        if (UIUtils.d() == false) goto L8;
        LengthenedCompatDraweeView r102 = this.f166046e;
        if (r102 == null) goto L7;
        r102.setVisibility(4);
    L7:
        m0(r100);
        return;
    L8:
        UIUtils.c().post(new e(this, r100));
    }

    public final void m0(int r110) {
        if (com.bytedance.android.ec.core.abtest.d.f() == true) goto L6;
        return;
    L6:
        if (this.f166055n.pageStatus().E == true) goto L10;
        n0(true);
        ViewGroup r100 = this.f166054m;
        if (r100 == null) goto L10;
        r100.setVisibility(0);
    L10:
        ECDraweeView r101 = null;
        if (this.f166049h == null) goto L13;
    L28:
        View r102 = this.f166049h;
        if (r102 == null) goto L88;
        r102.setVisibility(0);
        ViewGroup r103 = this.f166050i;
        if (r103 == null) goto L34;
        r103.setVisibility(8);
    L34:
        if (r110 != 0) goto L36;
    L47:
        View r104 = this.f166049h;
        if (r104 == null) goto L52;
        View r105 = r104.findViewById(R.id.tv_ec_common_refresh);
        if (r105 == null) goto L52;
        r105.setVisibility(0);
    L52:
        View r106 = this.f166049h;
        if (r106 == null) goto L57;
        View r107 = r106.findViewById(R.id.tv_ec_common_refresh_description);
        if (r107 == null) goto L57;
        r107.setVisibility(0);
    L57:
        View r108 = this.f166049h;
        if (r108 == null) goto L86;
        View r109 = r108.findViewById(R.id.tv_ec_common_refresh);
        if (r109 == null) goto L86;
        com.bytedance.android.ec.core.widget.f.c(r109, null, null, new WireframeComponent$showErrorRetry$1(this), 3);
    L86:
        Map r111 = (Map) this.f166053l.getValue();     // Catch: Exception -> L83
        if (r111.containsKey(String.valueOf(r110)) == false) goto L89;
        Map r112 = (Map) r111.get(String.valueOf(r110));     // Catch: Exception -> L83
        if (r112 == null) goto L73;
        String r113 = (String) r112.get("title");     // Catch: Exception -> L83
        if (r113 == null) goto L73;
        View r114 = this.f166049h;     // Catch: Exception -> L83
        if (r114 == null) goto L73;
        TextView r115 = (TextView) r114.findViewById(R.id.tv_ec_pdp_loading_error_title);     // Catch: Exception -> L83
        if (r115 == null) goto L73;
        r115.setText(r113);     // Catch: Exception -> L83
    L73:
        if (r112 == null) goto L90;
        String r116 = (String) r112.get("bg_image_url");     // Catch: Exception -> L83
        if (r116 == null) goto L91;
        View r117 = this.f166049h;     // Catch: Exception -> L83
        if (r117 == null) goto L79;
        r101 = (ECDraweeView) r117.findViewById(R.id.iv_ec_pdp_loading_error_bg);     // Catch: Exception -> L83
    L79:
        ECDraweeView r118 = r101;
        if (r118 == null) goto L92;
        com.bytedance.android.ec.core.imagex.h0.e(r118, r116, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_detail_error_network_bg_image"), null, null, 120);     // Catch: Exception -> L83
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L83:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L36:
        if (com.bytedance.android.ec.core.abtest.d.v().contains(Double.valueOf(r110)) == false) goto L47;
        View r119 = this.f166049h;
        if (r119 == null) goto L42;
        View r120 = r119.findViewById(R.id.tv_ec_common_refresh);
        if (r120 == null) goto L42;
        r120.setVisibility(8);
    L42:
        View r121 = this.f166049h;
        if (r121 == null) goto L86;
        View r122 = r121.findViewById(R.id.tv_ec_common_refresh_description);
        if (r122 == null) goto L86;
        r122.setVisibility(8);
        goto L86
    L88:
        return;
    L13:
        if (((Map) this.f166053l.getValue()).isEmpty() == false) goto L21;
        ViewGroup r123 = this.f166054m;
        if (r123 == null) goto L19;
        ViewStub r124 = (ViewStub) r123.findViewById(R.id.anchor_v4_error_view_stub);
        if (r124 == null) goto L19;
        View r125 = r124.inflate();
    L20:
        this.f166049h = r125;
    L19:
        r125 = null;
        goto L20
    L21:
        ViewGroup r126 = this.f166054m;
        if (r126 == null) goto L26;
        ViewStub r127 = (ViewStub) r126.findViewById(R.id.anchor_v4_error_view_stub_v2);
        if (r127 == null) goto L26;
        View r128 = r127.inflate();
    L27:
        this.f166049h = r128;
    L26:
        r128 = null;
        goto L27
    }

    public final void n0(boolean r100) {
        MutableLiveData r101 = this.f166044c;
        if ((r101 instanceof MutableLiveData) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L8;
        r101.setValue(Boolean.valueOf(r100));
        return;
    }

    public static final void i0(WireframeComponent r100, Bitmap r101) {
        r100.getClass();
        if (r101.getWidth() != 0) goto L5;
        return;
    L5:
        if (r101.getHeight() == 0) goto L23;
        float r102 = r101.getHeight() / r101.getWidth();
        LengthenedCompatDraweeView r103 = r100.f166046e;
        if (r103 == null) goto L9;
        float r104 = r103.getHeightRatio();
    L11:
        if (Math.abs(r102 - r104) >= 0.2f) goto L24;
        LengthenedCompatDraweeView r105 = r100.f166046e;
        if (r105 == null) goto L15;
        r105.setImageBitmap(r101);
    L15:
        HeadGaussItemView r106 = r100.f166051j;
        if (r106 == null) goto L18;
        HeadGaussItemView.b(r106, r101);
    L18:
        com.bytedance.android.shopping.anchorv4.perf.monitor.c.a r107 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.f167220k;
        AnchorV4VM r108 = r100.f166055n;
        r107.getClass();
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r109 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.a.a(r108);
        if (r109 == null) goto L25;
        r109.f167221a.f167261t = Long.valueOf(System.currentTimeMillis());
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r104 = 1.0f;
        goto L11
    }

    @Override // a73.n
    public final void H(boolean r100, int r101) {
        String r102 = this.f166045d;
        LengthenedCompatDraweeView r103 = this.f166046e;
        if (r103 == null) goto L5;
        ImageExtensionsKt.D(r103, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
    L5:
        AnchorV4Param r104 = this.f166055n.getAnchorV4Param();
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L10;
        V4NativeParams r106 = r104.getNativeParams();
        if (r106 == null) goto L10;
        WireFrameSchemaInfo r107 = r106.getWireFrameSchemaInfo();
    L11:
        int r108 = 0;
        if (r107 != null) goto L14;
    L18:
        boolean r109 = false;
    L20:
        if (this.f166055n.pathParams().f167761a == false) goto L30;
        com.bytedance.android.shopping.anchorv4.perf.preload.g r110 = com.bytedance.android.shopping.anchorv4.perf.preload.g.f167320b;
        if (r110 == null) goto L24;
        Integer r111 = r110.c();
    L25:
        if (r111 != null) goto L28;
        boolean r112 = PdpAB.b();
    L40:
        if (r112 == true) goto L45;
        if (r109 == false) goto L44;
        if (r100 == false) goto L45;
    L44:
        boolean r113 = false;
    L46:
        if (r113 == true) goto L48;
        k0(r102, false);
        com.bytedance.android.shopping.anchorv4.perf.monitor.c.a r114 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.f167220k;
        AnchorV4VM r115 = this.f166055n;
        r114.getClass();
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r116 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.a.a(r115);
        if (r116 == null) goto L67;
        com.bytedance.android.shopping.anchorv4.perf.monitor.k r117 = r116.f167223c;
        if (r117 == null) goto L67;
        Pair<String, Boolean> r118 = this.f166052k;
        if (r118 == null) goto L57;
        String r119 = (String) r118.first;
    L58:
        boolean r120 = com.bytedance.android.shopping.extensions.k.c(r119);
        Pair<String, Boolean> r121 = this.f166052k;
        if (r121 == null) goto L61;
        Boolean r122 = (Boolean) r121.second;
    L63:
        if (Intrinsics.areEqual(r122, Boolean.TRUE) == false) goto L65;
        float r123 = 0.75f;
    L66:
        com.bytedance.android.shopping.anchorv4.perf.monitor.j r124 = r117.f167279a;
        r124.f167267a = r120;
        r124.f167268b = r123;
        goto L67
    L65:
        r123 = 1.0f;
        goto L66
    L61:
        r122 = null;
        goto L63
    L57:
        r119 = null;
    L67:
        if (r100 == false) goto L80;
        LengthenedCompatDraweeView r125 = this.f166046e;
        if (r125 == null) goto L89;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L74;
        r105 = r126;
    L74:
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r105;
        if (r127 != null) goto L77;
        return;
    L77:
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L79;
        r108 = com.bytedance.android.shopping.extensions.j.a(R.dimen.commerce_anchor_v3_top_area_height);
    L79:
        r127.topMargin = r108;
        r125.setLayoutParams(r127);
        return;
    L89:
        return;
    L80:
        ViewGroup r128 = this.f166054m;
        if (r128 == null) goto L85;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
        if (r129 == null) goto L85;
        r129.height = r101;
    L85:
        ViewGroup r130 = this.f166054m;
        if (r130 == null) goto L92;
        r130.requestLayout();
        return;
    L92:
        return;
    L48:
        if (PdpPerfOpt.b().l() == false) goto L67;
        k0(r102, true);
    L45:
        r113 = true;
        goto L46
    L28:
        if (r111.intValue() == 1) goto L38;
    L39:
        r112 = false;
    L38:
        r112 = true;
        goto L40
    L24:
        r111 = null;
        goto L25
    L30:
        com.bytedance.android.shopping.anchorv4.perf.preload.g r131 = com.bytedance.android.shopping.anchorv4.perf.preload.g.f167320b;
        if (r131 == null) goto L33;
        Integer r132 = r131.d();
    L34:
        if (r132 != null) goto L37;
        r112 = PdpAB.b();
        goto L40
    L37:
        if (r132.intValue() != 1) goto L39;
    L33:
        r132 = null;
        goto L34
    L14:
        if (r107.getHalPdpOptimizeStyle() != 1) goto L18;
        if (r107.getHalfPdpHeadScaleParam() != 0.0f) goto L18;
        r109 = true;
    L10:
        r107 = null;
        goto L11
    }

    public final void k0(String r100, final boolean r110) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (PdpPerfOpt.h() == false) goto L7;
        int r101 = com.bytedance.android.ec.core.imagex.r.f44937h;
        ImageExtensionsKt.f(r100, com.bytedance.android.ec.core.imagex.r.a.a("ec_product_cover_image"), null, null, null, new WireframeComponent$loadPreviewImage$1(this, r110), 110);
        return;
    L7:
        LruCache<String, List<String>> r102 = com.bytedance.android.ec.core.imagex.transform.b.f45042a;
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        if (StringsKt.isBlank(r100) == true) goto L23;
        Object r103 = null;
        List<String> r104 = com.bytedance.android.ec.core.imagex.transform.b.f45042a.get(com.bytedance.android.ec.core.imagex.transform.b.e(r100, null, null));
        if (r104 == null) goto L23;
        if (r104.isEmpty() == true) goto L23;
        Object r105 = ListProtector.get(r104, 0);
        if ((!StringsKt.isBlank((String) r105)) == false) goto L19;
        r103 = r105;
    L19:
        String r106 = (String) r103;
        if (r106 == null) goto L23;
        r100 = r106;
    L23:
        fa3.c.a(Observable.create(new b(r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r110), d.f166062a), this);
    }

    public WireframeComponent(ViewGroup r110, AnchorV4VM r111, BasePdpRecyclerView r112, com.bytedance.android.shopping.anchorv4.containers.g r113) {
        Intrinsics.checkNotNullParameter(r111, "anchorV4VM");
        this.f166054m = r110;
        this.f166055n = r111;
        this.f166056o = r113;
        Boolean r100 = Boolean.TRUE;
        this.f166044c = new MutableLiveData(r100);
        if (r110 == null) goto L5;
        LengthenedCompatDraweeView r101 = (LengthenedCompatDraweeView) r110.findViewById(R.id.anchor_v4_frame_image);
    L6:
        this.f166046e = r101;
        if (r110 == null) goto L9;
        WireFrameViewV2 r102 = (WireFrameViewV2) r110.findViewById(R.id.anchor_v4_frame_view);
    L10:
        if (r110 == null) goto L12;
        View r103 = r110.findViewById(R.id.anchor_v4_frame_close);
    L13:
        this.f166047f = r103;
        if (r110 == null) goto L16;
        ViewGroup r104 = (ViewGroup) r110.findViewById(R.id.anchor_v4_frame_close_applet);
    L17:
        this.f166048g = r104;
        if (r110 == null) goto L20;
        ViewGroup r105 = (ViewGroup) r110.findViewById(R.id.anchor_v4_frame_ll);
    L21:
        this.f166050i = r105;
        this.f166053l = LazyKt.lazy(WireframeComponent$networkErrorConfigMap$2.INSTANCE);
        r111.watchNetworkFlow(this);
        LinkedHashMap<String, com.bytedance.android.shopping.anchorv4.helper.u> r106 = com.bytedance.android.shopping.anchorv4.helper.t.f166991a;
        com.bytedance.android.shopping.anchorv4.helper.u r107 = com.bytedance.android.shopping.anchorv4.helper.t.a(r111.getSessionId());
        if (r107 == null) goto L26;
        s73.c r108 = r107.f166993b;
        if (r108 == null) goto L26;
        Pair<String, Boolean> r109 = r108.f540923a;
    L27:
        this.f166052k = r109;
        if (r109 == null) goto L31;
        String r114 = (String) r109.first;
        if (r114 == null) goto L31;
    L37:
        this.f166045d = r114;
        if (r109 == null) goto L40;
        Boolean r115 = (Boolean) r109.second;
    L42:
        if (Intrinsics.areEqual(r115, r100) == false) goto L45;
        if (r101 == null) goto L45;
        r101.setHeightRatio(1.33f);
    L45:
        AnchorV4Param r116 = r111.getAnchorV4Param();
        if (r116 == null) goto L59;
        V4NativeParams r117 = r116.getNativeParams();
        if (r117 == null) goto L59;
        WireFrameSchemaInfo r118 = r117.getWireFrameSchemaInfo();
        if (r118 == null) goto L59;
        if (r118.getHalPdpOptimizeStyle() != 1) goto L59;
        if (r118.getHalfPdpHeadScaleParam() != 0.0f) goto L58;
        Float r119 = Float.valueOf(0.6666667f);
    L60:
        if (r119 == null) goto L64;
        float r120 = r119.floatValue();
        if (r101 == null) goto L64;
        r101.setHeightRatio(r120);
    L64:
        if (r101 == null) goto L67;
        r101.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L67:
        if (r102 == null) goto L69;
        r102.setVisibility(0);
    L69:
        if (r110 == null) goto L72;
        r110.setBackgroundColor((int) 4294309625L);
    L72:
        if (r111.pathParams().f167761a == false) goto L96;
        int r121 = ECSdk.f48106a;
        IECHostService r122 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r122 == null) goto L76;
        IECAIHostService r123 = r122.getECHostAIService();
    L77:
        if (r123 != null) goto L79;
    L91:
        if (r103 == null) goto L93;
        r103.setVisibility(0);
    L93:
        if (r103 == null) goto L96;
        r103.setOnClickListener(new m0(this));
        goto L96
    L79:
        if (r123.isInApplet() != true) goto L91;
        if (r123.isLandingPage() == true) goto L96;
        if (r104 == null) goto L96;
        BackComponent r124 = r123.createBackComponent(r104.getContext());
        if (r124 == null) goto L96;
        r124.setOnClickListener(new p0(this));
        View r125 = r124.getView();
        if (r125 == null) goto L96;
        r104.setVisibility(0);
        r104.addView(r125);
        goto L96
    L76:
        r123 = null;
    L96:
        if (PdpPerfOpt.h() == false) goto L110;
        if (r112 == null) goto L99;
        r112.setItemAnimator(null);
    L99:
        r111.getPdpTaskManager().g(new n0(this));
        PdpTaskManager r126 = r111.getPdpTaskManager();
        o0 r127 = new o0(this);
        monitor-enter(r126);
        Intrinsics.checkNotNullParameter(r127, "task");     // Catch: Throwable -> L107
        if (r126.f43781c == false) goto L104;
        r127.a();     // Catch: Throwable -> L107
    L105:
        monitor-exit(r126);
        goto L110
    L104:
        r126.a(r127, 1);     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        throw th;
    L110:
        Lazy r128 = TopGuideGaussComponent.f166030e;
        if (TopGuideGaussComponent.a.a() == true) goto L113;
        return;
    L113:
        if (r111.pathParams().f167761a == false) goto L119;
        if (r105 == null) goto L120;
        HeadGaussItemView r129 = new HeadGaussItemView(r105.getContext());
        this.f166051j = r129;
        r105.addView(r129, 0);
        return;
    L120:
        return;
    L119:
        return;
    L58:
        r119 = Float.valueOf(r118.getHalfPdpHeadScaleParam());
    L59:
        r119 = null;
        goto L60
    L40:
        r115 = null;
    L31:
        AnchorV4Param r130 = r111.getAnchorV4Param();
        if (r130 == null) goto L36;
        V4NativeParams r131 = r130.getNativeParams();
        if (r131 == null) goto L36;
        r114 = r131.getFrameCovImage();
    L36:
        r114 = null;
    L26:
        r109 = null;
        goto L27
    L20:
        r105 = null;
        goto L21
    L16:
        r104 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
