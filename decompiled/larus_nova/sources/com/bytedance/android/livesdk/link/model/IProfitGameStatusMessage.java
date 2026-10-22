package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003bcdR\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR*\u0010,\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R$\u00100\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\"\u00104\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\t\u001a\u0004\b1\u0010\u0005\"\u0004\b2\u0010\u0007R\"\u0010:\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\t\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010>\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\t\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR$\u0010B\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\t\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010F\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\t\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\"\u0010J\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\t\u001a\u0004\bG\u0010\u0005\"\u0004\bH\u0010\u0007R\"\u0010Q\u001a\u00020K8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bP\u0010\t\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR>\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0Rj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`S8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\t\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010]\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\\\u0010\t\u001a\u0004\bZ\u00106\"\u0004\b[\u00108R\"\u0010a\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\t\u001a\u0004\b^\u0010\u0005\"\u0004\b_\u0010\u0007¨\u0006e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/e2;", "", "getGameStatus", "()I", "setGameStatus", "(I)V", "getGameStatus$annotations", "()V", "gameStatus", "", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "getRoomId$annotations", "roomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)V", "getStreamUrl$annotations", "streamUrl", "", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "getGameId$annotations", "gameId", "getAppId", "setAppId", "getAppId$annotations", "appId", "getLinkGameId", "setLinkGameId", "getLinkGameId$annotations", "linkGameId", "getAndStreamUrl", "setAndStreamUrl", "getAndStreamUrl$annotations", "andStreamUrl", "getGameExtra", "setGameExtra", "getGameExtra$annotations", "gameExtra", "getPushStreamType", "setPushStreamType", "getPushStreamType$annotations", "pushStreamType", "getGameType", "()J", "setGameType", "(J)V", "getGameType$annotations", "gameType", "getInitParam", "setInitParam", "getInitParam$annotations", "initParam", "getAnchorOpenId", "setAnchorOpenId", "getAnchorOpenId$annotations", "anchorOpenId", "getLinkerExtra", "setLinkerExtra", "getLinkerExtra$annotations", "linkerExtra", "getBizEndReasonType", "setBizEndReasonType", "getBizEndReasonType$annotations", "bizEndReasonType", "", "getServerRtcStream", "()Z", "setServerRtcStream", "(Z)V", "getServerRtcStream$annotations", "serverRtcStream", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTrackInfo", "()Ljava/util/Map;", "setTrackInfo", "(Ljava/util/Map;)V", "getTrackInfo$annotations", "trackInfo", "getChannelId", "setChannelId", "getChannelId$annotations", RemoteMessageConst.Notification.CHANNEL_ID, "getBizType", "setBizType", "getBizType$annotations", "bizType", "EndReasonType", "GameStatus", "PushStreamType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IProfitGameStatusMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e2>, com.bytedance.android.livesdk.link.model.bridge.e2 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessage$EndReasonType;", "", "DefaultReason", "BizReply", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EndReasonType extends Enum<EndReasonType> {
        public static final EndReasonType BizReply = null;
        public static final EndReasonType DefaultReason = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EndReasonType[] f147062a = null;

        static {
            EndReasonType r100 = new EndReasonType("DefaultReason", 0);
            DefaultReason = r100;
            EndReasonType r101 = new EndReasonType("BizReply", 1);
            BizReply = r101;
            f147062a = new EndReasonType[]{r100, r101};
        }

        public static EndReasonType valueOf(String r100) {
            return (EndReasonType) r27.a.a(EndReasonType.class, r100);
        }

        public static EndReasonType[] values() {
            return (EndReasonType[]) f147062a.clone();
        }

        public EndReasonType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessage$GameStatus;", "", "Default", "BizStart", "BizEnd", "AppStart", "AppFinish", "GameStart", "GameFinish", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum GameStatus extends Enum<GameStatus> {
        public static final GameStatus AppFinish = null;
        public static final GameStatus AppStart = null;
        public static final GameStatus BizEnd = null;
        public static final GameStatus BizStart = null;
        public static final GameStatus Default = null;
        public static final GameStatus GameFinish = null;
        public static final GameStatus GameStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GameStatus[] f147063a = null;

        static {
            GameStatus r100 = new GameStatus("Default", 0);
            Default = r100;
            GameStatus r101 = new GameStatus("BizStart", 1);
            BizStart = r101;
            GameStatus r102 = new GameStatus("BizEnd", 2);
            BizEnd = r102;
            GameStatus r103 = new GameStatus("AppStart", 3);
            AppStart = r103;
            GameStatus r104 = new GameStatus("AppFinish", 4);
            AppFinish = r104;
            GameStatus r105 = new GameStatus("GameStart", 5);
            GameStart = r105;
            GameStatus r106 = new GameStatus("GameFinish", 6);
            GameFinish = r106;
            f147063a = new GameStatus[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static GameStatus valueOf(String r100) {
            return (GameStatus) r27.a.a(GameStatus.class, r100);
        }

        public static GameStatus[] values() {
            return (GameStatus[]) f147063a.clone();
        }

        public GameStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessage$PushStreamType;", "", "Default_Push", "Cloud_Push", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PushStreamType extends Enum<PushStreamType> {
        public static final PushStreamType Cloud_Push = null;
        public static final PushStreamType Default_Push = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PushStreamType[] f147064a = null;

        static {
            PushStreamType r100 = new PushStreamType("Default_Push", 0);
            Default_Push = r100;
            PushStreamType r101 = new PushStreamType("Cloud_Push", 1);
            Cloud_Push = r101;
            f147064a = new PushStreamType[]{r100, r101};
        }

        public static PushStreamType valueOf(String r100) {
            return (PushStreamType) r27.a.a(PushStreamType.class, r100);
        }

        public static PushStreamType[] values() {
            return (PushStreamType[]) f147064a.clone();
        }

        public PushStreamType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.e2, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.e2, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_open_id")
    String getAnchorOpenId();

    @FieldName(name = "android_stream_url")
    IBaseStreamUrl getAndStreamUrl();

    @FieldName(name = "app_id")
    String getAppId();

    @FieldName(name = "reason")
    int getBizEndReasonType();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "channel_id")
    long getChannelId();

    @Override // com.bytedance.android.livesdk.link.model.bridge.e2, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "game_extra")
    String getGameExtra();

    @FieldName(name = "game_id")
    Long getGameId();

    @FieldName(name = "status")
    int getGameStatus();

    @FieldName(name = BdpAppEventConstant.PARAMS_GAME_TYPE)
    long getGameType();

    @FieldName(name = "init_param")
    String getInitParam();

    @FieldName(name = "link_game_id")
    Long getLinkGameId();

    @FieldName(name = "linker_extra")
    String getLinkerExtra();

    @FieldName(name = "push_stream_type")
    int getPushStreamType();

    @FieldName(name = "room_id")
    String getRoomId();

    @FieldName(name = "server_rtc_stream")
    boolean getServerRtcStream();

    @FieldName(name = "stream_url")
    IBaseStreamUrl getStreamUrl();

    @FieldName(name = "track_info")
    Map<String, String> getTrackInfo();

    @FieldName(name = "anchor_open_id#setter")
    void setAnchorOpenId(String r100);

    @FieldName(name = "android_stream_url#setter")
    void setAndStreamUrl(IBaseStreamUrl r100);

    @FieldName(name = "app_id#setter")
    void setAppId(String r100);

    @FieldName(name = "reason#setter")
    void setBizEndReasonType(int r100);

    @FieldName(name = "biz_type#setter")
    void setBizType(int r100);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.e2
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "game_extra#setter")
    void setGameExtra(String r100);

    @FieldName(name = "game_id#setter")
    void setGameId(Long r100);

    @FieldName(name = "status#setter")
    void setGameStatus(int r100);

    @FieldName(name = "game_type#setter")
    void setGameType(long r100);

    @FieldName(name = "init_param#setter")
    void setInitParam(String r100);

    @FieldName(name = "link_game_id#setter")
    void setLinkGameId(Long r100);

    @FieldName(name = "linker_extra#setter")
    void setLinkerExtra(String r100);

    @FieldName(name = "push_stream_type#setter")
    void setPushStreamType(int r100);

    @FieldName(name = "room_id#setter")
    void setRoomId(String r100);

    @FieldName(name = "server_rtc_stream#setter")
    void setServerRtcStream(boolean r100);

    @FieldName(name = "stream_url#setter")
    void setStreamUrl(IBaseStreamUrl r100);

    @FieldName(name = "track_info#setter")
    void setTrackInfo(Map<String, String> r100);
}
