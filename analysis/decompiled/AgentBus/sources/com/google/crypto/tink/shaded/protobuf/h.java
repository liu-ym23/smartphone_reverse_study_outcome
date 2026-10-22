package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class h implements Iterable, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final g f2209g = new g(z.f2297b);

    /* renamed from: h, reason: collision with root package name */
    public static final e f2210h;

    /* renamed from: f, reason: collision with root package name */
    public int f2211f;

    static {
        f2210h = c.a() ? new e(1) : new e(0);
    }

    public static int f(int i2, int i10, int i11) {
        int i12 = i10 - i2;
        if ((i2 | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a1.a.f(i2, "Beginning index: ", " < 0"));
        }
        if (i10 < i2) {
            throw new IndexOutOfBoundsException(m.x.k("Beginning index larger than ending index: ", i2, i10, ", "));
        }
        throw new IndexOutOfBoundsException(m.x.k("End index: ", i10, i11, " >= "));
    }

    public static g h(byte[] bArr, int i2, int i10) {
        byte[] bArrCopyOfRange;
        f(i2, i2 + i10, bArr.length);
        switch (f2210h.f2202a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i10 + i2);
                break;
            default:
                bArrCopyOfRange = new byte[i10];
                System.arraycopy(bArr, i2, bArrCopyOfRange, 0, i10);
                break;
        }
        return new g(bArrCopyOfRange);
    }

    public abstract byte a(int i2);

    public final int hashCode() {
        int i2 = this.f2211f;
        if (i2 != 0) {
            return i2;
        }
        int size = size();
        g gVar = (g) this;
        int iK = gVar.k();
        int i10 = size;
        for (int i11 = iK; i11 < iK + size; i11++) {
            i10 = (i10 * 31) + gVar.f2207i[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f2211f = i10;
        return i10;
    }

    public abstract void i(int i2, byte[] bArr);

    public final byte[] j() {
        int size = size();
        if (size == 0) {
            return z.f2297b;
        }
        byte[] bArr = new byte[size];
        i(size, bArr);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = ib.k.u(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            g gVar = (g) this;
            int iF = f(0, 47, gVar.size());
            sb2.append(ib.k.u(iF == 0 ? f2209g : new f(gVar.f2207i, gVar.k(), iF)));
            sb2.append("...");
            string = sb2.toString();
        }
        return a1.a.m(a1.a.o("<ByteString@", hexString, " size=", size, " contents=\""), string, "\">");
    }
}
