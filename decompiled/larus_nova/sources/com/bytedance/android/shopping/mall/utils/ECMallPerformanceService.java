package com.bytedance.android.shopping.mall.utils;

import android.os.Build;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.shopping.api.mall.ECMallMemoryReportConfig;
import com.bytedance.android.shopping.api.mall.IECMallPerformanceService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kk.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/utils/ECMallPerformanceService;", "Lcom/bytedance/android/shopping/api/mall/IECMallPerformanceService;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPerformanceService implements IECMallPerformanceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f178589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f178590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f178591c = null;

    public static final class a {
        public static final ECMallMemoryReportConfig a() {
            Lazy r100 = ECMallPerformanceService.f178589a;
            return (ECMallMemoryReportConfig) ECMallPerformanceService.f178589a.getValue();
        }

        public a() {
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f178592a;

        public b(Function0 r100) {
            this.f178592a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f178592a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallPerformanceService() {
    }

    static {
        new a();
        f178589a = LazyKt.lazy(ECMallPerformanceService$Companion$memoryReportConfig$2.INSTANCE);
        f178591c = LazyKt.lazy(ECMallPerformanceService$Companion$lastMemoryReportTimestamps$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.api.mall.IECMallPerformanceService
    public final void a(final IECMallPerformanceService.SceneContext r110, final String r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "sceneContext");
        Intrinsics.checkNotNullParameter(r111, "timing");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        boolean r100 = false;
        if (f178590b != null) goto L24;
        monitor-enter(ECMallPerformanceService.class);
        double r101 = Math.random();     // Catch: Throwable -> L20
        Float r102 = a.a().getSampleRatio();     // Catch: Throwable -> L20
        if (r102 == null) goto L12;
        float r103 = r102.floatValue();     // Catch: Throwable -> L20
    L14:
        if (r101 >= r103) goto L16;
        boolean r104 = true;
    L17:
        f178590b = Boolean.valueOf(r104);     // Catch: Throwable -> L20
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(ECMallPerformanceService.class);
        goto L24
    L16:
        r104 = false;
        goto L17
    L12:
        r103 = 0.0f;
    L20:
        th = move-exception;
        throw th;
    L24:
        if ((!Intrinsics.areEqual(f178590b, Boolean.TRUE)) == false) goto L28;
        Lazy r113 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.a.f47501b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by sample ratio");
        return;
    L28:
        if (a.a().isEnabled(r110.f170205c) == true) goto L31;
        Lazy r114 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.a.f47501b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by scene list");
        return;
    L31:
        List<String> r106 = a.a().blockTimingListOf(r110.f170205c);
        if ((!r106.isEmpty()) == true) goto L34;
    L37:
        int r107 = a.a().reportIntervalOf(r110.f170205c);
        if (r107 <= 0) goto L47;
        int r108 = r110.hashCode();
        Lazy r109 = f178591c;
        Long r115 = (Long) ((ConcurrentHashMap) r109.getValue()).get(Integer.valueOf(r108));
        if (r115 != null) goto L42;
        r115 = 0L;
    L42:
        long r116 = r115.longValue();
        long r117 = System.currentTimeMillis();
        if ((r117 - r116) > r107) goto L46;
        Lazy r118 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.a.f47501b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by report interval");
        return;
    L46:
        ((ConcurrentHashMap) r109.getValue()).put(Integer.valueOf(r108), Long.valueOf(r117));
    L47:
        final long r119 = System.currentTimeMillis();
        r110.a(ECMallPerformanceService$reportMemoryStatus$2.INSTANCE);
        int r120 = a.a().reportStrategyOf(r110.f170205c);
        if (r120 != 1) goto L50;
        Map<String, Object> r121 = r110.b(r111);
    L51:
        final Map<String, Object> r122 = r121;
        if (r112 == null) goto L55;
        r100 = r112.booleanValue();
    L57:
        if (r100 == false) goto L59;
        ThreadPoolHelper.d().submit(new ECMallPerformanceService$reportMemoryStatus$3(this, r110, r111, r122, r119));
        return;
    L59:
        b(r110, r111, r122, ECMallPerformanceService$reportMemoryStatus$4.INSTANCE);
        return;
    L55:
        if (r120 == 3) goto L57;
        r100 = true;
        goto L57
    L50:
        r121 = null;
        goto L51
    L34:
        if (r106.contains(r111) == false) goto L37;
        Lazy r123 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.a.f47501b, "ECMallPerformanceMonitor#reportMemoryStatus, report disabled by block timing list");
    }

    public static void b(IECMallPerformanceService.SceneContext r100, final String r101, Map r110, Function1 r111) {
        long r102 = System.nanoTime();
        final LinkedHashMap r103 = new LinkedHashMap();
        if (r110 != null) goto L5;
        r110 = r100.b(r101);
    L5:
        r103.putAll(r110);
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        final LinkedHashMap r112 = new LinkedHashMap();
    L9:
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r112.size()));
        Iterator r105 = r112.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put(((String) r106.getKey()) + '_' + r101, r106.getValue());
        goto L11
    L13:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "params");
        r100.f170204b.putAll(r104);
        Unit r107 = Unit.INSTANCE;
        r103.putAll(r112);
        final float r108 = (System.nanoTime() - r102) / 1000000.0f;
        r103.put("report_cost_duration", Float.valueOf(r108));
        if (r111 == null) goto L16;
        Unit r113 = (Unit) r111.invoke(r103);
    L16:
        Function0<Unit> r114 = new ECMallPerformanceService$reportMemoryStatus$reportAction$1(r108, r101, r103);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        ThreadPoolHelper.d().submit(new b(r114));
        return;
    L19:
        r114.invoke();
        return;
    L8:
        r112 = new LinkedHashMap();
        d.c(new ECMallPerformanceService$collectMemoryParams$1(r112));
        r112.put(BdpAppEventConstant.PARAMS_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        goto L9
    }
}
