package xd;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Method f13798a;

    /* renamed from: b, reason: collision with root package name */
    public final List<?> f13799b;

    public i(Method method, ArrayList arrayList) {
        this.f13798a = method;
        this.f13799b = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        Method method = this.f13798a;
        return String.format("%s.%s() %s", method.getDeclaringClass().getName(), method.getName(), this.f13799b);
    }
}
