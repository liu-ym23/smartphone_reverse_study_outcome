package a4;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends ReplacementSpan {

    /* renamed from: c, reason: collision with root package name */
    public Paint.FontMetricsInt f155c;

    /* renamed from: f, reason: collision with root package name */
    public z f156f;

    /* renamed from: g, reason: collision with root package name */
    public short f157g;

    /* renamed from: h, reason: collision with root package name */
    public float f158h;
    public TextPaint i;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r19, java.lang.CharSequence r20, int r21, int r22, float r23, int r24, int r25, int r26, android.graphics.Paint r27) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r27
            boolean r3 = r1 instanceof android.text.Spanned
            r4 = 0
            if (r3 == 0) goto L4e
            android.text.Spanned r1 = (android.text.Spanned) r1
            java.lang.Class<android.text.style.CharacterStyle> r3 = android.text.style.CharacterStyle.class
            r5 = r21
            r6 = r22
            java.lang.Object[] r1 = r1.getSpans(r5, r6, r3)
            android.text.style.CharacterStyle[] r1 = (android.text.style.CharacterStyle[]) r1
            int r3 = r1.length
            if (r3 == 0) goto L46
            int r3 = r1.length
            r5 = 0
            r6 = 1
            if (r3 != r6) goto L26
            r3 = r1[r5]
            if (r3 != r0) goto L26
            goto L46
        L26:
            android.text.TextPaint r3 = r0.i
            if (r3 != 0) goto L31
            android.text.TextPaint r3 = new android.text.TextPaint
            r3.<init>()
            r0.i = r3
        L31:
            r4 = r3
            r4.set(r2)
        L35:
            int r3 = r1.length
            if (r5 >= r3) goto L44
            r3 = r1[r5]
            boolean r6 = r3 instanceof android.text.style.MetricAffectingSpan
            if (r6 != 0) goto L41
            r3.updateDrawState(r4)
        L41:
            int r5 = r5 + 1
            goto L35
        L44:
            r10 = r4
            goto L56
        L46:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L44
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L44
        L4e:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L44
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L44
        L56:
            if (r10 == 0) goto L86
            int r1 = r10.bgColor
            if (r1 == 0) goto L86
            short r1 = r0.f157g
            float r1 = (float) r1
            float r8 = r23 + r1
            r1 = r24
            float r7 = (float) r1
            r1 = r26
            float r9 = (float) r1
            int r1 = r10.getColor()
            android.graphics.Paint$Style r3 = r10.getStyle()
            int r4 = r10.bgColor
            r10.setColor(r4)
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            r5 = r19
            r6 = r23
            r5.drawRect(r6, r7, r8, r9, r10)
            r10.setStyle(r3)
            r10.setColor(r1)
        L86:
            a4.j r1 = a4.j.a()
            r1.getClass()
            a4.z r0 = r0.f156f
            r1 = r25
            float r1 = (float) r1
            if (r10 == 0) goto L95
            goto L96
        L95:
            r10 = r2
        L96:
            p5.i r2 = r0.f218b
            java.lang.Object r3 = r2.f9733h
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3
            android.graphics.Typeface r4 = r10.getTypeface()
            r10.setTypeface(r3)
            int r0 = r0.f217a
            int r13 = r0 * 2
            java.lang.Object r0 = r2.f9731f
            r12 = r0
            char[] r12 = (char[]) r12
            r14 = 2
            r11 = r19
            r15 = r23
            r16 = r1
            r17 = r10
            r11.drawText(r12, r13, r14, r15, r16, r17)
            r10.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.a0.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f155c;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        z zVar = this.f156f;
        this.f158h = fAbs / (zVar.b().a(14) != 0 ? ((ByteBuffer) r8.f1900h).getShort(r1 + r8.f1897c) : (short) 0);
        b4.a aVarB = zVar.b();
        int iA = aVarB.a(14);
        if (iA != 0) {
            ((ByteBuffer) aVarB.f1900h).getShort(iA + aVarB.f1897c);
        }
        short s6 = (short) ((zVar.b().a(12) != 0 ? ((ByteBuffer) r5.f1900h).getShort(r7 + r5.f1897c) : (short) 0) * this.f158h);
        this.f157g = s6;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s6;
    }
}
