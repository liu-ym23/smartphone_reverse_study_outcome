package B0;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import s0.G;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public String f164a;

    /* renamed from: b, reason: collision with root package name */
    public G f165b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Intrinsics.areEqual(this.f164a, qVar.f164a) && this.f165b == qVar.f165b;
    }

    public final int hashCode() {
        return this.f165b.hashCode() + (this.f164a.hashCode() * 31);
    }

    public final String toString() {
        return "IdAndState(id=" + this.f164a + ", state=" + this.f165b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
