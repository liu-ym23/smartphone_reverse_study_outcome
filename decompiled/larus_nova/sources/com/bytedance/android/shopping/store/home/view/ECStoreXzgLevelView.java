package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreXzgLevelView;", "Landroid/widget/LinearLayout;", "", "isLightStyle", "", "setStyle", "", "color", "setNoLevelViewColor", "", "value", ce.f26391f, FaceService.girlLabel, "getCollapse", "()F", "setCollapse", "(F)V", "collapse", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreXzgLevelView extends LinearLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f184606m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f184607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f184608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f184609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f184610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f184611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.ec.model.o f184612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f184613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f184614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f184615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f184616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f184617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f184618l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECStoreXzgLevelView f184619a;

        public a(ECStoreXzgLevelView r100) {
            this.f184619a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreXzgLevelView r100 = this.f184619a;     // Catch: Throwable -> L9
            int r101 = ECStoreXzgLevelView.f184606m;     // Catch: Throwable -> L9
            com.bytedance.android.ec.model.o r102 = r100.f184612f;     // Catch: Throwable -> L9
            if (r102 == null) goto L7;
            Integer r103 = r102.f();     // Catch: Throwable -> L9
            if (r103 == null) goto L7;
            r103.intValue();     // Catch: Throwable -> L9
        L7:
            r100.f184609c.removeAllViews();     // Catch: Throwable -> L9
            r100.f184610d.removeAllViews();     // Catch: Throwable -> L9
            this.f184619a.f184609c.setVisibility(0);     // Catch: Throwable -> L9
            this.f184619a.f184610d.setVisibility(0);     // Catch: Throwable -> L9
            this.f184619a.requestLayout();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public ECStoreXzgLevelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStoreXzgLevelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getCollapse() {
        return this.f184613g;
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L5;
        setCollapse(1.0f);
    L5:
        com.bytedance.android.ec.model.o r101 = this.f184612f;
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.b();
    L9:
        if (r103 == null) goto L15;
        com.bytedance.android.ec.model.o r104 = this.f184612f;
        if (r104 == null) goto L13;
        String r105 = r104.b();
    L14:
        int r106 = ColorProtector.parseColor(r105);
    L16:
        com.bytedance.android.ec.model.o r107 = this.f184612f;
        if (r107 == null) goto L19;
        String r108 = r107.d();
    L20:
        if (r108 == null) goto L25;
        com.bytedance.android.ec.model.o r109 = this.f184612f;
        if (r109 == null) goto L24;
        r102 = r109.d();
    L24:
        int r110 = ColorProtector.parseColor(r102);
    L26:
        this.f184611e.setTextColor(ColorUtils.blendARGB(r106, r110, this.f184613g));
        float r111 = 1;
        this.f184608b.setAlpha(r111 - this.f184613g);
        this.f184607a.setAlpha(1.0f);
        com.bytedance.android.ec.model.o r112 = this.f184612f;
        if (r112 == null) goto L31;
        Integer r113 = r112.f();
        if (r113 == null) goto L31;
        int r114 = r113.intValue();
    L32:
        if (r114 != 0) goto L34;
        this.f184609c.setAlpha(1.0f);
        this.f184610d.setAlpha(0.0f);
        return;
    L34:
        this.f184609c.setAlpha(r111 - this.f184613g);
        this.f184610d.setAlpha(this.f184613g);
        return;
    L31:
        r114 = 0;
        goto L32
    L25:
        r110 = (int) 4279638051L;
        goto L26
    L19:
        r108 = null;
        goto L20
    L13:
        r105 = null;
        goto L14
    L15:
        r106 = -1;
        goto L16
    L8:
        r103 = null;
        goto L9
    }

    public final void setCollapse(float r100) {
        if (this.f184613g == r100) goto L6;
        this.f184613g = r100;
        a(false);
        return;
    }

    public final void setNoLevelViewColor(int r100) {
        this.f184611e.setTextColor(r100);
    }

    public final void setStyle(boolean r100) {
        if (r100 == false) goto L4;
        this.f184611e.setTextColor(-1);
        return;
    L4:
        TextView r101 = this.f184611e;
        int r102 = g1.f45599a;
        r101.setTextColor(g1.a.a(getContext(), R.color.commerce_color_90161823));
    }

    public ECStoreXzgLevelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(r100);
        int r104 = g1.f45599a;
        r103.setText(g1.a.c(r100, R.string.ec_store_xzg_no_level, new Object[0]));
        com.bytedance.android.shopping.extensions.f.e(r103, 500);
        r103.setGravity(16);
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.store.utils.o.a(14));
        r105.setMargins(com.bytedance.android.shopping.extensions.b.b(3), 0, 0, 0);
        Unit r106 = Unit.INSTANCE;
        r103.setLayoutParams(r105);
        r103.setIncludeFontPadding(false);
        wg.a.g(r103, 11);
        this.f184611e = r103;
        LinearLayout.inflate(r100, R.layout.ec_store_xzg_reputation_level_view, this);
        this.f184608b = (ECDraweeView) findViewById(R.id.xzg_title_dv_start);
        this.f184607a = (ECDraweeView) findViewById(R.id.xzg_title_dv_end);
        this.f184609c = (LinearLayout) findViewById(R.id.expand_xzg_container);
        this.f184610d = (LinearLayout) findViewById(R.id.collapse_xzg_container);
        setGravity(16);
        this.f184614h = com.bytedance.android.shopping.extensions.b.b(28);
        this.f184615i = com.bytedance.android.shopping.extensions.b.b(58);
        com.bytedance.android.shopping.store.utils.o.a(16);
        this.f184616j = com.bytedance.android.shopping.store.utils.o.a(20);
    }

    public /* synthetic */ ECStoreXzgLevelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Point r105 = l0.f(getContext());
        if (r105 == null) goto L7;
        int r106 = r105.x;
        Rect r107 = new Rect();
        this.f184608b.getGlobalVisibleRect(r107);
        int r108 = r106 - (this.f184614h + this.f184615i);
        if ((r107.right + ((this.f184616j + com.bytedance.android.shopping.extensions.b.b(1)) * 5)) <= r108) goto L7;
        Math.floor(((double) (((r108 - r107.right) / 5) - com.bytedance.android.shopping.extensions.b.b(1))) * 0.8d);
        boolean r109 = true;
    L8:
        if (r109 == true) goto L10;
        return;
    L10:
        if (this.f184617k == false) goto L12;
        return;
    L12:
        if (this.f184618l == true) goto L17;
        this.f184617k = true;
        this.f184609c.setVisibility(4);
        this.f184610d.setVisibility(4);
        post(new a(this));
        return;
    L17:
        return;
    L7:
        r109 = false;
        goto L8
    }
}
