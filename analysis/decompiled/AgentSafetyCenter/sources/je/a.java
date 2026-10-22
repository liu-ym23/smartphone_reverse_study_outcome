package je;

import a1.g;
import ie.k;
import ie.l;
import ie.q0;
import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Type;
import m7.e;
import m7.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a extends k {

    /* renamed from: a, reason: collision with root package name */
    public e f6792a;

    @Override // ie.k
    public final l a(Type type) {
        e eVar = this.f6792a;
        n nVarC = eVar.c(t7.a.get(type));
        b bVar = new b();
        bVar.f6795c = eVar;
        bVar.f6796f = nVarC;
        VarHandle.storeStoreFence();
        return bVar;
    }

    @Override // ie.k
    public final l b(Type type, Annotation[] annotationArr, q0 q0Var) {
        n nVarC = this.f6792a.c(t7.a.get(type));
        g gVar = new g(16, false);
        gVar.f19f = nVarC;
        VarHandle.storeStoreFence();
        return gVar;
    }
}
