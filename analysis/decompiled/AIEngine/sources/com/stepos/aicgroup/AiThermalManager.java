package com.stepos.aicgroup;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiThermalManager {
    public static final AiThermalManager INSTANCE = new AiThermalManager();

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f5636a = Executors.newSingleThreadExecutor(new d(1));

    /* renamed from: b, reason: collision with root package name */
    public static volatile Object f5637b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Object f5638c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f5639d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f5640e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile SystemTemperature f5641f;

    public static void a() {
        Method method;
        SystemTemperature systemTemperature = f5641f;
        if (systemTemperature == null) {
            int iIntValue = -1;
            try {
                Object obj = f5637b;
                Object objInvoke = (obj == null || (method = obj.getClass().getMethod("getMaxTemperature", null)) == null) ? null : method.invoke(f5637b, null);
                Number number = objInvoke instanceof Number ? (Number) objInvoke : null;
                if (number != null) {
                    iIntValue = number.intValue();
                }
            } catch (Throwable th) {
                Log.w("AiThermalManager", "getMaxTemperature 失败", th);
            }
            systemTemperature = iIntValue < 0 ? SystemTemperature.NORMAL : iIntValue >= 47000 ? SystemTemperature.CRITICAL : iIntValue >= 45000 ? SystemTemperature.HIGH : iIntValue >= 43000 ? SystemTemperature.MODERATE : SystemTemperature.NORMAL;
        }
        AiDispatchersManager.INSTANCE.onTemperatureChanged(systemTemperature);
    }

    public final void debugInject(SystemTemperature systemTemperature) {
        if (kotlin.jvm.internal.g.b(Build.TYPE, "user")) {
            Log.w("AiThermalManager", "debugInject 在 user 生产版禁用（仅 userdebug/eng）");
            return;
        }
        f5641f = systemTemperature;
        Object obj = systemTemperature;
        if (systemTemperature == null) {
            obj = "清除(恢复真实读数)";
        }
        Log.w("AiThermalManager", "debugInject 温度档=" + obj);
        f5636a.execute(new a6.f(2));
    }

    public final synchronized void init(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (f5639d) {
            return;
        }
        f5639d = true;
        f5636a.execute(new e(0));
    }

    public final boolean isAvailable() {
        return f5640e;
    }

    public final synchronized void release() {
        if (f5639d) {
            f5636a.execute(new a6.f(1));
            f5639d = false;
        }
    }
}
