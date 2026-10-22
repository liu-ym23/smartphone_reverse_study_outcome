package u4;

import java.util.concurrent.atomic.AtomicReferenceArray;
import x4.AbstractC1291C;

/* renamed from: u4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1169g<E> extends AbstractC1291C<C1169g<E>> {

    /* renamed from: e, reason: collision with root package name */
    private final C1164b<E> f22967e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f22968f;

    public C1169g(long j5, C1169g<E> c1169g, C1164b<E> c1164b, int i5) {
        super(j5, c1169g, i5);
        this.f22967e = c1164b;
        this.f22968f = new AtomicReferenceArray(C1165c.f22941b * 2);
    }

    private final void E(int i5, Object obj) {
        z().set(i5 * 2, obj);
    }

    private final /* synthetic */ AtomicReferenceArray z() {
        return this.f22968f;
    }

    public final E A(int i5) {
        return (E) z().get(i5 * 2);
    }

    public final Object B(int i5) {
        return z().get((i5 * 2) + 1);
    }

    public final void C(int i5, boolean z5) {
        if (z5) {
            y().G0((this.f23829c * C1165c.f22941b) + i5);
        }
        t();
    }

    public final E D(int i5) {
        E eA = A(i5);
        w(i5);
        return eA;
    }

    public final void F(int i5, Object obj) {
        z().set((i5 * 2) + 1, obj);
    }

    public final void G(int i5, E e6) {
        E(i5, e6);
    }

    @Override // x4.AbstractC1291C
    public int r() {
        return C1165c.f22941b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r3 = y().f22929c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r3 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        x4.x.b(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // x4.AbstractC1291C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, Z3.i r6) {
        /*
            r3 = this;
            int r5 = u4.C1165c.f22941b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof s4.L0
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof u4.C1176n
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            x4.F r2 = u4.C1165c.j()
            if (r1 == r2) goto L62
            x4.F r2 = u4.C1165c.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            x4.F r2 = u4.C1165c.o()
            if (r1 == r2) goto Le
            x4.F r2 = u4.C1165c.p()
            if (r1 != r2) goto L35
            goto Le
        L35:
            x4.F r3 = u4.C1165c.f()
            if (r1 == r3) goto L99
            x4.F r3 = u4.C1165c.f22943d
            if (r1 != r3) goto L40
            goto L99
        L40:
            x4.F r3 = u4.C1165c.y()
            if (r1 != r3) goto L47
            goto L99
        L47:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unexpected state: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L62:
            r3.w(r4)
            if (r0 == 0) goto L99
            u4.b r3 = r3.y()
            i4.l<E, V3.v> r3 = r3.f22929c
            if (r3 == 0) goto L99
            x4.x.b(r3, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            x4.F r2 = u4.C1165c.j()
            goto L7e
        L7a:
            x4.F r2 = u4.C1165c.i()
        L7e:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L99
            u4.b r3 = r3.y()
            i4.l<E, V3.v> r3 = r3.f22929c
            if (r3 == 0) goto L99
            x4.x.b(r3, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.C1169g.s(int, java.lang.Throwable, Z3.i):void");
    }

    public final boolean v(int i5, Object obj, Object obj2) {
        return z().compareAndSet((i5 * 2) + 1, obj, obj2);
    }

    public final void w(int i5) {
        E(i5, null);
    }

    public final Object x(int i5, Object obj) {
        return z().getAndSet((i5 * 2) + 1, obj);
    }

    public final C1164b<E> y() {
        C1164b<E> c1164b = this.f22967e;
        j4.k.d(c1164b);
        return c1164b;
    }
}
