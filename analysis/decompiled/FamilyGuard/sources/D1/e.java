package D1;

import A1.o;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends G1.a {

    /* renamed from: u, reason: collision with root package name */
    private static final Reader f1052u = new a();

    /* renamed from: v, reason: collision with root package name */
    private static final Object f1053v = new Object();

    /* renamed from: q, reason: collision with root package name */
    private Object[] f1054q;

    /* renamed from: r, reason: collision with root package name */
    private int f1055r;

    /* renamed from: s, reason: collision with root package name */
    private String[] f1056s;

    /* renamed from: t, reason: collision with root package name */
    private int[] f1057t;

    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i5, int i6) {
            throw new AssertionError();
        }
    }

    private String C() {
        return " at path " + f0();
    }

    private void o0(G1.b bVar) {
        if (V() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + V() + C());
    }

    private Object p0() {
        return this.f1054q[this.f1055r - 1];
    }

    private Object s0() {
        Object[] objArr = this.f1054q;
        int i5 = this.f1055r - 1;
        this.f1055r = i5;
        Object obj = objArr[i5];
        objArr[i5] = null;
        return obj;
    }

    private void w0(Object obj) {
        int i5 = this.f1055r;
        Object[] objArr = this.f1054q;
        if (i5 == objArr.length) {
            Object[] objArr2 = new Object[i5 * 2];
            int[] iArr = new int[i5 * 2];
            String[] strArr = new String[i5 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i5);
            System.arraycopy(this.f1057t, 0, iArr, 0, this.f1055r);
            System.arraycopy(this.f1056s, 0, strArr, 0, this.f1055r);
            this.f1054q = objArr2;
            this.f1057t = iArr;
            this.f1056s = strArr;
        }
        Object[] objArr3 = this.f1054q;
        int i6 = this.f1055r;
        this.f1055r = i6 + 1;
        objArr3[i6] = obj;
    }

    @Override // G1.a
    public boolean D() {
        o0(G1.b.BOOLEAN);
        boolean zO = ((o) s0()).o();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return zO;
    }

    @Override // G1.a
    public double E() {
        G1.b bVarV = V();
        G1.b bVar = G1.b.NUMBER;
        if (bVarV != bVar && bVarV != G1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + C());
        }
        double dQ = ((o) p0()).q();
        if (!x() && (Double.isNaN(dQ) || Double.isInfinite(dQ))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dQ);
        }
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return dQ;
    }

    @Override // G1.a
    public int G() {
        G1.b bVarV = V();
        G1.b bVar = G1.b.NUMBER;
        if (bVarV != bVar && bVarV != G1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + C());
        }
        int iR = ((o) p0()).r();
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return iR;
    }

    @Override // G1.a
    public long I() {
        G1.b bVarV = V();
        G1.b bVar = G1.b.NUMBER;
        if (bVarV != bVar && bVarV != G1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + C());
        }
        long jS = ((o) p0()).s();
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return jS;
    }

    @Override // G1.a
    public String L() {
        o0(G1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p0()).next();
        String str = (String) entry.getKey();
        this.f1056s[this.f1055r - 1] = str;
        w0(entry.getValue());
        return str;
    }

    @Override // G1.a
    public void O() {
        o0(G1.b.NULL);
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // G1.a
    public String T() {
        G1.b bVarV = V();
        G1.b bVar = G1.b.STRING;
        if (bVarV == bVar || bVarV == G1.b.NUMBER) {
            String strU = ((o) s0()).u();
            int i5 = this.f1055r;
            if (i5 > 0) {
                int[] iArr = this.f1057t;
                int i6 = i5 - 1;
                iArr[i6] = iArr[i6] + 1;
            }
            return strU;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + C());
    }

    @Override // G1.a
    public G1.b V() {
        if (this.f1055r == 0) {
            return G1.b.END_DOCUMENT;
        }
        Object objP0 = p0();
        if (objP0 instanceof Iterator) {
            boolean z5 = this.f1054q[this.f1055r - 2] instanceof A1.m;
            Iterator it = (Iterator) objP0;
            if (!it.hasNext()) {
                return z5 ? G1.b.END_OBJECT : G1.b.END_ARRAY;
            }
            if (z5) {
                return G1.b.NAME;
            }
            w0(it.next());
            return V();
        }
        if (objP0 instanceof A1.m) {
            return G1.b.BEGIN_OBJECT;
        }
        if (objP0 instanceof A1.g) {
            return G1.b.BEGIN_ARRAY;
        }
        if (!(objP0 instanceof o)) {
            if (objP0 instanceof A1.l) {
                return G1.b.NULL;
            }
            if (objP0 == f1053v) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        o oVar = (o) objP0;
        if (oVar.z()) {
            return G1.b.STRING;
        }
        if (oVar.v()) {
            return G1.b.BOOLEAN;
        }
        if (oVar.x()) {
            return G1.b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // G1.a
    public void a() {
        o0(G1.b.BEGIN_ARRAY);
        w0(((A1.g) p0()).iterator());
        this.f1057t[this.f1055r - 1] = 0;
    }

    @Override // G1.a
    public void c() {
        o0(G1.b.BEGIN_OBJECT);
        w0(((A1.m) p0()).p().iterator());
    }

    @Override // G1.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1054q = new Object[]{f1053v};
        this.f1055r = 1;
    }

    @Override // G1.a
    public String f0() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i5 = 0;
        while (i5 < this.f1055r) {
            Object[] objArr = this.f1054q;
            Object obj = objArr[i5];
            if (obj instanceof A1.g) {
                i5++;
                if (objArr[i5] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f1057t[i5]);
                    sb.append(']');
                }
            } else if (obj instanceof A1.m) {
                i5++;
                if (objArr[i5] instanceof Iterator) {
                    sb.append('.');
                    String str = this.f1056s[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i5++;
        }
        return sb.toString();
    }

    @Override // G1.a
    public void m0() {
        if (V() == G1.b.NAME) {
            L();
            this.f1056s[this.f1055r - 2] = "null";
        } else {
            s0();
            int i5 = this.f1055r;
            if (i5 > 0) {
                this.f1056s[i5 - 1] = "null";
            }
        }
        int i6 = this.f1055r;
        if (i6 > 0) {
            int[] iArr = this.f1057t;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
    }

    @Override // G1.a
    public void r() {
        o0(G1.b.END_ARRAY);
        s0();
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // G1.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // G1.a
    public void u() {
        o0(G1.b.END_OBJECT);
        s0();
        s0();
        int i5 = this.f1055r;
        if (i5 > 0) {
            int[] iArr = this.f1057t;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    public void u0() {
        o0(G1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p0()).next();
        w0(entry.getValue());
        w0(new o((String) entry.getKey()));
    }

    @Override // G1.a
    public boolean w() {
        G1.b bVarV = V();
        return (bVarV == G1.b.END_OBJECT || bVarV == G1.b.END_ARRAY) ? false : true;
    }
}
