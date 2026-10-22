package x8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class f extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f43585a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f43586b = g.b();

    /* renamed from: c, reason: collision with root package name */
    public final Paint f43587c = g.a();

    /* renamed from: d, reason: collision with root package name */
    public final int f43588d;

    public f(C5671a c5671a, int i10) {
        this.f43585a = c5671a;
        this.f43588d = i10;
    }

    public final void a(TextPaint textPaint) {
        this.f43585a.e(textPaint, this.f43588d);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = this.f43588d;
        if ((i17 == 1 || i17 == 2) && N8.c.a(i16, charSequence, this)) {
            this.f43587c.set(paint);
            this.f43585a.d(this.f43587c);
            float strokeWidth = this.f43587c.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i18 = (int) ((i14 - strokeWidth) + 0.5f);
                if (i11 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i10;
                    i10 -= canvas.getWidth();
                }
                this.f43586b.set(i10, i18, width, i14);
                canvas.drawRect(this.f43586b, this.f43587c);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
