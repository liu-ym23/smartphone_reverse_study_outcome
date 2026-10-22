package com.stepos.policy.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class HookMacAddressUtils {
    private static WifiInfo cacheWifiInfo;
    public static final HookMacAddressUtils INSTANCE = new HookMacAddressUtils();
    private static boolean isHookMacAddress = true;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MacAddressInvocationHandler implements InvocationHandler {
        private final String methodName;
        private final Object real;

        public MacAddressInvocationHandler(String str, Object obj) {
            str.getClass();
            this.methodName = str;
            this.real = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.reflect.InvocationHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke(java.lang.Object r2, java.lang.reflect.Method r3, java.lang.Object[] r4) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.InstantiationException, java.lang.SecurityException, java.lang.IllegalArgumentException {
            /*
                r1 = this;
                r2.getClass()
                r3.getClass()
                r4.getClass()
                boolean r2 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$isHookMacAddress$p()
                if (r2 == 0) goto L4c
                java.lang.String r2 = r1.methodName
                java.lang.String r0 = r3.getName()
                boolean r2 = yb.k.a(r2, r0)
                if (r2 == 0) goto L4c
                android.net.wifi.WifiInfo r1 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$getCacheWifiInfo$p()
                if (r1 == 0) goto L22
                return r1
            L22:
                r1 = 0
                java.lang.Class<android.net.wifi.WifiInfo> r2 = android.net.wifi.WifiInfo.class
                java.lang.Object r3 = r2.newInstance()     // Catch: java.lang.Exception -> L43
                r3.getClass()     // Catch: java.lang.Exception -> L43
                android.net.wifi.WifiInfo r3 = (android.net.wifi.WifiInfo) r3     // Catch: java.lang.Exception -> L43
                java.lang.String r4 = "mMacAddress"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r4)     // Catch: java.lang.Exception -> L41
                r4 = 1
                r2.setAccessible(r4)     // Catch: java.lang.Exception -> L41
                java.lang.String r4 = ""
                r2.set(r3, r4)     // Catch: java.lang.Exception -> L41
                com.stepos.policy.sdk.util.HookMacAddressUtils.access$setCacheWifiInfo$p(r3)     // Catch: java.lang.Exception -> L41
                goto L48
            L41:
                r2 = move-exception
                goto L45
            L43:
                r2 = move-exception
                r3 = r1
            L45:
                r2.printStackTrace()
            L48:
                if (r3 == 0) goto L4b
                r1 = r3
            L4b:
                return r1
            L4c:
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
        context.getClass();
        try {
            isHookMacAddress = true;
            Class<?> cls = Class.forName("android.net.wifi.IWifiManager");
            Field declaredField = WifiManager.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object systemService = context.getSystemService("wifi");
            systemService.getClass();
            WifiManager wifiManager = (WifiManager) systemService;
            declaredField.set(wifiManager, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new MacAddressInvocationHandler("getConnectionInfo", declaredField.get(wifiManager))));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
