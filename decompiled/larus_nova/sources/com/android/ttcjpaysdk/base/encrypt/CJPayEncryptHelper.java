package com.android.ttcjpaysdk.base.encrypt;

import android.text.TextUtils;
import android.util.Base64;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.settings.bean.CJPayEncryptConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import com.bytedance.caijing.sdk.infra.base.encrypt.CJEncrypt;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import we4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/CJPayEncryptHelper;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayEncryptHelper {
    public static final Companion Companion = null;
    public static final int NEW_ENCRYPT_VERSION = 20;
    public static final int OLD_ENCRYPT_VERSION = 3;
    private static final String TAG = "CJPayEncryptHelper";
    public static final String V3_DEFAULT_PUB_KEY = "MIICvDCCAmCgAwIBAgIFE4JECEgwDAYIKoEcz1UBg3UFADAlMQswCQYDVQQGEwJDTjEWMBQGA1UECgwNQ0ZDQSBTTTIgT0NBMTAeFw0yMjA4MDEwOTM1MDhaFw0yNzA4MDEwNjQyMzVaMIGhMQswCQYDVQQGEwJDTjEWMBQGA1UECgwNQ0ZDQSBBQ1MgT0NBMTESMBAGA1UECwwJTXNnQ3J5cHRvMRkwFwYDVQQLDBBPcmdhbml6YXRpb25hbC0xMUswSQYDVQQDDEJNc2dDcnlwQOatpuaxieWQiOS8l+aYk+WuneenkeaKgOaciemZkOWFrOWPuEBOOTE0MjAxMDMwNTU3MzcxNTdXQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAASxnwF/tYSbLTgtidcDs4qNhiFN1pYmSq9StbLAI7tmyCs8e0BMWN+xMxvy5hGw7tikncD+14GQTNVZM1bGFVmJo4H9MIH6MB8GA1UdIwQYMBaAFFyTWCBaJHNWEBtkUBDs6afKB0ERMAkGA1UdEwQCMAAwSAYDVR0gBEEwPzA9BghggRyG7yoBATAxMC8GCCsGAQUFBwIBFiNodHRwOi8vd3d3LmNmY2EuY29tLmNuL3VzL3VzLTE0Lmh0bTA3BgNVHR8EMDAuMCygKqAohiZodHRwOi8vY3JsLmNmY2EuY29tLmNuL1NNMi9jcmw2OTI5LmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFIOJGErBnU7uhyyFML/XZxV32u8oMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDAMBggqgRzPVQGDdQUAA0gAMEUCIQCFYPXIxWIWksKSPL8g4c4lkxiMfdu8GwQZxg0y6bj1XQIgV6rfk42a+IyFOn5i9aHhw5V6AR9k1xRPzrcpKnhevCc=";
    public static final String V3_DEFAULT_PUB_KEY_BOE = "MIICxjCCAmqgAwIBAgIFQDl1YpEwDAYIKoEcz1UBg3UFADBhMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MSAwHgYDVQQDDBdDRkNBIEFDUyBURVNUIFNNMiBPQ0EzMTAeFw0yMjA2MTQwNDI5MjBaFw0yNzA2MTQwNDI5MjBaMHIxCzAJBgNVBAYTAkNOMREwDwYDVQQKDAhPQ0EzMVNNMjERMA8GA1UECwwIdGVzdHpvdTIxGTAXBgNVBAsMEE9yZ2FuaXphdGlvbmFsLTIxIjAgBgNVBAMMGTA1MUDmtYvor5VAWjIzNDU2Nzg2NTQzQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAQ6eOp34qA1PXcPoQ4lkQquxjdUsLFJLgVFePLSYfKvMH81mocKI2sgerpJklTakQQwbPvUgoZhitcoCamda5gjo4H7MIH4MD8GCCsGAQUFBwEBBDMwMTAvBggrBgEFBQcwAYYjaHR0cDovL29jc3B0ZXN0LmNmY2EuY29tLmNuOjgwL29jc3AwHwYDVR0jBBgwFoAUBMe8+VkBaT6MNDYgYhg83ry1uwwwDAYDVR0TAQH/BAIwADA4BgNVHR8EMTAvMC2gK6AphidodHRwOi8vMjEwLjc0LjQyLjMvT0NBMzEvU00yL2NybDE3Ni5jcmwwDgYDVR0PAQH/BAQDAgM4MB0GA1UdDgQWBBQI6O4sqYMa5yrvAtT91oDGovSi8TAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiAn1vEjwqL1rZK31rR7LXEsJKxCCP0jsINna7O5Oqf8HAIhALzD8e+uGEmZtbll0g2XQVNSa5IDcpYED/JLCzaZKv9P";
    private static final CJPayEncryptProxy encryptProxy = null;
    private static final Lazy<CJPayEncryptConfig> encryptV3AbConfig$delegate = null;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J@\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007J.\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0004H\u0007J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u001eH\u0007J,\u0010%\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J.\u0010(\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0007J@\u0010)\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007J4\u0010*\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0007J\"\u0010+\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0007J\u0010\u00103\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u00064"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/CJPayEncryptHelper$Companion;", "", "()V", "NEW_ENCRYPT_VERSION", "", "OLD_ENCRYPT_VERSION", "TAG", "", "V3_DEFAULT_PUB_KEY", "V3_DEFAULT_PUB_KEY_BOE", "encryptProxy", "Lcom/android/ttcjpaysdk/base/encrypt/CJPayEncryptProxy;", "encryptV3AbConfig", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayEncryptConfig;", "getEncryptV3AbConfig", "()Lcom/android/ttcjpaysdk/base/settings/bean/CJPayEncryptConfig;", "encryptV3AbConfig$delegate", "Lkotlin/Lazy;", "aesEncrypt", "rawData", "key", "", CJPayFingerprintSharedPrefUtils.KEY_IV, "getByteEncryptDataWithKey", "bizScene", "Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "publicKey", "source", "field", "forceISEC", "", "getDecryptDataSM", "decryptedData", "getEPName", "version", "getEPVersion", "isSupportV3", "getEncryptData", "pwd", "salt", "getEncryptDataSM", "getEncryptDataWithKey", "getEncryptDataWithoutMd5", "getEncryptDataWithoutSalt", "getEncryptVersion", "getSupportCert", "getV3Key", "isEncryptV3", "isNewEncryptType", "md5Encrypt", "text", "shouldUseV3Encrypt", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final String getEPName(int r100) {
            if (r100 != 3) goto L5;
            return "tfcc";
        L5:
            if (r100 != 20) goto L7;
            return "信安";
        L7:
            if (r100 == 30) goto L9;
            return "";
        L9:
            return "创原";
        }

        public final String getV3Key() {
            INetEnv r100 = CJEnv.j();     // Catch: Throwable -> L11
            boolean r101 = false;
            if (r100 == null) goto L8;
            if (r100.isBoe() != true) goto L8;
            r101 = true;
        L8:
            if (r101 == false) goto L16;
            return CJPayEncryptHelper.V3_DEFAULT_PUB_KEY_BOE;
        L16:
            return CJPayEncryptHelper.V3_DEFAULT_PUB_KEY;
        L11:
            th = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayEncryptHelper#getV3Key", th);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayEncryptHelper#getV3Key", th);
            return CJPayEncryptHelper.V3_DEFAULT_PUB_KEY;
        }

        public final CJPayEncryptConfig getEncryptV3AbConfig() {
            return (CJPayEncryptConfig) CJPayEncryptHelper.access$getEncryptV3AbConfig$delegate$cp().getValue();
        }

        @JvmStatic
        private final int getEncryptVersion(CJEncryptScene r100) {
            return CJPayEncryptHelper.access$getEncryptProxy$cp().getEncryptVersion();
        }

        private final boolean shouldUseV3Encrypt(CJEncryptScene r100) {
            if (getEncryptV3AbConfig().enable_cert != 0) goto L6;
            return false;
        L6:
            if (getEncryptV3AbConfig().encrypt_update_available_scene.contains(r100.getSceneValue()) == true) goto L9;
            CJLogger.d(CJPayEncryptHelper.TAG, "encryptV3AbConfig.encrypt_update_available_scene not contains " + r100.getSceneValue());
            return false;
        L9:
            CJPayCallBackCenter.getInstance().getCjContext().b("encryptv3_" + r100.getSceneValue());
            return true;
        }

        @JvmStatic
        public final String getEPName(CJEncryptScene r100) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            return getEPName(getEPVersion$default(this, r100, false, 2, null));
        }

        @JvmStatic
        public final int getSupportCert(CJEncryptScene r100) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            return shouldUseV3Encrypt(r100) ? 1 : 0;
        }

        public final boolean isEncryptV3(CJEncryptScene r100) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            return shouldUseV3Encrypt(r100);
        }

        @JvmStatic
        public final boolean isNewEncryptType(CJEncryptScene r100) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            if (getEncryptVersion(r100) != 20) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final String md5Encrypt(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            int r101 = 0;
            if (r100.length() != 0) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == false) goto L20;
            return "";
        L20:
            MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L17
            StringBuilder r104 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L17
            byte[] r105 = r103.digest(r100.getBytes(Charsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L17
            int r106 = r105.length;     // Catch: NoSuchAlgorithmException -> L17
        L10:
            if (r101 >= r106) goto L15;
            String r107 = Integer.toHexString(r105[r101] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L17
            if (r107.length() != 1) goto L14;
            r107 = '0' + r107;     // Catch: NoSuchAlgorithmException -> L17
        L14:
            r104.append(r107);     // Catch: NoSuchAlgorithmException -> L17
            r101 = r101 + 1;     // Catch: NoSuchAlgorithmException -> L17
            goto L10
        L15:
            return r104.toString();
        L17:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayEncryptHelper#md5Encrypt", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayEncryptHelper#md5Encrypt", e);
            CJLogger.c(CJPayEncryptHelper.TAG, "MD5 encryption failed", e);
            return "";
        L5:
            r102 = false;
            goto L7
        }

        public static final /* synthetic */ int access$getEncryptVersion(Companion r100, CJEncryptScene r101) {
            return r100.getEncryptVersion(r101);
        }

        @JvmStatic
        public final int getEPVersion(CJEncryptScene r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            if (r101 == false) goto L9;
            if (shouldUseV3Encrypt(r100) == false) goto L11;
            return 30;
        L11:
            return getEncryptVersion(r100);
        L9:
            return getEncryptVersion(r100);
        }

        @JvmStatic
        public final String aesEncrypt(String r100, byte[] r101, byte[] r102) {
            Intrinsics.checkNotNullParameter(r100, "rawData");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, CJPayFingerprintSharedPrefUtils.KEY_IV);
            Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L5
            r103.init(1, new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES), new IvParameterSpec(r102));     // Catch: Exception -> L5
            byte[] r104 = r103.doFinal(r100.getBytes(Charsets.UTF_8));     // Catch: Exception -> L5
            byte[] r105 = new byte[r102.length + r104.length];     // Catch: Exception -> L5
            System.arraycopy(r102, 0, r105, 0, r102.length);     // Catch: Exception -> L5
            System.arraycopy(r104, 0, r105, r102.length, r104.length);     // Catch: Exception -> L5
            return Base64.encodeToString(r105, 2);
        L5:
            e = move-exception;
            CJLogger.c(CJPayEncryptHelper.TAG, "AES encryption failed", e);
            return "";
        }

        @JvmStatic
        public final String getEncryptDataWithoutSalt(CJEncryptScene r100, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            Intrinsics.checkNotNullParameter(r111, "source");
            if (r110 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L14;
            CJPayEncryptUploadUtil.Companion r102 = CJPayEncryptUploadUtil.Companion;
            r102.walletEnigmaCallUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, r111, "pwd");
            r102.walletParamsErrorUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, "pwd", r111, new String[]{"pwd"});
            return "";
        L14:
            return getEncryptDataSM(r100, md5Encrypt(md5Encrypt(r110)), r111, "pwd");
        L5:
            if (r110.length() == 0) goto L8;
            r101 = false;
            goto L10
        }

        @JvmStatic
        public final String aesEncrypt(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "rawData");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, CJPayFingerprintSharedPrefUtils.KEY_IV);
            Charset r103 = Charsets.UTF_8;
            return aesEncrypt(r100, r101.getBytes(r103), r102.getBytes(r103));
        }

        @JvmStatic
        public final String getDecryptDataSM(CJEncryptScene r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r110, "bizScene");
            Intrinsics.checkNotNullParameter(r112, "source");
            CJPayEncryptUploadUtil.Companion r100 = CJPayEncryptUploadUtil.Companion;
            r100.walletEnigmaCallUpload(r110, "decrypt", r112, r113);
            int r101 = 0;
            if (r111 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            String r114 = "";
            r100.walletParamsErrorUpload(r110, "decrypt", r112, r113, new String[]{""});
        L13:
            if (r114.length() != 0) goto L15;
            r101 = 1;
        L15:
            r100.walletEnigmaResultUpload(r110, "decrypt", r101 ^ 1, r112, r113);
            return r114;
        L11:
            r114 = CJPayEncryptHelper.access$getEncryptProxy$cp().getDecryptDataSM(r110, r111);
            goto L13
        L5:
            if (r111.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @JvmStatic
        public final String getEncryptData(CJEncryptScene r100, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            Intrinsics.checkNotNullParameter(r112, "source");
            boolean r101 = false;
            if (r110 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            String r103 = "pwd";
            if (r102 == true) goto L21;
            if (r111 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == true) goto L21;
            return getEncryptDataSM(r100, md5Encrypt(md5Encrypt(r110)) + r111, r112, "pwd");
        L13:
            if (r111.length() == 0) goto L16;
            r104 = false;
        L21:
            CJPayEncryptUploadUtil.Companion r105 = CJPayEncryptUploadUtil.Companion;
            r105.walletEnigmaCallUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, r112, "pwd");
            String[] r106 = new String[2];
            if (r110 != null) goto L24;
        L27:
            boolean r113 = true;
        L29:
            if (r113 == true) goto L32;
            r103 = "";
        L32:
            r106[0] = r103;
            if (r111 != null) goto L35;
        L36:
            r101 = true;
        L37:
            if (r101 == false) goto L39;
            String r114 = "salt";
        L40:
            r106[1] = r114;
            r105.walletParamsErrorUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, r112, "pwd", r106);
            return "";
        L39:
            r114 = "";
            goto L40
        L35:
            if (r111.length() != 0) goto L37;
        L24:
            if (r110.length() == 0) goto L27;
            r113 = false;
            goto L29
        L5:
            if (r110.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @JvmStatic
        public final String getEncryptDataSM(CJEncryptScene r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r110, "bizScene");
            Intrinsics.checkNotNullParameter(r112, "source");
            return getEncryptDataWithKey$default(this, r110, r111, "", r112, r113, false, 32, null);
        }

        public static /* synthetic */ int getEPVersion$default(Companion r100, CJEncryptScene r101, boolean r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = true;
        L6:
            return r100.getEPVersion(r101, r102);
        }

        @JvmStatic
        public final String getEncryptDataWithoutMd5(CJEncryptScene r100, String r101, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "bizScene");
            Intrinsics.checkNotNullParameter(r111, "source");
            Intrinsics.checkNotNullParameter(r112, "field");
            boolean r102 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L19;
            if (r110 != null) goto L12;
        L15:
            boolean r104 = true;
        L16:
            if (r104 == true) goto L19;
            return getEncryptDataSM(r100, r101 + r110, r111, r112);
        L12:
            if (r110.length() == 0) goto L15;
            r104 = false;
        L19:
            CJPayEncryptUploadUtil.Companion r105 = CJPayEncryptUploadUtil.Companion;
            r105.walletEnigmaCallUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, r111, r112);
            String[] r106 = new String[2];
            if (r101 != null) goto L22;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L29;
            String r108 = "rawData";
        L30:
            r106[0] = r108;
            if (r110 != null) goto L33;
        L34:
            r102 = true;
        L35:
            if (r102 == false) goto L37;
            String r109 = "salt";
        L38:
            r106[1] = r109;
            r105.walletParamsErrorUpload(r100, LBSLightLocationTraceLogger.ENCRYPT, r111, r112, r106);
            return "";
        L37:
            r109 = "";
            goto L38
        L33:
            if (r110.length() != 0) goto L35;
        L29:
            r108 = "";
            goto L30
        L22:
            if (r101.length() == 0) goto L25;
            r107 = false;
            goto L27
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final byte[] getByteEncryptDataWithKey(CJEncryptScene r110, byte[] r111, String r112, String r210, String r211, boolean r212) {
            String r100 = r112;
            Intrinsics.checkNotNullParameter(r110, "bizScene");
            Intrinsics.checkNotNullParameter(r100, "publicKey");
            Intrinsics.checkNotNullParameter(r210, "source");
            CJPayEncryptUploadUtil.Companion r113 = CJPayEncryptUploadUtil.Companion;
            r113.walletEnigmaCallUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r210, r211);
            int r114 = 0;
            if (r111 != null) goto L5;
        L29:
            r113.walletParamsErrorUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r210, r211, new String[]{"rawData"});
            byte[] r101 = "".getBytes(Charsets.UTF_8);
        L30:
            byte[] r102 = r101;
            if (r102.length != 0) goto L33;
            r114 = 1;
        L33:
            r113.walletEnigmaResultUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r114 ^ 1, r210, r211);
            return r102;
        L5:
            if (r111.length != 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L29;
            if (shouldUseV3Encrypt(r110) == true) goto L13;
            int r104 = CJPayEncryptHelper.access$getEncryptProxy$cp().getEncryptVersion();
            String r115 = CJPayEncryptHelper.access$getEncryptProxy$cp().getEncryptDataSM(r110, Base64.encodeToString(r111, 2), r100);
            if (r115.length() != 0) goto L25;
            boolean r105 = true;
        L26:
            if (r105 == false) goto L28;
            r113.walletEncryptFailed(r104, r110, 0, "", "", r210, r211);
        L28:
            r101 = r115.getBytes(Charsets.UTF_8);
            goto L30
        L25:
            r105 = false;
            goto L26
        L13:
            if (TextUtils.isEmpty(r112) == false) goto L15;
            r100 = getV3Key();
        L15:
            Charset r116 = Charsets.UTF_8;
            b r106 = CJEncrypt.a(r111, Base64.encodeToString(r100.getBytes(r116), 2), 30, r210);
            if (CJEnv.n() == false) goto L19;
            CJLogger.d(CJPayEncryptHelper.TAG, "getEncryptDataWithKey " + r106.f559395a + ',' + r106.f559397c);
        L19:
            if (r106.a() == false) goto L21;
            r101 = (byte[]) r106.f559397c;
            goto L30
        L21:
            r113.walletEncryptFailed(30, r110, 0, String.valueOf(r106.f559395a), r106.f559396b, r210, r211);
            r101 = "".getBytes(r116);
            goto L30
        L7:
            r103 = false;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final String getEncryptDataWithKey(CJEncryptScene r110, String r111, String r112, String r113, String r210, boolean r211) {
            String r100 = r112;
            Intrinsics.checkNotNullParameter(r110, "bizScene");
            Intrinsics.checkNotNullParameter(r100, "publicKey");
            Intrinsics.checkNotNullParameter(r113, "source");
            CJPayEncryptUploadUtil.Companion r114 = CJPayEncryptUploadUtil.Companion;
            r114.walletEnigmaCallUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r113, r210);
            int r115 = 0;
            if (r111 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L12;
            r114.walletParamsErrorUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r113, r210, new String[]{"rawData"});
        L23:
            String r102 = "";
        L24:
            String r116 = r102;
        L32:
            if (r116.length() != 0) goto L34;
            r115 = 1;
        L34:
            r114.walletEnigmaResultUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r115 ^ 1, r113, r210);
            return r116;
        L12:
            if (shouldUseV3Encrypt(r110) == true) goto L14;
            int r103 = CJPayEncryptHelper.access$getEncryptProxy$cp().getEncryptVersion();
            r116 = CJPayEncryptHelper.access$getEncryptProxy$cp().getEncryptDataSM(r110, r111, r100);
            if (r116.length() != 0) goto L28;
            boolean r104 = true;
        L29:
            if (r104 == false) goto L32;
            r114.walletEncryptFailed(r103, r110, 0, "", "", r113, r210);
            goto L32
        L28:
            r104 = false;
            goto L29
        L14:
            if (TextUtils.isEmpty(r112) == false) goto L16;
            r100 = getV3Key();
        L16:
            Charset r105 = Charsets.UTF_8;
            String r106 = Base64.encodeToString(r100.getBytes(r105), 2);
            Lazy r107 = CJEncrypt.f202287a;
            b r108 = CJEncrypt.a(r111.getBytes(r105), r106, 30, r113);
            if (CJEnv.n() == false) goto L20;
            CJLogger.d(CJPayEncryptHelper.TAG, "getEncryptDataWithKey " + r108.f559395a + ',' + r108.f559397c);
        L20:
            if (r108.a() == false) goto L22;
            r102 = Base64.encodeToString((byte[]) r108.f559397c, 3);
            goto L24
        L22:
            r114.walletEncryptFailed(30, r110, 0, String.valueOf(r108.f559395a), r108.f559396b, r113, r210);
            goto L23
        L5:
            if (r111.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public static /* synthetic */ String getDecryptDataSM$default(Companion r100, CJEncryptScene r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L6;
            r104 = "";
        L6:
            return r100.getDecryptDataSM(r101, r102, r103, r104);
        }

        public static /* synthetic */ String getEncryptDataSM$default(Companion r100, CJEncryptScene r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L6;
            r104 = "";
        L6:
            return r100.getEncryptDataSM(r101, r102, r103, r104);
        }

        public static /* synthetic */ byte[] getByteEncryptDataWithKey$default(Companion r100, CJEncryptScene r101, byte[] r102, String r110, String r111, String r112, boolean r113, int r114, Object r115) {
            if ((r114 & 16) == 0) goto L5;
            r112 = "";
        L5:
            String r103 = r112;
            if ((r114 & 32) == 0) goto L8;
            boolean r104 = false;
        L10:
            return r100.getByteEncryptDataWithKey(r101, r102, r110, r111, r103, r104);
        L8:
            r104 = r113;
            goto L10
        }

        public static /* synthetic */ String getEncryptDataWithKey$default(Companion r100, CJEncryptScene r101, String r102, String r110, String r111, String r112, boolean r113, int r114, Object r115) {
            if ((r114 & 16) == 0) goto L5;
            r112 = "";
        L5:
            String r103 = r112;
            if ((r114 & 32) == 0) goto L8;
            boolean r104 = false;
        L10:
            return r100.getEncryptDataWithKey(r101, r102, r110, r111, r103, r104);
        L8:
            r104 = r113;
            goto L10
        }
    }

    public CJPayEncryptHelper() {
    }

    @JvmStatic
    public static final String aesEncrypt(String r100, String r101, String r102) {
        return Companion.aesEncrypt(r100, r101, r102);
    }

    @JvmStatic
    public static final String aesEncrypt(String r100, byte[] r101, byte[] r102) {
        return Companion.aesEncrypt(r100, r101, r102);
    }

    @JvmStatic
    public static final byte[] getByteEncryptDataWithKey(CJEncryptScene r100, byte[] r101, String r102, String r110, String r111, boolean r112) {
        return Companion.getByteEncryptDataWithKey(r100, r101, r102, r110, r111, r112);
    }

    @JvmStatic
    public static final String getDecryptDataSM(CJEncryptScene r100, String r101, String r102, String r103) {
        return Companion.getDecryptDataSM(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final String getEPName(int r100) {
        return Companion.getEPName(r100);
    }

    @JvmStatic
    public static final String getEPName(CJEncryptScene r100) {
        return Companion.getEPName(r100);
    }

    @JvmStatic
    public static final int getEPVersion(CJEncryptScene r100, boolean r101) {
        return Companion.getEPVersion(r100, r101);
    }

    @JvmStatic
    public static final String getEncryptData(CJEncryptScene r100, String r101, String r102, String r103) {
        return Companion.getEncryptData(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final String getEncryptDataSM(CJEncryptScene r100, String r101, String r102, String r103) {
        return Companion.getEncryptDataSM(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final String getEncryptDataWithKey(CJEncryptScene r100, String r101, String r102, String r110, String r111, boolean r112) {
        return Companion.getEncryptDataWithKey(r100, r101, r102, r110, r111, r112);
    }

    @JvmStatic
    public static final String getEncryptDataWithoutMd5(CJEncryptScene r100, String r101, String r102, String r103, String r110) {
        return Companion.getEncryptDataWithoutMd5(r100, r101, r102, r103, r110);
    }

    @JvmStatic
    public static final String getEncryptDataWithoutSalt(CJEncryptScene r100, String r101, String r102) {
        return Companion.getEncryptDataWithoutSalt(r100, r101, r102);
    }

    @JvmStatic
    private static final int getEncryptVersion(CJEncryptScene r100) {
        return Companion.access$getEncryptVersion(Companion, r100);
    }

    @JvmStatic
    public static final int getSupportCert(CJEncryptScene r100) {
        return Companion.getSupportCert(r100);
    }

    @JvmStatic
    public static final boolean isNewEncryptType(CJEncryptScene r100) {
        return Companion.isNewEncryptType(r100);
    }

    @JvmStatic
    public static final String md5Encrypt(String r100) {
        return Companion.md5Encrypt(r100);
    }

    static {
        Companion = new Companion(null);
        encryptProxy = new ISECEncrypt();
        encryptV3AbConfig$delegate = LazyKt.lazy(CJPayEncryptHelper$Companion$encryptV3AbConfig$2.INSTANCE);
    }

    public static final /* synthetic */ CJPayEncryptProxy access$getEncryptProxy$cp() {
        return encryptProxy;
    }

    public static final /* synthetic */ Lazy access$getEncryptV3AbConfig$delegate$cp() {
        return encryptV3AbConfig$delegate;
    }
}
