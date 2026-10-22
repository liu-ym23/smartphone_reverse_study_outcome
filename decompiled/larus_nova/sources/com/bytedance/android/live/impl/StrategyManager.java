package com.bytedance.android.live.impl;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.impl.monitor.StrategyTracingMonitor;
import com.bytedance.android.live.impl.processor.BaseFactorProcessor;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.impl.timer.TaskManager;
import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombineBaseInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.StrategyInitObserver;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyInitConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.d3;
import j40.e3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes45.dex */
public final class StrategyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Strategy f69033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, BaseFactorProcessor> f69034b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.live.impl.processor.b f69035c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Object> f69036d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f69037e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f69038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f69039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f69040h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<StrategyInitObserver> f69041i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f69042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f69043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f69044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f69045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f69046n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f69047o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f69048p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f69049q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f69050r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final StrategyManager f69051s = null;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f69052a = null;

        static {
            f69052a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            StrategyManager r100 = StrategyManager.f69051s;
            monitor-enter(r100);
            ALogger.i("strategy_tag", "factors scan start");     // Catch: Throwable -> L58
            if (StrategyManager.f69045m == false) goto L8;
            monitor-exit(r100);
            return;
        L8:
            Set<String> r101 = StrategyManager.f69037e;     // Catch: Throwable -> L58
            Strategy r102 = StrategyManager.f69033a;     // Catch: Throwable -> L58
            if (r102 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L58
        L11:
            ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r103 = null;
            if (r102 == null) goto L14;
            CopyOnWriteArrayList<CombineInfo> r104 = r102.getCombineStrategys();     // Catch: Throwable -> L58
        L15:
            if (r104 == null) goto L29;
            Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L58
        L18:
            if (r105.hasNext() == false) goto L29;
            CopyOnWriteArrayList<CombbineFactorInfo> r106 = ((CombineInfo) r105.next()).getFaList();     // Catch: Throwable -> L58
            if (r106 == null) goto L18;
            Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L58
        L23:
            if (r107.hasNext() == false) goto L18;
            CombbineFactorInfo r108 = (CombbineFactorInfo) r107.next();     // Catch: Throwable -> L58
            if (r108 == null) goto L23;
            String r109 = r108.getFaName();     // Catch: Throwable -> L58
            if (r109 == null) goto L23;
            r101.add(r109);     // Catch: Throwable -> L58
        L29:
            Strategy r110 = StrategyManager.f69033a;     // Catch: Throwable -> L58
            if (r110 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L58
        L32:
            if (r110 == null) goto L34;
            r103 = r110.getAbInfos();     // Catch: Throwable -> L58
        L34:
            if (r103 == null) goto L55;
            Iterator<Map.Entry<String, CopyOnWriteArrayList<CombineInfo>>> r111 = r103.entrySet().iterator();     // Catch: Throwable -> L58
        L37:
            if (r111.hasNext() == false) goto L55;
            CopyOnWriteArrayList<CombineInfo> r112 = r111.next().getValue();     // Catch: Throwable -> L58
            if (r112 == null) goto L37;
            Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L58
        L42:
            if (r113.hasNext() == false) goto L37;
            CombineInfo r114 = (CombineInfo) r113.next();     // Catch: Throwable -> L58
            if (r114 == null) goto L42;
            CopyOnWriteArrayList<CombbineFactorInfo> r115 = r114.getFaList();     // Catch: Throwable -> L58
            if (r115 == null) goto L42;
            Iterator<T> r116 = r115.iterator();     // Catch: Throwable -> L58
        L49:
            if (r116.hasNext() == false) goto L42;
            CombbineFactorInfo r117 = (CombbineFactorInfo) r116.next();     // Catch: Throwable -> L58
            if (r117 == null) goto L49;
            String r118 = r117.getFaName();     // Catch: Throwable -> L58
            if (r118 == null) goto L49;
            r101.add(r118);     // Catch: Throwable -> L58
        L55:
            StrategyManager.f69045m = true;     // Catch: Throwable -> L58
            monitor-exit(r100);
            return;
        L14:
            r104 = null;
        L58:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f69053a = null;

        static {
            f69053a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            ALogger.i("strategy_tag", "factors scan finish");
        }
    }

    public StrategyManager() {
    }

    public static StrategyInitConfig f() {
        return (StrategyInitConfig) f69049q.getValue();
    }

    static {
        f69051s = new StrategyManager();
        f69034b = new LinkedHashMap();
        f69035c = new com.bytedance.android.live.impl.processor.b();
        f69036d = new ConcurrentHashMap();
        f69037e = new LinkedHashSet();
        f69038f = -1;
        f69039g = -1;
        f69040h = new LinkedHashSet();
        f69041i = new ArrayList();
        f69044l = true;
        f69046n = LazyKt.lazy(StrategyManager$sdkEnable$2.INSTANCE);
        f69047o = LazyKt.lazy(StrategyManager$strategySettingEnable$2.INSTANCE);
        f69048p = LazyKt.lazy(StrategyManager$logOnlyInDebug$2.INSTANCE);
        f69049q = LazyKt.lazy(StrategyManager$initStrategyConfig$2.INSTANCE);
        f69050r = LazyKt.lazy(StrategyManager$whiteFactorList$2.INSTANCE);
    }

    public final void g() {
        if (((Boolean) f69046n.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (f69042j == false) goto L11;
        if (f69043k == true) goto L11;
        return;
    L11:
        if (f69044l == true) goto L13;
        return;
    L13:
        f69044l = false;
        f69038f = System.currentTimeMillis() - ((IUtilsCommonService) k.n(IUtilsCommonService.class)).startTimeOfSDKInitTracer();
        f69039g = System.currentTimeMillis();
        int r100 = oa0.a.f522519a;     // Catch: Exception -> L25
        oa0.a.c(new StrategyManager$init$1(this));     // Catch: Exception -> L25
        Iterator r101 = ((ConcurrentHashMap) f69036d).entrySet().iterator();     // Catch: Exception -> L25
    L16:
        if (r101.hasNext() == false) goto L24;
        Object r102 = ((Map.Entry) r101.next()).getValue();     // Catch: Exception -> L25
        if (r102 == null) goto L23;
        if (((StrategyMutableLiveData) r102).hasActiveObservers() == true) goto L16;
        r101.remove();     // Catch: Exception -> L25
        goto L16
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");     // Catch: Exception -> L25
    L24:
        return;
    L25:
        e = move-exception;
        ALogger.w("strategy_tag", e.getMessage(), e);
        f69042j = false;
        Lazy r103 = StrategyTracingMonitor.f69241a;
        StrategyTracingMonitor.a(c(this, -1, 0, String.valueOf(e.getMessage()), 2));
        Iterator r104 = ((ArrayList) f69041i).iterator();
    L28:
        if (r104.hasNext() == false) goto L30;
        ((StrategyInitObserver) r104.next()).onFailed();
        goto L28
    }

    public static boolean b() {
        if (v.a() == false) goto L5;
        return true;
    L5:
        if (v.a() == false) goto L7;
        return false;
    L7:
        if (((Boolean) f69048p.getValue()).booleanValue() == false) goto L14;
        return false;
    L14:
        return true;
    }

    public static final void a(StrategyManager r100, String r101) {
        r100.getClass();
        if (b() == false) goto L5;
        ALogger.i("strategy_tag", "updateCharacter chName " + r101);
    L5:
        Strategy r102 = f69033a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L8:
        if (r102 == null) goto L10;
        List<String> r103 = r102.getFactorsByChName(r101);
    L11:
        LinkedHashMap r104 = new LinkedHashMap();
        if (r103 == null) goto L32;
        List r105 = CollectionsKt.distinct(r103);
        if (r105 == null) goto L46;
        Iterator r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L47;
        String r107 = (String) r106.next();
        ConcurrentHashMap r108 = (ConcurrentHashMap) f69036d;
        if (r108.containsKey(r107) == false) goto L17;
        if (r108.get(r107) == null) goto L17;
        Object r109 = r108.get(r107);
        if (r109 == null) goto L31;
        StrategyMutableLiveData<Object> r110 = (StrategyMutableLiveData) r109;
        Map<String, BaseFactorProcessor> r111 = f69034b;
        if (r111.containsKey(r107) == true) goto L26;
        f69035c.update(r107, r110, r104, f69043k);
        goto L17
    L26:
        BaseFactorProcessor r112 = (BaseFactorProcessor) ((LinkedHashMap) r111).get(r107);
        if (r112 == null) goto L17;
        r112.update(r107, r110, r104, f69043k);
        goto L17
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L47:
        return;
    L46:
        return;
    L32:
        return;
    L10:
        r103 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, com.bytedance.android.live.strategy.api.StrategyMutableLiveData] */
    public static void i(List r110, boolean r111) {
        if (b() == false) goto L5;
        ALogger.i("strategy_tag", "updateCharacter " + r110);
    L5:
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = new LinkedHashMap();
        ArrayList r101 = new ArrayList();
        if (r110 == null) goto L17;
        Iterator r112 = r110.iterator();
    L9:
        if (r112.hasNext() == false) goto L17;
        String r102 = (String) r112.next();
        Strategy r103 = f69033a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L13:
        if (r103 == null) goto L9;
        List<String> r104 = r103.getFactorsByChName(r102);
        if (r104 == null) goto L9;
        r101.addAll(r104);
    L17:
        List r113 = CollectionsKt.distinct(r101);
        if (r113 == null) goto L43;
        Iterator r114 = r113.iterator();
    L21:
        if (r114.hasNext() == false) goto L69;
        String r105 = (String) r114.next();
        ConcurrentHashMap r106 = (ConcurrentHashMap) f69036d;
        if (r106.containsKey(r105) == false) goto L21;
        if (r106.get(r105) == null) goto L21;
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        Object r108 = r106.get(r105);
        if (r108 == null) goto L42;
        r107.element = (StrategyMutableLiveData) r108;
        if (d3.f497185a.getValue().booleanValue() == false) goto L35;
        if (r111 == false) goto L34;
        if (ArraysKt.contains(e3.f497191a.getValue(), r105) == true) goto L35;
    L34:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StrategyManager$updateCharacter$$inlined$forEach$lambda$1(r105, r107, null, r111, r100), 3, null);
    L35:
        Map<String, BaseFactorProcessor> r109 = f69034b;
        if (r109.containsKey(r105) == true) goto L37;
        f69035c.update(r105, (StrategyMutableLiveData) r107.element, (Map) r100.element, f69043k);
        goto L21
    L37:
        BaseFactorProcessor r115 = (BaseFactorProcessor) ((LinkedHashMap) r109).get(r105);
        if (r115 == null) goto L21;
        r115.update(r105, (StrategyMutableLiveData) r107.element, (Map) r100.element, f69043k);
        goto L21
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L69:
        return;
    }

    public final void h(Strategy r110, boolean r111) {
        long r100 = System.currentTimeMillis();
        if (r110 != null) goto L5;
        return;
    L5:
        f69033a = r110;
        if (r111 == true) goto L11;
        int r101 = oa0.a.f522519a;
        Strategy r102 = f69033a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L10:
        oa0.a.d(r102);
    L11:
        Strategy r103 = f69033a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L14:
        if (r103 == null) goto L16;
        r103.clearCache();
    L16:
        Strategy r104 = f69033a;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L20:
        if (r104 == null) goto L32;
        CopyOnWriteArrayList<CombineInfo> r105 = r104.getCombineStrategys();
        if (r105 == null) goto L32;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L25:
        if (r106.hasNext() == false) goto L32;
        CombineInfo r108 = (CombineInfo) r106.next();
        CombineBaseInfo r109 = r108.getCombineBaseInfo();
        if (r109 == null) goto L29;
        StringBuilder r112 = new StringBuilder();
        r112.append(r107);
        r112.append("_online");
        r109.setCombineInfoId(r112.toString());
        r107 = r107 + 1;
    L29:
        CombineBaseInfo r113 = r108.getCombineBaseInfo();
        if (r113 == null) goto L25;
        r113.setCurrentStrategyState(1);
    L32:
        Strategy r114 = f69033a;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L36:
        if (r114 == null) goto L40;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r115 = r114.getAbInfos();
        if (r115 == null) goto L40;
        Set<String> r116 = r115.keySet();
    L41:
        if (r116 == null) goto L75;
        Iterator<T> r117 = r116.iterator();
    L44:
        if (r117.hasNext() == false) goto L75;
        String r118 = (String) r117.next();
        Strategy r119 = f69033a;
        if (r119 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L48:
        if (r119 == null) goto L52;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r120 = r119.getAbInfos();
        if (r120 == null) goto L52;
        CopyOnWriteArrayList<CombineInfo> r121 = r120.get(r118);
    L54:
        if (StringsKt.contains$default(r118, "_mock", false, 2, null) == true) goto L55;
        if (r121 == null) goto L44;
        Iterator<T> r122 = r121.iterator();
    L68:
        if (r122.hasNext() == false) goto L44;
        CombineInfo r123 = (CombineInfo) r122.next();
        CombineBaseInfo r124 = r123.getCombineBaseInfo();
        if (r124 == null) goto L72;
        r124.setCombineInfoId(r118);
    L72:
        CombineBaseInfo r125 = r123.getCombineBaseInfo();
        if (r125 == null) goto L68;
        r125.setCurrentStrategyState(2);
        goto L68
    L55:
        if (r121 == null) goto L44;
        Iterator<T> r126 = r121.iterator();
    L58:
        if (r126.hasNext() == false) goto L44;
        CombineInfo r127 = (CombineInfo) r126.next();
        CombineBaseInfo r128 = r127.getCombineBaseInfo();
        if (r128 == null) goto L62;
        r128.setCombineInfoId(r118);
    L62:
        CombineBaseInfo r129 = r127.getCombineBaseInfo();
        if (r129 == null) goto L58;
        r129.setCurrentStrategyState(3);
    L52:
        r121 = null;
    L75:
        Strategy r130 = f69033a;
        if (r130 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L78:
        if (r130 == null) goto L93;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r131 = r130.getAbInfos();
        if (r131 == null) goto L93;
        Collection<CopyOnWriteArrayList<CombineInfo>> r132 = r131.values();
        if (r132 == null) goto L93;
        Iterator<T> r133 = r132.iterator();
    L85:
        if (r133.hasNext() == false) goto L93;
        CopyOnWriteArrayList r134 = (CopyOnWriteArrayList) r133.next();
        Strategy r135 = f69033a;
        if (r135 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L89:
        if (r135 == null) goto L85;
        CopyOnWriteArrayList<CombineInfo> r136 = r135.getCombineStrategys();
        if (r136 == null) goto L85;
        r136.addAll(0, r134);
    L93:
        boolean r137 = AotuCharacterHandler.f69021a;
        Strategy r138 = f69033a;
        if (r138 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L96:
        AotuCharacterHandler.f69022b = r138.getChList();
        Strategy r139 = f69033a;
        if (r139 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L99:
        Set r140 = ((LinkedHashMap) f69034b).keySet();
        if (r140 == null) goto L112;
        Iterator r141 = r140.iterator();
    L103:
        if (r141.hasNext() == false) goto L112;
        String r142 = (String) r141.next();
        if (r139 == null) goto L107;
        List<CombineInfo> r143 = r139.getCombineInfosByFaName(r142);
    L108:
        if (r143 == null) goto L103;
        BaseFactorProcessor r144 = (BaseFactorProcessor) ((LinkedHashMap) f69034b).get(r142);
        if (r144 == null) goto L103;
        r144.e(r143);
        goto L103
    L107:
        r143 = null;
    L112:
        com.bytedance.android.live.impl.processor.b r145 = f69035c;
        if (r139 == null) goto L136;
        CopyOnWriteArrayList<CombineInfo> r146 = r139.getCombineStrategys();
        if (r146 == null) goto L136;
        ArrayList r147 = new ArrayList();
        Iterator<T> r148 = r146.iterator();
    L118:
        if (r148.hasNext() == false) goto L137;
        Object r149 = r148.next();
        CombineInfo r150 = (CombineInfo) r149;
        if (r150 == null) goto L133;
        CopyOnWriteArrayList<CombbineFactorInfo> r151 = r150.getFaList();
        if (r151 == null) goto L133;
        if (r151.isEmpty() == true) goto L132;
        Iterator<T> r152 = r151.iterator();
    L128:
        if (r152.hasNext() == false) goto L132;
        if ((!f69034b.containsKey(((CombbineFactorInfo) r152.next()).getFaName())) == true) goto L128;
    L132:
        boolean r153 = true;
    L134:
        if (r153 == false) goto L118;
        r147.add(r149);
    L133:
        r153 = false;
    L137:
        r145.e(r147);
        f69042j = true;
        Lazy r154 = TaskManager.f69297a;
        Strategy r155 = f69033a;
        if (r155 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L140:
        TaskManager.b(r155);
        if (f().getEnableInitOpt() == false) goto L143;
        TaskManager.c(new StrategyManager$initSource$2(this));
        boolean r156 = AotuCharacterHandler.f69021a;
        AotuCharacterHandler.b(new StrategyManager$initSource$3(this), new StrategyManager$initSource$4(this));
    L143:
        long r157 = System.currentTimeMillis() - r100;
        f69043k = r111;
        Lazy r158 = StrategyTracingMonitor.f69241a;
        StrategyTracingMonitor.a(c(this, 0, r157, null, 4));
        Iterator r159 = ((ArrayList) f69041i).iterator();
    L145:
        if (r159.hasNext() == false) goto L148;
        ((StrategyInitObserver) r159.next()).onSuccess(r111);
        goto L145
    L148:
        if (((Boolean) f69047o.getValue()).booleanValue() == false) goto L197;
        Observable.fromCallable(a.f69052a).subscribeOn(Schedulers.io()).subscribe(b.f69053a);
        return;
    L197:
        return;
    L136:
        r147 = new ArrayList();
    L40:
        r116 = null;
        goto L41
    }

    public final Object e(String r110, String r111, Object r112) {
        Intrinsics.checkNotNullParameter(r110, "faName");
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        if (((Boolean) f69046n.getValue()).booleanValue() == true) goto L5;
    L30:
        return r112;
    L5:
        if (f69042j == false) goto L30;
        if (f().getEnableInitOpt() == true) goto L10;
        Lazy r100 = TaskManager.f69297a;
        TaskManager.c(new StrategyManager$getFactor$4(this));
        boolean r101 = AotuCharacterHandler.f69021a;
        AotuCharacterHandler.a(new StrategyManager$getFactor$5(this), new StrategyManager$getFactor$6(this));
    L10:
        StrategyMutableLiveData r102 = new StrategyMutableLiveData();
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, BaseFactorProcessor> r104 = f69034b;
        if (r104.containsKey(r110) == false) goto L15;
        BaseFactorProcessor r105 = (BaseFactorProcessor) ((LinkedHashMap) r104).get(r110);
        if (r105 == null) goto L17;
        r105.c(r110, r111, r112, r102, r103, f69043k);
    L17:
        if (f69044l == false) goto L22;
        if (f().getEnableInitOpt() == true) goto L22;
        g();
    L22:
        if ((!Intrinsics.areEqual(r102.getValue(), r112)) == false) goto L29;
        String[] r113 = (String[]) f69050r.getValue();
        if (r113 == null) goto L29;
        if (ArraysKt.contains(r113, r110) != true) goto L29;
        StrategyTeaLogHelper.e(r110);
    L29:
        return r102.getValue();
    L15:
        f69035c.c(r110, r111, r112, r102, r103, f69043k);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> LiveData<T> d(String r110, T r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "faName");
        if (((Boolean) f69046n.getValue()).booleanValue() == true) goto L10;
        ConcurrentHashMap r114 = (ConcurrentHashMap) f69036d;
        Object r115 = r114.get(r110);
        if (r115 != null) goto L67;
        StrategyMutableLiveData r116 = new StrategyMutableLiveData();
        r116.setValue(r111);
        r114.put(r110, r116);
        return r116;
    L67:
        return (LiveData) r115;
    L10:
        if (f69042j == true) goto L21;
        if (f().getEnableStrategyInitCache() == false) goto L17;
        boolean r100 = f().getEnableUseSliceStrategy();
        f69038f = System.currentTimeMillis() - ((IUtilsCommonService) k.n(IUtilsCommonService.class)).startTimeOfSDKInitTracer();
        Strategy r101 = oa0.a.a(r100);
        if (r101 == null) goto L17;
        f69051s.h(r101, true);
        ALogger.i("strategy_tag", "Use SP cache");
    L17:
        if (f69042j == true) goto L21;
        ALogger.i("strategy_tag", "strategy disable");
        StrategyMutableLiveData r117 = new StrategyMutableLiveData();
        r117.setValue(r111);
        return r117;
    L21:
        if (f().getEnableInitOpt() == true) goto L23;
        Lazy r102 = TaskManager.f69297a;
        TaskManager.c(new StrategyManager$getFactor$1(this));
        boolean r103 = AotuCharacterHandler.f69021a;
        AotuCharacterHandler.a(new StrategyManager$getFactor$2(this), new StrategyManager$getFactor$3(this));
    L23:
        ConcurrentHashMap r104 = (ConcurrentHashMap) f69036d;
        if (r104.containsKey(r110) == false) goto L31;
        if (r113 == false) goto L31;
        Object r118 = r104.get(r110);
        if (r118 == null) goto L30;
        LiveData<T> r119 = (LiveData) r118;
    L52:
        if (f69044l == true) goto L54;
    L56:
        if (r112 == true) goto L58;
    L64:
        return r119;
    L58:
        if ((!Intrinsics.areEqual(r119, r111)) == false) goto L64;
        String[] r120 = (String[]) f69050r.getValue();
        if (r120 == null) goto L64;
        if (ArraysKt.contains(r120, r110) != true) goto L64;
        StrategyTeaLogHelper.e(r110);
        goto L64
    L54:
        if (f().getEnableInitOpt() == true) goto L56;
        g();
        goto L56
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L31:
        StrategyMutableLiveData r121 = new StrategyMutableLiveData();
        LinkedHashMap r105 = new LinkedHashMap();
        Map<String, BaseFactorProcessor> r106 = f69034b;
        if (r106.containsKey(r110) == false) goto L36;
        BaseFactorProcessor r107 = (BaseFactorProcessor) ((LinkedHashMap) r106).get(r110);
        if (r107 == null) goto L38;
        r107.c(r110, null, r111, r121, r105, f69043k);
    L38:
        if (r104.containsKey(r110) == false) goto L48;
        Object r108 = r104.get(r110);
        if (r108 == null) goto L47;
        ((StrategyMutableLiveData) r108).setValue(r121.getValue());
        Object r122 = r104.get(r110);
        if (r122 == null) goto L45;
        r119 = (LiveData) r122;
        goto L52
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<T>");
    L48:
        r104.put(r110, r121);
        Object r123 = r104.get(r110);
        if (r123 == null) goto L66;
        r119 = (LiveData) r123;
        goto L52
    L66:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L36:
        f69035c.c(r110, null, r111, r121, r105, f69043k);
        goto L38
    }

    public static Map c(StrategyManager r100, int r101, long r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = -1;
    L5:
        String r105 = "";
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.getClass();
        LinkedHashMap r106 = new LinkedHashMap();
        if (r101 != 0) goto L17;
        Strategy r107 = f69033a;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L13:
        String r108 = r107.getId();
        if (r108 == null) goto L17;
        r105 = r108;
    L17:
        r106.put("strategy_id", r105);
        r106.put("init_duration", String.valueOf(System.currentTimeMillis() - ((IUtilsCommonService) k.n(IUtilsCommonService.class)).startTimeOfSDKInitTracer()));
        r106.put("init_by_cache", String.valueOf(f69043k));
        r106.put("fetch_result", String.valueOf(oa0.a.f522519a));
        r106.put("init_result", String.valueOf(r101));
        r106.put("fetch_msg", oa0.a.f522520b);
        r106.put("init_msg", r103);
        r106.put("strategy_fetch_time", String.valueOf(oa0.a.f522521c));
        r106.put("json_parse_time", String.valueOf(oa0.a.f522522d));
        r106.put("init_source_time", String.valueOf(r102));
        r106.put("trigger_init_duration", String.valueOf(f69038f));
        if (f69043k == true) goto L20;
        String r109 = String.valueOf(System.currentTimeMillis() - f69039g);
    L21:
        r106.put("init_function_time", r109);
        return r106;
    L20:
        r109 = "-1";
        goto L21
    }
}
