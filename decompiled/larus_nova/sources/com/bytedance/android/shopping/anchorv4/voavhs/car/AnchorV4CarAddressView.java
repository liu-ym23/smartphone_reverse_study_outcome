package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.extensions.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/car/AnchorV4CarAddressView;", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", ce.f26395j, "Lkotlin/Lazy;", "getCurrentRootView", "()Landroid/widget/LinearLayout;", "currentRootView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CarAddressView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongContentLabelComponentView f168062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextElementView f168063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextElementView f168064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b f168065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnchorV4CarAddressDisplay f168066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f168067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f168068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f168069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f168070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f168071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f168072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f168073l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4CarAddressView f168074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f168075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f168076c;

        public a(AnchorV4CarAddressView r100, String r101, String r102) {
            this.f168074a = r100;
            this.f168075b = r101;
            this.f168076c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f168074a.f168063b.getWidth() != 0) goto L11;
            AnchorV4CarAddressView r100 = this.f168074a;     // Catch: Throwable -> L8
            if (r100.f168067f == false) goto L15;
            r100.b(this.f168075b, this.f168076c);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    public AnchorV4CarAddressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4CarAddressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final LinearLayout getCurrentRootView() {
        return (LinearLayout) this.f168071j.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f168067f = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f168067f = false;
    }

    public static final /* synthetic */ LinearLayout a(AnchorV4CarAddressView r100) {
        return r100.getCurrentRootView();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f168065d.e(r100);
        super.draw(r100);
        this.f168065d.d(r100);
    }

    public final void b(String r210, String r211) {
        String r100 = r210;
        this.f168063b.post(new a(this, r100, r211));
        StringBuilder r101 = new StringBuilder();
        TextElement r102 = null;
        if (r100 == null) goto L5;
        Boolean r103 = Boolean.valueOf(StringsKt.contains$default(r100, "已选：", false, 2, null));
    L7:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == true) goto L9;
    L15:
        r101.append(r100);
        r101.append(" ");
        r101.append(r211);
        String r110 = r101.toString();
        float r104 = this.f168063b.getPaint().measureText(r110);
        float r105 = n1.f45657f;
        if (r104 >= r105) goto L23;
        TextElementView r106 = this.f168063b;
        AnchorV4CarAddressDisplay r107 = this.f168066e;
        if (r107 == null) goto L22;
        TextElement r108 = r107.getCarAddress();
        if (r108 == null) goto L22;
        r102 = TextElement.copy$default(r108, null, null, r110, null, null, null, null, null, 0, null, 1019, null);
    L22:
        r106.x(r102);
        return;
    L23:
        StringBuilder r109 = new StringBuilder();
        r109.append("已选： ");
        r109.append(r100);
        r109.append(" ");
        r109.append(r211);
    L25:
        if (this.f168063b.getPaint().measureText(r109.toString()) <= r105) goto L31;
        StringsKt.clear(r109);
        r109.append("已选： ");
        if (r100 == null) goto L29;
        r100 = r100.substring(0, r100.length() - 1);
    L30:
        r109.append(r100);
        r109.append("...");
        r109.append(r211);
        goto L25
    L29:
        r100 = null;
        goto L30
    L31:
        TextElementView r111 = this.f168063b;
        AnchorV4CarAddressDisplay r112 = this.f168066e;
        if (r112 == null) goto L36;
        TextElement r113 = r112.getCarAddress();
        if (r113 == null) goto L36;
        r102 = TextElement.copy$default(r113, null, null, r109.toString(), null, null, null, null, null, 0, null, 1019, null);
    L36:
        r111.x(r102);
        return;
    L9:
        if (this.f168068g == true) goto L15;
        if (k.c(r210) == false) goto L15;
        if (a2.a(r100, j.c(R.string.shopping_anchor_v3_gps_not_available)) == true) goto L15;
        r101.append("已选： ");
        goto L15
    L5:
        r103 = null;
        goto L7
    }

    public AnchorV4CarAddressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r103 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.f168065d = r103;
        this.f168068g = true;
        this.f168071j = LazyKt.lazy(new AnchorV4CarAddressView$currentRootView$2(this));
        this.f168072k = 8;
        int r104 = vf4.a.b(12);
        this.f168073l = r104;
        LayoutInflater r105 = LayoutInflater.from(r100);
        if (r105 == null) goto L5;
        r105.inflate(R.layout.ec_commerce_layout_anchor_v4_car_address_section, this, true);
    L5:
        setPadding(r104, r104, r104, r104);
        setBackgroundColor(-1);
        this.f168062a = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_car_title);
        this.f168063b = (TextElementView) findViewById(R.id.anchor_v4_car_address);
        this.f168064c = (TextElementView) findViewById(R.id.anchor_v4_car_address_detail);
        r103.f(new Radius(8, 8, 8, 8));
    }

    public /* synthetic */ AnchorV4CarAddressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void c(b r110, AnchorV4CarAddressDisplay r111, e r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r112, "viewModel");
        if (r111 != null) goto L6;
        return;
    L6:
        if (r112.i() == false) goto L9;
        if (r113 == true) goto L9;
        return;
    L9:
        this.f168069h = r112;
        CommonMeta r114 = r112.a();
        if (r114 != null) goto L12;
    L20:
        this.f168066e = r111;
        this.f168062a.bind(r111.getCarTitle());
        TextElement r115 = r111.getCarAddress();
        ViewGroup.LayoutParams r100 = null;
        if (r115 == null) goto L23;
        String r116 = r115.getText();
    L24:
        TextElement r101 = r111.getCarDistance();
        if (r101 == null) goto L27;
        String r102 = r101.getText();
    L28:
        b(r116, r102);
        this.f168064c.x(r111.getCarAddressDetail());
        TextElementView r117 = this.f168064c;
        TextElement r118 = r111.getCarAddressDetail();
        if (r118 == null) goto L35;
        String r119 = r118.getText();
        if (r119 == null) goto L35;
        if (k.c(r119) != true) goto L35;
        boolean r120 = true;
    L36:
        wg.a.h(r117, r120);
        CommonMeta r121 = r112.a();
        if (r121 == null) goto L39;
        Boolean r122 = Boolean.valueOf(r121.getEnablePDPOptimize());
    L41:
        if (k.i(r122) == false) goto L56;
        TextElementView r123 = this.f168064c;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if ((r124 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r124 = null;
    L45:
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;
        if (r125 == null) goto L48;
        r125.topMargin = vf4.a.b(8);
        r123.setLayoutParams(r125);
    L48:
        TextElementView r126 = this.f168063b;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == false) goto L52;
        r100 = r127;
    L52:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r100;
        if (r103 == null) goto L55;
        r103.topMargin = vf4.a.b(16);
        r126.setLayoutParams(r103);
    L55:
        this.f168065d.f(new Radius(12, 12, 12, 12));
        this.f168072k = 12;
    L56:
        this.f168068g = false;
        if (r110 == null) goto L60;
        int r128 = q.f166972a;
        q.a(this, r110.f168084e, this.f168065d, this.f168072k, -1, CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f168073l), Integer.valueOf(this.f168073l), Integer.valueOf(this.f168073l), Integer.valueOf(this.f168073l)}));
        return;
    L60:
        return;
    L39:
        r122 = null;
    L35:
        r120 = false;
        goto L36
    L27:
        r102 = null;
        goto L28
    L23:
        r116 = null;
        goto L24
    L12:
        if (Intrinsics.areEqual(r114.getNeedEnlarged(), Boolean.TRUE) == false) goto L20;
        if (this.f168070i == true) goto L20;
        Float r104 = r114.getHorizontalPadding();
        if (r104 == null) goto L18;
        int r105 = vf4.a.b(r104);
    L19:
        int r129 = vf4.a.b(Float.valueOf(h73.a.f(r114))) - r105;
        int r106 = k1.m(getContext()) - r105;
        LinearLayout r107 = getCurrentRootView();
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.width = r129;
        Unit r109 = Unit.INSTANCE;
        r107.setLayoutParams(r108);
        this.f168070i = true;
        getCurrentRootView().getViewTreeObserver().addOnGlobalLayoutListener(new c(r106, r129, this));
        goto L20
    L18:
        r105 = vf4.a.b(16) + (this.f168073l * 2);
        goto L19
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f168065d.c(r100, r101);
    }
}
