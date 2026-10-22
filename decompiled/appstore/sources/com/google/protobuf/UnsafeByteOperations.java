package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L7;
        int r11 = r10.arrayOffset();
        return ByteString.wrap(r10.array(), r11 + r10.position(), r10.remaining());
    L7:
        return new NioByteString(r10);
    }

    public static void unsafeWriteTo(ByteString r10, ByteOutput r11) throws IOException {
        r10.writeTo(r11);
    }
}
