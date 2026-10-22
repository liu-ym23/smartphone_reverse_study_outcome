package com.bytedance.android.livesdk.player.statehandler;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.bytedance.android.livesdk.player.Event;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdk.player.LivePlayerSpmLogger;
import com.bytedance.android.livesdk.player.LivePlayerStateMachine;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.player.i0;
import com.bytedance.android.livesdk.player.utils.g;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.roomplayer.IFrameCallback;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.RenderViewWrapper;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class BindRenderViewStateHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRenderView f156058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f156059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f156060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f156061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f156062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f156063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePlayerContext f156064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePlayerStateMachine f156065h;

    public static final class a implements IFrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BindRenderViewStateHandler f156066a;

        public a(BindRenderViewStateHandler r100) {
            this.f156066a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.IFrameCallback
        public final void onFrame(Surface r100) {
            SurfaceHolder r101 = this.f156066a.f156064g.f154941q;
            if (r101 == null) goto L5;
            Surface r102 = r101.getSurface();
        L7:
            if (Intrinsics.areEqual(r100, r102) == false) goto L13;
            LivePlayerClient r103 = this.f156066a.f156064g.N;
            if (r103 == null) goto L11;
            r103.setFrameCallback(null);
        L11:
            this.f156066a.f156064g.M.f155073r.a(Boolean.TRUE, "BindRenderViewStateHandler surfaceReady first render");
            return;
        L13:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    public static final class b implements IFrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BindRenderViewStateHandler f156067a;

        public b(BindRenderViewStateHandler r100) {
            this.f156067a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.IFrameCallback
        public final void onFrame(Surface r100) {
            if (Intrinsics.areEqual(r100, this.f156067a.f156064g.K) == false) goto L9;
            LivePlayerClient r101 = this.f156067a.f156064g.N;
            if (r101 == null) goto L7;
            r101.setFrameCallback(null);
        L7:
            this.f156067a.f156064g.M.f155073r.a(Boolean.TRUE, "BindRenderViewStateHandler surfaceReady first render");
            return;
        }
    }

    public static final class c implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BindRenderViewStateHandler f156068a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public c(BindRenderViewStateHandler r100) {
            this.f156068a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            boolean r103 = true;
            this.f156068a.f156064g.e("preCreateTextureListener onSurfaceTextureAvailable() " + r100.hashCode() + ' ', true);
            BindRenderViewStateHandler r104 = this.f156068a;
            if (r104.f156064g.b() != null) goto L6;
            r103 = false;
        L6:
            r104.f156060c = r103;
            this.f156068a.b(r100);
        }
    }

    public static final class d implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BindRenderViewStateHandler f156069a;

        public d(BindRenderViewStateHandler r100) {
            this.f156069a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            LivePlayerContext r101 = this.f156069a.f156064g;
            StringBuilder r102 = new StringBuilder("SurfaceView surfaceCreated, surface : ");
            IRenderView r103 = this.f156069a.f156064g.b();
            SurfaceHolder r104 = null;
            if ((r103 instanceof SurfaceRenderView) == true) goto L5;
            r103 = null;
        L5:
            SurfaceRenderView r105 = (SurfaceRenderView) r103;
            if (r105 == null) goto L8;
            r104 = r105.getHolder();
        L8:
            r102.append(r104);
            r102.append(", ");
            r102.append(r100);
            r101.e(r102.toString(), true);
            if ((this.f156069a.f156064g.b() instanceof SurfaceRenderView) == false) goto L17;
            IRenderView r106 = this.f156069a.f156064g.b();
            if (r106 == null) goto L16;
            if (Intrinsics.areEqual(((SurfaceRenderView) r106).getHolder(), r100) == false) goto L18;
            this.f156069a.d();
            this.f156069a.a(r100, false);
            return;
        L18:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            LivePlayerContext r101 = this.f156069a.f156064g;
            StringBuilder r102 = new StringBuilder("surfaceDestroyed , surface : ");
            Surface r103 = r100.getSurface();
            if (r103 == null) goto L5;
            Integer r104 = Integer.valueOf(r103.hashCode());
        L6:
            r102.append(r104);
            r101.e(r102.toString(), true);
            if (Intrinsics.areEqual(this.f156069a.f156064g.f154941q, r100) == true) goto L9;
            return;
        L9:
            if ((this.f156069a.f156064g.b() instanceof SurfaceRenderView) == false) goto L13;
            LivePlayerContext r105 = this.f156069a.f156064g;
            r105.f154941q = null;
            r105.N.setHasFirstFrameCacheForSurfaceView(false);
            return;
        L13:
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            if (((PlayerOptimizeConfig) LivePlayerService.INSTANCE.getConfig(PlayerOptimizeConfig.class)).getSurfaceFixedSize() == false) goto L6;
            r100.setFixedSize(r102, r103);
            return;
        }
    }

    public static final class e implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BindRenderViewStateHandler f156070a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public e(BindRenderViewStateHandler r100) {
            this.f156070a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            this.f156070a.f156064g.e("textureListener onSurfaceTextureDestroyed() surface : " + r100.hashCode() + " shouldDestroySurface : " + this.f156070a.f156064g.f154931g, true);
            this.f156070a.f156064g.N.setSurfaceDisplay(null);
            return this.f156070a.f156064g.f154931g;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            this.f156070a.f156064g.e("textureListener onSurfaceTextureAvailable " + r100.hashCode(), true);
            IRenderView r103 = this.f156070a.f156058a;
            if ((r103 instanceof TextureRenderView) == true) goto L5;
            r103 = null;
        L5:
            TextureRenderView r104 = (TextureRenderView) r103;
            if (r104 == null) goto L8;
            r104.setSurfaceTextureListener(null);
        L8:
            BindRenderViewStateHandler r105 = this.f156070a;
            r105.f156059b = true;
            r105.f156060c = false;
            r105.e();
            this.f156070a.b(r100);
        }
    }

    public final void d() {
        this.f156064g.e("releaseOtherSurfaceTexture", true);
        e();
        Surface r100 = this.f156064g.K;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        SurfaceTexture r101 = this.f156064g.f154924J;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        LivePlayerContext r102 = this.f156064g;
        r102.K = null;
        r102.f154924J = null;
    }

    public final void e() {
        final BindRenderViewStateHandler$releasePreCreatedSurface$1 r100 = new BindRenderViewStateHandler$releasePreCreatedSurface$1(this);
        if (this.f156059b == false) goto L5;
        g.e(0, true, true, new BindRenderViewStateHandler$releasePreCreatedSurface$2(r100), 1);
        return;
    L5:
        r100.invoke2();
    }

    public final void b(SurfaceTexture r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = Intrinsics.areEqual(r100, this.f156064g.f154924J);
        State r102 = this.f156065h.d();
        Integer r103 = null;
        if ((r102 instanceof State.Preparing) == true) goto L7;
        r102 = null;
    L7:
        State.Preparing r104 = (State.Preparing) r102;
        if (r104 == null) goto L12;
        if (r104.getSurfaceReady() != true) goto L12;
    L13:
        boolean r105 = true;
    L15:
        LivePlayerService r106 = LivePlayerService.INSTANCE;
        if (((PlayerModularizationConfig) r106.getConfig(PlayerModularizationConfig.class)).getEnableV2() == false) goto L20;
        if (r101 == false) goto L20;
        return;
    L20:
        if (((PlayerModularizationConfig) r106.getConfig(PlayerModularizationConfig.class)).getEnableV2() == true) goto L24;
        if (r101 == false) goto L24;
        if (r105 == false) goto L24;
        return;
    L24:
        LivePlayerClient r107 = this.f156064g.N;
        if (r107 == null) goto L27;
        r107.setFrameCallback(new b(this));
    L27:
        Surface r108 = this.f156064g.K;
        if (r108 == null) goto L30;
        r108.release();
    L30:
        this.f156064g.f154924J = r100;
        Surface r109 = new Surface(r100);
        LivePlayerContext r110 = this.f156064g;
        r110.K = r109;
        r110.N.getEventController().onSurfaceReady();
        this.f156064g.N.setSurfaceDisplay(r109);
        LivePlayerContext r111 = this.f156064g;
        StringBuilder r112 = new StringBuilder("player use texture view surface : ");
        Surface r113 = this.f156064g.K;
        if (r113 == null) goto L33;
        Integer r114 = Integer.valueOf(r113.hashCode());
    L34:
        r112.append(r114);
        r112.append(",  surfaceTexture : ");
        SurfaceTexture r115 = this.f156064g.f154924J;
        if (r115 == null) goto L37;
        r103 = Integer.valueOf(r115.hashCode());
    L37:
        r112.append(r103);
        r111.e(r112.toString(), true);
        this.f156065h.e(Event.Prepare.SurfaceReady.INSTANCE);
        this.f156064g.M.Q.setValue(Boolean.TRUE);
        return;
    L33:
        r114 = null;
    L12:
        if ((this.f156065h.d() instanceof State.Playing) == true) goto L13;
        r105 = false;
        goto L15
    }

    public final void c(i0 r110) {
        Intrinsics.checkNotNullParameter(r110, "effect");
        LivePlayerSpmLogger.Companion.getClass();
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == true) goto L5;
    L15:
        boolean r100 = false;
    L16:
        LivePlayerContext r101 = this.f156064g;
        StringBuilder r102 = new StringBuilder("BindRenderViewStateHandler handle, cur render view : ");
        LivePlayerClient r103 = this.f156064g.N;
        IRenderView r104 = null;
        if (r103 == null) goto L21;
        IRenderView r105 = r103.getRenderView();
        if (r105 == null) goto L21;
        Integer r106 = Integer.valueOf(r105.hashCode());
    L22:
        r102.append(r106);
        r101.e(r102.toString(), r100);
        this.f156064g.N.getEventController().onBindRenderView(this.f156064g.N.getRenderView());
        final BindRenderViewStateHandler$tryUsePreCreatedSurface$1 r107 = new BindRenderViewStateHandler$tryUsePreCreatedSurface$1(this);
        if (this.f156060c == false) goto L25;
        g.e(0, true, true, new BindRenderViewStateHandler$tryUsePreCreatedSurface$2(r107), 1);
    L26:
        IRenderView r108 = this.f156064g.b();
        if (r108 == null) goto L29;
        SurfaceTexture r109 = r108.getSurfaceTexture();
    L30:
        b(r109);
        if (((PlayerConfig) LivePlayerService.INSTANCE.getConfig(PlayerConfig.class)).getFixSurfaceCallbackIsNullForReuseAfterRelease() == false) goto L33;
        this.f156064g.f154928d = this.f156063f;
    L33:
        IRenderView r111 = this.f156064g.b();
        if ((r111 instanceof TextureRenderView) == true) goto L36;
        r111 = null;
    L36:
        TextureRenderView r112 = (TextureRenderView) r111;
        if (r112 == null) goto L39;
        r112.setSurfaceTextureListener(this.f156061d);
    L39:
        IRenderView r113 = this.f156064g.b();
        if ((r113 instanceof RenderViewWrapper) == true) goto L42;
        r113 = null;
    L42:
        RenderViewWrapper r114 = (RenderViewWrapper) r113;
        if (r114 == null) goto L45;
        r114.setSurfaceTextureListener(this.f156061d);
    L45:
        IRenderView r115 = this.f156064g.b();
        if ((r115 instanceof SurfaceRenderView) == false) goto L49;
        r104 = r115;
    L49:
        SurfaceRenderView r116 = (SurfaceRenderView) r104;
        if (r116 == null) goto L59;
        SurfaceHolder r117 = r116.getHolder();
        if (r117 == null) goto L60;
        r117.removeCallback(this.f156063f);
        r117.addCallback(this.f156063f);
        this.f156064g.e("set surfaceholder listener " + this.f156063f.hashCode(), true);
        if (r117.getSurface() != null) goto L56;
        return;
    L56:
        if (r117.getSurface().isValid() == false) goto L62;
        d();
        a(r117, r110 instanceof i0.b);
        return;
    L62:
        return;
    L60:
        return;
    L59:
        return;
    L29:
        r109 = null;
        goto L30
    L25:
        r107.invoke2();
    L21:
        r106 = null;
        goto L22
    L5:
        if ((r110 instanceof i0.e) == false) goto L15;
        i0.e r118 = (i0.e) r110;
        if (r118.f155408e == false) goto L9;
    L14:
        r100 = true;
        goto L16
    L9:
        if (r118.f155407d == true) goto L14;
        if (r118.f155409f == true) goto L14;
        if (r118.f155406c == false) goto L15;
        goto L14
    }

    public BindRenderViewStateHandler(LivePlayerContext r100, LivePlayerStateMachine r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "stateMachine");
        this.f156064g = r100;
        this.f156065h = r101;
        this.f156061d = new e(this);
        this.f156062e = new c(this);
        d r102 = new d(this);
        this.f156063f = r102;
        r100.f154928d = r102;
    }

    public final void a(SurfaceHolder r100, boolean r101) {
        if (Intrinsics.areEqual(r100, this.f156064g.f154941q) == false) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        LivePlayerContext r102 = this.f156064g;
        r102.f154941q = r100;
        LivePlayerClient r103 = r102.N;
        if (r103 == null) goto L9;
        r103.setFrameCallback(new a(this));
    L9:
        this.f156064g.N.getEventController().onSurfaceReady();
        this.f156064g.N.setDisplay(r100);
        LivePlayerContext r104 = this.f156064g;
        StringBuilder r105 = new StringBuilder("player use surface view surface : ");
        Integer r106 = null;
        if (r100 == null) goto L14;
        Surface r107 = r100.getSurface();
        if (r107 == null) goto L14;
        Integer r108 = Integer.valueOf(r107.hashCode());
    L15:
        r105.append(r108);
        r105.append(",  surfaceHolder : ");
        SurfaceHolder r109 = this.f156064g.f154941q;
        if (r109 == null) goto L18;
        r106 = Integer.valueOf(r109.hashCode());
    L18:
        r105.append(r106);
        r104.e(r105.toString(), true);
        this.f156065h.e(Event.Prepare.SurfaceReady.INSTANCE);
        this.f156064g.M.Q.setValue(Boolean.TRUE);
        return;
    L14:
        r108 = null;
        goto L15
    }
}
