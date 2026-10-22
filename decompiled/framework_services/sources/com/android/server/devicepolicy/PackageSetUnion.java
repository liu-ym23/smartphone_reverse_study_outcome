package com.android.server.devicepolicy;

import android.app.admin.PackageSetPolicyValue;
import android.app.admin.PolicyValue;
import android.app.admin.StringSetUnion;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class PackageSetUnion extends ResolutionMechanism<Set<String>> {
    PackageSetUnion() {
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism<Set<String>> mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism2();
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<Set<String>> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<Set<String>>> adminPolicies) {
        adminPolicies.getClass();
        if (adminPolicies.isEmpty() == false) goto L6;
        return null;
    L6:
        Set<String> unionOfPolicies = new HashSet();
        Iterator<PolicyValue<Set<String>>> r1 = adminPolicies.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        PolicyValue<Set<String>> policy = r1.next();
        unionOfPolicies.addAll((Collection) policy.getValue());
        goto L8
    L11:
        return new PackageSetPolicyValue(unionOfPolicies);
    }

    /* JADX INFO: renamed from: getParcelableResolutionMechanism, reason: avoid collision after fix types in other method */
    StringSetUnion getParcelableResolutionMechanism2() {
        return new StringSetUnion();
    }

    public String toString() {
        return "PackageSetUnion {}";
    }
}
