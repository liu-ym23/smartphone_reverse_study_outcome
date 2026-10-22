package com.stepos.core.ota.adapter;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ota.domain.port.IntegrityVerifier;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DigestIntegrityVerifier implements IntegrityVerifier {
    /* JADX INFO: Access modifiers changed from: private */
    public final String digest(String str, String str2) throws NoSuchAlgorithmException, IOException {
        int i10;
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            byte[] bArr = new byte[PcmDumpBudget.HARD_MAX_DIR_MB];
            while (true) {
                int i11 = fileInputStream.read(bArr);
                if (i11 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i11);
            }
            n nVar = n.f10413a;
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            g.e(bArrDigest, "digest(...)");
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) "");
            int i12 = 0;
            for (byte b10 : bArrDigest) {
                i12++;
                if (i12 > 1) {
                    sb2.append((CharSequence) "");
                }
                sb2.append(digest$lambda$2(b10));
            }
            sb2.append((CharSequence) "");
            return sb2.toString();
        } finally {
        }
    }

    private static final CharSequence digest$lambda$2(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.IntegrityVerifier
    /* renamed from: verify-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo109verify0E7RQCE(java.lang.String r6, com.stepos.core.ota.domain.model.Integrity r7, qb.b<? super kotlin.Result<lb.n>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$1 r0 = (com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$1 r0 = new com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r8)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$2 r2 = new com.stepos.core.ota.adapter.DigestIntegrityVerifier$verify$2
            r4 = 0
            r2.<init>(r7, r5, r6, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.DigestIntegrityVerifier.mo109verify0E7RQCE(java.lang.String, com.stepos.core.ota.domain.model.Integrity, qb.b):java.lang.Object");
    }
}
