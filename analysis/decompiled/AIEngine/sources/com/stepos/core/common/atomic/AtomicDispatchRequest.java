package com.stepos.core.common.atomic;

import ai.onnxruntime.a;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtomicDispatchRequest {
    private final Map<String, String> extras;
    private final String function;
    private final Map<String, String> params;
    private final String priority;
    private final String text;

    public AtomicDispatchRequest(String function, String text, Map<String, String> params, String str, Map<String, String> map) {
        g.f(function, "function");
        g.f(text, "text");
        g.f(params, "params");
        this.function = function;
        this.text = text;
        this.params = params;
        this.priority = str;
        this.extras = map;
    }

    public static /* synthetic */ AtomicDispatchRequest copy$default(AtomicDispatchRequest atomicDispatchRequest, String str, String str2, Map map, String str3, Map map2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = atomicDispatchRequest.function;
        }
        if ((i10 & 2) != 0) {
            str2 = atomicDispatchRequest.text;
        }
        if ((i10 & 4) != 0) {
            map = atomicDispatchRequest.params;
        }
        if ((i10 & 8) != 0) {
            str3 = atomicDispatchRequest.priority;
        }
        if ((i10 & 16) != 0) {
            map2 = atomicDispatchRequest.extras;
        }
        Map map3 = map2;
        Map map4 = map;
        return atomicDispatchRequest.copy(str, str2, map4, str3, map3);
    }

    public final String component1() {
        return this.function;
    }

    public final String component2() {
        return this.text;
    }

    public final Map<String, String> component3() {
        return this.params;
    }

    public final String component4() {
        return this.priority;
    }

    public final Map<String, String> component5() {
        return this.extras;
    }

    public final AtomicDispatchRequest copy(String function, String text, Map<String, String> params, String str, Map<String, String> map) {
        g.f(function, "function");
        g.f(text, "text");
        g.f(params, "params");
        return new AtomicDispatchRequest(function, text, params, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AtomicDispatchRequest)) {
            return false;
        }
        AtomicDispatchRequest atomicDispatchRequest = (AtomicDispatchRequest) obj;
        return g.b(this.function, atomicDispatchRequest.function) && g.b(this.text, atomicDispatchRequest.text) && g.b(this.params, atomicDispatchRequest.params) && g.b(this.priority, atomicDispatchRequest.priority) && g.b(this.extras, atomicDispatchRequest.extras);
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getFunction() {
        return this.function;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int iHashCode = (this.params.hashCode() + d.a(this.function.hashCode() * 31, 31, this.text)) * 31;
        String str = this.priority;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.extras;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        String str = this.function;
        String str2 = this.text;
        Map<String, String> map = this.params;
        String str3 = this.priority;
        Map<String, String> map2 = this.extras;
        StringBuilder sbS = a.s("AtomicDispatchRequest(function=", str, ", text=", str2, ", params=");
        sbS.append(map);
        sbS.append(", priority=");
        sbS.append(str3);
        sbS.append(", extras=");
        sbS.append(map2);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ AtomicDispatchRequest(String str, String str2, Map map, String str3, Map map2, int i10, e eVar) {
        this(str, str2, map, str3, (i10 & 16) != 0 ? null : map2);
    }
}
