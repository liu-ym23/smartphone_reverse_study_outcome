package com.bytedance.android.live.platformplayer.panel;

import am2.x;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g6;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.GameOpenPanelContentAdapterConfig;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;
import com.bytedance.android.livesdkapi.player.LiveZygoteBaseEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class StreamAutoAdapterService implements com.bytedance.android.live.platformplayer.service.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f85729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f85730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f85731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f85732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f85733e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f85734f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f85735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f85736h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f85737i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static DataCenter f85738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f85739k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f85740l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f85741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile boolean f85742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final StreamAutoAdapterService f85743o = null;

    public StreamAutoAdapterService() {
    }

    public static StreamAutoAdapterConfig b() {
        return (StreamAutoAdapterConfig) f85739k.getValue();
    }

    static {
        f85743o = new StreamAutoAdapterService();
        f85729a = LazyKt.lazy(StreamAutoAdapterService$panelObserver$2.INSTANCE);
        f85730b = LazyKt.lazy(StreamAutoAdapterService$msgHandler$2.INSTANCE);
        f85731c = LazyKt.lazy(StreamAutoAdapterService$playerViewHandler$2.INSTANCE);
        f85733e = LazyKt.lazy(StreamAutoAdapterService$gamePlayerViewHandler$2.INSTANCE);
        f85734f = LazyKt.lazy(StreamAutoAdapterService$statusController$2.INSTANCE);
        f85736h = LazyKt.lazy(StreamAutoAdapterService$normalPanelConsumer$2.INSTANCE);
        f85737i = LazyKt.lazy(StreamAutoAdapterService$gamePanelConsumer$2.INSTANCE);
        f85739k = LazyKt.lazy(StreamAutoAdapterService$config$2.INSTANCE);
        f85740l = LazyKt.lazy(StreamAutoAdapterService$gameConfig$2.INSTANCE);
    }

    public static void g(ds0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelEvent");
        if (Intrinsics.areEqual(r100.f469805b, "close") == false) goto L5;
        return;
    L5:
        j0 r101 = j0.l();
        HashMap r102 = new HashMap();
        r102.put("panel_scene", r100.getType().getIdentifier());
        r102.put(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE, "1");
        Unit r103 = Unit.INSTANCE;
        r101.sendLog("livesdk_live_screen_adaptive_strategy", r102, new Object[]{IRoom.class, x.class});
    }

    public final void c(ds0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelEvent");
        if (f85742n == true) goto L6;
        g(r100);
        return;
    L6:
        Lazy r101 = f85734f;
        s r102 = (s) r101.getValue();
        if (((Boolean) r102.f85793i.getValue()).booleanValue() == false) goto L10;
        r102.a(r102.f85792h);
    L10:
        if (r102.f85791g.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        e("in " + ((s) r101.getValue()).f85791g + " disable stream auto adapter");
        return;
    L16:
        DataCenter r104 = f85738j;
        if (r104 == null) goto L21;
        Boolean r105 = (Boolean) r104.get("data_is_portrait", Boolean.TRUE);
        if (r105 == null) goto L21;
        boolean r106 = r105.booleanValue();
    L22:
        c r107 = f85735g;
        if (r107 == null) goto L41;
        Lazy r108 = f85730b;
        boolean r109 = !r106;
        if (r107.b(r100, ((f) r108.getValue()).f85762b, r109) != true) goto L42;
        String r110 = null;
        if (Intrinsics.areEqual(r100.f469805b, "open") == false) goto L34;
        d r111 = f85732d;
        if (r111 == null) goto L43;
        nk r112 = ((f) r108.getValue()).f85762b;
        DataCenter r113 = f85738j;
        if (r113 == null) goto L33;
        r110 = a0.p(r113);
    L33:
        r111.F(r112, r100, r110, Boolean.valueOf(r109));
        return;
    L43:
        return;
    L34:
        d r114 = f85732d;
        if (r114 == null) goto L45;
        DataCenter r115 = f85738j;
        if (r115 == null) goto L39;
        r110 = a0.p(r115);
    L39:
        r114.G(r100, r110, Boolean.valueOf(r109));
        return;
    L45:
        return;
    L42:
        return;
    L41:
        return;
    L21:
        r106 = true;
        goto L22
    L12:
        r103 = false;
        goto L13
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("stream_auto_adapter", r100);
    }

    @Override // com.bytedance.android.live.platformplayer.service.b
    public final void w1(ds0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelEvent");
        if (r100.f469811h == false) goto L5;
        c(r100);
        return;
    L5:
        xs2.b.a().post(r100);
    }

    public static void d(LivePanelType r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        if (f85742n == true) goto L5;
        return;
    L5:
        DataCenter r102 = f85738j;
        if (r102 == null) goto L10;
        Boolean r103 = (Boolean) r102.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        c r105 = f85735g;
        if (r105 != null) goto L14;
        return;
    L14:
        if (r105.a(r100, !r104) != true) goto L20;
        d r106 = f85732d;
        if (r106 == null) goto L21;
        r106.E(r101);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r104 = true;
        goto L11
    }

    public final void i(DataCenter r110, LivePlayerView r111) {
        e("onRoomEnter");
        if (b().getEnable() == true) goto L5;
        return;
    L5:
        if (r110 == null) goto L108;
        if (r111 == null) goto L109;
        f85738j = r110;
        NextLiveData<Boolean> r100 = null;
        if (((LiveMode) r110.get("data_live_mode", null)) != LiveMode.AUDIO) goto L13;
        e("audio room disable stream auto adapter function");
        return;
    L13:
        if (PadConfigUtils.a() == false) goto L16;
        e("pad disable stream auto adapter function");
        return;
    L16:
        boolean r101 = false;
        if (b().getInterceptFold() == true) goto L19;
    L21:
        boolean r102 = false;
    L22:
        if (r102 == false) goto L25;
        e("normal intercept fold screen");
        return;
    L25:
        IRoom r103 = (IRoom) r110.get("data_room", null);
        if (r103 != null) goto L29;
        return;
    L29:
        if (r103.isGameRoom() == 1) goto L31;
    L35:
        boolean r104 = false;
    L36:
        if (r104 == false) goto L38;
    L40:
        boolean r105 = false;
    L42:
        if (r103.getRoomAuthStatus().getStreamAdaptation() != 2) goto L46;
        if (r105 == false) goto L46;
        e("mode normal, room auth disable stream auto adapter function");
        return;
    L46:
        if (r104 == true) goto L48;
        if (r105 == true) goto L48;
    L49:
        f85742n = r101;
        if (f85742n == true) goto L53;
        e("mode game or normal disable, return");
        return;
    L53:
        f85741m = r103.getRoomId();
        e("onRoomEnter dataCenter@" + r110.hashCode() + ", playerView@" + r111.hashCode());
        o r106 = (o) f85729a.getValue();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        r110.observe("cmd_gift_dialog_switch", r106.f85779c);
        f r107 = (f) f85730b.getValue();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        e r108 = new e(r107);
        r107.f85761a.put(Integer.valueOf(r110.hashCode()), r108);
        vlc.d r109 = (vlc.d) r110.get("data_message_manager", null);
        if (r109 == null) goto L57;
        r109.addMessageListener("WebcastRoomStreamAdaptationMessage", r108);
    L57:
        if ((r109 instanceof xlc.a) == true) goto L59;
        r109 = null;
    L59:
        xlc.a r112 = (xlc.a) r109;
        if (r112 == null) goto L62;
        tlc.d r113 = r112.l("WebcastRoomStreamAdaptationMessage");
    L63:
        if (r113 != null) goto L85;
        IRoom r114 = (IRoom) r110.get("data_room", null);
        com.bytedance.android.livesdk.message.cache.a r115 = com.bytedance.android.livesdk.message.cache.a.f153518e;
        if (r114 == null) goto L68;
        String r116 = String.valueOf(r114.getRoomId());
        if (r116 == null) goto L68;
    L69:
        Intrinsics.checkNotNullParameter(r116, "key");
        com.bytedance.android.livesdk.message.cache.a.C2363a r117 = com.bytedance.android.livesdk.message.cache.a.f153514a.get(r116);
        if (r117 != null) goto L72;
        Object r118 = null;
    L76:
        if (r118 == null) goto L85;
        if ((r118 instanceof tlc.d) == true) goto L80;
        r118 = null;
    L80:
        r113 = (tlc.d) r118;
        goto L85
    L72:
        monitor-enter(r115);
        r115.b(r117);     // Catch: Throwable -> L81
        r115.a(r117);     // Catch: Throwable -> L81
        monitor-exit(r115);
        r118 = r117.f153520b;
    L81:
        th = move-exception;
        throw th;
    L68:
        r116 = "";
    L85:
        if ((r113 instanceof nk) == true) goto L87;
        r113 = null;
    L87:
        nk r119 = (nk) r113;
        if (r119 == null) goto L90;
        r107.f85763c.e("load msg from message manager wrds cache");
        r107.a(r119);
    L90:
        if (r104 == false) goto L92;
        f85732d = (a) f85733e.getValue();
        f85735g = (GamePanelEventConsumer) f85737i.getValue();
    L94:
        d r120 = f85732d;
        if (r120 == null) goto L97;
        r120.H(r111);
    L97:
        s r121 = (s) f85734f.getValue();
        r121.getClass();
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        Intrinsics.checkNotNullParameter(r111, "playerView");
        r121.f85785a = new WeakReference(r110);
        r121.f85786b = new WeakReference(r111);
        r110.observe("data_link_state", r121.f85794j, true);
        LifecycleOwner r122 = r110.lifecycleOwner;
        if (r122 == null) goto L104;
        LiveZygoteBaseEventHub r123 = (LiveZygoteBaseEventHub) r110.get("zygote_event_hub", null);
        if (r123 == null) goto L102;
        r100 = r123.getSwitchStreamDataEvent();
    L102:
        if (r100 == null) goto L104;
        r100.observe(r122, new p(r121));
    L104:
        r111.getClient().getEventHub().getSeiUpdate().observe(r111.getClient().getLifecycleOwner(), r121.f85795k);
        return;
    L92:
        if (r105 == false) goto L94;
        f85732d = (t) f85731c.getValue();
        f85735g = (NormalPanelEventConsumer) f85736h.getValue();
        goto L94
    L62:
        r113 = null;
    L48:
        r101 = true;
        goto L49
    L38:
        if (b().getEnable() == false) goto L40;
        r105 = true;
        goto L42
    L31:
        if (((GameOpenPanelContentAdapterConfig) f85740l.getValue()).getSwitch() == false) goto L35;
        if (FoldScreenUtils.f() == true) goto L35;
        r104 = true;
        goto L36
    L19:
        if (FoldScreenUtils.f() == false) goto L21;
        r102 = true;
        goto L22
    L109:
        return;
    }

    public final void j(long r100, DataCenter r101) {
        if (r100 == f85741m) goto L6;
        return;
    L6:
        if (g6.f65308a.getValue().booleanValue() == false) goto L9;
        f85738j = null;
    L9:
        if (f85742n == true) goto L11;
        return;
    L11:
        StringBuilder r102 = new StringBuilder("onRoomExit dataCenter@");
        if (r101 == null) goto L14;
        int r103 = r101.hashCode();
    L15:
        r102.append(r103);
        r102.append('}');
        e(r102.toString());
        o r104 = (o) f85729a.getValue();
        if (r101 == null) goto L18;
        r101.removeObserver("cmd_gift_dialog_switch", r104.f85779c);
    L19:
        ((t) f85731c.getValue()).D();
        d r105 = f85732d;
        if (r105 == null) goto L22;
        r105.D();
    L22:
        s r106 = (s) f85734f.getValue();
        DataCenter r107 = r106.f85785a.get();
        if (r107 == null) goto L25;
        r107.removeObserver(r106.f85794j);
    L25:
        r106.f85791g = "";
        r106.f85792h = null;
        f r108 = (f) f85730b.getValue();
        if (r101 != null) goto L28;
        r108.getClass();
    L32:
        c r109 = f85735g;
        if (r109 == null) goto L35;
        r109.clear();
    L35:
        f85742n = false;
        return;
    L28:
        vlc.l r110 = r108.f85761a.remove(Integer.valueOf(r101.hashCode()));
        vlc.d r111 = (vlc.d) r101.get("data_message_manager", null);
        if (r111 == null) goto L31;
        r111.removeMessageListener(r110);
    L31:
        r108.f85762b = null;
        goto L32
    L18:
        r104.getClass();
        goto L19
    L14:
        r103 = 0;
        goto L15
    }
}
