package Aa;

import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f165a;
    public final String b;
    public final Map c;

    public b(String str, String str2, Map requestMetadata) {
        k.f(requestMetadata, "requestMetadata");
        this.f165a = str;
        this.b = str2;
        this.c = requestMetadata;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.b(this.f165a, bVar.f165a) && k.b(this.b, bVar.b) && k.b(this.c, bVar.c);
    }

    public final int hashCode() {
        String str = this.f165a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return this.c.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 961);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("LlmTrace(traceId=", this.f165a, ", modelId=", this.b, ", modelTrace=, requestMetadata=");
        sbW.append(this.c);
        sbW.append(")");
        return sbW.toString();
    }
}
