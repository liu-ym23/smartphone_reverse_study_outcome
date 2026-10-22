package g4;

import com.stepos.ability.mcpserver.model.McpRequest;
import kotlin.jvm.internal.k;

/* renamed from: g4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1456c {

    /* renamed from: a, reason: collision with root package name */
    public final McpRequest f4479a;
    public final int b;
    public final String c;

    public C1456c(McpRequest mcpRequest, int i, String str, int i6) {
        mcpRequest = (i6 & 1) != 0 ? null : mcpRequest;
        i = (i6 & 2) != 0 ? 0 : i;
        str = (i6 & 4) != 0 ? null : str;
        this.f4479a = mcpRequest;
        this.b = i;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1456c)) {
            return false;
        }
        C1456c c1456c = (C1456c) obj;
        return k.b(this.f4479a, c1456c.f4479a) && this.b == c1456c.b && k.b(this.c, c1456c.c);
    }

    public final int hashCode() {
        McpRequest mcpRequest = this.f4479a;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, (mcpRequest == null ? 0 : mcpRequest.hashCode()) * 31, 31);
        String str = this.c;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParseResult(request=");
        sb.append(this.f4479a);
        sb.append(", errorCode=");
        sb.append(this.b);
        sb.append(", errorMessage=");
        return B7.a.q(sb, this.c, ")");
    }
}
