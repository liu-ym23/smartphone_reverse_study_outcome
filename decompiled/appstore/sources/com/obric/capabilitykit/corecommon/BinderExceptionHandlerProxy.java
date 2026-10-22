package com.obric.capabilitykit.corecommon;

import android.os.IInterface;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.a;
import kotlin.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy;", "T", "Landroid/os/IInterface;", "Ljava/lang/reflect/InvocationHandler;", "target", "tag", "", "targetClass", "Ljava/lang/Class;", "(Landroid/os/IInterface;Ljava/lang/String;Ljava/lang/Class;)V", "Landroid/os/IInterface;", "getDefaultReturnValue", "", "method", "Ljava/lang/reflect/Method;", "invoke", "proxy", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinderExceptionHandlerProxy<T extends IInterface> implements InvocationHandler {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private final String tag;

    @NotNull
    private final T target;

    @NotNull
    private final Class<T> targetClass;

    @Keep
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy$Companion;", "", "()V", "createProxyInstance", "T", "Landroid/os/IInterface;", "api", "tag", "", "(Landroid/os/IInterface;Ljava/lang/String;)Landroid/os/IInterface;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final /* synthetic */ <T extends IInterface> T createProxyInstance(T r10, String r11) {
            q.g(r10, "api");
            q.g(r11, "tag");
            q.m(4, "T");     // Catch: Throwable -> L5
            ClassLoader r12 = IInterface.class.getClassLoader();     // Catch: Throwable -> L5
            q.m(4, "T");     // Catch: Throwable -> L5
            q.m(4, "T");     // Catch: Throwable -> L5
            Object r13 = Proxy.newProxyInstance(r12, new Class[]{IInterface.class}, new BinderExceptionHandlerProxy(r10, r11, IInterface.class));     // Catch: Throwable -> L5
            q.m(1, "T");     // Catch: Throwable -> L5
            return (T) r13;
        L5:
            th = move-exception;
            Throwable r14 = Result.m38exceptionOrNullimpl(Result.m35constructorimpl(c.a(th)));
            if (r14 == null) goto L9;
            Log.e(r11, "BinderExceptionHandlerProxy createProxyInstance for " + r10.getClass() + " fail", r14);
        L9:
            return r10;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinderExceptionHandlerProxy(@NotNull T r10, @NotNull String r11, @NotNull Class<T> r12) {
        q.g(r10, "target");
        q.g(r11, "tag");
        q.g(r12, "targetClass");
        this.target = r10;
        this.tag = r11;
        this.targetClass = r12;
    }

    private final Object getDefaultReturnValue(Method r10) {
        Class<?> r11 = r10.getReturnType();
        if (q.b(r11, Boolean.TYPE) == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (q.b(r11, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (q.b(r11, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (q.b(r11, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (q.b(r11, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (q.b(r11, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (q.b(r11, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (q.b(r11, Double.TYPE) == false) goto L27;
        return Double.valueOf(0.0d);
    L27:
        if (q.b(r11, Void.class) == true) goto L39;
        return null;
    L39:
        return Unit.f21064a;
    }

    @Override // java.lang.reflect.InvocationHandler
    @Nullable
    public Object invoke(@NotNull Object r10, @NotNull Method r11, @Nullable Object[] r12) {
        q.g(r10, "proxy");
        q.g(r11, "method");
    L8:
        th = move-exception;
        Log.e(this.tag, "BinderExceptionHandlerProxy " + r11.getName() + " throw exception: " + a.b(th));
        return getDefaultReturnValue(r11);
    L4:
        if (q.b(r11.getDeclaringClass(), this.targetClass) == true) goto L12;
        T r13 = this.target;     // Catch: Throwable -> L8
        if (r12 != null) goto L22;
        r12 = new Object[0];     // Catch: Throwable -> L8
    L22:
        return r11.invoke(r13, Arrays.copyOf(r12, r12.length));
    L12:
        if (this.target.asBinder().isBinderAlive() == false) goto L17;
        T r14 = this.target;     // Catch: Throwable -> L8
        if (r12 != null) goto L23;
        r12 = new Object[0];     // Catch: Throwable -> L8
    L23:
        return r11.invoke(r14, Arrays.copyOf(r12, r12.length));
    L17:
        Log.e(this.tag, "BinderExceptionHandlerProxy " + r11.getName() + " fail. Binder is already died.");     // Catch: Throwable -> L8
        return getDefaultReturnValue(r11);
    }
}
