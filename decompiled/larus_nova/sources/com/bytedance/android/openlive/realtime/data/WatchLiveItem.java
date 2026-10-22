package com.bytedance.android.openlive.realtime.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/openlive/realtime/data/WatchLiveItem;", "", "roomId", "", "timestamp", DyPayConstant.KEY_START_TIME, "duration", "source", "", "(JJJJLjava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getRoomId", "setRoomId", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getStartTime", "setStartTime", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class WatchLiveItem {

    @SerializedName("d")
    private long duration;

    @SerializedName("r_i")
    private long roomId;

    @SerializedName("s")
    private String source;

    @SerializedName("s_t")
    private long startTime;

    @SerializedName("t")
    private long timestamp;

    public WatchLiveItem() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ WatchLiveItem copy$default(WatchLiveItem r110, long r111, long r112, long r113, long r114, String r115, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.roomId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.timestamp;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.startTime;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.duration;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.source;
    L23:
        return r110.copy(r100, r101, r102, r103, r104);
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.roomId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final long component3() {
        return this.startTime;
    }

    public final long component4() {
        return this.duration;
    }

    public final String component5() {
        return this.source;
    }

    public final WatchLiveItem copy(long r110, long r111, long r112, long r113, String r210) {
        Intrinsics.checkNotNullParameter(r210, "source");
        return new WatchLiveItem(r110, r111, r112, r113, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WatchLiveItem) == false) goto L16;
        WatchLiveItem r101 = (WatchLiveItem) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (this.timestamp == r101.timestamp) goto L10;
        return false;
    L10:
        if (this.startTime == r101.startTime) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.timestamp;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.startTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.duration;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.source;
        if (r108 == null) goto L5;
        int r109 = r108.hashCode();
    L7:
        return r107 + r109;
    L5:
        r109 = 0;
        goto L7
    }

    public String toString() {
        return "WatchLiveItem(roomId=" + this.roomId + ", timestamp=" + this.timestamp + ", startTime=" + this.startTime + ", duration=" + this.duration + ", source=" + this.source + ")";
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getSource() {
        return this.source;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.source = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public WatchLiveItem(long r100, long r101, long r102, long r103, String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        this.roomId = r100;
        this.timestamp = r101;
        this.startTime = r102;
        this.duration = r103;
        this.source = r110;
    }

    public /* synthetic */ WatchLiveItem(long r110, long r111, long r112, long r113, String r114, int r115, DefaultConstructorMarker r210) {
        long r100 = 0;
        if ((r115 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r115 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r115 & 8) != 0) goto L19;
        r100 = r113;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r104 = "";
    L22:
        this(r101, r102, r103, r100, r104);
        return;
    L21:
        r104 = r114;
        goto L22
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
