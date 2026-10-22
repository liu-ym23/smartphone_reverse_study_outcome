package com.stepos.policy.sdk.bean;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyResponse {
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(PolicyData policyData, boolean z10) {
        policyData.getClass();
        this.data = policyData;
        this.newest = z10;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i & 2) != 0) {
            z10 = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z10);
    }

    public final PolicyData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.newest;
    }

    public final PolicyResponse copy(PolicyData policyData, boolean z10) {
        policyData.getClass();
        return new PolicyResponse(policyData, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) obj;
        return k.a(this.data, policyResponse.data) && this.newest == policyResponse.newest;
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
        boolean z10 = this.newest;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "PolicyResponse(data=" + this.data + ", newest=" + this.newest + ')';
    }
}
