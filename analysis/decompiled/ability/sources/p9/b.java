package p9;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes4.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f5556a;
    public final S7.n b;

    public b(c cVar, S7.n nVar) {
        this.f5556a = cVar;
        this.b = nVar;
    }

    @Override // p9.c
    public final Object collect(d dVar, H7.c cVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = q9.b.b;
        Object objCollect = this.f5556a.collect(new kotlinx.coroutines.flow.c(this, ref$ObjectRef, dVar), cVar);
        return objCollect == CoroutineSingletons.f4909a ? objCollect : C7.r.f317a;
    }
}
