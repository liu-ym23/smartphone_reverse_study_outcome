package y;

import k0.h1;
import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public Object f15839a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f15840b;

    /* renamed from: c, reason: collision with root package name */
    public h1 f15841c;

    /* renamed from: d, reason: collision with root package name */
    public h1 f15842d;

    /* renamed from: e, reason: collision with root package name */
    public k1 f15843e;

    /* renamed from: f, reason: collision with root package name */
    public k1 f15844f;

    public final z a() {
        h1 h1Var = this.f15842d;
        if (h1Var.g() == 0) {
            this.f15840b.f15728c.add(this);
            z zVar = (z) this.f15844f.getValue();
            if (zVar != null) {
                zVar.a();
            } else {
                zVar = null;
            }
            this.f15843e.setValue(zVar);
        }
        h1Var.h(h1Var.g() + 1);
        return this;
    }

    public final void b() {
        k1 k1Var = this.f15843e;
        h1 h1Var = this.f15842d;
        if (h1Var.g() <= 0) {
            od.f.e("Release should only be called once");
            return;
        }
        h1Var.h(h1Var.g() - 1);
        if (h1Var.g() == 0) {
            this.f15840b.f15728c.remove(this);
            z zVar = (z) k1Var.getValue();
            if (zVar != null) {
                zVar.b();
            }
            k1Var.setValue(null);
        }
    }
}
