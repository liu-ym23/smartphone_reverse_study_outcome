package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/g0;", "", "", "appointmentId", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "anchorId", "getAnchorId", "roomId", "getRoomId", DyPayConstant.KEY_START_TIME, "getStartTime", "endTime", "getEndTime", "", "isReserved", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("anchor_id")
    private final Long anchorId;

    @SerializedName("appointment_id")
    private final Long appointmentId;

    @SerializedName("content")
    private final String content;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("is_reserved")
    private Boolean isReserved;

    @SerializedName("room_id")
    private final Long roomId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L20;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.appointmentId, r101.appointmentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isReserved, r101.isReserved) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.appointmentId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.anchorId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.roomId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.startTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.endTime;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isReserved;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.content;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EndingPageReservation(appointmentId=" + this.appointmentId + ", anchorId=" + this.anchorId + ", roomId=" + this.roomId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", isReserved=" + this.isReserved + ", content=" + this.content + ")";
    }

    public g0() {
        Boolean r100 = Boolean.FALSE;
        this.appointmentId = 0L;
        this.anchorId = 0L;
        this.roomId = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.isReserved = r100;
        this.content = "";
    }

    public final Long a() {
        return this.appointmentId;
    }

    public final String b() {
        return this.content;
    }

    public final Boolean c() {
        return this.isReserved;
    }

    public final void d(Boolean r100) {
        this.isReserved = r100;
    }
}
