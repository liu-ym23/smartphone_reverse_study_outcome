package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p implements ObservableOnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f91325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f91326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f91327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f91328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f91329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f91330f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f91331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91332b;

        public a(p r100, ObservableEmitter r101) {
            this.f91331a = r100;
            this.f91332b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.platform.aio.a r101 = (com.bytedance.platform.aio.a) r100;
            p r102 = this.f91331a;
            if (((ArrayList) r102.f91325a.f91316d).contains(r102.f91328d) == true) goto L8;
            p r103 = this.f91331a;
            m r104 = r103.f91325a;
            Set r105 = r103.f91327c;
            r104.getClass();
            com.bytedance.android.live.revenue.platform.container.impl.core.g.a r106 = com.bytedance.android.live.revenue.platform.container.impl.core.g.D0;
            CenterServiceType r107 = CenterServiceType.PRE_CENTER_SERVICE;
            r106.getClass();
            if (Intrinsics.areEqual(r105, com.bytedance.android.live.revenue.platform.container.impl.core.g.a.a(r107)) == true) goto L8;
            this.f91332b.onError(com.bytedance.platform.aio.d.f(this.f91331a.f91328d));
            return;
        L8:
            jy0.b.d("[AioLink]", "invokeMethod, interfaceId: " + this.f91331a.f91328d + ", methodId: " + this.f91331a.f91329e);
            p r108 = this.f91331a;
            com.bytedance.revenue.platform.api.core.rx.f.a(r101.c(r108.f91328d, r108.f91329e, r108.f91330f).f497465a.subscribe(new n(this), new o(this)), this.f91331a.f91326b);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f91333a;

        public b(ObservableEmitter r100) {
            this.f91333a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ObservableEmitter r101 = this.f91333a;
            r101.onError((Throwable) r100);
        }
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r100.setDisposable(this.f91326b);
        m r101 = this.f91325a;
        Set r102 = this.f91327c;
        String r103 = this.f91328d;
        com.bytedance.revenue.platform.api.core.rx.f.a(r101.f91313a.filter(new q(r102)).firstOrError().map(new r(r103)).subscribe(new a(this, r100), new b(r100)), this.f91326b);
    }

    public p(m r100, CompositeDisposable r101, Set r102, String r103, String r104, z r105) {
        this.f91325a = r100;
        this.f91326b = r101;
        this.f91327c = r102;
        this.f91328d = r103;
        this.f91329e = r104;
        this.f91330f = r105;
    }
}
