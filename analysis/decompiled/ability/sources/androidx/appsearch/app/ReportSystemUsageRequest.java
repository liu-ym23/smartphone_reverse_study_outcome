package androidx.appsearch.app;

import androidx.annotation.NonNull;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class ReportSystemUsageRequest {
    private final String mDatabase;
    private final String mDocumentId;
    private final String mNamespace;
    private final String mPackageName;
    private final long mUsageTimestampMillis;

    public static final class Builder {
        private final String mDatabase;
        private final String mDocumentId;
        private final String mNamespace;
        private final String mPackageName;
        private Long mUsageTimestampMillis;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
            this.mPackageName = (String) Preconditions.checkNotNull(str);
            this.mDatabase = (String) Preconditions.checkNotNull(str2);
            this.mNamespace = (String) Preconditions.checkNotNull(str3);
            this.mDocumentId = (String) Preconditions.checkNotNull(str4);
        }

        @NonNull
        public ReportSystemUsageRequest build() {
            if (this.mUsageTimestampMillis == null) {
                this.mUsageTimestampMillis = Long.valueOf(System.currentTimeMillis());
            }
            return new ReportSystemUsageRequest(this.mPackageName, this.mDatabase, this.mNamespace, this.mDocumentId, this.mUsageTimestampMillis.longValue());
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setUsageTimestampMillis(long j5) {
            this.mUsageTimestampMillis = Long.valueOf(j5);
            return this;
        }
    }

    public ReportSystemUsageRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, long j5) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabase = (String) Preconditions.checkNotNull(str2);
        this.mNamespace = (String) Preconditions.checkNotNull(str3);
        this.mDocumentId = (String) Preconditions.checkNotNull(str4);
        this.mUsageTimestampMillis = j5;
    }

    @NonNull
    public String getDatabaseName() {
        return this.mDatabase;
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
    public String getPackageName() {
        return this.mPackageName;
    }

    public long getUsageTimestampMillis() {
        return this.mUsageTimestampMillis;
    }
}
