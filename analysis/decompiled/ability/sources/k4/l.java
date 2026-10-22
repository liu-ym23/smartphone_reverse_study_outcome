package k4;

import com.stepos.ability.mcpserver.security.KeyValidation;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final KeyValidation f4806a;
    public final long b;

    public l(KeyValidation keyValidation, long j5) {
        this.f4806a = keyValidation;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.k.b(this.f4806a, lVar.f4806a) && this.b == lVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f4806a.hashCode() * 31);
    }

    public final String toString() {
        return "Entry(verdict=" + this.f4806a + ", storedAt=" + this.b + ")";
    }
}
