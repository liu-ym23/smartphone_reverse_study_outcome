package com.stepos.core.ota.crypto;

import android.util.Base64;
import com.stepos.core.ota.d;
import com.stepos.core.ota.domain.port.OtaLogger;
import com.stepos.core.ota.domain.port.PayloadKeyUnavailableException;
import gc.q;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mb.l;
import qb.b;
import rb.c;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyCenterDeviceRegistrar implements DeviceRegistrar {
    private static final Companion Companion = new Companion(null);
    private static final Set<Integer> RANDOM_NONCE_SIZES = l.s0(new Integer[]{16, 24, 32, 48, 64});

    @Deprecated
    public static final String TAG = "KeyCenterRegistrar";
    private final KeyCenterClient client;
    private final a<String> deviceIdProvider;
    private final DeviceKeyStore keyStore;
    private final OtaLogger log;
    private final Mutex mutex;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Set<Integer> getRANDOM_NONCE_SIZES() {
            return KeyCenterDeviceRegistrar.RANDOM_NONCE_SIZES;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar", f = "KeyCenterDeviceRegistrar.kt", l = {60, 68}, m = "doRegister")
    /* renamed from: com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$doRegister$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return KeyCenterDeviceRegistrar.this.doRegister(this);
        }
    }

    public KeyCenterDeviceRegistrar(DeviceKeyStore keyStore, KeyCenterClient client, a<String> deviceIdProvider, OtaLogger log) {
        g.f(keyStore, "keyStore");
        g.f(client, "client");
        g.f(deviceIdProvider, "deviceIdProvider");
        g.f(log, "log");
        this.keyStore = keyStore;
        this.client = client;
        this.deviceIdProvider = deviceIdProvider;
        this.log = log;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final String buildProof(String str, String str2) throws PayloadKeyUnavailableException {
        String strFallbackProofKey$ota_release = KeyCenterBootstrap.INSTANCE.fallbackProofKey$ota_release();
        if (q.t0(strFallbackProofKey$ota_release)) {
            throw new PayloadKeyUnavailableException("device cannot attest and no fallback proof key is configured", null, 2, null);
        }
        String strPublicKeyFingerprint = this.keyStore.publicKeyFingerprint();
        if (strPublicKeyFingerprint == null) {
            throw new PayloadKeyUnavailableException("key vanished right after generation", null, 2, null);
        }
        this.log.w(TAG, h0.e.c("device cannot attest, registering a RAW public key with a proof: deviceId=", str, " fingerprint=", strPublicKeyFingerprint, " — server must allowlist this device or register will be rejected"));
        return DeviceProof.INSTANCE.compute(strFallbackProofKey$ota_release, KeyCenterClient.DEVICE_APP_ID, str, str2, strPublicKeyFingerprint);
    }

    private final byte[] challengeToBytes(String str) {
        Object objA;
        try {
            objA = Base64.decode(str, 11);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        byte[] bArr = (byte[]) objA;
        if (bArr != null && RANDOM_NONCE_SIZES.contains(Integer.valueOf(bArr.length))) {
            this.log.i(TAG, d.e(str.length(), "challenge decoded as base64url: ", bArr.length, " chars -> ", " bytes"));
            return bArr;
        }
        this.log.i(TAG, "challenge used as raw ascii: " + str.length() + " bytes");
        byte[] bytes = str.getBytes(gc.a.f9106b);
        g.e(bytes, "getBytes(...)");
        return bytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doRegister(qb.b<? super java.lang.String> r10) throws com.stepos.core.ota.domain.port.PayloadKeyUnavailableException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar.doRegister(qb.b):java.lang.Object");
    }

    private final String registerFailure(boolean z, Throwable th) {
        return z ? ai.onnxruntime.a.k("register failed: ", th.getMessage()) : ai.onnxruntime.a.k("register failed for a raw (non-attested) key, device is probably not allowlisted on the server: ", th.getMessage());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(7:12|44|13|35|38|39|40)(2:17|18))(1:19))(3:20|(0)|33)|48|23|(1:25)(1:28)|(3:30|39|40)(3:31|(5:34|35|38|39|40)|33)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r7 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.core.ota.crypto.DeviceRegistrar
    /* renamed from: ensureRegistered-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo120ensureRegisteredIoAF18A(qb.b<? super kotlin.Result<java.lang.String>> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "device key present, fingerprint="
            boolean r1 = r9 instanceof com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$ensureRegistered$1
            if (r1 == 0) goto L15
            r1 = r9
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$ensureRegistered$1 r1 = (com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$ensureRegistered$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$ensureRegistered$1 r1 = new com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$ensureRegistered$1
            r1.<init>(r8, r9)
        L1a:
            java.lang.Object r9 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L4b
            if (r3 == r5) goto L3d
            if (r3 != r4) goto L35
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.c.b(r9)     // Catch: java.lang.Throwable -> L32
            goto L96
        L32:
            r9 = move-exception
            goto L9a
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r1.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r3 = r1.L$0
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar r3 = (com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar) r3
            kotlin.c.b(r9)
            r9 = r8
            r8 = r3
            goto L5d
        L4b:
            kotlin.c.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.mutex
            r1.L$0 = r8
            r1.L$1 = r9
            r1.label = r5
            java.lang.Object r3 = r9.lock(r6, r1)
            if (r3 != r2) goto L5d
            goto L92
        L5d:
            com.stepos.core.ota.crypto.DeviceKeyStore r3 = r8.keyStore     // Catch: java.lang.Throwable -> L6c
            boolean r3 = r3.isUsable()     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L71
            com.stepos.core.ota.crypto.DeviceKeyStore r3 = r8.keyStore     // Catch: java.lang.Throwable -> L6c
            java.lang.String r3 = r3.publicKeyFingerprint()     // Catch: java.lang.Throwable -> L6c
            goto L72
        L6c:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9a
        L71:
            r3 = r6
        L72:
            if (r3 == 0) goto L86
            com.stepos.core.ota.domain.port.OtaLogger r8 = r8.log     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "KeyCenterRegistrar"
            r2 = 16
            java.lang.String r2 = gc.r.R0(r2, r3)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r0 = r0.concat(r2)     // Catch: java.lang.Throwable -> L6c
            r8.d(r1, r0)     // Catch: java.lang.Throwable -> L6c
            goto L9f
        L86:
            r1.L$0 = r9     // Catch: java.lang.Throwable -> L6c
            r1.L$1 = r6     // Catch: java.lang.Throwable -> L6c
            r1.label = r4     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r8 = r8.doRegister(r1)     // Catch: java.lang.Throwable -> L6c
            if (r8 != r2) goto L93
        L92:
            return r2
        L93:
            r7 = r9
            r9 = r8
            r8 = r7
        L96:
            r3 = r9
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L32
            goto L9e
        L9a:
            kotlin.Result$Failure r3 = kotlin.c.a(r9)     // Catch: java.lang.Throwable -> La3
        L9e:
            r9 = r8
        L9f:
            r9.unlock(r6)
            return r3
        La3:
            r9 = move-exception
            r8.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar.mo120ensureRegisteredIoAF18A(qb.b):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(6:12|41|13|27|32|33)(2:17|18))(1:19))(3:20|(0)|25)|39|23|(4:26|27|32|33)|25|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r6 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: reregister-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m131reregisterIoAF18A(qb.b<? super kotlin.Result<java.lang.String>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$reregister$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$reregister$1 r0 = (com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$reregister$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$reregister$1 r0 = new com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar$reregister$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L2f
            goto L69
        L2f:
            r8 = move-exception
            goto L70
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r2 = r0.L$0
            com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar r2 = (com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar) r2
            kotlin.c.b(r8)
            r8 = r7
            r7 = r2
            goto L59
        L47:
            kotlin.c.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.mutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L59
            goto L65
        L59:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L6c
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L6c
            r0.label = r3     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r7 = r7.doRegister(r0)     // Catch: java.lang.Throwable -> L6c
            if (r7 != r1) goto L66
        L65:
            return r1
        L66:
            r6 = r8
            r8 = r7
            r7 = r6
        L69:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L2f
            goto L74
        L6c:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L70:
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L78
        L74:
            r7.unlock(r5)
            return r8
        L78:
            r8 = move-exception
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar.m131reregisterIoAF18A(qb.b):java.lang.Object");
    }
}
