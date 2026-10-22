package com.stepos.aicgroup.internal;

import com.stepos.aicgroup.internal.SvipBridge;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {
    @Override // zb.a
    public final Object invoke() {
        SvipBridge svipBridge = SvipBridge.INSTANCE;
        try {
            Class<?> cls = Class.forName("com.stepos.perfmain.client.PerfMainClient");
            Constructor<?> constructor = cls.getConstructor(null);
            g.e(constructor, "getConstructor(...)");
            Method method = cls.getMethod("connect", Integer.TYPE);
            g.e(method, "getMethod(...)");
            Method method2 = cls.getMethod("request", String.class, String.class, int[].class);
            g.e(method2, "getMethod(...)");
            Method method3 = cls.getMethod("disconnect", null);
            g.e(method3, "getMethod(...)");
            return new SvipBridge.Refl(constructor, method, method2, method3);
        } catch (Throwable th) {
            a0.a.w("PerfMainClient 不可用（非 StepOS 设备或缺类）: ", th.getClass().getSimpleName(), ": ", th.getMessage(), "SvipBridge");
            return null;
        }
    }
}
