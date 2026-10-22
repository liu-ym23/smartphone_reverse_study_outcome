package com.stepos.mcp.sdk.base;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityManager {
    public static final AbilityManager INSTANCE = new AbilityManager();
    private static final HashMap<String, IAbility<?, ?>> abilityMap = new HashMap<>();

    private AbilityManager() {
    }

    public final void clear() {
        abilityMap.clear();
    }

    public final IAbility<?, ?> getAbility(String str) {
        str.getClass();
        return abilityMap.get(str);
    }

    public final void registerAbility(IAbility<?, ?> iAbility) throws AbilityException {
        iAbility.getClass();
        if (iAbility.getName().length() == 0) {
            throw new AbilityException("abilityName can not be empty", null, 2, null);
        }
        HashMap<String, IAbility<?, ?>> map = abilityMap;
        if (map.containsKey(iAbility.getName())) {
            return;
        }
        map.put(iAbility.getName(), iAbility);
    }

    public final void unregisterAbility(String str) {
        str.getClass();
        abilityMap.remove(str);
    }
}
