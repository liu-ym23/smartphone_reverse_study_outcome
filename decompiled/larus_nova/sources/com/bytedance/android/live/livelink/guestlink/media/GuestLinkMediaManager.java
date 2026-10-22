package com.bytedance.android.live.livelink.guestlink.media;

import android.content.Context;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager$startRtcEngine$1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt_live_model_apiKt;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.impl.base.thread.ThreadManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import gi6.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oi6.c;
import org.json.JSONObject;
import ui6.d;
import vm2.i;

/* JADX INFO: loaded from: classes46.dex */
public final class GuestLinkMediaManager extends lb6.b implements ob6.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f81201s = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ec6.a f81202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ei6.a f81203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f81204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ob6.b f81205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f81206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f81207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f81208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f81209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ob6.a.b f81210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ob6.a.InterfaceC7033a f81211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ThreadManager f81212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f81213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.livelink.guestlink.media.a f81214n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f81215o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f81216p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f81217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final fc6.a f81218r;

    public static final class a {
    }

    static {
    }

    @Override // ob6.a
    public final boolean C() {
        jy0.b.d("GuestLinkMediaManager", "checkRtcRoom, isSelfJoinedRTCRoom: " + this.f81206f + ", isRemoteJoinedRTCRoom: " + this.f81207g);
        if (this.f81206f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f81207g == false) goto L7;
        return true;
    }

    public final void H() {
        Iterator<String> r100 = this.f81208h.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        String r101 = r100.next();
        ei6.a r102 = this.f81203c;
        if (r102 == null) goto L4;
        e r103 = r102.getEventManager();
        if (r103 == null) goto L4;
        r103.c(r101);
        goto L4
    L10:
        this.f81208h.clear();
    }

    @Override // ob6.a
    public final void destroyEngine() {
        ThreadManager r100 = this.f81212l;
        if (r100 == null) goto L6;
        c.c(r100, new AnonymousClass1(this), "GuestLinkMediaManager");
        return;
    }

    @Override // ob6.a
    public final void p() {
        jy0.b.d("GuestLinkMediaManager", "leaveRtcRoom");
        ei6.a r100 = this.f81203c;
        if (r100 == null) goto L7;
        si6.b r101 = r100.b();
        if (r101 == null) goto L7;
        si6.a.b(r101, false, "leaveRtcRoom", 3);
    L7:
        jy0.b.d("GuestLinkMediaManager", "switchAudioCapture, isOpen: false, reason: adventure leave rtc room");
        ei6.a r102 = this.f81203c;
        if (r102 == null) goto L14;
        d r103 = r102.l();
        if (r103 == null) goto L14;
        mi6.a r104 = r103.b();
        if (r104 == null) goto L14;
        jy0.b.d("GuestLinkMediaManager", "switchAudioCapture call success");
        r104.f();
    L14:
        cy0.e.f465759a.getClass();
        j r105 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r106 = m.b(r105).a(Reflection.getOrCreateKotlinClass(ly0.a.class));
        Intrinsics.checkNotNull(r106);
        ((ly0.a) ((f80.a) r106)).o5(this.f81214n);
    }

    @Override // lb6.b, lb6.d
    public final void detach() {
        super.detach();
        ThreadManager r100 = this.f81212l;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // ob6.a
    public final ei6.a A() {
        return this.f81203c;
    }

    public final Context getContext() {
        return this.f81217q;
    }

    @Override // ob6.a
    public final ec6.a n() {
        return this.f81202b;
    }

    @Override // ob6.a
    public final void f(com.bytedance.android.live.livelink.guestlink.pipeline.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f81211k = r100;
    }

    @Override // ob6.a
    public final void s(String r110) {
        Intrinsics.checkNotNullParameter(r110, "rtcExtInfo");
        StringBuilder r100 = new StringBuilder("joinRtcRoom start, isAppBackground:");
        r100.append(this.f81213m);
        r100.append(", rtcRoomId: ");
        ei6.a r101 = this.f81203c;
        String r102 = null;
        if (r101 == null) goto L7;
        si6.b r103 = r101.b();
        if (r103 == null) goto L7;
        String r104 = r103.m();
    L8:
        r100.append(String.valueOf(r104));
        jy0.b.d("GuestLinkMediaManager", r100.toString());
        Intrinsics.checkNotNullParameter(r110, "rtcExtInfo");
        if (this.f81204d == false) goto L11;
        jy0.b.c("GuestLinkMediaManager", "initEngine, return reason: mIsRtcEngineInit is true", null, 4);
    L84:
        if (this.f81205e == null) goto L110;
        this.f81209i = !this.f81213m;
        ei6.a r111 = this.f81203c;
        if (r111 == null) goto L90;
        fi6.a r112 = r111.g();
        if (r112 == null) goto L90;
        r112.f477381e0 = this.f81209i;
    L90:
        ei6.a r113 = this.f81203c;
        if (r113 == null) goto L95;
        fi6.a r114 = r113.g();
        if (r114 == null) goto L95;
        r114.f477383f0 = true;
    L95:
        ei6.a r115 = this.f81203c;
        if (r115 == null) goto L100;
        fi6.a r116 = r115.g();
        if (r116 == null) goto L100;
        r116.f477385g0 = true;
    L100:
        ei6.a r117 = this.f81203c;
        if (r117 == null) goto L110;
        si6.b r118 = r117.b();
        if (r118 == null) goto L110;
        ei6.a r105 = this.f81203c;
        if (r105 == null) goto L109;
        si6.b r106 = r105.b();
        if (r106 == null) goto L109;
        r102 = r106.m();
    L109:
        si6.a.a(r118, String.valueOf(r102), false, 14);
    L110:
        cy0.e.f465759a.getClass();
        j r119 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r120 = m.b(r119).a(Reflection.getOrCreateKotlinClass(ly0.a.class));
        Intrinsics.checkNotNull(r120);
        ((ly0.a) ((f80.a) r120)).y0(this.f81214n);
        return;
    L11:
        int r107 = ob6.c.f522612a;
        Intrinsics.checkNotNullParameter(r110, "rtcExtInfo");
        if (r110.length() <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == true) goto L112;
    L23:
        ob6.b r109 = null;
    L24:
        this.f81205e = r109;
        jy0.b.d("GuestLinkMediaManager", "initEngine, linkEngineConfig: " + this.f81205e);
        ob6.b r121 = this.f81205e;
        if (r121 == null) goto L84;
        fi6.a r122 = new fi6.a();
        r122.h(this.f81217q);
        r122.m(r121.f522601a);
        r122.S = 5;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r122.f477407w = "douyin_live";
        KmpEnv r123 = KmpEnv.f255139a;
        String r124 = ((wh6.a) vh6.c.b(wh6.a.class)).getChannel();
        if (r124 != null) goto L29;
        r124 = "";
    L29:
        Intrinsics.checkNotNullParameter(r124, "channel");
        r122.f477409y = r124;
        r122.c(String.valueOf(((wh6.a) vh6.c.b(wh6.a.class)).getAppId()));
        r122.e(((wh6.a) vh6.c.b(wh6.a.class)).getVersionCode());
        r122.d(String.valueOf(((wh6.a) vh6.c.b(wh6.a.class)).getUpdateVersionCode()));
        if (i.k().getEnable() == false) goto L33;
        r122.f477396m = true;
        r122.f477398n = i.k().q7();
    L33:
        if (((wh6.a) vh6.c.b(wh6.a.class)).isBoe() == false) goto L35;
        r122.l(Env.ENV_BOE);
    L35:
        r122.Z = true;
        r122.N = LinkConstantKt_live_model_apiKt.getVOLUME_CALLBACK_INTERVAL();
        r122.f477390j = 1;
        sk0.b r125 = this.f81218r.L();
        this.f81202b = r125;
        if (r125 == null) goto L40;
        sk0.c r126 = r125.f542314a;
        if (r126 == null) goto L40;
        r126.a(this.f81215o);
    L40:
        ec6.a r127 = this.f81202b;
        if (r127 == null) goto L43;
        ei6.a r128 = r127.q(r122);
    L44:
        this.f81203c = r128;
        if (r128 == null) goto L51;
        d r129 = r128.l();
        if (r129 == null) goto L51;
        mi6.a r130 = r129.b();
        if (r130 == null) goto L51;
        r130.g(r121.f522611k);
    L51:
        ei6.a r131 = this.f81203c;
        if (r131 == null) goto L56;
        e r132 = r131.getEventManager();
        if (r132 == null) goto L56;
        r132.b((GuestLinkMediaManager$mRtcListener$2.AnonymousClass1) this.f81216p.getValue());
    L56:
        ei6.a r133 = this.f81203c;
        if (r133 == null) goto L61;
        ri6.b r134 = r133.r();
        if (r134 == null) goto L61;
        r134.f(3);
    L61:
        ei6.a r135 = this.f81203c;
        if (r135 == null) goto L68;
        e r136 = r135.getEventManager();
        if (r136 == null) goto L68;
        String r137 = r136.a(EventCategory.RTC_ROOM_EVENT, null, new GuestLinkMediaManager$initEventObserver$1(this));
        if (r137 == null) goto L68;
        this.f81208h.add(r137);
    L68:
        ei6.a r138 = this.f81203c;
        if (r138 == null) goto L75;
        e r139 = r138.getEventManager();
        if (r139 == null) goto L75;
        String r140 = r139.a(EventCategory.RTC_ROOM_EVENT_EX, null, new GuestLinkMediaManager$initEventObserver$2(this));
        if (r140 == null) goto L75;
        this.f81208h.add(r140);
    L75:
        ei6.a r141 = this.f81203c;
        if (r141 == null) goto L82;
        e r142 = r141.getEventManager();
        if (r142 == null) goto L82;
        String r143 = r142.a(EventCategory.RTC_ENGINE_EVENT, null, new GuestLinkMediaManager$initEventObserver$3(this));
        if (r143 == null) goto L82;
        this.f81208h.add(r143);
    L82:
        this.f81204d = true;
        goto L84
    L43:
        r128 = null;
        goto L44
    L112:
        r109 = new ob6.b();     // Catch: Exception -> L22
        JSONObject r144 = new JSONObject(r110);     // Catch: Exception -> L22
        JSONObject r145 = r144.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L22
        if (r145 == null) goto L20;
        String r146 = r145.optString("rtc_app_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r146, "<set-?>");     // Catch: Exception -> L22
        r109.f522602b = r146;     // Catch: Exception -> L22
        String r147 = r145.optString("rtc_token");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r147, "<set-?>");     // Catch: Exception -> L22
        r109.f522607g = r147;     // Catch: Exception -> L22
        r109.f522603c = r145.optInt("rtc_vendor");     // Catch: Exception -> L22
        int r148 = com.bytedance.revenue.platform.api.core.a.f267505a;     // Catch: Exception -> L22
        r109.f522605e = com.bytedance.revenue.platform.api.core.a.a(r145.optString("rtc_app_sign"));     // Catch: Exception -> L22
        String r149 = r145.optString("rtc_channel_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r149, "<set-?>");     // Catch: Exception -> L22
        r109.f522606f = r149;     // Catch: Exception -> L22
        String r150 = r145.optString("rtc_user_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r150, "<set-?>");     // Catch: Exception -> L22
        r109.f522609i = r150;     // Catch: Exception -> L22
        r109.f522610j = r145.optInt("rtc_user_id_mode");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L22
        r109.f522604d = "byte";     // Catch: Exception -> L22
        String r151 = r145.optString("user_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r151, "<set-?>");     // Catch: Exception -> L22
        r109.f522608h = r151;     // Catch: Exception -> L22
    L20:
        String r152 = r144.optString("rtc_business_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r152, "<set-?>");     // Catch: Exception -> L22
        r109.f522611k = r152;     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Exception -> L22
        r109.f522601a = r110;     // Catch: Exception -> L22
    L14:
        r108 = false;
    L7:
        r104 = null;
        goto L8
    }

    @Override // ob6.a
    public final void u(GuestLinkPipeLineManager$startRtcEngine$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f81210j = r100;
    }

    public GuestLinkMediaManager(Context r100, fc6.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "hostService");
        this.f81217q = r100;
        this.f81218r = r101;
        this.f81208h = new LinkedHashSet();
        this.f81209i = true;
        this.f81212l = new ThreadManager();
        this.f81214n = new com.bytedance.android.live.livelink.guestlink.media.a(this);
        this.f81215o = new b(this);
        this.f81216p = LazyKt.lazy(new GuestLinkMediaManager$mRtcListener$2(this));
    }

    public static final void F(GuestLinkMediaManager r100, String r101, LiveWrappedMediaStreamType r102) {
        r100.getClass();
        jy0.b.d("GuestLinkMediaManager", "onUserPublishStream, uid: " + r101 + ", type: " + r102);
    }

    public static final void G(GuestLinkMediaManager r100, String r101, LiveWrappedMediaStreamType r102) {
        r100.getClass();
        jy0.b.d("GuestLinkMediaManager", "onUserUnpublishStream, uid: " + r101 + ", type: " + r102 + ", reason: null");
    }
}
