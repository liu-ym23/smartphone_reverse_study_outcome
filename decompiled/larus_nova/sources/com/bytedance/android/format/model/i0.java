package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/format/model/i0;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "enterFrom", "getEnterFrom", "enterMethod", "getEnterMethod", "playId", "getPlayId", "", "taskType", "I", "getTaskType", "()I", "roomProtocolType", "getRoomProtocolType", "avatarInfo", "getAvatarInfo", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("aweme_avatar_info")
    private final String avatarInfo;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_protocol_type")
    private final int roomProtocolType;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final int taskType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L20;
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L14;
        return false;
    L14:
        if (this.taskType == r101.taskType) goto L16;
        return false;
    L16:
        if (this.roomProtocolType == r101.roomProtocolType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarInfo, r101.avatarInfo) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterFrom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterMethod;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.playId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((((r109 + r111) * 31) + this.taskType) * 31) + this.roomProtocolType) * 31;
        String r113 = this.avatarInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "GetLiveRoomDataRequest(roomId=" + this.roomId + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", playId=" + this.playId + ", taskType=" + this.taskType + ", roomProtocolType=" + this.roomProtocolType + ", avatarInfo=" + this.avatarInfo + ")";
    }
}
