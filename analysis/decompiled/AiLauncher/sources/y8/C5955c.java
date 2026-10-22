package y8;

import android.graphics.Paint;
import android.graphics.Rect;
import v8.C5671a;

/* renamed from: y8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5955c extends C5953a {

    /* renamed from: d, reason: collision with root package name */
    public final io.noties.markwon.image.a f43947d;

    public C5955c(C5671a c5671a, C5963k c5963k, int i10) {
        super(c5671a, c5963k, i10);
        this.f43947d = c5963k;
    }

    @Override // io.noties.markwon.image.e, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.f43947d.h()) {
            return (int) (paint.measureText(charSequence, i10, i11) + 0.5f);
        }
        Rect bounds = this.f43947d.getBounds();
        if (fontMetricsInt != null) {
            int i12 = bounds.bottom / 2;
            int i13 = -i12;
            fontMetricsInt.ascent = i13;
            fontMetricsInt.descent = i12;
            fontMetricsInt.top = i13;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
