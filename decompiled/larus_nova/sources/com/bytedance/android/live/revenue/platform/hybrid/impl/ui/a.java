package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends c implements zy0.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f91466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f91467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.hybrid.b f91468e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a$a, reason: collision with other inner class name */
    public static final class C1410a implements wy0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f91469a;

        public C1410a(a r100) {
            this.f91469a = r100;
        }

        @Override // wy0.e
        public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "methodProvider");
            this.f91469a.f91467d.registerMethod(r100, r101);
        }

        @Override // wy0.e
        public final void sendJsEvent(String r100, Object r101) {
            Intrinsics.checkNotNullParameter("rpcChannelMessage", "name");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f91469a.f91467d.sendJsEvent("rpcChannelMessage", r101);
        }

        @Override // wy0.e
        public final void registerMethod(String r100, g<?, ?> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            this.f91469a.f91467d.registerMethod(r100, r101);
        }
    }

    public static final class b implements xy0.a<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HybridType f91470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f91471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f91472c;

        @Override // xy0.a
        public final void load() {
            load(null, null);
        }

        @Override // xy0.a, io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f91472c.f91468e.dispose();
        }

        @Override // xy0.a, io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f91472c.f91468e.isDisposed();
        }

        @Override // xy0.a
        public final View getHybridView() {
            return this.f91471b;
        }

        @Override // xy0.a
        public final HybridType o() {
            return this.f91470a;
        }

        public b(a r100) {
            this.f91472c = r100;
            this.f91470a = HybridType.LYNX;
            r100.f91468e.getContainerId();
            this.f91471b = r100.f91468e.c();
        }

        public final void b(Map<String, ? extends Object> r100) {
            this.f91472c.f91468e.load(null, r100);
        }

        @Override // xy0.a
        public final void load(String r100) {
            load(r100, null);
        }

        @Override // xy0.a
        public final void updateData(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f91472c.f91468e.updateData(r100);
        }

        @Override // xy0.a
        public final void updateGlobalProps(Map<String, ? extends Object> r100) {
            this.f91472c.f91468e.updateGlobalProps(r100);
        }

        @Override // xy0.a
        public final void load(String r100, Map<String, ? extends Object> r101) {
            this.f91472c.f91468e.load(r100, r101);
        }

        @Override // xy0.a, wy0.e
        public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "methodProvider");
            this.f91472c.f91468e.registerMethod(r100, r101);
        }

        @Override // xy0.a, wy0.e
        public final void sendJsEvent(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f91472c.f91468e.sendJsEvent(r100, r101);
        }

        @Override // xy0.a
        public final void updateScreenMetrics(int r100, int r101) {
            this.f91472c.f91468e.updateScreenMetrics(r100, r101);
        }

        @Override // xy0.a, wy0.e
        public final void registerMethod(String r100, g<?, ?> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            this.f91472c.f91468e.registerMethod(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.ui.c
    public final View getHybridView() {
        return this.f91467d.f91471b;
    }

    @Override // zy0.b
    public final void x() {
        IMiddlewareHostBusiness r100 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r100 == null) goto L6;
        r100.loadLynxSoLib(this.f91466c);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.ui.c, com.bytedance.android.live.revenue.common.j
    public final void d() {
        super.d();
        this.f91468e.dispose();
    }

    @Override // zy0.b
    public final View c() {
        return this.f91466c;
    }

    @Override // zy0.c
    public final xy0.a<View> g() {
        return this.f91467d;
    }

    @Override // zy0.c
    public final xy0.a<?> w() {
        return this.f91467d;
    }

    public a(com.bytedance.android.livesdk.revenue.service.hybrid.b r100) {
        Intrinsics.checkNotNullParameter(r100, "originalCard");
        this.f91468e = r100;
        this.f91466c = r100.c();
        this.f91467d = new b(this);
        l1(new BaseHybridComponentContainerBase$init$1(this));
    }

    @Override // zy0.c
    public final void l1(Function1<? super wy0.e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke(new C1410a(this));
    }

    @Override // uh6.a
    public final void b(String r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f91468e.registerMethod(r100, new com.bytedance.android.live.revenue.platform.hybrid.impl.ui.b(r101));
    }

    @Override // uh6.a
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f91468e.sendJsEvent(r100, r101);
    }
}
