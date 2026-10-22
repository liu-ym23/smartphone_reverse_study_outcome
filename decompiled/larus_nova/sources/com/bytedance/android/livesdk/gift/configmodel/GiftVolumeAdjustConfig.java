package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftVolumeAdjustConfig;", "", "minDB", "", "maxDB", "leftDB", "rightDB", "minVolume", "", "maxVolume", "(IIIIFF)V", "getLeftDB", "()I", "getMaxDB", "getMaxVolume", "()F", "getMinDB", "getMinVolume", "getRightDB", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftVolumeAdjustConfig {

    @SerializedName("default_volume_range_left_dB")
    private final int leftDB;

    @SerializedName("max_dB")
    private final int maxDB;

    @SerializedName("max_volume")
    private final float maxVolume;

    @SerializedName("min_dB")
    private final int minDB;

    @SerializedName("min_volume")
    private final float minVolume;

    @SerializedName("default_volume_range_right_dB")
    private final int rightDB;

    public GiftVolumeAdjustConfig() {
        this(0, 0, 0, 0, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ GiftVolumeAdjustConfig copy$default(GiftVolumeAdjustConfig r100, int r101, int r102, int r103, int r104, float r105, float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.minDB;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.maxDB;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.leftDB;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.rightDB;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.minVolume;
    L17:
        float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.maxVolume;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.minDB;
    }

    public final int component2() {
        return this.maxDB;
    }

    public final int component3() {
        return this.leftDB;
    }

    public final int component4() {
        return this.rightDB;
    }

    public final float component5() {
        return this.minVolume;
    }

    public final float component6() {
        return this.maxVolume;
    }

    public final GiftVolumeAdjustConfig copy(int r100, int r110, int r111, int r112, float r113, float r114) {
        return new GiftVolumeAdjustConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GiftVolumeAdjustConfig) == false) goto L18;
        GiftVolumeAdjustConfig r101 = (GiftVolumeAdjustConfig) r100;
        if (this.minDB == r101.minDB) goto L8;
        return false;
    L8:
        if (this.maxDB == r101.maxDB) goto L10;
        return false;
    L10:
        if (this.leftDB == r101.leftDB) goto L12;
        return false;
    L12:
        if (this.rightDB == r101.rightDB) goto L14;
        return false;
    L14:
        if (Float.compare(this.minVolume, r101.minVolume) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.maxVolume, r101.maxVolume) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((((((((this.minDB * 31) + this.maxDB) * 31) + this.leftDB) * 31) + this.rightDB) * 31) + Float.floatToIntBits(this.minVolume)) * 31) + Float.floatToIntBits(this.maxVolume);
    }

    public String toString() {
        return "GiftVolumeAdjustConfig(minDB=" + this.minDB + ", maxDB=" + this.maxDB + ", leftDB=" + this.leftDB + ", rightDB=" + this.rightDB + ", minVolume=" + this.minVolume + ", maxVolume=" + this.maxVolume + ")";
    }

    public final int getLeftDB() {
        return this.leftDB;
    }

    public final int getMaxDB() {
        return this.maxDB;
    }

    public final float getMaxVolume() {
        return this.maxVolume;
    }

    public final int getMinDB() {
        return this.minDB;
    }

    public final float getMinVolume() {
        return this.minVolume;
    }

    public final int getRightDB() {
        return this.rightDB;
    }

    public GiftVolumeAdjustConfig(int r100, int r101, int r102, int r103, float r104, float r105) {
        this.minDB = r100;
        this.maxDB = r101;
        this.leftDB = r102;
        this.rightDB = r103;
        this.minVolume = r104;
        this.maxVolume = r105;
    }

    public /* synthetic */ GiftVolumeAdjustConfig(int r100, int r101, int r102, int r103, float r104, float r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = -40;
    L6:
        if ((r111 & 2) == 0) goto L8;
        int r113 = -8;
    L10:
        if ((r111 & 4) == 0) goto L12;
        int r105 = -25;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r106 = -20;
    L18:
        if ((r111 & 16) == 0) goto L20;
        float r107 = 0.5f;
    L22:
        if ((r111 & 32) == 0) goto L24;
        float r108 = 2.0f;
    L25:
        this(r100, r113, r105, r106, r107, r108);
        return;
    L24:
        r108 = r110;
        goto L25
    L20:
        r107 = r104;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
