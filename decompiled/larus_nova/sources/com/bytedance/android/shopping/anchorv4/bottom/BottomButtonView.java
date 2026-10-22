package com.bytedance.android.shopping.anchorv4.bottom;

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
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
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

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0017\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\rR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001a\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001d\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R#\u0010 \u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0019R#\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonView;", "Landroid/widget/FrameLayout;", "Lti/k;", "Landroid/widget/LinearLayout;", "enlargedView", "", "setEnlargedConfig", "", "isVisible", "setTipsVisible", "(Ljava/lang/Boolean;)V", "", "getLynxLocationY", "Landroid/view/View;", "getSuperMarketLynxView", "getCartIcon", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLeftGroupItems", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "leftGroupItems", "b", "getRightGroupButtons", "()Landroid/widget/LinearLayout;", "rightGroupButtons", "c", "getScaleContent", "scaleContent", "d", "getNormalButtons", "normalButtons", "e", "getSuperMarketButtons", "()Landroid/widget/FrameLayout;", "superMarketButtons", "Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", ce.f26391f, "getCartNumberComponent", "()Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", "cartNumberComponent", "Lcom/bytedance/android/shopping/anchorv4/bottom/l;", "h", "getBottomTipComponent", "()Lcom/bytedance/android/shopping/anchorv4/bottom/l;", "bottomTipComponent", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElementView;", ce.f26396k, "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElementView;", "getFirstButtonElementView", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElementView;", "setFirstButtonElementView", "(Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElementView;)V", "firstButtonElementView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonView extends FrameLayout implements ti.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f165725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f165726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f165727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f165728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomButtonVO f165729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f165730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f165731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ti.l f165732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnchorV4VM f165733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BottomButtonElementView f165734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f165735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f165736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECLottieAnimationView f165737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f165738o;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f165739a;

        public b(View r100) {
            this.f165739a = r100;
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
            this.f165739a.setVisibility(8);
        L17:
            return false;
        L14:
            if (r102.intValue() != 2) goto L16;
        L15:
            this.f165739a.setVisibility(0);
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

    private final l getBottomTipComponent() {
        return (l) this.f165731h.getValue();
    }

    private final CartNumberComponent getCartNumberComponent() {
        return (CartNumberComponent) this.f165730g.getValue();
    }

    private final TagsScrollBoxComponentView getLeftGroupItems() {
        return (TagsScrollBoxComponentView) this.f165724a.getValue();
    }

    private final LinearLayout getNormalButtons() {
        return (LinearLayout) this.f165727d.getValue();
    }

    private final LinearLayout getRightGroupButtons() {
        return (LinearLayout) this.f165725b.getValue();
    }

    private final LinearLayout getScaleContent() {
        return (LinearLayout) this.f165726c.getValue();
    }

    private final FrameLayout getSuperMarketButtons() {
        return (FrameLayout) this.f165728e.getValue();
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final int getLynxLocationY() {
        ti.l r100 = this.f165732i;
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
        ti.l r103 = this.f165732i;
        if (r103 == null) goto L9;
        r101 = r103.b();
        goto L10
    L9:
        r101 = null;
        goto L10
    }

    public final View getSuperMarketLynxView() {
        ti.l r100 = this.f165732i;
        if (r100 == null) goto L6;
        View r101 = r100.getHybridView();
        if (r101 == null) goto L6;
        return r101;
    L6:
        ti.l r102 = this.f165732i;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.b();
    }

    public final void d() {
        getCartNumberComponent().getClass();
        ti.l r100 = this.f165732i;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final View getCartIcon() {
        return this.f165738o;
    }

    public final BottomButtonElementView getFirstButtonElementView() {
        return this.f165734k;
    }

    private final void setEnlargedConfig(LinearLayout r100) {
        float r101 = k1.m(r100.getContext()) / com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r100.setPivotX(0.0f);
        r100.setPivotY(0.0f);
        r100.setScaleX(r101);
        r100.setScaleY(r101);
    }

    public final void f(boolean r100) {
        ti.l r101 = this.f165732i;
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
        this.f165734k = r100;
    }

    public final void setTipsVisible(Boolean r100) {
        l r101 = getBottomTipComponent();
        r101.getClass();
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.f165853d.setVisibility(0);
        return;
    L6:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L10;
        r101.f165853d.setVisibility(8);
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
    /* JADX WARN: Type inference failed for: r6v14, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.bytedance.android.shopping.anchorv4.dto.base.Radius] */
    public final void a(BottomButtonVO r210, AnchorV4VM r211) {
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
        r118.post(new h(r111, r116, r118));
    L45:
        r108 = r110;
        goto L23
    L30:
        r113 = 0;
    L46:
        List<BottomButtonElement> r119 = r210.getRightButtons();
        if (r211.pageStatus().f167760z == false) goto L53;
        List<BottomButtonElement> r120 = r210.getRightButtonsSmallMode();
        if (r120 == null) goto L53;
        if ((!r120.isEmpty()) != true) goto L53;
        r119 = r210.getRightButtonsSmallMode();
    L53:
        if (r119 == null) goto L102;
        Iterator r121 = r119.iterator();
        int r122 = 0;
    L56:
        if (r121.hasNext() == false) goto L113;
        Object r123 = r121.next();
        int r124 = r122 + 1;
        if (r122 >= 0) goto L60;
        CollectionsKt.throwIndexOverflow();
    L60:
        BottomButtonElement r125 = (BottomButtonElement) r123;
        if (r122 >= 1) goto L63;
    L77:
        Context r126 = getContext();
        if (com.bytedance.android.shopping.anchorv4.experiment.h.f166759c != 1) goto L80;
        boolean r127 = true;
    L81:
        if (r127 == false) goto L83;
        ?? r128 = "DouyinNumberABC";
    L84:
        BottomButtonElementView r129 = new BottomButtonElementView(r126, null, 0, r128, 14);
        r129.a(r125, r210, r211);
        if (r122 != 0) goto L87;
        this.f165734k = r129;
    L87:
        Background r130 = r125.getBackground();
        if (r130 == null) goto L90;
        ?? r131 = r130.getRadius();
    L91:
        String r132 = r125.getClickMaskColor();
        if (r131 != 0) goto L103;
        ?? r133 = r103;
    L97:
        ?? r134 = new View(getContext());
        Intrinsics.checkNotNullParameter(r134, "$this$setBackgroundCompat");
        r134.setBackground(r133);
        ?? r135 = new FrameLayout(getContext());
        r135.addView(r129, new FrameLayout.LayoutParams(-1, -1));
        r135.addView(r134, new FrameLayout.LayoutParams(-1, -1));
        r134.setVisibility(8);
        ?? r136 = getRightGroupButtons();
        LinearLayout.LayoutParams r137 = new LinearLayout.LayoutParams(0, -1);
        Float r138 = r125.getWeight();
        if (r138 == null) goto L100;
        float r139 = r138.floatValue();
    L101:
        r137.weight = r139;
        Unit r140 = Unit.INSTANCE;
        r136.addView(r135, r137);
        r129.setOnTouchListener(new b(r134));
        r122 = r124;
        r103 = null;
        goto L56
    L100:
        r139 = 1.0f;
        goto L101
    L103:
        GradientDrawable r141 = new GradientDrawable();     // Catch: Exception -> L96
        r141.setCornerRadii(new float[]{com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getBottomLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r131.getBottomLeft()))});     // Catch: Exception -> L96
        r141.setColor(Color.parseColor(r132));     // Catch: Exception -> L96
        r133 = r141;
    L96:
        r133 = 0;
        goto L97
    L90:
        r131 = r103;
        goto L91
    L83:
        r128 = r103;
        goto L84
    L80:
        r127 = false;
        goto L81
    L63:
        if (r210.getRightButtonDivider() == null) goto L77;
        ?? r142 = getRightGroupButtons();
        ?? r143 = new FrameLayout(getContext());
        ExtensionsKt.j(r143, r210.getRightButtonDivider().getBackground());
        SimpleDraweeView r144 = new SimpleDraweeView(getContext());
        ImageModel r145 = r210.getRightButtonDivider().getImage();
        if (r145 == null) goto L69;
        ECUrlModel r146 = r145.getRemote();
        if (r146 == null) goto L69;
        int r147 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r146.getWidth()));
    L70:
        ImageModel r148 = r210.getRightButtonDivider().getImage();
        if (r148 == null) goto L75;
        ECUrlModel r149 = r148.getRemote();
        if (r149 == null) goto L75;
        int r150 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r149.getHeight()));
    L76:
        FrameLayout.LayoutParams r151 = new FrameLayout.LayoutParams(r147, r150);
        r151.gravity = 16;
        Unit r152 = Unit.INSTANCE;
        r144.setLayoutParams(r151);
        ImageExtensionsKt.d(r144, r210.getRightButtonDivider().getImage(), r103);
        r143.addView(r144);
        r142.addView(r143, new FrameLayout.LayoutParams(-2, -1));
    L75:
        r150 = 0;
    L69:
        r147 = 0;
        goto L70
    L113:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v8, types: [boolean, int] */
    public final void c(BottomButtonVO r210, AnchorV4VM r211) {
        Intrinsics.checkNotNullParameter(r210, "bottomButtonVO");
        String r110 = "anchorV4VM";
        Intrinsics.checkNotNullParameter(r211, "anchorV4VM");
        this.f165729f = r210;
        this.f165733j = r211;
        TextWithOneIconElement r111 = null;
        if (r210.getSuperMarketVO() == null) goto L49;
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
        ti.l r105 = this.f165732i;
        if (r105 == null) goto L34;
        JSONObject r106 = new JSONObject();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        if (r104 == null) goto L24;
        Object r108 = r104.get("product_status");     // Catch: Throwable -> L31
    L25:
        r106.put("product_status", r108);     // Catch: Throwable -> L31
        LynxCardComponent r109 = r210.getSuperMarketVO();     // Catch: Throwable -> L31
        if (r109 == null) goto L28;
        String r112 = r109.getSchema();     // Catch: Throwable -> L31
    L29:
        Result.m9449constructorimpl(r106.put("schema", r112));     // Catch: Throwable -> L31
    L33:
        Unit r113 = Unit.INSTANCE;
        r105.sendJsEvent("refresh_market_cart", r106);
        goto L34
    L28:
        r112 = null;
        goto L29
    L24:
        r108 = null;
    L31:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        int r115 = 8;
    L48:
        ?? r116 = 1;
    L75:
        BottomButtonVO r117 = this.f165729f;
        if (r117 == null) goto L78;
        TextWithOneIconElement r118 = r117.getAddCartComponent();
    L79:
        BottomButtonVO r119 = this.f165729f;
        if (r119 == null) goto L84;
        BottomButtonMeta r120 = r119.getBottomButtonMetaValue();
        if (r120 == null) goto L84;
        EnterCartMeta r121 = r120.getEnterCartMeta();
    L86:
        if (r121 != null) goto L88;
    L87:
        int r122 = 0;
    L125:
        l r123 = getBottomTipComponent();
        TextWithOneIconElement r124 = r210.getTipVO();
        LynxCardComponent r125 = r210.getLynxTip();
        BottomButtonMeta r126 = r210.getBottomButtonMetaValue();
        if (r126 == null) goto L128;
        BottomTipMeta r127 = r126.getTipMeta();
    L129:
        r210.getBottomButtonConfig();
        r123.getClass();
        Intrinsics.checkNotNullParameter(r211, r110);
        if (r124 != null) goto L133;
        if (r125 != null) goto L133;
        r123.f165851b.setVisibility(r115);
        r123.f165852c.setVisibility(r115);
    L179:
        CommonMeta r128 = r211.commonMeta();
        if (r128 == 0) goto L182;
        r128.setBottomTipExist(r116);
    L182:
        CommonMeta r129 = r211.commonMeta();
        if (r129 == null) goto L185;
        Boolean r130 = Boolean.valueOf(r129.getEnablePDPOptimize());
    L187:
        if (com.bytedance.android.shopping.extensions.k.i(r130) == false) goto L198;
        BottomButtonVO r131 = this.f165729f;
        if (r131 == null) goto L191;
        LynxCardComponent r132 = r131.getLynxTip();
    L192:
        if (r132 != null) goto L198;
        BottomButtonVO r133 = this.f165729f;
        if (r133 == null) goto L196;
        r111 = r133.getTipVO();
    L196:
        if (r111 != null) goto L198;
        findViewById(R.id.button_top_border_view).setVisibility(r122);
        return;
    L191:
        r132 = null;
    L198:
        findViewById(R.id.button_top_border_view).setVisibility(r115);
        return;
    L185:
        r130 = null;
    L133:
        if (r124 != null) goto L135;
        r123.f165851b.setVisibility(r115);
    L135:
        if (r125 != null) goto L171;
        r123.f165852c.setVisibility(r115);
        if (r124 == null) goto L179;
        r123.f165850a = r127;
        r123.f165851b.setVisibility(r122);
        if (r127 == null) goto L155;
        String r134 = r127.getTipUrl();
        if (r134 == null) goto L155;
        if (com.bytedance.android.shopping.extensions.k.c(r134) == true) goto L147;
        r134 = null;
    L147:
        if (r134 == null) goto L155;
        r123.f165851b.setOnClickListener(new j(r134, r123, r211, r127));
        int r135 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r136 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r211);
        if (r136 == null) goto L155;
        JSONObject r137 = com.bytedance.android.shopping.extensions.k.w(r127.getTrackParamsJStr());
        if (r137 == null) goto L153;
        Map<String, ? extends Object> r138 = com.bytedance.android.shopping.hybrid.a.b(r137);
    L154:
        r136.f167498c = r138;
        AnchorV4TrackerImpl.b(r136, "show_logistics_tab", false, null, false, null, 30);
        goto L155
    L153:
        r138 = null;
    L155:
        if (r127 == null) goto L163;
        int r139 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r140 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r211);
        if (r140 == null) goto L163;
        JSONObject r141 = com.bytedance.android.shopping.extensions.k.w(r127.getTrackParamsJStr());
        if (r141 == null) goto L161;
        Map<String, ? extends Object> r142 = com.bytedance.android.shopping.hybrid.a.b(r141);
    L162:
        r140.f167498c = r142;
        AnchorV4TrackerImpl.b(r140, "bottom_tip_show", false, null, false, null, 30);
        goto L163
    L161:
        r142 = null;
    L163:
        r123.f165851b.a(r124);
        if (r127 == null) goto L166;
        Boolean r143 = Boolean.valueOf(r127.getDisplayAsCountDown());
    L168:
        if (com.bytedance.android.shopping.extensions.k.i(r143) == false) goto L179;
        r211.listenActivityTick(r123);
        goto L179
    L166:
        r143 = null;
        goto L168
    L171:
        if (PdpPerfOpt.e() == false) goto L173;
        r211.getPdpTaskManager().i(new k(r123, r125), r116);
    L178:
        r123.f165852c.setVisibility(r122);
        goto L179
    L173:
        LynxCardView r144 = r123.f165852c;
        if (LargeFontModeUtil.a() <= 1.0f) goto L176;
        boolean r145 = true;
    L177:
        LynxCardView.a(r144, r125, r145, 2);
        goto L178
    L176:
        r145 = false;
        goto L177
    L128:
        r127 = null;
        goto L129
    L88:
        TextView r146 = getCartNumberComponent().b(r121);
        View r147 = ExtensionsKt.k(getLeftGroupItems(), "ref_cart");
        if ((r147 instanceof TextWithOneIconElementView) == true) goto L91;
        r147 = null;
    L91:
        TextWithOneIconElementView r148 = (TextWithOneIconElementView) r147;
        if (r148 == null) goto L87;
        this.f165738o = r148.getIconView();
        r122 = 0;
        r148.setClipChildren(false);
        r148.setClipToPadding(false);
        getLeftGroupItems().setClipChildren(false);
        getLeftGroupItems().setClipToPadding(false);
        ECLottieAnimationView r149 = new ECLottieAnimationView(r148.getContext());
        this.f165737n = r149;
        r149.setVisibility(4);
        if (com.bytedance.android.shopping.anchorv4.experiment.h.f166759c != r116) goto L96;
        boolean r150 = true;
    L97:
        if (r150 == false) goto L99;
        r149.setAnimation("ec_commerce_cart_lottie_opt.json");
    L100:
        r149.setImageAssetsFolder("images");
        r149.setBackgroundColor(-1);
        r149.addAnimatorListener(new i(this));
        FrameLayout.LayoutParams r151 = new FrameLayout.LayoutParams(-2, -2);
        if (r118 == null) goto L107;
        ImageModel r152 = r118.getIcon();
        if (r152 == null) goto L107;
        ECUrlModel r153 = r152.getRemote();
        if (r153 == null) goto L107;
        int r154 = Integer.valueOf(r153.getWidth());
    L108:
        r151.width = com.bytedance.android.shopping.extensions.b.b(r154);
        if (r118 == null) goto L115;
        ImageModel r155 = r118.getIcon();
        if (r155 == null) goto L115;
        ECUrlModel r156 = r155.getRemote();
        if (r156 == null) goto L115;
        int r157 = Integer.valueOf(r156.getHeight());
    L116:
        r151.height = com.bytedance.android.shopping.extensions.b.b(r157);
        r151.gravity = r116;
        Unit r158 = Unit.INSTANCE;
        r148.a(r149, r151);
        ViewGroup.MarginLayoutParams r159 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r118 == null) goto L123;
        ImageModel r160 = r118.getIcon();
        if (r160 == null) goto L123;
        ECUrlModel r161 = r160.getRemote();
        if (r161 == null) goto L123;
        int r162 = Integer.valueOf(r161.getWidth());
    L124:
        r159.leftMargin = ((com.bytedance.android.shopping.extensions.b.b(r162) - com.bytedance.android.shopping.extensions.b.b(22)) / 2) + com.bytedance.android.shopping.extensions.b.b(14);
        r159.topMargin = com.bytedance.android.shopping.extensions.b.b(-5);
        r148.a(r146, r159);
    L123:
        r162 = 22;
    L115:
        r157 = 22;
    L107:
        r154 = 22;
        goto L108
    L99:
        r149.setAnimation("ec_commerce_cart_lottie.json");
        goto L100
    L96:
        r150 = false;
    L84:
        r121 = null;
        goto L86
    L78:
        r118 = null;
        goto L79
    L35:
        Activity r163 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(getContext());
        if (r163 == null) goto L34;
        LynxCardComponent r164 = r210.getSuperMarketVO();
        if (r164 == null) goto L34;
        String r165 = r164.getSchema();
        if (r165 == null) goto L34;
        ti.l r166 = ECLiveHybridUtil.b(r163, r165, r104, getSuperMarketButtons(), this, null, null, false, null, null, false, 4064);
        com.bytedance.android.shopping.anchorv4.helper.w.a r167 = com.bytedance.android.shopping.anchorv4.helper.w.f166998b;
        Context r168 = getContext();
        AnchorV4VM r169 = this.f165733j;
        if (r169 == null) goto L46;
        Boolean r170 = Boolean.valueOf(r169.isInSplit());
    L47:
        r115 = 8;
        com.bytedance.android.shopping.anchorv4.helper.w.a.e(r167, r166, r168, r170, 8);
        Unit r171 = Unit.INSTANCE;
        this.f165732i = r166;
        goto L48
    L46:
        r170 = null;
    L14:
        r104 = null;
        goto L16
    L49:
        r110 = "anchorV4VM";
        r115 = 8;
        BottomButtonConfig r172 = r210.getBottomButtonConfig();
        if (r172 == null) goto L52;
        Boolean r173 = r172.getNeedEnlarged();
    L54:
        if (Intrinsics.areEqual(r173, Boolean.TRUE) == true) goto L56;
    L74:
        r116 = 1;
        a(r210, r211);
        goto L75
    L56:
        if (this.f165735l <= com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS))) goto L74;
        if (this.f165736m == true) goto L72;
        LinearLayout r174 = getNormalButtons();
        ViewGroup.LayoutParams r175 = r174.getLayoutParams();
        r175.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r175.height = com.bytedance.android.shopping.extensions.b.b(60);
        Unit r176 = Unit.INSTANCE;
        r174.setLayoutParams(r175);
        LinearLayout r177 = getScaleContent();
        ViewGroup.LayoutParams r178 = r177.getLayoutParams();
        float r179 = com.bytedance.android.shopping.extensions.b.b(60);
        float r180 = this.f165735l;
        AnchorV4VM r181 = this.f165733j;
        if (r181 == null) goto L64;
        CommonMeta r182 = r181.commonMeta();
        if (r182 == null) goto L64;
        float r183 = h73.a.f(r182);
    L65:
        r178.height = (int) (r179 * (r180 / com.bytedance.android.ec.core.utils.q.a(Float.valueOf(r183))));
        r177.setLayoutParams(r178);
        setEnlargedConfig(getNormalButtons());
        BottomButtonVO r184 = this.f165729f;
        if (r184 == null) goto L68;
        LynxCardComponent r185 = r184.getLynxTip();
    L69:
        if (r185 != null) goto L71;
        LinearLayout r186 = getBottomTipComponent().f165853d;
        ViewGroup.LayoutParams r187 = r186.getLayoutParams();
        r187.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        r186.setLayoutParams(r187);
        setEnlargedConfig(getBottomTipComponent().f165853d);
    L71:
        boolean r188 = true;
        this.f165736m = true;
    L73:
        a(r210, r211);
        r116 = r188;
        goto L75
    L68:
        r185 = null;
    L64:
        r183 = 375.0f;
        goto L65
    L72:
        r188 = true;
        goto L73
    L52:
        r173 = null;
        goto L54
    }

    public final void e(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "showToast");
        ECLottieAnimationView r102 = this.f165737n;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        ECLottieAnimationView r103 = this.f165737n;
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
        this.f165724a = LazyKt.lazy(new BottomButtonView$leftGroupItems$2(this));
        this.f165725b = LazyKt.lazy(new BottomButtonView$rightGroupButtons$2(this));
        this.f165726c = LazyKt.lazy(new BottomButtonView$scaleContent$2(this));
        this.f165727d = LazyKt.lazy(new BottomButtonView$normalButtons$2(this));
        this.f165728e = LazyKt.lazy(new BottomButtonView$superMarketButtons$2(this));
        this.f165730g = LazyKt.lazy(new BottomButtonView$cartNumberComponent$2(r100));
        this.f165731h = LazyKt.lazy(new BottomButtonView$bottomTipComponent$2(this));
        this.f165735l = k1.m(r100);
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
