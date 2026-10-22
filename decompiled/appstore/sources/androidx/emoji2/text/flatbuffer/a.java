package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public a() {
    }

    public a f(int r10, ByteBuffer r11) {
        g(r10, r11);
        return this;
    }

    public void g(int r10, ByteBuffer r11) {
        c(r10, r11);
    }

    public int h(int r10) {
        int r11 = b(16);
        if (r11 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getInt(d(r11) + (r10 * 4));
    }

    public int i() {
        int r10 = b(16);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return e(r10);
    }

    public boolean j() {
        int r10 = b(6);
        if (r10 != 0) goto L5;
        return false;
    L5:
        if (this.f3077b.get(r10 + this.f3076a) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public short k() {
        int r10 = b(14);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getShort(r10 + this.f3076a);
    }

    public int l() {
        int r10 = b(4);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getInt(r10 + this.f3076a);
    }

    public short m() {
        int r10 = b(8);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getShort(r10 + this.f3076a);
    }

    public short n() {
        int r10 = b(12);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f3077b.getShort(r10 + this.f3076a);
    }
}
