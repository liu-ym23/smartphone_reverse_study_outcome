package Q;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a extends c {
    public a f(int i5, ByteBuffer byteBuffer) {
        g(i5, byteBuffer);
        return this;
    }

    public void g(int i5, ByteBuffer byteBuffer) {
        c(i5, byteBuffer);
    }

    public int h(int i5) {
        int iB = b(16);
        if (iB != 0) {
            return this.f4862b.getInt(d(iB) + (i5 * 4));
        }
        return 0;
    }

    public int i() {
        int iB = b(16);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public boolean j() {
        int iB = b(6);
        return (iB == 0 || this.f4862b.get(iB + this.f4861a) == 0) ? false : true;
    }

    public short k() {
        int iB = b(14);
        if (iB != 0) {
            return this.f4862b.getShort(iB + this.f4861a);
        }
        return (short) 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f4862b.getInt(iB + this.f4861a);
        }
        return 0;
    }

    public short m() {
        int iB = b(8);
        if (iB != 0) {
            return this.f4862b.getShort(iB + this.f4861a);
        }
        return (short) 0;
    }

    public short n() {
        int iB = b(12);
        if (iB != 0) {
            return this.f4862b.getShort(iB + this.f4861a);
        }
        return (short) 0;
    }
}
