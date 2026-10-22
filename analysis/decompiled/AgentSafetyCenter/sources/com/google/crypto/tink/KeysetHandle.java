package com.google.crypto.tink;

import androidx.activity.b;
import b8.z;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.InternalKeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import k0.a;
import od.f;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KeysetHandle {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;
    private final Keyset keyset;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.KeysetHandle$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private KeysetHandle(Keyset keyset, List<Entry> list) {
        this.keyset = keyset;
        this.entries = list;
        this.annotations = MonitoringAnnotations.EMPTY;
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            z.l("empty keyset");
        }
    }

    private static void assertEnoughKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        if (keyset == null || keyset.getKeyCount() <= 0) {
            z.l("empty keyset");
        }
    }

    private static void assertNoSecretKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(b.j("keyset contains key material of type ", key.getKeyData().getKeyMaterialType().name(), " for type url ", key.getKeyData().getTypeUrl()));
            }
        }
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) {
        KeysetManager keysetManagerAdd = KeysetManager.withEmptyKeyset().add(keyHandle);
        keysetManagerAdd.setPrimary(keysetManagerAdd.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return keysetManagerAdd.getKeysetHandle();
    }

    private static KeyData createPublicKeyData(KeyData keyData) throws GeneralSecurityException {
        if (keyData.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            z.l("The keyset contains a non-private key");
            return null;
        }
        KeyData publicKeyData = Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
        validate(publicKeyData);
        return publicKeyData;
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead, byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset from = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), bArr), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(from);
            return from;
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset, corrupted key material");
            return null;
        }
    }

    private static EncryptedKeyset encrypt(Keyset keyset, Aead aead, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrEncrypt = aead.encrypt(keyset.toByteArray(), bArr);
        try {
            if (Keyset.parseFrom(aead.decrypt(bArrEncrypt, bArr), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset)) {
                return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrEncrypt)).setKeysetInfo(Util.getKeysetInfo(keyset)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset, corrupted key material");
            return null;
        }
    }

    private Entry entryByIndex(int i) {
        if (this.entries.get(i) != null) {
            return this.entries.get(i);
        }
        f.e("Keyset-Entry at position i has wrong status or key parsing failed");
        return null;
    }

    public static final KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset));
    }

    public static final KeysetHandle fromKeysetAndAnnotations(Keyset keyset, MonitoringAnnotations monitoringAnnotations) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset), monitoringAnnotations);
    }

    public static Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new Builder.Entry(parameters, (AnonymousClass1) null);
    }

    public static Builder.Entry generateEntryFromParametersName(String str) throws GeneralSecurityException {
        if (!Registry.keyTemplateMap().containsKey(str)) {
            throw new GeneralSecurityException(c.b("cannot find key template: ", str));
        }
        return new Builder.Entry(MutableSerializationRegistry.globalInstance().parseParametersWithLegacyFallback(ProtoParametersSerialization.create(Registry.keyTemplateMap().get(str).getProto())), (AnonymousClass1) null);
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.create(keyTemplate.getProto()))).makePrimary().withRandomId()).build();
    }

    private static List<Entry> getEntriesFromKeyset(Keyset keyset) {
        ArrayList arrayList = new ArrayList(keyset.getKeyCount());
        for (Keyset.Key key : keyset.getKeyList()) {
            int keyId = key.getKeyId();
            try {
                arrayList.add(new Entry(MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(toProtoKeySerialization(key), InsecureSecretKeyAccess.get()), parseStatus(key.getStatus()), keyId, keyId == keyset.getPrimaryKeyId(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private <B> B getFullPrimitiveOrNull(Key key, Class<B> cls) {
        try {
            return (B) Registry.getFullPrimitive(key, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Nullable
    private static <B> B getLegacyPrimitiveOrNull(Keyset.Key key, Class<B> cls) throws GeneralSecurityException {
        try {
            return (B) Registry.getPrimitive(key.getKeyData(), cls);
        } catch (GeneralSecurityException e10) {
            if (e10.getMessage().contains("No key manager found for key type ") || e10.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        Util.validateKeyset(this.keyset);
        PrimitiveSet.Builder builderNewBuilder = PrimitiveSet.newBuilder(cls2);
        builderNewBuilder.setAnnotations(this.annotations);
        for (int i = 0; i < size(); i++) {
            Keyset.Key key = this.keyset.getKey(i);
            if (key.getStatus().equals(KeyStatusType.ENABLED)) {
                Object legacyPrimitiveOrNull = getLegacyPrimitiveOrNull(key, cls2);
                Object fullPrimitiveOrNull = this.entries.get(i) != null ? getFullPrimitiveOrNull(this.entries.get(i).getKey(), cls2) : null;
                if (key.getKeyId() == this.keyset.getPrimaryKeyId()) {
                    builderNewBuilder.addPrimaryFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, key);
                } else {
                    builderNewBuilder.addFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, key);
                }
            }
        }
        return (P) Registry.wrap(builderNewBuilder.build(), cls);
    }

    public static Builder.Entry importKey(Key key) {
        Builder.Entry entry = new Builder.Entry(key, (AnonymousClass1) null);
        Integer idRequirementOrNull = key.getIdRequirementOrNull();
        if (idRequirementOrNull != null) {
            entry.withFixedId(idRequirementOrNull.intValue());
        }
        return entry;
    }

    public static Builder newBuilder(KeysetHandle keysetHandle) {
        Builder builder = new Builder();
        for (int i = 0; i < keysetHandle.size(); i++) {
            Entry entryEntryByIndex = keysetHandle.entryByIndex(i);
            Builder.Entry entryWithFixedId = importKey(entryEntryByIndex.getKey()).withFixedId(entryEntryByIndex.getId());
            entryWithFixedId.setStatus(entryEntryByIndex.getStatus());
            if (entryEntryByIndex.isPrimary()) {
                entryWithFixedId.makePrimary();
            }
            builder.addEntry(entryWithFixedId);
        }
        return builder;
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatus.ENABLED;
        }
        if (i == 2) {
            return KeyStatus.DISABLED;
        }
        if (i == 3) {
            return KeyStatus.DESTROYED;
        }
        z.l("Unknown key status");
        return null;
    }

    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) {
        return readWithAssociatedData(keysetReader, aead, new byte[0]);
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset from = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(from);
            return fromKeyset(from);
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset");
            return null;
        }
    }

    public static final KeysetHandle readWithAssociatedData(KeysetReader keysetReader, Aead aead, byte[] bArr) throws GeneralSecurityException {
        EncryptedKeyset encrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(encrypted);
        return fromKeyset(decrypt(encrypted, aead, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyStatusType serializeStatus(KeyStatus keyStatus) {
        if (KeyStatus.ENABLED.equals(keyStatus)) {
            return KeyStatusType.ENABLED;
        }
        if (KeyStatus.DISABLED.equals(keyStatus)) {
            return KeyStatusType.DISABLED;
        }
        if (KeyStatus.DESTROYED.equals(keyStatus)) {
            return KeyStatusType.DESTROYED;
        }
        f.e("Unknown key status");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Keyset.Key toKeysetKey(int i, KeyStatusType keyStatusType, ProtoKeySerialization protoKeySerialization) {
        return Keyset.Key.newBuilder().setKeyData(KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(keyStatusType).setKeyId(i).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).build();
    }

    private static ProtoKeySerialization toProtoKeySerialization(Keyset.Key key) {
        try {
            return ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), key.getOutputPrefixType() == OutputPrefixType.RAW ? null : Integer.valueOf(key.getKeyId()));
        } catch (GeneralSecurityException e10) {
            throw new TinkBugException("Creating a protokey serialization failed", e10);
        }
    }

    private static void validate(KeyData keyData) {
        Registry.getPrimitive(keyData);
    }

    public Entry getAt(int i) {
        if (i >= 0 && i < size()) {
            return entryByIndex(i);
        }
        z.i(size(), a.t(i, "Invalid index ", " for keyset of size "));
        return null;
    }

    @Deprecated
    public List<KeyHandle> getKeys() {
        ArrayList arrayList = new ArrayList();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            arrayList.add(new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public Entry getPrimary() {
        for (int i = 0; i < this.keyset.getKeyCount(); i++) {
            if (this.keyset.getKey(i).getKeyId() == this.keyset.getPrimaryKeyId()) {
                Entry entryEntryByIndex = entryByIndex(i);
                if (entryEntryByIndex.getStatus() == KeyStatus.ENABLED) {
                    return entryEntryByIndex;
                }
                f.e("Keyset has primary which isn't enabled");
                return null;
            }
        }
        f.e("Keyset has no primary");
        return null;
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive != null) {
            return (P) getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset == null) {
            z.l("cleartext keyset is not available");
            return null;
        }
        Keyset.Builder builderNewBuilder = Keyset.newBuilder();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            builderNewBuilder.addKey(key.toBuilder().setKeyData(createPublicKeyData(key.getKeyData())).build());
        }
        builderNewBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
        return fromKeyset(builderNewBuilder.build());
    }

    @Deprecated
    public KeyHandle primaryKey() throws GeneralSecurityException {
        int primaryKeyId = this.keyset.getPrimaryKeyId();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            if (key.getKeyId() == primaryKeyId) {
                return new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId());
            }
        }
        z.l("No primary key found in keyset.");
        return null;
    }

    public int size() {
        return this.keyset.getKeyCount();
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    public void write(KeysetWriter keysetWriter, Aead aead) {
        writeWithAssociatedData(keysetWriter, aead, new byte[0]);
    }

    public void writeNoSecret(KeysetWriter keysetWriter) throws GeneralSecurityException {
        assertNoSecretKeyMaterial(this.keyset);
        keysetWriter.write(this.keyset);
    }

    public void writeWithAssociatedData(KeysetWriter keysetWriter, Aead aead, byte[] bArr) {
        keysetWriter.write(encrypt(this.keyset, aead, bArr));
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private final List<Entry> entries = new ArrayList();

        private static void checkIdAssignments(List<Entry> list) throws GeneralSecurityException {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).strategy == KeyIdStrategy.RANDOM_ID && list.get(i + 1).strategy != KeyIdStrategy.RANDOM_ID) {
                    z.l("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimary() {
            Iterator<Entry> it = this.entries.iterator();
            while (it.hasNext()) {
                it.next().isPrimary = false;
            }
        }

        private static Keyset.Key createKeyFromParameters(Parameters parameters, int i, KeyStatusType keyStatusType) {
            ProtoParametersSerialization serialization = parameters instanceof LegacyProtoParameters ? ((LegacyProtoParameters) parameters).getSerialization() : (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(parameters, ProtoParametersSerialization.class);
            return Keyset.Key.newBuilder().setKeyId(i).setStatus(keyStatusType).setKeyData(Registry.newKeyData(serialization.getKeyTemplate())).setOutputPrefixType(serialization.getKeyTemplate().getOutputPrefixType()).build();
        }

        private static Keyset.Key createKeysetKeyFromBuilderEntry(Entry entry, int i) throws GeneralSecurityException {
            if (entry.key == null) {
                return createKeyFromParameters(entry.parameters, i, KeysetHandle.serializeStatus(entry.getStatus()));
            }
            ProtoKeySerialization serialization = entry.key instanceof LegacyProtoKey ? ((LegacyProtoKey) entry.key).getSerialization(InsecureSecretKeyAccess.get()) : (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(entry.key, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
            Integer idRequirementOrNull = serialization.getIdRequirementOrNull();
            if (idRequirementOrNull == null || idRequirementOrNull.intValue() == i) {
                return KeysetHandle.toKeysetKey(i, KeysetHandle.serializeStatus(entry.getStatus()), serialization);
            }
            z.l("Wrong ID set for key with ID requirement");
            return null;
        }

        private static int getNextIdFromBuilderEntry(Entry entry, Set<Integer> set) throws GeneralSecurityException {
            if (entry.strategy != null) {
                return entry.strategy == KeyIdStrategy.RANDOM_ID ? randomIdNotInSet(set) : entry.strategy.getFixedId();
            }
            z.l("No ID was set (with withFixedId or withRandomId)");
            return 0;
        }

        private static int randomIdNotInSet(Set<Integer> set) {
            int iRandKeyId = 0;
            while (true) {
                if (iRandKeyId != 0 && !set.contains(Integer.valueOf(iRandKeyId))) {
                    return iRandKeyId;
                }
                iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
            }
        }

        public Builder addEntry(Entry entry) {
            if (entry.builder != null) {
                f.e("Entry has already been added to a KeysetHandle.Builder");
                return null;
            }
            if (entry.isPrimary) {
                clearPrimary();
            }
            entry.builder = this;
            this.entries.add(entry);
            return this;
        }

        public KeysetHandle build() throws GeneralSecurityException {
            Keyset.Builder builderNewBuilder = Keyset.newBuilder();
            checkIdAssignments(this.entries);
            HashSet hashSet = new HashSet();
            Integer numValueOf = null;
            for (Entry entry : this.entries) {
                if (entry.keyStatus == null) {
                    z.l("Key Status not set.");
                    return null;
                }
                int nextIdFromBuilderEntry = getNextIdFromBuilderEntry(entry, hashSet);
                if (hashSet.contains(Integer.valueOf(nextIdFromBuilderEntry))) {
                    throw new GeneralSecurityException(a.k(nextIdFromBuilderEntry, "Id ", " is used twice in the keyset"));
                }
                hashSet.add(Integer.valueOf(nextIdFromBuilderEntry));
                builderNewBuilder.addKey(createKeysetKeyFromBuilderEntry(entry, nextIdFromBuilderEntry));
                if (entry.isPrimary) {
                    if (numValueOf != null) {
                        z.l("Two primaries were set");
                        return null;
                    }
                    numValueOf = Integer.valueOf(nextIdFromBuilderEntry);
                }
            }
            if (numValueOf != null) {
                builderNewBuilder.setPrimaryKeyId(numValueOf.intValue());
                return KeysetHandle.fromKeyset(builderNewBuilder.build());
            }
            z.l("No primary was set");
            return null;
        }

        public Builder deleteAt(int i) {
            this.entries.remove(i);
            return this;
        }

        public Entry getAt(int i) {
            return this.entries.get(i);
        }

        @Deprecated
        public Entry removeAt(int i) {
            return this.entries.remove(i);
        }

        public int size() {
            return this.entries.size();
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class KeyIdStrategy {
            private static final KeyIdStrategy RANDOM_ID = new KeyIdStrategy();
            private final int fixedId;

            private KeyIdStrategy() {
                this.fixedId = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy fixedId(int i) {
                return new KeyIdStrategy(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getFixedId() {
                return this.fixedId;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }

            private KeyIdStrategy(int i) {
                this.fixedId = i;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class Entry {

            @Nullable
            private Builder builder;
            private boolean isPrimary;

            @Nullable
            private final Key key;
            private KeyStatus keyStatus;

            @Nullable
            private final Parameters parameters;
            private KeyIdStrategy strategy;

            private Entry(Key key) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = key;
                this.parameters = null;
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry makePrimary() {
                Builder builder = this.builder;
                if (builder != null) {
                    builder.clearPrimary();
                }
                this.isPrimary = true;
                return this;
            }

            public Entry setStatus(KeyStatus keyStatus) {
                this.keyStatus = keyStatus;
                return this;
            }

            public Entry withFixedId(int i) {
                this.strategy = KeyIdStrategy.fixedId(i);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.randomId();
                return this;
            }

            public /* synthetic */ Entry(Parameters parameters, AnonymousClass1 anonymousClass1) {
                this(parameters);
            }

            public /* synthetic */ Entry(Key key, AnonymousClass1 anonymousClass1) {
                this(key);
            }

            private Entry(Parameters parameters) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = null;
                this.parameters = parameters;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Alpha
    public static final class Entry {

        /* renamed from: id, reason: collision with root package name */
        private final int f2465id;
        private final boolean isPrimary;
        private final Key key;
        private final KeyStatus keyStatus;

        private Entry(Key key, KeyStatus keyStatus, int i, boolean z10) {
            this.key = key;
            this.keyStatus = keyStatus;
            this.f2465id = i;
            this.isPrimary = z10;
        }

        public int getId() {
            return this.f2465id;
        }

        public Key getKey() {
            return this.key;
        }

        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        public boolean isPrimary() {
            return this.isPrimary;
        }

        public /* synthetic */ Entry(Key key, KeyStatus keyStatus, int i, boolean z10, AnonymousClass1 anonymousClass1) {
            this(key, keyStatus, i, z10);
        }
    }

    private KeysetHandle(Keyset keyset, List<Entry> list, MonitoringAnnotations monitoringAnnotations) {
        this.keyset = keyset;
        this.entries = list;
        this.annotations = monitoringAnnotations;
    }

    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) throws GeneralSecurityException {
        try {
            Keyset keyset = keysetReader.read();
            assertNoSecretKeyMaterial(keyset);
            return fromKeyset(keyset);
        } catch (InvalidProtocolBufferException unused) {
            z.l("invalid keyset");
            return null;
        }
    }

    @Deprecated
    public static final KeysetHandle generateNew(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.create(keyTemplate))).makePrimary().withRandomId()).build();
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
