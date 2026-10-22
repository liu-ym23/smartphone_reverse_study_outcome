package com.bytedance.android.livesdk.player.surfacecontrol.dbr;

import android.hardware.HardwareBuffer;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdk.player.PlayerEventHub;
import com.bytedance.android.livesdk.player.PlayerLoggerNextLiveData;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdk.player.surfacecontrol.v2.SurfaceControlManager;
import com.bytedance.android.livesdk.player.utils.g;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.SurfaceControlHardwareBufferConfig;
import com.bytedance.android.livesdkapi.player.ILivePlayerEventController;
import com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor;
import com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.KeepSurfaceControlRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class SurfaceControlRenderManager extends LivePlayerEventListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f156110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f156111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SurfaceControlHardwareBufferConfig f156112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f156113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f156114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.a f156115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Pair<Integer, Integer> f156116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f156117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<LivePlayerClient> f156118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SurfaceControlManager.a f156119j;

    public final class NormalSurfaceSmoothSolution extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile SurfaceControlRender f156120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f156121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Runnable f156122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f156123d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SurfaceControlRenderManager$NormalSurfaceSmoothSolution$firstFrameRenderObserver$1 f156124e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f156125f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ SurfaceControlRenderManager f156126g;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NormalSurfaceSmoothSolution f156127a;

            public a(NormalSurfaceSmoothSolution r100) {
                this.f156127a = r100;
            }

            public final void a() {
                if (this.f156127a.f156120a == null) goto L27;
                this.f156127a.f156121b.run();
                this.f156127a.f156126g.a("doubleRender force release");
                LivePlayerClient r100 = this.f156127a.f156126g.f156118i.get();
                if (r100 == null) goto L7;
                int r101 = is0.b.f495579a;
                r100.registerPlayerFeature(is0.b.a.a("smooth_enter_force_render", 1, 2));
            L7:
                LivePlayerClient r102 = this.f156127a.f156126g.f156118i.get();
                if (r102 == null) goto L15;
                IRoomEventHub r103 = r102.getEventHub();
                if (r103 == null) goto L15;
                MutableLiveData<Boolean> r104 = r103.getSurfaceReadyFirstFrameRender();
                if (r104 == null) goto L15;
                r104.removeObserver(this.f156127a.f156124e);
            L15:
                if (this.f156127a.f156126g.f156112c.getEnableExceptionReport() == false) goto L28;
                LivePlayerClient r105 = this.f156127a.f156126g.f156118i.get();
                if (r105 == null) goto L29;
                String r106 = com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.b(r105, com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.a(r105), "hwb_e");
                int r107 = is0.b.f495579a;
                SurfaceControlRender r108 = this.f156127a.f156120a;
                int r109 = 0;
                if (r108 == null) goto L21;
                int r110 = r108.f156103i;
            L22:
                r105.registerPlayerFeature(is0.b.a.a("hwb_e_render_count", 0, r110));
                SurfaceControlRenderManager r111 = this.f156127a.f156126g;
                StringBuilder r112 = new StringBuilder("HWBExceptionReporter: ");
                r112.append(r106);
                r112.append(" renderCount:");
                SurfaceControlRender r113 = this.f156127a.f156120a;
                if (r113 == null) goto L25;
                r109 = r113.f156103i;
            L25:
                r112.append(r109);
                r111.a(r112.toString());
                return;
            L21:
                r110 = 0;
                goto L22
            L29:
                return;
            L28:
                return;
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

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NormalSurfaceSmoothSolution f156128a;

            public b(NormalSurfaceSmoothSolution r100) {
                this.f156128a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerClient r100 = this.f156128a.f156126g.f156118i.get();     // Catch: Throwable -> L12
                if (r100 == null) goto L15;
                LivePlayerContext r101 = r100.getPlayerContext();     // Catch: Throwable -> L12
                if (r101 == null) goto L19;
                PlayerEventHub r102 = r101.M;     // Catch: Throwable -> L12
                if (r102 == null) goto L20;
                PlayerLoggerNextLiveData<Boolean> r103 = r102.f155073r;     // Catch: Throwable -> L12
                if (r103 == null) goto L21;
                r103.a(Boolean.TRUE, "SurfaceControlRenderManager");     // Catch: Throwable -> L12
                return;
            L21:
                return;
            L20:
                return;
            L19:
                return;
            L15:
                return;
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L22;
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NormalSurfaceSmoothSolution f156129a;

            public c(NormalSurfaceSmoothSolution r100) {
                this.f156129a = r100;
            }

            public final void a() {
                SurfaceControlRender r100 = this.f156129a.f156120a;
                if (r100 == null) goto L13;
                r100.c();
                this.f156129a.f156120a = null;
                LivePlayerClient r101 = this.f156129a.f156126g.f156118i.get();
                if (r101 == null) goto L11;
                LivePlayerContext r102 = r101.getPlayerContext();
                if (r102 == null) goto L11;
                ITTLivePlayer r103 = r102.f154929e;
                if (r103 == null) goto L11;
                r103.O(0);
            L11:
                NormalSurfaceSmoothSolution r104 = this.f156129a;
                r104.f156122c = null;
                r104.f156125f = false;
                r104.f156126g.a("doubleRender release");
                return;
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

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final SurfaceControl a() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void c() {
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void h(int r100, int r101) {
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean b() {
            if (this.f156120a == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void e() {
            SurfaceControlRender r100 = this.f156120a;
            if (r100 == null) goto L6;
            r100.c();
            return;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void f() {
            this.f156126g.a("onSurfaceViewAttach:");
            LivePlayerClient r100 = this.f156126g.f156118i.get();
            if (r100 != null) goto L5;
        L6:
            LivePlayerClient r101 = this.f156126g.f156118i.get();
            if (r101 == null) goto L15;
            LivePlayerClientContext r102 = r101.context();
            if (r102 != null) goto L11;
            return;
        L11:
            if (r102.isLiveHeadEnterSmooth() == true) goto L17;
            g();
            return;
        L17:
            return;
        L15:
            return;
        L5:
            if (r100.globalSurfaceControlRender$live_player_impl_saasRelease() != true) goto L6;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean g() {
            LivePlayerClient r100 = this.f156126g.f156118i.get();
            if (r100 != null) goto L5;
        L7:
            LivePlayerClient r101 = this.f156126g.f156118i.get();
            SurfaceHolder r102 = null;
            if (r101 == null) goto L12;
            LivePlayerContext r103 = r101.getPlayerContext();
            if (r103 == null) goto L12;
            IRenderView r104 = r103.b();
        L14:
            if ((r104 instanceof SurfaceRenderView) == true) goto L16;
        L117:
            return false;
        L16:
            if (this.f156120a == null) goto L72;
            this.f156126g.a("resetSurface1: " + this.f156125f);
            if (this.f156125f == true) goto L71;
            LivePlayerClient r105 = this.f156126g.f156118i.get();
            if (r105 == null) goto L26;
            LivePlayerContext r106 = r105.getPlayerContext();
            if (r106 == null) goto L26;
            ITTLivePlayer r107 = r106.f154929e;
            if (r107 == null) goto L26;
            r107.setSetSurfaceInterceptor(null);
        L26:
            SurfaceControlRenderManager r108 = this.f156126g;
            SurfaceControlManager.a r109 = r108.f156119j;
            LivePlayerClient r110 = r108.f156118i.get();
            if (r110 == null) goto L31;
            LivePlayerContext r111 = r110.getPlayerContext();
            if (r111 == null) goto L31;
            IRenderView r112 = r111.b();
        L33:
            if ((r112 instanceof SurfaceRenderView) == true) goto L35;
            r112 = null;
        L35:
            SurfaceRenderView r113 = (SurfaceRenderView) r112;
            if (r113 == null) goto L38;
            r102 = r113.getHolder();
        L38:
            r109.N(r102, true);
            LivePlayerClient r114 = this.f156126g.f156118i.get();
            if (r114 == null) goto L45;
            IRoomEventHub r115 = r114.getEventHub();
            if (r115 == null) goto L45;
            MutableLiveData<Boolean> r116 = r115.getSurfaceReadyFirstFrameRender();
            if (r116 == null) goto L45;
            r116.removeObserver(this.f156124e);
        L45:
            LivePlayerClient r117 = this.f156126g.f156118i.get();
            if (r117 == null) goto L52;
            IRoomEventHub r118 = r117.getEventHub();
            if (r118 == null) goto L52;
            MutableLiveData<Boolean> r119 = r118.getSurfaceReadyFirstFrameRender();
            if (r119 == null) goto L52;
            r119.observeForever(this.f156124e);
        L52:
            LivePlayerClient r120 = this.f156126g.f156118i.get();
            if (r120 == null) goto L61;
            LivePlayerContext r121 = r120.getPlayerContext();
            if (r121 == null) goto L61;
            IRenderView r122 = r121.b();
            if (r122 == null) goto L61;
            View r123 = r122.getSelfView();
            if (r123 == null) goto L61;
            r123.removeCallbacks(this.f156123d);
        L61:
            LivePlayerClient r124 = this.f156126g.f156118i.get();
            if (r124 == null) goto L70;
            LivePlayerContext r125 = r124.getPlayerContext();
            if (r125 == null) goto L70;
            IRenderView r126 = r125.b();
            if (r126 == null) goto L70;
            View r127 = r126.getSelfView();
            if (r127 == null) goto L70;
            r127.postDelayed(this.f156123d, this.f156126g.f156112c.getForceResetDelay());
        L70:
            this.f156125f = true;
        L31:
            r112 = null;
        L71:
            return true;
        L72:
            LivePlayerClient r128 = this.f156126g.f156118i.get();
            if (r128 == null) goto L117;
            if (r128.isTextureRender() == true) goto L117;
            LivePlayerClient r129 = this.f156126g.f156118i.get();
            if (r129 == null) goto L81;
            LivePlayerContext r130 = r129.getPlayerContext();
            if (r130 == null) goto L81;
            IRenderView r131 = r130.b();
        L83:
            if ((r131 instanceof SurfaceRenderView) == true) goto L85;
            r131 = null;
        L85:
            SurfaceRenderView r132 = (SurfaceRenderView) r131;
            if (r132 == null) goto L90;
            SurfaceHolder r133 = r132.getSurfaceHolder();
            if (r133 == null) goto L90;
            Surface r134 = r133.getSurface();
        L91:
            LivePlayerClient r135 = this.f156126g.f156118i.get();
            if (r135 == null) goto L94;
            Surface r136 = r135.getActualPlayerSurface();
        L96:
            if ((!Intrinsics.areEqual(r136, r134)) == false) goto L117;
            LivePlayerClient r137 = this.f156126g.f156118i.get();
            if (r137 == null) goto L104;
            LivePlayerContext r138 = r137.getPlayerContext();
            if (r138 == null) goto L104;
            ITTLivePlayer r139 = r138.f154929e;
            if (r139 == null) goto L104;
            r139.setSetSurfaceInterceptor(null);
        L104:
            SurfaceControlRenderManager r140 = this.f156126g;
            SurfaceControlManager.a r141 = r140.f156119j;
            LivePlayerClient r142 = r140.f156118i.get();
            if (r142 == null) goto L109;
            LivePlayerContext r143 = r142.getPlayerContext();
            if (r143 == null) goto L109;
            IRenderView r144 = r143.b();
        L111:
            if ((r144 instanceof SurfaceRenderView) == true) goto L113;
            r144 = null;
        L113:
            SurfaceRenderView r145 = (SurfaceRenderView) r144;
            if (r145 == null) goto L116;
            r102 = r145.getHolder();
        L116:
            r141.N(r102, false);
            this.f156126g.a("resetSurface2:");
        L109:
            r144 = null;
            goto L111
        L94:
            r136 = null;
        L90:
            r134 = null;
        L81:
            r131 = null;
        L12:
            r104 = null;
            goto L14
        L5:
            if (r100.isTextureRender() != true) goto L7;
            return false;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager$NormalSurfaceSmoothSolution$firstFrameRenderObserver$1] */
        public NormalSurfaceSmoothSolution(SurfaceControlRenderManager r100) {
            this.f156126g = r100;
            this.f156121b = new c(this);
            this.f156123d = new a(this);
            this.f156124e = new SurfaceControlRenderManager$NormalSurfaceSmoothSolution$firstFrameRenderObserver$1(this);
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean i(SurfaceHolder r110) {
            LivePlayerClient r100 = this.f156126g.f156118i.get();
            if (r100 != null) goto L5;
        L7:
            if (r110 != null) goto L9;
            return false;
        L9:
            LivePlayerClient r101 = this.f156126g.f156118i.get();
            if (r101 == null) goto L12;
            r101.getPlayerContext();
        L12:
            LivePlayerClient r102 = this.f156126g.f156118i.get();
            SurfaceControlRender r103 = null;
            if (r102 == null) goto L17;
            LivePlayerContext r104 = r102.getPlayerContext();
            if (r104 == null) goto L17;
            IRenderView r105 = r104.b();
        L19:
            if ((r105 instanceof SurfaceRenderView) == true) goto L21;
            r105 = null;
        L21:
            SurfaceRenderView r106 = (SurfaceRenderView) r105;
            if (r106 != null) goto L24;
            return false;
        L24:
            LivePlayerClient r107 = this.f156126g.f156118i.get();
            if (r107 == null) goto L31;
            LivePlayerContext r108 = r107.getPlayerContext();
            if (r108 == null) goto L31;
            ITTLivePlayer r109 = r108.f154929e;
            if (r109 == null) goto L31;
            ISetSurfaceInterceptor r111 = r109.J0();
        L32:
            if (r111 == null) goto L34;
            LivePlayerClient r112 = this.f156126g.f156118i.get();
            Intrinsics.checkNotNull(r112);
            ISetSurfaceInterceptor.MODE r113 = r111.intercept(r112, null);
        L36:
            if (r113 != ISetSurfaceInterceptor.MODE.ADD) goto L134;
            SurfaceControlRenderManager r114 = this.f156126g;
            if (r114.f156111b == true) goto L45;
            LivePlayerClient r115 = r114.f156118i.get();
            if (r115 == null) goto L72;
            LivePlayerClientContext r116 = r115.context();
            if (r116 == null) goto L72;
            if (r116.isLiveHeadEnterSmooth() == true) goto L45;
        L72:
            boolean r117 = false;
        L73:
            if (r117 == true) goto L75;
            LivePlayerClient r118 = this.f156126g.f156118i.get();
            if (r118 == null) goto L134;
            if (r118.isTextureRender() == true) goto L134;
            LivePlayerClient r119 = this.f156126g.f156118i.get();
            if (r119 == null) goto L133;
            LivePlayerContext r120 = r119.getPlayerContext();
            if (r120 == null) goto L133;
            ITTLivePlayer r121 = r120.f154929e;
            if (r121 == null) goto L133;
            r121.setSetSurfaceInterceptor(null);
        L133:
            this.f156126g.f156119j.N(r110, false);
            goto L134
        L75:
            if (this.f156120a != null) goto L134;
            int r122 = SurfaceControlRender.f156094l;
            LivePlayerClient r123 = this.f156126g.f156118i.get();
            if (r123 == null) goto L83;
            Pair<Integer, Integer> r124 = r123.getVideoSize();
            if (r124 == null) goto L83;
            Integer r125 = r124.getFirst();
            if (r125 == null) goto L83;
            int r126 = r125.intValue();
        L84:
            LivePlayerClient r127 = this.f156126g.f156118i.get();
            if (r127 == null) goto L91;
            Pair<Integer, Integer> r128 = r127.getVideoSize();
            if (r128 == null) goto L91;
            Integer r129 = r128.getSecond();
            if (r129 == null) goto L91;
            int r130 = r129.intValue();
        L92:
            Intrinsics.checkNotNullParameter("live-double-layer", "name");
            if (r126 <= 0) goto L97;
            if (r130 <= 0) goto L97;
            SurfaceControlRender r131 = new SurfaceControlRender();
            r131.f156095a = new SurfaceControlCompat(new SurfaceControl.Builder().setName("live-double-layer").setBufferSize(r126, r130).setOpaque(false));
        L99:
            if (r131 == null) goto L117;
            r131.f156098d = 2;
            LivePlayerClient r132 = this.f156126g.f156118i.get();
            if (r132 == null) goto L107;
            Pair<Integer, Integer> r133 = r132.getVideoSize();
            if (r133 == null) goto L107;
            Integer r134 = r133.getFirst();
            if (r134 == null) goto L107;
            int r135 = r134.intValue();
        L108:
            LivePlayerClient r136 = this.f156126g.f156118i.get();
            if (r136 == null) goto L115;
            Pair<Integer, Integer> r137 = r136.getVideoSize();
            if (r137 == null) goto L115;
            Integer r138 = r137.getSecond();
            if (r138 == null) goto L115;
            int r139 = r138.intValue();
        L116:
            r131.d(r135, r139);
            r131.e(r106);
            Unit r140 = Unit.INSTANCE;
            r103 = r131;
        L115:
            r139 = 1;
        L107:
            r135 = 1;
        L117:
            this.f156120a = r103;
            this.f156126g.openHardwareBufferOutput();
            this.f156126g.a("updateRenderView createDoubleRender:");
            LivePlayerClient r141 = this.f156126g.f156118i.get();
            if (r141 == null) goto L120;
            int r142 = is0.b.f495579a;
            r141.registerPlayerFeature(is0.b.a.a("use_hwb_dbr", 1, 2));
        L120:
            g.e(0, false, false, new SurfaceControlRenderManager$NormalSurfaceSmoothSolution$setDisplay$2(this), 7);
            return true;
        L97:
            r131 = null;
        L91:
            r130 = 1;
        L83:
            r126 = 1;
        L45:
            LivePlayerClient r143 = this.f156126g.f156118i.get();
            if (r143 == null) goto L72;
            if (r143.isTextureRender() == true) goto L72;
            LivePlayerClient r144 = this.f156126g.f156118i.get();
            if (r144 == null) goto L72;
            if (r144.isVrLive() == true) goto L72;
            LivePlayerClient r145 = this.f156126g.f156118i.get();
            if (r145 == null) goto L72;
            ILivePlayerExtraRenderController r146 = r145.extraRenderController();
            if (r146 == null) goto L72;
            if (r146.isEnable() == true) goto L72;
            LivePlayerClient r147 = this.f156126g.f156118i.get();
            if (r147 == null) goto L72;
            ILivePlayerGameExtraRenderController r148 = r147.gameExtraRenderController();
            if (r148 == null) goto L72;
            if (r148.isEnable() == true) goto L72;
            LivePlayerClient r149 = this.f156126g.f156118i.get();
            if (r149 == null) goto L72;
            ILivePlayerMultiRenderController r150 = r149.multiRenderController();
            if (r150 == null) goto L72;
            if (r150.isEnable() == true) goto L72;
            r117 = true;
        L134:
            return false;
        L34:
            r113 = null;
        L31:
            r111 = null;
        L17:
            r105 = null;
            goto L19
        L5:
            if (r100.isTextureRender() != true) goto L7;
            return false;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean d(HardwareBuffer r110, int[] r111, int r112) {
            Intrinsics.checkNotNullParameter(r110, "hardwareBuffer");
            Intrinsics.checkNotNullParameter(r111, "roi");
            if (r111.length < 4) goto L53;
            SurfaceControlRenderManager r100 = this.f156126g;
            StringBuilder r101 = new StringBuilder("onHWBDrawFrame: ");
            r101.append(r110);
            r101.append(' ');
            r101.append(r112);
            r101.append(' ');
            SurfaceControlRender r102 = this.f156120a;
            if (r102 == null) goto L7;
            int r103 = r102.f156103i;
        L8:
            r101.append(r103);
            r100.b(r101.toString());
            SurfaceControlRender r104 = this.f156120a;
            if (r104 == null) goto L27;
            int r105 = r111[2];
            int r113 = r111[3];
            if (Build.VERSION.SDK_INT < 33) goto L27;
            if (r104.f156095a == null) goto L27;
            Object r106 = r104.f156105k;
            monitor-enter(r106);
            SurfaceControlCompat r107 = r104.f156095a;     // Catch: Throwable -> L24
            if (r107 == null) goto L22;
            SurfaceControlCompat.Transaction r108 = r104.f156102h;     // Catch: Throwable -> L24
            r108.c(r107, r110);     // Catch: Throwable -> L24
            if (r104.f156104j == r112) goto L21;
            r108.e(r107, SurfaceControlRender.b(r112));     // Catch: Throwable -> L24
            r104.f156104j = r112;     // Catch: Throwable -> L24
        L21:
            r108.a();     // Catch: Throwable -> L24
            r104.d(r105, r113);     // Catch: Throwable -> L24
            r104.f156103i++;     // Catch: Throwable -> L24
        L22:
            monitor-exit(r106);
        L24:
            th = move-exception;
            throw th;
        L27:
            SurfaceControlRender r114 = this.f156120a;
            if (r114 == null) goto L41;
            if (r114.f156103i != this.f156126g.f156112c.getRenderCount()) goto L41;
            LivePlayerClient r115 = this.f156126g.f156118i.get();
            if (r115 == null) goto L41;
            LivePlayerContext r116 = r115.getPlayerContext();
            if (r116 == null) goto L41;
            IRenderView r117 = r116.b();
            if (r117 == null) goto L41;
            View r118 = r117.getSelfView();
            if (r118 == null) goto L41;
            r118.post(new b(this));
        L41:
            if (this.f156122c == null) goto L53;
            LivePlayerClient r119 = this.f156126g.f156118i.get();
            if (r119 == null) goto L51;
            LivePlayerContext r120 = r119.getPlayerContext();
            if (r120 == null) goto L51;
            IRenderView r121 = r120.b();
            if (r121 == null) goto L51;
            View r122 = r121.getSelfView();
            if (r122 == null) goto L51;
            r122.removeCallbacks(this.f156123d);
        L51:
            final Runnable r123 = this.f156122c;
            g.e(0, true, false, new SurfaceControlRenderManager$NormalSurfaceSmoothSolution$onHWBDrawFrame$2(r123), 5);
            this.f156122c = null;
            goto L53
        L7:
            r103 = 0;
        L53:
            if (this.f156120a == null) goto L58;
            return true;
        L58:
            return false;
        }
    }

    public final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SyncSurfaceControlRender f156131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile c f156132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SurfaceControlRenderManager f156133c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager$a$a, reason: collision with other inner class name */
        public static final class RunnableC2387a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f156134a;

            public RunnableC2387a(a r100) {
                this.f156134a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerClient r100 = this.f156134a.f156133c.f156118i.get();     // Catch: Throwable -> L12
                if (r100 == null) goto L15;
                LivePlayerContext r101 = r100.getPlayerContext();     // Catch: Throwable -> L12
                if (r101 == null) goto L19;
                PlayerEventHub r102 = r101.M;     // Catch: Throwable -> L12
                if (r102 == null) goto L20;
                PlayerLoggerNextLiveData<Boolean> r103 = r102.f155073r;     // Catch: Throwable -> L12
                if (r103 == null) goto L21;
                r103.a(Boolean.TRUE, "SurfaceControlRenderManager");     // Catch: Throwable -> L12
                return;
            L21:
                return;
            L20:
                return;
            L19:
                return;
            L15:
                return;
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L22;
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f156135a;

            public b(a r100) {
                this.f156135a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c r100 = this.f156135a.f156132b;     // Catch: Throwable -> L13
                if (r100 == null) goto L5;
                r100.release();     // Catch: Throwable -> L13
            L5:
                this.f156135a.f156132b = null;     // Catch: Throwable -> L13
                LivePlayerClient r101 = this.f156135a.f156133c.f156118i.get();     // Catch: Throwable -> L13
                if (r101 == null) goto L16;
                LivePlayerContext r102 = r101.getPlayerContext();     // Catch: Throwable -> L13
                if (r102 == null) goto L20;
                ITTLivePlayer r103 = r102.f154929e;     // Catch: Throwable -> L13
                if (r103 == null) goto L21;
                r103.O(0);     // Catch: Throwable -> L13
                return;
            L21:
                return;
            L20:
                return;
            L16:
                return;
            L13:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L22;
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void f() {
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final SurfaceControl a() {
            SyncSurfaceControlRender r100 = this.f156131a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f();
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean b() {
            if (this.f156132b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void e() {
            if (this.f156131a == null) goto L17;
            monitor-enter(this);
            SyncSurfaceControlRender r100 = this.f156131a;     // Catch: Throwable -> L14
            if (r100 == null) goto L8;
            r100.h();     // Catch: Throwable -> L14
        L8:
            this.f156131a = null;     // Catch: Throwable -> L14
            c r101 = this.f156132b;     // Catch: Throwable -> L14
            if (r101 == null) goto L11;
            r101.release();     // Catch: Throwable -> L14
        L11:
            this.f156132b = null;     // Catch: Throwable -> L14
            this.f156133c.b("tryRelease:");     // Catch: Throwable -> L14
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean g() {
            SyncSurfaceControlRender r100 = this.f156131a;
            Object r101 = null;
            Surface r102 = null;
            r101 = null;
            if (r100 == null) goto L5;
            SurfaceControl r103 = r100.f();
        L7:
            if (r103 == null) goto L9;
            boolean r104 = true;
        L10:
            if (r104 == false) goto L86;
            LivePlayerClient r105 = this.f156133c.f156118i.get();
            if (r105 == null) goto L16;
            LivePlayerContext r106 = r105.getPlayerContext();
            if (r106 == null) goto L16;
            IRenderView r107 = r106.b();
        L18:
            if ((r107 instanceof SurfaceView) == false) goto L86;
            SyncSurfaceControlRender r108 = this.f156131a;
            if (r108 == null) goto L86;
            if (this.f156132b == null) goto L46;
            LivePlayerClient r109 = this.f156133c.f156118i.get();
            if (r109 == null) goto L28;
            LivePlayerContext r110 = r109.getPlayerContext();
            if (r110 == null) goto L28;
            Object r111 = r110.b();
        L29:
            if (r111 == null) goto L45;
            r108.j((SurfaceView) r111);
            SurfaceControlManager.a r112 = this.f156133c.f156119j;
            SyncSurfaceControlRender r113 = this.f156131a;
            if (r113 == null) goto L33;
            r102 = r113.e();
        L33:
            r112.setSurfaceDisplay(r102);
            LivePlayerClient r114 = this.f156133c.f156118i.get();
            if (r114 == null) goto L42;
            LivePlayerContext r115 = r114.getPlayerContext();
            if (r115 == null) goto L42;
            IRenderView r116 = r115.b();
            if (r116 == null) goto L42;
            View r117 = r116.getSelfView();
            if (r117 == null) goto L42;
            r117.post(new b(this));
        L42:
            this.f156133c.b("resetSurface1:");
            return true;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
        L28:
            r111 = null;
            goto L29
        L46:
            LivePlayerClient r118 = this.f156133c.f156118i.get();
            if (r118 == null) goto L51;
            LivePlayerContext r119 = r118.getPlayerContext();
            if (r119 == null) goto L51;
            IRenderView r120 = r119.b();
        L52:
            if (r120 == null) goto L85;
            if (Intrinsics.areEqual(j(r108, (SurfaceRenderView) r120), Boolean.TRUE) == false) goto L86;
            SyncSurfaceControlRender r121 = this.f156131a;
            if (r121 == null) goto L58;
            Surface r122 = r121.e();
        L59:
            if (r122 == null) goto L82;
            LivePlayerClient r123 = this.f156133c.f156118i.get();
            if (r123 == null) goto L63;
            Surface r124 = r123.getActualPlayerSurface();
        L65:
            if ((!Intrinsics.areEqual(r124, r122)) == false) goto L82;
            LivePlayerClient r125 = this.f156133c.f156118i.get();
            if (r125 == null) goto L73;
            LivePlayerContext r126 = r125.getPlayerContext();
            if (r126 == null) goto L73;
            ITTLivePlayer r127 = r126.f154929e;
            if (r127 == null) goto L73;
            r127.resetSurface(r122);
        L73:
            LivePlayerClient r128 = this.f156133c.f156118i.get();
            if (r128 == null) goto L78;
            LivePlayerContext r129 = r128.getPlayerContext();
            if (r129 == null) goto L78;
            r101 = r129.b();
        L78:
            if (r101 == null) goto L81;
            r108.j((SurfaceView) r101);
            goto L82
        L81:
            throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
        L63:
            r124 = null;
        L82:
            this.f156133c.b("resetSurface2:");
            return true;
        L58:
            r122 = null;
            goto L59
        L85:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
        L51:
            r120 = null;
        L16:
            r107 = null;
        L86:
            this.f156133c.b("resetSurfaceIgnore:");
            return false;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void c() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f156131a != null) goto L11;
            int r100 = SyncSurfaceControlRender.f156136n;     // Catch: Throwable -> L14
            SyncSurfaceControlRender r101 = SyncSurfaceControlRender.a.a("live-player-layer", 1, 1);     // Catch: Throwable -> L14
            if (r101 == null) goto L9;
            r101.f156141e = 1;     // Catch: Throwable -> L14
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L10:
            this.f156131a = r101;     // Catch: Throwable -> L14
            this.f156133c.b("tryCreate:" + this.f156131a);     // Catch: Throwable -> L14
            goto L11
        L9:
            r101 = null;
        L11:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(this);
        }

        public a(SurfaceControlRenderManager r100) {
            this.f156133c = r100;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean i(SurfaceHolder r100) {
            SyncSurfaceControlRender r101 = this.f156131a;
            IRenderView r102 = null;
            if (r101 == null) goto L5;
            SurfaceControl r103 = r101.f();
        L7:
            if (r103 == null) goto L9;
            boolean r104 = true;
        L10:
            if (r104 == false) goto L25;
            if (r100 == null) goto L25;
            if ((r100 instanceof KeepSurfaceControlRenderView.CustomSurfaceHolder) == false) goto L15;
            k(r100, ((KeepSurfaceControlRenderView.CustomSurfaceHolder) r100).getSurfaceView());
        L22:
            return true;
        L15:
            LivePlayerClient r105 = this.f156133c.f156118i.get();
            if (r105 == null) goto L20;
            LivePlayerContext r106 = r105.getPlayerContext();
            if (r106 == null) goto L20;
            r102 = r106.b();
        L20:
            if (r102 == null) goto L24;
            k(r100, (SurfaceRenderView) r102);
            goto L22
        L24:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
        L25:
            this.f156133c.b("setDisplayIgnore:");
            return false;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = null;
            goto L7
        }

        public static Boolean j(SyncSurfaceControlRender r100, SurfaceView r101) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.f() != null) goto L8;
        L11:
            boolean r102 = true;
        L13:
            return Boolean.valueOf(r102);
        L8:
            if (Intrinsics.areEqual(r100.d(), r101.getSurfaceControl()) == true) goto L11;
            r102 = false;
            goto L13
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final void h(int r100, int r101) {
            if (this.f156131a == null) goto L13;
            monitor-enter(this);
            SyncSurfaceControlRender r102 = this.f156131a;     // Catch: Throwable -> L10
            if (r102 == null) goto L8;
            r102.i(r100, r101);     // Catch: Throwable -> L10
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void k(SurfaceHolder r100, SurfaceRenderView r101) {
            LivePlayerClient r102 = this.f156133c.f156118i.get();
            if (r102 == null) goto L5;
            r102.getPlayerContext();
        L5:
            LivePlayerClient r103 = this.f156133c.f156118i.get();
            SyncSurfaceControlRender r104 = null;
            Surface r105 = null;
            if (r103 == null) goto L12;
            LivePlayerContext r106 = r103.getPlayerContext();
            if (r106 == null) goto L12;
            ITTLivePlayer r107 = r106.f154929e;
            if (r107 == null) goto L12;
            ISetSurfaceInterceptor r108 = r107.J0();
        L13:
            if (r108 == null) goto L15;
            LivePlayerClient r109 = this.f156133c.f156118i.get();
            Intrinsics.checkNotNull(r109);
            ISetSurfaceInterceptor.MODE r110 = r108.intercept(r109, null);
        L17:
            if (r110 != ISetSurfaceInterceptor.MODE.ADD) goto L112;
            SurfaceControlRenderManager r111 = this.f156133c;
            if (r111.f156111b == false) goto L47;
            LivePlayerClient r112 = r111.f156118i.get();
            if (r112 == null) goto L47;
            if (r112.isTextureRender() == true) goto L47;
            LivePlayerClient r113 = this.f156133c.f156118i.get();
            if (r113 == null) goto L47;
            if (r113.isVrLive() == true) goto L47;
            LivePlayerClient r114 = this.f156133c.f156118i.get();
            if (r114 == null) goto L47;
            ILivePlayerExtraRenderController r115 = r114.extraRenderController();
            if (r115 == null) goto L47;
            if (r115.isEnable() == true) goto L47;
            LivePlayerClient r116 = this.f156133c.f156118i.get();
            if (r116 == null) goto L47;
            ILivePlayerGameExtraRenderController r117 = r116.gameExtraRenderController();
            if (r117 == null) goto L47;
            if (r117.isEnable() == true) goto L47;
            LivePlayerClient r118 = this.f156133c.f156118i.get();
            if (r118 == null) goto L47;
            ILivePlayerMultiRenderController r119 = r118.multiRenderController();
            if (r119 == null) goto L47;
            if (r119.isEnable() == true) goto L47;
            boolean r120 = true;
        L48:
            if (r120 == true) goto L71;
            if (Intrinsics.areEqual(j(this.f156131a, r101), Boolean.TRUE) == false) goto L58;
            SurfaceControlManager.a r121 = this.f156133c.f156119j;
            SyncSurfaceControlRender r122 = this.f156131a;
            if (r122 == null) goto L54;
            r105 = r122.e();
        L54:
            r121.setSurfaceDisplay(r105);
            SyncSurfaceControlRender r123 = this.f156131a;
            if (r123 == null) goto L57;
            r123.j(r101);
        L57:
            this.f156133c.b("updateRenderView setDisplay 0");
            return;
        L58:
            LivePlayerClient r124 = this.f156133c.f156118i.get();
            if (r124 != null) goto L61;
        L69:
            this.f156133c.f156119j.N(r100, false);
            this.f156133c.b("updateRenderView setDisplay 1");
            return;
        L61:
            if (r124.isTextureRender() == true) goto L69;
            LivePlayerClient r125 = this.f156133c.f156118i.get();
            if (r125 == null) goto L69;
            LivePlayerContext r126 = r125.getPlayerContext();
            if (r126 == null) goto L69;
            ITTLivePlayer r127 = r126.f154929e;
            if (r127 == null) goto L69;
            r127.setSetSurfaceInterceptor(null);
            goto L69
        L71:
            if (this.f156132b != null) goto L132;
            int r128 = SyncSurfaceControlRender.f156136n;
            LivePlayerClient r129 = this.f156133c.f156118i.get();
            if (r129 == null) goto L79;
            Pair<Integer, Integer> r130 = r129.getVideoSize();
            if (r130 == null) goto L79;
            Integer r131 = r130.getFirst();
            if (r131 == null) goto L79;
            int r132 = r131.intValue();
        L80:
            LivePlayerClient r133 = this.f156133c.f156118i.get();
            if (r133 == null) goto L87;
            Pair<Integer, Integer> r134 = r133.getVideoSize();
            if (r134 == null) goto L87;
            Integer r135 = r134.getSecond();
            if (r135 == null) goto L87;
            int r136 = r135.intValue();
        L88:
            SyncSurfaceControlRender r137 = SyncSurfaceControlRender.a.a("live-double-layer", r132, r136);
            if (r137 == null) goto L107;
            r137.f156141e = 2;
            LivePlayerClient r138 = this.f156133c.f156118i.get();
            if (r138 == null) goto L97;
            Pair<Integer, Integer> r139 = r138.getVideoSize();
            if (r139 == null) goto L97;
            Integer r140 = r139.getFirst();
            if (r140 == null) goto L97;
            int r141 = r140.intValue();
        L98:
            LivePlayerClient r142 = this.f156133c.f156118i.get();
            if (r142 == null) goto L105;
            Pair<Integer, Integer> r143 = r142.getVideoSize();
            if (r143 == null) goto L105;
            Integer r144 = r143.getSecond();
            if (r144 == null) goto L105;
            int r145 = r144.intValue();
        L106:
            r137.i(r141, r145);
            r137.j(r101);
            Unit r146 = Unit.INSTANCE;
            r104 = r137;
        L105:
            r145 = 1;
        L97:
            r141 = 1;
        L107:
            this.f156132b = r104;
            this.f156133c.openHardwareBufferOutput();
            LivePlayerClient r147 = this.f156133c.f156118i.get();
            if (r147 == null) goto L110;
            int r148 = is0.b.f495579a;
            r147.registerPlayerFeature(is0.b.a.a("use_hwb_dbr", 1, 1));
        L110:
            this.f156133c.b("updateRenderView doubleRender:");
            return;
        L87:
            r136 = 1;
        L79:
            r132 = 1;
            goto L80
        L132:
            return;
        L47:
            r120 = false;
            goto L48
        L112:
            if (Intrinsics.areEqual(j(this.f156131a, r101), Boolean.TRUE) == false) goto L128;
            SyncSurfaceControlRender r149 = this.f156131a;
            if (r149 == null) goto L116;
            Surface r150 = r149.e();
        L117:
            LivePlayerClient r151 = this.f156133c.f156118i.get();
            if (r151 == null) goto L120;
            Surface r152 = r151.getActualPlayerSurface();
        L122:
            if ((!Intrinsics.areEqual(r152, r150)) == false) goto L124;
            this.f156133c.f156119j.N(null, false);
            this.f156133c.f156119j.setSurfaceDisplay(r150);
        L124:
            SyncSurfaceControlRender r153 = this.f156131a;
            if (r153 == null) goto L127;
            r153.j(r101);
        L127:
            this.f156133c.b("updateRenderView mainShow:");
            return;
        L120:
            r152 = null;
            goto L122
        L116:
            r150 = null;
            goto L117
        L128:
            this.f156133c.f156119j.N(r100, false);
            this.f156133c.b("updateRenderView setDisplay2:");
            return;
        L15:
            r110 = null;
        L12:
            r108 = null;
            goto L13
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.SurfaceControlRenderManager.b
        public final boolean d(HardwareBuffer r100, int[] r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "hardwareBuffer");
            Intrinsics.checkNotNullParameter(r101, "roi");
            if (r101.length < 4) goto L21;
            this.f156133c.b("onHWBDrawFrame: " + r100 + ' ' + r102);
            c r103 = this.f156132b;
            if (r103 == null) goto L7;
            r103.a(r100, r101[2], r101[3], r102);
        L7:
            c r104 = this.f156132b;
            if (r104 == null) goto L21;
            if (r104.b() != 2) goto L21;
            LivePlayerClient r105 = this.f156133c.f156118i.get();
            if (r105 == null) goto L21;
            LivePlayerContext r106 = r105.getPlayerContext();
            if (r106 == null) goto L21;
            IRenderView r107 = r106.b();
            if (r107 == null) goto L21;
            View r108 = r107.getSelfView();
            if (r108 == null) goto L21;
            r108.post(new RunnableC2387a(this));
        L21:
            if (this.f156132b == null) goto L23;
            return true;
        L23:
            return false;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract SurfaceControl a();

        public abstract boolean b();

        public abstract void c();

        public abstract boolean d(HardwareBuffer r100, int[] r101, int r102);

        public abstract void e();

        public abstract void f();

        public abstract boolean g();

        public abstract void h(int r100, int r101);

        public abstract boolean i(SurfaceHolder r100);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        b r100 = this.f156110a;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.f156111b = false;
        this.f156115f = null;
        this.f156116g = null;
        this.f156113d = false;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void openHardwareBufferOutput() {
        if (this.f156112c.getEnableCheckCodecInfo() == true) goto L5;
        this.f156111b = false;
    L5:
        LivePlayerClient r100 = this.f156118i.get();
        if (r100 == null) goto L13;
        LivePlayerContext r101 = r100.getPlayerContext();
        if (r101 == null) goto L14;
        ITTLivePlayer r102 = r101.f154929e;
        if (r102 == null) goto L15;
        r102.O(1);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onFirstFrame() {
        super.onFirstFrame();
        openHardwareBufferOutput();
        if (this.f156112c.getEnableNotSupportReport() == false) goto L12;
        ILivePlayerHostService r100 = LivePlayerService.INSTANCE.hostService();
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isLocalTest() != true) goto L14;
        LivePlayerClient r101 = this.f156118i.get();
        if (r101 == null) goto L15;
        a("onFirstFrame judgeAndReport: " + com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.b(r101, com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.a(r101), ""));
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        StringBuilder r101 = new StringBuilder("SurfaceControlRender:");
        r101.append(r100);
        r101.append(" client_code:");
        LivePlayerClient r102 = this.f156118i.get();
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.hashCode());
    L6:
        r101.append(r103);
        com.bytedance.android.live.player.utils.b.f(r101.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        LivePlayerClient r101 = this.f156118i.get();
        if (r101 == null) goto L5;
        r101.isTextureRender();
    L5:
        LivePlayerClient r102 = this.f156118i.get();
        if (r102 == null) goto L9;
        r102.getIdentifier();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onBindRenderView(IRenderView r100) {
        b r101 = this.f156110a;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStallEvent(int r100) {
        super.onStallEvent(r100);
        if (r100 == 2001) goto L7;
        if (r100 == 2002) goto L7;
    L16:
        if (this.f156112c.getEnableAvoidStall() == true) goto L18;
    L23:
        b("onStallEvent " + r100);
        return;
    L18:
        if (r100 != 1001) goto L21;
        this.f156114e = true;
        goto L23
    L21:
        if (r100 != 1002) goto L23;
        this.f156114e = false;
    L7:
        if (this.f156111b == false) goto L16;
        b r101 = this.f156110a;
        if (r101 == null) goto L13;
        if (r101.b() == true) goto L16;
    L13:
        if (this.f156112c.getEnableCheckCodecInfo() == true) goto L16;
        openHardwareBufferOutput();
        goto L16
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onVideoSizeChange(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        int r101 = r100.getFirst().intValue();
        Pair<Integer, Integer> r102 = this.f156116g;
        if (r102 != null) goto L5;
    L10:
        b r103 = this.f156110a;
        if (r103 == null) goto L13;
        r103.h(r100.getFirst().intValue(), r100.getSecond().intValue());
    L13:
        LivePlayerClient r104 = this.f156118i.get();
        if (r104 == null) goto L20;
        IRoomEventHub r105 = r104.getEventHub();
        if (r105 == null) goto L20;
        MutableLiveData<Boolean> r106 = r105.getFirstFrame();
        if (r106 == null) goto L20;
        Boolean r107 = r106.getValue();
    L22:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L24;
        openHardwareBufferOutput();
    L24:
        this.f156116g = r100;
        return;
    L20:
        r107 = null;
        goto L22
    L5:
        if (r101 != r102.getFirst().intValue()) goto L10;
        int r108 = r100.getSecond().intValue();
        Pair<Integer, Integer> r109 = this.f156116g;
        if (r109 == null) goto L10;
        if (r108 != r109.getSecond().intValue()) goto L10;
    }

    public SurfaceControlRenderManager(WeakReference r100, SurfaceControlManager.c r101) {
        Intrinsics.checkNotNullParameter(r100, "playerClient");
        Intrinsics.checkNotNullParameter(r101, "innerSetSurface");
        this.f156118i = r100;
        this.f156119j = r101;
        SurfaceControlHardwareBufferConfig r102 = (SurfaceControlHardwareBufferConfig) LivePlayerService.INSTANCE.getConfig(SurfaceControlHardwareBufferConfig.class);
        this.f156112c = r102;
        if (r102.getEnable() == false) goto L56;
        LivePlayerClient r103 = (LivePlayerClient) r100.get();
        int r104 = 0;
        b r105 = null;
        if (r103 == null) goto L7;
        ILivePlayerEventController.DefaultImpls.addEventListener$default(r103, this, false, 2, null);
        this.f156113d = r103.getLiveLiteEnterRoomOpt();
    L7:
        LivePlayerClient r106 = (LivePlayerClient) r100.get();
        if (r106 != null) goto L10;
    L12:
        List<String> r107 = r102.getCreateScene();
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L41;
        List<String> r109 = r102.getCreateScene();
        if (r109 == null) goto L34;
        LivePlayerClient r110 = (LivePlayerClient) r100.get();
        if (r110 == null) goto L30;
        LivePlayerClientContext r111 = r110.context();
        if (r111 == null) goto L30;
        ILivePlayerScene r112 = r111.getCreateScene();
        if (r112 == null) goto L30;
        String r113 = r112.getScene();
        if (r113 == null) goto L30;
    L32:
        if (r109.contains(r113) == true) goto L41;
    L30:
        r113 = "undefined";
    L34:
        if (this.f156113d == true) goto L41;
        LivePlayerClient r114 = (LivePlayerClient) r100.get();
        if (r114 == null) goto L43;
        LivePlayerClientContext r115 = r114.context();
        if (r115 == null) goto L43;
        if (r115.isLiveHeadEnterSmooth() == true) goto L41;
    L43:
        if (r104 == 1) goto L50;
        if (r104 == 2) goto L47;
    L53:
        this.f156110a = r105;
        LivePlayerClient r116 = (LivePlayerClient) r100.get();
        if (r116 == null) goto L56;
        int r117 = is0.b.f495579a;
        r116.registerPlayerFeature(is0.b.a.a("enable_hwb_dbr", 1, r104));
        goto L56
    L47:
        if (Build.VERSION.SDK_INT < 33) goto L53;
        b r118 = new NormalSurfaceSmoothSolution(this);
    L52:
        r105 = r118;
        goto L53
    L50:
        if (Build.VERSION.SDK_INT < 33) goto L53;
        r118 = new a(this);
    L41:
        r104 = r102.getSmoothRenderSolution();
        goto L43
    L15:
        if (r107.isEmpty() == true) goto L18;
        r108 = false;
        goto L19
    L10:
        if (r106.isVrLive() != true) goto L12;
    L56:
        this.f156117h = new d(this);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onHWBDrawFrame(HardwareBuffer r100, int[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "hardwareBuffer");
        Intrinsics.checkNotNullParameter(r101, "roi");
        b r103 = this.f156110a;
        boolean r104 = false;
        if (r103 == null) goto L5;
        boolean r105 = r103.d(r100, r101, r102);
    L6:
        if (r105 == true) goto L15;
        LivePlayerClient r106 = this.f156118i.get();
        if (r106 == null) goto L14;
        LivePlayerContext r107 = r106.getPlayerContext();
        if (r107 == null) goto L14;
        ITTLivePlayer r108 = r107.f154929e;
        if (r108 == null) goto L14;
        r108.O(0);
    L14:
        b("onHWBDrawFrame closeHardwareBufferOutput");
    L15:
        boolean r109 = true;
        if (this.f156111b == true) goto L25;
        int r110 = com.bytedance.android.livesdk.player.surfacecontrol.dbr.a.f156154a;
        if (r102 < 65536) goto L25;
        if (this.f156112c.getOnlySupportSDR() != true) goto L25;
        if ((130023424 & r102) != 12582912) goto L24;
        r104 = true;
    L24:
        r109 = r104;
    L25:
        this.f156111b = r109;
        if (r109 == true) goto L28;
        return;
    L28:
        if (this.f156115f == null) goto L30;
        return;
    L30:
        if (this.f156112c.getEnableCheckCodecInfo() == false) goto L35;
        int r111 = com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.f156155a;
        this.f156115f = com.bytedance.android.livesdk.player.surfacecontrol.dbr.b.a(this.f156118i.get());
        return;
    L35:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
