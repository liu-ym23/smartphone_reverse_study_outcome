package com.google.crypto.tink.hybrid.internal;

import b8.z;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class HpkePublicKeyManager extends KeyTypeManager<HpkePublicKey> {
    public HpkePublicKeyManager() {
        super(HpkePublicKey.class, new PrimitiveFactory<HybridEncrypt, HpkePublicKey>(HybridEncrypt.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePublicKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public HybridEncrypt getPrimitive(HpkePublicKey hpkePublicKey) {
                return HpkeEncrypt.createHpkeEncrypt(hpkePublicKey);
            }
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
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
    public HpkePublicKey parseKey(ByteString byteString) {
        return HpkePublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(HpkePublicKey hpkePublicKey) throws GeneralSecurityException {
        Validators.validateVersion(hpkePublicKey.getVersion(), getVersion());
        if (hpkePublicKey.hasParams()) {
            HpkeUtil.validateParams(hpkePublicKey.getParams());
        } else {
            z.l("Missing HPKE key params.");
        }
    }
}
