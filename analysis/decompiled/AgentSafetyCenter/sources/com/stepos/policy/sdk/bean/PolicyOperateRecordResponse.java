package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import k0.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyOperateRecordResponse {
    private final int code;
    private final String data;
    private final String msg;

    public PolicyOperateRecordResponse(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.code = i;
        this.data = str;
        this.msg = str2;
    }

    public static /* synthetic */ PolicyOperateRecordResponse copy$default(PolicyOperateRecordResponse policyOperateRecordResponse, int i, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = policyOperateRecordResponse.code;
        }
        if ((i3 & 2) != 0) {
            str = policyOperateRecordResponse.data;
        }
        if ((i3 & 4) != 0) {
            str2 = policyOperateRecordResponse.msg;
        }
        return policyOperateRecordResponse.copy(i, str, str2);
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

    public final PolicyOperateRecordResponse copy(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        return new PolicyOperateRecordResponse(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyOperateRecordResponse)) {
            return false;
        }
        PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) obj;
        return this.code == policyOperateRecordResponse.code && k.a(this.data, policyOperateRecordResponse.data) && k.a(this.msg, policyOperateRecordResponse.msg);
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
        return this.msg.hashCode() + b.d(Integer.hashCode(this.code) * 31, 31, this.data);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyOperateRecordResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.s(sb2, this.msg, ')');
    }
}
