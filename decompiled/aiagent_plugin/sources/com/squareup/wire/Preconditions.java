package com.squareup.wire;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(Object r0, String r1) {
        Objects.requireNonNull(r0, r1);
    }
}
