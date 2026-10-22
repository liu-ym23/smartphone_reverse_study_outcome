package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import android.os.Build;
import com.stepos.core.ota.domain.port.OtaLogger;
import com.stepos.core.ota.domain.port.PayloadKeyUnavailableException;
import java.security.PrivateKey;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeystoreEcdhDecryptProvider implements ModelDecryptProvider {
    public static final Companion Companion = new Companion(null);
    public static final String ID = "keystore-ecdh";
    private static final String TAG = "KeystoreEcdhProvider";
    private final IModelCrypto crypto;

    /* renamed from: id, reason: collision with root package name */
    private final String f7539id;
    private final DeviceKeyStore keyStore;
    private final OtaLogger log;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public KeystoreEcdhDecryptProvider(DeviceKeyStore keyStore, IModelCrypto crypto, OtaLogger log) {
        g.f(keyStore, "keyStore");
        g.f(crypto, "crypto");
        g.f(log, "log");
        this.keyStore = keyStore;
        this.crypto = crypto;
        this.log = log;
        this.f7539id = ID;
    }

    private final String toHex(byte[] bArr) {
        g.f(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(toHex$lambda$3(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    private static final CharSequence toHex$lambda$3(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final byte[] unsealFek(DecryptRequest decryptRequest) throws PayloadKeyUnavailableException {
        try {
            PrivateKey privateKeyPrivateKeyOrNull = this.keyStore.privateKeyOrNull();
            if (privateKeyPrivateKeyOrNull == null) {
                throw new IllegalStateException("device private key unavailable");
            }
            FekEnvelopeCipher envelope = decryptRequest.getEnvelope();
            FekEnvelope fekEnvelope = FekEnvelope.INSTANCE;
            byte[] bArrBuildInfo = fekEnvelope.buildInfo(decryptRequest.getIdentity().getDeviceAppId(), decryptRequest.getIdentity().getDeviceId(), decryptRequest.getIdentity().getFingerprint(), envelope.getKeyEpoch());
            try {
                return fekEnvelope.open(privateKeyPrivateKeyOrNull, envelope.getEpk(), envelope.getIv(), envelope.getCiphertext(), bArrBuildInfo);
            } catch (Throwable th) {
                this.log.e(TAG, "fek unseal failed: " + decryptRequest.getSrcPath() + " infoHex=" + this.toHex(bArrBuildInfo), th);
                throw th;
            }
        } catch (PayloadKeyUnavailableException e10) {
            throw e10;
        } catch (Throwable th2) {
            throw new PayloadKeyUnavailableException(a.k("cannot unseal FEK: ", th2.getMessage()), th2);
        }
    }

    @Override // com.stepos.core.ota.crypto.ModelDecryptProvider
    public String getId() {
        return this.f7539id;
    }

    @Override // com.stepos.core.ota.crypto.ModelDecryptProvider
    public Object isAvailable(b<? super Boolean> bVar) {
        return Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && this.keyStore.isUsable());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x002d, B:24:0x005c, B:26:0x0062, B:29:0x0068, B:30:0x007d), top: B:39:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068 A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x002d, B:24:0x005c, B:26:0x0062, B:29:0x0068, B:30:0x007d), top: B:39:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.core.ota.crypto.ModelDecryptProvider
    /* renamed from: openDecryptedStream-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo132openDecryptedStreamgIAlus(com.stepos.core.ota.crypto.DecryptRequest r7, qb.b<? super kotlin.Result<? extends java.io.InputStream>> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "header unreadable: "
            boolean r1 = r8 instanceof com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider$openDecryptedStream$1
            if (r1 == 0) goto L15
            r1 = r8
            com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider$openDecryptedStream$1 r1 = (com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider$openDecryptedStream$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider$openDecryptedStream$1 r1 = new com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider$openDecryptedStream$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L3f
            if (r3 != r4) goto L37
            java.lang.Object r6 = r1.L$1
            byte[] r6 = (byte[]) r6
            java.lang.Object r7 = r1.L$0
            com.stepos.core.ota.crypto.DecryptRequest r7 = (com.stepos.core.ota.crypto.DecryptRequest) r7
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L35
            kotlin.Result r8 = (kotlin.Result) r8     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r8.f9987a     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r7 = move-exception
            goto L80
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.c.b(r8)
            byte[] r8 = r6.unsealFek(r7)     // Catch: java.lang.Throwable -> L84
            com.stepos.core.ota.crypto.IModelCrypto r6 = r6.crypto     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r7.getSrcPath()     // Catch: java.lang.Throwable -> L7e
            r1.L$0 = r7     // Catch: java.lang.Throwable -> L7e
            r1.L$1 = r8     // Catch: java.lang.Throwable -> L7e
            r1.label = r4     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r6 = r6.mo125openDecryptedStream0E7RQCE(r3, r8, r1)     // Catch: java.lang.Throwable -> L7e
            if (r6 != r2) goto L59
            return r2
        L59:
            r5 = r8
            r8 = r6
            r6 = r5
        L5c:
            java.lang.Throwable r1 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L68
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch: java.lang.Throwable -> L35
            androidx.datastore.preferences.protobuf.b1.H(r6)     // Catch: java.lang.Throwable -> L84
            return r8
        L68:
            com.stepos.core.ota.domain.port.PayloadDecryptException r8 = new com.stepos.core.ota.domain.port.PayloadDecryptException     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = r7.getSrcPath()     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L35
            r2.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L35
            r8.<init>(r7, r1)     // Catch: java.lang.Throwable -> L35
            throw r8     // Catch: java.lang.Throwable -> L35
        L7e:
            r7 = move-exception
            r6 = r8
        L80:
            androidx.datastore.preferences.protobuf.b1.H(r6)     // Catch: java.lang.Throwable -> L84
            throw r7     // Catch: java.lang.Throwable -> L84
        L84:
            r6 = move-exception
            kotlin.Result$Failure r6 = kotlin.c.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider.mo132openDecryptedStreamgIAlus(com.stepos.core.ota.crypto.DecryptRequest, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.crypto.ModelDecryptProvider
    public boolean supports(String envelopeAlg, CryptoAlgorithm payloadAlg) {
        g.f(envelopeAlg, "envelopeAlg");
        g.f(payloadAlg, "payloadAlg");
        return envelopeAlg.equals(FekEnvelope.ALG) && payloadAlg == CryptoAlgorithm.AES_256_GCM;
    }
}
