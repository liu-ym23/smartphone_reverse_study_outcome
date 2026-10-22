package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CounterView extends SlcRoundFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f171769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f171770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f171771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f171772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f171773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f171774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f171775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f171776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f171777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f171778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f171779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f171780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f171781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f171782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f171783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImageView f171784r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f171785s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final EditText f171786t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f171787u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Integer> f171788v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<Integer> f171789w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<Integer> f171790x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f171791y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f171792z;

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CounterView f171793a;

        public a(CounterView r100) {
            this.f171793a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            CardListTrackerComponent r102 = CounterView.d(this.f171793a);
            if (r102 == null) goto L6;
            CardListTrackerComponent.h(r102, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "input")), 4);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final s getActions() {
        return (s) this.f171771e.getValue();
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.f171770d.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.f171769c.getValue();
    }

    private final float getShrinkScale() {
        return ((Number) this.f171791y.getValue()).floatValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.f171772f.getValue();
    }

    public final boolean getEnableLargeTextMode() {
        return this.f171792z;
    }

    public final String getMaxLimitToast() {
        return this.f171778l;
    }

    public final int getMaxQuantity() {
        return this.f171776j;
    }

    public final String getMinLimitToast() {
        return this.f171777k;
    }

    public final int getMinQuantity() {
        return this.f171775i;
    }

    public final String getProductId() {
        return this.f171779m;
    }

    public final int getQuantity() {
        return this.f171774h;
    }

    public static final /* synthetic */ CardListObjectContainer b(CounterView r100) {
        return r100.getObjectContainer();
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent c(CounterView r100) {
        return r100.getProvider();
    }

    public static final /* synthetic */ CardListTrackerComponent d(CounterView r100) {
        return r100.getTrackerComponent();
    }

    public final void f(com.bytedance.android.ecom.arch.slice.render.context.b r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        ImageView r101 = this.f171784r;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = SlcDimensExtensionsKt.a(24, r100);
        r102.width = SlcDimensExtensionsKt.a(24, r100);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        ImageView r104 = this.f171785s;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = SlcDimensExtensionsKt.a(24, r100);
        r105.width = SlcDimensExtensionsKt.a(24, r100);
        r104.setLayoutParams(r105);
        EditText r106 = this.f171786t;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = SlcDimensExtensionsKt.a(24, r100);
        r107.width = SlcDimensExtensionsKt.a(40, r100);
        r106.setLayoutParams(r107);
        this.f171786t.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
        TextView r108 = this.f171782p;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.height = SlcDimensExtensionsKt.a(24, r100);
        r108.setLayoutParams(r109);
        this.f171782p.setPadding(SlcDimensExtensionsKt.a(4, r100), 0, SlcDimensExtensionsKt.a(4, r100), 0);
        this.f171782p.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
    }

    public final void g(int r110) {
        if (r110 >= this.f171775i) goto L9;
        CardListTrackerComponent r111 = getTrackerComponent();
        if (r111 == null) goto L7;
        CardListTrackerComponent.h(r111, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f171777k), TuplesKt.to("product_id", this.f171779m)}), 4);
    L7:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f171777k, 0, null, 8, null);
        h(this.f171775i);
        r110 = this.f171775i;
    L15:
        if (r110 != this.f171774h) goto L17;
        return;
    L17:
        Map r112 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r110)));
        BaseSlcViewManager<?> r100 = SlcViewExtensionsKt.g(this);
        if (r100 == null) goto L21;
        r100.f50260a.d(new SlcCommonAction("cartChangeQuantity", r112), this, r100.l(), null, null);
        return;
    L21:
        return;
    L9:
        if (r110 <= this.f171776j) goto L15;
        CardListTrackerComponent r113 = getTrackerComponent();
        if (r113 == null) goto L13;
        CardListTrackerComponent.h(r113, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f171778l), TuplesKt.to("product_id", this.f171779m)}), 4);
    L13:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f171778l, 0, null, 8, null);
        h(this.f171776j);
        r110 = this.f171776j;
        goto L15
    }

    public final void h(int r100) {
        this.f171786t.setText(String.valueOf(r100));
        this.f171786t.setSelection(String.valueOf(r100).length());
        int r101 = com.bytedance.android.shopping.card_list.utils.f.f171917a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171786t, "input", "商品个数," + r100, false);
        this.f171782p.setText("x" + r100);
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171782p, "input", "数量" + r100, false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.f171787u;
        this.f171787u = r101;
        if (r102 > 0) goto L5;
        return;
    L5:
        int r103 = r100.getId();
        if (r103 != R.id.btn_decrease) goto L11;
        this.f171786t.clearFocus();
        CardListExtentionsKt.h(this.f171786t);
        g(this.f171774h - 1);
        CardListTrackerComponent r104 = getTrackerComponent();
        if (r104 == null) goto L32;
        CardListTrackerComponent.h(r104, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "sub")), 4);
        return;
    L32:
        return;
    L11:
        if (r103 != R.id.btn_increase) goto L16;
        this.f171786t.clearFocus();
        CardListExtentionsKt.h(this.f171786t);
        g(this.f171774h + 1);
        CardListTrackerComponent r105 = getTrackerComponent();
        if (r105 == null) goto L34;
        CardListTrackerComponent.h(r105, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "add")), 4);
        return;
    L34:
        return;
    L16:
        if (r103 == R.id.tv_quantity) goto L18;
        return;
    L18:
        if (this.f171780n != 0) goto L37;
        Map r106 = MapsKt.mapOf(TuplesKt.to("counter_active", Boolean.TRUE));
        BaseSlcViewManager<?> r107 = SlcViewExtensionsKt.g(this);
        if (r107 == null) goto L22;
        r107.f50260a.d(new SlcCommonAction("cartCounterActive", r106), this, r107.l(), null, null);
    L22:
        CardListObjectContainer r108 = getObjectContainer();
        if (r108 == null) goto L38;
        CardListContainerConfig r109 = r108.f171546f;
        if (r109 == null) goto L39;
        String r110 = r109.getStandardClickEventName();
        if (r110 == null) goto L40;
        CardListTrackerComponent r111 = getTrackerComponent();
        if (r111 == null) goto L41;
        CardListTrackerComponent.h(r111, r110, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "stepper")), 4);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void setActive(boolean r100) {
        this.f171773g = r100;
    }

    public final void setMaxLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171778l = r100;
    }

    public final void setMaxQuantity(int r100) {
        this.f171776j = r100;
    }

    public final void setMinLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171777k = r100;
    }

    public final void setMinQuantity(int r100) {
        this.f171775i = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171779m = r100;
    }

    public final void setQuantity(int r100) {
        this.f171774h = r100;
    }

    public CounterView(Context r100, final SlcTemplateContext r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 6, 0);
        this.f171792z = r102;
        this.f171769c = LazyKt.lazy(new CounterView$provider$2(r101));
        this.f171770d = LazyKt.lazy(new CounterView$objectContainer$2(this));
        this.f171771e = LazyKt.lazy(new CounterView$actions$2(this));
        this.f171772f = LazyKt.lazy(new CounterView$trackerComponent$2(this));
        this.f171777k = "";
        this.f171778l = "";
        this.f171779m = "";
        this.f171788v = CollectionsKt.listOf(new Integer[]{12, 12, 12, 12});
        this.f171789w = CollectionsKt.listOf(new Integer[]{12, 12, 0, 12});
        this.f171790x = CollectionsKt.listOf(new Integer[]{0, 12, 12, 12});
        this.f171791y = LazyKt.lazy(new CounterView$shrinkScale$2(this));
        LayoutInflater r103 = LayoutInflater.from(r100);
        r103.inflate(R.layout.ec_card_list_layout_counter_expend, this, true);
        this.f171783q = findViewById(R.id.ll_expend);
        ImageView r104 = (ImageView) findViewById(R.id.btn_decrease);
        this.f171784r = r104;
        EditText r105 = (EditText) findViewById(R.id.et_quantity);
        r105.setOnFocusChangeListener(new a(this));
        Unit r106 = Unit.INSTANCE;
        this.f171786t = r105;
        ImageView r107 = (ImageView) findViewById(R.id.btn_increase);
        this.f171785s = r107;
        r103.inflate(R.layout.ec_card_list_layout_counter_normal, this, true);
        View r108 = findViewById(R.id.tv_quantity);
        this.f171781o = r108;
        if (r108 == null) goto L7;
        this.f171782p = (TextView) r108;
        r104.setOnClickListener(this);
        r107.setOnClickListener(this);
        r108.setOnClickListener(this);
        r105.setOnEditorActionListener(new h(this));
        r105.addTextChangedListener(new i(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void e(boolean r100, int r101, int r102, int r103, String r104, String r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r104, "minLimitToast");
        Intrinsics.checkNotNullParameter(r110, "maxLimitToast");
        Intrinsics.checkNotNullParameter(r111, "productId");
        if (this.f171773g == false) goto L10;
        if (r100 == true) goto L10;
        Integer r105 = CardListExtentionsKt.b(this.f171786t.getText().toString());
        if (r105 == null) goto L8;
        int r106 = r105.intValue();
    L9:
        g(r106);
        goto L10
    L8:
        r106 = r102;
    L10:
        this.f171780n = r112;
        boolean r113 = true;
        if (r100 == true) goto L13;
        this.f171783q.setVisibility(8);
        this.f171781o.setVisibility(0);
    L27:
        if (this.f171773g == r100) goto L29;
        requestLayout();
        invalidate();
    L29:
        this.f171773g = r100;
        this.f171774h = r101;
        this.f171775i = r102;
        this.f171776j = r103;
        this.f171777k = r104;
        this.f171778l = r110;
        this.f171779m = r111;
        h(r101);
        if (this.f171775i >= this.f171774h) goto L32;
        boolean r107 = true;
    L34:
        if (r107 == false) goto L36;
        this.f171784r.setImageResource(R.drawable.card_list_counter_minus_enable_optimize);
        int r108 = com.bytedance.android.shopping.card_list.utils.f.f171917a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171784r, "button", "减少商品数量", false);
    L38:
        if (this.f171774h < this.f171776j) goto L41;
        r113 = false;
    L41:
        if (r113 == false) goto L43;
        this.f171785s.setImageResource(R.drawable.card_list_counter_plus_enable_optimize);
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171785s, "button", "增加商品数量", false);
    L44:
        TextView r109 = this.f171782p;
        ViewExtensionsKt.e(r109, r109.getPaint(), 500);
        this.f171782p.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.commerce_color_F5F6F9));
        EditText r114 = this.f171786t;
        ViewExtensionsKt.e(r114, r114.getPaint(), 500);
        return;
    L43:
        this.f171785s.setImageResource(R.drawable.card_list_counter_plus_disable_optimize);
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171785s, "button", this.f171774h + "为最大数量, 不可增加", false);
        goto L44
    L36:
        this.f171784r.setImageResource(R.drawable.card_list_counter_minus_disable_optimize);
        int r115 = com.bytedance.android.shopping.card_list.utils.f.f171917a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.f171784r, "button", this.f171774h + "为最小数量, 不可减少", false);
        goto L38
    L32:
        r107 = false;
        goto L34
    L13:
        if (this.f171783q.getVisibility() == 0) goto L15;
        boolean r116 = true;
    L16:
        this.f171783q.setVisibility(0);
        this.f171781o.setVisibility(8);
        s r117 = getActions();
        if (r117 == null) goto L21;
        Function1<Boolean, Unit> r118 = r117.f171484d;
        if (r118 == null) goto L21;
        Unit r119 = r118.invoke(Boolean.TRUE);
    L21:
        if (r116 == false) goto L27;
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L27;
        post(new g(this));
        goto L27
    L15:
        r116 = false;
        goto L16
    }
}
