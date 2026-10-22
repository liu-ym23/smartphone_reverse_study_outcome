package u6;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class p {
    public static int a(int i8, int i9, int i10) throws IOException {
        if ((i9 & 8) != 0) {
            i8--;
        }
        if (i10 <= i8) {
            return i8 - i10;
        }
        throw new IOException(a8.b.i(i10, i8, "PROTOCOL_ERROR padding ", " > remaining length "));
    }
}
