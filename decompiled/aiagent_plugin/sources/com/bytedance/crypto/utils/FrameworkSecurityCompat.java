package com.bytedance.crypto.utils;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.aiassistant.security.rot_provision.RotProvisionManager;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSecurityCompat {
    private static final String AIASSISTANT_KEY_MANAGER = "com.aiassistant.security.keymanager.KeyManager";
    private static final String AIASSISTANT_PLATFORM_KEY_MANAGER = "com.aiassistant.security.platformkey.PlatformKeyManager";
    private static final String AIASSISTANT_ROT_PROVISION_MANAGER = "com.aiassistant.security.rot_provision.RotProvisionManager";
    private static final String AIASSISTANT_SECRET_DATA_MANAGER = "com.aiassistant.security.secretdata.SecretDataManager";
    private static final String OBRIC_KEY_MANAGER = "com.obric.security.keymanager.KeyManager";
    private static final String OBRIC_PLATFORM_KEY_MANAGER = "com.obric.security.platformkey.PlatformKeyManager";
    private static final String OBRIC_ROT_PROVISION_MANAGER = "com.obric.security.rot_provision.RotProvisionManager";
    private static final String OBric_SECRET_DATA_MANAGER = "com.obric.security.secretdata.SecretDataManager";
    private static final String TAG = "FrameworkSecurityCompat";
    private static volatile Impl sKeyManagerImpl;
    private static volatile Impl sPlatformKeyImpl;
    private static volatile Impl sRotProvisionImpl;
    private static volatile Impl sSecretDataImpl;

    /* JADX INFO: renamed from: com.bytedance.crypto.utils.FrameworkSecurityCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AiassistantImpl implements Impl {
        private AiassistantImpl() {
        }

        public /* synthetic */ AiassistantImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r4, Object r5, Bundle r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, com.aiassistant.security.secretdata.SecretData.class) == true) goto L5;
            return -1;
        L5:
            AddResult r7 = SecretDataManager.getInstance().addData(r3, (com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r5, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin"), r6);
            if (r7 != null) goto L9;
            return -1;
        L9:
            return r7.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyAad() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return SecretDataManager.getInstance().deleteData(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().deleteKey(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r2, String r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().deleteSyncKey(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new AiassistantKmResult(KeyManager.getInstance().getCertificateChain(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().importKey(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return KeyManager.getInstance().importKeyLegacy(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new AiassistantKmResult(KeyManager.getInstance().keyAgreement(r1, r3, r4, r5), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new AiassistantKmResult(KeyManager.getInstance().keyAttestation(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.aiassistant.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            return PlatformKeyManager.getInstance().decrypt(r1, r8, r9, r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyEncrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            return PlatformKeyManager.getInstance().encrypt(r1, r8, r9, r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformTagLen() {
            return 16;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new AiassistantSdQueryResult(SecretDataManager.getInstance().queryData(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            String r4 = RotProvisionManager.getInstance().checkState(r1, r3);
            if (r4 != null) goto L6;
            return "";
        L6:
            return r4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r2) {
            String r1 = ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).extInfo;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r2) {
            String r1 = ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).publicData;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r2) {
            String r1 = ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).searchInfo;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r2) {
            String r1 = ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).secretData;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r2, String r3) {
            ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).alias = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r2, String r3) {
            ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).extInfo = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r2, String r3) {
            ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).publicData = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r2, String r3) {
            ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).searchInfo = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r2, String r3) {
            ((com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).secretData = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r3, Object r4, Bundle r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, com.aiassistant.security.secretdata.SecretData.class) == true) goto L7;
            return -1;
        L7:
            return SecretDataManager.getInstance().updateData(r2, (com.aiassistant.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r4, com.aiassistant.security.secretdata.SecretData.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r2, int r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new AiassistantKmResult(KeyManager.getInstance().xcrypt(r1, r3, r4, r5), null);
        }
    }

    public static final class AiassistantKmResult implements KmResult {
        private final KeyManagerResult m;

        private AiassistantKmResult(KeyManagerResult r3) {
            this.m = (KeyManagerResult) ZeusTransformUtils.wrapperContextForParams(r3, KeyManagerResult.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ AiassistantKmResult(KeyManagerResult r2, AnonymousClass1 r3) {
            this((KeyManagerResult) ZeusTransformUtils.wrapperContextForParams(r2, KeyManagerResult.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return new byte[0];
        L6:
            return r0.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
        }
    }

    public static final class AiassistantSdQueryResult implements SdQueryResult {
        private final QueryResult m;

        private AiassistantSdQueryResult(QueryResult r3) {
            this.m = (QueryResult) ZeusTransformUtils.wrapperContextForParams(r3, QueryResult.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ AiassistantSdQueryResult(QueryResult r2, AnonymousClass1 r3) {
            this((QueryResult) ZeusTransformUtils.wrapperContextForParams(r2, QueryResult.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
        }
    }

    public interface Impl {
        int addData(Context r1, Object r2, Bundle r3);

        String additionalData();

        String bundleKeyAad();

        String bundleKeyQueryMode();

        String challenge();

        int deleteData(Context r1, String r2, Bundle r3);

        int deleteKey(Context r1, String r2, Bundle r3);

        int deleteSyncKey(Context r1, String r2);

        String deviceHealthStatusRequired();

        String eccPrivateKey();

        String eccPublicKey();

        int generateKeyPair(Context r1, String r2, Bundle r3);

        KmResult getCertificateChain(Context r1, String r2, Bundle r3);

        int importKey(Context r1, Bundle r2);

        int importKeyLegacy(Context r1, Bundle r2);

        KmResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4);

        String keyAlgo();

        int keyAlgorithmEcc();

        String keyAlias();

        KmResult keyAttestation(Context r1, String r2, Bundle r3);

        String keyLen();

        String keyPurpose();

        int kmSuccess();

        Object newSecretData();

        int platformIvLen();

        byte[] platformKeyDecrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5);

        byte[] platformKeyEncrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5);

        int platformMagicNumLen();

        int platformSm8750();

        int platformTagLen();

        int platformVerLen();

        int preciseQueryAndDecrypt();

        int purposeAgreeKey();

        int purposeAttestKey();

        SdQueryResult queryData(Context r1, String r2, Bundle r3);

        String rotCheckState(Context r1, Bundle r2);

        String sdGetExtInfo(Object r1);

        String sdGetPublicData(Object r1);

        String sdGetSearchInfo(Object r1);

        String sdGetSecretData(Object r1);

        void sdSetAlias(Object r1, String r2);

        void sdSetExtInfo(Object r1, String r2);

        void sdSetPublicData(Object r1, String r2);

        void sdSetSearchInfo(Object r1, String r2);

        void sdSetSecretData(Object r1, String r2);

        int secretDataNotFound();

        int secretSuccess();

        int updateData(Context r1, Object r2, Bundle r3);

        String wrappedKeyData();

        KmResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4);
    }

    public static final class KeyManagerConst {
        public KeyManagerConst() {
        }

        public static String ADDITIONAL_DATA() {
            return FrameworkSecurityCompat.access$900().additionalData();
        L4:
            return "ADDITIONAL_DATA";
        }

        public static String CHALLENGE() {
            return FrameworkSecurityCompat.access$900().challenge();
        L4:
            return "CHALLENGE";
        }

        public static String DEVICE_HEALTH_STATUS_REQUIRED() {
            return FrameworkSecurityCompat.access$900().deviceHealthStatusRequired();
        L4:
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        public static String ECC_PRIVATE_KEY() {
            return FrameworkSecurityCompat.access$900().eccPrivateKey();
        L4:
            return "ECC_PRIVATE_KEY";
        }

        public static String ECC_PUBLIC_KEY() {
            return FrameworkSecurityCompat.access$900().eccPublicKey();
        L4:
            return "ECC_PUBLIC_KEY";
        }

        public static String KEY_ALGO() {
            return FrameworkSecurityCompat.access$900().keyAlgo();
        L4:
            return "KEY_ALGO";
        }

        public static int KEY_ALGORITHM_ECC() {
            return FrameworkSecurityCompat.access$900().keyAlgorithmEcc();
        L4:
            return -1;
        }

        public static String KEY_ALIAS() {
            return FrameworkSecurityCompat.access$900().keyAlias();
        L4:
            return "KEY_ALIAS";
        }

        public static String KEY_LEN() {
            return FrameworkSecurityCompat.access$900().keyLen();
        L4:
            return "KEY_LEN";
        }

        public static String KEY_PURPOSE() {
            return FrameworkSecurityCompat.access$900().keyPurpose();
        L4:
            return "KEY_PURPOSE";
        }

        public static int PURPOSE_AGREE_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAgreeKey();
        L4:
            return 0;
        }

        public static int PURPOSE_ATTEST_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAttestKey();
        L4:
            return 0;
        }

        public static String WRAPPED_KEY_DATA() {
            return FrameworkSecurityCompat.access$900().wrappedKeyData();
        L4:
            return "WRAPPED_KEY_DATA";
        }
    }

    public static final class KeyManagerErrorCode {
        public KeyManagerErrorCode() {
        }

        public static int KM_SUCCESS() {
            return FrameworkSecurityCompat.access$900().kmSuccess();
        L4:
            return 0;
        }
    }

    public interface KmResult {
        List<Certificate> getCertChain();

        byte[] getOutData();

        int getResultCode();
    }

    public static final class NoopImpl implements Impl {
        private NoopImpl() {
        }

        public /* synthetic */ NoopImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r1, Object r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "ADDITIONAL_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyAad() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "BUNDLE_KEY_QUERY_MODE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "CHALLENGE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r1, String r2) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ECC_PRIVATE_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ECC_PUBLIC_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r1, Bundle r2) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r1, Bundle r2) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "KEY_ALGO";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "KEY_ALIAS";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "KEY_LEN";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "KEY_PURPOSE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyEncrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformTagLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r1, String r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return new NoopSdQueryResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r1, Bundle r2) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r1, Object r2, Bundle r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "WRAPPED_KEY_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            return new NoopKmResult(null);
        }
    }

    public static final class NoopKmResult implements KmResult {
        private NoopKmResult() {
        }

        public /* synthetic */ NoopKmResult(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            return new byte[0];
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class NoopSdQueryResult implements SdQueryResult {
        private NoopSdQueryResult() {
        }

        public /* synthetic */ NoopSdQueryResult(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class ObricImpl implements Impl {
        private ObricImpl() {
        }

        public /* synthetic */ ObricImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r4, Object r5, Bundle r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, com.obric.security.secretdata.SecretData.class) == true) goto L5;
            return -1;
        L5:
            com.obric.security.secretdata.AddResult r7 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r3, (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r5, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin"), r6);
            if (r7 != null) goto L9;
            return -1;
        L9:
            return r7.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyAad() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r2, String r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().deleteSyncKey(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r1, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().getCertificateChain(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().importKey(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.keymanager.KeyManager.getInstance().importKeyLegacy(r1, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r2, String r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAgreement(r1, r3, r4, r5), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.obric.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().decrypt(r1, r8, r9, r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyEncrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().encrypt(r1, r8, r9, r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformTagLen() {
            return 16;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r2, String r3, Bundle r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new ObricSdQueryResult(com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r1, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r2, Bundle r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            String r4 = com.obric.security.rot_provision.RotProvisionManager.getInstance().checkState(r1, r3);
            if (r4 != null) goto L6;
            return "";
        L6:
            return r4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r2) {
            String r1 = ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).extInfo;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r2) {
            String r1 = ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).publicData;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r2) {
            String r1 = ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).searchInfo;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r2) {
            String r1 = ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).secretData;
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r2, String r3) {
            ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).alias = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r2, String r3) {
            ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).extInfo = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r2, String r3) {
            ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).publicData = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r2, String r3) {
            ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).searchInfo = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r2, String r3) {
            ((com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r2, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin")).secretData = r3;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r3, Object r4, Bundle r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, com.obric.security.secretdata.SecretData.class) == true) goto L7;
            return -1;
        L7:
            return com.obric.security.secretdata.SecretDataManager.getInstance().updateData(r2, (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(r4, com.obric.security.secretdata.SecretData.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r2, int r3, byte[] r4, Bundle r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().xcrypt(r1, r3, r4, r5), null);
        }
    }

    public static final class ObricKmResult implements KmResult {
        private final com.obric.security.keymanager.KeyManagerResult m;

        private ObricKmResult(com.obric.security.keymanager.KeyManagerResult r3) {
            this.m = (com.obric.security.keymanager.KeyManagerResult) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.security.keymanager.KeyManagerResult.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ ObricKmResult(com.obric.security.keymanager.KeyManagerResult r2, AnonymousClass1 r3) {
            this((com.obric.security.keymanager.KeyManagerResult) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.security.keymanager.KeyManagerResult.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            com.obric.security.keymanager.KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            com.obric.security.keymanager.KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return new byte[0];
        L6:
            return r0.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            com.obric.security.keymanager.KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
        }
    }

    public static final class ObricSdQueryResult implements SdQueryResult {
        private final com.obric.security.secretdata.QueryResult m;

        private ObricSdQueryResult(com.obric.security.secretdata.QueryResult r3) {
            this.m = (com.obric.security.secretdata.QueryResult) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.security.secretdata.QueryResult.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ ObricSdQueryResult(com.obric.security.secretdata.QueryResult r2, AnonymousClass1 r3) {
            this((com.obric.security.secretdata.QueryResult) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.security.secretdata.QueryResult.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            com.obric.security.secretdata.QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            com.obric.security.secretdata.QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
        }
    }

    public static final class PlatformKeyConst {
        public PlatformKeyConst() {
        }

        public static String BUNDLE_KEY_AAD() {
            return FrameworkSecurityCompat.access$1100().bundleKeyAad();
        L4:
            return "aad";
        }

        public static int IV_LEN() {
            return FrameworkSecurityCompat.access$1100().platformIvLen();
        L4:
            return 0;
        }

        public static int MAGIC_NUM_LEN() {
            return FrameworkSecurityCompat.access$1100().platformMagicNumLen();
        L4:
            return 0;
        }

        public static int PLATFORM_SM8750() {
            return FrameworkSecurityCompat.access$1100().platformSm8750();
        L4:
            return 0;
        }

        public static int PLATFORM_VER_LEN() {
            return FrameworkSecurityCompat.access$1100().platformVerLen();
        L4:
            return 0;
        }

        public static int TAG_LEN() {
            return FrameworkSecurityCompat.access$1100().platformTagLen();
        L4:
            return 0;
        }
    }

    public static final class QueryMode {
        public QueryMode() {
        }

        public static int PRECISE_QUERY_AND_DECRYPT() {
            return FrameworkSecurityCompat.access$1000().preciseQueryAndDecrypt();
        L4:
            return 0;
        }
    }

    public interface SdQueryResult {
        List<?> getDataList();

        int getResultCode();
    }

    public static final class SecretConst {
        public SecretConst() {
        }

        public static String BUNDLE_KEY_QUERY_MODE() {
            return FrameworkSecurityCompat.access$1000().bundleKeyQueryMode();
        L4:
            return "BUNDLE_KEY_QUERY_MODE";
        }
    }

    public static final class SecretData {
        public SecretData() {
        }

        public static String getExtInfo(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$1000().sdGetExtInfo(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getExtInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getPublicData(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$1000().sdGetPublicData(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getPublicData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSearchInfo(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$1000().sdGetSearchInfo(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSearchInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSecretData(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$1000().sdGetSecretData(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSecretData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static Object newInstance() {
            return FrameworkSecurityCompat.access$1000().newSecretData();
        L4:
            return null;
        }

        public static void setAlias(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$1000().sdSetAlias(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setAlias failed: " + th.getMessage());
            return;
        }

        public static void setExtInfo(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$1000().sdSetExtInfo(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setExtInfo failed: " + th.getMessage());
            return;
        }

        public static void setPublicData(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$1000().sdSetPublicData(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setPublicData failed: " + th.getMessage());
            return;
        }

        public static void setSearchInfo(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$1000().sdSetSearchInfo(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSearchInfo failed: " + th.getMessage());
            return;
        }

        public static void setSecretData(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$1000().sdSetSecretData(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSecretData failed: " + th.getMessage());
            return;
        }
    }

    public static final class SecretErrorCode {
        public SecretErrorCode() {
        }

        public static int DATA_NOT_FOUNT() {
            return FrameworkSecurityCompat.access$1000().secretDataNotFound();
        L4:
            return -1;
        }

        public static int SUCCESS() {
            return FrameworkSecurityCompat.access$1000().secretSuccess();
        L4:
            return 0;
        }
    }

    private FrameworkSecurityCompat() {
    }

    public static /* synthetic */ Impl access$1000() {
        return secretDataImpl();
    }

    public static /* synthetic */ Impl access$1100() {
        return platformKeyImpl();
    }

    public static /* synthetic */ Impl access$900() {
        return keyManagerImpl();
    }

    public static int addData(Context r2, Object r3, Bundle r4) {
        return secretDataImpl().addData((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "addData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteData(Context r2, String r3, Bundle r4) {
        return secretDataImpl().deleteData((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "deleteData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteKey(Context r2, String r3, Bundle r4) {
        return keyManagerImpl().deleteKey((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "deleteKey failed: " + th.getMessage());
        return -1;
    }

    public static int deleteSyncKey(Context r2, String r3) {
        return keyManagerImpl().deleteSyncKey((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "deleteSyncKey failed: " + th.getMessage());
        return -1;
    }

    public static int generateKeyPair(Context r2, String r3, Bundle r4) {
        return keyManagerImpl().generateKeyPair((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "generateKeyPair failed: " + th.getMessage());
        return -1;
    }

    public static KmResult getCertificateChain(Context r2, String r3, Bundle r4) {
        return keyManagerImpl().getCertificateChain((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "getCertificateChain failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    private static boolean hasAiassistantKeyManager() {
        return hasClass(AIASSISTANT_KEY_MANAGER);
    }

    private static boolean hasAiassistantPlatformKeyManager() {
        return hasClass(AIASSISTANT_PLATFORM_KEY_MANAGER);
    }

    private static boolean hasAiassistantRotProvisionManager() {
        return hasClass(AIASSISTANT_ROT_PROVISION_MANAGER);
    }

    private static boolean hasAiassistantSecretDataManager() {
        return hasClass(AIASSISTANT_SECRET_DATA_MANAGER);
    }

    private static boolean hasClass(String r3) {
        Class.forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        LogUtils.e(TAG, "Class not found:" + e);
        return false;
    }

    private static boolean hasObricKeyManager() {
        return hasClass(OBRIC_KEY_MANAGER);
    }

    private static boolean hasObricPlatformKeyManager() {
        return hasClass(OBRIC_PLATFORM_KEY_MANAGER);
    }

    private static boolean hasObricRotProvisionManager() {
        return hasClass(OBRIC_ROT_PROVISION_MANAGER);
    }

    private static boolean hasObricSecretDataManager() {
        return hasClass(OBric_SECRET_DATA_MANAGER);
    }

    public static boolean hasPlatformKeyManager() {
        if (hasObricPlatformKeyManager() == false) goto L5;
    L8:
        return true;
    L5:
        if (hasAiassistantPlatformKeyManager() == true) goto L8;
        return false;
    }

    public static int importKey(Context r2, Bundle r3) {
        return keyManagerImpl().importKey((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "importKey failed: " + th.getMessage());
        return -1;
    }

    public static int importKeyLegacy(Context r2, Bundle r3) {
        return keyManagerImpl().importKeyLegacy((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "importKeyLegacy failed: " + th.getMessage());
        return -1;
    }

    public static KmResult keyAgreement(Context r2, String r3, byte[] r4, Bundle r5) {
        return keyManagerImpl().keyAgreement((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "keyAgreement failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static KmResult keyAttestation(Context r2, String r3, Bundle r4) {
        return keyManagerImpl().keyAttestation((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "keyAttestation failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    private static Impl keyManagerImpl() {
        if (sKeyManagerImpl == null) goto L7;
        return sKeyManagerImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sKeyManagerImpl == null) goto L13;
        Impl r1 = sKeyManagerImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r1;
    L13:
        AnonymousClass1 r2 = null;
        if (hasObricKeyManager() == false) goto L17;
        sKeyManagerImpl = new ObricImpl(r2);     // Catch: Throwable -> L24
        String r3 = TAG;
        String r4 = "Resolved keymanager package: com.obric.security";
    L19:
        LogUtils.i(r3, r4);     // Catch: Throwable -> L24
    L21:
        Impl r5 = sKeyManagerImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r5;
    L17:
        if (hasAiassistantKeyManager() == false) goto L20;
        sKeyManagerImpl = new AiassistantImpl(r2);     // Catch: Throwable -> L24
        r3 = TAG;
        r4 = "Resolved keymanager package: com.aiassistant.security";
        goto L19
    L20:
        sKeyManagerImpl = new NoopImpl(r2);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No keymanager package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static byte[] platformKeyDecrypt(Context r6, int r7, byte[] r8, byte[] r9, Bundle r10) {
        return platformKeyImpl().platformKeyDecrypt((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "platformKeyDecrypt failed: " + th.getMessage());
        return null;
    }

    public static byte[] platformKeyEncrypt(Context r6, int r7, byte[] r8, byte[] r9, Bundle r10) {
        return platformKeyImpl().platformKeyEncrypt((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "platformKeyEncrypt failed: " + th.getMessage());
        return null;
    }

    private static Impl platformKeyImpl() {
        if (sPlatformKeyImpl == null) goto L7;
        return sPlatformKeyImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sPlatformKeyImpl == null) goto L13;
        Impl r1 = sPlatformKeyImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r1;
    L13:
        AnonymousClass1 r2 = null;
        if (hasObricPlatformKeyManager() == false) goto L17;
        sPlatformKeyImpl = new ObricImpl(r2);     // Catch: Throwable -> L24
        String r3 = TAG;
        String r4 = "Resolved platformkey package: com.obric.security";
    L19:
        LogUtils.i(r3, r4);     // Catch: Throwable -> L24
    L21:
        Impl r5 = sPlatformKeyImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r5;
    L17:
        if (hasAiassistantPlatformKeyManager() == false) goto L20;
        sPlatformKeyImpl = new AiassistantImpl(r2);     // Catch: Throwable -> L24
        r3 = TAG;
        r4 = "Resolved platformkey package: com.aiassistant.security";
        goto L19
    L20:
        sPlatformKeyImpl = new NoopImpl(r2);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No platformkey package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static SdQueryResult queryData(Context r2, String r3, Bundle r4) {
        return secretDataImpl().queryData((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "queryData failed: " + th.getMessage());
        return new NoopSdQueryResult(null);
    }

    public static String rotCheckState(Context r2, Bundle r3) {
        return rotProvisionImpl().rotCheckState((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "rotCheckState failed: " + th.getMessage());
        return "";
    }

    private static Impl rotProvisionImpl() {
        if (sRotProvisionImpl == null) goto L7;
        return sRotProvisionImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sRotProvisionImpl == null) goto L13;
        Impl r1 = sRotProvisionImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r1;
    L13:
        AnonymousClass1 r2 = null;
        if (hasObricRotProvisionManager() == false) goto L17;
        sRotProvisionImpl = new ObricImpl(r2);     // Catch: Throwable -> L24
        String r3 = TAG;
        String r4 = "Resolved rot_provision package: com.obric.security";
    L19:
        LogUtils.i(r3, r4);     // Catch: Throwable -> L24
    L21:
        Impl r5 = sRotProvisionImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r5;
    L17:
        if (hasAiassistantRotProvisionManager() == false) goto L20;
        sRotProvisionImpl = new AiassistantImpl(r2);     // Catch: Throwable -> L24
        r3 = TAG;
        r4 = "Resolved rot_provision package: com.aiassistant.security";
        goto L19
    L20:
        sRotProvisionImpl = new NoopImpl(r2);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No rot_provision package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    private static Impl secretDataImpl() {
        if (sSecretDataImpl == null) goto L7;
        return sSecretDataImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sSecretDataImpl == null) goto L13;
        Impl r1 = sSecretDataImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r1;
    L13:
        AnonymousClass1 r2 = null;
        if (hasObricSecretDataManager() == false) goto L17;
        sSecretDataImpl = new ObricImpl(r2);     // Catch: Throwable -> L24
        String r3 = TAG;
        String r4 = "Resolved secretdata package: com.obric.security";
    L19:
        LogUtils.i(r3, r4);     // Catch: Throwable -> L24
    L21:
        Impl r5 = sSecretDataImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r5;
    L17:
        if (hasAiassistantSecretDataManager() == false) goto L20;
        sSecretDataImpl = new AiassistantImpl(r2);     // Catch: Throwable -> L24
        r3 = TAG;
        r4 = "Resolved secretdata package: com.aiassistant.security";
        goto L19
    L20:
        sSecretDataImpl = new NoopImpl(r2);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No secretdata package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static int updateData(Context r2, Object r3, Bundle r4) {
        return secretDataImpl().updateData((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "updateData failed: " + th.getMessage());
        return -1;
    }

    public static KmResult xcrypt(Context r2, int r3, byte[] r4, Bundle r5) {
        return keyManagerImpl().xcrypt((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    L5:
        th = move-exception;
        LogUtils.e(TAG, "xcrypt failed: " + th.getMessage());
        return new NoopKmResult(null);
    }
}
