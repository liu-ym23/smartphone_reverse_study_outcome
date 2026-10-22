package com.bytedance.android.live.impl.processor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombineBaseInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseFactorProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<CombineInfo> f69244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ma0.a f69245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<sb1.a> f69246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f69247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f69248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final na0.a f69249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f69250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f69251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f69252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f69253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, List<CombineInfo>> f69254l;

    public abstract LiveData f(CombineInfo r100, LiveData r101);

    public BaseFactorProcessor() {
        this.f69243a = "BaseFactorProcessor";
        this.f69245c = new ma0.a();
        this.f69246d = new ArrayList();
        this.f69247e = new LinkedHashMap();
        this.f69248f = new LinkedHashMap();
        this.f69249g = new na0.a();
        new ConcurrentHashMap();
        this.f69250h = new LinkedHashMap();
        this.f69251i = LazyKt.lazy(BaseFactorProcessor$updateReportEnable$2.INSTANCE);
        this.f69252j = LazyKt.lazy(BaseFactorProcessor$logOnlyInDebug$2.INSTANCE);
        this.f69254l = new LinkedHashMap();
    }

    public final boolean a() {
        if (v.a() == false) goto L5;
        return true;
    L5:
        if (v.a() == false) goto L7;
        return false;
    L7:
        if (((Boolean) this.f69252j.getValue()).booleanValue() == false) goto L14;
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
        return r101;
    }

    public final void e(List<CombineInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "combineInfos");
        this.f69244b = r100;
        ((LinkedHashMap) this.f69247e).clear();
        ((LinkedHashMap) this.f69248f).clear();
        ((LinkedHashMap) this.f69250h).clear();
        ((LinkedHashMap) this.f69254l).clear();
        StrategyTeaLogHelper.f69235a.clear();
        List<sb1.a> r101 = this.f69246d;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(this.f69249g) == true) goto L5;
        List<sb1.a> r103 = this.f69246d;
        ArrayList r104 = (ArrayList) r103;
        r104.add(this.f69249g);
    L5:
        this.f69253k = true;
    }

    public void update(String r100, StrategyMutableLiveData<Object> r110, Map<String, Object> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "characterCache");
        if (r110.getValue() != null) goto L5;
        return;
    L5:
        Object r101 = r110.getValue();
        Intrinsics.checkNotNull(r101);
        StrategyMutableLiveData r102 = c(r100, null, r101, r110, r111, r112);
        if (r102 == null) goto L9;
        r102.getValue();
        return;
    }

    public final void g(String r100, String r101, Object r102, StrategyMutableLiveData<Object> r103, boolean r104) {
        if (((Boolean) this.f69251i.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r104 == true) goto L8;
        Object r105 = r103.getValue();
    L9:
        if (r105 != null) goto L11;
    L13:
        if (r104 == false) goto L16;
        this.f69250h.put(r100 + '|' + r101, r102);
    L16:
        if (r103.hasActiveObservers() == true) goto L18;
        return;
    L18:
        if (a() == false) goto L20;
        ALogger.i(this.f69243a, "update log send faName:" + r100 + ",combineId:" + r101);
    L20:
        ConcurrentHashMap<String, Map<String, String>> r106 = StrategyTeaLogHelper.f69235a;
        Intrinsics.checkNotNullParameter(r100, "faName");
        Intrinsics.checkNotNullParameter(r101, "strategyId");
        Map<String, String> r107 = StrategyTeaLogHelper.f69235a.get(r100 + '|' + r101);
        if (r107 != null) goto L23;
        return;
    L23:
        if (StrategyTeaLogHelper.c(r107, r100) == false) goto L38;
        IRoomContextService r108 = (IRoomContextService) k.f(IRoomContextService.class);
        Class<?> r109 = null;
        if (r108 == null) goto L31;
        o r110 = IRoomContextService.a.a(r108, null, 0, 3);
        if (r110 == null) goto L31;
        r109 = r110.Q2();
    L31:
        if (((Boolean) StrategyTeaLogHelper.f69240f.getValue()).booleanValue() == false) goto L33;
        j0.l().o("livesdk_live_strategy_info", r107, new Object[]{r109});
        return;
    L33:
        j0.l().sendLog("livesdk_live_strategy_info", r107, new Object[]{r109});
        return;
    L38:
        return;
    L11:
        if (Intrinsics.areEqual(r105, r102) == false) goto L13;
        return;
    L8:
        r105 = ((LinkedHashMap) this.f69250h).get(r100 + '|' + r101);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.bytedance.android.live.strategy.api.StrategyMutableLiveData] */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.bytedance.android.live.strategy.api.StrategyMutableLiveData] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v10, types: [T] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v94, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.bytedance.android.live.impl.processor.BaseFactorProcessor] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List] */
    public final synchronized StrategyMutableLiveData c(final String r210, final String r211, final Object r310, final StrategyMutableLiveData r311, final Map r312, final boolean r313) {
        String r100 = r210;
        StrategyMutableLiveData r110 = r311;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "faName");     // Catch: Throwable -> L196
        Intrinsics.checkNotNullParameter(r110, "data");     // Catch: Throwable -> L196
        Intrinsics.checkNotNullParameter(r312, "characterCache");     // Catch: Throwable -> L196
        Boolean r111 = null;
        if (this.f69253k == false) goto L194;
        final long r112 = System.currentTimeMillis();     // Catch: Throwable -> L196
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L188 Throwable -> L196
        final Ref.ObjectRef r101 = new Ref.ObjectRef();     // Catch: Exception -> L188 Throwable -> L196
        r101.element = null;     // Catch: Exception -> L188 Throwable -> L196
        if (this.f69254l.containsKey(r100) == false) goto L10;
        r101.element = (List) ((LinkedHashMap) this.f69254l).get(r100);     // Catch: Exception -> L188 Throwable -> L196
    L38:
        List r102 = (List) r101.element;     // Catch: Exception -> L188 Throwable -> L196
        if (r102 != null) goto L200;
    L181:
        String r114 = r100;
        StrategyMutableLiveData r115 = r110;
        if (a() == false) goto L185;
        ALogger.i("strategy_tag", "No strategy data or op matches " + r114 + ' ');     // Catch: Throwable -> L196
    L185:
        r115.setValue(r310);     // Catch: Throwable -> L196
        monitor-exit(this);
        return r115;
    L200:
        Iterator r212 = r102.iterator();     // Catch: Exception -> L178 Throwable -> L196
        ?? r116 = r113;
    L42:
        if (r212.hasNext() == false) goto L181;
        final CombineInfo r103 = (CombineInfo) r212.next();     // Catch: Exception -> L178 Throwable -> L196
        ma0.a r104 = this.f69245c;     // Catch: Exception -> L178 Throwable -> L196
        String r105 = r103.getCombineOp();     // Catch: Exception -> L178 Throwable -> L196
        if (r105 != null) goto L46;
        r105 = "";
    L46:
        r104.getClass();     // Catch: Exception -> L178 Throwable -> L196
        String r106 = ma0.a.a(r105);     // Catch: Exception -> L178 Throwable -> L196
        if (r106 != null) goto L208;
        r101 = r101;
        ?? r213 = r116;
    L204:
        List<CombineInfo> r107 = this.f69244b;     // Catch: Exception -> L176 Throwable -> L196
        if (r107 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L50 Throwable -> L196
    L57:
        String r108 = String.valueOf(r107.indexOf(r103));     // Catch: Exception -> L176 Throwable -> L196
        CombineBaseInfo r109 = r103.getCombineBaseInfo();     // Catch: Exception -> L176 Throwable -> L196
        if (r109 == null) goto L61;
        ?? r117 = r109.getCurrentStrategyState();     // Catch: Exception -> L50 Throwable -> L196
    L62:
        if (r117 == 0) goto L67;
        if (r117.intValue() != 3) goto L67;
        String r118 = r210;
        r311 = r311;
        r101 = r101;
        CombineBaseInfo r119 = r103.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r119 == null) goto L122;
        Object r120 = r119.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L123:
        ?? r121 = r213;
        if (CollectionsKt.contains(r121, r120) == true) goto L173;
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == true) goto L128;
        this.f69248f.remove(r108);     // Catch: Exception -> L174 Throwable -> L196
        ConcurrentHashMap<String, Map<String, String>> r122 = StrategyTeaLogHelper.f69235a;     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r123 = r103.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r123 == null) goto L171;
        String r124 = r123.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
        if (r124 == null) goto L171;
    L172:
        StrategyTeaLogHelper.d(r118, r124);     // Catch: Exception -> L174 Throwable -> L196
    L171:
        r124 = "";
        goto L172
    L128:
        if (r103.getTotalDuration() == null) goto L166;
        Integer r125 = r103.getTotalDuration();     // Catch: Exception -> L174 Throwable -> L196
        if (r125 != null) goto L133;
    L136:
        if (((LinkedHashMap) this.f69248f).get(r108) != null) goto L138;
        this.f69248f.put(r108, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L174 Throwable -> L196
        goto L173
    L138:
        long r126 = System.currentTimeMillis();     // Catch: Exception -> L174 Throwable -> L196
        Object r127 = ((LinkedHashMap) this.f69248f).get(r108);     // Catch: Exception -> L174 Throwable -> L196
        Intrinsics.checkNotNull(r127);     // Catch: Exception -> L174 Throwable -> L196
        long r128 = r126 - ((Number) r127).longValue();     // Catch: Exception -> L174 Throwable -> L196
        Integer r129 = r103.getTotalDuration();     // Catch: Exception -> L174 Throwable -> L196
        if (r129 == null) goto L141;
        int r130 = r129.intValue() * 1000;     // Catch: Exception -> L174 Throwable -> L196
    L143:
        if (r128 < r130) goto L173;
        List r131 = (List) r101.element;     // Catch: Exception -> L174 Throwable -> L196
        if (r131 == null) goto L165;
        Iterator r132 = r131.iterator();     // Catch: Exception -> L174 Throwable -> L196
    L148:
        if (r132.hasNext() == false) goto L165;
        CombineInfo r133 = (CombineInfo) r132.next();     // Catch: Exception -> L174 Throwable -> L196
        List<CombineInfo> r134 = this.f69244b;     // Catch: Exception -> L174 Throwable -> L196
        if (r134 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L174 Throwable -> L196
    L152:
        String r135 = String.valueOf(r134.indexOf(r133));     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r136 = r133.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r136 == null) goto L155;
        Object r137 = r136.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L156:
        CombineBaseInfo r138 = r103.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r138 == null) goto L159;
        Object r139 = r138.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L161:
        if (Intrinsics.areEqual(r137, r139) == false) goto L148;
        if ((!Intrinsics.areEqual(r135, r108)) == false) goto L148;
        this.f69248f.remove(r135);     // Catch: Exception -> L174 Throwable -> L196
        goto L148
    L159:
        r139 = r111;
        goto L161
    L155:
        r137 = r111;
    L165:
        d(r103, r310, r210, r313, r311, true, r121);     // Catch: Exception -> L174 Throwable -> L196
        goto L173
    L141:
        r130 = 0;
        goto L143
    L133:
        if (r125.intValue() != 0) goto L136;
    L166:
        d(r103, r310, r210, r313, r311, true, r121);     // Catch: Exception -> L174 Throwable -> L196
    L173:
        r100 = r118;
        r111 = r111;
        ?? r214 = r121;
        r110 = r311;
        r116 = r214;
        goto L42
    L122:
        r120 = r111;
    L174:
        e = e;
    L180:
        Object r140 = r310;
        ?? r141 = r116;
    L190:
        ALogger.i("strategy_tag", e.getMessage());     // Catch: Throwable -> L196
        r141.setValue(r140);     // Catch: Throwable -> L196
        monitor-exit(this);
        return r141;
    L67:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L112;
        if (r103.getTotalDuration() == null) goto L107;
        Integer r142 = r103.getTotalDuration();     // Catch: Exception -> L176 Throwable -> L196
        if (r142 != null) goto L74;
    L77:
        if (((LinkedHashMap) this.f69247e).get(r108) != null) goto L80;
        this.f69247e.put(r108, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L50 Throwable -> L196
        r118 = r210;
    L118:
        r121 = r213;
        goto L173
    L80:
        long r143 = System.currentTimeMillis();     // Catch: Exception -> L176 Throwable -> L196
        Object r144 = ((LinkedHashMap) this.f69247e).get(r108);     // Catch: Exception -> L176 Throwable -> L196
        Intrinsics.checkNotNull(r144);     // Catch: Exception -> L176 Throwable -> L196
        long r145 = r143 - ((Number) r144).longValue();     // Catch: Exception -> L176 Throwable -> L196
        Integer r146 = r103.getTotalDuration();     // Catch: Exception -> L176 Throwable -> L196
        if (r146 != null) goto L83;
        int r147 = 0;
    L86:
        if (r145 >= r147) goto L88;
        r118 = r210;
        goto L118
    L88:
        List r148 = (List) r101.element;     // Catch: Exception -> L176 Throwable -> L196
        if (r148 == null) goto L102;
        Iterator r149 = r148.iterator();     // Catch: Exception -> L50 Throwable -> L196
    L91:
        if (r149.hasNext() == false) goto L102;
        CombineInfo r150 = (CombineInfo) r149.next();     // Catch: Exception -> L50 Throwable -> L196
        List<CombineInfo> r151 = this.f69244b;     // Catch: Exception -> L50 Throwable -> L196
        if (r151 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L50 Throwable -> L196
    L96:
        String r152 = String.valueOf(r151.indexOf(r150));     // Catch: Exception -> L50 Throwable -> L196
        if ((!Intrinsics.areEqual(r152, r108)) == false) goto L91;
        this.f69247e.remove(r152);     // Catch: Exception -> L50 Throwable -> L196
    L50:
        e = e;
        r140 = r310;
        r141 = r311;
    L102:
        d(r103, r310, r210, r313, r311, false, r213);     // Catch: Exception -> L176 Throwable -> L196
        monitor-exit(this);
        return r311;
    L83:
        r147 = r146.intValue() * 1000;
        goto L86
    L74:
        if (r142.intValue() != 0) goto L77;
    L107:
        r116 = r311;
        d(r103, r310, r210, r313, r311, false, r213);     // Catch: Exception -> L174 Throwable -> L196
        monitor-exit(this);
        return r116;
    L112:
        this.f69247e.remove(r108);     // Catch: Exception -> L174 Throwable -> L196
        ConcurrentHashMap<String, Map<String, String>> r153 = StrategyTeaLogHelper.f69235a;     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r154 = r103.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r154 == null) goto L116;
        String r155 = r154.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
        if (r155 == null) goto L116;
    L117:
        r118 = r210;
        StrategyTeaLogHelper.d(r118, r155);     // Catch: Exception -> L174 Throwable -> L196
    L116:
        r155 = "";
        goto L117
    L61:
        r117 = r111;
    L176:
        e = e;
        r116 = r311;
        goto L180
    L208:
        ma0.a r156 = this.f69245c;     // Catch: Exception -> L50 Throwable -> L196
        r101 = r101;
        final ?? r215 = r116;
        Function1<String, Boolean> r157 = new BaseFactorProcessor$handle$$inlined$forEach$lambda$1(r103, this, r312, r211, r310, r210, r313, r311, r112, r215, r101);     // Catch: Exception -> L50 Throwable -> L196
        r156.getClass();     // Catch: Exception -> L50 Throwable -> L196
        r111 = Boolean.valueOf(ma0.a.b(r106, r157));     // Catch: Exception -> L50 Throwable -> L196
        r213 = r215;
    L178:
        e = e;
        r116 = r110;
        goto L180
    L10:
        List<CombineInfo> r158 = this.f69244b;     // Catch: Exception -> L188 Throwable -> L196
        if (r158 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L188 Throwable -> L196
    L13:
        if (r158 == null) goto L34;
        ArrayList r159 = new ArrayList();     // Catch: Exception -> L188 Throwable -> L196
        Iterator r160 = r158.iterator();     // Catch: Exception -> L188 Throwable -> L196
    L16:
        if (r160.hasNext() == false) goto L33;
        Object r161 = r160.next();     // Catch: Exception -> L188 Throwable -> L196
        CombineInfo r162 = (CombineInfo) r161;     // Catch: Exception -> L188 Throwable -> L196
        if (r162 == null) goto L30;
        CopyOnWriteArrayList<CombbineFactorInfo> r163 = r162.getFaList();     // Catch: Exception -> L188 Throwable -> L196
        if (r163 == null) goto L30;
        if (r163.isEmpty() == true) goto L30;
        Iterator r164 = r163.iterator();     // Catch: Exception -> L188 Throwable -> L196
    L26:
        if (r164.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((CombbineFactorInfo) r164.next()).getFaName(), r100) == false) goto L26;
        boolean r165 = true;
    L31:
        if (r165 == false) goto L16;
        r159.add(r161);     // Catch: Exception -> L188 Throwable -> L196
    L30:
        r165 = false;
        goto L31
    L33:
        ?? r166 = CollectionsKt.sortedWith(r159, new a());     // Catch: Exception -> L188 Throwable -> L196
    L35:
        r101.element = r166;     // Catch: Exception -> L188 Throwable -> L196
        List<CombineInfo> r167 = (List) r166;     // Catch: Exception -> L188 Throwable -> L196
        if (r167 == null) goto L38;
        this.f69254l.put(r100, r167);     // Catch: Exception -> L188 Throwable -> L196
        goto L38
    L34:
        r166 = 0;
    L188:
        e = e;
        r141 = r110;
        r140 = r310;
        goto L190
    L194:
        monitor-exit(this);
        return null;
    L196:
        th = move-exception;
        throw th;
    }

    public final void d(CombineInfo r100, Object r110, String r111, boolean r112, StrategyMutableLiveData r113, boolean r114, List r115) {
        int r101 = com.bytedance.android.live.impl.b.f69057a;
        CopyOnWriteArrayList<CombbineFactorInfo> r102 = r100.getFaList();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        CombbineFactorInfo r104 = (CombbineFactorInfo) r103.next();
        if (Intrinsics.areEqual(r104.getFaName(), r111) == false) goto L6;
        Object r105 = r104.getFaValue();
    L13:
        Object r116 = com.bytedance.android.live.impl.b.a(r105, r110);
        LinkedHashMap r106 = new LinkedHashMap();
        CombineBaseInfo r107 = r100.getCombineBaseInfo();
        String r108 = "";
        if (r107 == null) goto L17;
        String r109 = r107.getCombineInfoId();
        if (r109 == null) goto L17;
    L18:
        r106.put("combine_info_id", r109);
        String r117 = r100.getCombineId();
        if (r117 != null) goto L21;
        r117 = "";
    L21:
        r106.put("detail_combine_id", r117);
        if (r111 != null) goto L24;
        String r118 = "";
    L25:
        r106.put("fa_name", r118);
        if (r116 == null) goto L29;
        String r119 = r116.toString();
        if (r119 == null) goto L29;
    L30:
        r106.put("fa_value", r119);
        CombineBaseInfo r120 = r100.getCombineBaseInfo();
        if (r120 == null) goto L36;
        Integer r121 = r120.getCurrentStrategyState();
        if (r121 == null) goto L36;
        String r122 = String.valueOf(r121.intValue());
        if (r122 == null) goto L36;
    L37:
        r106.put("combine_info_type", r122);
        r106.put("use_sp_cache", String.valueOf(r112));
        Integer r123 = r100.getPriority();
        if (r123 == null) goto L41;
        String r124 = String.valueOf(r123.intValue());
        if (r124 == null) goto L41;
    L42:
        r106.put("priority", r124);
        if (r114 == true) goto L69;
        ConcurrentHashMap<String, Map<String, String>> r125 = StrategyTeaLogHelper.f69235a;
        CombineBaseInfo r126 = r100.getCombineBaseInfo();
        if (r126 == null) goto L48;
        String r127 = r126.getCombineInfoId();
        if (r127 == null) goto L48;
    L49:
        StrategyTeaLogHelper.a(r111, r127, r106);
        CombineBaseInfo r128 = r100.getCombineBaseInfo();
        if (r128 == null) goto L55;
        String r129 = r128.getCombineInfoId();
        if (r129 == null) goto L55;
        String r130 = r129;
    L56:
        if (r116 == null) goto L68;
        if (r113 == null) goto L66;
        g(r111, r130, r116, r113, r114);
        r113.setValue(r116);
        f(r100, r113);
        if (a() == false) goto L97;
        StringBuilder r131 = new StringBuilder();
        r131.append(r111);
        r131.append(" is shot by ");
        String r132 = r100.getCombineId();
        if (r132 == null) goto L64;
        r108 = r132;
    L64:
        r131.append(r108);
        r131.append(",faValue: ");
        r131.append(r116);
        ALogger.i("strategy_tag", r131.toString());
        return;
    L97:
        return;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L68:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L55:
        r130 = "";
    L48:
        r127 = "";
        goto L49
    L69:
        ConcurrentHashMap<String, Map<String, String>> r133 = StrategyTeaLogHelper.f69235a;
        CombineBaseInfo r134 = r100.getCombineBaseInfo();
        if (r134 == null) goto L73;
        String r135 = r134.getCombineInfoId();
        if (r135 == null) goto L73;
    L74:
        StrategyTeaLogHelper.f(r111, r135, r106);
        CombineBaseInfo r136 = r100.getCombineBaseInfo();
        if (r136 == null) goto L78;
        String r137 = r136.getCombineInfoId();
        if (r137 == null) goto L78;
    L79:
        ((ArrayList) r115).add(r137);
        CombineBaseInfo r138 = r100.getCombineBaseInfo();
        if (r138 == null) goto L85;
        String r139 = r138.getCombineInfoId();
        if (r139 == null) goto L85;
        String r140 = r139;
    L86:
        if (r116 == null) goto L93;
        if (r113 == null) goto L91;
        g(r111, r140, r116, r113, r114);
        return;
    L91:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L93:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L85:
        r140 = "";
    L78:
        r137 = "";
    L73:
        r135 = "";
    L41:
        r124 = "";
    L36:
        r122 = "-1";
    L29:
        r119 = "";
        goto L30
    L24:
        r118 = r111;
    L17:
        r109 = "";
        goto L18
    L11:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L12:
        r105 = null;
        goto L13
    }
}
