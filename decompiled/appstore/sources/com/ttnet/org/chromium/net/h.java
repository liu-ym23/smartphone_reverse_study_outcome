package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements HttpNegotiateAuthenticator.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HttpNegotiateAuthenticator.Natives f18491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18492b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(HttpNegotiateAuthenticator.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            h.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((HttpNegotiateAuthenticator.Natives) r10);
        }
    }

    static {
        f18492b = new a();
    }

    public h() {
    }

    public static /* synthetic */ HttpNegotiateAuthenticator.Natives a(HttpNegotiateAuthenticator.Natives r10) {
        f18491a = r10;
        return r10;
    }

    public static HttpNegotiateAuthenticator.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        HttpNegotiateAuthenticator.Natives r10 = f18491a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new h();
    }

    @Override // com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives
    public void setResult(long r10, HttpNegotiateAuthenticator r11, int r12, String r13) {
        kf.a.D(r10, r11, r12, r13);
    }
}
