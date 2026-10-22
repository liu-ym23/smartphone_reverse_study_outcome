package com.obric.capabilitykit.corecommon;

import android.os.IInterface;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class BinderExceptionHandlerProxy<T extends IInterface> implements InvocationHandler {
    public static final Companion Companion = null;
    private final String tag;
    private final T target;
    private final Class<T> targetClass;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public final /* synthetic */ <T extends IInterface> T createProxyInstance(T r8, String r9) {
            T r10 = (T) ZeusTransformUtils.wrapperContextForParams(r8, IInterface.class, "com.obric.aiagent.plugin");
            o.e(r10, "api");
            o.e(r9, "tag");
            o.a(4, "T");     // Catch: Throwable -> L5
            ClassLoader r2 = IInterface.class.getClassLoader();     // Catch: Throwable -> L5
            o.a(4, "T");     // Catch: Throwable -> L5
            o.a(4, "T");     // Catch: Throwable -> L5
            Object r0 = Proxy.newProxyInstance(r2, new Class[]{IInterface.class}, new BinderExceptionHandlerProxy(r10, r9, IInterface.class));     // Catch: Throwable -> L5
            o.a(1, "T");     // Catch: Throwable -> L5
            return (T) ZeusTransformUtils.preCheckCast(r0, IInterface.class, "com.obric.aiagent.plugin");
        L5:
            th = move-exception;
            Throwable r7 = n.c(n.f(d.o.a(th)));
            if (r7 == null) goto L9;
            INVOKESTATIC_com_obric_capabilitykit_corecommon_BinderExceptionHandlerProxy$Companion_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r9, "BinderExceptionHandlerProxy createProxyInstance for " + r10.getClass() + " fail", r7);
        L9:
            return r10;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_capabilitykit_corecommon_BinderExceptionHandlerProxy$Companion_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinderExceptionHandlerProxy(T r3, String r4, Class<T> r5) {
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.aiagent.plugin");
        o.e(r6, "target");
        o.e(r4, "tag");
        o.e(r5, "targetClass");
        this.target = r6;
        this.tag = r4;
        this.targetClass = r5;
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private final Object getDefaultReturnValue(Method r2) {
        Class<?> r1 = r2.getReturnType();
        if (o.a(r1, Boolean.TYPE) == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (o.a(r1, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (o.a(r1, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (o.a(r1, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (o.a(r1, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (o.a(r1, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (o.a(r1, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (o.a(r1, Double.TYPE) == false) goto L27;
        return Double.valueOf(0.0d);
    L27:
        if (o.a(r1, Void.class) == true) goto L39;
        return null;
    L39:
        return x.f38692a;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) {
        o.e(r3, "proxy");
        o.e(r4, "method");
    L17:
        th = move-exception;
        INVOKESTATIC_com_obric_capabilitykit_corecommon_BinderExceptionHandlerProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.tag, "BinderExceptionHandlerProxy " + r4.getName() + " throw exception: " + a.a(th));
        return getDefaultReturnValue(r4);
    L4:
        if (o.a(r4.getDeclaringClass(), this.targetClass) == true) goto L10;
        T r6 = this.target;     // Catch: Throwable -> L17
        if (r5 != null) goto L21;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L21:
        return r4.invoke(r6, Arrays.copyOf(r5, r5.length));
    L10:
        if (this.target.asBinder().isBinderAlive() == false) goto L15;
        T r7 = this.target;     // Catch: Throwable -> L17
        if (r5 != null) goto L22;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L22:
        return r4.invoke(r7, Arrays.copyOf(r5, r5.length));
    L15:
        INVOKESTATIC_com_obric_capabilitykit_corecommon_BinderExceptionHandlerProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.tag, "BinderExceptionHandlerProxy " + r4.getName() + " fail. Binder is already died.");     // Catch: Throwable -> L17
        return getDefaultReturnValue(r4);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_corecommon_BinderExceptionHandlerProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
