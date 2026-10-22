package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public final class j implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final H7.h f5249a;
    public final Object b;
    public final n c;

    public j(p9.d dVar, H7.h hVar) {
        this.f5249a = hVar;
        this.b = AbstractC1921a.k(hVar);
        this.c = new UndispatchedContextCollector$emitRef$1(dVar, null);
    }

    @Override // p9.d
    public final Object emit(Object obj, H7.c cVar) {
        Object objB = q9.b.b(this.f5249a, obj, this.b, this.c, cVar);
        return objB == CoroutineSingletons.f4909a ? objB : r.f317a;
    }
}
