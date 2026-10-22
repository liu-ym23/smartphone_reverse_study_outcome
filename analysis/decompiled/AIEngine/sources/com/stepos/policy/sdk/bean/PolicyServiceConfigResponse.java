package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import h0.e;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyServiceConfigResponse {
    private final int code;
    private final List<PolicyServiceConfigBean> data;
    private final String msg;

    public PolicyServiceConfigResponse(int i10, List<PolicyServiceConfigBean> data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        this.code = i10;
        this.data = data;
        this.msg = msg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyServiceConfigResponse copy$default(PolicyServiceConfigResponse policyServiceConfigResponse, int i10, List list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = policyServiceConfigResponse.code;
        }
        if ((i11 & 2) != 0) {
            list = policyServiceConfigResponse.data;
        }
        if ((i11 & 4) != 0) {
            str = policyServiceConfigResponse.msg;
        }
        return policyServiceConfigResponse.copy(i10, list, str);
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

    public final PolicyServiceConfigResponse copy(int i10, List<PolicyServiceConfigBean> data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        return new PolicyServiceConfigResponse(i10, data, msg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigResponse)) {
            return false;
        }
        PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) obj;
        return this.code == policyServiceConfigResponse.code && g.b(this.data, policyServiceConfigResponse.data) && g.b(this.msg, policyServiceConfigResponse.msg);
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
        return this.msg.hashCode() + e.b(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyServiceConfigResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.n(sb2, this.msg, ')');
    }
}
