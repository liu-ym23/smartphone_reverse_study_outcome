package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ParametersSerializer.ParametersSerializationFunction, ParametersParser.ParametersParsingFunction, KeySerializer.KeySerializationFunction, KeyParser.KeyParsingFunction, PrimitiveConstructor.PrimitiveConstructionFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2470a;

    public /* synthetic */ a(int i) {
        this.f2470a = i;
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public Object constructPrimitive(Key key) {
        switch (this.f2470a) {
            case 8:
                return new ChunkedAesCmacImpl((AesCmacKey) key);
            default:
                return new ChunkedHmacImpl((HmacKey) key);
        }
    }

    @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
    public Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) serialization;
        switch (this.f2470a) {
            case 3:
                return AesCmacProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
            default:
                return HmacProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
    public Parameters parseParameters(Serialization serialization) {
        ProtoParametersSerialization protoParametersSerialization = (ProtoParametersSerialization) serialization;
        switch (this.f2470a) {
            case 1:
                return AesCmacProtoSerialization.parseParameters(protoParametersSerialization);
            default:
                return HmacProtoSerialization.parseParameters(protoParametersSerialization);
        }
    }

    @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
    public Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        switch (this.f2470a) {
            case 2:
                return AesCmacProtoSerialization.serializeKey((AesCmacKey) key, secretKeyAccess);
            default:
                return HmacProtoSerialization.serializeKey((HmacKey) key, secretKeyAccess);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
    public Serialization serializeParameters(Parameters parameters) {
        switch (this.f2470a) {
            case 0:
                return AesCmacProtoSerialization.serializeParameters((AesCmacParameters) parameters);
            default:
                return HmacProtoSerialization.serializeParameters((HmacParameters) parameters);
        }
    }
}
