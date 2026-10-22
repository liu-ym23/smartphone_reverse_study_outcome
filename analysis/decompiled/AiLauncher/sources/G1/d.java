package G1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class d<T> {

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentMap<Type, Type> f2777b = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: a, reason: collision with root package name */
    public final Type f2778a;

    public d() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (type instanceof Class) {
            this.f2778a = type;
            return;
        }
        Type type2 = f2777b.get(type);
        if (type2 == null) {
            f2777b.putIfAbsent(type, type);
            type2 = f2777b.get(type);
        }
        this.f2778a = type2;
    }
}
