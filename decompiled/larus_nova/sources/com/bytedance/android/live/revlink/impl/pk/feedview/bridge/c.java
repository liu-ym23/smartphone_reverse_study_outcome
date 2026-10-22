package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkStateMachine;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.q;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.e3;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.j;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.t1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.util.e;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements w, t, d, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedPkBridgePresenter f96454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f96455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f96456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Integer> f96457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<l> f96458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> f96459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<String> f96460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<q11.a> f96461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<String> f96462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<String> f96463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f96464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f96465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f96466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CountDownTimerC1476c f96467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList<f4> f96468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedList<f4> f96469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r f96470q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b f96471r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FeedPkStateMachine f96472s;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/feedview/bridge/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdk/link/model/e1;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<e1> {
        public a() {
        }
    }

    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f96473a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f96473a;
            r r101 = r100.f96470q;
            if (r101 == null) goto L5;
            r101.f96619b = Boolean.FALSE;
        L5:
            if (r101 == null) goto L7;
            r101.f96618a = null;
        L7:
            r100.f96464k = false;
            r100.f96468o.remove();
            this.f96473a.f96471r.g();
            this.f96473a.n();
        }

        public b(c r100, long r101) {
            this.f96473a = r100;
            super(r101, 1000);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c$c, reason: collision with other inner class name */
    public static final class CountDownTimerC1476c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f96474a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f96474a;
            r r101 = r100.f96470q;
            if (r101 == null) goto L5;
            r101.f96621d = Boolean.FALSE;
        L5:
            if (r101 == null) goto L7;
            r101.f96620c = null;
        L7:
            r100.f96465l = false;
            r100.f96469p.remove();
            this.f96474a.f96471r.g();
            this.f96474a.o();
        }

        public CountDownTimerC1476c(c r100, long r101) {
            this.f96474a = r100;
            super(r101, 1000);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void e() {
    }

    public final void f() {
        b r100 = this.f96466m;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        CountDownTimerC1476c r101 = this.f96467n;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f96464k = false;
        LinkedList<f4> r102 = this.f96468o;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        this.f96465l = false;
        LinkedList<f4> r103 = this.f96469p;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        r r104 = this.f96470q;
        if (r104 == null) goto L18;
        Boolean r105 = Boolean.FALSE;
        r104.f96619b = r105;
        r104.f96618a = null;
        r104.f96620c = null;
        r104.f96621d = r105;
        return;
    }

    public final void n() {
        if (this.f96464k == false) goto L5;
        return;
    L5:
        f4 r100 = this.f96468o.peek();
        if (r100 != null) goto L8;
        return;
    L8:
        long r101 = e.b();
        if (r101 > r100.getStartTime()) goto L11;
        r101 = r100.getStartTime();
    L11:
        long r102 = r100.getEndTime() - r101;
        if (r102 >= 1000) goto L15;
        this.f96468o.remove();
        n();
        return;
    L15:
        r r103 = this.f96470q;
        if (r103 == null) goto L18;
        r103.f96618a = r100;
    L18:
        this.f96471r.f96669q = r103;
        b r104 = new b(this, r102);
        this.f96466m = r104;
        r104.start();
        this.f96464k = true;
        r r105 = this.f96470q;
        if (r105 == null) goto L22;
        r105.f96619b = Boolean.TRUE;
        return;
    }

    public final void o() {
        if (this.f96465l == false) goto L5;
        return;
    L5:
        f4 r100 = this.f96469p.peek();
        if (r100 != null) goto L8;
        return;
    L8:
        long r101 = e.b();
        if (r101 > r100.getStartTime()) goto L11;
        r101 = r100.getStartTime();
    L11:
        long r102 = r100.getEndTime() - r101;
        if (r102 >= 1000) goto L15;
        this.f96469p.remove();
        o();
        return;
    L15:
        r r103 = this.f96470q;
        if (r103 == null) goto L18;
        r103.f96620c = r100;
    L18:
        this.f96471r.f96669q = r103;
        CountDownTimerC1476c r104 = new CountDownTimerC1476c(this, r102);
        this.f96467n = r104;
        r104.start();
        this.f96465l = true;
        r r105 = this.f96470q;
        if (r105 == null) goto L22;
        r105.f96621d = Boolean.TRUE;
        return;
    }

    public static ModeType i(IBaseBattleSetting r100) {
        IBattleConfigSetting r101 = r100.getBattleConfigSetting();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getModType());
    L6:
        int r103 = PkBaseDataContext.PKModType.BreakThrough.ordinal();
        if (r102 != null) goto L10;
    L12:
        int r104 = PkBaseDataContext.PKModType.Vote.ordinal();
        if (r102 == null) goto L19;
        if (r102.intValue() != r104) goto L19;
        return ModeType.Vote;
    L19:
        return ModeType.PK;
    L10:
        if (r102.intValue() != r103) goto L12;
        return ModeType.BreakThough;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void a(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "effectInfo");
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r101 = this.f96471r;
        if ((r101.f96657e instanceof l.c) == false) goto L13;
        Long r102 = r101.f96671s;
        long r103 = r100.getBattleId();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.longValue() == r103) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r100.getBattleEffectInfo()) == true) goto L15;
        k(r100.getBattleEffectInfo());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void b(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r101 = this.f96471r;
        r101.f96665m = r100.getTeamTaskJson();
        this.f96460g.setValue(this.f96471r.f96665m);
        this.f96471r.g();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void c(k5 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ArrayList r101 = new ArrayList();
        List<t1> r102 = r100.getUserScores();
        if (r102 == null) goto L8;
        Iterator<t1> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r101.add(r103.next());
    L8:
        t41.a r104 = t41.a.f544564m;
        r104.getClass();
        if (((Boolean) t41.a.f544556e.getValue(r104, t41.a.f544552a[3])).booleanValue() == true) goto L11;
        return;
    L11:
        List<t1> r105 = r100.getUserScores();
        if (r105 == null) goto L14;
        IBattleBarConfig r106 = r100.getBattleBarConfig();
        IBaseUser r107 = r100.getFromUser();
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        r100.get_fromUserId();
        s(r105, r106, r107);
    L14:
        n3 r108 = r100.getBreakthroughInfo();
        if (r108 == null) goto L17;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r109 = this.f96471r;
        r109.f96667o = r108;
        r109.f96668p = r100.getUserScores();
        this.f96471r.f(3);
    L17:
        this.f96471r.g();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.q
    public final void d(int r100) {
        l r101 = this.f96472s.a();
        if ((r101 instanceof l.a) == false) goto L6;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r102 = this.f96471r;
        r102.f96657e = r101;
        r102.f96660h = Integer.valueOf(r100);
        this.f96471r.g();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.t
    public final void g(int r100) {
        this.f96457d.setValue(Integer.valueOf(r100));
        l r101 = this.f96472s.a();
        if ((r101 instanceof l.b) == false) goto L5;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r102 = this.f96471r;
        r102.f96657e = r101;
        r102.f96659g = Integer.valueOf(r100);
        this.f96471r.g();
    L5:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r103 = this.f96471r;
        if (r103.f96656d != ModeType.BreakThough) goto L9;
        r103.f(2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.w
    public final void h(int r100) {
        this.f96457d.setValue(Integer.valueOf(r100));
        l r101 = this.f96472s.a();
        if ((r101 instanceof l.c) == false) goto L5;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r102 = this.f96471r;
        r102.f96657e = r101;
        r102.f96659g = Integer.valueOf(r100);
        this.f96471r.g();
    L5:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r103 = this.f96471r;
        if (r103.f96656d != ModeType.BreakThough) goto L9;
        r103.f(2);
        return;
    }

    public final void k(String r100) {
        this.f96462i.setValue(r100);
        e1 r101 = (e1) GsonProtectorUtils.fromJson(GsonHelper.get(), r100, new a().getType());
        IRoom r102 = this.f96455b;
        if (r102 == null) goto L7;
        IBaseUser r103 = r102.getOwner();
        if (r103 == null) goto L7;
        String r104 = iz.a.a(r103);
    L8:
        if (r101 == null) goto L28;
        Map<String, j> r105 = r101.getAnchorEffectMap();
        if (r105 == null) goto L47;
        Iterator<Map.Entry<String, j>> r106 = r105.entrySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L48;
        Map.Entry<String, j> r107 = r106.next();
        String r108 = r107.getKey();
        j r109 = r107.getValue();
        if (TextUtils.equals(r108.toString(), r104) == true) goto L16;
        if (r109 == null) goto L13;
        List<f4> r110 = r109.getEffectList();
        if (r110 == null) goto L13;
        if (r110.size() < this.f96469p.size()) goto L13;
        this.f96469p.clear();
        this.f96469p.addAll(r110);
        o();
        goto L13
    L16:
        if (r109 == null) goto L13;
        List<f4> r111 = r109.getEffectList();
        if (r111 == null) goto L13;
        if (r111.size() < this.f96468o.size()) goto L13;
        this.f96468o.clear();
        this.f96468o.addAll(r111);
        n();
        goto L13
    L48:
        return;
    L47:
        return;
    L28:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void l(c3 r100) {
        long r101 = r100.getSkinType();
        this.f96471r.f96655c = Long.valueOf(r101);
        q(r100.getBattleUserInfoMap());
        r(r100.getBattleUserInfoMap());
        List<a1> r102 = r100.getBattleScorePairList();
        c1 r103 = r100.getBattleSetting();
        if (r103 == null) goto L5;
        IBattleBarConfig r104 = r103.getBarConfig();
    L6:
        s(r102, r104, null);
        String r105 = r100.getTeamTaskJson();
        this.f96471r.f96665m = r105;
        this.f96460g.setValue(r105);
        p(r100.getBattleSetting(), r100.getBreakthroughInfo(), r100.getBattleScorePairList());
        String r106 = r100.getBattleEffectInfo();
        if (TextUtils.isEmpty(r106) == true) goto L10;
        Intrinsics.checkNotNull(r106);
        k(r106);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void m(e3 r100) {
        long r101 = r100.getSkinType();
        this.f96471r.f96655c = Long.valueOf(r101);
        q(r100.getBattleUserInfoMap());
        r(r100.getBattleUserInfoMap());
        List<a1> r102 = r100.getBattleScorePairList();
        c1 r103 = r100.getBattleSetting();
        if (r103 == null) goto L5;
        IBattleBarConfig r104 = r103.getBarConfig();
    L6:
        s(r102, r104, null);
        String r105 = r100.getTeamTaskJson();
        this.f96471r.f96665m = r105;
        this.f96460g.setValue(r105);
        p(r100.getBattleSetting(), r100.getBreakthroughInfo(), r100.getBattleScorePairList());
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void q(Map<String, ? extends IBattleUserInfo> r100) {
        IRoom r101 = this.f96455b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L16;
        Iterator<Map.Entry<String, ? extends IBattleUserInfo>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<String, ? extends IBattleUserInfo> r103 = r102.next();
        String r104 = r103.getKey();
        IBaseUser r105 = r101.getOwner();
        if (r105 == null) goto L12;
        String r106 = iz.a.a(r105);
    L14:
        if ((!Intrinsics.areEqual(r104, r106)) == false) goto L8;
        this.f96471r.f96658f = r103.getValue();
        goto L8
    L12:
        r106 = null;
        goto L14
    L22:
        return;
    }

    public final void r(Map<String, ? extends IBattleUserInfo> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        IRoom r101 = this.f96455b;
        if (r101 == null) goto L44;
        IBaseUser r102 = r101.getOwner();
        if (r102 == null) goto L45;
        String r103 = iz.a.a(r102);
        if (r103 != null) goto L12;
        return;
    L12:
        if (r100.containsKey(r103) == false) goto L46;
        IBattleUserInfo r104 = r100.get(r103);
        if (r104 == null) goto L16;
        Integer r105 = Integer.valueOf(r104.getPkResult());
    L17:
        int r106 = IBattleUserInfo.PKResult.PKUnCompute.ordinal();
        if (r105 != null) goto L21;
    L23:
        int r107 = IBattleUserInfo.PKResult.PKVictory.ordinal();
        if (r105 != null) goto L27;
    L29:
        int r108 = IBattleUserInfo.PKResult.PKFail.ordinal();
        if (r105 != null) goto L33;
    L35:
        int r109 = IBattleUserInfo.PKResult.PKTie.ordinal();
        if (r105 != null) goto L39;
    L41:
        q11.a r110 = q11.a.d.f531270a;
    L42:
        this.f96471r.f96664l = r110;
        this.f96461h.setValue(r110);
        return;
    L39:
        if (r105.intValue() != r109) goto L41;
        r110 = q11.a.C7264a.f531267a;
        goto L42
    L33:
        if (r105.intValue() != r108) goto L35;
        r110 = q11.a.c.f531269a;
        goto L42
    L27:
        if (r105.intValue() != r107) goto L29;
        r110 = q11.a.b.f531268a;
        goto L42
    L21:
        if (r105.intValue() != r106) goto L23;
        r110 = q11.a.d.f531270a;
        goto L42
    L16:
        r105 = null;
        goto L17
    L46:
        return;
    L45:
        return;
    }

    public c(com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r100, FeedPkStateMachine r101) {
        Intrinsics.checkNotNullParameter(r100, "viewState");
        Intrinsics.checkNotNullParameter(r101, "machine");
        this.f96471r = r100;
        this.f96472s = r101;
        this.f96454a = new FeedPkBridgePresenter();
        this.f96457d = new MutableLiveData();
        this.f96458e = new MutableLiveData();
        this.f96459f = new MutableLiveData();
        this.f96460g = new MutableLiveData();
        this.f96461h = new MutableLiveData();
        this.f96462i = new MutableLiveData();
        this.f96463j = new MutableLiveData();
        this.f96468o = new LinkedList();
        this.f96469p = new LinkedList();
        this.f96470q = new r(null, null, null);
    }

    public final z31.d j(List r100, IBattleBarConfig r101, IBaseUser r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IRoom r103 = this.f96455b;
        if (r103 != null) goto L8;
        return null;
    L8:
        z31.d r104 = new z31.d();
        Iterator r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L22;
        af2.b r106 = (af2.b) r105.next();
        String r107 = af2.c.a(r106);
        IBaseUser r108 = r103.getOwner();
        if (r108 == null) goto L14;
        String r109 = iz.a.a(r108);
    L16:
        if (Intrinsics.areEqual(r107, r109) == true) goto L17;
        r104.f569863d = Integer.valueOf((int) af2.c.b(r106));
        r106.getScoreText();
        goto L10
    L17:
        r106.getScoreRelativeText();
        r104.f569860a = Integer.valueOf((int) af2.c.b(r106));
        r104.f569861b = r101;
        if ((r106 instanceof t1) == false) goto L20;
        t1 r110 = (t1) r106;
        r110.getCurAddScoreText();
        r104.f569862c = r102;
        r110.getBuffScoreRatio();
    L20:
        r106.getScoreText();
        goto L10
    L14:
        r109 = null;
        goto L16
    L22:
        return r104;
    }

    public final void p(c1 r100, n3 r101, List<? extends a1> r102) {
        if (r100 == null) goto L5;
        long r103 = r100.getFinished();
    L6:
        m3 r104 = null;
        if (r103 <= 0) goto L13;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r105 = this.f96471r;
        if (r100 == null) goto L11;
        h3 r106 = r100.getPunishConfig();
    L12:
        r105.f96661i = r106;
    L18:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r107 = this.f96471r;
        if (r100 == null) goto L23;
        IBattleConfigSetting r108 = r100.getBattleConfigSetting();
        if (r108 == null) goto L23;
        r104 = r108.getBreakthroughConfig();
    L23:
        r107.f96666n = r104;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r109 = this.f96471r;
        r109.f96667o = r101;
        r109.f96668p = r102;
        return;
    L11:
        r106 = null;
        goto L12
    L13:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r110 = this.f96471r;
        if (r100 == null) goto L16;
        h3 r111 = r100.getTitleConfig();
    L17:
        r110.f96661i = r111;
        goto L18
    L16:
        r111 = null;
        goto L17
    L5:
        r103 = 0;
        goto L6
    }

    public final void s(List r100, IBattleBarConfig r101, IBaseUser r102) {
        if (this.f96455b != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r103 = this.f96471r;
        r103.f96662j = j(r100, r101, r102);
        this.f96459f.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r100, this.f96471r.f96667o, 0));
    }
}
