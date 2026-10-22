package kotlinx.coroutines.flow;

import C7.r;
import S7.o;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import p9.t;

/* loaded from: classes4.dex */
public final class g implements p9.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p9.c f5227a;
    public final /* synthetic */ p9.c b;
    public final /* synthetic */ o c;

    public g(t tVar, t tVar2, o oVar) {
        this.f5227a = tVar;
        this.b = tVar2;
        this.c = oVar;
    }

    @Override // p9.c
    public final Object collect(p9.d dVar, H7.c cVar) {
        Object objA = kotlinx.coroutines.flow.internal.g.a(cVar, new FlowKt__ZipKt$combine$1$1(this.c, null), dVar, new p9.c[]{this.f5227a, this.b});
        return objA == CoroutineSingletons.f4909a ? objA : r.f317a;
    }
}
