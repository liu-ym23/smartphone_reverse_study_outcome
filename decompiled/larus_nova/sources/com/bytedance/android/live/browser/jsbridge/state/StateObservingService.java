package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.annie.api.data.subscribe.g;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.revenue.ILiveRevenueService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import j30.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class StateObservingService implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> f63906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashSet f63907b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StateObservingService f63908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.state.a f63909b;

        public a(StateObservingService r100, com.bytedance.android.live.browser.jsbridge.state.a r101) {
            this.f63908a = r100;
            this.f63909b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r102 = this.f63908a.f63906a;
            ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
            r103.put(this.f63909b.getKey(), this.f63909b);
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StateObservingService f63910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.state.a f63911b;

        public b(StateObservingService r100, com.bytedance.android.live.browser.jsbridge.state.a r101) {
            this.f63910a = r100;
            this.f63911b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.bytedance.android.live.browser.jsbridge.state.a r100 = this.f63911b;
            if ((r100 instanceof BaseObservableState) == true) goto L5;
            r100 = null;
        L5:
            BaseObservableState r101 = (BaseObservableState) r100;
            if (r101 == null) goto L8;
            r101.i();
        L8:
            this.f63910a.e(this.f63911b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends com.bytedance.android.live.browser.jsbridge.state.c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final i.e<T> f63912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Object f63913g;

        @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
        public final void i() {
        }

        @Override // com.bytedance.android.live.browser.jsbridge.state.a
        public final i.f d() {
            return this.f63912f;
        }

        public c(i.e r100, Object r101, Object r102) {
            this.f63913g = r101;
            super(r102);
            this.f63912f = r100;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends com.bytedance.android.annie.api.data.subscribe.b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i.e f63914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f63915d;

        @Override // com.bytedance.android.annie.api.data.subscribe.e
        public final void onRelease() {
        }

        @Override // com.bytedance.android.annie.api.data.subscribe.g
        public final String key() {
            return this.f63914c.a();
        }

        public d(i.e r100, Object r101, Object r102) {
            this.f63914c = r100;
            this.f63915d = r101;
            super(r102);
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final Map<String, i.c> a() {
        return this.f63906a;
    }

    public StateObservingService(Gson r100) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        this.f63906a = new ConcurrentHashMap();
        this.f63907b = new ConcurrentHashSet();
        c(new com.bytedance.android.live.browser.jsbridge.state.observable.e(0)).subscribe();
        c(new com.bytedance.android.live.browser.jsbridge.state.observable.d()).subscribe();
        d(new j30.e());
        d(new j30.a());
        d(new j30.c());
        d(new h());
        d(new j30.i());
        d(new j30.f());
        ((ILiveRevenueService) k.n(ILiveRevenueService.class)).getHybridService().D3(r100, AnonymousClass1.INSTANCE);
    }

    public final synchronized <T> Observable<Unit> c(com.bytedance.android.live.browser.jsbridge.state.a<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L6
        Observable<T> r101 = Observable.empty().doOnSubscribe(new a(this, r100)).doOnDispose(new b(this, r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final <T> void d(com.bytedance.android.live.browser.jsbridge.state.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r101 = this.f63906a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100.getKey(), r100);
    }

    public final synchronized <T> void e(com.bytedance.android.live.browser.jsbridge.state.a<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "state");     // Catch: Throwable -> L8
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r101 = this.f63906a;     // Catch: Throwable -> L8
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;     // Catch: Throwable -> L8
        if (Intrinsics.areEqual((com.bytedance.android.live.browser.jsbridge.state.a) r102.get(r100.getKey()), r100) == false) goto L6;
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r103 = this.f63906a;     // Catch: Throwable -> L8
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L8
        r104.remove(r100.getKey());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final <T> void registerStaticState(Function1<? super DataCenter, ? extends i.a<? extends T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "stateCreation");
        this.f63907b.add(r100);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final <T> void b(i.e<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        com.bytedance.android.live.browser.jsbridge.state.a r102 = (com.bytedance.android.live.browser.jsbridge.state.a) ((ConcurrentHashMap) this.f63906a).get(r100.a());
        Unit r103 = null;
        if (r102 != null) goto L5;
        ((ConcurrentHashMap) this.f63906a).put(r100.a(), new c(r100, r101, r101));
    L18:
        com.bytedance.android.annie.service.data.b r104 = com.bytedance.android.annie.service.data.b.f39869a;
        g r105 = com.bytedance.android.annie.service.data.b.a(r100.a());
        if (r105 != null) goto L21;
    L34:
        com.bytedance.android.annie.service.data.b.b(new d(r100, r101, r101));
        Unit r106 = Unit.INSTANCE;
        return;
    L21:
        if ((r105 instanceof com.bytedance.android.annie.api.data.subscribe.b) == true) goto L23;
        g r107 = null;
    L24:
        com.bytedance.android.annie.api.data.subscribe.b r108 = (com.bytedance.android.annie.api.data.subscribe.b) r107;
        if (r108 == null) goto L28;
        r108.f38405b = r101;
    L28:
        if ((r105 instanceof BaseDataObsProvider) == true) goto L30;
        r105 = null;
    L30:
        BaseDataObsProvider r109 = (BaseDataObsProvider) r105;
        if (r109 == null) goto L33;
        r109.i(r101);
        r103 = Unit.INSTANCE;
    L33:
        if (r103 == null) goto L34;
        return;
    L23:
        r107 = r105;
        goto L24
    L5:
        if ((r102 instanceof com.bytedance.android.live.browser.jsbridge.state.c) == true) goto L7;
        com.bytedance.android.live.browser.jsbridge.state.a r110 = null;
    L8:
        com.bytedance.android.live.browser.jsbridge.state.c r111 = (com.bytedance.android.live.browser.jsbridge.state.c) r110;
        if (r111 == null) goto L12;
        r111.f63951e = r101;
    L12:
        if ((r102 instanceof BaseObservableState) == true) goto L14;
        r102 = null;
    L14:
        BaseObservableState r112 = (BaseObservableState) r102;
        if (r112 == null) goto L18;
        r112.h(r101);
        goto L18
    L7:
        r110 = r102;
        goto L8
    }
}
