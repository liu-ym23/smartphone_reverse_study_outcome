package R4;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final Method f5032a;

    /* renamed from: b, reason: collision with root package name */
    private final List<?> f5033b;

    l(Method method, List<?> list) {
        this.f5032a = method;
        this.f5033b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f5032a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f5032a.getDeclaringClass().getName(), this.f5032a.getName(), this.f5033b);
    }
}
