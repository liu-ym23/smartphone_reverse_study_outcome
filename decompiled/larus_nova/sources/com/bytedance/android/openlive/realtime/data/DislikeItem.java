package com.bytedance.android.openlive.realtime.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/openlive/realtime/data/DislikeItem;", "", "roomId", "", "timestamp", "source", "", "(JJLjava/lang/String;)V", "getRoomId", "()J", "setRoomId", "(J)V", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DislikeItem {

    @SerializedName("r_i")
    private long roomId;

    @SerializedName("s")
    private String source;

    @SerializedName("t")
    private long timestamp;

    public DislikeItem() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ DislikeItem copy$default(DislikeItem r100, long r101, long r102, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.roomId;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.timestamp;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.source;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.roomId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.source;
    }

    public final DislikeItem copy(long r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "source");
        return new DislikeItem(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DislikeItem) == false) goto L12;
        DislikeItem r101 = (DislikeItem) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (this.timestamp == r101.timestamp) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.timestamp;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.source;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public String toString() {
        return "DislikeItem(roomId=" + this.roomId + ", timestamp=" + this.timestamp + ", source=" + this.source + ")";
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getSource() {
        return this.source;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.source = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public DislikeItem(long r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        this.roomId = r100;
        this.timestamp = r101;
        this.source = r102;
    }

    public /* synthetic */ DislikeItem(long r100, long r101, String r102, int r110, DefaultConstructorMarker r111) {
        long r103 = 0;
        if ((r110 & 1) == 0) goto L5;
        long r104 = 0;
    L7:
        if ((r110 & 2) != 0) goto L11;
        r103 = r101;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = "";
    L13:
        this(r104, r103, r102);
        return;
    L5:
        r104 = r100;
        goto L7
    }
}
