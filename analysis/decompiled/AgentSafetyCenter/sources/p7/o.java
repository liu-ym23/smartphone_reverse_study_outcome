package p7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends u7.a {

    /* renamed from: x, reason: collision with root package name */
    public static final n f9881x = new n();

    /* renamed from: y, reason: collision with root package name */
    public static final Object f9882y = new Object();

    /* renamed from: t, reason: collision with root package name */
    public Object[] f9883t;

    /* renamed from: u, reason: collision with root package name */
    public int f9884u;

    /* renamed from: v, reason: collision with root package name */
    public String[] f9885v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f9886w;

    @Override // u7.a
    public final String A() {
        return i0(false);
    }

    @Override // u7.a
    public final String F() {
        return i0(true);
    }

    @Override // u7.a
    public final boolean H() {
        u7.b bVarY = Y();
        return (bVarY == u7.b.f14165h || bVarY == u7.b.f14163f || bVarY == u7.b.f14170n) ? false : true;
    }

    @Override // u7.a
    public final boolean O() {
        h0(u7.b.f14168l);
        boolean zB = ((m7.l) m0()).b();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return zB;
    }

    @Override // u7.a
    public final double P() throws u7.d {
        u7.b bVarY = Y();
        u7.b bVar = u7.b.f14167k;
        if (bVarY != bVar && bVarY != u7.b.f14166j) {
            StringBuilder sb2 = new StringBuilder("Expected ");
            sb2.append(bVar);
            sb2.append(" but was ");
            sb2.append(bVarY);
            od.f.h(sb2, j0());
            return 0.0d;
        }
        double dC = ((m7.l) l0()).c();
        if (this.f14161s != 1 && (Double.isNaN(dC) || Double.isInfinite(dC))) {
            throw new u7.d("JSON forbids NaN and infinities: " + dC);
        }
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return dC;
    }

    @Override // u7.a
    public final int Q() {
        u7.b bVarY = Y();
        u7.b bVar = u7.b.f14167k;
        if (bVarY != bVar && bVarY != u7.b.f14166j) {
            StringBuilder sb2 = new StringBuilder("Expected ");
            sb2.append(bVar);
            sb2.append(" but was ");
            sb2.append(bVarY);
            od.f.h(sb2, j0());
            return 0;
        }
        m7.l lVar = (m7.l) l0();
        int iIntValue = lVar.f8267c instanceof Number ? lVar.h().intValue() : Integer.parseInt(lVar.i());
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return iIntValue;
    }

    @Override // u7.a
    public final long R() {
        u7.b bVarY = Y();
        u7.b bVar = u7.b.f14167k;
        if (bVarY != bVar && bVarY != u7.b.f14166j) {
            StringBuilder sb2 = new StringBuilder("Expected ");
            sb2.append(bVar);
            sb2.append(" but was ");
            sb2.append(bVarY);
            od.f.h(sb2, j0());
            return 0L;
        }
        long jG = ((m7.l) l0()).g();
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return jG;
    }

    @Override // u7.a
    public final String S() {
        return k0(false);
    }

    @Override // u7.a
    public final void U() {
        h0(u7.b.f14169m);
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // u7.a
    public final String W() {
        u7.b bVarY = Y();
        u7.b bVar = u7.b.f14166j;
        if (bVarY != bVar && bVarY != u7.b.f14167k) {
            StringBuilder sb2 = new StringBuilder("Expected ");
            sb2.append(bVar);
            sb2.append(" but was ");
            sb2.append(bVarY);
            od.f.h(sb2, j0());
            return null;
        }
        String strI = ((m7.l) m0()).i();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return strI;
    }

    @Override // u7.a
    public final u7.b Y() {
        if (this.f9884u == 0) {
            return u7.b.f14170n;
        }
        Object objL0 = l0();
        if (objL0 instanceof Iterator) {
            boolean z10 = this.f9883t[this.f9884u - 2] instanceof m7.j;
            Iterator it = (Iterator) objL0;
            if (!it.hasNext()) {
                return z10 ? u7.b.f14165h : u7.b.f14163f;
            }
            if (z10) {
                return u7.b.i;
            }
            n0(it.next());
            return Y();
        }
        if (objL0 instanceof m7.j) {
            return u7.b.f14164g;
        }
        if (objL0 instanceof m7.f) {
            return u7.b.f14162c;
        }
        if (objL0 instanceof m7.l) {
            Serializable serializable = ((m7.l) objL0).f8267c;
            if (serializable instanceof String) {
                return u7.b.f14166j;
            }
            if (serializable instanceof Boolean) {
                return u7.b.f14168l;
            }
            if (serializable instanceof Number) {
                return u7.b.f14167k;
            }
            throw new AssertionError();
        }
        if (objL0 instanceof m7.i) {
            return u7.b.f14169m;
        }
        if (objL0 == f9882y) {
            od.f.e("JsonReader is closed");
            return null;
        }
        throw new u7.d("Custom JsonElement subclass " + objL0.getClass().getName() + " is not supported");
    }

    @Override // u7.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9883t = new Object[]{f9882y};
        this.f9884u = 1;
    }

    @Override // u7.a
    public final void d() {
        h0(u7.b.f14162c);
        n0(((m7.f) l0()).f8264c.iterator());
        this.f9886w[this.f9884u - 1] = 0;
    }

    @Override // u7.a
    public final void e() {
        h0(u7.b.f14164g);
        n0(((o7.l) ((m7.j) l0()).f8266c.entrySet()).iterator());
    }

    @Override // u7.a
    public final void e0() {
        int iOrdinal = Y().ordinal();
        if (iOrdinal == 1) {
            n();
            return;
        }
        if (iOrdinal != 9) {
            if (iOrdinal == 3) {
                o();
                return;
            }
            if (iOrdinal == 4) {
                k0(true);
                return;
            }
            m0();
            int i = this.f9884u;
            if (i > 0) {
                int[] iArr = this.f9886w;
                int i3 = i - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    public final void h0(u7.b bVar) {
        if (Y() == bVar) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("Expected ");
        sb2.append(bVar);
        sb2.append(" but was ");
        sb2.append(Y());
        od.f.h(sb2, j0());
    }

    public final String i0(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i3 = this.f9884u;
            if (i >= i3) {
                return sb2.toString();
            }
            Object[] objArr = this.f9883t;
            Object obj = objArr[i];
            if (obj instanceof m7.f) {
                i++;
                if (i < i3 && (objArr[i] instanceof Iterator)) {
                    int i10 = this.f9886w[i];
                    if (z10 && i10 > 0 && (i == i3 - 1 || i == i3 - 2)) {
                        i10--;
                    }
                    sb2.append('[');
                    sb2.append(i10);
                    sb2.append(']');
                }
            } else if ((obj instanceof m7.j) && (i = i + 1) < i3 && (objArr[i] instanceof Iterator)) {
                sb2.append('.');
                String str = this.f9885v[i];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i++;
        }
    }

    public final String j0() {
        return " at path ".concat(i0(false));
    }

    public final String k0(boolean z10) {
        h0(u7.b.i);
        Map.Entry entry = (Map.Entry) ((Iterator) l0()).next();
        String str = (String) entry.getKey();
        this.f9885v[this.f9884u - 1] = z10 ? "<skipped>" : str;
        n0(entry.getValue());
        return str;
    }

    public final Object l0() {
        return this.f9883t[this.f9884u - 1];
    }

    public final Object m0() {
        Object[] objArr = this.f9883t;
        int i = this.f9884u - 1;
        this.f9884u = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    @Override // u7.a
    public final void n() {
        h0(u7.b.f14163f);
        m0();
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void n0(Object obj) {
        int i = this.f9884u;
        Object[] objArr = this.f9883t;
        if (i == objArr.length) {
            int i3 = i * 2;
            this.f9883t = Arrays.copyOf(objArr, i3);
            this.f9886w = Arrays.copyOf(this.f9886w, i3);
            this.f9885v = (String[]) Arrays.copyOf(this.f9885v, i3);
        }
        Object[] objArr2 = this.f9883t;
        int i10 = this.f9884u;
        this.f9884u = i10 + 1;
        objArr2[i10] = obj;
    }

    @Override // u7.a
    public final void o() {
        h0(u7.b.f14165h);
        this.f9885v[this.f9884u - 1] = null;
        m0();
        m0();
        int i = this.f9884u;
        if (i > 0) {
            int[] iArr = this.f9886w;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // u7.a
    public final String toString() {
        return o.class.getSimpleName().concat(j0());
    }
}
