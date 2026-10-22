package com.stepos.policy.sdk.bean;

import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyResponse;", "", "data", "Lcom/stepos/policy/sdk/bean/PolicyData;", "newest", "", "(Lcom/stepos/policy/sdk/bean/PolicyData;Z)V", "getData", "()Lcom/stepos/policy/sdk/bean/PolicyData;", "getNewest", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyResponse {

    @NotNull
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(@NotNull PolicyData data, boolean z4) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.newest = z4;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i4 & 2) != 0) {
            z4 = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final PolicyData getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getNewest() {
        return this.newest;
    }

    @NotNull
    public final PolicyResponse copy(@NotNull PolicyData data, boolean newest) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new PolicyResponse(data, newest);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) other;
        return Intrinsics.areEqual(this.data, policyResponse.data) && this.newest == policyResponse.newest;
    }

    @NotNull
    public final PolicyData getData() {
        return this.data;
    }

    public final boolean getNewest() {
        return this.newest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.data.hashCode() * 31;
        boolean z4 = this.newest;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        return iHashCode + i4;
    }

    @NotNull
    public String toString() {
        return "PolicyResponse(data=" + this.data + ", newest=" + this.newest + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
