package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.constant.CommonKey;
import com.obric.oui.common.style.l;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R*\u0010*\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00078\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u000eR*\u0010.\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00078\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010\u000eR*\u00106\u001a\u00020/2\u0006\u0010$\u001a\u00020/8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105¨\u0006;"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/IndicatorIcon;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", Style.KEY_WIDTH, "", "setWidth", "(I)V", "horizontalMargin", "setHorizontalMargin", Style.KEY_MARGIN, "setStartMargin", "setEndMargin", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "a", "Landroid/graphics/RectF;", "bgRectF", "b", "strokeRectF", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "dotPaint", "d", "strokePaint", CommonKey.KEY_VALUE, "e", "I", "getDotColor", "()I", "setDotColor", "dotColor", "f", "getStrokeColor", "setStrokeColor", "strokeColor", "", "g", "F", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "h", "getCornerRadius", "setCornerRadius", "cornerRadius", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorDotView extends View implements IndicatorIcon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f14969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f14970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f14971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f14972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f14975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14976h;

    @JvmOverloads
    public IndicatorDotView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getCornerRadius() {
        return this.f14976h;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getDotColor() {
        return this.f14973e;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getStrokeColor() {
        return this.f14974f;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getStrokeWidth() {
        return this.f14975g;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
        this.f14969a.set(0.0f, 0.0f, getWidth(), getHeight());
        l.i(r10, this.f14969a, getCornerRadius(), this.f14971c);
        if (getStrokeWidth() <= 0.0f) goto L6;
        float r11 = 2;
        this.f14970b.set(getStrokeWidth() / r11, getStrokeWidth() / r11, getWidth() - (getStrokeWidth() / r11), getHeight() - (getStrokeWidth() / r11));
        l.i(r10, this.f14970b, getCornerRadius(), this.f14972d);
        return;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setCornerRadius(float r10) {
        this.f14976h = r10;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setDotColor(int r10) {
        if (this.f14973e == r10) goto L5;
        this.f14973e = r10;
    L5:
        this.f14971c.setColor(r10);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setEndMargin(int r10) {
        ViewGroup.LayoutParams r11 = getLayoutParams();
        ViewGroup.LayoutParams r12 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r13 == null) goto L9;
        r13.setMarginEnd(r10);
        requestLayout();
        r12 = r13;
    L9:
        setLayoutParams(r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setHorizontalMargin(int r10) {
        c.c(this, r10);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStartMargin(int r10) {
        ViewGroup.LayoutParams r11 = getLayoutParams();
        ViewGroup.LayoutParams r12 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r13 == null) goto L9;
        r13.setMarginStart(r10);
        requestLayout();
        r12 = r13;
    L9:
        setLayoutParams(r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeColor(int r10) {
        if (this.f14974f == r10) goto L5;
        this.f14974f = r10;
    L5:
        this.f14972d.setColor(r10);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeWidth(float r10) {
        if (this.f14975g == r10) goto L6;
        this.f14975g = r10;
    L6:
        this.f14972d.setStrokeWidth(r10);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setWidth(int r10) {
        c.e(this, r10);
    }

    @JvmOverloads
    public IndicatorDotView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ IndicatorDotView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public IndicatorDotView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14969a = new RectF();
        this.f14970b = new RectF();
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        this.f14971c = r13;
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.STROKE);
        this.f14972d = r14;
        this.f14973e = -7829368;
    }
}
