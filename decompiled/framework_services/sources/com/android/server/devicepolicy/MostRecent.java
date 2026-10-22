package com.android.server.devicepolicy;

import android.app.admin.PolicyValue;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MostRecent<V> extends ResolutionMechanism<V> {
    MostRecent() {
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    /* JADX INFO: renamed from: getParcelableResolutionMechanism, reason: collision with other method in class */
    /* bridge */ /* synthetic */ android.app.admin.ResolutionMechanism mo3501getParcelableResolutionMechanism() {
        return getParcelableResolutionMechanism();
    }

    @Override // com.android.server.devicepolicy.ResolutionMechanism
    PolicyValue<V> resolve(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> adminPolicies) {
        List<Map.Entry<EnforcingAdmin, PolicyValue<V>>> policiesList = new ArrayList(adminPolicies.entrySet());
        if (policiesList.isEmpty() == false) goto L6;
        return null;
    L6:
        return policiesList.get(policiesList.size() - 1).getValue();
    }

    android.app.admin.MostRecent<V> getParcelableResolutionMechanism() {
        return new android.app.admin.MostRecent();
    }

    public String toString() {
        return "MostRecent {}";
    }
}
