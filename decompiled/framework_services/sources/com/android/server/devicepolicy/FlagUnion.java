package com.android.server.devicepolicy;

import android.app.admin.IntegerPolicyValue;
import android.app.admin.PolicyValue;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class FlagUnion extends ResolutionMechanism<Integer> {
    FlagUnion() {
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism<Integer> mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism2();
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* bridge */ /* synthetic */ PolicyValue<Integer> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<Integer>> r1) {
        return resolve2(r1);
    }

    /* JADX INFO: renamed from: resolve, reason: avoid collision after fix types in other method */
    IntegerPolicyValue resolve2(LinkedHashMap<EnforcingAdmin, PolicyValue<Integer>> adminPolicies) {
        adminPolicies.getClass();
        if (adminPolicies.isEmpty() == false) goto L6;
        return null;
    L6:
        Integer unionOfPolicies = 0;
        Iterator<PolicyValue<Integer>> r1 = adminPolicies.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        PolicyValue<Integer> policy = r1.next();
        unionOfPolicies = Integer.valueOf(unionOfPolicies.intValue() | ((Integer) policy.getValue()).intValue());
        goto L8
    L11:
        return new IntegerPolicyValue(unionOfPolicies.intValue());
    }

    /* JADX INFO: renamed from: getParcelableResolutionMechanism, reason: avoid collision after fix types in other method */
    android.app.admin.FlagUnion getParcelableResolutionMechanism2() {
        return android.app.admin.FlagUnion.FLAG_UNION;
    }

    public String toString() {
        return "IntegerUnion {}";
    }
}
