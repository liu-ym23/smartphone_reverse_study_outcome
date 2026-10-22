package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VolumeDetectConfig;", "", "firstCountDownDurationMinutes", "", "detectIntervalSeconds", "volumeThreshold", "countThreshold", "pausePromptDurationMinutes", "(IIIII)V", "getCountThreshold", "()I", "getDetectIntervalSeconds", "getFirstCountDownDurationMinutes", "getPausePromptDurationMinutes", "getVolumeThreshold", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VolumeDetectConfig {

    @SerializedName("count_threshold")
    private final int countThreshold;

    @SerializedName("detect_interval_seconds")
    private final int detectIntervalSeconds;

    @SerializedName("first_count_down_duration_minutes")
    private final int firstCountDownDurationMinutes;

    @SerializedName("pause_prompt_duration_minutes")
    private final int pausePromptDurationMinutes;

    @SerializedName("volume_threshold")
    private final int volumeThreshold;

    public VolumeDetectConfig() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ VolumeDetectConfig copy$default(VolumeDetectConfig r100, int r101, int r102, int r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.firstCountDownDurationMinutes;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.detectIntervalSeconds;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.volumeThreshold;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.countThreshold;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.pausePromptDurationMinutes;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.firstCountDownDurationMinutes;
    }

    public final int component2() {
        return this.detectIntervalSeconds;
    }

    public final int component3() {
        return this.volumeThreshold;
    }

    public final int component4() {
        return this.countThreshold;
    }

    public final int component5() {
        return this.pausePromptDurationMinutes;
    }

    public final VolumeDetectConfig copy(int r100, int r101, int r110, int r111, int r112) {
        return new VolumeDetectConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VolumeDetectConfig) == false) goto L16;
        VolumeDetectConfig r101 = (VolumeDetectConfig) r100;
        if (this.firstCountDownDurationMinutes == r101.firstCountDownDurationMinutes) goto L8;
        return false;
    L8:
        if (this.detectIntervalSeconds == r101.detectIntervalSeconds) goto L10;
        return false;
    L10:
        if (this.volumeThreshold == r101.volumeThreshold) goto L12;
        return false;
    L12:
        if (this.countThreshold == r101.countThreshold) goto L14;
        return false;
    L14:
        if (this.pausePromptDurationMinutes == r101.pausePromptDurationMinutes) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return (((((((this.firstCountDownDurationMinutes * 31) + this.detectIntervalSeconds) * 31) + this.volumeThreshold) * 31) + this.countThreshold) * 31) + this.pausePromptDurationMinutes;
    }

    public String toString() {
        return "VolumeDetectConfig(firstCountDownDurationMinutes=" + this.firstCountDownDurationMinutes + ", detectIntervalSeconds=" + this.detectIntervalSeconds + ", volumeThreshold=" + this.volumeThreshold + ", countThreshold=" + this.countThreshold + ", pausePromptDurationMinutes=" + this.pausePromptDurationMinutes + ")";
    }

    public final int getCountThreshold() {
        return this.countThreshold;
    }

    public final int getDetectIntervalSeconds() {
        return this.detectIntervalSeconds;
    }

    public final int getFirstCountDownDurationMinutes() {
        return this.firstCountDownDurationMinutes;
    }

    public final int getPausePromptDurationMinutes() {
        return this.pausePromptDurationMinutes;
    }

    public final int getVolumeThreshold() {
        return this.volumeThreshold;
    }

    public VolumeDetectConfig(int r100, int r101, int r102, int r103, int r104) {
        this.firstCountDownDurationMinutes = r100;
        this.detectIntervalSeconds = r101;
        this.volumeThreshold = r102;
        this.countThreshold = r103;
        this.pausePromptDurationMinutes = r104;
    }

    public /* synthetic */ VolumeDetectConfig(int r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = 3;
    L6:
        if ((r105 & 2) == 0) goto L8;
        int r111 = 30;
    L10:
        if ((r105 & 4) == 0) goto L12;
        int r106 = 2;
    L14:
        if ((r105 & 8) == 0) goto L16;
        int r107 = 5;
    L18:
        if ((r105 & 16) == 0) goto L20;
        int r108 = 1440;
    L21:
        this(r100, r111, r106, r107, r108);
        return;
    L20:
        r108 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
