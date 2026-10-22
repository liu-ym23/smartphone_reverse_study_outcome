package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.IntentFilter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusLeaveType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.interfaces.ChorusConcertApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements gd2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcertStageComponent f143727a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a$a, reason: collision with other inner class name */
    public static final class C2247a {
    }

    static {
    }

    public a() {
    }

    @Override // gd2.c
    public final boolean b() {
        gd2.f r100 = ConcertStageDataContext.Companion.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    @Override // gd2.c
    public final boolean d() {
        gd2.f r100 = ConcertStageDataContext.Companion.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    public final void h() {
        ALogger.i("ChorusConcertService", "unloadChorusConcertStage, concertStageComponent: " + this.f143727a);
        final ConcertStageComponent r100 = this.f143727a;
        if (r100 != null) goto L5;
        return;
    L5:
        de2.b.b();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("function_type2", "chorus");
        de2.b.a("livesdk_connection_over", r101);
    L9:
        x r102 = r100.f143707h;
        if (r102 == null) goto L12;
        JoinChorusConcertStatus r103 = r102.f143757c;
    L14:
        if (r103 != JoinChorusConcertStatus.JOINED) goto L33;
        com.bytedance.live.datacontext.m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L20;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L20;
        long r106 = r105.getId();
    L21:
        long r107 = r106;
        x r108 = r100.f143707h;
        if (r108 == null) goto L25;
        String r109 = r108.f143755a;
        if (r109 == null) goto L25;
    L26:
        String r110 = r109;
        if (r108 == null) goto L29;
        int r111 = r108.f143756b;
    L30:
        int r112 = r111;
        w.b("ConcertStageComponent", "before leaveChorus, roomId = " + r107 + ", chorusId = " + r110 + ", userType = " + r112);
        Disposable r113 = ((ChorusConcertApi) com.bytedance.android.live.network.c.b().e(ChorusConcertApi.class)).leaveChorus(r107, r110, ChorusLeaveType.ChorusLeaveType_Mid.getType(), r112).compose(RxUtil.rxSchedulerHelper()).subscribe(g.f143740a, h.f143741a);
        if (r113 == null) goto L33;
        RxUtilKt.c(r113, r100.f143710k);
        goto L33
    L29:
        r111 = ChorusUserType.ChorusUserType_Unknow.getType();
    L25:
        r109 = "0";
    L20:
        r106 = 0;
    L33:
        js1.a r114 = r100.f143713n;
        if (r114 == null) goto L39;
        vb6.g r115 = r114.f500178a;
        if (r115 == null) goto L39;
        r115.i1("widget destroy", false);
    L39:
        if (r100.f143700a == true) goto L119;
    L57:
        c r116 = r100.f143715p;
        if (r116 == null) goto L60;
        r116.g(false, false);
    L60:
        js1.a r117 = r100.f143713n;
        if (r117 == null) goto L65;
        vb6.g r118 = r117.f500178a;
        if (r118 == null) goto L65;
        r118.a1(r100.f143725z);
    L65:
        js1.a r119 = r100.f143713n;
        if (r119 == null) goto L70;
        js1.c r120 = r119.f500180c;
        if (r120 == null) goto L70;
        l r121 = r100.f143724y;
        Intrinsics.checkNotNullParameter(r121, "listener");
        r120.f500189b.remove(r121);
    L70:
        js1.a r122 = r100.f143713n;
        if (r122 == null) goto L75;
        vb6.g r123 = r122.f500178a;
        if (r123 == null) goto L75;
        r123.f1(r100.A);
    L75:
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r124 = r100.f143712m;
        if (r124 == null) goto L81;
        Iterator r125 = ((LinkedHashMap) r124.f143770a).entrySet().iterator();
    L79:
        if (r125.hasNext() == false) goto L81;
        ((ce2.a) ((Map.Entry) r125.next()).getValue()).release();
    L81:
        c r126 = r100.f143715p;
        if (r126 == null) goto L96;
        ConcertStageDataContext r127 = ConcertStageDataContext.Companion.getContext();
        if (r127 == null) goto L92;
        com.bytedance.live.datacontext.j<js1.a> r128 = r127.getLinkComponent();
        if (r128 == null) goto L92;
        js1.a r129 = r128.getValue();
        if (r129 == null) goto L92;
        vb6.g r130 = r129.f500178a;
        if (r130 == null) goto L92;
        r130.a1(r126.f143733e);
    L92:
        com.bytedance.android.live.pushstream.d r131 = c.k();
        if (r131 == null) goto L95;
        r131.h1(r126.f143734f);
    L95:
        r126.f143729a.clear();
        w.b("ConcertEarMonitor", "release");
    L96:
        DataCenter r132 = r100.f143720u;
        if (r132 == null) goto L99;
        r132.removeObserver(r100);
    L99:
        m r133 = r100.f143711l;
        if (r133 == null) goto L108;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r134 = r133.f143745a;
        if (r134 == null) goto L104;
        r134.J();
    L104:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r135 = r133.f143745a;
        if (r135 == null) goto L107;
        r135.release();
    L107:
        r133.f143745a = null;
    L108:
        r100.f143706g.clear();
        ViewGroup r136 = r100.C;
        if (r136 == null) goto L111;
        Integer r137 = Integer.valueOf(r136.indexOfChild(r100.f143721v));
    L112:
        int r138 = r137.intValue();
        if (r138 == (-1)) goto L117;
        ViewGroup r139 = r100.C;
        if (r139 == null) goto L117;
        r139.removeViewAt(r138);
    L117:
        UtilityKotlinExtentionsKt.s(0, false, true, new ConcertStageComponent$onDestroy$1(r100), 3);
        w.b("ConcertStageComponent", "onDestroy ;; index == " + r138);
        this.f143727a = null;
        return;
    L111:
        r137 = null;
        goto L112
    L119:
        Context r140 = r100.getContext();     // Catch: Exception -> L54
        if (r140 == null) goto L56;
        ConcertStageComponent$usbReceiver$1 r141 = r100.f143723x;     // Catch: Exception -> L54
        ReceiverRegisterLancet.loge(r141, false);     // Catch: Exception -> L54
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L120;
        r140.unregisterReceiver(r141);     // Catch: Exception -> L54
        goto L56
    L120:
    L48:
        e = move-exception;
        if (r141 == null) goto L51;
        Npth.addTag("unregisterReceiver", r141.toString());     // Catch: Exception -> L54
    L51:
        e.printStackTrace();     // Catch: Exception -> L54
        goto L56
    L45:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r141, r140) == false) goto L56;
        r140.unregisterReceiver(r141);     // Catch: Exception -> L48
    L56:
        r100.f143700a = false;
    L54:
        e = move-exception;
        w.b("ConcertStageComponent", "unregisterReceiver " + e.getMessage());
        goto L56
    L12:
        r103 = null;
        goto L14
    }

    @Override // gd2.c
    public final void a(VSChorusConcertWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        gd2.f r101 = ConcertStageDataContext.Companion.a();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // gd2.c
    public final void c(VSChorusConcertWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        gd2.f r101 = ConcertStageDataContext.Companion.a();
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // gd2.c
    public final void e(boolean r100) {
        if (r100 == false) goto L14;
        ConcertStageDataContext r101 = ConcertStageDataContext.Companion.getContext();
        if (r101 == null) goto L26;
        com.bytedance.live.datacontext.j<js1.a> r102 = r101.getLinkComponent();
        if (r102 == null) goto L27;
        js1.a r103 = r102.getValue();
        if (r103 == null) goto L28;
        ei6.a r104 = r103.a();
        if (r104 == null) goto L29;
        ri6.b r105 = r104.r();
        if (r105 == null) goto L30;
        r105.d(0);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L14:
        ConcertStageDataContext r106 = ConcertStageDataContext.Companion.getContext();
        if (r106 == null) goto L32;
        com.bytedance.live.datacontext.j<js1.a> r107 = r106.getLinkComponent();
        if (r107 == null) goto L33;
        js1.a r108 = r107.getValue();
        if (r108 == null) goto L34;
        ei6.a r109 = r108.a();
        if (r109 == null) goto L35;
        ri6.b r110 = r109.r();
        if (r110 == null) goto L36;
        r110.d(100);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    @Override // gd2.c
    public final void f(int r100, int r101) {
        gd2.f r102 = ConcertStageDataContext.Companion.a();
        if (r102 == null) goto L6;
        r102.f();
        return;
    }

    public final void g(Context r210, ViewGroup r211, DataCenter r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "parent");
        ALogger.i("ChorusConcertService", "loadChorusConcertStage, concertStageComponent: " + this.f143727a);
        if (this.f143727a == null) goto L5;
        return;
    L5:
        ConcertStageComponent r100 = new ConcertStageComponent(r210, r211);
        this.f143727a = r100;
        r100.f143720u = r212;
        w.b("ConcertStageComponent", WidgetCostModule.TYPE_ON_CREATE);
        Context r101 = r100.B;
        ConcertStageComponent$usbReceiver$1 r102 = r100.f143723x;
        boolean r103 = false;
        if (r101 != null) goto L140;
        w.b("ConcertStageComponent", "registerUsbDeviceReceiver: context is null");
    L11:
        boolean r104 = false;
    L12:
        r100.f143700a = r104;
        RxUtilKt.c(((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).registerExternalMethodFactory(new k()).subscribe(), r100.f143710k);
        js1.a r105 = new js1.a(r100.B);
        r100.f143713n = r105;
        js1.c r106 = r105.f500180c;
        if (r106 == null) goto L15;
        l r107 = r100.f143724y;
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f500189b.add(r107);
    L15:
        js1.a r108 = r100.f143713n;
        if (r108 == null) goto L20;
        vb6.g r109 = r108.f500178a;
        if (r109 == null) goto L20;
        r109.X0(r100.f143725z, true);
    L20:
        js1.a r110 = r100.f143713n;
        if (r110 == null) goto L25;
        vb6.g r111 = r110.f500178a;
        if (r111 == null) goto L25;
        r111.e1(r100.A, true);
    L25:
        Pair r112 = com.bytedance.live.datacontext.d.a(ConcertStageComponent$initConcertStageDataContext$1.INSTANCE);
        ConcertStageDataContext r113 = (ConcertStageDataContext) r112.component1();
        Disposable r114 = (Disposable) r112.component2();
        r113.getService().d(r100);
        r113.getLinkComponent().d(r100.f143713n);
        com.bytedance.live.datacontext.b.a(r113, ConcertStageDataContext.KEY_CONCERT_STAGE_DATA);
        r100.f143710k.add(r114);
        if (r212 == null) goto L28;
        r100.f143712m = new com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a(r100.B, r212);
        r100.f143711l = new m(r212);
    L28:
        ViewGroup r115 = r100.f143721v;
        if (r115 == null) goto L31;
        FrameLayout r116 = (FrameLayout) r115.findViewById(R.id.concert_stage_lynx_container);
    L32:
        r100.f143708i = r116;
        Context r117 = r100.B;
        if (r117 == null) goto L89;
        if (r116 == null) goto L89;
        m r118 = r100.f143711l;
        if (r118 == null) goto L89;
        com.bytedance.live.datacontext.m<IRoom> r119 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r119 == null) goto L45;
        IRoom r120 = r119.getValue();
        if (r120 == null) goto L45;
        String r121 = r120.getIdStr();
        if (r121 == null) goto L45;
        String r122 = r121;
    L46:
        com.bytedance.live.datacontext.m<IRoom> r123 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r123 == null) goto L54;
        IRoom r124 = r123.getValue();
        if (r124 == null) goto L54;
        String r125 = r124.getOwnerUserIdString();
        if (r125 == null) goto L54;
        String r126 = r125;
    L55:
        jd2.b r127 = new jd2.b(r117, r116, r122, r126, gh0.a.c());
        Intrinsics.checkNotNullParameter(r127, "params");
        String r128 = KtvSettingHelper.e().c().b();
        u6 r129 = new u6(KtvSettingHelper.e().c().a());
        r129.b("url", r128);
        u6 r130 = r129.d("url");
        r130.b("business_type", "vsconcert");
        r130.b("business_group", "vsconcert");
        r130.b("anchor_id", r127.f498223d);
        r130.b("room_id", r127.f498222c);
        r130.b("user_id", r127.f498224e);
        r130.b("is_feed", "0");
        int r131 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.f77142a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r132 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(r127.getContext(), r129.c(), new v(), 0, null, 56);
        r118.f143745a = r132;
        r132.registerMethod("registerMessage", new q(r118));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r133 = r118.f143745a;
        if (r133 == null) goto L58;
        r133.registerMethod("registerMessageLatch", new p(r118));
    L58:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r134 = r118.f143745a;
        if (r134 == null) goto L61;
        r134.registerMethod("registerWrds", new r(r118));
    L61:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r135 = r118.f143745a;
        if (r135 == null) goto L64;
        r135.registerMethod("live.getConcertStatus", n.f143747a);
    L64:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r136 = r118.f143745a;
        if (r136 == null) goto L67;
        r136.registerMethod("live.updateConcertStatus", u.f143754a);
    L67:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r137 = r118.f143745a;
        if (r137 == null) goto L70;
        r137.registerMethod("reportAggregateALog", s.f143752a);
    L70:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r138 = r118.f143745a;
        if (r138 == null) goto L73;
        r138.registerMethod("reportLinkmicStatus", t.f143753a);
    L73:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r139 = r118.f143745a;
        if (r139 == null) goto L76;
        r139.registerMethod("getLiveNtpTime", new o(r118));
    L76:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r140 = r118.f143745a;
        if (r140 == null) goto L79;
        ih0.c.a.a(r140, null, null, 7);
    L79:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r141 = r118.f143745a;
        if (r141 == null) goto L86;
        AnnieXLynxView r142 = r141.f76888h;
        if (r142 == null) goto L86;
        r142.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r143 = r127.f498221b;
        if (r143 == null) goto L86;
        r143.addView(r142);
    L86:
        LinkedHashMap r144 = new LinkedHashMap();
        r144.put("room_id", r127.f498222c);
        r144.put("anchor_id", r127.f498223d);
        r144.put("user_id", r127.f498224e);
        r144.put("is_feed", "0");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r145 = r118.f143745a;
        if (r145 == null) goto L89;
        r145.updateGlobalProps(r144);
    L54:
        r126 = "";
    L45:
        r122 = "";
    L89:
        if (r212 == null) goto L91;
        r212.observe(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, r100);
    L91:
        if (r212 == null) goto L93;
        r212.observe(ChorusJsbDataContext.CMD_START_RTC_ENGINE, r100);
    L93:
        if (r212 == null) goto L95;
        r212.observe("cmd_concert_stage_status", r100);
    L95:
        c r146 = new c();
        w.b("ConcertEarMonitor", "init");
        com.bytedance.android.livesdk.chatroom.o r147 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r147 == null) goto L102;
        com.bytedance.live.datacontext.m<Boolean> r148 = r147.X1();
        if (r148 == null) goto L102;
        Boolean r149 = r148.getValue();
        if (r149 == null) goto L102;
        r103 = r149.booleanValue();
    L102:
        r146.l(r103);
        com.bytedance.android.livesdk.chatroom.o r150 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r150 == null) goto L111;
        com.bytedance.live.datacontext.m<Boolean> r151 = r150.X1();
        if (r151 == null) goto L111;
        Observable<Boolean> r152 = r151.a();
        if (r152 == null) goto L111;
        Disposable r153 = r152.subscribe(new d(r146));
        if (r153 == null) goto L111;
        RxUtilKt.c(r153, r146.f143729a);
    L111:
        com.bytedance.android.livesdk.chatroom.o r154 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r154 == null) goto L120;
        com.bytedance.live.datacontext.m<Boolean> r155 = r154.n2();
        if (r155 == null) goto L120;
        Observable<Boolean> r156 = r155.a();
        if (r156 == null) goto L120;
        Disposable r157 = r156.subscribe(new e(r146));
        if (r157 == null) goto L120;
        RxUtilKt.c(r157, r146.f143729a);
    L120:
        com.bytedance.android.livesdk.chatroom.o r158 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r158 == null) goto L129;
        com.bytedance.live.datacontext.m<Boolean> r159 = r158.N2();
        if (r159 == null) goto L129;
        Observable<Boolean> r160 = r159.a();
        if (r160 == null) goto L129;
        Disposable r161 = r160.subscribe(new f(r146));
        if (r161 == null) goto L129;
        RxUtilKt.c(r161, r146.f143729a);
    L129:
        ConcertStageDataContext r162 = ConcertStageDataContext.Companion.getContext();
        if (r162 == null) goto L138;
        com.bytedance.live.datacontext.j<js1.a> r163 = r162.getLinkComponent();
        if (r163 == null) goto L138;
        js1.a r164 = r163.getValue();
        if (r164 == null) goto L138;
        vb6.g r165 = r164.f500178a;
        if (r165 == null) goto L138;
        r165.X0(r146.f143733e, true);
    L138:
        Unit r166 = Unit.INSTANCE;
        r100.f143715p = r146;
        return;
    L31:
        r116 = null;
        goto L32
    L140:
        IntentFilter r167 = new IntentFilter();     // Catch: Throwable -> L10
        r167.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");     // Catch: Throwable -> L10
        ConcertStageComponent.i(r101, r102, r167);     // Catch: Throwable -> L10
        w.b("ConcertStageComponent", "USB device receiver registered successfully");     // Catch: Throwable -> L10
        r104 = true;
    L10:
        w.b("ConcertStageComponent", "register USB receiver failed");
        goto L11
    }
}
