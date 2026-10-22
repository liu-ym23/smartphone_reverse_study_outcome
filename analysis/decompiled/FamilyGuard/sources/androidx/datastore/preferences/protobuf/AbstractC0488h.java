package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.libpag.BuildConfig;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0488h implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0488h f10009b = new j(A.f9907c);

    /* renamed from: c, reason: collision with root package name */
    private static final f f10010c;

    /* renamed from: d, reason: collision with root package name */
    private static final Comparator<AbstractC0488h> f10011d;

    /* renamed from: a, reason: collision with root package name */
    private int f10012a = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.h$a */
    class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private int f10013a = 0;

        /* renamed from: b, reason: collision with root package name */
        private final int f10014b;

        a() {
            this.f10014b = AbstractC0488h.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.g
        public byte a() {
            int i5 = this.f10013a;
            if (i5 >= this.f10014b) {
                throw new NoSuchElementException();
            }
            this.f10013a = i5 + 1;
            return AbstractC0488h.this.p(i5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10013a < this.f10014b;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$b */
    static class b implements Comparator<AbstractC0488h> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC0488h abstractC0488h, AbstractC0488h abstractC0488h2) {
            g it = abstractC0488h.iterator();
            g it2 = abstractC0488h2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int iCompare = Integer.compare(AbstractC0488h.y(it.a()), AbstractC0488h.y(it2.a()));
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return Integer.compare(abstractC0488h.size(), abstractC0488h2.size());
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$c */
    static abstract class c implements g {
        c() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$d */
    private static final class d implements f {
        private d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.f
        public byte[] a(byte[] bArr, int i5, int i6) {
            return Arrays.copyOfRange(bArr, i5, i6 + i5);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$e */
    private static final class e extends j {

        /* renamed from: f, reason: collision with root package name */
        private final int f10016f;

        /* renamed from: g, reason: collision with root package name */
        private final int f10017g;

        e(byte[] bArr, int i5, int i6) {
            super(bArr);
            AbstractC0488h.h(i5, i5 + i6, bArr.length);
            this.f10016f = i5;
            this.f10017g = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.j
        protected int G() {
            return this.f10016f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.j, androidx.datastore.preferences.protobuf.AbstractC0488h
        public byte c(int i5) {
            AbstractC0488h.f(i5, size());
            return this.f10020e[this.f10016f + i5];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.j, androidx.datastore.preferences.protobuf.AbstractC0488h
        protected void o(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f10020e, G() + i5, bArr, i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.j, androidx.datastore.preferences.protobuf.AbstractC0488h
        byte p(int i5) {
            return this.f10020e[this.f10016f + i5];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.j, androidx.datastore.preferences.protobuf.AbstractC0488h
        public int size() {
            return this.f10017g;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$f */
    private interface f {
        byte[] a(byte[] bArr, int i5, int i6);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$g */
    public interface g extends Iterator<Byte> {
        byte a();
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$h, reason: collision with other inner class name */
    static final class C0127h {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC0491k f10018a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f10019b;

        /* synthetic */ C0127h(int i5, a aVar) {
            this(i5);
        }

        public AbstractC0488h a() {
            this.f10018a.c();
            return new j(this.f10019b);
        }

        public AbstractC0491k b() {
            return this.f10018a;
        }

        private C0127h(int i5) {
            byte[] bArr = new byte[i5];
            this.f10019b = bArr;
            this.f10018a = AbstractC0491k.g0(bArr);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$i */
    static abstract class i extends AbstractC0488h {
        i() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$j */
    private static class j extends i {

        /* renamed from: e, reason: collision with root package name */
        protected final byte[] f10020e;

        j(byte[] bArr) {
            bArr.getClass();
            this.f10020e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        protected final String A(Charset charset) {
            return new String(this.f10020e, G(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        final void E(AbstractC0487g abstractC0487g) {
            abstractC0487g.a(this.f10020e, G(), size());
        }

        final boolean F(AbstractC0488h abstractC0488h, int i5, int i6) {
            if (i6 > abstractC0488h.size()) {
                throw new IllegalArgumentException("Length too large: " + i6 + size());
            }
            int i7 = i5 + i6;
            if (i7 > abstractC0488h.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i5 + ", " + i6 + ", " + abstractC0488h.size());
            }
            if (!(abstractC0488h instanceof j)) {
                return abstractC0488h.w(i5, i7).equals(w(0, i6));
            }
            j jVar = (j) abstractC0488h;
            byte[] bArr = this.f10020e;
            byte[] bArr2 = jVar.f10020e;
            int iG = G() + i6;
            int iG2 = G();
            int iG3 = jVar.G() + i5;
            while (iG2 < iG) {
                if (bArr[iG2] != bArr2[iG3]) {
                    return false;
                }
                iG2++;
                iG3++;
            }
            return true;
        }

        protected int G() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public byte c(int i5) {
            return this.f10020e[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0488h) || size() != ((AbstractC0488h) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iV = v();
            int iV2 = jVar.v();
            if (iV == 0 || iV2 == 0 || iV == iV2) {
                return F(jVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        protected void o(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f10020e, i5, bArr, i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        byte p(int i5) {
            return this.f10020e[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public final boolean q() {
            int iG = G();
            return t0.n(this.f10020e, iG, size() + iG);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public int size() {
            return this.f10020e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public final AbstractC0489i t() {
            return AbstractC0489i.j(this.f10020e, G(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        protected final int u(int i5, int i6, int i7) {
            return A.i(i5, this.f10020e, G() + i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h
        public final AbstractC0488h w(int i5, int i6) {
            int iH = AbstractC0488h.h(i5, i6, size());
            return iH == 0 ? AbstractC0488h.f10009b : new e(this.f10020e, G() + i5, iH);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$k */
    private static final class k implements f {
        private k() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0488h.f
        public byte[] a(byte[] bArr, int i5, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return bArr2;
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f10010c = C0484d.c() ? new k(aVar) : new d(aVar);
        f10011d = new b();
    }

    AbstractC0488h() {
    }

    static AbstractC0488h C(byte[] bArr) {
        return new j(bArr);
    }

    static AbstractC0488h D(byte[] bArr, int i5, int i6) {
        return new e(bArr, i5, i6);
    }

    static void f(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
        }
    }

    static int h(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
        }
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
        }
        throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
    }

    public static AbstractC0488h i(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static AbstractC0488h m(byte[] bArr, int i5, int i6) {
        h(i5, i5 + i6, bArr.length);
        return new j(f10010c.a(bArr, i5, i6));
    }

    public static AbstractC0488h n(String str) {
        return new j(str.getBytes(A.f9905a));
    }

    static C0127h s(int i5) {
        return new C0127h(i5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int y(byte b6) {
        return b6 & 255;
    }

    protected abstract String A(Charset charset);

    public final String B() {
        return z(A.f9905a);
    }

    abstract void E(AbstractC0487g abstractC0487g);

    public abstract byte c(int i5);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iU = this.f10012a;
        if (iU == 0) {
            int size = size();
            iU = u(size, 0, size);
            if (iU == 0) {
                iU = 1;
            }
            this.f10012a = iU;
        }
        return iU;
    }

    protected abstract void o(byte[] bArr, int i5, int i6, int i7);

    abstract byte p(int i5);

    public abstract boolean q();

    @Override // java.lang.Iterable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public g iterator() {
        return new a();
    }

    public abstract int size();

    public abstract AbstractC0489i t();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract int u(int i5, int i6, int i7);

    protected final int v() {
        return this.f10012a;
    }

    public abstract AbstractC0488h w(int i5, int i6);

    public final byte[] x() {
        int size = size();
        if (size == 0) {
            return A.f9907c;
        }
        byte[] bArr = new byte[size];
        o(bArr, 0, 0, size);
        return bArr;
    }

    public final String z(Charset charset) {
        return size() == 0 ? BuildConfig.FLAVOR : A(charset);
    }
}
