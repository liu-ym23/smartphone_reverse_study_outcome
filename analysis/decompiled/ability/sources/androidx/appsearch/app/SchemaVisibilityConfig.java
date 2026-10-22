package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.PackageIdentifierParcel;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
@SafeParcelable.Class(creator = "VisibilityConfigCreator")
/* loaded from: classes.dex */
public final class SchemaVisibilityConfig extends AbstractSafeParcelable {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SchemaVisibilityConfig> CREATOR = new StubCreators.VisibilityConfigCreator();

    @NonNull
    @AbstractSafeParcelable.Field(id = 1)
    final List<PackageIdentifierParcel> mAllowedPackages;

    @Nullable
    private List<PackageIdentifier> mAllowedPackagesCached;

    @Nullable
    private Integer mHashCode;

    @Nullable
    @AbstractSafeParcelable.Field(id = 3)
    final PackageIdentifierParcel mPubliclyVisibleTargetPackage;

    @NonNull
    @AbstractSafeParcelable.Field(id = 2)
    final List<VisibilityPermissionConfig> mRequiredPermissions;

    @Nullable
    private Set<Set<Integer>> mRequiredPermissionsCached;

    @AbstractSafeParcelable.Constructor
    public SchemaVisibilityConfig(@NonNull @AbstractSafeParcelable.Param(id = 1) List<PackageIdentifierParcel> list, @NonNull @AbstractSafeParcelable.Param(id = 2) List<VisibilityPermissionConfig> list2, @Nullable @AbstractSafeParcelable.Param(id = 3) PackageIdentifierParcel packageIdentifierParcel) {
        Objects.requireNonNull(list);
        this.mAllowedPackages = list;
        Objects.requireNonNull(list2);
        this.mRequiredPermissions = list2;
        this.mPubliclyVisibleTargetPackage = packageIdentifierParcel;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SchemaVisibilityConfig)) {
            return false;
        }
        SchemaVisibilityConfig schemaVisibilityConfig = (SchemaVisibilityConfig) obj;
        return Objects.equals(this.mAllowedPackages, schemaVisibilityConfig.mAllowedPackages) && Objects.equals(this.mRequiredPermissions, schemaVisibilityConfig.mRequiredPermissions) && Objects.equals(this.mPubliclyVisibleTargetPackage, schemaVisibilityConfig.mPubliclyVisibleTargetPackage);
    }

    @NonNull
    public List<PackageIdentifier> getAllowedPackages() {
        if (this.mAllowedPackagesCached == null) {
            this.mAllowedPackagesCached = new ArrayList(this.mAllowedPackages.size());
            for (int i = 0; i < this.mAllowedPackages.size(); i++) {
                this.mAllowedPackagesCached.add(new PackageIdentifier(this.mAllowedPackages.get(i)));
            }
        }
        return this.mAllowedPackagesCached;
    }

    @Nullable
    public PackageIdentifier getPubliclyVisibleTargetPackage() {
        PackageIdentifierParcel packageIdentifierParcel = this.mPubliclyVisibleTargetPackage;
        if (packageIdentifierParcel == null) {
            return null;
        }
        return new PackageIdentifier(packageIdentifierParcel);
    }

    @NonNull
    public Set<Set<Integer>> getRequiredPermissions() {
        if (this.mRequiredPermissionsCached == null) {
            this.mRequiredPermissionsCached = new ArraySet(this.mRequiredPermissions.size());
            for (int i = 0; i < this.mRequiredPermissions.size(); i++) {
                Set<Integer> allRequiredPermissions = this.mRequiredPermissions.get(i).getAllRequiredPermissions();
                Set<Set<Integer>> set = this.mRequiredPermissionsCached;
                if (set != null && allRequiredPermissions != null) {
                    set.add(allRequiredPermissions);
                }
            }
        }
        Set<Set<Integer>> set2 = this.mRequiredPermissionsCached;
        Objects.requireNonNull(set2);
        return set2;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(this.mAllowedPackages, this.mRequiredPermissions, this.mPubliclyVisibleTargetPackage));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS)
    public static final class Builder {
        private List<PackageIdentifierParcel> mAllowedPackages;
        private boolean mBuilt;

        @Nullable
        private PackageIdentifierParcel mPubliclyVisibleTargetPackage;
        private List<VisibilityPermissionConfig> mRequiredPermissions;

        public Builder() {
            this.mAllowedPackages = new ArrayList();
            this.mRequiredPermissions = new ArrayList();
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mAllowedPackages = new ArrayList(this.mAllowedPackages);
                this.mRequiredPermissions = new ArrayList(this.mRequiredPermissions);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addAllowedPackage(@NonNull PackageIdentifier packageIdentifier) {
            Objects.requireNonNull(packageIdentifier);
            resetIfBuilt();
            this.mAllowedPackages.add(packageIdentifier.getPackageIdentifierParcel());
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addRequiredPermissions(@NonNull Set<Integer> set) {
            Objects.requireNonNull(set);
            resetIfBuilt();
            this.mRequiredPermissions.add(new VisibilityPermissionConfig(set));
            return this;
        }

        @NonNull
        public SchemaVisibilityConfig build() {
            this.mBuilt = true;
            return new SchemaVisibilityConfig(this.mAllowedPackages, this.mRequiredPermissions, this.mPubliclyVisibleTargetPackage);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder clearAllowedPackages() {
            resetIfBuilt();
            this.mAllowedPackages.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder clearRequiredPermissions() {
            resetIfBuilt();
            this.mRequiredPermissions.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setPubliclyVisibleTargetPackage(@Nullable PackageIdentifier packageIdentifier) {
            resetIfBuilt();
            if (packageIdentifier == null) {
                this.mPubliclyVisibleTargetPackage = null;
                return this;
            }
            this.mPubliclyVisibleTargetPackage = packageIdentifier.getPackageIdentifierParcel();
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull SchemaVisibilityConfig schemaVisibilityConfig) {
            this.mAllowedPackages = new ArrayList();
            this.mRequiredPermissions = new ArrayList();
            Objects.requireNonNull(schemaVisibilityConfig);
            this.mAllowedPackages = new ArrayList(schemaVisibilityConfig.mAllowedPackages);
            this.mRequiredPermissions = new ArrayList(schemaVisibilityConfig.mRequiredPermissions);
            this.mPubliclyVisibleTargetPackage = schemaVisibilityConfig.mPubliclyVisibleTargetPackage;
        }
    }
}
