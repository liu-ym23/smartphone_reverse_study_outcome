package com.squareup.wire;

/* JADX INFO: loaded from: classes4.dex */
final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r11);
    }
}
