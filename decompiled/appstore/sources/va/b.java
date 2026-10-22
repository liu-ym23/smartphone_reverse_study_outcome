package va;

import bg.h;
import java.io.EOFException;
import kotlin.jvm.internal.q;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final boolean a(Buffer r10) {
        q.g(r10, "<this>");
        Buffer r11 = new Buffer();     // Catch: EOFException -> L17
        r10.d(r11, 0, h.h(r10.size(), 64));     // Catch: EOFException -> L17
        int r12 = 0;
    L5:
        if (r12 >= 16) goto L25;
        if (r11.exhausted() == true) goto L15;
        int r13 = r11.readUtf8CodePoint();     // Catch: EOFException -> L17
        if (Character.isISOControl(r13) == false) goto L14;
        if (Character.isWhitespace(r13) == true) goto L14;
        return false;
    L14:
        r12 = r12 + 1;
        goto L5
    L15:
        return true;
    L25:
        return true;
    L17:
        return false;
    }
}
