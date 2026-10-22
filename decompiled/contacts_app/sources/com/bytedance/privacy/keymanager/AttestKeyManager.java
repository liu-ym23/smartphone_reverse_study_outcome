package com.bytedance.privacy.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.privacy.network.ChallengeManager;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.security.keymanager.KeyManager;
import com.bytedance.security.keymanager.KeyManagerResult;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = TAG;
        LogUtils.d(r1, "Request challenge succeed! challenge:" + r0);
        int r10 = generateKeyPair(r5, r6, r9);
        if (r10 == 0) goto L11;
        LogUtils.e(r1, "Generate attestation key pair failed! ret:" + r10);
        return new ArrayList();
    L11:
        return attestKey(r5, r6, r0 + SimContactsConstants.ANR_SEP + r7 + SimContactsConstants.ANR_SEP + r6, r8);
    }

    private int generateKeyPair(Context r1, String r2, Bundle r3) {
        int r0 = KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        if (r0 == 0) goto L6;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r0);
        return r0;
    L6:
        return 0;
    }

    private List<Certificate> attestKey(Context r3, String r4, String r5, boolean r6) {
        Bundle r2 = new Bundle();
        if (r6 == false) goto L5;
        r2.putBoolean("device_health_status_required", true);
        r2.putString("challenge", r5);
    L6:
        KeyManagerResult r7 = KeyManager.getInstance().keyAttestation(r3, r4, r2);
        if (r7.getResultCode() == 0) goto L10;
        LogUtils.e(TAG, "Attest key failed! ret:" + r7.getResultCode());
        return new ArrayList();
    L10:
        List<Certificate> r8 = r7.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r8.size());
        return r8;
    L5:
        r2.putString("challenge", r5);
        goto L6
    }

    private List<Certificate> attestKeyWithIds(Context r1, String r2, String r3, Bundle r4) {
        if (r4 != null) goto L5;
        LogUtils.e(TAG, "Attest bundle is null");
        return new ArrayList();
    L5:
        r4.putString("challenge", r3);
        KeyManagerResult r0 = KeyManager.getInstance().keyAttestation(r1, r2, r4);
        if (r0.getResultCode() == 0) goto L9;
        LogUtils.e(TAG, "Attest key with ids failed! ret:" + r0.getResultCode());
        return new ArrayList();
    L9:
        List<Certificate> r5 = r0.getCertChain();
        if (r5 != null) goto L12;
    L16:
        LogUtils.e(TAG, "keyAttestation result certChain invalid for keyAlias=" + r2);
        return new ArrayList();
    L12:
        if (r5.isEmpty() == true) goto L16;
        LogUtils.d(TAG, "Attest key with ids succeed! keyAlias=" + r2 + ", cert chain size: " + r5.size());
        return r5;
    }

    public void deleteAttestKey(Context r3, String r4) {
        int r2 = KeyManager.getInstance().deleteKey(r3, r4, new Bundle());
        if (r2 != 0) goto L5;
        LogUtils.i(TAG, "Deleted attest key successfully: " + r4);
        return;
    L5:
        LogUtils.e(TAG, "Failed to delete attest key: " + r4 + ", ret: " + r2);
    }

    public List<Certificate> getIdAttestCertChain(Context r5, String r6, String r7, String r8, Bundle r9, Bundle r10) {
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = TAG;
        LogUtils.d(r1, "Request challenge succeed! challenge:" + r0);
        int r11 = generateKeyPair(r5, r8, r9);
        if (r11 == 0) goto L10;
        LogUtils.e(r1, "Generate attestation key pair failed! ret:" + r11);
        return new ArrayList();
    L10:
        List<Certificate> r12 = attestKeyWithIds(r5, r8, r0 + SimContactsConstants.ANR_SEP + r7 + SimContactsConstants.ANR_SEP + r6, r10);
        if (r12.isEmpty() == false) goto L14;
        LogUtils.e(r1, "attestKeyWithIds failed, delete keyAlias: " + r8);
        deleteAttestKey(r5, r8);
        return new ArrayList();
    L14:
        return r12;
    }
}
