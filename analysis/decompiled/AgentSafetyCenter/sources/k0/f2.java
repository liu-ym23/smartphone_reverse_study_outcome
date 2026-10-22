package k0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f2 implements Iterable, zb.a {

    /* renamed from: f, reason: collision with root package name */
    public int f6901f;

    /* renamed from: h, reason: collision with root package name */
    public int f6903h;
    public int i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6905k;

    /* renamed from: l, reason: collision with root package name */
    public int f6906l;

    /* renamed from: n, reason: collision with root package name */
    public HashMap f6908n;

    /* renamed from: o, reason: collision with root package name */
    public p.u f6909o;

    /* renamed from: c, reason: collision with root package name */
    public int[] f6900c = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public Object[] f6902g = new Object[0];

    /* renamed from: j, reason: collision with root package name */
    public final Object f6904j = new Object();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f6907m = new ArrayList();

    public final int a(b bVar) {
        if (this.f6905k) {
            t.c("Use active SlotWriter to determine anchor location instead");
        }
        if (!bVar.a()) {
            q1.a("Anchor refers to a group that was removed");
        }
        return bVar.f6864a;
    }

    public final void b() {
        this.f6908n = new HashMap();
    }

    public final e2 c() {
        if (this.f6905k) {
            od.f.e("Cannot read while a writer is pending");
            return null;
        }
        this.i++;
        e2 e2Var = new e2();
        e2Var.f6882a = this;
        e2Var.f6883b = this.f6900c;
        int i = this.f6901f;
        e2Var.f6884c = i;
        e2Var.f6885d = this.f6902g;
        e2Var.f6886e = this.f6903h;
        e2Var.f6889h = i;
        e2Var.i = -1;
        e2Var.f6890j = new r0();
        VarHandle.storeStoreFence();
        return e2Var;
    }

    public final i2 d() {
        if (this.f6905k) {
            t.c("Cannot start a writer when another writer is pending");
        }
        if (this.i > 0) {
            t.c("Cannot start a writer when a reader is pending");
        }
        this.f6905k = true;
        this.f6906l++;
        i2 i2Var = new i2();
        i2Var.f6938a = this;
        int[] iArr = this.f6900c;
        i2Var.f6939b = iArr;
        Object[] objArr = this.f6902g;
        i2Var.f6940c = objArr;
        i2Var.f6941d = this.f6907m;
        i2Var.f6942e = this.f6908n;
        i2Var.f6943f = this.f6909o;
        int i = this.f6901f;
        i2Var.f6944g = i;
        i2Var.f6945h = (iArr.length / 5) - i;
        int i3 = this.f6903h;
        i2Var.f6947k = i3;
        i2Var.f6948l = objArr.length - i3;
        i2Var.f6949m = i;
        i2Var.f6952p = new r0();
        i2Var.f6953q = new r0();
        i2Var.f6954r = new r0();
        i2Var.f6957u = i;
        i2Var.f6958v = -1;
        VarHandle.storeStoreFence();
        return i2Var;
    }

    public final boolean e(b bVar) {
        int iE;
        return bVar.a() && (iE = h2.e(this.f6907m, bVar.f6864a, this.f6901f)) >= 0 && yb.k.a(this.f6907m.get(iE), bVar);
    }

    public final q0 f(int i) {
        int i3;
        ArrayList arrayList;
        int iE;
        HashMap map = this.f6908n;
        if (map != null) {
            if (this.f6905k) {
                t.c("use active SlotWriter to crate an anchor for location instead");
            }
            b bVar = (i < 0 || i >= (i3 = this.f6901f) || (iE = h2.e((arrayList = this.f6907m), i, i3)) < 0) ? null : (b) arrayList.get(iE);
            if (bVar != null) {
                return (q0) map.get(bVar);
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p0(this, 0, this.f6901f);
    }
}
