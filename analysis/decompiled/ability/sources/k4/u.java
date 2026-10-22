package k4;

import java.util.Set;

/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Set f4815a;

    public u(Set set) {
        this.f4815a = set;
    }

    public final boolean a(String toolName) {
        kotlin.jvm.internal.k.f(toolName, "toolName");
        Set set = this.f4815a;
        return set == null || set.contains(toolName);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && kotlin.jvm.internal.k.b(this.f4815a, ((u) obj).f4815a);
    }

    public final int hashCode() {
        Set set = this.f4815a;
        if (set == null) {
            return 0;
        }
        return set.hashCode();
    }

    public final String toString() {
        return "McpScope(allowedTools=" + this.f4815a + ")";
    }
}
