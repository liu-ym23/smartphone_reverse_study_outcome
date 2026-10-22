package com.google.common.base;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Verify {
    public static void verify(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new VerifyException();
    }

    public static void verify(boolean r0, @Nullable String r1, @Nullable Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Preconditions.format(r1, r2));
    }

    public static <T> T verifyNotNull(@Nullable T r2) {
        return (T) verifyNotNull(r2, "expected a non-null reference", new Object[0]);
    }

    public static <T> T verifyNotNull(@Nullable T r1, @Nullable String r2, @Nullable Object... r3) {
        if (r1 == null) goto L4;
        boolean r0 = true;
    L5:
        verify(r0, r2, r3);
        return r1;
    L4:
        r0 = false;
        goto L5
    }

    private Verify() {
    }
}
