package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public b() {
    }

    public static b h(ByteBuffer r10) {
        return i(r10, new b());
    }

    public static b i(ByteBuffer r10, b r11) {
        r10.order(ByteOrder.LITTLE_ENDIAN);
        return r11.f(r10.getInt(r10.position()) + r10.position(), r10);
    }

    public b f(int r10, ByteBuffer r11) {
        g(r10, r11);
        return this;
    }

    public void g(int r10, ByteBuffer r11) {
        c(r10, r11);
    }

    public a j(a r10, int r11) {
        int r12 = b(6);
        if (r12 != 0) goto L7;
        return null;
    L7:
        return r10.f(a(d(r12) + (r11 * 4)), this.f3077b);
    }

    public int k() {
        int r10 = b(6);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return e(r10);
    }

    public int l() {
        int r10 = b(4);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getInt(r10 + this.f3076a);
    }
}
