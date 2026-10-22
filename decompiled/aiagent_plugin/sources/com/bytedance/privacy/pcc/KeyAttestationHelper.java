package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class KeyAttestationHelper {
    private static final String TAG = "KeyAttestationHelper";

    static {
    }

    private KeyAttestationHelper() {
    }

    public static String generateAndAttestSignKey(Context r4, String r5, String r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        deleteSignKey(r9, r5);
        Bundle r0 = new Bundle();
        r0.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r0.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r0.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey() | SecurityFrameworkCompat.purposeSign());
        int r1 = SecurityFrameworkCompat.generateKeyPair(r9, r5, r0);
        if (r1 != SecurityFrameworkCompat.kmSuccess()) goto L17;
        Bundle r2 = new Bundle();
        r2.putString(SecurityFrameworkCompat.challengeKey(), r6);
        r2.putString(SecurityFrameworkCompat.attestPrdidKey(), r7);
        r2.putString(SecurityFrameworkCompat.attestPruidKey(), r8);
        r2.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);
        SecurityFrameworkCompat.KeyManagerResultCompat r10 = SecurityFrameworkCompat.keyAttestation(r9, r5, r2);
        if (r10.getResultCode() != SecurityFrameworkCompat.kmSuccess()) goto L15;
        List<Certificate> r11 = r10.getCertChain();
        if (r11 == null) goto L13;
        if (r11.isEmpty() == true) goto L13;
        return CertUtils.certsToPemString(r11, Math.min(r11.size(), 3));
    L13:
        throw new Exception("cert chain is empty");
    L15:
        throw new Exception("keyAttestation failed: ret=" + r10.getResultCode());
    L17:
        throw new Exception("generateKeyPair failed: ret=" + r1);
    }

    public static byte[] sign(Context r2, String r3, byte[] r4) {
        SecurityFrameworkCompat.KeyManagerResultCompat r5 = SecurityFrameworkCompat.sign((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, new Bundle());
        byte[] r6 = r5.getOutData();
        if (r5.getResultCode() != SecurityFrameworkCompat.kmSuccess()) goto L9;
        if (r6 == null) goto L9;
        if (r6.length == 0) goto L9;
        return r6;
    L9:
        throw new Exception("sign failed: ret=" + r5.getResultCode());
    }

    public static void deleteSignKey(Context r3, String r4) {
        int r5 = SecurityFrameworkCompat.deleteKey((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, new Bundle());
        if (r5 != SecurityFrameworkCompat.kmSuccess()) goto L5;
        LogUtils.d(TAG, "deleteSignKey: alias=" + r4);
        return;
    L5:
        LogUtils.e(TAG, "deleteSignKey: ret=" + r5 + " alias=" + r4);
    }
}
