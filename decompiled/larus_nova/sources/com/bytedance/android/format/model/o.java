package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/format/model/o;", "", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "enterFrom", "getEnterFrom", "enterMethod", "getEnterMethod", "roomId", "getRoomId", "awemeAvatarInfo", "getAwemeAvatarInfo", "", "interactiveRoomMode", "I", "getInteractiveRoomMode", "()I", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("aweme_avatar_info")
    private final String awemeAvatarInfo;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("interactive_room_mode")
    private final int interactiveRoomMode;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("room_id")
    private final String roomId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L18;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.awemeAvatarInfo, r101.awemeAvatarInfo) == true) goto L16;
        return false;
    L16:
        if (this.interactiveRoomMode == r101.interactiveRoomMode) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.playId;
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
        String r110 = this.roomId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.awemeAvatarInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.interactiveRoomMode;
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
        return "CheckAvatarResourceEnableRequest(playId=" + this.playId + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", roomId=" + this.roomId + ", awemeAvatarInfo=" + this.awemeAvatarInfo + ", interactiveRoomMode=" + this.interactiveRoomMode + ")";
    }
}
