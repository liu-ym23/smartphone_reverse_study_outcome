package com.bytedance.android.live.revlink.link.biz.component;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class BreakThroughBarUIOperation implements com.bytedance.android.live.revlink.link.biz.service.e, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f97835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zy0.b f97836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f97837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f97838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f97839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f97840f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.BreakThroughBarUIOperation$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(BreakThroughBarUIOperation r100) {
            super(0, r100, BreakThroughBarUIOperation.class, "refreshLayout", "refreshLayout()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((BreakThroughBarUIOperation) this.receiver).g();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.f97838d = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().hh(), new AnonymousClass1(this)), this.f97839e);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void d() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.f97838d = false;
        h();
        this.f97839e.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void e() {
        if (this.f97838d == true) goto L6;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl notifyLynxLoadSuccess return for not in life", null, 4);
        return;
    L6:
        g();
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl notifyLynxLoadSuccess", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void b() {
        getContext().k4().d(this.f97837c, this.f97836b);
    }

    public final void g() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl refreshLayout with layoutStatus: " + getContext().hh().getValue() + ", hybridCard: " + this.f97836b + ", inLife: " + this.f97838d, null, 4);
        if (this.f97838d == true) goto L5;
        return;
    L5:
        f31.f r100 = getContext().hh().getValue();
        if (r100 != null) goto L8;
        return;
    L8:
        zy0.b r101 = this.f97836b;
        if (r101 != null) goto L11;
        return;
    L11:
        x51.a r102 = getContext().k4();
        int r103 = (int) r100.f475331b.width();
        int r104 = com.bytedance.android.live.revenue.common.i.b(48);
        RectF r105 = r100.f475331b;
        r102.b(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r103, r104, (int) r105.left, ((int) r105.top) - com.bytedance.android.live.revenue.common.i.b(16), 0), r101, this.f97837c);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final void h() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl call remove all lynxTag: " + this.f97837c + ", hybridCard: " + this.f97836b, null, 4);
        getContext().k4().d(this.f97837c, this.f97836b);
        this.f97836b = null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f97835a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.f97840f;
    }

    public BreakThroughBarUIOperation(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f97840f = r100;
        this.f97835a = "MultiBreakThroughBarUIOperation";
        this.f97837c = "multi_breakthrough";
        this.f97839e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void c(boolean r100) {
        getContext().k4().a(this.f97836b, !r100);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void f(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "lynxUrl");
        Intrinsics.checkNotNullParameter(r111, "source");
        if (this.f97838d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.link.biz.service.i.R(this).b(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this));
        LiveFullLinkPKMonitor.o(com.bytedance.android.live.revlink.link.biz.service.i.s(this), "link_break_through_top_bar_load_failed", r110, "context is null source".concat(r111), 7, 0, 16);
    }
}
