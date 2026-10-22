package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class PolicyNewestResponse {
    private final int code;
    private final PolicyResponse data;
    private final String msg;

    public PolicyNewestResponse(int i5, PolicyResponse policyResponse, String str) {
        k.g(policyResponse, "data");
        k.g(str, "msg");
        this.code = i5;
        this.data = policyResponse;
        this.msg = str;
    }

    public static /* synthetic */ PolicyNewestResponse copy$default(PolicyNewestResponse policyNewestResponse, int i5, PolicyResponse policyResponse, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = policyNewestResponse.code;
        }
        if ((i6 & 2) != 0) {
            policyResponse = policyNewestResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyNewestResponse.msg;
        }
        return policyNewestResponse.copy(i5, policyResponse, str);
    }

    public final int component1() {
        return this.code;
    }

    public final PolicyResponse component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyNewestResponse copy(int i5, PolicyResponse policyResponse, String str) {
        k.g(policyResponse, "data");
        k.g(str, "msg");
        return new PolicyNewestResponse(i5, policyResponse, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyNewestResponse)) {
            return false;
        }
        PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) obj;
        return this.code == policyNewestResponse.code && k.b(this.data, policyNewestResponse.data) && k.b(this.msg, policyNewestResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final PolicyResponse getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "PolicyNewestResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
