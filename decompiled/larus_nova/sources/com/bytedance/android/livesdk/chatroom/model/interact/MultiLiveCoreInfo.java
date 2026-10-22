package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MultiLiveCoreInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.u1> implements com.bytedance.android.livesdk.link.model.bridge.u1 {

    @SerializedName("ktv_live_core_info")
    public KTVLiveCoreInfo ktvLiveCoreInfo;

    @SerializedName("multi_anchor_linkmic_live_core_info")
    public MultiAnchorLinkmicLiveCoreInfo multiAnchorLiveCoreInfo;

    @SerializedName("scene")
    public int scene;

    @SerializedName("singing_challenge_live_core_info")
    public SingingChallengeLiveCoreInfo singingChallengeLiveCoreInfo;

    @SerializedName("video_duo_battle_live_core_info")
    public VideoDuoBattleLiveCoreInfo videoDuoBattleLiveCoreInfo;

    @SerializedName("video_equal_room_live_core_info")
    public VideoEqualRoomLiveCoreInfo videoEqualRoomLiveCoreInfo;

    @SerializedName("video_position_live_core_info")
    public VideoPositionLiveCoreInfo videoPositionLiveCoreInfo;

    public MultiLiveCoreInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.u1.class);
    }

    public String toString() {
        return "MultiLiveCoreInfo{scene=" + this.scene + ", videoEqualRoomLiveCoreInfo=" + this.videoEqualRoomLiveCoreInfo + ", ktvLiveCoreInfo=" + this.ktvLiveCoreInfo + ", singingChallengeLiveCoreInfo=" + this.singingChallengeLiveCoreInfo + ", multiAnchorLiveCoreInfo=" + this.multiAnchorLiveCoreInfo + ", videoPositionLiveCoreInfo=" + this.videoPositionLiveCoreInfo + '}';
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public /* bridge */ /* synthetic */ i0 getKtvLiveCoreInfo() {
        return getKtvLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.p1 getMultiAnchorLiveCoreInfo() {
        return getMultiAnchorLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.i2 getSingingChallengeLiveCoreInfo() {
        return getSingingChallengeLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.l2 getVideoEqualRoomLiveCoreInfo() {
        return getVideoEqualRoomLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m2 getVideoPositionLiveCoreInfo() {
        return getVideoPositionLiveCoreInfo();
    }

    public int getScene() {
        return this.scene;
    }

    public VideoDuoBattleLiveCoreInfo getVideoDuoBattleLiveCoreInfo() {
        return this.videoDuoBattleLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public KTVLiveCoreInfo getKtvLiveCoreInfo() {
        return this.ktvLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public MultiAnchorLinkmicLiveCoreInfo getMultiAnchorLiveCoreInfo() {
        return this.multiAnchorLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public SingingChallengeLiveCoreInfo getSingingChallengeLiveCoreInfo() {
        return this.singingChallengeLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public VideoEqualRoomLiveCoreInfo getVideoEqualRoomLiveCoreInfo() {
        return this.videoEqualRoomLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public VideoPositionLiveCoreInfo getVideoPositionLiveCoreInfo() {
        return this.videoPositionLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1
    public void setKtvLiveCoreInfo(i0 r100) {
        this.ktvLiveCoreInfo = (KTVLiveCoreInfo) r100;
    }

    public void setScene(int r100) {
        this.scene = r100;
    }
}
