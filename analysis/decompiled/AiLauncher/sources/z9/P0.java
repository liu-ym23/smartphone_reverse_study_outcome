package z9;

import K9.C0925f;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/lang/Class;", "LJ9/k;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Class;)LJ9/k;", "Ljava/util/concurrent/ConcurrentMap;", "Lz9/d1;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/ConcurrentMap;", "moduleByClassLoader", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class P0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<d1, WeakReference<J9.k>> f45315a = new ConcurrentHashMap();

    public static final J9.k a(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        ClassLoader classLoaderJ = C0925f.j(cls);
        d1 d1Var = new d1(classLoaderJ);
        ConcurrentMap<d1, WeakReference<J9.k>> concurrentMap = f45315a;
        WeakReference<J9.k> weakReference = concurrentMap.get(d1Var);
        if (weakReference != null) {
            J9.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(d1Var, weakReference);
        }
        J9.k kVarA = J9.k.f3800c.a(classLoaderJ);
        while (true) {
            try {
                ConcurrentMap<d1, WeakReference<J9.k>> concurrentMap2 = f45315a;
                WeakReference<J9.k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(d1Var, new WeakReference<>(kVarA));
                if (weakReferencePutIfAbsent == null) {
                    return kVarA;
                }
                J9.k kVar2 = weakReferencePutIfAbsent.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(d1Var, weakReferencePutIfAbsent);
            } finally {
                d1Var.a(null);
            }
        }
    }
}
