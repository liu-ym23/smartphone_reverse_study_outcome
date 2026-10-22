package com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.common.model.GameStageType;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 q2\u00020\u0001:\u0001rB\u0007¢\u0006\u0004\bo\u0010pR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R!\u00104\u001a\b\u0012\u0004\u0012\u00020\t0/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R!\u00107\u001a\b\u0012\u0004\u0012\u00020\t0/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010A\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR,\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR\"\u0010O\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020V0U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u00101\u001a\u0004\bX\u0010YR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR$\u0010f\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR.\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010*\u001a\u0004\bm\u0010,\"\u0004\bn\u0010.¨\u0006s"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/legacy/viewmodel/AudienceGamePromoteDetailViewModel;", "Lcom/bytedance/android/gamecp/business/gamedetail/legacy/viewmodel/BaseGamePromoteDetailViewModel;", "", "promoteScene", "I", "getPromoteScene", "()I", "setPromoteScene", "(I)V", "", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "getGameName", "setGameName", "enterFrom", "getEnterFrom", "setEnterFrom", "gameAdType", "getGameAdType", "setGameAdType", "gameAdShowType", "getGameAdShowType", "setGameAdShowType", "anchorId", "getAnchorId", "setAnchorId", "roomId", "getRoomId", "setRoomId", "attributionId", "getAttributionId", "setAttributionId", "h5ReportParams", "getH5ReportParams", "setH5ReportParams", "", "lynxCardLocation", "Ljava/util/Map;", "getLynxCardLocation", "()Ljava/util/Map;", "setLynxCardLocation", "(Ljava/util/Map;)V", "Lcom/bytedance/live/datacontext/m;", "detailTabChangeTo$delegate", "Lcom/bytedance/live/datacontext/p;", "getDetailTabChangeTo", "()Lcom/bytedance/live/datacontext/m;", "detailTabChangeTo", "currentTab$delegate", "getCurrentTab", "currentTab", "", "isFullScreen", "Z", "()Z", "setFullScreen", "(Z)V", "startPage", "getStartPage", "setStartPage", "couponType", "getCouponType", "setCouponType", "", "tabIdArray", "[Ljava/lang/String;", "getTabIdArray", "()[Ljava/lang/String;", "setTabIdArray", "([Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "Lcom/bytedance/android/gamecp/common/model/GameStageType;", "gameStage", "Lcom/bytedance/android/gamecp/common/model/GameStageType;", "getGameStage", "()Lcom/bytedance/android/gamecp/common/model/GameStageType;", "setGameStage", "(Lcom/bytedance/android/gamecp/common/model/GameStageType;)V", "Lcom/bytedance/live/datacontext/k;", "", "popupTip$delegate", "getPopupTip", "()Lcom/bytedance/live/datacontext/k;", "popupTip", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/h;", "gameDetailCommonInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/h;", "getGameDetailCommonInfo", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/h;", "setGameDetailCommonInfo", "(Lcom/bytedance/android/gamecp/business/gamedetail/base/model/h;)V", "promoteInstanceId", "getPromoteInstanceId", "setPromoteInstanceId", "Lorg/json/JSONObject;", "structure", "Lorg/json/JSONObject;", "getStructure", "()Lorg/json/JSONObject;", "setStructure", "(Lorg/json/JSONObject;)V", "gameReserveState", "getGameReserveState", "setGameReserveState", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGamePromoteDetailViewModel extends BaseGamePromoteDetailViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "AudienceDetailGamePromoteDetailViewModel";
    private String anchorId;
    private String attributionId;
    private String couponType;
    private final p currentTab$delegate;
    private final p detailTabChangeTo$delegate;
    private String enterFrom;
    private String gameAdShowType;
    private String gameAdType;
    private h gameDetailCommonInfo;
    private String gameId;
    private String gameName;
    private Map<String, Integer> gameReserveState;
    private GameStageType gameStage;
    private String h5ReportParams;
    private boolean isFullScreen;
    private Map<String, String> lynxCardLocation;
    private final p popupTip$delegate;
    private String promoteInstanceId;
    private int promoteScene;
    private String roomId;
    private String startPage;
    private JSONObject structure;
    private String[] tabIdArray;
    private String videoId;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AudienceGamePromoteDetailViewModel.class, "detailTabChangeTo", "getDetailTabChangeTo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGamePromoteDetailViewModel.class, "currentTab", "getCurrentTab()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceGamePromoteDetailViewModel.class, "popupTip", "getPopupTip()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final m<String> getCurrentTab() {
        return (m) this.currentTab$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<String> getDetailTabChangeTo() {
        return (m) this.detailTabChangeTo$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Unit> getPopupTip() {
        return (k) this.popupTip$delegate.a(this, $$delegatedProperties[2]);
    }

    public AudienceGamePromoteDetailViewModel() {
        this.gameId = "";
        this.gameName = "";
        this.enterFrom = "";
        this.gameAdType = "";
        this.gameAdShowType = "";
        Room r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r100 == null) goto L7;
        String r101 = r100.getOwnerUserId();
        if (r101 == null) goto L7;
    L8:
        this.anchorId = r101;
        Room r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r102 == null) goto L12;
        String r103 = String.valueOf(r102.getId());
        if (r103 == null) goto L12;
    L13:
        this.roomId = r103;
        this.attributionId = "";
        this.h5ReportParams = SliceInitService.DEFAULT_SWITCH;
        this.detailTabChangeTo$delegate = q.d(this, "tab_game_detail");
        this.currentTab$delegate = q.d(this, "tab_game_detail");
        this.startPage = "";
        this.couponType = "";
        this.gameStage = GameStageType.DOWNLOAD;
        this.popupTip$delegate = e.b(this);
        this.promoteInstanceId = "";
        this.structure = new JSONObject();
        this.gameReserveState = new LinkedHashMap();
        return;
    L12:
        r103 = "";
    L7:
        r101 = "";
        goto L8
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getGameAdShowType() {
        return this.gameAdShowType;
    }

    public final String getGameAdType() {
        return this.gameAdType;
    }

    public final h getGameDetailCommonInfo() {
        return this.gameDetailCommonInfo;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final Map<String, Integer> getGameReserveState() {
        return this.gameReserveState;
    }

    public final GameStageType getGameStage() {
        return this.gameStage;
    }

    public final String getH5ReportParams() {
        return this.h5ReportParams;
    }

    public final Map<String, String> getLynxCardLocation() {
        return this.lynxCardLocation;
    }

    public final String getPromoteInstanceId() {
        return this.promoteInstanceId;
    }

    public final int getPromoteScene() {
        return this.promoteScene;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getStartPage() {
        return this.startPage;
    }

    public final JSONObject getStructure() {
        return this.structure;
    }

    public final String[] getTabIdArray() {
        return this.tabIdArray;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setAttributionId(String r100) {
        this.attributionId = r100;
    }

    public final void setCouponType(String r100) {
        this.couponType = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setFullScreen(boolean r100) {
        this.isFullScreen = r100;
    }

    public final void setGameAdShowType(String r100) {
        this.gameAdShowType = r100;
    }

    public final void setGameAdType(String r100) {
        this.gameAdType = r100;
    }

    public final void setGameDetailCommonInfo(h r100) {
        this.gameDetailCommonInfo = r100;
    }

    public final void setGameId(String r100) {
        this.gameId = r100;
    }

    public final void setGameName(String r100) {
        this.gameName = r100;
    }

    public final void setGameReserveState(Map<String, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameReserveState = r100;
    }

    public final void setGameStage(GameStageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameStage = r100;
    }

    public final void setH5ReportParams(String r100) {
        this.h5ReportParams = r100;
    }

    public final void setLynxCardLocation(Map<String, String> r100) {
        this.lynxCardLocation = r100;
    }

    public final void setPromoteInstanceId(String r100) {
        this.promoteInstanceId = r100;
    }

    public final void setPromoteScene(int r100) {
        this.promoteScene = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setStartPage(String r100) {
        this.startPage = r100;
    }

    public final void setStructure(JSONObject r100) {
        this.structure = r100;
    }

    public final void setTabIdArray(String[] r100) {
        this.tabIdArray = r100;
    }

    public final void setVideoId(String r100) {
        this.videoId = r100;
    }
}
