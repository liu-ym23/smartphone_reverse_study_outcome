package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/v;", "", "", "enableSideBarAnimation", "Z", "getEnableSideBarAnimation", "()Z", "setEnableSideBarAnimation", "(Z)V", "", "exitDetailDialogDuration", "I", "getExitDetailDialogDuration", "()I", "setExitDetailDialogDuration", "(I)V", "", "", "supportGameChannel", "Ljava/util/List;", "getSupportGameChannel", "()Ljava/util/List;", "setSupportGameChannel", "(Ljava/util/List;)V", "supportEnterFrom", "getSupportEnterFrom", "setSupportEnterFrom", "supportPromoteScene", "getSupportPromoteScene", "setSupportPromoteScene", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("enable_gmcp_detail_exit_sidebar_animation")
    private boolean enableSideBarAnimation;

    @SerializedName("gmcp_detail_exit_within_seconds")
    private int exitDetailDialogDuration;

    @SerializedName("gmcp_detail_exit_support_enter_from")
    private List<String> supportEnterFrom;

    @SerializedName("gmcp_support_sidebar_channel")
    private List<String> supportGameChannel;

    @SerializedName("gmcp_detail_exit_support_promote_scene")
    private List<String> supportPromoteScene;

    public v() {
        this(null);
    }

    public v(Object r100) {
        List<String> r101 = CollectionsKt.listOf("108_gamecp_1");
        List<String> r102 = CollectionsKt.listOf(new String[]{"homepage_follow", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT});
        List<String> r103 = CollectionsKt.listOf("video");
        this.enableSideBarAnimation = false;
        this.exitDetailDialogDuration = 5;
        this.supportGameChannel = r101;
        this.supportEnterFrom = r102;
        this.supportPromoteScene = r103;
    }
}
