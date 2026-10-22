package com.stepos.policy.sdk.bean;

import androidx.appfunctions.metadata.a;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyResponse;", "", SettingsConfig.KEY_DATA, "Lcom/stepos/policy/sdk/bean/PolicyData;", "newest", "", "(Lcom/stepos/policy/sdk/bean/PolicyData;Z)V", "getData", "()Lcom/stepos/policy/sdk/bean/PolicyData;", "getNewest", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyResponse {
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(PolicyData data, boolean z10) {
        k.f(data, "data");
        this.data = data;
        this.newest = z10;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i & 2) != 0) {
            z10 = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final PolicyData getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getNewest() {
        return this.newest;
    }

    public final PolicyResponse copy(PolicyData data, boolean newest) {
        k.f(data, "data");
        return new PolicyResponse(data, newest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) other;
        return k.b(this.data, policyResponse.data) && this.newest == policyResponse.newest;
    }

    public final PolicyData getData() {
        return this.data;
    }

    public final boolean getNewest() {
        return this.newest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.data.hashCode() * 31;
        boolean z10 = this.newest;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyResponse(data=");
        sb.append(this.data);
        sb.append(", newest=");
        return a.r(sb, this.newest, ')');
    }
}
