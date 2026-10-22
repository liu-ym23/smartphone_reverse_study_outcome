package com.jakewharton.rxbinding.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("No instances.");
    }

    public static void checkArgument(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static <T> T checkNotNull(T r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }
}
