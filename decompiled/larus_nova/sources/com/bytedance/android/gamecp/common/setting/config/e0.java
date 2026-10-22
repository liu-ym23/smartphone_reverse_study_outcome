package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/e0;", "", "", "", "defaultTips", "Ljava/util/List;", "getDefaultTips", "()Ljava/util/List;", "setDefaultTips", "(Ljava/util/List;)V", "mapPlayTips", "getMapPlayTips", "setMapPlayTips", "teamPlayTips", "getTeamPlayTips", "setTeamPlayTips", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("default_tips")
    private List<String> defaultTips;

    @SerializedName("map_play_tips")
    private List<String> mapPlayTips;

    @SerializedName("team_play_tips")
    private List<String> teamPlayTips;

    public e0() {
        this.defaultTips = CollectionsKt.listOf(new String[]{"抖音登录玩，和游戏内账号互通", "游戏运行在云端，不会占用手机本地内存", "稳定的网络环境能带来更好的游戏体验", "游戏中若遇到问题，可随时在悬浮球-帮助页面反馈"});
        this.mapPlayTips = CollectionsKt.listOf(new String[]{"挑战视频同款，一键秒玩", "游戏运行在云端，不会占用手机本地内存", "稳定的网络环境能带来更好的游戏体验", "游戏中若遇到问题，可随时在悬浮球-帮助页面反馈"});
        this.teamPlayTips = CollectionsKt.listOf(new String[]{"一键上车，与主播同场竞技", "游戏运行在云端，不会占用手机本地内存", "稳定的网络环境能带来更好的游戏体验", "游戏中若遇到问题，可随时在悬浮球-帮助页面反馈"});
    }
}
