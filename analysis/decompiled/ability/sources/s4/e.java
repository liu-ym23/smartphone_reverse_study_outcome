package s4;

import java.util.Map;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5984a;
    public final Object b;
    public final boolean c;

    public e(Map map, Map map2, boolean z10) {
        this.f5984a = map;
        this.b = map2;
        this.c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f5984a.equals(eVar.f5984a) && this.b.equals(eVar.b) && this.c == eVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.f5984a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LedgerRules(toolScopeAll=");
        sb.append(this.f5984a);
        sb.append(", scopes=");
        sb.append(this.b);
        sb.append(", stale=");
        return B7.a.s(sb, this.c, ")");
    }
}
