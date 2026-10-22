package com.google.crypto.tink;

import b8.z;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public final class NoSecretKeysetHandle {
    private NoSecretKeysetHandle() {
    }

    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset from = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            validate(from);
            return KeysetHandle.fromKeyset(from);
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset");
            return null;
        }
    }

    public static final KeysetHandle read(KeysetReader keysetReader) throws GeneralSecurityException {
        Keyset keyset = keysetReader.read();
        validate(keyset);
        return KeysetHandle.fromKeyset(keyset);
    }

    private static void validate(Keyset keyset) throws GeneralSecurityException {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                z.l("keyset contains secret key material");
                return;
            }
        }
    }
}
