package com.bytedance.android.shopping.inflow.cardui.product.header.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "Landroid/view/View;", "", "count", "", LynxTemplateRender.RENDER_PHASE_SETUP, "", LynxVideoManagerLite.FILL, "setFillCurrent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardProgressIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f176236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f176237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f176238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f176239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f176240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f176241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f176242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f176243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f176244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f176245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f176246k;

    public ProductCardProgressIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductCardProgressIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = this.f176243h;
        if (r100 != 0) goto L5;
        return;
    L5:
        int r101 = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f176241f * (r100 - 1))) / this.f176243h;
        int r102 = getMeasuredHeight();
        if (f.f() == false) goto L8;
        r102 = 2;
    L8:
        this.f176238c.set(0.0f, getPaddingTop(), r101, r102 - getPaddingBottom());
        this.f176242g = this.f176238c.height() / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f176239d.set(this.f176238c);
        this.f176240e.set(this.f176238c);
        int r101 = this.f176243h;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        int r103 = this.f176244i;
        if (r102 < r103) goto L13;
        if (r102 == r103) goto L8;
    L10:
        if (r102 <= r103) goto L12;
        RectF r104 = this.f176239d;
        float r105 = this.f176242g;
        r100.drawRoundRect(r104, r105, r105, this.f176236a);
    L14:
        float r106 = this.f176238c.width();
        RectF r107 = this.f176239d;
        float r108 = r107.right + this.f176241f;
        r107.left = r108;
        r107.right = r108 + r106;
        this.f176240e.set(r107);
        r102 = r102 + 1;
        goto L3
    L12:
        RectF r109 = this.f176239d;
        float r110 = this.f176242g;
        r100.drawRoundRect(r109, r110, r110, this.f176236a);
        RectF r111 = this.f176240e;
        r111.right -= r111.width() * (1 - this.f176245j);
        RectF r112 = this.f176240e;
        float r113 = this.f176242g;
        r100.drawRoundRect(r112, r113, r113, this.f176237b);
        goto L14
    L8:
        if (this.f176246k == false) goto L10;
    L13:
        RectF r114 = this.f176240e;
        float r115 = this.f176242g;
        r100.drawRoundRect(r114, r115, r115, this.f176237b);
        goto L14
    }

    public final void setFillCurrent(boolean r100) {
        this.f176246k = r100;
        invalidate();
    }

    public final void setup(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        this.f176243h = r100;
        a();
        invalidate();
    }

    public final void b(int r100, float r101) {
        this.f176244i = r100;
        this.f176245j = r101;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f176243h == 0) goto L6;
        a();
        return;
    }

    public ProductCardProgressIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f176236a = r103;
        Paint r104 = new Paint();
        this.f176237b = r104;
        this.f176238c = new RectF();
        this.f176239d = new RectF();
        this.f176240e = new RectF();
        this.f176241f = b.b(2);
        r103.setAntiAlias(true);
        r103.setColor(Color.argb(122, 255, 255, 255));
        r104.setAntiAlias(true);
        r104.setColor(Color.argb(255, 255, 255, 255));
    }

    public /* synthetic */ ProductCardProgressIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
