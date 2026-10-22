package com.google.crypto.tink.signature;

import b8.z;
import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class EcdsaPrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger privateValue;
    private final EcdsaPublicKey publicKey;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private SecretBigInteger privateValue;
        private EcdsaPublicKey publicKey;

        private Builder() {
            this.publicKey = null;
            this.privateValue = null;
        }

        private static void validatePrivateValue(BigInteger bigInteger, ECPoint eCPoint, EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
            BigInteger order = curveType.toParameterSpec().getOrder();
            if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
                z.l("Invalid private value");
            } else {
                if (EllipticCurvesUtil.multiplyByGenerator(bigInteger, curveType.toParameterSpec()).equals(eCPoint)) {
                    return;
                }
                z.l("Invalid private value");
            }
        }

        @AccessesPartialKey
        public EcdsaPrivateKey build() throws GeneralSecurityException {
            if (this.publicKey == null) {
                z.l("Cannot build without a ecdsa public key");
                return null;
            }
            SecretBigInteger secretBigInteger = this.privateValue;
            if (secretBigInteger != null) {
                validatePrivateValue(secretBigInteger.getBigInteger(InsecureSecretKeyAccess.get()), this.publicKey.getPublicPoint(), this.publicKey.getParameters().getCurveType());
                return new EcdsaPrivateKey(this.publicKey, this.privateValue);
            }
            z.l("Cannot build without a private value");
            return null;
        }

        public Builder setPrivateValue(SecretBigInteger secretBigInteger) {
            this.privateValue = secretBigInteger;
            return this;
        }

        public Builder setPublicKey(EcdsaPublicKey ecdsaPublicKey) {
            this.publicKey = ecdsaPublicKey;
            return this;
        }
    }

    private EcdsaPrivateKey(EcdsaPublicKey ecdsaPublicKey, SecretBigInteger secretBigInteger) {
        this.publicKey = ecdsaPublicKey;
        this.privateValue = secretBigInteger;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof EcdsaPrivateKey)) {
            return false;
        }
        EcdsaPrivateKey ecdsaPrivateKey = (EcdsaPrivateKey) key;
        return ecdsaPrivateKey.publicKey.equalsKey(this.publicKey) && this.privateValue.equalsSecretBigInteger(ecdsaPrivateKey.privateValue);
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public EcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    public SecretBigInteger getPrivateValue() {
        return this.privateValue;
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public EcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }
}
