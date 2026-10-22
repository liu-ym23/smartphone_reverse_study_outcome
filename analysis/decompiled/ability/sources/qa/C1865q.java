package qa;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: qa.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1865q {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5658a;
    public final Object b;
    public final Method c;
    public final List d;

    public C1865q(Class cls, Object obj, Method method, ArrayList arrayList) {
        this.f5658a = cls;
        this.b = obj;
        this.c = method;
        this.d = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        return String.format("%s.%s() %s", this.f5658a.getName(), this.c.getName(), this.d);
    }
}
