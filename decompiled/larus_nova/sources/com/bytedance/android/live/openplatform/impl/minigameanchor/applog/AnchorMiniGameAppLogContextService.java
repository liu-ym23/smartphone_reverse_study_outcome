package com.bytedance.android.live.openplatform.impl.minigameanchor.applog;

import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qo0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J8\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bJ\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eJ8\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/applog/AnchorMiniGameAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "", "getCommonParams", "data", "", "addTaskEntranceInfo", "addInteractPanelGameInfo", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "reportPreviewMgAppLog", "", "getPreviewMgCommonLogMap", "reportLiveRoomMgAppLog", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "value", "microGameInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "getMicroGameInfo", "()Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "setMicroGameInfo", "(Lcom/bytedance/android/live/broadcastgame/api/model/c0;)V", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniGameAppLogContextService extends OpenPlatformContextService {
    private final String TAG;
    private c0 microGameInfo;

    private final Map<String, String> getCommonParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_GAME);
        int r101 = n.f84071a;
        n.d(getOpenPlatformContext().getRoom(), r100);
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r102 = AnchorMiniGameDataContext.a.a();
        if (r102 == null) goto L8;
        com.bytedance.live.datacontext.n<String> r103 = r102.getLiveType();
        if (r103 == null) goto L8;
        String r104 = r103.getValue();
        if (r104 == null) goto L8;
    L15:
        r100.put("live_type", r104);
        r100.put("user_type", "anchor");
        Room r105 = getOpenPlatformContext().getRoom();
        if (r105 == null) goto L21;
        AnchorData r106 = r105.getAnchorData();
        if (r106 == null) goto L21;
        String r107 = r106.getFrameScale();
        if (r107 == null) goto L21;
    L22:
        r100.put("frame_scale", r107);
        return r100;
    L21:
        r107 = "";
    L8:
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, getOpenPlatformContext().getDataCenter(), 0, 2);
        if (r108 == null) goto L13;
        i<LiveMode> r109 = r108.getLiveMode();
        if (r109 == null) goto L13;
        LiveMode r110 = r109.getValue();
    L14:
        int r111 = h1.f66189a;
        r104 = i1.a(r110);
    L13:
        r110 = null;
        goto L14
    }

    public final Map<String, String> getPreviewMgCommonLogMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(getCommonParams());
        addTaskEntranceInfo(r100);
        return r100;
    }

    public final c0 getMicroGameInfo() {
        return this.microGameInfo;
    }

    public AnchorMiniGameAppLogContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.TAG = "AnchorMiniGameAppLogContextService";
    }

    private final void addInteractPanelGameInfo(Map<String, String> r100) {
        c0 r101 = this.microGameInfo;
        String r102 = "";
        if (r101 == null) goto L38;
        String r103 = r101.gameId;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r100.put(BdpAppEventConstant.PARAMS_MP_ID, r103);
        String r104 = r101.gameName;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r100.put(BdpAppEventConstant.PARAMS_MP_NAME, r104);
        String r105 = r101.gameType;
        if (r105 != null) goto L13;
        r105 = BdpAppEventConstant.MICRO_GAME;
    L13:
        r100.put(BdpAppEventConstant.PARAMS_GAME_TYPE, r105);
        String r106 = r101.gameId;
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r100.put("game_id", r106);
        String r107 = r101.gameName;
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r100.put(EventConstants.ExtraJson.GAME_NAME, r107);
        r100.put(BdpAppEventConstant.PARAMS_GAME_CATEGORY, BdpAppEventConstant.MICRO_GAME);
        r100.put("user_type", "anchor");
        String r108 = r101.f59335a;
        if (r108 != null) goto L22;
        r108 = "";
    L22:
        r100.put("source", r108);
        String r109 = r101.taskId;
        if (r109 != null) goto L25;
        r109 = "";
    L25:
        r100.put("task_id", r109);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r110 = AnchorGameContext.a.a();
        if (r110 == null) goto L31;
        m<String> r111 = r110.getSearchWord();
        if (r111 == null) goto L31;
        String r112 = r111.getValue();
        if (r112 == null) goto L31;
    L32:
        r100.put("search_word", r112);
        Integer r113 = r101.bidType;
        if (r113 == null) goto L36;
        String r114 = String.valueOf(r113.intValue());
        if (r114 == null) goto L36;
    L37:
        r100.put("bid_type", r114);
    L36:
        r114 = "";
    L31:
        r112 = "";
    L38:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r115 = AnchorMiniGameDataContext.a.a();
        if (r115 == null) goto L43;
        com.bytedance.live.datacontext.n<Pair<String, String>> r116 = r115.getSourceFromDetailPage();
        if (r116 == null) goto L43;
        Pair<String, String> r117 = r116.getValue();
    L44:
        if (r117 == null) goto L53;
        String r118 = r117.getFirst();
        if (r118 == null) goto L54;
        r100.put("source", r118);
        String r119 = r117.getSecond();
        if (r119 == null) goto L51;
        r102 = r119;
    L51:
        r100.put("oe_source", r102);
        return;
    L54:
        return;
    L53:
        return;
    L43:
        r117 = null;
        goto L44
    }

    private final void addTaskEntranceInfo(Map<String, String> r100) {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r101 = AnchorMiniGameDataContext.a.a();
        if (r101 == null) goto L31;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r102 = r101.getOpenPlatformMg();
        if (r102 == null) goto L32;
        OpenPlatformMgInfoModel r103 = r102.getValue();
        if (r103 == null) goto L33;
        String r104 = r103.getAppId();
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r100.put(BdpAppEventConstant.PARAMS_MP_ID, r104);
        String r106 = r103.getAppName();
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        r100.put(BdpAppEventConstant.PARAMS_MP_NAME, r106);
        String r107 = r103.getGameType();
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r100.put(BdpAppEventConstant.PARAMS_GAME_TYPE, r107);
        String r108 = r103.getTaskId();
        if (r108 != null) goto L20;
        r108 = "";
    L20:
        r100.put("task_id", r108);
        String r109 = r103.getPanelFrom();
        if (r109 != null) goto L23;
        r109 = "";
    L23:
        r100.put("panel_from", r109);
        Integer r110 = r103.getBidType();
        if (r110 == null) goto L29;
        String r111 = String.valueOf(r110.intValue());
        if (r111 == null) goto L29;
        r105 = r111;
    L29:
        r100.put("bid_type", r105);
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void setMicroGameInfo(c0 r100) {
        if (r100 == null) goto L4;
        this.microGameInfo = r100;
        return;
    L4:
        this.microGameInfo = null;
    }

    public final void reportLiveRoomMgAppLog(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = a.f534145a;
        a.c(this.TAG, "live room event: " + r100 + ", extra:" + String.valueOf(r101));
        g r103 = u.l();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(getCommonParams());
        addTaskEntranceInfo(r104);
        addInteractPanelGameInfo(r104);
        if (r101 == null) goto L5;
        r104.putAll(r101);
    L5:
        Unit r105 = Unit.INSTANCE;
        r103.e(r100, r104, new Object[]{Room.class});
    }

    public final void reportPreviewMgAppLog(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = a.f534145a;
        a.c(this.TAG, "preview event: " + r100 + ", extra:" + String.valueOf(r101));
        g r103 = u.l();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(getCommonParams());
        addTaskEntranceInfo(r104);
        if (r101 == null) goto L5;
        r104.putAll(r101);
    L5:
        Unit r105 = Unit.INSTANCE;
        r103.e(r100, r104, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportLiveRoomMgAppLog$default(AnchorMiniGameAppLogContextService r100, String r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.reportLiveRoomMgAppLog(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportPreviewMgAppLog$default(AnchorMiniGameAppLogContextService r100, String r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.reportPreviewMgAppLog(r101, r102);
    }
}
