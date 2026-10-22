package w;

import java.util.ArrayList;

/* loaded from: classes.dex */
class m {

    /* renamed from: h, reason: collision with root package name */
    public static int f23443h;

    /* renamed from: c, reason: collision with root package name */
    p f23446c;

    /* renamed from: d, reason: collision with root package name */
    p f23447d;

    /* renamed from: f, reason: collision with root package name */
    int f23449f;

    /* renamed from: g, reason: collision with root package name */
    int f23450g;

    /* renamed from: a, reason: collision with root package name */
    public int f23444a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f23445b = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<p> f23448e = new ArrayList<>();

    public m(p pVar, int i5) {
        this.f23446c = null;
        this.f23447d = null;
        int i6 = f23443h;
        this.f23449f = i6;
        f23443h = i6 + 1;
        this.f23446c = pVar;
        this.f23447d = pVar;
        this.f23450g = i5;
    }

    private long c(f fVar, long j5) {
        p pVar = fVar.f23419d;
        if (pVar instanceof k) {
            return j5;
        }
        int size = fVar.f23426k.size();
        long jMin = j5;
        for (int i5 = 0; i5 < size; i5++) {
            InterfaceC1198d interfaceC1198d = fVar.f23426k.get(i5);
            if (interfaceC1198d instanceof f) {
                f fVar2 = (f) interfaceC1198d;
                if (fVar2.f23419d != pVar) {
                    jMin = Math.min(jMin, c(fVar2, fVar2.f23421f + j5));
                }
            }
        }
        if (fVar != pVar.f23477i) {
            return jMin;
        }
        long j6 = j5 - pVar.j();
        return Math.min(Math.min(jMin, c(pVar.f23476h, j6)), j6 - pVar.f23476h.f23421f);
    }

    private long d(f fVar, long j5) {
        p pVar = fVar.f23419d;
        if (pVar instanceof k) {
            return j5;
        }
        int size = fVar.f23426k.size();
        long jMax = j5;
        for (int i5 = 0; i5 < size; i5++) {
            InterfaceC1198d interfaceC1198d = fVar.f23426k.get(i5);
            if (interfaceC1198d instanceof f) {
                f fVar2 = (f) interfaceC1198d;
                if (fVar2.f23419d != pVar) {
                    jMax = Math.max(jMax, d(fVar2, fVar2.f23421f + j5));
                }
            }
        }
        if (fVar != pVar.f23476h) {
            return jMax;
        }
        long j6 = j5 + pVar.j();
        return Math.max(Math.max(jMax, d(pVar.f23477i, j6)), j6 - pVar.f23477i.f23421f);
    }

    public void a(p pVar) {
        this.f23448e.add(pVar);
        this.f23447d = pVar;
    }

    public long b(v.f fVar, int i5) {
        p pVar = this.f23446c;
        if (pVar instanceof C1197c) {
            if (((C1197c) pVar).f23474f != i5) {
                return 0L;
            }
        } else if (i5 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i5 == 0 ? fVar.f23064e : fVar.f23066f).f23476h;
        f fVar3 = (i5 == 0 ? fVar.f23064e : fVar.f23066f).f23477i;
        boolean zContains = pVar.f23476h.f23427l.contains(fVar2);
        boolean zContains2 = this.f23446c.f23477i.f23427l.contains(fVar3);
        long j5 = this.f23446c.j();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(d(this.f23446c.f23476h, r12.f23421f), this.f23446c.f23476h.f23421f + j5);
            }
            if (!zContains2) {
                return (r12.f23476h.f23421f + this.f23446c.j()) - this.f23446c.f23477i.f23421f;
            }
            return Math.max(-c(this.f23446c.f23477i, r12.f23421f), (-this.f23446c.f23477i.f23421f) + j5);
        }
        long jD = d(this.f23446c.f23476h, 0L);
        long jC = c(this.f23446c.f23477i, 0L);
        long j6 = jD - j5;
        p pVar2 = this.f23446c;
        int i6 = pVar2.f23477i.f23421f;
        if (j6 >= (-i6)) {
            j6 += i6;
        }
        int i7 = pVar2.f23476h.f23421f;
        long j7 = ((-jC) - j5) - i7;
        if (j7 >= i7) {
            j7 -= i7;
        }
        float fQ = pVar2.f23470b.q(i5);
        float f5 = fQ > 0.0f ? (long) ((j7 / fQ) + (j6 / (1.0f - fQ))) : 0L;
        long j8 = ((long) ((f5 * fQ) + 0.5f)) + j5 + ((long) ((f5 * (1.0f - fQ)) + 0.5f));
        p pVar3 = this.f23446c;
        return (pVar3.f23476h.f23421f + j8) - pVar3.f23477i.f23421f;
    }
}
