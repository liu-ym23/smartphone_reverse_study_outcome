package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f1717b = new LiteralByteString(u.f1889b);

    /* renamed from: c, reason: collision with root package name */
    public static final c f1718c;

    /* renamed from: a, reason: collision with root package name */
    public int f1719a = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class LeafByteString extends ByteString {
        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new g(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class LiteralByteString extends LeafByteString {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f1720d;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f1720d = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte a(int i10) {
            return this.f1720d[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte c(int i10) {
            return this.f1720d[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean d() {
            int iH = h();
            return Utf8.f1765a.c(this.f1720d, iH, size() + iH) == 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int e(int i10, int i11) {
            int iH = h();
            Charset charset = u.f1888a;
            for (int i12 = iH; i12 < iH + i11; i12++) {
                i10 = (i10 * 31) + this.f1720d[i12];
            }
            return i10;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
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
            int i10 = this.f1719a;
            int i11 = literalByteString.f1719a;
            if (i10 != 0 && i11 != 0 && i10 != i11) {
                return false;
            }
            int size = size();
            if (size > literalByteString.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            if (size > literalByteString.size()) {
                StringBuilder sbK = com.stepos.core.ota.d.k(size, "Ran off end of other: 0, ", ", ");
                sbK.append(literalByteString.size());
                throw new IllegalArgumentException(sbK.toString());
            }
            byte[] bArr = literalByteString.f1720d;
            int iH = h() + size;
            int iH2 = h();
            int iH3 = literalByteString.h();
            while (iH2 < iH) {
                if (this.f1720d[iH2] != bArr[iH3]) {
                    return false;
                }
                iH2++;
                iH3++;
            }
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String f(Charset charset) {
            return new String(this.f1720d, h(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void g(CodedOutputStream codedOutputStream) {
            codedOutputStream.j(this.f1720d, h(), size());
        }

        public int h() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f1720d.length;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a implements Iterator {
        @Override // java.util.Iterator
        public final Object next() {
            g gVar = (g) this;
            int i10 = gVar.f1812a;
            if (i10 >= gVar.f1813b) {
                throw new NoSuchElementException();
            }
            gVar.f1812a = i10 + 1;
            return Byte.valueOf(gVar.f1814c.c(i10));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements c {
        @Override // androidx.datastore.preferences.protobuf.ByteString.c
        public final byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements c {
        @Override // androidx.datastore.preferences.protobuf.ByteString.c
        public final byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }
    }

    static {
        f1718c = androidx.datastore.preferences.protobuf.d.a() ? new d() : new b();
    }

    public static ByteString b(byte[] bArr, int i10, int i11) {
        int i12 = i10 + i11;
        int length = bArr.length;
        if (((i12 - i10) | i10 | i12 | (length - i12)) >= 0) {
            return new LiteralByteString(f1718c.a(bArr, i10, i11));
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(ai.onnxruntime.a.g(i10, "Beginning index: ", " < 0"));
        }
        if (i12 < i10) {
            throw new IndexOutOfBoundsException(a0.a.f("Beginning index larger than ending index: ", i10, i12, ", "));
        }
        throw new IndexOutOfBoundsException(a0.a.f("End index: ", i12, length, " >= "));
    }

    public abstract byte a(int i10);

    public abstract byte c(int i10);

    public abstract boolean d();

    public abstract int e(int i10, int i11);

    public abstract boolean equals(Object obj);

    public abstract String f(Charset charset);

    public abstract void g(CodedOutputStream codedOutputStream);

    public final int hashCode() {
        int iE = this.f1719a;
        if (iE == 0) {
            int size = size();
            iE = e(size, size);
            if (iE == 0) {
                iE = 1;
            }
            this.f1719a = iE;
        }
        return iE;
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new g(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
