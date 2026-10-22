package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "", "", "gameId", "Ljava/lang/String;", "gameName", "gameIcon", "gameType", DBDefinition.TASK_ID, "taskName", "", "taskStatus", "Ljava/lang/Integer;", "schema", "", "hasTask", "Ljava/lang/Boolean;", "taskChange", "originTaskId", "taskPrice", "bidMetaTag", "cpsRatio", "bidType", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f59336b;

    @SerializedName("bid_meta_tag")
    public String bidMetaTag;

    @SerializedName("bid_type")
    public Integer bidType;

    @SerializedName("cps_ratio")
    public Integer cpsRatio;

    @SerializedName("game_icon")
    public String gameIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    public String gameType;

    @SerializedName("is_has_task")
    public Boolean hasTask;

    @SerializedName("origin_task_id")
    public String originTaskId;

    @SerializedName("schema")
    public String schema;

    @SerializedName("is_change_task")
    public Boolean taskChange;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName("task_name")
    public String taskName;

    @SerializedName("task_price")
    public Integer taskPrice;

    @SerializedName("task_status")
    public Integer taskStatus;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L36;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameIcon, r101.gameIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gameType, r101.gameType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.taskName, r101.taskName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskStatus, r101.taskStatus) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.hasTask, r101.hasTask) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskChange, r101.taskChange) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.originTaskId, r101.originTaskId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.taskPrice, r101.taskPrice) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bidMetaTag, r101.bidMetaTag) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.cpsRatio, r101.cpsRatio) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.bidType, r101.bidType) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        String r100 = this.gameId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.gameName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.gameIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.gameType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.taskId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.taskName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.taskStatus;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.schema;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.hasTask;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.taskChange;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.originTaskId;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.taskPrice;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.bidMetaTag;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.cpsRatio;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.bidType;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
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
        return "MicroGameInfo(gameId=" + this.gameId + ", gameName=" + this.gameName + ", gameIcon=" + this.gameIcon + ", gameType=" + this.gameType + ", taskId=" + this.taskId + ", taskName=" + this.taskName + ", taskStatus=" + this.taskStatus + ", schema=" + this.schema + ", hasTask=" + this.hasTask + ", taskChange=" + this.taskChange + ", originTaskId=" + this.originTaskId + ", taskPrice=" + this.taskPrice + ", bidMetaTag=" + this.bidMetaTag + ", cpsRatio=" + this.cpsRatio + ", bidType=" + this.bidType + ")";
    }

    public c0(int r100) {
        Boolean r101 = Boolean.TRUE;
        Boolean r102 = Boolean.FALSE;
        this.gameId = "";
        this.gameName = "";
        this.gameIcon = "";
        this.gameType = "";
        this.taskId = "";
        this.taskName = "";
        this.taskStatus = -1;
        this.schema = null;
        this.hasTask = r101;
        this.taskChange = r102;
        this.originTaskId = "";
        this.taskPrice = 1;
        this.bidMetaTag = "";
        this.cpsRatio = 0;
        this.bidType = null;
        this.f59335a = "";
    }
}
