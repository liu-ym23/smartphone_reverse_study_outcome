package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import java.util.List;
import k0.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyServiceConfigResponse {
    private final int code;
    private final List<PolicyServiceConfigBean> data;
    private final String msg;

    public PolicyServiceConfigResponse(int i, List<PolicyServiceConfigBean> list, String str) {
        list.getClass();
        str.getClass();
        this.code = i;
        this.data = list;
        this.msg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyServiceConfigResponse copy$default(PolicyServiceConfigResponse policyServiceConfigResponse, int i, List list, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = policyServiceConfigResponse.code;
        }
        if ((i3 & 2) != 0) {
            list = policyServiceConfigResponse.data;
        }
        if ((i3 & 4) != 0) {
            str = policyServiceConfigResponse.msg;
        }
        return policyServiceConfigResponse.copy(i, list, str);
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

    public final PolicyServiceConfigResponse copy(int i, List<PolicyServiceConfigBean> list, String str) {
        list.getClass();
        str.getClass();
        return new PolicyServiceConfigResponse(i, list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigResponse)) {
            return false;
        }
        PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) obj;
        return this.code == policyServiceConfigResponse.code && k.a(this.data, policyServiceConfigResponse.data) && k.a(this.msg, policyServiceConfigResponse.msg);
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
        return this.msg.hashCode() + b.e(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyServiceConfigResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.s(sb2, this.msg, ')');
    }
}
