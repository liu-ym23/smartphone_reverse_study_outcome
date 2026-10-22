package com.stepos.core.ota.download.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceConditions {
    private final long sampledAtMs;
    private final Map<ConditionKey<?>, Object> values;
    public static final Companion Companion = new Companion(null);
    private static final ConditionKey<Float> TEMPERATURE_C = new ConditionKey<>("temperature_c");
    private static final DeviceConditions EMPTY = new DeviceConditions(b.d0(), 0);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Builder {
        private final HashMap<ConditionKey<?>, Object> map = new HashMap<>();
        private long sampledAtMs;

        public final DeviceConditions build() {
            return new DeviceConditions(new HashMap(this.map), this.sampledAtMs, null);
        }

        public final long getSampledAtMs() {
            return this.sampledAtMs;
        }

        public final <T> Builder put(ConditionKey<T> key, T t8) {
            g.f(key, "key");
            if (t8 != null) {
                this.map.put(key, t8);
            }
            return this;
        }

        public final void setSampledAtMs(long j10) {
            this.sampledAtMs = j10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        public final DeviceConditions getEMPTY() {
            return DeviceConditions.EMPTY;
        }

        public final ConditionKey<Float> getTEMPERATURE_C() {
            return DeviceConditions.TEMPERATURE_C;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeviceConditions(Map map, long j10, e eVar) {
        this(map, j10);
    }

    public final <T> T get(ConditionKey<T> key) {
        g.f(key, "key");
        return (T) this.values.get(key);
    }

    public final <T> T getOr(ConditionKey<T> key, T t8) {
        g.f(key, "key");
        T t10 = (T) get(key);
        return t10 == null ? t8 : t10;
    }

    public final long getSampledAtMs() {
        return this.sampledAtMs;
    }

    public final boolean has(ConditionKey<?> key) {
        g.f(key, "key");
        return this.values.containsKey(key);
    }

    public final Set<ConditionKey<?>> keys() {
        return this.values.keySet();
    }

    private DeviceConditions(Map<ConditionKey<?>, ? extends Object> map, long j10) {
        this.values = map;
        this.sampledAtMs = j10;
    }
}
