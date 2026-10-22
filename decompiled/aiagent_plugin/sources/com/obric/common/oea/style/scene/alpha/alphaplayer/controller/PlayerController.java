package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.VideoRenderer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.k;
import java.io.File;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PlayerController.kt */
/* JADX INFO: loaded from: classes4.dex */
public class PlayerController implements Handler.Callback, o, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b {
    public static final a Companion = null;
    public static final int DESTROY = 7;
    public static final int INIT_MEDIA_PLAYER = 1;
    public static final int PAUSE = 4;
    public static final int RESET = 9;
    public static final int RESUME = 5;
    public static final int SET_DATA_SOURCE = 2;
    public static final int START = 3;
    public static final int STOP = 6;
    public static final int SURFACE_PREPARED = 8;
    public static final String TAG = "PlayerController";
    private com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a alphaVideoView;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a.a alphaVideoViewType;
    private Context context;
    private boolean isPlaying;
    private final e mErrorListener;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a mMonitor;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.b mPlayerAction;
    private final f mPreparedListener;
    private final Handler mainHandler;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.player.c mediaPlayer;
    private p owner;
    private HandlerThread playThread;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.player.d playerState;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a.c suspendDataSource;
    private Handler workHandler;

    /* JADX INFO: compiled from: PlayerController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32501a;

        b(PlayerController r1) {
            this.f32501a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f32501a);
            if (r0 == null) goto L6;
            r0.b();
            return;
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    public static final class c implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0890c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32502a;

        c(PlayerController r1) {
            this.f32502a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0890c
        public void a() {
            PlayerController.access$getAlphaVideoView$p(this.f32502a).onFirstFrame();
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    public static final class d implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32503a;

        d(PlayerController r1) {
            this.f32503a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a
        public void a() {
            PlayerController.access$getAlphaVideoView$p(this.f32503a).onCompletion();
            PlayerController.access$setPlayerState$p(this.f32503a, com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32524d);
            PlayerController.monitor$default(this.f32503a, true, 0, 0, "", 6, null);
            PlayerController.access$emitEndSignal(this.f32503a);
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    public static final class e implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32504a;

        e(PlayerController r1) {
            this.f32504a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b
        public void a(int r4, int r5, String r6) {
            d.h.b.o.e(r6, "desc");
            PlayerController.access$monitor(this.f32504a, false, r4, r5, "mediaPlayer error, info: " + r6);
            PlayerController.access$emitEndSignal(this.f32504a);
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    public static final class f implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32505a;

        f(PlayerController r1) {
            this.f32505a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d
        public void a() {
            PlayerController r2 = this.f32505a;
            PlayerController.access$sendMessage(r2, PlayerController.access$getMessage(r2, 3, null));
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.a.e f32507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.a.d f32508c;

        g(PlayerController r1, com.obric.common.oea.style.scene.alpha.alphaplayer.a.e r2, com.obric.common.oea.style.scene.alpha.alphaplayer.a.d r3) {
            this.f32506a = r1;
            this.f32507b = r2;
            this.f32508c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f32506a);
            if (r0 == null) goto L6;
            r0.a(this.f32507b.a() / 2, this.f32507b.b(), this.f32508c);
            return;
        }
    }

    /* JADX INFO: compiled from: PlayerController.kt */
    static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f32509a;

        h(PlayerController r1) {
            this.f32509a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f32509a);
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static final /* synthetic */ void access$emitEndSignal(PlayerController r0) {
        r0.emitEndSignal();
    }

