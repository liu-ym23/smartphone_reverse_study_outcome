package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
class JavaHandlerThreadJni implements JavaHandlerThread.Natives {
    public static final JniStaticTestMocker<JavaHandlerThread.Natives> TEST_HOOKS = null;
    private static JavaHandlerThread.Natives testInstance;

    JavaHandlerThreadJni() {
    }

    static /* synthetic */ JavaHandlerThread.Natives access$002(JavaHandlerThread.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void initializeThread(long r1, long r3) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(r1, r3);
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void onLooperStopped(long r1) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(r1);
    }

    public static JavaHandlerThread.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JavaHandlerThread.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaHandlerThread.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaHandlerThreadJni();
    }
}
