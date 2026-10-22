package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.p;
import i12.o;
import io.reactivex.Completable;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class AssetsDefaultDownloadPolicy implements e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f129120i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f129121j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f129122k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Long> f129123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, Integer> f129124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f129125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> f129126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f129127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f129128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f129129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j f129130h;

    public static final class a {
        public a() {
        }
    }

    public final boolean c() {
        return ((Boolean) this.f129127e.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void f(List r100, boolean r101) {
    }

    static {
        new a();
        f129120i = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveAssetsMangerReadSettingOptimize$2.INSTANCE);
        f129121j = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveAssetsUseMainThread$2.INSTANCE);
        f129122k = LazyKt.lazy(AssetsDefaultDownloadPolicy$Companion$liveDownloadDynamic$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        return this.f129126d;
    }

    public AssetsDefaultDownloadPolicy(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r100) {
        Intrinsics.checkNotNullParameter(r100, "assetsManager");
        this.f129130h = r100;
        this.f129123a = new LinkedHashMap();
        this.f129124b = new LinkedHashMap();
        this.f129126d = new MutableLiveData();
        this.f129127e = LazyKt.lazy(new AssetsDefaultDownloadPolicy$mShowLog$2(this));
        this.f129128f = new ArrayList();
        this.f129129g = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void a(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, Long>> r101 = this.f129129g.entrySet().iterator();
    L16:
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (r101.hasNext() == false) goto L24;
        Map.Entry<String, Long> r102 = r101.next();     // Catch: Exception -> L13
        if (r100.length() >= 500) goto L25;
        if (r102.getValue() == null) goto L16;
        r100.put(r102.getKey(), r102.getValue());     // Catch: Exception -> L13
        r101.remove();     // Catch: Exception -> L13
        goto L16
    L25:
        return;
    }

    public static void d(String r100, List r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.append(String.valueOf(((com.bytedance.android.live.core.resources.e) r103.next()).getId()) + ",");
        goto L4
    L6:
        jy0.b.a("AssetsDefaultDownloadPolicy", r100 + r102.toString());
    }

    public final void b(com.bytedance.android.live.core.resources.e r100, boolean r101) {
        if (r101 == false) goto L5;
        this.f129129g.put(String.valueOf(r100.getId()), Long.valueOf(r100.getModifyVersion()));
    L5:
        if (c() == false) goto L8;
        List<Pair<com.bytedance.android.live.core.resources.e, Boolean>> r102 = this.f129126d.getValue();
        Intrinsics.checkNotNull(r102);
        r102.add(new Pair(r100, Boolean.valueOf(r101)));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e
    public final void g(List<com.bytedance.android.live.core.resources.e> r210, int r211, boolean r310) {
        if (r210 != null) goto L5;
        return;
    L5:
        int r110 = 1;
        int r111 = 0;
        if (this.f129125c == false) goto L86;
        ((LinkedHashMap) this.f129124b).clear();
        if (c() == false) goto L10;
        ((ArrayList) this.f129128f).clear();
    L10:
        i12.e r100 = o.b();
        if (r100 == null) goto L13;
        m.f163449e.getClass();
        com.bytedance.android.scope.o r101 = (com.bytedance.android.scope.o) m.b(r100).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.effect.assets.h.class));
    L14:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.h r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.h) r101;
        if (r102 == null) goto L17;
        List<List<h1>> r103 = r102.X2();
    L19:
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().I0() == false) goto L54;
        if (this.f129125c == false) goto L52;
        if (r103 == null) goto L52;
        Iterator<List<h1>> r104 = r103.iterator();
        int r105 = 0;
    L26:
        if (r104.hasNext() == false) goto L50;
        List<h1> r106 = r104.next();
        if (r106 == null) goto L26;
        Iterator<h1> r107 = r106.iterator();
    L31:
        if (r107.hasNext() == false) goto L26;
        h1 r108 = r107.next();
        if (r108 == null) goto L31;
        int r112 = r105 + 1;
        this.f129124b.put(Long.valueOf(r108.getPrimaryEffectId()), Integer.valueOf(r105));
        if (r108.getAssetIds() != null) goto L37;
    L48:
        r105 = r112;
        goto L31
    L37:
        if (r108.getAssetIds().size() <= 1) goto L48;
        Iterator<T> r109 = r108.getAssetIds().iterator();
        int r113 = 0;
    L40:
        if (r109.hasNext() == false) goto L48;
        Object r114 = r109.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        long r116 = ((Number) r114).longValue();
        if (r116 == r108.getPrimaryEffectId()) goto L47;
        this.f129124b.put(Long.valueOf(r116), Integer.valueOf(r113 + r112));
    L47:
        r113 = r115;
        goto L40
    L50:
        if (c() == false) goto L73;
        jy0.b.a("AssetsDefaultDownloadPolicy", "observeState update SortIndex " + this.f129124b);
    L73:
        if (this.f129124b.size() != 0) goto L76;
        jy0.b.a("AssetsDefaultDownloadPolicy", "[sortIfNeed]-mSortIndexMap size is 0,no need sort");
        goto L86
    L76:
        if (c() == false) goto L214;
        d("before sort:", r210);
    L214:
        ArrayList r117 = new ArrayList(r210);     // Catch: Exception -> L80
        CollectionsKt.sortWith(r117, new com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.a(this));     // Catch: Exception -> L80
        r210.clear();     // Catch: Exception -> L80
        r210.addAll(r117);     // Catch: Exception -> L80
    L83:
        if (c() == false) goto L86;
        d("after sort:", r210);
        jy0.b.a("AssetsDefaultDownloadPolicy", "sort target:" + this.f129128f);
    L80:
        e = move-exception;
        e.printStackTrace();
    L52:
        jy0.b.a("AssetsDefaultDownloadPolicy", "setSortIndexOnlyPrimaryEffectId : needSort " + this.f129125c + "panelListList " + r103);
        goto L73
    L54:
        if (this.f129125c == false) goto L71;
        if (r103 == null) goto L71;
        Iterator<List<h1>> r118 = r103.iterator();
        int r119 = 0;
    L59:
        if (r118.hasNext() == false) goto L69;
        List<h1> r120 = r118.next();
        if (r120 == null) goto L59;
        Iterator<h1> r121 = r120.iterator();
    L64:
        if (r121.hasNext() == false) goto L59;
        h1 r122 = r121.next();
        if (r122 == null) goto L64;
        Map<Long, Integer> r123 = this.f129124b;
        Long r124 = Long.valueOf(r122.getPrimaryEffectId());
        Integer r125 = Integer.valueOf(r119);
        r119 = r119 + 1;
        r123.put(r124, r125);
        goto L64
    L69:
        if (c() == false) goto L73;
        jy0.b.a("AssetsDefaultDownloadPolicy", "observeState update SortIndex " + this.f129124b);
    L71:
        jy0.b.a("AssetsDefaultDownloadPolicy", "setSortIndexOnlyPrimaryEffectId : needSort " + this.f129125c + "panelListList " + r103);
        goto L73
    L17:
        r103 = null;
        goto L19
    L13:
        r101 = null;
    L86:
        if (c() == false) goto L88;
        List<Pair<com.bytedance.android.live.core.resources.e, Boolean>> r126 = this.f129126d.getValue();
        Intrinsics.checkNotNull(r126);
        r126.clear();
    L88:
        int r127 = 2;
        int r128 = 3;
        if (com.bytedance.android.livesdk.gift.platform.business.i.o().X1() == true) goto L123;
        i97.a r129 = i97.a.f488802a;
        long r130 = System.currentTimeMillis();
        Iterator<com.bytedance.android.live.core.resources.e> r131 = r210.iterator();
    L92:
        if (r131.hasNext() == false) goto L123;
        com.bytedance.android.live.core.resources.e r132 = r131.next();
        Long r133 = (Long) ((LinkedHashMap) this.f129123a).get(Long.valueOf(r132.getId()));
        if (r133 == null) goto L96;
        long r134 = r133.longValue();
    L98:
        if ((r130 - r134) <= 150000.0d) goto L100;
        boolean r135 = true;
    L102:
        if (r132.getResourceType() == r110) goto L110;
        if (r132.getResourceType() == 6) goto L110;
        if (r132.getResourceType() == 7) goto L110;
        if (r132.getResourceType() != 2) goto L92;
    L110:
        if (r135 == false) goto L92;
        if (((Boolean) f129122k.getValue()).booleanValue() == false) goto L120;
        if (r132.getDownloadType() == 2) goto L92;
        if (r132.getDownloadType() == r128) goto L92;
    L120:
        if (((Boolean) f129121j.getValue()).booleanValue() == true) goto L121;
        int r136 = com.bytedance.revenue.platform.api.core.rx.e.f267511a;
        Completable r137 = Completable.complete();
        int r138 = p.f267522a;
        r137.observeOn(Schedulers.single()).subscribe(new c(this, r132, r211, r130));
        r110 = 1;
        r128 = 3;
        goto L92
    L121:
        boolean r139 = this.f129130h.Re(r132, r211);
        this.f129123a.put(Long.valueOf(r132.getId()), Long.valueOf(r130));
        b(r132, r139);
        goto L92
    L100:
        r135 = false;
        goto L102
    L96:
        r134 = 0;
    L123:
        int r140 = 4;
        int r141 = 1007;
        int r142 = 5;
        String r143 = "$this$getLokiExtraModel";
        if (r310 == false) goto L166;
        i97.a r144 = i97.a.f488802a;
        long r145 = System.currentTimeMillis();
        Iterator<com.bytedance.android.live.core.resources.e> r212 = r210.iterator();
    L127:
        if (r212.hasNext() == false) goto L166;
        com.bytedance.android.live.core.resources.e r146 = r212.next();
        Long r147 = (Long) ((LinkedHashMap) this.f129123a).get(Long.valueOf(r146.getId()));
        if (r147 == null) goto L131;
        long r148 = r147.longValue();
    L133:
        if ((r145 - r148) <= 150000.0d) goto L135;
        boolean r149 = true;
    L136:
        if (r149 == false) goto L127;
        if (r146.getResourceType() != r142) goto L127;
        if (((Boolean) f129122k.getValue()).booleanValue() == false) goto L154;
        if (r146.getDownloadType() != 2) goto L146;
    L147:
        if (r211 == r141) goto L150;
        if (r211 == r140) goto L150;
        boolean r150 = true;
    L151:
        if (r150 == false) goto L154;
    L150:
        r150 = false;
        goto L151
    L146:
        if (r146.getDownloadType() == 3) goto L147;
    L154:
        if (((Boolean) f129121j.getValue()).booleanValue() == false) goto L156;
        boolean r151 = this.f129130h.ib(r146, null, r211, AssetDownloadPriority.NORMAL);
        this.f129123a.put(Long.valueOf(r146.getId()), Long.valueOf(r145));
        b(r146, r151);
    L158:
        if (r146.getModelRequirements() == null) goto L162;
        List<String> r152 = r146.getModelRequirements();
        Intrinsics.checkNotNull(r152);
        if (r152.isEmpty() == true) goto L162;
        cy0.e.f465759a.getClass();
        cy0.j r153 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r154 = m.b(r153).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r154);
        List<String> r155 = r146.getModelRequirements();
        Intrinsics.checkNotNull(r155);
        ((IRevBroadcastService) ((com.bytedance.live.kmp.core.c) r154)).downloadRequirements(r155);
    L162:
        Intrinsics.checkNotNullParameter(r146, r143);
        com.bytedance.android.live.core.resources.h r156 = r146.getLokiExtraModel();
        if (r156 == null) goto L165;
        cy0.e.f465759a.getClass();
        cy0.j r157 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r158 = m.b(r157).b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        Intrinsics.checkNotNull(r158);
        ((com.bytedance.android.livesdk.revenue.service.effect.c) ((com.bytedance.live.kmp.core.c) r158)).Bj(r156.o8(), com.bytedance.android.live.core.resources.i.a(r156), null);
    L165:
        r143 = r143;
        r140 = 4;
        r141 = 1007;
        r142 = 5;
        goto L127
    L156:
        int r159 = com.bytedance.revenue.platform.api.core.rx.e.f267511a;
        Completable r160 = Completable.complete();
        int r161 = p.f267522a;
        r160.observeOn(Schedulers.single()).subscribe(new d(this, r146, r211, r145));
        goto L158
    L135:
        r149 = false;
        goto L136
    L131:
        r148 = 0;
    L166:
        String r162 = r143;
        i97.a r163 = i97.a.f488802a;
        long r164 = System.currentTimeMillis();
        int r165 = r210.size();
        int r166 = 0;
    L167:
        if (r166 >= r165) goto L211;
        com.bytedance.android.live.core.resources.e r167 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r210, r166);
        Long r168 = (Long) ((LinkedHashMap) this.f129123a).get(Long.valueOf(r167.getId()));
        if (r168 == null) goto L171;
        long r169 = r168.longValue();
    L173:
        if ((r164 - r169) <= 150000.0d) goto L175;
        boolean r170 = true;
    L176:
        if (r170 == true) goto L179;
    L209:
        r166 = r166 + 1;
        r127 = 2;
        r111 = 0;
        goto L167
    L179:
        if (r167.getDownloadType() == r127) goto L185;
        if (r167.getDownloadType() == 3) goto L185;
    L200:
        if (r167.getResourceType() == 5) goto L209;
        Intrinsics.checkNotNullParameter(r167, r162);
        com.bytedance.android.live.core.resources.h r171 = r167.getLokiExtraModel();
        if (r171 == null) goto L206;
        cy0.e.f465759a.getClass();
        cy0.j r172 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r173 = m.b(r172).b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        Intrinsics.checkNotNull(r173);
        ((com.bytedance.android.livesdk.revenue.service.effect.c) ((com.bytedance.live.kmp.core.c) r173)).Bj(r171.o8(), com.bytedance.android.live.core.resources.i.a(r171), null);
    L206:
        if (((Boolean) f129121j.getValue()).booleanValue() == false) goto L208;
        boolean r174 = this.f129130h.ib(r167, null, r211, AssetDownloadPriority.NORMAL);
        this.f129123a.put(Long.valueOf(r167.getId()), Long.valueOf(r164));
        b(r167, r174);
        goto L209
    L208:
        int r175 = com.bytedance.revenue.platform.api.core.rx.e.f267511a;
        Completable r176 = Completable.complete();
        int r177 = p.f267522a;
        r176.observeOn(Schedulers.single()).subscribe(new b(this, r167, r211, r164));
    L185:
        if (((Boolean) f129122k.getValue()).booleanValue() == true) goto L188;
        if (r310 == true) goto L200;
    L188:
        if (r211 == 1007) goto L191;
        if (r211 == 4) goto L191;
        boolean r178 = true;
    L192:
        if (r178 == false) goto L200;
        if (r211 != 3) goto L196;
    L197:
        jy0.b.a("AssetsDefaultDownloadPolicy", "打开礼物面板跳过下载，资源id：" + r167.getId() + "，type：" + r167.getDownloadType());
        goto L209
    L196:
        if (r211 != 1006) goto L209;
    L191:
        r178 = false;
        goto L192
    L175:
        r170 = false;
        goto L176
    L171:
        r169 = r111;
        goto L173
    L211:
        if (c() == false) goto L269;
        jy0.b.a("AssetsDefaultDownloadPolicy", "DownloadSort:" + this.f129126d.getValue());
        MutableLiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> r179 = this.f129126d;
        r179.postValue(r179.getValue());
        return;
    }
}
