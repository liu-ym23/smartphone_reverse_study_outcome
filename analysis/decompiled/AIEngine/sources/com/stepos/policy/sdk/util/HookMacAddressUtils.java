package com.stepos.policy.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HookMacAddressUtils {
    private static WifiInfo cacheWifiInfo;
    public static final HookMacAddressUtils INSTANCE = new HookMacAddressUtils();
    private static boolean isHookMacAddress = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MacAddressInvocationHandler implements InvocationHandler {
        private final String methodName;
        private final Object real;

        public MacAddressInvocationHandler(String methodName, Object obj) {
            kotlin.jvm.internal.g.f(methodName, "methodName");
            this.methodName = methodName;
            this.real = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.reflect.InvocationHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke(java.lang.Object r2, java.lang.reflect.Method r3, java.lang.Object[] r4) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.InstantiationException, java.lang.SecurityException, java.lang.IllegalArgumentException {
            /*
                r1 = this;
                java.lang.String r0 = "proxy"
                kotlin.jvm.internal.g.f(r2, r0)
                java.lang.String r2 = "method"
                kotlin.jvm.internal.g.f(r3, r2)
                java.lang.String r2 = "args"
                kotlin.jvm.internal.g.f(r4, r2)
                boolean r2 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$isHookMacAddress$p()
                if (r2 == 0) goto L54
                java.lang.String r2 = r1.methodName
                java.lang.String r0 = r3.getName()
                boolean r2 = kotlin.jvm.internal.g.b(r2, r0)
                if (r2 == 0) goto L54
                android.net.wifi.WifiInfo r1 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$getCacheWifiInfo$p()
                if (r1 == 0) goto L28
                return r1
            L28:
                r1 = 0
                java.lang.Class<android.net.wifi.WifiInfo> r2 = android.net.wifi.WifiInfo.class
                java.lang.Object r3 = r2.newInstance()     // Catch: java.lang.Exception -> L4b
                java.lang.String r4 = "null cannot be cast to non-null type android.net.wifi.WifiInfo"
                kotlin.jvm.internal.g.d(r3, r4)     // Catch: java.lang.Exception -> L4b
                android.net.wifi.WifiInfo r3 = (android.net.wifi.WifiInfo) r3     // Catch: java.lang.Exception -> L4b
                java.lang.String r4 = "mMacAddress"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r4)     // Catch: java.lang.Exception -> L49
                r4 = 1
                r2.setAccessible(r4)     // Catch: java.lang.Exception -> L49
                java.lang.String r4 = ""
                r2.set(r3, r4)     // Catch: java.lang.Exception -> L49
                com.stepos.policy.sdk.util.HookMacAddressUtils.access$setCacheWifiInfo$p(r3)     // Catch: java.lang.Exception -> L49
                goto L50
            L49:
                r2 = move-exception
                goto L4d
            L4b:
                r2 = move-exception
                r3 = r1
            L4d:
                r2.printStackTrace()
            L50:
                if (r3 == 0) goto L53
                r1 = r3
            L53:
                return r1
            L54:
                java.lang.Object r1 = r1.real
                int r2 = r4.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r2)
                java.lang.Object r1 = r3.invoke(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.util.HookMacAddressUtils.MacAddressInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    private HookMacAddressUtils() {
    }

    public final void closeHookMacAddress() {
        isHookMacAddress = false;
    }

    @SuppressLint({"PrivateApi", "WifiManagerPotentialLeak"})
    public final void hookMacAddress(Context context) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        kotlin.jvm.internal.g.f(context, "context");
        try {
            isHookMacAddress = true;
            Class<?> cls = Class.forName("android.net.wifi.IWifiManager");
            Field declaredField = WifiManager.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object systemService = context.getSystemService("wifi");
            kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            declaredField.set(wifiManager, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new MacAddressInvocationHandler("getConnectionInfo", declaredField.get(wifiManager))));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
