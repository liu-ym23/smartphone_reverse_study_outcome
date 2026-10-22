package com.stepos.policy.sdk.bean;

import B0.g;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "", "code", "", "data", "Lcom/stepos/policy/sdk/bean/PolicyResponse;", "msg", "", "(ILcom/stepos/policy/sdk/bean/PolicyResponse;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/stepos/policy/sdk/bean/PolicyResponse;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyNewestResponse {
    private final int code;

    @NotNull
    private final PolicyResponse data;

    @NotNull
    private final String msg;

    public PolicyNewestResponse(int i4, @NotNull PolicyResponse data, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.code = i4;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyNewestResponse copy$default(PolicyNewestResponse policyNewestResponse, int i4, PolicyResponse policyResponse, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = policyNewestResponse.code;
        }
        if ((i5 & 2) != 0) {
            policyResponse = policyNewestResponse.data;
        }
        if ((i5 & 4) != 0) {
            str = policyNewestResponse.msg;
        }
        return policyNewestResponse.copy(i4, policyResponse, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final PolicyResponse getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final PolicyNewestResponse copy(int code, @NotNull PolicyResponse data, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new PolicyNewestResponse(code, data, msg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyNewestResponse)) {
            return false;
        }
        PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) other;
        return this.code == policyNewestResponse.code && Intrinsics.areEqual(this.data, policyNewestResponse.data) && Intrinsics.areEqual(this.msg, policyNewestResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final PolicyResponse getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyNewestResponse(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", msg=");
        return g.q(sb, this.msg, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
