package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.q;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CounterView extends SlcRoundFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f179214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f179215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f179216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f179217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f179218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f179219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f179220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f179221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f179222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f179223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f179224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f179225n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f179226o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f179227p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f179228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final EditText f179229r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f179230s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f179231t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f179232u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f179233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f179234w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f179235x;

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CounterView f179236a;

        public a(CounterView r100) {
            this.f179236a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            CartViewModel r102 = this.f179236a.getCartVM();
            if (r102 == null) goto L6;
            CartViewModel.doEventAction$default(r102, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "input")), null, 4, null);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final List<Integer> getBtnDecreaseHitSlop() {
        return (List) this.f179232u.getValue();
    }

    private final List<Integer> getBtnIncreaseHitSlop() {
        return (List) this.f179233v.getValue();
    }

    private final List<Integer> getNormalHitSlop() {
        return (List) this.f179231t.getValue();
    }

    private final float getShrinkScale() {
        return ((Number) this.f179234w.getValue()).floatValue();
    }

    public final CartViewModel getCartVM() {
        return (CartViewModel) this.f179214c.getValue();
    }

    public final b0 getActions() {
        return this.f179235x;
    }

    public final String getMaxLimitToast() {
        return this.f179221j;
    }

    public final int getMaxQuantity() {
        return this.f179219h;
    }

    public final String getMinLimitToast() {
        return this.f179220i;
    }

    public final int getMinQuantity() {
        return this.f179218g;
    }

    public final String getProductId() {
        return this.f179222k;
    }

    public final int getQuantity() {
        return this.f179217f;
    }

    public final void b(q r110) {
        Intrinsics.checkNotNullParameter(r110, "viewManager");
        View r100 = this.f179224m;
        List<Integer> r101 = getNormalHitSlop();
        Object r102 = 12;
        if (CollectionsKt.getLastIndex(r101) < 0) goto L5;
        Object r103 = ListProtector.get(r101, 0);
    L6:
        int r104 = SlcDimensExtensionsKt.a((Number) r103, r110.f50260a.m());
        List<Integer> r105 = getNormalHitSlop();
        if (1 > CollectionsKt.getLastIndex(r105)) goto L9;
        Object r106 = ListProtector.get(r105, 1);
    L10:
        int r107 = SlcDimensExtensionsKt.a((Number) r106, r110.f50260a.m());
        List<Integer> r108 = getNormalHitSlop();
        if (2 > CollectionsKt.getLastIndex(r108)) goto L13;
        Object r109 = ListProtector.get(r108, 2);
    L14:
        int r111 = SlcDimensExtensionsKt.a((Number) r109, r110.f50260a.m());
        List<Integer> r112 = getNormalHitSlop();
        if (3 > CollectionsKt.getLastIndex(r112)) goto L17;
        Object r113 = ListProtector.get(r112, 3);
    L18:
        r110.c1(r100, r104, r107, r111, SlcDimensExtensionsKt.a((Number) r113, r110.f50260a.m()));
        ImageView r114 = this.f179227p;
        List<Integer> r115 = getBtnDecreaseHitSlop();
        if (CollectionsKt.getLastIndex(r115) < 0) goto L21;
        Object r116 = ListProtector.get(r115, 0);
    L22:
        int r117 = SlcDimensExtensionsKt.a((Number) r116, r110.f50260a.m());
        List<Integer> r118 = getBtnDecreaseHitSlop();
        if (1 > CollectionsKt.getLastIndex(r118)) goto L25;
        Object r119 = ListProtector.get(r118, 1);
    L26:
        int r120 = SlcDimensExtensionsKt.a((Number) r119, r110.f50260a.m());
        List<Integer> r121 = getBtnDecreaseHitSlop();
        if (3 > CollectionsKt.getLastIndex(r121)) goto L29;
        Object r122 = ListProtector.get(r121, 3);
    L30:
        r110.c1(r114, r117, r120, 0, SlcDimensExtensionsKt.a((Number) r122, r110.f50260a.m()));
        ImageView r123 = this.f179228q;
        List<Integer> r124 = getBtnIncreaseHitSlop();
        if (1 > CollectionsKt.getLastIndex(r124)) goto L33;
        Object r125 = ListProtector.get(r124, 1);
    L34:
        int r126 = SlcDimensExtensionsKt.a((Number) r125, r110.f50260a.m());
        List<Integer> r127 = getBtnIncreaseHitSlop();
        if (2 > CollectionsKt.getLastIndex(r127)) goto L37;
        Object r128 = ListProtector.get(r127, 2);
    L38:
        int r129 = SlcDimensExtensionsKt.a((Number) r128, r110.f50260a.m());
        List<Integer> r130 = getBtnIncreaseHitSlop();
        if (3 > CollectionsKt.getLastIndex(r130)) goto L41;
        r102 = ListProtector.get(r130, 3);
    L41:
        r110.c1(r123, 0, r126, r129, SlcDimensExtensionsKt.a((Number) r102, r110.f50260a.m()));
        return;
    L37:
        r128 = r102;
        goto L38
    L33:
        r125 = r102;
        goto L34
    L29:
        r122 = r102;
        goto L30
    L25:
        r119 = r102;
        goto L26
    L21:
        r116 = r102;
        goto L22
    L17:
        r113 = r102;
        goto L18
    L13:
        r109 = r102;
        goto L14
    L9:
        r106 = r102;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }

    public final void c(com.bytedance.android.ecom.arch.slice.render.context.b r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        ImageView r101 = this.f179227p;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = SlcDimensExtensionsKt.a(24, r100);
        r102.width = SlcDimensExtensionsKt.a(24, r100);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        ImageView r104 = this.f179228q;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = SlcDimensExtensionsKt.a(24, r100);
        r105.width = SlcDimensExtensionsKt.a(24, r100);
        r104.setLayoutParams(r105);
        EditText r106 = this.f179229r;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = SlcDimensExtensionsKt.a(24, r100);
        r107.width = SlcDimensExtensionsKt.a(40, r100);
        r106.setLayoutParams(r107);
        this.f179229r.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
        TextView r108 = this.f179225n;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.height = SlcDimensExtensionsKt.a(24, r100);
        r108.setLayoutParams(r109);
        this.f179225n.setMinWidth(SlcDimensExtensionsKt.a(26, r100));
        this.f179225n.setPadding(SlcDimensExtensionsKt.a(6, r100), 0, SlcDimensExtensionsKt.a(6, r100), 0);
        this.f179225n.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
    }

    public final void d(int r210) {
        int r100 = r210;
        if (r100 >= this.f179218g) goto L9;
        CartViewModel r101 = getCartVM();
        if (r101 == null) goto L7;
        CartViewModel.doEventAction$default(r101, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f179220i), TuplesKt.to("product_id", this.f179222k)}), null, 4, null);
    L7:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f179220i, 0, null, 8, null);
        e(this.f179218g);
        r100 = this.f179218g;
    L15:
        if (r100 != this.f179217f) goto L17;
        return;
    L17:
        Map r102 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r100)));
        BaseSlcViewManager<?> r103 = SlcViewExtensionsKt.g(this);
        if (r103 == null) goto L21;
        r103.getTemplateContext().d(new SlcCommonAction("cartChangeQuantity", r102), this, r103.l(), null, null);
        return;
    L21:
        return;
    L9:
        if (r100 <= this.f179219h) goto L15;
        CartViewModel r104 = getCartVM();
        if (r104 == null) goto L13;
        CartViewModel.doEventAction$default(r104, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f179221j), TuplesKt.to("product_id", this.f179222k)}), null, 4, null);
    L13:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f179221j, 0, null, 8, null);
        e(this.f179219h);
        r100 = this.f179219h;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public final void e(int r110) {
        this.f179229r.setText(String.valueOf(r110));
        this.f179229r.setSelection(String.valueOf(r110).length());
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.h(this.f179229r, "input", "商品个数," + r110, false);
        this.f179225n.setText(String.valueOf(r110));
        com.bytedance.android.shopping.new_cart.utils.a.h(this.f179225n, "input", "数量" + r110, false);
        int r111 = g1.f45599a;
        Drawable r101 = g1.a.b(getContext(), R.drawable.ic_cart_card_num_prefix);
        if (r101 == null) goto L6;
        float r112 = getShrinkScale();
        int r102 = s.f179022a;
        int r113 = (int) (8 * (r112 * s.a(Boolean.valueOf(((Boolean) this.f179215d.getValue()).booleanValue())).f50239a));
        int r103 = com.bytedance.android.shopping.extensions.b.a(1);
        InsetDrawable r104 = new InsetDrawable(r101, 0, r103, 0, 0);
        r104.setBounds(0, 0, r113, r103 + r113);
        this.f179225n.setCompoundDrawablesRelative(r104, null, null, null);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f179230s;
        this.f179230s = r100;
        if (r101 > 0) goto L5;
        return;
    L5:
        int r111 = r110.getId();
        if (r111 != R.id.btn_decrease) goto L11;
        this.f179229r.clearFocus();
        CartViewExtentionsKt.c(this.f179229r);
        d(this.f179217f - 1);
        CartViewModel r102 = getCartVM();
        if (r102 == null) goto L26;
        CartViewModel.doEventAction$default(r102, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "sub")), null, 4, null);
        return;
    L26:
        return;
    L11:
        if (r111 != R.id.btn_increase) goto L16;
        this.f179229r.clearFocus();
        CartViewExtentionsKt.c(this.f179229r);
        d(this.f179217f + 1);
        CartViewModel r103 = getCartVM();
        if (r103 == null) goto L28;
        CartViewModel.doEventAction$default(r103, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "add")), null, 4, null);
        return;
    L28:
        return;
    L16:
        if (r111 == R.id.tv_quantity) goto L18;
        return;
    L18:
        if (this.f179223l != 0) goto L31;
        Map r112 = MapsKt.mapOf(TuplesKt.to("counter_active", Boolean.TRUE));
        BaseSlcViewManager<?> r104 = SlcViewExtensionsKt.g(this);
        if (r104 == null) goto L22;
        r104.getTemplateContext().d(new SlcCommonAction("cartCounterActive", r112), this, r104.l(), null, null);
    L22:
        CartViewModel r105 = getCartVM();
        if (r105 == null) goto L32;
        CartViewModel.doEventAction$default(r105, "cart_list_tab_click", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "stepper")), null, 4, null);
        return;
    L32:
        return;
    }

    public final void setActive(boolean r100) {
        this.f179216e = r100;
    }

    public final void setMaxLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179221j = r100;
    }

    public final void setMaxQuantity(int r100) {
        this.f179219h = r100;
    }

    public final void setMinLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179220i = r100;
    }

    public final void setMinQuantity(int r100) {
        this.f179218g = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179222k = r100;
    }

    public final void setQuantity(int r100) {
        this.f179217f = r100;
    }

    public CounterView(Context r100, b0 r101, final CartObjectContainer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f179235x = r101;
        this.f179214c = LazyKt.lazy(new CounterView$cartVM$2(r102));
        this.f179215d = LazyKt.lazy(new CounterView$isSplitMode$2(r102));
        this.f179220i = "";
        this.f179221j = "";
        this.f179222k = "";
        this.f179231t = LazyKt.lazy(CounterView$normalHitSlop$2.INSTANCE);
        this.f179232u = LazyKt.lazy(CounterView$btnDecreaseHitSlop$2.INSTANCE);
        this.f179233v = LazyKt.lazy(CounterView$btnIncreaseHitSlop$2.INSTANCE);
        this.f179234w = LazyKt.lazy(CounterView$shrinkScale$2.INSTANCE);
        LayoutInflater r103 = LayoutInflater.from(r100);
        r103.inflate(R.layout.ec_cart_layout_counter_expend, this, true);
        this.f179226o = findViewById(R.id.ll_expend);
        ImageView r104 = (ImageView) findViewById(R.id.btn_decrease);
        this.f179227p = r104;
        EditText r105 = (EditText) findViewById(R.id.et_quantity);
        r105.setOnFocusChangeListener(new a(this));
        Unit r106 = Unit.INSTANCE;
        this.f179229r = r105;
        ImageView r107 = (ImageView) findViewById(R.id.btn_increase);
        this.f179228q = r107;
        r103.inflate(R.layout.ec_cart_layout_counter_normal, this, true);
        View r108 = findViewById(R.id.tv_quantity);
        this.f179224m = r108;
        if (r108 == null) goto L7;
        this.f179225n = (TextView) r108;
        r104.setOnClickListener(this);
        r107.setOnClickListener(this);
        r108.setOnClickListener(this);
        r105.setOnEditorActionListener(new g(this));
        r105.addTextChangedListener(new h(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
