package com.google.crypto.tink.internal;

import androidx.activity.b;
import b8.z;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.a;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SerializationRegistry {
    private final Map<ParserIndex, KeyParser<?>> keyParserMap;
    private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
    private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
    private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ParserIndex {
        private final Class<? extends Serialization> keySerializationClass;
        private final Bytes serializationIdentifier;

        private ParserIndex(Class<? extends Serialization> cls, Bytes bytes) {
            this.keySerializationClass = cls;
            this.serializationIdentifier = bytes;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParserIndex)) {
                return false;
            }
            ParserIndex parserIndex = (ParserIndex) obj;
            return parserIndex.keySerializationClass.equals(this.keySerializationClass) && parserIndex.serializationIdentifier.equals(this.serializationIdentifier);
        }

        public int hashCode() {
            return Objects.hash(this.keySerializationClass, this.serializationIdentifier);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            b.t(sb2, this.keySerializationClass, ", object identifier: ");
            sb2.append(this.serializationIdentifier);
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SerializerIndex {
        private final Class<?> keyClass;
        private final Class<? extends Serialization> keySerializationClass;

        private SerializerIndex(Class<?> cls, Class<? extends Serialization> cls2) {
            this.keyClass = cls;
            this.keySerializationClass = cls2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SerializerIndex)) {
                return false;
            }
            SerializerIndex serializerIndex = (SerializerIndex) obj;
            return serializerIndex.keyClass.equals(this.keyClass) && serializerIndex.keySerializationClass.equals(this.keySerializationClass);
        }

        public int hashCode() {
            return Objects.hash(this.keyClass, this.keySerializationClass);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            b.t(sb2, this.keyClass, " with serialization type: ");
            sb2.append(this.keySerializationClass.getSimpleName());
            return sb2.toString();
        }
    }

    private SerializationRegistry(Builder builder) {
        this.keySerializerMap = new HashMap(builder.keySerializerMap);
        this.keyParserMap = new HashMap(builder.keyParserMap);
        this.parametersSerializerMap = new HashMap(builder.parametersSerializerMap);
        this.parametersParserMap = new HashMap(builder.parametersParserMap);
    }

    public <SerializationT extends Serialization> boolean hasParserForKey(SerializationT serializationt) {
        return this.keyParserMap.containsKey(new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier()));
    }

    public <SerializationT extends Serialization> boolean hasParserForParameters(SerializationT serializationt) {
        return this.parametersParserMap.containsKey(new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier()));
    }

    public <KeyT extends Key, SerializationT extends Serialization> boolean hasSerializerForKey(KeyT keyt, Class<SerializationT> cls) {
        return this.keySerializerMap.containsKey(new SerializerIndex(keyt.getClass(), cls));
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> boolean hasSerializerForParameters(ParametersT parameterst, Class<SerializationT> cls) {
        return this.parametersSerializerMap.containsKey(new SerializerIndex(parameterst.getClass(), cls));
    }

    public <SerializationT extends Serialization> Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        ParserIndex parserIndex = new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier());
        if (this.keyParserMap.containsKey(parserIndex)) {
            return this.keyParserMap.get(parserIndex).parseKey(serializationt, secretKeyAccess);
        }
        a.a("No Key Parser for requested key type ", parserIndex, " available");
        return null;
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializationt) throws GeneralSecurityException {
        ParserIndex parserIndex = new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier());
        if (this.parametersParserMap.containsKey(parserIndex)) {
            return this.parametersParserMap.get(parserIndex).parseParameters(serializationt);
        }
        a.a("No Parameters Parser for requested key type ", parserIndex, " available");
        return null;
    }

    public <KeyT extends Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT keyt, Class<SerializationT> cls, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        SerializerIndex serializerIndex = new SerializerIndex(keyt.getClass(), cls);
        if (this.keySerializerMap.containsKey(serializerIndex)) {
            return (SerializationT) this.keySerializerMap.get(serializerIndex).serializeKey(keyt, secretKeyAccess);
        }
        a.a("No Key serializer for ", serializerIndex, " available");
        return null;
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        SerializerIndex serializerIndex = new SerializerIndex(parameterst.getClass(), cls);
        if (this.parametersSerializerMap.containsKey(serializerIndex)) {
            return (SerializationT) this.parametersSerializerMap.get(serializerIndex).serializeParameters(parameterst);
        }
        a.a("No Key Format serializer for ", serializerIndex, " available");
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private final Map<ParserIndex, KeyParser<?>> keyParserMap;
        private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
        private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
        private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

        public Builder(SerializationRegistry serializationRegistry) {
            this.keySerializerMap = new HashMap(serializationRegistry.keySerializerMap);
            this.keyParserMap = new HashMap(serializationRegistry.keyParserMap);
            this.parametersSerializerMap = new HashMap(serializationRegistry.parametersSerializerMap);
            this.parametersParserMap = new HashMap(serializationRegistry.parametersParserMap);
        }

        public SerializationRegistry build() {
            return new SerializationRegistry(this);
        }

        public <SerializationT extends Serialization> Builder registerKeyParser(KeyParser<SerializationT> keyParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(keyParser.getSerializationClass(), keyParser.getObjectIdentifier());
            boolean zContainsKey = this.keyParserMap.containsKey(parserIndex);
            Map<ParserIndex, KeyParser<?>> map = this.keyParserMap;
            if (!zContainsKey) {
                map.put(parserIndex, keyParser);
                return this;
            }
            KeyParser<?> keyParser2 = map.get(parserIndex);
            if (keyParser2.equals(keyParser) && keyParser.equals(keyParser2)) {
                return this;
            }
            z.k(parserIndex, "Attempt to register non-equal parser for already existing object of type: ");
            return null;
        }

        public <KeyT extends Key, SerializationT extends Serialization> Builder registerKeySerializer(KeySerializer<KeyT, SerializationT> keySerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(keySerializer.getKeyClass(), keySerializer.getSerializationClass());
            boolean zContainsKey = this.keySerializerMap.containsKey(serializerIndex);
            Map<SerializerIndex, KeySerializer<?, ?>> map = this.keySerializerMap;
            if (!zContainsKey) {
                map.put(serializerIndex, keySerializer);
                return this;
            }
            KeySerializer<?, ?> keySerializer2 = map.get(serializerIndex);
            if (keySerializer2.equals(keySerializer) && keySerializer.equals(keySerializer2)) {
                return this;
            }
            z.k(serializerIndex, "Attempt to register non-equal serializer for already existing object of type: ");
            return null;
        }

        public <SerializationT extends Serialization> Builder registerParametersParser(ParametersParser<SerializationT> parametersParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(parametersParser.getSerializationClass(), parametersParser.getObjectIdentifier());
            boolean zContainsKey = this.parametersParserMap.containsKey(parserIndex);
            Map<ParserIndex, ParametersParser<?>> map = this.parametersParserMap;
            if (!zContainsKey) {
                map.put(parserIndex, parametersParser);
                return this;
            }
            ParametersParser<?> parametersParser2 = map.get(parserIndex);
            if (parametersParser2.equals(parametersParser) && parametersParser.equals(parametersParser2)) {
                return this;
            }
            z.k(parserIndex, "Attempt to register non-equal parser for already existing object of type: ");
            return null;
        }

        public <ParametersT extends Parameters, SerializationT extends Serialization> Builder registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> parametersSerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(parametersSerializer.getParametersClass(), parametersSerializer.getSerializationClass());
            boolean zContainsKey = this.parametersSerializerMap.containsKey(serializerIndex);
            Map<SerializerIndex, ParametersSerializer<?, ?>> map = this.parametersSerializerMap;
            if (!zContainsKey) {
                map.put(serializerIndex, parametersSerializer);
                return this;
            }
            ParametersSerializer<?, ?> parametersSerializer2 = map.get(serializerIndex);
            if (parametersSerializer2.equals(parametersSerializer) && parametersSerializer.equals(parametersSerializer2)) {
                return this;
            }
            z.k(serializerIndex, "Attempt to register non-equal serializer for already existing object of type: ");
            return null;
        }

        public Builder() {
            this.keySerializerMap = new HashMap();
            this.keyParserMap = new HashMap();
            this.parametersSerializerMap = new HashMap();
            this.parametersParserMap = new HashMap();
        }
    }
}
