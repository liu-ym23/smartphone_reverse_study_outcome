package v;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import v.e;
import w.C1196b;
import w.C1199e;

/* loaded from: classes.dex */
public class f extends m {

    /* renamed from: O0, reason: collision with root package name */
    private int f23117O0;

    /* renamed from: S0, reason: collision with root package name */
    int f23121S0;

    /* renamed from: T0, reason: collision with root package name */
    int f23122T0;

    /* renamed from: U0, reason: collision with root package name */
    int f23123U0;

    /* renamed from: V0, reason: collision with root package name */
    int f23124V0;

    /* renamed from: M0, reason: collision with root package name */
    C1196b f23115M0 = new C1196b(this);

    /* renamed from: N0, reason: collision with root package name */
    public C1199e f23116N0 = new C1199e(this);

    /* renamed from: P0, reason: collision with root package name */
    protected C1196b.InterfaceC0254b f23118P0 = null;

    /* renamed from: Q0, reason: collision with root package name */
    private boolean f23119Q0 = false;

    /* renamed from: R0, reason: collision with root package name */
    protected s.d f23120R0 = new s.d();

    /* renamed from: W0, reason: collision with root package name */
    public int f23125W0 = 0;

    /* renamed from: X0, reason: collision with root package name */
    public int f23126X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    c[] f23127Y0 = new c[4];

    /* renamed from: Z0, reason: collision with root package name */
    c[] f23128Z0 = new c[4];

    /* renamed from: a1, reason: collision with root package name */
    public boolean f23129a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f23130b1 = false;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f23131c1 = false;

    /* renamed from: d1, reason: collision with root package name */
    public int f23132d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    public int f23133e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    private int f23134f1 = 257;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f23135g1 = false;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f23136h1 = false;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f23137i1 = false;

    /* renamed from: j1, reason: collision with root package name */
    int f23138j1 = 0;

    /* renamed from: k1, reason: collision with root package name */
    private WeakReference<d> f23139k1 = null;

    /* renamed from: l1, reason: collision with root package name */
    private WeakReference<d> f23140l1 = null;

    /* renamed from: m1, reason: collision with root package name */
    private WeakReference<d> f23141m1 = null;

    /* renamed from: n1, reason: collision with root package name */
    private WeakReference<d> f23142n1 = null;

    /* renamed from: o1, reason: collision with root package name */
    HashSet<e> f23143o1 = new HashSet<>();

    /* renamed from: p1, reason: collision with root package name */
    public C1196b.a f23144p1 = new C1196b.a();

    private void A1(d dVar, s.i iVar) {
        this.f23120R0.h(iVar, this.f23120R0.q(dVar), 0, 5);
    }

    private void B1(d dVar, s.i iVar) {
        this.f23120R0.h(this.f23120R0.q(dVar), iVar, 0, 5);
    }

