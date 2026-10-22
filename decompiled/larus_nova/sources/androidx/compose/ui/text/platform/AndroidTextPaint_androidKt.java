package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint r100, float r101) {
        if (Float.isNaN(r101) == false) goto L5;
        return;
    L5:
        if (r101 >= 0.0f) goto L8;
        r101 = 0.0f;
    L8:
        if (r101 <= 1.0f) goto L10;
        r101 = 1.0f;
    L10:
        r100.setAlpha(Math.round(r101 * 255));
    }
}
