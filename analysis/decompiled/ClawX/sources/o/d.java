package o;

import android.view.View;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p.k;
import p.m;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class d {
    public float A;
    public final int[] B;
    public float C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public final c H;
    public final c I;
    public final c J;
    public final c K;
    public final c L;
    public final c M;
    public final c N;
    public final c O;
    public final c[] P;
    public final ArrayList Q;
    public final boolean[] R;
    public d S;
    public int T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f4213a0;

    /* renamed from: b, reason: collision with root package name */
    public p.c f4214b;

    /* renamed from: b0, reason: collision with root package name */
    public int f4215b0;

    /* renamed from: c, reason: collision with root package name */
    public p.c f4216c;

    /* renamed from: c0, reason: collision with root package name */
    public float f4217c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f4218d0;

    /* renamed from: e0, reason: collision with root package name */
    public View f4220e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f4222f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f4224g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f4226h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f4228i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4229j;

    /* renamed from: j0, reason: collision with root package name */
    public final float[] f4230j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4231k;
    public final d[] k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4232l;

    /* renamed from: l0, reason: collision with root package name */
    public final d[] f4233l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4234m;

    /* renamed from: m0, reason: collision with root package name */
    public int f4235m0;

    /* renamed from: n, reason: collision with root package name */
    public int f4236n;

    /* renamed from: n0, reason: collision with root package name */
    public int f4237n0;

    /* renamed from: o, reason: collision with root package name */
    public int f4238o;

    /* renamed from: o0, reason: collision with root package name */
    public final int[] f4239o0;

    /* renamed from: p, reason: collision with root package name */
    public int f4240p;

    /* renamed from: q, reason: collision with root package name */
    public int f4241q;

    /* renamed from: r, reason: collision with root package name */
    public int f4242r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f4243s;

    /* renamed from: t, reason: collision with root package name */
    public int f4244t;

    /* renamed from: u, reason: collision with root package name */
    public int f4245u;

    /* renamed from: v, reason: collision with root package name */
    public float f4246v;

    /* renamed from: w, reason: collision with root package name */
    public int f4247w;

    /* renamed from: x, reason: collision with root package name */
    public int f4248x;
    public float y;
    public int z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f4212a = false;
    public k d = null;

    /* renamed from: e, reason: collision with root package name */
    public m f4219e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f4221f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f4223g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f4225h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f4227i = -1;

    public d() {
        new HashMap();
        this.f4229j = false;
        this.f4231k = false;
        this.f4232l = false;
        this.f4234m = false;
        this.f4236n = -1;
        this.f4238o = -1;
        this.f4240p = 0;
        this.f4241q = 0;
        this.f4242r = 0;
        this.f4243s = new int[2];
        this.f4244t = 0;
        this.f4245u = 0;
        this.f4246v = 1.0f;
        this.f4247w = 0;
        this.f4248x = 0;
        this.y = 1.0f;
        this.z = -1;
        this.A = 1.0f;
        this.B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.C = 0.0f;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        c cVar = new c(this, 2);
        this.H = cVar;
        c cVar2 = new c(this, 3);
        this.I = cVar2;
        c cVar3 = new c(this, 4);
        this.J = cVar3;
        c cVar4 = new c(this, 5);
        this.K = cVar4;
        c cVar5 = new c(this, 6);
        this.L = cVar5;
        c cVar6 = new c(this, 8);
        this.M = cVar6;
        c cVar7 = new c(this, 9);
        this.N = cVar7;
        c cVar8 = new c(this, 7);
        this.O = cVar8;
        this.P = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar8};
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        this.R = new boolean[2];
        this.f4239o0 = new int[]{1, 1};
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f4217c0 = 0.5f;
        this.f4218d0 = 0.5f;
        this.f4222f0 = 0;
        this.f4224g0 = null;
        this.f4226h0 = 0;
        this.f4228i0 = 0;
        this.f4230j0 = new float[]{-1.0f, -1.0f};
        this.k0 = new d[]{null, null};
        this.f4233l0 = new d[]{null, null};
        this.f4235m0 = -1;
        this.f4237n0 = -1;
        arrayList.add(cVar);
        arrayList.add(cVar2);
        arrayList.add(cVar3);
        arrayList.add(cVar4);
        arrayList.add(cVar6);
        arrayList.add(cVar7);
        arrayList.add(cVar8);
        arrayList.add(cVar5);
    }

    public final void A() {
        d dVar = this.S;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((c) arrayList.get(i8)).j();
        }
    }

    public final void B() {
        this.f4229j = false;
        this.f4231k = false;
        this.f4232l = false;
        this.f4234m = false;
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            c cVar = (c) arrayList.get(i8);
            cVar.f4206c = false;
            cVar.f4205b = 0;
        }
    }

    public void C(a4.d dVar) {
        this.H.k();
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.O.k();
        this.M.k();
        this.N.k();
    }

    public final void D(int i8) {
        this.Z = i8;
        this.D = i8 > 0;
    }

    public final void E(int i8, int i9) {
        if (this.f4229j) {
            return;
        }
        this.H.l(i8);
        this.J.l(i9);
        this.X = i8;
        this.T = i9 - i8;
        this.f4229j = true;
    }

    public final void F(int i8, int i9) {
        if (this.f4231k) {
            return;
        }
        this.I.l(i8);
        this.K.l(i9);
        this.Y = i8;
        this.U = i9 - i8;
        if (this.D) {
            this.L.l(i8 + this.Z);
        }
        this.f4231k = true;
    }

    public final void G(int i8) {
        this.U = i8;
        int i9 = this.f4215b0;
        if (i8 < i9) {
            this.U = i9;
        }
    }

    public final void H(int i8) {
        this.f4239o0[0] = i8;
    }

    public final void I(int i8) {
        this.f4239o0[1] = i8;
    }

    public final void J(int i8) {
        this.T = i8;
        int i9 = this.f4213a0;
        if (i8 < i9) {
            this.T = i9;
        }
    }

    public void K(boolean z, boolean z2) {
        int i8;
        int i9;
        k kVar = this.d;
        boolean z8 = z & kVar.f4638g;
        m mVar = this.f4219e;
        boolean z9 = z2 & mVar.f4638g;
        int i10 = kVar.f4639h.f4615g;
        int i11 = mVar.f4639h.f4615g;
        int i12 = kVar.f4640i.f4615g;
        int i13 = mVar.f4640i.f4615g;
        int i14 = i13 - i11;
        if (i12 - i10 < 0 || i14 < 0 || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
            i12 = 0;
            i13 = 0;
            i10 = 0;
            i11 = 0;
        }
        int i15 = i12 - i10;
        int i16 = i13 - i11;
        if (z8) {
            this.X = i10;
        }
        if (z9) {
            this.Y = i11;
        }
        if (this.f4222f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f4239o0;
        if (z8) {
            if (iArr[0] == 1 && i15 < (i9 = this.T)) {
                i15 = i9;
            }
            this.T = i15;
            int i17 = this.f4213a0;
            if (i15 < i17) {
                this.T = i17;
            }
        }
        if (z9) {
            if (iArr[1] == 1 && i16 < (i8 = this.U)) {
                i16 = i8;
            }
            this.U = i16;
            int i18 = this.f4215b0;
            if (i16 < i18) {
                this.U = i18;
            }
        }
    }

    public void L(m.c cVar, boolean z) {
        int i8;
        int i9;
        m mVar;
        k kVar;
        cVar.getClass();
        int iN = m.c.n(this.H);
        int iN2 = m.c.n(this.I);
        int iN3 = m.c.n(this.J);
        int iN4 = m.c.n(this.K);
        if (z && (kVar = this.d) != null) {
            p.f fVar = kVar.f4639h;
            if (fVar.f4618j) {
                p.f fVar2 = kVar.f4640i;
                if (fVar2.f4618j) {
                    iN = fVar.f4615g;
                    iN3 = fVar2.f4615g;
                }
            }
        }
        if (z && (mVar = this.f4219e) != null) {
            p.f fVar3 = mVar.f4639h;
            if (fVar3.f4618j) {
                p.f fVar4 = mVar.f4640i;
                if (fVar4.f4618j) {
                    iN2 = fVar3.f4615g;
                    iN4 = fVar4.f4615g;
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
        if (this.f4222f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.f4239o0;
        int i13 = iArr[0];
        if (i13 == 1 && i11 < (i9 = this.T)) {
            i11 = i9;
        }
        if (iArr[1] == 1 && i12 < (i8 = this.U)) {
            i12 = i8;
        }
        this.T = i11;
        this.U = i12;
        int i14 = this.f4215b0;
        if (i12 < i14) {
            this.U = i14;
        }
        int i15 = this.f4213a0;
        if (i11 < i15) {
            this.T = i15;
        }
        int i16 = this.f4245u;
        if (i16 > 0 && i13 == 3) {
            this.T = Math.min(this.T, i16);
        }
        int i17 = this.f4248x;
        if (i17 > 0 && iArr[1] == 3) {
            this.U = Math.min(this.U, i17);
        }
        int i18 = this.T;
        if (i11 != i18) {
            this.f4225h = i18;
        }
        int i19 = this.U;
        if (i12 != i19) {
            this.f4227i = i19;
        }
    }

    public final void a(e eVar, m.c cVar, HashSet hashSet, int i8, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.b(eVar, cVar, this);
            hashSet.remove(this);
            b(cVar, eVar.R(64));
        }
        if (i8 == 0) {
            HashSet hashSet2 = this.H.f4204a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).d.a(eVar, cVar, hashSet, i8, true);
                }
            }
            HashSet hashSet3 = this.J.f4204a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).d.a(eVar, cVar, hashSet, i8, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.I.f4204a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((c) it3.next()).d.a(eVar, cVar, hashSet, i8, true);
            }
        }
        HashSet hashSet5 = this.K.f4204a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((c) it4.next()).d.a(eVar, cVar, hashSet, i8, true);
            }
        }
        HashSet hashSet6 = this.L.f4204a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((c) it5.next()).d.a(eVar, cVar, hashSet, i8, true);
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
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c5  */
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
    /* JADX WARN: Type inference failed for: r58v0, types: [o.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(m.c r59, boolean r60) {
        /*
            Method dump skipped, instructions count: 1912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.d.b(m.c, boolean):void");
    }

    public boolean c() {
        return this.f4222f0 != 8;
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
    public final void d(m.c r30, boolean r31, boolean r32, boolean r33, boolean r34, m.g r35, m.g r36, int r37, boolean r38, o.c r39, o.c r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.d.d(m.c, boolean, boolean, boolean, boolean, m.g, m.g, int, boolean, o.c, o.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i8, d dVar, int i9, int i10) {
        boolean z;
        if (i8 == 7) {
            if (i9 != 7) {
                if (i9 == 2 || i9 == 4) {
                    e(2, dVar, i9, 0);
                    e(4, dVar, i9, 0);
                    i(7).a(dVar.i(i9), 0);
                    return;
                } else {
                    if (i9 == 3 || i9 == 5) {
                        e(3, dVar, i9, 0);
                        e(5, dVar, i9, 0);
                        i(7).a(dVar.i(i9), 0);
                        return;
                    }
                    return;
                }
            }
            c cVarI = i(2);
            c cVarI2 = i(4);
            c cVarI3 = i(3);
            c cVarI4 = i(5);
            boolean z2 = true;
            if ((cVarI == null || !cVarI.h()) && (cVarI2 == null || !cVarI2.h())) {
                e(2, dVar, 2, 0);
                e(4, dVar, 4, 0);
                z = true;
            } else {
                z = false;
            }
            if ((cVarI3 == null || !cVarI3.h()) && (cVarI4 == null || !cVarI4.h())) {
                e(3, dVar, 3, 0);
                e(5, dVar, 5, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                i(7).a(dVar.i(7), 0);
                return;
            } else if (z) {
                i(8).a(dVar.i(8), 0);
                return;
            } else {
                if (z2) {
                    i(9).a(dVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i8 == 8 && (i9 == 2 || i9 == 4)) {
            c cVarI5 = i(2);
            c cVarI6 = dVar.i(i9);
            c cVarI7 = i(4);
            cVarI5.a(cVarI6, 0);
            cVarI7.a(cVarI6, 0);
            i(8).a(cVarI6, 0);
            return;
        }
        if (i8 == 9 && (i9 == 3 || i9 == 5)) {
            c cVarI8 = dVar.i(i9);
            i(3).a(cVarI8, 0);
            i(5).a(cVarI8, 0);
            i(9).a(cVarI8, 0);
            return;
        }
        if (i8 == 8 && i9 == 8) {
            i(2).a(dVar.i(2), 0);
            i(4).a(dVar.i(4), 0);
            i(8).a(dVar.i(i9), 0);
            return;
        }
        if (i8 == 9 && i9 == 9) {
            i(3).a(dVar.i(3), 0);
            i(5).a(dVar.i(5), 0);
            i(9).a(dVar.i(i9), 0);
            return;
        }
        c cVarI9 = i(i8);
        c cVarI10 = dVar.i(i9);
        if (cVarI9.i(cVarI10)) {
            if (i8 == 6) {
                c cVarI11 = i(3);
                c cVarI12 = i(5);
                if (cVarI11 != null) {
                    cVarI11.j();
                }
                if (cVarI12 != null) {
                    cVarI12.j();
                }
            } else if (i8 == 3 || i8 == 5) {
                c cVarI13 = i(6);
                if (cVarI13 != null) {
                    cVarI13.j();
                }
                c cVarI14 = i(7);
                if (cVarI14.f4208f != cVarI10) {
                    cVarI14.j();
                }
                c cVarF = i(i8).f();
                c cVarI15 = i(9);
                if (cVarI15.h()) {
                    cVarF.j();
                    cVarI15.j();
                }
            } else if (i8 == 2 || i8 == 4) {
                c cVarI16 = i(7);
                if (cVarI16.f4208f != cVarI10) {
                    cVarI16.j();
                }
                c cVarF2 = i(i8).f();
                c cVarI17 = i(8);
                if (cVarI17.h()) {
                    cVarF2.j();
                    cVarI17.j();
                }
            }
            cVarI9.a(cVarI10, i10);
        }
    }

    public final void f(c cVar, c cVar2, int i8) {
        if (cVar.d == this) {
            e(cVar.f4207e, cVar2.d, cVar2.f4207e, i8);
        }
    }

    public final void g(m.c cVar) {
        cVar.k(this.H);
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        if (this.Z > 0) {
            cVar.k(this.L);
        }
    }

    public final void h() {
        if (this.d == null) {
            k kVar = new k(this);
            kVar.f4639h.f4613e = 4;
            kVar.f4640i.f4613e = 5;
            kVar.f4637f = 0;
            this.d = kVar;
        }
        if (this.f4219e == null) {
            m mVar = new m(this);
            p.f fVar = new p.f(mVar);
            mVar.f4626k = fVar;
            mVar.f4627l = null;
            mVar.f4639h.f4613e = 6;
            mVar.f4640i.f4613e = 7;
            fVar.f4613e = 8;
            mVar.f4637f = 1;
            this.f4219e = mVar;
        }
    }

    public c i(int i8) {
        switch (m.f.a(i8)) {
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
                throw new AssertionError(m0.f.n(i8));
        }
    }

    public final int j(int i8) {
        int[] iArr = this.f4239o0;
        if (i8 == 0) {
            return iArr[0];
        }
        if (i8 == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.f4222f0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final d l(int i8) {
        c cVar;
        c cVar2;
        if (i8 != 0) {
            if (i8 == 1 && (cVar2 = (cVar = this.K).f4208f) != null && cVar2.f4208f == cVar) {
                return cVar2.d;
            }
            return null;
        }
        c cVar3 = this.J;
        c cVar4 = cVar3.f4208f;
        if (cVar4 == null || cVar4.f4208f != cVar3) {
            return null;
        }
        return cVar4.d;
    }

    public final d m(int i8) {
        c cVar;
        c cVar2;
        if (i8 != 0) {
            if (i8 == 1 && (cVar2 = (cVar = this.I).f4208f) != null && cVar2.f4208f == cVar) {
                return cVar2.d;
            }
            return null;
        }
        c cVar3 = this.H;
        c cVar4 = cVar3.f4208f;
        if (cVar4 == null || cVar4.f4208f != cVar3) {
            return null;
        }
        return cVar4.d;
    }

    public final int n() {
        if (this.f4222f0 == 8) {
            return 0;
        }
        return this.T;
    }

    public final int o() {
        d dVar = this.S;
        return (dVar == null || !(dVar instanceof e)) ? this.X : ((e) dVar).f4256w0 + this.X;
    }

    public final int p() {
        d dVar = this.S;
        return (dVar == null || !(dVar instanceof e)) ? this.Y : ((e) dVar).f4257x0 + this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            o.c r5 = r4.H
            o.c r5 = r5.f4208f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            o.c r4 = r4.J
            o.c r4 = r4.f4208f
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
            o.c r5 = r4.I
            o.c r5 = r5.f4208f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            o.c r3 = r4.K
            o.c r3 = r3.f4208f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            o.c r4 = r4.L
            o.c r4 = r4.f4208f
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
        throw new UnsupportedOperationException("Method not decompiled: o.d.q(int):boolean");
    }

    public final boolean r(int i8, int i9) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if (i8 == 0) {
            c cVar5 = this.H;
            c cVar6 = cVar5.f4208f;
            if (cVar6 == null || !cVar6.f4206c || (cVar4 = (cVar3 = this.J).f4208f) == null || !cVar4.f4206c) {
                return false;
            }
            return (cVar4.d() - cVar3.e()) - (cVar5.e() + cVar5.f4208f.d()) >= i9;
        }
        c cVar7 = this.I;
        c cVar8 = cVar7.f4208f;
        if (cVar8 == null || !cVar8.f4206c || (cVar2 = (cVar = this.K).f4208f) == null || !cVar2.f4206c) {
            return false;
        }
        return (cVar2.d() - cVar.e()) - (cVar7.e() + cVar7.f4208f.d()) >= i9;
    }

    public final void s(int i8, int i9, int i10, int i11, d dVar) {
        i(i8).b(dVar.i(i9), i10, i11, true);
    }

    public final boolean t(int i8) {
        c cVar;
        c cVar2;
        int i9 = i8 * 2;
        c[] cVarArr = this.P;
        c cVar3 = cVarArr[i9];
        c cVar4 = cVar3.f4208f;
        return (cVar4 == null || cVar4.f4208f == cVar3 || (cVar2 = (cVar = cVarArr[i9 + 1]).f4208f) == null || cVar2.f4208f != cVar) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strF = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        sb.append(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        if (this.f4224g0 != null) {
            strF = m0.f.f(new StringBuilder("id: "), this.f4224g0, " ");
        }
        sb.append(strF);
        sb.append("(");
        sb.append(this.X);
        sb.append(", ");
        sb.append(this.Y);
        sb.append(") - (");
        sb.append(this.T);
        sb.append(" x ");
        return m0.f.e(sb, this.U, ")");
    }

    public final boolean u() {
        c cVar = this.H;
        c cVar2 = cVar.f4208f;
        if (cVar2 != null && cVar2.f4208f == cVar) {
            return true;
        }
        c cVar3 = this.J;
        c cVar4 = cVar3.f4208f;
        return cVar4 != null && cVar4.f4208f == cVar3;
    }

    public final boolean v() {
        c cVar = this.I;
        c cVar2 = cVar.f4208f;
        if (cVar2 != null && cVar2.f4208f == cVar) {
            return true;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f4208f;
        return cVar4 != null && cVar4.f4208f == cVar3;
    }

    public final boolean w() {
        return this.f4223g && this.f4222f0 != 8;
    }

    public boolean x() {
        if (this.f4229j) {
            return true;
        }
        return this.H.f4206c && this.J.f4206c;
    }

    public boolean y() {
        if (this.f4231k) {
            return true;
        }
        return this.I.f4206c && this.K.f4206c;
    }

    public void z() {
        this.H.j();
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.S = null;
        this.C = 0.0f;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f4213a0 = 0;
        this.f4215b0 = 0;
        this.f4217c0 = 0.5f;
        this.f4218d0 = 0.5f;
        int[] iArr = this.f4239o0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f4220e0 = null;
        this.f4222f0 = 0;
        this.f4226h0 = 0;
        this.f4228i0 = 0;
        float[] fArr = this.f4230j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f4236n = -1;
        this.f4238o = -1;
        int[] iArr2 = this.B;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f4241q = 0;
        this.f4242r = 0;
        this.f4246v = 1.0f;
        this.y = 1.0f;
        this.f4245u = Integer.MAX_VALUE;
        this.f4248x = Integer.MAX_VALUE;
        this.f4244t = 0;
        this.f4247w = 0;
        this.z = -1;
        this.A = 1.0f;
        boolean[] zArr = this.f4221f;
        zArr[0] = true;
        zArr[1] = true;
        this.E = false;
        boolean[] zArr2 = this.R;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f4223g = true;
        int[] iArr3 = this.f4243s;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f4225h = -1;
        this.f4227i = -1;
    }
}
