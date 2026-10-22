package yc;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f44345a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f44346b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f44347c;

    /* renamed from: d, reason: collision with root package name */
    public final List<?> f44348d;

    public n(Class<?> cls, Object obj, Method method, List<?> list) {
        this.f44345a = cls;
        this.f44346b = obj;
        this.f44347c = method;
        this.f44348d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f44347c;
    }

    public Class<?> b() {
        return this.f44345a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f44345a.getName(), this.f44347c.getName(), this.f44348d);
    }
}
