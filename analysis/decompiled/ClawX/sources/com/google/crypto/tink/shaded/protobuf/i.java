package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final h f1465b = new h(a0.f1429b);

    /* renamed from: c, reason: collision with root package name */
    public static final f f1466c;

    /* renamed from: a, reason: collision with root package name */
    public int f1467a;

    static {
        f1466c = c.a() ? new f(1) : new f(0);
    }

    public static int g(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException(a8.b.k(i8, "Beginning index: ", " < 0"));
        }
        if (i9 < i8) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(a8.b.i(i9, i10, "End index: ", " >= "));
    }

    public static h h(int i8, int i9, byte[] bArr) {
        byte[] bArrCopyOfRange;
        g(i8, i8 + i9, bArr.length);
        switch (f1466c.f1459a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i8, i9 + i8);
                break;
            default:
                bArrCopyOfRange = new byte[i9];
                System.arraycopy(bArr, i8, bArrCopyOfRange, 0, i9);
                break;
        }
        return new h(bArrCopyOfRange);
    }

    public abstract byte f(int i8);

    public final int hashCode() {
        int i8 = this.f1467a;
        if (i8 != 0) {
            return i8;
        }
        int size = size();
        h hVar = (h) this;
        int iK = hVar.k();
        int i9 = size;
        for (int i10 = iK; i10 < iK + size; i10++) {
            i9 = (i9 * 31) + hVar.d[i10];
        }
        if (i9 == 0) {
            i9 = 1;
        }
        this.f1467a = i9;
        return i9;
    }

    public abstract void i(byte[] bArr, int i8);

    public final byte[] j() {
        int size = size();
        if (size == 0) {
            return a0.f1429b;
        }
        byte[] bArr = new byte[size];
        i(bArr, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = a.a.G(this);
        } else {
            StringBuilder sb = new StringBuilder();
            h hVar = (h) this;
            int iG = g(0, 47, hVar.size());
            sb.append(a.a.G(iG == 0 ? f1465b : new g(hVar.d, hVar.k(), iG)));
            sb.append("...");
            string = sb.toString();
        }
        return m0.f.f(a8.b.u("<ByteString@", size, hexString, " size=", " contents=\""), string, "\">");
    }
}
