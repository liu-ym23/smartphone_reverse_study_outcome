package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String H;
        public String I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f18446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f18447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f18448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f18449e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f18450f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f18451g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f18452h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f18453i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f18454j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f18455k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f18456l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f18457m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f18458n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f18459o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f18460p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f18461q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f18462r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f18463s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f18464t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f18465u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f18466v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f18467w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f18468x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f18469y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f18470z;

        public AppInfo() {
        }

        public void A(String r10) {
            this.B = r10;
        }

        public void B(String r10) {
            this.D = r10;
        }

        public void C(String r10) {
            this.H = r10;
        }

        public void D(String r10) {
            this.F = r10;
        }

        public void E(String r10) {
            this.G = r10;
        }

        public void F(String r10) {
            this.f18461q = r10;
        }

        public void G(String r10) {
            this.f18445a = r10;
        }

        public void H(String r10) {
            this.f18450f = r10;
        }

        public void I(String r10) {
            this.f18460p = r10;
        }

        public void a(String r10) {
            this.f18463s = r10;
        }

        public void b(String r10) {
            this.f18446b = r10;
        }

        public void c(String r10) {
            this.f18452h = r10;
        }

        public void d(String r10) {
            this.E = r10;
        }

        public void e(String r10) {
            this.f18455k = r10;
        }

        public void f(String r10) {
            this.f18458n = r10;
        }

        public void g(String r10) {
            this.f18448d = r10;
        }

        @CalledByNative
        public String getAbi() {
            return this.f18463s;
        }

        @CalledByNative
        public String getAppId() {
            return this.f18446b;
        }

        @CalledByNative
        public String getAppName() {
            return this.f18452h;
        }

        @CalledByNative
        public String getCarrierRegion() {
            return this.E;
        }

        @CalledByNative
        public String getChannel() {
            return this.f18455k;
        }

        @CalledByNative
        public String getDeviceBrand() {
            return this.f18458n;
        }

        @CalledByNative
        public String getDeviceId() {
            return this.f18448d;
        }

        @CalledByNative
        public String getDeviceModel() {
            return this.f18459o;
        }

        @CalledByNative
        public String getDevicePlatform() {
            return this.f18457m;
        }

        @CalledByNative
        public String getDeviceType() {
            return this.f18451g;
        }

        @CalledByNative
        public String getDomainBoe() {
            return this.f18469y;
        }

        @CalledByNative
        public String getDomainBoeHttps() {
            return this.f18470z;
        }

        @CalledByNative
        public String getDomainHttpDns() {
            return this.f18467w;
        }

        @CalledByNative
        public String getDomainNetlog() {
            return this.f18468x;
        }

        @CalledByNative
        public String getHostFirst() {
            return this.f18464t;
        }

        @CalledByNative
        public String getHostSecond() {
            return this.f18465u;
        }

        @CalledByNative
        public String getHostThird() {
            return this.f18466v;
        }

        @CalledByNative
        public String getHttpDnsRequestFlags() {
            return this.I;
        }

        @CalledByNative
        public String getIsMainProcess() {
            return this.A;
        }

        @CalledByNative
        public String getManifestVersionCode() {
            return this.f18462r;
        }

        @CalledByNative
        public String getNetAccessType() {
            return this.f18449e;
        }

        @CalledByNative
        public String getOSApi() {
            return this.f18447c;
        }

        @CalledByNative
        public String getOSVersion() {
            return this.f18456l;
        }

        @CalledByNative
        public String getRegion() {
            return this.C;
        }

        @CalledByNative
        public String getSdkAppID() {
            return this.f18453i;
        }

        @CalledByNative
        public String getSdkVersion() {
            return this.f18454j;
        }

        @CalledByNative
        public String getStoreIdc() {
            return this.B;
        }

        @CalledByNative
        public String getSysRegion() {
            return this.D;
        }

        @CalledByNative
        public String getTNCRequestFlags() {
            return this.H;
        }

        @CalledByNative
        public String getTNCRequestHeader() {
            return this.F;
        }

        @CalledByNative
        public String getTNCRequestQuery() {
            return this.G;
        }

        @CalledByNative
        public String getUpdateVersionCode() {
            return this.f18461q;
        }

        @CalledByNative
        public String getUserId() {
            return this.f18445a;
        }

        @CalledByNative
        public String getVersionCode() {
            return this.f18450f;
        }

        @CalledByNative
        public String getVersionName() {
            return this.f18460p;
        }

        public void h(String r10) {
            this.f18459o = r10;
        }

        public void i(String r10) {
            this.f18457m = r10;
        }

        public void j(String r10) {
            this.f18451g = r10;
        }

        public void k(String r10) {
            this.f18469y = r10;
        }

        public void l(String r10) {
            this.f18470z = r10;
        }

        public void m(String r10) {
            this.f18467w = r10;
        }

        public void n(String r10) {
            this.f18468x = r10;
        }

        public void o(String r10) {
            this.f18464t = r10;
        }

        public void p(String r10) {
            this.f18465u = r10;
        }

        public void q(String r10) {
            this.f18466v = r10;
        }

        public void r(String r10) {
            this.I = r10;
        }

        public void s(String r10) {
            this.A = r10;
        }

        public void t(String r10) {
            this.f18462r = r10;
        }

        public void u(String r10) {
            this.f18449e = r10;
        }

        public void v(String r10) {
            this.f18447c = r10;
        }

        public void w(String r10) {
            this.f18456l = r10;
        }

        public void x(String r10) {
            this.C = r10;
        }

        public void y(String r10) {
            this.f18453i = r10;
        }

        public void z(String r10) {
            this.f18454j = r10;
        }
    }

    public TTAppInfoProvider() {
    }

    public abstract AppInfo a();
}
