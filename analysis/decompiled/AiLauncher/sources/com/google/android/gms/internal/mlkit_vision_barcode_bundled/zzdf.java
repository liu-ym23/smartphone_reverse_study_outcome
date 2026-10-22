package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class zzdf implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzdf f20159b = new zzde(N0.f20039b);

    /* renamed from: a, reason: collision with root package name */
    public int f20160a = 0;

    static {
        int i10 = W.f20062a;
    }

    public static zzdf A(byte[] bArr, int i10, int i11) {
        x(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new zzde(bArr2);
    }

    public static zzdf C(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = inputStream.read(bArr, i10, iMin - i10);
                if (i11 == -1) {
                    break;
                }
                i10 += i11;
            }
            zzdf zzdfVarA = i10 == 0 ? null : A(bArr, 0, i10);
            if (zzdfVarA == null) {
                break;
            }
            arrayList.add(zzdfVarA);
            iMin = Math.min(iMin + iMin, com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        }
        int size = arrayList.size();
        return size == 0 ? f20159b : e(arrayList.iterator(), size);
    }

    public static void G(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    public static zzdf e(Iterator it, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i10)));
        }
        if (i10 == 1) {
            return (zzdf) it.next();
        }
        int i11 = i10 >>> 1;
        zzdf zzdfVarE = e(it, i11);
        zzdf zzdfVarE2 = e(it, i10 - i11);
        if (Integer.MAX_VALUE - zzdfVarE.f() >= zzdfVarE2.f()) {
            return zzgd.O(zzdfVarE, zzdfVarE2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + zzdfVarE.f() + "+" + zzdfVarE2.f());
    }

    public static int x(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        }
        throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
    }

    public final String D() {
        return f() == 0 ? "" : t(N0.f20038a);
    }

    @Deprecated
    public final void H(byte[] bArr, int i10, int i11, int i12) {
        x(0, i12, f());
        x(i11, i11 + i12, bArr.length);
        if (i12 > 0) {
            i(bArr, 0, i11, i12);
        }
    }

    public final byte[] J() {
        int iF = f();
        if (iF == 0) {
            return N0.f20039b;
        }
        byte[] bArr = new byte[iF];
        i(bArr, 0, 0, iF);
        return bArr;
    }

    public abstract byte b(int i10);

    public abstract byte c(int i10);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public final int hashCode() {
        int iL = this.f20160a;
        if (iL == 0) {
            int iF = f();
            iL = l(iF, 0, iF);
            if (iL == 0) {
                iL = 1;
            }
            this.f20160a = iL;
        }
        return iL;
    }

    public abstract void i(byte[] bArr, int i10, int i11, int i12);

    public abstract int j();

    public abstract boolean k();

    public abstract int l(int i10, int i11, int i12);

    public abstract int m(int i10, int i11, int i12);

    public abstract zzdf n(int i10, int i11);

    public abstract String t(Charset charset);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(f()), f() <= 50 ? L1.a(this) : L1.a(n(0, 47)).concat("..."));
    }

    public abstract void u(C1686a0 c1686a0) throws IOException;

    public abstract boolean v();

    public final int y() {
        return this.f20160a;
    }

    @Override // java.lang.Iterable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public InterfaceC1706e0 iterator() {
        return new C1691b0(this);
    }
}
