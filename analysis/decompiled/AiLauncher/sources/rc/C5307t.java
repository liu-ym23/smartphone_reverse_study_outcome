package rc;

import java.io.InputStream;
import java.lang.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.scilab.forge.jlatexmath.FontAlreadyLoadedException;
import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;
import org.scilab.forge.jlatexmath.TextStyleMappingNotFoundException;
import org.scilab.forge.jlatexmath.XMLResourceParseException;

/* renamed from: rc.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5307t implements Z0 {

    /* renamed from: h, reason: collision with root package name */
    public static String[] f39401h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, C5298o[]> f39402i = null;

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, C5298o> f39403j = null;

    /* renamed from: k, reason: collision with root package name */
    public static F[] f39404k = null;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, Float> f39405l = null;

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, Number> f39406m = null;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f39407n = true;

    /* renamed from: o, reason: collision with root package name */
    public static List<Character.UnicodeBlock> f39408o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public static Map<Character.UnicodeBlock, InterfaceC5272b> f39409p = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public float f39410a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39411b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39412c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39413d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39414e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39415f;

    /* renamed from: g, reason: collision with root package name */
    public final float f39416g;

    static {
        f39404k = new F[0];
        C5309u c5309u = new C5309u();
        f39408o.add(Character.UnicodeBlock.of('a'));
        f39404k = c5309u.j(f39404k);
        f39405l = c5309u.m();
        f39402i = c5309u.p();
        f39401h = c5309u.h();
        f39403j = c5309u.o();
        Map<String, Number> mapL = c5309u.l();
        f39406m = mapL;
        mapL.put("textfactor", 1);
        int iIntValue = f39406m.get("mufontid").intValue();
        if (iIntValue >= 0) {
            F[] fArr = f39404k;
            if (iIntValue < fArr.length && fArr[iIntValue] != null) {
                return;
            }
        }
        throw new XMLResourceParseException("DefaultTeXFont.xml", "GeneralSettings", "mufontid", "contains an unknown font id!");
    }

    public C5307t(float f10) {
        this.f39410a = 1.0f;
        this.f39411b = false;
        this.f39412c = false;
        this.f39413d = false;
        this.f39414e = false;
        this.f39415f = false;
        this.f39416g = f10;
    }

    public static void Q(Object obj, Character.UnicodeBlock[] unicodeBlockArr, String str) throws ResourceParseException {
        boolean z10 = false;
        for (int i10 = 0; !z10 && i10 < unicodeBlockArr.length; i10++) {
            z10 = f39408o.contains(unicodeBlockArr[i10]) || z10;
        }
        if (z10) {
            return;
        }
        d1.f39253n = true;
        S(obj, Bc.a.b(str), str);
        for (Character.UnicodeBlock unicodeBlock : unicodeBlockArr) {
            f39408o.add(unicodeBlock);
        }
        d1.f39253n = false;
    }

    public static void R(InterfaceC5272b interfaceC5272b) {
        if (interfaceC5272b != null) {
            try {
                Q(interfaceC5272b.a(), interfaceC5272b.c(), interfaceC5272b.b());
            } catch (FontAlreadyLoadedException unused) {
            }
        }
    }

    public static void S(Object obj, InputStream inputStream, String str) throws ResourceParseException {
        C5309u c5309u = new C5309u(obj, inputStream, str);
        f39404k = c5309u.j(f39404k);
        c5309u.i();
        f39402i.putAll(c5309u.p());
        f39403j.putAll(c5309u.o());
    }

    public static float V(String str) {
        Float f10 = f39405l.get(str);
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    public static float W(int i10) {
        if (i10 < 2) {
            return 1.0f;
        }
        return i10 < 4 ? f39406m.get("textfactor").floatValue() : i10 < 6 ? f39406m.get("scriptfactor").floatValue() : f39406m.get("scriptscriptfactor").floatValue();
    }

    public static void X(InterfaceC5272b interfaceC5272b) {
        for (Character.UnicodeBlock unicodeBlock : interfaceC5272b.c()) {
            f39409p.put(unicodeBlock, interfaceC5272b);
        }
    }

    public static void Y(float f10) {
        if (f39407n) {
            c1.f39242h = f10 / 1000.0f;
        }
    }

    public static void Z(float f10, float f11, float f12, float f13) {
        if (f39407n) {
            f39406m.put("scriptfactor", Float.valueOf(Math.abs(f12 / f10)));
            f39406m.put("scriptscriptfactor", Float.valueOf(Math.abs(f13 / f10)));
            f39406m.put("textfactor", Float.valueOf(Math.abs(f11 / f10)));
            c1.f39241g = Math.abs(f10);
        }
    }

    @Override // rc.Z0
    public float A(int i10) {
        return V("num1") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float B(int i10) {
        return V("bigopspacing3") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public boolean C(C5292l c5292l) {
        return f39404k[c5292l.e()].k(c5292l.a()) != null;
    }

    @Override // rc.Z0
    public float D(int i10) {
        return V("bigopspacing5") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public boolean E(C5292l c5292l) {
        return f39404k[c5292l.e()].d(c5292l.a()) != null;
    }

    @Override // rc.Z0
    public C5292l F(char c10, String str, int i10) throws TextStyleMappingNotFoundException {
        C5298o[] c5298oArr = f39402i.get(str);
        if (c5298oArr != null) {
            return T(c10, c5298oArr, i10);
        }
        throw new TextStyleMappingNotFoundException(str);
    }

    @Override // rc.Z0
    public void G(boolean z10) {
        this.f39411b = z10;
    }

    @Override // rc.Z0
    public float H(int i10) {
        return V("sup1") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public int I() {
        return f39406m.get("mufontid").intValue();
    }

    @Override // rc.Z0
    public float J(int i10) {
        return V("sup3") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public C5292l K(C5292l c5292l, int i10) {
        C5298o c5298oK = f39404k[c5292l.e()].k(c5292l.a());
        return new C5292l(c5298oK.f39367a, f39404k[c5298oK.f39368b].e(), c5298oK.f39368b, U(c5298oK, W(i10)));
    }

    @Override // rc.Z0
    public void L(boolean z10) {
        this.f39413d = z10;
    }

    @Override // rc.Z0
    public float M(int i10) {
        return V("sup2") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float N(int i10) {
        return V("defaultrulethickness") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float O(int i10, int i11) {
        return f39404k[i11].l(W(i10) * a1.f39201g);
    }

    @Override // rc.Z0
    public float P(int i10) {
        return V("bigopspacing1") * W(i10) * a1.f39201g;
    }

    public final C5292l T(char c10, C5298o[] c5298oArr, int i10) {
        char c11;
        int i11;
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
            c11 = 0;
        } else if (c10 >= 'a' && c10 <= 'z') {
            i11 = c10 - 'a';
            c11 = 2;
        } else if (c10 < 'A' || c10 > 'Z') {
            c11 = 3;
            i11 = c10;
        } else {
            i11 = c10 - 'A';
            c11 = 1;
        }
        C5298o c5298o = c5298oArr[c11];
        return c5298o == null ? z(c10, i10) : e(new C5298o((char) (c5298o.f39367a + i11), c5298o.f39368b), i10);
    }

    public final C5281f0 U(C5298o c5298o, float f10) {
        float[] fArrJ = f39404k[c5298o.f39368b].j(c5298o.f39367a);
        return new C5281f0(fArrJ[0], fArrJ[1], fArrJ[2], fArrJ[3], f10 * a1.f39201g, f10);
    }

    @Override // rc.Z0
    public void a(boolean z10) {
        this.f39412c = z10;
    }

    @Override // rc.Z0
    public void b(boolean z10) {
        this.f39414e = z10;
    }

    @Override // rc.Z0
    public void c(boolean z10) {
        this.f39415f = z10;
    }

    @Override // rc.Z0
    public Z0 copy() {
        return new C5307t(this.f39416g, this.f39410a, this.f39411b, this.f39412c, this.f39413d, this.f39414e, this.f39415f);
    }

    @Override // rc.Z0
    public boolean d(int i10) {
        return f39404k[i10].s();
    }

    @Override // rc.Z0
    public C5292l e(C5298o c5298o, int i10) {
        float fW = W(i10);
        boolean z10 = this.f39411b;
        int iG = z10 ? c5298o.f39369c : c5298o.f39368b;
        F f10 = f39404k[iG];
        if (z10 && c5298o.f39368b == c5298o.f39369c) {
            iG = f10.c();
            f10 = f39404k[iG];
            c5298o = new C5298o(c5298o.f39367a, iG, i10);
        }
        if (this.f39412c) {
            iG = f10.m();
            f10 = f39404k[iG];
            c5298o = new C5298o(c5298o.f39367a, iG, i10);
        }
        if (this.f39413d) {
            iG = f10.p();
            f10 = f39404k[iG];
            c5298o = new C5298o(c5298o.f39367a, iG, i10);
        }
        if (this.f39414e) {
            iG = f10.q();
            f10 = f39404k[iG];
            c5298o = new C5298o(c5298o.f39367a, iG, i10);
        }
        if (this.f39415f) {
            iG = f10.g();
            f10 = f39404k[iG];
            c5298o = new C5298o(c5298o.f39367a, iG, i10);
        }
        return new C5292l(c5298o.f39367a, f10.e(), iG, U(c5298o, this.f39410a * fW));
    }

    @Override // rc.Z0
    public float f(int i10) {
        return V("subdrop") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float g() {
        return this.f39410a;
    }

    @Override // rc.Z0
    public float getSize() {
        return this.f39416g;
    }

    @Override // rc.Z0
    public float h(C5298o c5298o, C5298o c5298o2, int i10) {
        int i11 = c5298o.f39368b;
        if (i11 == c5298o2.f39368b) {
            return f39404k[i11].h(c5298o.f39367a, c5298o2.f39367a, W(i10) * a1.f39201g);
        }
        return 0.0f;
    }

    @Override // rc.Z0
    public float i(int i10) {
        return V("denom1") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public C5292l j(String str, int i10) throws SymbolMappingNotFoundException {
        C5298o c5298o = f39403j.get(str);
        if (c5298o != null) {
            return e(c5298o, i10);
        }
        throw new SymbolMappingNotFoundException(str);
    }

    @Override // rc.Z0
    public float k(int i10) {
        return V("axisheight") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float l(int i10) {
        return f39404k[f39406m.get("spacefontid").intValue()].o(W(i10) * a1.f39201g);
    }

    @Override // rc.Z0
    public float m(int i10) {
        return W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float n(int i10) {
        return V("denom2") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public C5298o o(C5298o c5298o, C5298o c5298o2) {
        int i10 = c5298o.f39368b;
        if (i10 == c5298o2.f39368b) {
            return f39404k[i10].i(c5298o.f39367a, c5298o2.f39367a);
        }
        return null;
    }

    @Override // rc.Z0
    public float p(int i10) {
        return V("supdrop") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public C5319z q(C5292l c5292l, int i10) {
        Cc.e eVarD = c5292l.d();
        int iE = c5292l.e();
        float fW = W(i10);
        int[] iArrD = f39404k[iE].d(c5292l.a());
        C5292l[] c5292lArr = new C5292l[iArrD.length];
        for (int i11 = 0; i11 < iArrD.length; i11++) {
            int i12 = iArrD[i11];
            if (i12 == -1) {
                c5292lArr[i11] = null;
            } else {
                c5292lArr[i11] = new C5292l((char) i12, eVarD, iE, U(new C5298o((char) i12, iE), fW));
            }
        }
        return new C5319z(c5292lArr[0], c5292lArr[1], c5292lArr[2], c5292lArr[3]);
    }

    @Override // rc.Z0
    public float r(int i10) {
        return V("sub2") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float s(int i10) {
        return V("num2") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float t(int i10, int i11) {
        return f39404k[i11].r(W(i10) * a1.f39201g);
    }

    @Override // rc.Z0
    public float u(int i10) {
        return V("sub1") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float v(int i10) {
        return V("num3") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float w(C5298o c5298o, int i10) {
        char cN = f39404k[c5298o.f39368b].n();
        if (cN == 65535) {
            return 0.0f;
        }
        return h(c5298o, new C5298o(cN, c5298o.f39368b), i10);
    }

    @Override // rc.Z0
    public float x(int i10) {
        return V("bigopspacing2") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public float y(int i10) {
        return V("bigopspacing4") * W(i10) * a1.f39201g;
    }

    @Override // rc.Z0
    public C5292l z(char c10, int i10) {
        return (c10 < '0' || c10 > '9') ? (c10 < 'a' || c10 > 'z') ? F(c10, f39401h[1], i10) : F(c10, f39401h[2], i10) : F(c10, f39401h[0], i10);
    }

    public C5307t(float f10, float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f39416g = f10;
        this.f39410a = f11;
        this.f39411b = z10;
        this.f39412c = z11;
        this.f39413d = z12;
        this.f39414e = z13;
        this.f39415f = z14;
    }
}
