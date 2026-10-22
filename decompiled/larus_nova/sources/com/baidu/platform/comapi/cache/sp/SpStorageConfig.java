package com.baidu.platform.comapi.cache.sp;

/* JADX INFO: loaded from: classes39.dex */
public class SpStorageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32882b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f32884b;

        public Builder() {
            this(null);
        }

        public SpStorageConfig build() {
            return new SpStorageConfig(this.f32883a, this.f32884b, null);
        }

        public Builder(SpStorageConfig r100) {
            if (r100 == null) goto L6;
            this.f32883a = SpStorageConfig.a(r100);
            this.f32884b = SpStorageConfig.b(r100);
            return;
        }

        public Builder setCacheModel(boolean r100) {
            this.f32884b = r100;
            return this;
        }

        public Builder setStorageName(String r100) {
            this.f32883a = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private SpStorageConfig() {
    }

    public String getStorageName() {
        return this.f32881a;
    }

    public boolean isCacheModel() {
        return this.f32882b;
    }

    public static /* synthetic */ String a(SpStorageConfig r100) {
        return r100.f32881a;
    }

    public static /* synthetic */ boolean b(SpStorageConfig r100) {
        return r100.f32882b;
    }

    private SpStorageConfig(String r100, boolean r101) {
        this.f32881a = r100;
        this.f32882b = r101;
    }

    public /* synthetic */ SpStorageConfig(String r100, boolean r101, a r102) {
        this(r100, r101);
    }
}
