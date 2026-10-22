package rc;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class F {

    /* renamed from: z, reason: collision with root package name */
    public static Map<Integer, F> f39041z = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final int f39042a;

    /* renamed from: b, reason: collision with root package name */
    public Cc.e f39043b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f39044c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39045d;

    /* renamed from: e, reason: collision with root package name */
    public final String f39046e;

    /* renamed from: h, reason: collision with root package name */
    public float[][] f39049h;

    /* renamed from: i, reason: collision with root package name */
    public C5298o[] f39050i;

    /* renamed from: j, reason: collision with root package name */
    public int[][] f39051j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap<Character, Character> f39052k;

    /* renamed from: m, reason: collision with root package name */
    public final float f39054m;

    /* renamed from: n, reason: collision with root package name */
    public final float f39055n;

    /* renamed from: o, reason: collision with root package name */
    public final float f39056o;

    /* renamed from: p, reason: collision with root package name */
    public int f39057p;

    /* renamed from: q, reason: collision with root package name */
    public int f39058q;

    /* renamed from: r, reason: collision with root package name */
    public int f39059r;

    /* renamed from: s, reason: collision with root package name */
    public int f39060s;

    /* renamed from: t, reason: collision with root package name */
    public int f39061t;

    /* renamed from: u, reason: collision with root package name */
    public final String f39062u;

    /* renamed from: v, reason: collision with root package name */
    public final String f39063v;

    /* renamed from: w, reason: collision with root package name */
    public final String f39064w;

    /* renamed from: x, reason: collision with root package name */
    public final String f39065x;

    /* renamed from: y, reason: collision with root package name */
    public final String f39066y;

    /* renamed from: f, reason: collision with root package name */
    public final Map<a, Character> f39047f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map<a, Float> f39048g = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public char f39053l = 65535;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final char f39067a;

        /* renamed from: b, reason: collision with root package name */
        public final char f39068b;

        public a(char c10, char c11) {
            this.f39067a = c10;
            this.f39068b = c11;
        }

        public boolean equals(Object obj) {
            a aVar = (a) obj;
            return this.f39067a == aVar.f39067a && this.f39068b == aVar.f39068b;
        }

        public int hashCode() {
            return (this.f39067a + this.f39068b) % 128;
        }
    }

    public F(int i10, Object obj, String str, String str2, int i11, float f10, float f11, float f12, String str3, String str4, String str5, String str6, String str7) {
        this.f39052k = null;
        this.f39042a = i10;
        this.f39044c = obj;
        this.f39045d = str;
        this.f39046e = str2;
        this.f39054m = f10;
        this.f39055n = f11;
        this.f39056o = f12;
        this.f39062u = str3;
        this.f39063v = str4;
        this.f39064w = str5;
        this.f39065x = str6;
        this.f39066y = str7;
        if (i11 != 0) {
            this.f39052k = new HashMap<>(i11);
        } else {
            i11 = 256;
        }
        this.f39049h = new float[i11][];
        this.f39050i = new C5298o[i11];
        this.f39051j = new int[i11][];
        f39041z.put(Integer.valueOf(i10), this);
    }

    public static Cc.e f(int i10) {
        return f39041z.get(Integer.valueOf(i10)).e();
    }

    public void A(int i10) {
        if (i10 == -1) {
            i10 = this.f39042a;
        }
        this.f39059r = i10;
    }

    public void B(int i10) {
        if (i10 == -1) {
            i10 = this.f39042a;
        }
        this.f39060s = i10;
    }

    public void a(char c10, char c11, float f10) {
        this.f39048g.put(new a(c10, c11), new Float(f10));
    }

    public void b(char c10, char c11, char c12) {
        this.f39047f.put(new a(c10, c11), new Character(c12));
    }

    public int c() {
        return this.f39057p;
    }

    public int[] d(char c10) {
        HashMap<Character, Character> map = this.f39052k;
        return map == null ? this.f39051j[c10] : this.f39051j[map.get(Character.valueOf(c10)).charValue()];
    }

    public Cc.e e() {
        if (this.f39043b == null) {
            if (this.f39044c == null) {
                this.f39043b = C5309u.b(this.f39045d);
            } else {
                this.f39043b = C5309u.b(this.f39045d);
            }
        }
        return this.f39043b;
    }

    public int g() {
        return this.f39061t;
    }

    public float h(char c10, char c11, float f10) {
        Float f11 = this.f39048g.get(new a(c10, c11));
        if (f11 == null) {
            return 0.0f;
        }
        return f11.floatValue() * f10;
    }

    public C5298o i(char c10, char c11) {
        Character ch = this.f39047f.get(new a(c10, c11));
        if (ch == null) {
            return null;
        }
        return new C5298o(ch.charValue(), this.f39042a);
    }

    public float[] j(char c10) {
        HashMap<Character, Character> map = this.f39052k;
        return map == null ? this.f39049h[c10] : this.f39049h[map.get(Character.valueOf(c10)).charValue()];
    }

    public C5298o k(char c10) {
        HashMap<Character, Character> map = this.f39052k;
        return map == null ? this.f39050i[c10] : this.f39050i[map.get(Character.valueOf(c10)).charValue()];
    }

    public float l(float f10) {
        return this.f39056o * f10;
    }

    public int m() {
        return this.f39058q;
    }

    public char n() {
        return this.f39053l;
    }

    public float o(float f10) {
        return this.f39055n * f10;
    }

    public int p() {
        return this.f39059r;
    }

    public int q() {
        return this.f39060s;
    }

    public float r(float f10) {
        return this.f39054m * f10;
    }

    public boolean s() {
        return this.f39055n > 1.0E-7f;
    }

    public void t(int i10) {
        if (i10 == -1) {
            i10 = this.f39042a;
        }
        this.f39057p = i10;
    }

    public void u(char c10, int[] iArr) {
        HashMap<Character, Character> map = this.f39052k;
        if (map == null) {
            this.f39051j[c10] = iArr;
        } else {
            if (map.containsKey(Character.valueOf(c10))) {
                this.f39051j[this.f39052k.get(Character.valueOf(c10)).charValue()] = iArr;
                return;
            }
            char size = (char) this.f39052k.size();
            this.f39052k.put(Character.valueOf(c10), Character.valueOf(size));
            this.f39051j[size] = iArr;
        }
    }

    public void v(int i10) {
        if (i10 == -1) {
            i10 = this.f39042a;
        }
        this.f39061t = i10;
    }

    public void w(char c10, float[] fArr) {
        HashMap<Character, Character> map = this.f39052k;
        if (map == null) {
            this.f39049h[c10] = fArr;
        } else {
            if (map.containsKey(Character.valueOf(c10))) {
                this.f39049h[this.f39052k.get(Character.valueOf(c10)).charValue()] = fArr;
                return;
            }
            char size = (char) this.f39052k.size();
            this.f39052k.put(Character.valueOf(c10), Character.valueOf(size));
            this.f39049h[size] = fArr;
        }
    }

    public void x(char c10, char c11, int i10) {
        HashMap<Character, Character> map = this.f39052k;
        if (map == null) {
            this.f39050i[c10] = new C5298o(c11, i10);
        } else {
            if (map.containsKey(Character.valueOf(c10))) {
                this.f39050i[this.f39052k.get(Character.valueOf(c10)).charValue()] = new C5298o(c11, i10);
                return;
            }
            char size = (char) this.f39052k.size();
            this.f39052k.put(Character.valueOf(c10), Character.valueOf(size));
            this.f39050i[size] = new C5298o(c11, i10);
        }
    }

    public void y(int i10) {
        if (i10 == -1) {
            i10 = this.f39042a;
        }
        this.f39058q = i10;
    }

    public void z(char c10) {
        this.f39053l = c10;
    }
}
