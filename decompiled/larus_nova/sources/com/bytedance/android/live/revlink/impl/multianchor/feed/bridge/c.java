package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.g;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h;
import com.bytedance.android.live.revlink.impl.multianchor.pk.team.TeamStatus;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.j;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.t1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements w, t, e, y21.c, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d {
    public final LinkedList<f4> A;
    public f B;
    public final r C;
    public Map<String, ? extends b8> D;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c E;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedMultiBridgePresenter f94132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u21.a f94133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u21.b f94134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u21.c f94135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f94136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f94137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IBaseBattleSetting f94138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Integer> f94139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<PlayMode> f94140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Long> f94141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<Long> f94142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Long> f94143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> f94144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData<Integer> f94145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<String> f94146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<String> f94147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f94148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.b f94149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, ? extends IBattleUserInfo> f94150s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public IRoom f94151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f94152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f94153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f94154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CountDownTimer f94155x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f94156y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentLinkedQueue<f> f94157z;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/feed/bridge/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdk/link/model/e1;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<e1> {
        public a() {
        }
    }

    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f94158a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f94158a;
            r r101 = r100.C;
            if (r101 == null) goto L5;
            r101.f96619b = Boolean.FALSE;
        L5:
            if (r101 == null) goto L7;
            r101.f96618a = null;
        L7:
            r100.f94153v = false;
            r100.f94157z.remove(r100.B);
            this.f94158a.F.d();
            this.f94158a.k();
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            this.f94158a.k();
        }

        public b(long r100, c r101) {
            this.f94158a = r101;
            super(r100, 1000);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c$c, reason: collision with other inner class name */
    public static final class CountDownTimerC1453c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f94159a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f94159a;
            r r101 = r100.C;
            if (r101 == null) goto L5;
            r101.f96619b = Boolean.FALSE;
        L5:
            if (r101 == null) goto L7;
            r101.f96618a = null;
        L7:
            r100.f94152u = false;
            r100.f94157z.remove(r100.B);
            this.f94159a.F.d();
            this.f94159a.k();
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            this.f94159a.k();
        }

        public CountDownTimerC1453c(long r100, c r101) {
            this.f94159a = r101;
            super(r100, 1000);
        }
    }

    public static final class d extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f94160a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f94160a;
            r r101 = r100.C;
            if (r101 == null) goto L5;
            r101.f96621d = Boolean.FALSE;
        L5:
            if (r101 == null) goto L7;
            r101.f96620c = null;
        L7:
            r100.f94154w = false;
            if ((!r100.A.isEmpty()) == false) goto L10;
            this.f94160a.A.remove();
        L10:
            this.f94160a.F.d();
            this.f94160a.l();
        }

        public d(c r100, long r101) {
            this.f94160a = r100;
            super(r101, 1000);
        }
    }

    public final void i() {
        CountDownTimer r100 = this.f94155x;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        d r101 = this.f94156y;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.B = null;
        this.f94152u = false;
        this.f94153v = false;
        ConcurrentLinkedQueue<f> r102 = this.f94157z;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        this.f94154w = false;
        LinkedList<f4> r103 = this.A;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        r r104 = this.C;
        if (r104 == null) goto L18;
        Boolean r105 = Boolean.FALSE;
        r104.f96619b = r105;
        r104.f96618a = null;
        r104.f96620c = null;
        r104.f96621d = r105;
        return;
    }

    public final void k() {
        if (this.f94157z.isEmpty() == false) goto L5;
        return;
    L5:
        long r100 = com.bytedance.live.kmp.util.e.b();
        Iterator<f> r101 = this.f94157z.iterator();
    L7:
        if (r101.hasNext() == false) goto L53;
        f r102 = r101.next();
        f4 r103 = r102.f94163b;
        if (r100 > r103.getStartTime()) goto L11;
        long r104 = r103.getStartTime();
    L12:
        long r105 = r103.getEndTime() - r104;
        if (r105 < 1000) goto L14;
        if (r100 < r103.getStartTime()) goto L7;
        if (r100 < r103.getStartTime()) goto L7;
        if (r100 > r103.getEndTime()) goto L7;
        if (r102.f94162a == true) goto L25;
        if (this.f94153v == true) goto L7;
        boolean r106 = this.f94152u;
        if (r106 == true) goto L7;
        if (r106 == true) goto L7;
        CountDownTimer r107 = this.f94155x;
        if (r107 == null) goto L45;
        r107.cancel();
    L45:
        this.B = r102;
        CountDownTimerC1453c r108 = new CountDownTimerC1453c(r105, this);
        this.f94155x = r108;
        r108.start();
        this.f94152u = true;
        r r109 = this.C;
        if (r109 == null) goto L48;
        r109.f96619b = Boolean.TRUE;
    L48:
        if (r109 == null) goto L50;
        r109.f96618a = r103;
    L50:
        if (r109 == null) goto L52;
        r109.f96622e = Boolean.FALSE;
    L52:
        this.F.getClass();
        goto L7
    L25:
        if (this.f94153v == true) goto L7;
        CountDownTimer r110 = this.f94155x;
        if (r110 == null) goto L29;
        r110.cancel();
    L29:
        this.B = r102;
        b r111 = new b(r105, this);
        this.f94155x = r111;
        r111.start();
        this.f94153v = true;
        this.f94152u = false;
        r r112 = this.C;
        if (r112 == null) goto L32;
        r112.f96619b = Boolean.TRUE;
    L32:
        if (r112 == null) goto L34;
        r112.f96618a = r103;
    L34:
        if (r112 == null) goto L36;
        r112.f96622e = Boolean.TRUE;
    L36:
        this.F.getClass();
        goto L7
    L14:
        this.f94157z.remove(r102);
        k();
        goto L7
    L11:
        r104 = r100;
        goto L12
    }

    public final void l() {
        if (this.f94154w == false) goto L5;
        return;
    L5:
        f4 r100 = this.A.peek();
        if (r100 != null) goto L8;
        return;
    L8:
        long r101 = com.bytedance.live.kmp.util.e.b();
        if (r101 > r100.getStartTime()) goto L11;
        r101 = r100.getStartTime();
    L11:
        long r102 = r100.getEndTime() - r101;
        if (r102 >= 1000) goto L15;
        this.A.remove();
        l();
        return;
    L15:
        r r103 = this.C;
        if (r103 == null) goto L18;
        r103.f96620c = r100;
    L18:
        this.F.getClass();
        d r104 = new d(this, r102);
        this.f94156y = r104;
        r104.start();
        this.f94154w = true;
        r r105 = this.C;
        if (r105 == null) goto L22;
        r105.f96621d = Boolean.TRUE;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void a(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "effectInfo");
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r101 = this.F;
        if ((r101.f94283c instanceof x21.d.c) == false) goto L13;
        Long r102 = r101.f94293m;
        long r103 = r100.getBattleId();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.longValue() == r103) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r100.getBattleEffectInfo()) == true) goto L15;
        j(r100.getBattleEffectInfo());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void b(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((this.E.f94226a.b() instanceof x21.d.c) == false) goto L6;
        this.f94146o.setValue(r100.getTeamTaskJson());
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void c(k5 r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        x21.d r100 = this.E.f94226a.b();
        List<t1> r101 = r110.getUserScores();
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof x21.d.c) == false) goto L98;
        n3 r102 = r110.getBreakthroughInfo();
        if (r102 == null) goto L10;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r103 = this.F;
        r103.f94291k = r102;
        r103.f94292l = r110.getUserScores();
        this.F.c(3);
    L10:
        u21.a r104 = this.f94133b;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r105 = this.F.f94285e;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "newScoreList");
        u41.c r106 = u41.c.f548662f;
        r106.getClass();
        if (((Boolean) u41.c.f548658b.getValue(r106, u41.c.f548657a[0])).booleanValue() == false) goto L51;
        HashMap r107 = new HashMap();
        if ((r105 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) == false) goto L27;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r108 = ((com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) r105).f94297a;
        if (r108 != null) goto L18;
        r108 = MapsKt.emptyMap();
    L18:
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c>> r109 = r108.entrySet().iterator();
    L20:
        if (r109.hasNext() == false) goto L27;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r111 = r109.next();
        String r112 = r111.getKey();
        Integer r113 = r111.getValue().f94296a;
        if (r113 == null) goto L24;
        int r114 = r113.intValue();
    L25:
        r107.put(r112, Integer.valueOf(r114));
        goto L20
    L24:
        r114 = 0;
    L27:
        if ((r105 instanceof h) == false) goto L40;
        Map<String, g> r115 = ((h) r105).f94306b;
        if (r115 != null) goto L31;
        r115 = MapsKt.emptyMap();
    L31:
        Iterator<Map.Entry<String, g>> r116 = r115.entrySet().iterator();
    L33:
        if (r116.hasNext() == false) goto L40;
        Map.Entry<String, g> r117 = r116.next();
        String r118 = r117.getKey();
        Integer r119 = r117.getValue().f94304a;
        if (r119 == null) goto L37;
        int r120 = r119.intValue();
    L38:
        r107.put(r118, Integer.valueOf(r120));
        goto L33
    L37:
        r120 = 0;
    L40:
        if (r107.isEmpty() == true) goto L51;
        Iterator<t1> r121 = r101.iterator();
    L44:
        if (r121.hasNext() == false) goto L52;
        t1 r122 = r121.next();
        String r123 = af2.c.a(r122);
        long r124 = af2.c.b(r122);
        Integer r125 = (Integer) r107.get(r123);
        if (r125 == null) goto L48;
        int r126 = r125.intValue();
    L50:
        if (r124 <= r126) goto L44;
    L48:
        r126 = 0;
        goto L50
    L52:
        boolean r127 = false;
    L53:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r128 = null;
        if (r127 == false) goto L84;
        FeedMultiPlayMode r129 = this.F.f94284d;
        if (r129 == null) goto L84;
        int r130 = com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.a.f94130c[r129.ordinal()];
        if (r130 != 1) goto L62;
    L76:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r131 = this.F;
        u21.b r132 = this.f94134c;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r133 = r131.f94285e;
        r132.getClass();
        Intrinsics.checkNotNullParameter(r101, "newScoreList");
        if ((r133 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) == true) goto L79;
        r133 = null;
    L79:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d r134 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) r133;
        if (r134 != null) goto L82;
        r134 = null;
    L83:
        r131.f94285e = r134;
        goto L84
    L82:
        r134.f94297a = u21.b.a(r101);
        goto L83
    L62:
        if (r130 == 2) goto L76;
        if (r130 != 3) goto L84;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r135 = this.F;
        u21.c r136 = this.f94135d;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r137 = r135.f94285e;
        r136.getClass();
        Intrinsics.checkNotNullParameter(r101, "newScoreList");
        if ((r137 instanceof h) == true) goto L68;
        r137 = null;
    L68:
        h r138 = (h) r137;
        if (r138 == null) goto L73;
        Map<String, Long> r139 = r138.f94305a;
        if (r139 == null) goto L73;
        Map<String, g> r140 = r136.c(r139, r101);
        r138.f94307c = r136.b(r139, r101);
        r138.f94306b = r140;
    L75:
        r135.f94285e = r138;
    L73:
        r138 = null;
    L84:
        this.F.d();
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r141 = this.f94144m;
        List<t1> r142 = r110.getUserScores();
        if (r142 == null) goto L87;
        r128 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r142, null, 0);
    L87:
        r141.setValue(r128);
        return;
    L51:
        r127 = true;
        goto L53
    }

    @Override // y21.c
    public final void d(int r100) {
        x21.d r101 = this.E.f94226a.b();
        if ((r101 instanceof x21.d.a) == false) goto L6;
        this.F.f94283c = r101;
        this.f94141j.setValue(Long.valueOf(r100));
        this.F.d();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d
    public final void e(long r100) {
        this.f94143l.setValue(Long.valueOf(r100));
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), "interact_timer_count") == false) goto L5;
        return;
    L5:
        this.f94147p.setValue(String.valueOf((System.currentTimeMillis() - r100) / ((long) 1000)));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d
    public final void f(Map<String, ? extends b8> r100) {
        this.D = r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.t
    public final void g(int r100) {
        x21.d r101 = this.E.f94226a.b();
        if ((r101 instanceof x21.d.b) == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r102 = this.F;
        r102.f94283c = r101;
        r102.f94287g = Integer.valueOf(r100);
        this.F.d();
        this.f94142k.setValue(Long.valueOf(r100));
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r103 = this.F;
        if (r103.f94284d != FeedMultiPlayMode.BREAK_THROUGH) goto L9;
        r103.c(2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.w
    public final void h(int r100) {
        x21.d r101 = this.E.f94226a.b();
        if ((r101 instanceof x21.d.c) == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r102 = this.F;
        r102.f94283c = r101;
        r102.f94287g = Integer.valueOf(r100);
        this.F.d();
        this.f94142k.setValue(Long.valueOf(r100));
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r103 = this.F;
        if (r103.f94284d != FeedMultiPlayMode.BREAK_THROUGH) goto L9;
        r103.c(2);
        return;
    }

    public final void j(String r100) {
        if (this.F.f94284d == FeedMultiPlayMode.TEAM_PK) goto L5;
        return;
    L5:
        e1 r101 = (e1) GsonProtectorUtils.fromJson(GsonHelper.get(), r100, new a().getType());
        IRoom r102 = this.f94151t;
        if (r102 == null) goto L10;
        IBaseUser r103 = r102.getOwner();
        if (r103 == null) goto L10;
        String r104 = iz.a.a(r103);
    L11:
        this.f94157z.clear();
        this.A.clear();
        if (r101 == null) goto L14;
        Map<String, j> r105 = r101.getAnchorEffectMap();
    L15:
        if (r105 != null) goto L17;
        return;
    L17:
        Map<String, j> r106 = r101.getAnchorEffectMap();
        Intrinsics.checkNotNull(r106);
        Iterator<Map.Entry<String, j>> r107 = r106.entrySet().iterator();
    L19:
        if (r107.hasNext() == false) goto L55;
        Map.Entry<String, j> r108 = r107.next();
        String r109 = r108.getKey();
        j r110 = r108.getValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r111 = this.F.f94285e;
        if ((r111 instanceof h) == true) goto L23;
        r111 = null;
    L23:
        h r112 = (h) r111;
        if (r112 == null) goto L28;
        Map<String, Long> r113 = r112.f94305a;
        if (r113 == null) goto L28;
        u21.c r114 = this.f94135d;
        String r115 = r109.toString();
        r114.getClass();
        TeamStatus r116 = u21.c.d(r104, r115, r113);
    L30:
        if (r116 == TeamStatus.LEFT) goto L31;
        if (r110 == null) goto L19;
        List<f4> r117 = r110.getEffectList();
        if (r117 == null) goto L19;
        Iterator<T> r118 = r117.iterator();
    L51:
        if (r118.hasNext() == false) goto L19;
        f4 r119 = (f4) r118.next();
        if (r119.getEffectType() != 1) goto L51;
        this.A.add(r119);
        goto L51
    L31:
        if (r110 == null) goto L19;
        List<f4> r120 = r110.getEffectList();
        if (r120 == null) goto L19;
        if (TextUtils.equals(r109.toString(), r104) == true) goto L36;
        Iterator<T> r121 = r120.iterator();
    L42:
        if (r121.hasNext() == false) goto L19;
        f4 r122 = (f4) r121.next();
        if (r122.getEffectType() != 1) goto L42;
        this.f94157z.add(new f(false, r122));
        goto L42
    L36:
        Iterator<T> r123 = r120.iterator();
    L38:
        if (r123.hasNext() == false) goto L19;
        this.f94157z.add(new f(true, (f4) r123.next()));
    L28:
        r116 = null;
        goto L30
    L55:
        k();
        l();
        return;
    L14:
        r105 = null;
    L10:
        r104 = null;
        goto L11
    }

    public final void m(c3 r100) {
        c1 r101 = r100.getBattleSetting();
        if (r101 == null) goto L5;
        long r102 = r101.getFinished();
    L6:
        m3 r103 = null;
        if (r102 <= 0) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r104 = this.F;
        c1 r105 = r100.getBattleSetting();
        if (r105 == null) goto L11;
        h3 r106 = r105.getPunishConfig();
    L12:
        r104.f94289i = r106;
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r107 = this.F;
        c1 r108 = r100.getBattleSetting();
        if (r108 == null) goto L23;
        IBattleConfigSetting r109 = r108.getBattleConfigSetting();
        if (r109 == null) goto L23;
        r103 = r109.getBreakthroughConfig();
    L23:
        r107.f94290j = r103;
        this.F.f94291k = r100.getBreakthroughInfo();
        this.F.f94292l = r100.getBattleScorePairList();
        return;
    L11:
        r106 = null;
        goto L12
    L13:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r110 = this.F;
        c1 r111 = r100.getBattleSetting();
        if (r111 == null) goto L16;
        h3 r112 = r111.getTitleConfig();
    L17:
        r110.f94289i = r112;
        goto L18
    L16:
        r112 = null;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public c(z21.a r100, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r101, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "machine");
        Intrinsics.checkNotNullParameter(r102, "viewState");
        this.E = r101;
        this.F = r102;
        this.f94132a = new FeedMultiBridgePresenter(r100);
        this.f94133b = new u21.a(r100);
        this.f94134c = new u21.b();
        this.f94135d = new u21.c(r100);
        this.f94139h = new MutableLiveData();
        this.f94140i = new MutableLiveData();
        this.f94141j = new MutableLiveData();
        this.f94142k = new MutableLiveData();
        this.f94143l = new MutableLiveData();
        this.f94144m = new MutableLiveData();
        this.f94145n = new MutableLiveData();
        this.f94146o = new MutableLiveData();
        this.f94147p = new MutableLiveData();
        this.f94157z = new ConcurrentLinkedQueue();
        this.A = new LinkedList();
        this.C = new r(null, null, null);
    }
}
