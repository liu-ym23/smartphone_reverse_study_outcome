package com.google.crypto.tink.aead;

import ad.o;
import b8.z;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.AesGcmSivParameters;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class AesGcmSivKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final AesGcmSivParameters parameters;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private AesGcmSivParameters parameters;

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesGcmSivParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            o.n(this.parameters.getVariant(), "Unknown AesGcmSivParameters.Variant: ");
            return null;
        }

        public AesGcmSivKey build() throws GeneralSecurityException {
            AesGcmSivParameters aesGcmSivParameters = this.parameters;
            if (aesGcmSivParameters == null || this.keyBytes == null) {
                z.l("Cannot build without parameters and/or key material");
                return null;
            }
            if (aesGcmSivParameters.getKeySizeBytes() != this.keyBytes.size()) {
                z.l("Key size mismatch");
                return null;
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                z.l("Cannot create key without ID requirement with parameters with ID requirement");
                return null;
            }
            if (this.parameters.hasIdRequirement() || this.idRequirement == null) {
                return new AesGcmSivKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
            }
            z.l("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(AesGcmSivParameters aesGcmSivParameters) {
            this.parameters = aesGcmSivParameters;
            return this;
        }
    }

    private AesGcmSivKey(AesGcmSivParameters aesGcmSivParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = aesGcmSivParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof AesGcmSivKey)) {
            return false;
        }
        AesGcmSivKey aesGcmSivKey = (AesGcmSivKey) key;
        return aesGcmSivKey.parameters.equals(this.parameters) && aesGcmSivKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(aesGcmSivKey.idRequirement, this.idRequirement);
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public AesGcmSivParameters getParameters() {
        return this.parameters;
    }
}
