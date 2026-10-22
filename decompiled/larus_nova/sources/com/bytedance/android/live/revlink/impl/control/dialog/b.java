package com.bytedance.android.live.revlink.impl.control.dialog;

import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.utils.x;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f92346r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f92347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f92348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f92349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f92350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f92351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f92352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f92353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f92354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<e> f92355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseArray<f> f92356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseArray<Long> f92357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArraySet<String> f92358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayMap<String, e> f92359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayMap<String, f> f92360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayMap<String, Long> f92361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f92362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f92363q;

    public static final class a {
        public static boolean a() {
            return b51.b.f17721c0.i().getEnable();
        }

        public static b b() {
            LinkRevPanelDataContext r100 = LinkRevPanelDataContext.Companion.getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<b> r101 = r100.getLoader();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.control.dialog.b$b, reason: collision with other inner class name */
    public static final class C1437b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f92364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f92365b;

        public C1437b(b r100, String r101) {
            this.f92364a = r100;
            this.f92365b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            b r102 = this.f92364a;
            List<y7> r103 = ((IRivalRankRecommendResponse) r101.data).getSubTabs();
            Map<String, String> r104 = null;
            if (r103 == null) goto L19;
            Iterator<T> r105 = r103.iterator();
        L6:
            if (r105.hasNext() == false) goto L14;
            T r106 = r105.next();
            IPkSubTabKey r107 = ((y7) r106).getKey();
            if (r107 == null) goto L10;
            String r108 = r107.getActivityId();
        L12:
            if (Intrinsics.areEqual(r108, this.f92365b) == false) goto L6;
        L15:
            y7 r109 = (y7) r106;
            if (r109 == null) goto L19;
            String r110 = r109.getTrackingInfo();
            if (r110 == null) goto L19;
        L20:
            r102.getClass();
            r104 = JsonUtil.jsonObjectToMap(new JSONObject(r110));     // Catch: Exception -> L24
        L23:
            return new Pair(r101, r104);
        L10:
            r108 = null;
            goto L12
        L14:
            r106 = null;
        L19:
            r110 = "";
            goto L20
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f92366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f92367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f92368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f92369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f92370e;

        public c(b r100, String r101, long r102, int r103, String r104) {
            this.f92366a = r100;
            this.f92367b = r101;
            this.f92368c = r102;
            this.f92369d = r103;
            this.f92370e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Pair r100 = (Pair) r110;
            b r101 = this.f92366a;
            String r102 = this.f92367b;
            r101.getClass();
            boolean r103 = true;
            if (Intrinsics.areEqual(r102, UploadTypeInf.TIMER) == false) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == true) goto L13;
            LiveFullLinkPKMonitor r105 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r105 == null) goto L13;
            LiveFullLinkPKMonitor.s(r105, "battle/rivals/recommend", System.currentTimeMillis() - this.f92368c, this.f92369d, 0, null, 24);
        L13:
            this.f92366a.f92358l.remove(b.k(this.f92369d, this.f92370e));
            if (r100 == null) goto L122;
            ExtraResponse r106 = (ExtraResponse) r100.getFirst();
            if (r106 == null) goto L123;
            IRivalRankRecommendResponse r111 = (IRivalRankRecommendResponse) r106.data;
            if (r111 == null) goto L124;
            int r107 = x.f97681a;
            if (x.a(this.f92370e, this.f92369d) == false) goto L26;
            e r108 = new e(this.f92369d, this.f92370e, r111, this.f92368c, System.currentTimeMillis(), (Map) r100.getSecond());
            this.f92366a.f92359m.put(this.f92370e, r108);
            LinkRevPanelDataContext r109 = b.b(this.f92366a);
            if (r109 == null) goto L125;
            com.bytedance.live.datacontext.k<Pair<String, e>> r112 = r109.getLoadCompleteEvent();
            if (r112 == null) goto L126;
            r112.post(new Pair(b.c(this.f92366a, this.f92367b), r108));
            return;
        L126:
            return;
        L125:
            return;
        L26:
            int r113 = (int) r111.getLoadType();
            IRivalRankRecommendResponse.LoadType r114 = IRivalRankRecommendResponse.LoadType.All;
            if (r113 != r114.ordinal()) goto L96;
            if (Intrinsics.areEqual(this.f92367b, "init") == false) goto L31;
        L32:
            LinkRevPanelDataContext r115 = b.b(this.f92366a);
            if (r115 == null) goto L35;
            r115.setAbValueMap(r111.getListAbValueMap());
        L35:
            this.f92366a.getClass();
            s2 r116 = r111.getTabRivals();
            Triple r117 = null;
            HashMap r118 = null;
            if (r116 == null) goto L38;
            Map<Long, IGroupRivals> r119 = r116.getGroupRivals();
        L39:
            if (r119 != null) goto L41;
        L44:
            boolean r120 = true;
        L45:
            if (r120 == true) goto L60;
            vh7.c r121 = vh7.f.c(IRivalRankRecommendResponse.class);
            IRivalRankRecommendResponse r122 = (IRivalRankRecommendResponse) r121;
            r122.setLoadType(IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal());
            r122.setTabRivals((s2) vh7.f.c(s2.class));
            s2 r123 = r122.getTabRivals();
            if (r123 == null) goto L53;
            IGroupRivals.GroupType r124 = IGroupRivals.GroupType.GroupFeedRecommend;
            IGroupRivals r125 = r119.get(Long.valueOf(r124.ordinal()));
            if (r125 == null) goto L51;
            HashMap r126 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Long.valueOf(r124.ordinal()), r125)});
        L52:
            r123.setGroupRivals(r126);
            goto L53
        L51:
            r126 = null;
        L53:
            Unit r127 = Unit.INSTANCE;
            vh7.c r128 = vh7.f.c(IRivalRankRecommendResponse.class);
            IRivalRankRecommendResponse r129 = (IRivalRankRecommendResponse) r128;
            r129.setLoadType(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
            r129.setTabRivals((s2) vh7.f.c(s2.class));
            s2 r130 = r129.getTabRivals();
            if (r130 == null) goto L59;
            IGroupRivals.GroupType r131 = IGroupRivals.GroupType.GroupFeedFollowed;
            IGroupRivals r132 = r119.get(Long.valueOf(r131.ordinal()));
            if (r132 == null) goto L58;
            r118 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Long.valueOf(r131.ordinal()), r132)});
        L58:
            r130.setGroupRivals(r118);
        L59:
            r117 = new Triple(r111, r121, r128);
        L60:
            if (r117 == null) goto L94;
            e r133 = b.d(this.f92366a, this.f92370e, IRivalRankRecommendResponse.LoadType.Other.ordinal(), (IRivalRankRecommendResponse) r117.getFirst(), this.f92368c);
            if (r133 == null) goto L68;
            LinkRevPanelDataContext r134 = b.b(this.f92366a);
            if (r134 == null) goto L68;
            com.bytedance.live.datacontext.k<Pair<String, e>> r135 = r134.getLoadCompleteEvent();
            if (r135 == null) goto L68;
            r135.post(new Pair(b.c(this.f92366a, this.f92367b), r133));
        L68:
            e r136 = b.d(this.f92366a, this.f92370e, IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal(), (IRivalRankRecommendResponse) r117.getSecond(), this.f92368c);
            if (r136 == null) goto L75;
            LinkRevPanelDataContext r137 = b.b(this.f92366a);
            if (r137 == null) goto L75;
            com.bytedance.live.datacontext.k<Pair<String, e>> r138 = r137.getLoadCompleteEvent();
            if (r138 == null) goto L75;
            r138.post(new Pair(b.c(this.f92366a, this.f92367b), r136));
        L75:
            if (r104 == true) goto L77;
        L79:
            r103 = false;
        L80:
            e r139 = b.d(this.f92366a, this.f92370e, IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), (IRivalRankRecommendResponse) r117.getThird(), this.f92368c);
            if (r139 == null) goto L94;
            if (r103 == false) goto L88;
            LinkRevPanelDataContext r140 = b.b(this.f92366a);
            if (r140 == null) goto L94;
            com.bytedance.live.datacontext.k<Pair<String, e>> r141 = r140.getLoadCompleteEvent();
            if (r141 == null) goto L94;
            r141.post(new Pair(UploadTypeInf.TIMER, r139));
            goto L94
        L88:
            if (r104 == true) goto L94;
            LinkRevPanelDataContext r142 = b.b(this.f92366a);
            if (r142 == null) goto L94;
            com.bytedance.live.datacontext.k<Pair<String, e>> r143 = r142.getLoadCompleteEvent();
            if (r143 == null) goto L94;
            r143.post(new Pair(b.c(this.f92366a, this.f92367b), r139));
            goto L94
        L77:
            if (b.a(this.f92366a, (IRivalRankRecommendResponse) r117.getThird()) == false) goto L79;
        L94:
            this.f92366a.f92355i.put(r114.ordinal(), new e(r114.ordinal(), "0", r111, this.f92368c, System.currentTimeMillis()));
            return;
        L41:
            if (r119.isEmpty() == true) goto L44;
            r120 = false;
            goto L45
        L38:
            r119 = null;
            goto L39
        L31:
            if (Intrinsics.areEqual(this.f92367b, UploadTypeInf.TIMER) == false) goto L35;
        L96:
            if (Intrinsics.areEqual(this.f92367b, "init") == false) goto L100;
            LinkRevPanelDataContext r144 = b.b(this.f92366a);
            if (r144 == null) goto L100;
            r144.setAbValueMap(r111.getListAbValueMap());
        L100:
            if (r104 == true) goto L102;
        L106:
            r103 = false;
        L107:
            e r145 = b.d(this.f92366a, this.f92370e, r113, r111, this.f92368c);
            if (r145 == null) goto L129;
            if (r103 == false) goto L115;
            LinkRevPanelDataContext r146 = b.b(this.f92366a);
            if (r146 == null) goto L130;
            com.bytedance.live.datacontext.k<Pair<String, e>> r147 = r146.getLoadCompleteEvent();
            if (r147 == null) goto L131;
            r147.post(new Pair(UploadTypeInf.TIMER, r145));
            return;
        L131:
            return;
        L130:
            return;
        L115:
            if (r104 == true) goto L133;
            LinkRevPanelDataContext r148 = b.b(this.f92366a);
            if (r148 == null) goto L134;
            com.bytedance.live.datacontext.k<Pair<String, e>> r149 = r148.getLoadCompleteEvent();
            if (r149 == null) goto L135;
            r149.post(new Pair(b.c(this.f92366a, this.f92367b), r145));
            return;
        L135:
            return;
        L134:
            return;
        L133:
            return;
        L129:
            return;
        L102:
            if (b.a(this.f92366a, r111) == false) goto L106;
            if (r113 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L106;
        L124:
            return;
        L123:
            return;
        L122:
            return;
        L5:
            if (Intrinsics.areEqual(r102, "ai") == true) goto L8;
            r104 = false;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f92371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f92372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f92373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f92374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f92375e;

        public d(b r100, String r101, long r102, int r103, String r104) {
            this.f92371a = r100;
            this.f92372b = r101;
            this.f92373c = r102;
            this.f92374d = r103;
            this.f92375e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            b r100 = this.f92371a;
            String r101 = this.f92372b;
            r100.getClass();
            if (Intrinsics.areEqual(r101, UploadTypeInf.TIMER) == false) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L13;
            LiveFullLinkPKMonitor r103 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r103 == null) goto L13;
            LiveFullLinkPKMonitor.r(r103, "battle/rivals/recommend", r111, System.currentTimeMillis() - this.f92373c, this.f92374d, 0, null, 48);
        L13:
            if (r102 == true) goto L27;
            int r104 = x.f97681a;
            if (x.a(this.f92375e, this.f92374d) == false) goto L18;
            f r105 = new f(this.f92374d, this.f92375e, r111, this.f92373c, System.currentTimeMillis());
            this.f92371a.f92360n.put(this.f92375e, r105);
            return;
        L18:
            f r106 = new f(this.f92374d, this.f92375e, r111, this.f92373c, System.currentTimeMillis());
            this.f92371a.f92356j.put(this.f92374d, r106);
            LinkRevPanelDataContext r112 = b.b(this.f92371a);
            if (r112 == null) goto L25;
            com.bytedance.live.datacontext.k<Pair<String, f>> r113 = r112.getLoadFailEvent();
            if (r113 == null) goto L26;
            r113.post(new Pair(b.c(this.f92371a, this.f92372b), r106));
            return;
        L26:
            return;
        L25:
            return;
        L27:
            return;
        L5:
            if (Intrinsics.areEqual(r101, "ai") == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    static {
    }

    public final void o() {
        Disposable r100 = this.f92351e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f92352f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f92362p = true;
    }

    public b() {
        this.f92347a = -1;
        this.f92355i = new SparseArray();
        this.f92356j = new SparseArray();
        this.f92357k = new SparseArray();
        this.f92358l = new ArraySet();
        this.f92359m = new ArrayMap();
        this.f92360n = new ArrayMap();
        this.f92361o = new ArrayMap();
        this.f92362p = true;
        this.f92363q = LazyKt.lazy(LinkRevPanelLoader$exposeSet$2.INSTANCE);
    }

    public final void m() {
        this.f92349c = System.currentTimeMillis();
        d31.e r100 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r100 == null) goto L5;
        r100.f466689d = this.f92349c;
    L5:
        Disposable r101 = this.f92350d;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f92356j.clear();
        this.f92360n.clear();
        if (a.a() == true) goto L11;
        this.f92355i.clear();
        this.f92359m.clear();
        this.f92356j.clear();
        this.f92360n.clear();
        this.f92358l.clear();
        this.f92359m.clear();
    L11:
        b51.b r102 = b51.b.f17721c0;
        r102.getClass();
        if (((Boolean) b51.b.f17730l.getValue(r102, b51.b.f17716a[10])).booleanValue() == false) goto L20;
        Disposable r103 = this.f92353g;
        if (r103 == null) goto L16;
        r103.dispose();
    L16:
        Disposable r104 = this.f92354h;
        if (r104 == null) goto L19;
        r104.dispose();
    L19:
        this.f92350d = g(this, IRivalRankRecommendResponse.LoadType.Other.ordinal());
        this.f92353g = g(this, IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
        this.f92354h = g(this, IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal());
        return;
    L20:
        this.f92350d = g(this, IRivalRankRecommendResponse.LoadType.All.ordinal());
    }

    public static final LinkRevPanelDataContext b(b r100) {
        r100.getClass();
        return LinkRevPanelDataContext.Companion.getContext();
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        o();
        if (a.a() == true) goto L5;
    L6:
        this.f92355i.clear();
        this.f92359m.clear();
        this.f92356j.clear();
        this.f92360n.clear();
        this.f92358l.clear();
    L7:
        Disposable r101 = this.f92353g;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        Disposable r102 = this.f92350d;
        if (r102 == null) goto L13;
        r102.dispose();
    L13:
        Disposable r103 = this.f92354h;
        if (r103 == null) goto L17;
        r103.dispose();
        return;
    L17:
        return;
    L5:
        if (Intrinsics.areEqual(r100, "clear") == false) goto L7;
        goto L6
    }

    public final void n(String r210) {
        Intrinsics.checkNotNullParameter(r210, "source");
        if (this.f92347a < 0) goto L5;
    L7:
        boolean r100 = true;
        if (Intrinsics.areEqual(r210, "open") == false) goto L10;
        this.f92348b++;
    L10:
        b51.b r101 = b51.b.f17721c0;
        if (r101.i().getOpenPanelCount() < 0) goto L16;
        if (this.f92348b >= r101.i().getOpenPanelCount()) goto L16;
        return;
    L16:
        if (r101.i().h5() < 0) goto L25;
        if (this.f92348b >= r101.i().h5()) goto L25;
        if (this.f92347a <= 0) goto L25;
        i97.a r102 = i97.a.f488802a;
        if ((System.currentTimeMillis() - this.f92347a) < 1200000) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r210, "live") == true) goto L29;
        if (Intrinsics.areEqual(r210, "link_end") == true) goto L29;
    L37:
        if (r101.i().R5() == false) goto L42;
        if (((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPerfManager().a() == false) goto L42;
        return;
    L42:
        if (a.a() == false) goto L77;
        boolean r103 = Intrinsics.areEqual(r210, "open");
        r11.o r104 = r101.h();
        if (r103 == false) goto L47;
        long r110 = r104.q();
    L49:
        if (r110 <= 0) goto L77;
        r11.o r105 = r101.h();
        if (r103 == false) goto L54;
        int r106 = r105.C();
    L55:
        Disposable r111 = this.f92351e;
        if (r111 == null) goto L58;
        r111.dispose();
    L58:
        this.f92362p = false;
        if (r103 == true) goto L61;
    L63:
        long r112 = r101.h().getDelay();
    L64:
        if (r106 < 0) goto L66;
        long r113 = r106;
        if (r112 < 0) goto L73;
        long r114 = r112;
    L74:
        Observable<Long> r107 = Observable.intervalRange(0, r113, r114, r110, TimeUnit.MILLISECONDS);
    L75:
        this.f92351e = r107.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.control.dialog.d(this, r210));
        goto L77
    L73:
        r114 = 5000;
        goto L74
    L66:
        if (r112 >= 0) goto L69;
        r112 = 5000;
    L69:
        r107 = Observable.interval(r112, r110, TimeUnit.MILLISECONDS);
        goto L75
    L61:
        if (r101.i().R5() == false) goto L63;
        r112 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        goto L64
    L54:
        r106 = r105.getCount();
        goto L55
    L47:
        r110 = r104.getInterval();
    L77:
        if (a.a() == false) goto L126;
        boolean r108 = Intrinsics.areEqual(r210, "open");
        r11.r r109 = r101.i();
        if (r108 == false) goto L82;
        long r115 = r109.q();
    L84:
        if (r115 <= 0) goto L127;
        if (r108 == false) goto L88;
        int r116 = r101.i().C();
    L89:
        int r117 = r210.hashCode();
        if (r117 == 3112) goto L106;
        if (r117 == 3417674) goto L100;
        if (r117 == 1194515222) goto L97;
    L108:
        long r118 = r101.i().getDelay();
    L109:
        Disposable r119 = this.f92352f;
        if (r119 == null) goto L112;
        r119.dispose();
    L112:
        this.f92362p = false;
        if (r116 < 0) goto L115;
        long r120 = r116;
        if (r118 < 0) goto L122;
        long r121 = r118;
    L123:
        Observable<Long> r122 = Observable.intervalRange(0, r120, r121, r115, TimeUnit.MILLISECONDS);
    L124:
        this.f92352f = r122.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.control.dialog.c(this, r210));
        return;
    L122:
        r121 = 5000;
        goto L123
    L115:
        if (r118 >= 0) goto L118;
        r118 = 5000;
    L118:
        r122 = Observable.interval(r118, r115, TimeUnit.MILLISECONDS);
        goto L124
    L97:
        if (r210.equals("link_end") == false) goto L108;
    L107:
        r118 = 3000;
        goto L109
    L100:
        if (r210.equals("open") == false) goto L108;
        if (r101.i().R5() == false) goto L104;
        r118 = 15000;
        goto L109
    L104:
        r118 = r101.i().getDelay();
        goto L109
    L106:
        if (r210.equals("ai") == false) goto L108;
    L88:
        r116 = r101.i().getCount();
        goto L89
    L127:
        return;
    L82:
        r115 = r109.getInterval();
        goto L84
    L126:
        return;
    L29:
        if (r101.g().getEnable() == true) goto L31;
    L33:
        r100 = false;
    L34:
        if (r100 == false) goto L37;
        return;
    L31:
        if (r101.g().K3() == false) goto L33;
    L5:
        if (Intrinsics.areEqual(r210, "live") == false) goto L7;
        i97.a r123 = i97.a.f488802a;
        this.f92347a = System.currentTimeMillis();
        goto L7
    }

    public static final boolean a(b r100, IRivalRankRecommendResponse r101) {
        if (r101 == null) goto L13;
        r100.getClass();
        s2 r102 = r101.getTabRivals();
        if (r102 == null) goto L13;
        Map<Long, IGroupRivals> r103 = r102.getGroupRivals();
        if (r103 == null) goto L13;
        IGroupRivals r104 = r103.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r104 == null) goto L13;
        List<m2> r105 = r104.getRivals();
        if (r105 == null) goto L13;
        int r106 = r105.size();
    L14:
        SparseArray<e> r107 = r100.f92355i;
        if (r107 == null) goto L29;
        e r108 = r107.get(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
        if (r108 == null) goto L29;
        IRivalRankRecommendResponse r109 = r108.f92382c;
        if (r109 == null) goto L29;
        s2 r110 = r109.getTabRivals();
        if (r110 == null) goto L29;
        Map<Long, IGroupRivals> r111 = r110.getGroupRivals();
        if (r111 == null) goto L29;
        IGroupRivals r112 = r111.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r112 == null) goto L29;
        List<m2> r113 = r112.getRivals();
        if (r113 == null) goto L29;
        int r114 = r113.size();
    L30:
        if (r114 == r106) goto L33;
        return true;
    L33:
        return false;
    L29:
        r114 = 0;
    L13:
        r106 = 0;
        goto L14
    }

    public static final String c(b r100, String r101) {
        r100.getClass();
        if (Intrinsics.areEqual(r101, "ai") == false) goto L6;
        return UploadTypeInf.TIMER;
    L6:
        return r101;
    }

    public static Disposable g(b r100, int r101) {
        return r100.h(0, "0", "init", r101, "");
    }

    public static String k(int r100, String r101) {
        return r100 + '-' + r101;
    }

    public final Pair<String, e> e(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "activityId");
        Intrinsics.checkNotNullParameter(r111, "activityId");
        if (x.a(r111, r110) == false) goto L5;
        e r100 = this.f92359m.get(r111);
    L15:
        if (r100 != null) goto L17;
        return null;
    L17:
        if (a.a() == true) goto L21;
        return TuplesKt.to("cache", r100);
    L21:
        if (x.a(r111, r110) == false) goto L24;
        long r101 = b51.b.f17721c0.i().m3();
    L31:
        if (r101 <= (-1)) goto L36;
        if ((System.currentTimeMillis() - r100.f92383d) <= r101) goto L36;
        return null;
    L36:
        if (r110 != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L41;
        d31.e r112 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r112 == null) goto L88;
        r112.f466690e |= 1;
    L88:
        return TuplesKt.to("cache", r100);
    L41:
        if (r110 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L46;
        d31.e r113 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r113 == null) goto L88;
        r113.f466690e |= 2;
        goto L88
    L46:
        if (r110 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L88;
        IRivalRankRecommendResponse r114 = r100.f92382c;
        if (r114 == null) goto L54;
        s2 r115 = r114.getTabRivals();
        if (r115 == null) goto L54;
        Map<Long, IGroupRivals> r116 = r115.getGroupRivals();
        if (r116 == null) goto L54;
        IGroupRivals r117 = r116.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
    L55:
        if (r117 == null) goto L57;
        List<m2> r118 = r117.getRivals();
    L58:
        List<m2> r102 = r118;
        if (r102 != null) goto L61;
    L64:
        boolean r103 = true;
    L65:
        if (r103 == false) goto L67;
    L84:
        d31.e r119 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r119 == null) goto L88;
        r119.f466690e |= 4;
        goto L88
    L67:
        if ((true ^ ((HashSet) this.f92363q.getValue()).isEmpty()) == false) goto L84;
        ArrayList r104 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L70:
        if (r120.hasNext() == false) goto L81;
        m2 r105 = (m2) r120.next();
        if (r105 == null) goto L70;
        HashSet r106 = (HashSet) this.f92363q.getValue();
        IRoom r107 = r105.getRoom();
        if (r107 == null) goto L76;
        String r108 = r107.getIdStr();
    L78:
        if (r106.contains(r108) == true) goto L70;
        r104.add(r105);
        goto L70
    L76:
        r108 = null;
        goto L78
    L81:
        if (r104.size() < b51.b.f17721c0.i().t()) goto L84;
        if (r117 == null) goto L84;
        r117.setRivals(r104);
        goto L84
    L61:
        if (r102.isEmpty() == true) goto L64;
        r103 = false;
        goto L65
    L57:
        r118 = null;
    L54:
        r117 = null;
        goto L55
    L24:
        if (r110 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L27;
        r101 = b51.b.f17721c0.h().z();
        goto L31
    L27:
        if (r110 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L29;
        r101 = b51.b.f17721c0.i().V7();
        goto L31
    L29:
        r101 = b51.b.f17721c0.i().C2();
        goto L31
    L5:
        r100 = this.f92355i.get(r110);
        if (r110 != IRivalRankRecommendResponse.LoadType.All.ordinal()) goto L15;
        if (r100 != null) goto L15;
        r100 = this.f92355i.get(IRivalRankRecommendResponse.LoadType.Other.ordinal());
        SparseArray<e> r109 = this.f92355i;
        IRivalRankRecommendResponse.LoadType r121 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals;
        e r122 = r109.get(r121.ordinal());
        SparseArray<e> r123 = this.f92355i;
        IRivalRankRecommendResponse.LoadType r124 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals;
        e r125 = r123.get(r124.ordinal());
        if (r100 == null) goto L15;
        if (r122 == null) goto L12;
        j(r121.ordinal(), r100.f92382c, r122.f92382c);
    L12:
        if (r125 == null) goto L15;
        j(r124.ordinal(), r100.f92382c, r125.f92382c);
        goto L15
    }

    public final boolean i(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "activityId");
        if (this.f92358l.contains(k(r100, r101)) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f92358l.contains(k(IRivalRankRecommendResponse.LoadType.All.ordinal(), r101)) == true) goto L8;
        return false;
    }

    public static void j(int r100, IRivalRankRecommendResponse r101, IRivalRankRecommendResponse r102) {
        if (r101.getTabRivals() != null) goto L5;
        r101.setTabRivals(r102.getTabRivals());
        return;
    L5:
        s2 r103 = r101.getTabRivals();
        Map<Long, IGroupRivals> r104 = null;
        if (r103 == null) goto L8;
        Map<Long, IGroupRivals> r105 = r103.getGroupRivals();
    L9:
        if (r105 == null) goto L11;
    L18:
        s2 r106 = r101.getTabRivals();
        if (r106 == null) goto L21;
        Map<Long, IGroupRivals> r107 = r106.getGroupRivals();
    L22:
        if (r107 == null) goto L63;
        s2 r108 = r102.getTabRivals();
        if (r108 == null) goto L26;
        r104 = r108.getGroupRivals();
    L26:
        if (r104 != null) goto L28;
        return;
    L28:
        if (r100 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L44;
        s2 r109 = r102.getTabRivals();
        if (r109 == null) goto L65;
        Map<Long, IGroupRivals> r110 = r109.getGroupRivals();
        if (r110 == null) goto L66;
        IGroupRivals.GroupType r111 = IGroupRivals.GroupType.GroupFeedRecommend;
        IGroupRivals r112 = r110.get(Long.valueOf(r111.ordinal()));
        if (r112 == null) goto L67;
        s2 r113 = r101.getTabRivals();
        if (r113 == null) goto L68;
        LinkedHashMap r114 = new LinkedHashMap();
        s2 r115 = r101.getTabRivals();
        if (r115 == null) goto L41;
        Map<Long, IGroupRivals> r116 = r115.getGroupRivals();
        if (r116 == null) goto L41;
    L42:
        r114.putAll(r116);
        r114.put(Long.valueOf(r111.ordinal()), r112);
        Unit r117 = Unit.INSTANCE;
        r113.setGroupRivals(r114);
        return;
    L41:
        r116 = MapsKt.emptyMap();
        goto L42
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L44:
        if (r100 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L70;
        s2 r118 = r102.getTabRivals();
        if (r118 == null) goto L71;
        Map<Long, IGroupRivals> r119 = r118.getGroupRivals();
        if (r119 == null) goto L72;
        IGroupRivals r120 = r119.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r120 == null) goto L73;
        s2 r121 = r101.getTabRivals();
        if (r121 == null) goto L74;
        LinkedHashMap r122 = new LinkedHashMap();
        s2 r123 = r101.getTabRivals();
        if (r123 == null) goto L57;
        Map<Long, IGroupRivals> r124 = r123.getGroupRivals();
        if (r124 == null) goto L57;
    L58:
        r122.putAll(r124);
        r122.put(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()), r120);
        Unit r125 = Unit.INSTANCE;
        r121.setGroupRivals(r122);
        return;
    L57:
        r124 = MapsKt.emptyMap();
        goto L58
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L63:
        return;
    L21:
        r107 = null;
        goto L22
    L11:
        if (r102.getTabRivals() == null) goto L18;
        s2 r126 = r101.getTabRivals();
        if (r126 == null) goto L61;
        s2 r127 = r102.getTabRivals();
        if (r127 == null) goto L17;
        r104 = r127.getGroupRivals();
    L17:
        r126.setGroupRivals(r104);
        return;
    L61:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static void l(b r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter("0", "activityId");
        b51.b r103 = b51.b.f17721c0;
        if (r103.g().getEnable() == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L11;
        return;
    L11:
        if ((!Intrinsics.areEqual(r101, "init")) == false) goto L16;
        if ((!Intrinsics.areEqual(r101, "cache")) == false) goto L16;
        return;
    L16:
        if (r102 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L22;
        r100.f92355i.remove(r102);
        r100.f92356j.remove(r102);
        r100.f92358l.remove(k(r102, "0"));
        return;
    L22:
        return;
    L5:
        if (r103.g().K3() == false) goto L7;
        r104 = true;
        goto L8
    }

    public static final e d(b r110, String r111, int r112, IRivalRankRecommendResponse r113, long r114) {
        r110.getClass();
        if (x.a(r111, r112) == false) goto L6;
        e r100 = new e(r112, r111, r113, r114, System.currentTimeMillis());
        r110.f92359m.put(r111, r100);
        return r100;
    L6:
        if (r112 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L10;
        ((HashSet) r110.f92363q.getValue()).clear();
        e r115 = new e(r112, "0", r113, r114, System.currentTimeMillis());
        r110.f92355i.put(r112, r115);
        ALogger.i("LinkRevPanelLoader", "updateCache piece loadType=" + r112);
    L17:
        return r115;
    L10:
        if (r112 != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L12;
    L15:
        r115 = new e(r112, "0", r113, r114, System.currentTimeMillis());
        r110.f92355i.put(r112, r115);
        ALogger.i("LinkRevPanelLoader", "updateCache piece loadType=" + r112);
        goto L17
    L12:
        if (r112 == IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L15;
        return null;
    }

    public final Disposable h(int r210, String r211, String r212, int r213, String r214) {
        Intrinsics.checkNotNullParameter(r211, "activityId");
        Intrinsics.checkNotNullParameter(r212, "source");
        Intrinsics.checkNotNullParameter(r214, "posStr");
        this.f92358l.add(k(r213, r211));
        long r110 = System.currentTimeMillis();
        if (x.a(r211, r213) == false) goto L5;
        this.f92361o.put(r211, Long.valueOf(r110));
    L6:
        boolean r111 = Intrinsics.areEqual(r212, "init");
        if (Intrinsics.areEqual(r212, "init") == false) goto L9;
        String r112 = "";
    L10:
        r31.a r100 = r31.b.a(r31.a.f535859a);
        int r101 = com.bytedance.android.live.revlink.impl.pk.flexactivity.b.f96711a;
        int r113 = e51.a.f471039c.a();
        int r102 = r212.hashCode();
        if (r102 != 3112) goto L13;
        String r103 = "ai";
        if (r212.equals("ai") == false) goto L21;
    L20:
        String r114 = r103;
    L22:
        Observable r104 = r100.D(1, r112, r211, r113, r210, r213, r111 ? 1 : 0, r214, r114);
        if (r104 == null) goto L29;
        Observable r105 = r104.map(new C1437b(this, r211));
        if (r105 == null) goto L29;
        Observable r106 = r105.compose(RxUtil.rxSchedulerHelper());
        if (r106 == null) goto L29;
        return r106.subscribe(new c(this, r212, r110, r213, r211), new d(this, r212, r110, r213, r211));
    L29:
        return null;
    L21:
        r114 = "";
        goto L22
    L13:
        if (r102 != 110364485) goto L21;
        if (r212.equals(UploadTypeInf.TIMER) == false) goto L21;
        r103 = "cache";
        goto L20
    L9:
        r112 = "common_pk";
        goto L10
    L5:
        this.f92357k.put(r213, Long.valueOf(r110));
        goto L6
    }
}
