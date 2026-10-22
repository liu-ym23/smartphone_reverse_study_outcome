package k4;

import com.stepos.ability.mcpserver.security.KeyValidation;
import java.util.Set;

/* loaded from: classes3.dex */
public final class q implements KeyValidation {

    /* renamed from: a, reason: collision with root package name */
    public final Set f4811a;

    public q(Set set) {
        this.f4811a = set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && kotlin.jvm.internal.k.b(this.f4811a, ((q) obj).f4811a);
    }

    public final int hashCode() {
        Set set = this.f4811a;
        if (set == null) {
            return 0;
        }
        return set.hashCode();
    }

    public final String toString() {
        return "Valid(allowedTools=" + this.f4811a + ")";
    }
}
