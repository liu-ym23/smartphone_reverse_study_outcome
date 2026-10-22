package w2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import x2.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public int f15151b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15152c;

    /* renamed from: d, reason: collision with root package name */
    public final e f15153d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15154e;

    /* renamed from: f, reason: collision with root package name */
    public d f15155f;
    public u2.e i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f15150a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f15156g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f15157h = Integer.MIN_VALUE;

    public d(e eVar, int i) {
        this.f15153d = eVar;
        this.f15154e = i;
    }

    public final void a(d dVar, int i, int i3) {
        if (dVar == null) {
            g();
            return;
        }
        this.f15155f = dVar;
        if (dVar.f15150a == null) {
            dVar.f15150a = new HashSet();
        }
        HashSet hashSet = this.f15155f.f15150a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f15156g = i;
        this.f15157h = i3;
    }

    public final void b(int i, ArrayList arrayList, m mVar) {
        HashSet hashSet = this.f15150a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                x2.g.b(((d) it.next()).f15153d, i, arrayList, mVar);
            }
        }
    }

    public final int c() {
        if (this.f15152c) {
            return this.f15151b;
        }
        return 0;
    }

    public final int d() {
        d dVar;
        if (this.f15153d.f0 == 8) {
            return 0;
        }
        int i = this.f15157h;
        return (i == Integer.MIN_VALUE || (dVar = this.f15155f) == null || dVar.f15153d.f0 != 8) ? this.f15156g : i;
    }

    public final boolean e() {
        d dVar;
        HashSet hashSet = this.f15150a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            e eVar = dVar2.f15153d;
            int i = dVar2.f15154e;
            switch (s.f.c(i)) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    dVar = null;
                    break;
                case 1:
                    dVar = eVar.J;
                    break;
                case 2:
                    dVar = eVar.K;
                    break;
                case 3:
                    dVar = eVar.H;
                    break;
                case 4:
                    dVar = eVar.I;
                    break;
                default:
                    throw new AssertionError(c.e(i));
            }
            if (dVar.f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f15155f != null;
    }

    public final void g() {
        HashSet hashSet;
        d dVar = this.f15155f;
        if (dVar != null && (hashSet = dVar.f15150a) != null) {
            hashSet.remove(this);
            if (this.f15155f.f15150a.size() == 0) {
                this.f15155f.f15150a = null;
            }
        }
        this.f15150a = null;
        this.f15155f = null;
        this.f15156g = 0;
        this.f15157h = Integer.MIN_VALUE;
        this.f15152c = false;
        this.f15151b = 0;
    }

    public final void h() {
        u2.e eVar = this.i;
        if (eVar == null) {
            this.i = new u2.e(1);
        } else {
            eVar.c();
        }
    }

    public final void i(int i) {
        this.f15151b = i;
        this.f15152c = true;
    }

    public final String toString() {
        return this.f15153d.f15169g0 + ":" + c.e(this.f15154e);
    }
}
