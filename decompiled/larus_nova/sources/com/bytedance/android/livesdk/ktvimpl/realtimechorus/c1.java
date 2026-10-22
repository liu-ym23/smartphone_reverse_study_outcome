package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.i f146518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MusicPanel f146519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f146520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xe2.c f146521d;

    public static final class a {
    }

    static {
    }

    public final long a() {
        com.bytedance.android.livesdk.ktvimpl.base.i r100 = this.f146518a;
        if (r100 == null) goto L7;
        Long r101 = r100.e();
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public final void c() {
        KtvContext.Companion.getClass();
        oe2.b r100 = null;
        if (KtvContext.a.g().getKtvCoreController().getValue() == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.base.i r101 = KtvContext.a.g().getKtvCoreController().getValue();
        if (r101 == null) goto L7;
        com.bytedance.android.live.pushstream.d r102 = r101.f142533r;
    L9:
        if ((!Intrinsics.areEqual(r102, b())) == true) goto L10;
    L26:
        StringBuilder r103 = new StringBuilder("initPlayer ");
        r103.append(hashCode());
        r103.append(' ');
        r103.append(ThreadMethodProxy.currentThread().getName());
        r103.append(" : ");
        r103.append(ThreadMethodProxy.currentThread().getId());
        r103.append("   ktvCoreController == ");
        com.bytedance.android.livesdk.ktvimpl.base.i r104 = this.f146518a;
        int r105 = 0;
        if (r104 == null) goto L29;
        int r106 = r104.hashCode();
    L30:
        r103.append(r106);
        r103.append(" ;; ktvCoreController2 == ");
        com.bytedance.android.livesdk.ktvimpl.base.i r107 = KtvContext.a.g().getKtvCoreController().getValue();
        if (r107 == null) goto L33;
        r105 = r107.hashCode();
    L33:
        r103.append(r105);
        w.a("RealTimeChorusPlayer", r103.toString());
        this.f146518a = KtvContext.a.g().getKtvCoreController().getValue();
        return;
    L29:
        r106 = 0;
        goto L30
    L7:
        r102 = null;
    L10:
        KtvContext r108 = KtvContext.a.g();
        if (r108 == null) goto L17;
        com.bytedance.live.datacontext.n<oe2.b> r109 = r108.getKtvRoomProvider();
        if (r109 == null) goto L17;
        oe2.b r110 = r109.getValue();
        if (r110 == null) goto L17;
        com.bytedance.android.live.pushstream.d r111 = r110.h(com.bytedance.android.live.ktv.common.util.j.i());
    L18:
        if (r111 != null) goto L20;
        return;
    L20:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r112 = KtvContext.a.g().getKtvCoreController();
        com.bytedance.android.live.pushstream.d r113 = b();
        KtvContext r114 = KtvContext.a.g();
        if (r114 == null) goto L25;
        com.bytedance.live.datacontext.n<oe2.b> r115 = r114.getKtvRoomProvider();
        if (r115 == null) goto L25;
        r100 = r115.getValue();
    L25:
        r112.setValue(new com.bytedance.android.livesdk.ktvimpl.base.i(r113, r100));
    L17:
        r111 = null;
        goto L18
    }

    public final void e() {
        com.bytedance.android.livesdk.ktvimpl.base.i r100 = this.f146518a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f142528m == true) goto L19;
        StringBuilder r101 = new StringBuilder();
        r101.append(hashCode());
        r101.append(' ');
        r101.append(ThreadMethodProxy.currentThread().getName());
        r101.append(" : ");
        r101.append(ThreadMethodProxy.currentThread().getId());
        r101.append(" pause ");
        MusicPanel r102 = this.f146519b;
        if (r102 == null) goto L11;
        KtvMusic r103 = r102.f153577a;
        if (r103 == null) goto L11;
        String r104 = r103.getTitle();
    L12:
        r101.append(r104);
        w.a("RealTimeChorusPlayer", r101.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r105 = this.f146518a;
        if (r105 == null) goto L20;
        r105.f142528m = true;
        r105.d();
        if (vm2.h.d() == false) goto L21;
        r105.d();
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r104 = null;
        goto L12
    }

    public final void i() {
        StringBuilder r100 = new StringBuilder();
        r100.append(hashCode());
        r100.append(' ');
        r100.append(ThreadMethodProxy.currentThread().getName());
        r100.append(" : ");
        r100.append(ThreadMethodProxy.currentThread().getId());
        r100.append(" stop ");
        MusicPanel r101 = this.f146519b;
        if (r101 == null) goto L7;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L7;
        String r103 = r102.getTitle();
    L8:
        r100.append(r103);
        r100.append(" ktvCoreController == null : ");
        if (this.f146518a != null) goto L11;
        boolean r104 = true;
    L12:
        r100.append(r104);
        w.a("RealTimeChorusPlayer", r100.toString());
        int r105 = xe2.g.f563356a;
        MusicPanel r106 = this.f146519b;
        JSONObject r107 = new JSONObject();
        if (r106 == null) goto L17;
        KtvMusic r108 = r106.f153577a;
        if (r108 == null) goto L17;
        Object r109 = Long.valueOf(r108.getMId());
    L18:
        r107.put("music_id", r109);
        if (r106 == null) goto L24;
        KtvMusic r110 = r106.f153577a;
        if (r110 == null) goto L24;
        String r111 = r110.getMTitle();
        if (r111 == null) goto L24;
    L25:
        r107.put("music_name", r111);
        if (r106 == null) goto L30;
        InteractiveSongUserInfo r112 = r106.f();
        if (r112 == null) goto L30;
        Long r113 = Long.valueOf(r112.getId());
    L31:
        r107.put("order_user_id", String.valueOf(r113));
        xe2.g.f(r107);
        int r114 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.RTChorus, MultiTraceData$TraceEvent.ChorusFlow, "MusicStop", 0, null, r107, 88);
        this.f146519b = null;
        fd2.s r115 = RealTimeChorusBusinessContext.Companion.c();
        if (r115 == null) goto L34;
        r115.qf(false);
    L34:
        KtvContext.Companion.getClass();
        KtvContext.a.g().getHasBgm().setValue(Boolean.FALSE);
        com.bytedance.android.livesdk.ktvimpl.base.i r116 = this.f146518a;
        if (r116 == null) goto L37;
        r116.s();
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.i r117 = this.f146518a;
        if (r117 == null) goto L40;
        r117.l();
    L40:
        com.bytedance.android.livesdk.ktvimpl.base.i r118 = this.f146518a;
        if (r118 == null) goto L43;
        r118.j();
    L43:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r119 = KtvContext.a.g().getKtvCoreController();
        if (r119 == null) goto L46;
        r119.setValue(null);
    L46:
        this.f146518a = null;
        return;
    L30:
        r113 = null;
    L24:
        r111 = "";
    L17:
        r109 = "0";
        goto L18
    L11:
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public c1() {
        this.f146520c = new CompositeDisposable();
    }

    public static com.bytedance.android.live.pushstream.d b() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r101 = r100.getLiveStream();
        if (r101 == null) goto L12;
        return r101.getValue();
    L12:
        return null;
    L9:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r102 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r102 == null) goto L12;
        return r102.guestLiveStream();
    }

    public final boolean d(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        long r101 = r100.f153577a.getMId();
        MusicPanel r102 = this.f146519b;
        if (r102 == null) goto L9;
        KtvMusic r103 = r102.f153577a;
        if (r103 == null) goto L9;
        if (r101 != r103.getMId()) goto L9;
        return true;
    L9:
        return false;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        com.bytedance.android.livesdk.ktvimpl.base.i r101 = this.f146518a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f142528m != true) goto L18;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(' ');
        r102.append(hashCode());
        r102.append(' ');
        r102.append(ThreadMethodProxy.currentThread().getName());
        r102.append(" : ");
        r102.append(ThreadMethodProxy.currentThread().getId());
        r102.append(" resume ");
        MusicPanel r103 = this.f146519b;
        if (r103 == null) goto L11;
        KtvMusic r104 = r103.f153577a;
        if (r104 == null) goto L11;
        String r105 = r104.getTitle();
    L12:
        r102.append(r105);
        r102.append(' ');
        w.a("RealTimeChorusPlayer", r102.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r106 = this.f146518a;
        if (r106 == null) goto L15;
        r106.u();
    L15:
        int r107 = xe2.g.f563356a;
        xe2.g.c(this.f146519b);
        return;
    L11:
        r105 = null;
        goto L12
    }

    public final void h(long r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        StringBuilder r101 = new StringBuilder();
        r101.append(hashCode());
        r101.append(' ');
        r101.append(ThreadMethodProxy.currentThread().getName());
        r101.append(" : ");
        r101.append(ThreadMethodProxy.currentThread().getId());
        r101.append(' ');
        MusicPanel r102 = this.f146519b;
        if (r102 == null) goto L10;
        KtvMusic r103 = r102.f153577a;
        if (r103 == null) goto L10;
        String r104 = r103.getTitle();
    L11:
        r101.append(r104);
        r101.append("   seek progress ");
        r101.append(r100);
        w.a("RealTimeChorusPlayer", r101.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r105 = this.f146518a;
        if (r105 != null) goto L14;
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.i r106 = this.f146518a;
        if (r106 == null) goto L23;
        r106.n(r100);
        return;
    L23:
        return;
    L14:
        if (r105.i(r100) == true) goto L18;
        ALogger.i("KtvCoreController", "seekProgress: progress is invalid, progress: " + r100 + ", duration: " + r105.f());
        if (KtvSettingHelper.y() == true) goto L19;
    L18:
        r105.d();
    L10:
        r104 = null;
        goto L11
    }

    public final void f(MusicPanel r110, int r111, long r112, Long r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        StringBuilder r100 = new StringBuilder("prepareBGM# playingMusic:");
        MusicPanel r101 = this.f146519b;
        Long r115 = null;
        if (r101 == null) goto L7;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L7;
        String r103 = r102.getTitle();
    L8:
        r100.append(r103);
        r100.append('_');
        MusicPanel r104 = this.f146519b;
        if (r104 == null) goto L13;
        KtvMusic r105 = r104.f153577a;
        if (r105 == null) goto L13;
        Long r106 = Long.valueOf(r105.getMId());
    L14:
        r100.append(r106);
        r100.append(", role:");
        RealTimeChorusBusinessContext.a r107 = RealTimeChorusBusinessContext.Companion;
        r100.append(r107.b());
        r100.append(", coreController is null:");
        boolean r108 = false;
        if (this.f146518a != null) goto L17;
        boolean r109 = true;
    L18:
        r100.append(r109);
        r100.append(", liveStream is null:");
        if (b() != null) goto L21;
        boolean r116 = true;
    L22:
        r100.append(r116);
        r100.append(", obtainTuningCore is null:");
        if (KSongTuningPanelHelperKt.d() != null) goto L25;
        boolean r117 = true;
    L26:
        r100.append(r117);
        w.a("RealTimeChorusPlayer", r100.toString());
        if (((Boolean) KtvSettingHelper.f70654q1.getValue()).booleanValue() == false) goto L32;
        if (r107.b() == 2) goto L32;
        return;
    L32:
        if (this.f146518a != null) goto L35;
        c();
    L35:
        if (KSongTuningPanelHelperKt.d() != null) goto L38;
        return;
    L38:
        if (this.f146519b == null) goto L42;
        w.a("RealTimeChorusPlayer", hashCode() + ' ' + ThreadMethodProxy.currentThread().getName() + " : " + ThreadMethodProxy.currentThread().getId() + " prepareBGM " + r110.f153577a.getTitle() + " ;; is playing music ");
        return;
    L42:
        if (b() != null) goto L45;
        return;
    L45:
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L58;
        int r118 = r107.b();
        boolean r119 = KtvUtilsKt.n(r110);
        if (r118 != 2) goto L50;
        if (r119 == false) goto L50;
        boolean r120 = true;
    L51:
        if (r120 == true) goto L54;
        w.a("RealTimeChorusPlayer", hashCode() + ' ' + ThreadMethodProxy.currentThread().getName() + " : " + ThreadMethodProxy.currentThread().getId() + " prepareBGM " + r110.f153577a.getTitle() + " ;; music not ready ;; chorusRole == " + r118 + " ;; isMusicMainResourceDownloaded == " + r119);
        return;
    L54:
        fd2.s r121 = r107.c();
        if (r121 == null) goto L58;
        r121.qf(true);
    L50:
        r120 = false;
    L58:
        if (this.f146521d != null) goto L67;
        fd2.s r122 = r107.c();
        if (r122 == null) goto L62;
        xe2.c r123 = r122.Qe();
    L64:
        if ((r123 instanceof xe2.c) == true) goto L66;
        r123 = null;
    L66:
        this.f146521d = r123;
        goto L67
    L62:
        r123 = null;
    L67:
        xe2.c r124 = this.f146521d;
        if (r124 == null) goto L70;
        r124.c("music_set_time", System.currentTimeMillis());
    L70:
        com.bytedance.android.livesdk.ktvimpl.base.i r125 = this.f146518a;
        if (r125 == null) goto L73;
        com.bytedance.android.live.pushstream.d r126 = r125.f142533r;
    L75:
        if ((!Intrinsics.areEqual(r126, b())) == false) goto L79;
        com.bytedance.android.livesdk.ktvimpl.base.i r127 = this.f146518a;
        if (r127 == null) goto L79;
        r127.f142533r = b();
    L79:
        StringBuilder r128 = new StringBuilder();
        r128.append(hashCode());
        r128.append(' ');
        r128.append(ThreadMethodProxy.currentThread().getName());
        r128.append(" : ");
        r128.append(ThreadMethodProxy.currentThread().getId());
        r128.append(" setBGMMusic ");
        r128.append(r110.f153577a.getTitle());
        r128.append(" ktvCoreController == null : ");
        if (this.f146518a != null) goto L82;
        r108 = true;
    L82:
        r128.append(r108);
        r128.append(" coreController liveStream ");
        com.bytedance.android.livesdk.ktvimpl.base.i r129 = this.f146518a;
        if (r129 == null) goto L85;
        com.bytedance.android.live.pushstream.d r130 = r129.f142533r;
    L86:
        r128.append(r130);
        r128.append(" guestLiveStream ");
        r128.append(b());
        r128.append("  null");
        com.bytedance.android.live.pushstream.d r131 = b();
        if (r131 == null) goto L89;
        r131.u();
    L89:
        w.a("RealTimeChorusPlayer", r128.toString());
        KtvContext.Companion.getClass();
        KtvContext.a.g().getHasBgm().setValue(Boolean.TRUE);
        this.f146519b = r110;
        com.bytedance.android.livesdk.ktvimpl.base.i r132 = this.f146518a;
        if (r132 == null) goto L92;
        r132.o(r110, SetBgmFunctionType.MULTI_KTV, r111, r112, r113, true);
    L92:
        if (r114 == true) goto L94;
        e();
    L95:
        int r133 = xe2.g.f563356a;
        JSONObject r134 = new JSONObject();
        KtvMusic r135 = r110.f153577a;
        if (r135 == null) goto L98;
        Object r136 = Long.valueOf(r135.getMId());
    L99:
        r134.put("music_id", r136);
        KtvMusic r137 = r110.f153577a;
        if (r137 == null) goto L103;
        String r138 = r137.getMTitle();
        if (r138 == null) goto L103;
    L104:
        r134.put("music_name", r138);
        InteractiveSongUserInfo r139 = r110.f();
        if (r139 == null) goto L107;
        r115 = Long.valueOf(r139.getId());
    L107:
        r134.put("order_user_id", String.valueOf(r115));
        xe2.g.f(r134);
        int r140 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.RTChorus, MultiTraceData$TraceEvent.ChorusFlow, "PlayMusic", 0, null, r134, 88);
        return;
    L103:
        r138 = "";
        goto L104
    L98:
        r136 = "0";
        goto L99
    L94:
        g("prepareBGM");
        goto L95
    L85:
        r130 = null;
        goto L86
    L73:
        r126 = null;
        goto L75
    L25:
        r117 = false;
        goto L26
    L21:
        r116 = false;
        goto L22
    L17:
        r109 = false;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }
}
