package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "objectContainer", "", "setObjectContainer", "Lcom/bytedance/android/shopping/new_cart/widgets/i;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/new_cart/widgets/i;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/i;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/i;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;)V", "viewAction", "", ce.f26391f, "Lkotlin/Lazy;", "getRlBarHeight", "()I", "rlBarHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCartErrorView extends ConstraintLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f179403h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f179404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ErrorViewAction f179405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f179406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f179407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f179408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CardListLinkedScrollView f179409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f179410g;

    public CardListCartErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListCartErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getRlBarHeight() {
        return ((Number) this.f179410g.getValue()).intValue();
    }

    public final ErrorViewAction getViewAction() {
        ErrorViewAction r100 = this.f179405b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r100;
    }

    public final i getViewState() {
        i r100 = this.f179404a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r100;
    }

    public final void initView() {
        View r100 = this.f179408e;
        ImageView r101 = null;
        if (r100 == null) goto L5;
        CardListLinkedScrollView r102 = (CardListLinkedScrollView) r100.findViewById(R.id.linked_scroll_view);
    L6:
        this.f179409f = r102;
        if (r102 == null) goto L9;
        r102.setTopView(this.f179407d);
    L9:
        CardListLinkedScrollView r103 = this.f179409f;
        if (r103 == null) goto L18;
        i r104 = this.f179404a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L14:
        r103.setViewState(r104.f179493e);
        ErrorViewAction r105 = this.f179405b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L17:
        r103.setViewAction(r105.f179465d);
        r103.j();
    L18:
        int r106 = com.bytedance.ies.xbridge.base.utils.c.f249457a;
        int r107 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        View r108 = this.f179408e;
        if (r108 == null) goto L21;
        View r109 = r108.findViewById(R.id.rl_bar);
    L22:
        this.f179406c = r109;
        if (r109 == null) goto L25;
        r109.setPadding(0, r107, 0, 0);
    L25:
        View r110 = this.f179406c;
        if (r110 == null) goto L31;
        int r111 = getRlBarHeight();
        Intrinsics.checkNotNullParameter(r110, "$this$setHeight");
        ViewGroup.LayoutParams r112 = r110.getLayoutParams();
        if (r112 == null) goto L30;
        r112.height = r111;
    L30:
        r110.setLayoutParams(r112);
    L31:
        requestLayout();
        View r113 = this.f179407d;
        if (r113 == null) goto L36;
        TextView r114 = (TextView) r113.findViewById(R.id.tv_retry);
        if (r114 == null) goto L36;
        int r115 = com.bytedance.android.shopping.card_list.utils.f.f171917a;
        com.bytedance.android.shopping.card_list.utils.f.b(r114, "button", r114.getText().toString(), false);
        Unit r116 = Unit.INSTANCE;
    L37:
        if (r114 == null) goto L39;
        r114.setOnClickListener(this);
    L39:
        View r117 = this.f179408e;
        if (r117 == null) goto L42;
        r101 = (ImageView) r117.findViewById(R.id.iv_back);
    L42:
        if (r101 == null) goto L44;
        com.bytedance.android.shopping.card_list.utils.f.b(r101, "button", "返回", false);
    L44:
        Unit r118 = Unit.INSTANCE;
        if (r101 == null) goto L47;
        r101.setOnClickListener(this);
    L47:
        View r119 = this.f179408e;
        if (r119 == null) goto L52;
        TextView r120 = (TextView) r119.findViewById(R.id.err_title);
        if (r120 == null) goto L52;
        int r121 = com.bytedance.android.shopping.card_list.utils.f.f171917a;
        com.bytedance.android.shopping.card_list.utils.f.b(r120, "text", r120.getText().toString(), true);
    L52:
        setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r122 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartErrorView$hide$1(this));
        i r123 = this.f179404a;
        if (r123 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L55:
        i r124 = this.f179404a;
        if (r124 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L58:
        r123.b(r124.f179491c, new CardListCartErrorView$initObserver$1(this), true);
        i r125 = this.f179404a;
        if (r125 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L61:
        i r126 = this.f179404a;
        if (r126 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L64:
        r125.b(r126.f179492d, new CardListCartErrorView$initObserver$2(this), true);
        return;
    L36:
        r114 = null;
        goto L37
    L21:
        r109 = null;
        goto L22
    L5:
        r102 = null;
        goto L6
    }

    public static final /* synthetic */ int R5(CardListCartErrorView r100) {
        return r100.getRlBarHeight();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = r100.getId();
        if (r101 != R.id.iv_back) goto L9;
        ErrorViewAction r102 = this.f179405b;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L7:
        r102.f179463b.invoke();
        return;
    L9:
        if (r101 != R.id.tv_retry) goto L15;
        ErrorViewAction r103 = this.f179405b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L13:
        r103.f179462a.invoke();
        return;
    L15:
        if (r101 != R.id.tv_advice) goto L23;
        ErrorViewAction r104 = this.f179405b;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L19:
        r104.f179464c.invoke();
        return;
    }

    public final void setObjectContainer(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        CardListLinkedScrollView r101 = this.f179409f;
        if (r101 == null) goto L6;
        r101.setObjectContainer(r100);
        return;
    }

    public final void setViewAction(ErrorViewAction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179405b = r100;
    }

    public final void setViewState(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179404a = r100;
    }

    public CardListCartErrorView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f179410g = LazyKt.lazy(new CardListCartErrorView$rlBarHeight$2(r100));
        this.f179408e = LayoutInflater.from(r100).inflate(R.layout.card_list_cart_layout_error, this, true);
        this.f179407d = LayoutInflater.from(r100).inflate(R.layout.card_list_cart_error_view, this, false);
    }

    public /* synthetic */ CardListCartErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
