package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¨\u0006\t"}, d2 = {"toCharArray", "", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "", "destinationOffset", "", "startIndex", "endIndex", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ToCharArray_androidKt {
    public static final void toCharArray(CharSequence r100, char[] r101, int r102, int r103, int r104) {
        if ((r100 instanceof TextFieldCharSequence) == false) goto L5;
        ((TextFieldCharSequence) r100).toCharArray(r101, r102, r103, r104);
        return;
    L5:
        if (r103 >= r104) goto L9;
        r101[r102] = r100.charAt(r103);
        r103 = r103 + 1;
        r102 = r102 + 1;
        goto L5
    }
}
