package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements ProxyChangeListener.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ProxyChangeListener.Natives f18953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18954b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(ProxyChangeListener.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            q.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((ProxyChangeListener.Natives) r10);
        }
    }

    static {
        f18954b = new a();
    }

    public q() {
    }

    public static /* synthetic */ ProxyChangeListener.Natives a(ProxyChangeListener.Natives r10) {
        f18953a = r10;
        return r10;
    }

    public static ProxyChangeListener.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        ProxyChangeListener.Natives r10 = f18953a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new q();
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long r10, ProxyChangeListener r11) {
        kf.a.L(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long r10, ProxyChangeListener r11, String r12, int r13, String r14, String[] r15) {
        kf.a.M(r10, r11, r12, r13, r14, r15);
    }
}
