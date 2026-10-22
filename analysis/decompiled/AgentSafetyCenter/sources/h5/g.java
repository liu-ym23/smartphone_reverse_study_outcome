package h5;

import androidx.work.impl.WorkDatabase;
import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements a {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ androidx.room.b0 f5339c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ List f5340f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ g5.a f5341g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ WorkDatabase f5342h;

    @Override // h5.a
    public final void e(p5.j jVar, boolean z10) {
        androidx.room.b0 b0Var = this.f5339c;
        List list = this.f5340f;
        g5.a aVar = this.f5341g;
        WorkDatabase workDatabase = this.f5342h;
        h hVar = new h();
        hVar.f5343c = list;
        hVar.f5344f = jVar;
        hVar.f5345g = aVar;
        hVar.f5346h = workDatabase;
        VarHandle.storeStoreFence();
        b0Var.execute(hVar);
    }
}
