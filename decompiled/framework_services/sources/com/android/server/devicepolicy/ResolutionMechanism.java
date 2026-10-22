package com.android.server.devicepolicy;

import android.app.admin.PolicyValue;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class ResolutionMechanism<V> {
    /* JADX INFO: renamed from: getParcelableResolutionMechanism */
    abstract android.app.admin.ResolutionMechanism<V> mo3501getParcelableResolutionMechanism();

    abstract PolicyValue<V> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r1);

    ResolutionMechanism() {
    }

    PolicyValue<V> resolve(List<PolicyValue<V>> adminPolicies) {
        throw new UnsupportedOperationException();
    }
}
