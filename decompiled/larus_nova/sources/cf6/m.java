package cf6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes20.dex */
public final class m extends f {
    public m(i r100, d r101) throws IOException {
        ByteBuffer r102 = ByteBuffer.allocate(8);
        if (r101.f23514a == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        this.f23524a = r100.d(r102, (r101.f23516c + ((long) (0 * r101.f23519f))) + 44);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
