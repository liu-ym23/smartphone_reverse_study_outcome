package com.stepos.taskrobot.dictionary.interceptor;

import B7.a;
import D7.q;
import F9.A;
import F9.G;
import F9.M;
import F9.z;
import K9.g;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.dictionary.utils.DeviceInfo;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.t;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/dictionary/interceptor/BizInterceptor;", "LF9/A;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", "message", "secret", "hmacSha256", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", SingleFileBundle.KEY_BYTES, "bytesToHex", "([B)Ljava/lang/String;", "LF9/z;", "chain", "LF9/M;", "intercept", "(LF9/z;)LF9/M;", "Landroid/content/Context;", "Companion", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BizInterceptor implements A {
    public static final String APP_ID = "83649570121923358340";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private static final int IV_LEN = 12;
    private static final String TAG = "BizInterceptor";
    private static final int TAG_BITS = 128;
    private final Context context;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] APP_SECRET_ENC = {73, -59, -73, 38, 5, -53, 110, 22, 125, -67, 118, -127, -1, -26, -120, 29, -116, 127, -126, 85, 3, -121, 99, 100, 86, -96, -120, 26, -8, -109, 55, 65, 83, 122, 75, 110, 81, 85, -85, -33, -66, -11, 125, -123, 54, 48, 96, 76, -29, -39, 121, -6, -22, 32, 32, 75, -12, -45, -77, -20};

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/dictionary/interceptor/BizInterceptor$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "APP_ID", "HMAC_SHA256_ALGORITHM", "IV_LEN", "", "TAG_BITS", "APP_SECRET_ENC", "", "appSecret", "context", "Landroid/content/Context;", "signingCertSha256", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String appSecret(Context context) {
            try {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, new SecretKeySpec(signingCertSha256(context), "AES"), new GCMParameterSpec(128, BizInterceptor.APP_SECRET_ENC, 0, 12));
                byte[] bArrDoFinal = cipher.doFinal(BizInterceptor.APP_SECRET_ENC, 12, BizInterceptor.APP_SECRET_ENC.length - 12);
                k.e(bArrDoFinal, "doFinal(...)");
                Charset UTF_8 = StandardCharsets.UTF_8;
                k.e(UTF_8, "UTF_8");
                return new String(bArrDoFinal, UTF_8);
            } catch (Throwable th) {
                Log.e(BizInterceptor.TAG, "decrypt appSecret failed (repack or wrong signature?): " + th.getMessage());
                return "";
            }
        }

        private final byte[] signingCertSha256(Context context) {
            Signature[] apkContentsSigners;
            Signature signature;
            SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
            if (signingInfo == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null || (signature = (Signature) q.n0(apkContentsSigners)) == null) {
                throw new IllegalStateException("no signing certificate available");
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
            k.e(bArrDigest, "digest(...)");
            return bArrDigest;
        }

        private Companion() {
        }
    }

    public BizInterceptor(Context context) {
        k.f(context, "context");
        this.context = context;
    }

    private final String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    private final String hmacSha256(String message, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        Charset UTF_8 = StandardCharsets.UTF_8;
        k.e(UTF_8, "UTF_8");
        byte[] bytes = secret.getBytes(UTF_8);
        k.e(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, HMAC_SHA256_ALGORITHM));
        k.e(UTF_8, "UTF_8");
        byte[] bytes2 = message.getBytes(UTF_8);
        k.e(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        k.c(bArrDoFinal);
        return bytesToHex(bArrDoFinal);
    }

    @Override // F9.A
    public M intercept(z chain) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        k.f(chain, "chain");
        g gVar = (g) chain;
        G g = gVar.e;
        String string = UUID.randomUUID().toString();
        k.e(string, "toString(...)");
        String strC0 = t.c0(string, "-", "");
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strAppSecret = INSTANCE.appSecret(this.context);
        String strHmacSha256 = hmacSha256(a.n(APP_ID, strC0, strValueOf, strAppSecret), strAppSecret);
        K1.a aVarB = g.b();
        DeviceInfo deviceInfo = DeviceInfo.INSTANCE;
        aVarB.b("zy-device-id", deviceInfo.getDeviceId(this.context));
        aVarB.b("zy-device-model", deviceInfo.getModel());
        aVarB.b("zy-device-brand", deviceInfo.getBrand());
        aVarB.b("zy-client-type", "Android");
        aVarB.b("zy-client-lang", deviceInfo.getLanguage());
        aVarB.b("zy-app-id", APP_ID);
        aVarB.b("zy-system-ver", deviceInfo.getSystemVersion());
        aVarB.b("zy-app-ver-name", deviceInfo.getAppVersionName(this.context));
        aVarB.b("zy-app-ver-code", String.valueOf(deviceInfo.getAppVersionCode(this.context)));
        aVarB.b("zy-nonce", strC0);
        aVarB.b("zy-timestamp", strValueOf);
        aVarB.b("zy-sign", strHmacSha256);
        aVarB.b(HttpHeaders.CONTENT_TYPE, "application/json");
        return gVar.b(aVarB.d());
    }
}
