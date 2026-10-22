package com.google.crypto.tink.internal;

import androidx.activity.b;
import b8.z;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.aead.a;
import g5.f;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PrimitiveRegistry {
    private final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
    private final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PrimitiveConstructorIndex {
        private final Class<?> keyClass;
        private final Class<?> primitiveClass;

        private PrimitiveConstructorIndex(Class<?> cls, Class<?> cls2) {
            this.keyClass = cls;
            this.primitiveClass = cls2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PrimitiveConstructorIndex)) {
                return false;
            }
            PrimitiveConstructorIndex primitiveConstructorIndex = (PrimitiveConstructorIndex) obj;
            return primitiveConstructorIndex.keyClass.equals(this.keyClass) && primitiveConstructorIndex.primitiveClass.equals(this.primitiveClass);
        }

        public int hashCode() {
            return Objects.hash(this.keyClass, this.primitiveClass);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            b.t(sb2, this.keyClass, " with primitive type: ");
            sb2.append(this.primitiveClass.getSimpleName());
            return sb2.toString();
        }
    }

    private PrimitiveRegistry(Builder builder) {
        this.primitiveConstructorMap = new HashMap(builder.primitiveConstructorMap);
        this.primitiveWrapperMap = new HashMap(builder.primitiveWrapperMap);
    }

    public Class<?> getInputPrimitiveClass(Class<?> cls) throws GeneralSecurityException {
        if (this.primitiveWrapperMap.containsKey(cls)) {
            return this.primitiveWrapperMap.get(cls).getInputPrimitiveClass();
        }
        a.a("No input primitive class for ", cls, " available");
        return null;
    }

    public <KeyT extends Key, PrimitiveT> PrimitiveT getPrimitive(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        PrimitiveConstructorIndex primitiveConstructorIndex = new PrimitiveConstructorIndex(keyt.getClass(), cls);
        if (this.primitiveConstructorMap.containsKey(primitiveConstructorIndex)) {
            return (PrimitiveT) this.primitiveConstructorMap.get(primitiveConstructorIndex).constructPrimitive(keyt);
        }
        a.a("No PrimitiveConstructor for ", primitiveConstructorIndex, " available");
        return null;
    }

    public <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT wrap(PrimitiveSet<InputPrimitiveT> primitiveSet, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        if (!this.primitiveWrapperMap.containsKey(cls)) {
            z.k(cls, "No wrapper found for ");
            return null;
        }
        PrimitiveWrapper<?, ?> primitiveWrapper = this.primitiveWrapperMap.get(cls);
        if (primitiveSet.getPrimitiveClass().equals(primitiveWrapper.getInputPrimitiveClass()) && primitiveWrapper.getInputPrimitiveClass().equals(primitiveSet.getPrimitiveClass())) {
            return (WrapperPrimitiveT) primitiveWrapper.wrap(primitiveSet);
        }
        z.l("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
        private final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

        public Builder(PrimitiveRegistry primitiveRegistry) {
            this.primitiveConstructorMap = new HashMap(primitiveRegistry.primitiveConstructorMap);
            this.primitiveWrapperMap = new HashMap(primitiveRegistry.primitiveWrapperMap);
        }

        public PrimitiveRegistry build() {
            return new PrimitiveRegistry(this);
        }

        public <KeyT extends Key, PrimitiveT> Builder registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> primitiveConstructor) throws GeneralSecurityException {
            if (primitiveConstructor == null) {
                f.g("primitive constructor must be non-null");
                return null;
            }
            PrimitiveConstructorIndex primitiveConstructorIndex = new PrimitiveConstructorIndex(primitiveConstructor.getKeyClass(), primitiveConstructor.getPrimitiveClass());
            boolean zContainsKey = this.primitiveConstructorMap.containsKey(primitiveConstructorIndex);
            Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> map = this.primitiveConstructorMap;
            if (!zContainsKey) {
                map.put(primitiveConstructorIndex, primitiveConstructor);
                return this;
            }
            PrimitiveConstructor<?, ?> primitiveConstructor2 = map.get(primitiveConstructorIndex);
            if (primitiveConstructor2.equals(primitiveConstructor) && primitiveConstructor.equals(primitiveConstructor2)) {
                return this;
            }
            z.k(primitiveConstructorIndex, "Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ");
            return null;
        }

        public <InputPrimitiveT, WrapperPrimitiveT> Builder registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> primitiveWrapper) throws GeneralSecurityException {
            if (primitiveWrapper == null) {
                f.g("wrapper must be non-null");
                return null;
            }
            Class<WrapperPrimitiveT> primitiveClass = primitiveWrapper.getPrimitiveClass();
            boolean zContainsKey = this.primitiveWrapperMap.containsKey(primitiveClass);
            Map<Class<?>, PrimitiveWrapper<?, ?>> map = this.primitiveWrapperMap;
            if (!zContainsKey) {
                map.put(primitiveClass, primitiveWrapper);
                return this;
            }
            PrimitiveWrapper<?, ?> primitiveWrapper2 = map.get(primitiveClass);
            if (primitiveWrapper2.equals(primitiveWrapper) && primitiveWrapper.equals(primitiveWrapper2)) {
                return this;
            }
            z.k(primitiveClass, "Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type");
            return null;
        }

        public Builder() {
            this.primitiveConstructorMap = new HashMap();
            this.primitiveWrapperMap = new HashMap();
        }
    }
}
