package com.bytedance.android.shopping.card_list.widgets.nest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.CardListGULView;
import com.bytedance.android.shopping.card_list.widgets.LoadMoreFooterView;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListLinkedScrollView;", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevNestedScrollView;", "", "enable", "", "setViewAccessibility", "", "height", "setLoadMoreFooterViewHeight", "Landroidx/recyclerview/widget/RecyclerView;", "getYataBody", "Lcom/bytedance/android/shopping/card_list/widgets/CardListGULView;", "getGul", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "objectContainer", "setObjectContainer", "Landroid/view/View;", "view", "setTopView", "value", "p", "I", "setOuterHeight", "(I)V", "outerHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListLinkedScrollView extends CardListTwoRevNestedScrollView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f171964q = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RecyclerView f171965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CardListGULView f171966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LoadMoreFooterView f171967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f171968p;

    public CardListLinkedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListLinkedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
    }

    public final void j() {
        d r100 = this.f171979a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        Function1<Integer, Boolean> r101 = new CardListTwoRevNestedScrollView$initView$1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f172015f = r101;
        d r102 = this.f171979a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L8:
        Function0<Boolean> r103 = new CardListTwoRevNestedScrollView$initView$2(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        CardListGULView r104 = this.f171966n;
        r104.setViewState(getViewState().f172012c);
        com.bytedance.android.shopping.card_list.widgets.a r105 = getViewAction().f172004f;
        CardListLinkedScrollView$initView$1$1$1 r106 = new CardListLinkedScrollView$initView$1$1$1(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f171943a = r106;
        Unit r107 = Unit.INSTANCE;
        r104.setViewAction(r105);
        this.f171966n.f();
        d r108 = getViewState();
        Function0<Boolean> r109 = new CardListLinkedScrollView$initView$2(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f172020k = r109;
        getViewState().b(getViewState().f172013d, new CardListLinkedScrollView$initObserver$1(this), true);
        getViewState().b(getViewState().f172014e, new CardListLinkedScrollView$initObserver$2(this), false);
        getViewState().b(getViewState().f172016g, new CardListLinkedScrollView$initObserver$3(this), true);
        getViewState().b(getViewState().f172017h, new CardListLinkedScrollView$initObserver$4(this), true);
        getViewState().b(getViewState().f172018i, new CardListLinkedScrollView$initObserver$5(this), true);
        getViewState().b(getViewState().f172019j, new CardListLinkedScrollView$initObserver$6(this), true);
        getViewState().b(getViewState().f172021l, new CardListLinkedScrollView$initObserver$7(this), true);
        getViewState().b(getViewState().f172022m, new CardListLinkedScrollView$initObserver$8(this), true);
    }

    public final CardListGULView getGul() {
        return this.f171966n;
    }

    public final RecyclerView getYataBody() {
        return this.f171965m;
    }

    private final void setLoadMoreFooterViewHeight(int r100) {
        LoadMoreFooterView r101 = this.f171967o;
        Intrinsics.checkNotNullParameter(r101, "$this$setHeight");
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L5;
        r102.height = r100;
    L5:
        r101.setLayoutParams(r102);
    }

    private final void setOuterHeight(int r100) {
        if (this.f171968p == r100) goto L13;
        RecyclerView r101 = this.f171965m;
        if ((r101 instanceof MaxHeightRecyclerView) == true) goto L7;
        r101 = null;
    L7:
        MaxHeightRecyclerView r102 = (MaxHeightRecyclerView) r101;
        if (r102 == null) goto L10;
        r102.setMaxHeight(r100);
    L10:
        this.f171966n.setOuterHeight(r100);
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L13;
        r103.height = r100;
    L13:
        this.f171968p = r100;
    }

    private final void setViewAccessibility(boolean r100) {
        com.bytedance.android.ec.core.utils.a.a(this, r100);
    }

    public final void setObjectContainer(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f171966n.setObjectContainer(r100);
    }

    public final void setTopView(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup r101 = getInnerLayout();
        if (r101 == null) goto L7;
        r101.removeView(this.f171965m);
    L7:
        ViewGroup r102 = getInnerLayout();
        if (r102 == null) goto L11;
        r102.addView(r100, 0);
        return;
    }

    public static final /* synthetic */ void g(CardListLinkedScrollView r100, int r101) {
        r100.setLoadMoreFooterViewHeight(r101);
    }

    public static final /* synthetic */ void h(CardListLinkedScrollView r100, int r101) {
        r100.setOuterHeight(r101);
    }

    public static final /* synthetic */ void i(CardListLinkedScrollView r100, boolean r101) {
        r100.setViewAccessibility(r101);
    }

    public CardListLinkedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.card_list_nested_container, this, true);
        setInnerLayout((ViewGroup) findViewById(R.id.container));
        RecyclerView r103 = (RecyclerView) findViewById(R.id.card_list_rev);
        r103.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        f(BitableResourceData.KEY_REV_1, r103);
        Unit r104 = Unit.INSTANCE;
        this.f171965m = r103;
        CardListGULView r105 = (CardListGULView) findViewById(R.id.nested_gul);
        r105.setSetUpCallBack(new CardListLinkedScrollView$$special$$inlined$apply$lambda$1(this));
        this.f171966n = r105;
        this.f171967o = (LoadMoreFooterView) findViewById(R.id.load_more_footer_view);
    }

    public /* synthetic */ CardListLinkedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
