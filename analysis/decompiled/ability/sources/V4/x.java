package V4;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final List f1382a;
    public final boolean b;
    public final String c;

    public x(ArrayList arrayList, boolean z10, String str, int i) {
        List sessions = arrayList;
        sessions = (i & 1) != 0 ? EmptyList.f4893a : sessions;
        z10 = (i & 2) != 0 ? false : z10;
        str = (i & 4) != 0 ? null : str;
        kotlin.jvm.internal.k.f(sessions, "sessions");
        this.f1382a = sessions;
        this.b = z10;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.k.b(this.f1382a, xVar.f1382a) && this.b == xVar.b && kotlin.jvm.internal.k.b(this.c, xVar.c);
    }

    public final int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.f1382a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SyncConversationsResult(sessions=");
        sb.append(this.f1382a);
        sb.append(", success=");
        sb.append(this.b);
        sb.append(", errorMessage=");
        return B7.a.q(sb, this.c, ")");
    }
}
