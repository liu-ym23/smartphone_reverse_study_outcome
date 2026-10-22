package com.google.crypto.tink;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface StreamingAead {
    ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr);

    InputStream newDecryptingStream(InputStream inputStream, byte[] bArr);

    WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr);

    OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr);

    SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr);
}
