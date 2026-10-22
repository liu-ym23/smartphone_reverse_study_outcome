package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.resources.CleanStrategyType;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.AssetKevaKey;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes9.dex */
public final class LRUCleanStrategy implements com.bytedance.android.livesdk.gift.platform.business.effect.delete.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f129215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, v>> f129216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f129217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.core.resources.c> f129218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f129219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f129220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f129221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f129222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f129223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f129224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public t f129225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ResourceRecordService f129226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j f129227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final GiftResourceFileCacheService f129228n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/LRUCleanStrategy$CleanResourceResult;", "", "FILE_REMOVE_SUCCESS", "FILE_REMOVE_FAILED", "FILE_NOT_EXIST", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CleanResourceResult extends Enum<CleanResourceResult> {
        public static final CleanResourceResult FILE_NOT_EXIST = null;
        public static final CleanResourceResult FILE_REMOVE_FAILED = null;
        public static final CleanResourceResult FILE_REMOVE_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CleanResourceResult[] f129229a = null;

        static {
            CleanResourceResult r100 = new CleanResourceResult("FILE_REMOVE_SUCCESS", 0);
            FILE_REMOVE_SUCCESS = r100;
            CleanResourceResult r101 = new CleanResourceResult("FILE_REMOVE_FAILED", 1);
            FILE_REMOVE_FAILED = r101;
            CleanResourceResult r102 = new CleanResourceResult("FILE_NOT_EXIST", 2);
            FILE_NOT_EXIST = r102;
            f129229a = new CleanResourceResult[]{r100, r101, r102};
        }

        public static CleanResourceResult valueOf(String r100) {
            return (CleanResourceResult) r27.a.a(CleanResourceResult.class, r100);
        }

        public static CleanResourceResult[] values() {
            return (CleanResourceResult[]) f129229a.clone();
        }

        public CleanResourceResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((v) r100).i3()), Long.valueOf(((v) r101).i3()));
        }
    }

    public static final class c implements SingleOnSubscribe<Map<String, ? extends List<? extends String>>> {
        public c() {
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Map<String, ? extends List<? extends String>>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            LinkedHashMap r101 = new LinkedHashMap();
            iz0.a r102 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.f130726a;     // Catch: Exception -> L14
            String r103 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a(AssetKevaKey.RESOURCE_LRU_MD5_CACHE);     // Catch: Exception -> L14
            if (r103 != null) goto L6;
        L9:
            boolean r104 = true;
        L10:
            if (r104 == true) goto L12;
            Gson r105 = l97.a.f508113a;     // Catch: Exception -> L14
            KTypeProjection.Companion r106 = KTypeProjection.Companion;     // Catch: Exception -> L14
            r101.putAll((Map) r105.fromJson(r103, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, r106.invariant(Reflection.typeOf(String.class)), r106.invariant(Reflection.typeOf(List.class, r106.invariant(Reflection.typeOf(String.class))))))));     // Catch: Exception -> L14
        L12:
            r100.onSuccess(r101);     // Catch: Exception -> L14
            return;
        L6:
            if (r103.length() == 0) goto L9;
            r104 = false;
        L14:
            e = move-exception;
            r100.onError(e);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LRUCleanStrategy f129230a;

        public d(LRUCleanStrategy r100) {
            this.f129230a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Map r101 = (Map) r100;
            Boolean r102 = this.f129230a.f129226l.f129241f.getValue();
            if (r102 == null) goto L5;
            boolean r103 = r102.booleanValue();
        L6:
            if (r103 == false) goto L8;
            LRUCleanStrategy.g(this.f129230a, r101);
            jy0.b.c("GiftAssetClean", "record初始化完成", null, 4);
            return;
        L8:
            BehaviorSubject<Boolean> r104 = this.f129230a.f129226l.f129241f;
            int r105 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
            Disposable r106 = r104.observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this, r101), s.f129312a);
            this.f129230a.f129215a.add(r106);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f129231a = null;

        static {
            f129231a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.c("GiftAssetClean", "初始化错误, " + ((Throwable) r100).getMessage(), null, 4);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LRUCleanStrategy f129232a;

        public f(LRUCleanStrategy r100) {
            this.f129232a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            v r100 = (v) r210;
            com.bytedance.android.live.core.resources.e r101 = this.f129232a.f129227m.G1(r100.getAssetId());
            if (r101 == null) goto L84;
            com.bytedance.android.live.core.resources.b r102 = r101.getCleanStrategy();
            if (r102 == null) goto L85;
            long r103 = 0;
            Map<String, v> r104 = this.f129232a.f129216b.get(r102.getAssetType());
            if (r104 != null) goto L9;
        L29:
            Map<String, v> r105 = this.f129232a.f129216b.get(r102.getAssetType());
            if (r105 != null) goto L32;
            r105 = new LinkedHashMap();
        L32:
            r105.put(r100.getMd5(), r100);
            this.f129232a.f129216b.put(r102.getAssetType(), r105);
            Long r106 = (Long) ((LinkedHashMap) this.f129232a.f129217c).get(r102.getAssetType());
            if (r106 == null) goto L35;
            long r107 = r106.longValue();
        L36:
            long r108 = r107 + r100.getSize();
            this.f129232a.f129217c.put(r102.getAssetType(), Long.valueOf(r108));
        L37:
            Map<String, v> r109 = this.f129232a.f129216b.get("not_belong_poll_resource_tag");
            if (r109 == null) goto L41;
            v r110 = r109.remove(r100.getMd5());
        L41:
            if (this.f129232a.h().g0() == false) goto L81;
            com.bytedance.android.live.core.resources.c r111 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) this.f129232a.f129218d).get(r102.getAssetType());
            if (r111 == null) goto L45;
            int r112 = r111.getMaxSize();
        L47:
            if (r112 >= r108) goto L81;
            com.bytedance.live.kmp.util.c r113 = com.bytedance.live.kmp.util.c.f255167a;
            long r114 = System.currentTimeMillis() / ((long) 1000);
            LRUCleanStrategy r115 = this.f129232a;
            if ((r114 - r115.f129224j) <= r115.h().u1()) goto L81;
            LRUCleanStrategy r116 = this.f129232a;
            CleanOpportunity r117 = CleanOpportunity.IN_THE_LIVE_ROOM;
            String r118 = r102.getAssetType();
            if (r116.h().getEnable() == true) goto L54;
        L80:
            this.f129232a.f129224j = r114;
            goto L81
        L54:
            if (r116.f129216b.isEmpty() == true) goto L80;
            Disposable r119 = r116.f129222h;
            if (r119 != null) goto L59;
        L61:
            i12.e r120 = i12.o.b();
            if (r120 == null) goto L64;
            com.bytedance.android.scope.m.f163449e.getClass();
            com.bytedance.android.scope.o r121 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r120).a(Reflection.getOrCreateKotlinClass(w.class));
        L65:
            w r122 = (w) r121;
            if (r122 == null) goto L68;
            ConcurrentHashMap<String, Integer> r123 = r122.f129315a;
        L69:
            ArrayList r124 = new ArrayList();
            Map<String, v> r125 = r116.f129216b.get(r118);
            if (r125 == null) goto L72;
            r124.addAll(r125.values());
        L72:
            Long r126 = (Long) ((LinkedHashMap) r116.f129217c).get(r118);
            if (r126 == null) goto L75;
            r103 = r126.longValue();
        L75:
            long r127 = r103;
            com.bytedance.android.live.core.resources.c r128 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) r116.f129218d).get(r118);
            if (r128 == null) goto L78;
            long r129 = r128.getPoolSize();
        L79:
            long r130 = r129;
            ArrayList r131 = new ArrayList();
            r131.addAll(r116.f129226l.h());
            int r132 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
            Single r133 = Single.create(new l(r116, r124, r118, r127, r130, r131, r123, r117));
            int r134 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
            r116.f129222h = r133.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r116, r118), n.f129304a);
            goto L80
        L78:
            r129 = Long.MAX_VALUE;
            goto L79
        L68:
            r123 = null;
            goto L69
        L64:
            r121 = null;
            goto L65
        L59:
            if (r119.isDisposed() == true) goto L61;
        L45:
            r112 = Integer.MAX_VALUE;
        L81:
            this.f129232a.f129223i = true;
            return;
        L35:
            r107 = r103;
            goto L36
        L9:
            if (r104.containsKey(r100.getMd5()) != true) goto L29;
            Map<String, v> r135 = this.f129232a.f129216b.get(r102.getAssetType());
            if (r135 == null) goto L13;
            v r136 = r135.remove(r100.getMd5());
        L13:
            Map<String, v> r137 = this.f129232a.f129216b.get(r102.getAssetType());
            if (r137 == null) goto L16;
            v r138 = r137.put(r100.getMd5(), r100);
        L16:
            Long r139 = (Long) ((LinkedHashMap) this.f129232a.f129217c).get(r102.getAssetType());
            if (r139 == null) goto L19;
            r108 = r139.longValue();
        L21:
            if (r108 != r103) goto L37;
            Map<String, v> r140 = this.f129232a.f129216b.get(r102.getAssetType());
            if (r140 == null) goto L28;
            Iterator<Map.Entry<String, v>> r141 = r140.entrySet().iterator();
        L26:
            if (r141.hasNext() == false) goto L28;
            Map.Entry<String, v> r142 = r141.next();
            String r143 = r142.getKey();
            r108 = r108 + r142.getValue().getSize();
        L28:
            this.f129232a.f129217c.put(r102.getAssetType(), Long.valueOf(r108));
            goto L37
        L19:
            r108 = r103;
            goto L21
        L85:
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f129233a = null;

        static {
            f129233a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class h implements SingleOnSubscribe<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f129234a;

        public h(Map r100) {
            this.f129234a = r100;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            Map r101 = this.f129234a;
            String r102 = GsonProtectorUtils.toJson(l97.a.f508113a, r101);
            iz0.a r103 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.f130726a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.b(AssetKevaKey.RESOURCE_LRU_MD5_CACHE, r102);
        }
    }

    static {
    }

    public final com.bytedance.android.livesdk.gift.configmodel.m h() {
        return (com.bytedance.android.livesdk.gift.configmodel.m) this.f129219e.getValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final long c() {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r101 = this.f129216b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next().getKey();
        Map<String, v> r103 = this.f129216b.get(r102);
        if (r103 == null) goto L11;
        Collection<v> r104 = r103.values();
        if (r104 == null) goto L11;
        List r105 = CollectionsKt.toMutableList(r104);
        if (r105 == null) goto L11;
    L12:
        r100.put(r102, r105);
    L11:
        r105 = new ArrayList();
        goto L12
    L13:
        ArrayList r106 = new ArrayList();
        r106.addAll(this.f129226l.h());
        Iterator r107 = r100.entrySet().iterator();
        long r108 = 0;
    L15:
        if (r107.hasNext() == false) goto L29;
        List r109 = (List) ((Map.Entry) r107.next()).getValue();
        if (r109.size() <= 1) goto L19;
        CollectionsKt.sortWith(r109, new b());
    L19:
        long r110 = com.bytedance.live.kmp.util.e.b() / ((long) 1000);
        Iterator r111 = r109.iterator();
    L21:
        if (r111.hasNext() == false) goto L15;
        v r112 = (v) r111.next();
        if (i(r112, r106, r110, null) == true) goto L21;
        if ((r110 - r112.i3()) <= com.bytedance.android.livesdk.gift.platform.business.i.d().C0()) goto L21;
        jy0.b.a("GiftAssetClean", "getDeletableCacheSizeMB, 可清理礼物资源, 资源ID是：" + r112.getAssetId() + "， 资源大小是： " + r112.getSize());
        r108 = r108 + r112.getSize();
        goto L21
    L29:
        return r108 / ((long) 1024);
    }

    public final void k() {
        if (this.f129223i == false) goto L17;
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r101 = this.f129216b.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Map<String, v>> r102 = r101.next();
        String r103 = r102.getKey();
        Map<String, v> r104 = r102.getValue();
        if ((!Intrinsics.areEqual(r103, "not_belong_poll_resource_tag")) == false) goto L6;
        r100.put(r103, r104.keySet());
        goto L6
    L10:
        int r105 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r106 = Single.create(new h(r100));
        int r107 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        r106.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        this.f129223i = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void destroy() {
        k();
        this.f129215a.clear();
        Disposable r100 = this.f129222h;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void init() {
        if (h().getEnable() == true) goto L5;
        return;
    L5:
        int r100 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r101 = Single.create(new c());
        int r102 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r103 = r101.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.f129231a);
        Observable<v> r104 = this.f129226l.f129242g.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L8;
        Disposable r105 = r104.subscribe(new f(this), g.f129233a);
    L9:
        if (r105 == null) goto L11;
        this.f129215a.add(r105);
    L11:
        this.f129215a.add(r103);
        return;
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void leaveRoom() {
        k();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void b(Map<String, ? extends com.bytedance.android.live.core.resources.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyMap");
        if (h().getEnable() == false) goto L27;
        Map<String, com.bytedance.android.livesdk.gift.configmodel.g> r101 = h().K8();
        Iterator<Map.Entry<String, ? extends com.bytedance.android.live.core.resources.c>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L35;
        Map.Entry<String, ? extends com.bytedance.android.live.core.resources.c> r103 = r102.next();
        String r104 = r103.getKey();
        com.bytedance.android.live.core.resources.c r105 = r103.getValue();
        com.bytedance.android.livesdk.gift.configmodel.g r106 = r101.get(r104);
        if (r106 == null) goto L7;
        if (r105.getCleanStrategy() != CleanStrategyType.LRU.getValue()) goto L7;
        if (r105.getPoolSize() >= r106.getPoolSize()) goto L17;
    L19:
        int r107 = r106.getPoolSize();
    L21:
        if (r105.getMaxSize() >= r106.getPoolSize()) goto L23;
    L25:
        int r108 = r106.U7();
    L26:
        com.bytedance.android.live.core.resources.c r109 = (com.bytedance.android.live.core.resources.c) vh7.f.c(com.bytedance.android.live.core.resources.c.class);
        r109.setPoolSize(r107);
        r109.setCleanStrategy(r105.getCleanStrategy());
        r109.setMaxSize(r108);
        this.f129218d.put(r104, r109);
        goto L7
    L23:
        if (r105.getPoolSize() > r106.U7()) goto L25;
        r108 = r105.getMaxSize();
        goto L26
    L17:
        if (r105.getPoolSize() > r106.U7()) goto L19;
        r107 = r105.getPoolSize();
        goto L21
    L35:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void d(List<? extends com.bytedance.android.live.core.resources.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "assetList");
        ConcurrentHashMap<String, v> r101 = this.f129226l.f129238c;
        if (r101.isEmpty() == false) goto L6;
        jy0.b.c("GiftAssetClean", "resourceRecord is empty", null, 4);
        return;
    L6:
        Iterator<? extends com.bytedance.android.live.core.resources.e> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L48;
        com.bytedance.android.live.core.resources.e r103 = r102.next();
        com.bytedance.android.live.core.resources.b r104 = r103.getCleanStrategy();
        if (r104 == null) goto L8;
        if (r104.getCleanType() != CleanStrategyType.LRU.getValue()) goto L8;
        Set r105 = ((LinkedHashMap) this.f129218d).keySet();
        com.bytedance.android.live.core.resources.b r106 = r103.getCleanStrategy();
        if (r106 == null) goto L17;
        String r107 = r106.getAssetType();
    L19:
        if (CollectionsKt.contains(r105, r107) == false) goto L8;
        String r108 = this.f129227m.D1(r103.getId());
        if (r108 == null) goto L8;
        v r109 = r101.get(r108);
        if (r109 == null) goto L8;
        com.bytedance.android.live.core.resources.b r110 = r103.getCleanStrategy();
        if (r110 == null) goto L29;
        long r111 = r110.getKeepAliveTime();
    L30:
        r109.x7(r111);
        Map<String, Map<String, v>> r112 = this.f129216b;
        com.bytedance.android.live.core.resources.b r113 = r103.getCleanStrategy();
        if (r113 == null) goto L33;
        String r114 = r113.getAssetType();
    L34:
        Map<String, v> r115 = r112.get(r114);
        if (r115 != null) goto L38;
        r115 = new LinkedHashMap();
    L38:
        if (r115.containsKey(r108) == true) goto L40;
        r115.put(r108, r109);
        this.f129223i = true;
    L40:
        com.bytedance.android.live.core.resources.b r116 = r103.getCleanStrategy();
        if (r116 == null) goto L45;
        String r117 = r116.getAssetType();
        if (r117 == null) goto L45;
        this.f129216b.put(r117, r115);
    L45:
        Map<String, v> r118 = this.f129216b.get("not_belong_poll_resource_tag");
        if (r118 == null) goto L8;
        v r119 = r118.remove(r108);
        goto L8
    L33:
        r114 = null;
        goto L34
    L29:
        r111 = 0;
        goto L30
    L17:
        r107 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void e(CleanOpportunity r100) {
        Intrinsics.checkNotNullParameter(r100, "cleanOpportunity");
        if (com.bytedance.android.livesdk.gift.platform.business.effect.delete.h.f129286b[r100.ordinal()] == 1) goto L5;
        this.f129220f = false;
        return;
    L5:
        this.f129221g = false;
        this.f129225k = null;
    }

    public static final void g(LRUCleanStrategy r110, Map r111) {
        ConcurrentHashMap<String, v> r100 = r110.f129226l.f129238c;
        jy0.b.c("GiftAssetClean", "recordMap size is " + r100.size(), null, 4);
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r112 = r111.entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L20;
        Map.Entry r102 = (Map.Entry) r112.next();
        String r103 = (String) r102.getKey();
        List r104 = (List) r102.getValue();
        Map<String, v> r105 = r110.f129216b.get(r103);
        if (r105 != null) goto L8;
        r105 = new LinkedHashMap();
    L8:
        LinkedHashMap r106 = new LinkedHashMap();
        long r107 = 0;
        Iterator r108 = r104.iterator();
    L10:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();
        v r113 = r100.get(r109);
        if (r113 == null) goto L10;
        if (r105.containsKey(r109) == true) goto L17;
        r106.put(r109, r113);
        r101.put(r109, r113);
    L17:
        r107 = r107 + r113.getSize();
        goto L10
    L18:
        r106.putAll(r105);
        r110.f129216b.put(r103, r106);
        r110.f129217c.put(r103, Long.valueOf(r107));
        goto L4
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.i.b().getEnable() == false) goto L45;
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator<Map.Entry<String, v>> r115 = r100.entrySet().iterator();
    L23:
        if (r115.hasNext() == false) goto L32;
        Map.Entry<String, v> r116 = r115.next();
        String r117 = r116.getKey();
        v r118 = r116.getValue();
        if (r101.containsKey(r117) == true) goto L29;
        boolean r119 = true;
        if ((!Intrinsics.areEqual(r117, "zip")) == false) goto L29;
    L30:
        if (r119 == false) goto L23;
        r114.put(r116.getKey(), r116.getValue());
    L29:
        r119 = false;
        goto L30
    L32:
        r110.f129216b.put("not_belong_poll_resource_tag", MapsKt.toMutableMap(r114));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.a
    public final void a(CleanOpportunity r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "cleanOpportunity");
        if (com.bytedance.android.livesdk.gift.platform.business.effect.delete.h.f129285a[r100.ordinal()] != 1) goto L5;
        this.f129221g = true;
        this.f129225k = r101;
        Disposable r102 = this.f129222h;
        if (r102 == null) goto L36;
        if (r102.isDisposed() == true) goto L36;
        t r103 = this.f129225k;
        if (r103 == null) goto L66;
        r103.a();
        return;
    L66:
        return;
    L36:
        if (h().getEnable() == true) goto L38;
    L55:
        t r104 = this.f129225k;
        if (r104 == null) goto L69;
        r104.b();
        return;
    L69:
        return;
    L38:
        if (this.f129216b.isEmpty() == true) goto L55;
        t r105 = this.f129225k;
        if (r105 == null) goto L43;
        r105.c();
    L43:
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r107 = this.f129216b.entrySet().iterator();
    L45:
        if (r107.hasNext() == false) goto L54;
        Map.Entry<String, Map<String, v>> r108 = r107.next();
        String r109 = r108.getKey();
        Map<String, v> r110 = r108.getValue();
        Map<String, v> r111 = this.f129216b.get(r109);
        if (r111 == null) goto L52;
        Collection<v> r112 = r111.values();
        if (r112 == null) goto L52;
        List r113 = CollectionsKt.toMutableList(r112);
        if (r113 == null) goto L52;
    L53:
        r106.put(r109, r113);
    L52:
        r113 = new ArrayList();
        goto L53
    L54:
        ArrayList r114 = new ArrayList();
        r114.addAll(this.f129226l.h());
        int r115 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r116 = Single.create(new o(this, r106, r114));
        int r117 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        this.f129222h = r116.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this), new q(this));
        return;
    L5:
        if (h().getEnable() == true) goto L8;
    L27:
        this.f129220f = true;
        return;
    L8:
        if (this.f129216b.isEmpty() == false) goto L10;
        jy0.b.c("GiftAssetClean", "池子为空，跳过清理", null, 4);
        goto L27
    L10:
        Disposable r118 = this.f129222h;
        if (r118 != null) goto L13;
    L15:
        LinkedHashMap r119 = new LinkedHashMap();
        r119.putAll(this.f129217c);
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, v>>> r121 = this.f129216b.entrySet().iterator();
    L17:
        if (r121.hasNext() == false) goto L26;
        Map.Entry<String, Map<String, v>> r122 = r121.next();
        String r123 = r122.getKey();
        Map<String, v> r124 = r122.getValue();
        Map<String, v> r125 = this.f129216b.get(r123);
        if (r125 == null) goto L24;
        Collection<v> r126 = r125.values();
        if (r126 == null) goto L24;
        List r127 = CollectionsKt.toMutableList(r126);
        if (r127 == null) goto L24;
    L25:
        r120.put(r123, r127);
    L24:
        r127 = new ArrayList();
        goto L25
    L26:
        ArrayList r128 = new ArrayList();
        r128.addAll(this.f129226l.h());
        int r129 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r130 = Single.create(new i(this, r120, r128, r100));
        int r131 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        this.f129222h = r130.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r119), k.f129293a);
        goto L27
    L13:
        if (r118.isDisposed() == true) goto L15;
        jy0.b.c("GiftAssetClean", "上一次清理任务没有执行完成,跳过清理", null, 4);
        goto L27
    }

    public LRUCleanStrategy(ResourceRecordService r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r101, GiftResourceFileCacheService r102) {
        Intrinsics.checkNotNullParameter(r100, "recordService");
        Intrinsics.checkNotNullParameter(r101, "assetsService");
        Intrinsics.checkNotNullParameter(r102, "fileCacheService");
        this.f129226l = r100;
        this.f129227m = r101;
        this.f129228n = r102;
        this.f129215a = new CompositeDisposable();
        if (com.bytedance.android.livesdk.gift.platform.business.i.e().v3() == false) goto L5;
        Map<String, Map<String, v>> r103 = new ConcurrentHashMap();
    L6:
        this.f129216b = r103;
        this.f129217c = new LinkedHashMap();
        this.f129218d = new LinkedHashMap();
        this.f129219e = LazyKt.lazy(LRUCleanStrategy$cleanConfig$2.INSTANCE);
        return;
    L5:
        r103 = new LinkedHashMap();
        goto L6
    }

    public static boolean i(v r100, List r101, long r102, ConcurrentHashMap r110) {
        if (r101.contains(r100.getMd5()) == false) goto L7;
        jy0.b.c("GiftAssetClean", r100.getMd5() + "跳过删除, 资源ID是：" + r100.getAssetId() + ", 白名单更新时间 " + r100.i3(), null, 4);
        return true;
    L7:
        if (r102 > r100.J0()) goto L10;
        jy0.b.c("GiftAssetClean", r100.getMd5() + "跳过删除, 资源ID是:" + r100.getAssetId() + ", server保活时间为 " + r100.J0(), null, 4);
        return true;
    L10:
        if (r110 == null) goto L17;
        Integer r103 = (Integer) r110.get(r100.getMd5());
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r103.intValue() <= 0) goto L20;
        jy0.b.c("GiftAssetClean", r100.getMd5() + "跳过删除, 资源ID是:" + r100.getAssetId() + ", 跳过原因：正在播放", null, 4);
        return true;
    L20:
        return false;
    L17:
        return false;
    }

    public static /* synthetic */ boolean j(LRUCleanStrategy r100, v r101, List r102, long r103) {
        r100.getClass();
        return i(r101, r102, r103, null);
    }

    public static final CleanResourceResult f(LRUCleanStrategy r110, v r111, long r112, CleanOpportunity r113, String r114) {
        r110.getClass();
        String r100 = r111.getMd5();
        StringBuilder r101 = new StringBuilder();
        r101.append(r110.f129228n.f());
        int r102 = uy0.a.f552061a;
        r101.append(HTTP.URL_DEFAULT);
        r101.append(r100);
        r101.append(HTTP.URL_DEFAULT);
        String r103 = r101.toString();
        com.bytedance.android.livesdk.gift.configmodel.g r104 = r110.h().K8().get(r114);
        if (r104 == null) goto L5;
        long r105 = r104.d5();
    L7:
        if (r105 > 0) goto L10;
        r105 = r110.h().d3();
    L10:
        uy0.b r106 = (uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        if (r106.Y4(r103) == false) goto L27;
        boolean r107 = r106.J(r103);
        if (r107 == true) goto L15;
    L23:
        if (r107 == false) goto L29;
        return CleanResourceResult.FILE_REMOVE_SUCCESS;
    L29:
        return CleanResourceResult.FILE_REMOVE_FAILED;
    L15:
        if (r113 != CleanOpportunity.MANUAL_CLEAN_IN_ROOM) goto L19;
        String r108 = "pop_up";
    L17:
        String r109 = r108;
        jy0.b.c("GiftAssetClean", r111.getMd5() + "执行删除, 资源ID是：" + r111.getAssetId(), null, 4);
        int r115 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.f129081a;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r111.getAssetId(), r112 - r111.i3(), r111.getMd5(), r109, null, r113, r114, 16);
        goto L23
    L19:
        if ((r112 - r111.i3()) <= r105) goto L21;
        r108 = "expire_clean";
        goto L17
    L21:
        r108 = "lru_clean";
        goto L17
    L27:
        return CleanResourceResult.FILE_NOT_EXIST;
    L5:
        r105 = 0;
        goto L7
    }
}
