package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.iq0;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdk.config.wh;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.q3;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0004\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/room/discovery/NetSpeedMonitorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lo70/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NetSpeedMonitorWidget extends LiveRecyclableWidget implements o70.a, Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final TokenCert f99330m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetSpeedImageView f99331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetSpeedTextView f99332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f99333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f99334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f99335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f99336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f99337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveNetworkBroadcastReceiver f99338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f99339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f99340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f99341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f99342l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f99343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f99344b;

        /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.NetSpeedMonitorWidget$a$a, reason: collision with other inner class name */
        public static final class C1520a {
        }

        static {
        }

        public a() {
        }
    }

    public static final class b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f99345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NetSpeedMonitorWidget f99346b;

        public final String a() {
            if (((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).P() == false) goto L5;
            return "1";
        L5:
            DataCenter r100 = this.f99346b.dataCenter;
            int r101 = 0;
            if (r100 == null) goto L10;
            Integer r102 = (Integer) r100.get("data_link_state", 0);
            if (r102 == null) goto L10;
            r101 = r102.intValue();
        L10:
            if (r101 != 0) goto L12;
            return "0";
        L12:
            if (r101 == 2) goto L16;
            return "1";
        L16:
            return "0";
        }

        public c(NetSpeedMonitorWidget r100) {
            this.f99346b = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f99347a;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            int r100 = this.f99347a;
            if (r100 != 1) goto L5;
            return "good";
        L5:
            if (r100 == 2) goto L7;
            return "stuck";
        L7:
            return SRStrategy.KEY_BITRATE_AFTER_DOWNGRADE;
        }

        public d() {
            this.f99347a = 1;
        }
    }

    public static final class e implements r81.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetSpeedMonitorWidget f99348a;

        @Override // r81.a
        public final void onLowMemory() {
            RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f99348a.dataCenter, 0, 2);
            if (r100 == null) goto L10;
            com.bytedance.live.datacontext.i<Boolean> r101 = r100.isLiveEnd();
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.getValue().booleanValue() == true) goto L12;
            ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).handleLowMemory();
            return;
        L12:
            return;
        }

        public e(NetSpeedMonitorWidget r100) {
            this.f99348a = r100;
        }
    }

    public static final class f implements LiveNetworkBroadcastReceiver.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetSpeedMonitorWidget f99349a;

        public f(NetSpeedMonitorWidget r100) {
            this.f99349a = r100;
        }

        @Override // com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver.a
        public final void a(NetworkUtils.NetworkType r100) {
            NetSpeedMonitorWidget r101 = this.f99349a;
            if (r100 != NetworkUtils.NetworkType.NONE) goto L5;
            boolean r102 = true;
        L6:
            r101.f99337g = r102;
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{p0.class, zg1.m0.class});
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_internet_speed_monitor;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a233";
    }

    static {
        f99330m = TokenCert.Companion.with("bpea-bpea-live_netspeedmonitor_get_network_type");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        LiveNetworkBroadcastReceiver r100 = this.f99338h;
        r100.c(this.f99339i);
        r100.d();
        r81.b r101 = r81.b.f536504b;
        jc1.a.b().unregisterComponentCallbacks(r101);
        r81.b.f536503a = null;
    }

    public NetSpeedMonitorWidget() {
        this.f99333c = LazyKt.lazy(NetSpeedMonitorWidget$status$2.INSTANCE);
        this.f99334d = LazyKt.lazy(NetSpeedMonitorWidget$reminder$2.INSTANCE);
        this.f99335e = LazyKt.lazy(new NetSpeedMonitorWidget$logger$2(this));
        this.f99336f = new CompositeDisposable();
        this.f99338h = new LiveNetworkBroadcastReceiver();
        this.f99339i = new f(this);
        this.f99342l = new e(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f99336f.clear();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L42;
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        int r104 = 0;
        if (r103 == (-738124344)) goto L23;
        if (r103 == 1060055221) goto L10;
        return;
    L10:
        if (r102.equals("data_keyboard_status") == false) goto L43;
        Boolean r105 = Boolean.TRUE;
        Boolean r106 = (Boolean) r101.getData(r105);
        if (r106 == null) goto L15;
        r105 = r106;
    L15:
        boolean r107 = r105.booleanValue();
        this.f99340j = r107;
        View r108 = this.contentView;
        if (r108 == null) goto L44;
        if (r107 == false) goto L19;
    L20:
        r104 = 8;
    L21:
        r108.setVisibility(r104);
        return;
    L19:
        if (this.f99341k == false) goto L21;
    L44:
        return;
    L43:
        return;
    L23:
        if (r102.equals("cmd_official_inspector") == false) goto L46;
        com.bytedance.android.live.room.discovery.inspector.a r109 = (com.bytedance.android.live.room.discovery.inspector.a) r101.getData();
        if (r109 == null) goto L51;
        int r110 = r109.getType();
        if (r110 != 0) goto L30;
        this.f99341k = true;
        View r111 = this.contentView;
        if (r111 == null) goto L49;
        r111.setVisibility(8);
        return;
    L49:
        return;
    L30:
        if (r110 != 2) goto L52;
        this.f99341k = false;
        View r112 = this.contentView;
        if (r112 != null) goto L35;
        return;
    L35:
        if (this.f99340j == false) goto L37;
        r104 = 8;
    L37:
        r112.setVisibility(r104);
        return;
    L52:
        return;
    L51:
        return;
    L46:
        return;
    }

    @Override // o70.a
    public void onEvent(o70.b r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof p0) == false) goto L46;
        int r111 = ((p0) r110).f99577a;
        if (this.f99337g == false) goto L7;
        r111 = 3;
    L7:
        if (r111 == 0) goto L57;
        ((d) this.f99333c.getValue()).f99347a = r111;
        ((c) this.f99335e.getValue()).f99345a = ((d) this.f99333c.getValue()).toString();
        NetSpeedTextView r100 = this.f99332b;
        if (r100 == null) goto L18;
        if (r111 == 1) goto L17;
        if (r111 == 2) goto L16;
        if (r111 != 3) goto L18;
        r100.setText(R.string.live_room_internet_speed_status_stuck);
        goto L18
    L16:
        r100.setText(R.string.live_room_internet_speed_status_bad);
        goto L18
    L17:
        r100.setText(R.string.live_room_internet_speed_status_good);
    L18:
        NetSpeedImageView r101 = this.f99331a;
        if (r101 == null) goto L27;
        if (r111 == 1) goto L26;
        if (r111 == 2) goto L25;
        if (r111 != 3) goto L27;
        r101.setImageResource(R.drawable.ttlive_ic_speed_status_stuck);
        goto L27
    L25:
        r101.setImageResource(R.drawable.ttlive_ic_speed_status_bad);
        goto L27
    L26:
        r101.setImageResource(R.drawable.ttlive_ic_speed_status_good);
    L27:
        a r102 = (a) this.f99334d.getValue();
        Function0<Unit> r103 = new NetSpeedMonitorWidget$onNetworkStatus$1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "closure");
        if (r111 == 3) goto L30;
        r102.f99344b = 0;
    L41:
        if (UIUtils.isViewVisible(this.containerView) == false) goto L53;
        c r112 = (c) this.f99335e.getValue();
        String r104 = r112.f99345a;
        if (r104 == null) goto L54;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_netspeed_show", MapsKt.mapOf(new Pair[]{TuplesKt.to(FeatureManager.NET_SPEED, r104), TuplesKt.to("is_connection", r112.a())}), new Object[]{Room.class});
        return;
    L54:
        return;
    L53:
        return;
    L30:
        long r105 = System.currentTimeMillis();
        if (r102.f99344b != 0) goto L34;
        r102.f99344b = r105;
    L34:
        if ((r105 - r102.f99344b) < 9000) goto L41;
        if ((r105 - r102.f99343a) < TimeUnit.MINUTES.toMillis(1)) goto L41;
        r102.f99343a = r105;
        r102.f99344b = 0;
        f2.b(R.string.live_room_internet_speed_remind, 1);
        r103.invoke();
        goto L41
    L57:
        return;
    L46:
        if ((r110 instanceof zg1.m0) == false) goto L56;
        boolean r113 = ((zg1.m0) r110).f571878a;
        View r106 = this.contentView;
        if (r113 == false) goto L50;
        float r114 = 0.0f;
    L51:
        r106.setAlpha(r114);
        return;
    L50:
        r114 = 1.0f;
        goto L51
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99331a = (NetSpeedImageView) findViewById(R.id.icon_status_iv);
        this.f99332b = (NetSpeedTextView) findViewById(R.id.tip_status_tv);
        Disposable r101 = xs2.b.a().b(q3.class).subscribe(new m0(this));
        this.f99336f.add(r101);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        LiveNetworkBroadcastReceiver r101 = this.f99338h;
        Context r102 = this.context;
        TokenCert r103 = f99330m;
        r101.b(r102, r103);
        r101.a(this.f99339i, r103);
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L5;
        r104.observe("data_keyboard_status", this);
    L5:
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L8;
        r105.observe("cmd_official_inspector", this);
    L8:
        boolean r106 = false;
        LiveMode r107 = null;
        if (wh.f121524a.getValue().booleanValue() == true) goto L11;
    L35:
        boolean r108 = false;
    L36:
        iq0 r109 = iq0.f120473a;
        if (r109.getValue().b() == true) goto L39;
    L54:
        if (r108 == true) goto L56;
        if (r106 == true) goto L56;
        return;
    L56:
        r81.b r110 = r81.b.f536504b;
        e r111 = this.f99342l;
        Intrinsics.checkNotNullParameter(r111, "callback");
        jc1.a.b().registerComponentCallbacks(r110);
        r81.b.f536503a = new WeakReference(r111);
        return;
    L39:
        if (r109.getValue().a() == false) goto L54;
        RoomContext.a r112 = RoomContext.Companion;
        RoomContext r113 = RoomContext.a.c(r112, this.dataCenter, 0, 2);
        if (r113 == null) goto L46;
        com.bytedance.live.datacontext.i<LiveMode> r114 = r113.getLiveMode();
        if (r114 == null) goto L46;
        r107 = r114.getValue();
    L46:
        if (r107 != LiveMode.SCREEN_RECORD) goto L54;
        RoomContext r115 = RoomContext.a.c(r112, this.dataCenter, 0, 2);
        if (r115 == null) goto L54;
        com.bytedance.live.datacontext.i<Boolean> r116 = r115.isAnchor();
        if (r116 == null) goto L54;
        if (r116.getValue().booleanValue() != true) goto L54;
        r106 = true;
        goto L54
    L11:
        if (vh.f121449a.getValue().booleanValue() == false) goto L35;
        RoomContext.a r117 = RoomContext.Companion;
        RoomContext r118 = RoomContext.a.c(r117, this.dataCenter, 0, 2);
        if (r118 == null) goto L17;
        com.bytedance.live.datacontext.i<LiveMode> r119 = r118.getLiveMode();
        if (r119 == null) goto L17;
        LiveMode r120 = r119.getValue();
    L19:
        if (r120 == LiveMode.VIDEO) goto L28;
        RoomContext r121 = RoomContext.a.c(r117, this.dataCenter, 0, 2);
        if (r121 == null) goto L25;
        com.bytedance.live.datacontext.i<LiveMode> r122 = r121.getLiveMode();
        if (r122 == null) goto L25;
        LiveMode r123 = r122.getValue();
    L27:
        if (r123 != LiveMode.MEDIA) goto L35;
    L25:
        r123 = null;
    L28:
        RoomContext r124 = RoomContext.a.c(r117, this.dataCenter, 0, 2);
        if (r124 == null) goto L35;
        com.bytedance.live.datacontext.i<Boolean> r125 = r124.isAnchor();
        if (r125 == null) goto L35;
        if (r125.getValue().booleanValue() != true) goto L35;
        r108 = true;
    L17:
        r120 = null;
        goto L19
    }
}
