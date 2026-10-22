package q9;

import C7.r;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import o9.InterfaceC1786l;
import o9.o;

/* loaded from: classes4.dex */
public final class j implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final o f5627a;

    public j(InterfaceC1786l interfaceC1786l) {
        this.f5627a = interfaceC1786l;
    }

    @Override // p9.d
    public final Object emit(Object obj, H7.c cVar) {
        Object objP = this.f5627a.p(cVar, obj);
        return objP == CoroutineSingletons.f4909a ? objP : r.f317a;
    }
}
