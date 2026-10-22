package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkDirect(ByteBuffer r1) {
        if (r1.isDirect() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
    }

    public static void checkHasRemaining(ByteBuffer r1) {
        if (r1.hasRemaining() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer is already full.");
    }
}
