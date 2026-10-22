package x8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import v8.C5671a;

/* renamed from: x8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5855a implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f43572a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f43573b = g.b();

    /* renamed from: c, reason: collision with root package name */
    public final Paint f43574c = g.a();

    public C5855a(C5671a c5671a) {
        this.f43572a = c5671a;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iL = this.f43572a.l();
        this.f43574c.set(paint);
        this.f43572a.a(this.f43574c);
        int i17 = i11 * iL;
        int i18 = i10 + i17;
        int i19 = i17 + i18;
        this.f43573b.set(Math.min(i18, i19), i12, Math.max(i18, i19), i14);
        canvas.drawRect(this.f43573b, this.f43574c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f43572a.k();
    }
}
