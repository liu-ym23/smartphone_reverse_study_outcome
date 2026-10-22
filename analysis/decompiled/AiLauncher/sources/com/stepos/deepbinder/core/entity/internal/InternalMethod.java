package com.stepos.deepbinder.core.entity.internal;

import Z8.r;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001f\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010 J/\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\u0006\u0010\"\u001a\u00020#2\u0010\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001fH\u0002¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010'\u001a\u00020(H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", "", "<init>", "()V", "method", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "methodHandle", "Ljava/lang/invoke/MethodHandle;", "getMethodHandle", "()Ljava/lang/invoke/MethodHandle;", "setMethodHandle", "(Ljava/lang/invoke/MethodHandle;)V", "methodType", "Ljava/lang/invoke/MethodType;", "getMethodType", "()Ljava/lang/invoke/MethodType;", "setMethodType", "(Ljava/lang/invoke/MethodType;)V", "parameterMapping", "", "getParameterMapping", "()[I", "setParameterMapping", "([I)V", "invoke", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "mapArguments", "methodParamCount", "", "callArgs", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "withMethod", "toString", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InternalMethod {
    private Method method;
    private MethodHandle methodHandle;
    private MethodType methodType;
    private int[] parameterMapping = new int[0];

    private final Object[] mapArguments(int methodParamCount, Object[] callArgs) {
        int i10 = 0;
        if (this.parameterMapping.length != 0) {
            Object[] objArr = new Object[methodParamCount];
            while (i10 < methodParamCount) {
                int i11 = this.parameterMapping[i10];
                objArr[i10] = (i11 < 0 || i11 >= callArgs.length) ? null : callArgs[i11];
                i10++;
            }
            return objArr;
        }
        if (callArgs.length < methodParamCount) {
            Object[] objArr2 = new Object[methodParamCount];
            while (i10 < methodParamCount) {
                objArr2[i10] = i10 < callArgs.length ? callArgs[i10] : null;
                i10++;
            }
            return objArr2;
        }
        int length = callArgs.length;
        Object[] objArr3 = new Object[length];
        while (i10 < length) {
            objArr3[i10] = callArgs[i10];
            i10++;
        }
        return objArr3;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final MethodHandle getMethodHandle() {
        return this.methodHandle;
    }

    public final MethodType getMethodType() {
        return this.methodType;
    }

    public final int[] getParameterMapping() {
        return this.parameterMapping;
    }

    public final Object invoke(Object instance, Object... args) {
        p.i(args, "args");
        Method method = this.method;
        if (method == null) {
            throw new IllegalStateException("Method is not set");
        }
        Object[] objArrMapArguments = mapArguments(method.getParameterCount(), args);
        MethodHandle methodHandleBindTo = this.methodHandle;
        if (methodHandleBindTo == null) {
            return method.invoke(instance, Arrays.copyOf(objArrMapArguments, objArrMapArguments.length));
        }
        if (instance != null) {
            p.f(methodHandleBindTo);
            methodHandleBindTo = methodHandleBindTo.bindTo(instance);
        } else {
            p.f(methodHandleBindTo);
        }
        return methodHandleBindTo.invokeWithArguments(r.T0(objArrMapArguments));
    }

    public final void setMethod(Method method) {
        this.method = method;
    }

    public final void setMethodHandle(MethodHandle methodHandle) {
        this.methodHandle = methodHandle;
    }

    public final void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    public final void setParameterMapping(int[] iArr) {
        p.i(iArr, "<set-?>");
        this.parameterMapping = iArr;
    }

    public String toString() {
        Method method = this.method;
        MethodHandle methodHandle = this.methodHandle;
        MethodType methodType = this.methodType;
        String string = Arrays.toString(this.parameterMapping);
        p.h(string, "toString(...)");
        return "InternalMethod{method=" + method + ", methodHandle=" + methodHandle + ", methodType=" + methodType + ", parameterMapping=" + string + "}";
    }

    public final InternalMethod withMethod(Method method) {
        p.i(method, "method");
        this.method = method;
        return this;
    }
}
