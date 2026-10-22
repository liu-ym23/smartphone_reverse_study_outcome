package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTSamplingSettingProvider {

    public static class TTEventLogSamplingRule {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f37860a;

        public TTEventLogSamplingRule() {
        }

        public String[] getEventLogTypeWhiteList() {
            return this.f37860a;
        }
    }

    public static class TTSlaSamplingRule {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f37861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f37863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String[] f37864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String[] f37865e;
        public String[] f;
        public String[] g;
        public String[] h;
        public String[] i;

        public TTSlaSamplingRule() {
        }

        public boolean isEnableBaseApiAll() {
            return this.f37861a;
        }

        public boolean isEnableApiAllUpload() {
            return this.f37862b;
        }

        public String[] getUrlRegexBlackList() {
            return this.f37863c;
        }

        public String[] getPathEqualWhiteList() {
            return this.f37864d;
        }

        public String[] getPathContainWhiteList() {
            return this.f37865e;
        }

        public String[] getPathPrefixWhiteList() {
            return this.f;
        }

        public String[] getPathRegexWhiteList() {
            return this.g;
        }

        public String[] getUrlRegexWhiteList() {
            return this.h;
        }

        public String[] getHostPatternWhiteList() {
            return this.i;
        }
    }

    public static class TTSlaSamplingSetting {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TTSlaSamplingRule f37868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TTEventLogSamplingRule f37869d;

        public TTSlaSamplingSetting() {
        }

        public int getHostAid() {
            return this.f37866a;
        }

        public int getSdkAid() {
            return this.f37867b;
        }

        public TTSlaSamplingRule getSlaSamplingRule() {
            return this.f37868c;
        }

        public TTEventLogSamplingRule getEventLogSamplingRule() {
            return this.f37869d;
        }
    }
}
