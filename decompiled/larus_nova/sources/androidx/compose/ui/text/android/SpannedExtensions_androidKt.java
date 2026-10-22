package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"hasSpan", "", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "startInclusive", "", "endExclusive", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpannedExtensions_androidKt {
    public static final boolean hasSpan(Spanned r100, Class<?> r101) {
        if (r100.nextSpanTransition(-1, r100.length(), r101) == r100.length()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean hasSpan(Spanned r100, Class<?> r101, int r102, int r103) {
        if (r100.nextSpanTransition(r102 - 1, r103, r101) != r103) goto L7;
        return false;
    L7:
        return true;
    }
}
