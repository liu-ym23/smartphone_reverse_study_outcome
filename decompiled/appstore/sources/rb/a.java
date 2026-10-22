package rb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.p;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public class a implements IPlayerControllerExt, LifecycleObserver, Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0351a f23822o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifecycleOwner f23824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlphaVideoViewType f23825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMediaPlayer f23826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IAlphaVideoView f23827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayerState f23829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IMonitor f23830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IPlayerAction f23831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f23832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f23833k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HandlerThread f23834l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final rb.d f23835m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final rb.c f23836n;

    /* JADX INFO: renamed from: rb.a$a, reason: collision with other inner class name */
    public static final class C0351a {
        public C0351a() {
        }

        public /* synthetic */ C0351a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23837a;

        public b(a r10) {
            this.f23837a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPlayerAction r10 = a.c(this.f23837a);
            if (r10 == null) goto L6;
            r10.endAction();
            return;
        }
    }

    public static final class c implements IMediaPlayer.OnFirstFrameListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23838a;

        public c(a r10) {
            this.f23838a = r10;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer.OnFirstFrameListener
        public void onFirstFrame() {
            a.b(this.f23838a).onFirstFrame();
        }
    }

    public static final class d implements IMediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23839a;

        public d(a r10) {
            this.f23839a = r10;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer.OnCompletionListener
        public void onCompletion() {
            a.b(this.f23839a).onCompletion();
            a.g(this.f23839a, PlayerState.PAUSED);
            a.r(this.f23839a, true, 0, 0, "", 6, null);
            a.a(this.f23839a);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sb.c f23841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScaleType f23842c;

        public e(a r10, sb.c r11, ScaleType r12) {
            this.f23840a = r10;
            this.f23841b = r11;
            this.f23842c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPlayerAction r10 = a.c(this.f23840a);
            if (r10 == null) goto L6;
            r10.onVideoSizeChanged(this.f23841b.b() / 2, this.f23841b.a(), this.f23842c);
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f23843a;

        public f(a r10) {
            this.f23843a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPlayerAction r10 = a.c(this.f23843a);
            if (r10 == null) goto L6;
            r10.startAction();
            return;
        }
    }

    static {
        f23822o = new C0351a(null);
    }

    public /* synthetic */ a(sb.a r10, IMediaPlayer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ void a(a r10) {
        r10.h();
    }

    public static final /* synthetic */ IAlphaVideoView b(a r10) {
        IAlphaVideoView r11 = r10.f23827e;
        if (r11 != null) goto L5;
        q.y("alphaVideoView");
    L5:
        return r11;
    }

    public static final /* synthetic */ IPlayerAction c(a r10) {
        return r10.f23831i;
    }

    public static final /* synthetic */ Message d(a r10, int r11, Object r12) {
        return r10.i(r11, r12);
    }

    public static final /* synthetic */ void e(a r10, boolean r11, int r12, int r13, String r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void f(a r10, Message r11) {
        r10.u(r11);
    }

    public static final /* synthetic */ void g(a r10, PlayerState r11) {
        r10.f23829g = r11;
    }

    private final void l() {
        m(this.f23824b);
        n();
        o();
    }

    public static /* synthetic */ void r(a r10, boolean r11, int r12, int r13, String r14, int r15, Object r16) {
        if (r16 != null) goto L12;
        if ((r15 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        r10.q(r11, r12, r13, r14);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    private final void x() {
        PlayerState r10 = this.f23829g;
        int r11 = rb.b.f23845b[r10.ordinal()];
        if (r11 != 1) goto L5;
        this.f23826d.start();
        this.f23828f = true;
        this.f23829g = PlayerState.STARTED;
        this.f23833k.post(new f(this));
        return;
    L5:
        if (r11 != 2) goto L7;
        this.f23826d.start();
        this.f23829g = PlayerState.STARTED;
        return;
    L7:
        if (r11 != 3) goto L9;
    L18:
        t();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        r(this, false, 0, 0, "prepare and start MediaPlayer failure!", 6, null);
        h();
        return;
    L9:
        if (r11 == 4) goto L18;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void attachAlphaView(ViewGroup r10) {
        q.g(r10, "parentView");
        IAlphaVideoView r11 = this.f23827e;
        if (r11 != null) goto L5;
        q.y("alphaVideoView");
    L5:
        r11.addParentView(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void detachAlphaView(ViewGroup r10) {
        q.g(r10, "parentView");
        IAlphaVideoView r11 = this.f23827e;
        if (r11 != null) goto L5;
        q.y("alphaVideoView");
    L5:
        r11.removeParentView(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public String getPlayerType() {
        return this.f23826d.getPlayerType();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public View getView() {
        IAlphaVideoView r10 = this.f23827e;
        if (r10 != null) goto L6;
        q.y("alphaVideoView");
    L6:
        return r10.getView();
    }

    public final void h() {
        this.f23828f = false;
        this.f23833k.post(new b(this));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        q.g(r10, "msg");
        switch(r10.what) {
            case 1: goto L48;
            case 2: goto L43;
            case 3: goto L50;
            case 4: goto L36;
            case 5: goto L33;
            case 6: goto L26;
            case 7: goto L11;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L49;
        };
    L5:
        this.f23826d.reset();
        this.f23829g = PlayerState.NOT_PREPARED;
        this.f23828f = false;
        goto L49
    L6:
        Object r11 = r10.obj;
        if (r11 == null) goto L10;
        this.f23826d.setSurface((Surface) r11);
        k();
        goto L49
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
    L11:
        IAlphaVideoView r12 = this.f23827e;
        if (r12 != null) goto L14;
        q.y("alphaVideoView");
    L14:
        r12.onPause();
        if (this.f23829g != PlayerState.STARTED) goto L18;
        this.f23826d.pause();
        this.f23829g = PlayerState.PAUSED;
    L18:
        if (this.f23829g != PlayerState.PAUSED) goto L20;
        this.f23826d.stop();
        this.f23829g = PlayerState.STOPPED;
    L20:
        this.f23826d.release();
        IAlphaVideoView r13 = this.f23827e;
        if (r13 != null) goto L23;
        q.y("alphaVideoView");
    L23:
        r13.release();
        this.f23829g = PlayerState.RELEASE;
        HandlerThread r14 = this.f23834l;
        if (r14 == null) goto L49;
        r14.quit();
        r14.interrupt();
        goto L49
    L26:
        int r15 = rb.b.f23847d[this.f23829g.ordinal()];
        if (r15 != 1) goto L29;
    L31:
        this.f23826d.pause();
        this.f23829g = PlayerState.PAUSED;
        goto L49
    L29:
        if (r15 == 2) goto L31;
    L43:
        Object r16 = r10.obj;
        if (r16 == null) goto L47;
        p.a(r16);
        v(null);
        goto L49
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
    L48:
        p();
    L49:
        return true;
    L50:
        s();     // Catch: Exception -> L41
        this.f23829g = PlayerState.PREPARED;     // Catch: Exception -> L41
        x();     // Catch: Exception -> L41
        Unit r17 = Unit.f21064a;     // Catch: Exception -> L41
    L41:
        e = move-exception;
        r(this, false, 0, 0, "start video failure: " + Log.getStackTraceString(e), 6, null);
        h();
        Unit r18 = Unit.f21064a;
        goto L49
    L33:
        if (this.f23828f == false) goto L49;
        x();
        goto L49
    L36:
        if (rb.b.f23846c[this.f23829g.ordinal()] != 1) goto L49;
        this.f23826d.pause();
        this.f23829g = PlayerState.PAUSED;
        goto L49
    }

    public final Message i(int r10, Object r11) {
        Message r12 = Message.obtain();
        r12.what = r10;
        r12.obj = r11;
        q.f(r12, "message");
        return r12;
    }

    public final PlayerState j() {
        return this.f23829g;
    }

    public final void k() {
    }

    public final void m(LifecycleOwner r10) {
        r10.getLifecycle().a(this);
        HandlerThread r11 = new HandlerThread("alpha-play-thread", 10);
        this.f23834l = r11;
        q.d(r11);
        r11.start();
        HandlerThread r12 = this.f23834l;
        q.d(r12);
        this.f23832j = new Handler(r12.getLooper(), this);
    }

    public final void n() {
        AlphaVideoViewType r10 = this.f23825c;
        int r11 = rb.b.f23844a[r10.ordinal()];
        if (r11 != 1) goto L5;
        IAlphaVideoView r12 = new AlphaVideoGLSurfaceView(this.f23823a, null);
    L10:
        this.f23827e = r12;
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r12.setPlayerController(this);
        r12.setVideoRenderer(new ub.a(r12));
        return;
    L5:
        if (r11 != 2) goto L8;
        r12 = new AlphaVideoGLTextureView(this.f23823a, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void o() {
        u(i(1, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        stop();
    }

    public final void p() {
        this.f23826d.initMediaPlayer();     // Catch: Exception -> L4
    L6:
        this.f23826d.setScreenOnWhilePlaying(true);
        this.f23826d.setLooping(false);
        this.f23826d.setOnFirstFrameListener(new c(this));
        this.f23826d.setOnCompletionListener(new d(this));
        return;
    L4:
        e = move-exception;
        tb.b r10 = new tb.b();
        this.f23826d = r10;
        r10.initMediaPlayer();
        Log.e("PlayerController", "initPlayer failed " + e.getMessage());
        goto L6
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void pause() {
        u(i(4, null));
    }

    public final void q(boolean r10, int r11, int r12, String r13) {
        IMonitor r14 = this.f23830h;
        if (r14 == null) goto L6;
        r14.monitor(r10, getPlayerType(), r11, r12, r13);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void release() {
        u(i(7, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void reset() {
        u(i(9, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void resume() {
        u(i(5, null));
    }

    public final void s() {
        sb.c r10 = this.f23826d.getVideoInfo();
        IAlphaVideoView r11 = this.f23827e;
        if (r11 != null) goto L5;
        q.y("alphaVideoView");
    L5:
        r11.measureInternal(r10.b() / 2, r10.a());
        IAlphaVideoView r12 = this.f23827e;
        if (r12 != null) goto L8;
        q.y("alphaVideoView");
    L8:
        this.f23833k.post(new e(this, r10, r12.getScaleType()));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setMonitor(IMonitor r10) {
        q.g(r10, "monitor");
        this.f23830h = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setPlayerAction(IPlayerAction r10) {
        q.g(r10, "playerAction");
        this.f23831i = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setVisibility(int r10) {
        IAlphaVideoView r11 = this.f23827e;
        if (r11 != null) goto L5;
        q.y("alphaVideoView");
    L5:
        r11.setVisibility(r10);
        if (r10 != 0) goto L12;
        IAlphaVideoView r12 = this.f23827e;
        if (r12 != null) goto L10;
        q.y("alphaVideoView");
    L10:
        r12.bringToFront();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void start(sb.b r10) {
        q.g(r10, "dataSource");
        throw null;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void stop() {
        u(i(6, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt
    public void surfacePrepared(Surface r10) {
        q.g(r10, "surface");
        u(i(8, r10));
    }

    public final void t() {
        IMediaPlayer r10 = this.f23826d;
        PlayerState r11 = this.f23829g;
        if (r11 != PlayerState.NOT_PREPARED) goto L5;
    L6:
        r10.setOnPreparedListener(this.f23835m);
        r10.setOnErrorListener(this.f23836n);
        r10.prepareAsync();
        return;
    L5:
        if (r11 == PlayerState.STOPPED) goto L6;
    }

    public final void u(Message r10) {
        HandlerThread r11 = this.f23834l;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isAlive() == true) goto L7;
        return;
    L7:
        if (r11.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.f23832j != null) goto L11;
        this.f23832j = new Handler(r11.getLooper(), this);
    L11:
        Handler r12 = this.f23832j;
        q.d(r12);
        r12.sendMessageDelayed(r10, 0);
    }

    public final void v(sb.b r10) {
        w(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r(this, false, 0, 0, "alphaVideoView set dataSource failure: " + Log.getStackTraceString(e), 6, null);
        h();
    }

    public final void w(sb.b r10) {
        this.f23826d.reset();
        this.f23829g = PlayerState.NOT_PREPARED;
        Resources r11 = this.f23823a.getResources();
        q.f(r11, "context.resources");
        int r12 = r11.getConfiguration().orientation;
        throw null;
    }

    public a(sb.a r10, IMediaPlayer r11) {
        q.g(r10, "configuration");
        this.f23829g = PlayerState.NOT_PREPARED;
        this.f23833k = new Handler(Looper.getMainLooper());
        this.f23835m = new rb.d(this);
        this.f23836n = new rb.c(this);
        this.f23823a = r10.b();
        this.f23824b = r10.c();
        this.f23825c = r10.a();
        if (r11 != null) goto L6;
        r11 = new tb.b();
    L6:
        this.f23826d = r11;
        l();
    }
}
