package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0003\b\u0092\u0001\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0006\u009a\u0001\u009b\u0001\u009c\u0001R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R\"\u0010\u001d\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\"\u0010!\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\"\u0010%\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R\"\u0010)\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\t\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R\"\u0010-\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\t\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\"\u00101\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\t\u001a\u0004\b.\u0010\u0005\"\u0004\b/\u0010\u0007R\"\u00105\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\t\u001a\u0004\b2\u0010\u0005\"\u0004\b3\u0010\u0007R\"\u00109\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\t\u001a\u0004\b6\u0010\u0005\"\u0004\b7\u0010\u0007R\"\u0010=\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\t\u001a\u0004\b:\u0010\u0005\"\u0004\b;\u0010\u0007R\"\u0010A\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\t\u001a\u0004\b>\u0010\u0005\"\u0004\b?\u0010\u0007R\"\u0010E\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\t\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R\"\u0010I\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bH\u0010\t\u001a\u0004\bF\u0010\u0005\"\u0004\bG\u0010\u0007R\"\u0010M\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bL\u0010\t\u001a\u0004\bJ\u0010\u0005\"\u0004\bK\u0010\u0007R\"\u0010Q\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bP\u0010\t\u001a\u0004\bN\u0010\u0005\"\u0004\bO\u0010\u0007R\"\u0010U\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\t\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\"\u0010Y\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\t\u001a\u0004\bV\u0010\u0005\"\u0004\bW\u0010\u0007R\"\u0010]\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\\\u0010\t\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR\"\u0010a\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\t\u001a\u0004\b^\u0010\r\"\u0004\b_\u0010\u000fR\"\u0010e\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bd\u0010\t\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000fR\"\u0010i\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bh\u0010\t\u001a\u0004\bf\u0010\u0005\"\u0004\bg\u0010\u0007R\"\u0010m\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bl\u0010\t\u001a\u0004\bj\u0010\u0005\"\u0004\bk\u0010\u0007R\"\u0010q\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bp\u0010\t\u001a\u0004\bn\u0010\u0005\"\u0004\bo\u0010\u0007R\"\u0010u\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bt\u0010\t\u001a\u0004\br\u0010\u0005\"\u0004\bs\u0010\u0007R\"\u0010y\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bx\u0010\t\u001a\u0004\bv\u0010\u0005\"\u0004\bw\u0010\u0007R\"\u0010}\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b|\u0010\t\u001a\u0004\bz\u0010\u0005\"\u0004\b{\u0010\u0007R$\u0010\u0081\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0013\u0012\u0005\b\u0080\u0001\u0010\t\u001a\u0004\b~\u0010\u0005\"\u0004\b\u007f\u0010\u0007R&\u0010\u0085\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0084\u0001\u0010\t\u001a\u0005\b\u0082\u0001\u0010\u0005\"\u0005\b\u0083\u0001\u0010\u0007R&\u0010\u0089\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0088\u0001\u0010\t\u001a\u0005\b\u0086\u0001\u0010\u0005\"\u0005\b\u0087\u0001\u0010\u0007R&\u0010\u008d\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u008c\u0001\u0010\t\u001a\u0005\b\u008a\u0001\u0010\u0005\"\u0005\b\u008b\u0001\u0010\u0007R&\u0010\u0091\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0090\u0001\u0010\t\u001a\u0005\b\u008e\u0001\u0010\u0005\"\u0005\b\u008f\u0001\u0010\u0007R&\u0010\u0095\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0094\u0001\u0010\t\u001a\u0005\b\u0092\u0001\u0010\u0005\"\u0005\b\u0093\u0001\u0010\u0007R&\u0010\u0099\u0001\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0098\u0001\u0010\t\u001a\u0005\b\u0096\u0001\u0010\u0005\"\u0005\b\u0097\u0001\u0010\u0007¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusKt;", "", "getMoreAnchor", "()J", "setMoreAnchor", "(J)V", "getMoreAnchor$annotations", "()V", "moreAnchor", "", "getEnableChat", "()Z", "setEnableChat", "(Z)V", "getEnableChat$annotations", "enableChat", "getEnableDanmaku", "setEnableDanmaku", "getEnableDanmaku$annotations", "enableDanmaku", "getDanmakuDefault", "setDanmakuDefault", "getDanmakuDefault$annotations", "danmakuDefault", "getPoster", "setPoster", "getPoster$annotations", "poster", "getDownloadVideo", "setDownloadVideo", "getDownloadVideo$annotations", "downloadVideo", "getUgcVSReplayDelete", "setUgcVSReplayDelete", "getUgcVSReplayDelete$annotations", "ugcVSReplayDelete", "getUgcVsReplayVisibility", "setUgcVsReplayVisibility", "getUgcVsReplayVisibility$annotations", "ugcVsReplayVisibility", "getCastScreen", "setCastScreen", "getCastScreen$annotations", "castScreen", "getCastScreenExplicit", "setCastScreenExplicit", "getCastScreenExplicit$annotations", "castScreenExplicit", "getPcPlay", "setPcPlay", "getPcPlay$annotations", "pcPlay", "getPadPlay", "setPadPlay", "getPadPlay$annotations", "padPlay", "getMultiplierPlayback", "setMultiplierPlayback", "getMultiplierPlayback$annotations", "multiplierPlayback", "getCollect", "setCollect", "getCollect$annotations", ShareChannel.COLLECT, "getTimedShutdown", "setTimedShutdown", "getTimedShutdown$annotations", "timedShutdown", "getDenounce", "setDenounce", "getDenounce$annotations", "denounce", "getDislike", "setDislike", "getDislike$annotations", AppConstants.BUNDLE_DISLIKE, "getRecordScreen", "setRecordScreen", "getRecordScreen$annotations", "recordScreen", "getEnableGift", "setEnableGift", "getEnableGift$annotations", "enableGift", "getShowShare", "setShowShare", "getShowShare$annotations", "showShare", "getEnableDigg", "setEnableDigg", "getEnableDigg$annotations", "enableDigg", "getEnablePoi", "setEnablePoi", "getEnablePoi$annotations", "enablePoi", "getEnableUserCard", "setEnableUserCard", "getEnableUserCard$annotations", "enableUserCard", "getVideoAmplificationType", "setVideoAmplificationType", "getVideoAmplificationType$annotations", "videoAmplificationType", "getFansClubAuth", "setFansClubAuth", "getFansClubAuth$annotations", "fansClubAuth", "getEcomFansClubAuth", "setEcomFansClubAuth", "getEcomFansClubAuth$annotations", "ecomFansClubAuth", "getEnableAdminPinComment", "setEnableAdminPinComment", "getEnableAdminPinComment$annotations", "enableAdminPinComment", "getProjectionBtn", "setProjectionBtn", "getProjectionBtn$annotations", "projectionBtn", "getEnableVideoShare", "setEnableVideoShare", "getEnableVideoShare$annotations", "enableVideoShare", "getStreamAdaptation", "setStreamAdaptation", "getStreamAdaptation$annotations", "streamAdaptation", "getCommerceCard", "setCommerceCard", "getCommerceCard$annotations", "commerceCard", "getGamePointsPlaying", "setGamePointsPlaying", "getGamePointsPlaying$annotations", "gamePointsPlaying", "getCommonCard", "setCommonCard", "getCommonCard$annotations", "commonCard", "getHighlightAreaContainer", "setHighlightAreaContainer", "getHighlightAreaContainer$annotations", "highlightAreaContainer", "getPlayerRankList", "setPlayerRankList", "getPlayerRankList$annotations", "playerRankList", "getQuizGamePointsPlaying", "setQuizGamePointsPlaying", "getQuizGamePointsPlaying$annotations", "quizGamePointsPlaying", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "IOffReason", "IRoomAuthSpecialStyle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomAuthStatus extends c<IRoomAuthStatus>, IRoomAuthStatusKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$Action;", "", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface Action {
        public static final Companion Companion = null;
        public static final long DEFAULT = 0;
        public static final long DISABLE = 2;
        public static final long ENABLE = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$Action$Companion;", "", "()V", "DEFAULT", "", "DISABLE", "ENABLE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final long DEFAULT = 0;
            public static final long DISABLE = 2;
            public static final long ENABLE = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "CastScreen")
        public static /* synthetic */ void getCastScreen$annotations() {
        }

        @FieldName(name = "CastScreenExplicit")
        public static /* synthetic */ void getCastScreenExplicit$annotations() {
        }

        @FieldName(name = "Collect")
        public static /* synthetic */ void getCollect$annotations() {
        }

        @FieldName(name = "CommerceCard")
        public static /* synthetic */ void getCommerceCard$annotations() {
        }

        @FieldName(name = "CommonCard")
        public static /* synthetic */ void getCommonCard$annotations() {
        }

        @FieldName(name = "DanmakuDefault")
        public static /* synthetic */ void getDanmakuDefault$annotations() {
        }

        @FieldName(name = "Denounce")
        public static /* synthetic */ void getDenounce$annotations() {
        }

        @FieldName(name = "Dislike")
        public static /* synthetic */ void getDislike$annotations() {
        }

        @FieldName(name = "DownloadVideo")
        public static /* synthetic */ void getDownloadVideo$annotations() {
        }

        @FieldName(name = "EcomFansClub")
        public static /* synthetic */ void getEcomFansClubAuth$annotations() {
        }

        @FieldName(name = "AdminCommentWall")
        public static /* synthetic */ void getEnableAdminPinComment$annotations() {
        }

        @FieldName(name = "Chat")
        public static /* synthetic */ void getEnableChat$annotations() {
        }

        @FieldName(name = "Danmaku")
        public static /* synthetic */ void getEnableDanmaku$annotations() {
        }

        @FieldName(name = "Digg")
        public static /* synthetic */ void getEnableDigg$annotations() {
        }

        @FieldName(name = "Gift")
        public static /* synthetic */ void getEnableGift$annotations() {
        }

        @FieldName(name = "POI")
        public static /* synthetic */ void getEnablePoi$annotations() {
        }

        @FieldName(name = "UserCard")
        public static /* synthetic */ void getEnableUserCard$annotations() {
        }

        @FieldName(name = "VideoShare")
        public static /* synthetic */ void getEnableVideoShare$annotations() {
        }

        @FieldName(name = "FansClub")
        public static /* synthetic */ void getFansClubAuth$annotations() {
        }

        @FieldName(name = "GamePointsPlaying")
        public static /* synthetic */ void getGamePointsPlaying$annotations() {
        }

        @FieldName(name = "HighlightAreaContainer")
        public static /* synthetic */ void getHighlightAreaContainer$annotations() {
        }

        @FieldName(name = "MoreAnchor")
        public static /* synthetic */ void getMoreAnchor$annotations() {
        }

        @FieldName(name = "MultiplierPlayback")
        public static /* synthetic */ void getMultiplierPlayback$annotations() {
        }

        @FieldName(name = "PadPlay")
        public static /* synthetic */ void getPadPlay$annotations() {
        }

        @FieldName(name = "PCPlay")
        public static /* synthetic */ void getPcPlay$annotations() {
        }

        @FieldName(name = "PlayerRankList")
        public static /* synthetic */ void getPlayerRankList$annotations() {
        }

        @FieldName(name = "Poster")
        public static /* synthetic */ void getPoster$annotations() {
        }

        @FieldName(name = "ProjectionBtn")
        public static /* synthetic */ void getProjectionBtn$annotations() {
        }

        @FieldName(name = "QuizGamePointsPlaying")
        public static /* synthetic */ void getQuizGamePointsPlaying$annotations() {
        }

        @FieldName(name = "RecordScreen")
        public static /* synthetic */ void getRecordScreen$annotations() {
        }

        @FieldName(name = "Share")
        public static /* synthetic */ void getShowShare$annotations() {
        }

        @FieldName(name = "StreamAdaptation")
        public static /* synthetic */ void getStreamAdaptation$annotations() {
        }

        @FieldName(name = "TimedShutdown")
        public static /* synthetic */ void getTimedShutdown$annotations() {
        }

        @FieldName(name = "UgcVSReplayDelete")
        public static /* synthetic */ void getUgcVSReplayDelete$annotations() {
        }

        @FieldName(name = "UgcVsReplayVisibility")
        public static /* synthetic */ void getUgcVsReplayVisibility$annotations() {
        }

        @FieldName(name = "VideoAmplificationType")
        public static /* synthetic */ void getVideoAmplificationType$annotations() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IOffReason;", "Lvh7/c;", "", "getGift", "()Ljava/lang/String;", "getGift$annotations", "()V", PbRequest.SwitchType.GIFT, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IOffReason extends c<IOffReason> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = PbRequest.SwitchType.GIFT)
            public static /* synthetic */ void getGift$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = PbRequest.SwitchType.GIFT)
        String getGift();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IRoomAuthSpecialStyle;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "getChatStyle", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "setChatStyle", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;)V", "getChatStyle$annotations", "()V", "chatStyle", "getShareStyle", "setShareStyle", "getShareStyle$annotations", "shareStyle", "getCastScreenAuth", "setCastScreenAuth", "getCastScreenAuth$annotations", "castScreenAuth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IRoomAuthSpecialStyle extends c<IRoomAuthSpecialStyle> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "CastScreenAuth")
            public static /* synthetic */ void getCastScreenAuth$annotations() {
            }

            @FieldName(name = "Chat")
            public static /* synthetic */ void getChatStyle$annotations() {
            }

            @FieldName(name = "Share")
            public static /* synthetic */ void getShareStyle$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "CastScreenAuth")
        IRoomAuthStatusStyle getCastScreenAuth();

        @FieldName(name = "Chat")
        IRoomAuthStatusStyle getChatStyle();

        @FieldName(name = "Share")
        IRoomAuthStatusStyle getShareStyle();

        @FieldName(name = "CastScreenAuth#setter")
        void setCastScreenAuth(IRoomAuthStatusStyle r100);

        @FieldName(name = "Chat#setter")
        void setChatStyle(IRoomAuthStatusStyle r100);

        @FieldName(name = "Share#setter")
        void setShareStyle(IRoomAuthStatusStyle r100);
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "CastScreen")
    long getCastScreen();

    @FieldName(name = "CastScreenExplicit")
    long getCastScreenExplicit();

    @FieldName(name = "Collect")
    long getCollect();

    @FieldName(name = "CommerceCard")
    long getCommerceCard();

    @FieldName(name = "CommonCard")
    long getCommonCard();

    @FieldName(name = "DanmakuDefault")
    long getDanmakuDefault();

    @FieldName(name = "Denounce")
    long getDenounce();

    @FieldName(name = "Dislike")
    long getDislike();

    @FieldName(name = "DownloadVideo")
    long getDownloadVideo();

    @FieldName(name = "EcomFansClub")
    long getEcomFansClubAuth();

    @FieldName(name = "AdminCommentWall")
    long getEnableAdminPinComment();

    @FieldName(name = "Chat")
    boolean getEnableChat();

    @FieldName(name = "Danmaku")
    boolean getEnableDanmaku();

    @FieldName(name = "Digg")
    boolean getEnableDigg();

    @FieldName(name = "Gift")
    boolean getEnableGift();

    @FieldName(name = "POI")
    boolean getEnablePoi();

    @FieldName(name = "UserCard")
    boolean getEnableUserCard();

    @FieldName(name = "VideoShare")
    long getEnableVideoShare();

    @FieldName(name = "FansClub")
    long getFansClubAuth();

    @FieldName(name = "GamePointsPlaying")
    long getGamePointsPlaying();

    @FieldName(name = "HighlightAreaContainer")
    long getHighlightAreaContainer();

    @FieldName(name = "MoreAnchor")
    long getMoreAnchor();

    @FieldName(name = "MultiplierPlayback")
    long getMultiplierPlayback();

    @FieldName(name = "PadPlay")
    long getPadPlay();

    @FieldName(name = "PCPlay")
    long getPcPlay();

    @FieldName(name = "PlayerRankList")
    long getPlayerRankList();

    @FieldName(name = "Poster")
    long getPoster();

    @FieldName(name = "ProjectionBtn")
    long getProjectionBtn();

    @FieldName(name = "QuizGamePointsPlaying")
    long getQuizGamePointsPlaying();

    @FieldName(name = "RecordScreen")
    long getRecordScreen();

    @FieldName(name = "Share")
    long getShowShare();

    @FieldName(name = "StreamAdaptation")
    long getStreamAdaptation();

    @FieldName(name = "TimedShutdown")
    long getTimedShutdown();

    @FieldName(name = "UgcVSReplayDelete")
    long getUgcVSReplayDelete();

    @FieldName(name = "UgcVsReplayVisibility")
    long getUgcVsReplayVisibility();

    @FieldName(name = "VideoAmplificationType")
    long getVideoAmplificationType();

    @FieldName(name = "CastScreen#setter")
    void setCastScreen(long r100);

    @FieldName(name = "CastScreenExplicit#setter")
    void setCastScreenExplicit(long r100);

    @FieldName(name = "Collect#setter")
    void setCollect(long r100);

    @FieldName(name = "CommerceCard#setter")
    void setCommerceCard(long r100);

    @FieldName(name = "CommonCard#setter")
    void setCommonCard(long r100);

    @FieldName(name = "DanmakuDefault#setter")
    void setDanmakuDefault(long r100);

    @FieldName(name = "Denounce#setter")
    void setDenounce(long r100);

    @FieldName(name = "Dislike#setter")
    void setDislike(long r100);

    @FieldName(name = "DownloadVideo#setter")
    void setDownloadVideo(long r100);

    @FieldName(name = "EcomFansClub#setter")
    void setEcomFansClubAuth(long r100);

    @FieldName(name = "AdminCommentWall#setter")
    void setEnableAdminPinComment(long r100);

    @FieldName(name = "Chat#setter")
    void setEnableChat(boolean r100);

    @FieldName(name = "Danmaku#setter")
    void setEnableDanmaku(boolean r100);

    @FieldName(name = "Digg#setter")
    void setEnableDigg(boolean r100);

    @FieldName(name = "Gift#setter")
    void setEnableGift(boolean r100);

    @FieldName(name = "POI#setter")
    void setEnablePoi(boolean r100);

    @FieldName(name = "UserCard#setter")
    void setEnableUserCard(boolean r100);

    @FieldName(name = "VideoShare#setter")
    void setEnableVideoShare(long r100);

    @FieldName(name = "FansClub#setter")
    void setFansClubAuth(long r100);

    @FieldName(name = "GamePointsPlaying#setter")
    void setGamePointsPlaying(long r100);

    @FieldName(name = "HighlightAreaContainer#setter")
    void setHighlightAreaContainer(long r100);

    @FieldName(name = "MoreAnchor#setter")
    void setMoreAnchor(long r100);

    @FieldName(name = "MultiplierPlayback#setter")
    void setMultiplierPlayback(long r100);

    @FieldName(name = "PadPlay#setter")
    void setPadPlay(long r100);

    @FieldName(name = "PCPlay#setter")
    void setPcPlay(long r100);

    @FieldName(name = "PlayerRankList#setter")
    void setPlayerRankList(long r100);

    @FieldName(name = "Poster#setter")
    void setPoster(long r100);

    @FieldName(name = "ProjectionBtn#setter")
    void setProjectionBtn(long r100);

    @FieldName(name = "QuizGamePointsPlaying#setter")
    void setQuizGamePointsPlaying(long r100);

    @FieldName(name = "RecordScreen#setter")
    void setRecordScreen(long r100);

    @FieldName(name = "Share#setter")
    void setShowShare(long r100);

    @FieldName(name = "StreamAdaptation#setter")
    void setStreamAdaptation(long r100);

    @FieldName(name = "TimedShutdown#setter")
    void setTimedShutdown(long r100);

    @FieldName(name = "UgcVSReplayDelete#setter")
    void setUgcVSReplayDelete(long r100);

    @FieldName(name = "UgcVsReplayVisibility#setter")
    void setUgcVsReplayVisibility(long r100);

    @FieldName(name = "VideoAmplificationType#setter")
    void setVideoAmplificationType(long r100);
}
