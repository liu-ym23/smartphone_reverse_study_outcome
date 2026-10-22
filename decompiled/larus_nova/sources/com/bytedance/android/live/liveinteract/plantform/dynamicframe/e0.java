package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.tp;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f76917o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f76918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f76919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f76920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ih0.c f76921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ih0.c f76922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f76923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f76924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<JsonObject> f76925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<JsonObject> f76926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<JsonObject> f76927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRoom f76928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JsonObject f76929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f76930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSEventConsumer f76931n;

    public static final class a {
        public static Context a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if ((r100 instanceof MutableContextWrapper) == false) goto L5;
            return r100;
        L5:
            return new MutableContextWrapper(r100);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ih0.c f76932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f76933b;

        public b(ih0.c r100, Map r101) {
            this.f76932a = r100;
            this.f76933b = r101;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
            ih0.c r100 = this.f76932a;
            if (r100 == null) goto L5;
            ih0.c.a.a(r100, null, this.f76933b, 3);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f76934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f76935b;

        public c(e0 r100, Map r101) {
            this.f76934a = r100;
            this.f76935b = r101;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card start");
            ih0.c r100 = this.f76934a.f76922e;
            if (r100 == null) goto L5;
            ih0.c.a.a(r100, null, this.f76935b, 3);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card end");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static JsonObject d() {
        JsonObject r100 = new JsonObject();
        int r101 = com.bytedance.android.live.liveinteract.utils.w0.f78836a;
        Iterator r102 = ((List) vm2.h.f556153i6.getValue(null, vm2.h.f556082a[371(0x173, float:5.2E-43)])).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        r100.add(r103, SettingUtilExtensionKt.getRawSettingValue(r103));
        goto L4
    L6:
        return r100;
    }

    public static boolean j() {
        com.bytedance.android.livesdk.gecko.n r100 = com.bytedance.android.livesdk.gecko.n.f125818b;
        r100.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        LiveResourcesDistributionImpl r101 = r100.f125819a;
        r101.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        com.bytedance.android.livesdk.gecko.j r102 = r101.f125787a;
        if (r102 == null) goto L5;
        Long r103 = r102.c();
    L7:
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L10:
        ALogger.d("MultiLinkMainHybridCardManager", "isRenderWidgetStartEventOptGeckoSupportVersion: version=" + r104);
        if (r104 == 0) goto L18;
        if (r104 <= 0) goto L16;
        int r105 = com.bytedance.android.live.liveinteract.utils.w0.f78836a;
        if (r104 < tp.f121316a.getValue().getStartEventOptVersion()) goto L21;
        return true;
    L21:
        return false;
    L16:
        return true;
    L18:
        return false;
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public final JsonObject h() {
        IRoom r100 = com.bytedance.android.live.core.utils.a0.o(this.f76919b);
        z5 r101 = null;
        if (r100 != null) goto L7;
        f2.g();
        Lazy r102 = MultiLinkLoadWidgetUtils.f78649a;
        MultiLinkLoadWidgetUtils.m(this.f76919b, "MultiLinkMainHybridCardManager#geRoomJson", "roomInfo is null");
        return null;
    L7:
        if (this.f76930m == false) goto L34;
        if (this.f76929l == null) goto L27;
        IRoom r103 = this.f76928k;
        if (r103 == null) goto L13;
        z5 r104 = r103.getLinkerDetail();
    L14:
        z5 r105 = r100.getLinkerDetail();
        if (r104 == null) goto L25;
        if (r105 == null) goto L25;
        if (r104 != r105) goto L21;
    L24:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L27;
    L32:
        return this.f76929l;
    L21:
        if (r104.getUiLayout() != r105.getUiLayout()) goto L25;
        if (Intrinsics.areEqual(r104.getPlayModes(), r105.getPlayModes()) == true) goto L24;
    L25:
        r106 = false;
        goto L26
    L13:
        r104 = null;
    L27:
        this.f76928k = r100;
        JsonObject r107 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r100).getAsJsonObject();
        this.f76929l = r107;
        this.f76919b.put("data_room_cache_json", r107);
        Lazy r108 = MultiLinkLoadWidgetUtils.f78649a;
        DataCenter r109 = this.f76919b;
        StringBuilder r110 = new StringBuilder("roomInfo有区别，更新roomInfoJson, linkerDetail=");
        r110.append(r100.getLinkerDetail());
        r110.append(", last=");
        IRoom r111 = this.f76928k;
        if (r111 == null) goto L30;
        r101 = r111.getLinkerDetail();
    L30:
        r110.append(r101);
        MultiLinkLoadWidgetUtils.p(r109, "MultiLinkMainHybridCardManager#geRoomJson", r110.toString());
        goto L32
    L34:
        return GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r100).getAsJsonObject();
    }

    public final void s() {
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L17;
        JSEventConsumer r100 = this.f76931n;
        if (r100 != JSEventConsumer.Dual) goto L7;
    L8:
        Iterator<JsonObject> r101 = this.f76927j.iterator();
    L10:
        if (r101.hasNext() == false) goto L15;
        JsonObject r102 = r101.next();
        ih0.c r103 = this.f76922e;
        if (r103 == null) goto L14;
        r103.sendJsEvent("onLinkmicStatusChange", r102);
    L14:
        o(r102);
    L15:
        this.f76927j.clear();
        return;
    L7:
        if (r100 != JSEventConsumer.RenderWidget) goto L15;
    L17:
        Iterator<JsonObject> r104 = this.f76927j.iterator();
    L19:
        if (r104.hasNext() == false) goto L24;
        JsonObject r105 = r104.next();
        ih0.c r106 = this.f76922e;
        if (r106 == null) goto L23;
        r106.sendJsEvent("onLinkmicStatusChange", r105);
    L23:
        o(r105);
        goto L19
    L24:
        this.f76927j.clear();
    }

    public static final void a(e0 r100) {
        r100.getClass();
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L37;
        JSEventConsumer r101 = r100.f76931n;
        if (r101 != JSEventConsumer.Dual) goto L7;
    L29:
        Iterator<JsonObject> r102 = r100.f76926i.iterator();
    L31:
        if (r102.hasNext() == false) goto L36;
        JsonObject r103 = r102.next();
        ih0.c r104 = r100.f76921d;
        if (r104 == null) goto L35;
        r104.sendJsEvent("onLinkmicStatusChange", r103);
    L35:
        r100.o(r103);
    L36:
        r100.f76926i.clear();
        r100.f76925h.clear();
        return;
    L7:
        if (r101 == JSEventConsumer.RootWidget) goto L29;
        if (r101 == JSEventConsumer.LogicWidget) goto L29;
        if (r101 == JSEventConsumer.FeedRootWidget) goto L29;
        if (r101 == JSEventConsumer.RenderWidget) goto L15;
    L22:
        Iterator<JsonObject> r105 = r100.f76925h.iterator();
    L24:
        if (r105.hasNext() == false) goto L36;
        JsonObject r106 = r105.next();
        ih0.c r107 = r100.f76921d;
        if (r107 == null) goto L28;
        r107.sendJsEvent("onLinkmicStatusChange", r106);
    L28:
        r100.o(r106);
        goto L24
    L15:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L17;
    L19:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L22;
    L17:
        if (vm2.h.W().installFix() == false) goto L19;
        r108 = true;
        goto L20
    L37:
        Iterator<JsonObject> r109 = r100.f76926i.iterator();
    L39:
        if (r109.hasNext() == false) goto L43;
        JsonObject r110 = r109.next();
        ih0.c r111 = r100.f76921d;
        if (r111 == null) goto L39;
        r111.sendJsEvent("onLinkmicStatusChange", r110);
        goto L39
    L43:
        r100.f76926i.clear();
    }

    public static JsonObject f(IRoom r100) {
        JsonObject r101 = new JsonObject();
        if (r100 == null) goto L7;
        z5 r102 = r100.getLinkerDetail();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getUiLayout());
    L8:
        r101.addProperty("ui_layout", r103);
        r101.addProperty("scene", Integer.valueOf(je0.d.f()));
        JsonArray r104 = new JsonArray();
        Iterator<T> r105 = com.bytedance.android.live.liveinteract.plantform.utils.u0.d().iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(Integer.valueOf(((Number) r105.next()).intValue()));
        goto L10
    L12:
        r101.add(FastStartLiveConfig.PLAY_MODE, r104);
        return r101;
    L7:
        r103 = je0.d.h();
        goto L8
    }

    public static Context g(MutableContextWrapper r100) {
        Context r101 = r100.getBaseContext();
        if ((r101 instanceof MutableContextWrapper) == true) goto L5;
        return r101;
    L5:
        return g((MutableContextWrapper) r101);
    }

    public final Map<String, String> e(Long r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = null;
        if (r100 != null) goto L10;
        com.bytedance.live.datacontext.m<IRoom> r103 = o3.j(this.f76919b).getRoom();
        if (r103 == null) goto L9;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L9;
        Object r105 = r104.getIdStr();
    L11:
        com.bytedance.live.datacontext.m<IRoom> r106 = o3.j(this.f76919b).getRoom();
        if (r106 == null) goto L16;
        IRoom r107 = r106.getValue();
        if (r107 == null) goto L16;
        String r108 = r107.getOwnerUserIdString();
    L17:
        String r109 = gh0.a.c();
        if (r105 == null) goto L20;
        r101.put("room_id", r105.toString());
    L20:
        if (r108 == null) goto L23;
        r101.put("anchor_id", r108);
    L23:
        if (r2.a(r109) == false) goto L25;
        r102 = r109;
    L25:
        if (r102 == null) goto L27;
        r101.put("user_id", r102);
    L27:
        r101.put("is_feed", "0");
        ALogger.i("MultiLinkMainHybridCardManager", "获取更新GlobalProps, mHybridCard=" + this.f76921d + ", roomId=" + r100 + ", anchorId=" + r108 + ", userId=" + r109 + ", is_feed=0");
        return r101;
    L16:
        r108 = null;
    L9:
        r105 = null;
        goto L11
    L10:
        r105 = r100;
        goto L11
    }

    public final void i(JsonObject r100) {
        boolean r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        com.bytedance.live.datacontext.m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r102 == null) goto L5;
        IRoom r103 = r102.getValue();
    L5:
        List r104 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.b(0);
        if (r104 != null) goto L8;
        r104 = CollectionsKt.emptyList();
    L8:
        JsonArray r105 = new JsonArray();
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L13;
        r105.add(new JsonPrimitive((String) r106.next()));
        goto L10
    L13:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L15;
    L17:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L21;
        JsonElement r108 = h();
        if (r108 != null) goto L34;
        boolean r109 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L34;
        f2.c("room_id异常 null", 0);
    L34:
        if (r108 == null) goto L36;
        r100.add("room", r108);
    L36:
        r100.add("dynamic_seat_support_list", r105);
        r100.addProperty("dynamic_seat_support_all", Boolean.valueOf(vm2.d.d0().c()));
        return;
    L21:
        if (r100.has("room") == true) goto L36;
        JsonElement r110 = h();
        if (r110 != null) goto L27;
        boolean r111 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L27;
        f2.c("room_id异常 null", 0);
    L27:
        if (r110 == null) goto L36;
        r100.add("room", r110);
        goto L36
    L15:
        if (vm2.h.W().startEventRoomOpt() == false) goto L17;
        r107 = true;
        goto L19
    }

    public final void l(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(r100);
        if (je0.d.r() == true) goto L34;
        com.bytedance.live.datacontext.m<IRoom> r102 = o3.j(this.f76919b).getRoom();
        boolean r103 = false;
        if (r102 == null) goto L16;
        IRoom r104 = r102.getValue();
        if (r104 == null) goto L16;
        IBaseUser r105 = r104.getOwner();
        if (r105 == null) goto L16;
        py.k r106 = r105.getAvatarMedium();
        if (r106 == null) goto L16;
        List<String> r107 = r106.getUrls();
        if (r107 == null) goto L16;
        String r108 = (String) CollectionsKt.getOrNull(r107, 0);
        if (r108 == null) goto L16;
    L17:
        r101.put("anchor_avatar_url", r108);
        com.bytedance.live.datacontext.m<IRoom> r109 = o3.j(this.f76919b).getRoom();
        if (r109 == null) goto L24;
        IRoom r110 = r109.getValue();
        if (r110 == null) goto L24;
        IRoomBasisData r111 = r110.getBasisRoomData();
        if (r111 == null) goto L24;
        Boolean r112 = r111.isCustomizeAudioRoom();
    L25:
        r101.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r112, Boolean.TRUE)));
        com.bytedance.live.datacontext.m<IRoom> r113 = o3.j(this.f76919b).getRoom();
        if (r113 == null) goto L32;
        IRoom r114 = r113.getValue();
        if (r114 == null) goto L32;
        if (r114.isLiveTypeAudio() != true) goto L32;
        r103 = true;
    L32:
        r101.put("is_live_audio", String.valueOf(r103));
    L24:
        r112 = null;
    L16:
        r108 = "";
    L34:
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L36;
        Schedulers.io().scheduleDirect(new c(this, r101));
        return;
    L36:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card 2 start");
        ih0.c r115 = this.f76922e;
        if (r115 == null) goto L41;
        ih0.c.a.a(r115, null, r101, 3);
        return;
    }

    public final void n(JsonObject r100) {
        ih0.c r101 = this.f76921d;
        Object r102 = null;
        if (r101 == null) goto L7;
        View r103 = r101.S0();
        if (r103 == null) goto L7;
        Object r104 = r103.getTag(R.id.ttlive_multilink_hybrid_card_reuse_tag);
    L9:
        if ((r104 instanceof Boolean) == true) goto L11;
        r104 = null;
    L11:
        Boolean r105 = (Boolean) r104;
        boolean r106 = false;
        if (r105 == null) goto L14;
        boolean r107 = r105.booleanValue();
    L15:
        ih0.c r108 = this.f76922e;
        if (r108 == null) goto L20;
        View r109 = r108.S0();
        if (r109 == null) goto L20;
        Object r110 = r109.getTag(R.id.ttlive_multilink_hybrid_card_reuse_tag);
    L22:
        if ((r110 instanceof Boolean) == false) goto L25;
        r102 = r110;
    L25:
        Boolean r111 = (Boolean) r102;
        if (r111 == null) goto L28;
        r106 = r111.booleanValue();
    L28:
        r100.addProperty("root_widget_reuse", Boolean.valueOf(r107));
        r100.addProperty("render_widget_reuse", Boolean.valueOf(r106));
        int r112 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r113 = this.f76919b;
        com.bytedance.live.datacontext.m<IRoom> r114 = o3.j(r113).getRoom();
        long r115 = 0;
        if (r114 == null) goto L33;
        IRoom r116 = r114.getValue();
        if (r116 == null) goto L33;
        long r117 = r116.getRoomId();
    L34:
        MultiSceneEnterRoomStatisticsUtils r118 = MultiSceneEnterRoomStatisticsUtils.a.a(r113, Long.valueOf(r117));
        if (r118 == null) goto L37;
        r118.f78659i = r107;
    L37:
        DataCenter r119 = this.f76919b;
        com.bytedance.live.datacontext.m<IRoom> r120 = o3.j(r119).getRoom();
        if (r120 == null) goto L42;
        IRoom r121 = r120.getValue();
        if (r121 == null) goto L42;
        r115 = r121.getRoomId();
    L42:
        MultiSceneEnterRoomStatisticsUtils r122 = MultiSceneEnterRoomStatisticsUtils.a.a(r119, Long.valueOf(r115));
        if (r122 == null) goto L46;
        r122.f78660j = r106;
        return;
    L46:
        return;
    L33:
        r117 = 0;
    L20:
        r110 = null;
        goto L22
    L14:
        r107 = false;
    L7:
        r104 = null;
        goto L9
    }

    public final void o(JsonObject r100) {
        JsonElement r101 = r100.get("type");
        if (r101 == null) goto L6;
        String r102 = r101.getAsString();
        if (r102 == null) goto L6;
    L7:
        int r103 = r102.hashCode();
        long r104 = 0;
        if (r103 == (-1753865563)) goto L35;
        if (r103 == 177093645) goto L25;
        if (r103 == 2011270307) goto L15;
        return;
    L15:
        if (r102.equals("layout_info") == false) goto L45;
        int r105 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r106 = this.f76919b;
        com.bytedance.live.datacontext.m<IRoom> r107 = o3.j(r106).getRoom();
        if (r107 == null) goto L21;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L21;
        r104 = r108.getRoomId();
    L21:
        MultiSceneEnterRoomStatisticsUtils r109 = MultiSceneEnterRoomStatisticsUtils.a.a(r106, Long.valueOf(r104));
        if (r109 == null) goto L46;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r109, "native_send_layout_info", 0, 2, null);
        return;
    L46:
        return;
    L45:
        return;
    L25:
        if (r102.equals("linkmic") == false) goto L48;
        int r110 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r111 = this.f76919b;
        com.bytedance.live.datacontext.m<IRoom> r112 = o3.j(r111).getRoom();
        if (r112 == null) goto L31;
        IRoom r113 = r112.getValue();
        if (r113 == null) goto L31;
        r104 = r113.getRoomId();
    L31:
        MultiSceneEnterRoomStatisticsUtils r114 = MultiSceneEnterRoomStatisticsUtils.a.a(r111, Long.valueOf(r104));
        if (r114 == null) goto L49;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r114, "native_send_ui_layout", 0, 2, null);
        return;
    L49:
        return;
    L48:
        return;
    L35:
        if (r102.equals("guest_list") == false) goto L51;
        int r115 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        DataCenter r116 = this.f76919b;
        com.bytedance.live.datacontext.m<IRoom> r117 = o3.j(r116).getRoom();
        if (r117 == null) goto L41;
        IRoom r118 = r117.getValue();
        if (r118 == null) goto L41;
        r104 = r118.getRoomId();
    L41:
        MultiSceneEnterRoomStatisticsUtils r119 = MultiSceneEnterRoomStatisticsUtils.a.a(r116, Long.valueOf(r104));
        if (r119 == null) goto L52;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r119, "native_send_guest_list", 0, 2, null);
        return;
    L52:
        return;
    L51:
        return;
    L6:
        r102 = "";
        goto L7
    }

    public final void p(ih0.c r100) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L6;
        if (r100 == null) goto L6;
        r100.r1();
    L6:
        if (r100 == null) goto L8;
        r100.registerMethod("registerMessage", new j0(this));
    L8:
        if (r100 == null) goto L10;
        r100.registerMethod("live.unregisterMessage", new n0(this));
    L10:
        if (r100 == null) goto L12;
        r100.registerMethod("registerMessageLatch", new i0(this));
    L12:
        if (r100 == null) goto L14;
        r100.registerMethod("registerWrds", new k0(this));
    L14:
        if (r100 == null) goto L16;
        r100.registerMethod("live.unregisterWrds", new o0(this));
    L16:
        if (r100 == null) goto L18;
        r100.registerMethod("updateLinkmicStatus", new p0(this));
    L18:
        if (r100 == null) goto L20;
        r100.registerMethod("reportAggregateALog", l0.f77066a);
    L20:
        if (r100 == null) goto L22;
        r100.registerMethod("getLinkmicStatus", new g0(this));
    L22:
        if (r100 == null) goto L24;
        r100.registerMethod("reportLinkmicStatus", m0.f77070a);
    L24:
        if (r100 == null) goto L27;
        r100.registerMethod("getLiveNtpTime", new h0(this));
        return;
    }

    public final void r(boolean r110) {
        long r100 = System.currentTimeMillis();
        if (this.f76924g == false) goto L8;
        if (r110 == false) goto L8;
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L8;
        return;
    L8:
        boolean r101 = false;
        if (r110 == false) goto L11;
        this.f76924g = true;
    L97:
        JsonObject r111 = new JsonObject();     // Catch: JSONException -> L93
        JsonObject r112 = new JsonObject();     // Catch: JSONException -> L93
        if (r110 == false) goto L90;
        DataCenter r102 = this.f76919b;     // Catch: JSONException -> L93
        z5 r113 = null;
        if (r102 == null) goto L18;
        IRoom r103 = com.bytedance.android.live.core.utils.a0.o(r102);     // Catch: JSONException -> L93
    L19:
        if (r103 == null) goto L30;
        String r114 = r103.getIdStr();     // Catch: JSONException -> L93
        if (r114 != null) goto L23;
    L27:
        r112.addProperty("room_id", String.valueOf(r103.getId()));     // Catch: JSONException -> L93
    L28:
        r112.addProperty("anchor_id", r103.getAnchorId());     // Catch: JSONException -> L93
        goto L30
    L23:
        if (r114.length() <= 0) goto L25;
        r101 = true;
    L25:
        if (r101 != true) goto L27;
        r112.addProperty("room_id", r103.getIdStr());     // Catch: JSONException -> L93
    L30:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L65;
        r112.addProperty("dynamic_load_opt", Boolean.TRUE);     // Catch: JSONException -> L93
        r112.add("room", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r103).getAsJsonObject());     // Catch: JSONException -> L93
        if (r103 != null) goto L34;
    L40:
        IInteractService r115 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r115 == null) goto L45;
        rj0.m r116 = r115.getVideoTalkService();     // Catch: JSONException -> L93
        if (r116 == null) goto L45;
        JsonElement r117 = r116.getLinkmicSeatListInfo();     // Catch: JSONException -> L93
    L46:
        r112.add("seat_list_info", r117);     // Catch: JSONException -> L93
        r112.add("linkmic", f(r103));     // Catch: JSONException -> L93
        if (r103 == null) goto L65;
        if (r103.isLiveTypeAudio() == true) goto L65;
        if (r103.isLiveTypeAudio() != true) goto L57;
        IInteractService r104 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r104 == null) goto L62;
        qd0.a r105 = r104.getAudioTalkService();     // Catch: JSONException -> L93
        if (r105 == null) goto L62;
        JsonElement r106 = r105.getLinkmicAreaFrameInfo();     // Catch: JSONException -> L93
    L63:
        if (r106 == null) goto L65;
        r112.add("frame_info", r106);     // Catch: JSONException -> L93
    L62:
        r106 = null;
        goto L63
    L57:
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r107 == null) goto L62;
        rj0.m r108 = r107.getVideoTalkService();     // Catch: JSONException -> L93
        if (r108 == null) goto L62;
        r106 = r108.getLinkmicAreaFrameInfo();     // Catch: JSONException -> L93
    L45:
        r117 = null;
        goto L46
    L34:
        if (r103.isLiveTypeAudio() != true) goto L40;
        IInteractService r118 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r118 == null) goto L45;
        qd0.a r119 = r118.getAudioTalkService();     // Catch: JSONException -> L93
        if (r119 == null) goto L45;
        r117 = r119.getLinkmicSeatListInfo();     // Catch: JSONException -> L93
    L65:
        i(r112);     // Catch: JSONException -> L93
        n(r112);     // Catch: JSONException -> L93
        r112.add("client_settings_info", d());     // Catch: JSONException -> L93
        r112.addProperty("start_event_local_time", Long.valueOf(System.currentTimeMillis()));     // Catch: JSONException -> L93
        r112.addProperty("start_event_ntp_time", Long.valueOf(com.bytedance.android.livesdk.utils.ntp.e.a()));     // Catch: JSONException -> L93
        if (r103 == null) goto L68;
        z5 r109 = r103.getLinkerDetail();     // Catch: JSONException -> L93
    L69:
        if (r109 == null) goto L71;
        r112.add("linker_detail", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r109).getAsJsonObject());     // Catch: JSONException -> L93
    L71:
        DataCenter r120 = this.f76919b;     // Catch: JSONException -> L93
        if (r120 == null) goto L74;
        EnterRoomInfoResult r121 = (EnterRoomInfoResult) r120.get("data_room_enter_info", null);     // Catch: JSONException -> L93
    L75:
        if (r121 == null) goto L77;
        r112.add("enter_info", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r121).getAsJsonObject());     // Catch: JSONException -> L93
    L77:
        r111.add("data", r112);     // Catch: JSONException -> L93
        r111.addProperty("type", "start");     // Catch: JSONException -> L93
        int r122 = MultiSceneEnterRoomStatisticsUtils.f78650u;     // Catch: JSONException -> L93
        DataCenter r123 = this.f76919b;     // Catch: JSONException -> L93
        com.bytedance.live.datacontext.m<IRoom> r124 = o3.j(r123).getRoom();     // Catch: JSONException -> L93
        if (r124 == null) goto L82;
        IRoom r125 = r124.getValue();     // Catch: JSONException -> L93
        if (r125 == null) goto L82;
        long r126 = r125.getRoomId();     // Catch: JSONException -> L93
    L83:
        MultiSceneEnterRoomStatisticsUtils r127 = MultiSceneEnterRoomStatisticsUtils.a.a(r123, Long.valueOf(r126));     // Catch: JSONException -> L93
        if (r127 == null) goto L86;
        r127.recordSubElementShow("send_start_event", System.currentTimeMillis());     // Catch: JSONException -> L93
    L86:
        Lazy r128 = MultiLinkLoadWidgetUtils.f78649a;     // Catch: JSONException -> L93
        DataCenter r129 = this.f76919b;     // Catch: JSONException -> L93
        StringBuilder r130 = new StringBuilder("逻辑主容器发送Start, open = ");     // Catch: JSONException -> L93
        r130.append(r110);     // Catch: JSONException -> L93
        r130.append(", roomInfo.LinkerDetail = ");     // Catch: JSONException -> L93
        if (r103 == null) goto L89;
        r113 = r103.getLinkerDetail();     // Catch: JSONException -> L93
    L89:
        r130.append(r113);     // Catch: JSONException -> L93
        r130.append(", enter_info = ");     // Catch: JSONException -> L93
        r130.append(r121);     // Catch: JSONException -> L93
        r130.append(", stack = ");     // Catch: JSONException -> L93
        r130.append(Log.getStackTraceString(new Throwable()));     // Catch: JSONException -> L93
        MultiLinkLoadWidgetUtils.n(r129, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", r130.toString());     // Catch: JSONException -> L93
    L91:
        q(r111, true);     // Catch: JSONException -> L93
    L95:
        Lazy r131 = MultiLinkLoadWidgetUtils.f78649a;
        MultiLinkLoadWidgetUtils.p(this.f76919b, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", "spendTime = " + (System.currentTimeMillis() - r100));
        return;
    L82:
        r126 = 0;
        goto L83
    L74:
        r121 = null;
        goto L75
    L68:
        r109 = null;
        goto L69
    L18:
        r103 = null;
        goto L19
    L90:
        r112.addProperty("room_id", "");     // Catch: JSONException -> L93
        r111.add("data", r112);     // Catch: JSONException -> L93
        r111.addProperty("type", BasicTestActionHandler.TEST_ACTION_RESET);     // Catch: JSONException -> L93
        Lazy r132 = MultiLinkLoadWidgetUtils.f78649a;     // Catch: JSONException -> L93
        MultiLinkLoadWidgetUtils.n(this.f76919b, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", "逻辑主容器发送Reset, stack = " + Log.getStackTraceString(new Throwable()));     // Catch: JSONException -> L93
    L93:
        e = move-exception;
        ALogger.e("MainRootWidget", e.toString());
        goto L95
    L11:
        this.f76924g = false;
        goto L97
    }

    public static final void b(e0 r100, ih0.c r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        if (je0.d.r() == true) goto L33;
        com.bytedance.live.datacontext.m<IRoom> r103 = o3.j(r100.f76919b).getRoom();
        boolean r104 = false;
        if (r103 == null) goto L16;
        IRoom r105 = r103.getValue();
        if (r105 == null) goto L16;
        IBaseUser r106 = r105.getOwner();
        if (r106 == null) goto L16;
        py.k r107 = r106.getAvatarMedium();
        if (r107 == null) goto L16;
        List<String> r108 = r107.getUrls();
        if (r108 == null) goto L16;
        String r109 = (String) CollectionsKt.getOrNull(r108, 0);
        if (r109 == null) goto L16;
    L17:
        r102.put("anchor_avatar_url", r109);
        com.bytedance.live.datacontext.m<IRoom> r110 = o3.j(r100.f76919b).getRoom();
        if (r110 == null) goto L24;
        IRoom r111 = r110.getValue();
        if (r111 == null) goto L24;
        IRoomBasisData r112 = r111.getBasisRoomData();
        if (r112 == null) goto L24;
        Boolean r113 = r112.isCustomizeAudioRoom();
    L25:
        r102.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r113, Boolean.TRUE)));
        com.bytedance.live.datacontext.m<IRoom> r114 = o3.j(r100.f76919b).getRoom();
        if (r114 == null) goto L32;
        IRoom r115 = r114.getValue();
        if (r115 == null) goto L32;
        if (r115.isLiveTypeAudio() != true) goto L32;
        r104 = true;
    L32:
        r102.put("is_live_audio", String.valueOf(r104));
    L24:
        r113 = null;
    L16:
        r109 = "";
    L33:
        if (r101 == null) goto L36;
        r101.updateData(r102);
        return;
    }

    public static void k(ih0.c r100, Map r101) {
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L5;
        Schedulers.io().scheduleDirect(new b(r100, r101));
        return;
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        if (r100 == null) goto L10;
        ih0.c.a.a(r100, null, r101, 3);
        return;
    }

    public static void m(View r100, Context r101) {
        if (r100 == null) goto L4;
        Context r102 = r100.getContext();
    L6:
        if ((r102 instanceof MutableContextWrapper) == false) goto L14;
        MutableContextWrapper r103 = (MutableContextWrapper) r102;
        if ((!Intrinsics.areEqual(r103.getBaseContext(), r101)) == true) goto L10;
        return;
    L10:
        if ((r101 instanceof MutableContextWrapper) == false) goto L12;
        r101 = g((MutableContextWrapper) r101);
    L12:
        r103.setBaseContext(r101);
        return;
    L14:
        return;
    L4:
        r102 = null;
        goto L6
    }

    public final void q(JsonObject r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonData");
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L34;
        if (r101 == false) goto L8;
        ih0.c r102 = this.f76921d;
        if (r102 == null) goto L40;
        r102.sendJsEvent("onLinkmicStatusChange", r100);
    L40:
        ih0.c r103 = this.f76921d;
        Boolean r104 = null;
        if (r103 == null) goto L43;
        Boolean r105 = r103.A();
    L44:
        Boolean r106 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r105, r106)) == false) goto L49;
        this.f76926i.add(r100);
        if (r101 == false) goto L49;
        this.f76925h.add(r100);
    L49:
        ih0.c r107 = this.f76922e;
        if (r107 == null) goto L52;
        Boolean r108 = r107.A();
    L54:
        if ((!Intrinsics.areEqual(r108, r106)) == false) goto L56;
        this.f76927j.add(r100);
    L56:
        ih0.c r109 = this.f76921d;
        if (r109 == null) goto L59;
        Boolean r110 = r109.A();
    L61:
        if (Intrinsics.areEqual(r110, r106) == true) goto L67;
        ih0.c r111 = this.f76922e;
        if (r111 == null) goto L66;
        r104 = r111.A();
    L66:
        if (Intrinsics.areEqual(r104, r106) == true) goto L67;
        return;
    L67:
        o(r100);
        return;
    L59:
        r110 = null;
        goto L61
    L52:
        r108 = null;
        goto L54
    L43:
        r105 = null;
        goto L44
    L8:
        int r112 = f0.f76942a[this.f76931n.ordinal()];
        if (r112 != 1) goto L11;
    L31:
        ih0.c r113 = this.f76921d;
        if (r113 == null) goto L40;
        r113.sendJsEvent("onLinkmicStatusChange", r100);
        goto L40
    L11:
        if (r112 == 2) goto L31;
        if (r112 == 3) goto L31;
        if (r112 != 4) goto L17;
        ih0.c r114 = this.f76921d;
        if (r114 == null) goto L28;
        r114.sendJsEvent("onLinkmicStatusChange", r100);
    L28:
        ih0.c r115 = this.f76922e;
        if (r115 == null) goto L40;
        r115.sendJsEvent("onLinkmicStatusChange", r100);
        goto L40
    L17:
        if (r112 != 5) goto L40;
        ih0.c r116 = this.f76921d;
        if (r116 == null) goto L22;
        r116.sendJsEvent("onLinkmicStatusChange", r100);
    L22:
        ih0.c r117 = this.f76922e;
        if (r117 == null) goto L40;
        r117.sendJsEvent("onLinkmicStatusChange", r100);
        goto L40
    L34:
        ih0.c r118 = this.f76921d;
        if (r118 == null) goto L37;
        r118.sendJsEvent("onLinkmicStatusChange", r100);
    L37:
        ih0.c r119 = this.f76922e;
        if (r119 == null) goto L40;
        r119.sendJsEvent("onLinkmicStatusChange", r100);
        goto L40
    }

    public final void t(nh0.f r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "json");
        j r102 = this.f76923f;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public e0(Context r100, DataCenter r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "mLinkRootView");
        this.f76925h = new ArrayList();
        this.f76926i = new ArrayList();
        this.f76927j = new ArrayList();
        int r103 = com.bytedance.android.live.liveinteract.utils.w0.f78836a;
        this.f76930m = vm2.h.i().enableJsbTransferOpt();
        this.f76931n = JSEventConsumer.Dual;
        this.f76918a = a.a(r100);
        this.f76919b = r101;
        this.f76920c = r102;
    }

    public static final void c(e0 r100, ih0.c r101, Long r102) {
        r100.getClass();
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = null;
        if (r102 != null) goto L10;
        com.bytedance.live.datacontext.m<IRoom> r105 = o3.j(r100.f76919b).getRoom();
        if (r105 == null) goto L9;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L9;
        Object r107 = r106.getIdStr();
    L11:
        com.bytedance.live.datacontext.m<IRoom> r108 = o3.j(r100.f76919b).getRoom();
        if (r108 == null) goto L16;
        IRoom r109 = r108.getValue();
        if (r109 == null) goto L16;
        String r110 = r109.getOwnerUserIdString();
    L17:
        String r111 = gh0.a.c();
        ALogger.i("MultiLinkMainHybridCardManager", "更新GlobalProps, mHybridCard=" + r100.f76921d + ", roomId=" + r102 + ", anchorId=" + r110 + ", userId=" + r111 + ", is_feed=0");
        if (r107 == null) goto L20;
        r103.put("room_id", r107.toString());
    L20:
        if (r110 == null) goto L23;
        r103.put("anchor_id", r110);
    L23:
        if (r2.a(r111) == false) goto L25;
        r104 = r111;
    L25:
        if (r104 == null) goto L27;
        r103.put("user_id", r104);
    L27:
        r103.put("is_feed", "0");
        if (r101 == null) goto L31;
        r101.updateGlobalProps(r103);
        return;
    L31:
        return;
    L16:
        r110 = null;
    L9:
        r107 = null;
        goto L11
    L10:
        r107 = r102;
        goto L11
    }
}
