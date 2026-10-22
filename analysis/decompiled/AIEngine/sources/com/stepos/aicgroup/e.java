package com.stepos.aicgroup;

import android.util.Log;
import com.stepos.core.common.atomic.AtomicSdkClientReal;
import com.stepos.core.common.memory.NativeMemoryBridge;
import com.stepos.core.common.telemetry.scene.AiStageSceneDonator;
import com.stepos.thermal.StepOSThermalManager;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5693a;

    public /* synthetic */ e(int i10) {
        this.f5693a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5693a) {
            case 0:
                AiThermalManager.INSTANCE.getClass();
                try {
                    Object objInvoke = Class.forName("com.stepos.thermal.StepOSThermalManager").getMethod("get", null).invoke(null, null);
                    if (objInvoke != null) {
                        AiThermalManager.f5637b = objInvoke;
                        ClassLoader classLoader = StepOSThermalManager.OnThermalChangedListener.class.getClassLoader();
                        kotlin.jvm.internal.g.e(classLoader, "getClassLoader(...)");
                        Object objNewProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{StepOSThermalManager.OnThermalChangedListener.class}, new a6.a(1));
                        kotlin.jvm.internal.g.e(objNewProxyInstance, "newProxyInstance(...)");
                        Object objInvoke2 = objInvoke.getClass().getMethod("registerListener", StepOSThermalManager.OnThermalChangedListener.class).invoke(objInvoke, objNewProxyInstance);
                        Boolean bool = objInvoke2 instanceof Boolean ? (Boolean) objInvoke2 : null;
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                        AiThermalManager.f5638c = objNewProxyInstance;
                        AiThermalManager.f5640e = zBooleanValue;
                        Log.i("AiThermalManager", "温度监听注册: " + zBooleanValue + "（StepOSThermalManager）");
                        AiThermalManager.a();
                        break;
                    } else {
                        Log.w("AiThermalManager", "StepOSThermalManager.get() 返回 null，温度维保持 inert");
                        break;
                    }
                } catch (Throwable th) {
                    Log.w("AiThermalManager", "订阅 StepOSThermalManager 失败，温度维保持 inert", th);
                    return;
                }
            case 1:
                AiStageSceneDonator.init$lambda$2();
                break;
            case 2:
                AtomicSdkClientReal.Companion.scheduleIdleRelease$lambda$2$lambda$1();
                break;
            case 3:
                NativeMemoryBridge.purgeTask$lambda$2();
                break;
            default:
                ConcurrentHashMap<String, z6.a> concurrentHashMap = z6.b.f14267a;
                Collection<z6.a> collectionValues = concurrentHashMap.values();
                kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
                Iterator it = kotlin.collections.a.O0(collectionValues).iterator();
                while (it.hasNext()) {
                    try {
                        ((z6.a) it.next()).close();
                        n nVar = n.f10413a;
                    } catch (Throwable th2) {
                        kotlin.c.a(th2);
                    }
                }
                concurrentHashMap.clear();
                z6.b.f14268b.clear();
                break;
        }
    }
}
