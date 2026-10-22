package com.google.crypto.tink.signature;

import b8.z;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.subtle.Validators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class Ed25519PublicKeyManager extends KeyTypeManager<Ed25519PublicKey> {
    public Ed25519PublicKeyManager() {
        super(Ed25519PublicKey.class, new PrimitiveFactory<PublicKeyVerify, Ed25519PublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.Ed25519PublicKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public PublicKeyVerify getPrimitive(Ed25519PublicKey ed25519PublicKey) {
                return new Ed25519Verify(ed25519PublicKey.getKeyValue().toByteArray());
            }
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public Ed25519PublicKey parseKey(ByteString byteString) {
        return Ed25519PublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(Ed25519PublicKey ed25519PublicKey) {
        Validators.validateVersion(ed25519PublicKey.getVersion(), getVersion());
        if (ed25519PublicKey.getKeyValue().size() == 32) {
            return;
        }
        z.l("invalid Ed25519 public key: incorrect key length");
    }
}
