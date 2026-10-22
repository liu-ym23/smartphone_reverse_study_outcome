package b8;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: b8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0842c {

    /* renamed from: a, reason: collision with root package name */
    public static final O2.a f2038a;
    public static final O2.a b;

    static {
        C0841b c0841b = C0841b.b;
        int i = AbstractC0840a.f2034a;
        f2038a = new O2.a(c0841b);
        b = new O2.a(C0841b.c);
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static final kotlin.reflect.jvm.internal.a a(Class jClass) {
        Object objPutIfAbsent;
        kotlin.jvm.internal.k.f(jClass, "jClass");
        O2.a aVar = f2038a;
        aVar.getClass();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) aVar.c;
        Object objInvoke = concurrentHashMap.get(jClass);
        if (objInvoke == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(jClass, (objInvoke = ((S7.k) aVar.b).invoke(jClass)))) != null) {
            objInvoke = objPutIfAbsent;
        }
        kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (kotlin.reflect.jvm.internal.a) objInvoke;
    }
}
