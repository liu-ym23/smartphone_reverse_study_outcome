package l0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class n<T> {

    /* renamed from: b, reason: collision with root package name */
    static ConcurrentMap<Type, Type> f18147b = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: c, reason: collision with root package name */
    public static final Type f18148c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    protected final Type f18149a;

    static class a extends n<List<String>> {
        a() {
        }
    }

    protected n() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = f18147b.get(type);
        if (type2 == null) {
            f18147b.putIfAbsent(type, type);
            type2 = f18147b.get(type);
        }
        this.f18149a = type2;
    }

    public static Type b(u0.k kVar) {
        Type type = f18147b.get(kVar);
        if (type != null) {
            return type;
        }
        f18147b.putIfAbsent(kVar, kVar);
        return f18147b.get(kVar);
    }

    public Type a() {
        return this.f18149a;
    }
}
