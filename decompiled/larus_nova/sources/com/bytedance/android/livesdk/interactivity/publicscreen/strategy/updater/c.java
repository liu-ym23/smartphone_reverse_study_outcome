package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater;

import am2.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import ec2.d1;
import f32.f;
import f32.h;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import ju1.g;
import ju1.n;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f139590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f139591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f139592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner<n> f139593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f139594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IPublicScreenSpeedConfig f139595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f139596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f139597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f139598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o72.e f139599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f139600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f139601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f139602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f139603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f139604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f139605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f139606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f139607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f139608u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j0 f139609v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f139610w;

    public static final class a {
    }

    public static final class b implements h32.d<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f139611a;

        public b(c r100) {
            this.f139611a = r100;
        }

        @Override // h32.d
        public final void a(f r100) {
            h r101 = (h) r100;
            Intrinsics.checkNotNullParameter(r101, "newConfig");
            c r102 = this.f139611a;
            r102.f139603p = r101;
            if (r101.f475374a <= 0) goto L11;
            boolean r103 = TextMessageTracer.f133629a;
            TextMessageTracer.A("trigger degrade, use degrade speed config");
            c r104 = this.f139611a;
            c r105 = this.f139611a;
            int r106 = r105.f139603p.f475374a;
            r104.f139597j = new e(1000, r106, r106, 750);
            if (r105.f139601n.booleanValue() == false) goto L9;
            e r107 = r105.f139597j;
            if (r107 != null) goto L10;
            r107 = r105.f139596i;
        L10:
            c.k(r105, r107);
            return;
        L9:
            r107 = r105.f139596i;
            goto L10
        L11:
            r102.f139597j = null;
            if (r102.f139601n.booleanValue() == false) goto L16;
            e r108 = r102.f139597j;
            if (r108 != null) goto L17;
            r108 = r102.f139596i;
        L17:
            c.k(r102, r108);
            return;
        L16:
            r108 = r102.f139596i;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c$c, reason: collision with other inner class name */
    public static final class C2206c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f139612a;

        public C2206c(c r100) {
            this.f139612a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            n r111 = (n) r110;
            c r100 = this.f139612a;
            int r101 = q.f133648a;
            r100.f139596i = q.h(r100.f139609v, r111.b(r100.f139590c), this.f139612a.f139595h);
            c r102 = this.f139612a;
            c.k(r102, r102.f139596i);
            boolean r103 = this.f139612a.f139610w;
            List<String> r104 = wa2.a.f558808a;
            Intrinsics.checkNotNullParameter(r111, "speed");
            Object r105 = r111.c();
            if (Intrinsics.areEqual(r105, 0) == false) goto L6;
            String r106 = "lowest";
        L18:
            String r107 = "";
            if ((r111 instanceof g) == false) goto L36;
            LinkedHashMap r108 = new LinkedHashMap();
            g r112 = (g) r111;
            Iterator<T> r109 = r112.f500409d.iterator();
        L23:
            if (r109.hasNext() == false) goto L30;
            String r113 = (String) r109.next();
            Object r114 = r112.f500408c.get(r113);
            if (r114 == null) goto L28;
            String r115 = r114.toString();
            if (r115 == null) goto L28;
        L29:
            r108.put(r113, r115);
        L28:
            r115 = "";
            goto L29
        L30:
            Gson r116 = GsonHelper.get();
            if (r116 == null) goto L36;
            String r117 = GsonProtectorUtils.toJson(r116, r108);
            if (r117 == null) goto L36;
            r107 = r117;
        L36:
            Pair[] r118 = new Pair[4];
            r118[0] = TuplesKt.to("comment_show_speed", r106);
            r118[1] = TuplesKt.to("speed_change_reason", r107);
            if (r103 == false) goto L39;
            String r119 = "1";
        L40:
            r118[2] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r119);
            r118[3] = TuplesKt.to(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE, "speed_formula");
            Map<String, String> r120 = MapsKt.mapOf(r118);
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_show_speed", r120, new Object[]{IRoom.class, x.class});
            return;
        L39:
            r119 = "0";
            goto L40
        L6:
            if (Intrinsics.areEqual(r105, 1) == false) goto L9;
            r106 = "low";
            goto L18
        L9:
            if (Intrinsics.areEqual(r105, 2) == false) goto L12;
            r106 = "normal";
            goto L18
        L12:
            if (Intrinsics.areEqual(r105, 3) == false) goto L15;
            r106 = "high";
            goto L18
        L15:
            if (Intrinsics.areEqual(r105, 4) == false) goto L17;
            r106 = "highest";
            goto L18
        L17:
            r106 = "unknown";
            goto L18
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        boolean r100 = this.f139610w;
        int r101 = 0;
        if (r100 == true) goto L7;
        int r102 = this.f139607t;
        if (r102 <= 0) goto L7;
        this.f139608u = 2;
        this.f139607t = 0;
        ka2.a r103 = new ka2.a(r102, r102, 0);
        r103.f502178a = true;
    L20:
        e(r103);
        return;
    L7:
        if (r100 == true) goto L11;
        int r104 = this.f139605r;
        if (r104 >= this.f139606s) goto L11;
        this.f139608u = 2;
        this.f139605r = r104 + 1;
        r103 = new ka2.a(this.f139599l.c(), this.f139599l.c(), 0);
    L11:
        if (r100 == true) goto L15;
        int r105 = this.f139608u;
        if (r105 >= 2) goto L15;
        this.f139608u = r105 + 1;
        int r106 = this.f139598k.f133485b;
        r103 = new ka2.a(r106, r106, 0);
    L15:
        int r107 = this.f139598k.f133485b;
        int r108 = r107 + r107;
        if (System.currentTimeMillis() >= this.f139600m) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(DynamicSpeedMessageUpdaterV2$getUpdateInfo$2.INSTANCE);
    L19:
        r103 = new ka2.a(r108, r107, r101);
        goto L20
    L18:
        r101 = this.f139598k.f133486c;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        if (this.f139610w == true) goto L9;
        if (this.f139605r >= this.f139606s) goto L9;
        return this.f139599l.d();
    L9:
        return this.f139598k.f133484a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void g() {
        super.g();
        Disposable r100 = this.f139594g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        PropertyOwner<n> r101 = this.f139593f;
        Disposable r102 = null;
        if (r101 == null) goto L12;
        Observable r103 = com.bytedance.android.live.core.arch.mvvm.f.b(r101);
        if (r103 == null) goto L12;
        Observable r104 = RxUtilKt.h(r103);
        if (r104 == null) goto L12;
        Disposable r105 = r104.subscribe(new C2206c(this));
    L13:
        this.f139594g = r105;
        if (this.f139601n.booleanValue() == false) goto L37;
        Disposable r106 = this.f139602o;
        if (r106 == null) goto L18;
        r106.dispose();
    L18:
        o r107 = this.f139592e;
        if (r107 == null) goto L23;
        j<ViewModel> r108 = r107.M1();
        if (r108 == null) goto L23;
        Object r109 = (ViewModel) r108.getValue();
    L25:
        if ((r109 instanceof com.bytedance.android.livesdk.interactivity.api.h) == true) goto L27;
        r109 = null;
    L27:
        com.bytedance.android.livesdk.interactivity.api.h r110 = (com.bytedance.android.livesdk.interactivity.api.h) r109;
        if (r110 == null) goto L36;
        j<h32.a> r111 = r110.getDegradeManager();
        if (r111 == null) goto L36;
        h32.a r112 = r111.getValue();
        if (r112 == null) goto L36;
        h32.c<h> r113 = r112.h();
        if (r113 == null) goto L36;
        r102 = g32.b.a(r113, this.f139604q);
    L36:
        this.f139602o = r102;
    L23:
        r109 = null;
    L37:
        d r114 = this.f139591d;
        if (r114 == null) goto L41;
        e r115 = this.f139598k;
        r114.update(r115.f133487d, r115.f133484a);
        return;
    L41:
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void i() {
        super.i();
        Disposable r100 = this.f139594g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f139602o;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public static final void k(c r100, e r101) {
        r100.f139598k = r101;
        boolean r102 = TextMessageTracer.f133629a;
        TextMessageTracer.A("speed updateInterval:" + r100.f139598k.f133484a + ",scrollSpeed:" + r100.f139598k.f133487d);
        d r103 = r100.f139591d;
        if (r103 == null) goto L6;
        e r104 = r100.f139598k;
        r103.update(r104.f133487d, r104.f133484a);
        return;
    }

    public c(IRoom r100, j0 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f139609v = r101;
        this.f139610w = r102;
        this.f139590c = 2;
        IRoomContextService r103 = (IRoomContextService) k.f(IRoomContextService.class);
        long r104 = 0;
        PropertyOwner<n> r105 = null;
        if (r103 == null) goto L8;
        if (r100 == null) goto L6;
        long r106 = r100.getRoomId();
    L7:
        o r107 = IRoomContextService.a.a(r103, null, r106, 1);
    L9:
        this.f139592e = r107;
        IRoomContextService r108 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r108 == null) goto L20;
        if (r100 == null) goto L13;
        r104 = r100.getRoomId();
    L13:
        o r109 = IRoomContextService.a.a(r108, null, r104, 1);
        if (r109 == null) goto L20;
        j<IDynamicStrategyContext> r110 = r109.r2();
        if (r110 == null) goto L20;
        IDynamicStrategyContext r111 = r110.getValue();
        if (r111 == null) goto L20;
        r105 = r111.getStrategy("public_screen_speed_strategy");
    L20:
        this.f139593f = r105;
        IPublicScreenSpeedConfig r112 = q.g(r100);
        this.f139595h = r112;
        e r113 = q.h(r101, -1, r112);
        this.f139596i = r113;
        this.f139598k = r113;
        this.f139599l = d1.f472011a.getValue();
        this.f139601n = com.bytedance.android.livesdk.interactivity.service.settings.b.f140990a.getValue();
        this.f139603p = new h(0);
        this.f139604q = new b(this);
        return;
    L6:
        r106 = 0;
        goto L7
    L8:
        r107 = null;
        goto L9
    }
}
