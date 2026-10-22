package com.android.server.devicepolicy;

import android.app.admin.Authority;
import android.app.admin.PolicyValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
final class TopPriority<V> extends ResolutionMechanism<V> {
    private final List<String> mHighestToLowestPriorityAuthorities;

    /* JADX INFO: renamed from: $r8$lambda$6lUR-vAHYPzsWytonmT7aquNLSg, reason: not valid java name */
    public static /* synthetic */ boolean m3528$r8$lambda$6lURvAHYPzsWytonmT7aquNLSg(String r0, EnforcingAdmin r1) {
        return lambda$resolve$0(r0, r1);
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism();
    }

    TopPriority(List<String> highestToLowestPriorityAuthorities) {
        highestToLowestPriorityAuthorities.getClass();
        this.mHighestToLowestPriorityAuthorities = highestToLowestPriorityAuthorities;
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<V> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> adminPolicies) {
        if (adminPolicies.isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator<String> r0 = this.mHighestToLowestPriorityAuthorities.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        final String authority = r0.next();
        Optional<EnforcingAdmin> admin = adminPolicies.keySet().stream().filter(new TopPriority$$ExternalSyntheticLambda0(authority)).findFirst();
        if (admin.isPresent() == false) goto L8;
        return adminPolicies.get(admin.get());
    L14:
        Map.Entry<EnforcingAdmin, PolicyValue<V>> policy = adminPolicies.entrySet().stream().findFirst().get();
        return policy.getValue();
    }

    private static /* synthetic */ boolean lambda$resolve$0(String authority, EnforcingAdmin a) {
        return a.hasAuthority(authority);
    }

    android.app.admin.TopPriority<V> getParcelableResolutionMechanism() {
        return new android.app.admin.TopPriority(getParcelableAuthorities());
    }

    private List<Authority> getParcelableAuthorities() {
        List<Authority> authorities = new ArrayList();
        Iterator<String> r1 = this.mHighestToLowestPriorityAuthorities.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String authority = r1.next();
        authorities.add(EnforcingAdmin.getParcelableAuthority(authority));
        goto L4
    L6:
        return authorities;
    }

    public String toString() {
        return "TopPriority { mHighestToLowestPriorityAuthorities= " + this.mHighestToLowestPriorityAuthorities + " }";
    }
}
