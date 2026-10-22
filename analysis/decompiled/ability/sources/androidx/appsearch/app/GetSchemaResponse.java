package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.InternalVisibilityConfig;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "GetSchemaResponseCreator")
/* loaded from: classes.dex */
public final class GetSchemaResponse extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<GetSchemaResponse> CREATOR = new StubCreators.GetSchemaResponseCreator();

    @Nullable
    private Map<String, PackageIdentifier> mPubliclyVisibleSchemasCached;

    @AbstractSafeParcelable.Field(id = 2)
    final List<AppSearchSchema> mSchemas;

    @Nullable
    private Set<AppSearchSchema> mSchemasCached;

    @Nullable
    private Set<String> mSchemasNotDisplayedBySystemCached;

    @Nullable
    private Map<String, Set<SchemaVisibilityConfig>> mSchemasVisibleToConfigsCached;

    @Nullable
    private Map<String, Set<PackageIdentifier>> mSchemasVisibleToPackagesCached;

    @Nullable
    private Map<String, Set<Set<Integer>>> mSchemasVisibleToPermissionsCached;

    @AbstractSafeParcelable.Field(getter = "getVersion", id = 1)
    private final int mVersion;

    @Nullable
    @AbstractSafeParcelable.Field(id = 3)
    final List<InternalVisibilityConfig> mVisibilityConfigs;

    @AbstractSafeParcelable.Constructor
    public GetSchemaResponse(@AbstractSafeParcelable.Param(id = 1) int i, @NonNull @AbstractSafeParcelable.Param(id = 2) List<AppSearchSchema> list, @Nullable @AbstractSafeParcelable.Param(id = 3) List<InternalVisibilityConfig> list2) {
        this.mVersion = i;
        this.mSchemas = (List) Preconditions.checkNotNull(list);
        this.mVisibilityConfigs = list2;
    }

    @NonNull
    private List<InternalVisibilityConfig> getVisibilityConfigsOrThrow() {
        List<InternalVisibilityConfig> list = this.mVisibilityConfigs;
        if (list != null) {
            return list;
        }
        throw new UnsupportedOperationException("Get visibility setting is not supported with this backend/Android API level combination.");
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA)
    public Map<String, PackageIdentifier> getPubliclyVisibleSchemas() {
        List<InternalVisibilityConfig> visibilityConfigsOrThrow = getVisibilityConfigsOrThrow();
        if (this.mPubliclyVisibleSchemasCached == null) {
            ArrayMap arrayMap = new ArrayMap();
            for (int i = 0; i < visibilityConfigsOrThrow.size(); i++) {
                InternalVisibilityConfig internalVisibilityConfig = visibilityConfigsOrThrow.get(i);
                PackageIdentifier publiclyVisibleTargetPackage = internalVisibilityConfig.getVisibilityConfig().getPubliclyVisibleTargetPackage();
                if (publiclyVisibleTargetPackage != null) {
                    arrayMap.put(internalVisibilityConfig.getSchemaType(), publiclyVisibleTargetPackage);
                }
            }
            this.mPubliclyVisibleSchemasCached = Collections.unmodifiableMap(arrayMap);
        }
        return this.mPubliclyVisibleSchemasCached;
    }

    @NonNull
    @SuppressLint({"RequiresPermission"})
    public Map<String, Set<Set<Integer>>> getRequiredPermissionsForSchemaTypeVisibility() {
        List<InternalVisibilityConfig> visibilityConfigsOrThrow = getVisibilityConfigsOrThrow();
        if (this.mSchemasVisibleToPermissionsCached == null) {
            ArrayMap arrayMap = new ArrayMap();
            for (int i = 0; i < visibilityConfigsOrThrow.size(); i++) {
                InternalVisibilityConfig internalVisibilityConfig = visibilityConfigsOrThrow.get(i);
                Set<Set<Integer>> requiredPermissions = internalVisibilityConfig.getVisibilityConfig().getRequiredPermissions();
                if (!requiredPermissions.isEmpty()) {
                    arrayMap.put(internalVisibilityConfig.getSchemaType(), Collections.unmodifiableSet(requiredPermissions));
                }
            }
            this.mSchemasVisibleToPermissionsCached = Collections.unmodifiableMap(arrayMap);
        }
        return this.mSchemasVisibleToPermissionsCached;
    }

    @NonNull
    public Set<String> getSchemaTypesNotDisplayedBySystem() {
        List<InternalVisibilityConfig> visibilityConfigsOrThrow = getVisibilityConfigsOrThrow();
        if (this.mSchemasNotDisplayedBySystemCached == null) {
            ArraySet arraySet = new ArraySet();
            for (int i = 0; i < visibilityConfigsOrThrow.size(); i++) {
                if (visibilityConfigsOrThrow.get(i).isNotDisplayedBySystem()) {
                    arraySet.add(visibilityConfigsOrThrow.get(i).getSchemaType());
                }
            }
            this.mSchemasNotDisplayedBySystemCached = Collections.unmodifiableSet(arraySet);
        }
        return this.mSchemasNotDisplayedBySystemCached;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
    public Map<String, Set<SchemaVisibilityConfig>> getSchemaTypesVisibleToConfigs() {
        List<InternalVisibilityConfig> visibilityConfigsOrThrow = getVisibilityConfigsOrThrow();
        if (this.mSchemasVisibleToConfigsCached == null) {
            ArrayMap arrayMap = new ArrayMap();
            for (int i = 0; i < visibilityConfigsOrThrow.size(); i++) {
                InternalVisibilityConfig internalVisibilityConfig = visibilityConfigsOrThrow.get(i);
                Set<SchemaVisibilityConfig> visibleToConfigs = internalVisibilityConfig.getVisibleToConfigs();
                if (!visibleToConfigs.isEmpty()) {
                    arrayMap.put(internalVisibilityConfig.getSchemaType(), Collections.unmodifiableSet(visibleToConfigs));
                }
            }
            this.mSchemasVisibleToConfigsCached = Collections.unmodifiableMap(arrayMap);
        }
        return this.mSchemasVisibleToConfigsCached;
    }

    @NonNull
    public Map<String, Set<PackageIdentifier>> getSchemaTypesVisibleToPackages() {
        List<InternalVisibilityConfig> visibilityConfigsOrThrow = getVisibilityConfigsOrThrow();
        if (this.mSchemasVisibleToPackagesCached == null) {
            ArrayMap arrayMap = new ArrayMap();
            for (int i = 0; i < visibilityConfigsOrThrow.size(); i++) {
                InternalVisibilityConfig internalVisibilityConfig = visibilityConfigsOrThrow.get(i);
                List<PackageIdentifier> allowedPackages = internalVisibilityConfig.getVisibilityConfig().getAllowedPackages();
                if (!allowedPackages.isEmpty()) {
                    arrayMap.put(internalVisibilityConfig.getSchemaType(), Collections.unmodifiableSet(new ArraySet(allowedPackages)));
                }
            }
            this.mSchemasVisibleToPackagesCached = Collections.unmodifiableMap(arrayMap);
        }
        return this.mSchemasVisibleToPackagesCached;
    }

    @NonNull
    public Set<AppSearchSchema> getSchemas() {
        if (this.mSchemasCached == null) {
            this.mSchemasCached = Collections.unmodifiableSet(new ArraySet(this.mSchemas));
        }
        return this.mSchemasCached;
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public int getVersion() {
        return this.mVersion;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static final class Builder {
        private boolean mBuilt;
        private ArrayList<AppSearchSchema> mSchemas;
        private int mVersion;

        @Nullable
        private Map<String, InternalVisibilityConfig.Builder> mVisibilityConfigBuilders;

        public Builder() {
            this.mVersion = 0;
            this.mSchemas = new ArrayList<>();
            this.mBuilt = false;
            setVisibilitySettingSupported(true);
        }

        @NonNull
        private InternalVisibilityConfig.Builder getOrCreateVisibilityConfigBuilder(@NonNull String str) {
            Map<String, InternalVisibilityConfig.Builder> map = this.mVisibilityConfigBuilders;
            if (map == null) {
                throw new IllegalStateException("GetSchemaResponse is not configured withvisibility setting support");
            }
            InternalVisibilityConfig.Builder builder = map.get(str);
            if (builder != null) {
                return builder;
            }
            InternalVisibilityConfig.Builder builder2 = new InternalVisibilityConfig.Builder(str);
            this.mVisibilityConfigBuilders.put(str, builder2);
            return builder2;
        }

        @Nullable
        private InternalVisibilityConfig.Builder getVisibilityConfigBuilder(@NonNull String str) {
            Map<String, InternalVisibilityConfig.Builder> map = this.mVisibilityConfigBuilders;
            if (map != null) {
                return map.get(str);
            }
            throw new IllegalStateException("GetSchemaResponse is not configured withvisibility setting support");
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSchemas = new ArrayList<>(this.mSchemas);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addSchema(@NonNull AppSearchSchema appSearchSchema) {
            Preconditions.checkNotNull(appSearchSchema);
            resetIfBuilt();
            this.mSchemas.add(appSearchSchema);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addSchemaTypeNotDisplayedBySystem(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            getOrCreateVisibilityConfigBuilder(str).setNotDisplayedBySystem(true);
            return this;
        }

        @NonNull
        public GetSchemaResponse build() {
            ArrayList arrayList;
            if (this.mVisibilityConfigBuilders != null) {
                arrayList = new ArrayList();
                Iterator<InternalVisibilityConfig.Builder> it = this.mVisibilityConfigBuilders.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().build());
                }
            } else {
                arrayList = null;
            }
            this.mBuilt = true;
            return new GetSchemaResponse(this.mVersion, this.mSchemas, arrayList);
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearPubliclyVisibleSchema(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            InternalVisibilityConfig.Builder visibilityConfigBuilder = getVisibilityConfigBuilder(str);
            if (visibilityConfigBuilder != null) {
                visibilityConfigBuilder.setPubliclyVisibleTargetPackage(null);
            }
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @SuppressLint({"RequiresPermission"})
        @CanIgnoreReturnValue
        public Builder clearRequiredPermissionsForSchemaTypeVisibility(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            InternalVisibilityConfig.Builder visibilityConfigBuilder = getVisibilityConfigBuilder(str);
            if (visibilityConfigBuilder != null) {
                visibilityConfigBuilder.clearVisibleToPermissions();
            }
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSchemaTypeNotDisplayedBySystem(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            InternalVisibilityConfig.Builder visibilityConfigBuilder = getVisibilityConfigBuilder(str);
            if (visibilityConfigBuilder != null) {
                visibilityConfigBuilder.setNotDisplayedBySystem(false);
            }
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSchemaTypeVisibleToConfigs(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            InternalVisibilityConfig.Builder visibilityConfigBuilder = getVisibilityConfigBuilder(str);
            if (visibilityConfigBuilder != null) {
                visibilityConfigBuilder.clearVisibleToConfig();
            }
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSchemaTypeVisibleToPackages(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            InternalVisibilityConfig.Builder visibilityConfigBuilder = getVisibilityConfigBuilder(str);
            if (visibilityConfigBuilder != null) {
                visibilityConfigBuilder.clearVisibleToPackages();
            }
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
        @FlaggedApi(Flags.FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleSchema(@NonNull String str, @NonNull PackageIdentifier packageIdentifier) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(packageIdentifier);
            resetIfBuilt();
            getOrCreateVisibilityConfigBuilder(str).setPubliclyVisibleTargetPackage(packageIdentifier);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder", "RequiresPermission"})
        public Builder setRequiredPermissionsForSchemaTypeVisibility(@NonNull String str, @NonNull Set<Set<Integer>> set) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(set);
            resetIfBuilt();
            InternalVisibilityConfig.Builder orCreateVisibilityConfigBuilder = getOrCreateVisibilityConfigBuilder(str);
            Iterator<Set<Integer>> it = set.iterator();
            while (it.hasNext()) {
                orCreateVisibilityConfigBuilder.addVisibleToPermissions(it.next());
            }
            return this;
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setSchemaTypeVisibleToConfigs(@NonNull String str, @NonNull Set<SchemaVisibilityConfig> set) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(set);
            resetIfBuilt();
            InternalVisibilityConfig.Builder orCreateVisibilityConfigBuilder = getOrCreateVisibilityConfigBuilder(str);
            Iterator<SchemaVisibilityConfig> it = set.iterator();
            while (it.hasNext()) {
                orCreateVisibilityConfigBuilder.addVisibleToConfig(it.next());
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSchemaTypeVisibleToPackages(@NonNull String str, @NonNull Set<PackageIdentifier> set) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(set);
            resetIfBuilt();
            InternalVisibilityConfig.Builder orCreateVisibilityConfigBuilder = getOrCreateVisibilityConfigBuilder(str);
            Iterator<PackageIdentifier> it = set.iterator();
            while (it.hasNext()) {
                orCreateVisibilityConfigBuilder.addVisibleToPackage(it.next());
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setVersion(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i) {
            Preconditions.checkArgument(i >= 0, "Version must be a non-negative number.");
            resetIfBuilt();
            this.mVersion = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setVisibilitySettingSupported(boolean z10) {
            if (z10) {
                this.mVisibilityConfigBuilders = new ArrayMap();
                return this;
            }
            this.mVisibilityConfigBuilders = null;
            return this;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(@NonNull GetSchemaResponse getSchemaResponse) {
            this.mVersion = 0;
            this.mSchemas = new ArrayList<>();
            this.mBuilt = false;
            setVisibilitySettingSupported(true);
            this.mVersion = getSchemaResponse.mVersion;
            this.mSchemas.addAll(getSchemaResponse.mSchemas);
            List<InternalVisibilityConfig> list = getSchemaResponse.mVisibilityConfigs;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    InternalVisibilityConfig internalVisibilityConfig = getSchemaResponse.mVisibilityConfigs.get(i);
                    this.mVisibilityConfigBuilders.put(internalVisibilityConfig.getSchemaType(), new InternalVisibilityConfig.Builder(internalVisibilityConfig));
                }
            }
        }
    }
}
