package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f13407b = new LiteralByteString(C1359w.f13644c);

    /* renamed from: c, reason: collision with root package name */
    public static final e f13408c;

    /* renamed from: d, reason: collision with root package name */
    public static final Comparator<ByteString> f13409d;

    /* renamed from: a, reason: collision with root package name */
    public int f13410a = 0;

    public static final class BoundedByteString extends LiteralByteString {

        /* renamed from: f, reason: collision with root package name */
        public final int f13411f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13412g;

        public BoundedByteString(byte[] bArr, int i10, int i11) {
            super(bArr);
            ByteString.f(i10, i10 + i11, bArr.length);
            this.f13411f = i10;
            this.f13412g = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        public int O() {
            return this.f13411f;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte c(int i10) {
            ByteString.e(i10, size());
            return this.f13413e[this.f13411f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public void l(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f13413e, O() + i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte m(int i10) {
            return this.f13413e[this.f13411f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f13412g;
        }

        public Object writeReplace() {
            return ByteString.J(A());
        }
    }

    public static abstract class LeafByteString extends ByteString {
        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }
    }

    public static class LiteralByteString extends LeafByteString {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f13413e;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f13413e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String G(Charset charset) {
            return new String(this.f13413e, O(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void L(AbstractC1344g abstractC1344g) throws IOException {
            abstractC1344g.a(this.f13413e, O(), size());
        }

        public final boolean N(ByteString byteString, int i10, int i11) {
            if (i11 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
            int i12 = i10 + i11;
            if (i12 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.z(i10, i12).equals(z(0, i11));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.f13413e;
            byte[] bArr2 = literalByteString.f13413e;
            int iO = O() + i11;
            int iO2 = O();
            int iO3 = literalByteString.O() + i10;
            while (iO2 < iO) {
                if (bArr[iO2] != bArr2[iO3]) {
                    return false;
                }
                iO2++;
                iO3++;
            }
            return true;
        }

        public int O() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte c(int i10) {
            return this.f13413e[i10];
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
            int iY = y();
            int iY2 = literalByteString.y();
            if (iY == 0 || iY2 == 0 || iY == iY2) {
                return N(literalByteString, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void l(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f13413e, i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte m(int i10) {
            return this.f13413e[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean n() {
            int iO = O();
            return Utf8.n(this.f13413e, iO, size() + iO);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f13413e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final AbstractC1345h v() {
            return AbstractC1345h.j(this.f13413e, O(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int x(int i10, int i11, int i12) {
            return C1359w.i(i10, this.f13413e, O() + i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString z(int i10, int i11) {
            int iF = ByteString.f(i10, i11, size());
            return iF == 0 ? ByteString.f13407b : new BoundedByteString(this.f13413e, O() + i10, iF);
        }
    }

    public class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public int f13414a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final int f13415b;

        public a() {
            this.f13415b = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13414a < this.f13415b;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.f
        public byte nextByte() {
            int i10 = this.f13414a;
            if (i10 >= this.f13415b) {
                throw new NoSuchElementException();
            }
            this.f13414a = i10 + 1;
            return ByteString.this.m(i10);
        }
    }

    public static class b implements Comparator<ByteString> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ByteString byteString, ByteString byteString2) {
            f it = byteString.iterator();
            f it2 = byteString2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int iCompare = Integer.compare(ByteString.C(it.nextByte()), ByteString.C(it2.nextByte()));
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    }

    public static abstract class c implements f {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d implements e {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.e
        public byte[] copyFrom(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public interface e {
        byte[] copyFrom(byte[] bArr, int i10, int i11);
    }

    public interface f extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final CodedOutputStream f13417a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f13418b;

        public /* synthetic */ g(int i10, a aVar) {
            this(i10);
        }

        public ByteString a() {
            this.f13417a.c();
            return new LiteralByteString(this.f13418b);
        }

        public CodedOutputStream b() {
            return this.f13417a;
        }

        public g(int i10) {
            byte[] bArr = new byte[i10];
            this.f13418b = bArr;
            this.f13417a = CodedOutputStream.g0(bArr);
        }
    }

    public static final class h implements e {
        public h() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.e
        public byte[] copyFrom(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f13408c = C1341d.c() ? new h(aVar) : new d(aVar);
        f13409d = new b();
    }

    public static int C(byte b10) {
        return b10 & 255;
    }

    public static ByteString J(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public static ByteString K(byte[] bArr, int i10, int i11) {
        return new BoundedByteString(bArr, i10, i11);
    }

    public static void e(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    public static int f(int i10, int i11, int i12) {
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

    public static ByteString i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static ByteString j(byte[] bArr, int i10, int i11) {
        f(i10, i10 + i11, bArr.length);
        return new LiteralByteString(f13408c.copyFrom(bArr, i10, i11));
    }

    public static ByteString k(String str) {
        return new LiteralByteString(str.getBytes(C1359w.f13642a));
    }

    public static g u(int i10) {
        return new g(i10, null);
    }

    public final byte[] A() {
        int size = size();
        if (size == 0) {
            return C1359w.f13644c;
        }
        byte[] bArr = new byte[size];
        l(bArr, 0, 0, size);
        return bArr;
    }

    public final String D(Charset charset) {
        return size() == 0 ? "" : G(charset);
    }

    public abstract String G(Charset charset);

    public final String H() {
        return D(C1359w.f13642a);
    }

    public abstract void L(AbstractC1344g abstractC1344g) throws IOException;

    public abstract byte c(int i10);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iX = this.f13410a;
        if (iX == 0) {
            int size = size();
            iX = x(size, 0, size);
            if (iX == 0) {
                iX = 1;
            }
            this.f13410a = iX;
        }
        return iX;
    }

    public abstract void l(byte[] bArr, int i10, int i11, int i12);

    public abstract byte m(int i10);

    public abstract boolean n();

    public abstract int size();

    @Override // java.lang.Iterable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public f iterator() {
        return new a();
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract AbstractC1345h v();

    public abstract int x(int i10, int i11, int i12);

    public final int y() {
        return this.f13410a;
    }

    public abstract ByteString z(int i10, int i11);
}
