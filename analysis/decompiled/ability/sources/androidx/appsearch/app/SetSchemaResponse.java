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
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "SetSchemaResponseCreator")
/* loaded from: classes.dex */
public final class SetSchemaResponse extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SetSchemaResponse> CREATOR = new StubCreators.SetSchemaResponseCreator();

    @AbstractSafeParcelable.Field(id = 1)
    final List<String> mDeletedTypes;

    @Nullable
    private Set<String> mDeletedTypesCached;

    @AbstractSafeParcelable.Field(id = 2)
    final List<String> mIncompatibleTypes;

    @Nullable
    private Set<String> mIncompatibleTypesCached;

    @AbstractSafeParcelable.Field(id = 3)
    final List<String> mMigratedTypes;

    @Nullable
    private Set<String> mMigratedTypesCached;
    private final List<MigrationFailure> mMigrationFailures;

    @AbstractSafeParcelable.Constructor
    public SetSchemaResponse(@NonNull @AbstractSafeParcelable.Param(id = 1) List<String> list, @NonNull @AbstractSafeParcelable.Param(id = 2) List<String> list2, @NonNull @AbstractSafeParcelable.Param(id = 3) List<String> list3) {
        this.mDeletedTypes = list;
        this.mIncompatibleTypes = list2;
        this.mMigratedTypes = list3;
        this.mMigrationFailures = Collections.EMPTY_LIST;
    }

    @NonNull
    public Set<String> getDeletedTypes() {
        if (this.mDeletedTypesCached == null) {
            this.mDeletedTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mDeletedTypes));
        }
        return Collections.unmodifiableSet(this.mDeletedTypesCached);
    }

    @NonNull
    public Set<String> getIncompatibleTypes() {
        if (this.mIncompatibleTypesCached == null) {
            this.mIncompatibleTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mIncompatibleTypes));
        }
        return Collections.unmodifiableSet(this.mIncompatibleTypesCached);
    }

    @NonNull
    public Set<String> getMigratedTypes() {
        if (this.mMigratedTypesCached == null) {
            this.mMigratedTypesCached = new ArraySet((Collection) Preconditions.checkNotNull(this.mMigratedTypes));
        }
        return Collections.unmodifiableSet(this.mMigratedTypesCached);
    }

    @NonNull
    public List<MigrationFailure> getMigrationFailures() {
        return Collections.unmodifiableList(this.mMigrationFailures);
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @SafeParcelable.Class(creator = "MigrationFailureCreator")
    public static class MigrationFailure extends AbstractSafeParcelable {

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<MigrationFailure> CREATOR = new StubCreators.MigrationFailureCreator();

        @AbstractSafeParcelable.Field(getter = "getDocumentId", id = 2)
        private final String mDocumentId;

        @Nullable
        @AbstractSafeParcelable.Field(id = 4)
        final String mErrorMessage;

        @AbstractSafeParcelable.Field(getter = "getNamespace", id = 1)
        private final String mNamespace;

        @AbstractSafeParcelable.Field(id = 5)
        final int mResultCode;

        @AbstractSafeParcelable.Field(getter = "getSchemaType", id = 3)
        private final String mSchemaType;

        @AbstractSafeParcelable.Constructor
        public MigrationFailure(@NonNull @AbstractSafeParcelable.Param(id = 1) String str, @NonNull @AbstractSafeParcelable.Param(id = 2) String str2, @NonNull @AbstractSafeParcelable.Param(id = 3) String str3, @Nullable @AbstractSafeParcelable.Param(id = 4) String str4, @AbstractSafeParcelable.Param(id = 5) int i) {
            this.mNamespace = str;
            this.mDocumentId = str2;
            this.mSchemaType = str3;
            this.mErrorMessage = str4;
            this.mResultCode = i;
        }

        @NonNull
        public AppSearchResult<Void> getAppSearchResult() {
            return AppSearchResult.newFailedResult(this.mResultCode, this.mErrorMessage);
        }

        @NonNull
        public String getDocumentId() {
            return this.mDocumentId;
        }

        @NonNull
        public String getNamespace() {
            return this.mNamespace;
        }

        @NonNull
        public String getSchemaType() {
            return this.mSchemaType;
        }

        @NonNull
        public String toString() {
            return "MigrationFailure { schemaType: " + getSchemaType() + ", namespace: " + getNamespace() + ", documentId: " + getDocumentId() + ", appSearchResult: " + getAppSearchResult().toString() + "}";
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }

        public MigrationFailure(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull AppSearchResult<?> appSearchResult) {
            this.mNamespace = str;
            this.mDocumentId = str2;
            this.mSchemaType = str3;
            Preconditions.checkNotNull(appSearchResult);
            Preconditions.checkArgument(!appSearchResult.isSuccess(), "failedResult was actually successful");
            this.mErrorMessage = appSearchResult.getErrorMessage();
            this.mResultCode = appSearchResult.getResultCode();
        }
    }

    public SetSchemaResponse(@NonNull List<String> list, @NonNull List<String> list2, @NonNull List<String> list3, @NonNull List<MigrationFailure> list4) {
        this.mDeletedTypes = list;
        this.mIncompatibleTypes = list2;
        this.mMigratedTypes = list3;
        this.mMigrationFailures = (List) Preconditions.checkNotNull(list4);
    }

    public static final class Builder {
        private List<MigrationFailure> mMigrationFailures = new ArrayList();
        private ArrayList<String> mDeletedTypes = new ArrayList<>();
        private ArrayList<String> mMigratedTypes = new ArrayList<>();
        private ArrayList<String> mIncompatibleTypes = new ArrayList<>();
        private boolean mBuilt = false;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull SetSchemaResponse setSchemaResponse) {
            Preconditions.checkNotNull(setSchemaResponse);
            this.mDeletedTypes.addAll(setSchemaResponse.getDeletedTypes());
            this.mIncompatibleTypes.addAll(setSchemaResponse.getIncompatibleTypes());
            this.mMigratedTypes.addAll(setSchemaResponse.getMigratedTypes());
            this.mMigrationFailures.addAll(setSchemaResponse.getMigrationFailures());
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mMigrationFailures = new ArrayList(this.mMigrationFailures);
                this.mDeletedTypes = new ArrayList<>(this.mDeletedTypes);
                this.mMigratedTypes = new ArrayList<>(this.mMigratedTypes);
                this.mIncompatibleTypes = new ArrayList<>(this.mIncompatibleTypes);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addDeletedType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mDeletedTypes.add(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addDeletedTypes(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mDeletedTypes.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addIncompatibleType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mIncompatibleTypes.add(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addIncompatibleTypes(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mIncompatibleTypes.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addMigratedType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            resetIfBuilt();
            this.mMigratedTypes.add(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addMigratedTypes(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mMigratedTypes.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addMigrationFailure(@NonNull MigrationFailure migrationFailure) {
            Preconditions.checkNotNull(migrationFailure);
            resetIfBuilt();
            this.mMigrationFailures.add(migrationFailure);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addMigrationFailures(@NonNull Collection<MigrationFailure> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mMigrationFailures.addAll(collection);
            return this;
        }

        @NonNull
        public SetSchemaResponse build() {
            this.mBuilt = true;
            return new SetSchemaResponse(this.mDeletedTypes, this.mIncompatibleTypes, this.mMigratedTypes, this.mMigrationFailures);
        }

        public Builder() {
        }
    }
}
