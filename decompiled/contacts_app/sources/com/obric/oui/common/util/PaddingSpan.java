package com.obric.oui.common.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TextViewExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JR\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J4\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/common/util/PaddingSpan;", "Landroid/text/style/ReplacementSpan;", "horPadding", "", "textColor", "", "(FI)V", "getHorPadding", "()F", "mRect", "Landroid/graphics/Rect;", "getTextColor", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", TraceStatsConsts.STATS_KEY_END, MaterialConfigFormatNames.X, "top", MaterialConfigFormatNames.Y, "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaddingSpan extends ReplacementSpan {
    private final float horPadding;
    private final Rect mRect;
    private final int textColor;

    public PaddingSpan(float r1, int r2) {
        this.horPadding = r1;
        this.textColor = r2;
        this.mRect = new Rect();
    }

    public final float getHorPadding() {
        return this.horPadding;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return MathKt.roundToInt(r1.measureText(r2, r3, r4) + (this.horPadding * 2));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r13, CharSequence r14, int r15, int r16, float r17, int r18, int r19, int r20, Paint r21) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r21, "paint");
        this.mRect.set((int) r17, r18, (int) ((r21.measureText(r14, r15, r16) + r17) + (this.horPadding * 2)), r20);
        r21.setColor(0);
        r13.drawRect(this.mRect, r21);
        r21.setColor(this.textColor);
        float r4 = r17 + this.horPadding;
        if (r14 == null) goto L7;
        r13.drawText(r14, r15, r16, r4, r19, r21);
        return;
    }
}
