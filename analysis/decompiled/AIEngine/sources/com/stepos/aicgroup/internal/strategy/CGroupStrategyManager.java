package com.stepos.aicgroup.internal.strategy;

import android.util.Log;
import com.stepos.aicgroup.internal.strategy.CGroupStrategyManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.collections.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import mb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CGroupStrategyManager {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public static volatile CGroupStrategyManager f5742b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5743a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CGroupStrategyManager getInstance() {
            CGroupStrategyManager cGroupStrategyManager;
            CGroupStrategyManager cGroupStrategyManager2 = CGroupStrategyManager.f5742b;
            if (cGroupStrategyManager2 != null) {
                return cGroupStrategyManager2;
            }
            synchronized (this) {
                cGroupStrategyManager = CGroupStrategyManager.f5742b;
                if (cGroupStrategyManager == null) {
                    cGroupStrategyManager = new CGroupStrategyManager(null);
                    CGroupStrategyManager.f5742b = cGroupStrategyManager;
                }
            }
            return cGroupStrategyManager;
        }

        public Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class StrategyWithPriority {

        /* renamed from: a, reason: collision with root package name */
        public final CGroupStrategy f5744a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5745b;

        public StrategyWithPriority(CGroupStrategy strategy, int i10) {
            g.f(strategy, "strategy");
            this.f5744a = strategy;
            this.f5745b = i10;
        }

        public static /* synthetic */ StrategyWithPriority copy$default(StrategyWithPriority strategyWithPriority, CGroupStrategy cGroupStrategy, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                cGroupStrategy = strategyWithPriority.f5744a;
            }
            if ((i11 & 2) != 0) {
                i10 = strategyWithPriority.f5745b;
            }
            return strategyWithPriority.copy(cGroupStrategy, i10);
        }

        public final CGroupStrategy component1() {
            return this.f5744a;
        }

        public final int component2() {
            return this.f5745b;
        }

        public final StrategyWithPriority copy(CGroupStrategy strategy, int i10) {
            g.f(strategy, "strategy");
            return new StrategyWithPriority(strategy, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StrategyWithPriority)) {
                return false;
            }
            StrategyWithPriority strategyWithPriority = (StrategyWithPriority) obj;
            return g.b(this.f5744a, strategyWithPriority.f5744a) && this.f5745b == strategyWithPriority.f5745b;
        }

        public final int getPriority() {
            return this.f5745b;
        }

        public final CGroupStrategy getStrategy() {
            return this.f5744a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f5745b) + (this.f5744a.hashCode() * 31);
        }

        public String toString() {
            return "StrategyWithPriority(strategy=" + this.f5744a + ", priority=" + this.f5745b + ")";
        }
    }

    public /* synthetic */ CGroupStrategyManager(e eVar) {
        this();
    }

    public final Map<String, String> getAllCGroups(int i10) {
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            CGroupStrategy cGroupStrategyComponent1 = ((StrategyWithPriority) obj).component1();
            if (cGroupStrategyComponent1.isAvailable()) {
                Map<String, String> allCGroups = cGroupStrategyComponent1.getAllCGroups(i10);
                if (!allCGroups.isEmpty()) {
                    return allCGroups;
                }
            }
        }
        Log.w("CGroupStrategyManager", "所有策略都无法获取进程 " + i10 + " 的 CGroup 信息");
        return b.d0();
    }

    public final List<String> getAvailableStrategies() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f5743a;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            if (((StrategyWithPriority) obj).getStrategy().isAvailable()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(m.Z(arrayList, 10));
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList3.add(((StrategyWithPriority) obj2).getStrategy().getName());
        }
        return arrayList3;
    }

    public final String getCGroup(int i10, String controller) {
        String cGroup;
        g.f(controller, "controller");
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            CGroupStrategy cGroupStrategyComponent1 = ((StrategyWithPriority) obj).component1();
            if (cGroupStrategyComponent1.isAvailable() && (cGroup = cGroupStrategyComponent1.getCGroup(i10, controller)) != null) {
                return cGroup;
            }
        }
        Log.w("CGroupStrategyManager", "所有策略都无法获取进程 " + i10 + " 的 " + controller + " CGroup");
        return null;
    }

    public final CGroupStrategy getCurrentStrategy() {
        Object obj;
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((StrategyWithPriority) obj).getStrategy().isAvailable()) {
                break;
            }
        }
        StrategyWithPriority strategyWithPriority = (StrategyWithPriority) obj;
        if (strategyWithPriority != null) {
            return strategyWithPriority.getStrategy();
        }
        return null;
    }

    public final void registerStrategy(CGroupStrategy strategy, int i10) {
        g.f(strategy, "strategy");
        synchronized (this.f5743a) {
            try {
                this.f5743a.add(new StrategyWithPriority(strategy, i10));
                ArrayList arrayList = this.f5743a;
                if (arrayList.size() > 1) {
                    q.k0(arrayList, new Comparator() { // from class: com.stepos.aicgroup.internal.strategy.CGroupStrategyManager$registerStrategy$lambda$1$$inlined$sortByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t8, T t10) {
                            return ob.b.a(Integer.valueOf(((CGroupStrategyManager.StrategyWithPriority) t10).getPriority()), Integer.valueOf(((CGroupStrategyManager.StrategyWithPriority) t8).getPriority()));
                        }
                    });
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        String name = strategy.getName();
        boolean zIsAvailable = strategy.isAvailable();
        StringBuilder sbF = h0.e.f("注册策略: ", name, " (优先级: ", i10, ", 可用: ");
        sbF.append(zIsAvailable);
        sbF.append(")");
        Log.i("CGroupStrategyManager", sbF.toString());
    }

    public final boolean setCGroup(int i10, String controller, String cgroupPath) {
        g.f(controller, "controller");
        g.f(cgroupPath, "cgroupPath");
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            CGroupStrategy cGroupStrategyComponent1 = ((StrategyWithPriority) obj).component1();
            if (cGroupStrategyComponent1.isAvailable() && cGroupStrategyComponent1.setCGroup(i10, controller, cgroupPath)) {
                return true;
            }
        }
        StringBuilder sbE = h0.e.e("所有策略都无法设置进程 ", i10, " 到 ", controller, " CGroup: ");
        sbE.append(cgroupPath);
        Log.w("CGroupStrategyManager", sbE.toString());
        return false;
    }

    public final boolean setProcessProfiles(int i10, int i11, List<String> profiles) {
        g.f(profiles, "profiles");
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            CGroupStrategy cGroupStrategyComponent1 = ((StrategyWithPriority) obj).component1();
            if (cGroupStrategyComponent1.isAvailable() && cGroupStrategyComponent1.setProcessProfiles(i10, i11, profiles)) {
                return true;
            }
        }
        StringBuilder sbD = h0.e.d(i11, "所有策略都无法设置进程 ", i10, " (UID ", ") 的任务配置文件: ");
        sbD.append(profiles);
        Log.w("CGroupStrategyManager", sbD.toString());
        return false;
    }

    public final boolean setTaskProfiles(int i10, List<String> profiles) {
        g.f(profiles, "profiles");
        ArrayList arrayList = this.f5743a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            CGroupStrategy cGroupStrategyComponent1 = ((StrategyWithPriority) obj).component1();
            if (cGroupStrategyComponent1.isAvailable() && cGroupStrategyComponent1.setTaskProfiles(i10, profiles)) {
                return true;
            }
        }
        Log.w("CGroupStrategyManager", "所有策略都无法设置线程 " + i10 + " 的任务配置文件: " + profiles);
        return false;
    }

    public final boolean unregisterStrategy(String strategyName) {
        boolean zRemoveIf;
        g.f(strategyName, "strategyName");
        synchronized (this.f5743a) {
            zRemoveIf = this.f5743a.removeIf(new b9.b(new a(strategyName), 1));
            if (zRemoveIf) {
                Log.i("CGroupStrategyManager", "移除策略: ".concat(strategyName));
            }
        }
        return zRemoveIf;
    }

    public CGroupStrategyManager() {
        String name;
        this.f5743a = new ArrayList();
        registerStrategy(new NativeCGroupStrategy(), 100);
        registerStrategy(new FileSystemCGroupStrategy(), 50);
        List<String> availableStrategies = getAvailableStrategies();
        CGroupStrategy currentStrategy = getCurrentStrategy();
        Log.i("CGroupStrategyManager", "=== CGroup 策略管理器 ===");
        Log.i("CGroupStrategyManager", "可用策略: " + availableStrategies);
        Log.i("CGroupStrategyManager", "当前策略: ".concat((currentStrategy == null || (name = currentStrategy.getName()) == null) ? "无" : name));
        Log.i("CGroupStrategyManager", "========================");
    }
}
