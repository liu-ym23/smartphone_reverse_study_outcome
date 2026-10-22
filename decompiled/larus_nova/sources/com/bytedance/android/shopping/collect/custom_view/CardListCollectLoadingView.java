package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.new_cart.widgets.k;
import com.bytedance.android.shopping.new_cart.widgets.l;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CardListCollectLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/l;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/l;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/k;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/k;)V", "viewAction", "Landroid/view/View;", "c", "Lkotlin/Lazy;", "getSkeletonContainer", "()Landroid/view/View;", "skeletonContainer", "d", "getTitle", "title", "e", "getSkeletonView", "skeletonView", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "f", "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCollectLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f172166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f172167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f172168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f172169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f172170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f172171f;

    public CardListCollectLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListCollectLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.f172171f.getValue();
    }

    private final View getSkeletonContainer() {
        return (View) this.f172168c.getValue();
    }

    private final View getSkeletonView() {
        return (View) this.f172170e.getValue();
    }

    private final View getTitle() {
        return (View) this.f172169d.getValue();
    }

    public final void V5() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r100 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCollectLoadingView$stopLoading$1(this));
    }

    public final k getViewAction() {
        k r100 = this.f172167b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r100;
    }

    public final l getViewState() {
        l r100 = this.f172166a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r100;
    }

    public final void T5() {
        View r100 = getTitle();
        if (r100 == null) goto L8;
        k r101 = this.f172167b;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L7:
        wg.a.h(r100, r101.f179494a.invoke().booleanValue());
    L8:
        View r102 = getSkeletonView();
        if (r102 == null) goto L17;
        k r103 = this.f172167b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L14:
        if (r103.f179496c.invoke().booleanValue() == false) goto L16;
        r102.setBackgroundResource(R.drawable.ec_collect_default_loading_without_header_dark);
        goto L17
    L16:
        r102.setBackgroundResource(R.drawable.ec_collect_default_loading_without_header_light);
    L17:
        requestLayout();
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(CardListCollectLoadingView r100) {
        return r100.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(CardListCollectLoadingView r100) {
        return r100.getSkeletonContainer();
    }

    public final void U5(final boolean r100) {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r101 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCollectLoadingView$startLoading$1(this, r100));
    }

    public final void setViewAction(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f172167b = r100;
    }

    public final void setViewState(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f172166a = r100;
    }

    public CardListCollectLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172168c = LazyKt.lazy(new CardListCollectLoadingView$skeletonContainer$2(this));
        this.f172169d = LazyKt.lazy(new CardListCollectLoadingView$title$2(this));
        this.f172170e = LazyKt.lazy(new CardListCollectLoadingView$skeletonView$2(this));
        this.f172171f = LazyKt.lazy(new CardListCollectLoadingView$ballAnimationView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.card_list_collect_loading_layout, this, true);
    }

    public /* synthetic */ CardListCollectLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
