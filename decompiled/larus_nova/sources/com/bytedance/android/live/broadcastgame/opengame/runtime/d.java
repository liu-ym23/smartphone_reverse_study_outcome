package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.channel.receiver.helper.ImAlignHelper;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver;
import com.bytedance.android.live.broadcastgame.opengame.message.o0;
import com.bytedance.android.live.broadcastgame.opengame.network.outer.GamePlayApi;
import com.bytedance.android.live.broadcastgame.opengame.service.AudienceMiniGameIntroCardService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends OpenApiSupportPluginRuntime {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.message.g f60825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a0 f60826w;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f60827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f60828b;

        public b(d r100, Map r101) {
            this.f60827a = r100;
            this.f60828b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;     // Catch: Throwable -> L4
            com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"show plugin checked"});     // Catch: Throwable -> L4
            d.y(this.f60827a, this.f60828b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f60829a = null;

        static {
            f60829a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            com.bytedance.android.livesdk.event.z r101 = (com.bytedance.android.livesdk.event.z) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if ((r101.f123383a instanceof d0) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.f123384b == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.runtime.d$d, reason: collision with other inner class name */
    public static final class C1004d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f60830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f60831b;

        public C1004d(d r100, long r101) {
            this.f60830a = r100;
            this.f60831b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.event.z r111 = (com.bytedance.android.livesdk.event.z) r110;
            d r112 = this.f60830a;
            String r100 = String.valueOf(this.f60831b);
            r112.getClass();
            Map<String, String> r113 = com.bytedance.android.livesdk.sharedpref.b.F2.getValue();
            Integer r101 = null;
            if (r113.size() >= 3) goto L5;
        L20:
            String r102 = r113.get(r100);
            int r103 = 0;
            if (r102 != null) goto L29;
        L27:
            JSONObject r104 = new JSONObject();
            r104.put("count", r103 + 1);
            r104.put("timestamp", System.currentTimeMillis());
            Unit r105 = Unit.INSTANCE;
            r113.put(r100, r104.toString());
            com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r106 = com.bytedance.android.livesdk.sharedpref.b.F2;
            r106.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r106, r113);
            return;
        L29:
            LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L24
            r101 = Integer.valueOf(LiveSeiUtil.c(r102).optInt("count", 0));     // Catch: Exception -> L24
        L25:
            if (r101 == null) goto L27;
            r103 = r101.intValue();
            goto L27
        L5:
            if (r113.containsKey(r100) == true) goto L20;
            Iterator<Map.Entry<String, String>> r107 = r113.entrySet().iterator();
            String r108 = null;
            long r109 = Long.MAX_VALUE;
        L8:
            if (r107.hasNext() == false) goto L18;
            Map.Entry<String, String> r114 = r107.next();
            String r115 = r114.getValue();
            if (r115 == null) goto L8;
            LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L16
            long r116 = LiveSeiUtil.c(r115).optLong("timestamp");     // Catch: Exception -> L16
            if (r116 >= r109) goto L14;
            r108 = r114.getKey();     // Catch: Exception -> L16
            r109 = r116;
        L14:
            Unit r117 = Unit.INSTANCE;     // Catch: Exception -> L16
            goto L8
        L18:
            if (r109 == Long.MAX_VALUE) goto L20;
            r113.remove(r108);
            goto L20
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"ready to start, init audience open api"});
        k r101 = t();
        com.bytedance.android.live.broadcastgame.opengame.openapi.d r102 = new com.bytedance.android.live.broadcastgame.opengame.openapi.d(u(), w(), (CloudExecutor) this.f60784p.getValue());
        v r103 = (v) r101;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "openApi");
        r103.f60848b = r102;
        super.start();
        if (this.f60861f == false) goto L11;
        Object r104 = u().f60810n.get("is_debug");
        if ((r104 instanceof Boolean) == true) goto L8;
        r104 = null;
    L8:
        if (Intrinsics.areEqual((Boolean) r104, Boolean.TRUE) == false) goto L12;
        g(null);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        super.launch();
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r100 = AudienceGameContext.a.a();
        if (r100 == null) goto L10;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r101 = r100.getGameIntroCardInfo();
        if (r101 == null) goto L11;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r102 = r101.getValue();
        if (r102 == null) goto L12;
        z(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        super.stop();
        if (u().m() != PluginType.LYNX) goto L5;
    L6:
        AudienceMiniGameIntroCardService.a((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class), false, true, 1);
    L7:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r100 = AudienceGameContext.a.a();
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r101 = r100.getGameIntroCardInfo();
        if (r101 == null) goto L12;
        r101.setValue(null);
    L12:
        ((u10.e) w()).f();
        com.bytedance.android.live.broadcastgame.opengame.message.g r102 = this.f60825v;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L15:
        r102.f60229i.b();
        com.bytedance.android.live.broadcastgame.opengame.message.q r103 = r102.f60222b;
        r103.f60270b = null;
        r103.f60269a = null;
        o0 r104 = r102.f60223c;
        monitor-enter(r104);
        r104.f60266a.clear();     // Catch: Throwable -> L21
        monitor-exit(r104);
        r102.f60227g.b();
        r102.f60221a.d();
        this.f60826w.a(null);
        return;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (u().m() != PluginType.SONIC_GAME) goto L7;
        goto L6
    }

    public final void A(long r100) {
        com.bytedance.android.live.broadcastgame.opengame.message.g r101 = this.f60825v;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L5:
        Iterator r102 = ((ArrayList) r101.f60224d).iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        ImAlignHelper r103 = (ImAlignHelper) ((BaseAnchorMessageReceiver) r102.next()).f60183b.getValue();
        com.bytedance.android.live.broadcastgame.channel.receiver.helper.a r104 = (com.bytedance.android.live.broadcastgame.channel.receiver.helper.a) r103.f59571b.getValue();
        if (r100 != 0) goto L11;
        r104.getClass();
    L13:
        if ((!((PriorityQueue) r103.f59572c.getValue()).isEmpty()) == false) goto L7;
        ImAlignHelper.b r105 = (ImAlignHelper.b) ((PriorityQueue) r103.f59572c.getValue()).peek();
        if (r105.f59574a.a() > r100) goto L7;
        ((PriorityQueue) r103.f59572c.getValue()).remove(r105);
        r103.f59570a.removeCallbacks(r105);
        r103.f59573d.invoke(r105.f59574a);
        goto L13
    L11:
        r104.f59580c = r100;
        r104.f59579b = System.currentTimeMillis();
        goto L13
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.d(r100);
        if ((r100 instanceof com.bytedance.android.live.broadcastgame.api.openplatform.a) == false) goto L6;
        z(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void g(Map<String, String> r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"show plugin if boot info is not null, boot info: ", u().f60809m.f61086l});
        this.f60826w.a(new b(this, r100));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime
    public void onEventEnter(y.b r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginEvent");
        super.onEventEnter(r100);
        if ((r100 instanceof y.b.a) == false) goto L9;
        a0 r101 = this.f60826w;
        r101.f60820b = true;
        Runnable r102 = r101.f60819a;
        if (r102 == null) goto L7;
        r102.run();
    L7:
        r101.a(null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w
    public final PluginContext q(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Context r100 = getContext();
        DataCenter r101 = this.f60864i;
        com.bytedance.android.live.broadcastgame.opengame.i r102 = this.f60867l;
        com.bytedance.android.live.broadcastgame.opengame.message.g r103 = this.f60825v;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L6:
        return new PluginContext(r100, r101, r102, this, r103, r(), r110, this.f60866k, false, null);
    }

    public final void z(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        if (u().m() != PluginType.LYNX) goto L5;
    L6:
        Object r101 = u().f60809m.f61085k.get("OPEN_APP_ICON_URL");
        if ((r101 instanceof String) == true) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        String r103 = r102;
        if (r100.f59392a == false) goto L15;
        ((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class)).b(com.bytedance.android.live.broadcastgame.api.openplatform.a.a(r100, r103, u().f60809m.c(), u().f60809m.f61088n, 0, 3829));
        return;
    L15:
        AudienceMiniGameIntroCardService.a((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class), false, false, 3);
        return;
    L5:
        if (u().m() == PluginType.SONIC_GAME) goto L6;
    }

    public static final /* synthetic */ void y(d r100, Map r101) {
        super.g(r101);
    }

    public d(Context r110, long r111, DataCenter r112, com.bytedance.android.live.broadcastgame.opengame.f r113, com.bytedance.android.live.broadcastgame.opengame.i r114) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "dataCenter");
        Intrinsics.checkNotNullParameter(r113, "gameIMManager");
        super(r110, r112, r111, false, r114, r113);
        this.f60826w = new a0();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void e(String r210, PluginType r211, Map<String, ? extends Object> r212, boolean r213, r r214) {
        Intrinsics.checkNotNullParameter(r210, "schema");
        Intrinsics.checkNotNullParameter(r211, "pluginType");
        Intrinsics.checkNotNullParameter(r212, "params");
        Object r100 = r212.get("app_id");
        Object r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = r212.get("game_id");
        if ((r103 instanceof Long) == true) goto L11;
        r103 = null;
    L11:
        Long r104 = (Long) r103;
        if (r104 == null) goto L14;
        long r110 = r104.longValue();
    L15:
        Object r105 = r212.get("conn_id");
        if ((r105 instanceof Long) == true) goto L18;
        r105 = null;
    L18:
        Long r106 = (Long) r105;
        if (r106 == null) goto L21;
        long r107 = r106.longValue();
    L22:
        Object r108 = r212.get("app_version");
        if ((r108 instanceof String) == true) goto L25;
        r108 = null;
    L25:
        String r109 = (String) r108;
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        DataCenter r111 = this.f60864i;
        Intrinsics.checkNotNull(r111);
        Room r112 = (Room) r111.get("data_room", new Room());
        Object r113 = r212.get("game");
        if ((r113 instanceof com.bytedance.android.live.broadcastgame.api.model.u) == false) goto L32;
        r101 = r113;
    L32:
        com.bytedance.android.live.broadcastgame.api.model.u r114 = (com.bytedance.android.live.broadcastgame.api.model.u) r101;
        if (r112.getRoomId() == 0) goto L35;
        this.f60825v = new com.bytedance.android.live.broadcastgame.opengame.message.g(r102, r107, this.f60788t, r112);
        Disposable r115 = xs2.b.a().b(com.bytedance.android.livesdk.event.z.class).filter(c.f60829a).subscribe(new C1004d(this, r107));
        Intrinsics.checkNotNullParameter(r115, "$this$autoDispose");
        this.f60868m.a(r115);
        this.f60860e = r214;
        if (r114 == null) goto L43;
        r114.c();
    L43:
        x(r110, r102, r109, r210, r211, r212, r213);
        Disposable r116 = ((GamePlayApi) com.bytedance.android.live.network.c.b().e(GamePlayApi.class)).fetchCollectStatus(r102, Long.valueOf(r110)).subscribe(new e(this), f.f60833a);
        Intrinsics.checkNotNullParameter(r116, "$this$autoDispose");
        this.f60868m.a(r116);
        return;
    L35:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
        f2.c("room is null", 0);
    L37:
        if (r214 == null) goto L45;
        r214.p("room is null");
        return;
    L45:
        return;
    L21:
        r107 = -1;
        goto L22
    L14:
        r110 = 0;
        goto L15
    }
}
