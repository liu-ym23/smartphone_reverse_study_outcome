package f2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends ReplacementSpan {

    /* renamed from: c, reason: collision with root package name */
    public Paint.FontMetricsInt f3888c;

    /* renamed from: f, reason: collision with root package name */
    public int f3889f;

    /* renamed from: g, reason: collision with root package name */
    public int f3890g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3891h;

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f3888c;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        yb.k.f("fontMetrics");
        throw null;
    }

    public final int b() {
        if (!this.f3891h) {
            i2.a.b("PlaceholderSpan is not laid out yet.");
        }
        return this.f3890g;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i3, Paint.FontMetricsInt fontMetricsInt) {
        this.f3891h = true;
        paint.getTextSize();
        this.f3888c = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            i2.a.a("Invalid fontMetrics: line height can not be negative.");
        }
        this.f3889f = (int) Math.ceil(0.0f);
        this.f3890g = (int) Math.ceil(0.0f);
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
        if (!this.f3891h) {
            i2.a.b("PlaceholderSpan is not laid out yet.");
        }
        return this.f3889f;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i3, float f5, int i10, int i11, int i12, Paint paint) {
    }
}
