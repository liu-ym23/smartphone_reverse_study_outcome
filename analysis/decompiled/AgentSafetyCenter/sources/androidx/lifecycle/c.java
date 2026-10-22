package androidx.lifecycle;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f1363a;

    /* renamed from: b, reason: collision with root package name */
    public Method f1364b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1363a == cVar.f1363a && this.f1364b.getName().equals(cVar.f1364b.getName());
    }

    public final int hashCode() {
        return this.f1364b.getName().hashCode() + (this.f1363a * 31);
    }
}
