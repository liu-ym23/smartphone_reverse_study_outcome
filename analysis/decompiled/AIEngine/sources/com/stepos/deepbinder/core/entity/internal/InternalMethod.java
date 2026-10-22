package com.stepos.deepbinder.core.entity.internal;

import ai.onnxruntime.a;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InternalMethod {
    private Method method;
    private MethodHandle methodHandle;
    private MethodType methodType;
    private int[] parameterMapping = new int[0];

    private final Object[] mapArguments(int i10, Object[] objArr) {
        int i11 = 0;
        if (this.parameterMapping.length != 0) {
            Object[] objArr2 = new Object[i10];
            while (i11 < i10) {
                int i12 = this.parameterMapping[i11];
                objArr2[i11] = (i12 < 0 || i12 >= objArr.length) ? null : objArr[i12];
                i11++;
            }
            return objArr2;
        }
        if (objArr.length < i10) {
            Object[] objArr3 = new Object[i10];
            while (i11 < i10) {
                objArr3[i11] = i11 < objArr.length ? objArr[i11] : null;
                i11++;
            }
            return objArr3;
        }
        int length = objArr.length;
        Object[] objArr4 = new Object[length];
        while (i11 < length) {
            objArr4[i11] = objArr[i11];
            i11++;
        }
        return objArr4;
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

    public final Object invoke(Object obj, Object... args) {
        g.f(args, "args");
        Method method = this.method;
        if (method == null) {
            throw new IllegalStateException("Method is not set");
        }
        Object[] objArrMapArguments = mapArguments(method.getParameterCount(), args);
        MethodHandle methodHandleBindTo = this.methodHandle;
        if (methodHandleBindTo == null) {
            return method.invoke(obj, Arrays.copyOf(objArrMapArguments, objArrMapArguments.length));
        }
        if (obj != null) {
            g.c(methodHandleBindTo);
            methodHandleBindTo = methodHandleBindTo.bindTo(obj);
        } else {
            g.c(methodHandleBindTo);
        }
        return methodHandleBindTo.invokeWithArguments(l.q0(objArrMapArguments));
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
        g.f(iArr, "<set-?>");
        this.parameterMapping = iArr;
    }

    public String toString() {
        Method method = this.method;
        MethodHandle methodHandle = this.methodHandle;
        MethodType methodType = this.methodType;
        String string = Arrays.toString(this.parameterMapping);
        g.e(string, "toString(...)");
        StringBuilder sb2 = new StringBuilder("InternalMethod{method=");
        sb2.append(method);
        sb2.append(", methodHandle=");
        sb2.append(methodHandle);
        sb2.append(", methodType=");
        sb2.append(methodType);
        sb2.append(", parameterMapping=");
        return a.o(sb2, string, "}");
    }

    public final InternalMethod withMethod(Method method) {
        g.f(method, "method");
        this.method = method;
        return this;
    }
}
