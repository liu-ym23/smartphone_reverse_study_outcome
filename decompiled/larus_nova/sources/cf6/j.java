package cf6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes20.dex */
public final class j extends e {
    public j(i r100, d r101, long r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(4);
        if (r101.f23514a == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        long r105 = r101.f23515b + (r102 * ((long) r101.f23517d));
        this.f23520a = r100.d(r103, r105);
        this.f23521b = r100.d(r103, 4 + r105);
        this.f23522c = r100.d(r103, 8 + r105);
        this.f23523d = r100.d(r103, r105 + 20);
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
