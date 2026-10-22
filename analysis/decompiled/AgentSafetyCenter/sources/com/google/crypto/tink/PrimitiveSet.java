package com.google.crypto.tink;

import b8.z;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final boolean isMutable;
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Entry<P> {

        @Nullable
        private final P fullPrimitive;
        private final byte[] identifier;
        private final Key key;
        private final int keyId;
        private final String keyType;
        private final OutputPrefixType outputPrefixType;

        @Nullable
        private final P primitive;
        private final KeyStatusType status;

        public Entry(@Nullable P p3, @Nullable P p10, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType, int i, String str, Key key) {
            this.fullPrimitive = p3;
            this.primitive = p10;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType;
            this.keyId = i;
            this.keyType = str;
            this.key = key;
        }

        @Nullable
        public P getFullPrimitive() {
            return this.fullPrimitive;
        }

        @Nullable
        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public Key getKey() {
            return this.key;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        @Nullable
        public Parameters getParameters() {
            Key key = this.key;
            if (key == null) {
                return null;
            }
            return key.getParameters();
        }

        @Nullable
        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        @Override // java.lang.Comparable
        public int compareTo(Prefix prefix) {
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = prefix.prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i = 0;
            while (true) {
                byte[] bArr3 = this.prefix;
                if (i >= bArr3.length) {
                    return 0;
                }
                byte b10 = bArr3[i];
                byte b11 = prefix.prefix[i];
                if (b10 != b11) {
                    return b10 - b11;
                }
                i++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Prefix) {
                return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitives = new ConcurrentHashMap();
        this.primitiveClass = cls;
        this.annotations = MonitoringAnnotations.EMPTY;
        this.isMutable = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <P> Entry<P> addEntryToMap(@Nullable P p3, @Nullable P p10, Keyset.Key key, ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap) {
        Integer numValueOf = Integer.valueOf(key.getKeyId());
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            numValueOf = null;
        }
        Entry<P> entry = new Entry<>(p3, p10, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId(), key.getKeyData().getTypeUrl(), MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), numValueOf), InsecureSecretKeyAccess.get()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(entry);
        Prefix prefix = new Prefix(entry.getIdentifier());
        List<Entry<P>> listPut = concurrentMap.put(prefix, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(entry);
            concurrentMap.put(prefix, Collections.unmodifiableList(arrayList2));
        }
        return entry;
    }

    public static <P> Builder<P> newBuilder(Class<P> cls) {
        return new Builder<>(cls);
    }

    @Deprecated
    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    @Deprecated
    public Entry<P> addPrimitive(P p3, Keyset.Key key) throws GeneralSecurityException {
        if (!this.isMutable) {
            f.e("addPrimitive cannot be called on an immutable primitive set");
            return null;
        }
        if (key.getStatus() == KeyStatusType.ENABLED) {
            return addEntryToMap(null, p3, key, this.primitives);
        }
        z.l("only ENABLED key is allowed");
        return null;
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    @Nullable
    public Entry<P> getPrimary() {
        return this.primary;
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = this.primitives.get(new Prefix(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public boolean hasAnnotations() {
        return !this.annotations.toMap().isEmpty();
    }

    @Deprecated
    public void setPrimary(Entry<P> entry) {
        if (!this.isMutable) {
            f.e("setPrimary cannot be called on an immutable primitive set");
            return;
        }
        if (entry == null) {
            g5.f.s("the primary entry must be non-null");
            return;
        }
        if (entry.getStatus() != KeyStatusType.ENABLED) {
            g5.f.s("the primary entry has to be ENABLED");
        } else if (getPrimitive(entry.getIdentifier()).isEmpty()) {
            g5.f.s("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            this.primary = entry;
        }
    }

    private PrimitiveSet(ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap, Entry<P> entry, MonitoringAnnotations monitoringAnnotations, Class<P> cls) {
        this.primitives = concurrentMap;
        this.primary = entry;
        this.primitiveClass = cls;
        this.annotations = monitoringAnnotations;
        this.isMutable = false;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder<P> {
        private MonitoringAnnotations annotations;
        private Entry<P> primary;
        private final Class<P> primitiveClass;
        private ConcurrentMap<Prefix, List<Entry<P>>> primitives;

        private Builder(Class<P> cls) {
            this.primitives = new ConcurrentHashMap();
            this.primitiveClass = cls;
            this.annotations = MonitoringAnnotations.EMPTY;
        }

        private Builder<P> addPrimitive(@Nullable P p3, @Nullable P p10, Keyset.Key key, boolean z10) throws GeneralSecurityException {
            if (this.primitives == null) {
                f.e("addPrimitive cannot be called after build");
                return null;
            }
            if (p3 == null && p10 == null) {
                z.l("at least one of the `fullPrimitive` or `primitive` must be set");
                return null;
            }
            if (key.getStatus() != KeyStatusType.ENABLED) {
                z.l("only ENABLED key is allowed");
                return null;
            }
            Entry<P> entryAddEntryToMap = PrimitiveSet.addEntryToMap(p3, p10, key, this.primitives);
            if (!z10) {
                return this;
            }
            if (this.primary == null) {
                this.primary = entryAddEntryToMap;
                return this;
            }
            f.e("you cannot set two primary primitives");
            return null;
        }

        public Builder<P> addFullPrimitiveAndOptionalPrimitive(@Nullable P p3, @Nullable P p10, Keyset.Key key) {
            return addPrimitive(p3, p10, key, false);
        }

        public Builder<P> addPrimaryFullPrimitiveAndOptionalPrimitive(@Nullable P p3, @Nullable P p10, Keyset.Key key) {
            return addPrimitive(p3, p10, key, true);
        }

        public Builder<P> addPrimaryPrimitive(P p3, Keyset.Key key) {
            return addPrimitive(null, p3, key, true);
        }

        public PrimitiveSet<P> build() {
            ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap = this.primitives;
            if (concurrentMap == null) {
                f.e("build cannot be called twice");
                return null;
            }
            PrimitiveSet<P> primitiveSet = new PrimitiveSet<>(concurrentMap, this.primary, this.annotations, this.primitiveClass);
            this.primitives = null;
            return primitiveSet;
        }

        public Builder<P> setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.primitives != null) {
                this.annotations = monitoringAnnotations;
                return this;
            }
            f.e("setAnnotations cannot be called after build");
            return null;
        }

        public Builder<P> addPrimitive(P p3, Keyset.Key key) {
            return addPrimitive(null, p3, key, false);
        }
    }
}
