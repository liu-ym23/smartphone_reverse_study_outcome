package com.google.crypto.tink.streamingaead;

import b8.z;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class StreamingAeadHelper implements StreamingAead {
    PrimitiveSet<StreamingAead> primitives;

    public StreamingAeadHelper(PrimitiveSet<StreamingAead> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() != null) {
            this.primitives = primitiveSet;
        } else {
            z.l("Missing primary primitive.");
            throw null;
        }
    }

    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return new ReadableByteChannelDecrypter(this.primitives, readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        return new InputStreamDecrypter(this.primitives, inputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) {
        return this.primitives.getPrimary().getPrimitive().newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return this.primitives.getPrimary().getPrimitive().newEncryptingStream(outputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return new SeekableByteChannelDecrypter(this.primitives, seekableByteChannel, bArr);
    }
}
