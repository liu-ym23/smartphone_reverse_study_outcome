package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.applet.aibridge.baidunavi.tts.BaiduNaviTtsPlayer;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.nova.R;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class NavigationCallback implements tl9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f190917k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static NavigationCallback f190918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f190919m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static AbsStartBaiduNavigationIDL.b f190920n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Pair<Integer, Integer> f190921o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaiduNaviTtsPlayer f190922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f190923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f190924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f190925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f190926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f190927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f190928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f190929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f190930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f190931j;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(AbsStartBaiduNavigationIDL.b r100, Continuation<? super Unit> r110) {
            if ((r110 instanceof NavigationCallback$Companion$updateParams$1) == false) goto L7;
            NavigationCallback$Companion$updateParams$1 r101 = (NavigationCallback$Companion$updateParams$1) r110;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            NavigationCallback$Companion$updateParams$1 r103 = r101;
            Object r111 = r103.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r103.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            r100 = (AbsStartBaiduNavigationIDL.b) r103.L$0;
            ResultKt.throwOnFailure(r111);
        L27:
            BotModel r112 = (BotModel) r111;
            if (r112 == null) goto L34;
            SpeakerVoice r113 = r112.getVoiceType();
            if (r113 == null) goto L34;
            String r114 = r113.getStyleId();
            if (r114 == null) goto L34;
            NavigationCallback.f190919m = r114;
        L34:
            NavigationCallback.f190920n = r100;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r111);
            String r115 = r100.getBotId();
            String r106 = r100.getStyleId();
            if (r106 != null) goto L17;
        L20:
            boolean r107 = true;
        L21:
            if (r107 == true) goto L23;
            NavigationCallback.f190919m = r100.getStyleId();
            goto L34
        L23:
            if (r115 == null) goto L34;
            IBotRepoService r108 = zh8.a.f572200e;
            r103.L$0 = r100;
            r103.label = 1;
            r111 = IBotRepoService.b.a(r108, r115, false, null, false, r103, 28);
            if (r111 != r104) goto L27;
            return r104;
        L17:
            if (StringsKt.isBlank(r106) == true) goto L20;
            r107 = false;
        L7:
            r101 = new NavigationCallback$Companion$updateParams$1(this, r110);
            goto L8
        }
    }

    static {
        f190917k = new Companion();
    }

    public NavigationCallback() {
    }

    public static dv3.b f(ul9.a r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new dv3.b(r100.c(), r100.b());
    }

    public static dv3.d g(ul9.e r110) {
        String r100 = r110.e();
        dv3.b r101 = f(r110.f());
        dv3.b r102 = f(r110.c());
        int r103 = r110.a();
        int r104 = r110.b();
        List<ul9.h> r105 = r110.g();
        if (r105 == null) goto L12;
        List<ul9.h> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L6:
        if (r108.hasNext() == false) goto L13;
        ul9.h r109 = (ul9.h) r108.next();
        if (r109 == null) goto L10;
        String r111 = r109.b();
    L11:
        r107.add(new dv3.f(r111));
        goto L6
    L10:
        r111 = null;
    L13:
        String r112 = r110.h();
        List<ul9.h> r113 = r110.g();
        if (r113 == null) goto L48;
        ul9.h r114 = (ul9.h) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L48;
        ul9.d r115 = r114.a();
        if (r115 == null) goto L48;
        List<vl9.d> r116 = r115.b();
        if (r116 == null) goto L48;
        List<vl9.d> r117 = r116;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L23:
        if (r119.hasNext() == false) goto L47;
        vl9.d r120 = (vl9.d) r119.next();
        if (r120 == null) goto L27;
        Integer r121 = Integer.valueOf(r120.b());
    L28:
        if (r120 == null) goto L30;
        Integer r122 = Integer.valueOf(r120.a());
    L31:
        if (r120 == null) goto L33;
        ul9.a r123 = r120.c();
    L34:
        dv3.b r124 = f(r123);
        if (r120 == null) goto L39;
        vl9.a r125 = r120.d();
        if (r125 == null) goto L39;
        int r126 = r125.a();
    L40:
        if (r120 == null) goto L45;
        vl9.a r127 = r120.d();
        if (r127 == null) goto L45;
        String r128 = r127.b();
        if (r128 == null) goto L45;
    L46:
        r118.add(new dv3.h(r121, r122, r124, new dv3.g(r126, r128)));
    L45:
        r128 = "";
    L39:
        r126 = 1;
        goto L40
    L33:
        r123 = null;
        goto L34
    L30:
        r122 = null;
        goto L31
    L27:
        r121 = null;
        goto L28
    L47:
        ArrayList r129 = r118;
    L50:
        return new dv3.d(r100, r101, r102, r103, r104, r107, r112, r129, 96);
    L48:
        r129 = null;
        goto L50
    L12:
        r107 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    @Override // tl9.a
    public final void b(ul9.i r110) {
        Intrinsics.checkNotNullParameter(r110, "update");
        int r100 = r110.f550634a;
        String r101 = r110.f550635b;
        String r102 = r110.f550636c;
        int r111 = r110.f550637d;
        String r103 = r110.f550638e;
        ul9.a r104 = r110.f550639f;
        Integer r112 = r110.f550640g;
        ul9.e r105 = r110.f550641h;
        FLogger r113 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("onNaviUpdate,sessionId[");
        r106.append(r102);
        r106.append("];routeId[");
        r106.append(r103);
        r106.append("];status[");
        r106.append(r100);
        r106.append("];hasLocation[");
        if (r104 == null) goto L5;
        boolean r114 = true;
    L6:
        r106.append(r114);
        r106.append("];hasRoute[");
        if (r105 == null) goto L9;
        boolean r115 = true;
    L10:
        r106.append(r115);
        r106.append(']');
        r113.i("navi_callback", r106.toString());
        vl9.d r107 = null;
        if (tl9.b.a() == false) goto L17;
        StringBuilder r108 = new StringBuilder("onNaviUpdate,sessionId[");
        r108.append(r102);
        r108.append("];routeId[");
        r108.append(r103);
        r108.append("];status[");
        r108.append(r100);
        r108.append("];message[");
        r108.append(r101);
        r108.append("];mmLocation[");
        r108.append(r104);
        r108.append("];route[");
        if (r105 == null) goto L15;
        String r109 = r105.i();
    L16:
        r108.append(r109);
        r108.append(']');
        r113.d("navi_callback", r108.toString());
    L22:
        if (r105 == null) goto L29;
        if (r104 == null) goto L26;
        dv3.b r116 = new dv3.b(r104.c(), r104.b());
    L27:
        dv3.c r117 = new dv3.c(1, r102, r116, r112, CollectionsKt.listOf(g(r105)));
        ?? r118 = 0;
        ?? r119 = 1;
    L33:
        a.a(r100, r101, r117);
        if (r100 != r119) goto L36;
    L52:
        NavigationCallback r120 = this;
        int r121 = r120.f190931j + r119;
        r120.f190931j = r121;
        ?? r122 = r120;
        if (r121 < 5) goto L56;
        r120.f190931j = r118;
        r120.e(AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_serviceissue_cn), r119);
        r113.i(r12, "status error dut to continuous status: " + r100);
        ?? r123 = r120;
    L55:
        boolean r124 = true;
        NavigationCallback r125 = r123;
    L57:
        if (r124 == false) goto L67;
        e.b("status_error");
        BaiduNaviServiceDelegate.f359647b.a("status_error");
        if (r125.f190924c == true) goto L61;
    L63:
        r125.f190923b = r118;
    L64:
        String r126 = ev3.a.f474232a;
        ev3.a.b(null, RealTimeNavEndReason.STATUS_ERROR.getValue() + '_' + r100, r119);
        r113.i(r12, "auto stop navi due to error status");
        return;
    L61:
        if (r125.f190923b == false) goto L63;
    L67:
        if (r100 != 6) goto L80;
        Integer r127 = r125.f190926e;
        if (r127 == null) goto L74;
        if (r127.intValue() == r100) goto L80;
    L74:
        if (r125.f190927f == false) goto L80;
        if (r125.f190929h == null) goto L78;
        r125.e(AppHost.f326268a.getApplication().getString(R.string.larus_navigation_topBar_banner_tomovetostart_cn), r118);
        r113.i(r12, "origin not reached tts triggered,mLatestNaviUpdateStatus:" + r125.f190926e);
    L123:
        r125.f190926e = Integer.valueOf(r100);
        if (r105 == null) goto L153;
        List<ul9.h> r128 = r105.g();
        if (r128 == null) goto L154;
        ul9.h r129 = (ul9.h) CollectionsKt.firstOrNull(r128);
        if (r129 == null) goto L155;
        ul9.d r130 = r129.a();
        if (r130 == null) goto L156;
        List<vl9.c> r131 = r130.a();
        if (r131 == null) goto L157;
        vl9.c r132 = (vl9.c) CollectionsKt.firstOrNull(r131);
        if (r132 == null) goto L158;
        List<vl9.b> r133 = r132.b();
        if (r133 == null) goto L159;
        vl9.b r134 = (vl9.b) CollectionsKt.firstOrNull(r133);
        if (r134 == null) goto L160;
        String r135 = r134.d();
        if (r135 != null) goto L143;
        return;
    L143:
        if (Intrinsics.areEqual(r125.f190925d, r135) == true) goto L161;
        Pair<Integer, Integer> r136 = f190921o;
        if (r136 != null) goto L147;
    L151:
        r125.f190925d = r135;
        r125.f190927f = r118;
        r125.e(r135, r118);
        r113.i(r12, "tts play text: ".concat(r135));
        return;
    L147:
        if (r134.c() >= r136.getFirst().intValue()) goto L149;
        return;
    L149:
        if (r134.c() <= r136.getSecond().intValue()) goto L151;
        return;
    L161:
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L78:
        r113.i(r12, "origin not reached tts ignored,mLatestNaviUpdateStatus:" + r125.f190926e);
    L80:
        if (r100 != 4) goto L87;
        Integer r137 = r125.f190926e;
        if (r137 != null) goto L85;
    L86:
        r125.f190927f = r118;
        r125.e(AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_rerouting_cn), r119);
        r113.i(r12, "reroute tts triggered,mLatestNaviUpdateStatus:" + r125.f190926e);
        goto L123
    L85:
        if (r137.intValue() != r100) goto L86;
    L87:
        if (r100 != 0) goto L123;
        if (r125.f190929h == null) goto L123;
        boolean r138 = r125.f190924c;
        r125.f190924c = r118;
        r125.f190929h = null;
        Boolean r139 = r125.f190928g;
        r125.f190928g = null;
        if (r105 == null) goto L101;
        List<ul9.h> r140 = r105.g();
        if (r140 == null) goto L101;
        ul9.h r141 = (ul9.h) CollectionsKt.firstOrNull(r140);
        if (r141 == null) goto L101;
        ul9.d r142 = r141.a();
        if (r142 == null) goto L101;
        List<vl9.d> r143 = r142.b();
        if (r143 == null) goto L101;
        r107 = (vl9.d) CollectionsKt.firstOrNull(r143);
    L101:
        if (r107 == null) goto L122;
        int r144 = r107.a();
        String r145 = "";
        if (r111 != 0) goto L105;
        String r146 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_walk_cn);
    L112:
        Intrinsics.checkNotNull(r146);
        if (Intrinsics.areEqual(r139, Boolean.TRUE) == false) goto L115;
        String r147 = r146 + AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_started_cn);
    L116:
        if (r138 == false) goto L118;
        r113.i(r12, "start text ignored due to quickRestart,mLatestNaviUpdateStatus:" + r125.f190926e);
        r147 = "";
    L118:
        if (r144 == 0) goto L121;
        StringBuilder r148 = new StringBuilder();
        AppHost.Companion r149 = AppHost.f326268a;
        r148.append(r149.getApplication().getString(R.string.larus_navigation_message_section_continue_cn));
        r148.append(r144);
        r148.append(r149.getApplication().getString(R.string.larus_navigation_topBar_banner_meter_cn));
        r145 = r148.toString();
    L121:
        r125.e(r147 + r145, r118);
        r113.i(r12, "start tts triggered,mLatestNaviUpdateStatus:" + r125.f190926e + ",distanceToCurrent:" + r144);
        goto L123
    L115:
        r147 = "";
        goto L116
    L105:
        if (r111 != r119) goto L107;
        r146 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_bike_cn);
        goto L112
    L107:
        if (r111 == 2) goto L109;
        r146 = "";
        goto L112
    L109:
        r146 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_car_cn);
        goto L112
    L122:
        r113.i(r12, "start tts triggered fails,mLatestNaviUpdateStatus:" + r125.f190926e);
    L56:
        r124 = false;
        r125 = r122;
        goto L57
    L36:
        if (r100 == 9001) goto L52;
        NavigationCallback r150 = this;
        r150.f190931j = r118;
        if (r100 != 5) goto L40;
        String r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_fail_cn);
    L51:
        Intrinsics.checkNotNull(r151);
        r113.i("navi_callback", "status error dut to status: " + r100);
        r150.e(r151, r119);
        r123 = r150;
        goto L55
    L40:
        if (r100 == 2001) goto L49;
        r122 = r150;
        if (r100 == 2002) goto L48;
        switch(r100) {
            case 3001: goto L47;
            case 3002: goto L46;
            case 3003: goto L45;
            default: goto L56;
        };
    L45:
        r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_outofrangewalk_cn);
        goto L51
    L46:
        r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_nowalkroute_cn);
        goto L51
    L47:
        r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_noentry_cn);
        goto L51
    L48:
        r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_outofrangebike_cn);
        goto L51
    L49:
        r151 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_nobikeroute_cn);
        goto L51
    L26:
        r116 = null;
        goto L27
    L29:
        if (r104 == null) goto L31;
        dv3.b r152 = new dv3.b(r104.c(), r104.b());
    L32:
        r119 = 1;
        r118 = 0;
        r117 = new dv3.c(null, null, r152, r112, null);
        goto L33
    L31:
        r152 = null;
        goto L32
    L15:
        r109 = null;
        goto L16
    L17:
        StringBuilder r153 = new StringBuilder("onNaviUpdate,sessionId[");
        r153.append(r102);
        r153.append("];routeId[");
        r153.append(r103);
        r153.append("];status[");
        r153.append(r100);
        r153.append("];message[");
        r153.append(r101);
        r153.append("];route[");
        if (r105 == null) goto L20;
        String r154 = r105.i();
    L21:
        r153.append(r154);
        r153.append(']');
        r113.d("navi_callback", r153.toString());
        goto L22
    L20:
        r154 = null;
        goto L21
    L9:
        r115 = false;
        goto L10
    L5:
        r114 = false;
        goto L6
    }

    public final void e(String r100, boolean r110) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        FLogger.f375446a.i("navi_callback", "startTts with NullOrBlank");
        return;
    L13:
        if (this.f190922a != null) goto L24;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L16:
        if (this.f190922a != null) goto L18;
        this.f190922a = new BaiduNaviTtsPlayer();     // Catch: Throwable -> L21
    L18:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
    L24:
        BaiduNaviTtsPlayer r104 = this.f190922a;
        if (r104 == null) goto L49;
        String r105 = f190919m;
        AbsStartBaiduNavigationIDL.b r106 = f190920n;
        if (r106 == null) goto L29;
        String r107 = r106.getConversationId();
    L30:
        LinkedHashMap r108 = new LinkedHashMap();
        AbsStartBaiduNavigationIDL.b r109 = f190920n;
        if (r109 == null) goto L35;
        String r111 = r109.getBotId();
        if (r111 == null) goto L35;
        r108.put("bot_id", r111);
    L35:
        Unit r112 = Unit.INSTANCE;
        if (r100 != null) goto L38;
    L39:
        r101 = true;
    L40:
        if (r101 == false) goto L43;
        FLogger.f375446a.i("BaiduNaviTtsPlayer", "empty text for tts");
        return;
    L43:
        if (r105 != null) goto L45;
        r105 = "zh_female_maomao_conversation_wvae_bigtts";
    L45:
        r104.b(new BaiduNaviTtsPlayer.a(r100, r105, r107, r108), r110);
        return;
    L38:
        if (r100.length() != 0) goto L40;
    L29:
        r107 = null;
        goto L30
    L49:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void h(ul9.e r100, boolean r101) {
        FLogger.f375446a.i("navi_callback", "updateStartEndGuide triggered");
        ul9.b r102 = null;
        Object r103 = null;
        if (r100 == null) goto L5;
        List<ul9.b> r104 = r100.d();
    L7:
        if (r104 == null) goto L24;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L22;
        Object r106 = r105.next();
        ul9.b r107 = (ul9.b) r106;
        if (r107 == null) goto L19;
        Integer r108 = r107.getType();
        if (r108 == null) goto L19;
        if (r108.intValue() != 1) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L10;
    L23:
        ul9.b r110 = (ul9.b) r106;
    L25:
        if (r104 == null) goto L41;
        Iterator<T> r111 = r104.iterator();
    L28:
        if (r111.hasNext() == false) goto L40;
        Object r112 = r111.next();
        ul9.b r113 = (ul9.b) r112;
        if (r113 == null) goto L37;
        Integer r114 = r113.getType();
        if (r114 == null) goto L37;
        if (r114.intValue() != 3) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == false) goto L28;
        r103 = r112;
    L37:
        r115 = false;
    L40:
        r102 = (ul9.b) r103;
    L41:
        this.f190928g = Boolean.valueOf(r101);
        if (r110 == null) goto L45;
        String r116 = r110.a();
        if (r116 == null) goto L45;
    L46:
        this.f190929h = r116;
        if (r102 == null) goto L50;
        String r117 = r102.a();
        if (r117 == null) goto L50;
    L51:
        this.f190930i = r117;
        return;
    L50:
        r117 = AppHost.f326268a.getApplication().getString(R.string.larus_navigation_message_section_arrived_cn);
    L45:
        r116 = "";
    L19:
        r109 = false;
        goto L20
    L22:
        r106 = null;
        goto L23
    L24:
        r110 = null;
        goto L25
    L5:
        r104 = null;
        goto L7
    }

    @Override // tl9.a
    public final void c(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "routeId");
        boolean r103 = this.f190924c;
        if (r103 == true) goto L14;
        boolean r104 = this.f190923b;
        if (r104 == false) goto L14;
        if (r103 == false) goto L9;
        if (r104 == false) goto L9;
    L10:
        String r105 = this.f190930i;
        if (r105 == null) goto L13;
        this.f190930i = null;
        e(r105, true);
        FLogger.f375446a.i("navi_callback", "auto stop tts triggered");
    L15:
        FLogger.f375446a.i("navi_callback", "onNaviEnd,sessionId[" + r100 + "];routeId[" + r102 + ']');
        a.a(9, null, null);
        String r106 = ev3.a.f474232a;
        ev3.a.b(RealTimeNavEndReason.ARRIVE, null, 2);
        this.f190922a = null;
        e.b("navi_end");
        f190919m = null;
        f190920n = null;
        f190921o = null;
        return;
    L13:
        FLogger.f375446a.i("navi_callback", "auto stop tts triggered fails");
    L9:
        this.f190923b = false;
    L14:
        FLogger.f375446a.i("navi_callback", "onNaviEnd,sessionId[" + r100 + "];routeId[" + r102 + "] ignored due to keepNavi");
        goto L15
    }

    @Override // tl9.a
    public final void d(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "routeId");
        this.f190927f = true;
        this.f190926e = null;
        this.f190925d = null;
        if (this.f190924c == true) goto L5;
    L7:
        this.f190923b = true;
    L8:
        FLogger.f375446a.i("navi_callback", "onNaviStart,sessionId:[" + r100 + "];routeId:[" + r102 + "];routePlanType:[" + r101 + ']');
        return;
    L5:
        if (this.f190923b == false) goto L7;
        goto L7
    }

    @Override // tl9.a
    public final void a(int r100, String r101, String r102, String r110, String r111, ul9.e r112) {
        Intrinsics.checkNotNullParameter(r101, "oldSessionId");
        Intrinsics.checkNotNullParameter(r102, "oldRouteId");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "routeId");
        Intrinsics.checkNotNullParameter(r112, CloudControlInf.ROUTE);
        FLogger.f375446a.i("navi_callback", "onNaviRouteChange,sessionId[" + r110 + "];routeId[" + r112.e() + ']');
        h(r112, false);
        int r103 = a.f190937a;
        a.a(4, null, new dv3.c(1, r110, null, null, CollectionsKt.listOf(g(r112))));
    }
}
