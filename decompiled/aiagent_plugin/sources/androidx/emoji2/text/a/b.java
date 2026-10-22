package androidx.emoji2.text.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: MetadataList.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public b() {
    }

    public static b a(ByteBuffer r1) {
        return a(r1, new b());
    }

    public static b a(ByteBuffer r2, b r3) {
        r2.order(ByteOrder.LITTLE_ENDIAN);
        return r3.b(r2.getInt(r2.position()) + r2.position(), r2);
    }

    public void a(int r1, ByteBuffer r2) {
        c(r1, r2);
    }

    public b b(int r1, ByteBuffer r2) {
        a(r1, r2);
        return this;
    }

    public int a() {
        int r0 = b(4);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.f1609b.getInt(r0 + this.f1608a);
    }

    public a a(a r2, int r3) {
        int r0 = b(6);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return r2.b(c(e(r0) + (r3 * 4)), this.f1609b);
    }

    public int b() {
        int r0 = b(6);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return d(r0);
    }
}
