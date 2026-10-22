package K;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3933a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Object, r> f3934b = new HashMap();

    public static r a(Object obj) {
        r rVar;
        synchronized (f3933a) {
            rVar = f3934b.get(obj);
        }
        return rVar == null ? r.f4006a : rVar;
    }
}
