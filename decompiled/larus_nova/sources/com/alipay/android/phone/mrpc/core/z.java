package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes28.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Object> f25078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f25079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f25080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicInteger f25081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f25082e;

    static {
        f25078a = new ThreadLocal();
        f25079b = new ThreadLocal();
    }

    public z(x r100) {
        this.f25080c = 0;
        this.f25082e = r100;
        this.f25081d = new AtomicInteger();
    }

    public final Object a(Method r110, Object[] r111) {
        if (Looper.myLooper() != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L32;
        OperationType r101 = (OperationType) r110.getAnnotation(OperationType.class);
        if (r110.getAnnotation(ResetCookie.class) == null) goto L12;
        boolean r112 = true;
    L13:
        Type r102 = r110.getGenericReturnType();
        r110.getAnnotations();
        ThreadLocal<Object> r103 = f25078a;
        r103.set(null);
        ThreadLocal<Map<String, Object>> r113 = f25079b;
        r113.set(null);
        if (r101 == null) goto L30;
        String r104 = r101.value();
        int r105 = this.f25081d.incrementAndGet();
    L26:
        e = move-exception;
        e.setOperationType(r104);
        throw e;
    L17:
        if (this.f25080c != 0) goto L25;
        com.alipay.android.phone.mrpc.core.a.e r106 = new com.alipay.android.phone.mrpc.core.a.e(r105, r104, r111);     // Catch: RpcException -> L26
        if (r113.get() == null) goto L21;
        r106.a(r113.get());     // Catch: RpcException -> L26
    L21:
        byte[] r107 = r106.a();     // Catch: RpcException -> L26
        byte[] r114 = (byte[]) new j(this.f25082e.a(), r110, r105, r104, r107, r112).a();     // Catch: RpcException -> L26
        r113.set(null);     // Catch: RpcException -> L26
        Object r115 = new com.alipay.android.phone.mrpc.core.a.d(r102, r114).a();     // Catch: RpcException -> L26
        if (r102 == Void.TYPE) goto L25;
        r103.set(r115);     // Catch: RpcException -> L26
    L25:
        return r103.get();
    L30:
        throw new IllegalStateException("OperationType must be set.");
    L12:
        r112 = false;
        goto L13
    L32:
        throw new IllegalThreadStateException("can't in main thread call rpc .");
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        r100 = true;
        goto L8
    }
}
