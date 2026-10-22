package u1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes.dex */
public final class c implements LeadingMarginSpan {
    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14, int i15, boolean z4, Layout layout) {
        int lineForOffset;
        if (layout == null || paint == null || (lineForOffset = layout.getLineForOffset(i14)) != layout.getLineCount() - 1) {
            return;
        }
        t1.g gVar = t1.i.f9703a;
        if (layout.getEllipsisCount(lineForOffset) > 0) {
            float fK = n7.a.k(layout, lineForOffset, paint) + n7.a.j(layout, lineForOffset, paint);
            if (fK == 0.0f) {
                return;
            }
            q7.k.b(canvas);
            canvas.translate(fK, 0.0f);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z4) {
        return 0;
    }
}
