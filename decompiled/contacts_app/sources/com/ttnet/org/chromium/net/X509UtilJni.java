package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
class X509UtilJni implements X509Util.Natives {
    public static final JniStaticTestMocker<X509Util.Natives> TEST_HOOKS = null;
    private static X509Util.Natives testInstance;

    X509UtilJni() {
    }

    static /* synthetic */ X509Util.Natives access$002(X509Util.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.X509Util.Natives
    public void notifyKeyChainChanged() {
        GEN_JNI.com_ttnet_org_chromium_net_X509Util_notifyKeyChainChanged();
    }

    public static X509Util.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        X509Util.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.X509Util.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new X509UtilJni();
    }
}
