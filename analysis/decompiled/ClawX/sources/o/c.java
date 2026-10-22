package o;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public int f4205b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4206c;
    public final d d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4207e;

    /* renamed from: f, reason: collision with root package name */
    public c f4208f;

    /* renamed from: i, reason: collision with root package name */
    public m.g f4211i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f4204a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f4209g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f4210h = Integer.MIN_VALUE;

    public c(d dVar, int i8) {
        this.d = dVar;
        this.f4207e = i8;
    }

    public final void a(c cVar, int i8) {
        b(cVar, i8, Integer.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i8, int i9, boolean z) {
        if (cVar == null) {
            j();
            return true;
        }
        if (!z && !i(cVar)) {
            return false;
        }
        this.f4208f = cVar;
        if (cVar.f4204a == null) {
            cVar.f4204a = new HashSet();
        }
        HashSet hashSet = this.f4208f.f4204a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f4209g = i8;
        this.f4210h = i9;
        return true;
    }

    public final void c(int i8, ArrayList arrayList, n nVar) {
        HashSet hashSet = this.f4204a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                p.h.b(((c) it.next()).d, i8, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f4206c) {
            return this.f4205b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.d.f4222f0 == 8) {
            return 0;
        }
        int i8 = this.f4210h;
        return (i8 == Integer.MIN_VALUE || (cVar = this.f4208f) == null || cVar.d.f4222f0 != 8) ? this.f4209g : i8;
    }

    public final c f() {
        int i8 = this.f4207e;
        int iA = m.f.a(i8);
        d dVar = this.d;
        switch (iA) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.J;
            case 2:
                return dVar.K;
            case 3:
                return dVar.H;
            case 4:
                return dVar.I;
            default:
                throw new AssertionError(m0.f.n(i8));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f4204a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f4208f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(o.c r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L5
            goto L65
        L5:
            o.d r1 = r10.d
            int r10 = r10.f4207e
            r2 = 6
            int r3 = r9.f4207e
            r4 = 1
            if (r10 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r10 = r1.D
            if (r10 == 0) goto L65
            o.d r9 = r9.d
            boolean r9 = r9.D
            if (r9 != 0) goto L63
            goto L65
        L1c:
            int r9 = m.f.a(r3)
            r5 = 8
            r6 = 9
            r7 = 4
            r8 = 2
            switch(r9) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r10 = m0.f.n(r3)
            r9.<init>(r10)
            throw r9
        L33:
            if (r10 == r2) goto L65
            if (r10 == r5) goto L65
            if (r10 == r6) goto L65
            goto L63
        L3a:
            if (r10 == r8) goto L65
            if (r10 != r7) goto L63
            goto L65
        L3f:
            r9 = 3
            if (r10 == r9) goto L48
            r9 = 5
            if (r10 != r9) goto L46
            goto L48
        L46:
            r9 = r0
            goto L49
        L48:
            r9 = r4
        L49:
            boolean r1 = r1 instanceof o.h
            if (r1 == 0) goto L52
            if (r9 != 0) goto L63
            if (r10 != r6) goto L65
            goto L63
        L52:
            return r9
        L53:
            if (r10 == r8) goto L5a
            if (r10 != r7) goto L58
            goto L5a
        L58:
            r9 = r0
            goto L5b
        L5a:
            r9 = r4
        L5b:
            boolean r1 = r1 instanceof o.h
            if (r1 == 0) goto L64
            if (r9 != 0) goto L63
            if (r10 != r5) goto L65
        L63:
            return r4
        L64:
            return r9
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.c.i(o.c):boolean");
    }

    public final void j() {
        HashSet hashSet;
        c cVar = this.f4208f;
        if (cVar != null && (hashSet = cVar.f4204a) != null) {
            hashSet.remove(this);
            if (this.f4208f.f4204a.size() == 0) {
                this.f4208f.f4204a = null;
            }
        }
        this.f4204a = null;
        this.f4208f = null;
        this.f4209g = 0;
        this.f4210h = Integer.MIN_VALUE;
        this.f4206c = false;
        this.f4205b = 0;
    }

    public final void k() {
        m.g gVar = this.f4211i;
        if (gVar == null) {
            this.f4211i = new m.g(1);
        } else {
            gVar.c();
        }
    }

    public final void l(int i8) {
        this.f4205b = i8;
        this.f4206c = true;
    }

    public final String toString() {
        return this.d.f4224g0 + ":" + m0.f.n(this.f4207e);
    }
}
