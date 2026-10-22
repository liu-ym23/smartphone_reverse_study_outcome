package com.stepos.policy.sdk.bean;

import k0.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyNewestResponse {
    private final int code;
    private final PolicyResponse data;
    private final String msg;

    public PolicyNewestResponse(int i, PolicyResponse policyResponse, String str) {
        policyResponse.getClass();
        str.getClass();
        this.code = i;
        this.data = policyResponse;
        this.msg = str;
    }

    public static /* synthetic */ PolicyNewestResponse copy$default(PolicyNewestResponse policyNewestResponse, int i, PolicyResponse policyResponse, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = policyNewestResponse.code;
        }
        if ((i3 & 2) != 0) {
            policyResponse = policyNewestResponse.data;
        }
        if ((i3 & 4) != 0) {
            str = policyNewestResponse.msg;
        }
        return policyNewestResponse.copy(i, policyResponse, str);
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

    public final PolicyNewestResponse copy(int i, PolicyResponse policyResponse, String str) {
        policyResponse.getClass();
        str.getClass();
        return new PolicyNewestResponse(i, policyResponse, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyNewestResponse)) {
            return false;
        }
        PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) obj;
        return this.code == policyNewestResponse.code && k.a(this.data, policyNewestResponse.data) && k.a(this.msg, policyNewestResponse.msg);
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
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyNewestResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.s(sb2, this.msg, ')');
    }
}
