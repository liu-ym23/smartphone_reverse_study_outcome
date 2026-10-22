package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements CronetUrlRequestContext.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetUrlRequestContext.Natives f18798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18799b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(CronetUrlRequestContext.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            e.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetUrlRequestContext.Natives) r10);
        }
    }

    static {
        f18799b = new a();
    }

    public e() {
    }

    public static /* synthetic */ CronetUrlRequestContext.Natives a(CronetUrlRequestContext.Natives r10) {
        f18798a = r10;
        return r10;
    }

    public static CronetUrlRequestContext.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetUrlRequestContext.Natives r10 = f18798a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new e();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addClientOpaqueData(long r10, CronetUrlRequestContext r11, String[] r12, byte[] r13, byte[] r14) {
        kf.a.c0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addPkp(long r10, String r11, byte[][] r12, boolean r13, long r14) {
        kf.a.d0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addQuicHint(long r10, String r11, int r12, int r13) {
        kf.a.e0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void clearClientOpaqueData(long r10, CronetUrlRequestContext r11) {
        kf.a.f0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void configureNetworkQualityEstimatorForTesting(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14) {
        kf.a.g0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void controlHttpDNSConfig(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14) {
        kf.a.h0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextAdapter(long r10) {
        return kf.a.i0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextConfig(String r10, String r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, int r17, long r18, String r19, long r110, boolean r111, boolean r112, boolean r113, boolean r114, String r20, int r21) {
        return kf.a.j0(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void destroy(long r10, CronetUrlRequestContext r11) {
        kf.a.k0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void dnsLookup(long r10, CronetUrlRequestContext r11, DnsQuery r12) {
        kf.a.l0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableBoeProxy(long r10, boolean r11) {
        kf.a.m0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableTTBizHttpDns(long r10, CronetUrlRequestContext r11, boolean r12, String r13, String r14, String r15, boolean r16, String r17) {
        kf.a.n0(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public byte[] getHistogramDeltas() {
        return kf.a.o0();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long[] getOpaqueFuncAddress() {
        return kf.a.p0();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initALogFuncAddr(long r10) {
        kf.a.q0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initRequestContextOnInitThread(long r10, CronetUrlRequestContext r11) {
        kf.a.r0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void notifySwitchToMultiNetwork(long r10, CronetUrlRequestContext r11, boolean r12) {
        kf.a.s0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void notifyTNCConfigUpdated(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        kf.a.t0(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void preconnectUrl(long r10, CronetUrlRequestContext r11, String r12, int r13) {
        kf.a.u0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideRTTObservations(long r10, CronetUrlRequestContext r11, boolean r12) {
        kf.a.v0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideThroughputObservations(long r10, CronetUrlRequestContext r11, boolean r12) {
        kf.a.w0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void removeClientOpaqueData(long r10, CronetUrlRequestContext r11, String r12) {
        kf.a.x0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void reportNetDiagnosisUserLog(long r10, CronetUrlRequestContext r11, String r12) {
        kf.a.y0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAlogFuncAddr(long r10, CronetUrlRequestContext r11, long r12) {
        kf.a.z0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAppStartUpState(long r10, CronetUrlRequestContext r11, int r12) {
        kf.a.A0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setBypassBOEJSON(long r10, String r11) {
        kf.a.B0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setClientOpaqueData(long r10, String[] r11, byte[] r12, byte[] r13) {
        kf.a.C0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setGetDomainDefaultJSON(long r10, String r11) {
        kf.a.D0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setHostResolverRules(long r10, CronetUrlRequestContext r11, String r12) {
        kf.a.E0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public int setMinLogLevel(int r10) {
        return kf.a.F0(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setOpaqueData(long r10, byte[][] r11) {
        kf.a.G0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxy(long r10, CronetUrlRequestContext r11, String r12) {
        kf.a.H0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxyConfig(long r10, String r11) {
        kf.a.I0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setStoreIdcRuleJSON(long r10, String r11) {
        kf.a.J0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startNetLogToDisk(long r10, CronetUrlRequestContext r11, String r12, boolean r13, int r14) {
        kf.a.K0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean startNetLogToFile(long r10, CronetUrlRequestContext r11, String r12, boolean r13) {
        return kf.a.L0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopNetLog(long r10, CronetUrlRequestContext r11) {
        kf.a.M0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tiggerWiFiToCellularByThirdParty(long r10, CronetUrlRequestContext r11) {
        kf.a.N0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerGetDomain(long r10, CronetUrlRequestContext r11, boolean r12) {
        kf.a.O0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tryStartNetDetect(long r10, CronetUrlRequestContext r11, String[] r12, int r13, int r14) {
        kf.a.P0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttDnsResolve(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14) {
        kf.a.Q0(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttUrlDispatch(long r10, CronetUrlRequestContext r11, URLDispatch r12, String r13) {
        kf.a.R0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void updateStoreRegionFromServer(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        kf.a.S0(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
