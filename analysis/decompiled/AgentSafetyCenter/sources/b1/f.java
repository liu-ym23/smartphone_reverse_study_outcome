package b1;

import androidx.activity.d0;
import p.a0;
import p.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public i f1812a;

    /* renamed from: b, reason: collision with root package name */
    public v1.t f1813b;

    /* renamed from: c, reason: collision with root package name */
    public g0 f1814c;

    /* renamed from: d, reason: collision with root package name */
    public g0 f1815d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1816e;

    public final void a() {
        if (this.f1816e) {
            return;
        }
        v1.t tVar = this.f1813b;
        d0 d0Var = new d0(0, this, f.class, "invalidateNodes", "invalidateNodes()V", 0, 0, 3);
        a0 a0Var = tVar.f14574x0;
        if (a0Var.f(d0Var) < 0) {
            a0Var.a(d0Var);
        }
        this.f1816e = true;
    }
}
