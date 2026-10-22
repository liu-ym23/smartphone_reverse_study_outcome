package J6;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f3732a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Method> f3733b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Field> f3734c = new HashMap<>();

    public a(Class<?> cls, String str) {
        this.f3732a = cls;
    }

    public void a(String str, Method method) {
        this.f3733b.put(str, method);
    }

    public Method b(String str) {
        return this.f3733b.get(str);
    }
}
