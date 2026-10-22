package com.stepos.policy.sdk.bean;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyResponse {
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(PolicyData data, boolean z) {
        g.f(data, "data");
        this.data = data;
        this.newest = z;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i10 & 2) != 0) {
            z = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z);
    }

    public final PolicyData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.newest;
    }

    public final PolicyResponse copy(PolicyData data, boolean z) {
        g.f(data, "data");
        return new PolicyResponse(data, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) obj;
        return g.b(this.data, policyResponse.data) && this.newest == policyResponse.newest;
    }

    public final PolicyData getData() {
        return this.data;
    }

    public final boolean getNewest() {
        return this.newest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.data.hashCode() * 31;
        boolean z = this.newest;
        int i10 = z;
        if (z != 0) {
            i10 = 1;
        }
        return iHashCode + i10;
    }

    public String toString() {
        return "PolicyResponse(data=" + this.data + ", newest=" + this.newest + ')';
    }
}
