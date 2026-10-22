package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements X509Util.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static X509Util.Natives f18487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18488b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(X509Util.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            c0.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((X509Util.Natives) r10);
        }
    }

    static {
        f18488b = new a();
    }

    public c0() {
    }

    public static /* synthetic */ X509Util.Natives a(X509Util.Natives r10) {
        f18487a = r10;
        return r10;
    }

    public static X509Util.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        X509Util.Natives r10 = f18487a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.X509Util.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new c0();
    }

    @Override // com.ttnet.org.chromium.net.X509Util.Natives
    public void notifyKeyChainChanged() {
        kf.a.N();
    }
}
