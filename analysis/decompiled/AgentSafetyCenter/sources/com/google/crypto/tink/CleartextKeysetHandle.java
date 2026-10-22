package com.google.crypto.tink;

import b8.z;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class CleartextKeysetHandle {
    private CleartextKeysetHandle() {
    }

    public static KeysetHandle fromKeyset(Keyset keyset) {
        return KeysetHandle.fromKeyset(keyset);
    }

    public static Keyset getKeyset(KeysetHandle keysetHandle) {
        return keysetHandle.getKeyset();
    }

    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            return KeysetHandle.fromKeyset(Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry()));
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset");
            return null;
        }
    }

    @Alpha
    public static KeysetHandle read(KeysetReader keysetReader, Map<String, String> map) {
        return KeysetHandle.fromKeysetAndAnnotations(keysetReader.read(), MonitoringAnnotations.newBuilder().addAll(map).build());
    }

    public static void write(KeysetHandle keysetHandle, KeysetWriter keysetWriter) {
        keysetWriter.write(keysetHandle.getKeyset());
    }

    public static KeysetHandle read(KeysetReader keysetReader) {
        return KeysetHandle.fromKeyset(keysetReader.read());
    }
}
