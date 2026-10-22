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
import androidx.core.util.Preconditions;

@SafeParcelable.Class(creator = "SearchSuggestionResultCreator")
/* loaded from: classes.dex */
public final class SearchSuggestionResult extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSuggestionResult> CREATOR = new StubCreators.SearchSuggestionResultCreator();

    @Nullable
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getSuggestedResult", id = 1)
    private final String mSuggestedResult;

    public static final class Builder {
        private String mSuggestedResult = "";

        @NonNull
        public SearchSuggestionResult build() {
            return new SearchSuggestionResult(this.mSuggestedResult);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setSuggestedResult(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Preconditions.checkStringNotEmpty(str);
            this.mSuggestedResult = str;
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public SearchSuggestionResult(@AbstractSafeParcelable.Param(id = 1) String str) {
        this.mSuggestedResult = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchSuggestionResult) {
            return this.mSuggestedResult.equals(((SearchSuggestionResult) obj).mSuggestedResult);
        }
        return false;
    }

    @NonNull
    public String getSuggestedResult() {
        return this.mSuggestedResult;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(this.mSuggestedResult.hashCode());
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
