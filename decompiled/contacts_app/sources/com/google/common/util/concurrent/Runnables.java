package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = null;

    static {
        EMPTY_RUNNABLE = new AnonymousClass1();
    }

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    private Runnables() {
    }
}
