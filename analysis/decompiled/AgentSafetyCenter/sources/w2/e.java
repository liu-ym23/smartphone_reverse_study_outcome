package w2;

import android.view.View;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p5.m;
import x2.j;
import x2.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public int F;
    public int G;
    public final d H;
    public final d I;
    public final d J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d[] P;
    public final ArrayList Q;
    public final boolean[] R;
    public e S;
    public int T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f15159a0;

    /* renamed from: b, reason: collision with root package name */
    public x2.c f15160b;

    /* renamed from: b0, reason: collision with root package name */
    public int f15161b0;

    /* renamed from: c, reason: collision with root package name */
    public x2.c f15162c;

    /* renamed from: c0, reason: collision with root package name */
    public float f15163c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f15165d0;
    public View e0;
    public int f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f15169g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f15171h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f15172i0;

    /* renamed from: j, reason: collision with root package name */
    public String f15173j;

    /* renamed from: j0, reason: collision with root package name */
    public final float[] f15174j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15175k;

    /* renamed from: k0, reason: collision with root package name */
    public final e[] f15176k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15177l;

    /* renamed from: l0, reason: collision with root package name */
    public final e[] f15178l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15179m;

    /* renamed from: m0, reason: collision with root package name */
    public int f15180m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15181n;

    /* renamed from: n0, reason: collision with root package name */
    public int f15182n0;

    /* renamed from: o, reason: collision with root package name */
    public int f15183o;

    /* renamed from: o0, reason: collision with root package name */
    public final int[] f15184o0;

    /* renamed from: p, reason: collision with root package name */
    public int f15185p;

    /* renamed from: q, reason: collision with root package name */
    public int f15186q;

    /* renamed from: r, reason: collision with root package name */
    public int f15187r;

    /* renamed from: s, reason: collision with root package name */
    public int f15188s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f15189t;

    /* renamed from: u, reason: collision with root package name */
    public int f15190u;

    /* renamed from: v, reason: collision with root package name */
    public int f15191v;

    /* renamed from: w, reason: collision with root package name */
    public float f15192w;

    /* renamed from: x, reason: collision with root package name */
    public int f15193x;

    /* renamed from: y, reason: collision with root package name */
    public int f15194y;

    /* renamed from: z, reason: collision with root package name */
    public float f15195z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f15158a = false;

    /* renamed from: d, reason: collision with root package name */
    public j f15164d = null;

    /* renamed from: e, reason: collision with root package name */
    public l f15166e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f15167f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f15168g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f15170h = -1;
    public int i = -1;

    public e() {
        new HashMap();
        this.f15175k = false;
        this.f15177l = false;
        this.f15179m = false;
        this.f15181n = false;
        this.f15183o = -1;
        this.f15185p = -1;
        this.f15186q = 0;
        this.f15187r = 0;
        this.f15188s = 0;
        this.f15189t = new int[2];
        this.f15190u = 0;
        this.f15191v = 0;
        this.f15192w = 1.0f;
        this.f15193x = 0;
        this.f15194y = 0;
        this.f15195z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Reader.READ_DONE, Reader.READ_DONE};
        this.D = 0.0f;
        this.E = false;
        this.F = 0;
        this.G = 0;
        d dVar = new d(this, 2);
        this.H = dVar;
        d dVar2 = new d(this, 3);
        this.I = dVar2;
        d dVar3 = new d(this, 4);
        this.J = dVar3;
        d dVar4 = new d(this, 5);
        this.K = dVar4;
        d dVar5 = new d(this, 6);
        this.L = dVar5;
        d dVar6 = new d(this, 8);
        this.M = dVar6;
        d dVar7 = new d(this, 9);
        this.N = dVar7;
        d dVar8 = new d(this, 7);
        this.O = dVar8;
        this.P = new d[]{dVar, dVar3, dVar2, dVar4, dVar5, dVar8};
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        this.R = new boolean[2];
        this.f15184o0 = new int[]{1, 1};
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15163c0 = 0.5f;
        this.f15165d0 = 0.5f;
        this.f0 = 0;
        this.f15169g0 = null;
        this.f15171h0 = 0;
        this.f15172i0 = 0;
        this.f15174j0 = new float[]{-1.0f, -1.0f};
        this.f15176k0 = new e[]{null, null};
        this.f15178l0 = new e[]{null, null};
        this.f15180m0 = -1;
        this.f15182n0 = -1;
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        arrayList.add(dVar5);
    }

    public static void D(String str, int i, int i3, StringBuilder sb2) {
        if (i == i3) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i);
        sb2.append(",\n");
    }

    public static void E(StringBuilder sb2, String str, float f5, float f10) {
        if (f5 == f10) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f5);
        sb2.append(",\n");
    }

    public static void m(StringBuilder sb2, String str, int i, int i3, int i10, int i11, int i12, float f5) {
        sb2.append(str);
        sb2.append(" :  {\n");
        D("      size", i, 0, sb2);
        D("      min", i3, 0, sb2);
        D("      max", i10, Reader.READ_DONE, sb2);
        D("      matchMin", i11, 0, sb2);
        D("      matchDef", i12, 0, sb2);
        E(sb2, "      matchPercent", f5, 1.0f);
        sb2.append("    },\n");
    }

    public static void n(StringBuilder sb2, String str, d dVar) {
        if (dVar.f15155f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(dVar.f15155f);
        sb2.append("'");
        if (dVar.f15157h != Integer.MIN_VALUE || dVar.f15156g != 0) {
            sb2.append(",");
            sb2.append(dVar.f15156g);
            if (dVar.f15157h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(dVar.f15157h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    public void A() {
        this.H.g();
        this.I.g();
        this.J.g();
        this.K.g();
        this.L.g();
        this.M.g();
        this.N.g();
        this.O.g();
        this.S = null;
        this.D = 0.0f;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15159a0 = 0;
        this.f15161b0 = 0;
        this.f15163c0 = 0.5f;
        this.f15165d0 = 0.5f;
        int[] iArr = this.f15184o0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.e0 = null;
        this.f0 = 0;
        this.f15171h0 = 0;
        this.f15172i0 = 0;
        float[] fArr = this.f15174j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f15183o = -1;
        this.f15185p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f15187r = 0;
        this.f15188s = 0;
        this.f15192w = 1.0f;
        this.f15195z = 1.0f;
        this.f15191v = Reader.READ_DONE;
        this.f15194y = Reader.READ_DONE;
        this.f15190u = 0;
        this.f15193x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f15167f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.R;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f15168g = true;
        int[] iArr3 = this.f15189t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f15170h = -1;
        this.i = -1;
    }

    public final void B() {
        this.f15175k = false;
        this.f15177l = false;
        this.f15179m = false;
        this.f15181n = false;
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            dVar.f15152c = false;
            dVar.f15151b = 0;
        }
    }

    public void C(m mVar) {
        this.H.h();
        this.I.h();
        this.J.h();
        this.K.h();
        this.L.h();
        this.O.h();
        this.M.h();
        this.N.h();
    }

    public final void F(int i, int i3) {
        if (this.f15175k) {
            return;
        }
        this.H.i(i);
        this.J.i(i3);
        this.X = i;
        this.T = i3 - i;
        this.f15175k = true;
    }

    public final void G(int i, int i3) {
        if (this.f15177l) {
            return;
        }
        this.I.i(i);
        this.K.i(i3);
        this.Y = i;
        this.U = i3 - i;
        if (this.E) {
            this.L.i(i + this.Z);
        }
        this.f15177l = true;
    }

    public final void H(int i) {
        this.U = i;
        int i3 = this.f15161b0;
        if (i < i3) {
            this.U = i3;
        }
    }

    public final void I(int i) {
        this.f15184o0[0] = i;
    }

    public final void J(int i) {
        this.f15184o0[1] = i;
    }

    public final void K(int i) {
        this.T = i;
        int i3 = this.f15159a0;
        if (i < i3) {
            this.T = i3;
        }
    }

    public void L(boolean z10, boolean z11) {
        int i;
        int i3;
        j jVar = this.f15164d;
        boolean z12 = z10 & jVar.f15564g;
        l lVar = this.f15166e;
        boolean z13 = z11 & lVar.f15564g;
        int i10 = jVar.f15565h.f15540g;
        int i11 = lVar.f15565h.f15540g;
        int i12 = jVar.i.f15540g;
        int i13 = lVar.i.f15540g;
        int i14 = i13 - i11;
        if (i12 - i10 < 0 || i14 < 0 || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
            i12 = 0;
            i13 = 0;
            i10 = 0;
            i11 = 0;
        }
        int i15 = i12 - i10;
        int i16 = i13 - i11;
        if (z12) {
            this.X = i10;
        }
        if (z13) {
            this.Y = i11;
        }
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f15184o0;
        if (z12) {
            if (iArr[0] == 1 && i15 < (i3 = this.T)) {
                i15 = i3;
            }
            this.T = i15;
            int i17 = this.f15159a0;
            if (i15 < i17) {
                this.T = i17;
            }
        }
        if (z13) {
            if (iArr[1] == 1 && i16 < (i = this.U)) {
                i16 = i;
            }
            this.U = i16;
            int i18 = this.f15161b0;
            if (i16 < i18) {
                this.U = i18;
            }
        }
    }

    public void M(u2.c cVar, boolean z10) {
        int i;
        int i3;
        l lVar;
        j jVar;
        cVar.getClass();
        int iN = u2.c.n(this.H);
        int iN2 = u2.c.n(this.I);
        int iN3 = u2.c.n(this.J);
        int iN4 = u2.c.n(this.K);
        if (z10 && (jVar = this.f15164d) != null) {
            x2.e eVar = jVar.f15565h;
            if (eVar.f15542j) {
                x2.e eVar2 = jVar.i;
                if (eVar2.f15542j) {
                    iN = eVar.f15540g;
                    iN3 = eVar2.f15540g;
                }
            }
        }
        if (z10 && (lVar = this.f15166e) != null) {
            x2.e eVar3 = lVar.f15565h;
            if (eVar3.f15542j) {
                x2.e eVar4 = lVar.i;
                if (eVar4.f15542j) {
                    iN2 = eVar3.f15540g;
                    iN4 = eVar4.f15540g;
                }
            }
        }
        int i10 = iN4 - iN2;
        if (iN3 - iN < 0 || i10 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i11 = iN3 - iN;
        int i12 = iN4 - iN2;
        this.X = iN;
        this.Y = iN2;
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f15184o0;
        int i13 = iArr[0];
        if (i13 == 1 && i11 < (i3 = this.T)) {
            i11 = i3;
        }
        if (iArr[1] == 1 && i12 < (i = this.U)) {
            i12 = i;
        }
        this.T = i11;
        this.U = i12;
        int i14 = this.f15161b0;
        if (i12 < i14) {
            this.U = i14;
        }
        int i15 = this.f15159a0;
        if (i11 < i15) {
            this.T = i15;
        }
        int i16 = this.f15191v;
        if (i16 > 0 && i13 == 3) {
            this.T = Math.min(this.T, i16);
        }
        int i17 = this.f15194y;
        if (i17 > 0 && iArr[1] == 3) {
            this.U = Math.min(this.U, i17);
        }
        int i18 = this.T;
        if (i11 != i18) {
            this.f15170h = i18;
        }
        int i19 = this.U;
        if (i12 != i19) {
            this.i = i19;
        }
    }

    public final void a(f fVar, u2.c cVar, HashSet hashSet, int i, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            h.b(fVar, cVar, this);
            hashSet.remove(this);
            b(cVar, fVar.S(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.H.f15150a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f15153d.a(fVar, cVar, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.J.f15150a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f15153d.a(fVar, cVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.I.f15150a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f15153d.a(fVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.K.f15150a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f15153d.a(fVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.L.f15150a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f15153d.a(fVar, cVar, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fd  */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v17 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r58v0, types: [w2.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(u2.c r59, boolean r60) {
        /*
            Method dump skipped, instructions count: 1910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e.b(u2.c, boolean):void");
    }

    public boolean c() {
        return this.f0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0493 A[PHI: r0
      0x0493: PHI (r0v15 int) = (r0v14 int), (r0v19 int), (r0v19 int), (r0v19 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(u2.c r30, boolean r31, boolean r32, boolean r33, boolean r34, u2.e r35, u2.e r36, int r37, boolean r38, w2.d r39, w2.d r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e.d(u2.c, boolean, boolean, boolean, boolean, u2.e, u2.e, int, boolean, w2.d, w2.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(u2.c cVar) {
        cVar.k(this.H);
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        if (this.Z > 0) {
            cVar.k(this.L);
        }
    }

    public final void f() {
        if (this.f15164d == null) {
            j jVar = new j(this);
            jVar.f15565h.f15538e = 4;
            jVar.i.f15538e = 5;
            jVar.f15563f = 0;
            this.f15164d = jVar;
        }
        if (this.f15166e == null) {
            l lVar = new l(this);
            x2.e eVar = new x2.e(lVar);
            lVar.f15550k = eVar;
            lVar.f15551l = null;
            lVar.f15565h.f15538e = 6;
            lVar.i.f15538e = 7;
            eVar.f15538e = 8;
            lVar.f15563f = 1;
            this.f15166e = lVar;
        }
    }

    public d g(int i) {
        switch (s.f.c(i)) {
            case 0:
                return null;
            case 1:
                return this.H;
            case 2:
                return this.I;
            case 3:
                return this.J;
            case 4:
                return this.K;
            case 5:
                return this.L;
            case 6:
                return this.O;
            case 7:
                return this.M;
            case 8:
                return this.N;
            default:
                throw new AssertionError(c.e(i));
        }
    }

    public final int h(int i) {
        int[] iArr = this.f15184o0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int i() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final e j(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.K).f15155f) != null && dVar2.f15155f == dVar) {
                return dVar2.f15153d;
            }
            return null;
        }
        d dVar3 = this.J;
        d dVar4 = dVar3.f15155f;
        if (dVar4 == null || dVar4.f15155f != dVar3) {
            return null;
        }
        return dVar4.f15153d;
    }

    public final e k(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.I).f15155f) != null && dVar2.f15155f == dVar) {
                return dVar2.f15153d;
            }
            return null;
        }
        d dVar3 = this.H;
        d dVar4 = dVar3.f15155f;
        if (dVar4 == null || dVar4.f15155f != dVar3) {
            return null;
        }
        return dVar4.f15153d;
    }

    public void l(StringBuilder sb2) {
        sb2.append("  " + this.f15173j + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.T);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.U);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.X);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.Y);
        sb2.append("\n");
        n(sb2, "left", this.H);
        n(sb2, "top", this.I);
        n(sb2, "right", this.J);
        n(sb2, "bottom", this.K);
        n(sb2, "baseline", this.L);
        n(sb2, "centerX", this.M);
        n(sb2, "centerY", this.N);
        int i = this.T;
        int i3 = this.f15159a0;
        int[] iArr = this.C;
        int i10 = iArr[0];
        int i11 = this.f15190u;
        int i12 = this.f15187r;
        float f5 = this.f15192w;
        float[] fArr = this.f15174j0;
        float f10 = fArr[0];
        m(sb2, "    width", i, i3, i10, i11, i12, f5);
        int i13 = this.U;
        int i14 = this.f15161b0;
        int i15 = iArr[1];
        int i16 = this.f15193x;
        int i17 = this.f15188s;
        float f11 = this.f15195z;
        float f12 = fArr[1];
        m(sb2, "    height", i13, i14, i15, i16, i17, f11);
        float f13 = this.V;
        int i18 = this.W;
        if (f13 != 0.0f) {
            sb2.append("    dimensionRatio");
            sb2.append(" :  [");
            sb2.append(f13);
            sb2.append(",");
            sb2.append(i18);
            sb2.append("");
            sb2.append("],\n");
        }
        E(sb2, "    horizontalBias", this.f15163c0, 0.5f);
        E(sb2, "    verticalBias", this.f15165d0, 0.5f);
        D("    horizontalChainStyle", this.f15171h0, 0, sb2);
        D("    verticalChainStyle", this.f15172i0, 0, sb2);
        sb2.append("  }");
    }

    public final int o() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.T;
    }

    public final int p() {
        e eVar = this.S;
        return (eVar == null || !(eVar instanceof f)) ? this.X : ((f) eVar).f15203w0 + this.X;
    }

    public final int q() {
        e eVar = this.S;
        return (eVar == null || !(eVar instanceof f)) ? this.Y : ((f) eVar).f15204x0 + this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            w2.d r5 = r4.H
            w2.d r5 = r5.f15155f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            w2.d r4 = r4.J
            w2.d r4 = r4.f15155f
            if (r4 == 0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = r1
        L17:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            w2.d r5 = r4.I
            w2.d r5 = r5.f15155f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            w2.d r3 = r4.K
            w2.d r3 = r3.f15155f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            w2.d r4 = r4.L
            w2.d r4 = r4.f15155f
            if (r4 == 0) goto L36
            r4 = r2
            goto L37
        L36:
            r4 = r1
        L37:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e.r(int):boolean");
    }

    public final boolean s(int i, int i3) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (i == 0) {
            d dVar5 = this.H;
            d dVar6 = dVar5.f15155f;
            if (dVar6 == null || !dVar6.f15152c || (dVar4 = (dVar3 = this.J).f15155f) == null || !dVar4.f15152c) {
                return false;
            }
            return (dVar4.c() - dVar3.d()) - (dVar5.d() + dVar5.f15155f.c()) >= i3;
        }
        d dVar7 = this.I;
        d dVar8 = dVar7.f15155f;
        if (dVar8 == null || !dVar8.f15152c || (dVar2 = (dVar = this.K).f15155f) == null || !dVar2.f15152c) {
            return false;
        }
        return (dVar2.c() - dVar.d()) - (dVar7.d() + dVar7.f15155f.c()) >= i3;
    }

    public final void t(int i, int i3, int i10, int i11, e eVar) {
        g(i).a(eVar.g(i3), i10, i11);
    }

    public String toString() {
        StringBuilder sbC = c.c("");
        sbC.append(this.f15169g0 != null ? androidx.activity.b.n(new StringBuilder("id: "), this.f15169g0, " ") : "");
        sbC.append("(");
        sbC.append(this.X);
        sbC.append(", ");
        sbC.append(this.Y);
        sbC.append(") - (");
        sbC.append(this.T);
        sbC.append(" x ");
        return k0.a.r(sbC, this.U, ")");
    }

    public final boolean u(int i) {
        d dVar;
        d dVar2;
        int i3 = i * 2;
        d[] dVarArr = this.P;
        d dVar3 = dVarArr[i3];
        d dVar4 = dVar3.f15155f;
        return (dVar4 == null || dVar4.f15155f == dVar3 || (dVar2 = (dVar = dVarArr[i3 + 1]).f15155f) == null || dVar2.f15155f != dVar) ? false : true;
    }

    public final boolean v() {
        d dVar = this.H;
        d dVar2 = dVar.f15155f;
        if (dVar2 != null && dVar2.f15155f == dVar) {
            return true;
        }
        d dVar3 = this.J;
        d dVar4 = dVar3.f15155f;
        return dVar4 != null && dVar4.f15155f == dVar3;
    }

    public final boolean w() {
        d dVar = this.I;
        d dVar2 = dVar.f15155f;
        if (dVar2 != null && dVar2.f15155f == dVar) {
            return true;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f15155f;
        return dVar4 != null && dVar4.f15155f == dVar3;
    }

    public final boolean x() {
        return this.f15168g && this.f0 != 8;
    }

    public boolean y() {
        if (this.f15175k) {
            return true;
        }
        return this.H.f15152c && this.J.f15152c;
    }

    public boolean z() {
        if (this.f15177l) {
            return true;
        }
        return this.I.f15152c && this.K.f15152c;
    }
}
