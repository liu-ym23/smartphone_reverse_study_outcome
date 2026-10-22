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
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.r;
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
public final class CounterViewV2 extends SlcRoundFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f179237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f179238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f179239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f179240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f179241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f179242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f179243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f179244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f179245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f179246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f179247m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f179248n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f179249o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f179250p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f179251q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final EditText f179252r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f179253s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f179254t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f179255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f179256v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f179257w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f179258x;

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CounterViewV2 f179259a;

        public a(CounterViewV2 r100) {
            this.f179259a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            CartViewModel r102 = this.f179259a.getCartVM();
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
        return (List) this.f179255u.getValue();
    }

    private final List<Integer> getBtnIncreaseHitSlop() {
        return (List) this.f179256v.getValue();
    }

    private final List<Integer> getNormalHitSlop() {
        return (List) this.f179254t.getValue();
    }

    private final float getShrinkScale() {
        return ((Number) this.f179257w.getValue()).floatValue();
    }

    public final CartViewModel getCartVM() {
        return (CartViewModel) this.f179237c.getValue();
    }

    public final b0 getActions() {
        return this.f179258x;
    }

    public final String getMaxLimitToast() {
        return this.f179244j;
    }

    public final int getMaxQuantity() {
        return this.f179242h;
    }

    public final String getMinLimitToast() {
        return this.f179243i;
    }

    public final int getMinQuantity() {
        return this.f179241g;
    }

    public final String getProductId() {
        return this.f179245k;
    }

    public final int getQuantity() {
        return this.f179240f;
    }

    public final void b(r r110) {
        Intrinsics.checkNotNullParameter(r110, "viewManager");
        View r100 = this.f179247m;
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
        ImageView r114 = this.f179250p;
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
        ImageView r123 = this.f179251q;
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
        ImageView r101 = this.f179250p;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = SlcDimensExtensionsKt.a(24, r100);
        r102.width = SlcDimensExtensionsKt.a(24, r100);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        ImageView r104 = this.f179251q;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = SlcDimensExtensionsKt.a(24, r100);
        r105.width = SlcDimensExtensionsKt.a(24, r100);
        r104.setLayoutParams(r105);
        EditText r106 = this.f179252r;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = SlcDimensExtensionsKt.a(24, r100);
        r107.width = SlcDimensExtensionsKt.a(40, r100);
        r106.setLayoutParams(r107);
        this.f179252r.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
        TextView r108 = this.f179248n;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.height = SlcDimensExtensionsKt.a(24, r100);
        r108.setLayoutParams(r109);
        this.f179248n.setMinWidth(SlcDimensExtensionsKt.a(26, r100));
        this.f179248n.setPadding(SlcDimensExtensionsKt.a(6, r100), 0, SlcDimensExtensionsKt.a(6, r100), 0);
        this.f179248n.setTextSize(0, SlcDimensExtensionsKt.e(14, r100) * getShrinkScale());
    }

    public final void d(int r210) {
        int r100 = r210;
        if (r100 >= this.f179241g) goto L9;
        CartViewModel r101 = getCartVM();
        if (r101 == null) goto L7;
        CartViewModel.doEventAction$default(r101, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f179243i), TuplesKt.to("product_id", this.f179245k)}), null, 4, null);
    L7:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f179243i, 0, null, 8, null);
        e(this.f179241g);
        r100 = this.f179241g;
    L15:
        if (r100 != this.f179240f) goto L17;
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
        if (r100 <= this.f179242h) goto L15;
        CartViewModel r104 = getCartVM();
        if (r104 == null) goto L13;
        CartViewModel.doEventAction$default(r104, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f179244j), TuplesKt.to("product_id", this.f179245k)}), null, 4, null);
    L13:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f179244j, 0, null, 8, null);
        e(this.f179242h);
        r100 = this.f179242h;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public final void e(int r110) {
        this.f179252r.setText(String.valueOf(r110));
        this.f179252r.setSelection(String.valueOf(r110).length());
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.h(this.f179252r, "input", "商品个数," + r110, false);
        this.f179248n.setText(String.valueOf(r110));
        com.bytedance.android.shopping.new_cart.utils.a.h(this.f179248n, "input", "数量" + r110, false);
        int r111 = g1.f45599a;
        Drawable r101 = g1.a.b(getContext(), R.drawable.ic_cart_card_num_prefix);
        if (r101 == null) goto L6;
        float r112 = getShrinkScale();
        int r102 = s.f179022a;
        int r113 = (int) (8 * (r112 * s.a(Boolean.valueOf(((Boolean) this.f179238d.getValue()).booleanValue())).f50239a));
        int r103 = com.bytedance.android.shopping.extensions.b.a(1);
        InsetDrawable r104 = new InsetDrawable(r101, 0, r103, 0, 0);
        r104.setBounds(0, 0, r113, r103 + r113);
        this.f179248n.setCompoundDrawablesRelative(r104, null, null, null);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f179253s;
        this.f179253s = r100;
        if (r101 > 0) goto L5;
        return;
    L5:
        int r111 = r110.getId();
        if (r111 != R.id.btn_decrease) goto L11;
        this.f179252r.clearFocus();
        CartViewExtentionsKt.c(this.f179252r);
        d(this.f179240f - 1);
        CartViewModel r102 = getCartVM();
        if (r102 == null) goto L26;
        CartViewModel.doEventAction$default(r102, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "sub")), null, 4, null);
        return;
    L26:
        return;
    L11:
        if (r111 != R.id.btn_increase) goto L16;
        this.f179252r.clearFocus();
        CartViewExtentionsKt.c(this.f179252r);
        d(this.f179240f + 1);
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
        if (this.f179246l != 0) goto L31;
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
        this.f179239e = r100;
    }

    public final void setMaxLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179244j = r100;
    }

    public final void setMaxQuantity(int r100) {
        this.f179242h = r100;
    }

    public final void setMinLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179243i = r100;
    }

    public final void setMinQuantity(int r100) {
        this.f179241g = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f179245k = r100;
    }

    public final void setQuantity(int r100) {
        this.f179240f = r100;
    }

    public CounterViewV2(Context r100, b0 r101, final CartObjectContainer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f179258x = r101;
        this.f179237c = LazyKt.lazy(new CounterViewV2$cartVM$2(r102));
        this.f179238d = LazyKt.lazy(new CounterViewV2$isSplitMode$2(r102));
        this.f179243i = "";
        this.f179244j = "";
        this.f179245k = "";
        this.f179254t = LazyKt.lazy(CounterViewV2$normalHitSlop$2.INSTANCE);
        this.f179255u = LazyKt.lazy(CounterViewV2$btnDecreaseHitSlop$2.INSTANCE);
        this.f179256v = LazyKt.lazy(CounterViewV2$btnIncreaseHitSlop$2.INSTANCE);
        this.f179257w = LazyKt.lazy(CounterViewV2$shrinkScale$2.INSTANCE);
        LayoutInflater r103 = LayoutInflater.from(r100);
        r103.inflate(R.layout.ec_cart_layout_counter_expend, this, true);
        this.f179249o = findViewById(R.id.ll_expend);
        ImageView r104 = (ImageView) findViewById(R.id.btn_decrease);
        this.f179250p = r104;
        EditText r105 = (EditText) findViewById(R.id.et_quantity);
        r105.setOnFocusChangeListener(new a(this));
        Unit r106 = Unit.INSTANCE;
        this.f179252r = r105;
        ImageView r107 = (ImageView) findViewById(R.id.btn_increase);
        this.f179251q = r107;
        r103.inflate(R.layout.ec_cart_layout_counter_normal, this, true);
        View r108 = findViewById(R.id.tv_quantity);
        this.f179247m = r108;
        if (r108 == null) goto L7;
        this.f179248n = (TextView) r108;
        r104.setOnClickListener(this);
        r107.setOnClickListener(this);
        r108.setOnClickListener(this);
        r105.setOnEditorActionListener(new j(this));
        r105.addTextChangedListener(new k(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
