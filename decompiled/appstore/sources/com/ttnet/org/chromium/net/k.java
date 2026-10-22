package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements NetworkChangeNotifier.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkChangeNotifier.Natives f18946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18947b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(NetworkChangeNotifier.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            k.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((NetworkChangeNotifier.Natives) r10);
        }
    }

    static {
        f18947b = new a();
    }

    public k() {
    }

    public static /* synthetic */ NetworkChangeNotifier.Natives a(NetworkChangeNotifier.Natives r10) {
        f18946a = r10;
        return r10;
    }

    public static NetworkChangeNotifier.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        NetworkChangeNotifier.Natives r10 = f18946a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new k();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionTypeChanged(long r10, NetworkChangeNotifier r11, int r12, long r13) {
        kf.a.F(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyMaxBandwidthChanged(long r10, NetworkChangeNotifier r11, int r12) {
        kf.a.G(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkConnect(long r10, NetworkChangeNotifier r11, long r12, int r13) {
        kf.a.H(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkDisconnect(long r10, NetworkChangeNotifier r11, long r12) {
        kf.a.I(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkSoonToDisconnect(long r10, NetworkChangeNotifier r11, long r12) {
        kf.a.J(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyPurgeActiveNetworkList(long r10, NetworkChangeNotifier r11, long[] r12) {
        kf.a.K(r10, r11, r12);
    }
}
