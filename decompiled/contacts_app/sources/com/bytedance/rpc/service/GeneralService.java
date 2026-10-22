package com.bytedance.rpc.service;

import com.bytedance.rpc.RpcInvokeContext;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcPath;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;

/* JADX INFO: loaded from: classes2.dex */
public class GeneralService {

    private interface GeneralApi {
        @RpcOperation("$POST {url}")
        @RpcSerializer(SerializeType.FORM)
        Object form(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$POST {url}")
        @RpcSerializer(SerializeType.FORM)
        void form(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);

        @RpcOperation("$GET {url}")
        Object get(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$GET {url}")
        void get(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);

        @RpcOperation("$POST {url}")
        Object post(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$POST {url}")
        void post(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);
    }

    public GeneralService() {
    }

    public static <T> T get(String r1, Object r2, Class<T> r3) {
        return (T) ((GeneralApi) RpcService.getProxy(GeneralApi.class)).get(r1, r2, r3);
    }

    public static <T> T post(String r1, Object r2, Class<T> r3) {
        return (T) ((GeneralApi) RpcService.getProxy(GeneralApi.class)).post(r1, r2, r3);
    }

    public static <T> T form(String r1, Object r2, Class<T> r3) {
        return (T) ((GeneralApi) RpcService.getProxy(GeneralApi.class)).form(r1, r2, r3);
    }

    public static <T> void get(String r1, Object r2, RpcCallback<T> r3) {
        ((GeneralApi) RpcService.getProxy(GeneralApi.class)).get(r1, r2, r3);
    }

    public static <T> void post(String r1, Object r2, RpcCallback<T> r3) {
        ((GeneralApi) RpcService.getProxy(GeneralApi.class)).post(r1, r2, r3);
    }

    public static <T> void form(String r1, Object r2, RpcCallback<T> r3) {
        ((GeneralApi) RpcService.getProxy(GeneralApi.class)).form(r1, r2, r3);
    }

    public static RpcInvokeContext getRpcInvokeContext() {
        return RpcService.getRpcInvokeContext(GeneralApi.class);
    }
}
