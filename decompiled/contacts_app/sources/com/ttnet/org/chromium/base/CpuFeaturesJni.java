package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
class CpuFeaturesJni implements CpuFeatures.Natives {
    public static final JniStaticTestMocker<CpuFeatures.Natives> TEST_HOOKS = null;
    private static CpuFeatures.Natives testInstance;

    CpuFeaturesJni() {
    }

    static /* synthetic */ CpuFeatures.Natives access$002(CpuFeatures.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.CpuFeatures.Natives
    public int getCoreCount() {
        return GEN_JNI.com_ttnet_org_chromium_base_CpuFeatures_getCoreCount();
    }

    @Override // com.ttnet.org.chromium.base.CpuFeatures.Natives
    public long getCpuFeatures() {
        return GEN_JNI.com_ttnet_org_chromium_base_CpuFeatures_getCpuFeatures();
    }

    public static CpuFeatures.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CpuFeatures.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.CpuFeatures.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CpuFeaturesJni();
    }
}
