package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements CronetLibraryLoader.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetLibraryLoader.Natives f18770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18771b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(CronetLibraryLoader.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            b.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetLibraryLoader.Natives) r10);
        }
    }

    static {
        f18771b = new a();
    }

    public b() {
    }

    public static /* synthetic */ CronetLibraryLoader.Natives a(CronetLibraryLoader.Natives r10) {
        f18770a = r10;
        return r10;
    }

    public static CronetLibraryLoader.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetLibraryLoader.Natives r10 = f18770a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new b();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public void cronetInitOnInitThread() {
        kf.a.U();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public String getCronetVersion() {
        return kf.a.V();
    }
}
