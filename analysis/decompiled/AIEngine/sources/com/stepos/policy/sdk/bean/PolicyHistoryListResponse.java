package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import h0.e;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyHistoryListResponse {
    private final int code;
    private final List<PolicyResponse> data;
    private final String msg;

    public PolicyHistoryListResponse(int i10, List<PolicyResponse> data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        this.code = i10;
        this.data = data;
        this.msg = msg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyHistoryListResponse copy$default(PolicyHistoryListResponse policyHistoryListResponse, int i10, List list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = policyHistoryListResponse.code;
        }
        if ((i11 & 2) != 0) {
            list = policyHistoryListResponse.data;
        }
        if ((i11 & 4) != 0) {
            str = policyHistoryListResponse.msg;
        }
        return policyHistoryListResponse.copy(i10, list, str);
    }

    public final int component1() {
        return this.code;
    }

    public final List<PolicyResponse> component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyHistoryListResponse copy(int i10, List<PolicyResponse> data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        return new PolicyHistoryListResponse(i10, data, msg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyHistoryListResponse)) {
            return false;
        }
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) obj;
        return this.code == policyHistoryListResponse.code && g.b(this.data, policyHistoryListResponse.data) && g.b(this.msg, policyHistoryListResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<PolicyResponse> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + e.b(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyHistoryListResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.n(sb2, this.msg, ')');
    }
}
