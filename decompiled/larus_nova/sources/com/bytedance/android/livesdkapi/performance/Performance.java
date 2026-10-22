package com.bytedance.android.livesdkapi.performance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/Performance;", "", "roomId", "", "stallUiSeriousRate", "", "stallUiModerateRate", "stallUiSlightRate", "fps", "stallVideoRate", "(Ljava/lang/String;FFFFF)V", "getFps", "()F", "getRoomId", "()Ljava/lang/String;", "getStallUiModerateRate", "getStallUiSeriousRate", "getStallUiSlightRate", "getStallVideoRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Performance {
    private final float fps;
    private final String roomId;
    private final float stallUiModerateRate;
    private final float stallUiSeriousRate;
    private final float stallUiSlightRate;
    private final float stallVideoRate;

    public static /* synthetic */ Performance copy$default(Performance r100, String r101, float r102, float r103, float r104, float r105, float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.stallUiSeriousRate;
    L8:
        float r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.stallUiModerateRate;
    L11:
        float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.stallUiSlightRate;
    L14:
        float r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.fps;
    L17:
        float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.stallVideoRate;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.roomId;
    }

    public final float component2() {
        return this.stallUiSeriousRate;
    }

    public final float component3() {
        return this.stallUiModerateRate;
    }

    public final float component4() {
        return this.stallUiSlightRate;
    }

    public final float component5() {
        return this.fps;
    }

    public final float component6() {
        return this.stallVideoRate;
    }

    public final Performance copy(String r100, float r110, float r111, float r112, float r113, float r114) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        return new Performance(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Performance) == false) goto L18;
        Performance r101 = (Performance) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.stallUiSeriousRate, r101.stallUiSeriousRate) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.stallUiModerateRate, r101.stallUiModerateRate) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.stallUiSlightRate, r101.stallUiSlightRate) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.fps, r101.fps) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.stallVideoRate, r101.stallVideoRate) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.roomId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((((r101 * 31) + Float.floatToIntBits(this.stallUiSeriousRate)) * 31) + Float.floatToIntBits(this.stallUiModerateRate)) * 31) + Float.floatToIntBits(this.stallUiSlightRate)) * 31) + Float.floatToIntBits(this.fps)) * 31) + Float.floatToIntBits(this.stallVideoRate);
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "Performance(roomId=" + this.roomId + ", stallUiSeriousRate=" + this.stallUiSeriousRate + ", stallUiModerateRate=" + this.stallUiModerateRate + ", stallUiSlightRate=" + this.stallUiSlightRate + ", fps=" + this.fps + ", stallVideoRate=" + this.stallVideoRate + ")";
    }

    public final float getFps() {
        return this.fps;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final float getStallUiModerateRate() {
        return this.stallUiModerateRate;
    }

    public final float getStallUiSeriousRate() {
        return this.stallUiSeriousRate;
    }

    public final float getStallUiSlightRate() {
        return this.stallUiSlightRate;
    }

    public final float getStallVideoRate() {
        return this.stallVideoRate;
    }

    public Performance(String r100, float r101, float r102, float r103, float r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.roomId = r100;
        this.stallUiSeriousRate = r101;
        this.stallUiModerateRate = r102;
        this.stallUiSlightRate = r103;
        this.fps = r104;
        this.stallVideoRate = r105;
    }
}
