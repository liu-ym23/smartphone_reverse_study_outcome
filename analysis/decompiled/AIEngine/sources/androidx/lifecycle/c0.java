package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Deprecated
/* loaded from: classes.dex */
public final class c0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2261a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f2262b;

    public c0(p pVar) {
        this.f2261a = pVar;
        c cVar = c.f2254c;
        Class<?> cls = pVar.getClass();
        c.a aVar = (c.a) cVar.f2255a.get(cls);
        this.f2262b = aVar == null ? cVar.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap map = this.f2262b.f2257a;
        List list = (List) map.get(event);
        Object obj = this.f2261a;
        c.a.a(list, qVar, event, obj);
        c.a.a((List) map.get(Lifecycle.Event.ON_ANY), qVar, event, obj);
    }
}
