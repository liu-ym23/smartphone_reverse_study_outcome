package com.bytedance.android.shopping.buynow.slice.counter;

import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.buynow.utils.ViewUtilsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00015B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\n¢\u0006\u0004\b3\u00104R\"\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010-\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/buynow/slice/counter/BuyNowCounterView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroid/view/View$OnClickListener;", "", "c", "Z", "isActive", "()Z", "setActive", "(Z)V", "", "d", "I", "getQuantity", "()I", "setQuantity", "(I)V", "quantity", "e", "getMinQuantity", "setMinQuantity", "minQuantity", "f", "getMaxQuantity", "setMaxQuantity", "maxQuantity", "", ce.f26391f, "Ljava/lang/String;", "getMinLimitToast", "()Ljava/lang/String;", "setMinLimitToast", "(Ljava/lang/String;)V", "minLimitToast", "h", "getMaxLimitToast", "setMaxLimitToast", "maxLimitToast", RXScreenCaptureService.KEY_INDEX, "getProductId", "setProductId", "productId", ce.f26395j, "getChangeQuantityEvent", "setChangeQuantityEvent", "changeQuantityEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowCounterView extends SlcRoundFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f171057u = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f171058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f171059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f171060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f171061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f171062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f171063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f171064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f171065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f171066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f171067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f171068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EditText f171069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f171070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f171071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f171072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f171073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f171074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f171075t;

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f171076a;

        public a(EditText r100) {
            this.f171076a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L9;
            WeakReference<EditText> r102 = d.f171078a;
            EditText r103 = this.f171076a;
            if (r103 != null) goto L6;
            d.f171078a = null;
        L7:
            d.f171079b = true;
            return;
        L6:
            d.f171078a = new WeakReference(r103);
            goto L7
        }
    }

    public static final class b {
    }

    static {
    }

    public BuyNowCounterView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BuyNowCounterView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final String getChangeQuantityEvent() {
        return this.f171065j;
    }

    public final String getMaxLimitToast() {
        return this.f171063h;
    }

    public final int getMaxQuantity() {
        return this.f171061f;
    }

    public final String getMinLimitToast() {
        return this.f171062g;
    }

    public final int getMinQuantity() {
        return this.f171060e;
    }

    public final String getProductId() {
        return this.f171064i;
    }

    public final int getQuantity() {
        return this.f171059d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void c(com.bytedance.android.ecom.arch.slice.render.context.b r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        if (this.f171073r == false) goto L29;
        LinearLayout r101 = this.f171066k;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = SlcDimensExtensionsKt.a(24, r100);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        ImageView r104 = this.f171067l;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = SlcDimensExtensionsKt.a(24, r100);
        r105.width = SlcDimensExtensionsKt.a(24, r100);
        r104.setLayoutParams(r105);
        ImageView r106 = this.f171068m;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = SlcDimensExtensionsKt.a(24, r100);
        r107.width = SlcDimensExtensionsKt.a(24, r100);
        r106.setLayoutParams(r107);
        EditText r108 = this.f171069n;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.height = SlcDimensExtensionsKt.a(24, r100);
        r109.width = SlcDimensExtensionsKt.a(34, r100);
        r108.setLayoutParams(r109);
        int r110 = SlcDimensExtensionsKt.a(4, r100);
        int r111 = SlcDimensExtensionsKt.a(1, r100);
        View r112 = this.f171074s;
        LinearLayout.LayoutParams r113 = null;
        if (r112 == null) goto L17;
        if (r112 == null) goto L8;
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
    L10:
        if ((r114 instanceof LinearLayout.LayoutParams) == true) goto L12;
        r114 = null;
    L12:
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        if (r115 == null) goto L15;
        r115.width = r111;
        r115.height = SlcDimensExtensionsKt.a(16, r100);
        r115.topMargin = r110;
        r115.bottomMargin = r110;
    L16:
        r112.setLayoutParams(r115);
        goto L17
    L15:
        r115 = null;
        goto L16
    L8:
        r114 = null;
    L17:
        View r116 = this.f171075t;
        if (r116 == null) goto L30;
        if (r116 == null) goto L21;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L23:
        if ((r117 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r117 = null;
    L25:
        LinearLayout.LayoutParams r118 = (LinearLayout.LayoutParams) r117;
        if (r118 == null) goto L28;
        r118.width = r111;
        r118.height = SlcDimensExtensionsKt.a(16, r100);
        r118.topMargin = r110;
        r118.bottomMargin = r110;
        r113 = r118;
    L28:
        r116.setLayoutParams(r113);
        goto L30
    L21:
        r117 = null;
    L30:
        this.f171069n.setTextSize(0, SlcDimensExtensionsKt.e(14, r100));
        return;
    L29:
        LinearLayout r119 = this.f171066k;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        r120.height = SlcDimensExtensionsKt.a(20, r100);
        Unit r121 = Unit.INSTANCE;
        r119.setLayoutParams(r120);
        ImageView r122 = this.f171067l;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        r123.height = SlcDimensExtensionsKt.a(20, r100);
        r123.width = SlcDimensExtensionsKt.a(20, r100);
        r122.setLayoutParams(r123);
        ImageView r124 = this.f171068m;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        r125.height = SlcDimensExtensionsKt.a(20, r100);
        r125.width = SlcDimensExtensionsKt.a(20, r100);
        r124.setLayoutParams(r125);
        EditText r126 = this.f171069n;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        r127.height = SlcDimensExtensionsKt.a(20, r100);
        r127.width = SlcDimensExtensionsKt.a(36, r100);
        r126.setLayoutParams(r127);
        goto L30
    }

    public final void d(int r100) {
        if (r100 >= this.f171060e) goto L9;
        if (k.c(this.f171062g) == false) goto L7;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f171062g, 0, null, 8, null);
    L7:
        int r101 = this.f171060e;
        this.f171069n.setText(String.valueOf(r101));
        r100 = this.f171060e;
    L16:
        if (r100 != this.f171059d) goto L18;
        return;
    L18:
        Map r102 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r100)));
        BaseSlcViewManager<?> r103 = SlcViewExtensionsKt.g(this);
        if (r103 == null) goto L22;
        SlcCommonAction r104 = new SlcCommonAction(this.f171065j, r102);
        r103.f50260a.d(r104, this, r103.l(), null, null);
        return;
    L22:
        return;
    L9:
        if (r100 > this.f171061f) goto L11;
        this.f171069n.setText(String.valueOf(r100));
        goto L16
    L11:
        if (k.c(this.f171063h) == false) goto L13;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.f171063h, 0, null, 8, null);
    L13:
        int r105 = this.f171061f;
        this.f171069n.setText(String.valueOf(r105));
        r100 = this.f171061f;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.f171070o;
        this.f171070o = r101;
        if (r102 > 0) goto L5;
        return;
    L5:
        int r103 = r100.getId();
        if (r103 != R.id.btn_decrease) goto L9;
        this.f171069n.clearFocus();
        ViewUtilsKt.a(this.f171069n);
        d(this.f171059d - 1);
        return;
    L9:
        if (r103 != R.id.btn_increase) goto L13;
        this.f171069n.clearFocus();
        ViewUtilsKt.a(this.f171069n);
        d(this.f171059d + 1);
        return;
    }

    public final void setActive(boolean r100) {
        this.f171058c = r100;
    }

    public final void setChangeQuantityEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171065j = r100;
    }

    public final void setMaxLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171063h = r100;
    }

    public final void setMaxQuantity(int r100) {
        this.f171061f = r100;
    }

    public final void setMinLimitToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171062g = r100;
    }

    public final void setMinQuantity(int r100) {
        this.f171060e = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171064i = r100;
    }

    public final void setQuantity(int r100) {
        this.f171059d = r100;
    }

    public BuyNowCounterView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f171059d = 1;
        this.f171060e = 1;
        this.f171061f = 1;
        this.f171062g = "";
        this.f171063h = "";
        this.f171064i = "";
        this.f171065j = "";
        this.f171071p = true;
        this.f171072q = true;
        ECSettingKeys.f43625j.getClass();
        if (ECSettingKeys.U() != 1) goto L5;
        boolean r101 = true;
    L6:
        this.f171073r = r101;
        int r102 = com.bytedance.android.shopping.buynow.opt.a.f171027a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "parentView");
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.buynow_layout_counter, this, true);
        LinearLayout r112 = (LinearLayout) findViewById(R.id.ll_expend);
        this.f171066k = r112;
        ImageView r103 = (ImageView) findViewById(R.id.btn_decrease);
        this.f171067l = r103;
        EditText r104 = (EditText) findViewById(R.id.et_quantity);
        r104.setOnFocusChangeListener(new a(r104));
        Unit r105 = Unit.INSTANCE;
        this.f171069n = r104;
        ImageView r106 = (ImageView) findViewById(R.id.btn_increase);
        this.f171068m = r106;
        if (r101 == false) goto L9;
        r106.setImageResource(R.drawable.buynow_counter_v2_plus_enable);
        r103.setImageResource(R.drawable.buynow_counter_v2_minus_enable);
        r104.getPaint().setTypeface(Typeface.create("sans-serif-medium", 0));
        View r107 = new View(r100);
        r107.setBackgroundResource(R.drawable.buynow_counter_v2_divider);
        this.f171074s = r107;
        View r108 = new View(r100);
        r108.setBackgroundResource(R.drawable.buynow_counter_v2_divider);
        this.f171075t = r108;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -1);
        r109.gravity = 17;
        r112.addView(r107, 1, r109);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -1);
        r113.gravity = 17;
        r112.addView(r108, 3, r113);
    L10:
        r103.setOnClickListener(this);
        r106.setOnClickListener(this);
        r104.setOnEditorActionListener(new com.bytedance.android.shopping.buynow.slice.counter.a(this));
        WeakReference<EditText> r114 = d.f171078a;
        d.f171080c = new BuyNowCounterView$doBindManager$1(this);
        return;
    L9:
        r106.setImageResource(R.drawable.buynow_counter_plus_enable);
        r103.setImageResource(R.drawable.buynow_counter_minus_enable);
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public /* synthetic */ BuyNowCounterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(boolean r100, int r101, int r102, int r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r104, "minLimitToast");
        Intrinsics.checkNotNullParameter(r105, "maxLimitToast");
        Intrinsics.checkNotNullParameter(r106, "productId");
        Intrinsics.checkNotNullParameter(r107, "changeQuantityEvent");
        if (this.f171058c == false) goto L6;
        if (r100 == true) goto L6;
        d(com.bytedance.android.ecom.arch.slice.render.util.b.f(this.f171069n.getText().toString(), r101));
    L6:
        this.f171058c = r100;
        this.f171059d = r101;
        this.f171060e = r102;
        this.f171061f = r103;
        this.f171062g = r104;
        this.f171063h = r105;
        this.f171064i = r106;
        this.f171065j = r107;
        this.f171069n.setText(String.valueOf(r101));
        boolean r108 = false;
        if (this.f171060e >= this.f171059d) goto L9;
        boolean r109 = true;
    L11:
        if (r109 == this.f171072q) goto L18;
        this.f171072q = r109;
        if (r109 == false) goto L16;
        this.f171067l.setImageResource(R.drawable.buynow_counter_minus_enable);
        goto L18
    L16:
        this.f171067l.setImageResource(R.drawable.buynow_counter_minus_disable);
    L18:
        if (this.f171059d >= this.f171061f) goto L21;
        r108 = true;
    L21:
        if (r108 == this.f171071p) goto L27;
        this.f171071p = r108;
        if (r108 == false) goto L26;
        this.f171068m.setImageResource(R.drawable.buynow_counter_plus_enable);
        goto L27
    L26:
        this.f171068m.setImageResource(R.drawable.buynow_counter_plus_disable);
    L27:
        if (r100 == false) goto L30;
        d.f171079b = true;
        return;
    L30:
        return;
    L9:
        r109 = false;
        goto L11
    }
}
