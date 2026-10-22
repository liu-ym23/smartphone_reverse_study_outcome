package com.stepos.policy.sdk.util;

import j4.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.libpag.BuildConfig;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicyCloudPolicyIndex {
    public static final PolicyCloudPolicyIndex INSTANCE = new PolicyCloudPolicyIndex();
    private static final ConcurrentHashMap<String, String> uidToCategory = new ConcurrentHashMap<>();

    private PolicyCloudPolicyIndex() {
    }

    public static final void clear() {
        uidToCategory.clear();
    }

    public static final String getCategory(String str) {
        String string = str != null ? C1031n.i0(str).toString() : null;
        if (string == null) {
            string = BuildConfig.FLAVOR;
        }
        if (string.length() == 0) {
            return null;
        }
        return uidToCategory.get(string);
    }

    public static final void put(String str, String str2) {
        k.g(str, "policyUid");
        k.g(str2, "category");
        String string = C1031n.i0(str).toString();
        String string2 = C1031n.i0(str2).toString();
        if (string.length() == 0 || string2.length() == 0) {
            return;
        }
        uidToCategory.put(string, string2);
        PolicySdkLogUtils.Companion.d("CloudPolicyIndex", "put uid=" + string + " category=" + string2);
    }

    public static final void putAll(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public static final Map<String, String> snapshot() {
        return new HashMap(uidToCategory);
    }
}
