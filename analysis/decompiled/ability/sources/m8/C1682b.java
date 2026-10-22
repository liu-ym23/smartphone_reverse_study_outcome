package m8;

import com.fasterxml.jackson.core.JsonPointer;
import j9.t;
import kotlin.jvm.internal.k;

/* renamed from: m8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1682b {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5307a;
    public final A8.a b;

    public C1682b(Class cls, A8.a aVar) {
        this.f5307a = cls;
        this.b = aVar;
    }

    public final String a() {
        return t.b0(this.f5307a.getName(), '.', JsonPointer.SEPARATOR).concat(".class");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1682b) {
            return k.b(this.f5307a, ((C1682b) obj).f5307a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5307a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, C1682b.class, ": ");
        sb.append(this.f5307a);
        return sb.toString();
    }
}
