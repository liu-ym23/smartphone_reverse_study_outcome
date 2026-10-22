package N8;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import x8.j;
import x8.k;

/* loaded from: classes4.dex */
public abstract class f {
    public static int a(Canvas canvas, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Layout layoutC = j.c(spanned);
            if (layoutC != null) {
                return layoutC.getWidth();
            }
            TextView textViewC = k.c(spanned);
            if (textViewC != null) {
                return (textViewC.getWidth() - textViewC.getPaddingLeft()) - textViewC.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }
}
