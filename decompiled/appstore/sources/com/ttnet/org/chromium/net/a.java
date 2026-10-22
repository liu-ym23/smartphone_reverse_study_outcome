package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements AndroidNetworkLibrary.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AndroidNetworkLibrary.Natives f18483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18484b = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.a$a, reason: collision with other inner class name */
    public class C0223a implements JniStaticTestMocker {
        public C0223a() {
        }

        public void a(AndroidNetworkLibrary.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            a.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((AndroidNetworkLibrary.Natives) r10);
        }
    }

    static {
        f18484b = new C0223a();
    }

    public a() {
    }

    public static /* synthetic */ AndroidNetworkLibrary.Natives a(AndroidNetworkLibrary.Natives r10) {
        f18483a = r10;
        return r10;
    }

    public static AndroidNetworkLibrary.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        AndroidNetworkLibrary.Natives r10 = f18483a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new a();
    }

    @Override // com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives
    public void onCellularAlwaysUp(boolean r10) {
        kf.a.C(r10);
    }
}
