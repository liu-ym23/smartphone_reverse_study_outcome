package com.bytedance.android.live.ai.api.model;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u0081\u0001\b\u0087\b\u0018\u00002\u00020\u0001B±\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005¢\u0006\u0002\u0010#J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J\t\u0010i\u001a\u00020\u0007HÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0007HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0005HÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0007HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0007HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0007HÆ\u0003J¶\u0002\u0010\u0083\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005HÆ\u0001J\u0015\u0010\u0084\u0001\u001a\u00020\u00032\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010%\"\u0004\b;\u0010'R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010B\"\u0004\bC\u0010DR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u00101R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010/\"\u0004\bJ\u00101R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010/\"\u0004\bN\u00101R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010/\"\u0004\bP\u00101R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010/\"\u0004\bR\u00101R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010/\"\u0004\bT\u00101R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010/\"\u0004\bV\u00101R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010/\"\u0004\bX\u00101R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010/\"\u0004\b\\\u00101R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010%\"\u0004\b^\u0010'R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010%\"\u0004\bb\u0010'R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010%\"\u0004\bd\u0010'¨\u0006\u0088\u0001"}, d2 = {"Lcom/bytedance/android/live/ai/api/model/RechargeCurrentCacheData;", "", "isFollowed", "", "curMoneyPaid", "", "eventModuleCode", "", "liveTypeCode", "payMethodCode", "anchorTypeCode", "chargeSceneCode", "chargeReasonCode", "interactFunctionCode", "requestPageCode", "roomLayoutCode", "streamingTypeCode", "enterFromMergeCode", "enterMethodCode", "actionTypeCode", "livesdkCommentScreenMessageMonitor", "livesdkGiftEffectShow", "livesdkRedPackageShow", "livesdkAudienceLiveMessage", "livesdkSendGift", "livesdkRechargeClick", "livesdkRechargeShow", "livesdkRechargeSuccess", "livesdkRechargeCustomizedNext", "livesdkLike", "livesdkRechargeBannerClick", "curWatchDuration", "curRankDuration", "curSentGiftMoney", "curSentGiftCnt", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIIIIIIIII)V", "getActionTypeCode", "()Ljava/lang/String;", "setActionTypeCode", "(Ljava/lang/String;)V", "getAnchorTypeCode", "setAnchorTypeCode", "getChargeReasonCode", "setChargeReasonCode", "getChargeSceneCode", "setChargeSceneCode", "getCurMoneyPaid", "()I", "setCurMoneyPaid", "(I)V", "getCurRankDuration", "setCurRankDuration", "getCurSentGiftCnt", "setCurSentGiftCnt", "getCurSentGiftMoney", "setCurSentGiftMoney", "getCurWatchDuration", "setCurWatchDuration", "getEnterFromMergeCode", "setEnterFromMergeCode", "getEnterMethodCode", "setEnterMethodCode", "getEventModuleCode", "setEventModuleCode", "getInteractFunctionCode", "setInteractFunctionCode", "()Z", "setFollowed", "(Z)V", "getLiveTypeCode", "setLiveTypeCode", "getLivesdkAudienceLiveMessage", "setLivesdkAudienceLiveMessage", "getLivesdkCommentScreenMessageMonitor", "setLivesdkCommentScreenMessageMonitor", "getLivesdkGiftEffectShow", "setLivesdkGiftEffectShow", "getLivesdkLike", "setLivesdkLike", "getLivesdkRechargeBannerClick", "setLivesdkRechargeBannerClick", "getLivesdkRechargeClick", "setLivesdkRechargeClick", "getLivesdkRechargeCustomizedNext", "setLivesdkRechargeCustomizedNext", "getLivesdkRechargeShow", "setLivesdkRechargeShow", "getLivesdkRechargeSuccess", "setLivesdkRechargeSuccess", "getLivesdkRedPackageShow", "setLivesdkRedPackageShow", "getLivesdkSendGift", "setLivesdkSendGift", "getPayMethodCode", "setPayMethodCode", "getRequestPageCode", "setRequestPageCode", "getRoomLayoutCode", "setRoomLayoutCode", "getStreamingTypeCode", "setStreamingTypeCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCurrentCacheData {
    private String actionTypeCode;
    private String anchorTypeCode;
    private String chargeReasonCode;
    private String chargeSceneCode;
    private int curMoneyPaid;
    private int curRankDuration;
    private int curSentGiftCnt;
    private int curSentGiftMoney;
    private int curWatchDuration;
    private String enterFromMergeCode;
    private String enterMethodCode;
    private String eventModuleCode;
    private String interactFunctionCode;
    private boolean isFollowed;
    private String liveTypeCode;
    private int livesdkAudienceLiveMessage;
    private int livesdkCommentScreenMessageMonitor;
    private int livesdkGiftEffectShow;
    private int livesdkLike;
    private int livesdkRechargeBannerClick;
    private int livesdkRechargeClick;
    private int livesdkRechargeCustomizedNext;
    private int livesdkRechargeShow;
    private int livesdkRechargeSuccess;
    private int livesdkRedPackageShow;
    private int livesdkSendGift;
    private String payMethodCode;
    private String requestPageCode;
    private String roomLayoutCode;
    private String streamingTypeCode;

    public RechargeCurrentCacheData() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1073741823, null);
    }

    public static /* synthetic */ RechargeCurrentCacheData copy$default(RechargeCurrentCacheData r110, boolean r111, int r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, int r313, int r314, int r315, int r316, int r317, int r318, int r319, int r410, int r411, int r412, int r413, int r414, int r415, int r416, int r417, int r418, Object r419) {
        if ((r418 & 1) == 0) goto L5;
        boolean r100 = r110.isFollowed;
    L7:
        if ((r418 & 2) == 0) goto L9;
        int r101 = r110.curMoneyPaid;
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r102 = r110.eventModuleCode;
    L15:
        if ((r418 & 8) == 0) goto L17;
        String r103 = r110.liveTypeCode;
    L19:
        if ((r418 & 16) == 0) goto L21;
        String r104 = r110.payMethodCode;
    L23:
        if ((r418 & 32) == 0) goto L25;
        String r105 = r110.anchorTypeCode;
    L27:
        if ((r418 & 64) == 0) goto L29;
        String r106 = r110.chargeSceneCode;
    L31:
        if ((r418 & 128) == 0) goto L33;
        String r107 = r110.chargeReasonCode;
    L35:
        if ((r418 & 256) == 0) goto L37;
        String r113 = r110.interactFunctionCode;
    L39:
        if ((r418 & 512) == 0) goto L41;
        String r114 = r110.requestPageCode;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        String r115 = r110.roomLayoutCode;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        String r116 = r110.streamingTypeCode;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        String r117 = r110.enterFromMergeCode;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        String r118 = r110.enterMethodCode;
    L58:
        String r320 = r118;
        if ((r418 & 16384) == 0) goto L61;
        String r119 = r110.actionTypeCode;
    L62:
        String r321 = r119;
        if ((r418 & 32768) == 0) goto L65;
        int r120 = r110.livesdkCommentScreenMessageMonitor;
    L66:
        int r322 = r120;
        if ((r418 & 65536) == 0) goto L69;
        int r121 = r110.livesdkGiftEffectShow;
    L70:
        int r323 = r121;
        if ((r418 & 131072) == 0) goto L73;
        int r122 = r110.livesdkRedPackageShow;
    L74:
        int r324 = r122;
        if ((r418 & 262144) == 0) goto L77;
        int r123 = r110.livesdkAudienceLiveMessage;
    L78:
        int r325 = r123;
        if ((r418 & 524288) == 0) goto L81;
        int r124 = r110.livesdkSendGift;
    L82:
        int r326 = r124;
        if ((r418 & 1048576) == 0) goto L85;
        int r125 = r110.livesdkRechargeClick;
    L86:
        int r327 = r125;
        if ((r418 & 2097152) == 0) goto L89;
        int r126 = r110.livesdkRechargeShow;
    L90:
        int r328 = r126;
        if ((r418 & 4194304) == 0) goto L93;
        int r127 = r110.livesdkRechargeSuccess;
    L94:
        int r420 = r127;
        if ((r418 & 8388608) == 0) goto L97;
        int r128 = r110.livesdkRechargeCustomizedNext;
    L98:
        int r421 = r128;
        if ((r418 & 16777216) == 0) goto L101;
        int r129 = r110.livesdkLike;
    L102:
        int r422 = r129;
        if ((r418 & 33554432) == 0) goto L105;
        int r130 = r110.livesdkRechargeBannerClick;
    L106:
        int r423 = r130;
        if ((r418 & 67108864) == 0) goto L109;
        int r131 = r110.curWatchDuration;
    L110:
        int r424 = r131;
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r132 = r110.curRankDuration;
    L114:
        int r425 = r132;
        if ((r418 & 268435456) == 0) goto L117;
        int r133 = r110.curSentGiftMoney;
    L119:
        if ((r418 & 536870912) == 0) goto L121;
        int r108 = r110.curSentGiftCnt;
    L123:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r133, r108);
    L121:
        r108 = r417;
        goto L123
    L117:
        r133 = r416;
        goto L119
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.isFollowed;
    }

    public final String component10() {
        return this.requestPageCode;
    }

    public final String component11() {
        return this.roomLayoutCode;
    }

    public final String component12() {
        return this.streamingTypeCode;
    }

    public final String component13() {
        return this.enterFromMergeCode;
    }

    public final String component14() {
        return this.enterMethodCode;
    }

    public final String component15() {
        return this.actionTypeCode;
    }

    public final int component16() {
        return this.livesdkCommentScreenMessageMonitor;
    }

    public final int component17() {
        return this.livesdkGiftEffectShow;
    }

    public final int component18() {
        return this.livesdkRedPackageShow;
    }

    public final int component19() {
        return this.livesdkAudienceLiveMessage;
    }

    public final int component2() {
        return this.curMoneyPaid;
    }

    public final int component20() {
        return this.livesdkSendGift;
    }

    public final int component21() {
        return this.livesdkRechargeClick;
    }

    public final int component22() {
        return this.livesdkRechargeShow;
    }

    public final int component23() {
        return this.livesdkRechargeSuccess;
    }

    public final int component24() {
        return this.livesdkRechargeCustomizedNext;
    }

    public final int component25() {
        return this.livesdkLike;
    }

    public final int component26() {
        return this.livesdkRechargeBannerClick;
    }

    public final int component27() {
        return this.curWatchDuration;
    }

    public final int component28() {
        return this.curRankDuration;
    }

    public final int component29() {
        return this.curSentGiftMoney;
    }

    public final String component3() {
        return this.eventModuleCode;
    }

    public final int component30() {
        return this.curSentGiftCnt;
    }

    public final String component4() {
        return this.liveTypeCode;
    }

    public final String component5() {
        return this.payMethodCode;
    }

    public final String component6() {
        return this.anchorTypeCode;
    }

    public final String component7() {
        return this.chargeSceneCode;
    }

    public final String component8() {
        return this.chargeReasonCode;
    }

    public final String component9() {
        return this.interactFunctionCode;
    }

    public final RechargeCurrentCacheData copy(boolean r310, int r311, String r312, String r313, String r314, String r315, String r316, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, int r418, int r419, int r510, int r511, int r512, int r513, int r514, int r515, int r516, int r517, int r518, int r519, int r610, int r611, int r612) {
        Intrinsics.checkNotNullParameter(r312, "eventModuleCode");
        Intrinsics.checkNotNullParameter(r313, "liveTypeCode");
        Intrinsics.checkNotNullParameter(r314, "payMethodCode");
        Intrinsics.checkNotNullParameter(r315, "anchorTypeCode");
        Intrinsics.checkNotNullParameter(r316, "chargeSceneCode");
        Intrinsics.checkNotNullParameter(r410, "chargeReasonCode");
        Intrinsics.checkNotNullParameter(r411, "interactFunctionCode");
        Intrinsics.checkNotNullParameter(r412, "requestPageCode");
        Intrinsics.checkNotNullParameter(r413, "roomLayoutCode");
        Intrinsics.checkNotNullParameter(r414, "streamingTypeCode");
        Intrinsics.checkNotNullParameter(r415, "enterFromMergeCode");
        Intrinsics.checkNotNullParameter(r416, "enterMethodCode");
        Intrinsics.checkNotNullParameter(r417, "actionTypeCode");
        return new RechargeCurrentCacheData(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RechargeCurrentCacheData) == false) goto L66;
        RechargeCurrentCacheData r101 = (RechargeCurrentCacheData) r100;
        if (this.isFollowed == r101.isFollowed) goto L8;
        return false;
    L8:
        if (this.curMoneyPaid == r101.curMoneyPaid) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventModuleCode, r101.eventModuleCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveTypeCode, r101.liveTypeCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.payMethodCode, r101.payMethodCode) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.anchorTypeCode, r101.anchorTypeCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chargeSceneCode, r101.chargeSceneCode) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.chargeReasonCode, r101.chargeReasonCode) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.interactFunctionCode, r101.interactFunctionCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestPageCode, r101.requestPageCode) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.roomLayoutCode, r101.roomLayoutCode) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.streamingTypeCode, r101.streamingTypeCode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enterFromMergeCode, r101.enterFromMergeCode) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.enterMethodCode, r101.enterMethodCode) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.actionTypeCode, r101.actionTypeCode) == true) goto L36;
        return false;
    L36:
        if (this.livesdkCommentScreenMessageMonitor == r101.livesdkCommentScreenMessageMonitor) goto L38;
        return false;
    L38:
        if (this.livesdkGiftEffectShow == r101.livesdkGiftEffectShow) goto L40;
        return false;
    L40:
        if (this.livesdkRedPackageShow == r101.livesdkRedPackageShow) goto L42;
        return false;
    L42:
        if (this.livesdkAudienceLiveMessage == r101.livesdkAudienceLiveMessage) goto L44;
        return false;
    L44:
        if (this.livesdkSendGift == r101.livesdkSendGift) goto L46;
        return false;
    L46:
        if (this.livesdkRechargeClick == r101.livesdkRechargeClick) goto L48;
        return false;
    L48:
        if (this.livesdkRechargeShow == r101.livesdkRechargeShow) goto L50;
        return false;
    L50:
        if (this.livesdkRechargeSuccess == r101.livesdkRechargeSuccess) goto L52;
        return false;
    L52:
        if (this.livesdkRechargeCustomizedNext == r101.livesdkRechargeCustomizedNext) goto L54;
        return false;
    L54:
        if (this.livesdkLike == r101.livesdkLike) goto L56;
        return false;
    L56:
        if (this.livesdkRechargeBannerClick == r101.livesdkRechargeBannerClick) goto L58;
        return false;
    L58:
        if (this.curWatchDuration == r101.curWatchDuration) goto L60;
        return false;
    L60:
        if (this.curRankDuration == r101.curRankDuration) goto L62;
        return false;
    L62:
        if (this.curSentGiftMoney == r101.curSentGiftMoney) goto L64;
        return false;
    L64:
        if (this.curSentGiftCnt == r101.curSentGiftCnt) goto L100;
        return false;
    L100:
        return true;
    L66:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    public int hashCode() {
        boolean r100 = this.isFollowed;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.curMoneyPaid) * 31;
        String r103 = this.eventModuleCode;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.liveTypeCode;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.payMethodCode;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.anchorTypeCode;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.chargeSceneCode;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.chargeReasonCode;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.interactFunctionCode;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.requestPageCode;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.roomLayoutCode;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.streamingTypeCode;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.enterFromMergeCode;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.enterMethodCode;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        String r140 = this.actionTypeCode;
        if (r140 == null) goto L57;
        r104 = r140.hashCode();
    L57:
        return ((((((((((((((((((((((((((((((r139 + r104) * 31) + this.livesdkCommentScreenMessageMonitor) * 31) + this.livesdkGiftEffectShow) * 31) + this.livesdkRedPackageShow) * 31) + this.livesdkAudienceLiveMessage) * 31) + this.livesdkSendGift) * 31) + this.livesdkRechargeClick) * 31) + this.livesdkRechargeShow) * 31) + this.livesdkRechargeSuccess) * 31) + this.livesdkRechargeCustomizedNext) * 31) + this.livesdkLike) * 31) + this.livesdkRechargeBannerClick) * 31) + this.curWatchDuration) * 31) + this.curRankDuration) * 31) + this.curSentGiftMoney) * 31) + this.curSentGiftCnt;
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "RechargeCurrentCacheData(isFollowed=" + this.isFollowed + ", curMoneyPaid=" + this.curMoneyPaid + ", eventModuleCode=" + this.eventModuleCode + ", liveTypeCode=" + this.liveTypeCode + ", payMethodCode=" + this.payMethodCode + ", anchorTypeCode=" + this.anchorTypeCode + ", chargeSceneCode=" + this.chargeSceneCode + ", chargeReasonCode=" + this.chargeReasonCode + ", interactFunctionCode=" + this.interactFunctionCode + ", requestPageCode=" + this.requestPageCode + ", roomLayoutCode=" + this.roomLayoutCode + ", streamingTypeCode=" + this.streamingTypeCode + ", enterFromMergeCode=" + this.enterFromMergeCode + ", enterMethodCode=" + this.enterMethodCode + ", actionTypeCode=" + this.actionTypeCode + ", livesdkCommentScreenMessageMonitor=" + this.livesdkCommentScreenMessageMonitor + ", livesdkGiftEffectShow=" + this.livesdkGiftEffectShow + ", livesdkRedPackageShow=" + this.livesdkRedPackageShow + ", livesdkAudienceLiveMessage=" + this.livesdkAudienceLiveMessage + ", livesdkSendGift=" + this.livesdkSendGift + ", livesdkRechargeClick=" + this.livesdkRechargeClick + ", livesdkRechargeShow=" + this.livesdkRechargeShow + ", livesdkRechargeSuccess=" + this.livesdkRechargeSuccess + ", livesdkRechargeCustomizedNext=" + this.livesdkRechargeCustomizedNext + ", livesdkLike=" + this.livesdkLike + ", livesdkRechargeBannerClick=" + this.livesdkRechargeBannerClick + ", curWatchDuration=" + this.curWatchDuration + ", curRankDuration=" + this.curRankDuration + ", curSentGiftMoney=" + this.curSentGiftMoney + ", curSentGiftCnt=" + this.curSentGiftCnt + ")";
    }

    public final String getActionTypeCode() {
        return this.actionTypeCode;
    }

    public final String getAnchorTypeCode() {
        return this.anchorTypeCode;
    }

    public final String getChargeReasonCode() {
        return this.chargeReasonCode;
    }

    public final String getChargeSceneCode() {
        return this.chargeSceneCode;
    }

    public final int getCurMoneyPaid() {
        return this.curMoneyPaid;
    }

    public final int getCurRankDuration() {
        return this.curRankDuration;
    }

    public final int getCurSentGiftCnt() {
        return this.curSentGiftCnt;
    }

    public final int getCurSentGiftMoney() {
        return this.curSentGiftMoney;
    }

    public final int getCurWatchDuration() {
        return this.curWatchDuration;
    }

    public final String getEnterFromMergeCode() {
        return this.enterFromMergeCode;
    }

    public final String getEnterMethodCode() {
        return this.enterMethodCode;
    }

    public final String getEventModuleCode() {
        return this.eventModuleCode;
    }

    public final String getInteractFunctionCode() {
        return this.interactFunctionCode;
    }

    public final String getLiveTypeCode() {
        return this.liveTypeCode;
    }

    public final int getLivesdkAudienceLiveMessage() {
        return this.livesdkAudienceLiveMessage;
    }

    public final int getLivesdkCommentScreenMessageMonitor() {
        return this.livesdkCommentScreenMessageMonitor;
    }

    public final int getLivesdkGiftEffectShow() {
        return this.livesdkGiftEffectShow;
    }

    public final int getLivesdkLike() {
        return this.livesdkLike;
    }

    public final int getLivesdkRechargeBannerClick() {
        return this.livesdkRechargeBannerClick;
    }

    public final int getLivesdkRechargeClick() {
        return this.livesdkRechargeClick;
    }

    public final int getLivesdkRechargeCustomizedNext() {
        return this.livesdkRechargeCustomizedNext;
    }

    public final int getLivesdkRechargeShow() {
        return this.livesdkRechargeShow;
    }

    public final int getLivesdkRechargeSuccess() {
        return this.livesdkRechargeSuccess;
    }

    public final int getLivesdkRedPackageShow() {
        return this.livesdkRedPackageShow;
    }

    public final int getLivesdkSendGift() {
        return this.livesdkSendGift;
    }

    public final String getPayMethodCode() {
        return this.payMethodCode;
    }

    public final String getRequestPageCode() {
        return this.requestPageCode;
    }

    public final String getRoomLayoutCode() {
        return this.roomLayoutCode;
    }

    public final String getStreamingTypeCode() {
        return this.streamingTypeCode;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }

    public final void setActionTypeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionTypeCode = r100;
    }

    public final void setAnchorTypeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorTypeCode = r100;
    }

    public final void setChargeReasonCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chargeReasonCode = r100;
    }

    public final void setChargeSceneCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chargeSceneCode = r100;
    }

    public final void setCurMoneyPaid(int r100) {
        this.curMoneyPaid = r100;
    }

    public final void setCurRankDuration(int r100) {
        this.curRankDuration = r100;
    }

    public final void setCurSentGiftCnt(int r100) {
        this.curSentGiftCnt = r100;
    }

    public final void setCurSentGiftMoney(int r100) {
        this.curSentGiftMoney = r100;
    }

    public final void setCurWatchDuration(int r100) {
        this.curWatchDuration = r100;
    }

    public final void setEnterFromMergeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMergeCode = r100;
    }

    public final void setEnterMethodCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethodCode = r100;
    }

    public final void setEventModuleCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventModuleCode = r100;
    }

    public final void setFollowed(boolean r100) {
        this.isFollowed = r100;
    }

    public final void setInteractFunctionCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interactFunctionCode = r100;
    }

    public final void setLiveTypeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveTypeCode = r100;
    }

    public final void setLivesdkAudienceLiveMessage(int r100) {
        this.livesdkAudienceLiveMessage = r100;
    }

    public final void setLivesdkCommentScreenMessageMonitor(int r100) {
        this.livesdkCommentScreenMessageMonitor = r100;
    }

    public final void setLivesdkGiftEffectShow(int r100) {
        this.livesdkGiftEffectShow = r100;
    }

    public final void setLivesdkLike(int r100) {
        this.livesdkLike = r100;
    }

    public final void setLivesdkRechargeBannerClick(int r100) {
        this.livesdkRechargeBannerClick = r100;
    }

    public final void setLivesdkRechargeClick(int r100) {
        this.livesdkRechargeClick = r100;
    }

    public final void setLivesdkRechargeCustomizedNext(int r100) {
        this.livesdkRechargeCustomizedNext = r100;
    }

    public final void setLivesdkRechargeShow(int r100) {
        this.livesdkRechargeShow = r100;
    }

    public final void setLivesdkRechargeSuccess(int r100) {
        this.livesdkRechargeSuccess = r100;
    }

    public final void setLivesdkRedPackageShow(int r100) {
        this.livesdkRedPackageShow = r100;
    }

    public final void setLivesdkSendGift(int r100) {
        this.livesdkSendGift = r100;
    }

    public final void setPayMethodCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.payMethodCode = r100;
    }

    public final void setRequestPageCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestPageCode = r100;
    }

    public final void setRoomLayoutCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomLayoutCode = r100;
    }

    public final void setStreamingTypeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamingTypeCode = r100;
    }

    public RechargeCurrentCacheData(boolean r110, int r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, int r319, int r410, int r411, int r412, int r413, int r414, int r415) {
        Intrinsics.checkNotNullParameter(r112, "eventModuleCode");
        Intrinsics.checkNotNullParameter(r113, "liveTypeCode");
        Intrinsics.checkNotNullParameter(r210, "payMethodCode");
        Intrinsics.checkNotNullParameter(r211, "anchorTypeCode");
        Intrinsics.checkNotNullParameter(r212, "chargeSceneCode");
        Intrinsics.checkNotNullParameter(r213, "chargeReasonCode");
        Intrinsics.checkNotNullParameter(r214, "interactFunctionCode");
        Intrinsics.checkNotNullParameter(r215, "requestPageCode");
        Intrinsics.checkNotNullParameter(r216, "roomLayoutCode");
        Intrinsics.checkNotNullParameter(r217, "streamingTypeCode");
        Intrinsics.checkNotNullParameter(r218, "enterFromMergeCode");
        Intrinsics.checkNotNullParameter(r219, "enterMethodCode");
        Intrinsics.checkNotNullParameter(r310, "actionTypeCode");
        this.isFollowed = r110;
        this.curMoneyPaid = r111;
        this.eventModuleCode = r112;
        this.liveTypeCode = r113;
        this.payMethodCode = r210;
        this.anchorTypeCode = r211;
        this.chargeSceneCode = r212;
        this.chargeReasonCode = r213;
        this.interactFunctionCode = r214;
        this.requestPageCode = r215;
        this.roomLayoutCode = r216;
        this.streamingTypeCode = r217;
        this.enterFromMergeCode = r218;
        this.enterMethodCode = r219;
        this.actionTypeCode = r310;
        this.livesdkCommentScreenMessageMonitor = r311;
        this.livesdkGiftEffectShow = r312;
        this.livesdkRedPackageShow = r313;
        this.livesdkAudienceLiveMessage = r314;
        this.livesdkSendGift = r315;
        this.livesdkRechargeClick = r316;
        this.livesdkRechargeShow = r317;
        this.livesdkRechargeSuccess = r318;
        this.livesdkRechargeCustomizedNext = r319;
        this.livesdkLike = r410;
        this.livesdkRechargeBannerClick = r411;
        this.curWatchDuration = r412;
        this.curRankDuration = r413;
        this.curSentGiftMoney = r414;
        this.curSentGiftCnt = r415;
    }

    public /* synthetic */ RechargeCurrentCacheData(boolean r310, int r311, String r312, String r313, String r314, String r315, String r316, String r317, String r410, String r411, String r412, String r413, String r414, String r415, String r416, int r417, int r418, int r419, int r510, int r511, int r512, int r513, int r514, int r515, int r516, int r517, int r518, int r519, int r610, int r611, int r612, DefaultConstructorMarker r613) {
        if ((r612 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r612 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r612 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r612 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r612 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r612 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r612 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r612 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r612 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r612 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r612 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r612 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r612 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r612 & 8192) == 0) goto L57;
        String r107 = "";
    L59:
        if ((r612 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r612 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r612 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r612 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r612 & 262144) == 0) goto L77;
        int r119 = 0;
    L79:
        if ((r612 & 524288) == 0) goto L81;
        int r210 = 0;
    L83:
        if ((r612 & 1048576) == 0) goto L85;
        int r211 = 0;
    L87:
        if ((r612 & 2097152) == 0) goto L89;
        int r212 = 0;
    L91:
        if ((r612 & 4194304) == 0) goto L93;
        int r213 = 0;
    L95:
        if ((r612 & 8388608) == 0) goto L97;
        int r214 = 0;
    L99:
        if ((r612 & 16777216) == 0) goto L101;
        int r215 = 0;
    L103:
        if ((r612 & 33554432) == 0) goto L105;
        int r216 = 0;
    L107:
        if ((r612 & 67108864) == 0) goto L109;
        int r217 = 0;
    L111:
        if ((r612 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r218 = 0;
    L115:
        if ((r612 & 268435456) == 0) goto L117;
        int r219 = 0;
    L119:
        if ((r612 & 536870912) == 0) goto L121;
        int r109 = 0;
    L122:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r109);
        return;
    L121:
        r109 = r611;
        goto L122
    L117:
        r219 = r610;
        goto L119
    L113:
        r218 = r519;
        goto L115
    L109:
        r217 = r518;
        goto L111
    L105:
        r216 = r517;
        goto L107
    L101:
        r215 = r516;
        goto L103
    L97:
        r214 = r515;
        goto L99
    L93:
        r213 = r514;
        goto L95
    L89:
        r212 = r513;
        goto L91
    L85:
        r211 = r512;
        goto L87
    L81:
        r210 = r511;
        goto L83
    L77:
        r119 = r510;
        goto L79
    L73:
        r118 = r419;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r108 = r416;
        goto L63
    L57:
        r107 = r415;
        goto L59
    L53:
        r115 = r414;
        goto L55
    L49:
        r114 = r413;
        goto L51
    L45:
        r113 = r412;
        goto L47
    L41:
        r112 = r411;
        goto L43
    L37:
        r111 = r410;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
