package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyVersionResponse {
    private final int code;
    private final PolicyData data;
    private final String msg;

    public PolicyVersionResponse(int i10, PolicyData data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        this.code = i10;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyVersionResponse copy$default(PolicyVersionResponse policyVersionResponse, int i10, PolicyData policyData, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = policyVersionResponse.code;
        }
        if ((i11 & 2) != 0) {
            policyData = policyVersionResponse.data;
        }
        if ((i11 & 4) != 0) {
            str = policyVersionResponse.msg;
        }
        return policyVersionResponse.copy(i10, policyData, str);
    }

    public final int component1() {
        return this.code;
    }

    public final PolicyData component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyVersionResponse copy(int i10, PolicyData data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        return new PolicyVersionResponse(i10, data, msg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyVersionResponse)) {
            return false;
        }
        PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) obj;
        return this.code == policyVersionResponse.code && g.b(this.data, policyVersionResponse.data) && g.b(this.msg, policyVersionResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final PolicyData getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyVersionResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.n(sb2, this.msg, ')');
    }
}
