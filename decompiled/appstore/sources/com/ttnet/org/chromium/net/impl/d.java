package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements CronetUploadDataStream.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetUploadDataStream.Natives f18796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18797b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(CronetUploadDataStream.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            d.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetUploadDataStream.Natives) r10);
        }
    }

    static {
        f18797b = new a();
    }

    public d() {
    }

    public static /* synthetic */ CronetUploadDataStream.Natives a(CronetUploadDataStream.Natives r10) {
        f18796a = r10;
        return r10;
    }

    public static CronetUploadDataStream.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetUploadDataStream.Natives r10 = f18796a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new d();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long attachUploadDataToRequest(CronetUploadDataStream r10, long r11, long r12) {
        return kf.a.W(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createAdapterForTesting(CronetUploadDataStream r10) {
        return kf.a.X(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createUploadDataStreamForTesting(CronetUploadDataStream r10, long r11, long r12) {
        return kf.a.Y(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void destroy(long r10) {
        kf.a.Z(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onReadSucceeded(long r10, CronetUploadDataStream r11, int r12, boolean r13) {
        kf.a.a0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onRewindSucceeded(long r10, CronetUploadDataStream r11) {
        kf.a.b0(r10, r11);
    }
}
