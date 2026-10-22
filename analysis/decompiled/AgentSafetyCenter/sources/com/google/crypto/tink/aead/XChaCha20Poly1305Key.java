package com.google.crypto.tink.aead;

import ad.o;
import b8.z;
import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.XChaCha20Poly1305Parameters;
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
public final class XChaCha20Poly1305Key extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final XChaCha20Poly1305Parameters parameters;

    private XChaCha20Poly1305Key(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = xChaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static XChaCha20Poly1305Key create(XChaCha20Poly1305Parameters.Variant variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        XChaCha20Poly1305Parameters.Variant variant2 = XChaCha20Poly1305Parameters.Variant.NO_PREFIX;
        if (variant != variant2 && num == null) {
            a.a("For given Variant ", variant, " the value of idRequirement must be non-null");
            return null;
        }
        if (variant == variant2 && num != null) {
            z.l("For given Variant NO_PREFIX the value of idRequirement must be null");
            return null;
        }
        if (secretBytes.size() == 32) {
            XChaCha20Poly1305Parameters xChaCha20Poly1305ParametersCreate = XChaCha20Poly1305Parameters.create(variant);
            return new XChaCha20Poly1305Key(xChaCha20Poly1305ParametersCreate, secretBytes, getOutputPrefix(xChaCha20Poly1305ParametersCreate, num), num);
        }
        throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.size());
    }

    private static Bytes getOutputPrefix(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, @Nullable Integer num) {
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.NO_PREFIX) {
            return Bytes.copyFrom(new byte[0]);
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.CRUNCHY) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.Variant.TINK) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        o.n(xChaCha20Poly1305Parameters.getVariant(), "Unknown Variant: ");
        return null;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof XChaCha20Poly1305Key)) {
            return false;
        }
        XChaCha20Poly1305Key xChaCha20Poly1305Key = (XChaCha20Poly1305Key) key;
        return xChaCha20Poly1305Key.parameters.equals(this.parameters) && xChaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(xChaCha20Poly1305Key.idRequirement, this.idRequirement);
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public XChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    @AccessesPartialKey
    public static XChaCha20Poly1305Key create(SecretBytes secretBytes) {
        return create(XChaCha20Poly1305Parameters.Variant.NO_PREFIX, secretBytes, null);
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }
}
