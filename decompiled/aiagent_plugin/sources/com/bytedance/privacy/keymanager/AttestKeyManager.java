package com.bytedance.privacy.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.network.ChallengeManager;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttestKeyManager {
    public static final String TAG = "AttestKeyManager";
    private static volatile AttestKeyManager keyManager;

    static {
    }

    public AttestKeyManager() {
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

    public List<Certificate> getAttestCertChain(Context r5, String r6, String r7, boolean r8, Bundle r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = TAG;
        LogUtils.d(r1, "Request challenge succeed! challenge:" + r0);
        int r11 = generateKeyPair(r10, r6, r9);
        if (r11 == SecurityFrameworkCompat.kmSuccess()) goto L11;
        LogUtils.e(r1, "Generate attestation key pair failed! ret:" + r11);
        return new ArrayList();
    L11:
        return attestKey(r10, r6, r0 + ":" + r7 + ":" + r6, r8);
    }

    private int generateKeyPair(Context r2, String r3, Bundle r4) {
        int r1 = SecurityFrameworkCompat.generateKeyPair((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
        if (r1 == SecurityFrameworkCompat.kmSuccess()) goto L7;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r1);
        return r1;
    L7:
        return SecurityFrameworkCompat.kmSuccess();
    }

    private List<Certificate> attestKey(Context r2, String r3, String r4, boolean r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        if (r5 == false) goto L5;
        r6.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);
        r6.putString(SecurityFrameworkCompat.challengeKey(), r4);
    L6:
        SecurityFrameworkCompat.KeyManagerResultCompat r7 = SecurityFrameworkCompat.keyAttestation(r1, r3, r6);
        if (r7.getResultCode() == SecurityFrameworkCompat.kmSuccess()) goto L10;
        LogUtils.e(TAG, "Attest key failed! ret:" + r7.getResultCode());
        return new ArrayList();
    L10:
        List<Certificate> r8 = r7.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r8.size());
        return r8;
    L5:
        r6.putString(SecurityFrameworkCompat.challengeKey(), r4);
        goto L6
    }

    private List<Certificate> attestKeyWithIds(Context r2, String r3, String r4, Bundle r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        LogUtils.e(TAG, "Attest bundle is null");
        return new ArrayList();
    L6:
        r5.putString(SecurityFrameworkCompat.challengeKey(), r4);
        SecurityFrameworkCompat.KeyManagerResultCompat r6 = SecurityFrameworkCompat.keyAttestation(r1, r3, r5);
        if (r6.getResultCode() == SecurityFrameworkCompat.kmSuccess()) goto L10;
        LogUtils.e(TAG, "Attest key with ids failed! ret:" + r6.getResultCode());
        return new ArrayList();
    L10:
        List<Certificate> r7 = r6.getCertChain();
        if (r7 != null) goto L13;
    L17:
        LogUtils.e(TAG, "keyAttestation result certChain invalid for keyAlias=" + r3);
        return new ArrayList();
    L13:
        if (r7.isEmpty() == true) goto L17;
        LogUtils.d(TAG, "Attest key with ids succeed! keyAlias=" + r3 + ", cert chain size: " + r7.size());
        return r7;
    }

    public void deleteAttestKey(Context r3, String r4) {
        int r2 = SecurityFrameworkCompat.deleteKey((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, new Bundle());
        if (r2 != SecurityFrameworkCompat.kmSuccess()) goto L5;
        LogUtils.i(TAG, "Deleted attest key successfully: " + r4);
        return;
    L5:
        LogUtils.e(TAG, "Failed to delete attest key: " + r4 + ", ret: " + r2);
    }

    public List<Certificate> getIdAttestCertChain(Context r5, String r6, String r7, String r8, Bundle r9, Bundle r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = TAG;
        LogUtils.d(r1, "Request challenge succeed! challenge:" + r0);
        int r12 = generateKeyPair(r11, r8, r9);
        if (r12 == SecurityFrameworkCompat.kmSuccess()) goto L10;
        LogUtils.e(r1, "Generate attestation key pair failed! ret:" + r12);
        return new ArrayList();
    L10:
        List<Certificate> r13 = attestKeyWithIds(r11, r8, r0 + ":" + r7 + ":" + r6, r10);
        if (r13.isEmpty() == false) goto L14;
        LogUtils.e(r1, "attestKeyWithIds failed, delete keyAlias: " + r8);
        deleteAttestKey(r11, r8);
        return new ArrayList();
    L14:
        return r13;
    }
}
