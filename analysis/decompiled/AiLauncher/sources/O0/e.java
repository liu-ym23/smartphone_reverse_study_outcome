package O0;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class e extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final i f5137b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f5136a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public short f5138c = -1;

    /* renamed from: d, reason: collision with root package name */
    public short f5139d = -1;

    /* renamed from: e, reason: collision with root package name */
    public float f5140e = 1.0f;

    public e(i iVar) {
        B0.h.g(iVar, "rasterizer cannot be null");
        this.f5137b = iVar;
    }

    public final i a() {
        return this.f5137b;
    }

    public final int b() {
        return this.f5138c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f5136a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f5136a;
        this.f5140e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f5137b.e();
        this.f5139d = (short) (this.f5137b.e() * this.f5140e);
        short sI = (short) (this.f5137b.i() * this.f5140e);
        this.f5138c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f5136a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
