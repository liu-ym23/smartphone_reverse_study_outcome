package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/android/format/model/g0;", "", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "enterFrom", "getEnterFrom", "enterMethod", "getEnterMethod", "itemId", "getItemId", "avatarInfo", "getAvatarInfo", "", "enterScene", "I", "getEnterScene", "()I", "Lcom/bytedance/android/format/model/p;", "clientAbParam", "Lcom/bytedance/android/format/model/p;", "getClientAbParam", "()Lcom/bytedance/android/format/model/p;", "roomId", "getRoomId", "protocolType", "getProtocolType", "taskType", "getTaskType", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("aweme_avatar_info")
    private final String avatarInfo;

    @SerializedName("client_ab_param")
    private final p clientAbParam;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("enter_scene")
    private final int enterScene;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("aweme_item_id")
    private final String itemId;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("room_protocol_type")
    private final int protocolType;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final int taskType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L28;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.avatarInfo, r101.avatarInfo) == true) goto L16;
        return false;
    L16:
        if (this.enterScene == r101.enterScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clientAbParam, r101.clientAbParam) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L22;
        return false;
    L22:
        if (this.protocolType == r101.protocolType) goto L24;
        return false;
    L24:
        if (this.taskType == r101.taskType) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
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
        String r110 = this.itemId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.avatarInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.enterScene) * 31;
        p r116 = this.clientAbParam;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.roomId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((((r118 + r120) * 31) + this.protocolType) * 31) + this.taskType) * 31;
        Map<String, String> r122 = this.extra;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
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
        return "GetFormatLivePlayInfoRequest(playId=" + this.playId + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", itemId=" + this.itemId + ", avatarInfo=" + this.avatarInfo + ", enterScene=" + this.enterScene + ", clientAbParam=" + this.clientAbParam + ", roomId=" + this.roomId + ", protocolType=" + this.protocolType + ", taskType=" + this.taskType + ", extra=" + this.extra + ")";
    }
}
