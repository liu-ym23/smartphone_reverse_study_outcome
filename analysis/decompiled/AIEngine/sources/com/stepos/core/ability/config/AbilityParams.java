package com.stepos.core.ability.config;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityParams {

    /* renamed from: id, reason: collision with root package name */
    private final String f7219id;
    private final Integer maxTokens;
    private final Integer sampleRate;
    private final Float temperature;
    private final Float threshold;
    private final Integer topK;
    private final Float topP;

    public AbilityParams(String id2, Integer num, Float f8, Integer num2, Float f9, Integer num3, Float f10) {
        g.f(id2, "id");
        this.f7219id = id2;
        this.maxTokens = num;
        this.temperature = f8;
        this.topK = num2;
        this.topP = f9;
        this.sampleRate = num3;
        this.threshold = f10;
    }

    public static /* synthetic */ AbilityParams copy$default(AbilityParams abilityParams, String str, Integer num, Float f8, Integer num2, Float f9, Integer num3, Float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = abilityParams.f7219id;
        }
        if ((i10 & 2) != 0) {
            num = abilityParams.maxTokens;
        }
        if ((i10 & 4) != 0) {
            f8 = abilityParams.temperature;
        }
        if ((i10 & 8) != 0) {
            num2 = abilityParams.topK;
        }
        if ((i10 & 16) != 0) {
            f9 = abilityParams.topP;
        }
        if ((i10 & 32) != 0) {
            num3 = abilityParams.sampleRate;
        }
        if ((i10 & 64) != 0) {
            f10 = abilityParams.threshold;
        }
        Integer num4 = num3;
        Float f11 = f10;
        Float f12 = f9;
        Float f13 = f8;
        return abilityParams.copy(str, num, f13, num2, f12, num4, f11);
    }

    public final String component1() {
        return this.f7219id;
    }

    public final Integer component2() {
        return this.maxTokens;
    }

    public final Float component3() {
        return this.temperature;
    }

    public final Integer component4() {
        return this.topK;
    }

    public final Float component5() {
        return this.topP;
    }

    public final Integer component6() {
        return this.sampleRate;
    }

    public final Float component7() {
        return this.threshold;
    }

    public final AbilityParams copy(String id2, Integer num, Float f8, Integer num2, Float f9, Integer num3, Float f10) {
        g.f(id2, "id");
        return new AbilityParams(id2, num, f8, num2, f9, num3, f10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityParams)) {
            return false;
        }
        AbilityParams abilityParams = (AbilityParams) obj;
        return g.b(this.f7219id, abilityParams.f7219id) && g.b(this.maxTokens, abilityParams.maxTokens) && g.b(this.temperature, abilityParams.temperature) && g.b(this.topK, abilityParams.topK) && g.b(this.topP, abilityParams.topP) && g.b(this.sampleRate, abilityParams.sampleRate) && g.b(this.threshold, abilityParams.threshold);
    }

    public final String getId() {
        return this.f7219id;
    }

    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    public final Integer getSampleRate() {
        return this.sampleRate;
    }

    public final Float getTemperature() {
        return this.temperature;
    }

    public final Float getThreshold() {
        return this.threshold;
    }

    public final Integer getTopK() {
        return this.topK;
    }

    public final Float getTopP() {
        return this.topP;
    }

    public int hashCode() {
        int iHashCode = this.f7219id.hashCode() * 31;
        Integer num = this.maxTokens;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f8 = this.temperature;
        int iHashCode3 = (iHashCode2 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Integer num2 = this.topK;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f9 = this.topP;
        int iHashCode5 = (iHashCode4 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Integer num3 = this.sampleRate;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Float f10 = this.threshold;
        return iHashCode6 + (f10 != null ? f10.hashCode() : 0);
    }

    public String toString() {
        return "AbilityParams(id=" + this.f7219id + ", maxTokens=" + this.maxTokens + ", temperature=" + this.temperature + ", topK=" + this.topK + ", topP=" + this.topP + ", sampleRate=" + this.sampleRate + ", threshold=" + this.threshold + ")";
    }

    public /* synthetic */ AbilityParams(String str, Integer num, Float f8, Integer num2, Float f9, Integer num3, Float f10, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : f8, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : f9, (i10 & 32) != 0 ? null : num3, (i10 & 64) != 0 ? null : f10);
    }
}
