package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Throwables {
    private Throwables() {
    }

    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable r1, Class<X> r2) throws Throwable {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2.isInstance(r1) == true) goto L7;
        return;
    L7:
        throw r2.cast(r1);
    }

    public static void propagateIfPossible(@Nullable Throwable r1) {
        propagateIfInstanceOf(r1, Error.class);
        propagateIfInstanceOf(r1, RuntimeException.class);
    }

    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable r0, Class<X> r1) throws Throwable {
        propagateIfInstanceOf(r0, r1);
        propagateIfPossible(r0);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable r0, Class<X1> r1, Class<X2> r2) throws Throwable, Throwable {
        Preconditions.checkNotNull(r2);
        propagateIfInstanceOf(r0, r1);
        propagateIfPossible(r0, r2);
    }

    public static RuntimeException propagate(Throwable r1) {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(r1));
        throw new RuntimeException(r1);
    }

    public static Throwable getRootCause(Throwable r1) {
    L2:
        Throwable r0 = r1.getCause();
        if (r0 == null) goto L5;
        r1 = r0;
        goto L2
    L5:
        return r1;
    }

    public static List<Throwable> getCausalChain(Throwable r2) {
        Preconditions.checkNotNull(r2);
        ArrayList r0 = new ArrayList(4);
    L3:
        if (r2 == null) goto L6;
        r0.add(r2);
        r2 = r2.getCause();
        goto L3
    L6:
        return Collections.unmodifiableList(r0);
    }

    public static String getStackTraceAsString(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }
}
