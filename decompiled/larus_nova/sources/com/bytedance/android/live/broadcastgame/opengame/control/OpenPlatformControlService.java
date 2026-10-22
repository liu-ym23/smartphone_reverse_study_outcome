package com.bytedance.android.live.broadcastgame.opengame.control;

import android.app.Dialog;
import android.content.Context;
import android.util.LruCache;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.message.i0;
import com.bytedance.android.live.broadcastgame.opengame.panel.i;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.g;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.runtime.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdk.wrds.interact.InteractControlSyncModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\b\tB\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/control/OpenPlatformControlService;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "d", "e", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformControlService implements y10.a, i, p, Observer<KVData> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f59839j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractControlSyncModel f59840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f59841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.wrds.interact.a.C2484a f59842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.C2484a>> f59843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.C2484a>> f59844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f59846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PluginContext f59847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i20.a f59848i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformControlService f59854a;

        public a(OpenPlatformControlService r100) {
            this.f59854a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.wrds.interact.a r101 = (com.bytedance.android.livesdk.wrds.interact.a) r100;
            OpenPlatformControlService r102 = this.f59854a;
            String r103 = r101.roomId;
            if (r102.f59847h.f60811o == false) goto L5;
            List<com.bytedance.android.livesdk.wrds.interact.a.C2484a> r104 = r101.anchorOperationList;
        L6:
            OpenPlatformControlService.d(r102, r103, r104);
            return;
        L5:
            r104 = r101.audienceOperationList;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformControlService f59855a;

        public b(OpenPlatformControlService r100) {
            this.f59855a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            OpenPlatformControlService r101 = this.f59855a;
            sc r102 = ((i0.a) r100).f60236a;
            String r103 = r102.roomId;
            if (r101.f59847h.f60811o == false) goto L5;
            List<com.bytedance.android.livesdk.wrds.interact.a.C2484a> r104 = r102.anchorOperationList;
        L6:
            OpenPlatformControlService.d(r101, r103, r104);
            return;
        L5:
            r104 = r102.audienceOperationList;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f59856a = null;

        static {
            f59856a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class d {
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f59857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f59858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformControlService f59859c;

        public final class a extends Dialog {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f59860a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f59861b;

            public a(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                super(r100, R.style.ttlive_live_dialog);
                setCancelable(false);
                setCanceledOnTouchOutside(false);
                setContentView(R.layout.ttlive_dialog_certificate);
                this.f59860a = (TextView) findViewById(R.id.ttlive_open_certificate_btn_cancel);
                this.f59861b = (TextView) findViewById(R.id.ttlive_open_certificate_btn_confirm);
            }
        }

        public e(OpenPlatformControlService r100) {
            this.f59859c = r100;
        }
    }

    public static final class f extends OpenControlDialogManager {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformControlService f59862d;

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void a() {
            super.a();
            OpenPlatformControlService.e(this.f59862d);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void b() {
            super.b();
            OpenPlatformControlService.e(this.f59862d);
        }

        public f(OpenPlatformControlService r100, Context r101) {
            this.f59862d = r100;
            super(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    public final void i() {
        if ((!this.f59843d.isEmpty()) == false) goto L8;
        Pair<String, com.bytedance.android.livesdk.wrds.interact.a.C2484a> r100 = this.f59843d.pop();
        if (r100 == null) goto L9;
        h(r100.getFirst(), r100.getSecond());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        InteractControlSyncModel r100 = this.f59840a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f59843d.clear();
        if ((!this.f59844e.isEmpty()) == false) goto L11;
        Iterator<T> r101 = this.f59844e.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        Pair r102 = (Pair) r101.next();
        h((String) r102.getFirst(), (com.bytedance.android.livesdk.wrds.interact.a.C2484a) r102.getSecond());
    L11:
        this.f59844e.clear();
        DataCenter r103 = this.f59847h.f60805i;
        if (r103 == null) goto L14;
        r103.removeObserver(this);
    L14:
        this.f59848i.b();
    }

    public OpenPlatformControlService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        i20.a r101 = new i20.a();
        this.f59848i = r101;
        this.f59847h = r100;
        this.f59841b = new f(this, r100.i());
        this.f59843d = new LinkedList();
        this.f59844e = new LinkedList();
        Lazy r102 = LazyKt.lazy(new OpenPlatformControlService$roomContext$2(this));
        this.f59845f = r102;
        this.f59846g = new e(this);
        RoomContext r103 = (RoomContext) r102.getValue();
        if (r103 == null) goto L11;
        InteractControlSyncModel r104 = (InteractControlSyncModel) dc2.b.a(n3.g(r103), OpenPlatformControlService$1$1.INSTANCE);
        this.f59840a = r104;
        dc2.c<com.bytedance.android.livesdk.wrds.interact.a> r105 = r104.getInteractControlData();
        if (r105 == null) goto L11;
        Observable<com.bytedance.android.livesdk.wrds.interact.a> r106 = r105.f467852d;
        if (r106 == null) goto L11;
        Disposable r107 = r106.subscribe(new a(this));
        if (r107 == null) goto L11;
        Intrinsics.checkNotNullParameter(r107, "$this$autoDispose");
        r101.a(r107);
    L11:
        c0 r108 = r100.f60808l;
        if (r108 == null) goto L18;
        Observable r109 = r108.a(i0.a.class);
        if (r109 == null) goto L18;
        Disposable r110 = r109.subscribe(new b(this), c.f59856a);
        if (r110 == null) goto L18;
        Intrinsics.checkNotNullParameter(r110, "$this$autoDispose");
        r101.a(r110);
    L18:
        DataCenter r111 = r100.f60805i;
        if (r111 == null) goto L21;
        r111.observe("data_live_mode", this);
    L21:
        DataCenter r112 = r100.f60805i;
        if (r112 == null) goto L25;
        r112.observe("data_link_state", this);
        return;
    }

    public static final void e(OpenPlatformControlService r100) {
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r101 = r100.f59842c;
        if (r101 == null) goto L5;
        Integer r102 = r101.operationType;
    L6:
        if (r102 != null) goto L9;
    L17:
        r100.i();
        return;
    L9:
        if (r102.intValue() != 3) goto L17;
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r103 = r100.f59842c;
        if (r103 == null) goto L15;
        com.bytedance.android.livesdk.wrds.interact.a.b r104 = r103.popBoxContent;
        if (r104 == null) goto L15;
        String r105 = r104.a();
    L16:
        r100.f(r105);
    L15:
        r105 = "unknown";
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    public final void f(String r100) {
        boolean r101 = true;
        if ((!Intrinsics.areEqual(r100, "live_scene_limit")) == true) goto L5;
    L7:
        q r102 = this.f59847h.f60807k;
        if (r100.length() == 0) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L13;
        r100 = "control";
    L13:
        r102.b(r100);
        PluginType r103 = this.f59847h.m();
        if (r103 == null) goto L17;
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a r104 = com.bytedance.android.live.broadcastgame.opengame.behavior.e.f59744a;
        DataCenter r105 = this.f59847h.f60805i;
        Map r106 = MapsKt.emptyMap();
        r104.getClass();
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a.a(r105, r103, r106);
        return;
    L17:
        return;
    L5:
        if ((!Intrinsics.areEqual(r100, "anchor_close")) == false) goto L7;
        int r107 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        PluginContext r108 = this.f59847h;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenPlatformControlService", new Object[]{"add to black list, reason: ", r100, ", name: ", r108.f60809m.b(r108.f60811o), ", appid: ", this.f59847h.f60809m.f61083i});
        String r109 = ((BootInfoService) this.f59847h.o(BootInfoService.class)).e();
        LruCache<String, byte[]> r110 = ReportPicUploader.f59913a;
        String r111 = this.f59847h.f60809m.f61083i;
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r109, "gameTye");
        ReportPicUploader.f59915c.put(r111, new ReportPicUploader.a(r100, r109));
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        InteractControlSyncModel r101 = this.f59840a;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        this.f59843d.clear();
        this.f59848i.b();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 == null) goto L39;
        int r103 = r102.hashCode();
        if (r103 == 872172481) goto L17;
        if (r103 == 1691407041) goto L14;
        return;
    L14:
        if (r102.equals("data_live_mode") == true) goto L19;
        return;
    L19:
        if (this.f59847h.f60809m.f61089o == PluginType.MINI_APP) goto L41;
        int r104 = j.a();
        g r105 = ((BootInfoService) this.f59847h.o(BootInfoService.class)).c();
        if (r105 == null) goto L28;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r106 = r105.f60835b;
        if (r106 == null) goto L28;
        List<Integer> r107 = r106.f60843e;
        if (r107 == null) goto L28;
        boolean r108 = r107.contains(Integer.valueOf(r104));
    L29:
        if (r108 == true) goto L38;
        com.bytedance.android.livesdk.wrds.interact.a.b r109 = new com.bytedance.android.livesdk.wrds.interact.a.b();
        if (this.f59847h.f60811o == false) goto L33;
        r109.iconType = 3;
        r109.description = s1.B(R.string.ttlive_open_platform_control_switch_dialog_msg_anchor);
        r109.largeType = 3;
    L34:
        Intrinsics.checkNotNullParameter("live_scene_limit", "value");
        r109.mControlType = "live_scene_limit";
        r109.countDownSec = 45;
        r109.title = s1.B(R.string.ttlive_open_platform_control_switch_dialog_title);
        r109.buttonDesc = s1.B(R.string.ttlive_open_platform_control_confirm_close);
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r110 = new com.bytedance.android.livesdk.wrds.interact.a.C2484a();
        r110.popBoxContent = r109;
        r110.appId = this.f59847h.f60809m.f61083i;
        r110.operationType = 3;
        r110.b(1);
        h(String.valueOf(this.f59847h.f60809m.f61075a), r110);
        return;
    L33:
        r109.description = s1.B(R.string.ttlive_open_platform_control_switch_dialog_msg_audience);
        r109.largeType = 2;
        goto L34
    L38:
        return;
    L28:
        r108 = true;
        goto L29
    L41:
        return;
    L17:
        if (r102.equals("data_link_state") == true) goto L19;
        return;
    L39:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void h(String r110, final com.bytedance.android.livesdk.wrds.interact.a.C2484a r111) {
        String r100 = null;
        if ((!Intrinsics.areEqual(String.valueOf(this.f59847h.f60809m.f61075a), r110)) == true) goto L5;
    L6:
        String r101 = this.f59847h.f60809m.f61083i;
        if (r111 == null) goto L9;
        String r102 = r111.appId;
    L11:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L13;
    L68:
        i();
        int r103 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        StringBuilder r104 = new StringBuilder("process InteractControlData error dataRoomId:");
        r104.append(r110);
        r104.append(", dataAppId:");
        if (r111 == null) goto L71;
        r100 = r111.appId;
    L71:
        r104.append(r100);
        com.bytedance.android.live.broadcastgame.opengame.q.h(r104.toString());
        return;
    L13:
        if (r111.operationType == null) goto L68;
        if (r111.popBoxContent == null) goto L68;
        Integer r105 = r111.a();
        if (r105 != null) goto L21;
    L23:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r106 = this.f59841b.f60106a;
        if (r106 != null) goto L26;
    L27:
        e.a r107 = this.f59846g.f59858b;
        if (r107 == null) goto L30;
        boolean r108 = r107.isShowing();
    L31:
        if (r108 == false) goto L54;
    L32:
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r109 = this.f59842c;
        if (r109 == null) goto L37;
        com.bytedance.android.livesdk.wrds.interact.a.b r112 = r109.popBoxContent;
        if (r112 == null) goto L37;
        String r113 = r112.a();
    L39:
        if (Intrinsics.areEqual(r113, "live_scene_limit") == false) goto L52;
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r114 = this.f59842c;
        if (r114 == null) goto L45;
        com.bytedance.android.livesdk.wrds.interact.a.b r115 = r114.popBoxContent;
        if (r115 == null) goto L45;
        String r116 = r115.a();
    L46:
        com.bytedance.android.livesdk.wrds.interact.a.b r117 = r111.popBoxContent;
        if (r117 == null) goto L50;
        r100 = r117.a();
    L50:
        if (Intrinsics.areEqual(r116, r100) == false) goto L52;
        return;
    L45:
        r116 = null;
    L52:
        this.f59843d.add(TuplesKt.to(r110, r111));
        return;
    L37:
        r113 = null;
        goto L39
    L54:
        this.f59842c = r111;
        final com.bytedance.android.livesdk.wrds.interact.a.b r118 = r111.popBoxContent;
        if (r118 == null) goto L57;
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPlatformControlService$processInteractControlDataAndShow$$inlined$let$lambda$1(r118, this, r111), 7);
    L57:
        Integer r119 = r111.operationType;
        if (r119 != null) goto L61;
        return;
    L61:
        if (r119.intValue() != 2) goto L73;
        com.bytedance.android.livesdk.wrds.interact.a.b r120 = r111.popBoxContent;
        if (r120 == null) goto L65;
        String r121 = r120.a();
    L66:
        f(r121);
        return;
    L65:
        r121 = "unknown";
        goto L66
    L73:
        return;
    L30:
        r108 = false;
        goto L31
    L26:
        if (r106.isShowing() == true) goto L32;
    L21:
        if (r105.intValue() != 2) goto L23;
        r111.operationType = 1;
        goto L23
    L9:
        r102 = null;
        goto L11
    L5:
        if (v.a() == false) goto L68;
        goto L6
    }

    public static final void d(OpenPlatformControlService r100, String r101, List r102) {
        if ((!Intrinsics.areEqual(String.valueOf(r100.f59847h.f60809m.f61075a), r101)) == true) goto L5;
    L7:
        if (r102 == null) goto L34;
        Iterator r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L35;
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r104 = (com.bytedance.android.livesdk.wrds.interact.a.C2484a) r103.next();
        Integer r105 = r104.a();
        if (r105 == null) goto L17;
        if (r105.intValue() != 1) goto L17;
        r100.h(r101, r104);
    L17:
        if (r105 == null) goto L10;
        if (r105.intValue() != 2) goto L10;
        r100.f59844e.add(TuplesKt.to(r101, r104));
        goto L10
    L35:
        return;
    L34:
        return;
    L5:
        if (v.a() == true) goto L7;
        int r106 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.h("enqueue operationList error dataRoomId:" + r101);
    }
}
