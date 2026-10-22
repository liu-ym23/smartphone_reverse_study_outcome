package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BizAdMsgPanelViewManager;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ShowFinishType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.g0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.DanmakuCarnivalTrayManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import f52.i;
import f52.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pm1.h;
import r52.j2;

/* JADX INFO: loaded from: classes9.dex */
public final class PSTopContainer implements f52.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f52.c f139671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f139672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, f52.d> f139673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<f52.f, FrameLayout> f139674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Disposable> f139675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, a> f139676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f139677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<f52.e> f139678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f139679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f139680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f139681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f139682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f139683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f139684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<f52.c, AbsPSHighlightComp> f139685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f139686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f139687q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f52.c f139688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f139689b;

        public a(f52.c r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f139688a = r100;
            this.f139689b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSTopContainer f139690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f52.c f139691b;

        public b(PSTopContainer r100, f52.c r101) {
            this.f139690a = r100;
            this.f139691b = r101;
        }

        public final void a() {
            if (this.f139690a.g(this.f139691b) == false) goto L7;
            PSTopContainer r100 = this.f139690a;
            f52.c r101 = r100.f139671a;
            if (r101 == null) goto L11;
            r101.e(this.f139691b, r100);
            return;
        L11:
            return;
        L7:
            Map<String, a> r102 = this.f139690a.f139676f;
            HashMap r103 = (HashMap) r102;
            a r104 = (a) r103.remove(this.f139691b.getId());
            if (r104 == null) goto L13;
            this.f139690a.w(r104);
            return;
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
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSTopContainer f139692a;

        public final void a() {
            long r100 = this.f139692a.f139682l - System.currentTimeMillis();
            if (r100 > 0) goto L5;
            PSTopContainer r101 = this.f139692a;
            String r102 = PSTopContainer.m(this.f139692a.f139671a) + " timeout, force stop. maxShowDuration=" + this.f139692a.f139681k;
            r101.getClass();
            i.a(r102);
            PSTopContainer r103 = this.f139692a;
            r103.f139682l = -1;
            r103.l(null, true);
            return;
        L5:
            this.f139692a.n().postDelayed(this, r100);
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

        public c(PSTopContainer r100) {
            this.f139692a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSTopContainer f139693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f52.c f139694b;

        public d(PSTopContainer r100, f52.c r101) {
            this.f139693a = r100;
            this.f139694b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f139693a.d(this.f139694b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSTopContainer f139695a;

        public e(PSTopContainer r100) {
            this.f139695a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b r101 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b) r100;
            PSTopContainer r102 = this.f139695a;
            String r103 = "receive ForceStopCurViewEvent. curView=" + PSTopContainer.m(this.f139695a.f139671a);
            r102.getClass();
            i.a(r103);
            this.f139695a.l(null, true);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSTopContainer f139696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f52.c f139697b;

        public f(PSTopContainer r100, f52.c r101) {
            this.f139696a = r100;
            this.f139697b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Map<String, Disposable> r102 = this.f139696a.f139675e;
            HashMap r103 = (HashMap) r102;
            if (((Disposable) r103.remove(this.f139697b.getId())) == null) goto L6;
            this.f139696a.t(this.f139697b, ShowFinishType.TIMEOUT);
            return;
        }
    }

    public final Handler n() {
        return (Handler) this.f139677g.getValue();
    }

    @Override // f52.b
    public final o getRoomContext() {
        IRoomContextService r100 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return IRoomContextService.a.a(r100, this.f139687q, 0, 2);
    }

    @Override // f52.b
    public final void onCreate() {
        if (this.f139672b == false) goto L5;
        return;
    L5:
        i.a(WidgetCostModule.TYPE_ON_CREATE);
        this.f139672b = true;
        this.f139679i = xs2.b.a().b(com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b.class).subscribe(new e(this));
        ArrayList r100 = new ArrayList();
        o r101 = getRoomContext();
        if (r101 == null) goto L10;
        m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L10;
        IRoom r103 = r102.getValue();
    L11:
        boolean r104 = false;
        if (PublicScreenABHelper.a(r103) == true) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L19;
        r100.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.b());
    L19:
        o r106 = getRoomContext();
        if (r106 == null) goto L24;
        m<IRoom> r107 = r106.getRoom();
        if (r107 == null) goto L24;
        IRoom r108 = r107.getValue();
    L26:
        if (PublicScreenABHelper.a(r108) == true) goto L28;
    L30:
        if (r104 == false) goto L32;
        r100.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.d());
    L32:
        r100.add(new DanmakuCarnivalTrayManager());
        nu2.a r109 = (nu2.a) h.f529822d.c(nu2.a.class);
        if (r109 == null) goto L35;
        Object r110 = r109.getLikeEggTopViewManager(getContext(), this.f139687q);
    L37:
        if ((r110 instanceof f52.d) == true) goto L39;
        r110 = null;
    L39:
        f52.d r111 = (f52.d) r110;
        if (r111 == null) goto L43;
        r100.add(r111);
    L43:
        if (com.bytedance.android.livesdk.chatroom.setting.a.f111519a.getValue().b() == false) goto L53;
        dq1.c r112 = pm1.f.k();
        if (r112 == null) goto L47;
        BizAdMsgPanelViewManager r113 = r112.g(this.f139687q, getContext(), this.f139686p);
    L49:
        if ((r113 instanceof f52.d) == true) goto L51;
        r113 = null;
    L51:
        if (r113 == null) goto L53;
        r100.add(r113);
        goto L53
    L47:
        r113 = null;
    L53:
        r100.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.e());
        com.bytedance.android.livesdk.interactivity.api.h r114 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f139687q, 1);
        if (r114 == null) goto L58;
        n<ViewGroup> r115 = r114.getMatchTrayRootView();
        if (r115 == null) goto L58;
        ViewGroup r116 = r115.getValue();
    L59:
        if (r116 == null) goto L61;
        r100.add(new qa2.k(r116));
    L63:
        if (v.a() == false) goto L65;
        r100.add(new sa2.b());
    L65:
        Iterator r117 = r100.iterator();
    L67:
        if (r117.hasNext() == false) goto L69;
        e((f52.d) r117.next());
        goto L67
    L69:
        return;
    L61:
        SafetyGuard.a(null, null, "matchTrayRootView is null");
    L58:
        r116 = null;
        goto L59
    L35:
        r110 = null;
        goto L37
    L28:
        if (PublicScreenABHelper.C == false) goto L30;
        r104 = true;
    L24:
        r108 = null;
        goto L26
    L14:
        if (PublicScreenABHelper.C == true) goto L16;
        r105 = true;
    L10:
        r103 = null;
        goto L11
    }

    @Override // f52.b
    public final void onDestroy() {
        if (this.f139672b == true) goto L5;
        return;
    L5:
        i.a(LiveCommonConstants.REASON_ON_DEDTROY);
        this.f139672b = false;
        Disposable r100 = this.f139679i;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        f52.c r101 = this.f139671a;
        if (r101 == null) goto L11;
        h(r101, r101.b(this, null));
        q(r101, ShowFinishType.DESTROY);
        this.f139671a = null;
    L11:
        Iterator r102 = ((HashMap) this.f139673c).entrySet().iterator();
    L13:
        if (r102.hasNext() == false) goto L15;
        ((f52.d) ((Map.Entry) r102.next()).getValue()).onUnload();
        goto L13
    L15:
        ((HashMap) this.f139673c).clear();
        n().removeCallbacksAndMessages(null);
        ((HashMap) this.f139676f).clear();
        ((ArrayList) this.f139678h).clear();
        this.f139686p.removeAllViews();
        ((HashMap) this.f139674d).clear();
        Iterator r103 = ((HashMap) this.f139675e).entrySet().iterator();
    L17:
        if (r103.hasNext() == false) goto L19;
        ((Disposable) ((Map.Entry) r103.next()).getValue()).dispose();
        goto L17
    L19:
        ((HashMap) this.f139675e).clear();
        ((LinkedHashMap) this.f139685o).clear();
    }

    @Override // f52.b
    public Context getContext() {
        return this.f139684n;
    }

    @Override // f52.b
    public final DataCenter getDataCenter() {
        return this.f139687q;
    }

    @Override // f52.b
    public final ViewGroup getRoot() {
        return this.f139686p;
    }

    public static String m(f52.c r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return "id=" + r100.getId() + " type=" + r100.getType();
    }

    public static void p(String r100) {
        int r101 = i.f475618a;
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.e("PSTopContainer", r100);
    }

    @Override // f52.b
    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.b(this, r100));
    }

    @Override // f52.b
    public final View c(f52.c r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_test_ps_top_view, o(r100.getType()), this.f139672b);
        if ((!Intrinsics.areEqual(this.f139671a, r100)) == false) goto L5;
        UtilityKotlinExtentionsKt.t(r101);
    L5:
        return r101;
    }

    @Override // f52.b
    public final void d(f52.c r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f139672b == false) goto L26;
        f52.c r101 = this.f139671a;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getId();
    L9:
        if ((!Intrinsics.areEqual(r103, r100.getId())) == false) goto L16;
        StringBuilder r104 = new StringBuilder("notifyShowFinish failed. curId=");
        f52.c r105 = this.f139671a;
        if (r105 == null) goto L13;
        r102 = r105.getId();
    L13:
        r104.append(r102);
        r104.append(". viewId=");
        r104.append(r100.getId());
        p(r104.toString());
        return;
    L16:
        if (r100.getEndTimestamp() <= 0) goto L18;
        return;
    L18:
        if (r100.getDuration() <= 0) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L24;
        n().post(new d(this, r100));
        return;
    L24:
        t(r100, ShowFinishType.NORMAL);
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // f52.b
    public final void e(f52.d r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (this.f139672b == true) goto L7;
        p("register view manger " + r100.getId() + " after destroy");
        return;
    L7:
        if (((HashMap) this.f139673c).containsKey(r100.getId()) == false) goto L10;
        p("register view manager " + r100.getId() + " twice");
        return;
    L10:
        ((HashMap) this.f139673c).put(r100.getId(), r100);
        r100.j(this);
    }

    @Override // f52.b
    public final void f(f52.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f139672b == true) goto L7;
        p("register show listener after destroy");
        return;
    L7:
        if (((ArrayList) this.f139678h).contains(r100) == true) goto L10;
        ((ArrayList) this.f139678h).add(r100);
        return;
    }

    public final boolean g(f52.c r100) {
        f52.c r101 = this.f139671a;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101.getType(), r100.getType()) == true) goto L7;
        return false;
    L7:
        if (r101.g() == true) goto L9;
        return false;
    L9:
        if (r100.g() == true) goto L11;
        return false;
    L11:
        if (r101.j(r100) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final void j(f52.c r100) {
        z.a r101 = z.f133764a;
        DataCenter r102 = this.f139687q;
        r101.getClass();
        if (z.a.a(r102) == false) goto L16;
        IPublicScreenService r103 = (IPublicScreenService) k.f(IPublicScreenService.class);
        if (r103 == null) goto L18;
        String r104 = r100.getId();
        HighlightAreaPriorityConfig r105 = r100.c();
        long r106 = 100;
        if (r105 == null) goto L9;
        long r107 = r105.getShowPriority();
    L10:
        HighlightAreaPriorityConfig r108 = r100.c();
        if (r108 == null) goto L13;
        r106 = r108.getLocationPriority();
    L13:
        AbsPSHighlightComp r109 = r103.createFastHighlightComp(r104, new PSHighlightType.b(r107, r106), getContext(), this.f139687q, new PSTopContainer$doShow$1(this, r100));
        if (r109 == null) goto L19;
        this.f139685o.put(r100, r109);
        r109.q();
        return;
    L19:
        return;
    L9:
        r107 = 100;
        goto L10
    L18:
        return;
    L16:
        s(r100);
    }

    public final void k(f52.c r100) {
        i.a("forceShow " + m(r100) + ". cur " + m(this.f139671a));
        l(r100, false);
        j(r100);
    }

    public final FrameLayout o(f52.f r100) {
        FrameLayout r101 = (FrameLayout) ((HashMap) this.f139674d).get(r100);
        if (r101 != null) goto L6;
        FrameLayout r102 = new FrameLayout(this.f139686p.getContext());
        this.f139686p.addView(r102, new ViewGroup.LayoutParams(-1, -1));
        ((HashMap) this.f139674d).put(r100, r102);
        i.a("create wrap view for " + r100);
        return r102;
    L6:
        return r101;
    }

    public final void s(f52.c r100) {
        i.a("do show " + m(r100));
        this.f139671a = r100;
        UtilityKotlinExtentionsKt.w(o(r100.getType()));
        Iterator r101 = ((ArrayList) this.f139678h).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f52.e) r101.next()).g(r100);
        goto L4
    L6:
        r100.h(this);
        if (this.f139682l > 0) goto L9;
        this.f139682l = System.currentTimeMillis() + this.f139681k;
        n().postDelayed(this.f139683m, this.f139681k);
    L11:
        if (r100.getEndTimestamp() <= 0) goto L17;
        long r102 = r100.getEndTimestamp() - System.currentTimeMillis();
        if (r102 > 0) goto L15;
        t(r100, ShowFinishType.TIMEOUT);
        return;
    L15:
        v(r100, r102);
        return;
    L17:
        if (r100.getDuration() <= 0) goto L23;
        v(r100, ((long) r100.getDuration()) * 1000);
        return;
    L23:
        return;
    L9:
        this.f139682l = System.currentTimeMillis() + this.f139681k;
        goto L11
    }

    public final void u(a r100) {
        i.a("queue " + m(r100.f139688a));
        ((PriorityQueue) this.f139680j.getValue()).add(r100);
    }

    public final void w(a r100) {
        f52.c r101 = r100.f139688a;
        i.a("tryShow " + m(r101) + ". cur: " + m(this.f139671a));
        f52.c r102 = this.f139671a;
        if (r102 == null) goto L31;
        int r103 = r101.getType().getPriority() - r102.getType().getPriority();
        if (r103 <= 0) goto L14;
        int r104 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.f139699a[r101.d().ordinal()];
        if (r104 == 1) goto L13;
        if (r104 == 2) goto L12;
        if (r104 != 3) goto L42;
        SafetyGuard.a(null, null, "priority higher. discard");
        return;
    L42:
        return;
    L12:
        k(r101);
        return;
    L13:
        u(r100);
        return;
    L14:
        if (r103 != 0) goto L23;
        int r105 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.f139700b[r101.k().ordinal()];
        if (r105 == 1) goto L22;
        if (r105 == 2) goto L21;
        if (r105 != 3) goto L43;
        i.a("priority equal. discard");
        r101.a(DiscardReason.CONFLICT);
        return;
    L43:
        return;
    L21:
        k(r101);
        return;
    L22:
        u(r100);
        return;
    L23:
        int r106 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.f139701c[r101.f().ordinal()];
        if (r106 == 1) goto L30;
        if (r106 == 2) goto L29;
        if (r106 != 3) goto L44;
        SafetyGuard.a(null, null, "priority lower. interrupt");
        return;
    L44:
        return;
    L29:
        i.a("priority lower. discard");
        r101.a(DiscardReason.CONFLICT);
        return;
    L30:
        u(r100);
        return;
    L31:
        j(r101);
    }

    public PSTopContainer(FrameLayout r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f139686p = r100;
        this.f139687q = r101;
        this.f139673c = new HashMap();
        this.f139674d = new HashMap();
        this.f139675e = new HashMap();
        this.f139676f = new HashMap();
        this.f139677g = LazyKt.lazy(PSTopContainer$mainHandler$2.INSTANCE);
        this.f139678h = new ArrayList();
        this.f139680j = LazyKt.lazy(PSTopContainer$showQueue$2.INSTANCE);
        g0.f133761a.getClass();
        this.f139681k = ((long) RangesKt.coerceAtLeast(j2.f536202a.getValue().b(), 1)) * 1000;
        this.f139682l = -1;
        this.f139683m = new c(this);
        this.f139684n = r100.getContext();
        this.f139685o = new LinkedHashMap();
    }

    public final void h(f52.c r100, CleanStrategy r101) {
        f52.f r102 = r100.getType();
        FrameLayout r103 = (FrameLayout) ((HashMap) this.f139674d).get(r102);
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.f139702d[r101.ordinal()];
        if (r104 != 2) goto L8;
        r103.removeAllViews();
    L12:
        UtilityKotlinExtentionsKt.t(r103);
        return;
    L8:
        if (r104 != 3) goto L12;
        ((HashMap) this.f139674d).remove(r102);
        r103.removeAllViews();
        this.f139686p.removeView(r103);
        goto L12
    }

    public final void l(f52.c r100, boolean r101) {
        f52.c r102 = this.f139671a;
        if (r102 == null) goto L8;
        Map<String, Disposable> r103 = this.f139675e;
        HashMap r104 = (HashMap) r103;
        Disposable r105 = (Disposable) r104.remove(r102.getId());
        if (r105 == null) goto L7;
        r105.dispose();
    L7:
        h(r102, r102.b(this, r100));
        this.f139671a = null;
        q(r102, ShowFinishType.INTERRUPT);
    L8:
        if (r101 == false) goto L11;
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.c(this));
        return;
    }

    public final void q(f52.c r100, ShowFinishType r101) {
        Iterator<T> r102 = this.f139678h.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f52.e) r102.next()).d(r100, r101);
        goto L4
    }

    public final void r(f52.c r100, ShowFinishType r101) {
        this.f139685o.remove(r100);
        i.a("onShowFinish " + m(r100) + " finishType=" + r101);
        h(r100, r100.i(this));
        this.f139671a = null;
        q(r100, r101);
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.c(this));
    }

    public final void t(f52.c r100, ShowFinishType r101) {
        z.a r102 = z.f133764a;
        DataCenter r103 = this.f139687q;
        r102.getClass();
        if (z.a.a(r103) == false) goto L7;
        AbsPSHighlightComp r104 = (AbsPSHighlightComp) ((LinkedHashMap) this.f139685o).get(r100);
        if (r104 == null) goto L9;
        r104.p("finish_type", r101);
        r104.b();
        return;
    L9:
        return;
    L7:
        r(r100, r101);
    }

    public final void v(f52.c r100, long r101) {
        i.a("start countdown " + r101 + "ms. " + m(r100));
        Disposable r102 = (Disposable) ((HashMap) this.f139675e).get(r100.getId());
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        ((HashMap) this.f139675e).put(r100.getId(), Observable.timer(r101, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r100)));
    }

    @Override // f52.b
    public final void b(f52.c r100, View r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "view");
        if (this.f139672b == true) goto L5;
        return;
    L5:
        ViewParent r103 = r101.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L8;
        r103 = null;
    L8:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L11;
        r104.removeView(r101);
    L11:
        FrameLayout r105 = o(r100.getType());
        if (r102 == null) goto L14;
        r105.addView(r101, r102);
    L16:
        if ((!Intrinsics.areEqual(r100, this.f139671a)) == false) goto L19;
        UtilityKotlinExtentionsKt.t(r105);
        return;
    L19:
        return;
    L14:
        r105.addView(r101);
        goto L16
    }

    public final void i(f52.c r100, long r101, long r102) {
        i.a("delay show. delayMillis=" + r102 + ' ' + m(r100));
        ((HashMap) this.f139676f).put(r100.getId(), new a(r100, r101));
        n().postDelayed(new b(this, r100), r102);
    }
}
