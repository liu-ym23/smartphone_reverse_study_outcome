package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/JumpRealTimeChorusRoomParams;", "", "jumpScene", "", "jumpRooms", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getJumpRooms", "()Ljava/lang/String;", "getJumpScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/live/soloktv/model/JumpRealTimeChorusRoomParams;", "equals", "", "other", "hashCode", "toString", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JumpRealTimeChorusRoomParams {

    @SerializedName("jump_rooms")
    private final String jumpRooms;

    @SerializedName("jump_scene")
    private final Integer jumpScene;

    /* JADX WARN: Multi-variable type inference failed */
    public JumpRealTimeChorusRoomParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ JumpRealTimeChorusRoomParams copy$default(JumpRealTimeChorusRoomParams r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.jumpScene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.jumpRooms;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.jumpScene;
    }

    public final String component2() {
        return this.jumpRooms;
    }

    public final JumpRealTimeChorusRoomParams copy(Integer r100, String r101) {
        return new JumpRealTimeChorusRoomParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JumpRealTimeChorusRoomParams) == false) goto L10;
        JumpRealTimeChorusRoomParams r101 = (JumpRealTimeChorusRoomParams) r100;
        if (Intrinsics.areEqual(this.jumpScene, r101.jumpScene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpRooms, r101.jumpRooms) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.jumpScene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpRooms;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "JumpRealTimeChorusRoomParams(jumpScene=" + this.jumpScene + ", jumpRooms=" + this.jumpRooms + ")";
    }

    public final String getJumpRooms() {
        return this.jumpRooms;
    }

    public final Integer getJumpScene() {
        return this.jumpScene;
    }

    public JumpRealTimeChorusRoomParams(Integer r100, String r101) {
        this.jumpScene = r100;
        this.jumpRooms = r101;
    }

    public /* synthetic */ JumpRealTimeChorusRoomParams(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Integer.valueOf(JumpScene.Unknown.getValue());
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
