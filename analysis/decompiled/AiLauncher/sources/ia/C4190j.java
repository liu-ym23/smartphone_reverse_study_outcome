package ia;

import ia.AbstractC4182b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* renamed from: ia.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4190j extends AbstractC4182b {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f33104h;

    /* renamed from: b, reason: collision with root package name */
    public final int f33105b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f33106c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC4182b f33107d;

    /* renamed from: e, reason: collision with root package name */
    public final int f33108e;

    /* renamed from: f, reason: collision with root package name */
    public final int f33109f;

    /* renamed from: g, reason: collision with root package name */
    public int f33110g;

    /* renamed from: ia.j$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Stack<AbstractC4182b> f33111a;

        public b() {
            this.f33111a = new Stack<>();
        }

        public final AbstractC4182b b(AbstractC4182b abstractC4182b, AbstractC4182b abstractC4182b2) {
            c(abstractC4182b);
            c(abstractC4182b2);
            AbstractC4182b abstractC4182bPop = this.f33111a.pop();
            while (!this.f33111a.isEmpty()) {
                abstractC4182bPop = new C4190j(this.f33111a.pop(), abstractC4182bPop);
            }
            return abstractC4182bPop;
        }

        public final void c(AbstractC4182b abstractC4182b) {
            if (abstractC4182b.n()) {
                e(abstractC4182b);
                return;
            }
            if (abstractC4182b instanceof C4190j) {
                C4190j c4190j = (C4190j) abstractC4182b;
                c(c4190j.f33106c);
                c(c4190j.f33107d);
            } else {
                String strValueOf = String.valueOf(abstractC4182b.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
                sb2.append("Has a new type of ByteString been created? Found ");
                sb2.append(strValueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public final int d(int i10) {
            int iBinarySearch = Arrays.binarySearch(C4190j.f33104h, i10);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(AbstractC4182b abstractC4182b) {
            int iD = d(abstractC4182b.size());
            int i10 = C4190j.f33104h[iD + 1];
            if (this.f33111a.isEmpty() || this.f33111a.peek().size() >= i10) {
                this.f33111a.push(abstractC4182b);
                return;
            }
            int i11 = C4190j.f33104h[iD];
            AbstractC4182b abstractC4182bPop = this.f33111a.pop();
            while (true) {
                if (this.f33111a.isEmpty() || this.f33111a.peek().size() >= i11) {
                    break;
                } else {
                    abstractC4182bPop = new C4190j(this.f33111a.pop(), abstractC4182bPop);
                }
            }
            C4190j c4190j = new C4190j(abstractC4182bPop, abstractC4182b);
            while (!this.f33111a.isEmpty()) {
                if (this.f33111a.peek().size() >= C4190j.f33104h[d(c4190j.size()) + 1]) {
                    break;
                } else {
                    c4190j = new C4190j(this.f33111a.pop(), c4190j);
                }
            }
            this.f33111a.push(c4190j);
        }
    }

    /* renamed from: ia.j$c */
    public static class c implements Iterator<C4186f> {

        /* renamed from: a, reason: collision with root package name */
        public final Stack<C4190j> f33112a;

        /* renamed from: b, reason: collision with root package name */
        public C4186f f33113b;

        public final C4186f a(AbstractC4182b abstractC4182b) {
            while (abstractC4182b instanceof C4190j) {
                C4190j c4190j = (C4190j) abstractC4182b;
                this.f33112a.push(c4190j);
                abstractC4182b = c4190j.f33106c;
            }
            return (C4186f) abstractC4182b;
        }

        public final C4186f b() {
            while (!this.f33112a.isEmpty()) {
                C4186f c4186fA = a(this.f33112a.pop().f33107d);
                if (!c4186fA.isEmpty()) {
                    return c4186fA;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C4186f next() {
            C4186f c4186f = this.f33113b;
            if (c4186f == null) {
                throw new NoSuchElementException();
            }
            this.f33113b = b();
            return c4186f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33113b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(AbstractC4182b abstractC4182b) {
            this.f33112a = new Stack<>();
            this.f33113b = a(abstractC4182b);
        }
    }

    /* renamed from: ia.j$d */
    public class d implements AbstractC4182b.a {

        /* renamed from: a, reason: collision with root package name */
        public final c f33114a;

        /* renamed from: b, reason: collision with root package name */
        public AbstractC4182b.a f33115b;

        /* renamed from: c, reason: collision with root package name */
        public int f33116c;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33116c > 0;
        }

        @Override // ia.AbstractC4182b.a
        public byte nextByte() {
            if (!this.f33115b.hasNext()) {
                this.f33115b = this.f33114a.next().iterator();
            }
            this.f33116c--;
            return this.f33115b.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public d() {
            c cVar = new c(C4190j.this);
            this.f33114a = cVar;
            this.f33115b = cVar.next().iterator();
            this.f33116c = C4190j.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            int i12 = i11 + i10;
            i11 = i10;
            i10 = i12;
        }
        arrayList.add(Integer.MAX_VALUE);
        f33104h = new int[arrayList.size()];
        int i13 = 0;
        while (true) {
            int[] iArr = f33104h;
            if (i13 >= iArr.length) {
                return;
            }
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
            i13++;
        }
    }

    public static AbstractC4182b I(AbstractC4182b abstractC4182b, AbstractC4182b abstractC4182b2) {
        C4190j c4190j = abstractC4182b instanceof C4190j ? (C4190j) abstractC4182b : null;
        if (abstractC4182b2.size() == 0) {
            return abstractC4182b;
        }
        if (abstractC4182b.size() == 0) {
            return abstractC4182b2;
        }
        int size = abstractC4182b.size() + abstractC4182b2.size();
        if (size < 128) {
            return J(abstractC4182b, abstractC4182b2);
        }
        if (c4190j != null && c4190j.f33107d.size() + abstractC4182b2.size() < 128) {
            return new C4190j(c4190j.f33106c, J(c4190j.f33107d, abstractC4182b2));
        }
        if (c4190j == null || c4190j.f33106c.m() <= c4190j.f33107d.m() || c4190j.m() <= abstractC4182b2.m()) {
            return size >= f33104h[Math.max(abstractC4182b.m(), abstractC4182b2.m()) + 1] ? new C4190j(abstractC4182b, abstractC4182b2) : new b().b(abstractC4182b, abstractC4182b2);
        }
        return new C4190j(c4190j.f33106c, new C4190j(c4190j.f33107d, abstractC4182b2));
    }

    public static C4186f J(AbstractC4182b abstractC4182b, AbstractC4182b abstractC4182b2) {
        int size = abstractC4182b.size();
        int size2 = abstractC4182b2.size();
        byte[] bArr = new byte[size + size2];
        abstractC4182b.k(bArr, 0, 0, size);
        abstractC4182b2.k(bArr, 0, size, size2);
        return new C4186f(bArr);
    }

    @Override // ia.AbstractC4182b
    public void C(OutputStream outputStream, int i10, int i11) throws IOException {
        int i12 = i10 + i11;
        int i13 = this.f33108e;
        if (i12 <= i13) {
            this.f33106c.C(outputStream, i10, i11);
        } else {
            if (i10 >= i13) {
                this.f33107d.C(outputStream, i10 - i13, i11);
                return;
            }
            int i14 = i13 - i10;
            this.f33106c.C(outputStream, i10, i14);
            this.f33107d.C(outputStream, 0, i11 - i14);
        }
    }

    public final boolean K(AbstractC4182b abstractC4182b) {
        c cVar = new c(this);
        C4186f next = cVar.next();
        c cVar2 = new c(abstractC4182b);
        C4186f next2 = cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = next.size() - i10;
            int size2 = next2.size() - i11;
            int iMin = Math.min(size, size2);
            if (!(i10 == 0 ? next.G(next2, i11, iMin) : next2.G(next, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f33105b;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar.next();
                i10 = 0;
            } else {
                i10 += iMin;
            }
            if (iMin == size2) {
                next2 = cVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    public boolean equals(Object obj) {
        int iX;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4182b)) {
            return false;
        }
        AbstractC4182b abstractC4182b = (AbstractC4182b) obj;
        if (this.f33105b != abstractC4182b.size()) {
            return false;
        }
        if (this.f33105b == 0) {
            return true;
        }
        if (this.f33110g == 0 || (iX = abstractC4182b.x()) == 0 || this.f33110g == iX) {
            return K(abstractC4182b);
        }
        return false;
    }

    public int hashCode() {
        int iU = this.f33110g;
        if (iU == 0) {
            int i10 = this.f33105b;
            iU = u(i10, 0, i10);
            if (iU == 0) {
                iU = 1;
            }
            this.f33110g = iU;
        }
        return iU;
    }

    @Override // ia.AbstractC4182b
    public void l(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f33108e;
        if (i13 <= i14) {
            this.f33106c.l(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f33107d.l(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f33106c.l(bArr, i10, i11, i15);
            this.f33107d.l(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // ia.AbstractC4182b
    public int m() {
        return this.f33109f;
    }

    @Override // ia.AbstractC4182b
    public boolean n() {
        return this.f33105b >= f33104h[this.f33109f];
    }

    @Override // ia.AbstractC4182b
    public boolean o() {
        int iV = this.f33106c.v(0, 0, this.f33108e);
        AbstractC4182b abstractC4182b = this.f33107d;
        return abstractC4182b.v(iV, 0, abstractC4182b.size()) == 0;
    }

    @Override // ia.AbstractC4182b, java.lang.Iterable
    /* renamed from: p */
    public AbstractC4182b.a iterator() {
        return new d();
    }

    @Override // ia.AbstractC4182b
    public kotlin.reflect.jvm.internal.impl.protobuf.c r() {
        return kotlin.reflect.jvm.internal.impl.protobuf.c.h(new e());
    }

    @Override // ia.AbstractC4182b
    public int size() {
        return this.f33105b;
    }

    @Override // ia.AbstractC4182b
    public int u(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f33108e;
        if (i13 <= i14) {
            return this.f33106c.u(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f33107d.u(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f33107d.u(this.f33106c.u(i10, i11, i15), 0, i12 - i15);
    }

    @Override // ia.AbstractC4182b
    public int v(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f33108e;
        if (i13 <= i14) {
            return this.f33106c.v(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f33107d.v(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f33107d.v(this.f33106c.v(i10, i11, i15), 0, i12 - i15);
    }

    @Override // ia.AbstractC4182b
    public int x() {
        return this.f33110g;
    }

    @Override // ia.AbstractC4182b
    public String z(String str) throws UnsupportedEncodingException {
        return new String(y(), str);
    }

    public C4190j(AbstractC4182b abstractC4182b, AbstractC4182b abstractC4182b2) {
        this.f33110g = 0;
        this.f33106c = abstractC4182b;
        this.f33107d = abstractC4182b2;
        int size = abstractC4182b.size();
        this.f33108e = size;
        this.f33105b = size + abstractC4182b2.size();
        this.f33109f = Math.max(abstractC4182b.m(), abstractC4182b2.m()) + 1;
    }

    /* renamed from: ia.j$e */
    public class e extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public c f33118a;

        /* renamed from: b, reason: collision with root package name */
        public C4186f f33119b;

        /* renamed from: c, reason: collision with root package name */
        public int f33120c;

        /* renamed from: d, reason: collision with root package name */
        public int f33121d;

        /* renamed from: e, reason: collision with root package name */
        public int f33122e;

        /* renamed from: f, reason: collision with root package name */
        public int f33123f;

        public e() {
            e();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return C4190j.this.size() - (this.f33122e + this.f33121d);
        }

        public final void b() {
            if (this.f33119b != null) {
                int i10 = this.f33121d;
                int i11 = this.f33120c;
                if (i10 == i11) {
                    this.f33122e += i11;
                    this.f33121d = 0;
                    if (!this.f33118a.hasNext()) {
                        this.f33119b = null;
                        this.f33120c = 0;
                    } else {
                        C4186f next = this.f33118a.next();
                        this.f33119b = next;
                        this.f33120c = next.size();
                    }
                }
            }
        }

        public final void e() {
            c cVar = new c(C4190j.this);
            this.f33118a = cVar;
            C4186f next = cVar.next();
            this.f33119b = next;
            this.f33120c = next.size();
            this.f33121d = 0;
            this.f33122e = 0;
        }

        public final int g(byte[] bArr, int i10, int i11) {
            int i12 = i11;
            while (true) {
                if (i12 <= 0) {
                    break;
                }
                b();
                if (this.f33119b != null) {
                    int iMin = Math.min(this.f33120c - this.f33121d, i12);
                    if (bArr != null) {
                        this.f33119b.k(bArr, this.f33121d, i10, iMin);
                        i10 += iMin;
                    }
                    this.f33121d += iMin;
                    i12 -= iMin;
                } else if (i12 == i11) {
                    return -1;
                }
            }
            return i11 - i12;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f33123f = this.f33122e + this.f33121d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            bArr.getClass();
            if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            return g(bArr, i10, i11);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            e();
            g(null, 0, this.f33123f);
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (j10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j10 > 2147483647L) {
                j10 = 2147483647L;
            }
            return g(null, 0, (int) j10);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            b();
            C4186f c4186f = this.f33119b;
            if (c4186f == null) {
                return -1;
            }
            int i10 = this.f33121d;
            this.f33121d = i10 + 1;
            return c4186f.D(i10) & 255;
        }
    }
}
