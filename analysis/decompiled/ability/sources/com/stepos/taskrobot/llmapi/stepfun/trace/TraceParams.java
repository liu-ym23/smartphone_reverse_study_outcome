package com.stepos.taskrobot.llmapi.stepfun.trace;

import C7.f;
import D7.q;
import android.app.Application;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import f6.AbstractC1436a;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006 "}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/TraceParams;", "", AppAgent.CONSTRUCT, "()V", "", "blob", "", "decrypt", "([B)Ljava/lang/String;", "signingCertSha256", "()[B", "TAG", "Ljava/lang/String;", "END_POINT", "REGION", "BUCKET_NAME", "OBJECT_KEY", "ACCESS_KEY_ENC", "[B", "SECRET_KEY_ENC", "", "IV_LEN", "I", "TAG_BITS", "ACCESS_KEY$delegate", "LC7/f;", "getACCESS_KEY", "()Ljava/lang/String;", "ACCESS_KEY", "SECRET_KEY$delegate", "getSECRET_KEY", "SECRET_KEY", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TraceParams {
    public static final String BUCKET_NAME = "aos-edge-model-test";
    public static final String END_POINT = "tos-cn-shanghai.volces.com";
    private static final int IV_LEN = 12;
    public static final String OBJECT_KEY = "trace_data/";
    public static final String REGION = "cn-shanghai";
    private static final String TAG = "TraceParams";
    private static final int TAG_BITS = 128;
    public static final TraceParams INSTANCE = new TraceParams();
    private static final byte[] ACCESS_KEY_ENC = {66, 48, -98, 17, -34, -26, -23, 75, -5, 15, 73, -8, 29, 71, 121, 48, 112, 123, -68, -81, -93, -117, -31, -35, 22, -47, -54, -37, 20, 110, 46, 45, 66, -64, 58, -87, -53, -31, -64, -57, 101, 35, 38, -22, 66, -15, 8, -101, -96, -66, 30, -26, 25, -111, -34, -54, 32, 18, -9, 61, -87, 30, 18, 125, -99, 46, -125, -68, -68, 93, -32, -5, 98, -30, 121};
    private static final byte[] SECRET_KEY_ENC = {-38, 19, -97, -64, 70, -102, 100, -13, -35, 89, 58, 85, -104, -60, -80, -128, -109, -73, 90, -60, -55, -126, -115, 35, -39, 65, -71, 107, 108, -45, 117, 72, -16, -84, 38, -39, 53, -9, 40, 47, 63, 12, -105, -127, ByteSourceJsonBootstrapper.UTF8_BOM_2, -92, -25, 71, -103, -64, -35, 40, -108, -113, -99, -67, 121, 32, -6, 2, 104, -123, -7, 32, -102, 66, -21, -67, 17, 6, 45, 32, 92, -106, -119, 94, -126, -44, -42, 113, -122, 27, -121, 70, -66, -53, -110, ByteSourceJsonBootstrapper.UTF8_BOM_3};

    /* renamed from: ACCESS_KEY$delegate, reason: from kotlin metadata */
    private static final f ACCESS_KEY = kotlin.a.a(new com.stepos.ability.voicewakeup.service.f(11));

    /* renamed from: SECRET_KEY$delegate, reason: from kotlin metadata */
    private static final f SECRET_KEY = kotlin.a.a(new com.stepos.ability.voicewakeup.service.f(12));

    private TraceParams() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ACCESS_KEY_delegate$lambda$0() {
        return INSTANCE.decrypt(ACCESS_KEY_ENC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SECRET_KEY_delegate$lambda$0() {
        return INSTANCE.decrypt(SECRET_KEY_ENC);
    }

    private final String decrypt(byte[] blob) {
        try {
            byte[] bArrSigningCertSha256 = signingCertSha256();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(bArrSigningCertSha256, "AES"), new GCMParameterSpec(128, blob, 0, 12));
            byte[] bArrDoFinal = cipher.doFinal(blob, 12, blob.length - 12);
            k.e(bArrDoFinal, "doFinal(...)");
            return new String(bArrDoFinal, AbstractC1607a.f4778a);
        } catch (Throwable th) {
            AbstractC1436a.b(TAG, "decrypt TOS credential failed (repack or wrong signature?): " + th.getMessage(), true);
            return "";
        }
    }

    private final byte[] signingCertSha256() {
        Signature[] apkContentsSigners;
        Signature signature;
        Application application = l.b;
        if (application == null) {
            k.n("application");
            throw null;
        }
        SigningInfo signingInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 134217728).signingInfo;
        if (signingInfo == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null || (signature = (Signature) q.n0(apkContentsSigners)) == null) {
            throw new IllegalStateException("no signing certificate available");
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
        k.e(bArrDigest, "digest(...)");
        return bArrDigest;
    }

    public final String getACCESS_KEY() {
        return (String) ACCESS_KEY.getF4884a();
    }

    public final String getSECRET_KEY() {
        return (String) SECRET_KEY.getF4884a();
    }
}
