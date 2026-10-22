package com.stepos.aicgroup;

import android.content.Context;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import b6.i;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.internal.ailimit.BatteryStrategy;
import com.stepos.aicgroup.internal.ailimit.CpuStrategy;
import com.stepos.aicgroup.internal.ailimit.DimensionConstraint;
import com.stepos.aicgroup.internal.ailimit.IoStrategy;
import com.stepos.aicgroup.internal.ailimit.MemoryStrategy;
import com.stepos.aicgroup.internal.ailimit.PowerSaveModeStrategy;
import com.stepos.aicgroup.internal.ailimit.StopAction;
import com.stepos.aicgroup.internal.ailimit.SystemStateStrategy;
import com.stepos.aicgroup.internal.ailimit.TemperatureStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.collections.EmptySet;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import mb.m;
import mb.v;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiDispatchersManager {
    public static final AiDispatchersManager INSTANCE = new AiDispatchersManager();

    /* renamed from: a, reason: collision with root package name */
    public static final TemperatureStrategy f5613a;

    /* renamed from: b, reason: collision with root package name */
    public static final MemoryStrategy f5614b;

    /* renamed from: e, reason: collision with root package name */
    public static final CpuStrategy f5617e;

    /* renamed from: f, reason: collision with root package name */
    public static final IoStrategy f5618f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile Integer f5619g;
    public static volatile Integer h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile Integer f5620i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile Integer f5621j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile Integer f5622k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile Integer f5623l;

    /* renamed from: n, reason: collision with root package name */
    public static final CoroutineScope f5625n;

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap<String, StopAction> f5626o;

    /* renamed from: p, reason: collision with root package name */
    public static volatile Set<String> f5627p;

    /* renamed from: q, reason: collision with root package name */
    public static volatile Job f5628q;
    public static volatile Job r;

    /* renamed from: s, reason: collision with root package name */
    public static volatile boolean f5629s;

    /* renamed from: c, reason: collision with root package name */
    public static final BatteryStrategy f5615c = new BatteryStrategy(0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    /* renamed from: d, reason: collision with root package name */
    public static final PowerSaveModeStrategy f5616d = new PowerSaveModeStrategy(false, 1, null);

    /* renamed from: m, reason: collision with root package name */
    public static final lb.d f5624m = kotlin.b.b(new a9.b(9));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StopAction.values().length];
            try {
                iArr[StopAction.CANCEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 1;
        f5613a = new TemperatureStrategy(null, i10, 0 == true ? 1 : 0);
        f5614b = new MemoryStrategy(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f5617e = new CpuStrategy(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f5618f = new IoStrategy(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new d(0));
        kotlin.jvm.internal.g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        f5625n = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        f5626o = new HashMap<>();
        f5627p = EmptySet.f10003a;
    }

    public static void a(SystemStateStrategy systemStateStrategy, Integer num, l lVar) {
        int stateLevel = systemStateStrategy.getStateLevel();
        int iIntValue = num != null ? num.intValue() : 0;
        if (stateLevel == iIntValue) {
            Log.d("AiDispatchersManager", "[" + systemStateStrategy.getName() + "] 状态未变: " + systemStateStrategy.getStateDescription());
            return;
        }
        lVar.invoke(Integer.valueOf(stateLevel));
        String name = systemStateStrategy.getName();
        String stateDescription = systemStateStrategy.getStateDescription();
        StringBuilder sbF = h0.e.f("[", name, "] 状态变化: Level ", iIntValue, " -> ");
        sbF.append(stateLevel);
        sbF.append(" (");
        sbF.append(stateDescription);
        sbF.append(")");
        Log.i("AiDispatchersManager", sbF.toString());
        if (stateLevel > iIntValue) {
            BuildersKt__Builders_commonKt.launch$default(f5625n, null, null, new AiDispatchersManager$signalChanged$1(systemStateStrategy, null), 3, null);
            return;
        }
        Job job = r;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        r = BuildersKt__Builders_commonKt.launch$default(f5625n, null, null, new AiDispatchersManager$signalChanged$2(systemStateStrategy, null), 3, null);
    }

    public static final void access$reconcile(AiDispatchersManager aiDispatchersManager, String str) {
        aiDispatchersManager.getClass();
        List list = (List) f5624m.getValue();
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SystemStateStrategy) it.next()).desiredSuspension());
        }
        Map<AiDispatchers.DispatcherPriority, StopAction> mapComputeDesiredByPriority$aicgroup_release = aiDispatchersManager.computeDesiredByPriority$aicgroup_release(arrayList);
        HashMap map = new HashMap();
        for (Map.Entry<AiDispatchers.DispatcherPriority, StopAction> entry : mapComputeDesiredByPriority$aicgroup_release.entrySet()) {
            AiDispatchers.DispatcherPriority key = entry.getKey();
            StopAction value = entry.getValue();
            Iterator<String> it2 = AiDispatchers.INSTANCE.getDispatcherNamesByPriorities$aicgroup_release(b1.P(key)).iterator();
            while (it2.hasNext()) {
                map.put(it2.next(), value);
            }
        }
        Set setKeySet = map.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        f5627p = kotlin.collections.a.R0(setKeySet);
        for (Map.Entry entry2 : map.entrySet()) {
            String str2 = (String) entry2.getKey();
            StopAction stopAction = (StopAction) entry2.getValue();
            StopAction stopAction2 = StopAction.CANCEL;
            if (stopAction == stopAction2) {
                HashMap<String, StopAction> map2 = f5626o;
                if (map2.get(str2) != stopAction2) {
                    Log.w("AiDispatchersManager", h0.e.c("❌ [", str, "] 取消调度器 ", str2, "（杀任务腾资源）"));
                    AiDispatchers aiDispatchers = AiDispatchers.INSTANCE;
                    aiDispatchers.cancelDispatcher(str2, str);
                    aiDispatchers.pauseDispatcher(str2);
                    map2.put(str2, stopAction2);
                }
            }
            StopAction stopAction3 = StopAction.PAUSE;
            if (stopAction == stopAction3) {
                boolean zPauseDispatcher = AiDispatchers.INSTANCE.pauseDispatcher(str2);
                HashMap<String, StopAction> map3 = f5626o;
                StopAction stopAction4 = map3.get(str2);
                int i10 = stopAction4 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[stopAction4.ordinal()];
                if (i10 == -1) {
                    a0.a.w("⏸️ [", str, "] 暂停调度器 ", str2, "AiDispatchersManager");
                    map3.put(str2, stopAction3);
                } else if (i10 == 1) {
                    map3.put(str2, stopAction3);
                } else if (zPauseDispatcher) {
                    Log.w("AiDispatchersManager", h0.e.c("⏸️ [", str, "] 重新夹停调度器 ", str2, "（中断其逐线程恢复）"));
                }
            }
        }
        Set<String> setKeySet2 = f5626o.keySet();
        kotlin.jvm.internal.g.e(setKeySet2, "<get-keys>(...)");
        Set<String> set = setKeySet2;
        if ((set instanceof Collection) && set.isEmpty()) {
            return;
        }
        Iterator<T> it3 = set.iterator();
        while (it3.hasNext()) {
            if (!f5627p.contains((String) it3.next())) {
                Job job = f5628q;
                if (job == null || !job.isActive()) {
                    f5628q = BuildersKt__Builders_commonKt.launch$default(f5625n, null, null, new AiDispatchersManager$ensureRecoveryWorker$2(2, null), 3, null);
                    return;
                }
                return;
            }
        }
    }

    public final Map<AiDispatchers.DispatcherPriority, StopAction> computeDesiredByPriority$aicgroup_release(List<DimensionConstraint> constraints) {
        kotlin.jvm.internal.g.f(constraints, "constraints");
        HashMap map = new HashMap();
        for (DimensionConstraint dimensionConstraint : constraints) {
            for (AiDispatchers.DispatcherPriority dispatcherPriority : dimensionConstraint.getPriorities()) {
                StopAction stopAction = (StopAction) map.get(dispatcherPriority);
                StopAction stopAction2 = StopAction.CANCEL;
                if (stopAction != stopAction2 && dimensionConstraint.getAction() != stopAction2) {
                    stopAction2 = StopAction.PAUSE;
                }
                map.put(dispatcherPriority, stopAction2);
            }
        }
        return map;
    }

    public final Map<String, Integer> getStatistics() {
        List<AiDispatchers.DispatcherState> allDispatcherStates$aicgroup_release = AiDispatchers.INSTANCE.getAllDispatcherStates$aicgroup_release();
        int iA0 = v.a0(m.Z(allDispatcherStates$aicgroup_release, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (AiDispatchers.DispatcherState dispatcherState : allDispatcherStates$aicgroup_release) {
            linkedHashMap.put(dispatcherState.getName(), Integer.valueOf(AiDispatchers.INSTANCE.getActiveCoroutineCount(dispatcherState.getName())));
        }
        return linkedHashMap;
    }

    public final String getSystemStateInfo() {
        StringBuilder sb2 = new StringBuilder("=== 系统状态（策略模式）===\n");
        TemperatureStrategy temperatureStrategy = f5613a;
        sb2.append(ai.onnxruntime.a.i("温度: ", temperatureStrategy.getStateLevel(), temperatureStrategy.getStateDescription(), " (Level ", ")\n"));
        MemoryStrategy memoryStrategy = f5614b;
        sb2.append(ai.onnxruntime.a.i("内存: ", memoryStrategy.getStateLevel(), memoryStrategy.getStateDescription(), " (Level ", ")\n"));
        BatteryStrategy batteryStrategy = f5615c;
        sb2.append(ai.onnxruntime.a.i("电量: ", batteryStrategy.getStateLevel(), batteryStrategy.getStateDescription(), " (Level ", ")\n"));
        PowerSaveModeStrategy powerSaveModeStrategy = f5616d;
        sb2.append(ai.onnxruntime.a.i("省电模式: ", powerSaveModeStrategy.getStateLevel(), powerSaveModeStrategy.getStateDescription(), " (Level ", ")\n"));
        CpuStrategy cpuStrategy = f5617e;
        sb2.append(ai.onnxruntime.a.i("CPU: ", cpuStrategy.getStateLevel(), cpuStrategy.getStateDescription(), " (Level ", ")\n"));
        IoStrategy ioStrategy = f5618f;
        sb2.append(ai.onnxruntime.a.i("IO: ", ioStrategy.getStateLevel(), ioStrategy.getStateDescription(), " (Level ", ")\n"));
        sb2.append("\n=== 调度器状态 ===\n");
        for (AiDispatchers.DispatcherState dispatcherState : kotlin.collections.a.I0(AiDispatchers.INSTANCE.getAllDispatcherStates$aicgroup_release(), new Comparator() { // from class: com.stepos.aicgroup.AiDispatchersManager$getSystemStateInfo$lambda$13$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Integer.valueOf(((AiDispatchers.DispatcherState) t10).getPriority().getLevel()), Integer.valueOf(((AiDispatchers.DispatcherState) t8).getPriority().getLevel()));
            }
        })) {
            sb2.append(dispatcherState.getName() + " (" + dispatcherState.getPriority().name() + "):\n");
            AiDispatchers aiDispatchers = AiDispatchers.INSTANCE;
            sb2.append("  活跃作用域: " + aiDispatchers.getActiveCoroutineCount(dispatcherState.getName()) + "\n");
            sb2.append("  暂停状态: " + aiDispatchers.isDispatcherPaused(dispatcherState.getName()) + "\n");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final synchronized void init(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (f5629s) {
            return;
        }
        context.getApplicationContext();
        AiThermalManager.INSTANCE.init(context);
        f5629s = true;
        Log.i("AiDispatchersManager", "AiDispatchersManager 初始化完成（温度经 StepOSThermalManager；电量/省电经场景引擎）");
    }

    public final boolean isInitialized() {
        return f5629s;
    }

    public final void onBatteryChanged(int i10, boolean z) {
        BatteryStrategy batteryStrategy = f5615c;
        batteryStrategy.updateBattery(i10, z);
        a(batteryStrategy, f5620i, new i(7));
    }

    public final void onCpuUsageChanged(CpuUsage cpuUsage) {
        kotlin.jvm.internal.g.f(cpuUsage, "cpuUsage");
        CpuStrategy cpuStrategy = f5617e;
        cpuStrategy.updateCpuUsage(cpuUsage);
        a(cpuStrategy, f5622k, new b6.e(5));
    }

    public final void onIoUsageChanged(IoUsage ioUsage) {
        kotlin.jvm.internal.g.f(ioUsage, "ioUsage");
        IoStrategy ioStrategy = f5618f;
        ioStrategy.updateIoUsage(ioUsage);
        a(ioStrategy, f5623l, new b6.e(6));
    }

    public final void onMemoryChanged(MemoryState memoryState) {
        kotlin.jvm.internal.g.f(memoryState, "memoryState");
        MemoryStrategy memoryStrategy = f5614b;
        memoryStrategy.updateMemoryState(memoryState);
        a(memoryStrategy, h, new i(8));
    }

    public final void onPowerSaveModeChanged(boolean z) {
        PowerSaveModeStrategy powerSaveModeStrategy = f5616d;
        powerSaveModeStrategy.updatePowerSaveMode(z);
        a(powerSaveModeStrategy, f5621j, new b6.e(7));
    }

    public final void onTemperatureChanged(SystemTemperature temperature) {
        kotlin.jvm.internal.g.f(temperature, "temperature");
        TemperatureStrategy temperatureStrategy = f5613a;
        temperatureStrategy.updateTemperature(temperature);
        a(temperatureStrategy, f5619g, new i(6));
    }

    public final String registerCustomStrategy(SystemStateStrategy strategy) {
        kotlin.jvm.internal.g.f(strategy, "strategy");
        Log.i("AiDispatchersManager", "自定义策略注册功能：" + strategy.getName());
        return a0.a.k("策略 ", strategy.getName(), " 已注册（示例）");
    }

    public final synchronized void release() {
        try {
            if (f5629s) {
                AiThermalManager.INSTANCE.release();
                Job job = f5628q;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                Job job2 = r;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, null, 1, null);
                }
                f5629s = false;
                Log.i("AiDispatchersManager", "AiDispatchersManager 已释放");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
