package com.stepos.mcp.sdk.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003R@\u0010\u0012\u001a.\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0010j\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/mcp/sdk/base/AbilityManager;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/mcp/sdk/base/IAbility;", "ability", "LC7/r;", "registerAbility", "(Lcom/stepos/mcp/sdk/base/IAbility;)V", "", "abilityName", "unregisterAbility", "(Ljava/lang/String;)V", "getAbility", "(Ljava/lang/String;)Lcom/stepos/mcp/sdk/base/IAbility;", "clear", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "abilityMap", "Ljava/util/HashMap;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityManager {
    public static final AbilityManager INSTANCE = new AbilityManager();
    private static final HashMap<String, IAbility<?, ?>> abilityMap = new HashMap<>();

    private AbilityManager() {
    }

    public final void clear() {
        abilityMap.clear();
    }

    public final IAbility<?, ?> getAbility(String abilityName) {
        k.f(abilityName, "abilityName");
        return abilityMap.get(abilityName);
    }

    public final void registerAbility(IAbility<?, ?> ability) throws AbilityException {
        k.f(ability, "ability");
        if (ability.getName().length() == 0) {
            throw new AbilityException("abilityName can not be empty", null, 2, null);
        }
        HashMap<String, IAbility<?, ?>> map = abilityMap;
        if (map.containsKey(ability.getName())) {
            return;
        }
        map.put(ability.getName(), ability);
    }

    public final void unregisterAbility(String abilityName) {
        k.f(abilityName, "abilityName");
        abilityMap.remove(abilityName);
    }
}
