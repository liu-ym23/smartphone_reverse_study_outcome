package com.stepos.policy.sdk.bean;

import k0.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyVersionResponse {
    private final int code;
    private final PolicyData data;
    private final String msg;

    public PolicyVersionResponse(int i, PolicyData policyData, String str) {
        policyData.getClass();
        str.getClass();
        this.code = i;
        this.data = policyData;
        this.msg = str;
    }

    public static /* synthetic */ PolicyVersionResponse copy$default(PolicyVersionResponse policyVersionResponse, int i, PolicyData policyData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = policyVersionResponse.code;
        }
        if ((i3 & 2) != 0) {
            policyData = policyVersionResponse.data;
        }
        if ((i3 & 4) != 0) {
            str = policyVersionResponse.msg;
        }
        return policyVersionResponse.copy(i, policyData, str);
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

    public final PolicyVersionResponse copy(int i, PolicyData policyData, String str) {
        policyData.getClass();
        str.getClass();
        return new PolicyVersionResponse(i, policyData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyVersionResponse)) {
            return false;
        }
        PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) obj;
        return this.code == policyVersionResponse.code && k.a(this.data, policyVersionResponse.data) && k.a(this.msg, policyVersionResponse.msg);
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
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyVersionResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.s(sb2, this.msg, ')');
    }
}
