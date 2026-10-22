package com.stepos.policy.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/policy/sdk/util/HookMacAddressUtils;", "", "()V", "cacheWifiInfo", "Landroid/net/wifi/WifiInfo;", "isHookMacAddress", "", "closeHookMacAddress", "", "hookMacAddress", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "MacAddressInvocationHandler", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HookMacAddressUtils {

    @Nullable
    private static WifiInfo cacheWifiInfo;

    @NotNull
    public static final HookMacAddressUtils INSTANCE = new HookMacAddressUtils();
    private static boolean isHookMacAddress = true;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0096\u0002¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/policy/sdk/util/HookMacAddressUtils$MacAddressInvocationHandler;", "Ljava/lang/reflect/InvocationHandler;", "methodName", "", "real", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nHookMacAddressUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HookMacAddressUtils.kt\ncom/stepos/policy/sdk/util/HookMacAddressUtils$MacAddressInvocationHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
    public static final class MacAddressInvocationHandler implements InvocationHandler {

        @NotNull
        private final String methodName;

        @Nullable
        private final Object real;

        public MacAddressInvocationHandler(@NotNull String methodName, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            this.methodName = methodName;
            this.real = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.reflect.InvocationHandler
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.Object r2, @org.jetbrains.annotations.NotNull java.lang.reflect.Method r3, @org.jetbrains.annotations.NotNull java.lang.Object[] r4) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.InstantiationException, java.lang.SecurityException, java.lang.IllegalArgumentException {
            /*
                r1 = this;
                java.lang.String r0 = "proxy"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r2 = "method"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "args"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
                boolean r2 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$isHookMacAddress$p()
                if (r2 == 0) goto L54
                java.lang.String r2 = r1.methodName
                java.lang.String r0 = r3.getName()
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
                if (r2 == 0) goto L54
                android.net.wifi.WifiInfo r1 = com.stepos.policy.sdk.util.HookMacAddressUtils.access$getCacheWifiInfo$p()
                if (r1 == 0) goto L28
                return r1
            L28:
                r1 = 0
                java.lang.Class<android.net.wifi.WifiInfo> r2 = android.net.wifi.WifiInfo.class
                java.lang.Object r3 = r2.newInstance()     // Catch: java.lang.Exception -> L4b
                java.lang.String r4 = "null cannot be cast to non-null type android.net.wifi.WifiInfo"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)     // Catch: java.lang.Exception -> L4b
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
                if (r3 == 0) goto L5f
                r1 = r3
                goto L5f
            L54:
                java.lang.Object r1 = r1.real
                int r2 = r4.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r2)
                java.lang.Object r1 = r3.invoke(r1, r2)
            L5f:
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
    public final void hookMacAddress(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            isHookMacAddress = true;
            Class<?> cls = Class.forName("android.net.wifi.IWifiManager");
            Field declaredField = WifiManager.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object systemService = context.getSystemService(AppSuggestStorable.COLUMN_WIFI);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            declaredField.set(wifiManager, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new MacAddressInvocationHandler("getConnectionInfo", declaredField.get(wifiManager))));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