    public static final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a access$getAlphaVideoView$p(PlayerController r1) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = r1.alphaVideoView;
        if (r2 != null) goto L5;
        d.h.b.o.c("alphaVideoView");
    L5:
        return r2;
    }

    public static final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.b access$getMPlayerAction$p(PlayerController r0) {
        return r0.mPlayerAction;
    }

    public static final /* synthetic */ Message access$getMessage(PlayerController r0, int r1, Object r2) {
        return r0.getMessage(r1, r2);
    }

    public static final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.player.d access$getPlayerState$p(PlayerController r0) {
        return r0.playerState;
    }

    public static final /* synthetic */ void access$monitor(PlayerController r0, boolean r1, int r2, int r3, String r4) {
        r0.monitor(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$sendMessage(PlayerController r0, Message r1) {
        r0.sendMessage(r1);
    }

    public static final /* synthetic */ void access$setAlphaVideoView$p(PlayerController r2, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r3) {
        r2.alphaVideoView = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setMPlayerAction$p(PlayerController r2, com.obric.common.oea.style.scene.alpha.alphaplayer.b r3) {
        r2.mPlayerAction = (com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setPlayerState$p(PlayerController r0, com.obric.common.oea.style.scene.alpha.alphaplayer.player.d r1) {
        r0.playerState = r1;
    }

    public /* synthetic */ PlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.a.b r2, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r3, int r4, d.h.b.h r5) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
    L5:
        this(r2, r6);
    }

    public PlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.a.b r4, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r5) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "configuration");
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32521a;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new f(this);
        this.mErrorListener = new e(this);
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.owner = r4.b();
        this.alphaVideoViewType = r4.a();
        if (r6 != null) goto L6;
        r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.style.scene.alpha.alphaplayer.player.b(), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
    L6:
        this.mediaPlayer = r6;
        init();
    }

    public PlayerController(Context r4, p r5, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r6, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r10 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        d.h.b.o.e(r9, "owner");
        d.h.b.o.e(r6, "alphaVideoViewType");
        d.h.b.o.e(r10, "mediaPlayer");
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32521a;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new f(this);
        this.mErrorListener = new e(this);
        this.context = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.owner = r9;
        this.alphaVideoViewType = r6;
        this.mediaPlayer = r10;
        init();
    }

    private final void init() {
        init(this.owner);
        initAlphaView();
        initMediaPlayer();
    }

    private final void init(p r4) {
        ((p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin")).getLifecycle().a((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        HandlerThread r5 = new HandlerThread("alpha-play-thread", 10);
        this.playThread = r5;
        d.h.b.o.a(r5);
        r5.start();
        HandlerThread r0 = this.playThread;
        d.h.b.o.a(r0);
        this.workHandler = new Handler(r0.getLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.aiagent.plugin"));
    }

    private final void initAlphaView() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r0 = this.alphaVideoViewType;
        int r1 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f32510a[r0.ordinal()];
        if (r1 != 1) goto L5;
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.preCheckCast(new AlphaVideoGLSurfaceView(this.context, null), com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.aiagent.plugin");
    L10:
        this.alphaVideoView = r2;
        if (r2 != null) goto L13;
        d.h.b.o.c("alphaVideoView");
    L13:
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.setPlayerController((com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.preCheckCast(this, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.aiagent.plugin"));
        r2.setVideoRenderer((IRender) ZeusTransformUtils.preCheckCast(new VideoRenderer(r2), IRender.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.preCheckCast(new AlphaVideoGLTextureView(this.context, null), com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.aiagent.plugin");
        goto L10
    L8:
        throw new k();
    }

    private final void initMediaPlayer() {
        sendMessage(getMessage(1, null));
    }

    public void setPlayerAction(com.obric.common.oea.style.scene.alpha.alphaplayer.b r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.b r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "playerAction");
        this.mPlayerAction = r4;
    }

    public void setMonitor(com.obric.common.oea.style.scene.alpha.alphaplayer.a r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "monitor");
        this.mMonitor = r4;
    }

    public void setVisibility(int r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r0 = this.alphaVideoView;
        if (r0 != null) goto L5;
        d.h.b.o.c("alphaVideoView");
    L5:
        r0.setVisibility(r3);
        if (r3 != 0) goto L12;
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = this.alphaVideoView;
        if (r2 != null) goto L10;
        d.h.b.o.c("alphaVideoView");
    L10:
        r2.bringToFront();
        return;
    }

    public void attachAlphaView(ViewGroup r2) {
        d.h.b.o.e(r2, "parentView");
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        d.h.b.o.c("alphaVideoView");
    L5:
        r1.addParentView(r2);
    }

    public void detachAlphaView(ViewGroup r2) {
        d.h.b.o.e(r2, "parentView");
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        d.h.b.o.c("alphaVideoView");
    L5:
        r1.removeParentView(r2);
    }

    @x(a = i.a.ON_PAUSE)
    public final void onPause() {
        pause();
    }

    @x(a = i.a.ON_RESUME)
    public final void onResume() {
        resume();
    }

    @x(a = i.a.ON_STOP)
    public final void onStop() {
        stop();
    }

    @x(a = i.a.ON_DESTROY)
    public final void onDestroy() {
        release();
    }

    private final void sendMessage(Message r5) {
        HandlerThread r0 = this.playThread;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAlive() == true) goto L7;
        return;
    L7:
        if (r0.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.workHandler != null) goto L11;
        this.workHandler = new Handler(r0.getLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.aiagent.plugin"));
    L11:
        Handler r4 = this.workHandler;
        d.h.b.o.a(r4);
        r4.sendMessageDelayed(r5, 0);
    }

    private final Message getMessage(int r1, Object r2) {
        Message r0 = Message.obtain();
        r0.what = r1;
        r0.obj = r2;
        d.h.b.o.c(r0, "message");
        return r0;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b
    public void surfacePrepared(Surface r2) {
        d.h.b.o.e(r2, "surface");
        sendMessage(getMessage(8, r2));
    }

    public void start(com.obric.common.oea.style.scene.alpha.alphaplayer.a.c r8) {
        d.h.b.o.e(r8, "dataSource");
        if (r8.b() == false) goto L5;
        setVisibility(0);
        sendMessage(getMessage(2, r8));
        return;
    L5:
        emitEndSignal();
        monitor$default(this, false, 0, 0, "dataSource is invalid!", 6, null);
    }

    public void pause() {
        sendMessage(getMessage(4, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.a
    public void resume() {
        sendMessage(getMessage(5, null));
    }

    public void stop() {
        sendMessage(getMessage(6, null));
    }

    public void reset() {
        sendMessage(getMessage(9, null));
    }

    public void release() {
        sendMessage(getMessage(7, null));
    }

    public View getView() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L6;
        d.h.b.o.c("alphaVideoView");
    L6:
        return r1.getView();
    }

    public String getPlayerType() {
        return this.mediaPlayer.m();
    }

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.player.d getStatus() {
        return this.playerState;
    }

    private final void initPlayer() {
        this.mediaPlayer.e();     // Catch: Exception -> L5
    L7:
        this.mediaPlayer.b(true);
        this.mediaPlayer.a(false);
        this.mediaPlayer.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0890c) ZeusTransformUtils.preCheckCast(new c(this), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0890c.class, "com.obric.aiagent.plugin"));
        this.mediaPlayer.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a) ZeusTransformUtils.preCheckCast(new d(this), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        e = move-exception;
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r2 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.style.scene.alpha.alphaplayer.player.b(), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.aiagent.plugin");
        this.mediaPlayer = r2;
        r2.e();
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_controller_PlayerController_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "initPlayer failed " + e.getMessage());
        goto L7
    }

    private final void setDataSource(com.obric.common.oea.style.scene.alpha.alphaplayer.a.c r8) {
        setVideoFromFile(r8);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "alphaVideoView set dataSource failure: " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 6, null);
        emitEndSignal();
    }

    private final void setVideoFromFile(com.obric.common.oea.style.scene.alpha.alphaplayer.a.c r9) {
        this.mediaPlayer.j();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32521a;
        Resources r0 = ZeusTransformUtils.getResources(this.context, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "context.resources");
        int r1 = r0.getConfiguration().orientation;
        String r2 = r9.a(r1);
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.d r3 = r9.b(r1);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L21:
        monitor$default(this, false, 0, 0, "dataPath is empty or File is not exists. path = " + r2, 6, null);
        emitEndSignal();
        return;
    L5:
        if (new File(r2).exists() == false) goto L21;
        if (r3 == null) goto L13;
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r4 = this.alphaVideoView;
        if (r4 != null) goto L12;
        d.h.b.o.c("alphaVideoView");
    L12:
        r4.setScaleType(r3);
    L13:
        this.mediaPlayer.a(r9.a());
        this.mediaPlayer.a(r2);
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r5 = this.alphaVideoView;
        if (r5 != null) goto L17;
        d.h.b.o.c("alphaVideoView");
    L17:
        if (r5.isSurfaceCreated() == false) goto L19;
        prepareAsync();
        return;
    L19:
        this.suspendDataSource = r9;
    }

    private final void handleSuspendedEvent() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.c r0 = this.suspendDataSource;
        if (r0 == null) goto L5;
        setVideoFromFile(r0);
    L5:
        this.suspendDataSource = (com.obric.common.oea.style.scene.alpha.alphaplayer.a.c) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.style.scene.alpha.alphaplayer.a.c.class, "com.obric.aiagent.plugin");
    }

    private final void prepareAsync() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r0 = this.mediaPlayer;
        if (this.playerState != com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32521a) goto L5;
    L6:
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d) ZeusTransformUtils.preCheckCast(this.mPreparedListener, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d.class, "com.obric.aiagent.plugin"));
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b) ZeusTransformUtils.preCheckCast(this.mErrorListener, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b.class, "com.obric.aiagent.plugin"));
        r0.f();
        return;
    L5:
        if (this.playerState == com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32525e) goto L6;
    }

    private final void startPlay() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.d r0 = this.playerState;
        int r1 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f32511b[r0.ordinal()];
        if (r1 != 1) goto L5;
        this.mediaPlayer.g();
        this.isPlaying = true;
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32523c;
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new h(this), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r1 != 2) goto L7;
        this.mediaPlayer.g();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32523c;
        return;
    L7:
        if (r1 != 3) goto L9;
    L18:
        prepareAsync();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "prepare and start MediaPlayer failure!", 6, null);
        emitEndSignal();
        return;
    L9:
        if (r1 == 4) goto L18;
    }

    private final void parseVideoSize() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.e r0 = this.mediaPlayer.l();
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        d.h.b.o.c("alphaVideoView");
    L5:
        r1.measureInternal(r0.a() / 2, r0.b());
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = this.alphaVideoView;
        if (r2 != null) goto L8;
        d.h.b.o.c("alphaVideoView");
    L8:
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new g(this, r0, r2.getScaleType()), Runnable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r11) {
        d.h.b.o.e(r11, "msg");
        switch(r11.what) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L42;
            case 4: goto L32;
            case 5: goto L29;
            case 6: goto L22;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L41;
        };
    L5:
        this.mediaPlayer.j();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32521a;
        this.isPlaying = false;
        goto L41
    L6:
        Object r12 = r11.obj;
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.Surface");
        this.mediaPlayer.a((Surface) ZeusTransformUtils.preCheckCast(r12, Surface.class, "com.obric.aiagent.plugin"));
        handleSuspendedEvent();
        goto L41
    L7:
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r13 = this.alphaVideoView;
        if (r13 != null) goto L10;
        d.h.b.o.c("alphaVideoView");
    L10:
        r13.onPause();
        if (this.playerState != com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32523c) goto L14;
        this.mediaPlayer.h();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32524d;
    L14:
        if (this.playerState != com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32524d) goto L16;
        this.mediaPlayer.i();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32525e;
    L16:
        this.mediaPlayer.k();
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r14 = this.alphaVideoView;
        if (r14 != null) goto L19;
        d.h.b.o.c("alphaVideoView");
    L19:
        r14.release();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f;
        HandlerThread r10 = this.playThread;
        if (r10 == null) goto L41;
        r10.quit();
        r10.interrupt();
        goto L41
    L22:
        int r15 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f32513d[this.playerState.ordinal()];
        if (r15 != 1) goto L25;
    L27:
        this.mediaPlayer.h();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32524d;
        goto L41
    L25:
        if (r15 == 2) goto L27;
    L39:
        Object r16 = r11.obj;
        Objects.requireNonNull(r16, "null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
        setDataSource((com.obric.common.oea.style.scene.alpha.alphaplayer.a.c) ZeusTransformUtils.preCheckCast(r16, com.obric.common.oea.style.scene.alpha.alphaplayer.a.c.class, "com.obric.aiagent.plugin"));
        goto L41
    L40:
        initPlayer();
    L41:
        return true;
    L42:
        parseVideoSize();     // Catch: Exception -> L37
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32522b;     // Catch: Exception -> L37
        startPlay();     // Catch: Exception -> L37
        d.x r17 = d.x.f38692a;     // Catch: Exception -> L37
    L37:
        e = move-exception;
        monitor$default(this, false, 0, 0, "start video failure: " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 6, null);
        emitEndSignal();
        d.x r18 = d.x.f38692a;
        goto L41
    L29:
        if (this.isPlaying == false) goto L41;
        startPlay();
        goto L41
    L32:
        if (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f32512c[this.playerState.ordinal()] != 1) goto L41;
        this.mediaPlayer.h();
        this.playerState = com.obric.common.oea.style.scene.alpha.alphaplayer.player.d.f32524d;
        goto L41
    }

    private final void emitEndSignal() {
        this.isPlaying = false;
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new b(this), Runnable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void monitor$default(PlayerController r1, boolean r2, int r3, int r4, String r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.monitor(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    private final void monitor(boolean r7, int r8, int r9, String r10) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a r0 = this.mMonitor;
        if (r0 == null) goto L6;
        r0.a(r7, getPlayerType(), r8, r9, r10);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_controller_PlayerController_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
