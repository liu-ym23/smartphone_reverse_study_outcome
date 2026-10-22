package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"codePointAt", "", "", "index", "charCount", "codePoint", "codePointBefore", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CodepointHelpers_jvmKt {
    public static final int charCount(int r100) {
        return Character.charCount(r100);
    }

    public static final int codePointAt(CharSequence r100, int r101) {
        return Character.codePointAt(r100, r101);
    }

    public static final int codePointBefore(CharSequence r100, int r101) {
        return Character.codePointBefore(r100, r101);
    }
}
