package cf6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes20.dex */
public final class k extends e {
    public k(i r100, d r101, long r102) throws IOException {
        ByteBuffer r103 = ByteBuffer.allocate(8);
        if (r101.f23514a == false) goto L5;
        ByteOrder r104 = ByteOrder.BIG_ENDIAN;
    L6:
        r103.order(r104);
        long r105 = r101.f23515b + (r102 * ((long) r101.f23517d));
        this.f23520a = r100.d(r103, r105);
        r100.b(r103, 8 + r105, 8);
        this.f23521b = r103.getLong();
        r100.b(r103, 16 + r105, 8);
        this.f23522c = r103.getLong();
        r100.b(r103, r105 + 40, 8);
        this.f23523d = r103.getLong();
        return;
    L5:
        r104 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
