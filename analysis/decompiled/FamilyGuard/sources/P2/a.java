package P2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final Class<?> f4822a;

    /* renamed from: b, reason: collision with root package name */
    final HashMap<String, Method> f4823b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    final HashMap<String, Field> f4824c = new HashMap<>();

    public a(Class<?> cls, String str) {
        this.f4822a = cls;
    }

    public void a(String str, Method method) {
        this.f4823b.put(str, method);
    }

    public Method b(String str) {
        return this.f4823b.get(str);
    }
}
