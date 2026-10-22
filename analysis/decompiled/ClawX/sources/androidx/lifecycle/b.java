package androidx.lifecycle;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f699a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f700b;

    public b(int i8, Method method) throws SecurityException {
        this.f699a = i8;
        this.f700b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f699a == bVar.f699a && this.f700b.getName().equals(bVar.f700b.getName());
    }

    public final int hashCode() {
        return this.f700b.getName().hashCode() + (this.f699a * 31);
    }
}
