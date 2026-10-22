package com.stepos.policy.sdk.bean;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "", "code", "", "data", "", "msg", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyOperateRecordResponse {
    private final int code;

    @NotNull
    private final String data;

    @NotNull
    private final String msg;

    public PolicyOperateRecordResponse(int i4, @NotNull String data, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.code = i4;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyOperateRecordResponse copy$default(PolicyOperateRecordResponse policyOperateRecordResponse, int i4, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = policyOperateRecordResponse.code;
        }
        if ((i5 & 2) != 0) {
            str = policyOperateRecordResponse.data;
        }
        if ((i5 & 4) != 0) {
            str2 = policyOperateRecordResponse.msg;
        }
        return policyOperateRecordResponse.copy(i4, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final PolicyOperateRecordResponse copy(int code, @NotNull String data, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new PolicyOperateRecordResponse(code, data, msg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyOperateRecordResponse)) {
            return false;
        }
        PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) other;
        return this.code == policyOperateRecordResponse.code && Intrinsics.areEqual(this.data, policyOperateRecordResponse.data) && Intrinsics.areEqual(this.msg, policyOperateRecordResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + AbstractC0351g.d(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyOperateRecordResponse(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", msg=");
        return g.q(sb, this.msg, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
