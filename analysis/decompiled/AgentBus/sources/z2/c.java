package z2;

import androidx.lifecycle.v;
import b0.k0;

/* loaded from: classes.dex */
public final class c implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f11794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f11795b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q7.v f11796c;

    public c(v vVar, b bVar, q7.v vVar2) {
        this.f11794a = vVar;
        this.f11795b = bVar;
        this.f11796c = vVar2;
    }

    @Override // b0.k0
    public final void a() {
        this.f11794a.a().f(this.f11795b);
        d.c cVar = (d.c) this.f11796c.f8820f;
        if (cVar != null) {
            cVar.a();
        }
    }
}
