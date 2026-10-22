package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "", "code", "", "data", "", "Lcom/stepos/policy/sdk/bean/PolicyResponse;", "msg", "", "(ILjava/util/List;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyHistoryListResponse {
    private final int code;
    private final List<PolicyResponse> data;
    private final String msg;

    public PolicyHistoryListResponse(int i10, List<PolicyResponse> data, String msg) {
        p.i(data, "data");
        p.i(msg, "msg");
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

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final List<PolicyResponse> component2() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final PolicyHistoryListResponse copy(int code, List<PolicyResponse> data, String msg) {
        p.i(data, "data");
        p.i(msg, "msg");
        return new PolicyHistoryListResponse(code, data, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyHistoryListResponse)) {
            return false;
        }
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) other;
        return this.code == policyHistoryListResponse.code && p.d(this.data, policyHistoryListResponse.data) && p.d(this.msg, policyHistoryListResponse.msg);
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
