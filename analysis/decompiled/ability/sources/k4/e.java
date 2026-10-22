package k4;

import com.stepos.ability.mcpserver.security.BearerAuthenticator$Result;

/* loaded from: classes3.dex */
public final class e implements BearerAuthenticator$Result {

    /* renamed from: a, reason: collision with root package name */
    public final t f4799a;

    public e(t tVar) {
        this.f4799a = tVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && kotlin.jvm.internal.k.b(this.f4799a, ((e) obj).f4799a);
    }

    public final int hashCode() {
        return this.f4799a.hashCode();
    }

    public final String toString() {
        return "Authenticated(principal=" + this.f4799a + ")";
    }
}
