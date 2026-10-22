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
import com.amap.api.col.s.ce;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "need", "", "setNeedHint", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/l;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/l;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/k;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/k;)V", "viewAction", "Landroid/view/View;", "c", "Lkotlin/Lazy;", "getMainLayout", "()Landroid/view/View;", "mainLayout", ce.f26391f, "getLoadingLayout", "loadingLayout", "Landroid/widget/ImageView;", "h", "getIvWireframe", "()Landroid/widget/ImageView;", "ivWireframe", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", RXScreenCaptureService.KEY_INDEX, "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCartLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f179411m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f179412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f179413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f179414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f179415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f179416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f179417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f179418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f179419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f179420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f179421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f179422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f179423l;

    public CardListCartLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListCartLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.f179420i.getValue();
    }

    private final ImageView getIvWireframe() {
        return (ImageView) this.f179419h.getValue();
    }

    private final View getLoadingLayout() {
        return (View) this.f179418g.getValue();
    }

    private final View getMainLayout() {
        return (View) this.f179414c.getValue();
    }

    public final void U5() {
        ValueAnimator r100 = this.f179422k;
        if (r100 == null) goto L5;
        r100.removeAllUpdateListeners();
        r100.cancel();
        r100.end();
    L5:
        this.f179422k = null;
    }

    public final void Y5() {
        int r100 = com.bytedance.ies.xbridge.base.utils.c.f249457a;
        int r101 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        this.f179415d = getMainLayout().findViewById(R.id.header);
        k r102 = this.f179413b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L6:
        if (r102.f179497d.invoke().booleanValue() == true) goto L15;
        View r103 = this.f179415d;
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
        View r106 = this.f179415d;
        if (r106 == null) goto L23;
        View r107 = r106.findViewById(R.id.iv_back);
        if (r107 == null) goto L23;
        k r108 = this.f179413b;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L22:
        wg.a.h(r107, r108.f179494a.invoke().booleanValue());
        r107.setOnClickListener(new a(this));
    L23:
        this.f179417f = (LinearLayout) getMainLayout().findViewById(R.id.footer);
        this.f179416e = (LinearLayout) getMainLayout().findViewById(R.id.tab);
        k r109 = this.f179413b;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L27:
        if (r109.f179497d.invoke().booleanValue() == false) goto L31;
        LinearLayout r110 = this.f179416e;
        if (r110 == null) goto L46;
        ExtensionsKt.gone(r110);
    L46:
        CartViewExtentionsKt.d(getIvWireframe());
        return;
    L31:
        LinearLayout r111 = this.f179416e;
        if (r111 == null) goto L34;
        ExtensionsKt.visible(r111);
    L34:
        View r112 = V5(64, 26, 14);
        View r113 = V5(64, 26, 14);
        View r114 = V5(96, 26, 14);
        LinearLayout r115 = this.f179416e;
        if (r115 == null) goto L37;
        r115.addView(r112);
    L37:
        LinearLayout r116 = this.f179416e;
        if (r116 == null) goto L40;
        r116.addView(r113);
    L40:
        LinearLayout r117 = this.f179416e;
        if (r117 == null) goto L43;
        r117.addView(r114);
    L43:
        View r118 = V5(112, 44, 44);
        LinearLayout r119 = this.f179417f;
        if (r119 == null) goto L46;
        r119.addView(r118);
        goto L46
    }

    public final void Z5() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r100 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartLoadingView$startLoading$1(this));
    }

    public final void b6() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r100 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartLoadingView$stopLoading$1(this));
    }

    public final k getViewAction() {
        k r100 = this.f179413b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r100;
    }

    public final l getViewState() {
        l r100 = this.f179412a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U5();
        View r100 = this.f179423l;
        if (r100 == null) goto L5;
        r100.setTranslationX(0.0f);
    L5:
        this.f179423l = null;
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(CardListCartLoadingView r100) {
        return r100.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(CardListCartLoadingView r100) {
        return r100.getLoadingLayout();
    }

    public static final /* synthetic */ View T5(CardListCartLoadingView r100) {
        return r100.getMainLayout();
    }

    public final void setNeedHint(boolean r100) {
        this.f179421j.set(r100);
    }

    public final void setViewAction(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179413b = r100;
    }

    public final void setViewState(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179412a = r100;
    }

    public CardListCartLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f179414c = LazyKt.lazy(new CardListCartLoadingView$mainLayout$2(this));
        this.f179418g = LazyKt.lazy(new CardListCartLoadingView$loadingLayout$2(this));
        this.f179419h = LazyKt.lazy(new CardListCartLoadingView$ivWireframe$2(this));
        this.f179420i = LazyKt.lazy(new CardListCartLoadingView$ballAnimationView$2(this));
        this.f179421j = new AtomicBoolean(true);
        LayoutInflater.from(r100).inflate(R.layout.card_list_cart_layout_loading, this, true);
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

    public /* synthetic */ CardListCartLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
