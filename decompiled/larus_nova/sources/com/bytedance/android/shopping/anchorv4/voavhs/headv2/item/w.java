package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.blur.BlurImageView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.Config;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaPreviewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.HeadLynxAbilityManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.ItemMediaLayer;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class w extends RoundedFrameLayout implements o<HeaderContentModel>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemMediaLayer f169797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i f169798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HeadMultiPreview f169799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c f169800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f169801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f169802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f169803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HeaderContentModel f169804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u f169805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f169806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BgDecorLayer f169807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s f169808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b f169809n;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r100) {
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

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s getHeadAbility() {
        return this.f169808m;
    }

    public final View B(Integer r100) {
        if (r100 == null) goto L36;
        HeaderContentModel r101 = this.f169804i;
        if (r101 == null) goto L13;
        HeaderMediaModel r102 = r101.getMedia();
        if (r102 == null) goto L13;
        List<HeaderMediaPreviewModel> r103 = r102.getPreviewList();
        if (r103 == null) goto L13;
        HeaderMediaPreviewModel r104 = (HeaderMediaPreviewModel) CollectionsKt.getOrNull(r103, r100.intValue());
        if (r104 == null) goto L13;
        String r105 = r104.getSliceKey();
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r106 = this.f169798c;
        if (r106 == null) goto L36;
        if (r105 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L33;
        SlcTemplateViewHelper r108 = r106.f169696b;
        if (r108 == null) goto L28;
        View r109 = r108.d(r105);
        if (r109 == null) goto L28;
    L34:
        if (r109 == null) goto L36;
        return r109;
    L28:
        View r110 = r106.f169695a;
        if (r110 == null) goto L33;
        if (r106.f169697c.yd().f169072b == null) goto L33;
        r109 = SlcRenderContext.f(r110, r105);
    L33:
        r109 = null;
        goto L34
    L18:
        if (r105.length() == 0) goto L21;
        r107 = false;
    L13:
        r105 = null;
    L36:
        if (r100 != null) goto L38;
    L45:
        ItemMediaLayer r111 = this.f169797b;
        if (r111 != null) goto L48;
        return null;
    L48:
        return r111.r();
    L38:
        if (r100.intValue() < 0) goto L45;
        HeadMultiPreview r112 = this.f169799d;
        if (r112 == null) goto L45;
        ItemMediaLayer r113 = (ItemMediaLayer) CollectionsKt.getOrNull(r112.f169578e, r100.intValue());
        if (r113 != null) goto L44;
        return null;
    L44:
        return r113.r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r100) {
        if (this.f169801f != this.f169808m.getCurrentPosition()) goto L16;
        if (r100 == false) goto L10;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r101 = this.f169798c;
        if (r101 == null) goto L17;
        View r102 = r101.f169695a;
        if (r102 == null) goto L18;
        ViewExtensionsKt.c(r102, false, 3);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r103 = this.f169798c;
        if (r103 == null) goto L20;
        View r104 = r103.f169695a;
        if (r104 == null) goto L21;
        ViewExtensionsKt.i(r104);
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r100) {
        boolean r101 = true;
        if (r100 == true) goto L5;
    L9:
        boolean r102 = false;
    L10:
        if (r100 == true) goto L12;
    L14:
        r101 = r102;
    L15:
        if (r101 == false) goto L18;
        int r103 = k83.b.f502093a;
        k83.b.c(this.f169808m.getRecyclerView());
        return;
    L18:
        return;
    L12:
        if (this.f169808m.h00() == true) goto L14;
        this.f169808m.m90();
        goto L15
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(this.f169808m, null, 3) == false) goto L7;
    L8:
        this.f169808m.tB(Boolean.TRUE);
        this.f169809n.f169186c = null;
        r102 = true;
        goto L10
    L7:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.a(this.f169808m, null, 3) == false) goto L9;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r100) {
        int r101 = this.f169808m.XU();
        HeaderContentModel r102 = this.f169804i;
        if (r102 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.i r103 = r102.getStyle();
        if (r103 == null) goto L9;
        Float r104 = r103.a();
        if (r104 == null) goto L9;
        float r105 = r104.floatValue();
    L11:
        if (r101 == 1) goto L13;
        return;
    L13:
        if (this.f169808m.wq() == false) goto L15;
        return;
    L15:
        if (r105 >= 1.0f) goto L25;
        ViewGroup.LayoutParams r106 = getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r106 = null;
    L19:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L26;
        r107.topMargin = (int) (com.bytedance.android.shopping.extensions.b.b(12) + ((com.bytedance.android.shopping.extensions.b.b(44) - com.bytedance.android.shopping.extensions.b.b(12)) * r100));
        setLayoutParams(r107);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r105 = 1.0f;
        goto L11
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        BgDecorLayer r101 = this.f169807l;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r100) {
        Intrinsics.checkNotNullParameter(r100, "headVo");
        Intrinsics.checkNotNullParameter(r100, "headVo");
    }

    public final void y(int r100) {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(this.f169808m, null, 3) == false) goto L6;
        setTranslationY(r100 * (1 - 0.4f));
        return;
    L6:
        if (this.f169802g == false) goto L43;
        ItemMediaLayer r101 = this.f169797b;
        if (r101 == null) goto L27;
        float r102 = r100 * (1 - 0.4f);
        r101.f169661c.setTranslationY(r102);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        k r103 = r101.f169664f;
        if (r103 == null) goto L21;
        r103.f169633b = r102;
        BasePdpVideoView r104 = k.g(r103.f169632a);
        if (r104 == null) goto L21;
        r104.setTranslationY(r103.f169633b);
    L21:
        BlurImageView r105 = r101.f169665g;
        if (r105 == null) goto L24;
        r105.setTranslationY(r102);
    L24:
        ECDraweeView r106 = r101.f169666h;
        if (r106 == null) goto L27;
        r106.setTranslationY(r102);
        goto L27
    L16:
        j r107 = r101.f169663e;
        if (r107 == null) goto L21;
        r107.f169625f = r102;
        PlayerBlock r108 = r107.f169624e;
        if (r108 == null) goto L21;
        r108.setTranslationY(r102);
    L27:
        BgDecorLayer r109 = this.f169807l;
        if (r109 != null) goto L30;
    L34:
        HeadMultiPreview r110 = this.f169799d;
        if (r110 == null) goto L37;
        float r111 = r100 * (1 - 0.4f);
        r110.f169574a.setTranslationY(r111);
        r110.f169575b.setTranslationY(r111);
    L37:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r112 = this.f169800e;
        if (r112 == null) goto L43;
        b r113 = r112.f169674a;
        if (r113 == null) goto L43;
        r113.setTranslationY(r100 * (1 - 0.4f));
        goto L43
    L30:
        if (r109.e() == false) goto L32;
        float r114 = 0.0f;
    L33:
        r109.f169653e = r114;
        r109.f169656h.invalidate();
        goto L34
    L32:
        r114 = r100 * (1 - 0.4f);
    L43:
        if (this.f169803h == false) goto L51;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r115 = this.f169798c;
        if (r115 == null) goto L52;
        View r116 = r115.f169695a;
        if (r116 == null) goto L53;
        r116.setTranslationY(r100 * (1 - 0.4f));
        return;
    L53:
        return;
    L52:
        return;
    }

    public final void C(JSONObject r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f169808m.Pg().e(r100.optString("pdp_container_id", "ai_combination"), r110);
        RecyclerView r101 = this.f169808m.getRecyclerView();
        if (r101 == null) goto L7;
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 == null) goto L7;
        r102.notifyItemChanged(this.f169801f);
    L7:
        if (r110 == false) goto L18;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r103 = this.f169800e;
        if (r103 == null) goto L18;
        String r104 = this.f169808m.rR().getSessionId();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        Intrinsics.checkNotNullParameter(r104, "sessionId");
        b r105 = r103.f169674a;
        if (r105 == null) goto L18;
        Intrinsics.checkNotNullParameter(r104, "sessionId");
        ti.l r106 = r105.f169596a;
        if (r106 == null) goto L18;
        JSONObject r107 = new JSONObject();
        r107.put("update_combination_tryon_setting", true);
        Unit r108 = Unit.INSTANCE;
        r106.sendJsEvent("ec.tryon.combain.setting.open", r107);
    L18:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r109 = this.f169809n;
        r109.f169186c = Integer.valueOf((int) com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.k(r109, this.f169801f, null, null, null, 14));
        RecyclerView r111 = this.f169808m.getRecyclerView();
        if (r111 == null) goto L21;
        r111.requestLayout();
    L21:
        this.f169808m.eh().h(r110);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f169808m.aN(this.f169801f) == false) goto L6;
        setMeasuredDimension(0, getMeasuredHeight());
        return;
    }

    public w(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r101, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        Intrinsics.checkNotNullParameter(r102, "sizeHelper");
        super(r100);
        this.f169808m = r101;
        this.f169809n = r102;
        this.f169801f = -1;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169210d == false) goto L5;
        BgDecorLayer r103 = new BgDecorLayer(r101, this, false, false, 12);
    L6:
        this.f169807l = r103;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(-1);
        addOnAttachStateChangeListener(new p(this));
        if (r103 == null) goto L10;
        setWillNotDraw(false);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final void l(HeaderContentModel r110, int r111, Integer r112) {
        HeaderContentModel r113 = r110;
        Intrinsics.checkNotNullParameter(r113, "data");
        setContentDescription("图片" + (r111 + 1));
        this.f169801f = r111;
        removeAllViews();
        this.f169804i = r113;
        if (this.f169808m.aN(r111) == true) goto L170;
        BgDecorLayer r100 = this.f169807l;
        b r101 = null;
        if (r100 == null) goto L18;
        Intrinsics.checkNotNullParameter(r113, "data");
        Integer r114 = r100.f169650b;
        if (r114 != null) goto L11;
    L12:
        r100.f169651c = null;
        r100.f169652d = null;
        CloseableReference<Bitmap> r115 = r100.f169654f;
        if (r115 == null) goto L15;
        r115.close();
    L15:
        r100.f169654f = null;
        r100.f169656h.invalidate();
    L16:
        r100.f169650b = Integer.valueOf(r111);
        r100.f169649a = r113;
        goto L18
    L11:
        if (r114.intValue() == r111) goto L16;
    L18:
        if (r113.getMultiPreview() == null) goto L75;
        HeadMultiPreview r116 = this.f169799d;
        if (r116 != null) goto L22;
        r116 = new HeadMultiPreview(getContext(), this.f169808m, this.f169809n);
    L22:
        this.f169799d = r116;
        HeadMultiPreview r117 = this.f169799d;
        if (r117 == null) goto L73;
        Intrinsics.checkNotNullParameter(r113, "contentVo");
        r117.f169579f = r111;
        int r102 = 0;
        if (r117.f169577d != null) goto L27;
        r117.f169574a.removeAllViews();
        r117.f169575b.removeAllViews();
        List<HeaderContentModel> r103 = r117.f169576c;
        if (r103 != null) goto L50;
        r117.f169576c = new ArrayList();
    L51:
        r117.f169577d = r113;
        ((ArrayList) r117.f169578e).clear();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r104 = r113.getMultiPreview();
        if (r104 == null) goto L72;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r105 = r104.a();
        if (r105 == null) goto L72;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L57:
        if (r106.hasNext() == false) goto L72;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r118 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) r108;
        HeaderContentModel r119 = r117.l(r118);
        ItemMediaLayer r120 = new ItemMediaLayer(r117.f169581h, false);
        if (r119 == null) goto L64;
        r117.b(r120, r119, r118, r107);
    L64:
        ViewGroup r121 = r120.f169660b;
        if (r107 != 0) goto L67;
        r117.f169574a.addView(r121, -1, -1);
    L71:
        ((ArrayList) r117.f169578e).add(r120);
        r107 = r109;
        goto L57
    L67:
        LinearLayout r122 = r117.f169575b;
        ViewGroup.MarginLayoutParams r123 = new ViewGroup.MarginLayoutParams(-1, -1);
        if (r107 <= 1) goto L70;
        int r124 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r123.topMargin = com.bytedance.android.ec.hybrid.list.util.c.d(6);
    L70:
        Unit r125 = Unit.INSTANCE;
        r122.addView(r121, r123);
    L72:
        r117.r();
        goto L73
    L50:
        ((ArrayList) r103).clear();
        goto L51
    L27:
        if (PdpPerfOpt.b().h() == false) goto L44;
        r117.f169577d = r113;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.r r126 = r113.getMultiPreview();
        if (r126 == null) goto L44;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.k> r127 = r126.a();
        if (r127 == null) goto L44;
        Iterator<T> r128 = r127.iterator();
    L34:
        if (r128.hasNext() == false) goto L44;
        Object r129 = r128.next();
        int r130 = r102 + 1;
        if (r102 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r131 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.k) r129;
        HeaderContentModel r132 = r117.l(r131);
        ItemMediaLayer r133 = (ItemMediaLayer) CollectionsKt.getOrNull(r117.f169578e, r102);
        if (r133 == null) goto L42;
        if (r132 == null) goto L42;
        r117.b(r133, r132, r131, r102);
    L42:
        r102 = r130;
    L44:
        if (r117.f169581h.wq() == false) goto L46;
        LinearLayout r134 = r117.f169574a;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        r135.width = -1;
        r135.height = -1;
        Unit r136 = Unit.INSTANCE;
        r134.setLayoutParams(r135);
        r117.f169582i.f169186c = null;
        r117.o(null);
    L46:
        r117.r();
    L73:
        addView(this.f169799d);
    L75:
        if (r113.getMedia() == null) goto L85;
        ItemMediaLayer r137 = this.f169797b;
        if (r137 != null) goto L79;
        r137 = new ItemMediaLayer(this.f169808m, true);
    L79:
        this.f169797b = r137;
        r137.f169667i = new s(this, r111);
        o.a.a(r137, r113.getMedia(), r111);
        ItemMediaLayer r138 = this.f169797b;
        if (r138 == null) goto L85;
        ViewGroup r139 = r138.f169660b;
        if (r139 == null) goto L85;
        wg.a.a(r139);
        addView(r139);
    L85:
        if (r113.getSlice() == null) goto L95;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r140 = this.f169798c;
        if (r140 != null) goto L89;
        r140 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i(this.f169808m);
    L89:
        this.f169798c = r140;
        o.a.a(r140, r113.getSlice(), r111);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r141 = this.f169798c;
        if (r141 == null) goto L95;
        View r142 = r141.f169695a;
        if (r142 == null) goto L95;
        wg.a.a(r142);
        addView(r142);
    L95:
        if (r113.getLynx() != null) goto L97;
        u r143 = this.f169805j;
        if (r143 == null) goto L142;
        this.f169808m.Pg().f("ec.tryon.combain.setting.close", r143);
    L142:
        v r144 = this.f169806k;
        if (r144 == null) goto L145;
        this.f169808m.Pg().f("ec.tryon.combain.setting.open", r144);
    L145:
        setOnClickListener(new t(this, r111));
        Config r145 = r113.getConfig();
        if (r145 == null) goto L149;
        this.f169802g = r145.getEnableMediaAsyncScroll();
        this.f169803h = r145.getEnableSliceAsyncScroll();
    L149:
        if (PdpAB.f166749c != 1) goto L166;
        y(this.f169808m.rR().R());
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r146 = this.f169798c;
        if (r146 != null) goto L153;
        return;
    L153:
        if (r146.f169695a != null) goto L155;
        return;
    L155:
        if (this.f169797b != null) goto L157;
        setBackgroundColor(ColorProtector.parseColor("#FFF6F6F9"));
        return;
    L157:
        setBackgroundColor(ColorProtector.parseColor("#FFFFFFFF"));
        return;
    L166:
        return;
    L97:
        if (Intrinsics.areEqual(r113.getLynx().a(), "ai_combination") == false) goto L111;
        if (this.f169805j != null) goto L102;
        this.f169805j = new u(this);
    L102:
        if (this.f169806k != null) goto L105;
        this.f169806k = new v(this);
    L105:
        if (this.f169805j == null) goto L108;
        this.f169808m.Pg().c("ec.tryon.combain.setting.close", this.f169805j);
    L108:
        if (this.f169806k == null) goto L111;
        this.f169808m.Pg().c("ec.tryon.combain.setting.open", this.f169806k);
    L111:
        if (this.f169808m.Pg().b(r113.getLynx()) == false) goto L145;
        if (r113.getLynx().c() == false) goto L128;
        HeadLynxAbilityManager r147 = this.f169808m.Pg();
        String r148 = r113.getLynx().a();
        String r149 = "";
        if (r148 != null) goto L117;
        r148 = "";
    L117:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r150 = r147.a(r148);
        if (r150 == null) goto L120;
        this.f169800e = r150;
    L132:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r151 = this.f169800e;
        if (r151 == null) goto L135;
        o.a.a(r151, r113.getLynx(), r111);
    L135:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r152 = this.f169800e;
        if (r152 == null) goto L138;
        r101 = r152.f169674a;
    L138:
        addView(r101);
        goto L145
    L120:
        this.f169800e = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(getContext(), this.f169808m);
        HeadLynxAbilityManager r153 = this.f169808m.Pg();
        String r154 = r113.getLynx().a();
        if (r154 != null) goto L123;
        r154 = "";
    L123:
        r153.d(r154, this.f169800e);
        HeadLynxAbilityManager r155 = this.f169808m.Pg();
        String r156 = r113.getLynx().a();
        if (r156 == null) goto L127;
        r149 = r156;
    L127:
        r155.e(r149, r113.getLynx().f());
        goto L132
    L128:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r157 = this.f169800e;
        if (r157 != null) goto L131;
        r157 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(getContext(), this.f169808m);
    L131:
        this.f169800e = r157;
        goto L132
    }
}
