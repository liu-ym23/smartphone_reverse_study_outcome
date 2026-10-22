package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SetSchemaRequest {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int ENTERPRISE_ACCESS = 7;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int EXECUTE_APP_FUNCTIONS = 9;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int EXECUTE_APP_FUNCTIONS_TRUSTED = 10;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int MANAGED_PROFILE_CONTACTS_ACCESS = 8;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int PACKAGE_USAGE_STATS = 11;
    public static final int READ_ASSISTANT_APP_SEARCH_DATA = 6;
    public static final int READ_CALENDAR = 2;
    public static final int READ_CONTACTS = 3;
    public static final int READ_EXTERNAL_STORAGE = 4;
    public static final int READ_HOME_APP_SEARCH_DATA = 5;
    public static final int READ_SMS = 1;
    private final boolean mForceOverride;
    private final Map<String, Migrator> mMigrators;
    private final Map<String, PackageIdentifier> mPubliclyVisibleSchemas;
    private final Set<AppSearchSchema> mSchemas;
    private final Set<String> mSchemasNotDisplayedBySystem;
    private final Map<String, Set<SchemaVisibilityConfig>> mSchemasVisibleToConfigs;
    private final Map<String, Set<PackageIdentifier>> mSchemasVisibleToPackages;
    private final Map<String, Set<Set<Integer>>> mSchemasVisibleToPermissions;
    private final int mVersion;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AppSearchSupportedPermission {
    }

    public SetSchemaRequest(@NonNull Set<AppSearchSchema> set, @NonNull Set<String> set2, @NonNull Map<String, Set<PackageIdentifier>> map, @NonNull Map<String, Set<Set<Integer>>> map2, @NonNull Map<String, PackageIdentifier> map3, @NonNull Map<String, Set<SchemaVisibilityConfig>> map4, @NonNull Map<String, Migrator> map5, boolean z10, int i) {
        this.mSchemas = (Set) Preconditions.checkNotNull(set);
        this.mSchemasNotDisplayedBySystem = (Set) Preconditions.checkNotNull(set2);
        this.mSchemasVisibleToPackages = (Map) Preconditions.checkNotNull(map);
        this.mSchemasVisibleToPermissions = (Map) Preconditions.checkNotNull(map2);
        this.mPubliclyVisibleSchemas = (Map) Preconditions.checkNotNull(map3);
        this.mSchemasVisibleToConfigs = (Map) Preconditions.checkNotNull(map4);
        this.mMigrators = (Map) Preconditions.checkNotNull(map5);
        this.mForceOverride = z10;
        this.mVersion = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayMap<String, Set<Set<Integer>>> deepCopy(@NonNull Map<String, Set<Set<Integer>>> map) {
        ArrayMap<String, Set<Set<Integer>>> arrayMap = new ArrayMap<>(map.size());
        for (Map.Entry<String, Set<Set<Integer>>> entry : map.entrySet()) {
            ArraySet arraySet = new ArraySet();
            Iterator<Set<Integer>> it = entry.getValue().iterator();
            while (it.hasNext()) {
                arraySet.add(new ArraySet(it.next()));
            }
            arrayMap.put(entry.getKey(), arraySet);
        }
        return arrayMap;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetSchemaRequest)) {
            return false;
        }
        SetSchemaRequest setSchemaRequest = (SetSchemaRequest) obj;
        return this.mSchemas.equals(setSchemaRequest.mSchemas) && this.mSchemasNotDisplayedBySystem.equals(setSchemaRequest.mSchemasNotDisplayedBySystem) && this.mSchemasVisibleToPackages.equals(setSchemaRequest.mSchemasVisibleToPackages) && this.mSchemasVisibleToPermissions.equals(setSchemaRequest.mSchemasVisibleToPermissions) && this.mPubliclyVisibleSchemas.equals(setSchemaRequest.mPubliclyVisibleSchemas) && this.mSchemasVisibleToConfigs.equals(setSchemaRequest.mSchemasVisibleToConfigs) && this.mMigrators.equals(setSchemaRequest.mMigrators) && this.mForceOverride == setSchemaRequest.mForceOverride && this.mVersion == setSchemaRequest.mVersion;
    }

    @NonNull
    public Map<String, Migrator> getMigrators() {
        return Collections.unmodifiableMap(this.mMigrators);
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA)
    public Map<String, PackageIdentifier> getPubliclyVisibleSchemas() {
        return Collections.unmodifiableMap(this.mPubliclyVisibleSchemas);
    }

    @NonNull
    @SuppressLint({"RequiresPermission"})
    public Map<String, Set<Set<Integer>>> getRequiredPermissionsForSchemaTypeVisibility() {
        return deepCopy(this.mSchemasVisibleToPermissions);
    }

    @NonNull
    public Set<AppSearchSchema> getSchemas() {
        return Collections.unmodifiableSet(this.mSchemas);
    }

    @NonNull
    public Set<String> getSchemasNotDisplayedBySystem() {
        return Collections.unmodifiableSet(this.mSchemasNotDisplayedBySystem);
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
    public Map<String, Set<SchemaVisibilityConfig>> getSchemasVisibleToConfigs() {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, Set<SchemaVisibilityConfig>> entry : this.mSchemasVisibleToConfigs.entrySet()) {
            arrayMap.put(entry.getKey(), new ArraySet(entry.getValue()));
        }
        return arrayMap;
    }

    @NonNull
    public Map<String, Set<PackageIdentifier>> getSchemasVisibleToPackages() {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, Set<PackageIdentifier>> entry : this.mSchemasVisibleToPackages.entrySet()) {
            arrayMap.put(entry.getKey(), new ArraySet(entry.getValue()));
        }
        return arrayMap;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<String, Set<PackageIdentifier>> getSchemasVisibleToPackagesInternal() {
        return this.mSchemasVisibleToPackages;
    }

    @IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID)
    public int getVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mSchemas, this.mSchemasNotDisplayedBySystem, this.mSchemasVisibleToPackages, this.mSchemasVisibleToPermissions, this.mPubliclyVisibleSchemas, this.mSchemasVisibleToConfigs, this.mMigrators, Boolean.valueOf(this.mForceOverride), Integer.valueOf(this.mVersion));
    }

    public boolean isForceOverride() {
        return this.mForceOverride;
    }

    public static final class Builder {
        private static final int DEFAULT_VERSION = 1;
        private boolean mBuilt;
        private boolean mForceOverride;
        private ArrayMap<String, Migrator> mMigrators;
        private ArrayMap<String, PackageIdentifier> mPubliclyVisibleSchemas;
        private ArrayMap<String, Set<SchemaVisibilityConfig>> mSchemaVisibleToConfigs;
        private ArraySet<AppSearchSchema> mSchemas;
        private ArraySet<String> mSchemasNotDisplayedBySystem;
        private ArrayMap<String, Set<PackageIdentifier>> mSchemasVisibleToPackages;
        private ArrayMap<String, Set<Set<Integer>>> mSchemasVisibleToPermissions;
        private int mVersion;

        public Builder() {
            this.mSchemas = new ArraySet<>();
            this.mSchemasNotDisplayedBySystem = new ArraySet<>();
            this.mSchemasVisibleToPackages = new ArrayMap<>();
            this.mSchemasVisibleToPermissions = new ArrayMap<>();
            this.mPubliclyVisibleSchemas = new ArrayMap<>();
            this.mSchemaVisibleToConfigs = new ArrayMap<>();
            this.mMigrators = new ArrayMap<>();
            this.mForceOverride = false;
            this.mVersion = 1;
            this.mBuilt = false;
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                ArrayMap<String, Set<PackageIdentifier>> arrayMap = new ArrayMap<>(this.mSchemasVisibleToPackages.getSize());
                for (Map.Entry<String, Set<PackageIdentifier>> entry : this.mSchemasVisibleToPackages.entrySet()) {
                    arrayMap.put(entry.getKey(), new ArraySet(entry.getValue()));
                }
                this.mSchemasVisibleToPackages = arrayMap;
                this.mPubliclyVisibleSchemas = new ArrayMap<>(this.mPubliclyVisibleSchemas);
                this.mSchemasVisibleToPermissions = SetSchemaRequest.deepCopy(this.mSchemasVisibleToPermissions);
                ArrayMap<String, Set<SchemaVisibilityConfig>> arrayMap2 = new ArrayMap<>(this.mSchemaVisibleToConfigs.getSize());
                for (Map.Entry<String, Set<SchemaVisibilityConfig>> entry2 : this.mSchemaVisibleToConfigs.entrySet()) {
                    arrayMap2.put(entry2.getKey(), new ArraySet(entry2.getValue()));
                }
                this.mSchemaVisibleToConfigs = arrayMap2;
                this.mSchemas = new ArraySet<>((ArraySet) this.mSchemas);
                this.mSchemasNotDisplayedBySystem = new ArraySet<>((ArraySet) this.mSchemasNotDisplayedBySystem);
                this.mMigrators = new ArrayMap<>(this.mMigrators);
                this.mBuilt = false;
            }
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addDocumentClassVisibleToConfig(@NonNull Class<?> cls, @NonNull SchemaVisibilityConfig schemaVisibilityConfig) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return addSchemaTypeVisibleToConfig(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), schemaVisibilityConfig);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addDocumentClasses(@NonNull Class<?>... clsArr) throws AppSearchException {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addDocumentClasses(Arrays.asList(clsArr));
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addRequiredPermissionsForDocumentClassVisibility(@NonNull Class<?> cls, @NonNull Set<Integer> set) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return addRequiredPermissionsForSchemaTypeVisibility(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), set);
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder", "RequiresPermission"})
        public Builder addRequiredPermissionsForSchemaTypeVisibility(@NonNull String str, @NonNull Set<Integer> set) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(set);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgumentInRange(it.next().intValue(), 1, 11, "permission");
            }
            resetIfBuilt();
            Set<Set<Integer>> arraySet = this.mSchemasVisibleToPermissions.get(str);
            if (arraySet == null) {
                arraySet = new ArraySet<>();
                this.mSchemasVisibleToPermissions.put(str, arraySet);
            }
            arraySet.add(set);
            return this;
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addSchemaTypeVisibleToConfig(@NonNull String str, @NonNull SchemaVisibilityConfig schemaVisibilityConfig) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(schemaVisibilityConfig);
            resetIfBuilt();
            Set<SchemaVisibilityConfig> arraySet = this.mSchemaVisibleToConfigs.get(str);
            if (arraySet == null) {
                arraySet = new ArraySet<>();
                this.mSchemaVisibleToConfigs.put(str, arraySet);
            }
            arraySet.add(schemaVisibilityConfig);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addSchemas(@NonNull AppSearchSchema... appSearchSchemaArr) {
            Preconditions.checkNotNull(appSearchSchemaArr);
            resetIfBuilt();
            return addSchemas(Arrays.asList(appSearchSchemaArr));
        }

        @NonNull
        public SetSchemaRequest build() {
            ArraySet arraySet = new ArraySet((ArraySet) this.mSchemasNotDisplayedBySystem);
            arraySet.addAll(this.mSchemasVisibleToPackages.keySet());
            arraySet.addAll(this.mSchemasVisibleToPermissions.keySet());
            arraySet.addAll(this.mPubliclyVisibleSchemas.keySet());
            arraySet.addAll(this.mSchemaVisibleToConfigs.keySet());
            Iterator<AppSearchSchema> it = this.mSchemas.iterator();
            while (it.hasNext()) {
                arraySet.remove(it.next().getSchemaType());
            }
            if (!arraySet.isEmpty()) {
                throw new IllegalArgumentException("Schema types " + arraySet + " referenced, but were not added.");
            }
            if (this.mSchemas.isEmpty() && this.mVersion != 1) {
                throw new IllegalArgumentException("Cannot set version to the request if schema is empty.");
            }
            this.mBuilt = true;
            return new SetSchemaRequest(this.mSchemas, this.mSchemasNotDisplayedBySystem, this.mSchemasVisibleToPackages, this.mSchemasVisibleToPermissions, this.mPubliclyVisibleSchemas, this.mSchemaVisibleToConfigs, this.mMigrators, this.mForceOverride, this.mVersion);
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
        public Builder clearDocumentClassVisibleToConfigs(@NonNull Class<?> cls) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return clearSchemaTypeVisibleToConfigs(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName());
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearMigrators() {
            resetIfBuilt();
            this.mMigrators.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder clearRequiredPermissionsForDocumentClassVisibility(@NonNull Class<?> cls) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return clearRequiredPermissionsForSchemaTypeVisibility(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName());
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder clearRequiredPermissionsForSchemaTypeVisibility(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mSchemasVisibleToPermissions.remove(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
        public Builder clearSchemaTypeVisibleToConfigs(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mSchemaVisibleToConfigs.remove(str);
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSchemas() {
            resetIfBuilt();
            this.mSchemas.clear();
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setDocumentClassDisplayedBySystem(@NonNull Class<?> cls, boolean z10) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return setSchemaTypeDisplayedBySystem(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), z10);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setDocumentClassVisibilityForPackage(@NonNull Class<?> cls, boolean z10, @NonNull PackageIdentifier packageIdentifier) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return setSchemaTypeVisibilityForPackage(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), z10, packageIdentifier);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setForceOverride(boolean z10) {
            resetIfBuilt();
            this.mForceOverride = z10;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setMigrator(@NonNull String str, @NonNull Migrator migrator) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(migrator);
            resetIfBuilt();
            this.mMigrators.put(str, migrator);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setMigrators(@NonNull Map<String, Migrator> map) {
            Preconditions.checkNotNull(map);
            resetIfBuilt();
            this.mMigrators.putAll(map);
            return this;
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleDocumentClass(@NonNull Class<?> cls, @Nullable PackageIdentifier packageIdentifier) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return setPubliclyVisibleSchema(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), packageIdentifier);
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleSchema(@NonNull String str, @Nullable PackageIdentifier packageIdentifier) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            if (packageIdentifier == null || packageIdentifier.getPackageName().isEmpty()) {
                this.mPubliclyVisibleSchemas.remove(str);
                return this;
            }
            this.mPubliclyVisibleSchemas.put(str, packageIdentifier);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSchemaTypeDisplayedBySystem(@NonNull String str, boolean z10) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            if (z10) {
                this.mSchemasNotDisplayedBySystem.remove(str);
                return this;
            }
            this.mSchemasNotDisplayedBySystem.add(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSchemaTypeVisibilityForPackage(@NonNull String str, boolean z10, @NonNull PackageIdentifier packageIdentifier) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(packageIdentifier);
            resetIfBuilt();
            Set<PackageIdentifier> arraySet = this.mSchemasVisibleToPackages.get(str);
            if (z10) {
                if (arraySet == null) {
                    arraySet = new ArraySet<>();
                }
                arraySet.add(packageIdentifier);
                this.mSchemasVisibleToPackages.put(str, arraySet);
                return this;
            }
            if (arraySet != null) {
                arraySet.remove(packageIdentifier);
                if (arraySet.isEmpty()) {
                    this.mSchemasVisibleToPackages.remove(str);
                }
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setVersion(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int i) {
            Preconditions.checkArgument(i >= 1, "Version must be a positive number.");
            resetIfBuilt();
            this.mVersion = i;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addDocumentClasses(@NonNull Collection<? extends Class<?>> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            DocumentClassFactoryRegistry documentClassFactoryRegistry = DocumentClassFactoryRegistry.getInstance();
            ArrayList arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            for (int i = 0; i < arrayList.size(); i++) {
                for (Class<?> cls : documentClassFactoryRegistry.getOrCreateFactory((Class) arrayList.get(i)).getDependencyDocumentClasses()) {
                    if (!arrayList.contains(cls)) {
                        arrayList.add(cls);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(documentClassFactoryRegistry.getOrCreateFactory((Class) it.next()).getSchema());
            }
            return addSchemas(arrayList2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addSchemas(@NonNull Collection<AppSearchSchema> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mSchemas.addAll(collection);
            return this;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(@NonNull SetSchemaRequest setSchemaRequest) {
            this.mSchemas = new ArraySet<>();
            this.mSchemasNotDisplayedBySystem = new ArraySet<>();
            this.mSchemasVisibleToPackages = new ArrayMap<>();
            this.mSchemasVisibleToPermissions = new ArrayMap<>();
            this.mPubliclyVisibleSchemas = new ArrayMap<>();
            this.mSchemaVisibleToConfigs = new ArrayMap<>();
            this.mMigrators = new ArrayMap<>();
            this.mForceOverride = false;
            this.mVersion = 1;
            this.mBuilt = false;
            this.mSchemas.addAll(setSchemaRequest.mSchemas);
            this.mSchemasNotDisplayedBySystem.addAll(setSchemaRequest.mSchemasNotDisplayedBySystem);
            for (Map.Entry entry : setSchemaRequest.mSchemasVisibleToPackages.entrySet()) {
                this.mSchemasVisibleToPackages.put((String) entry.getKey(), new ArraySet((Collection) entry.getValue()));
            }
            this.mSchemasVisibleToPermissions = SetSchemaRequest.deepCopy(setSchemaRequest.mSchemasVisibleToPermissions);
            this.mPubliclyVisibleSchemas.putAll(setSchemaRequest.mPubliclyVisibleSchemas);
            for (Map.Entry entry2 : setSchemaRequest.mSchemasVisibleToConfigs.entrySet()) {
                this.mSchemaVisibleToConfigs.put((String) entry2.getKey(), new ArraySet((Collection) entry2.getValue()));
            }
            this.mMigrators.putAll(setSchemaRequest.mMigrators);
            this.mForceOverride = setSchemaRequest.mForceOverride;
            this.mVersion = setSchemaRequest.mVersion;
        }
    }
}
