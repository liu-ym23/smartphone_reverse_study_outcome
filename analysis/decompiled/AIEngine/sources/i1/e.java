package i1;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final g f9435b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f9434a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public short f9436c = -1;

    /* renamed from: d, reason: collision with root package name */
    public float f9437d = 1.0f;

    public e(g gVar) {
        y.n(gVar, "rasterizer cannot be null");
        this.f9435b = gVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f9434a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        g gVar = this.f9435b;
        this.f9437d = fAbs / (gVar.b().a(14) != 0 ? r8.f9653b.getShort(r1 + r8.f9652a) : (short) 0);
        j1.a aVarB = gVar.b();
        int iA = aVarB.a(14);
        if (iA != 0) {
            aVarB.f9653b.getShort(iA + aVarB.f9652a);
        }
        short s8 = (short) ((gVar.b().a(12) != 0 ? r5.f9653b.getShort(r7 + r5.f9652a) : (short) 0) * this.f9437d);
        this.f9436c = s8;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s8;
    }
}
