package com.stepos.mcp.sdk.base;

import java.util.HashMap;
import java.util.Map;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityResult<T> {
    public static final Companion Companion = new Companion(null);
    private final String abilityName;
    private final Object customData;
    private final Map<String, Object> meta;
    private final T result;

    public AbilityResult(String str, T t10, Map<String, ? extends Object> map, Object obj) {
        str.getClass();
        this.abilityName = str;
        this.result = t10;
        this.meta = map;
        this.customData = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AbilityResult copy$default(AbilityResult abilityResult, String str, Object obj, Map map, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = abilityResult.abilityName;
        }
        if ((i & 2) != 0) {
            obj = abilityResult.result;
        }
        if ((i & 4) != 0) {
            map = abilityResult.meta;
        }
        if ((i & 8) != 0) {
            obj2 = abilityResult.customData;
        }
        return abilityResult.copy(str, obj, map, obj2);
    }

    public final String component1() {
        return this.abilityName;
    }

    public final T component2() {
        return this.result;
    }

    public final Map<String, Object> component3() {
        return this.meta;
    }

    public final Object component4() {
        return this.customData;
    }

    public final AbilityResult<T> copy(String str, T t10, Map<String, ? extends Object> map, Object obj) {
        str.getClass();
        return new AbilityResult<>(str, t10, map, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityResult)) {
            return false;
        }
        AbilityResult abilityResult = (AbilityResult) obj;
        return k.a(this.abilityName, abilityResult.abilityName) && k.a(this.result, abilityResult.result) && k.a(this.meta, abilityResult.meta) && k.a(this.customData, abilityResult.customData);
    }

    public final String getAbilityName() {
        return this.abilityName;
    }

    public final Object getCustomData() {
        return this.customData;
    }

    public final Map<String, Object> getMeta() {
        return this.meta;
    }

    public final T getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.abilityName.hashCode() * 31;
        T t10 = this.result;
        int iHashCode2 = (iHashCode + (t10 == null ? 0 : t10.hashCode())) * 31;
        Map<String, Object> map = this.meta;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Object obj = this.customData;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "AbilityResult(abilityName=" + this.abilityName + ", result=" + this.result + ", meta=" + this.meta + ", customData=" + this.customData + ")";
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ AbilityResult buildResult$default(Companion companion, String str, Object obj, AppUI appUI, Object obj2, int i, Object obj3) {
            if ((i & 4) != 0) {
                appUI = null;
            }
            if ((i & 8) != 0) {
                obj2 = null;
            }
            return companion.buildResult(str, obj, appUI, obj2);
        }

        public final AbilityResult<String> buildFailedResult(String str, String str2) {
            str.getClass();
            str2.getClass();
            return new AbilityResult<>(str, "call failed, because of ".concat(str2), null, null, 12, null);
        }

        public final <T> AbilityResult<T> buildResult(String str, T t10, AppUI appUI, Object obj) {
            str.getClass();
            HashMap map = new HashMap();
            if (appUI != null) {
                map.put("appUI", appUI);
            }
            return new AbilityResult<>(str, t10, map, obj);
        }

        private Companion() {
        }

        public final AbilityResult<String> buildFailedResult(String str) {
            str.getClass();
            return new AbilityResult<>(str, "call failed", null, null, 12, null);
        }
    }

    public /* synthetic */ AbilityResult(String str, Object obj, Map map, Object obj2, int i, f fVar) {
        this(str, obj, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : obj2);
    }
}
