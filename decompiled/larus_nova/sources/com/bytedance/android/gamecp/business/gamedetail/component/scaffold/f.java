package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/scaffold/f;", "", "", "videoSwitch", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "playerDirection", "c", "", "isActive", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "", "reserveStatus", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "mapId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mapName", "b", "", "relatedGames", "Ljava/util/List;", "d", "()Ljava/util/List;", "userPlayingCount", "f", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("is_active")
    private final Boolean isActive;

    @SerializedName("map_id")
    private final String mapId;

    @SerializedName("map_name")
    private final String mapName;

    @SerializedName("player_direction")
    private final String playerDirection;

    @SerializedName("related_game_id")
    private final List<String> relatedGames;

    @SerializedName("reserved_status")
    private final Long reserveStatus;

    @SerializedName("user_playing_count")
    private final Long userPlayingCount;

    @SerializedName("video_switch")
    private final String videoSwitch;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L22;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.videoSwitch, r101.videoSwitch) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.playerDirection, r101.playerDirection) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isActive, r101.isActive) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reserveStatus, r101.reserveStatus) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mapId, r101.mapId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mapName, r101.mapName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.relatedGames, r101.relatedGames) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.userPlayingCount, r101.userPlayingCount) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.videoSwitch;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.playerDirection;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isActive;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.reserveStatus;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mapId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mapName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.relatedGames;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.userPlayingCount;
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
        return "ScaffoldData(videoSwitch=" + this.videoSwitch + ", playerDirection=" + this.playerDirection + ", isActive=" + this.isActive + ", reserveStatus=" + this.reserveStatus + ", mapId=" + this.mapId + ", mapName=" + this.mapName + ", relatedGames=" + this.relatedGames + ", userPlayingCount=" + this.userPlayingCount + ")";
    }

    public f() {
        this.videoSwitch = null;
        this.playerDirection = null;
        this.isActive = null;
        this.reserveStatus = null;
        this.mapId = "";
        this.mapName = "";
        this.relatedGames = null;
        this.userPlayingCount = null;
    }

    public final String a() {
        return this.mapId;
    }

    public final String b() {
        return this.mapName;
    }

    public final String c() {
        return this.playerDirection;
    }

    public final List<String> d() {
        return this.relatedGames;
    }

    public final Long e() {
        return this.reserveStatus;
    }

    public final Long f() {
        return this.userPlayingCount;
    }

    public final String g() {
        return this.videoSwitch;
    }

    public final Boolean h() {
        return this.isActive;
    }
}
