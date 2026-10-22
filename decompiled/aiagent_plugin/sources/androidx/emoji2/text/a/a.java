package androidx.emoji2.text.a;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: MetadataItem.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public a() {
    }

    public void a(int r1, ByteBuffer r2) {
        c(r1, r2);
    }

    public a b(int r1, ByteBuffer r2) {
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

    public boolean b() {
        int r0 = b(6);
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (this.f1609b.get(r0 + this.f1608a) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public short c() {
        int r0 = b(8);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.f1609b.getShort(r0 + this.f1608a);
    }

    public short d() {
        int r0 = b(12);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.f1609b.getShort(r0 + this.f1608a);
    }

    public short e() {
        int r0 = b(14);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.f1609b.getShort(r0 + this.f1608a);
    }

    public int a(int r3) {
        int r0 = b(16);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.f1609b.getInt(e(r0) + (r3 * 4));
    }

    public int f() {
        int r0 = b(16);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return d(r0);
    }
}
