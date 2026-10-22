package com.stepos.policy.sdk.util;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import j9.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u0003R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyCloudPolicyIndex;", "", AppAgent.CONSTRUCT, "()V", "", "policyUid", QueryAlgorithmBundle.KEY_CATEGORY, "LC7/r;", "put", "(Ljava/lang/String;Ljava/lang/String;)V", "", "map", "putAll", "(Ljava/util/Map;)V", "getCategory", "(Ljava/lang/String;)Ljava/lang/String;", RequestInfo.FUNCTION_SNAPSHOT, "()Ljava/util/Map;", "clear", "Ljava/util/concurrent/ConcurrentHashMap;", "uidToCategory", "Ljava/util/concurrent/ConcurrentHashMap;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyCloudPolicyIndex {
    public static final PolicyCloudPolicyIndex INSTANCE = new PolicyCloudPolicyIndex();
    private static final ConcurrentHashMap<String, String> uidToCategory = new ConcurrentHashMap<>();

    private PolicyCloudPolicyIndex() {
    }

    public static final void clear() {
        uidToCategory.clear();
    }

    public static final String getCategory(String policyUid) {
        String string = policyUid != null ? m.R0(policyUid).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return null;
        }
        return uidToCategory.get(string);
    }

    public static final void put(String policyUid, String category) {
        k.f(policyUid, "policyUid");
        k.f(category, "category");
        String string = m.R0(policyUid).toString();
        String string2 = m.R0(category).toString();
        if (string.length() == 0 || string2.length() == 0) {
            return;
        }
        uidToCategory.put(string, string2);
        PolicySdkLogUtils.INSTANCE.d("CloudPolicyIndex", B7.a.n("put uid=", string, " category=", string2));
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
