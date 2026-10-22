package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    private final o f10348b;

    /* renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f10347a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    private short f10349c = -1;

    /* renamed from: d, reason: collision with root package name */
    private short f10350d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f10351e = 1.0f;

    i(o oVar) {
        D.h.f(oVar, "rasterizer cannot be null");
        this.f10348b = oVar;
    }

    public final o a() {
        return this.f10348b;
    }

    final int b() {
        return this.f10349c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f10347a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f10347a;
        this.f10351e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f10348b.e();
        this.f10350d = (short) (this.f10348b.e() * this.f10351e);
        short sI = (short) (this.f10348b.i() * this.f10351e);
        this.f10349c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f10347a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
