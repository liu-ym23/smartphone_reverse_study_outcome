package E8;

import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b implements Iterable<E8.a>, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f2411d = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public int f2412a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String[] f2413b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f2414c;

    public class a implements Iterator<E8.a> {

        /* renamed from: a, reason: collision with root package name */
        public int f2415a = 0;

        public a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public E8.a next() {
            b bVar = b.this;
            String[] strArr = bVar.f2414c;
            int i10 = this.f2415a;
            String str = strArr[i10];
            String str2 = bVar.f2413b[i10];
            if (str == null) {
                str = "";
            }
            E8.a aVar = new E8.a(str2, str, bVar);
            this.f2415a++;
            return aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2415a < b.this.f2412a;
        }

        @Override // java.util.Iterator
        public void remove() {
            b bVar = b.this;
            int i10 = this.f2415a - 1;
            this.f2415a = i10;
            bVar.v(i10);
        }
    }

    public b() {
        String[] strArr = f2411d;
        this.f2413b = strArr;
        this.f2414c = strArr;
    }

    public static String n(String str) {
        return str == null ? "" : str;
    }

    public static String[] p(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i10));
        return strArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2412a == bVar.f2412a && Arrays.equals(this.f2413b, bVar.f2413b)) {
            return Arrays.equals(this.f2414c, bVar.f2414c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f2412a * 31) + Arrays.hashCode(this.f2413b)) * 31) + Arrays.hashCode(this.f2414c);
    }

    @Override // java.lang.Iterable
    public Iterator<E8.a> iterator() {
        return new a();
    }

    public final void j(String str, String str2) {
        k(this.f2412a + 1);
        String[] strArr = this.f2413b;
        int i10 = this.f2412a;
        strArr[i10] = str;
        this.f2414c[i10] = str2;
        this.f2412a = i10 + 1;
    }

    public final void k(int i10) {
        D8.b.d(i10 >= this.f2412a);
        String[] strArr = this.f2413b;
        int length = strArr.length;
        if (length >= i10) {
            return;
        }
        int i11 = length >= 4 ? this.f2412a * 2 : 4;
        if (i10 <= i11) {
            i10 = i11;
        }
        this.f2413b = p(strArr, i10);
        this.f2414c = p(this.f2414c, i10);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f2412a = this.f2412a;
            this.f2413b = p(this.f2413b, this.f2412a);
            this.f2414c = p(this.f2414c, this.f2412a);
            return bVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public String r(String str) {
        int iT = t(str);
        return iT == -1 ? "" : n(this.f2414c[iT]);
    }

    public int size() {
        return this.f2412a;
    }

    public int t(String str) {
        D8.b.f(str);
        for (int i10 = 0; i10 < this.f2412a; i10++) {
            if (str.equals(this.f2413b[i10])) {
                return i10;
            }
        }
        return -1;
    }

    public b u(String str, String str2) {
        int iT = t(str);
        if (iT != -1) {
            this.f2414c[iT] = str2;
            return this;
        }
        j(str, str2);
        return this;
    }

    public final void v(int i10) {
        D8.b.b(i10 >= this.f2412a);
        int i11 = (this.f2412a - i10) - 1;
        if (i11 > 0) {
            String[] strArr = this.f2413b;
            int i12 = i10 + 1;
            System.arraycopy(strArr, i12, strArr, i10, i11);
            String[] strArr2 = this.f2414c;
            System.arraycopy(strArr2, i12, strArr2, i10, i11);
        }
        int i13 = this.f2412a - 1;
        this.f2412a = i13;
        this.f2413b[i13] = null;
        this.f2414c[i13] = null;
    }
}
