package hd;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {
    public static int a(int i, int i3, int i10) throws IOException {
        if ((i3 & 8) != 0) {
            i--;
        }
        if (i10 <= i) {
            return i - i10;
        }
        od.f.l(androidx.activity.b.i("PROTOCOL_ERROR padding ", i10, " > remaining length ", i));
        return 0;
    }
}
