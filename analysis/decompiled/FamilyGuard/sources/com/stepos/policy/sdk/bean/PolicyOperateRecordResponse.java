package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class PolicyOperateRecordResponse {
    private final int code;
    private final String data;
    private final String msg;

    public PolicyOperateRecordResponse(int i5, String str, String str2) {
        k.g(str, "data");
        k.g(str2, "msg");
        this.code = i5;
        this.data = str;
        this.msg = str2;
    }

    public static /* synthetic */ PolicyOperateRecordResponse copy$default(PolicyOperateRecordResponse policyOperateRecordResponse, int i5, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = policyOperateRecordResponse.code;
        }
        if ((i6 & 2) != 0) {
            str = policyOperateRecordResponse.data;
        }
        if ((i6 & 4) != 0) {
            str2 = policyOperateRecordResponse.msg;
        }
        return policyOperateRecordResponse.copy(i5, str, str2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyOperateRecordResponse copy(int i5, String str, String str2) {
        k.g(str, "data");
        k.g(str2, "msg");
        return new PolicyOperateRecordResponse(i5, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyOperateRecordResponse)) {
            return false;
        }
        PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) obj;
        return this.code == policyOperateRecordResponse.code && k.b(this.data, policyOperateRecordResponse.data) && k.b(this.msg, policyOperateRecordResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "PolicyOperateRecordResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
