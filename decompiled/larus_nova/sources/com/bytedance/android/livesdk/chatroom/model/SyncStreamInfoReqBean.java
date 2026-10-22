package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/SyncStreamInfoReqBean;", "", "roomId", "", "live_id", "", "process_at_sei_time_ms", "info_list", "", "Lcom/bytedance/android/livesdk/chatroom/model/SyncStreamInfo;", "(JIJLjava/util/List;)V", "getInfo_list", "()Ljava/util/List;", "getLive_id", "()I", "getProcess_at_sei_time_ms", "()J", "getRoomId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SyncStreamInfoReqBean {

    @SerializedName("info_list")
    private final List<SyncStreamInfo> info_list;

    @SerializedName("live_id")
    private final int live_id;

    @SerializedName("process_at_sei_time_ms")
    private final long process_at_sei_time_ms;

    @SerializedName("room_id")
    private final long roomId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncStreamInfoReqBean copy$default(SyncStreamInfoReqBean r100, long r101, int r110, long r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.roomId;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.live_id;
    L8:
        int r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.process_at_sei_time_ms;
    L11:
        long r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.info_list;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.roomId;
    }

    public final int component2() {
        return this.live_id;
    }

    public final long component3() {
        return this.process_at_sei_time_ms;
    }

    public final List<SyncStreamInfo> component4() {
        return this.info_list;
    }

    public final SyncStreamInfoReqBean copy(long r100, int r110, long r111, List<SyncStreamInfo> r112) {
        Intrinsics.checkNotNullParameter(r112, "info_list");
        return new SyncStreamInfoReqBean(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SyncStreamInfoReqBean) == false) goto L14;
        SyncStreamInfoReqBean r101 = (SyncStreamInfoReqBean) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (this.live_id == r101.live_id) goto L10;
        return false;
    L10:
        if (this.process_at_sei_time_ms == r101.process_at_sei_time_ms) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.info_list, r101.info_list) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.live_id) * 31;
        long r102 = this.process_at_sei_time_ms;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        List<SyncStreamInfo> r104 = this.info_list;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public String toString() {
        return "SyncStreamInfoReqBean(roomId=" + this.roomId + ", live_id=" + this.live_id + ", process_at_sei_time_ms=" + this.process_at_sei_time_ms + ", info_list=" + this.info_list + ")";
    }

    public final List<SyncStreamInfo> getInfo_list() {
        return this.info_list;
    }

    public final int getLive_id() {
        return this.live_id;
    }

    public final long getProcess_at_sei_time_ms() {
        return this.process_at_sei_time_ms;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public SyncStreamInfoReqBean(long r100, int r101, long r102, List<SyncStreamInfo> r103) {
        Intrinsics.checkNotNullParameter(r103, "info_list");
        this.roomId = r100;
        this.live_id = r101;
        this.process_at_sei_time_ms = r102;
        this.info_list = r103;
    }
}
