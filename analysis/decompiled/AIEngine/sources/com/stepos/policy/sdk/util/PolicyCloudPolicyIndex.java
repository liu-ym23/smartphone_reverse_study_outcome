package com.stepos.policy.sdk.util;

import gc.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        String string = str != null ? q.L0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return null;
        }
        return uidToCategory.get(string);
    }

    public static final void put(String policyUid, String category) {
        kotlin.jvm.internal.g.f(policyUid, "policyUid");
        kotlin.jvm.internal.g.f(category, "category");
        String string = q.L0(policyUid).toString();
        String string2 = q.L0(category).toString();
        if (string.length() == 0 || string2.length() == 0) {
            return;
        }
        uidToCategory.put(string, string2);
        PolicySdkLogUtils.Companion.d("CloudPolicyIndex", ai.onnxruntime.a.l("put uid=", string, " category=", string2));
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
