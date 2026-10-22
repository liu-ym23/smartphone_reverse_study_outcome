package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExperimentalUrlRequest extends UrlRequest {

    public static abstract class Builder extends UrlRequest.Builder {
        public static final int DEFAULT_IDEMPOTENCY = 0;
        public static final int IDEMPOTENT = 1;
        public static final int NOT_IDEMPOTENT = 2;

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder addHeader(String r1, String r2);

        public Builder addRequestAnnotation(Object r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder allowDirectExecutor();

        public Builder bindToNetwork(long r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract ExperimentalUrlRequest build();

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder disableCache();

        public Builder disableConnectionMigration() {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setHttpMethod(String r1);

        public Builder setIdempotency(int r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setPriority(int r1);

        public Builder setRequestFinishedListener(RequestFinishedInfo.Listener r1) {
            return this;
        }

        public Builder setTrafficStatsTag(int r1) {
            return this;
        }

        public Builder setTrafficStatsUid(int r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setUploadDataProvider(UploadDataProvider r1, Executor r2);

        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r1, String r2) {
            return addHeader(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
            return allowDirectExecutor();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
            return disableCache();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r1) {
            return setHttpMethod(r1);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r1) {
            return setPriority(r1);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r1, Executor r2) {
            return setUploadDataProvider(r1, r2);
        }
    }

    public ExperimentalUrlRequest() {
    }
}
