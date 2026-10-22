package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class BinaryKeysetReader implements KeysetReader {
    private final InputStream inputStream;

    private BinaryKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static KeysetReader withBytes(byte[] bArr) {
        return new BinaryKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static KeysetReader withFile(File file) {
        return withInputStream(new FileInputStream(file));
    }

    public static KeysetReader withInputStream(InputStream inputStream) {
        return new BinaryKeysetReader(inputStream);
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            return Keyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            this.inputStream.close();
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            return EncryptedKeyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            this.inputStream.close();
        }
    }
}
