package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements NetworkActivationRequest.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkActivationRequest.Natives f18944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18945b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(NetworkActivationRequest.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            j.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((NetworkActivationRequest.Natives) r10);
        }
    }

    static {
        f18945b = new a();
    }

    public j() {
    }

    public static /* synthetic */ NetworkActivationRequest.Natives a(NetworkActivationRequest.Natives r10) {
        f18944a = r10;
        return r10;
    }

    public static NetworkActivationRequest.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        NetworkActivationRequest.Natives r10 = f18944a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkActivationRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new j();
    }

    @Override // com.ttnet.org.chromium.net.NetworkActivationRequest.Natives
    public void notifyAvailable(long r10, long r11) {
        kf.a.E(r10, r11);
    }
}
