package com.bytedance.android.livesdk.chatroom.replay.paid;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayPaidApi;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.replay.PaidReplayCallback;
import com.bytedance.android.livesdkapi.replay.paid.PaidReplayScene;
import com.bytedance.android.livesdkapi.roomplayer.PaidLivePingV2Response;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/paid/PaidReplayPresenter;", "Lkq1/b;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdkapi/replay/PaidReplayCallback;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidReplayPresenter implements kq1.b, LifecycleOwnerCompat, PaidReplayCallback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f109299u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.scope.j f109300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Long> f109301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplayPaidInfo f109302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vlc.d f109303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f109304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f109305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f109306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f109307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConstraintLayout f109308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f109309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f109310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f109311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f109312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f109313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PaidSceneViewEntry f109314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.paid.d f109315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f109316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f109317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f109318s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f109319t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayPresenter f109320a;

        public b(PaidReplayPresenter r100) {
            this.f109320a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            T r102 = r101.data;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r101.statusCode != 0) goto L16;
            PaidReplayPresenter r103 = this.f109320a;
            PaidLivePingV2Response r104 = (PaidLivePingV2Response) r102;
            int r105 = PaidReplayPresenter.f109299u;
            ALogger.i(r103.getLogTag(), "ping response -> ret_type : " + r104.retType + " , delivery : " + r104.delivery + " , duration : " + r104.duration + " , ");
            int r106 = r104.retType;
            if (r106 != 1) goto L9;
            r103.k(0, r104.delivery);
        L13:
            r103.j();
            return;
        L9:
            if (r106 != 2) goto L13;
            r103.k(1, r104.delivery);
            goto L13
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayPresenter f109321a;

        public c(PaidReplayPresenter r100) {
            this.f109321a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PaidReplayPresenter r101 = this.f109321a;
            int r102 = PaidReplayPresenter.f109299u;
            ALogger.i(r101.getLogTag(), "request ping error! , " + ((Throwable) r100).getMessage());
        }
    }

    public static final class d extends com.bytedance.android.livesdk.chatroom.vs_base.player.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayPresenter f109322a;

        public d(PaidReplayPresenter r100) {
            this.f109322a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
        public final void o0(nic.p r210, tic.a r211, long r212, long r213) {
            PaidReplayPresenter r110 = this.f109322a;
            int r100 = PaidReplayPresenter.f109299u;
            r110.getClass();
            ALogger.i("PaidReplayPresenter", "onScopeFirstFrame");
            if (r110.f109300a == null) goto L5;
            ALogger.i("PaidReplayPresenter", "onScopeFirstFrame, scope not null, skip");
            return;
        L5:
            FrameLayout r111 = r110.f109304e;
            Map<String, String> r101 = r110.f109306g;
            if (r101 == null) goto L8;
            Map r112 = MapsKt.toMap(r101);
        L9:
            String r113 = r110.f109305f;
            ALogger.i("PaidReplayPresenter", "initPaidReplayPresenterPaidScope, scene is : " + r113);
            ((LifecycleRegistry) r110.f109317r.getValue()).setCurrentState(Lifecycle.State.CREATED);
            ((LifecycleRegistry) r110.f109317r.getValue()).setCurrentState(Lifecycle.State.STARTED);
            DataCenter r102 = new DataCenter();
            vlc.d r103 = r110.f109303d;
            if (r103 == null) goto L12;
            r102.put("data_message_manager", r103);
        L12:
            if (r111 == null) goto L14;
            Context r104 = r111.getContext();
        L16:
            if ((r104 instanceof FragmentActivity) == true) goto L18;
            r104 = null;
        L18:
            FragmentActivity r105 = (FragmentActivity) r104;
            if (r105 != null) goto L28;
            Object r106 = pm1.h.f529822d.c(vr1.p.class);
            Intrinsics.checkNotNull(r106);
            vr1.p r107 = (vr1.p) r106;
            if (r111 == null) goto L23;
            Context r108 = r111.getContext();
        L24:
            Context r109 = r107.a(r108);
            if ((r109 instanceof FragmentActivity) == true) goto L27;
            r109 = null;
        L27:
            r105 = (FragmentActivity) r109;
            goto L28
        L23:
            r108 = null;
        L28:
            if (r105 != null) goto L30;
            r105 = (FragmentActivity) com.bytedance.android.live.core.utils.a.d();
        L30:
            FragmentActivity r114 = r105;
            if (r113 != null) goto L34;
        L48:
            PaidSceneViewEntry r115 = PaidSceneViewEntry.REPLAY_SEARCH;
        L49:
            r110.f109314o = r115;
            long r116 = 0;
            if (r114 == null) goto L92;
            StringBuilder r117 = new StringBuilder("initPaidReplayPresenterPaidScope in activity:");
            r117.append(r114);
            r117.append(", isPaidReplay:");
            ReplayPaidInfo r118 = r110.f109302c;
            if (r118 == null) goto L54;
            Boolean r119 = Boolean.valueOf(r118.isPaidEpisode());
        L55:
            r117.append(r119);
            ALogger.i("PaidReplayPresenter", r117.toString());
            yq1.a r120 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            if (r120 == null) goto L64;
            ReplayPaidInfo r121 = r110.f109302c;
            if (r121 == null) goto L62;
            TicketData r122 = r121.getTicketData();
            if (r122 == null) goto L62;
            long r123 = r122.getTicketId();
        L63:
            com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r124 = r120.c(r123, r110.hashCode(), r114, r110, r102, r110.g(), PaidReplayPresenter$initPaidReplayPresenterPaidScope$2$1.INSTANCE, r110.f109302c, PaidReplayPresenter$initPaidReplayPresenterPaidScope$2$2.INSTANCE, r110.f109314o);
        L65:
            r110.f109300a = r124;
            yq1.a r125 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            if (r125 == null) goto L74;
            ReplayPaidInfo r126 = r110.f109302c;
            if (r126 == null) goto L72;
            TicketData r127 = r126.getTicketData();
            if (r127 == null) goto L72;
            long r128 = r127.getTicketId();
        L73:
            r125.f(r128, r110.hashCode(), r110.f109314o);
        L72:
            r128 = 0;
        L74:
            yq1.a r129 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            if (r129 == null) goto L77;
            r129.F(r110.f109300a, r111, r110, r112);
        L77:
            com.bytedance.android.scope.j r130 = r110.f109300a;
            if ((r130 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.scope.b) == true) goto L80;
            com.bytedance.android.scope.j r131 = null;
        L81:
            com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r132 = (com.bytedance.android.livesdk.vscore_api.paidlive.scope.b) r131;
            if (r132 == null) goto L93;
            ConcurrentHashMap<String, Boolean> r133 = r110.f109316q;
            if (r113 != 0) goto L86;
            String r134 = "";
        L87:
            Boolean r135 = r133.get(r134);
            if (r135 == null) goto L93;
            yq1.a r136 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            if (r136 == null) goto L93;
            r136.R(r132, r110.f109314o, r135.booleanValue());
            goto L93
        L86:
            r134 = r113;
        L93:
            yq1.a r137 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            if (r137 == null) goto L103;
            ReplayPaidInfo r138 = r110.f109302c;
            if (r138 == null) goto L100;
            TicketData r139 = r138.getTicketData();
            if (r139 == null) goto L100;
            r116 = r139.getTicketId();
        L100:
            r137.w(r116, new ls2.a(false));
            return;
        L103:
            return;
        L80:
            r131 = r130;
        L62:
            r123 = 0;
            goto L63
        L64:
            r124 = null;
            goto L65
        L54:
            r119 = null;
            goto L55
        L92:
            ALogger.e("PaidReplayPresenter", "initPaidLivePresenterPaidScope failed cuz null activity");
            goto L93
        L34:
            switch(r113.hashCode()) {
                case -539748537: goto L46;
                case 863108557: goto L43;
                case 885887451: goto L40;
                case 1910904673: goto L37;
                default: goto L48;
            };
        L37:
            if (r113.equals("lvideo_theater") == false) goto L48;
            r115 = PaidSceneViewEntry.REPLAY_LVIDEO_THEATER;
            goto L49
        L40:
            if (r113.equals("ml_video") == false) goto L48;
            r115 = PaidSceneViewEntry.REPLAY_ML_VIDEO;
            goto L49
        L43:
            if (r113.equals("lynx_view") == false) goto L48;
            r115 = PaidSceneViewEntry.REPLAY_LYNX_VIEW;
            goto L49
        L46:
            if (r113.equals("search_card") == false) goto L48;
            r115 = PaidSceneViewEntry.REPLAY_SEARCH;
            goto L49
        L14:
            r104 = null;
            goto L16
        L8:
            r112 = null;
            goto L9
        }

        /* JADX WARN: Type inference failed for: r7v10, types: [androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.livesdk.chatroom.replay.paid.b] */
        @Override // nic.l.a, nic.h
        public final void q(oic.f r100, tic.a r101, int r102, int r110) {
            yq1.a r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
            boolean r104 = false;
            if (r103 == null) goto L16;
            fq1.a r105 = fq1.b.a();
            if (r105 == null) goto L9;
            IMainEpisode r106 = r105.a();
            if (r106 == null) goto L9;
            PrivilegeInfo r107 = r106.subscribeReplayInfo();
        L10:
            if (r107 == null) goto L12;
            boolean r108 = true;
        L14:
            if (yq1.a.C8372a.a(r103, null, Boolean.valueOf(r108), 1) != true) goto L16;
            return;
        L12:
            r108 = false;
        L9:
            r107 = null;
        L16:
            PaidReplayPresenter r109 = this.f109322a;
            FrameLayout r111 = r109.f109304e;
            if (r111 != null) goto L19;
        L25:
            if (r104 == true) goto L27;
            return;
        L27:
            ReplayPaidInfo r112 = this.f109322a.f109302c;
            if (r112 == null) goto L30;
            long r113 = r112.getFreeDuration();
        L31:
            long r114 = r102;
            long r115 = 1000 * r113;
            if (1 <= r115) goto L35;
        L42:
            this.f109322a.f109301b.setValue(Long.valueOf(r115 - r114));
        L43:
            ?? r116 = this.f109322a.f109308i;
            if (r116 != 0) goto L46;
            return;
        L46:
            if (r116.isShowing() != true) goto L56;
            VideoContext r117 = this.f109322a.g();
            if (r117 != null) goto L50;
        L51:
            VideoContext r118 = this.f109322a.g();
            if (r118 == null) goto L58;
            r118.pause();
            return;
        L58:
            return;
        L50:
            if (r117.isPlaying() == true) goto L51;
            return;
        L56:
            return;
        L35:
            if (r114 < r115) goto L42;
            Integer r119 = this.f109322a.f109307h.f109372a.getValue();
            if (r119 == null) goto L42;
            if (r119.intValue() != 1) goto L42;
            ALogger.i(this.f109322a.getLogTag(), "temp watch timeout，free duration: " + r113);
            this.f109322a.f109307h.c(2);
            this.f109322a.f109301b.setValue(0L);
            goto L43
        L30:
            r113 = -1;
            goto L31
        L19:
            if (r111.getLocalVisibleRect(new Rect()) != true) goto L25;
            FrameLayout r120 = r109.f109304e;
            if (r120 == null) goto L25;
            if (r120.isShown() != true) goto L25;
            r104 = true;
            goto L25
        }
    }

    static {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // kq1.b
    public final MutableLiveData<Integer> a() {
        return this.f109307h.f109372a;
    }

    public final com.bytedance.android.livesdk.chatroom.replay.paid.a f() {
        if (this.f109315p != null) goto L9;
        String r100 = this.f109305f;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        this.f109315p = new com.bytedance.android.livesdk.chatroom.replay.paid.d(r100);
    L9:
        return this.f109315p;
    }

    public final VideoContext g() {
        FrameLayout r100 = this.f109304e;
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L7:
        return VideoContext.n0(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return (LifecycleRegistry) this.f109317r.getValue();
    }

    public final String getLogTag() {
        return "PaidReplayLogTag PaidReplayPresenter" + hashCode();
    }

    public final void j() {
        ReplayPaidInfo r100 = this.f109302c;
        if (r100 != null) goto L5;
    L11:
        ReplayPaidInfo r101 = this.f109302c;
        if (r101 != null) goto L14;
    L16:
        Integer r102 = this.f109307h.f109372a.getValue();
        if (r102 != null) goto L20;
    L21:
        this.f109307h.c(1);
        return;
    L20:
        if (r102.intValue() != 2) goto L21;
        return;
    L14:
        if (r101.needDelivery() != true) goto L16;
        this.f109307h.c(3);
        return;
    L5:
        if (r100.isDelivery() != true) goto L11;
        ReplayPaidInfo r103 = this.f109302c;
        if (r103 == null) goto L11;
        if (r103.hasViewRight() != true) goto L11;
        this.f109307h.c(0);
    }

    public PaidReplayPresenter() {
        this.f109301b = new MutableLiveData();
        this.f109307h = new f0();
        this.f109314o = PaidSceneViewEntry.UNKNOWN;
        this.f109316q = new ConcurrentHashMap();
        this.f109317r = LazyKt.lazy(new PaidReplayPresenter$_lifecycle$2(this));
        this.f109318s = LazyKt.lazy(PaidReplayPresenter$paidLiveAPI$2.INSTANCE);
        this.f109319t = new d(this);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.livesdk.chatroom.replay.paid.b] */
    public final void i() {
        ALogger.i(getLogTag(), "reset variables");
        ALogger.i(getLogTag(), "stopProgressMonitor");
        VideoContext r100 = g();
        if (r100 == null) goto L5;
        r100.K0(this.f109319t);
    L5:
        this.f109302c = null;
        this.f109304e = null;
        this.f109305f = null;
        this.f109306g = null;
        ((LinkedHashMap) this.f109307h.f109374c).clear();
        ?? r101 = this.f109308i;
        if (r101 == 0) goto L8;
        r101.release();
    L8:
        this.f109308i = null;
        Disposable r102 = this.f109310k;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f109310k = null;
        Disposable r103 = this.f109311l;
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        this.f109311l = null;
        Disposable r104 = this.f109312m;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        this.f109312m = null;
        Disposable r105 = this.f109313n;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        this.f109313n = null;
        this.f109309j = null;
        ((LinkedHashMap) this.f109307h.f109374c).clear();
        this.f109307h.c(-1);
        com.bytedance.android.scope.j r106 = this.f109300a;
        if (r106 == null) goto L27;
        yq1.a r107 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r107 == null) goto L25;
        r107.d(r106, this.f109314o);
    L25:
        this.f109300a = null;
        return;
    }

    @Override // kq1.b
    public final void release() {
        ALogger.i(getLogTag(), "release");
        if (((LifecycleRegistry) this.f109317r.getValue()).getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L5;
        ((LifecycleRegistry) this.f109317r.getValue()).setCurrentState(Lifecycle.State.DESTROYED);
    L5:
        i();
    }

    @Override // kq1.b
    public final MutableLiveData<Long> getReplayPaidCountDown() {
        return this.f109301b;
    }

    public static final void e(PaidReplayPresenter r110) {
        ReplayPaidInfo r100 = r110.f109302c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.needDelivery() != true) goto L22;
        ReplayPaidInfo r101 = r110.f109302c;
        if (r101 == null) goto L20;
        TicketData r102 = r101.getTicketData();
        if (r102 == null) goto L21;
        String r103 = String.valueOf(r102.getTicketId());
        if (r103 == null) goto L23;
        ALogger.i(r110.getLogTag(), "start delivery ping, ticketId: ".concat(r103));
        Disposable r104 = r110.f109311l;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        r110.f109311l = ReplayPaidApi.a.a((ReplayPaidApi) r110.f109318s.getValue(), r103, 5, System.currentTimeMillis() / 1000, 0, 0, 97).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(r110), new x(r110));
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // kq1.b
    public final long c(long r100) {
        ALogger.i(getLogTag(), "computeProgressForPaid initProgress: " + r100);
        return r100;
    }

    public final void h(String r110) {
        ALogger.i(getLogTag(), "request ping  ticket id : " + r110);
        Disposable r100 = this.f109310k;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f109310k = ReplayPaidApi.a.a((ReplayPaidApi) this.f109318s.getValue(), r110, 4, System.currentTimeMillis() / 1000, 0, 0, 97).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
    public final void onFreePlayCountDown(long r100) {
        this.f109301b.setValue(Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.replay.PaidReplayCallback
    public final void onStateUpdate(int r100) {
        if (r100 != 0) goto L5;
        this.f109307h.c(1);
        return;
    L5:
        if (r100 == 1) goto L9;
        if (r100 != 2) goto L14;
        this.f109307h.c(0);
        return;
    L14:
        return;
    L9:
        this.f109307h.c(2);
    }

    @Override // kq1.b
    public final void setOnBuyTicketAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f109309j = r100;
        yq1.a r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r101 == null) goto L6;
        r101.x(this.f109300a, r100);
        return;
    }

    public final void k(int r100, int r101) {
        ALogger.i(getLogTag(), "updateReplayPaidInfo, viewRight: " + r100 + ", delivery: " + r101);
        ReplayPaidInfo r102 = this.f109302c;
        if (r102 == null) goto L6;
        r102.setViewRight(r100);
        r102.setDelivery(r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.livesdk.chatroom.replay.paid.b] */
    @Override // kq1.b
    public final void b(FrameLayout r110, ReplayPaidInfo r111, @PaidReplayScene String r112, Map<String, String> r113, vlc.d r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r112, "playerScene");
        Intrinsics.checkNotNullParameter(r113, "mobParams");
        ALogger.i(getLogTag(), "bind PaidInfo");
        i();
        if (r111 != null) goto L7;
        ALogger.i(getLogTag(), "replayPaidInfo is null.");
        return;
    L7:
        if (r111.isPaidEpisode() == true) goto L10;
        ALogger.i(getLogTag(), "replayPaidInfo is not paid episode.");
        return;
    L10:
        this.f109305f = r112;
        this.f109304e = r110;
        this.f109302c = r111;
        this.f109303d = r210;
        Map<String, String> r100 = MapsKt.toMutableMap(r113);
        this.f109306g = r100;
        if (r100 == null) goto L27;
        TicketData r101 = r111.getTicketData();
        String r102 = "";
        if (r101 == null) goto L16;
        String r103 = String.valueOf(r101.getTicketId());
        if (r103 == null) goto L16;
    L17:
        r100.put("ticket_id", r103);
        TicketData r104 = r111.getTicketData();
        if (r104 == null) goto L21;
        String r105 = r104.getTicketCategoryLogStr();
        if (r105 == null) goto L21;
    L22:
        r100.put("ticket_type", r105);
        String r106 = String.valueOf(r111.getFreeDuration());
        if (r106 == null) goto L26;
        r102 = r106;
    L26:
        r100.put("try_duration", r102);
    L21:
        r105 = "";
    L16:
        r103 = "";
    L27:
        this.f109316q.put(r112, Boolean.valueOf(r211));
        com.bytedance.android.scope.j r107 = this.f109300a;
        AttributeSet r108 = null;
        if ((r107 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.scope.b) == true) goto L30;
        r107 = null;
    L30:
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r109 = (com.bytedance.android.livesdk.vscore_api.paidlive.scope.b) r107;
        if (r109 == null) goto L52;
        switch(r112.hashCode()) {
            case -539748537: goto L45;
            case 863108557: goto L42;
            case 885887451: goto L39;
            case 1910904673: goto L36;
            default: goto L47;
        };
    L47:
        PaidSceneViewEntry r114 = PaidSceneViewEntry.REPLAY_SEARCH;
    L48:
        yq1.a r115 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r115 == null) goto L52;
        r115.R(r109, r114, r211);
        goto L52
    L36:
        if (r112.equals("lvideo_theater") == false) goto L47;
        r114 = PaidSceneViewEntry.REPLAY_LVIDEO_THEATER;
        goto L48
    L39:
        if (r112.equals("ml_video") == false) goto L47;
        r114 = PaidSceneViewEntry.REPLAY_ML_VIDEO;
        goto L48
    L42:
        if (r112.equals("lynx_view") == false) goto L47;
        r114 = PaidSceneViewEntry.REPLAY_LYNX_VIEW;
        goto L48
    L45:
        if (r112.equals("search_card") == false) goto L47;
        r114 = PaidSceneViewEntry.REPLAY_SEARCH;
    L52:
        yq1.a r116 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        int r117 = 0;
        if (r116 == null) goto L70;
        fq1.a r118 = fq1.b.a();
        if (r118 == null) goto L59;
        IMainEpisode r119 = r118.a();
        if (r119 == null) goto L59;
        PrivilegeInfo r120 = r119.subscribeReplayInfo();
    L60:
        if (r120 == null) goto L62;
        boolean r121 = true;
    L64:
        if (yq1.a.C8372a.a(r116, null, Boolean.valueOf(r121), 1) != true) goto L70;
        ALogger.i(getLogTag(), "startProgressMonitor");
        VideoContext r122 = g();
        if (r122 == null) goto L102;
        r122.D0(this.f109319t);
        return;
    L102:
        return;
    L62:
        r121 = false;
    L59:
        r120 = null;
    L70:
        if (this.f109308i != null) goto L92;
        String r123 = this.f109305f;
        int r124 = 6;
        if (r123 == null) goto L90;
        int r125 = r123.hashCode();
        if (r125 == (-539748537)) goto L88;
        if (r125 == 885887451) goto L85;
        if (r125 != 1910904673) goto L90;
        if (r123.equals("lvideo_theater") == false) goto L90;
        ConstraintLayout r126 = new ReplayLVideoTheaterBlockView(r110.getContext(), null, 0, r211, 6);
    L91:
        this.f109308i = r126;
        goto L92
    L85:
        if (r123.equals("ml_video") == false) goto L90;
        r126 = new ReplayMLVideoBlockView(r110.getContext(), r108, r124, r117);
        goto L91
    L88:
        if (r123.equals("search_card") == false) goto L90;
        r126 = new ReplaySearchBlockView(r110.getContext(), r108, r124, r117);
    L90:
        r126 = new ReplaySearchBlockView(r110.getContext(), r108, r124, r117);
    L92:
        ?? r127 = this.f109308i;
        if (r127 == 0) goto L95;
        r127.N(r110);
    L95:
        f0 r128 = this.f109307h;
        LinkedHashMap r129 = new LinkedHashMap();
        r129.put(1, CollectionsKt.listOf(new s(this)));
        r129.put(3, CollectionsKt.listOf(new t(this)));
        r129.put(2, CollectionsKt.listOf(new u(this)));
        r129.put(0, CollectionsKt.listOf(new v(this)));
        Unit r130 = Unit.INSTANCE;
        r128.getClass();
        Intrinsics.checkNotNullParameter(r129, "map");
        Iterator r131 = r129.entrySet().iterator();
    L97:
        if (r131.hasNext() == false) goto L99;
        Map.Entry r132 = (Map.Entry) r131.next();
        f0.b(r128.f109374c, ((Number) r132.getKey()).intValue()).addAll((Collection) r132.getValue());
        goto L97
    L99:
        j();
    }
}
