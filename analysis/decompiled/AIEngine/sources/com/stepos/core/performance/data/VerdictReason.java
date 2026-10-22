package com.stepos.core.performance.data;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VerdictReason {
    private final String action;
    private final String field;
    private final String policyId;
    private final String reason;
    private final String value;

    public VerdictReason(String policyId, String field, String action, String value, String reason) {
        g.f(policyId, "policyId");
        g.f(field, "field");
        g.f(action, "action");
        g.f(value, "value");
        g.f(reason, "reason");
        this.policyId = policyId;
        this.field = field;
        this.action = action;
        this.value = value;
        this.reason = reason;
    }

    public static /* synthetic */ VerdictReason copy$default(VerdictReason verdictReason, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = verdictReason.policyId;
        }
        if ((i10 & 2) != 0) {
            str2 = verdictReason.field;
        }
        if ((i10 & 4) != 0) {
            str3 = verdictReason.action;
        }
        if ((i10 & 8) != 0) {
            str4 = verdictReason.value;
        }
        if ((i10 & 16) != 0) {
            str5 = verdictReason.reason;
        }
        String str6 = str5;
        String str7 = str3;
        return verdictReason.copy(str, str2, str7, str4, str6);
    }

    public final String component1() {
        return this.policyId;
    }

    public final String component2() {
        return this.field;
    }

    public final String component3() {
        return this.action;
    }

    public final String component4() {
        return this.value;
    }

    public final String component5() {
        return this.reason;
    }

    public final VerdictReason copy(String policyId, String field, String action, String value, String reason) {
        g.f(policyId, "policyId");
        g.f(field, "field");
        g.f(action, "action");
        g.f(value, "value");
        g.f(reason, "reason");
        return new VerdictReason(policyId, field, action, value, reason);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerdictReason)) {
            return false;
        }
        VerdictReason verdictReason = (VerdictReason) obj;
        return g.b(this.policyId, verdictReason.policyId) && g.b(this.field, verdictReason.field) && g.b(this.action, verdictReason.action) && g.b(this.value, verdictReason.value) && g.b(this.reason, verdictReason.reason);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getField() {
        return this.field;
    }

    public final String getPolicyId() {
        return this.policyId;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.reason.hashCode() + d.a(d.a(d.a(this.policyId.hashCode() * 31, 31, this.field), 31, this.action), 31, this.value);
    }

    public String toString() {
        String str = this.policyId;
        String str2 = this.field;
        String str3 = this.action;
        String str4 = this.value;
        String str5 = this.reason;
        StringBuilder sbS = a.s("VerdictReason(policyId=", str, ", field=", str2, ", action=");
        a.z(sbS, str3, ", value=", str4, ", reason=");
        return a.o(sbS, str5, ")");
    }
}
