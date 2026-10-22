package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.LottieIconData;
import com.bytedance.android.ec.model.response.RelatedAction;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.p;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class WebpAnimatedWidget extends FrameLayout implements yk2.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f152747n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f152748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f152749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yk2.d f152750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yk2.a f152751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CartCardLinkedAnimController f152752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f152753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f152755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f152756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f152757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelatedAction f152758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Pair<RelatedAction, ? extends Runnable> f152759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RoomContextController f152760m;

    public static final class a {
    }

    static {
    }

    @Override // yk2.c
    public View getView() {
        return this;
    }

    private final yk2.d getCustomImageAdapter() {
        Lazy r100 = EnterRequestHandler.f151767a;
        String r101 = EnterRequestHandler.f();
        if (r101 != null) goto L7;
        return null;
    L7:
        return new e(CollectionsKt.listOf(r101));
    }

    @Override // yk2.c
    public String getCartAnimRelatedInfo() {
        RelatedAction r100 = this.f152758k;
        if (r100 != null) goto L5;
        return null;
    L5:
        RelatedAction.RelatedType r101 = r100.getRelatedType();
        if (c.f152768a[r101.ordinal()] != 1) goto L13;
        RelatedAction.BannerRelatedMeta r102 = r100.getBannerRelatedMeta();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getCartIconRelatedInfo();
    L13:
        return null;
    }

    public final void h() {
        Pair<RelatedAction, ? extends Runnable> r100 = this.f152759l;
        if (r100 == null) goto L5;
        MainThreadPostUtils.d(r100.component2());
    L5:
        this.f152759l = null;
    }

    @Override // yk2.c
    public final void unload() {
        this.f152756i.removeAllViews();
        this.f152757j = false;
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        p.f153104a = true;
        if (this.f152760m.v() == false) goto L5;
        this.f152760m.A().f151429t.e0();
    L6:
        ECLiveEntranceMonitor.trace$default("onAttachedToWindow", "WebpAnimatedWidget", false, 4, null);
        f152747n = true;
        return;
    L5:
        boolean r100 = EntryController.M1;
        EntryController.a.a().e0();
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean r100 = p.f153104a;
        p.f153104a = false;
        ECLiveEntranceMonitor.trace$default("onDetachedFromWindow", "WebpAnimatedWidget", false, 4, null);
    }

    @Override // yk2.b
    public final void playAnimation() {
        if (((ECNetImageView) d(R.id.iv_static)).getVisibility() == 0) goto L5;
        return;
    L5:
        ECLiveABUtils r100 = ECLiveABUtils.INSTANCE;
        boolean r101 = true;
        if (r100.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == false) goto L34;
        Lazy r102 = EnterRequestHandler.f151767a;
        IconItem r103 = EnterRequestHandler.g();
        if (r103 == null) goto L27;
        LottieIconData r104 = r103.getLottieIcon();
        if (r104 != null) goto L12;
    L17:
        String r105 = r103.getAnimatedIcon();
        if (r105 == null) goto L27;
        if (r105.length() > 0) goto L23;
        r101 = false;
    L23:
        if (r101 == false) goto L27;
        g(new e(CollectionsKt.listOf(r105)), false, false, r103);
        return;
    L12:
        if (r104.isValid() != true) goto L17;
        if (this.f152757j == true) goto L17;
        this.f152757j = true;
        i.f48124a.b(getContext());
    L27:
        if (r100.getEC_LIVE_SHOPPING_CART_DISABLE_ANIM() == false) goto L29;
        return;
    L29:
        yk2.d r106 = this.f152750c;
        if (r106 != null) goto L32;
        return;
    L32:
        g(r106, false, false, null);
        return;
    L34:
        yk2.d r107 = getCustomImageAdapter();
        if (r107 != null) goto L42;
        r107 = this.f152750c;
        if (r107 != null) goto L39;
    L41:
        r107 = null;
        goto L42
    L39:
        if ((!r100.getEC_LIVE_SHOPPING_CART_DISABLE_ANIM()) == false) goto L41;
    L42:
        if (r107 != null) goto L44;
        return;
    L44:
        g(r107, false, false, null);
    }

    @Override // yk2.c
    public final boolean c() {
        return this.f152755h;
    }

    @Override // yk2.b
    public yk2.a getController() {
        return this.f152751d;
    }

    public final yk2.d getDefaultImageAdapter() {
        return this.f152750c;
    }

    public final View d(int r100) {
        if (this.f152748a != null) goto L5;
        this.f152748a = new LinkedHashMap();
    L5:
        View r101 = this.f152748a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f152748a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f152749b == false) goto L6;
        System.out.println("Django: WebpAnimatedWidget:onDrawEnd");
        return;
    }

    @Override // yk2.b
    public void setController(yk2.a r100) {
        this.f152751d = r100;
    }

    public final void setD3Room(boolean r100) {
        this.f152754g = r100;
    }

    public final void setDefaultImageAdapter(yk2.d r100) {
        this.f152750c = r100;
    }

    public final void setEnableLinkedAnimation(boolean r100) {
        this.f152755h = r100;
    }

    public WebpAnimatedWidget(Context r100, RoomContextController r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContextController");
        CartCardLinkedAnimController r102 = null;
        super(r100, null, 0);
        this.f152760m = r101;
        this.f152748a = new LinkedHashMap();
        if (r101.v() == false) goto L9;
        ECContext r103 = r101.r();
        if (r103 == null) goto L14;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r104 = r103.getLinkedAnimController();
        if (r104 == null) goto L14;
        r102 = r104.getValue();
    L14:
        this.f152752e = r102;
        th.a.c(r100, R.layout.ec_widget_toolbar_webp_anim, this, true);
        ((ECNetImageView) d(R.id.ecniv_animated)).getHierarchy().setFadeDuration(0);
        setClipChildren(false);
        if (r102 == null) goto L17;
        r102.f151982d = this;
    L17:
        ViewGroup.LayoutParams r105 = ((FrameLayout) d(R.id.layout_cart_image)).getLayoutParams();
        if (r105 != null) goto L20;
    L27:
        this.f152756i = (FrameLayout) findViewById(R.id.fl_animated);
        if (this.f152757j == true) goto L32;
        this.f152757j = true;
        i.f48124a.b(getContext());
        return;
    L32:
        return;
    L20:
        if (r101.v() == true) goto L24;
        int r106 = RoomContextController.f151593h;
        r101 = RoomContextController.a.a();
    L24:
        if (r101.s() == true) goto L26;
        r105.width = UtilityKotlinExtentionsKt.d(38);
        r105.height = UtilityKotlinExtentionsKt.d(38);
        goto L27
    L26:
        r105.width = UtilityKotlinExtentionsKt.d(36);
        r105.height = UtilityKotlinExtentionsKt.d(36);
        goto L27
    L9:
        int r107 = RoomContextController.f151593h;
        ECContext r108 = RoomContextController.a.a().r();
        if (r108 == null) goto L14;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r109 = r108.getLinkedAnimController();
        if (r109 == null) goto L14;
        r102 = r109.getValue();
        goto L14
    }

    @Override // yk2.c
    public final void a(boolean r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "cartImageAdapter");
        g(r101, true, r100, null);
    }

    public final void e(String r100, float r101) {
        ((TextView) d(R.id.tv_shopping_number)).setText(r100);
        ViewGroup.LayoutParams r102 = ((TextView) d(R.id.tv_shopping_number)).getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 == null) goto L9;
        MarginLayoutParamsCompat.setMarginEnd(r103, w0.a(r101));
        return;
    }

    public final void f(boolean r100, int r101) {
        if (r100 == true) goto L6;
        this.f152753f = false;
        ((TextView) d(R.id.tv_shopping_number)).setVisibility(8);
        return;
    L6:
        if (r101 <= 0) goto L8;
        boolean r102 = true;
    L9:
        this.f152753f = r102;
        ((TextView) d(R.id.tv_shopping_number)).setVisibility(0);
        if (r101 > 0) goto L13;
        ((TextView) d(R.id.tv_shopping_number)).setVisibility(8);
        return;
    L13:
        if (r101 >= 10) goto L16;
        e(String.valueOf(r101), -2.0f);
        return;
    L16:
        if (r101 >= 100) goto L18;
        e(String.valueOf(r101), -4.0f);
        return;
    L18:
        e("99+", -6.0f);
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (f152747n == false) goto L6;
        f152747n = false;
        ECLiveEntranceMonitor.trace$default("onMeasure", "WebpAnimatedWidget", false, 4, null);
        return;
    }

    @Override // yk2.c
    public final void b(final boolean r100, e r101, e r102) {
        Intrinsics.checkNotNullParameter(r101, "smallCardImageAdapter");
        Intrinsics.checkNotNullParameter(r102, "cartImageAdapter");
        g(r102, true, r100, null);
        if (this.f152760m.v() == true) goto L6;
        ((ECNetImageView) d(R.id.ecniv_small_card_animated)).setVisibility(0);
        ECNetImageView r103 = (ECNetImageView) d(R.id.ecniv_small_card_animated);
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests((Object[]) r101.a());
        WebpAnimatedWidget$playSmallCardAnimation$1 r105 = WebpAnimatedWidget$playSmallCardAnimation$1.INSTANCE;
        Function0<Unit> r106 = new WebpAnimatedWidget$playSmallCardAnimation$2(this);
        Function1<Integer, Unit> r107 = new WebpAnimatedWidget$playSmallCardAnimation$3(this, r100);
        Intrinsics.checkNotNullParameter(r105, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r106, "onEnd");
        r103.setController(r104.setControllerListener(new f(null, r105, r106, r107)).build());
        return;
    }

    public final void g(yk2.d r100, final boolean r101, final boolean r102, final IconItem r103) {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L11;
        CartCardLinkedAnimController r104 = this.f152752e;
        if (r104 == null) goto L21;
        r104.f151980b = false;
        g r105 = r104.f151981c;
        if (r105 == null) goto L9;
        r105.a();
    L9:
        r104.f151981c = null;
        return;
    L21:
        return;
    L11:
        int r106 = (int) UtilityKotlinExtentionsKt.c(66);
        int r107 = (int) UtilityKotlinExtentionsKt.c(130);
        if (this.f152754g == false) goto L16;
        ViewGroup.LayoutParams r108 = ((ECNetImageView) d(R.id.ecniv_animated)).getLayoutParams();
        if (r108.width == r106) goto L19;
        r108.width = r106;
        r108.height = r106;
        ((ECNetImageView) d(R.id.ecniv_animated)).setLayoutParams(r108);
    L19:
        ECNetImageView r109 = (ECNetImageView) d(R.id.ecniv_animated);
        PipelineDraweeControllerBuilder r110 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests((Object[]) r100.a());
        Function0<Unit> r111 = new WebpAnimatedWidget$playAnimationImpl$1(this, r103, r101, r102);
        Function0<Unit> r112 = new WebpAnimatedWidget$playAnimationImpl$2(this, r101, r102);
        Function1<Integer, Unit> r113 = new WebpAnimatedWidget$playAnimationImpl$3(this, r102);
        Intrinsics.checkNotNullParameter(r111, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r112, "onEnd");
        r109.setController(r110.setControllerListener(new f(null, r111, r112, r113)).build());
        return;
    L16:
        ViewGroup.LayoutParams r114 = ((ECNetImageView) d(R.id.ecniv_animated)).getLayoutParams();
        if (r114.width == r107) goto L19;
        r114.width = r107;
        r114.height = r107;
        ((ECNetImageView) d(R.id.ecniv_animated)).setLayoutParams(r114);
        goto L19
    }
}
