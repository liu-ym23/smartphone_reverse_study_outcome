package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.k;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ItemMediaLayer extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.a<HeaderMediaModel> implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f169659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f169660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f169661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f169662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j f169663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f169664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BlurImageView f169665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECDraweeView f169666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f169667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f169668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s f169669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f169670l;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemMediaLayer f169671a;

        public a(ItemMediaLayer r100) {
            this.f169671a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f169671a.f169669k.eh().x(this.f169671a);
            this.f169671a.E();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f169671a.f169669k.eh().z(this.f169671a);
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r100, ImageInfo r101, boolean r102, int r103) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r100, Boolean r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r100) {
    }

    public final void E() {
        int r100 = 0;
        boolean r101 = true;
        if (this.f169662d == 1) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L23;
        int r102 = this.f169669k.FB();
        Object r103 = this.f169660b.getParent();
        ViewGroup.LayoutParams r104 = null;
        if ((r103 instanceof View) == true) goto L10;
        r103 = null;
    L10:
        View r105 = (View) r103;
        if (r105 == null) goto L13;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
    L15:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r104 = r106;
    L18:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r104;
        if (r107 == null) goto L21;
        int r108 = r107.topMargin;
    L22:
        int r109 = r102 + r108;
    L24:
        if (r101 == false) goto L26;
        int r110 = k83.b.f502093a;
        r100 = k83.b.b(this.f169669k);
    L26:
        D(this.f169661c, r109, r100);
        ECDraweeView r111 = this.f169666h;
        if (r111 == null) goto L30;
        D(r111, r109, r100);
        return;
    L30:
        return;
    L21:
        r108 = 0;
        goto L22
    L13:
        r106 = null;
        goto L15
    L23:
        r109 = 0;
        goto L24
    }

    public final void y() {
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r100 = this.f169669k.rR().d0();
        if (r100 == null) goto L15;
        int r101 = r100.f167227g;
        if (r101 != 1) goto L10;
        com.bytedance.android.shopping.anchorv4.perf.monitor.i r102 = r100.f167221a;
        if (r102.f167262u != null) goto L16;
        r102.f167262u = Long.valueOf(System.currentTimeMillis());
        return;
    L16:
        return;
    L10:
        if (r101 != 2) goto L18;
        com.bytedance.android.shopping.anchorv4.perf.monitor.i r103 = r100.f167221a;
        if (r103.f167263v != null) goto L19;
        r103.f167263v = Long.valueOf(System.currentTimeMillis());
        return;
    L19:
        return;
    L18:
        return;
    }

    public final View r() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        k r100 = this.f169664f;
        if (r100 == null) goto L16;
        View r101 = r100.getPreviewStartView();
        if (r101 == null) goto L16;
        return r101;
    L16:
        return this.f169661c;
    L9:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r102 = this.f169663e;
        if (r102 == null) goto L14;
        View r103 = r102.getPreviewStartView();
        if (r103 == null) goto L14;
        return r103;
    L14:
        return this.f169661c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r100) {
        E();
    }

    public final void C(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        this.f169661c.setAlpha(r101);
        ECDraweeView r102 = this.f169666h;
        if (r102 == null) goto L9;
        r102.setAlpha(r101);
        return;
    L9:
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r100) {
        E();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r100) {
        Intrinsics.checkNotNullParameter(r100, "headVo");
        E();
    }

    public ItemMediaLayer(s r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "headAbility");
        this.f169669k = r100;
        this.f169670l = r110;
        FrameLayout r111 = new FrameLayout(r100.getContext());
        r111.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ECDraweeView r101 = new ECDraweeView(r111.getContext(), null, 0, 6, null);
        this.f169661c = r101;
        if (r100.XU() < 2) goto L7;
        GenericDraweeHierarchy r102 = r101.getHierarchy();
        if (r102 == null) goto L10;
        r102.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L10:
        Unit r103 = Unit.INSTANCE;
        r111.addView(r101, -1, -1);
        this.f169660b = r111;
        r111.addOnAttachStateChangeListener(new a(this));
        Lazy r104 = PdpAB.f166747a;
        if (PdpAB.f166749c != 1) goto L14;
        r111.addOnAttachStateChangeListener(new AnonymousClass3());
        return;
    L14:
        return;
    L7:
        GenericDraweeHierarchy r105 = r101.getHierarchy();
        if (r105 == null) goto L10;
        r105.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        goto L10
    }

    public static void D(ECDraweeView r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r103 = null;
    L5:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 != null) goto L8;
        return;
    L8:
        int r105 = -r101;
        int r106 = -r102;
        if (r104.topMargin == r105) goto L11;
    L17:
        r104.width = -1;
        r104.height = -1;
        r104.topMargin = r105;
        r104.bottomMargin = r106;
        r100.setLayoutParams(r104);
        return;
    L11:
        if (r104.bottomMargin != r106) goto L17;
        if (r104.width != (-1)) goto L17;
        if (r104.height != (-1)) goto L17;
    }

    public final void B(HeaderMediaModel r410, final int r411, final Integer r412) {
        Intrinsics.checkNotNullParameter(r410, "data");
        this.f169659a = Integer.valueOf(r411);
        this.f169662d = r410.getFillMode();
        E();
        this.f169661c.setVisibility(8);
        String r100 = r410.getImageScaleType();
        Bitmap r110 = null;
        if (r100 == null) goto L21;
        int r101 = r100.hashCode();
        if (r101 == (-2021672893)) goto L19;
        if (r101 == (-1274273297)) goto L16;
        if (r101 != 1671566394) goto L21;
        if (r100.equals(SlcScaleType.CENTER_CROP) == false) goto L21;
        ScalingUtils.ScaleType r102 = ScalingUtils.ScaleType.CENTER_CROP;
    L22:
        if (r102 == null) goto L24;
    L27:
        GenericDraweeHierarchy r103 = this.f169661c.getHierarchy();
        if (r103 == null) goto L31;
        r103.setActualImageScaleType(r102);
    L31:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L35;
        k r104 = this.f169664f;
        if (r104 == null) goto L38;
        r104.setVisibility(8);
    L38:
        C(true);
        if (r412 != null) goto L41;
    L43:
        boolean r105 = false;
    L44:
        final ECUrlModel r106 = r410.getImageUrl(r105);
        if (r106 == null) goto L92;
        final ECDraweeView r107 = this.f169661c;
        final Function0<Unit> r108 = new ItemMediaLayer$onBind$$inlined$let$lambda$1(r106, this, r411, r412);
        r107.setVisibility(0);
        if (PdpPerfOpt.a().c() == true) goto L49;
        y.c(r107, r106, -1, -1, new z53.a(r106.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), r108, !PdpPerfOpt.c(), 8));
        goto L92
    L49:
        Function0<Unit> r109 = new ItemMediaLayer$bindBackgroundImage$onSuccessCB$1(this, r108);
        Function0<Unit> r111 = new ItemMediaLayer$bindBackgroundImage$onIntermediateSuccessCB$1(this);
        List<String> r112 = r106.getUrlList();
        ImagePosition r113 = ImagePosition.GOODS_HEADER;
        final d r114 = new d(this, r411, r107, r106, r412, r109, r111, r112, r113.getValue(), r109, r111, !PdpPerfOpt.c());
        if (r106.getUri() != null) goto L52;
    L54:
        boolean r115 = false;
    L55:
        if (r115 == false) goto L62;
        Integer r116 = this.f169668j;
        if (r116 == null) goto L62;
        if (r411 != r116.intValue()) goto L62;
        boolean r117 = false;
    L94:
        if (PdpPerfOpt.a().c() == true) goto L96;
    L100:
        boolean r118 = false;
    L101:
        if (r118 == true) goto L103;
        b(r410, r411, r412);
    L103:
        this.f169668j = Integer.valueOf(r411);
        return;
    L96:
        if (r410.getVideo() == null) goto L100;
        if (this.f169669k.rR().n() == true) goto L100;
        this.f169669k.rR().Z(new e(this, r411, r412, r410), r117);
        r118 = true;
    L62:
        ImageExtensionsKt.D(r107, new r("ec_detail", "ec_product_header_image"));
        if (this.f169670l == true) goto L65;
    L88:
        r117 = false;
    L89:
        final String r119 = r106.getFirstUrl();
        if (r119 == null) goto L94;
        ImageExtensionsKt.w(r107, r119, null, null, null, null, null, null, r114, false, null, new ItemMediaLayer$bindBackgroundImage$$inlined$let$lambda$1(r119, this, r107, r114), 2940);
        goto L94
    L65:
        if (this.f169669k.BY() == true) goto L88;
        String r120 = this.f169669k.rR().U();
        if (r411 != 0) goto L88;
        if (r120 == null) goto L88;
        if (this.f169666h != null) goto L88;
        ECDraweeView r121 = new ECDraweeView(this.f169669k.getContext(), null, 0, 6, null);
        r121.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r117 = false;
        this.f169660b.addView(r121, 0);
        E();
        Unit r122 = Unit.INSTANCE;
        this.f169666h = r121;
        GenericDraweeHierarchy r123 = r121.getHierarchy();
        if (r123 == null) goto L74;
        r123.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L74:
        CloseableReference<Bitmap> r124 = this.f169669k.rR().h0();
        if (r124 == null) goto L77;
        r110 = r124.get();
    L77:
        if (r110 == null) goto L85;
        ECDraweeView r125 = this.f169666h;
        if (r125 == null) goto L81;
        r125.setImageBitmap(r124.get());
    L81:
        ECDraweeView r126 = this.f169666h;
        if (r126 == null) goto L84;
        r126.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L84:
        y();
        CloseableStaticBitmap r127 = new CloseableStaticBitmap(r124, ImmutableQualityInfo.FULL_QUALITY, 0);
        g(this, r411, r127, true, 0, 8);
        r127.close();
        goto L89
    L85:
        r r128 = new r("ec_detail", "ec_product_header_image");
        ECDraweeView r129 = this.f169666h;
        if (r129 == null) goto L89;
        ImageExtensionsKt.x(r129, CollectionsKt.emptyList(), ImageExtensionsKt.G(r120, r128, Boolean.TRUE), r128, null, null, null, null, new h(this, r411, CollectionsKt.listOf(r120), r113.getValue()), false, null, ItemMediaLayer$setupPlaceHolderAsNeed$3.INSTANCE, null, 7032);
        goto L89
    L52:
        if (Intrinsics.areEqual(r106.getUri(), r107.getTag()) == false) goto L54;
        r115 = true;
    L92:
        r117 = false;
        goto L94
    L41:
        if (r412.intValue() <= 0) goto L43;
        r105 = true;
        goto L44
    L35:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r130 = this.f169663e;
        if (r130 == null) goto L38;
        r130.setVisibility(8);
        goto L38
    L24:
        if (this.f169669k.XU() < 2) goto L26;
        r102 = ScalingUtils.ScaleType.CENTER_CROP;
        goto L27
    L26:
        r102 = ScalingUtils.ScaleType.FIT_CENTER;
        goto L27
    L16:
        if (r100.equals(SlcScaleType.FIT_XY) == false) goto L21;
        r102 = ScalingUtils.ScaleType.FIT_XY;
        goto L22
    L19:
        if (r100.equals("fit_center") == false) goto L21;
        r102 = ScalingUtils.ScaleType.FIT_CENTER;
    L21:
        r102 = null;
        goto L22
    }

    public final void b(HeaderMediaModel r100, int r101, Integer r102) {
        if (r100.getVideo() != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L10;
        if (this.f169664f != null) goto L13;
        k r103 = new k(this.f169669k.getContext(), this.f169669k, new f(this, r101));
        this.f169664f = r103;
        this.f169660b.addView(r103, -1, -1);
    L13:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L17;
        k r104 = this.f169664f;
        if (r104 == null) goto L21;
        r104.setVisibility(0);
    L21:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L30;
        l r105 = this.f169669k.Sf().c(r101);
        if (r105 == null) goto L25;
        r105.f169112b = new ItemMediaLayer$bindVideoInner$1(this);
    L25:
        k r106 = this.f169664f;
        if (r106 == null) goto L28;
        r106.f169637f = false;
    L28:
        if (r106 == null) goto L38;
        r106.r(r100, r101, r102);
        return;
    L38:
        return;
    L30:
        PlayerBlock r107 = this.f169669k.Sf().d(r101);
        if (r107 == null) goto L33;
        r107.setClick2PlayInterceptor(new ItemMediaLayer$bindVideoInner$2(this));
    L33:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r108 = this.f169663e;
        if (r108 == null) goto L40;
        r108.b(r100, r101, r102);
        return;
    L40:
        return;
    L17:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r109 = this.f169663e;
        if (r109 == null) goto L21;
        r109.setVisibility(0);
        goto L21
    L10:
        if (this.f169663e != null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j r110 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.j(this.f169669k.getContext(), this.f169669k, new g(this, r101));
        this.f169663e = r110;
        this.f169660b.addView(r110, -1, -1);
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r100, int r101, Integer r102) {
        B((HeaderMediaModel) r100, r101, r102);
    }

    public static void g(ItemMediaLayer r100, int r101, ImageInfo r102, boolean r103, int r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = -1;
    L8:
        r100.f169669k.eh().j(r101, r102, r103, r104);
    }
}
