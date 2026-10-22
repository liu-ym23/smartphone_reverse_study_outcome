package com.stepos.aicgroup.resource;

import a6.a;
import a6.d;
import a6.e;
import a6.f;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.stepos.aicgroup.AiDispatchersManager;
import com.stepos.aicgroup.CpuUsage;
import com.stepos.aicgroup.IoUsage;
import com.stepos.aicgroup.MemoryState;
import com.stepos.aicgroup.memory.MemoryPressureCallback;
import com.stepos.aicgroup.memory.MemorySnapshot;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.aicgroup.resource.ResourcePressureSceneManager;
import com.stepos.scene.SceneManager;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ResourcePressureSceneManager {
    private static final String CLASS_SCENE_CALLBACK = "com.stepos.scene.SceneManager$SceneCallback";
    private static final String SERVICE_NAME = "stepscene";
    private static final String TAG = "ResPressureScene";
    private static volatile boolean available;
    private static volatile boolean batteryCharging;
    private static volatile boolean batteryCritical;
    private static volatile boolean batteryLow;
    private static volatile Object callbackProxy;
    private static volatile int cpuScene;
    private static volatile boolean initialized;
    private static volatile int ioScene;
    private static volatile int memScene;
    private static volatile Object sceneManager;
    public static final ResourcePressureSceneManager INSTANCE = new ResourcePressureSceneManager();
    private static final int MEM_MODERATE = 31001;
    private static final int MEM_LOW = 31002;
    private static final int MEM_CRITICAL = 31003;
    private static final int IO_MODERATE = 31101;
    private static final int IO_SEVERE = 31102;
    private static final int IO_CRITICAL = 31103;
    private static final int CPU_MODERATE = 31201;
    private static final int CPU_SEVERE = 31202;
    private static final int CPU_CRITICAL = 31203;
    private static final int BATTERY_LOW = 20000;
    private static final int BATTERY_CRITICAL = 20002;
    private static final int BATTERY_CHARGING = 20001;
    private static final int POWER_SAVE = 50051;
    private static final int[] ALL_SCENES = {MEM_MODERATE, MEM_LOW, MEM_CRITICAL, IO_MODERATE, IO_SEVERE, IO_CRITICAL, CPU_MODERATE, CPU_SEVERE, CPU_CRITICAL, BATTERY_LOW, BATTERY_CRITICAL, BATTERY_CHARGING, POWER_SAVE};
    private static final ExecutorService executor = Executors.newSingleThreadExecutor(new d(0));
    private static final CopyOnWriteArrayList<MemoryPressureCallback> memoryCallbacks = new CopyOnWriteArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MemoryState.values().length];
            try {
                iArr[MemoryState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemoryState.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MemoryState.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MemoryState.ULTRA_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ResourcePressureSceneManager() {
    }

    private final Object createSceneListenerProxy(ClassLoader classLoader, Class<?>[] clsArr) throws IllegalArgumentException {
        Object objNewProxyInstance = Proxy.newProxyInstance(classLoader, clsArr, new a(0));
        g.e(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createSceneListenerProxy$lambda$7(Object obj, Method method, Object[] objArr) {
        if (!g.b(method.getDeclaringClass(), Object.class)) {
            if (g.b(method.getName(), "onSceneStateUpdate") && objArr != null && objArr.length == 1) {
                INSTANCE.onSceneState(objArr[0]);
            }
            return null;
        }
        String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && name.equals("hashCode")) {
                        return Integer.valueOf(System.identityHashCode(obj));
                    }
                } else if (name.equals("equals")) {
                    return Boolean.valueOf(obj == (objArr != null ? l.g0(objArr, 0) : null));
                }
            } else if (name.equals("toString")) {
                return ai.onnxruntime.a.k("ResPressureSceneListener@", Integer.toHexString(System.identityHashCode(obj)));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debugInject$lambda$4(int i10, boolean z) {
        INSTANCE.handle(i10, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, TAG, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void feedBattery() {
        Pair pair = batteryCharging ? new Pair(100, Boolean.TRUE) : batteryCritical ? new Pair(3, Boolean.FALSE) : batteryLow ? new Pair(15, Boolean.FALSE) : new Pair(50, Boolean.FALSE);
        AiDispatchersManager.INSTANCE.onBatteryChanged(((Number) pair.f9985a).intValue(), ((Boolean) pair.f9986b).booleanValue());
    }

    private final void handle(int i10, boolean z) {
        switch (i10) {
            case BATTERY_LOW /* 20000 */:
                batteryLow = z;
                feedBattery();
                break;
            case BATTERY_CHARGING /* 20001 */:
                batteryCharging = z;
                feedBattery();
                break;
            case BATTERY_CRITICAL /* 20002 */:
                batteryCritical = z;
                feedBattery();
                break;
            case MEM_MODERATE /* 31001 */:
            case MEM_LOW /* 31002 */:
            case MEM_CRITICAL /* 31003 */:
                memScene = nextScene(memScene, i10, z);
                MemoryState memoryState = toMemoryState(memScene);
                AiDispatchersManager.INSTANCE.onMemoryChanged(memoryState);
                notifyMemoryCallbacks(toPressureLevel(memoryState));
                break;
            case IO_MODERATE /* 31101 */:
            case IO_SEVERE /* 31102 */:
            case IO_CRITICAL /* 31103 */:
                ioScene = nextScene(ioScene, i10, z);
                AiDispatchersManager.INSTANCE.onIoUsageChanged(toIoUsage(ioScene));
                break;
            case CPU_MODERATE /* 31201 */:
            case CPU_SEVERE /* 31202 */:
            case CPU_CRITICAL /* 31203 */:
                cpuScene = nextScene(cpuScene, i10, z);
                AiDispatchersManager.INSTANCE.onCpuUsageChanged(toCpuUsage(cpuScene));
                break;
            case POWER_SAVE /* 50051 */:
                AiDispatchersManager.INSTANCE.onPowerSaveModeChanged(z);
                break;
            default:
                Log.d(TAG, "未知场景 " + i10 + "，忽略");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(Context context) {
        ResourcePressureSceneManager resourcePressureSceneManager = INSTANCE;
        Context applicationContext = context.getApplicationContext();
        g.e(applicationContext, "getApplicationContext(...)");
        resourcePressureSceneManager.subscribe(applicationContext);
    }

    private final int nextScene(int i10, int i11, boolean z) {
        if (z) {
            return i11;
        }
        if (i10 == i11) {
            return 0;
        }
        return i10;
    }

    private final void notifyMemoryCallbacks(PressureLevel pressureLevel) {
        Iterator<T> it = memoryCallbacks.iterator();
        while (it.hasNext()) {
            try {
                ((MemoryPressureCallback) it.next()).onPressureLevelChanged(pressureLevel, MemorySnapshot.Companion.getEMPTY());
            } catch (Throwable th) {
                Log.w(TAG, "memory callback threw", th);
            }
        }
    }

    private final void onSceneState(Object obj) {
        String string;
        if (obj == null) {
            return;
        }
        try {
            Object objInvoke = obj.getClass().getMethod("getSceneId", null).invoke(obj, null);
            Number number = objInvoke instanceof Number ? (Number) objInvoke : null;
            if (number != null) {
                final int iIntValue = number.intValue();
                Object objInvoke2 = obj.getClass().getMethod("getStatus", null).invoke(obj, null);
                if (objInvoke2 != null && (string = objInvoke2.toString()) != null) {
                    final boolean zEquals = string.equals("TRIGGERED");
                    executor.execute(new Runnable() { // from class: a6.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ResourcePressureSceneManager.onSceneState$lambda$5(iIntValue, zEquals);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            Log.w(TAG, "parse SceneState failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSceneState$lambda$5(int i10, boolean z) {
        INSTANCE.handle(i10, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void release$lambda$3() {
        INSTANCE.unsubscribe();
    }

    private final void subscribe(Context context) {
        Object systemService;
        try {
            systemService = context.getSystemService(SERVICE_NAME);
        } catch (Throwable th) {
            Log.w(TAG, "getSystemService(stepscene) failed", th);
            systemService = null;
        }
        if (systemService == null) {
            Log.w(TAG, "stepscene 不可用，保持 inert（按默认策略运行）");
            return;
        }
        sceneManager = systemService;
        try {
            ClassLoader classLoader = SceneManager.SceneCallback.class.getClassLoader();
            g.e(classLoader, "getClassLoader(...)");
            Object objCreateSceneListenerProxy = createSceneListenerProxy(classLoader, new Class[]{SceneManager.SceneCallback.class});
            Method method = systemService.getClass().getMethod("registerSceneListener", Integer.TYPE, SceneManager.SceneCallback.class);
            for (int i10 : ALL_SCENES) {
                method.invoke(systemService, Integer.valueOf(i10), objCreateSceneListenerProxy);
            }
            callbackProxy = objCreateSceneListenerProxy;
            available = true;
            int[] iArr = ALL_SCENES;
            g.f(iArr, "<this>");
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) "");
            int i11 = 0;
            for (int i12 : iArr) {
                i11++;
                if (i11 > 1) {
                    sb2.append((CharSequence) ", ");
                }
                sb2.append((CharSequence) String.valueOf(i12));
            }
            sb2.append((CharSequence) "");
            Log.i(TAG, "已订阅整机压力 + 电源域场景: " + sb2.toString());
        } catch (Throwable th2) {
            Log.w(TAG, "registerSceneListener 失败", th2);
        }
    }

    private final CpuUsage toCpuUsage(int i10) {
        switch (i10) {
            case CPU_MODERATE /* 31201 */:
                return CpuUsage.MODERATE;
            case CPU_SEVERE /* 31202 */:
                return CpuUsage.HIGH;
            case CPU_CRITICAL /* 31203 */:
                return CpuUsage.CRITICAL;
            default:
                return CpuUsage.NORMAL;
        }
    }

    private final IoUsage toIoUsage(int i10) {
        switch (i10) {
            case IO_MODERATE /* 31101 */:
                return IoUsage.MODERATE;
            case IO_SEVERE /* 31102 */:
                return IoUsage.HIGH;
            case IO_CRITICAL /* 31103 */:
                return IoUsage.CRITICAL;
            default:
                return IoUsage.NORMAL;
        }
    }

    private final MemoryState toMemoryState(int i10) {
        switch (i10) {
            case MEM_MODERATE /* 31001 */:
                return MemoryState.MODERATE;
            case MEM_LOW /* 31002 */:
                return MemoryState.LOW;
            case MEM_CRITICAL /* 31003 */:
                return MemoryState.ULTRA_LOW;
            default:
                return MemoryState.NORMAL;
        }
    }

    private final PressureLevel toPressureLevel(MemoryState memoryState) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[memoryState.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return PressureLevel.NORMAL;
        }
        if (i10 == 3) {
            return PressureLevel.LOW;
        }
        if (i10 == 4) {
            return PressureLevel.ULTRA_LOW;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void unsubscribe() {
        Object obj;
        Object obj2 = sceneManager;
        if (obj2 == null || (obj = callbackProxy) == null) {
            return;
        }
        try {
            Method method = obj2.getClass().getMethod("unregisterSceneListener", Integer.TYPE, SceneManager.SceneCallback.class);
            for (int i10 : ALL_SCENES) {
                method.invoke(obj2, Integer.valueOf(i10), obj);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void debugInject(final int i10, final boolean z) {
        if (g.b(Build.TYPE, "user")) {
            Log.w(TAG, "debugInject 在 user 生产版禁用（仅 userdebug/eng）");
        } else {
            executor.execute(new Runnable() { // from class: a6.c
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcePressureSceneManager.debugInject$lambda$4(i10, z);
                }
            });
        }
    }

    public final synchronized void init(Context context) {
        g.f(context, "context");
        if (initialized) {
            return;
        }
        initialized = true;
        executor.execute(new e(context, 0));
    }

    public final boolean isAvailable() {
        return available;
    }

    public final void registerMemoryCallback(MemoryPressureCallback callback) {
        g.f(callback, "callback");
        memoryCallbacks.addIfAbsent(callback);
    }

    public final synchronized void release() {
        if (initialized) {
            executor.execute(new f(0));
            initialized = false;
        }
    }

    public final void unregisterMemoryCallback(MemoryPressureCallback callback) {
        g.f(callback, "callback");
        memoryCallbacks.remove(callback);
    }
}
