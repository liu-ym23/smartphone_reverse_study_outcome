package B0;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f150a;

    /* renamed from: b, reason: collision with root package name */
    public final int f151b;

    public k(String workSpecId, int i4) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f150a = workSpecId;
        this.f151b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Intrinsics.areEqual(this.f150a, kVar.f150a) && this.f151b == kVar.f151b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f151b) + (this.f150a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb.append(this.f150a);
        sb.append(", generation=");
        return g.o(sb, this.f151b, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
