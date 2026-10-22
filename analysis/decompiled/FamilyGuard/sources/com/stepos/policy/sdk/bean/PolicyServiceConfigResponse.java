package com.stepos.policy.sdk.bean;

import j4.k;
import java.util.List;

/* loaded from: classes.dex */
public final class PolicyServiceConfigResponse {
    private final int code;
    private final List<PolicyServiceConfigBean> data;
    private final String msg;

    public PolicyServiceConfigResponse(int i5, List<PolicyServiceConfigBean> list, String str) {
        k.g(list, "data");
        k.g(str, "msg");
        this.code = i5;
        this.data = list;
        this.msg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyServiceConfigResponse copy$default(PolicyServiceConfigResponse policyServiceConfigResponse, int i5, List list, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = policyServiceConfigResponse.code;
        }
        if ((i6 & 2) != 0) {
            list = policyServiceConfigResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyServiceConfigResponse.msg;
        }
        return policyServiceConfigResponse.copy(i5, list, str);
    }

    public final int component1() {
        return this.code;
    }

    public final List<PolicyServiceConfigBean> component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyServiceConfigResponse copy(int i5, List<PolicyServiceConfigBean> list, String str) {
        k.g(list, "data");
        k.g(str, "msg");
        return new PolicyServiceConfigResponse(i5, list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigResponse)) {
            return false;
        }
        PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) obj;
        return this.code == policyServiceConfigResponse.code && k.b(this.data, policyServiceConfigResponse.data) && k.b(this.msg, policyServiceConfigResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<PolicyServiceConfigBean> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "PolicyServiceConfigResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
