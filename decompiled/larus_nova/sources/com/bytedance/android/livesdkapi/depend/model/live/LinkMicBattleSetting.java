package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LinkMic.LinkMicBattleSetting")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LinkMicBattleSetting;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkMicBattleSetting;", "()V", "activityMode", "", "battleId", RemoteMessageConst.Notification.CHANNEL_ID, "duration", "", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "matchType", Keys.API_EVENT_KEY_PLAY_MODE, "startTimeMs", "teamMode", "theme", "", "toString", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicBattleSetting extends FlexModelBase<ILinkMicBattleSetting> implements ILinkMicBattleSetting, h {
    public static long ActivityMode_Empty;
    public static long ActivityMode_FlexActivity;
    public static long ActivityMode_PkSeason;
    public static long BattlePlayMode_Breakthrough;
    public static long BattlePlayMode_Compete;
    public static long BattlePlayMode_PK;
    public static long BattlePlayMode_Season;
    public static long BattlePlayMode_SelfPK;
    public static long BattlePlayMode_SpecifyGift;
    public static long BattlePlayMode_Vote;
    public static final Companion Companion = null;
    public static long TeamMode_Person;
    public static long TeamMode_Team;

    @SerializedName("activity_mode")
    public long activityMode;

    @SerializedName("battle_id")
    public long battleId;

    @SerializedName("channel_id")
    public long channelId;

    @SerializedName("duration")
    public int duration;

    @SerializedName(CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED)
    public long finished;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    public long matchType;

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    public long playMode;

    @SerializedName("start_time_ms")
    public long startTimeMs;

    @SerializedName("team_mode")
    public long teamMode;

    @SerializedName("theme")
    public String theme;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LinkMicBattleSetting$Companion;", "", "()V", "ActivityMode_Empty", "", "ActivityMode_FlexActivity", "ActivityMode_PkSeason", "BattlePlayMode_Breakthrough", "BattlePlayMode_Compete", "BattlePlayMode_PK", "BattlePlayMode_Season", "BattlePlayMode_SelfPK", "BattlePlayMode_SpecifyGift", "BattlePlayMode_Vote", "TeamMode_Person", "TeamMode_Team", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public LinkMicBattleSetting() {
        super(ILinkMicBattleSetting.class);
    }

    static {
        Companion = new Companion(null);
        BattlePlayMode_SelfPK = 10;
        BattlePlayMode_Vote = 101;
        BattlePlayMode_Breakthrough = 102;
        BattlePlayMode_Compete = 201;
        BattlePlayMode_SpecifyGift = 300;
        BattlePlayMode_Season = 501;
        ActivityMode_FlexActivity = 1;
        ActivityMode_PkSeason = 2;
        TeamMode_Team = 1;
    }

    public String toString() {
        return "LinkMicBattleSetting{finished=" + this.finished + ", channelId=" + this.channelId + ", duration=" + this.duration + ", startTimeMs=" + this.startTimeMs + ", theme='" + this.theme + "', battleId=" + this.battleId + ", matchType=" + this.matchType + '}';
    }

    public LinkMicBattleSetting(g r100) {
        super(ILinkMicBattleSetting.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L7;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this.activityMode = r100.j();
        goto L3
    L9:
        this.teamMode = r100.j();
        goto L3
    L10:
        this.playMode = r100.j();
        goto L3
    L11:
        this.matchType = r100.j();
        goto L3
    L12:
        this.battleId = r100.j();
        goto L3
    L13:
        this.finished = r100.j();
        goto L3
    L14:
        this.theme = am3.h.c(r100);
        goto L3
    L15:
        this.startTimeMs = r100.j();
        goto L3
    L16:
        this.duration = (int) r100.j();
        goto L3
    L17:
        this.channelId = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
