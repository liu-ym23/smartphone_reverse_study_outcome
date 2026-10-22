package ie;

import java.lang.reflect.Method;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public Method f6058a;

    /* renamed from: b, reason: collision with root package name */
    public List f6059b;

    public final String toString() {
        Method method = this.f6058a;
        return String.format("%s.%s() %s", method.getDeclaringClass().getName(), method.getName(), this.f6059b);
    }
}
