package com.stepos.mcp.sdk.base;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003JL\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0010\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/stepos/mcp/sdk/base/AbilityResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "abilityName", "", "result", "meta", "", "customData", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Object;)V", "getAbilityName", "()Ljava/lang/String;", "getCustomData", "()Ljava/lang/Object;", "getMeta", "()Ljava/util/Map;", "getResult", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Object;)Lcom/stepos/mcp/sdk/base/AbilityResult;", "equals", "", "other", "hashCode", "", "toString", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityResult<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String abilityName;
    private final Object customData;
    private final Map<String, Object> meta;
    private final T result;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J?\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u0002H\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/mcp/sdk/base/AbilityResult$Companion;", "", "()V", "buildFailedResult", "Lcom/stepos/mcp/sdk/base/AbilityResult;", "", "abilityName", "reason", "buildResult", ExifInterface.GPS_DIRECTION_TRUE, "result", "appUI", "Lcom/stepos/mcp/sdk/base/AppUI;", "custom", "(Ljava/lang/String;Ljava/lang/Object;Lcom/stepos/mcp/sdk/base/AppUI;Ljava/lang/Object;)Lcom/stepos/mcp/sdk/base/AbilityResult;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
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

        public final AbilityResult<String> buildFailedResult(String abilityName) {
            k.f(abilityName, "abilityName");
            return new AbilityResult<>(abilityName, "call failed", null, null, 12, null);
        }

        public final <T> AbilityResult<T> buildResult(String abilityName, T result, AppUI appUI, Object custom) {
            k.f(abilityName, "abilityName");
            HashMap map = new HashMap();
            if (appUI != null) {
                map.put("appUI", appUI);
            }
            return new AbilityResult<>(abilityName, result, map, custom);
        }

        private Companion() {
        }

        public final AbilityResult<String> buildFailedResult(String abilityName, String reason) {
            k.f(abilityName, "abilityName");
            k.f(reason, "reason");
            return new AbilityResult<>(abilityName, "call failed, because of ".concat(reason), null, null, 12, null);
        }
    }

    public AbilityResult(String abilityName, T t9, Map<String, ? extends Object> map, Object obj) {
        k.f(abilityName, "abilityName");
        this.abilityName = abilityName;
        this.result = t9;
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

    /* renamed from: component1, reason: from getter */
    public final String getAbilityName() {
        return this.abilityName;
    }

    public final T component2() {
        return this.result;
    }

    public final Map<String, Object> component3() {
        return this.meta;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getCustomData() {
        return this.customData;
    }

    public final AbilityResult<T> copy(String abilityName, T result, Map<String, ? extends Object> meta, Object customData) {
        k.f(abilityName, "abilityName");
        return new AbilityResult<>(abilityName, result, meta, customData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityResult)) {
            return false;
        }
        AbilityResult abilityResult = (AbilityResult) other;
        return k.b(this.abilityName, abilityResult.abilityName) && k.b(this.result, abilityResult.result) && k.b(this.meta, abilityResult.meta) && k.b(this.customData, abilityResult.customData);
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
        T t9 = this.result;
        int iHashCode2 = (iHashCode + (t9 == null ? 0 : t9.hashCode())) * 31;
        Map<String, Object> map = this.meta;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Object obj = this.customData;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "AbilityResult(abilityName=" + this.abilityName + ", result=" + this.result + ", meta=" + this.meta + ", customData=" + this.customData + ")";
    }

    public /* synthetic */ AbilityResult(String str, Object obj, Map map, Object obj2, int i, e eVar) {
        this(str, obj, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : obj2);
    }
}
