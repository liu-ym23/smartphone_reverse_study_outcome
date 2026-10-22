package B8;

import android.R;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class f implements LeadingMarginSpan {
    private static final int[] STATE_CHECKED = {R.attr.state_checked};
    private static final int[] STATE_NONE = new int[0];
    private final Drawable drawable;
    private boolean isDone;
    private final C5671a theme;

    public f(C5671a c5671a, Drawable drawable, boolean z10) {
        this.theme = c5671a;
        this.drawable = drawable;
        this.isDone = z10;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        if (z10 && N8.c.b(i15, charSequence, this)) {
            float fDescent = paint.descent();
            float fAscent = paint.ascent();
            int iSave = canvas.save();
            try {
                this.drawable.setBounds(0, 0, (int) ((this.theme.k() * 0.75f) + 0.5f), (int) ((((int) ((fDescent - fAscent) + 0.5f)) * 0.75f) + 0.5f));
                if (this.drawable.isStateful()) {
                    this.drawable.setState(this.isDone ? STATE_CHECKED : STATE_NONE);
                }
                canvas.translate(i11 > 0 ? i10 + ((r9 - r11) / 2) : (i10 - ((r9 - r11) / 2)) - r11, ((int) (i13 + fAscent + 0.5f)) + ((r6 - r12) / 2));
                this.drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.theme.k();
    }
}
