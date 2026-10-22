package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.lynx.tasm.LynxError;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0003J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0003J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003JD\u0010\u0017\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0003JD\u0010\u001a\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0003J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010#\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010&\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020'H\u0016J4\u0010,\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0002H\u0016J4\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0002H\u0016J:\u00102\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0016\u00105\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001303H\u0016J6\u00106\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0013032\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0002H\u0016R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/broadcastgame/InteractGameMonitorService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameMonitorService;", "", "generateCurrentGameIdentifier", "Lorg/json/JSONObject;", "data", "category", "", "adapterDataFormat", "service", "", "status", "metric", "extra", "monitor", "", "duration", "monitorStatus", "monitorStatusAndDuration", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "gameItem", "", LynxError.LYNX_THROWABLE, "logService", "Lcom/bytedance/android/live/broadcastgame/api/model/r;", "gameExtra", "logServiceWithGameExtra", "gameIdentifier", "recordGameIdentifier", "getCurrentGameIdentifier", "logFetchInteractItemList", "logInteractGameItemClick", "failedCode", "switchId", "switchName", "logInteractGamePreCheck", "logGameIntroShow", "logGameIntroClick", "logGameStartupResult", "", "isCutShort", "logGameStop", "playId", "logId", "logGameStatusStart", "logGameStatusStop", "tryCount", "startLoadTime", "errorCode", "errorMsg", "logEffectGameResourceLoad", "", "games", "logEffectBatchLoadStart", "logEffectBatchLoadEnd", "mCurrentGameIdentifier", "Ljava/lang/String;", "mStartGameTime", "J", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractGameMonitorService implements IInteractGameMonitorService {
    private String mCurrentGameIdentifier;
    private long mStartGameTime;

    private final void monitor(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104) {
    }

    private final String generateCurrentGameIdentifier() {
        return "game_" + System.currentTimeMillis();
    }

    public InteractGameMonitorService() {
        this.mCurrentGameIdentifier = "";
        jc1.k.l(IInteractGameMonitorService.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public String getCurrentGameIdentifier() {
        return this.mCurrentGameIdentifier;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectBatchLoadStart(List<com.bytedance.android.live.broadcastgame.api.model.u> r100) {
        Intrinsics.checkNotNullParameter(r100, "games");
        List<com.bytedance.android.live.broadcastgame.api.model.u> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.r r104 = ((com.bytedance.android.live.broadcastgame.api.model.u) r103.next()).c();
        if (r104 == null) goto L8;
        long r105 = r104.p();
    L9:
        r102.add(Long.valueOf(r105));
        goto L4
    L8:
        r105 = 0;
        goto L9
    L10:
        JSONObject r106 = new JSONObject();
        BaseMonitor.add(r106, "game_id_arr", r102.toString());
        BaseMonitor.add(r106, "download_count", r102.size());
        monitorStatus(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_START, 0, r106);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void recordGameIdentifier(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gameIdentifier");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
        return;
    L8:
        this.mCurrentGameIdentifier = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Deprecated(message = "这只是一种成本比较低的迁移方案")
    private final void adapterDataFormat(JSONObject r100, JSONObject r101) {
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next().toString();
        String r104 = r100.get(r103).toString();
        Set<String> r105 = com.bytedance.android.live.broadcastgame.api.interactgame.l.f59313a;
        if (com.bytedance.android.live.broadcastgame.api.interactgame.l.f59313a.contains(r103) == false) goto L4;
        BaseMonitor.add(r101, r103, r104);
        goto L4
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameIntroClick(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111) {
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_INTRO_CLICK_ALL, r110, r111, null, 0, null, 56, null);
        if (r110 != 1) goto L6;
        this.mCurrentGameIdentifier = "";
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameIntroShow(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111) {
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_INTRO_SHOW_ALL, r110, r111, null, 0, null, 56, null);
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitorStatus(String r100, int r110, JSONObject r111) {
        monitor$default(this, r100, r110, r111, 0, 8, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logFetchInteractItemList(int r100, long r101, Throwable r110) {
        JSONObject r102 = new JSONObject();
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_FETCH_INTERACT_GAME_LIST_ALL, r100, r101, r102);
        if (r100 != 1) goto L6;
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r102, r110);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_FETCH_INTERACT_GAME_LIST_ERROR, r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStartupResult(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, JSONObject r112) {
        this.mStartGameTime = System.currentTimeMillis();
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_START_ALL, r110, r111, r112, 0, null, 48, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStop(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, boolean r112) {
        JSONObject r100 = new JSONObject();
        BaseMonitor.add(r100, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r112 == false) goto L5;
        BaseMonitor.add(r100, "is_cut_short", 1);
    L7:
        if (this.mStartGameTime != 0) goto L9;
        long r101 = 0;
    L10:
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_EXIT_ALL, r110, r111, r100, r101, null, 32, null);
        this.mCurrentGameIdentifier = "";
        this.mStartGameTime = 0;
        return;
    L9:
        r101 = System.currentTimeMillis() - this.mStartGameTime;
        goto L10
    L5:
        BaseMonitor.add(r100, "is_cut_short", 0);
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logInteractGameItemClick(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, JSONObject r112) {
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_ICON_CLICK_ALL, r110, r111, r112, 0, null, 48, null);
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitor(String r110, int r111, JSONObject r112, long r113) {
        JSONObject r100 = new JSONObject();
        adapterDataFormat(r112, r100);
        JSONObject r101 = new JSONObject();
        if (r113 == (-1)) goto L5;
        BaseMonitor.add(r101, "duration", r113);
    L5:
        int r114 = com.bytedance.android.live.broadcastgame.api.interactgame.i.f59310a;
        Intrinsics.checkNotNullParameter(r112, "extra");
        Intrinsics.checkNotNullParameter(r100, "category");
        RoomContext.a r115 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r115, null, 0, 3);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L10;
        Room r104 = r103.getValue();
    L11:
        String r105 = "-1";
        if (r104 == null) goto L15;
        String r106 = r104.getIdStr();
        if (r106 == null) goto L15;
    L16:
        BaseMonitor.add(r112, "room_id", r106);
        if (r104 == null) goto L22;
        String r107 = r104.getOwnerUserIdString();
        if (r107 == null) goto L22;
        r105 = r107;
    L22:
        BaseMonitor.add(r112, "anchor_id", r105);
        if (r104 == null) goto L25;
        LiveMode r108 = r104.getStreamType();
    L26:
        int r109 = h1.f66189a;
        BaseMonitor.add(r100, "live_type", i1.a(r108));
        RoomContext r116 = RoomContext.a.c(r115, null, 0, 3);
        if (r116 == null) goto L33;
        com.bytedance.live.datacontext.i<Boolean> r117 = r116.isAnchor();
        if (r117 == null) goto L33;
        if (r117.getValue().booleanValue() != true) goto L33;
        String r118 = "0";
    L34:
        BaseMonitor.add(r100, IPerformanceManager.Params.is_anchor, r118);
        BaseMonitor.add(r100, "status", r111);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
        ALogger.d("OpenPlatformMonitor", "\n Service: " + r110 + " status: " + r111 + " metric: " + r101 + " \n category: " + r100 + "  \n extra: " + r112);
    L37:
        LiveTracingMonitor.e(r110, LiveTracingMonitor.EventModule.OPEN_PLATFORM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101, r112);
        return;
    L33:
        r118 = "1";
        goto L34
    L25:
        r108 = null;
    L15:
        r106 = "-1";
    L10:
        r104 = null;
        goto L11
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void monitorStatusAndDuration(String r100, int r101, long r102, JSONObject r110) {
        monitor(r100, r101, r110, r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectBatchLoadEnd(int r100, List<com.bytedance.android.live.broadcastgame.api.model.u> r110, long r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "games");
        Intrinsics.checkNotNullParameter(r113, "errorMsg");
        List<com.bytedance.android.live.broadcastgame.api.model.u> r114 = r110;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r115 = r114.iterator();
    L4:
        if (r115.hasNext() == false) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.r r102 = ((com.bytedance.android.live.broadcastgame.api.model.u) r115.next()).c();
        if (r102 == null) goto L8;
        long r103 = r102.p();
    L9:
        r101.add(Long.valueOf(r103));
        goto L4
    L8:
        r103 = 0;
        goto L9
    L10:
        JSONObject r116 = new JSONObject();
        long r117 = System.currentTimeMillis() - r111;
        BaseMonitor.add(r116, "game_id_arr", r101.toString());
        BaseMonitor.add(r116, "downloaded_count", r101.size());
        if (r100 != 0) goto L13;
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ALL, 0, r117, r116);
        return;
    L13:
        BaseMonitor.add(r116, "error_code", r112);
        BaseMonitor.add(r116, "error_msg", r113);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ALL, 1, r117, r116);
        monitorStatusAndDuration(IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_PRELOAD_ERROR, 1, r117, r116);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStatusStart(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, long r112, Throwable r113, String r114) {
        Intrinsics.checkNotNullParameter(r114, "logId");
        JSONObject r100 = new JSONObject();
        BaseMonitor.add(r100, "log_id", r114);
        BaseMonitor.add(r100, InstantPlayContext.PLAY_ID, String.valueOf(r112));
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_START_ALL, r110, r111, r100, 0, null, 48, null);
        if (r110 != 1) goto L6;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_START_ERROR, r110, r111, r100, 0, r113, 16, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logGameStatusStop(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, long r112, Throwable r113, String r114) {
        Intrinsics.checkNotNullParameter(r114, "logId");
        JSONObject r100 = new JSONObject();
        BaseMonitor.add(r100, InstantPlayContext.PLAY_ID, String.valueOf(r112));
        BaseMonitor.add(r100, "log_id", r114);
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_STOP_ALL, r110, r111, r100, 0, null, 48, null);
        if (r110 != 1) goto L6;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_STATUS_STOP_ERROR, r110, r111, r100, 0, r113, 16, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logInteractGamePreCheck(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r112, "failedCode");
        Intrinsics.checkNotNullParameter(r113, "switchId");
        Intrinsics.checkNotNullParameter(r114, "switchName");
        if (Intrinsics.areEqual(this.mCurrentGameIdentifier, "") == false) goto L5;
        this.mCurrentGameIdentifier = generateCurrentGameIdentifier();
    L5:
        if (r110 != 0) goto L7;
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_CHECK_ALL, r110, r111, null, 0, null, 56, null);
        return;
    L7:
        JSONObject r100 = new JSONObject();
        r100.put("status_code", r112);
        boolean r101 = true;
        if (r113.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
    L18:
        logService$default(this, IInteractGameMonitorService.SERVICE_INTERACT_GAME_CHECK_ALL, r110, r111, r100, 0, null, 48, null);
        return;
    L13:
        if (r114.length() > 0) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L18;
        r100.put("switch_game_id", r113);
        r100.put("switch_game_name", r114);
        goto L18
    L10:
        r102 = false;
        goto L11
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void logService(String r100, int r101, com.bytedance.android.live.broadcastgame.api.model.u r102, JSONObject r110, long r111, Throwable r112) {
        if (r110 != null) goto L4;
        r110 = new JSONObject();
    L4:
        JSONObject r103 = r110;
        int r113 = com.bytedance.android.live.broadcastgame.api.interactgame.i.f59310a;
        Intrinsics.checkNotNullParameter(r103, "extra");
        if (r102 == null) goto L7;
        BaseMonitor.add(r103, EventConstants.ExtraJson.GAME_NAME, r102.name);
        com.bytedance.android.live.broadcastgame.api.interactgame.i.b(r103, r102.c(), true);
    L10:
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r103, r112);
        BaseMonitor.add(r103, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r111 == (-1)) goto L13;
        monitorStatusAndDuration(r100, r101, r111, r103);
        return;
    L13:
        monitorStatus(r100, r101, r103);
        return;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        BaseMonitor.add(r103, AppConstants.BUNDLE_TIP, "game_item is null");
        goto L10
    }

    @Deprecated(message = "后续不要使用这个上报了")
    private final void logServiceWithGameExtra(String r100, int r101, com.bytedance.android.live.broadcastgame.api.model.r r102, JSONObject r110, long r111, Throwable r112) {
        if (r110 != null) goto L4;
        r110 = new JSONObject();
    L4:
        JSONObject r103 = r110;
        com.bytedance.android.live.broadcastgame.api.interactgame.i.b(r103, r102, false);
        com.bytedance.android.live.broadcastgame.api.interactgame.i.a(r103, r112);
        BaseMonitor.add(r103, "current_game_identifer", this.mCurrentGameIdentifier);
        if (r111 == (-1)) goto L7;
        monitorStatusAndDuration(r100, r101, r111, r103);
        return;
    L7:
        monitorStatus(r100, r101, r103);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService
    public void logEffectGameResourceLoad(int r110, com.bytedance.android.live.broadcastgame.api.model.u r111, int r112, long r113, int r114, String r210) {
        Intrinsics.checkNotNullParameter(r210, "errorMsg");
        JSONObject r100 = new JSONObject();
        BaseMonitor.add(r100, "try_count", r112);
        if (r110 != 1) goto L5;
        BaseMonitor.add(r100, "error_code", r114);
        BaseMonitor.add(r100, "error_msg", r210);
        logService$default(this, IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_LOAD_ERROR, r110, r111, r100, System.currentTimeMillis() - r113, null, 32, null);
    L5:
        logService$default(this, IInteractGameMonitorService.SERVICE_EFFECT_GAME_RESOURCE_LOAD_ALL, r110, r111, r100, System.currentTimeMillis() - r113, null, 32, null);
    }

    public static /* synthetic */ void monitor$default(InteractGameMonitorService r100, String r101, int r102, JSONObject r103, long r110, int r111, Object r112) {
        if (r112 != null) goto L9;
        if ((r111 & 8) == 0) goto L6;
        r110 = -1;
    L6:
        r100.monitor(r101, r102, r103, r110);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    public static /* synthetic */ void logService$default(InteractGameMonitorService r110, String r111, int r112, com.bytedance.android.live.broadcastgame.api.model.u r113, JSONObject r114, long r115, Throwable r116, int r117, Object r118) {
        if (r118 != null) goto L18;
        if ((r117 & 8) == 0) goto L6;
        JSONObject r100 = null;
    L8:
        if ((r117 & 16) == 0) goto L10;
        long r101 = -1;
    L12:
        if ((r117 & 32) == 0) goto L14;
        Throwable r102 = null;
    L15:
        r110.logService(r111, r112, r113, r100, r101, r102);
        return;
    L14:
        r102 = r116;
        goto L15
    L10:
        r101 = r115;
        goto L12
    L6:
        r100 = r114;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logService");
    }

    public static /* synthetic */ void logServiceWithGameExtra$default(InteractGameMonitorService r110, String r111, int r112, com.bytedance.android.live.broadcastgame.api.model.r r113, JSONObject r114, long r115, Throwable r116, int r117, Object r118) {
        if (r118 != null) goto L18;
        if ((r117 & 8) == 0) goto L6;
        JSONObject r100 = null;
    L8:
        if ((r117 & 16) == 0) goto L10;
        long r101 = -1;
    L12:
        if ((r117 & 32) == 0) goto L14;
        Throwable r102 = null;
    L15:
        r110.logServiceWithGameExtra(r111, r112, r113, r100, r101, r102);
        return;
    L14:
        r102 = r116;
        goto L15
    L10:
        r101 = r115;
        goto L12
    L6:
        r100 = r114;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logServiceWithGameExtra");
    }
}
