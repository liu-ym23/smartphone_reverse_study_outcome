package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.o;
import ca.AbstractC0897f;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes4.dex */
public final class h implements p9.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f5247a;

    public h(o oVar) {
        this.f5247a = oVar;
    }

    @Override // p9.c
    public final Object collect(p9.d dVar, H7.c cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.f5247a, dVar, null);
        q9.f fVar = new q9.f(cVar.getContext(), cVar);
        Object objM = AbstractC0897f.M(fVar, fVar, flowCoroutineKt$scopedFlow$1$1);
        return objM == CoroutineSingletons.f4909a ? objM : r.f317a;
    }
}
