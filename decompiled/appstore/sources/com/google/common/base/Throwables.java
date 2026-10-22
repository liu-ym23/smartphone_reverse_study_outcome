package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Throwables {

    @GwtIncompatible
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";

    @VisibleForTesting
    @GwtIncompatible
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";

    @NullableDecl
    @GwtIncompatible
    private static final Method getStackTraceDepthMethod = null;

    @NullableDecl
    @GwtIncompatible
    private static final Method getStackTraceElementMethod = null;

    @NullableDecl
    @GwtIncompatible
    private static final Object jla = null;

    static {
        Object r10 = getJLA();
        jla = r10;
        Method r11 = null;
        if (r10 != null) goto L5;
        Method r12 = null;
    L6:
        getStackTraceElementMethod = r12;
        if (r10 == null) goto L10;
        r11 = getSizeMethod();
    L10:
        getStackTraceDepthMethod = r11;
        return;
    L5:
        r12 = getGetMethod();
        goto L6
    }

    private Throwables() {
    }

    public static /* synthetic */ Method access$000() {
        return getStackTraceElementMethod;
    }

    public static /* synthetic */ Object access$100() {
        return jla;
    }

    public static /* synthetic */ Object access$200(Method r10, Object r11, Object[] r12) {
        return invokeAccessibleNonThrowingMethod(r10, r11, r12);
    }

    public static /* synthetic */ Method access$300() {
        return getStackTraceDepthMethod;
    }

    @Beta
    public static List<Throwable> getCausalChain(Throwable r10) {
        Preconditions.checkNotNull(r10);
        ArrayList r11 = new ArrayList(4);
        r11.add(r10);
        boolean r12 = false;
        Throwable r13 = r10;
    L3:
        r10 = r10.getCause();
        if (r10 == null) goto L13;
        r11.add(r10);
        if (r10 == r13) goto L11;
        if (r12 == false) goto L9;
        r13 = r13.getCause();
    L9:
        r12 = !r12;
        goto L3
    L11:
        throw new IllegalArgumentException("Loop in causal chain detected.", r10);
    L13:
        return Collections.unmodifiableList(r11);
    }

    @Beta
    @GwtIncompatible
    public static <X extends Throwable> X getCauseAs(Throwable r10, Class<X> r11) {
        return r11.cast(r10.getCause());
    L4:
        e = move-exception;
        e.initCause(r10);
        throw e;
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getGetMethod() {
        return getJlaMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});
    }

    @NullableDecl
    @GwtIncompatible
    private static Object getJLA() {
        return Class.forName(SHARED_SECRETS_CLASSNAME, false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
    L5:
        e = move-exception;
        throw e;
    L7:
        return null;
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getJlaMethod(String r10, Class<?>... r11) throws ThreadDeath {
        return Class.forName(JAVA_LANG_ACCESS_CLASSNAME, false, null).getMethod(r10, r11);
    L5:
        e = move-exception;
        throw e;
    L7:
        return null;
    }

    public static Throwable getRootCause(Throwable r10) {
        boolean r11 = false;
        Throwable r12 = r10;
    L3:
        Throwable r13 = r10.getCause();
        if (r13 == null) goto L11;
        if (r13 == r12) goto L10;
        if (r11 == false) goto L8;
        r12 = r12.getCause();
    L8:
        r11 = !r11;
        r10 = r13;
        goto L3
    L10:
        throw new IllegalArgumentException("Loop in causal chain detected.", r13);
    L11:
        return r10;
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getSizeMethod() {
        Method r10 = getJlaMethod("getStackTraceDepth", new Class[]{Throwable.class});     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        r10.invoke(getJLA(), new Object[]{new Throwable()});     // Catch: Throwable -> L8
        return r10;
    L8:
        return null;
    }

    @GwtIncompatible
    public static String getStackTraceAsString(Throwable r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11));
        return r11.toString();
    }

    @GwtIncompatible
    private static Object invokeAccessibleNonThrowingMethod(Method r10, Object r11, Object... r12) {
        return r10.invoke(r11, r12);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw propagate(e.getCause());
    }

    @GwtIncompatible
    private static List<StackTraceElement> jlaStackTrace(final Throwable r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(r10);
    }

    @Beta
    @GwtIncompatible
    public static List<StackTraceElement> lazyStackTrace(Throwable r10) {
        if (lazyStackTraceIsLazy() == false) goto L6;
        return jlaStackTrace(r10);
    L6:
        return Collections.unmodifiableList(Arrays.asList(r10.getStackTrace()));
    }

    @Beta
    @GwtIncompatible
    public static boolean lazyStackTraceIsLazy() {
        if (getStackTraceElementMethod != null) goto L5;
    L7:
        return false;
    L5:
        if (getStackTraceDepthMethod == null) goto L7;
        return true;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException propagate(Throwable r10) {
        throwIfUnchecked(r10);
        throw new RuntimeException(r10);
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void propagateIfInstanceOf(@NullableDecl Throwable r10, Class<X> r11) throws Throwable {
        if (r10 == null) goto L5;
        throwIfInstanceOf(r10, r11);
        return;
    }

    @GwtIncompatible
    @Deprecated
    public static void propagateIfPossible(@NullableDecl Throwable r10) {
        if (r10 == null) goto L5;
        throwIfUnchecked(r10);
        return;
    }

    @GwtIncompatible
    public static <X extends Throwable> void throwIfInstanceOf(Throwable r10, Class<X> r11) throws Throwable {
        Preconditions.checkNotNull(r10);
        if (r11.isInstance(r10) == true) goto L6;
        return;
    L6:
        throw r11.cast(r10);
    }

    public static void throwIfUnchecked(Throwable r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof RuntimeException) == true) goto L10;
        if ((r10 instanceof Error) == true) goto L8;
        return;
    L8:
        throw ((Error) r10);
    L10:
        throw ((RuntimeException) r10);
    }

    @GwtIncompatible
    public static <X extends Throwable> void propagateIfPossible(@NullableDecl Throwable r10, Class<X> r11) throws Throwable {
        propagateIfInstanceOf(r10, r11);
        propagateIfPossible(r10);
    }

    @GwtIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@NullableDecl Throwable r10, Class<X1> r11, Class<X2> r12) throws Throwable, Throwable {
        Preconditions.checkNotNull(r12);
        propagateIfInstanceOf(r10, r11);
        propagateIfPossible(r10, r12);
    }
}
