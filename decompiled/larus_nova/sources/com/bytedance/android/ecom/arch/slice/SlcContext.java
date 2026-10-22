package com.bytedance.android.ecom.arch.slice;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.ActionExtension;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcContext extends SlcRenderContext {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public com.bytedance.android.ecom.slice.ext.template.gecko.c f49954o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f49955p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final Context f49956q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final ActionContext f49957r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.adapter.e f49958s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final e f49959t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Map<String, ? extends Object> f49960u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final d f49961v0;

    public final List<g> u() {
        return this.f49961v0.F();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext
    public final void d() {
        super.d();
        v(false);
    }

    public final Context getActivity() {
        return this.f49956q0;
    }

    public final void v(boolean r100) {
        if (this.f49955p0 != r100) goto L5;
        return;
    L5:
        this.f49955p0 = r100;
        if (r100 == false) goto L11;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r101 = this.f49954o0;
        if (r101 == null) goto L10;
        r101.release();
    L10:
        SlcGeckoTemplateMgr r102 = SlcGeckoTemplateMgr.f51232l;
        String r103 = this.f50185l0;
        r102.getClass();
        com.bytedance.android.ecom.slice.ext.template.gecko.c r104 = SlcGeckoTemplateMgr.e(this, r103);
        this.f49954o0 = r104;
        r104.b(this);
        return;
    L11:
        com.bytedance.android.ecom.slice.ext.template.gecko.c r105 = this.f49954o0;
        if (r105 == null) goto L16;
        r105.release();
        return;
    }

    public /* synthetic */ SlcContext(Context r110, ActionContext r111, com.bytedance.android.ecom.arch.slice.adapter.e r112, SlcExprContext r113, e r114, com.bytedance.android.shopping.anchorv4.voavhs.i r115) {
        this(r110, r111, r112, "pdp", r113, r114, null, r115);
    }

    public SlcContext(Context r100, ActionContext r101, com.bytedance.android.ecom.arch.slice.adapter.e r102, String r103, SlcExprContext r104, e r105, Map<String, ? extends Object> r106, d r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "adapterHelper");
        Intrinsics.checkNotNullParameter(r103, "biz");
        Intrinsics.checkNotNullParameter(r104, "exprContext");
        Intrinsics.checkNotNullParameter(r105, "templateStore");
        Intrinsics.checkNotNullParameter(r107, "delegate");
        super(r100, r103, r104);
        this.f49956q0 = r100;
        this.f49957r0 = r101;
        this.f49958s0 = r102;
        this.f49959t0 = r105;
        this.f49960u0 = r106;
        this.f49961v0 = r107;
        ActionExtension.a();
        if (r101 == null) goto L5;
        r101.f49970e = SlcContext$initActionContext$1$1.INSTANCE;
    L5:
        r104.b(ComplianceConstants.ComplianceRequest.MARKET_STORE, new i(this));
        r104.b("slice", new j(this));
        r104.b("slices", new k(this));
        r104.b("filterSlices", new l(this));
        r104.b("mapField", new m());
        r104.b("andJoin", new n());
        this.f50163a0 = new AnonymousClass1(this);
    }
}
