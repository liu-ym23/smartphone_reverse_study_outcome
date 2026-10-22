package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface StreamSegmentEncrypter {
    void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z10, ByteBuffer byteBuffer3);

    void encryptSegment(ByteBuffer byteBuffer, boolean z10, ByteBuffer byteBuffer2);

    ByteBuffer getHeader();
}
