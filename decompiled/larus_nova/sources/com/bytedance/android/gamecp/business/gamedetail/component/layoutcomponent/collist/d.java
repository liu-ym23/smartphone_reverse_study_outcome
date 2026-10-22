package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import com.bytedance.android.gamecp.business.gamedetail.base.AudienceGamePromoteDetailApi;
import com.bytedance.android.gamecp.business.gamedetail.base.ComponentCriteria;
import com.bytedance.android.gamecp.business.patch.GameApkMd5Manager;
import com.bytedance.android.gamecp.common.monitor_v1.FMPMonitorTracker;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ yt.a f54428d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void e() {
        this.f54428d.b();
    }

    public d(Store r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r100);
        this.f54428d = new yt.a();
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r210) {
        Intrinsics.checkNotNullParameter(r210, "action");
        if ((r210 instanceof m) == false) goto L78;
        ComponentCriteria r100 = new ComponentCriteria();
        m r101 = (m) r210;
        r100.f53477id = r101.f54448a;
        r100.offset = Integer.valueOf(r101.f54449b);
        r100.size = Integer.valueOf(r101.f54450c);
        List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r102 = r101.f54451d;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        String r105 = ((com.bytedance.android.gamecp.business.gamedetail.component.nav.a) r104.next()).a();
        if (r105 == null) goto L6;
        r103.add(r105);
        goto L6
    L10:
        r100.tabList = r103;
        boolean r106 = r101.f54452e;
        Long r107 = null;
        Store r108 = this.f248705c;     // Catch: Exception -> L13
        int r109 = ht.a.f487096c;     // Catch: Exception -> L13
        r108.useState(ht.a.C6194a.a(), null, new ht.a(null, null));     // Catch: Exception -> L13
    L14:
        dt.b r110 = (dt.b) b(dt.e.f469988b);
        String r111 = r110.f469963l0;
        boolean r112 = true;
        if (r111 == null) goto L17;
        FMPMonitorTracker.k(r111, "custom_page_net_begin", "custom_page_net_duration", true, 16);
        FMPMonitorTracker.k(r111, "custom_page_real_net_begin", "custom_page_real_net_duration", true, 16);
    L17:
        int r113 = r110.P;
        String r114 = "";
        if (r113 == 0) goto L28;
        if (r113 != 1) goto L21;
        String r115 = "video";
    L29:
        String r116 = r115;
    L31:
        if (r110.Q.length() <= 0) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L36;
        String r118 = r110.Q;
    L44:
        String r119 = r118;
    L46:
        String r120 = r110.f469958j;
        if (r120.length() > 0) goto L50;
        r112 = false;
    L50:
        if (r112 == true) goto L53;
        r120 = null;
    L53:
        if (r120 == null) goto L57;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 == null) goto L57;
        int r122 = r121.intValue();
    L58:
        Lazy r123 = GameApkMd5Manager.f56195a;
        Pair r124 = GameApkMd5Manager.d(r110.F, "ComponentRequestEffect.request");
        if (r124 == null) goto L64;
        String r125 = (String) r124.getFirst();
        if (r125 == null) goto L64;
        r114 = r125;
    L64:
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r110.E = r114;
        yr.c.a("ComponentRequestEffect", " localApkMd5: " + r114 + " gameId:" + r110.F);
        AudienceGamePromoteDetailApi r126 = (AudienceGamePromoteDetailApi) bs.e.a().b(AudienceGamePromoteDetailApi.class);
        String r127 = r110.F;
        String r128 = r110.f469939J;
        String r129 = r110.R;
        if (r129 == null) goto L67;
        r107 = StringsKt.toLongOrNull(r129);
    L67:
        String r211 = r114;
        Observable r130 = AudienceGamePromoteDetailApi.a.a(r126, r127, r116, r119, r128, r107, r110.G, r110.f469954h, Integer.valueOf(r122), r110.f469956i, r110.Z, Integer.valueOf(r110.f469941a0), r110.f469943b0, r110.f469951f0, r100, r110.f469959j0, r110.f469940a, null, null, r211, 786432).map(new e(r110));
        hv.b r131 = hv.d.f487273a;
        Disposable r132 = r130.compose(new hv.a()).doOnSubscribe(new f(this, r106)).doFinally(g.f54432a).subscribe(new h(this, r110), new i(this, r110));
        if (r132 == null) goto L79;
        Intrinsics.checkNotNullParameter(r132, "$this$autoDispose");
        this.f54428d.a(r132);
        return;
    L79:
        return;
    L57:
        r122 = 0;
        goto L58
    L36:
        String r133 = r110.I;
        if (r133 != null) goto L39;
    L45:
        r119 = "";
        goto L46
    L39:
        if (r133.length() <= 0) goto L41;
        boolean r134 = true;
    L42:
        if (r134 != true) goto L45;
        r118 = r110.I;
        goto L44
    L41:
        r134 = false;
        goto L42
    L33:
        r117 = false;
        goto L34
    L21:
        if (r113 != 2) goto L23;
        r115 = "official";
        goto L29
    L23:
        if (r113 == 3) goto L25;
        r116 = "";
        goto L31
    L25:
        r115 = "official_saas";
        goto L29
    L28:
        r115 = "live";
        goto L29
    }

    public static final void g(d r100, boolean r101, boolean r102) {
        r100.getClass();
        int r103 = ht.a.f487096c;     // Catch: Exception -> L5
        ((Function1) r100.c(ht.a.C6194a.a()).component2()).invoke(new ht.a(Boolean.valueOf(r101), Boolean.valueOf(r102)));     // Catch: Exception -> L5
        return;
    }
}
