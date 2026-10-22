package q;

import W3.C0396g;
import java.util.Arrays;
import r.C0990a;

/* loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f19646a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f19647b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f19648c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f19649d;

    public j() {
        this(0, 1, null);
    }

    public void b(int i5, E e6) {
        int i6 = this.f19649d;
        if (i6 != 0 && i5 <= this.f19647b[i6 - 1]) {
            j(i5, e6);
            return;
        }
        if (this.f19646a && i6 >= this.f19647b.length) {
            k.d(this);
        }
        int i7 = this.f19649d;
        if (i7 >= this.f19647b.length) {
            int iE = C0990a.e(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f19647b, iE);
            j4.k.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f19647b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19648c, iE);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19648c = objArrCopyOf;
        }
        this.f19647b[i7] = i5;
        this.f19648c[i7] = e6;
        this.f19649d = i7 + 1;
    }

    public void d() {
        int i5 = this.f19649d;
        Object[] objArr = this.f19648c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f19649d = 0;
        this.f19646a = false;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public j<E> clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        j4.k.e(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j<E> jVar = (j) objClone;
        jVar.f19647b = (int[]) this.f19647b.clone();
        jVar.f19648c = (Object[]) this.f19648c.clone();
        return jVar;
    }

    public E g(int i5) {
        return (E) k.c(this, i5);
    }

    public int h(E e6) {
        if (this.f19646a) {
            k.d(this);
        }
        int i5 = this.f19649d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f19648c[i6] == e6) {
                return i6;
            }
        }
        return -1;
    }

    public int i(int i5) {
        if (this.f19646a) {
            k.d(this);
        }
        return this.f19647b[i5];
    }

    public void j(int i5, E e6) {
        int iA = C0990a.a(this.f19647b, this.f19649d, i5);
        if (iA >= 0) {
            this.f19648c[iA] = e6;
            return;
        }
        int i6 = ~iA;
        if (i6 < this.f19649d && this.f19648c[i6] == k.f19650a) {
            this.f19647b[i6] = i5;
            this.f19648c[i6] = e6;
            return;
        }
        if (this.f19646a && this.f19649d >= this.f19647b.length) {
            k.d(this);
            i6 = ~C0990a.a(this.f19647b, this.f19649d, i5);
        }
        int i7 = this.f19649d;
        if (i7 >= this.f19647b.length) {
            int iE = C0990a.e(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f19647b, iE);
            j4.k.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f19647b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19648c, iE);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19648c = objArrCopyOf;
        }
        int i8 = this.f19649d;
        if (i8 - i6 != 0) {
            int[] iArr = this.f19647b;
            int i9 = i6 + 1;
            C0396g.d(iArr, iArr, i9, i6, i8);
            Object[] objArr = this.f19648c;
            C0396g.f(objArr, objArr, i9, i6, this.f19649d);
        }
        this.f19647b[i6] = i5;
        this.f19648c[i6] = e6;
        this.f19649d++;
    }

    public int k() {
        if (this.f19646a) {
            k.d(this);
        }
        return this.f19649d;
    }

    public E l(int i5) {
        if (this.f19646a) {
            k.d(this);
        }
        return (E) this.f19648c[i5];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f19649d * 28);
        sb.append('{');
        int i5 = this.f19649d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(i(i6));
            sb.append('=');
            E eL = l(i6);
            if (eL != this) {
                sb.append(eL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        j4.k.f(string, "buffer.toString()");
        return string;
    }

    public j(int i5) {
        if (i5 == 0) {
            this.f19647b = C0990a.f19951a;
            this.f19648c = C0990a.f19953c;
        } else {
            int iE = C0990a.e(i5);
            this.f19647b = new int[iE];
            this.f19648c = new Object[iE];
        }
    }

    public /* synthetic */ j(int i5, int i6, j4.g gVar) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
