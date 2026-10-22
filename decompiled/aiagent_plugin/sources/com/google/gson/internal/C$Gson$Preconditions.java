package com.google.gson.internal;

import java.util.Objects;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T> T checkNotNull(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static void checkArgument(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }
}
