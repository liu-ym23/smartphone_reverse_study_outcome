package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VideoHeadSurfaceControlConfig;", "", "()V", "enableSceneList", "", "", "getEnableSceneList", "()Ljava/util/List;", "setEnableSceneList", "(Ljava/util/List;)V", "forceResetDelay", "", "getForceResetDelay", "()J", "setForceResetDelay", "(J)V", "surfaceControlEnable", "", "getSurfaceControlEnable", "()Z", "setSurfaceControlEnable", "(Z)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoHeadSurfaceControlConfig {

    @SerializedName("enable_scene_list")
    private List<String> enableSceneList;

    @SerializedName("force_reset_delay")
    private long forceResetDelay;

    @SerializedName("surface_control_enable")
    private boolean surfaceControlEnable;

    public VideoHeadSurfaceControlConfig() {
        this.forceResetDelay = 300;
        this.enableSceneList = CollectionsKt.emptyList();
    }

    public final List<String> getEnableSceneList() {
        return this.enableSceneList;
    }

    public final long getForceResetDelay() {
        return this.forceResetDelay;
    }

    public final boolean getSurfaceControlEnable() {
        return this.surfaceControlEnable;
    }

    public final void setEnableSceneList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enableSceneList = r100;
    }

    public final void setForceResetDelay(long r100) {
        this.forceResetDelay = r100;
    }

    public final void setSurfaceControlEnable(boolean r100) {
        this.surfaceControlEnable = r100;
    }
}
