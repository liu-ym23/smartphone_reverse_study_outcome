package com.bytedance.rpc.callback;

import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.RpcRequestModifier;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcInterceptor {
    void exceptionHandle(Class r1, Method r2, RpcException r3, String r4);

    boolean postHandle(Class r1, Method r2, Object r3, ThreadLocal r4, Map<String, String> r5, String r6) throws Exception;

    boolean preHandle(Class r1, Method r2, Object[] r3, RpcRequestModifier r4, String r5) throws Exception;
}
