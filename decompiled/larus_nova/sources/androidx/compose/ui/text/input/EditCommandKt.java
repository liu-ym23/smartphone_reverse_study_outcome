package androidx.compose.ui.text.input;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"isSurrogatePair", "", "high", "", "low", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditCommandKt {
    public static final /* synthetic */ boolean access$isSurrogatePair(char r100, char r101) {
        return isSurrogatePair(r100, r101);
    }

    private static final boolean isSurrogatePair(char r100, char r101) {
        if (Character.isHighSurrogate(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (Character.isLowSurrogate(r101) == false) goto L7;
        return true;
    }
}
