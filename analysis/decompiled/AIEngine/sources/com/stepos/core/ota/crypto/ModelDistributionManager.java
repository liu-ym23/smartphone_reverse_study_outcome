package com.stepos.core.ota.crypto;

import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.domain.port.OtaLogger;
import com.stepos.core.ota.domain.port.PayloadDecryptor;
import com.stepos.core.ota.domain.port.PayloadKeyUnavailableException;
import gc.r;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDistributionManager implements PayloadDecryptor {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAGIC_BYTES = 4;

    @Deprecated
    public static final String TAG = "ModelDistribution";
    private final FekCipherCache cipherCache;
    private final FekCipherSource cipherSource;
    private final IModelCrypto crypto;
    private final String deviceAppId;
    private final a<String> deviceIdProvider;
    private final DeviceKeyStore keyStore;
    private final OtaLogger log;
    private final ModelDecryptProviderRegistry providers;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.ModelDistributionManager", f = "ModelDistributionManager.kt", l = {113}, m = "obtainEnvelope")
    /* renamed from: com.stepos.core.ota.crypto.ModelDistributionManager$obtainEnvelope$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelDistributionManager.this.obtainEnvelope(null, 0, null, this);
        }
    }

    public ModelDistributionManager(IModelCrypto crypto, DeviceKeyStore keyStore, ModelDecryptProviderRegistry providers, FekCipherSource cipherSource, FekCipherCache cipherCache, a<String> deviceIdProvider, OtaLogger log, String deviceAppId) {
        g.f(crypto, "crypto");
        g.f(keyStore, "keyStore");
        g.f(providers, "providers");
        g.f(cipherSource, "cipherSource");
        g.f(cipherCache, "cipherCache");
        g.f(deviceIdProvider, "deviceIdProvider");
        g.f(log, "log");
        g.f(deviceAppId, "deviceAppId");
        this.crypto = crypto;
        this.keyStore = keyStore;
        this.providers = providers;
        this.cipherSource = cipherSource;
        this.cipherCache = cipherCache;
        this.deviceIdProvider = deviceIdProvider;
        this.log = log;
        this.deviceAppId = deviceAppId;
    }

    private final DeviceIdentity buildIdentity(FekEnvelopeCipher fekEnvelopeCipher) throws PayloadKeyUnavailableException {
        String strPublicKeyFingerprint = this.keyStore.publicKeyFingerprint();
        if (strPublicKeyFingerprint == null) {
            throw new PayloadKeyUnavailableException("device key missing, registration required", null, 2, null);
        }
        if (g.b(fekEnvelopeCipher.getFingerprint(), strPublicKeyFingerprint)) {
            return new DeviceIdentity(this.deviceAppId, this.deviceIdProvider.invoke(), strPublicKeyFingerprint);
        }
        throw new PayloadKeyUnavailableException(ai.onnxruntime.a.l("device public key changed: server=", r.R0(16, fekEnvelopeCipher.getFingerprint()), " local=", r.R0(16, strPublicKeyFingerprint)), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object obtainEnvelope(java.lang.String r7, int r8, java.lang.String r9, qb.b<? super com.stepos.core.ota.crypto.FekEnvelopeCipher> r10) throws com.stepos.core.ota.domain.port.PayloadKeyUnavailableException {
        /*
            r6 = this;
            java.lang.String r0 = "encrypted payload but no dekCipher: "
            boolean r1 = r10 instanceof com.stepos.core.ota.crypto.ModelDistributionManager.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r10
            com.stepos.core.ota.crypto.ModelDistributionManager$obtainEnvelope$1 r1 = (com.stepos.core.ota.crypto.ModelDistributionManager.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ota.crypto.ModelDistributionManager$obtainEnvelope$1 r1 = new com.stepos.core.ota.crypto.ModelDistributionManager$obtainEnvelope$1
            r1.<init>(r10)
        L1a:
            java.lang.Object r10 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            java.lang.String r4 = " v"
            r5 = 1
            if (r3 == 0) goto L44
            if (r3 != r5) goto L3c
            int r8 = r1.I$0
            java.lang.Object r6 = r1.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r1.L$0
            com.stepos.core.ota.crypto.ModelDistributionManager r6 = (com.stepos.core.ota.crypto.ModelDistributionManager) r6
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            kotlin.Result r10 = (kotlin.Result) r10     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            java.lang.Object r9 = r10.f9987a     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            goto L66
        L3a:
            r6 = move-exception
            goto L91
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.c.b(r10)
            boolean r10 = gc.q.t0(r9)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            if (r10 != 0) goto L75
            com.stepos.core.ota.crypto.FekCipherCache r10 = r6.cipherCache     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            com.stepos.core.ota.crypto.FekEnvelopeCipher r10 = r10.get(r7, r8)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            if (r10 != 0) goto L74
            com.stepos.core.ota.crypto.FekCipherSource r10 = r6.cipherSource     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r1.L$0 = r6     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r1.L$1 = r7     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r1.I$0 = r8     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r1.label = r5     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            java.lang.Object r9 = r10.mo121obtainBWLJW6A(r7, r8, r9, r1)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            if (r9 != r2) goto L66
            return r2
        L66:
            kotlin.c.b(r9)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r10 = r9
            com.stepos.core.ota.crypto.FekEnvelopeCipher r10 = (com.stepos.core.ota.crypto.FekEnvelopeCipher) r10     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            com.stepos.core.ota.crypto.FekCipherCache r6 = r6.cipherCache     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r6.put(r7, r8, r10)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            com.stepos.core.ota.crypto.FekEnvelopeCipher r9 = (com.stepos.core.ota.crypto.FekEnvelopeCipher) r9     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            return r9
        L74:
            return r10
        L75:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r6.append(r7)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r6.append(r4)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r6.append(r8)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            r9.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
            throw r9     // Catch: java.lang.Throwable -> L3a com.stepos.core.ota.domain.port.PayloadKeyUnavailableException -> Laa
        L91:
            com.stepos.core.ota.domain.port.PayloadKeyUnavailableException r9 = new com.stepos.core.ota.domain.port.PayloadKeyUnavailableException
            java.lang.String r10 = r6.getMessage()
            java.lang.String r0 = "cannot obtain envelope for "
            java.lang.String r1 = ": "
            java.lang.StringBuilder r7 = h0.e.f(r0, r7, r4, r8, r1)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r9.<init>(r7, r6)
            throw r9
        Laa:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelDistributionManager.obtainEnvelope(java.lang.String, int, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: classify-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m135classifygIAlus(java.lang.String r5, qb.b<? super kotlin.Result<? extends com.stepos.core.ota.crypto.PayloadKind>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ota.crypto.ModelDistributionManager$classify$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ota.crypto.ModelDistributionManager$classify$1 r0 = (com.stepos.core.ota.crypto.ModelDistributionManager$classify$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelDistributionManager$classify$1 r0 = new com.stepos.core.ota.crypto.ModelDistributionManager$classify$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.c.b(r4)
            goto L45
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r4)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelDistributionManager$classify$2 r1 = new com.stepos.core.ota.crypto.ModelDistributionManager$classify$2
            r3 = 0
            r1.<init>(r5, r3)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r4, r1, r0)
            if (r4 != r6) goto L45
            return r6
        L45:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.f9987a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelDistributionManager.m135classifygIAlus(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.PayloadDecryptor
    /* renamed from: isEncrypted-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo136isEncryptedgIAlus(java.lang.String r5, qb.b<? super kotlin.Result<java.lang.Boolean>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ota.crypto.ModelDistributionManager$isEncrypted$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ota.crypto.ModelDistributionManager$isEncrypted$1 r0 = (com.stepos.core.ota.crypto.ModelDistributionManager$isEncrypted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelDistributionManager$isEncrypted$1 r0 = new com.stepos.core.ota.crypto.ModelDistributionManager$isEncrypted$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.f9987a
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r6)
            r0.label = r3
            java.lang.Object r4 = r4.m135classifygIAlus(r5, r0)
            if (r4 != r1) goto L3f
            return r1
        L3f:
            boolean r5 = r4 instanceof kotlin.Result.Failure
            if (r5 != 0) goto L4f
            com.stepos.core.ota.crypto.PayloadKind r4 = (com.stepos.core.ota.crypto.PayloadKind) r4
            com.stepos.core.ota.crypto.PayloadKind r5 = com.stepos.core.ota.crypto.PayloadKind.ENCRYPTED
            if (r4 != r5) goto L4a
            goto L4b
        L4a:
            r3 = 0
        L4b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelDistributionManager.mo136isEncryptedgIAlus(java.lang.String, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.port.PayloadDecryptor
    public void onInstallSucceeded(String modelId, int i10) {
        g.f(modelId, "modelId");
        this.cipherCache.remove(modelId, i10);
    }

    public final void onKeyInvalidated(String modelId, int i10) {
        g.f(modelId, "modelId");
        this.cipherCache.remove(modelId, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0164, code lost:
    
        if (r2 == r7) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0124 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:15:0x0044, B:48:0x0167, B:50:0x016d, B:52:0x0170, B:53:0x0175, B:20:0x006f, B:43:0x0120, B:45:0x0124, B:54:0x0176, B:55:0x01ac, B:23:0x008c, B:39:0x00f2, B:26:0x00a4, B:33:0x00d0, B:35:0x00d6, B:56:0x01ad, B:57:0x01c4, B:29:0x00b1), top: B:61:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0176 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:15:0x0044, B:48:0x0167, B:50:0x016d, B:52:0x0170, B:53:0x0175, B:20:0x006f, B:43:0x0120, B:45:0x0124, B:54:0x0176, B:55:0x01ac, B:23:0x008c, B:39:0x00f2, B:26:0x00a4, B:33:0x00d0, B:35:0x00d6, B:56:0x01ad, B:57:0x01c4, B:29:0x00b1), top: B:61:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // com.stepos.core.ota.domain.port.PayloadDecryptor
    /* renamed from: openDecryptedStream-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo137openDecryptedStreamyxL6bBk(java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, qb.b<? super kotlin.Result<? extends java.io.InputStream>> r22) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelDistributionManager.mo137openDecryptedStreamyxL6bBk(java.lang.String, java.lang.String, int, java.lang.String, qb.b):java.lang.Object");
    }

    public /* synthetic */ ModelDistributionManager(IModelCrypto iModelCrypto, DeviceKeyStore deviceKeyStore, ModelDecryptProviderRegistry modelDecryptProviderRegistry, FekCipherSource fekCipherSource, FekCipherCache fekCipherCache, a aVar, OtaLogger otaLogger, String str, int i10, e eVar) {
        this(iModelCrypto, deviceKeyStore, modelDecryptProviderRegistry, fekCipherSource, fekCipherCache, aVar, otaLogger, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? KeyCenterClient.DEVICE_APP_ID : str);
    }
}
