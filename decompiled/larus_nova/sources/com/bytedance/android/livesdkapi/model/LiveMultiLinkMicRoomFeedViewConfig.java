package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveMultiLinkMicRoomFeedViewConfig;", "", "()V", "disableSceneList", "", "", "getDisableSceneList", "()Ljava/util/List;", "setDisableSceneList", "(Ljava/util/List;)V", "supportSceneList", "getSupportSceneList", "setSupportSceneList", "videoLiveEnableMicRoom", "", "getVideoLiveEnableMicRoom", "()Z", "setVideoLiveEnableMicRoom", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveMultiLinkMicRoomFeedViewConfig {

    @SerializedName("disable_scene_list")
    private List<String> disableSceneList;

    @SerializedName("support_scene_list")
    private List<String> supportSceneList;

    @SerializedName("video_live_enable_mic_room")
    private boolean videoLiveEnableMicRoom;

    public LiveMultiLinkMicRoomFeedViewConfig() {
        this.supportSceneList = CollectionsKt.mutableListOf(new String[]{"4", "5", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "11", "12", Constants.VIA_REPORT_TYPE_START_WAP});
        this.disableSceneList = CollectionsKt.mutableListOf(new String[]{"1", "2"});
        this.videoLiveEnableMicRoom = true;
    }

    public final List<String> getDisableSceneList() {
        return this.disableSceneList;
    }

    public final List<String> getSupportSceneList() {
        return this.supportSceneList;
    }

    public final boolean getVideoLiveEnableMicRoom() {
        return this.videoLiveEnableMicRoom;
    }

    public final void setDisableSceneList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.disableSceneList = r100;
    }

    public final void setSupportSceneList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.supportSceneList = r100;
    }

    public final void setVideoLiveEnableMicRoom(boolean r100) {
        this.videoLiveEnableMicRoom = r100;
    }
}
