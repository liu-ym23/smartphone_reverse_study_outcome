package b4;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import kotlin.jvm.internal.k;

/* renamed from: b4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0825a {

    /* renamed from: a, reason: collision with root package name */
    public final McpSchema.Tool f2015a;
    public final Map b;
    public final int c;
    public final String d;

    public C0825a(McpSchema.Tool tool, Map map, int i, String str) {
        this.f2015a = tool;
        this.b = map;
        this.c = i;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0825a)) {
            return false;
        }
        C0825a c0825a = (C0825a) obj;
        return k.b(this.f2015a, c0825a.f2015a) && k.b(this.b, c0825a.b) && this.c == c0825a.c && k.b(this.d, c0825a.d);
    }

    public final int hashCode() {
        int iHashCode = this.f2015a.hashCode() * 31;
        Map map = this.b;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.c, (iHashCode + (map == null ? 0 : map.hashCode())) * 31, 31);
        String str = this.d;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "ToolWrapper(tool=" + this.f2015a + ", extra=" + this.b + ", timeout=" + this.c + ", slaScene=" + this.d + ")";
    }
}
