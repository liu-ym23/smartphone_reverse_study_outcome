package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.apm.constant.CommonKey;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\rR*\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\rR\"\u0010!\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\r¨\u0006*"}, d2 = {"Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/indicator/IndicatorIcon;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "initialDrawable", "<init>", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V", "", Style.KEY_WIDTH, "", "setWidth", "(I)V", "horizontalMargin", "setHorizontalMargin", Style.KEY_MARGIN, "setStartMargin", "setEndMargin", CommonKey.KEY_VALUE, "a", "I", "getDotColor", "()I", "setDotColor", "dotColor", "", "b", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "c", "getStrokeWidth", "setStrokeWidth", "strokeWidth", "d", "getStrokeColor", "setStrokeColor", "strokeColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorImageDotView extends AppCompatImageView implements IndicatorIcon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14986d;

    public IndicatorImageDotView(Context r10, Drawable r11) {
        q.g(r10, "context");
        super(r10);
        this.f14983a = -7829368;
        setImageDrawable(r11);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getCornerRadius() {
        return this.f14984b;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getDotColor() {
        return this.f14983a;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getStrokeColor() {
        return this.f14986d;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getStrokeWidth() {
        return this.f14985c;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setCornerRadius(float r10) {
        this.f14984b = r10;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setDotColor(int r10) {
        if (this.f14983a == r10) goto L5;
        this.f14983a = r10;
    L5:
        setColorFilter(r10);
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
        this.f14986d = r10;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeWidth(float r10) {
        this.f14985c = r10;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setWidth(int r10) {
        c.e(this, r10);
    }
}
