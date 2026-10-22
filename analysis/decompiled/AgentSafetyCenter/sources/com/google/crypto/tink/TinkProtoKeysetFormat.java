package com.google.crypto.tink;

import b8.z;
import g5.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class TinkProtoKeysetFormat {
    private TinkProtoKeysetFormat() {
    }

    public static KeysetHandle parseEncryptedKeyset(byte[] bArr, Aead aead, byte[] bArr2) throws GeneralSecurityException {
        try {
            return KeysetHandle.readWithAssociatedData(BinaryKeysetReader.withBytes(bArr), aead, bArr2);
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static KeysetHandle parseKeyset(byte[] bArr, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess == null) {
            f.g("SecretKeyAccess cannot be null");
            return null;
        }
        try {
            return CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(bArr));
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static KeysetHandle parseKeysetWithoutSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            return KeysetHandle.readNoSecret(BinaryKeysetReader.withBytes(bArr));
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static byte[] serializeEncryptedKeyset(KeysetHandle keysetHandle, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeWithAssociatedData(BinaryKeysetWriter.withOutputStream(byteArrayOutputStream), aead, bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }

    public static byte[] serializeKeyset(KeysetHandle keysetHandle, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess == null) {
            f.g("SecretKeyAccess cannot be null");
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CleartextKeysetHandle.write(keysetHandle, BinaryKeysetWriter.withOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }

    public static byte[] serializeKeysetWithoutSecret(KeysetHandle keysetHandle) throws GeneralSecurityException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeNoSecret(BinaryKeysetWriter.withOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }
}
