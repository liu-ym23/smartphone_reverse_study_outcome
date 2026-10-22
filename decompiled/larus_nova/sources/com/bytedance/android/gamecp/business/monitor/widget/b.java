package com.bytedance.android.gamecp.business.monitor.widget;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.h0;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f56161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f56162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f56164d;

    @Override // com.bytedance.android.gamecp.base.gamedetail.g0
    public final h0 Yo() {
        return this.f56161a;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f56164d = r100;
        this.f56161a = new h0(0);
        this.f56162b = true;
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        h0 r101 = this.f56161a;
        r101.f51585c = System.currentTimeMillis();
        return;
    L4:
        h0 r102 = this.f56161a;
        r102.f51585c = System.currentTimeMillis() - this.f56161a.f51585c;
    }

    public final void b(boolean r100) {
        if (this.f56162b == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        h0 r101 = this.f56161a;
        r101.f51587e = System.currentTimeMillis();
        return;
    L7:
        h0 r102 = this.f56161a;
        r102.f51587e = System.currentTimeMillis() - this.f56161a.f51587e;
        this.f56162b = false;
    }

    public final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        a(false);
        h0 r101 = this.f56161a;
        r101.f51586d = System.currentTimeMillis();
        r100.invoke();
        h0 r102 = this.f56161a;
        r102.f51586d = System.currentTimeMillis() - this.f56161a.f51586d;
    }

    public final void d(p r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        if (this.f56163c == false) goto L5;
        return;
    L5:
        this.f56163c = true;
        Object r101 = this.f56164d;
        if ((r101 instanceof PureWidget) == true) goto L8;
        r101 = null;
    L8:
        PureWidget r102 = (PureWidget) r101;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isDestroyed == false) goto L14;
        return;
    L14:
        if ((r100 instanceof com.bytedance.ies.sve_list.a) == true) goto L16;
        r100 = null;
    L16:
        com.bytedance.ies.sve_list.a r103 = (com.bytedance.ies.sve_list.a) r100;
        if (r103 == null) goto L21;
        r102.Wo(new tt.a.C7770a(r103.getId(), r102.contentView, this.f56161a));
        return;
    }
}
