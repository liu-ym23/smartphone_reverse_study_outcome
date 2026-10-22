package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class PolicyResponse {
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(PolicyData policyData, boolean z5) {
        k.g(policyData, "data");
        this.data = policyData;
        this.newest = z5;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i5 & 2) != 0) {
            z5 = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z5);
    }

    public final PolicyData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.newest;
    }

    public final PolicyResponse copy(PolicyData policyData, boolean z5) {
        k.g(policyData, "data");
        return new PolicyResponse(policyData, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) obj;
        return k.b(this.data, policyResponse.data) && this.newest == policyResponse.newest;
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
        boolean z5 = this.newest;
        int i5 = z5;
        if (z5 != 0) {
            i5 = 1;
        }
        return iHashCode + i5;
    }

    public String toString() {
        return "PolicyResponse(data=" + this.data + ", newest=" + this.newest + ')';
    }
}
