package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import java.util.List;
import k0.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHistoryListResponse {
    private final int code;
    private final List<PolicyResponse> data;
    private final String msg;

    public PolicyHistoryListResponse(int i, List<PolicyResponse> list, String str) {
        list.getClass();
        str.getClass();
        this.code = i;
        this.data = list;
        this.msg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyHistoryListResponse copy$default(PolicyHistoryListResponse policyHistoryListResponse, int i, List list, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = policyHistoryListResponse.code;
        }
        if ((i3 & 2) != 0) {
            list = policyHistoryListResponse.data;
        }
        if ((i3 & 4) != 0) {
            str = policyHistoryListResponse.msg;
        }
        return policyHistoryListResponse.copy(i, list, str);
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

    public final PolicyHistoryListResponse copy(int i, List<PolicyResponse> list, String str) {
        list.getClass();
        str.getClass();
        return new PolicyHistoryListResponse(i, list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyHistoryListResponse)) {
            return false;
        }
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) obj;
        return this.code == policyHistoryListResponse.code && k.a(this.data, policyHistoryListResponse.data) && k.a(this.msg, policyHistoryListResponse.msg);
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
        return this.msg.hashCode() + b.e(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyHistoryListResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.s(sb2, this.msg, ')');
    }
}
