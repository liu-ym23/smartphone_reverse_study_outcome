package h3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0750a {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f17593a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Method> f17594b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Field> f17595c = new HashMap<>();

    public C0750a(Class<?> cls, String str) {
        this.f17593a = cls;
    }

    public void a(String str, Method method) {
        this.f17594b.put(str, method);
    }

    public Method b(String str) {
        return this.f17594b.get(str);
    }
}
