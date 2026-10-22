package com.obric.oui.common.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TextViewExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
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
    public int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r2, "paint");
        return d.i.a.a(r2.measureText(r7, r4, r5) + (this.horPadding * 2));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r13, CharSequence r14, int r15, int r16, float r17, int r18, int r19, int r20, Paint r21) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r13, "canvas");
        o.e(r21, "paint");
        this.mRect.set((int) r17, r18, (int) ((r21.measureText(r3, r15, r16) + r17) + (this.horPadding * 2)), r20);
        r21.setColor(0);
        r13.drawRect(this.mRect, r21);
        r21.setColor(this.textColor);
        float r4 = r17 + this.horPadding;
        if (r3 == null) goto L7;
        r13.drawText(r3, r15, r16, r4, r19, r21);
        return;
    }
}
