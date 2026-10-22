package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o {
    public static void a(ByteBuffer r10) {
        if (r10.isDirect() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
    }

    public static void b(ByteBuffer r10) {
        if (r10.hasRemaining() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer is already full.");
    }
}
