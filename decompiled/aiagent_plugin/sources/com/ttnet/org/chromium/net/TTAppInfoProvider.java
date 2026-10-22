package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        private String A;
        private String B;
        private String C;
        private String D;
        private String E;
        private String F;
        private String G;
        private String H;
        private String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private String f37854J;
        private String K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f37855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f37856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f37857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f37858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f37859e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;

        public AppInfo() {
        }

        public String getUserId() {
            return this.r;
        }

        public void a(String r1) {
            this.r = r1;
        }

        public String getAppId() {
            return this.f37855a;
        }

        public void b(String r1) {
            this.f37855a = r1;
        }

        public String getOSApi() {
            return this.s;
        }

        public void c(String r1) {
            this.s = r1;
        }

        public String getDeviceId() {
            return this.t;
        }

        public void d(String r1) {
            this.t = r1;
        }

        public String getNetAccessType() {
            return this.u;
        }

        public void e(String r1) {
            this.u = r1;
        }

        public String getVersionCode() {
            return this.f37857c;
        }

        public void f(String r1) {
            this.f37857c = r1;
        }

        public String getDeviceType() {
            return this.v;
        }

        public void g(String r1) {
            this.v = r1;
        }

        public String getAppName() {
            return this.w;
        }

        public void h(String r1) {
            this.w = r1;
        }

        public String getSdkAppID() {
            return this.x;
        }

        public void i(String r1) {
            this.x = r1;
        }

        public String getSdkVersion() {
            return this.y;
        }

        public void j(String r1) {
            this.y = r1;
        }

        public String getChannel() {
            return this.f37859e;
        }

        public void k(String r1) {
            this.f37859e = r1;
        }

        public String getOSVersion() {
            return this.z;
        }

        public void l(String r1) {
            this.z = r1;
        }

        public String getDevicePlatform() {
            return this.f37856b;
        }

        public void m(String r1) {
            this.f37856b = r1;
        }

        public String getDeviceBrand() {
            return this.A;
        }

        public void n(String r1) {
            this.A = r1;
        }

        public void o(String r1) {
            this.B = r1;
        }

        public String getDeviceModel() {
            return this.B;
        }

        public String getVersionName() {
            return this.C;
        }

        public void p(String r1) {
            this.C = r1;
        }

        public String getUpdateVersionCode() {
            return this.f37858d;
        }

        public void q(String r1) {
            this.f37858d = r1;
        }

        public String getManifestVersionCode() {
            return this.D;
        }

        public void r(String r1) {
            this.D = r1;
        }

        public String getAbi() {
            return this.E;
        }

        public void s(String r1) {
            this.E = r1;
        }

        public String getHostFirst() {
            return this.g;
        }

        public void t(String r1) {
            this.g = r1;
        }

        public String getHostSecond() {
            return this.h;
        }

        public void u(String r1) {
            this.h = r1;
        }

        public String getHostThird() {
            return this.i;
        }

        public void v(String r1) {
            this.i = r1;
        }

        public String getDomainHttpDns() {
            return this.j;
        }

        public void w(String r1) {
            this.j = r1;
        }

        public String getDomainBoe() {
            return this.k;
        }

        public void x(String r1) {
            this.k = r1;
        }

        public String getDomainBoeHttps() {
            return this.l;
        }

        public void y(String r1) {
            this.l = r1;
        }

        public String getIsDropFirstTnc() {
            return this.F;
        }

        public void z(String r1) {
            this.F = r1;
        }

        public String getStoreIdc() {
            return this.G;
        }

        public void A(String r1) {
            this.G = r1;
        }

        public String getRegion() {
            return this.m;
        }

        public void B(String r1) {
            this.m = r1;
        }

        public String getSysRegion() {
            return this.n;
        }

        public void C(String r1) {
            this.n = r1;
        }

        public String getCarrierRegion() {
            return this.o;
        }

        public void D(String r1) {
            this.o = r1;
        }

        public String getInitRegion() {
            return this.p;
        }

        public void E(String r1) {
            this.p = r1;
        }

        public String getTNCRequestHeader() {
            return this.H;
        }

        public void F(String r1) {
            this.H = r1;
        }

        public String getTNCRequestQuery() {
            return this.I;
        }

        public void G(String r1) {
            this.I = r1;
        }

        public String getTNCRequestFlags() {
            return this.f37854J;
        }

        public void H(String r1) {
            this.f37854J = r1;
        }

        public String getHttpDnsRequestFlags() {
            return this.q;
        }

        public void I(String r1) {
            this.q = r1;
        }

        public String getIsDomestic() {
            return this.K;
        }

        public void J(String r1) {
            this.K = r1;
        }

        public String getAbSdkVersion() {
            return this.f;
        }

        public void K(String r1) {
            this.f = r1;
        }
    }

    public abstract AppInfo a();

    public TTAppInfoProvider() {
    }
}
