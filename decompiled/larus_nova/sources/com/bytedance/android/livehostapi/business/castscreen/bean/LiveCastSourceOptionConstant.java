package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastSourceOptionConstant;", "", "()V", "GUIDE_VIDEO_STATUS_PLAY", "", "OPTION_CONTROL_VIEW_FEED_BACK_ENABLE", "OPTION_HIDE_REFRESH_ICON", "OPTION_LIVE_LANDSCAPE_SEARCH_HIDE_NAV_BAR", "OPTION_LIVE_ROOM_CLOSE", "OPTION_RESOLUTION_SHOW_REVERSED", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastSourceOptionConstant {
    public static final int GUIDE_VIDEO_STATUS_PLAY = 1;
    public static final LiveCastSourceOptionConstant INSTANCE = null;
    public static final int OPTION_CONTROL_VIEW_FEED_BACK_ENABLE = 300000;
    public static final int OPTION_HIDE_REFRESH_ICON = 100002;
    public static final int OPTION_LIVE_LANDSCAPE_SEARCH_HIDE_NAV_BAR = 100000;
    public static final int OPTION_LIVE_ROOM_CLOSE = 400000;
    public static final int OPTION_RESOLUTION_SHOW_REVERSED = 100003;

    private LiveCastSourceOptionConstant() {
    }

    static {
        INSTANCE = new LiveCastSourceOptionConstant();
    }
}
