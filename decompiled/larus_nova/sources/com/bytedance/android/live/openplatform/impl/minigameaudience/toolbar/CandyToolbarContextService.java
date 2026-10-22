package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import am2.n;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameaudience.api.MiniGameAudienceApi;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.launch.AudienceLaunchMgContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.y80;
import com.bytedance.android.livesdk.config.z80;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/CandyToolbarContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CandyToolbarContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fr0.b.a f85312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f85313c;

    public static final class a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CandyToolbarContextService f85314a;

        public a(CandyToolbarContextService r100) {
            this.f85314a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            IHostLiveOpenPlatform r101 = TTLiveSDK.hostService().hostOpenPlatform();
            if (r101 == null) goto L6;
            r101.preloadMiniGame(this.f85314a.h());
            return;
        }
    }

    public final String h() {
        fr0.b.a r100 = this.f85312b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.schemaUrl;
    L7:
        if (z80.f121743a.getValue().booleanValue() == true) goto L9;
    L28:
        if (r102 != null) goto L31;
        return "";
    L31:
        return r102;
    L9:
        if (this.f85313c == false) goto L28;
        String r103 = new JSONObject(n.f().d()).optString("micro_app_scheme");     // Catch: JSONException -> L12
    L13:
        int r104 = qo0.a.f534145a;
        String r105 = this.f85311a;
        StringBuilder r106 = new StringBuilder("getSchemaUrl ");
        fr0.b.a r107 = this.f85312b;
        if (r107 == null) goto L16;
        String r108 = r107.a();
    L17:
        r106.append(r108);
        r106.append(", ");
        r106.append(r103);
        qo0.a.c(r105, r106.toString());
        SchemaInfo.f83978s.getClass();
        SchemaInfo r109 = SchemaInfo.b.b(r103);
        if (TextUtils.isEmpty(r103) == true) goto L28;
        fr0.b.a r110 = this.f85312b;
        if (r110 == null) goto L22;
        String r111 = r110.a();
    L23:
        if (r109 == null) goto L26;
        r101 = r109.a();
    L26:
        if (TextUtils.equals(r111, r101) == false) goto L28;
        r102 = r103;
        goto L28
    L22:
        r111 = null;
        goto L23
    L16:
        r108 = null;
    L12:
        r103 = "";
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        if (y80.f121665a.getValue().booleanValue() == true) goto L5;
        Lazy r100 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.g(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE);
        return;
    L5:
        DataCenter r101 = getOpenPlatformContext().getDataCenter();
        if (r101 == null) goto L8;
        r101.put("CandyToolbarContextService", null);
    L8:
        DataCenter r102 = getOpenPlatformContext().getDataCenter();
        if (r102 == null) goto L11;
        r102.put("LittleGameConfig_entranceInfo", null);
    L11:
        DataCenter r103 = getOpenPlatformContext().getDataCenter();
        if (r103 == null) goto L14;
        r103.put("LittleGameConfig_loadButton", null);
    L14:
        DataCenter r104 = getOpenPlatformContext().getDataCenter();
        if (r104 == null) goto L19;
        r104.put("LittleGameConfig_dataFromEnter", null);
        return;
    }

    public CandyToolbarContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85311a = "CandyToolbarContextService";
    }

    public final void i(long r100) {
        int r101 = MiniGameLiveJsBridgeUtils.f85366a;
        autoDispose(MiniGameLiveJsBridgeUtils.a("lottery_open_game", new CandyToolbarContextService$initCandyToolbar$1(this)));
        if (y80.f121665a.getValue().booleanValue() == false) goto L23;
        DataCenter r102 = getOpenPlatformContext().getDataCenter();
        if (r102 == null) goto L7;
        r102.put("CandyToolbarContextService", this);
    L7:
        DataCenter r103 = getOpenPlatformContext().getDataCenter();
        Boolean r104 = null;
        if (r103 == null) goto L10;
        fr0.b.a r105 = (fr0.b.a) r103.get("LittleGameConfig_entranceInfo");
    L11:
        DataCenter r106 = getOpenPlatformContext().getDataCenter();
        if (r106 == null) goto L14;
        Function0<Unit> r107 = (Function0) r106.get("LittleGameConfig_loadButton");
    L15:
        DataCenter r108 = getOpenPlatformContext().getDataCenter();
        if (r108 == null) goto L18;
        r104 = (Boolean) r108.get("LittleGameConfig_dataFromEnter");
    L18:
        boolean r109 = Intrinsics.areEqual(r104, Boolean.TRUE);
        if (r105 == null) goto L25;
        if (r107 == null) goto L26;
        j(r105, r107, r109);
        return;
    L26:
        return;
    L25:
        return;
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L23:
        int r110 = qo0.a.f534145a;
        qo0.a.c(this.f85311a, "initCandyToolbar, this=" + this);
        Lazy r111 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.e(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE, new CandyToolbarContextService$initCandyToolbar$2(this, r100));
    }

    public static final void g(CandyToolbarContextService r100, Function0 r101, Function1 r102) {
        r100.getClass();
        String r103 = "";
        String r104 = new JSONObject(n.f().d()).optString("micro_app_scheme");     // Catch: JSONException -> L5
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L9:
        Lazy r105 = LiveOpenPlatformMgClient.f84036c;
        r100.autoDispose(((MiniGameAudienceApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAudienceApi.class)).getEntranceInfo(r100.getOpenPlatformContext().getRoomId(), r103).compose(RxUtil.rxSchedulerHelper()).retry(3).subscribe(new com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.a(r100, r102, r101), new b(r100, r102)));
        return;
    L14:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L11
        r106.put("ad_schema", r104);     // Catch: JSONException -> L11
        r103 = r106.toString();     // Catch: JSONException -> L11
    L5:
        r104 = "";
        goto L7
    }

    public final void j(fr0.b.a r100, Function0<Unit> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "entranceInfo");
        Intrinsics.checkNotNullParameter(r101, "loadButton");
        this.f85313c = r102;
        this.f85312b = r100;
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r103 = MiniGameDataContext.a.a();
        if (r103 == null) goto L7;
        m<String> r104 = r103.getGameId();
        if (r104 == null) goto L7;
        r104.setValue(r100.a());
    L7:
        MiniGameDataContext r105 = MiniGameDataContext.a.a();
        int r106 = 0;
        if (r105 == null) goto L16;
        m<Integer> r107 = r105.getInstantPlayOpenStatus();
        if (r107 == null) goto L16;
        Integer r108 = r100.f();
        if (r108 == null) goto L14;
        int r109 = r108.intValue();
    L15:
        r107.setValue(Integer.valueOf(r109));
        goto L16
    L14:
        r109 = 0;
    L16:
        MiniGameDataContext r110 = MiniGameDataContext.a.a();
        if (r110 == null) goto L25;
        m<Integer> r111 = r110.getInstantPlayToggleStatus();
        if (r111 == null) goto L25;
        Integer r112 = r100.g();
        if (r112 == null) goto L23;
        r106 = r112.intValue();
    L23:
        r111.setValue(Integer.valueOf(r106));
    L25:
        if (y80.f121665a.getValue().booleanValue() == false) goto L27;
    L30:
        ((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f();
        RoomWatchDurationContextService r113 = (RoomWatchDurationContextService) getOpenPlatformContext().getService(RoomWatchDurationContextService.class);
        r113.getClass();
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r114 = AudienceMiniGameDataContext.a.a();
        if (r114 == null) goto L39;
        m<Boolean> r115 = r114.isCandyToolbarShow();
        if (r115 == null) goto L39;
        Observable<Boolean> r116 = r115.a();
        if (r116 == null) goto L39;
        Disposable r117 = r116.subscribe(new gr0.a(r113));
        if (r117 == null) goto L39;
        r113.autoDispose(r117);
    L39:
        AudienceMiniGameDataContext r118 = AudienceMiniGameDataContext.a.a();
        if (r118 == null) goto L48;
        m<Boolean> r119 = r118.isRoomBackground();
        if (r119 == null) goto L48;
        Observable<Boolean> r120 = r119.a();
        if (r120 == null) goto L48;
        Disposable r121 = r120.subscribe(new gr0.b(r113));
        if (r121 == null) goto L48;
        r113.autoDispose(r121);
    L48:
        OpenPlatformContext r122 = r113.getOpenPlatformContext();
        if (r122 == null) goto L60;
        ((MiniGameContext) r122).registerMiniGameLifecycleChangeListener(r113.f85288f);
        com.bytedance.android.live.openplatform.impl.base.utils.m.f(Observable.create(new a(this)).subscribeOn(Schedulers.io()), null);
        int r123 = qo0.a.f534145a;
        qo0.a.c(this.f85311a, "load candy button.");
        r101.invoke();
        Room r124 = getOpenPlatformContext().getRoom();
        if (r124 == null) goto L53;
        r124.init();
    L53:
        AudienceMiniGameAppLogContextService r125 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        HashMap<String, String> r126 = new HashMap();
        r126.put("location", kr0.a.a("mg_link"));
        com.bytedance.android.live.openplatform.impl.base.utils.n.e(r126);
        if (((AudienceLaunchMgContextService) getOpenPlatformContext().getService(AudienceLaunchMgContextService.class)).f85299d == false) goto L56;
        r126.put("is_mg_dail_page", "1");
    L57:
        Unit r127 = Unit.INSTANCE;
        r125.h(BdpAppEventConstant.EVENT_MP_SHOW, r126);
        return;
    L56:
        r126.put("is_mg_dail_page", "0");
        goto L57
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    L27:
        if (y3.m(getOpenPlatformContext().getDataCenter()).n(ToolbarButton.LITTLE_GAME) == false) goto L30;
        int r128 = qo0.a.f534145a;
        qo0.a.c(this.f85311a, "candy button isShowing, don't load again");
    }

    public static final void f(CandyToolbarContextService r100, boolean r101, boolean r102, long r110) {
        r100.getClass();
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L21
        String r104 = "1";
        if (r101 == false) goto L7;
        Object r105 = "1";
    L8:
        r103.put("opt_group", r105);     // Catch: Exception -> L21
        if (r102 == false) goto L11;
        Object r106 = "1";
    L12:
        r103.put("validity", r106);     // Catch: Exception -> L21
        if (r110 > 0) goto L16;
        r104 = "0";
    L16:
        r103.put("has_start_timestamp", r104);     // Catch: Exception -> L21
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L21
        if (r110 <= 0) goto L19;
        r107.put("duration", System.currentTimeMillis() - r110);     // Catch: Exception -> L21
    L19:
        int r108 = qo0.a.f534145a;     // Catch: Exception -> L21
        qo0.a.c(r100.f85311a, "reportToolbarPerformance, category: " + r103 + ", metric: " + r107);     // Catch: Exception -> L21
        LiveTracingMonitor.f("ttlive_minigame_entrance_info", LiveTracingMonitor.EventModule.OPEN_PLATFORM, r103, r107, new JSONObject());     // Catch: Exception -> L21
        return;
    L11:
        r106 = "0";
        goto L12
    L7:
        r105 = "0";
    }
}
