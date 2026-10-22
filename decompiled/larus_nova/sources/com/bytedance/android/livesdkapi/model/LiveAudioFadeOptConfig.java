package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\bHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveAudioFadeOptConfig;", "", "enable", "", "minInVolume", "", "maxInVolume", "duration", "", "useCurVolume", "interpolator", "", "(ZFFIZLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveAudioFadeOptConfig {

    @SerializedName("duration")
    public final int duration;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("interpolator")
    public final String interpolator;

    @SerializedName("max_in_volume")
    public final float maxInVolume;

    @SerializedName("min_in_volume")
    public final float minInVolume;

    @SerializedName("use_current_volume")
    public final boolean useCurVolume;

    public LiveAudioFadeOptConfig() {
        this(false, 0.0f, 0.0f, 0, false, null, 63, null);
    }

    public static /* synthetic */ LiveAudioFadeOptConfig copy$default(LiveAudioFadeOptConfig r100, boolean r101, float r102, float r103, int r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.minInVolume;
    L8:
        float r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.maxInVolume;
    L11:
        float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.duration;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.useCurVolume;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.interpolator;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final float component2() {
        return this.minInVolume;
    }

    public final float component3() {
        return this.maxInVolume;
    }

    public final int component4() {
        return this.duration;
    }

    public final boolean component5() {
        return this.useCurVolume;
    }

    public final String component6() {
        return this.interpolator;
    }

    public final LiveAudioFadeOptConfig copy(boolean r100, float r110, float r111, int r112, boolean r113, String r114) {
        return new LiveAudioFadeOptConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveAudioFadeOptConfig) == false) goto L18;
        LiveAudioFadeOptConfig r101 = (LiveAudioFadeOptConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Float.compare(this.minInVolume, r101.minInVolume) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.maxInVolume, r101.maxInVolume) == 0) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L14;
        return false;
    L14:
        if (this.useCurVolume == r101.useCurVolume) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.interpolator, r101.interpolator) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((((((r102 * 31) + Float.floatToIntBits(this.minInVolume)) * 31) + Float.floatToIntBits(this.maxInVolume)) * 31) + this.duration) * 31;
        boolean r104 = this.useCurVolume;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.interpolator;
        if (r106 == null) goto L12;
        int r107 = r106.hashCode();
    L14:
        return r105 + r107;
    L12:
        r107 = 0;
        goto L14
    }

    public String toString() {
        return "LiveAudioFadeOptConfig(enable=" + this.enable + ", minInVolume=" + this.minInVolume + ", maxInVolume=" + this.maxInVolume + ", duration=" + this.duration + ", useCurVolume=" + this.useCurVolume + ", interpolator=" + this.interpolator + ")";
    }

    public LiveAudioFadeOptConfig(boolean r100, float r101, float r102, int r103, boolean r104, String r105) {
        this.enable = r100;
        this.minInVolume = r101;
        this.maxInVolume = r102;
        this.duration = r103;
        this.useCurVolume = r104;
        this.interpolator = r105;
    }

    public /* synthetic */ LiveAudioFadeOptConfig(boolean r100, float r101, float r102, int r103, boolean r104, String r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = false;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        float r106 = 0.0f;
    L11:
        if ((r111 & 4) == 0) goto L13;
        float r107 = 1.0f;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r108 = 400;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = "default";
    L25:
        String r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
