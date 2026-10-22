package F5;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import z3.G;
import z3.x;

/* loaded from: classes3.dex */
public final class f implements G {

    /* renamed from: a, reason: collision with root package name */
    public final long f553a;
    public final Iterable b;
    public final Serializable c;
    public final Object d;

    public f(x xVar, JsonNode jsonNode, String str, long j5) {
        this.d = xVar;
        this.b = jsonNode;
        this.c = str;
        this.f553a = j5;
    }

    @Override // z3.G
    public String w() {
        return String.valueOf(this.f553a);
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        x xVar = (x) this.d;
        if (jsonNode.isBigInteger()) {
            int iCompareTo = jsonNode.bigIntegerValue().compareTo(new BigInteger(((JsonNode) this.b).asText()));
            return iCompareTo > 0 || (xVar.g && iCompareTo == 0);
        }
        if (jsonNode.isTextual()) {
            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.c));
            return iCompareTo2 > 0 || (xVar.g && iCompareTo2 == 0);
        }
        long jAsLong = jsonNode.asLong();
        long j5 = this.f553a;
        return j5 < jAsLong || (xVar.g && j5 == jAsLong);
    }

    public f(long j5) {
        this.f553a = j5;
        this.b = new ArrayList();
        this.d = new LinkedHashMap();
        this.c = new ArrayList();
    }
}
