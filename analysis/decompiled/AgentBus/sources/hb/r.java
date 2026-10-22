package hb;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class r {
    public static int a(int i2, int i10, int i11) throws IOException {
        if ((i10 & 8) != 0) {
            i2--;
        }
        if (i11 <= i2) {
            return i2 - i11;
        }
        throw new IOException(m.x.k("PROTOCOL_ERROR padding ", i11, i2, " > remaining length "));
    }
}
