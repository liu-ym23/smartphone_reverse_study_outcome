package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.util.Objects;

@SafeParcelable.Class(creator = "ReportUsageRequestCreator")
/* loaded from: classes.dex */
public final class ReportUsageRequest extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<ReportUsageRequest> CREATOR = new StubCreators.ReportUsageRequestCreator();

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getDocumentId", id = 2)
    private final String mDocumentId;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getNamespace", id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Field(getter = "getUsageTimestampMillis", id = 3)
    private final long mUsageTimestampMillis;

    public static final class Builder {
        private final String mDocumentId;
        private final String mNamespace;
        private Long mUsageTimestampMillis;

        public Builder(@NonNull String str, @NonNull String str2) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
            this.mDocumentId = (String) Preconditions.checkNotNull(str2);
        }

        @NonNull
        public ReportUsageRequest build() {
            if (this.mUsageTimestampMillis == null) {
                this.mUsageTimestampMillis = Long.valueOf(System.currentTimeMillis());
            }
            return new ReportUsageRequest(this.mNamespace, this.mDocumentId, this.mUsageTimestampMillis.longValue());
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setUsageTimestampMillis(long j5) {
            this.mUsageTimestampMillis = Long.valueOf(j5);
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public ReportUsageRequest(@NonNull @AbstractSafeParcelable.Param(id = 1) String str, @NonNull @AbstractSafeParcelable.Param(id = 2) String str2, @AbstractSafeParcelable.Param(id = 3) long j5) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(str2);
        this.mDocumentId = str2;
        this.mUsageTimestampMillis = j5;
    }

    @NonNull
    public String getDocumentId() {
        return this.mDocumentId;
    }

    @NonNull
    public String getNamespace() {
        return this.mNamespace;
    }

    public long getUsageTimestampMillis() {
        return this.mUsageTimestampMillis;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
