package com.bytedance.android.livesdkapi.banner;

import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/banner/BannerData;", "", "logId", "", "roomId", "", "data", "Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;", "position", "", "(Ljava/lang/String;JLcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;I)V", "getData", "()Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;", "getLogId", "()Ljava/lang/String;", "getPosition", "()I", "getRoomId", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerData {
    private final BannerInRoomCollection data;
    private final String logId;
    private final int position;
    private final long roomId;

    public static /* synthetic */ BannerData copy$default(BannerData r100, String r101, long r102, BannerInRoomCollection r103, int r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.logId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.roomId;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.data;
    L11:
        BannerInRoomCollection r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.position;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.logId;
    }

    public final long component2() {
        return this.roomId;
    }

    public final BannerInRoomCollection component3() {
        return this.data;
    }

    public final int component4() {
        return this.position;
    }

    public final BannerData copy(String r100, long r101, BannerInRoomCollection r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        return new BannerData(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BannerData) == false) goto L14;
        BannerData r101 = (BannerData) r100;
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L8;
        return false;
    L8:
        if (this.roomId == r101.roomId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.position == r101.position) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.logId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.roomId;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        BannerInRoomCollection r105 = this.data;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return ((r104 + r101) * 31) + this.position;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BannerData(logId=" + this.logId + ", roomId=" + this.roomId + ", data=" + this.data + ", position=" + this.position + ")";
    }

    public final BannerInRoomCollection getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public BannerData(String r100, long r101, BannerInRoomCollection r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "data");
        this.logId = r100;
        this.roomId = r101;
        this.data = r102;
        this.position = r103;
    }

    public /* synthetic */ BannerData(String r100, long r101, BannerInRoomCollection r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101, r110, r111);
    }
}
