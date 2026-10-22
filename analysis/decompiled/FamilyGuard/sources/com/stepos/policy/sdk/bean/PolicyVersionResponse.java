package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class PolicyVersionResponse {
    private final int code;
    private final PolicyData data;
    private final String msg;

    public PolicyVersionResponse(int i5, PolicyData policyData, String str) {
        k.g(policyData, "data");
        k.g(str, "msg");
        this.code = i5;
        this.data = policyData;
        this.msg = str;
    }

    public static /* synthetic */ PolicyVersionResponse copy$default(PolicyVersionResponse policyVersionResponse, int i5, PolicyData policyData, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = policyVersionResponse.code;
        }
        if ((i6 & 2) != 0) {
            policyData = policyVersionResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyVersionResponse.msg;
        }
        return policyVersionResponse.copy(i5, policyData, str);
    }

    public final int component1() {
        return this.code;
    }

    public final PolicyData component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyVersionResponse copy(int i5, PolicyData policyData, String str) {
        k.g(policyData, "data");
        k.g(str, "msg");
        return new PolicyVersionResponse(i5, policyData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyVersionResponse)) {
            return false;
        }
        PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) obj;
        return this.code == policyVersionResponse.code && k.b(this.data, policyVersionResponse.data) && k.b(this.msg, policyVersionResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final PolicyData getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "PolicyVersionResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
