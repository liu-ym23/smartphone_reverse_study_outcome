package com.android.ttcjpaysdk.kmp.common.crypto;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/IKmpCJCryptoService;", "Lcom/bytedance/kmp/spi/IKmpService;", "isPayEncryptV3Enabled", "", LBSLightLocationTraceLogger.ENCRYPT, "Lcom/android/ttcjpaysdk/kmp/common/crypto/KmpEncryptResult;", "plainText", "", "encryptV3", "decrypt", "cipherText", "md5Encrypt", "txt", "generateOTP", "seed", "timestep", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJCryptoService extends a {
    String decrypt(String r100);

    KmpEncryptResult encrypt(String r100);

    KmpEncryptResult encryptV3(String r100);

    String generateOTP(String r100, int r101);

    boolean isPayEncryptV3Enabled();

    String md5Encrypt(String r100);
}
