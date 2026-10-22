package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/ECCartLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "need", "", "setNeedHint", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMainLayout", "()Landroid/view/View;", "mainLayout", "e", "getLoadingLayout", "loadingLayout", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "f", "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/widget/ImageView;", ce.f26391f, "getIvWireframe", "()Landroid/widget/ImageView;", "ivWireframe", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "getCartObjectContainer", "()Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "setCartObjectContainer", "(Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;)V", "cartObjectContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f179449l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f179450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f179451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f179452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f179453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f179454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f179455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f179456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f179457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CartObjectContainer f179458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f179459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f179460k;

    public ECCartLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCartLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.f179455f.getValue();
    }

    private final ImageView getIvWireframe() {
        return (ImageView) this.f179456g.getValue();
    }

    private final View getLoadingLayout() {
        return (View) this.f179454e.getValue();
    }

    private final View getMainLayout() {
        return (View) this.f179450a.getValue();
    }

    public final void U5() {
        ValueAnimator r100 = this.f179459j;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
        r100.removeAllListeners();
        r100.cancel();
        r100.end();
    L5:
        this.f179459j = null;
    }

    public final void Y5() {
        int r100 = com.bytedance.ies.xbridge.base.utils.c.f249457a;
        int r101 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        this.f179451b = getMainLayout().findViewById(R.id.header);
        CartObjectContainer r102 = this.f179458i;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L6:
        if (r102.f178935e.f178995p == true) goto L15;
        View r103 = this.f179451b;
        if (r103 == null) goto L15;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r104 = null;
    L12:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L15;
        r105.topMargin = r101;
        r103.setLayoutParams(r105);
    L15:
        View r106 = this.f179451b;
        if (r106 == null) goto L23;
        View r107 = r106.findViewById(R.id.iv_back);
        if (r107 == null) goto L23;
        CartObjectContainer r108 = this.f179458i;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L22:
        wg.a.h(r107, r108.f178935e.f178990k);
        r107.setOnClickListener(new f(r107, this));
    L23:
        this.f179453d = (LinearLayout) getMainLayout().findViewById(R.id.footer);
        this.f179452c = (LinearLayout) getMainLayout().findViewById(R.id.tab);
        CartObjectContainer r109 = this.f179458i;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L27:
        if (r109.f178935e.f178995p == false) goto L31;
        LinearLayout r110 = this.f179452c;
        if (r110 == null) goto L49;
        ExtensionsKt.gone(r110);
    L49:
        CartViewExtentionsKt.d(getIvWireframe());
        return;
    L31:
        LinearLayout r111 = this.f179452c;
        if (r111 == null) goto L34;
        ExtensionsKt.visible(r111);
    L34:
        LinearLayout r112 = this.f179452c;
        if (r112 == null) goto L37;
        ViewExtensionsKt.g(r112, 0.0f, 0.0f, 20.0f, 20.0f);
    L37:
        View r113 = V5(64, 26, 14);
        View r114 = V5(64, 26, 14);
        View r115 = V5(96, 26, 14);
        LinearLayout r116 = this.f179452c;
        if (r116 == null) goto L40;
        r116.addView(r113);
    L40:
        LinearLayout r117 = this.f179452c;
        if (r117 == null) goto L43;
        r117.addView(r114);
    L43:
        LinearLayout r118 = this.f179452c;
        if (r118 == null) goto L46;
        r118.addView(r115);
    L46:
        View r119 = V5(112, 44, 44);
        LinearLayout r120 = this.f179453d;
        if (r120 == null) goto L49;
        r120.addView(r119);
        goto L49
    }

    public final CartObjectContainer getCartObjectContainer() {
        CartObjectContainer r100 = this.f179458i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U5();
        View r100 = this.f179460k;
        if (r100 == null) goto L5;
        r100.setTranslationX(0.0f);
    L5:
        this.f179460k = null;
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(ECCartLoadingView r100) {
        return r100.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(ECCartLoadingView r100) {
        return r100.getLoadingLayout();
    }

    public static final /* synthetic */ View T5(ECCartLoadingView r100) {
        return r100.getMainLayout();
    }

    public final void setCartObjectContainer(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179458i = r100;
    }

    public final void setNeedHint(boolean r100) {
        this.f179457h.set(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECCartLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f179450a = LazyKt.lazy(new ECCartLoadingView$mainLayout$2(this));
        this.f179454e = LazyKt.lazy(new ECCartLoadingView$loadingLayout$2(this));
        this.f179455f = LazyKt.lazy(new ECCartLoadingView$ballAnimationView$2(this));
        this.f179456g = LazyKt.lazy(new ECCartLoadingView$ivWireframe$2(this));
        this.f179457h = new AtomicBoolean(true);
        LayoutInflater.from(r100).inflate(R.layout.ec_cart_layout_loading, this, true);
        if ((r100 instanceof LifecycleOwner) == false) goto L6;
        DefaultLifecycleObserver r103 = new ECCartLoadingView$observer$1(this);
        ((LifecycleOwner) r100).getLifecycle().addObserver(r103);
        return;
    }

    public final View V5(int r100, int r101, int r102) {
        View r103 = new View(getContext());
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102)));
        r104.setColor(ColorProtector.parseColor("#0D161823"));
        Unit r105 = Unit.INSTANCE;
        r103.setBackground(r104);
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r100)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r101)));
        r106.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
        r103.setLayoutParams(r106);
        return r103;
    }

    public /* synthetic */ ECCartLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
