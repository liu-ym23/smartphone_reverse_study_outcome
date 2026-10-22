package com.stepos.mcp.sdk.base;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityRequest<R> {
    private final String abilityName;
    private final R bean;

    public AbilityRequest(String str, R r10) {
        str.getClass();
        this.abilityName = str;
        this.bean = r10;
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

    public final String component1() {
        return this.abilityName;
    }

    public final R component2() {
        return this.bean;
    }

    public final AbilityRequest<R> copy(String str, R r10) {
        str.getClass();
        return new AbilityRequest<>(str, r10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityRequest)) {
            return false;
        }
        AbilityRequest abilityRequest = (AbilityRequest) obj;
        return k.a(this.abilityName, abilityRequest.abilityName) && k.a(this.bean, abilityRequest.bean);
    }

    public final String getAbilityName() {
        return this.abilityName;
    }

    public final R getBean() {
        return this.bean;
    }

    public int hashCode() {
        int iHashCode = this.abilityName.hashCode() * 31;
        R r10 = this.bean;
        return iHashCode + (r10 == null ? 0 : r10.hashCode());
    }

    public String toString() {
        return "AbilityRequest(abilityName=" + this.abilityName + ", bean=" + this.bean + ")";
    }
}
