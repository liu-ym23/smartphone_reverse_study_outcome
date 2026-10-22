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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@SafeParcelable.Class(creator = "RemoveByDocumentIdRequestCreator")
/* loaded from: classes.dex */
public final class RemoveByDocumentIdRequest extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<RemoveByDocumentIdRequest> CREATOR = new StubCreators.RemoveByDocumentIdRequestCreator();

    @NonNull
    @AbstractSafeParcelable.Field(id = 2)
    final List<String> mIds;

    @Nullable
    private Set<String> mIdsCached;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getNamespace", id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Constructor
    public RemoveByDocumentIdRequest(@NonNull @AbstractSafeParcelable.Param(id = 1) String str, @NonNull @AbstractSafeParcelable.Param(id = 2) List<String> list) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(list);
        this.mIds = list;
    }

    @NonNull
    public Set<String> getIds() {
        if (this.mIdsCached == null) {
            this.mIdsCached = Collections.unmodifiableSet(new ArraySet(this.mIds));
        }
        return this.mIdsCached;
    }

    @NonNull
    public String getNamespace() {
        return this.mNamespace;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static final class Builder {
        private final String mNamespace;
        private ArraySet<String> mIds = new ArraySet<>();
        private boolean mBuilt = false;

        public Builder(@NonNull String str) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mIds = new ArraySet<>((ArraySet) this.mIds);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addIds(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addIds(Arrays.asList(strArr));
        }

        @NonNull
        public RemoveByDocumentIdRequest build() {
            this.mBuilt = true;
            return new RemoveByDocumentIdRequest(this.mNamespace, new ArrayList(this.mIds));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addIds(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mIds.addAll(collection);
            return this;
        }
    }
}
