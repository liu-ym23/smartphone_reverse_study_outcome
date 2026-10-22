package com.baidu.mapapi;

/* loaded from: classes.dex */
public class CommonInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f5944a;

    /* renamed from: b, reason: collision with root package name */
    private String f5945b;

    /* renamed from: c, reason: collision with root package name */
    private String f5946c;

    /* renamed from: d, reason: collision with root package name */
    private String f5947d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f5948a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f5949b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f5950c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f5951d = "";

        public Builder androidId(String str) {
            this.f5949b = str;
            return this;
        }

        public CommonInfo build() {
            return new CommonInfo(this.f5949b, this.f5948a, this.f5950c, this.f5951d);
        }

        public Builder channel(String str) {
            this.f5950c = str;
            return this;
        }

        public Builder oaid(String str) {
            this.f5948a = str;
            return this;
        }

        public Builder shareDeviceId(String str) {
            this.f5951d = str;
            return this;
        }
    }

    public String getAndroidID() {
        return this.f5945b;
    }

    public String getChannel() {
        return this.f5946c;
    }

    public String getOAID() {
        return this.f5944a;
    }

    public String getShareDeviceId() {
        return this.f5947d;
    }

    public void updateShareDeviceId(String str) {
        this.f5947d = str;
    }

    private CommonInfo(String str, String str2, String str3, String str4) {
        this.f5945b = str;
        this.f5944a = str2;
        this.f5946c = str3;
        this.f5947d = str4;
    }
}
