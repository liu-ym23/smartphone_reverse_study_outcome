package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
class EarlyTraceEventJni implements EarlyTraceEvent.Natives {
    public static final JniStaticTestMocker<EarlyTraceEvent.Natives> TEST_HOOKS = null;
    private static EarlyTraceEvent.Natives testInstance;

    EarlyTraceEventJni() {
    }

    static /* synthetic */ EarlyTraceEvent.Natives access$002(EarlyTraceEvent.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyBeginEvent(String r1, long r2, int r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyEndEvent(String r1, long r2, int r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelBeginEvent(String r1, long r2, int r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelEndEvent(String r1, long r2, int r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncBeginEvent(String r1, long r2, long r4) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncEndEvent(String r1, long r2, long r4) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(r1, r2, r4);
    }

    public static EarlyTraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        EarlyTraceEvent.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new EarlyTraceEventJni();
    }
}
