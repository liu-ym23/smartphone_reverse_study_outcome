package l2;

import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.math.BigInteger;
import z3.G;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1655a implements G {

    /* renamed from: a, reason: collision with root package name */
    public String f5272a;
    public long b;

    @Override // z3.G
    public String w() {
        return String.valueOf(this.b);
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        String str = this.f5272a;
        if (jsonNode.isBigInteger()) {
            int iCompareTo = jsonNode.bigIntegerValue().compareTo(new BigInteger(str));
            return iCompareTo < 0 || iCompareTo == 0;
        }
        if (jsonNode.isTextual()) {
            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal(str));
            return iCompareTo2 < 0 || iCompareTo2 == 0;
        }
        long jAsLong = jsonNode.asLong();
        long j5 = this.b;
        return j5 > jAsLong || j5 == jAsLong;
    }
}
