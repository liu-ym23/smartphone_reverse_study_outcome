package com.android.ttcjpaysdk.base.ui.component;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005JP\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J2\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJPayOverlappedIconsSpan;", "Landroid/text/style/ReplacementSpan;", "bitmaps", "", "Landroid/graphics/Bitmap;", "(Ljava/util/List;)V", "bgPaint", "Landroid/graphics/Paint;", "bgSize", "", "bitmapPaint", "grayPaint", "iconSize", "overlapOffset", "sidePadding", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOverlappedIconsSpan extends ReplacementSpan {
    private final Paint bgPaint;
    private final int bgSize;
    private final Paint bitmapPaint;
    private final List<Bitmap> bitmaps;
    private final Paint grayPaint;
    private final int iconSize;
    private final int overlapOffset;
    private final int sidePadding;

    public CJPayOverlappedIconsSpan(List<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "bitmaps");
        this.bitmaps = r100;
        this.iconSize = CJPayBasicExtensionKt.dp(14);
        int r101 = CJPayBasicExtensionKt.dp(16);
        this.bgSize = r101;
        this.overlapOffset = (int) ((r101 * 2) / 3.0f);
        this.sidePadding = CJPayBasicExtensionKt.dp(3);
        Paint r102 = new Paint(1);
        r102.setFilterBitmap(true);
        r102.setDither(true);
        this.bitmapPaint = r102;
        Paint r103 = new Paint(1);
        r103.setColor(-1);
        r103.setStyle(Paint.Style.FILL);
        this.bgPaint = r103;
        Paint r104 = new Paint(1);
        r104.setColor(ColorProtector.parseColor("#F8F8F8"));
        r104.setStyle(Paint.Style.FILL);
        this.grayPaint = r104;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (this.bitmaps.isEmpty() == false) goto L6;
        return 0;
    L6:
        return ((this.sidePadding + this.bgSize) + ((this.bitmaps.size() - 1) * this.overlapOffset)) + this.sidePadding;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r110, int r111, Paint r112) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r112, "paint");
        float r106 = (r105 + r111) / 2.0f;
        float r107 = this.bgSize / 2.0f;
        float r108 = this.iconSize / 2.0f;
        float r109 = r104 + this.sidePadding;
        int r113 = this.bitmaps.size() - 1;
        if (r113 < 0) goto L11;
    L4:
        int r114 = r113 - 1;
        Bitmap r115 = (Bitmap) ListProtector.get(this.bitmaps, r113);
        float r116 = ((r113 * this.overlapOffset) + r109) + r107;
        r100.drawCircle(r116, r106, r107, this.bgPaint);
        if (r115 == null) goto L7;
        r100.drawBitmap(r115, new Rect(0, 0, r115.getWidth(), r115.getHeight()), new RectF(r116 - r108, r106 - r108, r116 + r108, r106 + r108), this.bitmapPaint);
    L8:
        if (r114 < 0) goto L13;
        r113 = r114;
        goto L4
    L13:
        return;
    L7:
        r100.drawCircle(r116, r106, r108, this.grayPaint);
        goto L8
    }
}
