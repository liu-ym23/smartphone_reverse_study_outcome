package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.annotation.RpcBizParam;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.log.LogInterceptor;
import com.bytedance.rpc.log.LogLevel;
import com.bytedance.rpc.log.Loggable;
import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.SerializeFactory;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.transport.TransportClientFactory;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcService {
    private static volatile RpcContext sContext;
    private static Map<Class<?>, RpcInvokeContext> sRpcInvokeContext;
    private static volatile RpcInvoker sRpcInvoker;

    public RpcService() {
    }

    static {
        sRpcInvokeContext = new HashMap(4);
    }

    public static void init(Application r3, RpcConfig r4) {
        if (r3 == null) goto L21;
        if (r4 == null) goto L21;
        if (Logger.isLoggableD() == false) goto L8;
        Logger.d(String.format("rpc: init config=%s", new Object[]{r4}));
    L8:
        if (sContext == null) goto L10;
        return;
    L10:
        monitor-enter(RpcService.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (sContext != null) goto L14;
        sContext = new RpcContext(r3, r4);     // Catch: Throwable -> L16
        sRpcInvoker = new RpcInvoker(sContext);     // Catch: Throwable -> L16
    L14:
        monitor-exit(RpcService.class);     // Catch: Throwable -> L16
        return;
    L21:
        throw new RuntimeException("parameters of RpcService.init should not be null ");
    }

    public static boolean isInitialized() {
        if (sContext == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void registerBizModel(Object r2) {
        if (r2 == null) goto L10;
        throwIfNotInitialized();
        RpcBizParam r0 = (RpcBizParam) r2.getClass().getAnnotation(RpcBizParam.class);
        if (r0 == null) goto L6;
        sContext.registerBizModel(r0.value(), r2);
        return;
    L6:
        if (Logger.isLoggableD() == false) goto L11;
        Logger.d(String.format("rpc: registerBizCommonModel with wrong argument=%s,it should have annotation RpcBizParam", new Object[]{r2}));
        return;
    L11:
        return;
    }

    public static synchronized <T> T getProxy(Class<T> r6) {
        monitor-enter(RpcService.class);
        throwIfNotInitialized();     // Catch: Throwable -> L7
        T r7 = (T) Proxy.newProxyInstance(r6.getClassLoader(), new Class[]{r6}, new RpcInvocationHandler(r6, sRpcInvoker, getRpcInvokeContext(r6)));
        monitor-exit(RpcService.class);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public static RpcContext getRpcContext() {
        throwIfNotInitialized();
        return sContext;
    }

    public static RpcConfig getRpcConfig() {
        throwIfNotInitialized();
        return sContext.getRpcConfig();
    }

    public static boolean updateRpcConfig(RpcConfig r2) {
        if (r2 == null) goto L6;
        throwIfNotInitialized();
        if (r2.computeChangedFlag(getRpcConfig(), true) == 0) goto L6;
        updateContextConfig(r2);
        return true;
    L6:
        return false;
    }

    public static RpcInvokeContext getRpcInvokeContext(Object r3) {
        if ((r3 instanceof Class) == false) goto L15;
        Map<Class<?>, RpcInvokeContext> r0 = sRpcInvokeContext;
        monitor-enter(r0);
        RpcInvokeContext r1 = sRpcInvokeContext.get(r3);     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        throwIfNotInitialized();     // Catch: Throwable -> L11
        r1 = createRPContext();     // Catch: Throwable -> L11
        sRpcInvokeContext.put((Class) r3, r1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L15:
        if (Proxy.isProxyClass(r3.getClass()) == false) goto L19;
        return ((RpcInvocationHandler) Proxy.getInvocationHandler(r3)).getRpcInvokeContext();
    L19:
        throw new IllegalArgumentException(r3.getClass().getName() + " class is not a proxy class ");
    }

    public static void addRpcInterceptor(RpcInterceptor r3, Class<?>... r4) {
        if (r3 == null) goto L18;
        if (r4 != null) goto L5;
    L13:
        sContext.addRpcInterceptor(r3);
        return;
    L5:
        if (r4.length == 0) goto L13;
        int r0 = r4.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L19;
        Class<?> r2 = r4[r1];
        if (r2 == null) goto L12;
        getRpcInvokeContext(r2).addRpcInterceptor(r3);
    L12:
        r1 = r1 + 1;
        goto L8
    L19:
        return;
    }

    public static void removeRpcInterceptor(RpcInterceptor r3, Class<?>... r4) {
        if (r3 == null) goto L19;
        throwIfNotInitialized();
        if (r4 != null) goto L6;
    L14:
        sContext.removeRpcInterceptor(r3);
        return;
    L6:
        if (r4.length == 0) goto L14;
        int r0 = r4.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L20;
        Class<?> r2 = r4[r1];
        if (r2 == null) goto L13;
        getRpcInvokeContext(r2).removeRpcInterceptor(r3);
    L13:
        r1 = r1 + 1;
        goto L9
    L20:
        return;
    }

    public static void addTransportRequestInterceptor(TransportRequestInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.addTransportRequestInterceptor(r1);
        return;
    }

    public static void removeTransportRequestInterceptor(TransportRequestInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.removeTransportRequestInterceptor(r1);
        return;
    }

    public static void addTransportResultInterceptor(TransportResultInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.addTransportResultInterceptor(r1);
        return;
    }

    public static void addRpcInvokeInterceptor(RpcInvokeInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.addRpcInvokeInterceptor(r1);
        return;
    }

    public static void removeRpcInvokeInterceptor(RpcInvokeInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.removeRpcInvokeInterceptor(r1);
        return;
    }

    public static void removeTransportResultInterceptor(TransportResultInterceptor r1) {
        if (r1 == null) goto L5;
        sContext.removeTransportResultInterceptor(r1);
        return;
    }

    public static void setTransportFactory(TransportClientFactory r1) {
        throwIfNotInitialized();
        sRpcInvoker.setTransportFactory(r1);
    }

    public static SerializeManager getSerializeManager() {
        throwIfNotInitialized();
        return sRpcInvoker.getSerializeManager();
    }

    public static void registerSerializeFactory(SerializeFactory r1) {
        throwIfNotInitialized();
        sRpcInvoker.registerSerializeFactory(r1);
    }

    public static void removeSerializeFactory(SerializeType r1) {
        if (sRpcInvoker == null) goto L6;
        sRpcInvoker.removeSerializeFactory(r1);
        return;
    }

    public static RpcConfig.Builder createRpcConfigBuilder() {
        if (sContext != null) goto L7;
        return new RpcConfig.Builder();
    L7:
        return sContext.getRpcConfig().toBuilder();
    }

    public static int getLatestRequestId() {
        return sRpcInvoker.getLatestRequestId();
    }

    public static void cancelRequest(int r1) {
        sRpcInvoker.cancelRequest(r1);
    }

    public static RequestModifier getRpcRequestModify() {
        return sRpcInvoker.getRequestModifier();
    }

    public static void setLogLevel(LogLevel r0) {
        Logger.setLogLevel(r0);
    }

    public static void setLogTag(String r0) {
        Logger.setLogTag(r0);
    }

    public static void setLogDelegate(Loggable r0) {
        Logger.setLogDelegate(r0);
    }

    public static void setLogInterceptor(LogInterceptor r0) {
        Logger.setLogIntercept(r0);
    }

    private static void updateContextConfig(RpcConfig r3) {
        sContext.updateRpcConfig(r3);
        if (r3.changed(9) == true) goto L5;
        return;
    L5:
        if (sRpcInvokeContext.isEmpty() == false) goto L7;
        return;
    L7:
        monitor-enter(RpcService.class);
        Iterator<Map.Entry<Class<?>, RpcInvokeContext>> r1 = sRpcInvokeContext.entrySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().getValue().updateConfig(r3);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(RpcService.class);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static RpcInvokeContext createRPContext() {
        return new RpcInvokeContext(sContext);
    }

    private static void throwIfNotInitialized() {
        if (sContext == null) goto L6;
        return;
    L6:
        throw new RuntimeException("had you called RpcService.init(Application,RpcConfig)");
    }
}
