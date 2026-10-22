package v;

import java.util.HashSet;
import v.e;
import w.C1196b;

/* loaded from: classes.dex */
public class l extends j {

    /* renamed from: N0, reason: collision with root package name */
    private int f23200N0 = 0;

    /* renamed from: O0, reason: collision with root package name */
    private int f23201O0 = 0;

    /* renamed from: P0, reason: collision with root package name */
    private int f23202P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    private int f23203Q0 = 0;

    /* renamed from: R0, reason: collision with root package name */
    private int f23204R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    private int f23205S0 = 0;

    /* renamed from: T0, reason: collision with root package name */
    private int f23206T0 = 0;

    /* renamed from: U0, reason: collision with root package name */
    private int f23207U0 = 0;

    /* renamed from: V0, reason: collision with root package name */
    private boolean f23208V0 = false;

    /* renamed from: W0, reason: collision with root package name */
    private int f23209W0 = 0;

    /* renamed from: X0, reason: collision with root package name */
    private int f23210X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    protected C1196b.a f23211Y0 = new C1196b.a();

    /* renamed from: Z0, reason: collision with root package name */
    C1196b.InterfaceC0254b f23212Z0 = null;

    public int A1() {
        return this.f23207U0;
    }

    public int B1() {
        return this.f23200N0;
    }

    public void C1(int i5, int i6, int i7, int i8) {
    }

    protected void D1(e eVar, e.b bVar, int i5, e.b bVar2, int i6) {
        while (this.f23212Z0 == null && K() != null) {
            this.f23212Z0 = ((f) K()).I1();
        }
        C1196b.a aVar = this.f23211Y0;
        aVar.f23395a = bVar;
        aVar.f23396b = bVar2;
        aVar.f23397c = i5;
        aVar.f23398d = i6;
        this.f23212Z0.b(eVar, aVar);
        eVar.k1(this.f23211Y0.f23399e);
        eVar.L0(this.f23211Y0.f23400f);
        eVar.K0(this.f23211Y0.f23402h);
        eVar.A0(this.f23211Y0.f23401g);
    }

    protected boolean E1() {
        e eVar = this.f23057a0;
        C1196b.InterfaceC0254b interfaceC0254bI1 = eVar != null ? ((f) eVar).I1() : null;
        if (interfaceC0254bI1 == null) {
            return false;
        }
        for (int i5 = 0; i5 < this.f23198M0; i5++) {
            e eVar2 = this.f23197L0[i5];
            if (eVar2 != null && !(eVar2 instanceof h)) {
                e.b bVarU = eVar2.u(0);
                e.b bVarU2 = eVar2.u(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarU != bVar || eVar2.f23100w == 1 || bVarU2 != bVar || eVar2.f23102x == 1) {
                    if (bVarU == bVar) {
                        bVarU = e.b.WRAP_CONTENT;
                    }
                    if (bVarU2 == bVar) {
                        bVarU2 = e.b.WRAP_CONTENT;
                    }
                    C1196b.a aVar = this.f23211Y0;
                    aVar.f23395a = bVarU;
                    aVar.f23396b = bVarU2;
                    aVar.f23397c = eVar2.W();
                    this.f23211Y0.f23398d = eVar2.x();
                    interfaceC0254bI1.b(eVar2, this.f23211Y0);
                    eVar2.k1(this.f23211Y0.f23399e);
                    eVar2.L0(this.f23211Y0.f23400f);
                    eVar2.A0(this.f23211Y0.f23401g);
                }
            }
        }
        return true;
    }

    public boolean F1() {
        return this.f23208V0;
    }

    protected void G1(boolean z5) {
        this.f23208V0 = z5;
    }

    public void H1(int i5, int i6) {
        this.f23209W0 = i5;
        this.f23210X0 = i6;
    }

    public void I1(int i5) {
        this.f23202P0 = i5;
        this.f23200N0 = i5;
        this.f23203Q0 = i5;
        this.f23201O0 = i5;
        this.f23204R0 = i5;
        this.f23205S0 = i5;
    }

    public void J1(int i5) {
        this.f23201O0 = i5;
    }

    public void K1(int i5) {
        this.f23205S0 = i5;
    }

    public void L1(int i5) {
        this.f23202P0 = i5;
        this.f23206T0 = i5;
    }

    public void M1(int i5) {
        this.f23203Q0 = i5;
        this.f23207U0 = i5;
    }

    public void N1(int i5) {
        this.f23204R0 = i5;
        this.f23206T0 = i5;
        this.f23207U0 = i5;
    }

    public void O1(int i5) {
        this.f23200N0 = i5;
    }

    @Override // v.j, v.i
    public void c(f fVar) {
        u1();
    }

    public void t1(boolean z5) {
        int i5 = this.f23204R0;
        if (i5 > 0 || this.f23205S0 > 0) {
            if (z5) {
                this.f23206T0 = this.f23205S0;
                this.f23207U0 = i5;
            } else {
                this.f23206T0 = i5;
                this.f23207U0 = this.f23205S0;
            }
        }
    }

    public void u1() {
        for (int i5 = 0; i5 < this.f23198M0; i5++) {
            e eVar = this.f23197L0[i5];
            if (eVar != null) {
                eVar.U0(true);
            }
        }
    }

    public boolean v1(HashSet<e> hashSet) {
        for (int i5 = 0; i5 < this.f23198M0; i5++) {
            if (hashSet.contains(this.f23197L0[i5])) {
                return true;
            }
        }
        return false;
    }

    public int w1() {
        return this.f23210X0;
    }

    public int x1() {
        return this.f23209W0;
    }

    public int y1() {
        return this.f23201O0;
    }

    public int z1() {
        return this.f23206T0;
    }
}
