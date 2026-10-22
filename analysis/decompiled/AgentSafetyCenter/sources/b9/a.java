package b9;

import io.modelcontextprotocol.server.McpAsyncServerExchange;
import java.util.Map;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f2042a;

    /* renamed from: b, reason: collision with root package name */
    public Map f2043b;

    /* renamed from: c, reason: collision with root package name */
    public Map f2044c;

    /* renamed from: d, reason: collision with root package name */
    public McpAsyncServerExchange f2045d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f2042a, aVar.f2042a) && this.f2043b.equals(aVar.f2043b) && k.a(this.f2044c, aVar.f2044c) && k.a(this.f2045d, aVar.f2045d);
    }

    public final int hashCode() {
        String str = this.f2042a;
        int iHashCode = (this.f2043b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31;
        Map map = this.f2044c;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        McpAsyncServerExchange mcpAsyncServerExchange = this.f2045d;
        return iHashCode2 + (mcpAsyncServerExchange != null ? mcpAsyncServerExchange.hashCode() : 0);
    }

    public final String toString() {
        return "CallToolRequest(name=" + this.f2042a + ", arguments=" + this.f2043b + ", meta=" + this.f2044c + ", serverExchange=" + this.f2045d + ")";
    }
}
