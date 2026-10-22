package com.alibaba.gaiax.render.view.basic.spannable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.alibaba.gaiax.template.GXSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J2\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/ImagePlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "leftOffset", "", "rightOffset", "(ILjava/lang/Float;Ljava/lang/Float;)V", "leftOffsetPX", "rightOffsetPX", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImagePlaceholderSpan extends ReplacementSpan {
    private final int leftOffsetPX;
    private final int rightOffsetPX;
    private final int width;

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
    }

    public ImagePlaceholderSpan(int r100, Float r101, Float r102) {
        this.width = r100;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = GXSize.Companion.dpToIntPx(r102.floatValue());
    L6:
        this.rightOffsetPX = r104;
        if (r101 == null) goto L9;
        r103 = GXSize.Companion.dpToIntPx(r101.floatValue());
    L9:
        this.leftOffsetPX = r103;
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public /* synthetic */ ImagePlaceholderSpan(int r100, Float r101, Float r102, int r103, DefaultConstructorMarker r104) {
        int r105 = r103 & 2;
        Float r106 = Float.valueOf(0.0f);
        if (r105 == 0) goto L6;
        r101 = r106;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = r106;
    L8:
        this(r100, r101, r102);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (this.width + this.rightOffsetPX) + this.leftOffsetPX;
    }
}
