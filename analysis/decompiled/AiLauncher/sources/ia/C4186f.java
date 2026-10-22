package ia;

import ia.AbstractC4182b;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

/* renamed from: ia.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4186f extends AbstractC4182b {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f33099b;

    /* renamed from: c, reason: collision with root package name */
    public int f33100c = 0;

    /* renamed from: ia.f$b */
    public class b implements AbstractC4182b.a {

        /* renamed from: a, reason: collision with root package name */
        public int f33101a;

        /* renamed from: b, reason: collision with root package name */
        public final int f33102b;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33101a < this.f33102b;
        }

        @Override // ia.AbstractC4182b.a
        public byte nextByte() {
            try {
                byte[] bArr = C4186f.this.f33099b;
                int i10 = this.f33101a;
                this.f33101a = i10 + 1;
                return bArr[i10];
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            this.f33101a = 0;
            this.f33102b = C4186f.this.size();
        }
    }

    public C4186f(byte[] bArr) {
        this.f33099b = bArr;
    }

    public static int I(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    @Override // ia.AbstractC4182b
    public void C(OutputStream outputStream, int i10, int i11) throws IOException {
        outputStream.write(this.f33099b, H() + i10, i11);
    }

    public byte D(int i10) {
        return this.f33099b[i10];
    }

    public boolean G(C4186f c4186f, int i10, int i11) {
        if (i11 > c4186f.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i10 + i11 > c4186f.size()) {
            int size2 = c4186f.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
        byte[] bArr = this.f33099b;
        byte[] bArr2 = c4186f.f33099b;
        int iH = H() + i11;
        int iH2 = H();
        int iH3 = c4186f.H() + i10;
        while (iH2 < iH) {
            if (bArr[iH2] != bArr2[iH3]) {
                return false;
            }
            iH2++;
            iH3++;
        }
        return true;
    }

    public int H() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4182b) || size() != ((AbstractC4182b) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof C4186f) {
            return G((C4186f) obj, 0, size());
        }
        if (obj instanceof C4190j) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("Has a new type of ByteString been created? Found ");
        sb2.append(strValueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int hashCode() {
        int iU = this.f33100c;
        if (iU == 0) {
            int size = size();
            iU = u(size, 0, size);
            if (iU == 0) {
                iU = 1;
            }
            this.f33100c = iU;
        }
        return iU;
    }

    @Override // ia.AbstractC4182b
    public void l(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f33099b, i10, bArr, i11, i12);
    }

    @Override // ia.AbstractC4182b
    public int m() {
        return 0;
    }

    @Override // ia.AbstractC4182b
    public boolean n() {
        return true;
    }

    @Override // ia.AbstractC4182b
    public boolean o() {
        int iH = H();
        return l.f(this.f33099b, iH, size() + iH);
    }

    @Override // ia.AbstractC4182b, java.lang.Iterable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC4182b.a iterator() {
        return new b();
    }

    @Override // ia.AbstractC4182b
    public kotlin.reflect.jvm.internal.impl.protobuf.c r() {
        return kotlin.reflect.jvm.internal.impl.protobuf.c.g(this);
    }

    @Override // ia.AbstractC4182b
    public int size() {
        return this.f33099b.length;
    }

    @Override // ia.AbstractC4182b
    public int u(int i10, int i11, int i12) {
        return I(i10, this.f33099b, H() + i11, i12);
    }

    @Override // ia.AbstractC4182b
    public int v(int i10, int i11, int i12) {
        int iH = H() + i11;
        return l.g(i10, this.f33099b, iH, i12 + iH);
    }

    @Override // ia.AbstractC4182b
    public int x() {
        return this.f33100c;
    }

    @Override // ia.AbstractC4182b
    public String z(String str) throws UnsupportedEncodingException {
        return new String(this.f33099b, H(), size(), str);
    }
}
