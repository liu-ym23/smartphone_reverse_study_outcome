package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¨\u0006\t"}, d2 = {"toCharArray", "", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "", "destinationOffset", "", "startIndex", "endIndex", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GapBuffer_jvmKt {
    public static final void toCharArray(String r100, char[] r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        r100.getChars(r103, r104, r101, r102);
    }
}
