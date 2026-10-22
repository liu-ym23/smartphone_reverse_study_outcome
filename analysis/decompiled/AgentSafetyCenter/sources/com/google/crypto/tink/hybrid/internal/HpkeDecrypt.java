package com.google.crypto.tink.hybrid.internal;

import b8.z;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.proto.HpkePrivateKey;
import g5.f;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class HpkeDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];
    private final HpkeAead aead;
    private final int encapsulatedKeyLength;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final HpkeKemPrivateKey recipientPrivateKey;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeDecrypt$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.HpkeKem.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[com.google.crypto.tink.proto.HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private HpkeDecrypt(HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, int i) {
        this.recipientPrivateKey = hpkeKemPrivateKey;
        this.kem = hpkeKem;
        this.kdf = hpkeKdf;
        this.aead = hpkeAead;
        this.encapsulatedKeyLength = i;
    }

    public static HpkeDecrypt createHpkeDecrypt(HpkePrivateKey hpkePrivateKey) {
        if (!hpkePrivateKey.hasPublicKey()) {
            f.s("HpkePrivateKey is missing public_key field.");
            return null;
        }
        if (!hpkePrivateKey.getPublicKey().hasParams()) {
            f.s("HpkePrivateKey.public_key is missing params field.");
            return null;
        }
        if (hpkePrivateKey.getPrivateKey().isEmpty()) {
            f.s("HpkePrivateKey.private_key is empty.");
            return null;
        }
        HpkeParams params = hpkePrivateKey.getPublicKey().getParams();
        return new HpkeDecrypt(HpkeKemKeyFactory.createPrivate(hpkePrivateKey), HpkePrimitiveFactory.createKem(params), HpkePrimitiveFactory.createKdf(params), HpkePrimitiveFactory.createAead(params), encodingSizeInBytes(params.getKem()));
    }

    private static int encodingSizeInBytes(com.google.crypto.tink.proto.HpkeKem hpkeKem) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkeKem.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 65;
        }
        if (i == 3) {
            return 97;
        }
        if (i == 4) {
            return 133;
        }
        f.f(hpkeKem.name(), "Unable to determine KEM-encoding length for ");
        return 0;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.encapsulatedKeyLength;
        if (length < i) {
            z.l("Ciphertext is too short.");
            return null;
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        return HpkeContext.createRecipientContext(bArrCopyOf, this.recipientPrivateKey, this.kem, this.kdf, this.aead, bArr3).open(Arrays.copyOfRange(bArr, this.encapsulatedKeyLength, bArr.length), EMPTY_ASSOCIATED_DATA);
    }
}
