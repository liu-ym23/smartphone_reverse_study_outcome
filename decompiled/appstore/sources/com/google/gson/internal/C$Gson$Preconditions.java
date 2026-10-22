package com.google.gson.internal;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }
}
