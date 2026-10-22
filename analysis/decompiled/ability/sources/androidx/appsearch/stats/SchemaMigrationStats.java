package androidx.appsearch.stats;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SafeParcelable.Class(creator = "SchemaMigrationStatsCreator")
/* loaded from: classes.dex */
public final class SchemaMigrationStats extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SchemaMigrationStats> CREATOR = new StubCreators.SchemaMigrationStatsCreator();
    public static final int FIRST_CALL_GET_INCOMPATIBLE = 1;
    public static final int NO_MIGRATION = 0;
    public static final int SECOND_CALL_APPLY_NEW_SCHEMA = 2;

    @AbstractSafeParcelable.Field(getter = "getDatabase", id = 2)
    private final String mDatabase;

    @AbstractSafeParcelable.Field(getter = "getExecutorAcquisitionLatencyMillis", id = 4)
    private final int mExecutorAcquisitionLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getFirstSetSchemaLatencyMillis", id = 8)
    private final int mFirstSetSchemaLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getGetSchemaLatencyMillis", id = 6)
    private final int mGetSchemaLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "isFirstSetSchemaSuccess", id = 9)
    private final boolean mIsFirstSetSchemaSuccess;

    @AbstractSafeParcelable.Field(getter = "getMigrationFailureCount", id = 13)
    private final int mMigrationFailureCount;

    @AbstractSafeParcelable.Field(getter = "getPackageName", id = 1)
    private final String mPackageName;

    @AbstractSafeParcelable.Field(getter = "getQueryAndTransformLatencyMillis", id = 7)
    private final int mQueryAndTransformLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getSaveDocumentLatencyMillis", id = 11)
    private final int mSaveDocumentLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getSecondSetSchemaLatencyMillis", id = 10)
    private final int mSecondSetSchemaLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int mStatusCode;

    @AbstractSafeParcelable.Field(getter = "getTotalLatencyMillis", id = 5)
    private final int mTotalLatencyMillis;

    @AbstractSafeParcelable.Field(getter = "getTotalNeedMigratedDocumentCount", id = 12)
    private final int mTotalNeedMigratedDocumentCount;

    @AbstractSafeParcelable.Field(getter = "getTotalSuccessMigratedDocumentCount", id = 14)
    private final int mTotalSuccessMigratedDocumentCount;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SchemaMigrationCallType {
    }

    @AbstractSafeParcelable.Constructor
    public SchemaMigrationStats(@AbstractSafeParcelable.Param(id = 1) String str, @AbstractSafeParcelable.Param(id = 2) String str2, @AbstractSafeParcelable.Param(id = 3) int i, @AbstractSafeParcelable.Param(id = 4) int i6, @AbstractSafeParcelable.Param(id = 5) int i10, @AbstractSafeParcelable.Param(id = 6) int i11, @AbstractSafeParcelable.Param(id = 7) int i12, @AbstractSafeParcelable.Param(id = 8) int i13, @AbstractSafeParcelable.Param(id = 9) boolean z10, @AbstractSafeParcelable.Param(id = 10) int i14, @AbstractSafeParcelable.Param(id = 11) int i15, @AbstractSafeParcelable.Param(id = 12) int i16, @AbstractSafeParcelable.Param(id = 13) int i17, @AbstractSafeParcelable.Param(id = 14) int i18) {
        this.mPackageName = str;
        this.mDatabase = str2;
        this.mStatusCode = i;
        this.mExecutorAcquisitionLatencyMillis = i6;
        this.mTotalLatencyMillis = i10;
        this.mGetSchemaLatencyMillis = i11;
        this.mQueryAndTransformLatencyMillis = i12;
        this.mFirstSetSchemaLatencyMillis = i13;
        this.mIsFirstSetSchemaSuccess = z10;
        this.mSecondSetSchemaLatencyMillis = i14;
        this.mSaveDocumentLatencyMillis = i15;
        this.mTotalNeedMigratedDocumentCount = i16;
        this.mMigrationFailureCount = i17;
        this.mTotalSuccessMigratedDocumentCount = i18;
    }

    public String getDatabase() {
        return this.mDatabase;
    }

    public int getExecutorAcquisitionLatencyMillis() {
        return this.mExecutorAcquisitionLatencyMillis;
    }

    public int getFirstSetSchemaLatencyMillis() {
        return this.mFirstSetSchemaLatencyMillis;
    }

    public int getGetSchemaLatencyMillis() {
        return this.mGetSchemaLatencyMillis;
    }

    public int getMigrationFailureCount() {
        return this.mMigrationFailureCount;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getQueryAndTransformLatencyMillis() {
        return this.mQueryAndTransformLatencyMillis;
    }

    public int getSaveDocumentLatencyMillis() {
        return this.mSaveDocumentLatencyMillis;
    }

    public int getSecondSetSchemaLatencyMillis() {
        return this.mSecondSetSchemaLatencyMillis;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public int getTotalLatencyMillis() {
        return this.mTotalLatencyMillis;
    }

    public int getTotalNeedMigratedDocumentCount() {
        return this.mTotalNeedMigratedDocumentCount;
    }

    public int getTotalSuccessMigratedDocumentCount() {
        return this.mTotalSuccessMigratedDocumentCount;
    }

    public boolean isFirstSetSchemaSuccess() {
        return this.mIsFirstSetSchemaSuccess;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static class Builder {
        String mDatabase;
        int mExecutorAcquisitionLatencyMillis;
        int mFirstSetSchemaLatencyMillis;
        int mGetSchemaLatencyMillis;
        boolean mIsFirstSetSchemaSuccess;
        int mMigrationFailureCount;
        String mPackageName;
        int mQueryAndTransformLatencyMillis;
        int mSaveDocumentLatencyMillis;
        int mSecondSetSchemaLatencyMillis;
        int mStatusCode;
        int mTotalLatencyMillis;
        int mTotalNeedMigratedDocumentCount;
        int mTotalSuccessMigratedDocumentCount;

        public Builder(String str, String str2) {
            Objects.requireNonNull(str);
            this.mPackageName = str;
            Objects.requireNonNull(str2);
            this.mDatabase = str2;
        }

        public SchemaMigrationStats build() {
            return new SchemaMigrationStats(this.mPackageName, this.mDatabase, this.mStatusCode, this.mExecutorAcquisitionLatencyMillis, this.mTotalLatencyMillis, this.mGetSchemaLatencyMillis, this.mQueryAndTransformLatencyMillis, this.mFirstSetSchemaLatencyMillis, this.mIsFirstSetSchemaSuccess, this.mSecondSetSchemaLatencyMillis, this.mSaveDocumentLatencyMillis, this.mTotalNeedMigratedDocumentCount, this.mMigrationFailureCount, this.mTotalSuccessMigratedDocumentCount);
        }

        @CanIgnoreReturnValue
        public Builder setExecutorAcquisitionLatencyMillis(int i) {
            this.mExecutorAcquisitionLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setFirstSetSchemaLatencyMillis(int i) {
            this.mFirstSetSchemaLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setGetSchemaLatencyMillis(int i) {
            this.mGetSchemaLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIsFirstSetSchemaSuccess(boolean z10) {
            this.mIsFirstSetSchemaSuccess = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMigrationFailureCount(int i) {
            this.mMigrationFailureCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setQueryAndTransformLatencyMillis(int i) {
            this.mQueryAndTransformLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSaveDocumentLatencyMillis(int i) {
            this.mSaveDocumentLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSecondSetSchemaLatencyMillis(int i) {
            this.mSecondSetSchemaLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setStatusCode(int i) {
            this.mStatusCode = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTotalLatencyMillis(int i) {
            this.mTotalLatencyMillis = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTotalNeedMigratedDocumentCount(int i) {
            this.mTotalNeedMigratedDocumentCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTotalSuccessMigratedDocumentCount(int i) {
            this.mTotalSuccessMigratedDocumentCount = i;
            return this;
        }

        public Builder(SchemaMigrationStats schemaMigrationStats) {
            Objects.requireNonNull(schemaMigrationStats);
            this.mPackageName = schemaMigrationStats.mPackageName;
            this.mDatabase = schemaMigrationStats.mDatabase;
            this.mStatusCode = schemaMigrationStats.mStatusCode;
            this.mExecutorAcquisitionLatencyMillis = schemaMigrationStats.mExecutorAcquisitionLatencyMillis;
            this.mTotalLatencyMillis = schemaMigrationStats.mTotalLatencyMillis;
            this.mGetSchemaLatencyMillis = schemaMigrationStats.mGetSchemaLatencyMillis;
            this.mQueryAndTransformLatencyMillis = schemaMigrationStats.mQueryAndTransformLatencyMillis;
            this.mFirstSetSchemaLatencyMillis = schemaMigrationStats.mFirstSetSchemaLatencyMillis;
            this.mIsFirstSetSchemaSuccess = schemaMigrationStats.mIsFirstSetSchemaSuccess;
            this.mSecondSetSchemaLatencyMillis = schemaMigrationStats.mSecondSetSchemaLatencyMillis;
            this.mSaveDocumentLatencyMillis = schemaMigrationStats.mSaveDocumentLatencyMillis;
            this.mTotalNeedMigratedDocumentCount = schemaMigrationStats.mTotalNeedMigratedDocumentCount;
            this.mMigrationFailureCount = schemaMigrationStats.mMigrationFailureCount;
            this.mTotalSuccessMigratedDocumentCount = schemaMigrationStats.mTotalSuccessMigratedDocumentCount;
        }
    }
}
