package V4;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final List f1384a;
    public final boolean b;
    public final String c;

    public z(ArrayList arrayList, boolean z10, String str, int i) {
        List messages = arrayList;
        messages = (i & 1) != 0 ? EmptyList.f4893a : messages;
        z10 = (i & 2) != 0 ? false : z10;
        str = (i & 4) != 0 ? null : str;
        kotlin.jvm.internal.k.f(messages, "messages");
        this.f1384a = messages;
        this.b = z10;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return kotlin.jvm.internal.k.b(this.f1384a, zVar.f1384a) && this.b == zVar.b && kotlin.jvm.internal.k.b(this.c, zVar.c);
    }

    public final int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.f1384a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SyncHistoryResult(messages=");
        sb.append(this.f1384a);
        sb.append(", success=");
        sb.append(this.b);
        sb.append(", errorMessage=");
        return B7.a.q(sb, this.c, ")");
    }
}
