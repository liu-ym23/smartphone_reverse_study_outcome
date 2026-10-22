package B0;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f145a;

    /* renamed from: b, reason: collision with root package name */
    public final int f146b;

    /* renamed from: c, reason: collision with root package name */
    public final int f147c;

    public h(String workSpecId, int i4, int i5) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f145a = workSpecId;
        this.f146b = i4;
        this.f147c = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.f145a, hVar.f145a) && this.f146b == hVar.f146b && this.f147c == hVar.f147c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f147c) + g.d(this.f146b, this.f145a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SystemIdInfo(workSpecId=");
        sb.append(this.f145a);
        sb.append(", generation=");
        sb.append(this.f146b);
        sb.append(", systemId=");
        return g.o(sb, this.f147c, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
