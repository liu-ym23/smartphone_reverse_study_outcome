package com.google.crypto.tink.internal;

import b8.z;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ProtoKeySerialization implements Serialization {

    @Nullable
    private final Integer idRequirement;
    private final KeyData.KeyMaterialType keyMaterialType;
    private final Bytes objectIdentifier;
    private final OutputPrefixType outputPrefixType;
    private final String typeUrl;
    private final ByteString value;

    private ProtoKeySerialization(String str, ByteString byteString, KeyData.KeyMaterialType keyMaterialType, OutputPrefixType outputPrefixType, @Nullable Integer num) {
        this.typeUrl = str;
        this.objectIdentifier = Util.toBytesFromPrintableAscii(str);
        this.value = byteString;
        this.keyMaterialType = keyMaterialType;
        this.outputPrefixType = outputPrefixType;
        this.idRequirement = num;
    }

    public static ProtoKeySerialization create(String str, ByteString byteString, KeyData.KeyMaterialType keyMaterialType, OutputPrefixType outputPrefixType, @Nullable Integer num) throws GeneralSecurityException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            if (num != null) {
                z.l("Keys with output prefix type raw should not have an id requirement.");
                return null;
            }
        } else if (num == null) {
            z.l("Keys with output prefix type different from raw should have an id requirement.");
            return null;
        }
        return new ProtoKeySerialization(str, byteString, keyMaterialType, outputPrefixType, num);
    }

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public KeyData.KeyMaterialType getKeyMaterialType() {
        return this.keyMaterialType;
    }

    @Override // com.google.crypto.tink.internal.Serialization
    public Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public OutputPrefixType getOutputPrefixType() {
        return this.outputPrefixType;
    }

    public String getTypeUrl() {
        return this.typeUrl;
    }

    public ByteString getValue() {
        return this.value;
    }
}
