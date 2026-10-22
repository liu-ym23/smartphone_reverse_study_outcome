package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/format/model/CommonParams;", "Ljava/io/Serializable;", "()V", "avatarUid", "", "getAvatarUid", "()Ljava/lang/Long;", "setAvatarUid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "devicePlatform", "", "getDevicePlatform", "()Ljava/lang/String;", "setDevicePlatform", "(Ljava/lang/String;)V", "playId", "getPlayId", "setPlayId", "protocolType", "", "getProtocolType", "()I", "setProtocolType", "(I)V", "roomId", "getRoomId", "setRoomId", "roomType", "getRoomType", "setRoomType", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "setVersionCode", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonParams implements Serializable {

    @SerializedName("avatar_uid")
    private Long avatarUid;

    @SerializedName("device_platform")
    private String devicePlatform;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private String playId;

    @SerializedName("room_protocol")
    private int protocolType;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("interactive_room_mode")
    private int roomType;

    @SerializedName("version_code")
    private Long versionCode;

    public CommonParams() {
    }

    public final Long getAvatarUid() {
        return this.avatarUid;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final int getProtocolType() {
        return this.protocolType;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final int getRoomType() {
        return this.roomType;
    }

    public final Long getVersionCode() {
        return this.versionCode;
    }

    public final void setAvatarUid(Long r100) {
        this.avatarUid = r100;
    }

    public final void setDevicePlatform(String r100) {
        this.devicePlatform = r100;
    }

    public final void setPlayId(String r100) {
        this.playId = r100;
    }

    public final void setProtocolType(int r100) {
        this.protocolType = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setRoomType(int r100) {
        this.roomType = r100;
    }

    public final void setVersionCode(Long r100) {
        this.versionCode = r100;
    }
}
