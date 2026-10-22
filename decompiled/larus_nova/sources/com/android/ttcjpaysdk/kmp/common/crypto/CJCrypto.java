package com.android.ttcjpaysdk.kmp.common.crypto;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/CJCrypto;", "", "<init>", "()V", "isPayEncryptV3Enabled", "", LBSLightLocationTraceLogger.ENCRYPT, "Lcom/android/ttcjpaysdk/kmp/common/crypto/EncryptResult;", "plainText", "", "encryptV3", "decrypt", "cipherText", "md5Encrypt", "data", "generateOTP", "seed", "timestep", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJCrypto {
    public static final int $stable = 0;
    public static final CJCrypto INSTANCE = null;

    static {
        INSTANCE = new CJCrypto();
    }

    private CJCrypto() {
    }

    public final boolean isPayEncryptV3Enabled() {
        b r100 = c.f528682a;
        IKmpCJCryptoService r101 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isPayEncryptV3Enabled();
    }

    public final String decrypt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cipherText");
        b r101 = c.f528682a;
        IKmpCJCryptoService r102 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r102 == null) goto L6;
        String r103 = r102.decrypt(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public final EncryptResult encrypt(String r110) {
        Intrinsics.checkNotNullParameter(r110, "plainText");
        b r100 = c.f528682a;
        IKmpCJCryptoService r101 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r101 == null) goto L8;
        KmpEncryptResult r102 = r101.encrypt(r110);
        if (r102 == null) goto L8;
        return new EncryptResult(r102.getData(), r102.getVersion(), r102.getType1(), r102.getType2(), 0);
    L8:
        return new EncryptResult("", 0, 0, 0, 0, 30, null);
    }

    public final EncryptResult encryptV3(String r110) {
        Intrinsics.checkNotNullParameter(r110, "plainText");
        b r100 = c.f528682a;
        IKmpCJCryptoService r101 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r101 == null) goto L8;
        KmpEncryptResult r102 = r101.encryptV3(r110);
        if (r102 == null) goto L8;
        return new EncryptResult(r102.getData(), r102.getVersion(), r102.getType1(), r102.getType2(), r102.getSupportCertType());
    L8:
        return new EncryptResult("", 0, 0, 0, 0, 30, null);
    }

    public final String md5Encrypt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b r101 = c.f528682a;
        IKmpCJCryptoService r102 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r102 == null) goto L6;
        String r103 = r102.md5Encrypt(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public final String generateOTP(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "seed");
        b r102 = c.f528682a;
        IKmpCJCryptoService r103 = (IKmpCJCryptoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCryptoService.class));
        if (r103 == null) goto L6;
        String r104 = r103.generateOTP(r100, r101);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }
}
