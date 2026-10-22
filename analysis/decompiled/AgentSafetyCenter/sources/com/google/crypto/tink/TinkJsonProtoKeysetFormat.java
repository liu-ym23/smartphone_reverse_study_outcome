package com.google.crypto.tink;

import b8.z;
import g5.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class TinkJsonProtoKeysetFormat {
    private TinkJsonProtoKeysetFormat() {
    }

    public static KeysetHandle parseEncryptedKeyset(String str, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            return KeysetHandle.readWithAssociatedData(JsonKeysetReader.withString(str), aead, bArr);
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static KeysetHandle parseKeyset(String str, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess == null) {
            f.g("SecretKeyAccess cannot be null");
            return null;
        }
        try {
            return CleartextKeysetHandle.read(JsonKeysetReader.withString(str));
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static KeysetHandle parseKeysetWithoutSecret(String str) throws GeneralSecurityException {
        try {
            return KeysetHandle.readNoSecret(JsonKeysetReader.withString(str));
        } catch (IOException unused) {
            z.l("Parse keyset failed");
            return null;
        }
    }

    public static String serializeEncryptedKeyset(KeysetHandle keysetHandle, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeWithAssociatedData(JsonKeysetWriter.withOutputStream(byteArrayOutputStream), aead, bArr);
            return new String(byteArrayOutputStream.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }

    public static String serializeKeyset(KeysetHandle keysetHandle, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess == null) {
            f.g("SecretKeyAccess cannot be null");
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withOutputStream(byteArrayOutputStream));
            return new String(byteArrayOutputStream.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }

    public static String serializeKeysetWithoutSecret(KeysetHandle keysetHandle) throws GeneralSecurityException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeNoSecret(JsonKeysetWriter.withOutputStream(byteArrayOutputStream));
            return new String(byteArrayOutputStream.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
        } catch (IOException unused) {
            z.l("Serialize keyset failed");
            return null;
        }
    }
}
