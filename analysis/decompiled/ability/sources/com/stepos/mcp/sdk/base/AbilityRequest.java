package com.stepos.mcp.sdk.base;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/mcp/sdk/base/AbilityRequest;", "R", "", "abilityName", "", "bean", "(Ljava/lang/String;Ljava/lang/Object;)V", "getAbilityName", "()Ljava/lang/String;", "getBean", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/stepos/mcp/sdk/base/AbilityRequest;", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityRequest<R> {
    private final String abilityName;
    private final R bean;

    public AbilityRequest(String abilityName, R r5) {
        k.f(abilityName, "abilityName");
        this.abilityName = abilityName;
        this.bean = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AbilityRequest copy$default(AbilityRequest abilityRequest, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = abilityRequest.abilityName;
        }
        if ((i & 2) != 0) {
            obj = abilityRequest.bean;
        }
        return abilityRequest.copy(str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAbilityName() {
        return this.abilityName;
    }

    public final R component2() {
        return this.bean;
    }

    public final AbilityRequest<R> copy(String abilityName, R bean) {
        k.f(abilityName, "abilityName");
        return new AbilityRequest<>(abilityName, bean);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityRequest)) {
            return false;
        }
        AbilityRequest abilityRequest = (AbilityRequest) other;
        return k.b(this.abilityName, abilityRequest.abilityName) && k.b(this.bean, abilityRequest.bean);
    }

    public final String getAbilityName() {
        return this.abilityName;
    }

    public final R getBean() {
        return this.bean;
    }

    public int hashCode() {
        int iHashCode = this.abilityName.hashCode() * 31;
        R r5 = this.bean;
        return iHashCode + (r5 == null ? 0 : r5.hashCode());
    }

    public String toString() {
        return "AbilityRequest(abilityName=" + this.abilityName + ", bean=" + this.bean + ")";
    }
}
