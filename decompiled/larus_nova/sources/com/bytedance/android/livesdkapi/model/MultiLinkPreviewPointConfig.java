package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/MultiLinkPreviewPointConfig;", "", "()V", "broadcastGameStartErrorSwitchScene", "", "getBroadcastGameStartErrorSwitchScene", "()Z", "setBroadcastGameStartErrorSwitchScene", "(Z)V", "broadcastMultiLinkGameItemEnable", "getBroadcastMultiLinkGameItemEnable", "setBroadcastMultiLinkGameItemEnable", "broadcastPreviewGameImageMap", "", "", "getBroadcastPreviewGameImageMap", "()Ljava/util/Map;", "setBroadcastPreviewGameImageMap", "(Ljava/util/Map;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkPreviewPointConfig {

    @SerializedName("broadcast_game_start_error_switch_scene")
    private boolean broadcastGameStartErrorSwitchScene;

    @SerializedName("broadcast_multi_link_game_item_enable")
    private boolean broadcastMultiLinkGameItemEnable;

    @SerializedName("broadcast_preview_game_image_map")
    private Map<String, String> broadcastPreviewGameImageMap;

    public MultiLinkPreviewPointConfig() {
        this.broadcastPreviewGameImageMap = MapsKt.emptyMap();
        this.broadcastGameStartErrorSwitchScene = true;
    }

    public final boolean getBroadcastGameStartErrorSwitchScene() {
        return this.broadcastGameStartErrorSwitchScene;
    }

    public final boolean getBroadcastMultiLinkGameItemEnable() {
        return this.broadcastMultiLinkGameItemEnable;
    }

    public final Map<String, String> getBroadcastPreviewGameImageMap() {
        return this.broadcastPreviewGameImageMap;
    }

    public final void setBroadcastGameStartErrorSwitchScene(boolean r100) {
        this.broadcastGameStartErrorSwitchScene = r100;
    }

    public final void setBroadcastMultiLinkGameItemEnable(boolean r100) {
        this.broadcastMultiLinkGameItemEnable = r100;
    }

    public final void setBroadcastPreviewGameImageMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.broadcastPreviewGameImageMap = r100;
    }
}
