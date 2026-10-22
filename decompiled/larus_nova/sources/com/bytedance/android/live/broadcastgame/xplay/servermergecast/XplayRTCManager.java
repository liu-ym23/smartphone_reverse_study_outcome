package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.q;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.broadcastgame.xplay.XplayException;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayRTCManager implements o, com.bytedance.android.live.broadcastgame.xplay.servermergecast.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f62386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f62387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f62388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f62389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f62390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, Integer> f62391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<XplayException> f62392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ei6.a f62393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f62394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f62395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f62396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f62397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f62398m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f62399n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final XplayMonitorSession f62400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b f62401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a f62402q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f62403a = null;

        static {
            f62403a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractGameService r100 = (IInteractGameService) k.n(IInteractGameService.class);     // Catch: Throwable -> L4
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
            r101.put(GameSeiConstants.KEY_GAME_WTN_PUSH_STREAM, "");     // Catch: Throwable -> L4
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
            r100.sendGameCastStatusSEI(false, r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        this.f62396k.postDelayed(this.f62397l, 1000);
        if (this.f62389d == false) goto L27;
        XplayLog.c("XplayRTCManager", "destroy rtc engine");
        this.f62389d = false;
        ei6.a r100 = this.f62393h;
        if (r100 == null) goto L9;
        gi6.e r101 = r100.getEventManager();
        if (r101 == null) goto L9;
        r101.b(null);
    L9:
        ei6.a r102 = this.f62393h;
        if (r102 == null) goto L14;
        si6.b r103 = r102.b();
        if (r103 == null) goto L14;
        si6.a.b(r103, false, "XplayRTCManager destroyEngine", 3);
    L14:
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L21;
        j<com.bytedance.android.live.pushstream.d> r105 = r104.getLiveStream();
        if (r105 == null) goto L21;
        com.bytedance.android.live.pushstream.d r106 = r105.getValue();
        if (r106 == null) goto L21;
        r106.r1();
    L21:
        g r107 = this.f62388c;
        if (r107 == null) goto L24;
        r107.f62416b = false;
    L24:
        if (r107 == null) goto L26;
        r107.f62421g.clear();
    L26:
        this.f62388c = null;
        this.f62402q.d();
    L27:
        this.f62394i.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L10;
        j<com.bytedance.android.live.pushstream.d> r101 = r100.getLiveStream();
        if (r101 == null) goto L11;
        com.bytedance.android.live.pushstream.d r102 = r101.getValue();
        if (r102 == null) goto L12;
        r102.r1();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        g r100 = this.f62388c;
        if (r100 == null) goto L5;
        r100.f62421g.clear();
    L5:
        this.f62394i.clear();
    }

    public XplayRTCManager(p r100, XplayMonitorSession r101, com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r102, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r103) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        Intrinsics.checkNotNullParameter(r101, "monitorSession");
        Intrinsics.checkNotNullParameter(r102, "littleWindowService");
        Intrinsics.checkNotNullParameter(r103, "xplayLittleWindowCastManager");
        this.f62399n = r100;
        this.f62400o = r101;
        this.f62401p = r102;
        this.f62402q = r103;
        this.f62392g = PublishSubject.create();
        this.f62394i = new CompositeDisposable();
        this.f62395j = System.currentTimeMillis();
        this.f62396k = new Handler(Looper.getMainLooper());
        this.f62397l = b.f62403a;
        this.f62398m = LazyKt.lazy(new XplayRTCManager$mRtcListener$2(this));
    }
}
