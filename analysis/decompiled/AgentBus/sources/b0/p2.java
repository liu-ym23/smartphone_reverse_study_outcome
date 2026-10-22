package b0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p2 implements Iterable, r7.a {

    /* renamed from: g, reason: collision with root package name */
    public int f1307g;

    /* renamed from: i, reason: collision with root package name */
    public int f1309i;

    /* renamed from: j, reason: collision with root package name */
    public int f1310j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1312l;

    /* renamed from: m, reason: collision with root package name */
    public int f1313m;

    /* renamed from: o, reason: collision with root package name */
    public HashMap f1315o;

    /* renamed from: p, reason: collision with root package name */
    public k.t f1316p;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1306f = new int[0];

    /* renamed from: h, reason: collision with root package name */
    public Object[] f1308h = new Object[0];

    /* renamed from: k, reason: collision with root package name */
    public final Object f1311k = new Object();

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f1314n = new ArrayList();

    public final int a(a aVar) {
        if (this.f1312l) {
            s.c("Use active SlotWriter to determine anchor location instead");
        }
        if (!aVar.a()) {
            u1.a("Anchor refers to a group that was removed");
        }
        return aVar.f1096a;
    }

    public final o2 f() {
        if (this.f1312l) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.f1310j++;
        return new o2(this);
    }

    public final s2 h() {
        if (this.f1312l) {
            s.c("Cannot start a writer when another writer is pending");
        }
        if (this.f1310j > 0) {
            s.c("Cannot start a writer when a reader is pending");
        }
        this.f1312l = true;
        this.f1313m++;
        return new s2(this);
    }

    public final boolean i(a aVar) {
        int iE;
        return aVar.a() && (iE = r2.e(this.f1314n, aVar.f1096a, this.f1307g)) >= 0 && q7.k.a(this.f1314n.get(iE), aVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p0(this, 0, this.f1307g);
    }

    public final q0 j(int i2) {
        int i10;
        ArrayList arrayList;
        int iE;
        HashMap map = this.f1315o;
        if (map != null) {
            if (this.f1312l) {
                s.c("use active SlotWriter to crate an anchor for location instead");
            }
            a aVar = (i2 < 0 || i2 >= (i10 = this.f1307g) || (iE = r2.e((arrayList = this.f1314n), i2, i10)) < 0) ? null : (a) arrayList.get(iE);
            if (aVar != null) {
                return (q0) map.get(aVar);
            }
        }
        return null;
    }
}
