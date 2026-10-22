package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonConfig;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonElement;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottom.BottomTipMeta;
import com.bytedance.android.shopping.anchorv4.bottom.CartNumberComponent;
import com.bytedance.android.shopping.anchorv4.bottom.EnterCartMeta;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomTipComponent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0017\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\rR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001a\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001d\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R#\u0010 \u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0019R#\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonView;", "Landroid/widget/FrameLayout;", "Lti/k;", "Landroid/widget/LinearLayout;", "enlargedView", "", "setEnlargedConfig", "", "isVisible", "setTipsVisible", "(Ljava/lang/Boolean;)V", "", "getLynxLocationY", "Landroid/view/View;", "getSuperMarketLynxView", "getCartIcon", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLeftGroupItems", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "leftGroupItems", "b", "getRightGroupButtons", "()Landroid/widget/LinearLayout;", "rightGroupButtons", "c", "getScaleContent", "scaleContent", "d", "getNormalButtons", "normalButtons", "e", "getSuperMarketButtons", "()Landroid/widget/FrameLayout;", "superMarketButtons", "Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", ce.f26391f, "getCartNumberComponent", "()Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", "cartNumberComponent", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/legacy/BottomTipComponent;", "h", "getBottomTipComponent", "()Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/legacy/BottomTipComponent;", "bottomTipComponent", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", ce.f26396k, "Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "getFirstButtonElementView", "()Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "setFirstButtonElementView", "(Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;)V", "firstButtonElementView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonView extends FrameLayout implements ti.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f182229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f182230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f182231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f182232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f182233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomButtonVO f182234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f182235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f182236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ti.l f182237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d f182238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BottomButtonElementView f182239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f182240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f182241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECLottieAnimationView f182242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f182243o;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f182244a;

        public b(View r100) {
            this.f182244a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 == null) goto L4;
            Integer r102 = Integer.valueOf(r101.getAction());
        L6:
            if (r102 != null) goto L9;
        L11:
            if (r102 != null) goto L14;
        L16:
            this.f182244a.setVisibility(8);
        L17:
            return false;
        L14:
            if (r102.intValue() != 2) goto L16;
        L15:
            this.f182244a.setVisibility(0);
            goto L17
        L9:
            if (r102.intValue() != 0) goto L11;
        L4:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public BottomButtonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomButtonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final BottomTipComponent getBottomTipComponent() {
        return (BottomTipComponent) this.f182236h.getValue();
    }

    private final CartNumberComponent getCartNumberComponent() {
        return (CartNumberComponent) this.f182235g.getValue();
    }

    private final TagsScrollBoxComponentView getLeftGroupItems() {
        return (TagsScrollBoxComponentView) this.f182229a.getValue();
    }

    private final LinearLayout getNormalButtons() {
        return (LinearLayout) this.f182232d.getValue();
    }

    private final LinearLayout getRightGroupButtons() {
        return (LinearLayout) this.f182230b.getValue();
    }

    private final LinearLayout getScaleContent() {
        return (LinearLayout) this.f182231c.getValue();
    }

    private final FrameLayout getSuperMarketButtons() {
        return (FrameLayout) this.f182233e.getValue();
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final int getLynxLocationY() {
        ti.l r100 = this.f182237i;
        if (r100 == null) goto L6;
        View r101 = r100.getHybridView();
        if (r101 == null) goto L6;
    L10:
        if (r101 == null) goto L13;
        int[] r102 = new int[2];
        r101.getLocationOnScreen(r102);
        return r102[1];
    L13:
        return 0;
    L6:
        ti.l r103 = this.f182237i;
        if (r103 == null) goto L9;
        r101 = r103.b();
        goto L10
    L9:
        r101 = null;
        goto L10
    }

    public final View getSuperMarketLynxView() {
        ti.l r100 = this.f182237i;
        if (r100 == null) goto L6;
        View r101 = r100.getHybridView();
        if (r101 == null) goto L6;
        return r101;
    L6:
        ti.l r102 = this.f182237i;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.b();
    }

    public final void d() {
        getCartNumberComponent().getClass();
        ti.l r100 = this.f182237i;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final View getCartIcon() {
        return this.f182243o;
    }

    public final BottomButtonElementView getFirstButtonElementView() {
        return this.f182239k;
    }

    private final void setEnlargedConfig(LinearLayout r100) {
        float r101 = k1.m(r100.getContext()) / q.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r100.setPivotX(0.0f);
        r100.setPivotY(0.0f);
        r100.setScaleX(r101);
        r100.setScaleY(r101);
    }

    public final void f(boolean r100) {
        ti.l r101 = this.f182237i;
        if (r101 == null) goto L10;
        JSONObject r102 = new JSONObject();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(r102.put("visible", r100));     // Catch: Throwable -> L7
    L9:
        Unit r104 = Unit.INSTANCE;
        r101.sendJsEvent("pageVisibilityChange", r102);
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        if (r100 == true) goto L20;
        ECLiveHybridUtil.f("androidInstantProductDetailHide", new JSONObject());     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final void h(int r100) {
        getCartNumberComponent().c(r100);
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public final void setFirstButtonElementView(BottomButtonElementView r100) {
        this.f182239k = r100;
    }

    public final void setTipsVisible(Boolean r100) {
        BottomTipComponent r101 = getBottomTipComponent();
        r101.getClass();
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.f181295d.setVisibility(0);
        return;
    L6:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L10;
        r101.f181295d.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.bytedance.android.shopping.anchorv4.dto.base.Radius] */
    public final void a(BottomButtonVO r210, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r211) {
        if (PdpBottomNavBarHelper.f166908d == false) goto L5;
        setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.a(4));
    L5:
        LinearLayout r100 = getNormalButtons();
        if (r100 == null) goto L8;
        r100.setVisibility(0);
    L8:
        LinearLayout r101 = getRightGroupButtons();
        if (r101 == null) goto L11;
        r101.setVisibility(0);
    L11:
        getLeftGroupItems().removeAllViews();
        getRightGroupButtons().removeAllViews();
        TagsScrollBoxComponent r102 = r210.getLeftItems();
        Function1 r103 = null;
        if (r102 == null) goto L14;
        getLeftGroupItems().a(r102, null, true, r211.getSessionId());
    L14:
        Object r104 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(getLeftGroupItems()), 0);
        if ((r104 instanceof ViewGroup) == true) goto L17;
        r104 = null;
    L17:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L46;
        List<View> r106 = com.bytedance.commerce.base.view.b.a(r105);
        if (r106 == null) goto L46;
        Iterator r107 = r106.iterator();
        int r108 = 0;
    L23:
        if (r107.hasNext() == false) goto L46;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        View r111 = (View) r109;
        TagsScrollBoxComponent r112 = r210.getLeftItems();
        if (r112 == null) goto L30;
        int r113 = r112.getSpace();
    L31:
        if (r113 <= 0) goto L45;
        if (r108 <= 0) goto L45;
        ViewGroup.LayoutParams r114 = r111.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L36;
        r114 = null;
    L36:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r115 == null) goto L39;
        r115.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r113));
        r111.setLayoutParams(r115);
    L39:
        int r116 = com.bytedance.android.shopping.extensions.b.b(12);
        Object r117 = r111.getParent();
        if ((r117 instanceof View) == true) goto L42;
        r117 = null;
    L42:
        View r118 = (View) r117;
        if (r118 == null) goto L45;
        r118.post(new g(r111, r116, r118));
    L45:
        r108 = r110;
        goto L23
    L30:
        r113 = 0;
    L46:
        List<BottomButtonElement> r119 = r210.getRightButtons();
        r211.l();
        if (r119 == null) goto L96;
        Iterator r120 = r119.iterator();
        int r121 = 0;
    L50:
        if (r120.hasNext() == false) goto L107;
        Object r122 = r120.next();
        int r123 = r121 + 1;
        if (r121 >= 0) goto L54;
        CollectionsKt.throwIndexOverflow();
    L54:
        BottomButtonElement r124 = (BottomButtonElement) r122;
        if (r121 >= 1) goto L57;
    L71:
        Context r125 = getContext();
        if (com.bytedance.android.shopping.anchorv4.experiment.h.f166759c != 1) goto L74;
        boolean r126 = true;
    L75:
        if (r126 == false) goto L77;
        ?? r127 = "DouyinNumberABC";
    L78:
        BottomButtonElementView r128 = new BottomButtonElementView(r125, null, 0, r127, 14);
        r128.a(r124, r210, r211);
        if (r121 != 0) goto L81;
        this.f182239k = r128;
    L81:
        Background r129 = r124.getBackground();
        if (r129 == null) goto L84;
        ?? r130 = r129.getRadius();
    L85:
        String r131 = r124.getClickMaskColor();
        if (r130 != 0) goto L97;
        ?? r132 = r103;
    L91:
        ?? r133 = new View(getContext());
        Intrinsics.checkNotNullParameter(r133, "$this$setBackgroundCompat");
        r133.setBackground(r132);
        ?? r134 = new FrameLayout(getContext());
        r134.addView(r128, new FrameLayout.LayoutParams(-1, -1));
        r134.addView(r133, new FrameLayout.LayoutParams(-1, -1));
        r133.setVisibility(8);
        ?? r135 = getRightGroupButtons();
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(0, -1);
        Float r137 = r124.getWeight();
        if (r137 == null) goto L94;
        float r138 = r137.floatValue();
    L95:
        r136.weight = r138;
        Unit r139 = Unit.INSTANCE;
        r135.addView(r134, r136);
        r128.setOnTouchListener(new b(r133));
        r121 = r123;
        r103 = null;
        goto L50
    L94:
        r138 = 1.0f;
        goto L95
    L97:
        GradientDrawable r140 = new GradientDrawable();     // Catch: Exception -> L90
        r140.setCornerRadii(new float[]{com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getBottomLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r130.getBottomLeft()))});     // Catch: Exception -> L90
        r140.setColor(Color.parseColor(r131));     // Catch: Exception -> L90
        r132 = r140;
    L90:
        r132 = 0;
        goto L91
    L84:
        r130 = r103;
        goto L85
    L77:
        r127 = r103;
        goto L78
    L74:
        r126 = false;
        goto L75
    L57:
        if (r210.getRightButtonDivider() == null) goto L71;
        ?? r141 = getRightGroupButtons();
        ?? r142 = new FrameLayout(getContext());
        ExtensionsKt.j(r142, r210.getRightButtonDivider().getBackground());
        SimpleDraweeView r143 = new SimpleDraweeView(getContext());
        ImageModel r144 = r210.getRightButtonDivider().getImage();
        if (r144 == null) goto L63;
        ECUrlModel r145 = r144.getRemote();
        if (r145 == null) goto L63;
        int r146 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r145.getWidth()));
    L64:
        ImageModel r147 = r210.getRightButtonDivider().getImage();
        if (r147 == null) goto L69;
        ECUrlModel r148 = r147.getRemote();
        if (r148 == null) goto L69;
        int r149 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r148.getHeight()));
    L70:
        FrameLayout.LayoutParams r150 = new FrameLayout.LayoutParams(r146, r149);
        r150.gravity = 16;
        Unit r151 = Unit.INSTANCE;
        r143.setLayoutParams(r150);
        ImageExtensionsKt.d(r143, r210.getRightButtonDivider().getImage(), r103);
        r142.addView(r143);
        r141.addView(r142, new FrameLayout.LayoutParams(-2, -1));
    L69:
        r149 = 0;
    L63:
        r146 = 0;
        goto L64
    L107:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v8, types: [boolean, int] */
    public final void c(BottomButtonVO r210, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r211) {
        Intrinsics.checkNotNullParameter(r210, "bottomButtonVO");
        Intrinsics.checkNotNullParameter(r211, "anchorV4VM");
        this.f182234f = r210;
        this.f182238j = r211;
        TextWithOneIconElement r110 = null;
        if (r210.getSuperMarketVO() == null) goto L45;
        setPadding(0, 0, 0, 0);
        setBackgroundColor(0);
        FrameLayout r100 = getSuperMarketButtons();
        if (r100 == null) goto L7;
        r100.setVisibility(0);
    L7:
        LynxCardComponent r101 = r210.getSuperMarketVO();
        if (r101 == null) goto L14;
        String r102 = r101.getData();
        if (r102 == null) goto L14;
        JSONObject r103 = com.bytedance.android.shopping.extensions.k.w(r102);
        if (r103 == null) goto L14;
        Map<String, Object> r104 = com.bytedance.android.shopping.hybrid.a.b(r103);
    L16:
        if (getSuperMarketButtons().getChildCount() <= 0) goto L35;
        ti.l r105 = this.f182237i;
        if (r105 == null) goto L34;
        JSONObject r106 = new JSONObject();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        if (r104 == null) goto L24;
        Object r108 = r104.get("product_status");     // Catch: Throwable -> L31
    L25:
        r106.put("product_status", r108);     // Catch: Throwable -> L31
        LynxCardComponent r109 = r210.getSuperMarketVO();     // Catch: Throwable -> L31
        if (r109 == null) goto L28;
        String r111 = r109.getSchema();     // Catch: Throwable -> L31
    L29:
        Result.m9449constructorimpl(r106.put("schema", r111));     // Catch: Throwable -> L31
    L33:
        Unit r112 = Unit.INSTANCE;
        r105.sendJsEvent("refresh_market_cart", r106);
        goto L34
    L28:
        r111 = null;
        goto L29
    L24:
        r108 = null;
    L31:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        int r114 = 8;
    L44:
        ?? r115 = 1;
    L71:
        BottomButtonVO r116 = this.f182234f;
        if (r116 == null) goto L74;
        TextWithOneIconElement r117 = r116.getAddCartComponent();
    L75:
        BottomButtonVO r118 = this.f182234f;
        if (r118 == null) goto L80;
        BottomButtonMeta r119 = r118.getBottomButtonMetaValue();
        if (r119 == null) goto L80;
        EnterCartMeta r120 = r119.getEnterCartMeta();
    L81:
        if (r120 != null) goto L83;
    L82:
        int r121 = 0;
    L120:
        BottomTipComponent r122 = getBottomTipComponent();
        TextWithOneIconElement r123 = r210.getTipVO();
        LynxCardComponent r124 = r210.getLynxTip();
        BottomButtonMeta r125 = r210.getBottomButtonMetaValue();
        if (r125 == null) goto L123;
        BottomTipMeta r126 = r125.getTipMeta();
    L124:
        r122.a(r123, r124, r126, r211);
        CommonMeta r127 = r211.a();
        if (r127 == 0) goto L127;
        r127.setBottomTipExist(r115);
    L127:
        CommonMeta r128 = r211.a();
        if (r128 == null) goto L130;
        Boolean r129 = Boolean.valueOf(r128.getEnablePDPOptimize());
    L132:
        if (com.bytedance.android.shopping.extensions.k.i(r129) == false) goto L143;
        BottomButtonVO r130 = this.f182234f;
        if (r130 == null) goto L136;
        LynxCardComponent r131 = r130.getLynxTip();
    L137:
        if (r131 != null) goto L143;
        BottomButtonVO r132 = this.f182234f;
        if (r132 == null) goto L141;
        r110 = r132.getTipVO();
    L141:
        if (r110 != null) goto L143;
        findViewById(R.id.button_top_border_view).setVisibility(r121);
        return;
    L136:
        r131 = null;
    L143:
        findViewById(R.id.button_top_border_view).setVisibility(r114);
        return;
    L130:
        r129 = null;
        goto L132
    L123:
        r126 = null;
        goto L124
    L83:
        TextView r133 = getCartNumberComponent().b(r120);
        View r134 = ExtensionsKt.k(getLeftGroupItems(), "ref_cart");
        if ((r134 instanceof TextWithOneIconElementView) == true) goto L86;
        r134 = null;
    L86:
        TextWithOneIconElementView r135 = (TextWithOneIconElementView) r134;
        if (r135 == null) goto L82;
        this.f182243o = r135.getIconView();
        r121 = 0;
        r135.setClipChildren(false);
        r135.setClipToPadding(false);
        getLeftGroupItems().setClipChildren(false);
        getLeftGroupItems().setClipToPadding(false);
        ECLottieAnimationView r136 = new ECLottieAnimationView(r135.getContext());
        this.f182242n = r136;
        r136.setVisibility(4);
        if (com.bytedance.android.shopping.anchorv4.experiment.h.f166759c != r115) goto L91;
        boolean r137 = true;
    L92:
        if (r137 == false) goto L94;
        r136.setAnimation("ec_commerce_cart_lottie_opt.json");
    L95:
        r136.setImageAssetsFolder("images");
        r136.setBackgroundColor(-1);
        r136.addAnimatorListener(new h(this));
        FrameLayout.LayoutParams r138 = new FrameLayout.LayoutParams(-2, -2);
        if (r117 == null) goto L102;
        ImageModel r139 = r117.getIcon();
        if (r139 == null) goto L102;
        ECUrlModel r140 = r139.getRemote();
        if (r140 == null) goto L102;
        int r141 = Integer.valueOf(r140.getWidth());
    L103:
        r138.width = com.bytedance.android.shopping.extensions.b.b(r141);
        if (r117 == null) goto L110;
        ImageModel r142 = r117.getIcon();
        if (r142 == null) goto L110;
        ECUrlModel r143 = r142.getRemote();
        if (r143 == null) goto L110;
        int r144 = Integer.valueOf(r143.getHeight());
    L111:
        r138.height = com.bytedance.android.shopping.extensions.b.b(r144);
        r138.gravity = r115;
        Unit r145 = Unit.INSTANCE;
        r135.a(r136, r138);
        ViewGroup.MarginLayoutParams r146 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r117 == null) goto L118;
        ImageModel r147 = r117.getIcon();
        if (r147 == null) goto L118;
        ECUrlModel r148 = r147.getRemote();
        if (r148 == null) goto L118;
        int r149 = Integer.valueOf(r148.getWidth());
    L119:
        r146.leftMargin = ((com.bytedance.android.shopping.extensions.b.b(r149) - com.bytedance.android.shopping.extensions.b.b(22)) / 2) + com.bytedance.android.shopping.extensions.b.b(14);
        r146.topMargin = com.bytedance.android.shopping.extensions.b.b(-5);
        r135.a(r133, r146);
    L118:
        r149 = 22;
    L110:
        r144 = 22;
    L102:
        r141 = 22;
        goto L103
    L94:
        r136.setAnimation("ec_commerce_cart_lottie.json");
        goto L95
    L91:
        r137 = false;
    L80:
        r120 = null;
        goto L81
    L74:
        r117 = null;
        goto L75
    L35:
        Activity r150 = d0.f165305a.getActivity(getContext());
        if (r150 == null) goto L34;
        LynxCardComponent r151 = r210.getSuperMarketVO();
        if (r151 == null) goto L34;
        String r152 = r151.getSchema();
        if (r152 == null) goto L34;
        r114 = 8;
        ti.l r153 = ECLiveHybridUtil.b(r150, r152, r104, getSuperMarketButtons(), this, null, null, false, null, null, false, 4064);
        w.a.e(w.f166998b, r153, getContext(), Boolean.valueOf(r211.C()), 8);
        Unit r154 = Unit.INSTANCE;
        this.f182237i = r153;
    L14:
        r104 = null;
        goto L16
    L45:
        r114 = 8;
        BottomButtonConfig r155 = r210.getBottomButtonConfig();
        if (r155 == null) goto L48;
        Boolean r156 = r155.getNeedEnlarged();
    L50:
        if (Intrinsics.areEqual(r156, Boolean.TRUE) == true) goto L52;
    L70:
        r115 = 1;
        a(r210, r211);
        goto L71
    L52:
        if (this.f182240l <= com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS))) goto L70;
        if (this.f182241m == true) goto L68;
        LinearLayout r157 = getNormalButtons();
        ViewGroup.LayoutParams r158 = r157.getLayoutParams();
        r158.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r158.height = com.bytedance.android.shopping.extensions.b.b(60);
        Unit r159 = Unit.INSTANCE;
        r157.setLayoutParams(r158);
        LinearLayout r160 = getScaleContent();
        ViewGroup.LayoutParams r161 = r160.getLayoutParams();
        float r162 = com.bytedance.android.shopping.extensions.b.b(60);
        float r163 = this.f182240l;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r164 = this.f182238j;
        if (r164 == null) goto L60;
        CommonMeta r165 = r164.a();
        if (r165 == null) goto L60;
        float r166 = h73.a.f(r165);
    L61:
        r161.height = (int) (r162 * (r163 / q.a(Float.valueOf(r166))));
        r160.setLayoutParams(r161);
        setEnlargedConfig(getNormalButtons());
        BottomButtonVO r167 = this.f182234f;
        if (r167 == null) goto L64;
        LynxCardComponent r168 = r167.getLynxTip();
    L65:
        if (r168 != null) goto L67;
        LinearLayout r169 = getBottomTipComponent().f181295d;
        ViewGroup.LayoutParams r170 = r169.getLayoutParams();
        r170.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r169.setLayoutParams(r170);
        setEnlargedConfig(getBottomTipComponent().f181295d);
    L67:
        boolean r171 = true;
        this.f182241m = true;
    L69:
        a(r210, r211);
        r115 = r171;
        goto L71
    L64:
        r168 = null;
    L60:
        r166 = 375.0f;
        goto L61
    L68:
        r171 = true;
        goto L69
    L48:
        r156 = null;
        goto L50
    }

    public final void e(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "showToast");
        ECLottieAnimationView r102 = this.f182242n;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        ECLottieAnimationView r103 = this.f182242n;
        if (r103 == null) goto L8;
        r103.playAnimation();
    L8:
        getCartNumberComponent().d(r100, r101);
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public BottomButtonView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f182229a = LazyKt.lazy(new BottomButtonView$leftGroupItems$2(this));
        this.f182230b = LazyKt.lazy(new BottomButtonView$rightGroupButtons$2(this));
        this.f182231c = LazyKt.lazy(new BottomButtonView$scaleContent$2(this));
        this.f182232d = LazyKt.lazy(new BottomButtonView$normalButtons$2(this));
        this.f182233e = LazyKt.lazy(new BottomButtonView$superMarketButtons$2(this));
        this.f182235g = LazyKt.lazy(new BottomButtonView$cartNumberComponent$2(r100));
        this.f182236h = LazyKt.lazy(new BottomButtonView$bottomTipComponent$2(this));
        this.f182240l = k1.m(r100);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_bottom_button_layout, this, true);
        setBackgroundColor(-1);
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public /* synthetic */ BottomButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
