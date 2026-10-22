package com.stepos.policy.sdk.bean;

import j4.k;
import java.util.List;

/* loaded from: classes.dex */
public final class PolicyHistoryListResponse {
    private final int code;
    private final List<PolicyResponse> data;
    private final String msg;

    public PolicyHistoryListResponse(int i5, List<PolicyResponse> list, String str) {
        k.g(list, "data");
        k.g(str, "msg");
        this.code = i5;
        this.data = list;
        this.msg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyHistoryListResponse copy$default(PolicyHistoryListResponse policyHistoryListResponse, int i5, List list, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = policyHistoryListResponse.code;
        }
        if ((i6 & 2) != 0) {
            list = policyHistoryListResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyHistoryListResponse.msg;
        }
        return policyHistoryListResponse.copy(i5, list, str);
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

    public final PolicyHistoryListResponse copy(int i5, List<PolicyResponse> list, String str) {
        k.g(list, "data");
        k.g(str, "msg");
        return new PolicyHistoryListResponse(i5, list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyHistoryListResponse)) {
            return false;
        }
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) obj;
        return this.code == policyHistoryListResponse.code && k.b(this.data, policyHistoryListResponse.data) && k.b(this.msg, policyHistoryListResponse.msg);
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
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "PolicyHistoryListResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
