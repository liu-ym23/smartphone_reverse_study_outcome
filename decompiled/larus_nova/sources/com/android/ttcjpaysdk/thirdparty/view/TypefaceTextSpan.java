package com.android.ttcjpaysdk.thirdparty.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007JR\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J4\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/view/TypefaceTextSpan;", "Landroid/text/style/ReplacementSpan;", "typeface", "Landroid/graphics/Typeface;", "textSize", "", "topOffset", "(Landroid/graphics/Typeface;FF)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getCustomTextPaint", "Landroid/text/TextPaint;", "srcPaint", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TypefaceTextSpan extends ReplacementSpan {
    private final float textSize;
    private final float topOffset;
    private final Typeface typeface;

    private final TextPaint getCustomTextPaint(Paint r100) {
        TextPaint r101 = new TextPaint(r100);
        Typeface r102 = this.typeface;
        if (r102 == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        TextPaint r104 = r101;
    L9:
        if (r104 == null) goto L12;
        r104.setTypeface(r102);
    L12:
        r101.setTextSize(this.textSize);
        return r101;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    public TypefaceTextSpan(Typeface r100, float r101, float r102) {
        this.typeface = r100;
        this.textSize = r101;
        this.topOffset = r102;
    }

    public /* synthetic */ TypefaceTextSpan(Typeface r100, float r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0.0f;
    L5:
        this(r100, r101, r102);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (int) getCustomTextPaint(r100).measureText(r101, r102, r103);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r118, "paint");
        TextPaint r100 = getCustomTextPaint(r118);
        Paint.FontMetricsInt r101 = r100.getFontMetricsInt();
        int r102 = ((((r116 + r101.ascent) + r116) + r101.descent) / 2) - ((r115 + r117) / 2);
        Intrinsics.checkNotNull(r111);
        r110.drawText(r111, r112, r113, r114, (r116 - r102) + this.topOffset, r100);
    }
}
