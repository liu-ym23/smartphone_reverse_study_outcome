package c1;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import i1.p1;
import ia.c0;
import ia.d0;
import ia.w1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x extends n0.l implements q, d2.c, p1 {
    public final d0.e A;
    public final d0.e B;
    public f C;
    public long D;

    /* renamed from: t, reason: collision with root package name */
    public Object f1850t;

    /* renamed from: u, reason: collision with root package name */
    public Object f1851u;

    /* renamed from: v, reason: collision with root package name */
    public i7.i f1852v;

    /* renamed from: w, reason: collision with root package name */
    public PointerInputEventHandler f1853w;

    /* renamed from: x, reason: collision with root package name */
    public w1 f1854x;

    /* renamed from: y, reason: collision with root package name */
    public f f1855y = t.f1840a;

    /* renamed from: z, reason: collision with root package name */
    public final d0.e f1856z;

    public x(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        this.f1850t = obj;
        this.f1851u = obj2;
        this.f1853w = pointerInputEventHandler;
        d0.e eVar = new d0.e(new v[16]);
        this.f1856z = eVar;
        this.A = eVar;
        this.B = new d0.e(new v[16]);
        this.D = 0L;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // i1.p1
    public final void C(f fVar, g gVar, long j2) {
        this.D = j2;
        if (gVar == g.f1797f) {
            this.f1855y = fVar;
        }
        g7.d dVar = null;
        if (this.f1854x == null) {
            this.f1854x = d0.s(Z(), null, c0.f4929i, new a6.r(this, dVar, 1), 1);
        }
        l0(fVar, gVar);
        ?? r52 = fVar.f1795a;
        int size = r52.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                fVar = null;
                break;
            } else if (!ib.k.m((l) r52.get(i2))) {
                break;
            } else {
                i2++;
            }
        }
        this.C = fVar;
    }

    @Override // i1.p1
    public final void I() {
        m0();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // i1.p1
    public final void M() {
        f fVar = this.C;
        if (fVar == null) {
            return;
        }
        ?? r12 = fVar.f1795a;
        int size = r12.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((l) r12.get(i2)).f1807d) {
                ArrayList arrayList = new ArrayList(r12.size());
                int size2 = r12.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    l lVar = (l) r12.get(i10);
                    long j2 = lVar.f1804a;
                    long j4 = lVar.f1806c;
                    long j10 = lVar.f1805b;
                    float f10 = lVar.f1808e;
                    boolean z4 = lVar.f1807d;
                    arrayList.add(new l(j2, j10, j4, false, f10, j10, j4, z4, z4, lVar.f1812i, 0L));
                }
                f fVar2 = new f(arrayList, null);
                this.f1855y = fVar2;
                l0(fVar2, g.f1797f);
                l0(fVar2, g.f1798g);
                l0(fVar2, g.f1799h);
                this.C = null;
                return;
            }
        }
    }

    @Override // i1.j, i1.p1
    public final void b() {
        m0();
    }

    @Override // d2.c
    public final float c() {
        return i1.l.u(this).A.c();
    }

    @Override // n0.l
    public final void e0() {
        m0();
    }

    @Override // d2.c
    public final float j() {
        return i1.l.u(this).A.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x000d, B:13:0x001b, B:14:0x0020, B:17:0x0023, B:20:0x002f, B:22:0x0037, B:24:0x003b, B:25:0x0040, B:26:0x0043, B:28:0x004c, B:30:0x0054, B:32:0x0058), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(c1.f r7, c1.g r8) {
        /*
            r6 = this;
            d0.e r0 = r6.A
            monitor-enter(r0)
            d0.e r1 = r6.B     // Catch: java.lang.Throwable -> L6c
            d0.e r2 = r6.f1856z     // Catch: java.lang.Throwable -> L6c
            int r3 = r1.f2751h     // Catch: java.lang.Throwable -> L6c
            r1.c(r3, r2)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r0)
            int r0 = r8.ordinal()     // Catch: java.lang.Throwable -> L21
            r1 = 0
            if (r0 == 0) goto L43
            r2 = 1
            if (r0 == r2) goto L23
            r2 = 2
            if (r0 != r2) goto L1b
            goto L43
        L1b:
            a4.u r7 = new a4.u     // Catch: java.lang.Throwable -> L21
            r7.<init>()     // Catch: java.lang.Throwable -> L21
            throw r7     // Catch: java.lang.Throwable -> L21
        L21:
            r7 = move-exception
            goto L66
        L23:
            d0.e r0 = r6.B     // Catch: java.lang.Throwable -> L21
            int r3 = r0.f2751h     // Catch: java.lang.Throwable -> L21
            int r3 = r3 - r2
            java.lang.Object[] r0 = r0.f2749f     // Catch: java.lang.Throwable -> L21
            int r2 = r0.length     // Catch: java.lang.Throwable -> L21
            if (r3 >= r2) goto L60
        L2d:
            if (r3 < 0) goto L60
            r2 = r0[r3]     // Catch: java.lang.Throwable -> L21
            c1.v r2 = (c1.v) r2     // Catch: java.lang.Throwable -> L21
            c1.g r4 = r2.f1845i     // Catch: java.lang.Throwable -> L21
            if (r8 != r4) goto L40
            ia.m r4 = r2.f1844h     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L40
            r2.f1844h = r1     // Catch: java.lang.Throwable -> L21
            r4.resumeWith(r7)     // Catch: java.lang.Throwable -> L21
        L40:
            int r3 = r3 + (-1)
            goto L2d
        L43:
            d0.e r0 = r6.B     // Catch: java.lang.Throwable -> L21
            java.lang.Object[] r2 = r0.f2749f     // Catch: java.lang.Throwable -> L21
            int r0 = r0.f2751h     // Catch: java.lang.Throwable -> L21
            r3 = 0
        L4a:
            if (r3 >= r0) goto L60
            r4 = r2[r3]     // Catch: java.lang.Throwable -> L21
            c1.v r4 = (c1.v) r4     // Catch: java.lang.Throwable -> L21
            c1.g r5 = r4.f1845i     // Catch: java.lang.Throwable -> L21
            if (r8 != r5) goto L5d
            ia.m r5 = r4.f1844h     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L5d
            r4.f1844h = r1     // Catch: java.lang.Throwable -> L21
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L21
        L5d:
            int r3 = r3 + 1
            goto L4a
        L60:
            d0.e r6 = r6.B
            r6.g()
            return
        L66:
            d0.e r6 = r6.B
            r6.g()
            throw r7
        L6c:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x.l0(c1.f, c1.g):void");
    }

    public final void m0() {
        w1 w1Var = this.f1854x;
        if (w1Var != null) {
            w1Var.C(new p("Pointer input was reset", 0));
            this.f1854x = null;
        }
    }
}
