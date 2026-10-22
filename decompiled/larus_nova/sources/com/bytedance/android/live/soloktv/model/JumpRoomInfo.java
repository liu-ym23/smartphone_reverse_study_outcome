package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/JumpRoomInfo;", "", "roomId", "", "songId", "tabName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRoomId", "()Ljava/lang/String;", "getSongId", "getTabName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JumpRoomInfo {

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("song_id")
    private final String songId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private final String tabName;

    public JumpRoomInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ JumpRoomInfo copy$default(JumpRoomInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.songId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tabName;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.songId;
    }

    public final String component3() {
        return this.tabName;
    }

    public final JumpRoomInfo copy(String r100, String r101, String r102) {
        return new JumpRoomInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JumpRoomInfo) == false) goto L12;
        JumpRoomInfo r101 = (JumpRoomInfo) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.songId, r101.songId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.songId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tabName;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "JumpRoomInfo(roomId=" + this.roomId + ", songId=" + this.songId + ", tabName=" + this.tabName + ")";
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSongId() {
        return this.songId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public JumpRoomInfo(String r100, String r101, String r102) {
        this.roomId = r100;
        this.songId = r101;
        this.tabName = r102;
    }

    public /* synthetic */ JumpRoomInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
