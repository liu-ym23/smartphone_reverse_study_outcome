package com.google.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class l implements Iterable, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final k f2424g = new k(p2.f2496b);

    /* renamed from: h, reason: collision with root package name */
    public static final i f2425h;

    /* renamed from: f, reason: collision with root package name */
    public int f2426f;

    static {
        f2425h = e.a() ? new i(1) : new i(0);
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

    public static k h(byte[] bArr, int i2, int i10) {
        byte[] bArrCopyOfRange;
        f(i2, i2 + i10, bArr.length);
        switch (f2425h.f2392a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i10 + i2);
                break;
            default:
                bArrCopyOfRange = new byte[i10];
                System.arraycopy(bArr, i2, bArrCopyOfRange, 0, i10);
                break;
        }
        return new k(bArrCopyOfRange);
    }

    public static k i(String str) {
        return new k(str.getBytes(p2.f2495a));
    }

    public abstract byte a(int i2);

    public final int hashCode() {
        int i2 = this.f2426f;
        if (i2 != 0) {
            return i2;
        }
        int size = size();
        k kVar = (k) this;
        int iK = kVar.k();
        int i10 = size;
        for (int i11 = iK; i11 < iK + size; i11++) {
            i10 = (i10 * 31) + kVar.f2418i[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f2426f = i10;
        return i10;
    }

    public abstract void j(int i2, byte[] bArr);

    public abstract int size();

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = ib.k.v(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            k kVar = (k) this;
            int iF = f(0, 47, kVar.size());
            sb2.append(ib.k.v(iF == 0 ? f2424g : new j(kVar.f2418i, kVar.k(), iF)));
            sb2.append("...");
            string = sb2.toString();
        }
        return a1.a.m(a1.a.o("<ByteString@", hexString, " size=", size, " contents=\""), string, "\">");
    }
}
