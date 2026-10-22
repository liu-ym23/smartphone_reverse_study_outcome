package r4;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5094a = new ConcurrentHashMap();

    public final Object a(a key, p5.a aVar) {
        p.e(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f5094a;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = aVar.invoke();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        if (objPutIfAbsent != null) {
            objInvoke = objPutIfAbsent;
        }
        p.c(objInvoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return objInvoke;
    }

    public final Object b(a key) {
        p.e(key, "key");
        Object objD = d(key);
        if (objD != null) {
            return objD;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    public final Map c() {
        return this.f5094a;
    }

    public final Object d(a key) {
        p.e(key, "key");
        return c().get(key);
    }

    public final void e(a key, Object value) {
        p.e(key, "key");
        p.e(value, "value");
        c().put(key, value);
    }
}
