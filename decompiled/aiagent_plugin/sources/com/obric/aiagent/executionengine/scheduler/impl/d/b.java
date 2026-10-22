package com.obric.aiagent.executionengine.scheduler.impl.d;

import android.os.DeadObjectException;
import android.os.IInterface;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: DeadDetectableBinderProxy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T extends IInterface> implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f18389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<T> f18391d;

    /* JADX INFO: compiled from: DeadDetectableBinderProxy.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18388a = new a(null);
    }

    public b(T r3, String r4, Class<T> r5) {
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.aiagent.plugin");
        o.e(r6, "target");
        o.e(r4, "tag");
        o.e(r5, "targetClass");
        this.f18389b = r6;
        this.f18390c = r4;
        this.f18391d = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r4, Method r5, Object[] r6) {
        o.e(r4, "proxy");
        o.e(r5, "method");
    L19:
        e = move-exception;
        Throwable r7 = e.getCause();
        if (r7 != null) goto L24;
        r7 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
    L24:
        if (ZeusTransformUtils.instanceOf(r7, DeadObjectException.class) == true) goto L27;
        ILogDepend.Companion.e(this.f18390c, "DeadDetectableBinderProxy " + r5.getName() + " throw exception (InvocationTargetException): " + d.a.a(r7));
        return a(r5);
    L27:
        ILogDepend.Companion.w(this.f18390c, "DeadDetectableBinderProxy " + r5.getName() + " [dead/frozen] throw exception: " + d.a.a(r7));
        throw r7;
    L17:
        th = move-exception;
        ILogDepend.Companion.e(this.f18390c, "DeadDetectableBinderProxy " + r5.getName() + " throw exception: " + d.a.a(th));
        return a(r5);
    L4:
        if (o.a(r5.getDeclaringClass(), this.f18391d) == true) goto L10;
        T r8 = this.f18389b;     // Catch: Throwable -> L17 InvocationTargetException -> L19
        if (r6 != null) goto L30;
        r6 = new Object[0];     // Catch: Throwable -> L17 InvocationTargetException -> L19
    L30:
        return r5.invoke(r8, Arrays.copyOf(r6, r6.length));
    L10:
        if (this.f18389b.asBinder().isBinderAlive() == false) goto L15;
        T r9 = this.f18389b;     // Catch: Throwable -> L17 InvocationTargetException -> L19
        if (r6 != null) goto L31;
        r6 = new Object[0];     // Catch: Throwable -> L17 InvocationTargetException -> L19
    L31:
        return r5.invoke(r9, Arrays.copyOf(r6, r6.length));
    L15:
        ILogDepend.Companion.e(this.f18390c, "DeadDetectableBinderProxy " + r5.getName() + " fail. Binder is already died.");     // Catch: Throwable -> L17 InvocationTargetException -> L19
        return a(r5);
    }

    private final Object a(Method r2) {
        Class<?> r1 = r2.getReturnType();
        if (o.a(r1, Boolean.TYPE) == false) goto L6;
        return false;
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
}
