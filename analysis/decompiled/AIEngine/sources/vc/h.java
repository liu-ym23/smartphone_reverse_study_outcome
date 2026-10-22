package vc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rc.j;
import vc.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final f.a<Map<String, Integer>> f13500a = new f.a<>();

    public static final int a(rc.e descriptor, uc.a json, String name) {
        kotlin.jvm.internal.g.f(descriptor, "<this>");
        kotlin.jvm.internal.g.f(json, "json");
        kotlin.jvm.internal.g.f(name, "name");
        b(descriptor, json);
        int iC = descriptor.c(name);
        if (iC != -3 || !json.f13194a.f13209g) {
            return iC;
        }
        f fVar = json.f13196c;
        cb.d dVar = new cb.d(12, descriptor, json);
        fVar.getClass();
        fVar.getClass();
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        Map map = (Map) fVar.f13498a.get(descriptor);
        f.a<Map<String, Integer>> aVar = f13500a;
        Object obj = map != null ? map.get(aVar) : null;
        Object objInvoke = obj != null ? obj : null;
        if (objInvoke == null) {
            objInvoke = dVar.invoke();
            ConcurrentHashMap concurrentHashMap = fVar.f13498a;
            Object concurrentHashMap2 = concurrentHashMap.get(descriptor);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(descriptor, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(aVar, objInvoke);
        }
        Integer num = (Integer) ((Map) objInvoke).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final void b(rc.e eVar, uc.a json) {
        kotlin.jvm.internal.g.f(eVar, "<this>");
        kotlin.jvm.internal.g.f(json, "json");
        kotlin.jvm.internal.g.b(eVar.d(), j.a.f11801a);
    }
}
