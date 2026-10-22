package com.bytedance.android.ec.core.slice.ectag;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.b;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.c;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/slice/ectag/ECTagViewWrapper;", "Landroid/widget/FrameLayout;", "", "serverTimeSecond", "", "setServerTime", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagViewWrapper extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45330c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f45331d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f45332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f45333f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SlcRenderContext f45334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f45335b;

    public static final class a {
        public a() {
        }

        public static SlcRenderContext a(Context r110, b r111) {
            Intrinsics.checkNotNullParameter("native_ectag", "biz");
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r100 = h.getActivity(r110);
            if (r100 != null) goto L6;
            nq.a.c(null, ECTagViewWrapper$Companion$getSlcRenderContext$1.INSTANCE, 1);
            return null;
        L6:
            Object r101 = mq.a.a(r100).getTag(R.id.native_ectag_render);
            if ((r101 instanceof SlcRenderContext) == true) goto L10;
            r101 = null;
        L10:
            SlcRenderContext r102 = (SlcRenderContext) r101;
            if (r102 != null) goto L23;
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (ECTagViewWrapper.f45332e == true) goto L16;
            final g r103 = new g(CollectionsKt.listOf((j) ECTagViewWrapper.f45330c.getValue()), 6);
            SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, "native_ectag_template_loader_id", "ecom_pdp_card_template", wh.a.b(r110), new ECTagViewWrapper$Companion$initBiz$1(r103));
            ECTagViewWrapper.f45332e = true;
        L16:
            SlcGeckoTemplateMgr.f51232l.getClass();
            c r104 = SlcGeckoTemplateMgr.e("native_ectag_template_loader_id", "native_ectag_template_loader_id");
            com.bytedance.android.ecom.arch.slice.expr.b r105 = r104.c();
            if (r105 != null) goto L19;
            r105 = new com.bytedance.android.ecom.arch.slice.expr.b(null);
        L19:
            r102 = new SlcRenderContext(r110, "native_ectag", new SlcExprContext(r105));
            if (r111 == null) goto L22;
            r102.f50172f = r111;
        L22:
            r102.f50163a0 = new SlcDefaultTemplateProvider(r104);
            r102.f50174g = true;
            Intrinsics.checkNotNullParameter(r100, "activity");
            mq.a.a(r100).setTag(R.id.native_ectag_render, r102);
        L23:
            return r102;
        }
    }

    public ECTagViewWrapper(Context r100) {
        this(r100, null, 0, 14);
    }

    public ECTagViewWrapper(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public ECTagViewWrapper(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    static {
        f45333f = new a();
        f45330c = LazyKt.lazy(ECTagViewWrapper$Companion$ectagPreloadInfo$2.INSTANCE);
        f45331d = LazyKt.lazy(ECTagViewWrapper$Companion$ecTagElement$2.INSTANCE);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L8;
        r r101 = this.f45335b;
        if (r101 == null) goto L8;
        View r102 = r101.f50701c;
        if (r102 == null) goto L8;
        r102.setLayoutParams(new FrameLayout.LayoutParams(r100.width, r100.height));
    L8:
        super.setLayoutParams(r100);
    }

    public final void setServerTime(long r100) {
        SlcRenderContext r101 = this.f45334a;
        if (r101 == null) goto L6;
        r101.r(r100);
        return;
    }

    public ECTagViewWrapper(Context r100, AttributeSet r101, int r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L8;
        r110 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        f45333f.getClass();
        SlcRenderContext r102 = a.a(r100, null);
        this.f45334a = r102;
        if (r102 != null) goto L11;
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);
        return;
    L11:
        SliceRender r103 = SliceRender.f50121o;
        SlcElement r112 = ((SlcElement) f45331d.getValue()).deepClone();
        Lazy r104 = f45330c;
        p r113 = new p(((j) r104.getValue()).c(), ((j) r104.getValue()).a(), null, null, 124);
        r103.getClass();
        r.f50698d.getClass();
        r r105 = r.a.a(r102, r112, r113);
        addView(r105.f50701c, 0);
        r105.b(new com.bytedance.android.ec.core.slice.ectag.a(this));
        Unit r106 = Unit.INSTANCE;
        this.f45335b = r105;
    }
}
