package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.dress.backend.DressBackendProcessor;
import com.bytedance.android.live.revenue.common.l0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CompositeDisposable f87118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.live.profit.dress.b f87119b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DressLocalDataSource f87120c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f87121d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f87122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f87123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f87124g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f87125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f87126i = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f87127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f87128b;

        public a(long r100, long r101) {
            this.f87127a = r100;
            this.f87128b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            ExtraResponse r111 = (ExtraResponse) r110;
            Intrinsics.checkNotNullParameter(r111, "resp");
            com.bytedance.live.kmp.util.c r100 = com.bytedance.live.kmp.util.c.f255167a;
            long r101 = System.currentTimeMillis() - this.f87127a;
            com.bytedance.android.livedress.impl.o r102 = com.bytedance.android.livedress.impl.o.f102909a;
            String r103 = j.f87125h;
            String r104 = ((n) r111.data).getVersion();
            String r105 = "";
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            Intrinsics.checkNotNullParameter(r103, "localVersion");
            Intrinsics.checkNotNullParameter(r104, "remoteVersion");
            JSONObject r106 = com.bytedance.android.livedress.impl.o.b(r102, true, null, 6);
            JSONObject r107 = com.bytedance.android.livedress.impl.o.d(Long.valueOf(r101));
            JSONObject r108 = new JSONObject();
            com.bytedance.android.livedress.impl.o.m(r108, "room_id", com.bytedance.android.livedress.impl.o.e());
            com.bytedance.android.livedress.impl.o.m(r108, "local_version", r103);
            com.bytedance.android.livedress.impl.o.m(r108, "remote_version", r104);
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_all", r106, r107, r108);
            List<p> r109 = ((n) r111.data).getDressList();
            if ((!r109.isEmpty()) == false) goto L12;
            String r112 = ((n) r111.data).getVersion();
            if (r112 == null) goto L11;
            r105 = r112;
        L11:
            j.f87125h = r105;
            j.f87120c.a(r109);
            r r113 = j.f87121d;
            String r114 = j.f87125h;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r109, "list");
            Intrinsics.checkNotNullParameter(r114, "version");
            iz0.a r115 = i.f87115a;
            Intrinsics.checkNotNullParameter(r109, "list");
            Intrinsics.checkNotNullParameter(r114, "version");
            int r116 = com.bytedance.revenue.platform.api.core.rx.e.f267511a;
            Completable.merge(com.bytedance.revenue.platform.api.core.c.a(new Completable[]{i.f87115a.clear(), i.f87116b.clear()})).subscribe(new h(r109, r114));
            jy0.b.c("DressRepository", "Fetch all dress succeed. size=" + r109.size() + ", version=" + j.f87125h, null, 4);
        L13:
            j.f87122e = this.f87128b;
            return j.f87125h;
        L12:
            jy0.b.c("DressRepository", "Fetch all dress succeed with no update", null, 4);
            goto L13
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f87129a = null;

        static {
            f87129a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            com.bytedance.android.livedress.impl.o r102 = com.bytedance.android.livedress.impl.o.f102909a;
            String r103 = h40.e.a(r101);
            Intrinsics.checkNotNullParameter(r101, "$this$errorCode");
            if ((r101 instanceof ApiServerException) == false) goto L5;
            int r104 = ((ApiServerException) r101).getErrorCode();
        L6:
            Intrinsics.checkNotNullParameter(r103, "errorMsg");
            JSONObject r105 = com.bytedance.android.livedress.impl.o.a(false, r103, Integer.valueOf(r104));
            JSONObject r106 = com.bytedance.android.livedress.impl.o.d(null);
            JSONObject r107 = new JSONObject();
            com.bytedance.android.livedress.impl.o.m(r107, "room_id", com.bytedance.android.livedress.impl.o.e());
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_all", r105, r106, r107);
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_error", r105, r106, r107);
            jy0.b.c("DressRepository", "Fetch all dress failed. " + h40.e.a(r101), null, 4);
            return;
        L5:
            r104 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zt0.b f87130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f87131b;

        public c(zt0.b r100, String r101) {
            this.f87130a = r100;
            this.f87131b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List<p> r101 = ((n) ((ExtraResponse) r100).data).getDressList();
            if ((!r101.isEmpty()) == false) goto L5;
            j.f87120c.a(r101);
        L5:
            zt0.b r102 = this.f87130a;
            if (r102 == null) goto L9;
            r102.a(this.f87131b);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zt0.b f87132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f87133b;

        public d(zt0.b r100, String r101) {
            this.f87132a = r100;
            this.f87133b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            jy0.b.c("DressRepository", "Fetch dress by ids failed. " + h40.e.a(r101), null, 4);
            zt0.b r102 = this.f87132a;
            if (r102 == null) goto L10;
            String r103 = this.f87133b;
            String r104 = j.f87125h;
            Intrinsics.checkNotNullParameter(r101, "$this$errorCode");
            if ((r101 instanceof ApiServerException) == false) goto L7;
            int r105 = ((ApiServerException) r101).getErrorCode();
        L8:
            r102.b(r103, r104, r105, h40.e.a(r101));
            return;
        L7:
            r105 = -1;
            goto L8
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f87134a;

        public e(String r100) {
            this.f87134a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            int r101 = DressBackendProcessor.f87081a;
            if (l0.a("dress") == true) goto L7;
            CompositeDisposable r102 = j.f87118a;
            return j.a(this.f87134a);
        L7:
            return DressBackendProcessor.a(this.f87134a, new DressRepository$onChangeRoom$1$1(this), new DressRepository$onChangeRoom$1$2(this), j.f87118a);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f87135a = null;

        static {
            f87135a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            String r101 = (String) r100;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f87136a = null;

        static {
            f87136a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.c("DressRepository", "Fetch all dress failed. " + h40.e.a((Throwable) r100), null, 4);
        }
    }

    public j() {
    }

    static {
        f87126i = new j();
        f87118a = new CompositeDisposable();
        f87119b = new com.bytedance.android.live.profit.dress.b();
        f87120c = new DressLocalDataSource();
        f87121d = new r();
        f87124g = new LinkedHashSet();
        f87125h = "";
    }

    public static Single a(String r110) {
        com.bytedance.live.kmp.util.c r100 = com.bytedance.live.kmp.util.c.f255167a;
        long r101 = System.currentTimeMillis();
        long r102 = System.currentTimeMillis();
        if ((r101 - f87122e) <= 1500) goto L11;
        com.bytedance.android.live.profit.dress.b r103 = f87119b;
        String r104 = f87125h;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "version");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        int r105 = zt0.a.f573561a;
        Intrinsics.checkNotNullParameter(r104, "version");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        tz0.b r106 = tz0.b.f548039a;
        uz0.c r107 = new uz0.c();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "$this$beforeConfigureRequest");
        Map<String, String> r108 = r107.f552161b;
        Intrinsics.checkNotNullParameter(r108, "queriesMap");
        Intrinsics.checkNotNullParameter("version", "$this$setTo");
        if (r104 == null) goto L7;
        r108.put("version", r104);
    L7:
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r110 == null) goto L10;
        r108.put("room_id", r110);
    L10:
        Intrinsics.checkNotNullParameter(r107, "$this$afterConfigureRequest");
        Observable r109 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/dress/list/", TypesJVMKt.getJavaType(Reflection.typeOf(n.class)), Extra.class, r107.f552163d, r107.f552160a, r107.f552161b, r107.f552162c);
        int r111 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r112 = r109.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        h40.a r113 = new h40.a();
        Intrinsics.checkNotNullParameter(r112, "$this$retryWhenCompat");
        return r112.retryWhen(new h40.d(3, r113, 1000)).map(new a(r102, r101)).firstOrError().doOnError(b.f87129a).subscribeOn(Schedulers.io());
    L11:
        int r114 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        return Single.just(f87125h);
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        if (f87125h.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        f87121d.getClass();
        iz0.a r102 = i.f87115a;
        int r103 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r104 = i.f87115a.getString();
        Single r105 = i.f87116b.getString();
        final DressKevaUtils$load$1 r106 = DressKevaUtils$load$1.INSTANCE;
        Single r107 = Single.zip(r104, r105, new com.bytedance.android.live.profit.dress.e(r106)).flatMap(com.bytedance.android.live.profit.dress.g.f87110a).map(k.f87137a);
        int r108 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Single r109 = r107.subscribeOn(Schedulers.io());
    L9:
        Single r110 = r109.flatMap(new e(r100));
        int r111 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r110.subscribeOn(Schedulers.io()).subscribe(f.f87135a, g.f87136a), f87118a);
        return;
    L8:
        int r112 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        r109 = Single.just(f87125h);
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public static com.bytedance.android.live.profit.dress.d e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        DressLocalDataSource r102 = f87120c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Map r103 = (Map) ((LinkedHashMap) r102.f87069c).get(Integer.valueOf(r101));
        if (r103 == null) goto L5;
        com.bytedance.android.live.profit.dress.d r104 = (com.bytedance.android.live.profit.dress.d) r103.get(r100);
    L7:
        if ((r104 instanceof com.bytedance.android.live.profit.dress.d) == true) goto L10;
        return null;
    L10:
        return r104;
    L5:
        r104 = null;
        goto L7
    }

    public static void b(String r100, String r101, zt0.b r102) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        com.bytedance.live.kmp.util.c r103 = com.bytedance.live.kmp.util.c.f255167a;
        long r104 = System.currentTimeMillis();
        if ((r104 - f87123f) <= 1500) goto L5;
        c(r100, r101, r102);
        f87123f = r104;
        Set<String> r105 = f87124g;
        r105.clear();
        r105.add(r100);
        return;
    L5:
        Set<String> r106 = f87124g;
        if (r106.contains(r100) == true) goto L10;
        c(r100, r101, r102);
        r106.add(r100);
        return;
    }

    public static void c(String r110, String r111, zt0.b r112) {
        f87119b.getClass();
        Intrinsics.checkNotNullParameter(r110, "dressId");
        Intrinsics.checkNotNullParameter(r111, "roomId");
        int r100 = zt0.a.f573561a;
        Intrinsics.checkNotNullParameter(r110, "dressId");
        Intrinsics.checkNotNullParameter(r111, "roomId");
        tz0.b r101 = tz0.b.f548039a;
        uz0.c r102 = new uz0.c();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "$this$beforeConfigureRequest");
        Map<String, String> r103 = r102.f552161b;
        Intrinsics.checkNotNullParameter(r103, "queriesMap");
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r111 == null) goto L5;
        r103.put("room_id", r111);
    L5:
        Intrinsics.checkNotNullParameter("dress_id", "$this$setTo");
        if (r110 == null) goto L8;
        r103.put("dress_id", r110);
    L8:
        Intrinsics.checkNotNullParameter(r102, "$this$afterConfigureRequest");
        Observable r113 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/dress/list/", TypesJVMKt.getJavaType(Reflection.typeOf(n.class)), Extra.class, r102.f552163d, r102.f552160a, r102.f552161b, r102.f552162c);
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r113.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).singleOrError().subscribe(new c(r112, r110), new d(r112, r110)), f87118a);
    }
}
