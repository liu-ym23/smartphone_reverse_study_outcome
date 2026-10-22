package com.baidu.platform.comapi.cache.sp;

/* loaded from: classes.dex */
public class SpStorageConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f8739a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8740b;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f8741a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8742b;

        public Builder() {
            this(null);
        }

        public SpStorageConfig build() {
            return new SpStorageConfig(this.f8741a, this.f8742b);
        }

        public Builder setCacheModel(boolean z4) {
            this.f8742b = z4;
            return this;
        }

        public Builder setStorageName(String str) {
            this.f8741a = str;
            return this;
        }

        public Builder(SpStorageConfig spStorageConfig) {
            if (spStorageConfig != null) {
                this.f8741a = spStorageConfig.f8739a;
                this.f8742b = spStorageConfig.f8740b;
            }
        }
    }

    public String getStorageName() {
        return this.f8739a;
    }

    public boolean isCacheModel() {
        return this.f8740b;
    }

    private SpStorageConfig() {
    }

    private SpStorageConfig(String str, boolean z4) {
        this.f8739a = str;
        this.f8740b = z4;
    }
}
