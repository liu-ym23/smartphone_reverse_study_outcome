package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.android.shopping.api.video.AVScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ECVideoPlayer implements VideoEngineListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f187336r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTVideoEngine f187337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f187338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f187339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f187340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.shopping.widget.ecvideoplayer.b> f187341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.shopping.widget.ecvideoplayer.b> f187342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.widget.ecvideoplayer.i f187343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f187344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f187345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f187346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f187347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Error f187348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f187349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ReentrantLock f187350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Condition f187351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f187352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AVScene f187353q;

    public static final class a {
        public static String a(int r100) {
            if (r100 == (-1)) goto L25;
            if (r100 != 0) goto L6;
            return ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE;
        L6:
            if (r100 != 2) goto L8;
            return "prepared";
        L8:
            if (r100 != 3) goto L10;
            return "playing";
        L10:
            if (r100 != 4) goto L12;
            return "paused";
        L12:
            if (r100 != 6) goto L14;
            return "release";
        L14:
            if (r100 != 7) goto L16;
            return "preparing";
        L16:
            if (r100 == 8) goto L18;
            return "";
        L18:
            return "buffering";
        L25:
            return "error";
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187354a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L32;
            ECVideoPlayer r101 = this.f187354a;
            TTVideoEngine r102 = r101.f187337a;
            if (r102 == null) goto L7;
            int r103 = r102.getCurrentPlaybackTime();
        L8:
            if (r103 > 0) goto L10;
        L15:
            Iterator<T> r104 = r101.d().iterator();
        L17:
            if (r104.hasNext() == false) goto L27;
            com.bytedance.android.shopping.widget.ecvideoplayer.b r105 = (com.bytedance.android.shopping.widget.ecvideoplayer.b) r104.next();
            TTVideoEngine r106 = r101.f187337a;
            if (r106 == null) goto L21;
            int r107 = r106.getCurrentPlaybackTime();
        L22:
            TTVideoEngine r108 = r101.f187337a;
            if (r108 == null) goto L25;
            int r109 = r108.getDuration();
        L26:
            r105.h(r107, r109);
            goto L17
        L25:
            r109 = 0;
            goto L26
        L21:
            r107 = 0;
            goto L22
        L27:
            sendEmptyMessageDelayed(1, 500);
            return;
        L10:
            if (r101.f187343g.f187406d != 2) goto L12;
            boolean r110 = true;
        L13:
            if (r110 == false) goto L15;
            r101.f187343g.a(3);
            r101.c();
            goto L15
        L12:
            r110 = false;
            goto L13
        L7:
            r103 = 0;
            goto L8
        }

        public b(ECVideoPlayer r100, Looper r101) {
            this.f187354a = r100;
            super(r101);
        }
    }

    public static final class c extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187356d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.f187356d.g(this);
            this.f187355c.stop();
            this.f187356d.f187349m.removeMessages(1);
        }

        public c(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187355c = r100;
            this.f187356d = r101;
            super(6);
        }
    }

    public static final class d extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Surface f187359e;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            if (this.f187359e.isValid() == false) goto L8;
            this.f187357c.setSurface(this.f187359e);
            this.f187358d.f187339c = true;
            if (this.f187359e.isValid() == true) goto L8;
            this.f187357c.setSurface(null);
            this.f187358d.f187339c = false;
        L8:
            if (this.f187358d.f187339c == false) goto L13;
            int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
            StringBuilder r101 = new StringBuilder("PlayerTaskExecutor");
            k r102 = this.f187407a;
            if (r102 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L12:
            r101.append(r102.hashCode());
            r101.append(" run setSurface success ");
            r101.append(b());
            r101.append(" surface = ");
            r101.append(this.f187359e.hashCode());
            r101.append(" isSurfaceValid = ");
            r101.append(this.f187359e.isValid());
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r101.toString());
            return;
        L13:
            int r103 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
            StringBuilder r104 = new StringBuilder("PlayerTaskExecutor");
            k r105 = this.f187407a;
            if (r105 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L16:
            r104.append(r105.hashCode());
            r104.append(" run setSurface fail ");
            r104.append(b());
            r104.append(" surface = ");
            r104.append(this.f187359e.hashCode());
            r104.append(" isSurfaceValid = ");
            r104.append(this.f187359e.isValid());
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r104.toString());
        }

        public d(TTVideoEngine r100, ECVideoPlayer r101, Surface r102) {
            this.f187357c = r100;
            this.f187358d = r101;
            this.f187359e = r102;
            super(10);
        }
    }

    public static final class e extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187361d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.f187360c.setSurface(null);
            this.f187361d.f187339c = false;
            int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
            StringBuilder r101 = new StringBuilder("PlayerTaskExecutor");
            k r102 = this.f187407a;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L5:
            r101.append(r102.hashCode());
            r101.append(" run ");
            r101.append(b());
            r101.append(" onSurfaceDestroy");
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r101.toString());
        }

        public e(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187360c = r100;
            this.f187361d = r101;
            super(10);
        }
    }

    public static final class f extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187363d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r100 = this.f187363d.f187343g;
            r100.getClass();
            if (r100.c(new int[]{3}) == false) goto L5;
            this.f187363d.g(this);
            this.f187362c.pause();
            return;
        L5:
            this.f187363d.f(this);
        }

        public f(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187362c = r100;
            this.f187363d = r101;
            super(1);
        }
    }

    public static final class g extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187365d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r100 = this.f187365d.f187343g;
            r100.getClass();
            if (r100.c(new int[]{0, 4, -1}) == false) goto L31;
            this.f187365d.g(this);
            boolean r101 = true;
            if (this.f187365d.f187343g.f187406d != 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == false) goto L10;
        L14:
            this.f187365d.f187343g.a(7);
            this.f187365d.c();
        L15:
            ECVideoPlayer r103 = this.f187365d;
            TTVideoEngine r104 = r103.f187337a;
            if (r104 == null) goto L19;
            r104.setIsMute(r103.f187346j);
        L19:
            if (this.f187365d.f187353q.getTag().length() <= 0) goto L21;
            boolean r105 = true;
        L22:
            if (r105 == false) goto L25;
            this.f187364c.setTag(this.f187365d.f187353q.getTag());
        L25:
            if (this.f187365d.f187353q.getSubTag().length() > 0) goto L28;
            r101 = false;
        L28:
            if (r101 == false) goto L30;
            this.f187364c.setSubTag(this.f187365d.f187353q.getSubTag());
        L30:
            dm.a.a("ECVideoPlayer").i("play tag: " + this.f187365d.f187353q.getTag() + ", subTag: " + this.f187365d.f187353q.getSubTag());
            this.f187364c.play();
            return;
        L21:
            r105 = false;
            goto L22
        L10:
            if (this.f187365d.f187343g.f187406d != (-1)) goto L12;
            boolean r106 = true;
        L13:
            if (r106 == false) goto L15;
        L12:
            r106 = false;
            goto L13
        L7:
            r102 = false;
            goto L8
        L31:
            this.f187365d.f(this);
        }

        public g(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187364c = r100;
            this.f187365d = r101;
            super(0);
        }
    }

    public static final class h extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187367d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.f187367d.g(this);
            this.f187366c.releaseAsync();
        }

        public h(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187366c = r100;
            this.f187367d = r101;
            super(3);
        }
    }

    public static final class i extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f187369d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            TTVideoEngine r100 = this.f187368c.f187337a;
            if (r100 == null) goto L5;
            r100.setDirectURL(this.f187369d);
        L5:
            this.f187368c.g(this);
        }

        public i(ECVideoPlayer r100, String r101) {
            this.f187368c = r100;
            this.f187369d = r101;
            super(4);
        }
    }

    public static final class j extends com.bytedance.android.shopping.widget.ecvideoplayer.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTVideoEngine f187370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECVideoPlayer f187371d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r100 = this.f187371d.f187343g;
            r100.getClass();
            if (r100.c(new int[]{3, 4, 2}) == false) goto L7;
            this.f187371d.g(this);
            this.f187370c.stop();
            if (this.f187371d.f187343g.f187406d != 2) goto L9;
            ECVideoPlayer r101 = this.f187371d;
            r101.f187345i = 0;
            r101.f187344h = 0;
            r101.f187343g.a(0);
            r101.f187349m.removeMessages(1);
            r101.c();
            return;
        L9:
            return;
        L7:
            this.f187371d.f(this);
        }

        public j(TTVideoEngine r100, ECVideoPlayer r101) {
            this.f187370c = r100;
            this.f187371d = r101;
            super(2);
        }
    }

    static {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onFirstAVSyncFrame(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPrepare(TTVideoEngine r100) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onRefreshSurface(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
        return VideoEngineListener.CC.$default$onSetSurface(this, r100, r101, r102);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onSilenceDetected(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onStreamChanged(TTVideoEngine r100, int r101) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
        VideoEngineListener.CC.$default$onVideoSecondFrame(this, r100);
    }

    public final void c() {
        Function0<Unit> r100 = new ECVideoPlayer$dispatchVideoStatusToAll$1(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.invoke();
        return;
    L8:
        this.f187349m.post(new com.bytedance.android.shopping.widget.ecvideoplayer.c(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final List<com.bytedance.android.shopping.widget.ecvideoplayer.b> d() {
        this.f187342f.clear();
        this.f187342f.addAll(this.f187341e);
        return this.f187342f;
    }

    public final boolean e() {
        if (this.f187343g.f187406d != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i() {
        int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " onSurfaceDestroy");
        b();
        TTVideoEngine r101 = this.f187337a;
        if (r101 == null) goto L6;
        this.f187338b.c(new e(r101, this));
        return;
    }

    public final void b() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("only main thread can touch");
    L5:
        r100 = false;
        goto L6
    }

    public final void j() {
        b();
        TTVideoEngine r100 = this.f187337a;
        if (r100 == null) goto L6;
        this.f187338b.c(new f(r100, this));
        return;
    }

    public final void k() {
        b();
        TTVideoEngine r100 = this.f187337a;
        if (r100 == null) goto L6;
        this.f187338b.c(new g(r100, this));
        return;
    }

    public final void l() {
        b();
        this.f187343g.a(6);
        TTVideoEngine r100 = this.f187337a;
        this.f187337a = null;
        Iterator<T> r101 = d().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r101.next()).onRelease();
        goto L4
    L6:
        if (r100 == null) goto L10;
        this.f187338b.c(new h(r100, this));
        this.f187349m.removeMessages(1);
        return;
    }

    public final void q() {
        b();
        TTVideoEngine r100 = this.f187337a;
        if (r100 == null) goto L6;
        this.f187338b.c(new j(r100, this));
        return;
    }

    public final Context getContext() {
        return this.f187352p;
    }

    public /* synthetic */ ECVideoPlayer(Context r100) {
        this(r100, AVScene.CONTENT_DEFAULT);
    }

    public final void a(com.bytedance.android.shopping.widget.ecvideoplayer.b r100) {
        Intrinsics.checkNotNullParameter(r100, "ecVideoListener");
        b();
        this.f187341e.add(r100);
        ECVideoPlayer$dispatchVideoStatus$1 r101 = new ECVideoPlayer$dispatchVideoStatus$1(this, r100);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101.invoke();
        return;
    L8:
        this.f187349m.post(new com.bytedance.android.shopping.widget.ecvideoplayer.c(r101));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void f(com.bytedance.android.shopping.widget.ecvideoplayer.j r100) {
        Intrinsics.checkNotNullParameter(r100, "playerTask");
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " ignore " + r100.b() + " PlayerState = " + a.a(this.f187343g.f187406d) + " due to error or release");
    }

    public final void g(com.bytedance.android.shopping.widget.ecvideoplayer.j r100) {
        Intrinsics.checkNotNullParameter(r100, "playerTask");
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " run " + r100.b() + " PlayerState = " + a.a(this.f187343g.f187406d));
    }

    public final void h(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " onSurfaceCreated surface" + r100.hashCode());
        b();
        TTVideoEngine r102 = this.f187337a;
        if (r102 == null) goto L6;
        this.f187338b.c(new d(r102, this, r100));
        return;
    }

    public final void m(com.bytedance.android.shopping.widget.ecvideoplayer.b r100) {
        Intrinsics.checkNotNullParameter(r100, "ecVideoListener");
        b();
        this.f187341e.remove(r100);
    }

    public final void n(boolean r100) {
        TTVideoEngine r101 = this.f187337a;
        if (r101 == null) goto L5;
        r101.setLooping(r100);
    L5:
        this.f187340d = r100;
    }

    public final void o(boolean r100) {
        this.f187346j = r100;
        TTVideoEngine r101 = this.f187337a;
        if (r101 == null) goto L6;
        r101.setIsMute(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onCompletion(TTVideoEngine r100) {
        if (this.f187340d == false) goto L5;
        return;
    L5:
        if (this.f187337a == null) goto L7;
        this.f187338b.c(new com.bytedance.android.shopping.widget.ecvideoplayer.f(5));
    L7:
        Iterator<T> r101 = d().iterator();
    L9:
        if (r101.hasNext() == false) goto L22;
        com.bytedance.android.shopping.widget.ecvideoplayer.b r102 = (com.bytedance.android.shopping.widget.ecvideoplayer.b) r101.next();
        TTVideoEngine r103 = this.f187337a;
        int r104 = 0;
        if (r103 == null) goto L13;
        int r105 = r103.getDuration();
    L14:
        TTVideoEngine r106 = this.f187337a;
        if (r106 == null) goto L17;
        r104 = r106.getDuration();
    L17:
        r102.h(r105, r104);
        r102.g();
        goto L9
    L13:
        r105 = 0;
        goto L14
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onError(Error r100) {
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        StringBuilder r102 = new StringBuilder("PlayerTaskExecutor");
        r102.append(this.f187338b.hashCode());
        r102.append(" onError RetryStrategy=");
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.getRetryStrategy());
    L6:
        r102.append(r103);
        r102.append(" onError=");
        r102.append(r100);
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r102.toString());
        if (this.f187347k == false) goto L9;
        return;
    L9:
        this.f187348l = r100;
        this.f187347k = true;
        this.f187343g.a(-1);
        TTVideoEngine r104 = this.f187337a;
        if (r104 == null) goto L12;
        this.f187338b.c(new c(r104, this));
    L12:
        c();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPrepared(TTVideoEngine r100) {
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " onPrepared isInErrorProcessing=" + this.f187347k);
        if (this.f187347k == false) goto L5;
        return;
    L5:
        this.f187343g.a(2);
        if (this.f187349m.hasMessages(1) == true) goto L9;
        this.f187349m.sendEmptyMessage(1);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onRenderStart(TTVideoEngine r100) {
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " DispatchPlayerEvent onRenderStart");
        Iterator<T> r102 = d().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r102.next()).onRenderStart();
        goto L4
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onVideoStatusException(int r100) {
        onError(new Error("error", 0, String.valueOf(r100)));
    }

    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b();
        if (this.f187337a == null) goto L6;
        this.f187338b.c(new i(this, r100));
        return;
    }

    public ECVideoPlayer(Context r100, AVScene r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f187352p = r100;
        this.f187353q = r101;
        this.f187337a = new TTVideoEngine(r100, 0);
        k r102 = new k(this);
        this.f187338b = r102;
        this.f187341e = new LinkedList();
        this.f187342f = new LinkedList();
        com.bytedance.android.shopping.widget.ecvideoplayer.i r103 = new com.bytedance.android.shopping.widget.ecvideoplayer.i();
        this.f187343g = r103;
        this.f187349m = new b(this, Looper.getMainLooper());
        TTVideoEngine r104 = this.f187337a;
        if (r104 == null) goto L5;
        r104.setListener(this);
        r104.setTag(r101.getTag());
        r104.setSubTag(r101.getSubTag());
        dm.a.a("ECVideoPlayer").i("init tag: " + r101.getTag() + ", subTag: " + r101.getSubTag());
    L5:
        r103.f187405c = r102.hashCode();
        TTVideoEngine r105 = this.f187337a;
        if (r105 == null) goto L8;
        r105.setIntOption(4, 1);
    L8:
        ReentrantLock r106 = new ReentrantLock();
        this.f187350n = r106;
        this.f187351o = r106.newCondition();
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
        int r102 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " onLoadStateChanged " + r101 + " isInErrorProcessing=" + this.f187347k);
        if (this.f187347k == false) goto L5;
        return;
    L5:
        boolean r103 = false;
        if (r101 == 1) goto L23;
        if (r101 == 2) goto L10;
        return;
    L10:
        if (this.f187343g.f187406d != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        this.f187343g.a(7);
        c();
        return;
    L16:
        if (e() == false) goto L18;
    L21:
        this.f187343g.a(8);
        c();
        return;
    L18:
        if (this.f187343g.f187406d != 2) goto L20;
        r103 = true;
    L20:
        if (r103 == true) goto L21;
        return;
    L12:
        r104 = false;
        goto L13
    L23:
        if (this.f187343g.f187406d != 7) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L31;
        this.f187343g.a(2);
        c();
        if (this.f187349m.hasMessages(1) == true) goto L39;
        this.f187349m.sendEmptyMessage(1);
        return;
    L39:
        return;
    L31:
        if (this.f187343g.f187406d != 8) goto L33;
        r103 = true;
    L33:
        if (r103 == false) goto L41;
        this.f187343g.a(3);
        c();
        return;
    L41:
        return;
    L25:
        r105 = false;
        goto L26
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
        int r102 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.f187338b.hashCode() + " onPlaybackStateChanged " + r101 + " isInErrorProcessing=" + this.f187347k);
        if (this.f187347k == false) goto L8;
        if (r101 != 0) goto L29;
        this.f187347k = false;
        return;
    L29:
        return;
    L8:
        if (r101 != 0) goto L10;
        this.f187345i = 0;
        this.f187344h = 0;
        this.f187343g.a(0);
        this.f187349m.removeMessages(1);
        c();
        return;
    L10:
        if (r101 == 1) goto L24;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L16;
        return;
    L16:
        if (r100 == null) goto L20;
        JSONObject r103 = r100.getPlayErrorInfo();
        if (r103 == null) goto L20;
        String r104 = r103.toString();
    L21:
        onError(new Error("error", 0, r104));
        return;
    L20:
        r104 = null;
        goto L21
    L22:
        this.f187343g.a(4);
        this.f187349m.removeMessages(1);
        c();
        return;
    L24:
        if (this.f187349m.hasMessages(1) == true) goto L26;
        this.f187349m.sendEmptyMessage(1);
    L26:
        this.f187343g.a(3);
        c();
    }

    @Override // com.ss.ttvideoengine.VideoEngineListener
    public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
        this.f187344h = r101;
        this.f187345i = r102;
        Iterator<T> r103 = d().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r103.next()).onVideoSizeChanged(r101, r102);
        goto L4
    }
}
