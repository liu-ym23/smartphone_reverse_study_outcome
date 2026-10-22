package com.google.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString b = new LiteralByteString(AbstractC0989s1.c);
    public static final C0956k c;

    /* renamed from: a, reason: collision with root package name */
    public int f2758a = 0;

    public static final class BoundedByteString extends LiteralByteString {
        public final int e;
        public final int f;

        public BoundedByteString(byte[] bArr, int i, int i6) {
            super(bArr);
            ByteString.c(i, i + i6, bArr.length);
            this.e = i;
            this.f = i6;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public final byte b(int i) {
            int i6 = this.f;
            if (((i6 - (i + 1)) | i) >= 0) {
                return this.d[this.e + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(B7.a.h(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(androidx.compose.foundation.b.n(i, i6, "Index > length: ", ", "));
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public final void g(int i, byte[] bArr) {
            System.arraycopy(this.d, this.e, bArr, 0, i);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public final byte h(int i) {
            return this.d[this.e + i];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public final int s() {
            return this.e;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public final int size() {
            return this.f;
        }

        public Object writeReplace() {
            return new LiteralByteString(o());
        }
    }

    public static abstract class LeafByteString extends ByteString {
        @Override // java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new H8.q(this);
        }
    }

    public static class LiteralByteString extends LeafByteString {
        public final byte[] d;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.d = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public byte b(int i) {
            return this.d[i];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int i = this.f2758a;
            int i6 = literalByteString.f2758a;
            if (i != 0 && i6 != 0 && i != i6) {
                return false;
            }
            int size = size();
            if (size > literalByteString.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            if (size > literalByteString.size()) {
                StringBuilder sbU = B7.a.u(size, "Ran off end of other: 0, ", ", ");
                sbU.append(literalByteString.size());
                throw new IllegalArgumentException(sbU.toString());
            }
            byte[] bArr = literalByteString.d;
            int iS = s() + size;
            int iS2 = s();
            int iS3 = literalByteString.s();
            while (iS2 < iS) {
                if (this.d[iS2] != bArr[iS3]) {
                    return false;
                }
                iS2++;
                iS3++;
            }
            return true;
        }

        @Override // com.google.protobuf.ByteString
        public void g(int i, byte[] bArr) {
            System.arraycopy(this.d, 0, bArr, 0, i);
        }

        @Override // com.google.protobuf.ByteString
        public byte h(int i) {
            return this.d[i];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean i() {
            int iS = s();
            return Y2.f2904a.C(this.d, iS, size() + iS);
        }

        @Override // com.google.protobuf.ByteString
        public final AbstractC0972o j() {
            return AbstractC0972o.h(this.d, s(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final int l(int i, int i6) {
            int iS = s();
            Charset charset = AbstractC0989s1.f2940a;
            for (int i10 = iS; i10 < iS + i6; i10++) {
                i = (i * 31) + this.d[i10];
            }
            return i;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString n(int i, int i6) {
            int iC = ByteString.c(i, i6, size());
            if (iC == 0) {
                return ByteString.b;
            }
            return new BoundedByteString(this.d, s() + i, iC);
        }

        @Override // com.google.protobuf.ByteString
        public final String p(Charset charset) {
            return new String(this.d, s(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void r(C0980q c0980q) {
            c0980q.V(this.d, s(), size());
        }

        public int s() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.d.length;
        }
    }

    static {
        c = AbstractC0944h.a() ? new C0956k(1) : new C0956k(0);
    }

    public static int c(int i, int i6, int i10) {
        int i11 = i6 - i;
        if ((i | i6 | i11 | (i10 - i6)) >= 0) {
            return i11;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(androidx.appfunctions.metadata.a.i(i, "Beginning index: ", " < 0"));
        }
        if (i6 < i) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.n(i, i6, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(androidx.compose.foundation.b.n(i6, i10, "End index: ", " >= "));
    }

    public static ByteString e(byte[] bArr, int i, int i6) {
        byte[] bArrCopyOfRange;
        c(i, i + i6, bArr.length);
        switch (c.f2926a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i6 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i6];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i6);
                break;
        }
        return new LiteralByteString(bArrCopyOfRange);
    }

    public static ByteString f(String str) {
        return new LiteralByteString(str.getBytes(AbstractC0989s1.f2940a));
    }

    public abstract byte b(int i);

    public abstract boolean equals(Object obj);

    public abstract void g(int i, byte[] bArr);

    public abstract byte h(int i);

    public final int hashCode() {
        int iL = this.f2758a;
        if (iL == 0) {
            int size = size();
            iL = l(size, size);
            if (iL == 0) {
                iL = 1;
            }
            this.f2758a = iL;
        }
        return iL;
    }

    public abstract boolean i();

    public abstract AbstractC0972o j();

    public abstract int l(int i, int i6);

    public abstract ByteString n(int i, int i6);

    public final byte[] o() {
        int size = size();
        if (size == 0) {
            return AbstractC0989s1.c;
        }
        byte[] bArr = new byte[size];
        g(size, bArr);
        return bArr;
    }

    public abstract String p(Charset charset);

    public final String q() {
        return size() == 0 ? "" : p(AbstractC0989s1.f2940a);
    }

    public abstract void r(C0980q c0980q);

    public abstract int size();

    public final String toString() {
        String strU;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strU = AbstractC1002v2.u(this);
        } else {
            strU = AbstractC1002v2.u(n(0, 47)) + "...";
        }
        return B7.a.q(androidx.appfunctions.metadata.a.t(size, "<ByteString@", hexString, " size=", " contents=\""), strU, "\">");
    }
}
