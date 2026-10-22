package com.baidu.mapapi;

/* JADX INFO: loaded from: classes39.dex */
public class CommonInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f30487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f30488d;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f30492d;

        public CommonInfo build() {
            return new CommonInfo(this.f30490b, this.f30489a, this.f30491c, this.f30492d, null);
        }

        public Builder() {
            this.f30489a = "";
            this.f30490b = "";
            this.f30491c = "";
            this.f30492d = "";
        }

        public Builder androidId(String r100) {
            this.f30490b = r100;
            return this;
        }

        public Builder channel(String r100) {
            this.f30491c = r100;
            return this;
        }

        public Builder oaid(String r100) {
            this.f30489a = r100;
            return this;
        }

        public Builder shareDeviceId(String r100) {
            this.f30492d = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    public String getAndroidID() {
        return this.f30486b;
    }

    public String getChannel() {
        return this.f30487c;
    }

    public String getOAID() {
        return this.f30485a;
    }

    public String getShareDeviceId() {
        return this.f30488d;
    }

    public void updateShareDeviceId(String r100) {
        this.f30488d = r100;
    }

    private CommonInfo(String r100, String r101, String r102, String r103) {
        this.f30486b = r100;
        this.f30485a = r101;
        this.f30487c = r102;
        this.f30488d = r103;
    }

    public /* synthetic */ CommonInfo(String r100, String r101, String r102, String r103, a r104) {
        this(r100, r101, r102, r103);
    }
}
