package x8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class l implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f43598a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f43599b = g.b();

    /* renamed from: c, reason: collision with root package name */
    public final Paint f43600c = g.a();

    public l(C5671a c5671a) {
        this.f43598a = c5671a;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = i12 + ((i14 - i12) / 2);
        this.f43600c.set(paint);
        this.f43598a.i(this.f43600c);
        int strokeWidth = (int) ((((int) (this.f43600c.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i11 > 0) {
            width = canvas.getWidth();
        } else {
            width = i10;
            i10 -= canvas.getWidth();
        }
        this.f43599b.set(i10, i17 - strokeWidth, width, i17 + strokeWidth);
        canvas.drawRect(this.f43599b, this.f43600c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return 0;
    }
}
