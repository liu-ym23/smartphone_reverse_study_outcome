package com.google.common.base;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class Platform {
    private Platform() {
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static CharMatcher precomputeCharMatcher(CharMatcher r0) {
        return r0.precomputedInternal();
    }

    static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> r1, String r2) {
        WeakReference<? extends Enum<?>> r3 = Enums.getEnumConstants(r1).get(r2);
        if (r3 != null) goto L6;
        return Optional.absent();
    L6:
        return Optional.of(r1.cast(r3.get()));
    }
}
