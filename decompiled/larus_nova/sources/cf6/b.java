package cf6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes20.dex */
public final class b extends c {
    public b(i r100, d r101, long r102, int r103) throws IOException {
        ByteBuffer r104 = ByteBuffer.allocate(8);
        if (r101.f23514a == false) goto L5;
        ByteOrder r105 = ByteOrder.BIG_ENDIAN;
    L6:
        r104.order(r105);
        long r106 = r102 + ((long) (r103 * 16));
        r100.b(r104, r106, 8);
        this.f23512a = r104.getLong();
        r100.b(r104, r106 + 8, 8);
        this.f23513b = r104.getLong();
        return;
    L5:
        r105 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
