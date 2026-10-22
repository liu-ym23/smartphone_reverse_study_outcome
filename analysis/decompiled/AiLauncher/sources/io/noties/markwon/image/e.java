package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class e extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int alignment;
    private final a drawable;
    private final boolean replacementTextIsLink;
    private final C5671a theme;

    public e(C5671a c5671a, a aVar, int i10, boolean z10) {
        this.theme = c5671a;
        this.drawable = aVar;
        this.alignment = i10;
        this.replacementTextIsLink = z10;
    }

    public static float b(int i10, int i11, Paint paint) {
        return (int) ((i10 + ((i11 - i10) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    public a a() {
        return this.drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        int iHeight;
        this.drawable.j(N8.f.a(canvas, charSequence), paint.getTextSize());
        a aVar = this.drawable;
        if (!aVar.h()) {
            float fB = b(i12, i14, paint);
            if (this.replacementTextIsLink) {
                this.theme.f(paint);
            }
            canvas.drawText(charSequence, i10, i11, f10, fB, paint);
            return;
        }
        int i15 = i14 - aVar.getBounds().bottom;
        int iSave = canvas.save();
        try {
            int i16 = this.alignment;
            if (2 != i16) {
                if (1 == i16) {
                    iHeight = paint.getFontMetricsInt().descent;
                }
                canvas.translate(f10, i15);
                aVar.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            iHeight = ((i14 - i12) - aVar.getBounds().height()) / 2;
            i15 -= iHeight;
            canvas.translate(f10, i15);
            aVar.draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.drawable.h()) {
            if (this.replacementTextIsLink) {
                this.theme.f(paint);
            }
            return (int) (paint.measureText(charSequence, i10, i11) + 0.5f);
        }
        Rect bounds = this.drawable.getBounds();
        if (fontMetricsInt != null) {
            int i12 = -bounds.bottom;
            fontMetricsInt.ascent = i12;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i12;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
