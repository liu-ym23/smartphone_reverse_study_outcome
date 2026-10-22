package com.bytedance.android.live.revenue.platform.stream.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import yz0.k;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o, d01.a, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject f91675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f91676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Observable<JsonObject> f91677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d01.b f91678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f91679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final or2.e f91680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f91681g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.stream.impl.a$a, reason: collision with other inner class name */
    public static final class C1419a {
    }

    public static final class b implements d01.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, Pair<Object, d01.b.a>> f91682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d01.b f91683b;

        public b() {
            this.f91682a = new HashMap();
        }

        @Override // d01.b
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            d01.b r101 = this.f91683b;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        L6:
            this.f91682a.remove(r100);
        }

        @Override // d01.b
        public final void a(String r100, Object r101, d01.b.a r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            Intrinsics.checkNotNullParameter(r102, "attributes");
            d01.b r103 = this.f91683b;
            if (r103 == null) goto L6;
            r103.a(r100, r101, r102);
            return;
        L6:
            this.f91682a.put(r100, TuplesKt.to(r101, r102));
        }
    }

    public static final class c implements d01.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f91684a;

        public c(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "liveCore");
            this.f91684a = r100;
        }

        @Override // d01.b
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f91684a.X();
        }

        @Override // d01.b
        public final void a(String r100, Object r101, d01.b.a r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            Intrinsics.checkNotNullParameter(r102, "attributes");
            d0 r103 = this.f91684a;
            int r104 = r102.f466180a;
            r103.X();
        }
    }

    public static final class d implements d01.b {
        public d() {
        }

        @Override // d01.b
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            throw new UnsupportedOperationException();
        }

        @Override // d01.b
        public final void a(String r100, Object r101, d01.b.a r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            Intrinsics.checkNotNullParameter(r102, "attributes");
            throw new UnsupportedOperationException();
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f91685a = null;

        static {
            f91685a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            JsonObject r102 = (JsonObject) GsonHelper.get().fromJson(r101, JsonObject.class);     // Catch: Throwable -> L7
            if (r102 != null) goto L12;
            return new JsonObject();
        L12:
            return r102;
        L7:
            th = move-exception;
            jy0.b.c("SeiServiceImpl", "failed to decode sei data: " + th + ": " + r101, null, 4);
            return new JsonObject();
        }
    }

    public static final class f<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f91686a;

        public f(String r100) {
            this.f91686a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.has(this.f91686a);
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f91687a;

        public g(String r100) {
            this.f91687a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.get(this.f91687a);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f91688a = null;

        static {
            f91688a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.d("SeiServiceImpl", "push stream success");
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f91689a;

        public i(a r100) {
            this.f91689a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return this.f91689a.f91681g.getRoomContext().getLiveStream().b();
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f91690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d01.b f91691b;

        public j(a r100, d01.b r101) {
            this.f91690a = r100;
            this.f91691b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.revenue.pushstream.a r101 = (com.bytedance.android.livesdk.revenue.pushstream.a) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L5;
            d0 r102 = r101.A();
        L7:
            if (r102 == null) goto L13;
            c r103 = new c(r102);
            b r104 = (b) this.f91691b;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r103, "other");
            Iterator<Map.Entry<String, Pair<Object, d01.b.a>>> r105 = r104.f91682a.entrySet().iterator();
        L10:
            if (r105.hasNext() == false) goto L12;
            Map.Entry<String, Pair<Object, d01.b.a>> r106 = r105.next();
            String r107 = r106.getKey();
            Pair<Object, d01.b.a> r108 = r106.getValue();
            r103.a(r107, r108.component1(), r108.component2());
            goto L10
        L12:
            r104.f91682a.clear();
            r104.f91683b = r103;
            this.f91690a.f91678d = r103;
            jy0.b.d("SeiServiceImpl", "SEI writer is initialized");
            return;
        L13:
            jy0.b.c("SeiServiceImpl", "liveCore is null", null, 4);
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // d01.a
    public final d01.b E3() {
        d01.b r100 = this.f91678d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_seiWriter");
    L5:
        return r100;
    }

    @Override // yz0.m
    public final void i() {
        this.f91675a.onComplete();
        d01.b r100 = this.f91678d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_seiWriter");
    L6:
        if ((r100 instanceof b) == false) goto L9;
        RxUtilKt.b(this.f91679e.getDataCenter(), "cmd_anchor_broadcast_start", true).take(1).doOnNext(h.f91688a).flatMapMaybe(new i(this)).takeUntil(this.f91676b).subscribe(new j(this, r100));
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f91679e.isAnchor() == false) goto L5;
        d01.b r100 = new b();
    L6:
        this.f91678d = r100;
        return;
    L5:
        r100 = new d();
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f91676b.onComplete();
        this.f91678d = new d();
    }

    @Override // d01.a
    public final Observable<JsonObject> ri() {
        return this.f91677c;
    }

    @Override // d01.a
    public final Observable<JsonElement> o6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f91677c.filter(new f(r100)).map(new g(r100));
    }

    public a(k r100, or2.e r101, com.bytedance.android.livesdk.revenue.service.room.c r102) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "roomPlayer");
        Intrinsics.checkNotNullParameter(r102, "roomService");
        this.f91679e = r100;
        this.f91680f = r101;
        this.f91681g = r102;
        PublishSubject r103 = PublishSubject.create();
        this.f91675a = r103;
        PublishSubject r104 = PublishSubject.create();
        this.f91676b = r104;
        this.f91677c = RxUtilKt.h(Observable.concat(r103, Observable.create(new com.bytedance.android.live.revenue.platform.stream.impl.b(this))).observeOn(Schedulers.computation()).map(e.f91685a)).takeUntil(RxUtilKt.h(r104)).share();
    }
}
