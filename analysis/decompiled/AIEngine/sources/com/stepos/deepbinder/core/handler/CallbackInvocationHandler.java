package com.stepos.deepbinder.core.handler;

import android.os.IBinder;
import android.os.SystemClock;
import androidx.appcompat.widget.z0;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import p9.a;
import p9.b;
import x9.c;
import x9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CallbackInvocationHandler extends BaseInvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final long f7628a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7629b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7630c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7631d;

    /* renamed from: e, reason: collision with root package name */
    public final a f7632e;

    public CallbackInvocationHandler(IBinder iBinder, long j10, int i10, int i11, String str) {
        a aVar;
        a aVarPutIfAbsent;
        this.f7628a = j10;
        this.f7629b = i10;
        this.f7630c = i11;
        this.f7631d = str;
        synchronized (o9.a.f10833a) {
            try {
                ConcurrentHashMap<IBinder, a> concurrentHashMap = o9.a.f10834b;
                a bVar = concurrentHashMap.get(iBinder);
                if (bVar == null && (aVarPutIfAbsent = concurrentHashMap.putIfAbsent(iBinder, (bVar = new b(iBinder)))) != null) {
                    bVar = aVarPutIfAbsent;
                }
                aVar = bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7632e = aVar;
    }

    @f.a
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
            if (hashCode() == obj.hashCode()) {
                long j10 = this.f7628a;
                g.d(invocationHandler, "null cannot be cast to non-null type com.stepos.deepbinder.core.handler.CallbackInvocationHandler");
                if (j10 == ((CallbackInvocationHandler) invocationHandler).f7628a) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    @f.a
    public int hashCode() {
        return this.f7629b;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public final Reply internalInvoke(Method method, Object[] args) {
        String name;
        Reply replyA;
        g.f(method, "method");
        g.f(args, "args");
        Class<?> returnType = method.getReturnType();
        g.e(returnType, "getReturnType(...)");
        boolean zB = g.b(Void.TYPE, returnType);
        ParameterWrapper[] parameterWrapperArrD = e.d(this.f7631d, method, args);
        MethodWrapper methodWrapperObtain = MethodWrapper.Companion.obtain();
        String name2 = method.getName();
        g.e(name2, "getName(...)");
        MethodWrapper methodWrapperWithVoid = methodWrapperObtain.withMethodName(name2).withVoid(zB);
        IPCException iPCException = null;
        if (zB) {
            name = null;
        } else {
            Class<?> returnType2 = method.getReturnType();
            g.e(returnType2, "getReturnType(...)");
            name = returnType2.getName();
        }
        if (name == null) {
            name = "";
        }
        methodWrapperWithVoid.withReturnType(name);
        Callback callback = Callback.CREATOR.obtain().withProtocolVersion(this.f7630c).withParameterWrappers(parameterWrapperArrD).withMethodWrapper(methodWrapperWithVoid).withTimeStamp(this.f7628a).withCallerProcessName(c.a()).withOneway(method.getAnnotation(Oneway.class) != null);
        a aVar = this.f7632e;
        aVar.getClass();
        g.f(callback, "callback");
        u9.a aVar2 = new u9.a(3);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long invokeTime = 0;
        try {
            replyA = aVar.a(callback);
            try {
                aVar2.f13187g = callback.getDataSize();
                invokeTime = replyA.getInvokeTime();
                IPCException ipcException = replyA.getIpcException();
                aVar2.f13184d = ipcException != null ? ipcException.getErrorCode() : 0;
            } catch (IPCException e10) {
                iPCException = e10;
            }
        } catch (IPCException e11) {
            iPCException = e11;
            replyA = null;
        }
        if (iPCException != null) {
            aVar2.f13184d = iPCException.getErrorCode();
        }
        aVar2.f13185e = (SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis) - invokeTime;
        w9.e.f13612e.b(new z0(aVar2, 21), false, true);
        if (iPCException == null) {
            return replyA == null ? Reply.CREATOR.obtain() : replyA;
        }
        throw iPCException;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public final void recycleOriginObjects() {
        long j10 = this.f7628a;
        try {
            IPCLog.INSTANCE.d("CallbackInvocationHandler", "[recycleOriginObjects] timeStamp=" + j10, new Object[0]);
            a aVar = this.f7632e;
            Long[] lArr = {Long.valueOf(j10)};
            aVar.getClass();
            u9.a aVar2 = new u9.a(5);
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            try {
                ((b) aVar).internalRecycle(lArr);
                aVar2.f13184d = 0;
                e = null;
            } catch (IPCException e10) {
                e = e10;
            }
            aVar2.f13185e = SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis;
            w9.e.f13612e.b(new z0(aVar2, 21), false, true);
            if (e == null) {
            } else {
                throw e;
            }
        } catch (IPCException e11) {
            IPCLog.INSTANCE.w("CallbackInvocationHandler", "[recycleOriginObjects][error]", e11);
        }
    }
}
