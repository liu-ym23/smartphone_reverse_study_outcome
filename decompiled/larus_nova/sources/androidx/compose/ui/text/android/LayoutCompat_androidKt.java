package androidx.compose.ui.text.android;

import android.text.Layout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"getLineForOffset", "", "Landroid/text/Layout;", "offset", "upstream", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutCompat_androidKt {
    public static final int getLineForOffset(Layout r100, int r101, boolean r102) {
        if (r101 > 0) goto L6;
        return 0;
    L6:
        if (r101 >= r100.getText().length()) goto L8;
        int r103 = r100.getLineForOffset(r101);
        int r104 = r100.getLineStart(r103);
        int r105 = r100.getLineEnd(r103);
        if (r104 == r101) goto L13;
        if (r105 == r101) goto L13;
        return r103;
    L13:
        if (r104 != r101) goto L16;
        if (r102 == true) goto L21;
        return r103;
    L21:
        return r103 - 1;
    L16:
        if (r102 == false) goto L19;
        return r103;
    L19:
        return r103 + 1;
    L8:
        return r100.getLineCount() - 1;
    }
}
