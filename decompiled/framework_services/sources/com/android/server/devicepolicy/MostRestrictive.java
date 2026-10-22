package com.android.server.devicepolicy;

import android.app.admin.PolicyValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class MostRestrictive<V> extends ResolutionMechanism<V> {
    private List<PolicyValue<V>> mMostToLeastRestrictive;

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism();
    }

    MostRestrictive(List<PolicyValue<V>> mostToLeastRestrictive) {
        this.mMostToLeastRestrictive = mostToLeastRestrictive;
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<V> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> adminPolicies) {
        return resolve(new ArrayList(adminPolicies.values()));
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<V> resolve(List<PolicyValue<V>> adminPolicies) {
        if (adminPolicies.isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator<PolicyValue<V>> r0 = this.mMostToLeastRestrictive.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        PolicyValue<V> value = r0.next();
        if (adminPolicies.contains(value) == false) goto L8;
        return value;
    L14:
        return adminPolicies.get(0);
    }

    android.app.admin.MostRestrictive<V> getParcelableResolutionMechanism() {
        return new android.app.admin.MostRestrictive(this.mMostToLeastRestrictive);
    }

    public String toString() {
        return "MostRestrictive { mMostToLeastRestrictive= " + this.mMostToLeastRestrictive + " }";
    }
}
