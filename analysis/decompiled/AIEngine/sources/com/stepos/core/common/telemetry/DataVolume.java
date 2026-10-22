package com.stepos.core.common.telemetry;

import com.stepos.core.common.util.TraceIdKeys;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DataVolume {
    private final Integer audioTokens;
    private final Integer imageTokens;
    private final Integer inputSizeBytes;
    private final Integer inputTokens;
    private final Float kvCacheHitRate;
    private final Integer kvCacheHitTokens;
    private final Long kvCacheSizeBytes;
    private final Integer outputSizeBytes;
    private final Integer outputTokens;

    public DataVolume() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ DataVolume copy$default(DataVolume dataVolume, Integer num, Integer num2, Integer num3, Integer num4, Long l10, Integer num5, Float f8, Integer num6, Integer num7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = dataVolume.inputTokens;
        }
        if ((i10 & 2) != 0) {
            num2 = dataVolume.outputTokens;
        }
        if ((i10 & 4) != 0) {
            num3 = dataVolume.imageTokens;
        }
        if ((i10 & 8) != 0) {
            num4 = dataVolume.audioTokens;
        }
        if ((i10 & 16) != 0) {
            l10 = dataVolume.kvCacheSizeBytes;
        }
        if ((i10 & 32) != 0) {
            num5 = dataVolume.kvCacheHitTokens;
        }
        if ((i10 & 64) != 0) {
            f8 = dataVolume.kvCacheHitRate;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            num6 = dataVolume.inputSizeBytes;
        }
        if ((i10 & 256) != 0) {
            num7 = dataVolume.outputSizeBytes;
        }
        Integer num8 = num6;
        Integer num9 = num7;
        Integer num10 = num5;
        Float f9 = f8;
        Long l11 = l10;
        Integer num11 = num3;
        return dataVolume.copy(num, num2, num11, num4, l11, num10, f9, num8, num9);
    }

    public final Integer component1() {
        return this.inputTokens;
    }

    public final Integer component2() {
        return this.outputTokens;
    }

    public final Integer component3() {
        return this.imageTokens;
    }

    public final Integer component4() {
        return this.audioTokens;
    }

    public final Long component5() {
        return this.kvCacheSizeBytes;
    }

    public final Integer component6() {
        return this.kvCacheHitTokens;
    }

    public final Float component7() {
        return this.kvCacheHitRate;
    }

    public final Integer component8() {
        return this.inputSizeBytes;
    }

    public final Integer component9() {
        return this.outputSizeBytes;
    }

    public final DataVolume copy(Integer num, Integer num2, Integer num3, Integer num4, Long l10, Integer num5, Float f8, Integer num6, Integer num7) {
        return new DataVolume(num, num2, num3, num4, l10, num5, f8, num6, num7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataVolume)) {
            return false;
        }
        DataVolume dataVolume = (DataVolume) obj;
        return kotlin.jvm.internal.g.b(this.inputTokens, dataVolume.inputTokens) && kotlin.jvm.internal.g.b(this.outputTokens, dataVolume.outputTokens) && kotlin.jvm.internal.g.b(this.imageTokens, dataVolume.imageTokens) && kotlin.jvm.internal.g.b(this.audioTokens, dataVolume.audioTokens) && kotlin.jvm.internal.g.b(this.kvCacheSizeBytes, dataVolume.kvCacheSizeBytes) && kotlin.jvm.internal.g.b(this.kvCacheHitTokens, dataVolume.kvCacheHitTokens) && kotlin.jvm.internal.g.b(this.kvCacheHitRate, dataVolume.kvCacheHitRate) && kotlin.jvm.internal.g.b(this.inputSizeBytes, dataVolume.inputSizeBytes) && kotlin.jvm.internal.g.b(this.outputSizeBytes, dataVolume.outputSizeBytes);
    }

    public final Integer getAudioTokens() {
        return this.audioTokens;
    }

    public final Integer getImageTokens() {
        return this.imageTokens;
    }

    public final Integer getInputSizeBytes() {
        return this.inputSizeBytes;
    }

    public final Integer getInputTokens() {
        return this.inputTokens;
    }

    public final Float getKvCacheHitRate() {
        return this.kvCacheHitRate;
    }

    public final Integer getKvCacheHitTokens() {
        return this.kvCacheHitTokens;
    }

    public final Long getKvCacheSizeBytes() {
        return this.kvCacheSizeBytes;
    }

    public final Integer getOutputSizeBytes() {
        return this.outputSizeBytes;
    }

    public final Integer getOutputTokens() {
        return this.outputTokens;
    }

    public int hashCode() {
        Integer num = this.inputTokens;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.outputTokens;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.imageTokens;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.audioTokens;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l10 = this.kvCacheSizeBytes;
        int iHashCode5 = (iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num5 = this.kvCacheHitTokens;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Float f8 = this.kvCacheHitRate;
        int iHashCode7 = (iHashCode6 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Integer num6 = this.inputSizeBytes;
        int iHashCode8 = (iHashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.outputSizeBytes;
        return iHashCode8 + (num7 != null ? num7.hashCode() : 0);
    }

    public String toString() {
        return "DataVolume(inputTokens=" + this.inputTokens + ", outputTokens=" + this.outputTokens + ", imageTokens=" + this.imageTokens + ", audioTokens=" + this.audioTokens + ", kvCacheSizeBytes=" + this.kvCacheSizeBytes + ", kvCacheHitTokens=" + this.kvCacheHitTokens + ", kvCacheHitRate=" + this.kvCacheHitRate + ", inputSizeBytes=" + this.inputSizeBytes + ", outputSizeBytes=" + this.outputSizeBytes + ")";
    }

    public DataVolume(Integer num, Integer num2, Integer num3, Integer num4, Long l10, Integer num5, Float f8, Integer num6, Integer num7) {
        this.inputTokens = num;
        this.outputTokens = num2;
        this.imageTokens = num3;
        this.audioTokens = num4;
        this.kvCacheSizeBytes = l10;
        this.kvCacheHitTokens = num5;
        this.kvCacheHitRate = f8;
        this.inputSizeBytes = num6;
        this.outputSizeBytes = num7;
    }

    public /* synthetic */ DataVolume(Integer num, Integer num2, Integer num3, Integer num4, Long l10, Integer num5, Float f8, Integer num6, Integer num7, int i10, kotlin.jvm.internal.e eVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : num4, (i10 & 16) != 0 ? null : l10, (i10 & 32) != 0 ? null : num5, (i10 & 64) != 0 ? null : f8, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : num6, (i10 & 256) != 0 ? null : num7);
    }
}
