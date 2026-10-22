package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttestKeyManager {
    private static final HashMap<String, String> APP_ID_LIST = null;
    public static final String TAG = "AttestKeyManager";
    private static volatile AttestKeyManager keyManager;

    static {
        APP_ID_LIST = new AnonymousClass1();
    }

    public AttestKeyManager() {
    }

    private List<Certificate> attestKey(Context r4, String r5, String r6, String r7, boolean r8) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Bundle r9 = new Bundle();
        if (r8 == false) goto L11;
        r9.putBoolean(FrameworkSecurityCompat.KeyManagerConst.DEVICE_HEALTH_STATUS_REQUIRED(), true);
        if (r6 != null) goto L7;
    L10:
        String r10 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        r7 = r7 + "::" + ((String) ZeusTransformUtils.preCheckCast(APP_ID_LIST.getOrDefault(r3.getPackageName(), ""), String.class, "com.obric.aiagent.plugin"));
    L12:
        r9.putString(r10, r7);
    L13:
        FrameworkSecurityCompat.KmResult r11 = FrameworkSecurityCompat.keyAttestation(r3, r5, r9);
        if (r11.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L17;
        LogUtils.e(TAG, "Attest key failed! ret:" + r11.getResultCode());
        return new ArrayList();
    L17:
        List<Certificate> r12 = r11.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r12.size());
        return r12;
    L7:
        if (r6.isEmpty() == true) goto L10;
        r9.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r7 + "::" + r6);
        goto L13
    L11:
        r10 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        goto L12
    }

    private int generateKeyPair(Context r2, String r3, Bundle r4) {
        int r1 = FrameworkSecurityCompat.generateKeyPair((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
        if (r1 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r1);
        return r1;
    L7:
        return FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS();
    }

    public static AttestKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(AttestKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new AttestKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AttestKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    public void deleteAttestKey(Context r3, String r4) {
        LogUtils.i(TAG, "Delete attest key! keyAlias:" + r4 + " ret:" + FrameworkSecurityCompat.deleteKey((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, new Bundle()));
    }

    public List<Certificate> getAttestCertChain(Context r7, String r8, String r9, boolean r10, Bundle r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        String r4 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r4) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r12 = TAG;
        LogUtils.d(r12, "Request challenge succeed! challenge:" + r4);
        int r13 = generateKeyPair(r1, r8, r11);
        if (r13 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L11;
        LogUtils.e(r12, "Generate attestation key pair failed! ret:" + r13);
        return new ArrayList();
    L11:
        return attestKey(r1, r8, r9, r4, r10);
    }
}
