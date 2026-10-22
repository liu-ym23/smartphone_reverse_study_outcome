package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u00100\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00104\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'¨\u00065"}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "draw", "", "setDrawBackground", "(Z)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "a", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "bgPaint", "c", "Z", "drawSelf", "d", "I", "getCornerRadius", "()I", "setCornerRadius", "(I)V", "cornerRadius", CommonKey.KEY_VALUE, "e", "Ljava/lang/Integer;", "getFixedContentWidthPx", "()Ljava/lang/Integer;", "setFixedContentWidthPx", "(Ljava/lang/Integer;)V", "fixedContentWidthPx", "f", "getBgColor", "setBgColor", Style.KEY_BG_COLOR, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f14977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f14978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f14981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14982f;

    @JvmOverloads
    public IndicatorGroupLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final int getBgColor() {
        return this.f14982f;
    }

    public final int getCornerRadius() {
        return this.f14980d;
    }

    @Nullable
    public final Integer getFixedContentWidthPx() {
        return this.f14981e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f14979c == false) goto L5;
        this.f14977a.set(0.0f, 0.0f, getWidth(), getHeight());
        l.i(r10, this.f14977a, this.f14980d * 1.0f, this.f14978b);
    L5:
        super.onDraw(r10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        Integer r12 = this.f14981e;
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = r12.intValue();
        int r14 = LinearLayout.resolveSize((getPaddingLeft() + r13) + getPaddingRight(), r10);
        if (getMeasuredWidth() == r14) goto L9;
        setMeasuredDimension(r14, getMeasuredHeight());
        return;
    }

    public final void setBgColor(int r10) {
        if (this.f14982f == r10) goto L5;
        this.f14982f = r10;
    L5:
        this.f14978b.setColor(r10);
    }

    public final void setCornerRadius(int r10) {
        this.f14980d = r10;
    }

    public final void setDrawBackground(boolean r10) {
        this.f14979c = r10;
        invalidate();
    }

    public final void setFixedContentWidthPx(@Nullable Integer r10) {
        if (q.b(this.f14981e, r10) == true) goto L6;
        this.f14981e = r10;
        requestLayout();
        invalidate();
        return;
    }

    @JvmOverloads
    public IndicatorGroupLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public IndicatorGroupLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14977a = new RectF();
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        this.f14978b = r13;
        setBackgroundColor(0);
    }
}
