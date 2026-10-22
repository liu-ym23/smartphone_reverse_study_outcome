package com.google.crypto.tink.signature;

import b8.z;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class EcdsaParameters extends SignatureParameters {
    private final CurveType curveType;
    private final HashType hashType;
    private final SignatureEncoding signatureEncoding;
    private final Variant variant;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private CurveType curveType;
        private HashType hashType;
        private SignatureEncoding signatureEncoding;
        private Variant variant;

        private Builder() {
            this.signatureEncoding = null;
            this.curveType = null;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public EcdsaParameters build() throws GeneralSecurityException {
            SignatureEncoding signatureEncoding = this.signatureEncoding;
            if (signatureEncoding == null) {
                z.l("signature encoding is not set");
                return null;
            }
            CurveType curveType = this.curveType;
            if (curveType == null) {
                z.l("EC curve type is not set");
                return null;
            }
            HashType hashType = this.hashType;
            if (hashType == null) {
                z.l("hash type is not set");
                return null;
            }
            Variant variant = this.variant;
            if (variant == null) {
                z.l("variant is not set");
                return null;
            }
            if (curveType == CurveType.NIST_P256 && hashType != HashType.SHA256) {
                z.l("NIST_P256 requires SHA256");
                return null;
            }
            if (curveType == CurveType.NIST_P384 && hashType != HashType.SHA384 && hashType != HashType.SHA512) {
                z.l("NIST_P384 requires SHA384 or SHA512");
                return null;
            }
            if (curveType != CurveType.NIST_P521 || hashType == HashType.SHA512) {
                return new EcdsaParameters(signatureEncoding, curveType, hashType, variant);
            }
            z.l("NIST_P521 requires SHA512");
            return null;
        }

        public Builder setCurveType(CurveType curveType) {
            this.curveType = curveType;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public Builder setSignatureEncoding(SignatureEncoding signatureEncoding) {
            this.signatureEncoding = signatureEncoding;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CurveType {
        public static final CurveType NIST_P256 = new CurveType("NIST_P256", EllipticCurvesUtil.NIST_P256_PARAMS);
        public static final CurveType NIST_P384 = new CurveType("NIST_P384", EllipticCurvesUtil.NIST_P384_PARAMS);
        public static final CurveType NIST_P521 = new CurveType("NIST_P521", EllipticCurvesUtil.NIST_P521_PARAMS);
        private final String name;
        private final ECParameterSpec spec;

        private CurveType(String str, ECParameterSpec eCParameterSpec) {
            this.name = str;
            this.spec = eCParameterSpec;
        }

        public static CurveType fromParameterSpec(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
            CurveType curveType = NIST_P256;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType.toParameterSpec())) {
                return curveType;
            }
            CurveType curveType2 = NIST_P384;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType2.toParameterSpec())) {
                return curveType2;
            }
            CurveType curveType3 = NIST_P521;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType3.toParameterSpec())) {
                return curveType3;
            }
            z.l("unknown ECParameterSpec");
            return null;
        }

        public ECParameterSpec toParameterSpec() {
            return this.spec;
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class HashType {
        public static final HashType SHA256 = new HashType("SHA256");
        public static final HashType SHA384 = new HashType("SHA384");
        public static final HashType SHA512 = new HashType("SHA512");
        private final String name;

        private HashType(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SignatureEncoding {
        private final String name;
        public static final SignatureEncoding IEEE_P1363 = new SignatureEncoding("IEEE_P1363");
        public static final SignatureEncoding DER = new SignatureEncoding("DER");

        private SignatureEncoding(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant LEGACY = new Variant("LEGACY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");

        private Variant(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private EcdsaParameters(SignatureEncoding signatureEncoding, CurveType curveType, HashType hashType, Variant variant) {
        this.signatureEncoding = signatureEncoding;
        this.curveType = curveType;
        this.hashType = hashType;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EcdsaParameters)) {
            return false;
        }
        EcdsaParameters ecdsaParameters = (EcdsaParameters) obj;
        return ecdsaParameters.getSignatureEncoding() == getSignatureEncoding() && ecdsaParameters.getCurveType() == getCurveType() && ecdsaParameters.getHashType() == getHashType() && ecdsaParameters.getVariant() == getVariant();
    }

    public CurveType getCurveType() {
        return this.curveType;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public SignatureEncoding getSignatureEncoding() {
        return this.signatureEncoding;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(this.signatureEncoding, this.curveType, this.hashType, this.variant);
    }

    public String toString() {
        return "ECDSA Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", encoding: " + this.signatureEncoding + ", curve: " + this.curveType + ")";
    }
}
