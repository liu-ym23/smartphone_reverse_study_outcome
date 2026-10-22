package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
final class Java8Compatibility {
    static void clear(Buffer r0) {
        r0.clear();
    }

    static void flip(Buffer r0) {
        r0.flip();
    }

    static void limit(Buffer r0, int r1) {
        r0.limit(r1);
    }

    static void mark(Buffer r0) {
        r0.mark();
    }

    static void position(Buffer r0, int r1) {
        r0.position(r1);
    }

    static void reset(Buffer r0) {
        r0.reset();
    }

    private Java8Compatibility() {
    }
}
