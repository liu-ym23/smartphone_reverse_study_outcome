package u1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public final class i extends ReplacementSpan {

    /* renamed from: f, reason: collision with root package name */
    public Paint.FontMetricsInt f9949f;

    /* renamed from: g, reason: collision with root package name */
    public int f9950g;

    /* renamed from: h, reason: collision with root package name */
    public int f9951h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9952i;

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f9949f;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        q7.k.j("fontMetrics");
        throw null;
    }

    public final int b() {
        if (!this.f9952i) {
            x1.a.b("PlaceholderSpan is not laid out yet.");
        }
        return this.f9951h;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i10, float f10, int i11, int i12, int i13, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i10, Paint.FontMetricsInt fontMetricsInt) {
        this.f9952i = true;
        paint.getTextSize();
        this.f9949f = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            x1.a.a("Invalid fontMetrics: line height can not be negative.");
        }
        this.f9950g = (int) Math.ceil(0.0f);
        this.f9951h = (int) Math.ceil(0.0f);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            if (fontMetricsInt.ascent > (-b())) {
                fontMetricsInt.ascent = -b();
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        if (!this.f9952i) {
            x1.a.b("PlaceholderSpan is not laid out yet.");
        }
        return this.f9950g;
    }
}