    private void C1(e eVar) {
        int i5 = this.f23126X0 + 1;
        c[] cVarArr = this.f23127Y0;
        if (i5 >= cVarArr.length) {
            this.f23127Y0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f23127Y0[this.f23126X0] = new c(eVar, 1, P1());
        this.f23126X0++;
    }

    public static boolean S1(int i5, e eVar, C1196b.InterfaceC0254b interfaceC0254b, C1196b.a aVar, int i6) {
        int i7;
        int i8;
        if (interfaceC0254b == null) {
            return false;
        }
        if (eVar.V() == 8 || (eVar instanceof h) || (eVar instanceof C1177a)) {
            aVar.f23399e = 0;
            aVar.f23400f = 0;
            return false;
        }
        aVar.f23395a = eVar.A();
        aVar.f23396b = eVar.T();
        aVar.f23397c = eVar.W();
        aVar.f23398d = eVar.x();
        aVar.f23403i = false;
        aVar.f23404j = i6;
        e.b bVar = aVar.f23395a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z5 = bVar == bVar2;
        boolean z6 = aVar.f23396b == bVar2;
        boolean z7 = z5 && eVar.f23063d0 > 0.0f;
        boolean z8 = z6 && eVar.f23063d0 > 0.0f;
        if (z5 && eVar.a0(0) && eVar.f23100w == 0 && !z7) {
            aVar.f23395a = e.b.WRAP_CONTENT;
            if (z6 && eVar.f23102x == 0) {
                aVar.f23395a = e.b.FIXED;
            }
            z5 = false;
        }
        if (z6 && eVar.a0(1) && eVar.f23102x == 0 && !z8) {
            aVar.f23396b = e.b.WRAP_CONTENT;
            if (z5 && eVar.f23100w == 0) {
                aVar.f23396b = e.b.FIXED;
            }
            z6 = false;
        }
        if (eVar.n0()) {
            aVar.f23395a = e.b.FIXED;
            z5 = false;
        }
        if (eVar.o0()) {
            aVar.f23396b = e.b.FIXED;
            z6 = false;
        }
        if (z7) {
            if (eVar.f23104y[0] == 4) {
                aVar.f23395a = e.b.FIXED;
            } else if (!z6) {
                e.b bVar3 = aVar.f23396b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i8 = aVar.f23398d;
                } else {
                    aVar.f23395a = e.b.WRAP_CONTENT;
                    interfaceC0254b.b(eVar, aVar);
                    i8 = aVar.f23400f;
                }
                aVar.f23395a = bVar4;
                aVar.f23397c = (int) (eVar.v() * i8);
            }
        }
        if (z8) {
            if (eVar.f23104y[1] == 4) {
                aVar.f23396b = e.b.FIXED;
            } else if (!z5) {
                e.b bVar5 = aVar.f23395a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i7 = aVar.f23397c;
                } else {
                    aVar.f23396b = e.b.WRAP_CONTENT;
                    interfaceC0254b.b(eVar, aVar);
                    i7 = aVar.f23399e;
                }
                aVar.f23396b = bVar6;
                if (eVar.w() == -1) {
                    aVar.f23398d = (int) (i7 / eVar.v());
                } else {
                    aVar.f23398d = (int) (eVar.v() * i7);
                }
            }
        }
        interfaceC0254b.b(eVar, aVar);
        eVar.k1(aVar.f23399e);
        eVar.L0(aVar.f23400f);
        eVar.K0(aVar.f23402h);
        eVar.A0(aVar.f23401g);
        aVar.f23404j = C1196b.a.f23392k;
        return aVar.f23403i;
    }

    private void U1() {
        this.f23125W0 = 0;
        this.f23126X0 = 0;
    }

    private void x1(e eVar) {
        int i5 = this.f23125W0 + 1;
        c[] cVarArr = this.f23128Z0;
        if (i5 >= cVarArr.length) {
            this.f23128Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f23128Z0[this.f23125W0] = new c(eVar, 0, P1());
        this.f23125W0++;
    }

    void D1(d dVar) {
        WeakReference<d> weakReference = this.f23141m1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > this.f23141m1.get().e()) {
            this.f23141m1 = new WeakReference<>(dVar);
        }
    }

    void E1(d dVar) {
        WeakReference<d> weakReference = this.f23139k1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > this.f23139k1.get().e()) {
            this.f23139k1 = new WeakReference<>(dVar);
        }
    }

    public boolean F1(boolean z5) {
        return this.f23116N0.f(z5);
    }

    public boolean G1(boolean z5) {
        return this.f23116N0.g(z5);
    }

    public boolean H1(boolean z5, int i5) {
        return this.f23116N0.h(z5, i5);
    }

    public C1196b.InterfaceC0254b I1() {
        return this.f23118P0;
    }

    public int J1() {
        return this.f23134f1;
    }

    public s.d K1() {
        return this.f23120R0;
    }

    public boolean L1() {
        return false;
    }

    public void M1() {
        this.f23116N0.j();
    }

    public void N1() {
        this.f23116N0.k();
    }

    @Override // v.e
    public void O(StringBuilder sb) {
        sb.append(this.f23084o + ":{\n");
        sb.append("  actualWidth:" + this.f23059b0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f23061c0);
        sb.append("\n");
        ArrayList<e> arrayListR1 = r1();
        int size = arrayListR1.size();
        int i5 = 0;
        while (i5 < size) {
            e eVar = arrayListR1.get(i5);
            i5++;
            eVar.O(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean O1() {
        return this.f23137i1;
    }

    public boolean P1() {
        return this.f23119Q0;
    }

    public boolean Q1() {
        return this.f23136h1;
    }

    public long R1(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f23121S0 = i12;
        this.f23122T0 = i13;
        return this.f23115M0.d(this, i5, i12, i13, i6, i7, i8, i9, i10, i11);
    }

    public boolean T1(int i5) {
        return (this.f23134f1 & i5) == i5;
    }

    public void V1(C1196b.InterfaceC0254b interfaceC0254b) {
        this.f23118P0 = interfaceC0254b;
        this.f23116N0.n(interfaceC0254b);
    }

    public void W1(int i5) {
        this.f23134f1 = i5;
        s.d.f20152r = T1(512);
    }

    public void X1(int i5) {
        this.f23117O0 = i5;
    }

    public void Y1(boolean z5) {
        this.f23119Q0 = z5;
    }

    public boolean Z1(s.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zT1 = T1(64);
        q1(dVar, zT1);
        int size = this.f23213L0.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = this.f23213L0.get(i5);
            eVar.q1(dVar, zT1);
            if (eVar.c0()) {
                z5 = true;
            }
        }
        return z5;
    }

    public void a2() {
        this.f23115M0.e(this);
    }

    @Override // v.e
    public void p1(boolean z5, boolean z6) {
        super.p1(z5, z6);
        int size = this.f23213L0.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f23213L0.get(i5).p1(z5, z6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0329 A[PHI: r13 r19
      0x0329: PHI (r13v9 boolean) = (r13v8 boolean), (r13v11 boolean), (r13v11 boolean), (r13v11 boolean) binds: [B:150:0x02e5, B:159:0x030e, B:160:0x0310, B:162:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0329: PHI (r19v4 boolean) = (r19v3 boolean), (r19v6 boolean), (r19v6 boolean), (r19v6 boolean) binds: [B:150:0x02e5, B:159:0x030e, B:160:0x0310, B:162:0x0316] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0330  */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    @Override // v.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s1() {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.f.s1():void");
    }

    @Override // v.m, v.e
    public void t0() {
        this.f23120R0.D();
        this.f23121S0 = 0;
        this.f23123U0 = 0;
        this.f23122T0 = 0;
        this.f23124V0 = 0;
        this.f23135g1 = false;
        super.t0();
    }

    void v1(e eVar, int i5) {
        if (i5 == 0) {
            x1(eVar);
        } else if (i5 == 1) {
            C1(eVar);
        }
    }

    public boolean w1(s.d dVar) {
        f fVar;
        s.d dVar2;
        boolean zT1 = T1(64);
        g(dVar, zT1);
        int size = this.f23213L0.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = this.f23213L0.get(i5);
            eVar.S0(0, false);
            eVar.S0(1, false);
            if (eVar instanceof C1177a) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i6 = 0; i6 < size; i6++) {
                e eVar2 = this.f23213L0.get(i6);
                if (eVar2 instanceof C1177a) {
                    ((C1177a) eVar2).y1();
                }
            }
        }
        this.f23143o1.clear();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar3 = this.f23213L0.get(i7);
            if (eVar3.f()) {
                if (eVar3 instanceof l) {
                    this.f23143o1.add(eVar3);
                } else {
                    eVar3.g(dVar, zT1);
                }
            }
        }
        while (this.f23143o1.size() > 0) {
            int size2 = this.f23143o1.size();
            Iterator<e> it = this.f23143o1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                l lVar = (l) it.next();
                if (lVar.v1(this.f23143o1)) {
                    lVar.g(dVar, zT1);
                    this.f23143o1.remove(lVar);
                    break;
                }
            }
            if (size2 == this.f23143o1.size()) {
                Iterator<e> it2 = this.f23143o1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(dVar, zT1);
                }
                this.f23143o1.clear();
            }
        }
        if (s.d.f20152r) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i8 = 0; i8 < size; i8++) {
                e eVar4 = this.f23213L0.get(i8);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            fVar = this;
            dVar2 = dVar;
            fVar.e(this, dVar2, hashSet, A() == e.b.WRAP_CONTENT ? 0 : 1, false);
            Iterator<e> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                e next = it3.next();
                k.a(fVar, dVar2, next);
                next.g(dVar2, zT1);
            }
        } else {
            fVar = this;
            dVar2 = dVar;
            for (int i9 = 0; i9 < size; i9++) {
                e eVar5 = fVar.f23213L0.get(i9);
                if (eVar5 instanceof f) {
                    e.b[] bVarArr = eVar5.f23055Z;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar5.P0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar5.g1(e.b.FIXED);
                    }
                    eVar5.g(dVar2, zT1);
                    if (bVar == bVar3) {
                        eVar5.P0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar5.g1(bVar2);
                    }
                } else {
                    k.a(fVar, dVar2, eVar5);
                    if (!eVar5.f()) {
                        eVar5.g(dVar2, zT1);
                    }
                }
            }
        }
        if (fVar.f23125W0 > 0) {
            b.b(fVar, dVar2, null, 0);
        }
        if (fVar.f23126X0 > 0) {
            b.b(fVar, dVar2, null, 1);
        }
        return true;
    }

    public void y1(d dVar) {
        WeakReference<d> weakReference = this.f23142n1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > this.f23142n1.get().e()) {
            this.f23142n1 = new WeakReference<>(dVar);
        }
    }

    public void z1(d dVar) {
        WeakReference<d> weakReference = this.f23140l1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > this.f23140l1.get().e()) {
            this.f23140l1 = new WeakReference<>(dVar);
        }
    }
}
