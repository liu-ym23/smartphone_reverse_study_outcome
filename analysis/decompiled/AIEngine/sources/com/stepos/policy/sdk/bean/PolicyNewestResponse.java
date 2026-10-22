package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyNewestResponse {
    private final int code;
    private final PolicyResponse data;
    private final String msg;

    public PolicyNewestResponse(int i10, PolicyResponse data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        this.code = i10;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyNewestResponse copy$default(PolicyNewestResponse policyNewestResponse, int i10, PolicyResponse policyResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = policyNewestResponse.code;
        }
        if ((i11 & 2) != 0) {
            policyResponse = policyNewestResponse.data;
        }
        if ((i11 & 4) != 0) {
            str = policyNewestResponse.msg;
        }
        return policyNewestResponse.copy(i10, policyResponse, str);
    }

    public final int component1() {
        return this.code;
    }

    public final PolicyResponse component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final PolicyNewestResponse copy(int i10, PolicyResponse data, String msg) {
        g.f(data, "data");
        g.f(msg, "msg");
        return new PolicyNewestResponse(i10, data, msg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyNewestResponse)) {
            return false;
        }
        PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) obj;
        return this.code == policyNewestResponse.code && g.b(this.data, policyNewestResponse.data) && g.b(this.msg, policyNewestResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final PolicyResponse getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyNewestResponse(code=");
        sb2.append(this.code);
        sb2.append(", data=");
        sb2.append(this.data);
        sb2.append(", msg=");
        return a.n(sb2, this.msg, ')');
    }
}
