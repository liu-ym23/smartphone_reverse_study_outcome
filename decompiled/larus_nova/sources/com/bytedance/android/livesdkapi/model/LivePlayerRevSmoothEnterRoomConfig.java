package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eR&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePlayerRevSmoothEnterRoomConfig;", "", "()V", "feedSeiOptScene", "", "", "getFeedSeiOptScene", "()Ljava/util/List;", "setFeedSeiOptScene", "(Ljava/util/List;)V", "linkUiKitShowTimeOut", "", "removeFrameViewMockTimeOut", "removeFrameViewMockWhenPause", "", "smoothClose", "smoothViewMock", "totalSwitch", "getLinkUiKitShowTimeOut", "getRemoveViewMockTimeOut", "isFeedSeiOpt", "scene", "isOpenSmoothClose", "isOpenSmoothViewMock", "isRemoveFrameViewMockWhenPause", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerRevSmoothEnterRoomConfig {

    @SerializedName("feed_sei_opt_scene")
    private List<Integer> feedSeiOptScene;

    @SerializedName("link_uikit_show_time_out")
    private long linkUiKitShowTimeOut;

    @SerializedName("remove_frame_view_mock_time_out")
    private long removeFrameViewMockTimeOut;

    @SerializedName("remove_frame_view_mock_when_pause")
    private boolean removeFrameViewMockWhenPause;

    @SerializedName("smooth_close")
    private boolean smoothClose;

    @SerializedName("smooth_view_mock")
    private boolean smoothViewMock;

    @SerializedName("total_switch")
    private boolean totalSwitch;

    public final boolean isOpenSmoothClose() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.smoothClose == false) goto L7;
        return true;
    }

    public final boolean isOpenSmoothViewMock() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.smoothViewMock == false) goto L7;
        return true;
    }

    public final boolean isRemoveFrameViewMockWhenPause() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.removeFrameViewMockWhenPause == false) goto L7;
        return true;
    }

    public LivePlayerRevSmoothEnterRoomConfig() {
        this.feedSeiOptScene = CollectionsKt.emptyList();
        this.removeFrameViewMockWhenPause = true;
        this.removeFrameViewMockTimeOut = 10;
        this.linkUiKitShowTimeOut = 12;
    }

    public final List<Integer> getFeedSeiOptScene() {
        return this.feedSeiOptScene;
    }

    public final long getLinkUiKitShowTimeOut() {
        return this.linkUiKitShowTimeOut;
    }

    public final long getRemoveViewMockTimeOut() {
        return this.removeFrameViewMockTimeOut;
    }

    public final boolean isFeedSeiOpt(int r100) {
        if (this.totalSwitch == false) goto L9;
        List<Integer> r101 = this.feedSeiOptScene;
        if (r101 == null) goto L9;
        if (r101.contains(Integer.valueOf(r100)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setFeedSeiOptScene(List<Integer> r100) {
        this.feedSeiOptScene = r100;
    }
}
