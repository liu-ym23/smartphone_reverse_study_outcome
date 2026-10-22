package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.util.Bytes;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ProtoParametersSerialization implements Serialization {
    private final KeyTemplate keyTemplate;
    private final Bytes objectIdentifier;

    private ProtoParametersSerialization(KeyTemplate keyTemplate) {
        this.keyTemplate = keyTemplate;
        this.objectIdentifier = Util.toBytesFromPrintableAscii(keyTemplate.getTypeUrl());
    }

    public static ProtoParametersSerialization create(String str, OutputPrefixType outputPrefixType, MessageLite messageLite) {
        return create(KeyTemplate.newBuilder().setTypeUrl(str).setOutputPrefixType(outputPrefixType).setValue(messageLite.toByteString()).build());
    }

    public KeyTemplate getKeyTemplate() {
        return this.keyTemplate;
    }

    @Override // com.google.crypto.tink.internal.Serialization
    public Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public static ProtoParametersSerialization create(KeyTemplate keyTemplate) {
        return new ProtoParametersSerialization(keyTemplate);
    }
}
