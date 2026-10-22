package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePlayerSmoothEnterRoomConfig;", "", "()V", "avatarAntiFlink", "", "avatarAntiFlinkDebounce", "", "disableWRDSWhenEnterRoom", "feedInfoTransport", "feedViewDisplayWhenGuestListReady", "ktvBgVisibleFallbackTime", "loadFeedViewAdapter", "removeFrameViewMockTimeOut", "removeFrameViewMockWhenPause", "seatDrawProtectTime", "smoothEnterRoom", "smoothViewMock", "totalSwitch", "userInfoCenterForwardInit", "getAntiFlinkDebounce", "getKtvBgVisibleFallbackTime", "getRemoveViewMockTimeOut", "getSeatDrawProtectTime", "isAvatarLoadAntiFlink", "isDisableWRDSWhenEnterRoom", "isFeedInfoTransport", "isFeedViewDisplayWhenGuestListReady", "isOpenLoadFeedViewAdapter", "isOpenSmoothEnterRoom", "isOpenSmoothViewMock", "isRemoveFrameViewMockWhenPause", "isTotalSwitch", "isUserInfoCenterForwardInit", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePlayerSmoothEnterRoomConfig {

    @SerializedName("avatar_anti_flink")
    private boolean avatarAntiFlink;

    @SerializedName("avatar_anti_flink_debounce")
    private long avatarAntiFlinkDebounce;

    @SerializedName("disable_wrds_when_enter_room")
    private boolean disableWRDSWhenEnterRoom;

    @SerializedName("feed_info_transport")
    private boolean feedInfoTransport;

    @SerializedName("feed_view_display_when_guest_list_ready")
    private boolean feedViewDisplayWhenGuestListReady;

    @SerializedName("ktv_bg_visible_fallback_time")
    private long ktvBgVisibleFallbackTime;

    @SerializedName("load_feed_view_adapter")
    private final boolean loadFeedViewAdapter;

    @SerializedName("remove_frame_view_mock_time_out")
    private long removeFrameViewMockTimeOut;

    @SerializedName("remove_frame_view_mock_when_pause")
    private boolean removeFrameViewMockWhenPause;

    @SerializedName("show_content_when_seat_draw_protect")
    private long seatDrawProtectTime;

    @SerializedName("smooth_enter_room")
    private boolean smoothEnterRoom;

    @SerializedName("smooth_view_mock")
    private boolean smoothViewMock;

    @SerializedName("total_switch")
    private boolean totalSwitch;

    @SerializedName("user_info_center_forward_init")
    private boolean userInfoCenterForwardInit;

    public final boolean isAvatarLoadAntiFlink() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.avatarAntiFlink == false) goto L7;
        return true;
    }

    public final boolean isDisableWRDSWhenEnterRoom() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.disableWRDSWhenEnterRoom == false) goto L7;
        return true;
    }

    public final boolean isFeedInfoTransport() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.feedInfoTransport == false) goto L7;
        return true;
    }

    public final boolean isFeedViewDisplayWhenGuestListReady() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.feedViewDisplayWhenGuestListReady == false) goto L7;
        return true;
    }

    public final boolean isOpenSmoothEnterRoom() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.smoothEnterRoom == false) goto L7;
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

    public final boolean isUserInfoCenterForwardInit() {
        if (this.totalSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.userInfoCenterForwardInit == false) goto L7;
        return true;
    }

    public LivePlayerSmoothEnterRoomConfig() {
        this.totalSwitch = true;
        this.smoothEnterRoom = true;
        this.loadFeedViewAdapter = true;
        this.smoothViewMock = true;
        this.feedInfoTransport = true;
        this.removeFrameViewMockWhenPause = true;
        this.removeFrameViewMockTimeOut = 10;
        this.disableWRDSWhenEnterRoom = true;
        this.feedViewDisplayWhenGuestListReady = true;
        this.avatarAntiFlink = true;
        this.avatarAntiFlinkDebounce = 5000;
        this.seatDrawProtectTime = 300;
        this.ktvBgVisibleFallbackTime = 7000;
    }

    public final long getAntiFlinkDebounce() {
        return this.avatarAntiFlinkDebounce;
    }

    public final long getKtvBgVisibleFallbackTime() {
        return this.ktvBgVisibleFallbackTime;
    }

    public final long getRemoveViewMockTimeOut() {
        return this.removeFrameViewMockTimeOut;
    }

    public final long getSeatDrawProtectTime() {
        return this.seatDrawProtectTime;
    }

    public final boolean isOpenLoadFeedViewAdapter() {
        return this.loadFeedViewAdapter;
    }

    public final boolean isTotalSwitch() {
        return this.totalSwitch;
    }
}
