package com.stepos.core.ota.crypto;

import com.stepos.core.ota.domain.port.OtaLogger;
import com.stepos.core.ota.domain.port.PayloadKeyUnavailableException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import qb.b;
import rb.c;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyCenterFekCipherSource implements FekCipherSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "KeyCenterFekSource";
    private final KeyCenterClient client;
    private final a<String> deviceIdProvider;
    private final DeviceKeyStore keyStore;
    private final OtaLogger log;
    private final KeyCenterDeviceRegistrar registrar;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.KeyCenterFekCipherSource", f = "KeyCenterDeviceRegistrar.kt", l = {213, 214}, m = "retryAfterReregister")
    /* renamed from: com.stepos.core.ota.crypto.KeyCenterFekCipherSource$retryAfterReregister$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KeyCenterFekCipherSource.this.retryAfterReregister(null, null, this);
        }
    }

    public KeyCenterFekCipherSource(KeyCenterDeviceRegistrar registrar, KeyCenterClient client, DeviceKeyStore keyStore, a<String> deviceIdProvider, OtaLogger log) {
        g.f(registrar, "registrar");
        g.f(client, "client");
        g.f(keyStore, "keyStore");
        g.f(deviceIdProvider, "deviceIdProvider");
        g.f(log, "log");
        this.registrar = registrar;
        this.client = client;
        this.keyStore = keyStore;
        this.deviceIdProvider = deviceIdProvider;
        this.log = log;
    }

    private final Throwable asKeyUnavailable(Throwable th) {
        return th instanceof PayloadKeyUnavailableException ? th : new PayloadKeyUnavailableException(ai.onnxruntime.a.k("rewrap failed: ", th.getMessage()), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r6 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object retryAfterReregister(java.lang.String r6, java.lang.String r7, qb.b<? super com.stepos.core.ota.crypto.FekEnvelopeCipher> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.crypto.KeyCenterFekCipherSource.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.crypto.KeyCenterFekCipherSource$retryAfterReregister$1 r0 = (com.stepos.core.ota.crypto.KeyCenterFekCipherSource.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.KeyCenterFekCipherSource$retryAfterReregister$1 r0 = new com.stepos.core.ota.crypto.KeyCenterFekCipherSource$retryAfterReregister$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ota.crypto.KeyCenterFekCipherSource r5 = (com.stepos.core.ota.crypto.KeyCenterFekCipherSource) r5
            kotlin.c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.f9987a
            goto L7c
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ota.crypto.KeyCenterFekCipherSource r5 = (com.stepos.core.ota.crypto.KeyCenterFekCipherSource) r5
            kotlin.c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.f9987a
            goto L64
        L50:
            kotlin.c.b(r8)
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar r8 = r5.registrar
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.m131reregisterIoAF18A(r0)
            if (r8 != r1) goto L64
            goto L7b
        L64:
            java.lang.Throwable r8 = kotlin.Result.b(r8)
            if (r8 != 0) goto L88
            com.stepos.core.ota.crypto.KeyCenterClient r8 = r5.client
            r0.L$0 = r5
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.m130rewrap0E7RQCE(r6, r7, r0)
            if (r6 != r1) goto L7c
        L7b:
            return r1
        L7c:
            java.lang.Throwable r7 = kotlin.Result.b(r6)
            if (r7 != 0) goto L83
            return r6
        L83:
            java.lang.Throwable r5 = r5.asKeyUnavailable(r7)
            throw r5
        L88:
            java.lang.Throwable r5 = r5.asKeyUnavailable(r8)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterFekCipherSource.retryAfterReregister(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:87|(1:(1:(1:(1:(4:14|15|69|(4:71|(1:73)(1:74)|75|76)(2:77|91))(2:17|18))(5:19|20|61|62|(2:64|90)(3:65|(3:68|69|(0)(0))|67)))(9:22|88|23|24|83|40|41|47|(3:50|(1:52)(1:53)|(2:78|79)(2:57|(2:59|67)(4:60|61|62|(0)(0))))(3:49|62|(0)(0))))(3:27|28|29))(3:30|31|(2:33|67)(1:34))|35|85|36|(6:39|83|40|41|47|(0)(0))|67) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        r19 = r7;
        r7 = r1;
        r1 = r19;
        r19 = r10;
        r20 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c A[Catch: all -> 0x0207, TryCatch #2 {all -> 0x0207, blocks: (B:15:0x003e, B:69:0x01c2, B:71:0x01d4, B:73:0x01e2, B:75:0x01e8, B:76:0x01ff, B:20:0x005b, B:61:0x016e, B:62:0x0174, B:65:0x0182, B:47:0x0125, B:50:0x012c, B:52:0x0130, B:55:0x0137, B:57:0x013d, B:78:0x0202, B:79:0x0206, B:46:0x0120, B:28:0x00a6, B:35:0x00d7, B:31:0x00b6), top: B:87:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0182 A[Catch: all -> 0x0207, TryCatch #2 {all -> 0x0207, blocks: (B:15:0x003e, B:69:0x01c2, B:71:0x01d4, B:73:0x01e2, B:75:0x01e8, B:76:0x01ff, B:20:0x005b, B:61:0x016e, B:62:0x0174, B:65:0x0182, B:47:0x0125, B:50:0x012c, B:52:0x0130, B:55:0x0137, B:57:0x013d, B:78:0x0202, B:79:0x0206, B:46:0x0120, B:28:0x00a6, B:35:0x00d7, B:31:0x00b6), top: B:87:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d4 A[Catch: all -> 0x0207, TryCatch #2 {all -> 0x0207, blocks: (B:15:0x003e, B:69:0x01c2, B:71:0x01d4, B:73:0x01e2, B:75:0x01e8, B:76:0x01ff, B:20:0x005b, B:61:0x016e, B:62:0x0174, B:65:0x0182, B:47:0x0125, B:50:0x012c, B:52:0x0130, B:55:0x0137, B:57:0x013d, B:78:0x0202, B:79:0x0206, B:46:0x0120, B:28:0x00a6, B:35:0x00d7, B:31:0x00b6), top: B:87:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // com.stepos.core.ota.crypto.FekCipherSource
    /* renamed from: obtain-BWLJW6A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo121obtainBWLJW6A(java.lang.String r23, int r24, java.lang.String r25, qb.b<? super kotlin.Result<com.stepos.core.ota.crypto.FekEnvelopeCipher>> r26) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterFekCipherSource.mo121obtainBWLJW6A(java.lang.String, int, java.lang.String, qb.b):java.lang.Object");
    }
}
