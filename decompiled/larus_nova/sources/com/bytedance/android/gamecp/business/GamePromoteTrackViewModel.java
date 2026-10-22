package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.BaseGamePromoteDetailViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u008a\u0001B\t¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR$\u00103\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR$\u0010?\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010A\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR$\u0010G\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR$\u0010J\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000b\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR$\u0010M\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR$\u0010P\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000b\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000fR$\u0010R\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\r\"\u0004\bT\u0010\u000fR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR$\u0010X\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u000b\u001a\u0004\bY\u0010\r\"\u0004\bZ\u0010\u000fR$\u0010[\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u000b\u001a\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000fR$\u0010^\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010\u000b\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR$\u0010a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\u000b\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000fR$\u0010d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010\u000b\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000fR$\u0010g\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR$\u0010j\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010\u000b\u001a\u0004\bk\u0010\r\"\u0004\bl\u0010\u000fR$\u0010m\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010\u000b\u001a\u0004\bn\u0010\r\"\u0004\bo\u0010\u000fR$\u0010p\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010\u000b\u001a\u0004\bq\u0010\r\"\u0004\br\u0010\u000fR\"\u0010s\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010\u000b\u001a\u0004\bt\u0010\r\"\u0004\bu\u0010\u000fR\"\u0010v\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010\u000b\u001a\u0004\bw\u0010\r\"\u0004\bx\u0010\u000fR\"\u0010y\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\u000b\u001a\u0004\bz\u0010\r\"\u0004\b{\u0010\u000fR\"\u0010|\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010\u000b\u001a\u0004\b}\u0010\r\"\u0004\b~\u0010\u000fRJ\u0010\u0081\u0001\u001a#\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u007fj\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/android/gamecp/business/GamePromoteTrackViewModel;", "Lcom/bytedance/android/gamecp/business/gamedetail/legacy/viewmodel/BaseGamePromoteDetailViewModel;", "", "fragmentHashCode", "I", "getFragmentHashCode", "()I", "setFragmentHashCode", "(I)V", "", "promoteId", "Ljava/lang/String;", "getPromoteId", "()Ljava/lang/String;", "setPromoteId", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "gameName", "getGameName", "setGameName", "enterFrom", "getEnterFrom", "setEnterFrom", "videoEnterFromMerge", "getVideoEnterFromMerge", "setVideoEnterFromMerge", "logPb", "getLogPb", "setLogPb", "requestId", "getRequestId", "setRequestId", "videoId", "getVideoId", "setVideoId", "roomId", "getRoomId", "setRoomId", "enterMethod", "getEnterMethod", "setEnterMethod", "entranceFrom", "getEntranceFrom", "setEntranceFrom", "adPlanId", "getAdPlanId", "setAdPlanId", "isFromAd", "setFromAd", "anchorId", "getAnchorId", "setAnchorId", "", "isAnchor", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAnchor", "(Ljava/lang/Boolean;)V", "scene", "getScene", "setScene", "isAds", "setAds", "adId", "getAdId", "setAdId", "adSourceType", "getAdSourceType", "setAdSourceType", "stockType", "getStockType", "setStockType", "originalSystemOrigin", "getOriginalSystemOrigin", "setOriginalSystemOrigin", "ifDou", "getIfDou", "setIfDou", "isOtherChannel", "setOtherChannel", "adLogExtra", "getAdLogExtra", "setAdLogExtra", "adValue", "getAdValue", "setAdValue", "shootWay", "getShootWay", "setShootWay", "creationId", "getCreationId", "setCreationId", "officialEnterFrom", "getOfficialEnterFrom", "setOfficialEnterFrom", "promoteSceneSub", "getPromoteSceneSub", "setPromoteSceneSub", "gcLaunchFrom", "getGcLaunchFrom", "setGcLaunchFrom", "gcLocation", "getGcLocation", "setGcLocation", "gcScene", "getGcScene", "setGcScene", "gcEnterDirectly", "getGcEnterDirectly", "setGcEnterDirectly", "attributionId", "getAttributionId", "setAttributionId", "adGroupId", "getAdGroupId", "setAdGroupId", "adAuthorId", "getAdAuthorId", "setAdAuthorId", "adAnchorId", "getAdAnchorId", "setAdAnchorId", "adAnchorType", "getAdAnchorType", "setAdAnchorType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportParams", "Ljava/util/HashMap;", "getReportParams", "()Ljava/util/HashMap;", "setReportParams", "(Ljava/util/HashMap;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteTrackViewModel extends BaseGamePromoteDetailViewModel {
    public static final a Companion = null;
    public static final String TAG = "GamePromoteTrackViewModel";
    private String adAnchorId;
    private String adAnchorType;
    private String adAuthorId;
    private String adGroupId;
    private String adId;
    private String adLogExtra;
    private String adPlanId;
    private String adSourceType;
    private String adValue;
    private String anchorId;
    private String attributionId;
    private String creationId;
    private String enterFrom;
    private String enterMethod;
    private String entranceFrom;
    private int fragmentHashCode;
    private String gameId;
    private String gameName;
    private String gcEnterDirectly;
    private String gcLaunchFrom;
    private String gcLocation;
    private String gcScene;
    private String ifDou;
    private String isAds;
    private Boolean isAnchor;
    private String isFromAd;
    private String isOtherChannel;
    private String logPb;
    private String officialEnterFrom;
    private String originalSystemOrigin;
    private String promoteId;
    private String promoteSceneSub;
    private HashMap<String, String> reportParams;
    private String requestId;
    private String roomId;
    private int scene;
    private String shootWay;
    private String stockType;
    private String videoEnterFromMerge;
    private String videoId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GamePromoteTrackViewModel() {
        bw.p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100 == null) goto L9;
        hw.b r101 = r100.user();
        if (r101 == null) goto L9;
        String r102 = r101.getCurrentUserId();
        if (r102 == null) goto L9;
    L10:
        this.promoteId = r102;
        this.gameId = "";
        this.gameName = "";
        this.enterFrom = "";
        this.videoEnterFromMerge = "";
        this.logPb = "";
        this.requestId = "";
        this.videoId = "";
        this.roomId = "";
        this.enterMethod = AdDownloadEventConfig.JsonKey.CLICK_LABEL;
        this.entranceFrom = "video_anchor";
        this.adPlanId = "";
        this.isFromAd = "";
        this.anchorId = "";
        this.isAnchor = Boolean.FALSE;
        this.isAds = "";
        this.adId = "";
        this.adSourceType = "0";
        this.stockType = "0";
        this.originalSystemOrigin = "0";
        this.ifDou = "0";
        this.isOtherChannel = "";
        this.adLogExtra = "";
        this.adValue = "";
        this.gcEnterDirectly = "0";
        this.attributionId = "";
        this.adGroupId = "";
        this.adAuthorId = "";
        this.adAnchorId = "";
        this.adAnchorType = "";
        return;
    L9:
        r102 = null;
        goto L10
    }

    public final String getAdAnchorId() {
        return this.adAnchorId;
    }

    public final String getAdAnchorType() {
        return this.adAnchorType;
    }

    public final String getAdAuthorId() {
        return this.adAuthorId;
    }

    public final String getAdGroupId() {
        return this.adGroupId;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAdPlanId() {
        return this.adPlanId;
    }

    public final String getAdSourceType() {
        return this.adSourceType;
    }

    public final String getAdValue() {
        return this.adValue;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceFrom() {
        return this.entranceFrom;
    }

    public final int getFragmentHashCode() {
        return this.fragmentHashCode;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGcEnterDirectly() {
        return this.gcEnterDirectly;
    }

    public final String getGcLaunchFrom() {
        return this.gcLaunchFrom;
    }

    public final String getGcLocation() {
        return this.gcLocation;
    }

    public final String getGcScene() {
        return this.gcScene;
    }

    public final String getIfDou() {
        return this.ifDou;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final String getOfficialEnterFrom() {
        return this.officialEnterFrom;
    }

    public final String getOriginalSystemOrigin() {
        return this.originalSystemOrigin;
    }

    public final String getPromoteId() {
        return this.promoteId;
    }

    public final String getPromoteSceneSub() {
        return this.promoteSceneSub;
    }

    public final HashMap<String, String> getReportParams() {
        return this.reportParams;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final int getScene() {
        return this.scene;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final String getStockType() {
        return this.stockType;
    }

    public final String getVideoEnterFromMerge() {
        return this.videoEnterFromMerge;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String isAds() {
        return this.isAds;
    }

    public final Boolean isAnchor() {
        return this.isAnchor;
    }

    public final String isFromAd() {
        return this.isFromAd;
    }

    public final String isOtherChannel() {
        return this.isOtherChannel;
    }

    public final void setAdAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adAnchorId = r100;
    }

    public final void setAdAnchorType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adAnchorType = r100;
    }

    public final void setAdAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adAuthorId = r100;
    }

    public final void setAdGroupId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adGroupId = r100;
    }

    public final void setAdId(String r100) {
        this.adId = r100;
    }

    public final void setAdLogExtra(String r100) {
        this.adLogExtra = r100;
    }

    public final void setAdPlanId(String r100) {
        this.adPlanId = r100;
    }

    public final void setAdSourceType(String r100) {
        this.adSourceType = r100;
    }

    public final void setAdValue(String r100) {
        this.adValue = r100;
    }

    public final void setAds(String r100) {
        this.isAds = r100;
    }

    public final void setAnchor(Boolean r100) {
        this.isAnchor = r100;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setAttributionId(String r100) {
        this.attributionId = r100;
    }

    public final void setCreationId(String r100) {
        this.creationId = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEntranceFrom(String r100) {
        this.entranceFrom = r100;
    }

    public final void setFragmentHashCode(int r100) {
        this.fragmentHashCode = r100;
    }

    public final void setFromAd(String r100) {
        this.isFromAd = r100;
    }

    public final void setGameId(String r100) {
        this.gameId = r100;
    }

    public final void setGameName(String r100) {
        this.gameName = r100;
    }

    public final void setGcEnterDirectly(String r100) {
        this.gcEnterDirectly = r100;
    }

    public final void setGcLaunchFrom(String r100) {
        this.gcLaunchFrom = r100;
    }

    public final void setGcLocation(String r100) {
        this.gcLocation = r100;
    }

    public final void setGcScene(String r100) {
        this.gcScene = r100;
    }

    public final void setIfDou(String r100) {
        this.ifDou = r100;
    }

    public final void setLogPb(String r100) {
        this.logPb = r100;
    }

    public final void setOfficialEnterFrom(String r100) {
        this.officialEnterFrom = r100;
    }

    public final void setOriginalSystemOrigin(String r100) {
        this.originalSystemOrigin = r100;
    }

    public final void setOtherChannel(String r100) {
        this.isOtherChannel = r100;
    }

    public final void setPromoteId(String r100) {
        this.promoteId = r100;
    }

    public final void setPromoteSceneSub(String r100) {
        this.promoteSceneSub = r100;
    }

    public final void setReportParams(HashMap<String, String> r100) {
        this.reportParams = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setScene(int r100) {
        this.scene = r100;
    }

    public final void setShootWay(String r100) {
        this.shootWay = r100;
    }

    public final void setStockType(String r100) {
        this.stockType = r100;
    }

    public final void setVideoEnterFromMerge(String r100) {
        this.videoEnterFromMerge = r100;
    }

    public final void setVideoId(String r100) {
        this.videoId = r100;
    }
}
