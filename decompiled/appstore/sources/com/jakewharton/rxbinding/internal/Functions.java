package com.jakewharton.rxbinding.internal;

import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public final class Functions {
    private static final Always<Boolean> ALWAYS_TRUE = null;
    public static final Func0<Boolean> FUNC0_ALWAYS_TRUE = null;
    public static final Func1<Object, Boolean> FUNC1_ALWAYS_TRUE = null;

    public static final class Always<T> implements Func1<Object, T>, Func0<T> {
        private final T value;

        public Always(T r10) {
            this.value = r10;
        }

        @Override // rx.functions.Func1
        public T call(Object r10) {
            return this.value;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public T call() {
            return this.value;
        }
    }

    static {
        Always<Boolean> r10 = new Always(Boolean.TRUE);
        ALWAYS_TRUE = r10;
        FUNC0_ALWAYS_TRUE = r10;
        FUNC1_ALWAYS_TRUE = r10;
    }

    private Functions() {
        throw new AssertionError("No instances.");
    }
}
