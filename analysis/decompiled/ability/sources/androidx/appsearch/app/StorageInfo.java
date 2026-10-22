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

@SafeParcelable.Class(creator = "StorageInfoCreator")
/* loaded from: classes.dex */
public final class StorageInfo extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<StorageInfo> CREATOR = new StubCreators.StorageInfoCreator();

    @AbstractSafeParcelable.Field(getter = "getAliveDocumentsCount", id = 2)
    private int mAliveDocumentsCount;

    @AbstractSafeParcelable.Field(getter = "getAliveNamespacesCount", id = 3)
    private int mAliveNamespacesCount;

    @AbstractSafeParcelable.Field(getter = "getBlobsCount", id = 5)
    private int mBlobsCount;

    @AbstractSafeParcelable.Field(getter = "getBlobsSizeBytes", id = 4)
    private long mBlobsSizeBytes;

    @AbstractSafeParcelable.Field(getter = "getSizeBytes", id = 1)
    private long mSizeBytes;

    public static final class Builder {
        private int mAliveDocumentsCount;
        private int mAliveNamespacesCount;
        private int mBlobsCount;
        private long mBlobsSizeBytes;
        private long mSizeBytes;

        @NonNull
        public StorageInfo build() {
            return new StorageInfo(this.mSizeBytes, this.mAliveDocumentsCount, this.mAliveNamespacesCount, this.mBlobsSizeBytes, this.mBlobsCount);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAliveDocumentsCount(int i) {
            this.mAliveDocumentsCount = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAliveNamespacesCount(int i) {
            this.mAliveNamespacesCount = i;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
        @CanIgnoreReturnValue
        public Builder setBlobsCount(int i) {
            this.mBlobsCount = i;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
        @CanIgnoreReturnValue
        public Builder setBlobsSizeBytes(long j5) {
            this.mBlobsSizeBytes = j5;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setSizeBytes(long j5) {
            this.mSizeBytes = j5;
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public StorageInfo(@AbstractSafeParcelable.Param(id = 1) long j5, @AbstractSafeParcelable.Param(id = 2) int i, @AbstractSafeParcelable.Param(id = 3) int i6, @AbstractSafeParcelable.Param(id = 4) long j6, @AbstractSafeParcelable.Param(id = 5) int i10) {
        this.mSizeBytes = j5;
        this.mAliveDocumentsCount = i;
        this.mAliveNamespacesCount = i6;
        this.mBlobsSizeBytes = j6;
        this.mBlobsCount = i10;
    }

    public int getAliveDocumentsCount() {
        return this.mAliveDocumentsCount;
    }

    public int getAliveNamespacesCount() {
        return this.mAliveNamespacesCount;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    public int getBlobsCount() {
        return this.mBlobsCount;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    public long getBlobsSizeBytes() {
        return this.mBlobsSizeBytes;
    }

    public long getSizeBytes() {
        return this.mSizeBytes;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
