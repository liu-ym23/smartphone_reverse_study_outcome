package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.ParamValidator;
import com.bytedance.privacy.utils.PrivacyConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class IdAttestationManager {
    private static final long CACHE_ENTRY_LIFETIME_MS = 0;
    public static final String TAG = "IdAttestationManager";
    private static final Map<String, CachedAttestation> attestationCacheMap = null;
    private static volatile IdAttestationManager idAttestationManager;

    public static class CachedAttestation {
        private final String certChain;
        private final long timestamp;

        public CachedAttestation(String r3) {
            this.certChain = r3;
            this.timestamp = System.currentTimeMillis();
        }

        public boolean isExpired() {
            if ((System.currentTimeMillis() - this.timestamp) < IdAttestationManager.access$000()) goto L5;
            return true;
        L5:
            return false;
        }

        public String getCertChain() {
            return this.certChain;
        }
    }

    public IdAttestationManager() {
    }

    static /* synthetic */ long access$000() {
        return CACHE_ENTRY_LIFETIME_MS;
    }

    public static IdAttestationManager getInstance() {
        if (idAttestationManager != null) goto L15;
        monitor-enter(IdAttestationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (idAttestationManager != null) goto L9;
        idAttestationManager = new IdAttestationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdAttestationManager.class);     // Catch: Throwable -> L11
    L15:
        return idAttestationManager;
    }

    static {
        attestationCacheMap = new ConcurrentHashMap();
        CACHE_ENTRY_LIFETIME_MS = TimeUnit.DAYS.toMillis(1);
    }

    private String getIDAttestation(Context r11, String r12, String r13, AttestationConfig r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        validateInput(r15, r12, r13, r14);
        if (PrivacyConfig.isDebug() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L19;
        String r1 = TAG;
        LogUtils.i(r1, "Entering cache check...");
        CachedAttestation r2 = (CachedAttestation) ZeusTransformUtils.preCheckCast(attestationCacheMap.get(r13), CachedAttestation.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L12;
    L15:
        if (r2 != null) goto L17;
        LogUtils.i(r1, "Attestation cache miss for keyAlias: " + r13);
    L18:
        LogUtils.i(r1, "Exiting cache check, moving to network flow");
    L20:
        String r7 = r13.intern();
        monitor-enter(r7);
        Map<String, CachedAttestation> r8 = attestationCacheMap;     // Catch: Throwable -> L48
        CachedAttestation r3 = (CachedAttestation) ZeusTransformUtils.preCheckCast(r8.get(r13), CachedAttestation.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        if (r0 == true) goto L30;
        if (r3 == null) goto L30;
        if (r3.isExpired() == true) goto L30;
        LogUtils.i(TAG, "Cache hit after wait for keyAlias: " + r13);     // Catch: Throwable -> L48
        String r10 = r3.getCertChain();     // Catch: Throwable -> L48
        monitor-exit(r7);     // Catch: Throwable -> L48
        return r10;
    L30:
        String r9 = TAG;     // Catch: Throwable -> L48
        LogUtils.d(r9, r14.toString());     // Catch: Throwable -> L48
        Bundle r6 = buildAttestBundle(r15, r12, r14);     // Catch: Throwable -> L48
        Bundle r5 = buildKeyBundle();     // Catch: Throwable -> L48
        String r4 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L48
        if (r4.isEmpty() == true) goto L47;
        AttestKeyManager.getInstance().deleteAttestKey(r15, r13);     // Catch: Throwable -> L48
        List<Certificate> r16 = AttestKeyManager.getInstance().getIdAttestCertChain(r15, r12, r4, r13, r5, r6);     // Catch: Throwable -> L48
        if (r16 == null) goto L45;
        if (r16.isEmpty() == true) goto L45;
        String r17 = CertUtils.certsToPemString(r16, 3);     // Catch: Exception -> L41 Throwable -> L48
        r8.put(r13, new CachedAttestation(r17));     // Catch: Throwable -> L48
        LogUtils.i(r9, "Successfully gen attestation and stored in cache for keyAlias: " + r13);     // Catch: Throwable -> L48
        AttestKeyManager.getInstance().deleteAttestKey(r15, r13);     // Catch: Throwable -> L48
        monitor-exit(r7);     // Catch: Throwable -> L48
        return r17;
    L41:
        e = move-exception;
        LogUtils.e(TAG, "certsToPemString unexpected error: " + e.getMessage(), e);     // Catch: Throwable -> L48
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L48
    L45:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L48
    L47:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L17:
        LogUtils.i(r1, "Attestation cache expired for keyAlias: " + r13);
        goto L18
    L12:
        if (r2.isExpired() == true) goto L15;
        LogUtils.i(r1, "Cache hit, returning cert chain for keyAlias: " + r13);
        return r2.getCertChain();
    L19:
        LogUtils.i(TAG, "Debug mode with force cloud fetch, skipping cache check");
        goto L20
    L5:
        if (PrivacyConfig.isForceFetchFromCloud(2) == false) goto L7;
        r0 = true;
        goto L8
    }

    public String getIDAttestationString(Context r10, String r11, String r12, AttestationConfig r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L5;
        String r4 = r14.getPackageName();
    L6:
        long r1 = System.currentTimeMillis();
        String r9 = getIDAttestation(r14, r11, r12, r13);     // Catch: Throwable -> L17 BdPrivacyException -> L19
        long r6 = System.currentTimeMillis() - r1;
        if (r11 == null) goto L11;
        String r5 = r11;
    L12:
        if (r13 != null) goto L15;
        r13 = new AttestationConfig.Builder().build();
    L15:
        IdAttestationEventTrace.eventTrace(0, 0, r4, r5, r6, r13);
        return r9;
    L11:
        r5 = "";
        goto L12
    L19:
        e = move-exception;
        int r15 = e.getErrorCode();     // Catch: Throwable -> L17
        LogUtils.e(TAG, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = th;
    L24:
        long r7 = System.currentTimeMillis() - r1;
        if (r11 == null) goto L27;
        String r8 = r11;
    L28:
        if (r13 != null) goto L31;
        r13 = new AttestationConfig.Builder().build();
    L31:
        IdAttestationEventTrace.eventTrace(r15, 0, r4, r8, r7, r13);
        throw th;
    L27:
        r8 = "";
    L17:
        th = th;
        r15 = 0;
        goto L24
    L5:
        r4 = "";
        goto L6
    }

    private void validateInput(Context r2, String r3, String r4, AttestationConfig r5) {
        ParamValidator.checkNotNull("context", (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        ParamValidator.checkNotNull("config", r5);
        ParamValidator.checkLength("appId", r3, 128);
        ParamValidator.checkLength("keyAlias", r4, SecurityFrameworkCompat.maxKeyAliasLen());
    }

    private Bundle buildAttestBundle(Context r4, String r5, AttestationConfig r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putString(SecurityFrameworkCompat.attestAppIdKey(), r5);
    L35:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    L4:
        if (r6.isIdRequested(AttestationConfig.IdType.RPDID) == false) goto L13;
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r7, r5);     // Catch: IllegalStateException -> L35
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.putString(SecurityFrameworkCompat.attestPrdidKey(), r1);     // Catch: IllegalStateException -> L35
    L11:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L35
    L13:
        if (r6.isIdRequested(AttestationConfig.IdType.RPUID) == false) goto L22;
        String r8 = PrivacySdk.getPseudoManager().getPseudoUID(r7, r5);     // Catch: IllegalStateException -> L35
        if (r8 == null) goto L20;
        if (r8.isEmpty() == true) goto L20;
        r0.putString(SecurityFrameworkCompat.attestPruidKey(), r8);     // Catch: IllegalStateException -> L35
    L20:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L35
    L22:
        if (r6.isIdRequested(AttestationConfig.IdType.UDID) == false) goto L29;
        String r3 = getUDID();     // Catch: IllegalStateException -> L35
        if (r3.isEmpty() == true) goto L27;
        r0.putString(SecurityFrameworkCompat.attestUdidKey(), r3);     // Catch: IllegalStateException -> L35
        goto L29
    L27:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L35
    L29:
        if (r6.isDevHealthStatusRequired() == false) goto L32;
        r0.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);     // Catch: IllegalStateException -> L35
    L32:
        if (r6.getCustomInfo() == null) goto L34;
        r0.putString(SecurityFrameworkCompat.attestCustomInfoKey(), r6.getCustomInfo());
    L34:
        return r0;
    }

    private Bundle buildKeyBundle() {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r2.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r2.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey());
        return r2;
    }

    private String getUDID() {
        String r3 = AccountApi.INSTANCE.getUDID();
        if (r3.length() == 64) goto L6;
        LogUtils.e(TAG, "Invalid UDID length: " + r3.length());
        return "";
    L6:
        return r3;
    }
}
