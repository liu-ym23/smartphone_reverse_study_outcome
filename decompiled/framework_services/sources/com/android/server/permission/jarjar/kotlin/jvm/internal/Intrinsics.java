package com.android.server.permission.jarjar.kotlin.jvm.internal;

import com.android.server.permission.jarjar.kotlin.UninitializedPropertyAccessException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class Intrinsics {
    private Intrinsics() {
    }

    public static void checkNotNull(Object object) {
        if (object != null) goto L5;
        throwJavaNpe();
        return;
    }

    public static void checkNotNull(Object object, String message) {
        if (object != null) goto L5;
        throwJavaNpe(message);
        return;
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwJavaNpe(String message) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(message)));
    }

    public static void throwUninitializedProperty(String message) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(message)));
    }

    public static void throwUninitializedPropertyAccessException(String propertyName) {
        throwUninitializedProperty("lateinit property " + propertyName + " has not been initialized");
    }

    public static void checkNotNullExpressionValue(Object value, String expression) {
        if (value == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(expression + " must not be null")));
    }

    public static void checkNotNullParameter(Object value, String paramName) {
        if (value != null) goto L5;
        throwParameterIsNullNPE(paramName);
        return;
    }

    private static void throwParameterIsNullNPE(String paramName) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(paramName))));
    }

    private static String createParameterIsNullExceptionMessage(String paramName) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String thisClassName = Intrinsics.class.getName();
        int i = 0;
    L4:
        if (stackTraceElements[i].getClassName().equals(thisClassName) == true) goto L7;
        i = i + 1;
    L7:
        if (stackTraceElements[i].getClassName().equals(thisClassName) == false) goto L9;
        i = i + 1;
        goto L7
    L9:
        StackTraceElement caller = stackTraceElements[i];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + paramName;
    }

    public static boolean areEqual(Object first, Object second) {
        if (first != null) goto L7;
        if (second != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return first.equals(second);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r1) {
        return (T) sanitizeStackTrace(r1, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T throwable, String classNameToDrop) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int lastIntrinsic = -1;
        int i = 0;
    L3:
        if (i >= size) goto L8;
        if (classNameToDrop.equals(stackTrace[i].getClassName()) == false) goto L7;
        lastIntrinsic = i;
    L7:
        i = i + 1;
        goto L3
    L8:
        int i2 = lastIntrinsic + 1;
        StackTraceElement[] newStackTrace = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2, size);
        throwable.setStackTrace(newStackTrace);
        return throwable;
    }
}
