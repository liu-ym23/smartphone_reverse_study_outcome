package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class ParametersSerializer<ParametersT extends Parameters, SerializationT extends Serialization> {
    private final Class<ParametersT> parametersClass;
    private final Class<SerializationT> serializationClass;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ParametersSerializationFunction<ParametersT extends Parameters, SerializationT extends Serialization> {
        SerializationT serializeParameters(ParametersT parameterst);
    }

    private ParametersSerializer(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.parametersClass = cls;
        this.serializationClass = cls2;
    }

    public static <ParametersT extends Parameters, SerializationT extends Serialization> ParametersSerializer<ParametersT, SerializationT> create(final ParametersSerializationFunction<ParametersT, SerializationT> parametersSerializationFunction, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return (ParametersSerializer<ParametersT, SerializationT>) new ParametersSerializer<ParametersT, SerializationT>(cls, cls2) { // from class: com.google.crypto.tink.internal.ParametersSerializer.1
            @Override // com.google.crypto.tink.internal.ParametersSerializer
            public SerializationT serializeParameters(ParametersT parameterst) {
                return (SerializationT) parametersSerializationFunction.serializeParameters(parameterst);
            }
        };
    }

    public Class<ParametersT> getParametersClass() {
        return this.parametersClass;
    }

    public Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract SerializationT serializeParameters(ParametersT parameterst);
}
