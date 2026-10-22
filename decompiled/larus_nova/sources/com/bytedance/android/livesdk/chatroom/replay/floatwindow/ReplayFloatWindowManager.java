package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.view.ReplayDragRelativeLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.android.videoshop.mediaview.SurfaceContainerLayout;
import com.ss.android.videoshop.mediaview.TextureContainerLayout;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayFloatWindowManager implements s.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, m> f108617j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f108618k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f108619l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f108620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.floatwindow.b f108621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleMediaView f108622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f108623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataCenter f108624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f108625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f108626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f108627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f108628i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.android.livesdk.chatroom.replay.floatwindow.b f108629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f108630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f108631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f108632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f108633e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f108634f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f108635g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TimeInterpolator f108636h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f108637i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.bytedance.android.livesdk.chatroom.replay.floatwindow.a f108638j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f108639k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f108640l;

        public a() {
            this.f108630b = -2;
            this.f108631c = -2;
            this.f108632d = 3;
            this.f108635g = 300;
        }
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.vs_base.api.a {

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f108641a = null;

            static {
                f108641a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Map<String, m> r100 = ReplayFloatWindowManager.f108617j;     // Catch: Throwable -> L10
                SimpleMediaView r101 = c.a().f108622c;     // Catch: Throwable -> L10
                if (r101 == null) goto L13;
                LayerHostMediaLayout r102 = r101.f455992c;     // Catch: Throwable -> L10
                if (r102 == null) goto L17;
                VideoContext r103 = r102.M;     // Catch: Throwable -> L10
                if (r103 == null) goto L18;
                r103.k0();     // Catch: Throwable -> L10
                return;
            L18:
                return;
            L17:
                return;
            L13:
                return;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void onCreate(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void onPause(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void onStart(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void onStop(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void b() {
            Map<String, m> r100 = ReplayFloatWindowManager.f108617j;
            IRoom r101 = fq1.p.a().f();
            IReplayInnerProgressService r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getAnchorId();
        L6:
            String r104 = fq1.t.a().getCurrentUserId();
            if (TextUtils.equals(r103, "") == false) goto L9;
        L11:
            boolean r105 = false;
        L12:
            if (r105 == false) goto L15;
            return;
        L15:
            if (c.a().f108622c != null) goto L17;
            return;
        L17:
            List<Class<?>> r106 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().getAllLiveActivity();
            Activity r107 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().getTopActivity();
            if (r106 == null) goto L29;
            Iterator<T> r108 = r106.iterator();
            boolean r109 = false;
        L21:
            if (r108.hasNext() == false) goto L30;
            Class r110 = (Class) r108.next();
            if (r107 == null) goto L25;
            Class<?> r111 = r107.getClass();
        L27:
            if (Intrinsics.areEqual(r111, r110) == false) goto L21;
            r109 = true;
            goto L21
        L25:
            r111 = null;
        L30:
            if (r109 == false) goto L188;
            wq1.b.f560683a = true;
            if (wq1.b.b(r107) == false) goto L200;
            Map<String, m> r112 = ReplayFloatWindowManager.f108617j;
            c.a().getClass();
            Object r113 = jc1.a.b().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L43
            if (r113 == null) goto L42;
            PowerManager r114 = (PowerManager) r113;     // Catch: Throwable -> L43
            if (r114.isInteractive() == false) goto L39;
        L40:
            boolean r115 = true;
        L46:
            if (r115 == false) goto L201;
            Map<String, m> r116 = ReplayFloatWindowManager.f108617j;
            c.a().getClass();
            Object r117 = jc1.a.b().getSystemService("keyguard");     // Catch: Exception -> L56
            if ((r117 instanceof KeyguardManager) == true) goto L51;
            r117 = null;
        L51:
            KeyguardManager r118 = (KeyguardManager) r117;     // Catch: Exception -> L56
            if (r118 == null) goto L58;
            if (r118.inKeyguardRestrictedInputMode() == false) goto L58;
            boolean r119 = true;
        L59:
            if (r119 == true) goto L202;
            Map<String, m> r120 = ReplayFloatWindowManager.f108617j;
            SimpleMediaView r121 = c.a().f108622c;
            if (c.a().f108626g == true) goto L203;
            if (r107 == null) goto L204;
            ReplayFloatWindowManager r122 = c.a();
            r122.getClass();
            Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (ReplayFloatWindowManager.f108618k.f108697a == false) goto L211;
            boolean r123 = wq1.b.f560683a;
            if (wq1.b.b(jc1.a.b()) == false) goto L205;
            m r124 = r122.a();
            if (r124 == null) goto L83;
            String r125 = r124.f108694t.f108637i;
            Map<String, m> r126 = ReplayFloatWindowManager.f108617j;
            if (r126 == null) goto L82;
            TypeIntrinsics.asMutableMap(r126).remove(r125);
            if (r124.f108693s == true) goto L78;
            r124.f108693s = true;
            WindowManager r127 = r124.f108675a;
            if (r127 == null) goto L78;
            r127.removeView(r124.f108695u);
        L78:
            r124.f108688n = false;
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r128 = r124.f108694t.f108638j;
            if (r128 == null) goto L83;
            r128.onDismiss();
            goto L83
        L82:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        L83:
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r129 = new com.bytedance.android.livesdk.chatroom.replay.floatwindow.b(jc1.a.b(), r107, r122.f108622c, r122.f108624e);
            r122.f108621b = r129;
            r129.setEpisodeId(r122.f108623d);
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r130 = ReplayRoomFragmentScopeUtil.f117917a;
            com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.o r131 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.o) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.o.class);
            SimpleMediaView r132 = r122.f108622c;
            if (r132 == null) goto L86;
            LayerHostMediaLayout r133 = r132.getLayerHostMediaLayout();
        L87:
            r131.getClass();
            if (r133 == null) goto L90;
            cjc.c r134 = r133.getTextureContainer();
        L92:
            if ((r134 instanceof SurfaceContainerLayout) == false) goto L95;
        L97:
            fq1.a r135 = fq1.b.a();
            if (r135 == null) goto L100;
            IMainEpisode r136 = r135.a();
        L101:
            if (r136 != null) goto L103;
        L104:
            if (r136 != null) goto L106;
        L107:
            if (r136 != null) goto L109;
        L110:
            if (r136 != null) goto L112;
        L116:
            boolean r137 = false;
        L117:
            a r138 = new a();
            r138.f108629a = r122.f108621b;
            r138.f108630b = 0;
            r138.f108631c = 0;
            String r139 = r122.f108620a;
            Intrinsics.checkNotNullParameter(r139, "tag");
            r138.f108637i = r139;
            r138.f108632d = 2;
            int r140 = (int) s1.e(12.0f);
            int r141 = (int) s1.e(12.0f);
            r138.f108633e = r140;
            r138.f108634f = r141;
            AccelerateDecelerateInterpolator r142 = new AccelerateDecelerateInterpolator();
            r138.f108635g = 300;
            r138.f108636h = r142;
            r138.f108639k = true;
            r138.f108640l = r137;
            r138.f108638j = new o(r122);
            Map<String, m> r143 = ReplayFloatWindowManager.f108617j;
            String r144 = r138.f108637i;
            if (r143 == null) goto L187;
            if (r143.containsKey(r144) == false) goto L122;
            ALogger.e("ReplayFloatWindowManager", "Float window has been added!");
        L130:
            wq1.b.f560686d = true;
            if (r107.getRequestedOrientation() != 0) goto L133;
            boolean r145 = true;
        L134:
            r122.f108625f = r145;
            if (r122.f108622c == null) goto L206;
            m r146 = r122.a();
            if (r146 != null) goto L139;
        L141:
            m r147 = r122.a();
            if (r147 == null) goto L207;
            r147.a();
            if (r147.f108687m == false) goto L146;
        L151:
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r148 = r147.f108695u;
            if ((r148 instanceof wq1.a) == false) goto L208;
            DataCenter r149 = r122.f108624e;
            if (r149 == null) goto L156;
            com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r149).d("mini_window_start", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_window_type", Argument.OUT)}), new Object[0]);
        L156:
            SimpleMediaView r150 = r148.f108655n;
            if (r150 == null) goto L161;
            TTVideoEngine r151 = r150.getVideoEngine();
            if (r151 == null) goto L161;
            int r152 = r151.getVideoHeight();
        L162:
            SimpleMediaView r153 = r148.f108655n;
            if (r153 == null) goto L167;
            TTVideoEngine r154 = r153.getVideoEngine();
            if (r154 == null) goto L167;
            int r155 = r154.getVideoWidth();
        L168:
            r148.g(r155, r152);
            SimpleMediaView r156 = r148.f108655n;
            if (r156 == null) goto L171;
            ViewParent r157 = r156.getParent();
        L172:
            if (r157 == null) goto L179;
            ViewParent r158 = r148.f108655n.getParent();
            if ((r158 instanceof ViewGroup) == true) goto L176;
            r158 = null;
        L176:
            ViewGroup r159 = (ViewGroup) r158;
            if (r159 == null) goto L179;
            r159.removeView(r148.f108655n);
        L179:
            ((RelativeLayout) r148.a(R.id.float_video_view_container)).addView(r148.f108655n);
            ((ReplayDragRelativeLayout) r148.a(R.id.float_drag_container)).post(new h(r148));
            mq1.t r160 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
            if (r160 == null) goto L182;
            r102 = r160.provideVSProgressService(r148.f108656o);
        L182:
            r148.f108652k = r102;
            r148.a(R.id.float_mute).setSelected(false);
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r161 = r148.f108643b;
            if (r161 == null) goto L185;
            r161.onShow();
        L185:
            r122.f108627h = System.currentTimeMillis();
            return;
        L171:
            r157 = null;
        L167:
            r155 = 0;
        L161:
            r152 = 0;
            goto L162
        L208:
            return;
        L146:
            if (r147.f108688n == false) goto L151;
            r147.f108695u.setVisibility(4);
            r147.f108688n = false;
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r162 = r147.f108694t.f108638j;
            if (r162 == null) goto L151;
            r162.onHide();
            goto L151
        L207:
            return;
        L139:
            if (r146.f108688n != true) goto L141;
            return;
        L206:
            return;
        L133:
            r145 = false;
            goto L134
        L122:
            com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r163 = r138.f108629a;
            if (r163 == null) goto L129;
            m r164 = new m(r138, r163);
            String r165 = r138.f108637i;
            if (r165 == null) goto L127;
            r143.put(r165, r164);
            Unit r166 = Unit.INSTANCE;
        L128:
            if (r166 != null) goto L130;
        L127:
            r166 = null;
        L129:
            ALogger.e("ReplayFloatWindowManager", "view can not be null!");
            goto L130
        L187:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        L112:
            if (r136.isPrivilegeClarity() != true) goto L116;
        L114:
            if (ReplayConfigSettingKeys.LIVE_PAID_REPLAY_BAN_SCREEN_RECORD.getValue().booleanValue() == false) goto L116;
            r137 = true;
            goto L117
        L109:
            if (r136.isPrivilegeCameraReplay() == true) goto L114;
        L106:
            if (r136.isPaidCameraReplay() == true) goto L114;
        L103:
            if (r136.isPaidReplay() == true) goto L114;
        L100:
            r136 = null;
            goto L101
        L95:
            if ((r134 instanceof TextureContainerLayout) == false) goto L97;
            r134.getVideoContainer();
            goto L97
        L90:
            r134 = null;
            goto L92
        L86:
            r133 = null;
            goto L87
        L205:
            return;
        L211:
            return;
        L204:
            return;
        L203:
            return;
        L202:
            return;
        L58:
            r119 = false;
        L56:
            e = move-exception;
            ALogger.e("ReplayFloatWindowManager", "isScreenLocked " + e.getMessage());
            goto L58
        L201:
            return;
        L39:
            if (r114.isScreenOn() == true) goto L40;
        L45:
            r115 = false;
            goto L46
        L42:
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            ALogger.e("ReplayFloatWindowManager", "isScreenInteractive " + th.getMessage());
            goto L45
        L200:
            return;
        L188:
            Map<String, m> r167 = ReplayFloatWindowManager.f108617j;
            SimpleMediaView r168 = c.a().f108622c;
            if (r168 == null) goto L210;
            r168.j();
            return;
        L210:
            return;
        L29:
            r109 = false;
            goto L30
        L9:
            if (TextUtils.equals(r103, r104.toString()) == false) goto L11;
            r105 = true;
            goto L12
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.api.a
        public final void onResume(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Map<String, m> r101 = ReplayFloatWindowManager.f108617j;
            c.a().b();
            Activity r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().getTopActivity();
            if (r102 == null) goto L6;
            c.a().d(r102);
        L6:
            if (c.a().f108625f == false) goto L12;
            SimpleMediaView r103 = c.a().f108622c;
            if (r103 == null) goto L10;
            r103.postDelayed(a.f108641a, 500);
        L10:
            c.a().f108625f = false;
            return;
        }
    }

    public static final class c {
        public static ReplayFloatWindowManager a() {
            return (ReplayFloatWindowManager) ReplayFloatWindowManager.f108619l.getValue();
        }
    }

    public final void b() {
        wq1.b.f560686d = false;
        m r100 = a();
        if (r100 == null) goto L13;
        boolean r101 = r100.f108688n;
        if (r101 == false) goto L13;
        if (r100.f108687m == true) goto L13;
        if (r101 == false) goto L13;
        r100.f108695u.setVisibility(4);
        r100.f108688n = false;
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r102 = r100.f108694t.f108638j;
        if (r102 == null) goto L13;
        r102.onHide();
    L13:
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r103 = this.f108621b;
        if (r103 == null) goto L24;
        VideoContext r104 = VideoContext.n0(r103.f108654m);
        ((ReplayDragRelativeLayout) r103.a(R.id.float_drag_container)).post(new i(r103, r104));
        Long r105 = r103.f108650i;
        if (r105 == null) goto L22;
        long r106 = r105.longValue();
        TTVideoEngine r107 = r104.o0();
        if (r107 == null) goto L20;
        int r108 = r107.getCurrentPlaybackTime();
    L21:
        sq1.c.b(r106, r108);
        goto L22
    L20:
        r108 = 0;
    L22:
        r103.f();
    L24:
        if (this.f108627h <= 0) goto L30;
        DataCenter r109 = this.f108624e;
        if (r109 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r109).d("mini_window_stay_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_window_type", Argument.OUT), TuplesKt.to("duration", String.valueOf(System.currentTimeMillis() - this.f108627h))}), new Object[0]);
    L28:
        this.f108627h = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.floatwindow.s.b
    public final void onScreenOn() {
    }

    static {
        f108617j = new LinkedHashMap();
        f108618k = new n(jc1.a.b(), new b());
        f108619l = LazyKt.lazy(ReplayFloatWindowManager$Companion$instance$2.INSTANCE);
    }

    public final m a() {
        String r100 = this.f108620a;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return (m) ((LinkedHashMap) f108617j).get(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.floatwindow.s.b
    public final void onScreenOff() {
        SimpleMediaView r100 = this.f108622c;
        if (r100 == null) goto L5;
        boolean r101 = r100.h();
    L6:
        this.f108628i = r101;
        if (r101 == false) goto L15;
        SimpleMediaView r102 = this.f108622c;
        if (r102 == null) goto L11;
        r102.j();
    L11:
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r103 = this.f108621b;
        if (r103 == null) goto L16;
        r103.e(false, true);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.floatwindow.s.b
    public final void onUserPresent() {
        if (this.f108628i == false) goto L15;
        SimpleMediaView r100 = this.f108622c;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.h() == true) goto L17;
        SimpleMediaView r101 = this.f108622c;
        if (r101 == null) goto L11;
        r101.k();
    L11:
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.b r102 = this.f108621b;
        if (r102 == null) goto L18;
        r102.e(false, false);
        return;
    L18:
        return;
    L17:
        return;
    }

    public ReplayFloatWindowManager() {
        this.f108620a = "replay_video_float_view";
        Application r100 = jc1.a.b();
        s r101 = new s(r100);
        r101.f108715b = this;
        if (r100 == null) goto L39;
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.intent.action.SCREEN_ON");
        r102.addAction("android.intent.action.SCREEN_OFF");
        r102.addAction("android.intent.action.USER_PRESENT");
        s.a r103 = r101.f108714a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L37:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r102);
        return;
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L21;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r102, 0, null, null, 2, r100).result;     // Catch: Exception -> L30
        if (r104 != 1) goto L14;
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L30
    L36:
        return;
    L14:
        if (r104 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L36
    L16:
        if (r104 == 3) goto L36;
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r100.registerReceiver(r103, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L36
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L30
        goto L36
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r100, r103, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
        goto L36
    }

    public final boolean c() {
        m r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f108688n != true) goto L7;
        return true;
    }

    public final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = nq1.d.f520096e;
        if (r101.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        if (wq1.b.b(r100) == true) goto L7;
        return;
    L7:
        if ((r100 instanceof Activity) == false) goto L18;
        Resources r102 = ((Activity) r100).getResources();
        if (r102 == null) goto L18;
        Configuration r103 = r102.getConfiguration();
        if (r103 == null) goto L18;
        if (r103.orientation != 2) goto L18;
        ArrayList r104 = new ArrayList();
        lm3.c r105 = new lm3.c();
        r105.f509864b = s1.B(R.string.ttlive_dialog_notified);
        r104.add(r105);
        lm3.d.a r106 = new lm3.d.a(r100);
        r106.f509870a = s1.B(R.string.ttlive_video_float_window_dialog_title);
        r106.f509871b = s1.B(R.string.ttlive_video_float_window_dialog_hint);
        r106.f509874e = r104;
        lm3.d r107 = r106.a();
        DataCenter r108 = this.f108624e;
        if (r108 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r108).d("mini_window_open_success_popup_show", null, new Object[0]);
    L17:
        r107.setCanceledOnTouchOutside(false);
    L19:
        com.bytedance.android.livesdk.sharedpref.f.d(r101, Boolean.TRUE);
        return;
    L18:
        new r(r100).a(this.f108624e);
        goto L19
    }
}
