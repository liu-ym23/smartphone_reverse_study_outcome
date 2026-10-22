package com.bytedance.android.live.v3;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombinCharacterInfo;
import com.bytedance.android.live.strategy.api.CombineBaseInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseFactorProcessorV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<CombineInfo> f102548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f102549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<sb1.a> f102550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f102551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f102552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f102553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f102554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f102555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f102556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f102557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f102558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f102559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, List<CombineInfo>> f102560m;

    public abstract LiveData f(CombineInfo r100, LiveData r101);

    public BaseFactorProcessorV3() {
        this.f102549b = new d();
        this.f102550c = new ArrayList();
        this.f102551d = new LinkedHashMap();
        this.f102552e = new LinkedHashMap();
        this.f102553f = new LinkedHashMap();
        this.f102554g = new b();
        new ConcurrentHashMap();
        this.f102555h = new ArrayList();
        this.f102556i = new LinkedHashMap();
        this.f102557j = LazyKt.lazy(BaseFactorProcessorV3$updateReportEnable$2.INSTANCE);
        this.f102558k = LazyKt.lazy(BaseFactorProcessorV3$logOnlyInDebug$2.INSTANCE);
        this.f102560m = new LinkedHashMap();
    }

    public final boolean a() {
        if (v.a() == false) goto L5;
        return true;
    L5:
        if (v.a() == false) goto L7;
        return false;
    L7:
        if (((Boolean) this.f102558k.getValue()).booleanValue() == false) goto L14;
        return false;
    L14:
        return true;
    }

    public final Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chName");
        Object r101 = com.bytedance.android.live.impl.a.a(r100);
        if (a() == false) goto L5;
        ALogger.i("strategy_tag", "curent character " + r100 + " is " + r101);
    L5:
        if (r101 != null) goto L7;
        ((ArrayList) this.f102555h).add(r100);
    L7:
        return r101;
    }

    public final void e(List<CombineInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "combineInfos");
        this.f102548a = r100;
        ((LinkedHashMap) this.f102551d).clear();
        ((LinkedHashMap) this.f102552e).clear();
        ((LinkedHashMap) this.f102556i).clear();
        ((LinkedHashMap) this.f102560m).clear();
        StrategyTeaLogHelper.f69235a.clear();
        LinkedHashMap r101 = new LinkedHashMap();
        List<CombineInfo> r102 = this.f102548a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");
    L5:
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        CombineInfo r104 = (CombineInfo) r103.next();
        CopyOnWriteArrayList<CombbineFactorInfo> r105 = r104.getFaList();
        if (r105 == null) goto L7;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L7;
        String r107 = ((CombbineFactorInfo) r106.next()).getFaName();
        if (r107 == null) goto L12;
        Object r108 = r101.get(r107);
        if (r108 != null) goto L18;
        r108 = new ArrayList();
        r101.put(r107, r108);
    L18:
        ((List) r108).add(r104);
        goto L12
    L19:
        Iterator r109 = r101.entrySet().iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        Map.Entry r110 = (Map.Entry) r109.next();
        String r111 = (String) r110.getKey();
        List r112 = (List) r110.getValue();
        this.f102560m.put(r111, CollectionsKt.sortedWith(r112, new a()));
        goto L21
    L23:
        List<sb1.a> r113 = this.f102550c;
        ArrayList r114 = (ArrayList) r113;
        if (r114.contains(this.f102554g) == true) goto L26;
        List<sb1.a> r115 = this.f102550c;
        ArrayList r116 = (ArrayList) r115;
        r116.add(this.f102554g);
    L26:
        this.f102559l = true;
    }

    public void update(String r100, StrategyMutableLiveData<Object> r110, Map<String, Object> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "characterCache");
        if (r110.getValue() != null) goto L5;
        return;
    L5:
        ((ArrayList) this.f102555h).clear();
        Object r101 = r110.getValue();
        Intrinsics.checkNotNull(r101);
        StrategyMutableLiveData r102 = c(r100, null, r101, r110, r111, r112);
        if (r102 == null) goto L9;
        r102.getValue();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.android.live.strategy.api.StrategyMutableLiveData] */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.bytedance.android.live.strategy.api.StrategyMutableLiveData] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [long] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.util.List] */
    public final synchronized StrategyMutableLiveData c(final String r210, final String r211, final Object r212, final StrategyMutableLiveData r213, final Map r214, final boolean r310) {
        String r100 = r210;
        Object r110 = r212;
        StrategyMutableLiveData r111 = r213;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "faName");     // Catch: Throwable -> L178
        Intrinsics.checkNotNullParameter(r111, "data");     // Catch: Throwable -> L178
        Intrinsics.checkNotNullParameter(r214, "characterCache");     // Catch: Throwable -> L178
        if (this.f102559l == false) goto L176;
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L178
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L171 Throwable -> L178
        Ref.ObjectRef r114 = new Ref.ObjectRef();     // Catch: Exception -> L171 Throwable -> L178
        ?? r101 = (List) ((LinkedHashMap) this.f102560m).get(r100);     // Catch: Exception -> L171 Throwable -> L178
        r114.element = r101;     // Catch: Exception -> L171 Throwable -> L178
        List r102 = (List) r101;     // Catch: Exception -> L171 Throwable -> L178
        if (r102 != null) goto L181;
    L164:
        String r115 = r100;
        StrategyMutableLiveData r116 = r111;
        if (a() == false) goto L168;
        ALogger.i("strategy_tag", "No strategy data or op matches " + r115 + ' ');     // Catch: Throwable -> L178
    L168:
        r116.setValue(r212);     // Catch: Throwable -> L178
        monitor-exit(this);
        return r116;
    L181:
        Iterator r117 = r102.iterator();     // Catch: Exception -> L161 Throwable -> L178
    L10:
        if (r117.hasNext() == false) goto L164;
        CombineInfo r103 = (CombineInfo) r117.next();     // Catch: Exception -> L161 Throwable -> L178
        CopyOnWriteArrayList<CombinCharacterInfo> r104 = r103.getChList();     // Catch: Exception -> L161 Throwable -> L178
        if (r104 != null) goto L15;
        final Map r105 = MapsKt.emptyMap();     // Catch: Exception -> L161 Throwable -> L178
    L22:
        Map<String, String> r106 = this.f102553f;     // Catch: Exception -> L161 Throwable -> L178
        String r107 = r103.getCombineOp();     // Catch: Exception -> L161 Throwable -> L178
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        LinkedHashMap r108 = (LinkedHashMap) r106;     // Catch: Exception -> L161 Throwable -> L178
        Object r109 = r108.get(r107);     // Catch: Exception -> L161 Throwable -> L178
        if (r109 != null) goto L34;
        d r118 = this.f102549b;     // Catch: Exception -> L171 Throwable -> L178
        String r119 = r103.getCombineOp();     // Catch: Exception -> L171 Throwable -> L178
        if (r119 != null) goto L30;
        r119 = "";
    L30:
        r109 = r118.a(r119);     // Catch: Exception -> L171 Throwable -> L178
        if (r109 != null) goto L33;
        r109 = "";
    L33:
        r108.put(r107, r109);     // Catch: Exception -> L171 Throwable -> L178
    L34:
        String r120 = (String) r109;     // Catch: Exception -> L161 Throwable -> L178
        d r121 = this.f102549b;     // Catch: Exception -> L161 Throwable -> L178
        final ArrayList r215 = r113;
        final Ref.ObjectRef r216 = r114;
        final ?? r122 = r112;
        Function1<String, Boolean> r123 = new BaseFactorProcessorV3$handle$$inlined$forEach$lambda$1(r105, this, r214, r211, r212, r210, r310, r213, r122, r215, r216);     // Catch: Exception -> L159 Throwable -> L178
        r121.getClass();     // Catch: Exception -> L159 Throwable -> L178
        boolean r124 = Boolean.valueOf(d.b(r120, r123)).booleanValue();     // Catch: Exception -> L159 Throwable -> L178
        List<CombineInfo> r125 = this.f102548a;     // Catch: Exception -> L159 Throwable -> L178
        if (r125 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L40 Throwable -> L178
    L40:
        e = e;
        Object r126 = r212;
        ?? r127 = r213;
    L173:
        ALogger.i("strategy_tag", e.getMessage());     // Catch: Throwable -> L178
        r127.setValue(r126);     // Catch: Throwable -> L178
        monitor-exit(this);
        return r127;
    L43:
        String r128 = String.valueOf(r125.indexOf(r103));     // Catch: Exception -> L159 Throwable -> L178
        CombineBaseInfo r129 = r103.getCombineBaseInfo();     // Catch: Exception -> L159 Throwable -> L178
        if (r129 == null) goto L47;
        Integer r130 = r129.getCurrentStrategyState();     // Catch: Exception -> L40 Throwable -> L178
    L48:
        int r131 = 0;
        if (r130 != null) goto L52;
    L53:
        if (r124 != true) goto L97;
        if (r103.getTotalDuration() == null) goto L92;
        Integer r132 = r103.getTotalDuration();     // Catch: Exception -> L159 Throwable -> L178
        if (r132 != null) goto L60;
    L63:
        if (((LinkedHashMap) this.f102551d).get(r128) != null) goto L66;
        this.f102551d.put(r128, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L40 Throwable -> L178
        String r133 = r210;
        r213 = r213;
        ArrayList r134 = r215;
        r216 = r216;
    L156:
        r110 = r212;
        r111 = r213;
        r100 = r133;
        r113 = r134;
        r114 = r216;
        goto L10
    L66:
        long r135 = System.currentTimeMillis();     // Catch: Exception -> L159 Throwable -> L178
        Object r136 = ((LinkedHashMap) this.f102551d).get(r128);     // Catch: Exception -> L159 Throwable -> L178
        Intrinsics.checkNotNull(r136);     // Catch: Exception -> L159 Throwable -> L178
        long r137 = r135 - ((Number) r136).longValue();     // Catch: Exception -> L159 Throwable -> L178
        Integer r138 = r103.getTotalDuration();     // Catch: Exception -> L159 Throwable -> L178
        if (r138 == null) goto L71;
        r131 = r138.intValue() * 1000;
    L71:
        if (r137 >= r131) goto L73;
        r133 = r210;
    L103:
        r134 = r215;
        goto L156
    L73:
        List r139 = (List) r216.element;     // Catch: Exception -> L159 Throwable -> L178
        if (r139 == null) goto L87;
        Iterator r140 = r139.iterator();     // Catch: Exception -> L40 Throwable -> L178
    L76:
        if (r140.hasNext() == false) goto L87;
        CombineInfo r141 = (CombineInfo) r140.next();     // Catch: Exception -> L40 Throwable -> L178
        List<CombineInfo> r142 = this.f102548a;     // Catch: Exception -> L40 Throwable -> L178
        if (r142 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L40 Throwable -> L178
    L81:
        String r143 = String.valueOf(r142.indexOf(r141));     // Catch: Exception -> L40 Throwable -> L178
        if ((!Intrinsics.areEqual(r143, r128)) == false) goto L76;
        this.f102551d.remove(r143);     // Catch: Exception -> L40 Throwable -> L178
    L87:
        d(r103, r212, r210, r310, r213, false, r215);     // Catch: Exception -> L159 Throwable -> L178
        monitor-exit(this);
        return r213;
    L60:
        if (r132.intValue() != 0) goto L63;
    L92:
        r122 = r213;
        d(r103, r212, r210, r310, r213, false, r215);     // Catch: Exception -> L157 Throwable -> L178
        monitor-exit(this);
        return r122;
    L157:
        e = e;
    L163:
        r126 = r212;
        r127 = r122;
        goto L173
    L97:
        this.f102551d.remove(r128);     // Catch: Exception -> L157 Throwable -> L178
        ConcurrentHashMap<String, Map<String, String>> r144 = StrategyTeaLogHelper.f69235a;     // Catch: Exception -> L157 Throwable -> L178
        CombineBaseInfo r145 = r103.getCombineBaseInfo();     // Catch: Exception -> L157 Throwable -> L178
        if (r145 == null) goto L101;
        String r146 = r145.getCombineInfoId();     // Catch: Exception -> L157 Throwable -> L178
        if (r146 == null) goto L101;
    L102:
        r133 = r210;
        StrategyTeaLogHelper.d(r133, r146);     // Catch: Exception -> L157 Throwable -> L178
    L101:
        r146 = "";
        goto L102
    L52:
        if (r130.intValue() != 3) goto L53;
        r133 = r210;
        r213 = r213;
        r216 = r216;
        CombineBaseInfo r147 = r103.getCombineBaseInfo();     // Catch: Exception -> L157 Throwable -> L178
        if (r147 == null) goto L107;
        String r148 = r147.getCombineInfoId();     // Catch: Exception -> L157 Throwable -> L178
    L108:
        r134 = r215;
        if (CollectionsKt.contains(r134, r148) == true) goto L156;
        if (r124 == true) goto L112;
        this.f102552e.remove(r128);     // Catch: Exception -> L157 Throwable -> L178
        ConcurrentHashMap<String, Map<String, String>> r149 = StrategyTeaLogHelper.f69235a;     // Catch: Exception -> L157 Throwable -> L178
        CombineBaseInfo r150 = r103.getCombineBaseInfo();     // Catch: Exception -> L157 Throwable -> L178
        if (r150 == null) goto L154;
        String r151 = r150.getCombineInfoId();     // Catch: Exception -> L157 Throwable -> L178
        if (r151 == null) goto L154;
    L155:
        StrategyTeaLogHelper.d(r133, r151);     // Catch: Exception -> L157 Throwable -> L178
    L154:
        r151 = "";
        goto L155
    L112:
        if (r103.getTotalDuration() == null) goto L149;
        Integer r152 = r103.getTotalDuration();     // Catch: Exception -> L157 Throwable -> L178
        if (r152 != null) goto L117;
    L120:
        if (((LinkedHashMap) this.f102552e).get(r128) != null) goto L122;
        this.f102552e.put(r128, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L157 Throwable -> L178
        goto L156
    L122:
        long r153 = System.currentTimeMillis();     // Catch: Exception -> L157 Throwable -> L178
        Object r154 = ((LinkedHashMap) this.f102552e).get(r128);     // Catch: Exception -> L157 Throwable -> L178
        Intrinsics.checkNotNull(r154);     // Catch: Exception -> L157 Throwable -> L178
        long r155 = r153 - ((Number) r154).longValue();     // Catch: Exception -> L157 Throwable -> L178
        Integer r156 = r103.getTotalDuration();     // Catch: Exception -> L157 Throwable -> L178
        if (r156 == null) goto L126;
        r131 = r156.intValue() * 1000;     // Catch: Exception -> L157 Throwable -> L178
    L126:
        if (r155 < r131) goto L156;
        List r157 = (List) r216.element;     // Catch: Exception -> L157 Throwable -> L178
        if (r157 == null) goto L148;
        Iterator r158 = r157.iterator();     // Catch: Exception -> L157 Throwable -> L178
    L131:
        if (r158.hasNext() == false) goto L148;
        CombineInfo r159 = (CombineInfo) r158.next();     // Catch: Exception -> L157 Throwable -> L178
        List<CombineInfo> r160 = this.f102548a;     // Catch: Exception -> L157 Throwable -> L178
        if (r160 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L157 Throwable -> L178
    L135:
        String r161 = String.valueOf(r160.indexOf(r159));     // Catch: Exception -> L157 Throwable -> L178
        CombineBaseInfo r162 = r159.getCombineBaseInfo();     // Catch: Exception -> L157 Throwable -> L178
        if (r162 == null) goto L138;
        String r163 = r162.getCombineInfoId();     // Catch: Exception -> L157 Throwable -> L178
    L139:
        CombineBaseInfo r164 = r103.getCombineBaseInfo();     // Catch: Exception -> L157 Throwable -> L178
        if (r164 == null) goto L142;
        String r165 = r164.getCombineInfoId();     // Catch: Exception -> L157 Throwable -> L178
    L144:
        if (Intrinsics.areEqual(r163, r165) == false) goto L131;
        if ((!Intrinsics.areEqual(r161, r128)) == false) goto L131;
        this.f102552e.remove(r161);     // Catch: Exception -> L157 Throwable -> L178
        goto L131
    L142:
        r165 = null;
        goto L144
    L138:
        r163 = null;
    L148:
        d(r103, r212, r210, r310, r213, true, r134);     // Catch: Exception -> L157 Throwable -> L178
        goto L156
    L117:
        if (r152.intValue() != 0) goto L120;
    L149:
        d(r103, r212, r210, r310, r213, true, r134);     // Catch: Exception -> L157 Throwable -> L178
        goto L156
    L107:
        r148 = null;
        goto L108
    L47:
        r130 = null;
    L159:
        e = e;
        r122 = r213;
        goto L163
    L15:
        LinkedHashMap r166 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));     // Catch: Exception -> L171 Throwable -> L178
        Iterator r167 = r104.iterator();     // Catch: Exception -> L171 Throwable -> L178
    L17:
        if (r167.hasNext() == false) goto L20;
        Object r168 = r167.next();     // Catch: Exception -> L171 Throwable -> L178
        r166.put(((CombinCharacterInfo) r168).getAlias(), r168);     // Catch: Exception -> L171 Throwable -> L178
        goto L17
    L20:
        r105 = r166;
    L161:
        e = e;
        r122 = r111;
    L171:
        e = e;
        r127 = r111;
        r126 = r110;
        goto L173
    L176:
        monitor-exit(this);
        return null;
    L178:
        th = move-exception;
        throw th;
    }

    public final void d(CombineInfo r100, Object r101, String r102, boolean r103, StrategyMutableLiveData r104, boolean r110, List r111) {
        int r105 = com.bytedance.android.live.impl.b.f69057a;
        CopyOnWriteArrayList<CombbineFactorInfo> r106 = r100.getFaList();
        if (r106 == null) goto L12;
        Iterator<T> r107 = r106.iterator();
    L6:
        if (r107.hasNext() == false) goto L11;
        CombbineFactorInfo r108 = (CombbineFactorInfo) r107.next();
        if (Intrinsics.areEqual(r108.getFaName(), r102) == false) goto L6;
        Object r109 = r108.getFaValue();
    L13:
        Object r112 = com.bytedance.android.live.impl.b.a(r109, r101);
        LinkedHashMap r113 = new LinkedHashMap();
        CombineBaseInfo r114 = r100.getCombineBaseInfo();
        String r115 = "";
        if (r114 == null) goto L17;
        String r116 = r114.getCombineInfoId();
        if (r116 == null) goto L17;
    L18:
        r113.put("combine_info_id", r116);
        String r117 = r100.getCombineId();
        if (r117 != null) goto L21;
        r117 = "";
    L21:
        r113.put("detail_combine_id", r117);
        if (r102 != null) goto L24;
        String r118 = "";
    L25:
        r113.put("fa_name", r118);
        if (r112 == null) goto L29;
        String r119 = r112.toString();
        if (r119 == null) goto L29;
    L30:
        r113.put("fa_value", r119);
        CombineBaseInfo r120 = r100.getCombineBaseInfo();
        if (r120 == null) goto L36;
        Integer r121 = r120.getCurrentStrategyState();
        if (r121 == null) goto L36;
        String r122 = String.valueOf(r121.intValue());
        if (r122 == null) goto L36;
    L37:
        r113.put("combine_info_type", r122);
        r113.put("use_sp_cache", String.valueOf(r103));
        Integer r123 = r100.getPriority();
        if (r123 == null) goto L41;
        String r124 = String.valueOf(r123.intValue());
        if (r124 == null) goto L41;
    L42:
        r113.put("priority", r124);
        if (r110 == true) goto L56;
        ConcurrentHashMap<String, Map<String, String>> r125 = StrategyTeaLogHelper.f69235a;
        CombineBaseInfo r126 = r100.getCombineBaseInfo();
        if (r126 == null) goto L48;
        String r127 = r126.getCombineInfoId();
        if (r127 == null) goto L48;
    L49:
        StrategyTeaLogHelper.a(r102, r127, r113);
        r104.setValue(r112);
        f(r100, r104);
        if (a() == false) goto L72;
        StringBuilder r128 = new StringBuilder();
        r128.append(r102);
        r128.append(" is shot by ");
        String r129 = r100.getCombineId();
        if (r129 == null) goto L55;
        r115 = r129;
    L55:
        r128.append(r115);
        r128.append(",faValue: ");
        r128.append(r112);
        ALogger.i("strategy_tag", r128.toString());
        return;
    L72:
        return;
    L48:
        r127 = "";
        goto L49
    L56:
        ConcurrentHashMap<String, Map<String, String>> r130 = StrategyTeaLogHelper.f69235a;
        CombineBaseInfo r131 = r100.getCombineBaseInfo();
        if (r131 == null) goto L60;
        String r132 = r131.getCombineInfoId();
        if (r132 == null) goto L60;
    L61:
        StrategyTeaLogHelper.f(r102, r132, r113);
        CombineBaseInfo r133 = r100.getCombineBaseInfo();
        if (r133 == null) goto L67;
        String r134 = r133.getCombineInfoId();
        if (r134 == null) goto L67;
        r115 = r134;
    L67:
        ((ArrayList) r111).add(r115);
        return;
    L60:
        r132 = "";
    L41:
        r124 = "";
    L36:
        r122 = "-1";
    L29:
        r119 = "";
        goto L30
    L24:
        r118 = r102;
    L17:
        r116 = "";
        goto L18
    L11:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L12:
        r109 = null;
        goto L13
    }
}
