package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x {
    public static void a(ByteBuffer r1) {
        if (r1.isDirect() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
    }

    public static void b(ByteBuffer r1) {
        if (r1.hasRemaining() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer is already full.");
    }
}
