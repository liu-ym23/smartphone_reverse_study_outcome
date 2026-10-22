package B0;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f138a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f139b;

    public d(String key, Long l4) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f138a = key;
        this.f139b = l4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f138a, dVar.f138a) && Intrinsics.areEqual(this.f139b, dVar.f139b);
    }

    public final int hashCode() {
        int iHashCode = this.f138a.hashCode() * 31;
        Long l4 = this.f139b;
        return iHashCode + (l4 == null ? 0 : l4.hashCode());
    }

    public final String toString() {
        return "Preference(key=" + this.f138a + ", value=" + this.f139b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
