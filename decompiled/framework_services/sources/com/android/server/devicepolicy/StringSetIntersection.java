package com.android.server.devicepolicy;

import android.app.admin.PackageSetPolicyValue;
import android.app.admin.PolicyValue;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class StringSetIntersection extends ResolutionMechanism<Set<String>> {
    StringSetIntersection() {
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism<Set<String>> mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism2();
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<Set<String>> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<Set<String>>> adminPolicies) {
        adminPolicies.getClass();
        Set<String> intersectionOfPolicies = null;
        Iterator<PolicyValue<Set<String>>> r1 = adminPolicies.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        PolicyValue<Set<String>> policy = r1.next();
        if (intersectionOfPolicies == null) goto L7;
        intersectionOfPolicies.retainAll((Collection) policy.getValue());
        goto L4
    L7:
        intersectionOfPolicies = new HashSet((Collection) policy.getValue());
        goto L4
    L10:
        if (intersectionOfPolicies != null) goto L14;
        return null;
    L14:
        return new PackageSetPolicyValue(intersectionOfPolicies);
    }

    /* JADX INFO: renamed from: getParcelableResolutionMechanism, reason: avoid collision after fix types in other method */
    android.app.admin.StringSetIntersection getParcelableResolutionMechanism2() {
        return new android.app.admin.StringSetIntersection();
    }

    public String toString() {
        return "StringSetIntersection {}";
    }
}
