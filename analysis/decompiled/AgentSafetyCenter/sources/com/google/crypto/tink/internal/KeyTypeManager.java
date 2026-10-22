package com.google.crypto.tink.internal;

import b8.z;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import g5.f;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    private final Class<KeyProtoT> clazz;
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    private final Class<?> firstPrimitiveClass;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        private final Class<KeyFormatProtoT> clazz;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class KeyFormat<KeyFormatProtoT> {
            public KeyFormatProtoT keyFormat;
            public KeyTemplate.OutputPrefixType outputPrefixType;

            public KeyFormat(KeyFormatProtoT keyformatprotot, KeyTemplate.OutputPrefixType outputPrefixType) {
                this.keyFormat = keyformatprotot;
                this.outputPrefixType = outputPrefixType;
            }
        }

        public KeyFactory(Class<KeyFormatProtoT> cls) {
            this.clazz = cls;
        }

        public static void readFully(InputStream inputStream, byte[] bArr) {
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                int i3 = inputStream.read(bArr, i, length - i);
                if (i3 == -1) {
                    z.l("Not enough pseudorandomness provided");
                    return;
                }
                i += i3;
            }
        }

        public abstract KeyProtoT createKey(KeyFormatProtoT keyformatprotot);

        public KeyProtoT deriveKey(KeyFormatProtoT keyformatprotot, InputStream inputStream) throws GeneralSecurityException {
            throw new GeneralSecurityException("deriveKey not implemented for key of type " + this.clazz);
        }

        public final Class<KeyFormatProtoT> getKeyFormatClass() {
            return this.clazz;
        }

        public Map<String, KeyFormat<KeyFormatProtoT>> keyFormats() {
            return Collections.EMPTY_MAP;
        }

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString);

        public abstract void validateKeyFormat(KeyFormatProtoT keyformatprotot);
    }

    @SafeVarargs
    public KeyTypeManager(Class<KeyProtoT> cls, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        this.clazz = cls;
        HashMap map = new HashMap();
        for (PrimitiveFactory<?, KeyProtoT> primitiveFactory : primitiveFactoryArr) {
            if (map.containsKey(primitiveFactory.getPrimitiveClass())) {
                f.f(primitiveFactory.getPrimitiveClass().getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                throw null;
            }
            map.put(primitiveFactory.getPrimitiveClass(), primitiveFactory);
        }
        if (primitiveFactoryArr.length > 0) {
            this.firstPrimitiveClass = primitiveFactoryArr[0].getPrimitiveClass();
        } else {
            this.firstPrimitiveClass = Void.class;
        }
        this.factories = Collections.unmodifiableMap(map);
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public final Class<?> firstSupportedPrimitiveClass() {
        return this.firstPrimitiveClass;
    }

    public final Class<KeyProtoT> getKeyClass() {
        return this.clazz;
    }

    public abstract String getKeyType();

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) {
        PrimitiveFactory<?, KeyProtoT> primitiveFactory = this.factories.get(cls);
        if (primitiveFactory != null) {
            return (P) primitiveFactory.getPrimitive(keyprotot);
        }
        od.f.m("Requested primitive class ", cls.getCanonicalName(), " not supported.");
        return null;
    }

    public abstract int getVersion();

    public KeyFactory<?, KeyProtoT> keyFactory() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract KeyData.KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString);

    public final Set<Class<?>> supportedPrimitives() {
        return this.factories.keySet();
    }

    public abstract void validateKey(KeyProtoT keyprotot);
}
