package com.bytedance.privacy.security;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityFrameworkCompat {
    private static final String CLASS_AIASSISTANT_SDM = "com.aiassistant.security.secretdata.SecretDataManager";
    private static final String CLASS_OBRIC_SDM = "com.obric.security.secretdata.SecretDataManager";
    private static final String TAG = "SecurityFrameworkCompat";
    private static volatile Impl sImpl;

    /* JADX INFO: renamed from: com.bytedance.privacy.security.SecurityFrameworkCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AiassistantImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestAppIdKey() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestCustomInfoKey() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPrdidKey() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPruidKey() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestUdidKey() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String basePkg() {
            return "com.aiassistant.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String challengeKey() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String deviceHealthStatusRequiredKey() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyAlgoKey() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyLenKey() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyPurposeKey() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxAttestationCustomInfoLen() {
            return 1024;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxKeyAliasLen() {
            return 128;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeSign() {
            return 4;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModeIfDataExist() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModePreciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String secretBundleKeyQueryMode() {
            return "query_mode";
        }

        private AiassistantImpl() {
        }

        /* synthetic */ AiassistantImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().deleteKey(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat keyAttestation(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            KeyManagerResult r5 = KeyManager.getInstance().keyAttestation(r1, r3, r4);     // Catch: Throwable -> L9
            if (r5 != null) goto L8;
            return KeyManagerResultCompat.nullResult();
        L8:
            return KeyManagerResultCompat.of(r5.getResultCode(), r5.getCertChain(), r5.getOutData());
        L9:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "keyAttestation failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat sign(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            KeyManagerResult r6 = KeyManager.getInstance().sign(r1, r3, r4, r5);     // Catch: Throwable -> L9
            if (r6 != null) goto L8;
            return KeyManagerResultCompat.nullResult();
        L8:
            return KeyManagerResultCompat.of(r6.getResultCode(), r6.getCertChain(), r6.getOutData());
        L9:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "sign failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public SecretQueryResult querySecretData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            QueryResult r5 = SecretDataManager.getInstance().queryData(r1, r3, r4);     // Catch: Throwable -> L16
            if (r5 == null) goto L6;
            String r6 = null;
            List r7 = r5.getDataList();     // Catch: Throwable -> L16
            if (r7 == null) goto L15;
            if (r7.isEmpty() == true) goto L15;
            SecretData r8 = (SecretData) ZeusTransformUtils.preCheckCast(r7.get(0), SecretData.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r8 == null) goto L15;
            r6 = r8.privateData;     // Catch: Throwable -> L16
        L15:
            return SecretQueryResult.of(r5.getResultCode(), r6);
        L6:
            return SecretQueryResult.nullResult();
        L16:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.queryData failed", th);
            return SecretQueryResult.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int addSecretData(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            SecretData r0 = new SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            AddResult r8 = SecretDataManager.getInstance().addData(r1, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteSecretData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return SecretDataManager.getInstance().deleteData(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.deleteData failed", th);
            return -1;
        }
    }

    private interface Impl {
        int addSecretData(Context r1, String r2, String r3, String r4, String r5, Bundle r6);

        String attestAppIdKey();

        String attestCustomInfoKey();

        String attestPrdidKey();

        String attestPruidKey();

        String attestUdidKey();

        String basePkg();

        String challengeKey();

        int deleteKey(Context r1, String r2, Bundle r3);

        int deleteSecretData(Context r1, String r2, Bundle r3);

        String deviceHealthStatusRequiredKey();

        int generateKeyPair(Context r1, String r2, Bundle r3);

        String keyAlgoKey();

        int keyAlgorithmEcc();

        KeyManagerResultCompat keyAttestation(Context r1, String r2, Bundle r3);

        String keyLenKey();

        String keyPurposeKey();

        int kmSuccess();

        int maxAttestationCustomInfoLen();

        int maxKeyAliasLen();

        int purposeAttestKey();

        int purposeSign();

        int queryModeIfDataExist();

        int queryModePreciseQueryAndDecrypt();

        SecretQueryResult querySecretData(Context r1, String r2, Bundle r3);

        String secretBundleKeyQueryMode();

        KeyManagerResultCompat sign(Context r1, String r2, byte[] r3, Bundle r4);
    }

    public static final class KeyManagerResultCompat {
        private final List<Certificate> certChain;
        private final boolean isNull;
        private final byte[] outData;
        private final int resultCode;

        private KeyManagerResultCompat(boolean r3, int r4, List<Certificate> r5, byte[] r6) {
            List<Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.isNull = r3;
            this.resultCode = r4;
            if (r7 != null) goto L6;
            r7 = Collections.emptyList();
        L6:
            this.certChain = r7;
            this.outData = r6;
        }

        static KeyManagerResultCompat nullResult() {
            return new KeyManagerResultCompat(true, -1, Collections.emptyList(), null);
        }

        static KeyManagerResultCompat of(int r2, List<Certificate> r3, byte[] r4) {
            return new KeyManagerResultCompat(false, r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
        }

        public boolean isNull() {
            return this.isNull;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public List<Certificate> getCertChain() {
            return this.certChain;
        }

        public byte[] getOutData() {
            return this.outData;
        }
    }

    private static final class ObricImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestAppIdKey() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestCustomInfoKey() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPrdidKey() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPruidKey() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestUdidKey() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String basePkg() {
            return "com.obric.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String challengeKey() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String deviceHealthStatusRequiredKey() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyAlgoKey() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyLenKey() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyPurposeKey() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxAttestationCustomInfoLen() {
            return 1024;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxKeyAliasLen() {
            return 128;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeSign() {
            return 4;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModeIfDataExist() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModePreciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String secretBundleKeyQueryMode() {
            return "query_mode";
        }

        private ObricImpl() {
        }

        /* synthetic */ ObricImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat keyAttestation(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            com.obric.security.keymanager.KeyManagerResult r5 = com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r1, r3, r4);     // Catch: Throwable -> L9
            if (r5 != null) goto L8;
            return KeyManagerResultCompat.nullResult();
        L8:
            return KeyManagerResultCompat.of(r5.getResultCode(), r5.getCertChain(), r5.getOutData());
        L9:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "keyAttestation failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat sign(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            com.obric.security.keymanager.KeyManagerResult r6 = com.obric.security.keymanager.KeyManager.getInstance().sign(r1, r3, r4, r5);     // Catch: Throwable -> L9
            if (r6 != null) goto L8;
            return KeyManagerResultCompat.nullResult();
        L8:
            return KeyManagerResultCompat.of(r6.getResultCode(), r6.getCertChain(), r6.getOutData());
        L9:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "sign failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public SecretQueryResult querySecretData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            com.obric.security.secretdata.QueryResult r5 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r1, r3, r4);     // Catch: Throwable -> L16
            if (r5 == null) goto L6;
            String r6 = null;
            List r7 = r5.getDataList();     // Catch: Throwable -> L16
            if (r7 == null) goto L15;
            if (r7.isEmpty() == true) goto L15;
            com.obric.security.secretdata.SecretData r8 = (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r7.get(0), com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            if (r8 == null) goto L15;
            r6 = r8.privateData;     // Catch: Throwable -> L16
        L15:
            return SecretQueryResult.of(r5.getResultCode(), r6);
        L6:
            return SecretQueryResult.nullResult();
        L16:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.queryData failed", th);
            return SecretQueryResult.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int addSecretData(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            com.obric.security.secretdata.SecretData r0 = new com.obric.security.secretdata.SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            com.obric.security.secretdata.AddResult r8 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r1, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteSecretData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r1, r3, r4);
        L5:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.deleteData failed", th);
            return -1;
        }
    }

    public static final class SecretQueryResult {
        private final String firstPrivateData;
        private final boolean isNull;
        private final int resultCode;

        private SecretQueryResult(boolean r1, int r2, String r3) {
            this.isNull = r1;
            this.resultCode = r2;
            this.firstPrivateData = r3;
        }

        static SecretQueryResult nullResult() {
            return new SecretQueryResult(true, -1, null);
        }

        static SecretQueryResult of(int r2, String r3) {
            return new SecretQueryResult(false, r2, r3);
        }

        public boolean isNull() {
            return this.isNull;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public String getFirstPrivateData() {
            return this.firstPrivateData;
        }
    }

    private SecurityFrameworkCompat() {
    }

    private static Impl impl() {
        Impl r0 = sImpl;
        if (r0 == null) goto L6;
        return r0;
    L6:
        monitor-enter(SecurityFrameworkCompat.class);
        Impl r1 = sImpl;     // Catch: Throwable -> L21
        if (r1 == null) goto L11;
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L21
        return r1;
    L11:
        boolean r2 = hasFrameworkClass(CLASS_OBRIC_SDM);     // Catch: Throwable -> L21
        AnonymousClass1 r3 = null;
        if (hasFrameworkClass(CLASS_AIASSISTANT_SDM) == false) goto L14;
        Impl r4 = new AiassistantImpl(r3);     // Catch: Throwable -> L21
    L16:
        sImpl = r4;     // Catch: Throwable -> L21
        LogUtils.i(TAG, "Using security framework package: " + r4.basePkg());     // Catch: Throwable -> L21
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L21
        return r4;
    L14:
        if (r2 == false) goto L19;
        r4 = new ObricImpl(r3);     // Catch: Throwable -> L21
        goto L16
    L19:
        LogUtils.e(TAG, "No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
        throw new IllegalStateException("No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static boolean hasFrameworkClass(String r3) {
        Class.forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        LogUtils.e(TAG, "Class not found:" + e);
        return false;
    }

    public static String keyAlgoKey() {
        return impl().keyAlgoKey();
    }

    public static String keyLenKey() {
        return impl().keyLenKey();
    }

    public static String keyPurposeKey() {
        return impl().keyPurposeKey();
    }

    public static int keyAlgorithmEcc() {
        return impl().keyAlgorithmEcc();
    }

    public static int purposeAttestKey() {
        return impl().purposeAttestKey();
    }

    public static int purposeSign() {
        return impl().purposeSign();
    }

    public static String challengeKey() {
        return impl().challengeKey();
    }

    public static String deviceHealthStatusRequiredKey() {
        return impl().deviceHealthStatusRequiredKey();
    }

    public static String attestAppIdKey() {
        return impl().attestAppIdKey();
    }

    public static String attestPrdidKey() {
        return impl().attestPrdidKey();
    }

    public static String attestPruidKey() {
        return impl().attestPruidKey();
    }

    public static String attestUdidKey() {
        return impl().attestUdidKey();
    }

    public static String attestCustomInfoKey() {
        return impl().attestCustomInfoKey();
    }

    public static int maxKeyAliasLen() {
        return impl().maxKeyAliasLen();
    }

    public static int maxAttestationCustomInfoLen() {
        return impl().maxAttestationCustomInfoLen();
    }

    public static int kmSuccess() {
        return impl().kmSuccess();
    }

    public static int generateKeyPair(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().generateKeyPair(r5, r3, r4);
    }

    public static int deleteKey(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().deleteKey(r5, r3, r4);
    }

    public static KeyManagerResultCompat keyAttestation(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().keyAttestation(r5, r3, r4);
    }

    public static KeyManagerResultCompat sign(Context r2, String r3, byte[] r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().sign(r6, r3, r4, r5);
    }

    public static String secretBundleKeyQueryMode() {
        return impl().secretBundleKeyQueryMode();
    }

    public static int queryModeIfDataExist() {
        return impl().queryModeIfDataExist();
    }

    public static int queryModePreciseQueryAndDecrypt() {
        return impl().queryModePreciseQueryAndDecrypt();
    }

    public static SecretQueryResult querySecretData(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().querySecretData(r5, r3, r4);
    }

    public static int addSecretData(Context r7, String r8, String r9, String r10, String r11, Bundle r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        return impl().addSecretData(r1, r8, r9, r10, r11, r12);
    }

    public static int deleteSecretData(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return impl().deleteSecretData(r5, r3, r4);
    }
}
