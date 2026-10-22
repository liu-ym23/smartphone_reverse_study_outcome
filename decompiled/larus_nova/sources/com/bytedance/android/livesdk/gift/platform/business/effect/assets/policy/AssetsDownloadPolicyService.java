package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class AssetsDownloadPolicyService implements o, dy0.c, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f129131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f129132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f129133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f129134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, Long> f129135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f129136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> f129137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Long, Integer> f129138h;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.core.resources.e f129139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetsDownloadPolicyService f129140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f129141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.j f129142d;

        public a(com.bytedance.android.live.core.resources.e r100, AssetsDownloadPolicyService r101, int r102, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r103) {
            this.f129139a = r100;
            this.f129140b = r101;
            this.f129141c = r102;
            this.f129142d = r103;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            boolean r100 = this.f129142d.ib(this.f129139a, null, this.f129141c, AssetDownloadPriority.NORMAL);
            this.f129140b.h(this.f129139a, r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f129143a = null;

        static {
            f129143a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public AssetsDownloadPolicyService() {
        this.f129131a = LazyKt.lazy(AssetsDownloadPolicyService$liveDownloadDynamic$2.INSTANCE);
        this.f129132b = LazyKt.lazy(AssetsDownloadPolicyService$liveAssetsUseMainThread$2.INSTANCE);
        this.f129133c = LazyKt.lazy(AssetsDownloadPolicyService$liveAssetsMangerReadSettingOptimize$2.INSTANCE);
        this.f129134d = LazyKt.lazy(AssetsDownloadPolicyService$showLog$2.INSTANCE);
        this.f129135e = new LinkedHashMap();
        this.f129136f = new ConcurrentHashMap();
        this.f129137g = new MutableLiveData();
        this.f129138h = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        return this.f129137g;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void a(JSONObject r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        Iterator<String> r101 = this.f129136f.keySet().iterator();     // Catch: JSONException -> L13
    L6:
        if (r101.hasNext() == false) goto L24;
        String r102 = r101.next();     // Catch: JSONException -> L13
        if (r100.length() >= 500) goto L25;
        Long r103 = this.f129136f.get(r102);     // Catch: JSONException -> L13
        if (r103 == null) goto L6;
        r100.put(r102, r103.longValue());     // Catch: JSONException -> L13
        goto L6
    L25:
        return;
    L24:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void f(List r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        x(r100, r101, 3);
    }

    public final void h(com.bytedance.android.live.core.resources.e r100, boolean r101) {
        if (r101 == false) goto L5;
        this.f129136f.put(String.valueOf(r100.getId()), Long.valueOf(r100.getModifyVersion()));
    L5:
        if (((Boolean) this.f129134d.getValue()).booleanValue() == false) goto L10;
        List<Pair<com.bytedance.android.live.core.resources.e, Boolean>> r102 = this.f129137g.getValue();
        if (r102 == null) goto L11;
        r102.add(new Pair(r100, Boolean.valueOf(r101)));
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void g(List<com.bytedance.android.live.core.resources.e> r210, int r211, boolean r212) {
        if (r210 != null) goto L5;
        return;
    L5:
        int r100 = 0;
        Object r101 = null;
        if (r211 != 3) goto L8;
    L62:
        ArrayList r102 = new ArrayList();
        r102.addAll(r210);
        ArrayList r103 = new ArrayList();
        i12.e r104 = i12.o.b();
        if (r104 == null) goto L65;
        m.f163449e.getClass();
        r101 = (o) m.b(r104).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.i.class));
    L65:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.i r105 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.i) r101;
        if (r105 == null) goto L70;
        List<Long> r106 = r105.k7();
        if (r106 == null) goto L70;
        r103.addAll(r106);
    L70:
        ArrayList r107 = new ArrayList();
        LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r109 = r102.iterator();
    L72:
        if (r109.hasNext() == false) goto L74;
        Object r110 = r109.next();
        r108.put(Long.valueOf(((com.bytedance.android.live.core.resources.e) r110).getId()), r110);
        goto L72
    L74:
        Map r111 = MapsKt.toMutableMap(r108);
        Iterator r112 = r103.iterator();
    L76:
        if (r112.hasNext() == false) goto L81;
        long r113 = ((Number) r112.next()).longValue();
        com.bytedance.android.live.core.resources.e r114 = (com.bytedance.android.live.core.resources.e) r111.get(Long.valueOf(r113));
        if (r114 == null) goto L80;
        r107.add(r114);
    L80:
        r111.remove(Long.valueOf(r113));
        goto L76
    L81:
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator r116 = r111.entrySet().iterator();
    L83:
        if (r116.hasNext() == false) goto L90;
        Map.Entry r117 = (Map.Entry) r116.next();
        if (((com.bytedance.android.live.core.resources.e) r117.getValue()).getDownloadType() != 1) goto L87;
        boolean r118 = true;
    L88:
        if (r118 == false) goto L83;
        r115.put(r117.getKey(), r117.getValue());
        goto L83
    L87:
        r118 = false;
        goto L88
    L90:
        r107.addAll(r115.values());
        x(r107, r212, r211);
        return;
    L8:
        if (r211 == 5) goto L62;
        if (r211 == 1006) goto L62;
        ((LinkedHashMap) this.f129138h).clear();
        i12.e r119 = i12.o.b();
        if (r119 == null) goto L15;
        m.f163449e.getClass();
        o r120 = (o) m.b(r119).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.h.class));
    L16:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.h r121 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.h) r120;
        if (r121 == null) goto L19;
        r101 = r121.X2();
    L19:
        if (r101 == null) goto L57;
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().I0() == false) goto L47;
        Iterator r122 = ((Iterable) r101).iterator();
        int r123 = 0;
    L25:
        if (r122.hasNext() == false) goto L57;
        Iterator r124 = ((List) r122.next()).iterator();
    L28:
        if (r124.hasNext() == false) goto L25;
        h1 r125 = (h1) r124.next();
        if (r125.getPrimaryEffectId() <= 0) goto L32;
        this.f129138h.put(Long.valueOf(r125.getPrimaryEffectId()), Integer.valueOf(r123));
        r123 = r123 + 1;
    L32:
        List<Long> r126 = r125.getAssetIds();
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r126.iterator();
    L34:
        if (r128.hasNext() == false) goto L43;
        Object r129 = r128.next();
        long r130 = ((Number) r129).longValue();
        if (r130 != r125.getPrimaryEffectId()) goto L38;
    L40:
        boolean r131 = false;
    L41:
        if (r131 == false) goto L34;
        r127.add(r129);
        goto L34
    L38:
        if (r130 <= 0) goto L40;
        r131 = true;
        goto L41
    L43:
        Iterator r132 = r127.iterator();
    L45:
        if (r132.hasNext() == false) goto L28;
        this.f129138h.put(Long.valueOf(((Number) r132.next()).longValue()), Integer.valueOf(r123));
        r123 = r123 + 1;
        goto L45
    L47:
        Iterator r133 = ((Iterable) r101).iterator();
    L49:
        if (r133.hasNext() == false) goto L57;
        Iterator r134 = ((List) r133.next()).iterator();
    L52:
        if (r134.hasNext() == false) goto L49;
        h1 r135 = (h1) r134.next();
        if (r135.getPrimaryEffectId() <= 0) goto L52;
        this.f129138h.put(Long.valueOf(r135.getPrimaryEffectId()), Integer.valueOf(r100));
        r100 = r100 + 1;
    L57:
        if (this.f129138h.isEmpty() == true) goto L60;
        CollectionsKt.sortWith(r210, new g(this));
    L60:
        x(r210, r212, r211);
        return;
    L15:
        r120 = null;
        goto L16
    }

    public final void x(List<com.bytedance.android.live.core.resources.e> r110, boolean r111, int r112) {
        i97.a r100 = i97.a.f488802a;
        long r101 = System.currentTimeMillis();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.j) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j.class);
        Iterator<T> r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L37;
        com.bytedance.android.live.core.resources.e r103 = (com.bytedance.android.live.core.resources.e) r113.next();
        Long r104 = (Long) ((LinkedHashMap) this.f129135e).get(Long.valueOf(r103.getId()));
        boolean r105 = false;
        if (r104 == null) goto L8;
        long r106 = r104.longValue();
    L10:
        if ((r101 - r106) <= 150000.0d) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L4;
        if (r103.getResourceType() != 5) goto L20;
        if (r111 == false) goto L4;
    L20:
        if (r103.getDownloadType() != 2) goto L22;
    L23:
        if (r111 == false) goto L27;
        if (((Boolean) this.f129131a.getValue()).booleanValue() == true) goto L27;
    L34:
        if (((Boolean) this.f129132b.getValue()).booleanValue() == true) goto L35;
        int r108 = com.bytedance.revenue.platform.api.core.rx.e.f267511a;
        Completable r109 = Completable.complete();
        int r114 = p.f267522a;
        r109.observeOn(Schedulers.single()).subscribe(new a(r103, this, r112, r102), b.f129143a);
        this.f129135e.put(Long.valueOf(r103.getId()), Long.valueOf(r101));
        goto L4
    L35:
        boolean r115 = r102.ib(r103, null, r112, AssetDownloadPriority.NORMAL);
        this.f129135e.put(Long.valueOf(r103.getId()), Long.valueOf(r101));
        h(r103, r115);
    L27:
        if (r112 != 1007) goto L29;
    L31:
        if (r105 == false) goto L34;
    L29:
        if (r112 == 4) goto L31;
        r105 = true;
        goto L31
    L22:
        if (r103.getDownloadType() != 3) goto L34;
    L12:
        r107 = false;
        goto L13
    L8:
        r106 = 0;
        goto L10
    }
}
