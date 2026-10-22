package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.util.Bytes;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class ParametersParser<SerializationT extends Serialization> {
    private final Bytes objectIdentifier;
    private final Class<SerializationT> serializationClass;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ParametersParsingFunction<SerializationT extends Serialization> {
        Parameters parseParameters(SerializationT serializationt);
    }

    private ParametersParser(Bytes bytes, Class<SerializationT> cls) {
        this.objectIdentifier = bytes;
        this.serializationClass = cls;
    }

    public static <SerializationT extends Serialization> ParametersParser<SerializationT> create(final ParametersParsingFunction<SerializationT> parametersParsingFunction, Bytes bytes, Class<SerializationT> cls) {
        return (ParametersParser<SerializationT>) new ParametersParser<SerializationT>(bytes, cls) { // from class: com.google.crypto.tink.internal.ParametersParser.1
            @Override // com.google.crypto.tink.internal.ParametersParser
            public Parameters parseParameters(SerializationT serializationt) {
                return parametersParsingFunction.parseParameters(serializationt);
            }
        };
    }

    public final Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public final Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract Parameters parseParameters(SerializationT serializationt);
}
