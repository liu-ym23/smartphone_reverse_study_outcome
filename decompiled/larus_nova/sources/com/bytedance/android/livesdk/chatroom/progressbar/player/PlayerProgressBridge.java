package com.bytedance.android.livesdk.chatroom.progressbar.player;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progressbar.widget.PlayerProgressBarWidget;
import com.bytedance.android.livesdk.chatroom.utils.h4;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import vr1.u;
import vr1.y;

/* JADX INFO: loaded from: classes7.dex */
public final class PlayerProgressBridge implements com.bytedance.android.livesdk.chatroom.progressbar.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f107786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f107787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f107788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompositeDisposable f107789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f107790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f107791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f107792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f107793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f107794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f107795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f107796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f107797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f107798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.progressbar.ui.a> f107799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f107800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f107801p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PlayerProgressServiceContext f107802q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f107803r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataCenter f107804s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LifecycleOwner f107805t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.progressbar.a.InterfaceC1638a f107806u;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBridge f107807a;

        public a(PlayerProgressBridge r100) {
            this.f107807a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f107807a.f107800o.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBridge f107808a;

        public b(PlayerProgressBridge r100) {
            this.f107808a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L9;
            Iterator r101 = ((ArrayList) this.f107808a.f107799n).iterator();
        L7:
            if (r101.hasNext() == false) goto L11;
            ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r101.next()).z();
            goto L7
        L11:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBridge f107809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f107810b;

        public c(PlayerProgressBridge r100, y r101) {
            this.f107809a = r100;
            this.f107810b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            if (((Boolean) r110).booleanValue() == false) goto L23;
            PlayerProgressBridge r111 = this.f107809a;
            if (r111.f107791f == false) goto L7;
            return;
        L7:
            if (r111.f107797l == true) goto L26;
            r111.f107793h = true;
            r111.f107792g = com.bytedance.android.livesdk.utils.ntp.e.a();
            this.f107809a.f107802q.setForceSeekResolution(null);
            com.bytedance.android.livesdk.vscore_api.paidlive.b r112 = g.d(this.f107809a.f107804s).J0();
            if (r112.d(this.f107809a.f107804s) == false) goto L16;
            String r100 = r112.c(this.f107809a.f107804s);
            if (r100 == null) goto L16;
            NextLiveData<Boolean> r101 = this.f107810b.d(this.f107809a.f107804s);
            this.f107809a.getClass();
            ILivePlayerClient r102 = PlayerProgressBridge.c();
            Pair[] r103 = new Pair[4];
            String r104 = "0";
            r103[0] = TuplesKt.to(VrBgLogData.KEY_IS_PREVIEW, "0");
            r103[1] = TuplesKt.to("reason", "click_at_latest");
            if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.c(g.d(this.f107809a.f107804s)) == false) goto L15;
            r104 = "1";
        L15:
            r103[2] = TuplesKt.to("view_right", r104);
            r103[3] = TuplesKt.to("current_camera_id", String.valueOf(g.d(this.f107809a.f107804s).J0().w(this.f107809a.f107804s)));
            com.bytedance.android.livesdk.vscore_api.paidlive.b.a.c(r112, r102, r100, r101, MapsKt.mutableMapOf(r103));
        L16:
            this.f107809a.getClass();
            ILivePlayerClient r113 = PlayerProgressBridge.c();
            if (r113 == null) goto L19;
            r113.seekBy(0, this.f107809a.f107795j);
        L19:
            Iterator r114 = ((ArrayList) this.f107809a.f107799n).iterator();
        L21:
            if (r114.hasNext() == false) goto L27;
            ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r114.next()).E();
            goto L21
        L27:
            return;
        L26:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBridge f107811a;

        public d(PlayerProgressBridge r100) {
            this.f107811a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (this.f107811a.f107793h == true) goto L37;
            ALogger.i("PlayerProgressBridge", "receive seekEvent:" + r101 + ", duration = " + this.f107811a.f107787b + ", seekLimit = " + this.f107811a.e());
            this.f107811a.f107786a = r101.longValue();
            PlayerProgressBridge r102 = this.f107811a;
            if (r102.f107786a != r102.f107787b) goto L8;
            r102.f107802q.getAtLatest().setValue(Boolean.TRUE);
            this.f107811a.f107791f = false;
            return;
        L8:
            r102.f107802q.getAtLatest().setValue(Boolean.FALSE);
            PlayerProgressBridge r103 = this.f107811a;
            r103.f107791f = true;
            r103.f107792g = com.bytedance.android.livesdk.utils.ntp.e.a();
            PlayerProgressBridge r104 = this.f107811a;
            long r105 = r104.f107786a;
            if (r105 != 0) goto L11;
            long r106 = (com.bytedance.android.livesdk.utils.ntp.e.a() - this.f107811a.f107803r) / 1000;
        L12:
            r104.f107796k = r106;
            if (this.f107811a.f107806u.a() == false) goto L28;
            PlayerProgressBridge r107 = this.f107811a;
            r107.getClass();
            ILivePlayerClient r108 = PlayerProgressBridge.c();
            String r109 = PlayerResolution.SDKKEY.ORIGIN;
            if (r108 == null) goto L18;
            String r110 = r108.getCurrentResolution();
            if (r110 == null) goto L18;
        L19:
            r107.f107795j = r110;
            PlayerProgressBridge r111 = this.f107811a;
            r111.f107802q.setForceSeekResolution(r111.f107806u.b());
            this.f107811a.getClass();
            ILivePlayerClient r112 = PlayerProgressBridge.c();
            if (r112 == null) goto L31;
            PlayerProgressBridge r113 = this.f107811a;
            int r114 = (int) r113.f107796k;
            IQuality r115 = r113.f107802q.getForceSeekResolution();
            if (r115 == null) goto L27;
            String r116 = r115.getSdkKey();
            if (r116 == null) goto L27;
            r109 = r116;
        L27:
            r112.seekBy(r114, r109);
        L31:
            StringBuilder r117 = new StringBuilder("do seekBy, timeShift:");
            r117.append(this.f107811a.f107796k);
            r117.append(", time str : ");
            int r118 = h4.f114490a;
            r117.append(h4.a(this.f107811a.f107786a));
            ALogger.i("PlayerProgressBridge", r117.toString());
            Iterator r119 = ((ArrayList) this.f107811a.f107799n).iterator();
        L33:
            if (r119.hasNext() == false) goto L38;
            ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r119.next()).B();
            goto L33
        L38:
            return;
        L18:
            r110 = PlayerResolution.SDKKEY.ORIGIN;
            goto L19
        L28:
            this.f107811a.getClass();
            ILivePlayerClient r120 = PlayerProgressBridge.c();
            if (r120 == null) goto L31;
            r120.seekBy((int) this.f107811a.f107796k);
            goto L31
        L11:
            r106 = RangesKt.coerceAtLeast((r104.f107787b - r105) / 1000, r104.e());
            goto L12
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBridge f107812a;

        public final void a() {
            long r100 = SystemClock.uptimeMillis();
            this.f107812a.f107788c.postAtTime(this, r100 + (1000 - (r100 % 1000)));
            this.f107812a.f107787b += 1000;
            IRoomEventHub r101 = PlayerProgressBridge.d();
            if (r101 == null) goto L7;
            MutableLiveData<Boolean> r102 = r101.getPlaying();
            if (r102 == null) goto L7;
            Boolean r103 = r102.getValue();
        L9:
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L18;
            PlayerProgressServiceContext r104 = this.f107812a.f107802q;
            if (r104 == null) goto L17;
            m<Boolean> r105 = r104.getAtLatest();
            if (r105 == null) goto L17;
            if (r105.getValue().booleanValue() != true) goto L17;
            PlayerProgressBridge r106 = this.f107812a;
            r106.f107786a = r106.f107787b;
        L17:
            this.f107812a.f107786a += 1000;
        L18:
            Iterator r107 = ((ArrayList) this.f107812a.f107799n).iterator();
        L20:
            if (r107.hasNext() == false) goto L22;
            com.bytedance.android.livesdk.chatroom.progressbar.ui.a r108 = (com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r107.next();
            PlayerProgressBridge r109 = this.f107812a;
            r108.A(r109.f107786a, r109.f107787b);
            goto L20
        L22:
            return;
        L7:
            r103 = null;
            goto L9
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

        public e(PlayerProgressBridge r100) {
            this.f107812a = r100;
        }
    }

    public final long e() {
        return ((Number) this.f107798m.getValue()).longValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.a
    public final void clear() {
        ((ArrayList) this.f107799n).clear();
        this.f107789d.dispose();
        this.f107788c.removeCallbacks(this.f107800o);
        this.f107788c.removeCallbacks(this.f107801p);
    }

    public final void g() {
        long r100 = 0;
        if (this.f107791f == true) goto L14;
        PlayerProgressServiceContext r101 = this.f107802q;
        if (r101 == null) goto L11;
        m<Long> r102 = r101.getCurrentTime();
        if (r102 == null) goto L11;
        Long r103 = r102.getValue();
        if (r103 == null) goto L11;
        long r104 = r103.longValue();
    L12:
        this.f107786a = r104;
    L11:
        r104 = 0;
    L14:
        if (this.f107786a != 0) goto L16;
        ALogger.e("PlayerProgressBridge", "no sei ts before first frame");
        long r105 = com.bytedance.android.livesdk.utils.ntp.e.a();
        long r106 = this.f107803r;
    L24:
        long r107 = r105 - r106;
    L25:
        this.f107787b = r107;
        StringBuilder r108 = new StringBuilder("start duration is ");
        r108.append(this.f107787b);
        r108.append(", readText: ");
        int r109 = h4.f114490a;
        r108.append(h4.a(this.f107787b));
        ALogger.i("PlayerProgressBridge", r108.toString());
        SystemClock.elapsedRealtime();
        ILivePlayerClient r110 = r.p().currentClient();
        if (r110 == null) goto L29;
        r110.setLiveRoomState(true);
    L29:
        if (((Number) this.f107804s.get("data_first_show_play_position", 0L)).longValue() <= 0) goto L37;
        this.f107786a = ((Number) this.f107804s.get("data_first_show_play_position", 0L)).longValue() - this.f107803r;
        this.f107804s.put("data_first_show_play_position", 0L);
        IRoomEventHub r111 = d();
        if (r111 == null) goto L35;
        MutableLiveData<String> r112 = r111.getSeiUpdate();
        if (r112 == null) goto L35;
        String r113 = r112.getValue();
    L36:
        h(r113);
        ALogger.i("PlayerProgressBridge", "currentTime form preview enter " + this.f107786a + ", time str:" + h4.a(this.f107786a));
    L35:
        r113 = null;
    L37:
        this.f107788c.removeCallbacks(this.f107800o);
        this.f107788c.removeCallbacks(this.f107801p);
        this.f107788c.postDelayed(this.f107801p, 1000);
        if (this.f107791f == false) goto L40;
    L51:
        StringBuilder r114 = new StringBuilder("start play currentTime ");
        r114.append(this.f107786a);
        r114.append(", duration ");
        r114.append(this.f107787b);
        r114.append('(');
        int r115 = h4.f114490a;
        r114.append(h4.a(this.f107787b));
        r114.append("), after seek ");
        r114.append(this.f107791f);
        r114.append(", back to latest ");
        r114.append(this.f107793h);
        ALogger.i("PlayerProgressBridge", r114.toString());
        if (this.f107791f == false) goto L71;
        this.f107791f = false;
        f(false);
        IRoom r116 = this.f107790e;
        if (r116 != null) goto L56;
    L58:
        boolean r117 = false;
    L59:
        if (r117 == false) goto L61;
    L66:
        Iterator r118 = ((ArrayList) this.f107799n).iterator();
    L68:
        if (r118.hasNext() == false) goto L71;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r118.next()).C();
        goto L68
    L61:
        if ((this.f107787b - this.f107786a) >= (e() * 1000)) goto L66;
        this.f107786a -= this.f107796k * 1000;
        Iterator r119 = ((ArrayList) this.f107799n).iterator();
    L64:
        if (r119.hasNext() == false) goto L66;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r119.next()).A(this.f107786a, this.f107787b);
        goto L64
    L56:
        if (r116.isMergeVSRoom() != true) goto L58;
        r117 = true;
    L71:
        if (this.f107793h == false) goto L76;
        this.f107793h = false;
        this.f107786a = this.f107787b;
        f(true);
        Iterator r120 = ((ArrayList) this.f107799n).iterator();
    L74:
        if (r120.hasNext() == false) goto L76;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r120.next()).D();
    L76:
        Iterator r121 = ((ArrayList) this.f107799n).iterator();
    L78:
        if (r121.hasNext() == false) goto L81;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r121.next()).A(this.f107786a, this.f107787b);
        goto L78
    L81:
        if (h.c(this.f107804s) == true) goto L124;
    L90:
        PlayerProgressServiceContext r122 = this.f107802q;
        if (r122 == null) goto L97;
        i<Long> r123 = r122.getInitSeekTime();
        if (r123 == null) goto L97;
        Long r124 = r123.getValue();
        if (r124 == null) goto L97;
        long r125 = r124.longValue();
    L99:
        if (r125 > 0) goto L101;
        return;
    L101:
        if (this.f107794i == true) goto L132;
        ALogger.i("PlayerProgressBridge", "receive initSeekTime :" + r125 + "(s), duration + startTime = " + (this.f107787b + this.f107803r));
        if (String.valueOf(r125).length() != 10) goto L105;
        r125 = r125 * 1000;
    L105:
        PlayerProgressServiceContext r126 = this.f107802q;
        if (r126 == null) goto L112;
        m<Long> r127 = r126.getLimitStartTime();
        if (r127 == null) goto L112;
        Long r128 = r127.getValue();
        if (r128 == null) goto L112;
        r100 = r128.longValue();
    L112:
        long r129 = this.f107803r;
        long r130 = this.f107787b + r129;
        if (((r100 + r129) + 1) <= r125) goto L116;
        return;
    L116:
        if (r130 <= r125) goto L133;
        long r131 = r125 - r129;
        PlayerProgressServiceContext r132 = this.f107802q;
        if (r132 == null) goto L122;
        k<Long> r133 = r132.getSeekEvent();
        if (r133 == null) goto L122;
        r133.post(Long.valueOf(r131));
    L122:
        this.f107794i = true;
        ALogger.i("PlayerProgressBridge", "initSeek do seekTo :" + r131);
        return;
    L133:
        return;
    L132:
        return;
    L97:
        r125 = -1;
        goto L99
    L124:
        IRoom r134 = this.f107790e;     // Catch: JSONException -> L89
        if (r134 == null) goto L86;
        long r135 = r134.getId();     // Catch: JSONException -> L89
    L87:
        a(r135, this.f107786a, false);     // Catch: JSONException -> L89
        goto L90
    L86:
        r135 = 0;
        goto L87
    L40:
        if (this.f107793h == true) goto L51;
        PlayerProgressServiceContext r136 = this.f107802q;
        if (r136 == null) goto L51;
        m<Boolean> r137 = r136.getAtLatest();
        if (r137 == null) goto L51;
        if (r137.getValue().booleanValue() != true) goto L51;
        this.f107786a = this.f107787b;
        Iterator r138 = ((ArrayList) this.f107799n).iterator();
    L49:
        if (r138.hasNext() == false) goto L51;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r138.next()).onRenderStart();
        goto L49
    L16:
        PlayerProgressServiceContext r139 = this.f107802q;
        if (r139 == null) goto L23;
        m<Long> r140 = r139.getTotalTime();
        if (r140 == null) goto L23;
        Long r141 = r140.getValue();
        if (r141 == null) goto L23;
        r107 = r141.longValue();
    L23:
        r105 = System.currentTimeMillis();
        r106 = this.f107803r;
        goto L24
    }

    public static ILivePlayerClient c() {
        return r.p().currentClient();
    }

    public static IRoomEventHub d() {
        ILivePlayerClient r100 = c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEventHub();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.a
    public final void start() {
        if (c() != null) goto L5;
        return;
    L5:
        IRoomEventHub r100 = d();
        String r101 = null;
        if (r100 == null) goto L10;
        MutableLiveData<Boolean> r102 = r100.getPlaying();
        if (r102 == null) goto L10;
        Boolean r103 = r102.getValue();
    L12:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L26;
        g();
        u r104 = r.u(this.f107804s, null, 2);
        if (r104 == null) goto L20;
        j<Long> r105 = r104.q();
        if (r105 == null) goto L20;
        Long r106 = r105.getValue();
        if (r106 == null) goto L20;
        long r107 = r106.longValue();
    L22:
        if (r107 <= 0) goto L26;
        ILivePlayerClient r108 = c();
        if (r108 == null) goto L26;
        r108.setLiveRoomState(true);
    L20:
        r107 = 0;
    L26:
        StringBuilder r109 = new StringBuilder("init sei = ");
        IRoomEventHub r110 = d();
        if (r110 == null) goto L31;
        MutableLiveData<String> r111 = r110.getSeiUpdate();
        if (r111 == null) goto L31;
        r101 = r111.getValue();
    L31:
        r109.append(r101);
        ALogger.i("PlayerProgressBridge", r109.toString());
        ILivePlayerClient r112 = c();
        if (r112 == null) goto L34;
        r112.enableRTMPauseUseStop(false);
    L34:
        IRoomEventHub r113 = d();
        if (r113 == null) goto L38;
        r113.getPlaying().observe(this.f107805t, new com.bytedance.android.livesdk.chatroom.progressbar.player.a(this));
        r113.getStopped().observe(this.f107805t, new com.bytedance.android.livesdk.chatroom.progressbar.player.b(this));
        r113.getSeiUpdate().observe(this.f107805t, new com.bytedance.android.livesdk.chatroom.progressbar.player.c(this));
    L38:
        Object r114 = pm1.h.f529822d.c(y.class);
        Intrinsics.checkNotNull(r114);
        y r115 = (y) r114;
        NextLiveData<Boolean> r116 = r115.c(this.f107804s);
        if (r116 == null) goto L41;
        r116.observe(this.f107805t, new b(this));
    L41:
        this.f107789d = new CompositeDisposable();
        PlayerProgressServiceContext r117 = this.f107802q;
        if (r117 == null) goto L50;
        m<Boolean> r118 = r117.getAtLatest();
        if (r118 == null) goto L50;
        Observable<Boolean> r119 = r118.a();
        if (r119 == null) goto L50;
        Disposable r120 = r119.subscribe(new c(this, r115));
        if (r120 == null) goto L50;
        RxUtilKt.c(r120, this.f107789d);
    L50:
        PlayerProgressServiceContext r121 = this.f107802q;
        if (r121 == null) goto L60;
        k<Long> r122 = r121.getSeekEvent();
        if (r122 == null) goto L61;
        PublishSubject r123 = r122.onEvent();
        if (r123 == null) goto L62;
        Disposable r124 = r123.subscribe(new d(this));
        if (r124 == null) goto L63;
        RxUtilKt.c(r124, this.f107789d);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L10:
        r103 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.a
    public final void b(PlayerProgressBarWidget.PlayerProgressListener r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ((ArrayList) this.f107799n).add(r100);
    }

    public final void f(boolean r100) {
        long r101 = com.bytedance.android.livesdk.utils.ntp.e.a() - this.f107792g;
        ALogger.i("PlayerProgressBridge", "last seek duration:" + r101 + ",isAtLatest:" + r100);
        r.l().sendLog("livesdk_live_seek_duration", MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(r101))), new Object[0]);
    }

    public final void h(String r110) {
        if (r110 != null) goto L6;
        return;
    L6:
        if (this.f107791f == false) goto L8;
        return;
    L8:
        if (this.f107793h == true) goto L46;
        LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L40
        long r100 = LiveSeiUtil.c(r110).optLong("ts", -1);     // Catch: JSONException -> L40
        PlayerProgressServiceContext r101 = this.f107802q;     // Catch: JSONException -> L40
        if (r101 != null) goto L13;
    L22:
        boolean r102 = false;
    L24:
        if (r100 != (-1)) goto L26;
        return;
    L26:
        long r103 = r100 - this.f107803r;     // Catch: JSONException -> L40
        this.f107786a = r103;     // Catch: JSONException -> L40
        if (r102 == false) goto L29;
        this.f107787b = r103;     // Catch: JSONException -> L40
    L29:
        Iterator r104 = ((ArrayList) this.f107799n).iterator();     // Catch: JSONException -> L40
    L31:
        if (r104.hasNext() == false) goto L33;
        ((com.bytedance.android.livesdk.chatroom.progressbar.ui.a) r104.next()).A(this.f107786a, this.f107787b);     // Catch: JSONException -> L40
        goto L31
    L33:
        u r105 = r.u(this.f107804s, null, 2);     // Catch: JSONException -> L40
        if (r105 == null) goto L38;
        m<z0> r106 = r105.K0();     // Catch: JSONException -> L40
        if (r106 == null) goto L38;
        r106.setValue(new z0(r100, System.currentTimeMillis()));     // Catch: JSONException -> L40
    L38:
        StringBuilder r107 = new StringBuilder();     // Catch: JSONException -> L40
        r107.append("currentTime form sei ");     // Catch: JSONException -> L40
        r107.append(this.f107786a);     // Catch: JSONException -> L40
        r107.append(", time str:");     // Catch: JSONException -> L40
        int r108 = h4.f114490a;     // Catch: JSONException -> L40
        r107.append(h4.a(this.f107786a));     // Catch: JSONException -> L40
        ALogger.i("PlayerProgressBridge", r107.toString());     // Catch: JSONException -> L40
        return;
    L13:
        if (r101.isCleared() == false) goto L16;
        r101 = null;
    L16:
        if (r101 == null) goto L22;
        m<Boolean> r109 = r101.getAtLatest();     // Catch: JSONException -> L40
        if (r109 == null) goto L22;
        r102 = true;
        if (r109.getValue().booleanValue() != true) goto L22;
    L40:
        ALogger.w("PlayerProgressBridge", "jsonException for sei:".concat(r110));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.a
    public final void a(long r100, long r101, boolean r110) {
        r.p().f(r100, r101, r110);
    }

    public PlayerProgressBridge(PlayerProgressServiceContext r100, long r101, DataCenter r102, LifecycleOwner r103, com.bytedance.android.livesdk.chatroom.progressbar.a.InterfaceC1638a r104) {
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "owner");
        Intrinsics.checkNotNullParameter(r104, "config");
        this.f107802q = r100;
        this.f107803r = r101;
        this.f107804s = r102;
        this.f107805t = r103;
        this.f107806u = r104;
        this.f107788c = new Handler(Looper.getMainLooper());
        this.f107789d = new CompositeDisposable();
        this.f107790e = h.e(r102);
        this.f107795j = "";
        this.f107798m = LazyKt.lazy(new PlayerProgressBridge$seekLimit$2(this));
        this.f107799n = new ArrayList();
        this.f107800o = new e(this);
        this.f107801p = new a(this);
    }
}
