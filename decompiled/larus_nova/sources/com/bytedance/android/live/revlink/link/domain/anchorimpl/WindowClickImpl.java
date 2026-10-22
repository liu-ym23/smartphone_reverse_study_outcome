package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class WindowClickImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s51.b f98415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f98416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f98417c;

    public final void a() {
        if (this.f98415a.e() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        p21.b r101 = this.f98416b.ne();
        this.f98416b.getScene();
        com.bytedance.android.live.revlink.impl.global.c r102 = r101.f527373a;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r103 = null;
        if (r102 == null) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r104 = r102.km();
    L12:
        if (r104 != null) goto L14;
    L15:
        w r105 = r101.e();
        if (r105 == null) goto L18;
        UILayout r106 = r105.b();
    L20:
        if (r106 == UILayout.FULL) goto L44;
        com.bytedance.android.live.revlink.impl.global.c r107 = r101.f527373a;
        if (r107 == null) goto L29;
        RevLinkWindowRegionContext r108 = r107.P8();
        if (r108 == null) goto L29;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r109 = r108.getPartnerService();
        if (r109 == null) goto L29;
        r103 = r109.getValue();
    L29:
        if (r103 != null) goto L31;
    L33:
        w r110 = r101.e();
        if (r110 == null) goto L36;
        int r111 = r110.i();
    L37:
        y41.d r112 = y41.d.f565943j;
        r112.getClass();
        Integer[] r113 = (Integer[]) y41.d.f565936c.getValue(r112, y41.d.f565934a[1]);
        int r114 = r113.length;
        int r115 = 0;
    L38:
        if (r115 >= r114) goto L46;
        if (r113[r115].intValue() != r111) goto L42;
        boolean r116 = true;
    L43:
        if (r116 == true) goto L44;
        r115 = r115 + 1;
        goto L38
    L42:
        r116 = false;
        goto L43
    L46:
        boolean r117 = false;
    L47:
        if (r100 == true) goto L50;
        if (r117 == true) goto L50;
        return;
    L50:
        boolean r118 = this.f98416b.getUiLayout().getValue() instanceof o51.e.C7015e;
        if (r118 == false) goto L56;
        if (this.f98415a.a() == false) goto L56;
        int r119 = ToastUtil.f90810a;
        int r120 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_screen_record_un_enlarge, 0);
    L56:
        if (this.f98415a.a() == false) goto L73;
        if (r118 == false) goto L59;
        return;
    L59:
        if (r100 == true) goto L61;
        return;
    L61:
        RevLinkWindowRegionContext r121 = this.f98416b.P8();
        if (r121 == null) goto L71;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r122 = r121.getPartnerService();
        if (r122 == null) goto L71;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r123 = r122.getValue();
        if (r123 == null) goto L71;
        if (r123.n() != true) goto L71;
        this.f98416b.ko().showUserProfile(this.f98415a.getUid());
        return;
    L71:
        k r124 = this.f98416b.ko();
        String r125 = this.f98415a.getUid();
        String r126 = this.f98415a.f();
        this.f98415a.g();
        r124.a(r125, r126);
        return;
    L73:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(this.f98416b) == false) goto L75;
        this.f98416b.ko().e(this.f98415a.getUid(), this.f98415a.f(), this.f98415a.g(), new WindowClickImpl$onWindowClick$1(this));
        return;
    L75:
        this.f98416b.ko().g(this.f98415a.getUid(), this.f98415a.f(), this.f98415a.g(), this.f98417c);
        return;
    L36:
        r111 = 0;
        goto L37
    L31:
        if (r103.n() != true) goto L33;
    L44:
        r117 = true;
        goto L47
    L18:
        r106 = null;
        goto L20
    L14:
        if (r104.a() == true) goto L44;
    L11:
        r104 = null;
        goto L12
    L5:
        if (this.f98416b.ne().a(this.f98416b.getScene()) == false) goto L7;
        r100 = true;
        goto L8
    }

    public WindowClickImpl(s51.b r100, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mic");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98415a = r100;
        this.f98416b = r101;
        this.f98417c = r102;
    }
}
