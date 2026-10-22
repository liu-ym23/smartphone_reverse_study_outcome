package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ParametersSerializer.ParametersSerializationFunction, ParametersParser.ParametersParsingFunction, KeySerializer.KeySerializationFunction, KeyParser.KeyParsingFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2466a;

    public /* synthetic */ a(int i) {
        this.f2466a = i;
    }

    public static /* synthetic */ void a(String str, Object obj, Object obj2) throws GeneralSecurityException {
        throw new GeneralSecurityException(str + obj + obj2);
    }

    @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
    public Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) serialization;
        switch (this.f2466a) {
            case 3:
                return AesEaxProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
            case 7:
                return AesGcmProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
            case 11:
                return AesGcmSivProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
            case 15:
                return ChaCha20Poly1305ProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
            default:
                return XChaCha20Poly1305ProtoSerialization.parseKey(protoKeySerialization, secretKeyAccess);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
    public Parameters parseParameters(Serialization serialization) {
        ProtoParametersSerialization protoParametersSerialization = (ProtoParametersSerialization) serialization;
        switch (this.f2466a) {
            case 1:
                return AesEaxProtoSerialization.parseParameters(protoParametersSerialization);
            case 5:
                return AesGcmProtoSerialization.parseParameters(protoParametersSerialization);
            case 9:
                return AesGcmSivProtoSerialization.parseParameters(protoParametersSerialization);
            case 13:
                return ChaCha20Poly1305ProtoSerialization.parseParameters(protoParametersSerialization);
            default:
                return XChaCha20Poly1305ProtoSerialization.parseParameters(protoParametersSerialization);
        }
    }

    @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
    public Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        switch (this.f2466a) {
            case 2:
                return AesEaxProtoSerialization.serializeKey((AesEaxKey) key, secretKeyAccess);
            case 6:
                return AesGcmProtoSerialization.serializeKey((AesGcmKey) key, secretKeyAccess);
            case 10:
                return AesGcmSivProtoSerialization.serializeKey((AesGcmSivKey) key, secretKeyAccess);
            case 14:
                return ChaCha20Poly1305ProtoSerialization.serializeKey((ChaCha20Poly1305Key) key, secretKeyAccess);
            default:
                return XChaCha20Poly1305ProtoSerialization.serializeKey((XChaCha20Poly1305Key) key, secretKeyAccess);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
    public Serialization serializeParameters(Parameters parameters) {
        switch (this.f2466a) {
            case 0:
                return AesEaxProtoSerialization.serializeParameters((AesEaxParameters) parameters);
            case 4:
                return AesGcmProtoSerialization.serializeParameters((AesGcmParameters) parameters);
            case 8:
                return AesGcmSivProtoSerialization.serializeParameters((AesGcmSivParameters) parameters);
            case 12:
                return ChaCha20Poly1305ProtoSerialization.serializeParameters((ChaCha20Poly1305Parameters) parameters);
            default:
                return XChaCha20Poly1305ProtoSerialization.serializeParameters((XChaCha20Poly1305Parameters) parameters);
        }
    }
}
