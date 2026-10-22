package ia;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ia.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4182b implements Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC4182b f33086a = new C4186f(new byte[0]);

    /* renamed from: ia.b$a */
    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    public static AbstractC4182b b(Iterator<AbstractC4182b> it, int i10) {
        if (i10 == 1) {
            return it.next();
        }
        int i11 = i10 >>> 1;
        return b(it, i11).c(b(it, i10 - i11));
    }

    public static AbstractC4182b e(Iterable<AbstractC4182b> iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator<AbstractC4182b> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList.isEmpty() ? f33086a : b(arrayList.iterator(), arrayList.size());
    }

    public static AbstractC4182b f(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static AbstractC4182b i(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new C4186f(bArr2);
    }

    public static AbstractC4182b j(String str) {
        try {
            return new C4186f(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public static C0409b t() {
        return new C0409b(128);
    }

    public String A() {
        try {
            return z("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public void B(OutputStream outputStream, int i10, int i11) throws IOException {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= size()) {
            if (i11 > 0) {
                C(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public abstract void C(OutputStream outputStream, int i10, int i11) throws IOException;

    public AbstractC4182b c(AbstractC4182b abstractC4182b) {
        int size = size();
        int size2 = abstractC4182b.size();
        if (size + size2 < 2147483647L) {
            return C4190j.I(this, abstractC4182b);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append("+");
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void k(byte[] bArr, int i10, int i11, int i12) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i12 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i13 = i10 + i12;
        if (i13 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i13);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i14 = i11 + i12;
        if (i14 <= bArr.length) {
            if (i12 > 0) {
                l(bArr, i10, i11, i12);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i14);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public abstract void l(byte[] bArr, int i10, int i11, int i12);

    public abstract int m();

    public abstract boolean n();

    public abstract boolean o();

    @Override // java.lang.Iterable
    /* renamed from: p */
    public abstract a iterator();

    public abstract kotlin.reflect.jvm.internal.impl.protobuf.c r();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int u(int i10, int i11, int i12);

    public abstract int v(int i10, int i11, int i12);

    public abstract int x();

    public byte[] y() {
        int size = size();
        if (size == 0) {
            return kotlin.reflect.jvm.internal.impl.protobuf.f.f35881a;
        }
        byte[] bArr = new byte[size];
        l(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String z(String str) throws UnsupportedEncodingException;

    /* renamed from: ia.b$b, reason: collision with other inner class name */
    public static final class C0409b extends OutputStream {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f33087f = new byte[0];

        /* renamed from: a, reason: collision with root package name */
        public final int f33088a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<AbstractC4182b> f33089b;

        /* renamed from: c, reason: collision with root package name */
        public int f33090c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f33091d;

        /* renamed from: e, reason: collision with root package name */
        public int f33092e;

        public C0409b(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f33088a = i10;
            this.f33089b = new ArrayList<>();
            this.f33091d = new byte[i10];
        }

        public final byte[] b(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i10));
            return bArr2;
        }

        public final void e(int i10) {
            this.f33089b.add(new C4186f(this.f33091d));
            int length = this.f33090c + this.f33091d.length;
            this.f33090c = length;
            this.f33091d = new byte[Math.max(this.f33088a, Math.max(i10, length >>> 1))];
            this.f33092e = 0;
        }

        public final void g() {
            int i10 = this.f33092e;
            byte[] bArr = this.f33091d;
            if (i10 >= bArr.length) {
                this.f33089b.add(new C4186f(this.f33091d));
                this.f33091d = f33087f;
            } else if (i10 > 0) {
                this.f33089b.add(new C4186f(b(bArr, i10)));
            }
            this.f33090c += this.f33092e;
            this.f33092e = 0;
        }

        public synchronized int i() {
            return this.f33090c + this.f33092e;
        }

        public synchronized AbstractC4182b l() {
            g();
            return AbstractC4182b.e(this.f33089b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(i()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            try {
                if (this.f33092e == this.f33091d.length) {
                    e(1);
                }
                byte[] bArr = this.f33091d;
                int i11 = this.f33092e;
                this.f33092e = i11 + 1;
                bArr[i11] = (byte) i10;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            try {
                byte[] bArr2 = this.f33091d;
                int length = bArr2.length;
                int i12 = this.f33092e;
                if (i11 <= length - i12) {
                    System.arraycopy(bArr, i10, bArr2, i12, i11);
                    this.f33092e += i11;
                } else {
                    int length2 = bArr2.length - i12;
                    System.arraycopy(bArr, i10, bArr2, i12, length2);
                    int i13 = i11 - length2;
                    e(i13);
                    System.arraycopy(bArr, i10 + length2, this.f33091d, 0, i13);
                    this.f33092e = i13;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
