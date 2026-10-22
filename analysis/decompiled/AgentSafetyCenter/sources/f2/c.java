package f2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements LeadingMarginSpan {
    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i3, int i10, int i11, int i12, CharSequence charSequence, int i13, int i14, boolean z10, Layout layout) {
        int lineForOffset;
        if (layout == null || paint == null || (lineForOffset = layout.getLineForOffset(i13)) != layout.getLineCount() - 1) {
            return;
        }
        e2.h hVar = e2.j.f3449a;
        if (layout.getEllipsisCount(lineForOffset) > 0) {
            float fD = a.a.D(layout, lineForOffset, paint) + a.a.C(layout, lineForOffset, paint);
            if (fD == 0.0f) {
                return;
            }
            canvas.getClass();
            canvas.translate(fD, 0.0f);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z10) {
        return 0;
    }
}
