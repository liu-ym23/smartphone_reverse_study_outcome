package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyOperateRecordResponse {
    private final int code;
    private final String data;
    private final String msg;

    public PolicyOperateRecordResponse(int i10, String data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        this.code = i10;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyOperateRecordResponse copy$default(PolicyOperateRecordResponse policyOperateRecordResponse, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = policyOperateRecordResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = policyOperateRecordResponse.data;
        }
        if ((i11 & 4) != 0) {
            str2 = policyOperateRecordResponse.msg;
        }
        return policyOperateRecordResponse.copy(i10, str, str2);
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

    public final PolicyOperateRecordResponse copy(int i10, String data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        return new PolicyOperateRecordResponse(i10, data, msg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyOperateRecordResponse)) {
            return false;
        }
        PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) obj;
        return this.code == policyOperateRecordResponse.code && g.b(this.data, policyOperateRecordResponse.data) && g.b(this.msg, policyOperateRecordResponse.msg);
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
        return this.msg.hashCode() + d.a(Integer.hashCode(this.code) * 31, 31, this.data);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyOperateRecordResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.n(sb2, this.msg, ')');
    }
}
