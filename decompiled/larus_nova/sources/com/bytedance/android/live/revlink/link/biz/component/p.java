package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.livesdk.link.model.x6;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p implements com.bytedance.android.live.revlink.link.biz.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f98064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f98065c;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.f98064b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        f21.a r100 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f475116f == true) goto L8;
        return;
    L8:
        if (r100.f475114d == 6) goto L82;
        g51.a r101 = g51.a.f480019d;
        r101.getClass();
        if (((Boolean) g51.a.f480018c.getValue(r101, g51.a.f480016a[1])).booleanValue() == false) goto L86;
        x6 r102 = r100.f475125o.f475135e;
        if (r102 == null) goto L83;
        Map<Long, String> r103 = r102.getRoleLinkMicMap();
        if (r103 != null) goto L17;
        return;
    L17:
        if (r103.size() != 4) goto L85;
        com.bytedance.android.live.revenuelink.rtc.i r104 = com.bytedance.android.live.revlink.link.biz.service.i.f(this);
        if (r104 == null) goto L23;
        com.bytedance.android.live.revenuelink.rtc.p r105 = r104.L();
        if (r105 == null) goto L23;
        int r106 = r105.f91969a.size();
    L24:
        if (r106 >= 4) goto L87;
        x6 r107 = r100.f475125o.f475135e;
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        Map<Long, String> r110 = r107.getRoleLinkMicMap();
        if (r110 == null) goto L53;
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        String r113 = r110.get(1L);
        if (r113 == null) goto L31;
        r111.add(r113);
    L31:
        String r114 = r110.get(Long.valueOf(2));
        if (r114 == null) goto L34;
        r111.add(r114);
    L34:
        String r115 = r110.get(Long.valueOf(3));
        if (r115 == null) goto L37;
        r112.add(r115);
    L37:
        String r116 = r110.get(Long.valueOf(4));
        if (r116 == null) goto L40;
        r112.add(r116);
    L40:
        Iterator r117 = MapsKt.toMap(r110).entrySet().iterator();
    L42:
        if (r117.hasNext() == false) goto L48;
        Map.Entry r118 = (Map.Entry) r117.next();
        int r119 = (int) ((Number) r118.getKey()).longValue();
        if (Intrinsics.areEqual((String) r118.getValue(), com.bytedance.android.live.revlink.link.biz.service.i.A(this).c()) == false) goto L42;
        if (r119 == 3) goto L47;
        if (r119 != 4) goto L42;
    L47:
        boolean r120 = false;
    L49:
        if (r120 == false) goto L51;
        Pair r121 = TuplesKt.to(r111, r112);
    L52:
        r108.addAll((Collection) r121.getFirst());
        r109.addAll((Collection) r121.getSecond());
        goto L53
    L51:
        r121 = TuplesKt.to(r112, r111);
        goto L52
    L48:
        r120 = true;
    L53:
        Object r122 = null;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "loadRandomTeamPKLayout leftLinkIds=" + r108 + ", rightLinkIds=" + r109, null, 4);
        if (r108.size() != 2) goto L56;
    L58:
        Pair[] r123 = new Pair[4];
        r123[0] = TuplesKt.to(getContext().Ab(), 0);
        Iterator r124 = r108.iterator();
    L60:
        if (r124.hasNext() == false) goto L64;
        Object r125 = r124.next();
        if ((!Intrinsics.areEqual((String) r125, getContext().Zl())) == false) goto L60;
        r122 = r125;
    L64:
        String r126 = (String) r122;
        if (r126 == null) goto L68;
        Intrinsics.checkNotNullParameter(r126, "$this$uid");
        Intrinsics.checkNotNullParameter(r126, "$this$uid");
        Intrinsics.checkNotNullParameter(r126, "$this$uid");
        String r127 = com.bytedance.android.live.revlink.link.biz.service.j.a.b(this, r126);
        if (r127 == null) goto L68;
    L69:
        r123[1] = TuplesKt.to(r127, 3);
        r123[2] = TuplesKt.to("role_invitee", 1);
        r123[3] = TuplesKt.to("role_invitee_follower", 2);
        getContext().m6().setValue(new com.bytedance.android.live.revlink.link.core.layoutstatus.l(4, MapsKt.mapOf(r123)));
        com.bytedance.revenue.platform.api.core.rx.l r128 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        int r129 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(10000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this)), this.f98064b);
        return;
    L68:
        r127 = "role_inviter_follower";
        goto L69
    L56:
        if (r109.size() == 2) goto L58;
        return;
    L87:
        return;
    L23:
        r106 = 0;
        goto L24
    L85:
        return;
    L83:
        return;
    L86:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f98063a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f98065c;
    }

    public p(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98065c = r100;
        this.f98063a = "MultiRandomPKComponent";
        this.f98064b = new CompositeDisposable();
    }
}
