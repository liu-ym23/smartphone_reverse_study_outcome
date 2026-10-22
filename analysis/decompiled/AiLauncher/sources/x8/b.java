package x8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class b implements LeadingMarginSpan {

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f43575f = false;

    /* renamed from: a, reason: collision with root package name */
    public C5671a f43576a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f43577b = g.a();

    /* renamed from: c, reason: collision with root package name */
    public final RectF f43578c = g.c();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f43579d = g.b();

    /* renamed from: e, reason: collision with root package name */
    public final int f43580e;

    public b(C5671a c5671a, int i10) {
        this.f43576a = c5671a;
        this.f43580e = i10;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iMin;
        int iMax;
        if (z10 && N8.c.b(i15, charSequence, this)) {
            this.f43577b.set(paint);
            this.f43576a.h(this.f43577b);
            int iSave = canvas.save();
            try {
                int iK = this.f43576a.k();
                int iM = this.f43576a.m((int) ((this.f43577b.descent() - this.f43577b.ascent()) + 0.5f));
                int i17 = (iK - iM) / 2;
                if (f43575f) {
                    int width = i11 < 0 ? i10 - (layout.getWidth() - (iK * this.f43580e)) : (iK * this.f43580e) - i10;
                    int i18 = i10 + (i17 * i11);
                    int i19 = (i11 * iM) + i18;
                    int i20 = i11 * width;
                    iMin = Math.min(i18, i19) + i20;
                    iMax = Math.max(i18, i19) + i20;
                } else {
                    if (i11 <= 0) {
                        i10 -= iK;
                    }
                    iMin = i10 + i17;
                    iMax = iMin + iM;
                }
                int iDescent = (i13 + ((int) (((this.f43577b.descent() + this.f43577b.ascent()) / 2.0f) + 0.5f))) - (iM / 2);
                int i21 = iM + iDescent;
                int i22 = this.f43580e;
                if (i22 == 0 || i22 == 1) {
                    this.f43578c.set(iMin, iDescent, iMax, i21);
                    this.f43577b.setStyle(this.f43580e == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.f43578c, this.f43577b);
                } else {
                    this.f43579d.set(iMin, iDescent, iMax, i21);
                    this.f43577b.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.f43579d, this.f43577b);
                }
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f43576a.k();
    }
}
