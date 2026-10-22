package x8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import v8.C5671a;

/* loaded from: classes4.dex */
public class h implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f43592a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43593b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f43594c = g.a();

    /* renamed from: d, reason: collision with root package name */
    public int f43595d;

    public h(C5671a c5671a, String str) {
        this.f43592a = c5671a;
        this.f43593b = str;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            h[] hVarArr = (h[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), h.class);
            if (hVarArr != null) {
                TextPaint paint = textView.getPaint();
                for (h hVar : hVarArr) {
                    hVar.f43595d = (int) (paint.measureText(hVar.f43593b) + 0.5f);
                }
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        if (z10 && N8.c.b(i15, charSequence, this)) {
            this.f43594c.set(paint);
            this.f43592a.h(this.f43594c);
            int iMeasureText = (int) (this.f43594c.measureText(this.f43593b) + 0.5f);
            int iK = this.f43592a.k();
            if (iMeasureText > iK) {
                this.f43595d = iMeasureText;
                iK = iMeasureText;
            } else {
                this.f43595d = 0;
            }
            canvas.drawText(this.f43593b, i11 > 0 ? (i10 + (iK * i11)) - iMeasureText : i10 + (i11 * iK) + (iK - iMeasureText), i13, this.f43594c);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return Math.max(this.f43595d, this.f43592a.k());
    }
}
