package Aa;

import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Action f164a;
    public final b b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public a(Action action, b bVar, String str, int i) {
        action = (i & 1) != 0 ? null : action;
        bVar = (i & 2) != 0 ? null : bVar;
        str = (i & 4) != 0 ? null : str;
        boolean z10 = (i & 8) == 0;
        boolean z11 = (i & 16) == 0;
        this.f164a = action;
        this.b = bVar;
        this.c = str;
        this.d = z10;
        this.e = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f164a, aVar.f164a) && k.b(this.b, aVar.b) && k.b(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e;
    }

    public final int hashCode() {
        Action action = this.f164a;
        int iHashCode = (action == null ? 0 : action.hashCode()) * 31;
        b bVar = this.b;
        int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        String str = this.c;
        return Boolean.hashCode(this.e) + androidx.appfunctions.metadata.a.d((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31, 31, this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActionReturned(action=");
        sb.append(this.f164a);
        sb.append(", llmTrace=");
        sb.append(this.b);
        sb.append(", error=");
        sb.append(this.c);
        sb.append(", isStopRequested=");
        sb.append(this.d);
        sb.append(", isTakeoverRequested=");
        return B7.a.s(sb, this.e, ")");
    }
}
