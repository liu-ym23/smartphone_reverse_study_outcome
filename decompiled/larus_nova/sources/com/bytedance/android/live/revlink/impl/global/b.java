package com.bytedance.android.live.revlink.impl.global;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.connect.g;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.e;
import com.bytedance.android.live.revlink.impl.pk.service.h;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.scope.m;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final x11.a i() {
        o41.a r100 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r100 == null) goto L7;
        o11.b r101 = r100.f521943a;
        if (r101 == null) goto L7;
        return (x11.a) m.f163449e.d(r101, x11.a.class);
    L7:
        return null;
    }

    public static final c k() {
        o41.a r100 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r100 == null) goto L7;
        o11.b r101 = r100.f521943a;
        if (r101 == null) goto L7;
        return (c) m.f163449e.d(r101, c.class);
    L7:
        return null;
    }

    public static final o11.a o() {
        o41.a r100 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f521943a;
    }

    public static final p21.b A() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ne();
    }

    public static final MultiLinkAnchorControlContext B() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ua();
    }

    public static final v C() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiLinkMonitor();
    }

    public static final w D() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiLinkUtil();
    }

    public static final k21.a E() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.P7();
    }

    public static final MultiPKLauncher F() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Be();
    }

    public static final MultiPkMatchContext G() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.gf();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.match.f H() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.F8();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.match.a I() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Mf();
    }

    public static final z J() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiPkMonitor();
    }

    public static final com.bytedance.android.live.revlink.impl.precisefind.a K() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Wd();
    }

    public static final b0 L() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Tj();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.a M() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ja();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.b N() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Ud();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.utils.j O() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPKInviteControlUtils();
    }

    public static final IPKLinkBizDataService P() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mk();
    }

    public static final e Q() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.lo();
    }

    public static final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e R() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Ig();
    }

    public static final com.bytedance.android.live.revlink.impl.monitor.b S() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkEnterRoomTracer();
    }

    public static final w31.c T() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkLinkUtils();
    }

    public static final h U() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.V0();
    }

    public static final h41.f V() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkSwitchLogger();
    }

    public static final q W() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkUtils();
    }

    public static final ProfitInteractionDataContext X() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.vj();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.profit.a Y() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Qj();
    }

    public static final e0 Z() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ti();
    }

    public static final com.bytedance.android.live.revenuelink.connect.f a() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Z0();
    }

    public static final com.bytedance.android.livesdk.log.filter.v a0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Pa();
    }

    public static final g b() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAnchorConnectUtils();
    }

    public static final s b0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRevLinkCommonUtil();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.utils.a c() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.km();
    }

    public static final d31.d c0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRevLinkLogHelper();
    }

    public static final com.bytedance.android.live.revenuelink.rtc.f d() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m0();
    }

    public static final d31.e d0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.q4();
    }

    public static final i11.b e() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c8();
    }

    public static final d31.f e0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.y2();
    }

    public static final com.bytedance.android.live.revlink.impl.control.d f() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Rc();
    }

    public static final RevLinkWindowRegionContext f0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.P8();
    }

    public static final i41.a g() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAutoMatchManager();
    }

    public static final com.bytedance.android.live.revenuelink.f g0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRevenueLinkTraceMonitor();
    }

    public static final e21.b h() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getClientAttachedInfoObj();
    }

    public static final i h0() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Hg();
    }

    public static final LinkCrossRoomDataHolder j() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLinkCrossRoomDataHolder();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e l() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLinkOptLogContext();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f m() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLinkPlayHelper();
    }

    public static final com.bytedance.android.live.revlink.impl.service.internal.a n() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Do();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.f p() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Fb();
    }

    public static final LiveFullLinkPKMonitor q() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveFullLinkPKMonitor();
    }

    public static final d21.d r() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMergePkHelper();
    }

    public static final ox0.a s() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getModeMerge();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.a t() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.u5();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.g u() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiAnchorLinkContextObj();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.utils.q v() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMultiAnchorLinkLogUtils();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.b w() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d6();
    }

    public static final MultiAnchorPkLaunchContext x() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Ib();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.c y() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.O4();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.d z() {
        c r100 = k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.R8();
    }
}
