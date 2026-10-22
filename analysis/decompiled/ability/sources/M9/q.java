package M9;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class q {
    public static int a(int i, int i6, int i10) throws IOException {
        if ((i6 & 8) != 0) {
            i--;
        }
        if (i10 <= i) {
            return i - i10;
        }
        throw new IOException(androidx.compose.foundation.b.n(i10, i, "PROTOCOL_ERROR padding ", " > remaining length "));
    }
}
