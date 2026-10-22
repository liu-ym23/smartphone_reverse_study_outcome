package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements p {

    /* renamed from: a, reason: collision with root package name */
    public final q f693a;

    /* renamed from: b, reason: collision with root package name */
    public final a f694b;

    public ReflectiveGenericLifecycleObserver(q qVar) {
        this.f693a = qVar;
        c cVar = c.f701c;
        Class<?> cls = qVar.getClass();
        a aVar = (a) cVar.f702a.get(cls);
        this.f694b = aVar == null ? cVar.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap map = this.f694b.f697a;
        List list = (List) map.get(lVar);
        q qVar = this.f693a;
        a.a(list, rVar, lVar, qVar);
        a.a((List) map.get(l.ON_ANY), rVar, lVar, qVar);
    }
}
