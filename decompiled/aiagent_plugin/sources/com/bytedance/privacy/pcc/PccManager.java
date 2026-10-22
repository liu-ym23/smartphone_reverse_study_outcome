package com.bytedance.privacy.pcc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.db.PccChannelDb;
import com.bytedance.privacy.pcc.network.PccNetworkManager;
import com.bytedance.privacy.pcc.network.model.CreateChannelRequest;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetRequest;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class PccManager {
    private static final String ATTEST_ROOT_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICZzCCAg6gAwIBAgIUGJmXeMuqSaXDKR9SmU6CizMYc9owCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODQ0MzNaFw00NDEyMzExNjAwMDBaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBPUENDIEV2aWRlbmNlIFRva2VuIENBMTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABJ9VunGoIJr4YdiyA4q9VG5SvbOxcwUcsEmyw5HnMcAK4c9D8kAw\nklDUo1lzvxFM0wRKuqQyPm3tudnXYp+YvaqjgakwgaYwDgYDVR0PAQH/BAQDAgGG\nMA8GA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYEFO4NorzPIpUFhHMoRicKQXOJCO91\nMB8GA1UdIwQYMBaAFCN6HBQRj2cdTtMkScSwgj5mjApMMEMGCCsGAQUFBwEBBDcw\nNTAzBggrBgEFBQcwAYYnaHR0cDovL25leHVzLWJvZS5ieXRlZGFuY2UubmV0L3Bj\nYS9vY3NwMAoGCCqGSM49BAMCA0cAMEQCICi0qfYIv1adG67GjMiDerkvATx+NAJc\nXuWHBw19rAbZAiB4t5TIdN4Blgoi4Z7TSC4ujKiZamCsQAWd/Qm6CjmSKA==\n-----END CERTIFICATE-----";
    private static final String ATTEST_ROOT_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICajCCAhCgAwIBAgIUGJmZqXIH8jlgen5vodpKCnEWqqgwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwOTI0NDFaFw00NTEyMzExNjAwMDBaMGAxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEpMCcGA1UEAxMgQnl0ZURh\nbmNlIE9QQ0MgRXZpZGVuY2UgVG9rZW4gQ0EwWTATBgcqhkjOPQIBBggqhkjOPQMB\nBwNCAARfeJVRuQB8Aj+/XmhaQ4rA8UsmnJr/gxZ9ect9Gbl5DN2hhQ9G8ALPFo0J\nkdWuN+8TTdZ15+zG9p2x1APerD3co4GwMIGtMA4GA1UdDwEB/wQEAwIBhjAPBgNV\nHRMBAf8EBTADAQH/MB0GA1UdDgQWBBTFGPH3KgQVKmcpIHp06m71wC/N2zAfBgNV\nHSMEGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYI\nKwYBBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQv\ncGNhL29jc3AwCgYIKoZIzj0EAwIDSAAwRQIgGrGTErx0YxbhgHBiG/l4zRpllRwk\n5028gMa/djZbR5sCIQDcvK83IKqkzQfvjocLzlRQtuC5Bue2rBR0NAOgs+y2QA==\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICNTCCAdqgAwIBAgIUGJmWDf76XK7QEDg7ePQ6Zp5a/QAwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODE4MzVaFw00MTAyMjgwODI4MzRaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBTbWFydCBTaWduIE9QQ0MgR2F0ZXdheTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABM25nWwFbu/tBeKoSdmqIEFzkGsiNlVBzp++3/y3PSAl3X5JQ98U\nkN8af1gEabmQWsnQ6rfAu+/3N1eLdaeyAH+jdjB0MAwGA1UdEwEB/wQCMAAwHwYD\nVR0jBBgwFoAUI3ocFBGPZx1O0yRJxLCCPmaMCkwwQwYIKwYBBQUHAQEENzA1MDMG\nCCsGAQUFBzABhidodHRwOi8vbmV4dXMtYm9lLmJ5dGVkYW5jZS5uZXQvcGNhL29j\nc3AwCgYIKoZIzj0EAwIDSQAwRgIhANzuvWkxo2IGpnbJNEWvZRuyp/brvmy9u76P\nRj9AkGSzAiEAuxwuHmrS6OmMWFi5ha9DpqLJijiXzNEKcdVYsJuAFTY=\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICODCCAd2gAwIBAgIUGJmcpAzL0+i5GIb6FxhoxPQSMtswCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQxMDE5MTZaFw00MTAyMjgxMDI5MTZaMGExEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEqMCgGA1UEAxMhQnl0ZURh\nbmNlIFNtYXJ0IFNpZ24gT1BDQyBHYXRld2F5MFkwEwYHKoZIzj0CAQYIKoZIzj0D\nAQcDQgAE1eO/rIuiv0g/zgUMel9/Jyv3msFzoimqEuwjFIRJGKKe51ONP9jMv7zP\ng/IuRK5HFR3IMZYjz507Az0wuT8jIKN9MHswDAYDVR0TAQH/BAIwADAfBgNVHSME\nGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYIKwYB\nBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQvcGNh\nL29jc3AwCgYIKoZIzj0EAwIDSQAwRgIhAM5X3JaXiaAD1sFDDFpRB5rNQS3G7mSc\nGDbtKnvJ3SQ4AiEAwH5JexV4T1BLcNoZctl6iOo5JeUbEwZ11lVi0fzXPI0=\n-----END CERTIFICATE-----";
    private static final int MAX_STRING_LENGTH = 512;
    private static final String PCC_CLIENT_VERSION = "1.0.0";
    private static final String PCC_SIGN_KEY_ALIAS = "pcc_sign_key";
    private static final String TAG = "PccManager";
    private static volatile PccManager pccManager;
    private Context appContext;
    private PccChannelDb channelDb;
    private volatile boolean pccInitialized;
    private final Map<String, SessionContext> sessionContextCache;

    private static class SessionContext {
        final String accessToken;
        final AppInfo appInfo;
        final int bizType;
        final KeyPair ephemeralKeyPair;
        final List<CreateChannelResponse.SvcPod> podList;
        final byte[] sessionKey;

        SessionContext(AppInfo r3, int r4, String r5, KeyPair r6, List<CreateChannelResponse.SvcPod> r7, byte[] r8) {
            List<CreateChannelResponse.SvcPod> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.appInfo = r3;
            this.bizType = r4;
            this.accessToken = r5;
            this.ephemeralKeyPair = r6;
            this.podList = r9;
            this.sessionKey = r8;
        }
    }

    static {
    }

    private PccManager() {
        this.pccInitialized = false;
        this.sessionContextCache = new ConcurrentHashMap();
    }

    public static PccManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (pccManager != null) goto L15;
        monitor-enter(PccManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pccManager != null) goto L9;
        pccManager = new PccManager();     // Catch: Throwable -> L11
        pccManager.attachContext(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PccManager.class);     // Catch: Throwable -> L11
    L15:
        return pccManager;
    }

    private void attachContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.channelDb = new PccChannelDb(this.appContext);
        return;
    }

    private static boolean isValidString(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.length() <= 0) goto L8;
        if (r1.length() >= 512) goto L8;
        return true;
    }

    private static boolean isValidBytes(byte[] r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length <= 0) goto L6;
        return true;
    }

    private static boolean isValidAppInfo(AppInfo r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (isValidString(r1.rpdid) == false) goto L12;
        if (isValidString(r1.rpuid) == false) goto L12;
        if (isValidString(r1.appId) == false) goto L12;
        if (isValidString(r1.appSvcId) == false) goto L12;
        return true;
    }

    public int init(AppInfo r23) {
        if (this.appContext != null) goto L7;
        LogUtils.e(TAG, "init failed: context not attached");
        return -31;
    L7:
        if (isValidAppInfo(r23) == true) goto L10;
        LogUtils.e(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return -2;
    L10:
        String r3 = TAG;
        LogUtils.i(r3, "init called: appId=" + r23.appId + ", appSvcId=" + r23.appSvcId);
        CreateChannelResponse r5 = queryChannelFromDb(r23);
        if (r5 != null) goto L13;
    L16:
        LogUtils.i(r3, "init: no valid cached channel, proceeding with network flow");
        String r6 = UUID.randomUUID().toString();
        String r8 = PccNetworkManager.getInstance().requestChallenge(r6);
        if (TextUtils.isEmpty(r8) == false) goto L20;
        LogUtils.e(r3, "init failed: get PCC challenge failed");
        return -31;
    L20:
        LogUtils.i(r3, "PCC challenge obtained");
        String r9 = KeyAttestationHelper.generateAndAttestSignKey(this.appContext, PCC_SIGN_KEY_ALIAS, r8, r23.rpdid, r23.rpuid);     // Catch: Exception -> L49
        String r10 = String.valueOf(System.currentTimeMillis());
        byte[] r11 = new byte[8];
        new SecureRandom().nextBytes(r11);
        String r12 = CryptoUtils.toHex(r11);
        String r13 = Base64.encodeToString(new CreateChannelRequest.Payload("1.0.0", r12, r23).toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        CreateChannelResponse r4 = PccNetworkManager.getInstance().createChannel(r6, r10, new CreateChannelRequest(r9, r13, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r6 + "|" + r10 + "|" + r13).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString());
        if (r4 != null) goto L29;
        LogUtils.e(r3, "init failed: createChannel returned null");
        return -31;
    L29:
        if (verifyCloudSignature(r4) == true) goto L33;
        LogUtils.e(r3, "init failed: cloud response signature verification failed");
        return -31;
    L33:
        if (verifyEvidenceToken(r4, r8, r12, r23) == true) goto L36;
        LogUtils.e(r3, "init warning: evidence token verification failed (non-fatal)");
    L36:
        if (this.channelDb.save(r23.rpdid, r23.rpuid, r23.appId, r23.appSvcId, r4) == true) goto L38;
        LogUtils.e(r3, "init warning: failed to persist channel data to DB");
    L38:
        this.pccInitialized = true;
        LogUtils.i(r3, "init success, channelId=" + r4.getChannelId());
        String r1 = Base64.encodeToString(new UploadChannelRetRequest.Payload("1.0.0", r23, r4.getChannelId(), "0").toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        String r7 = String.valueOf(System.currentTimeMillis());
        LogUtils.i(r3, "init: uploadChannelRet logId=" + PccNetworkManager.getInstance().uploadChannelRet(r6, r7, new UploadChannelRetRequest(r1, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r6 + "|" + r7 + "|" + r1).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString()));     // Catch: Exception -> L41
        return 0;
    L41:
        e = move-exception;
        LogUtils.e(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
        return 0;
    L45:
        e = move-exception;
        LogUtils.e(TAG, "init failed: sign request: " + e.getMessage());
        return -31;
    L49:
        e = move-exception;
        LogUtils.e(TAG, "init failed: attestation: " + e.getMessage());
        return -31;
    L13:
        if (isChannelExpired(r5) == true) goto L16;
        this.pccInitialized = true;
        return 0;
    }

    public int openSecuritySession(String r13, AppInfo r14) {
        String r0 = TAG;
        LogUtils.d(r0, "openSecuritySession called: sessionId=" + r13);
        if (isValidString(r13) == true) goto L7;
        LogUtils.e(r0, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (isValidAppInfo(r14) == true) goto L10;
        LogUtils.e(r0, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return -2;
    L10:
        CreateChannelResponse r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L13;
    L14:
        LogUtils.d(r0, "openSecuritySession: channel missing or expired, re-initialising");
        int r2 = init(r14);
        if (r2 == 0) goto L18;
        LogUtils.e(r0, "openSecuritySession failed: re-init returned " + r2);
        return r2;
    L18:
        r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L22;
        LogUtils.e(r0, "openSecuritySession failed: channel still null after re-init");
        return -31;
    L22:
        CreateChannelResponse.ServiceInfo r3 = r1.getServiceInfo();
        if (r3 != null) goto L25;
    L35:
        LogUtils.e(r0, "openSecuritySession failed: service pod list is empty");
        return -31;
    L25:
        if (r3.getAppSvcPodList() == null) goto L35;
        if (r3.getAppSvcPodList().isEmpty() == true) goto L35;
        KeyPair r9 = CryptoUtils.generateEphemeralEcKeyPair();     // Catch: Exception -> L32
        byte[] r11 = new byte[32];
        new SecureRandom().nextBytes(r11);
        List<CreateChannelResponse.SvcPod> r4 = r3.getAppSvcPodList();
        this.sessionContextCache.put(r13, new SessionContext(r14, 1, r1.getAccessToken(), r9, r4, r11));
        LogUtils.d(r0, "openSecuritySession success: sessionId=" + r13 + ", podCount=" + r4.size());
        return 0;
    L32:
        e = move-exception;
        LogUtils.e(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return -31;
    L13:
        if (isChannelExpired(r1) == false) goto L22;
        goto L14
    }

    public String dataEncrypt(String r17, byte[] r18) {
        String r4 = TAG;
        LogUtils.d(r4, "dataEncrypt called: sessionId=" + r17);
        if (isValidString(r17) == true) goto L7;
        LogUtils.e(r4, "dataEncrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L7:
        if (isValidBytes(r18) == true) goto L10;
        LogUtils.e(r4, "dataEncrypt failed: invalid data (null or empty)");
        return null;
    L10:
        SessionContext r5 = (SessionContext) ZeusTransformUtils.preCheckCast(this.sessionContextCache.get(r17), SessionContext.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L35;
        LogUtils.e(r4, "dataEncrypt failed: session not found");
        return null;
    L35:
        LogUtils.d(r4, "dataEncrypt sessionKey=" + CryptoUtils.toHex(r5.sessionKey));     // Catch: Exception -> L30
        byte[] r7 = new byte[12];     // Catch: Exception -> L30
        new SecureRandom().nextBytes(r7);     // Catch: Exception -> L30
        LogUtils.d(r4, "dataEncrypt nonce=" + CryptoUtils.toHex(r7) + " plainLen=" + r18.length);     // Catch: Exception -> L30
        byte[] r2 = CryptoUtils.aesGcmEncrypt(r5.sessionKey, r7, r18);     // Catch: Exception -> L30
        LogUtils.d(r4, "dataEncrypt ciphertextLen=" + r2.length);     // Catch: Exception -> L30
        EncryptedPayloadTlv r9 = new EncryptedPayloadTlv();     // Catch: Exception -> L30
        r9.metaInfo = new EncryptedPayloadTlv.MetaInfo();     // Catch: Exception -> L30
        r9.metaInfo.version = 1;     // Catch: Exception -> L30
        r9.metaInfo.contentType = 1;     // Catch: Exception -> L30
        EncryptedPayloadTlv.BizAttribute r10 = new EncryptedPayloadTlv.BizAttribute();     // Catch: Exception -> L30
        r10.appId = r5.appInfo.appId;     // Catch: Exception -> L30
        r10.serviceId = r5.appInfo.appSvcId;     // Catch: Exception -> L30
        r10.bizType = r5.bizType;     // Catch: Exception -> L30
        r10.sessionKeyId = r17.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L30
        int r12 = 0;
        if (r5.accessToken == null) goto L17;
        byte[] r1 = r5.accessToken.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L30
    L18:
        r10.accessToken = r1;     // Catch: Exception -> L30
        r9.metaInfo.bizAttribute = r10;     // Catch: Exception -> L30
        byte[] r3 = CryptoUtils.ecPubKeyToUncompressed(r5.ephemeralKeyPair.getPublic());     // Catch: Exception -> L30
        LogUtils.d(r4, "dataEncrypt ephemeralDhPK=" + CryptoUtils.toHex(r3));     // Catch: Exception -> L30
        r9.keyEnvelopePayload = new EncryptedPayloadTlv.KeyEnvelopePayload();     // Catch: Exception -> L30
        r9.keyEnvelopePayload.version = 1;     // Catch: Exception -> L30
        r9.keyEnvelopePayload.envelopeType = 1;     // Catch: Exception -> L30
        r9.keyEnvelopePayload.keyEnvelopeList = new ArrayList();     // Catch: Exception -> L30
    L20:
        if (r12 >= r5.podList.size()) goto L22;
        CreateChannelResponse.SvcPod r6 = (CreateChannelResponse.SvcPod) ZeusTransformUtils.preCheckCast(r5.podList.get(r12), CreateChannelResponse.SvcPod.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30
        byte[] r11 = new byte[16];     // Catch: Exception -> L30
        new SecureRandom().nextBytes(r11);     // Catch: Exception -> L30
        String r13 = TAG;     // Catch: Exception -> L30
        LogUtils.d(r13, "dataEncrypt pod[" + r12 + "] id=" + r6.getSvcPodId() + " keyType=" + r6.getSvcPodKeyType() + " keyVer=" + r6.getSvcPodKeyVersion() + " salt=" + CryptoUtils.toHex(r11));     // Catch: Exception -> L30
        byte[] r8 = CryptoUtils.eciesWrapKey(r5.ephemeralKeyPair.getPrivate(), r3, r6.getSvcPodPubKey(), r11, r5.sessionKey);     // Catch: Exception -> L30
        LogUtils.d(r13, "dataEncrypt pod[" + r12 + "] encryptedSessionKey=" + CryptoUtils.toHex(r8));     // Catch: Exception -> L30
        EncryptedPayloadTlv.KeyEnvelope r14 = new EncryptedPayloadTlv.KeyEnvelope();     // Catch: Exception -> L30
        r12 = r12 + 1;     // Catch: Exception -> L30
        r14.index = r12;     // Catch: Exception -> L30
        r14.keyIdentify = r6.getSvcPodId().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L30
        r14.keyVersion = parseKeyVersion(r6.getSvcPodKeyVersion());     // Catch: Exception -> L30
        r14.keyEncryptionAlgorithm = 1;     // Catch: Exception -> L30
        r14.dhPK = r3;     // Catch: Exception -> L30
        r14.salt = r11;     // Catch: Exception -> L30
        r14.encryptedSessionKey = r8;     // Catch: Exception -> L30
        r9.keyEnvelopePayload.keyEnvelopeList.add(r14);     // Catch: Exception -> L30
        goto L20
    L22:
        r9.keyEnvelopePayload.keyEnvelopeListSize = r9.keyEnvelopePayload.keyEnvelopeList.size();     // Catch: Exception -> L30
        r9.contentInfoMeta = new EncryptedPayloadTlv.ContentInfoMeta();     // Catch: Exception -> L30
        r9.contentInfoMeta.contentType = 1;     // Catch: Exception -> L30
        r9.contentInfoMeta.contentEncryptionAlgorithm = 1;     // Catch: Exception -> L30
        EncryptedPayloadTlv.OtherKeyAttribute r15 = new EncryptedPayloadTlv.OtherKeyAttribute();     // Catch: Exception -> L30
        r15.nonce = r7;     // Catch: Exception -> L30
        r9.contentInfoMeta.otherKeyAttribute = r15;     // Catch: Exception -> L30
        byte[] r0 = KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, r9.encodeSignedPortion());     // Catch: Exception -> L26
        EncryptedPayloadTlv.SignContentInfo r16 = new EncryptedPayloadTlv.SignContentInfo();     // Catch: Exception -> L26
        r16.signatureAlgorithm = 1;     // Catch: Exception -> L26
        r16.contentSignature = r0;     // Catch: Exception -> L26
        r9.signContentInfo = r16;     // Catch: Exception -> L26
        String r19 = TAG;     // Catch: Exception -> L30
        LogUtils.d(r19, "dataEncrypt TLV JSON:\n" + r9.toJsonString());     // Catch: Exception -> L30
        byte[] r20 = new EncryptedProtocol(r9, r2).encode();     // Catch: Exception -> L30
        LogUtils.d(r19, "dataEncrypt success: encodedLen=" + r20.length);     // Catch: Exception -> L30
        return Base64.encodeToString(r20, 11);
    L26:
        e = move-exception;
        LogUtils.e(TAG, "dataEncrypt failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L30
        return null;
    L17:
        r1 = new byte[0];     // Catch: Exception -> L30
    L30:
        e = move-exception;
        LogUtils.e(TAG, "dataEncrypt exception: " + Log.getStackTraceString(e));
        return null;
    }

    public byte[] dataDecrypt(String r5, String r6) {
        String r0 = TAG;
        LogUtils.d(r0, "dataDecrypt called: sessionId=" + r5);
        if (isValidString(r5) == true) goto L6;
        LogUtils.e(r0, "dataDecrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r6 != null) goto L8;
    L35:
        LogUtils.e(r0, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L8:
        if (r6.length() <= 0) goto L35;
        SessionContext r4 = (SessionContext) ZeusTransformUtils.preCheckCast(this.sessionContextCache.get(r5), SessionContext.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L37;
        LogUtils.e(r0, "dataDecrypt failed: session not found");
        return null;
    L37:
        byte[] r7 = Base64.decode(r6, 8);     // Catch: Exception -> L32
        LogUtils.d(r0, "dataDecrypt encodedLen=" + r7.length);     // Catch: Exception -> L32
        EncryptedProtocol r8 = EncryptedProtocol.decode(r7);     // Catch: Exception -> L32
        EncryptedPayloadTlv r9 = r8.tlvData;     // Catch: Exception -> L32
        byte[] r10 = r8.body;     // Catch: Exception -> L32
        LogUtils.d(r0, "dataDecrypt TLV JSON:\n" + r9.toJsonString());     // Catch: Exception -> L32
        if (r9.contentInfoMeta != null) goto L18;
    L30:
        LogUtils.e(r0, "dataDecrypt failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L32
        return null;
    L18:
        if (r9.contentInfoMeta.otherKeyAttribute == null) goto L30;
        if (r9.contentInfoMeta.otherKeyAttribute.nonce == null) goto L30;
        if (r10 != null) goto L24;
    L28:
        LogUtils.e(r0, "dataDecrypt failed: no ciphertext in Body");     // Catch: Exception -> L32
        return null;
    L24:
        if (r10.length == 0) goto L28;
        byte[] r11 = r9.contentInfoMeta.otherKeyAttribute.nonce;     // Catch: Exception -> L32
        LogUtils.d(r0, "dataDecrypt sessionKey=" + CryptoUtils.toHex(r4.sessionKey) + " nonce=" + CryptoUtils.toHex(r11) + " ciphertextLen=" + r10.length);     // Catch: Exception -> L32
        byte[] r12 = CryptoUtils.aesGcmDecrypt(r4.sessionKey, r11, r10);     // Catch: Exception -> L32
        LogUtils.d(r0, "dataDecrypt success: plaintextLen=" + r12.length);     // Catch: Exception -> L32
        return r12;
    L32:
        e = move-exception;
        LogUtils.e(TAG, "dataDecrypt exception: " + e.getMessage());
        return null;
    }

    public int closeSecuritySession(String r4) {
        String r0 = TAG;
        LogUtils.d(r0, "closeSecuritySession called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L6;
        LogUtils.e(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L6:
        this.sessionContextCache.remove(r4);
        LogUtils.d(r0, "closeSecuritySession success: sessionId=" + r4);
        return 0;
    }

    private CreateChannelResponse queryChannelFromDb(AppInfo r4) {
        PccChannelDb r3 = this.channelDb;
        if (r3 != null) goto L7;
        LogUtils.e(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L7:
        return r3.query(r4.rpdid, r4.rpuid, r4.appId, r4.appSvcId);
    }

    private boolean verifyCloudSignature(CreateChannelResponse r6) {
        boolean r5 = NetworkConfig.getInstance().isBoeEnv();
        if (r5 == false) goto L5;
        String r0 = CLOUD_CERT_BOE;
    L6:
        String r1 = TAG;
        StringBuilder r2 = new StringBuilder().append("verifyCloudSignature: env=");
        if (r5 == false) goto L9;
        String r7 = "BOE";
    L10:
        LogUtils.d(r1, r2.append(r7).toString());
        if (TextUtils.isEmpty(r6.getSignature()) == false) goto L22;
        LogUtils.e(r1, "verifyCloudSignature: server signature is empty");
        return false;
    L22:
        boolean r8 = CryptoUtils.verifyEcdsaSignature(r0, (r6.getResponseId() + "|" + r6.getPayloadJson()).getBytes(StandardCharsets.UTF_8), Base64.decode(r6.getSignature(), 8));     // Catch: Exception -> L19
        if (r8 == true) goto L17;
        LogUtils.e(r1, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L19
    L18:
        return r8;
    L17:
        LogUtils.i(r1, "verifyCloudSignature: signature valid");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        LogUtils.e(TAG, "verifyCloudSignature exception: " + e.getMessage());
        return false;
    L9:
        r7 = "Online";
        goto L10
    L5:
        r0 = CLOUD_CERT_ONLINE;
        goto L6
    }

    private boolean isChannelExpired(CreateChannelResponse r8) {
        String r7 = r8.getChannelExpiryTime();
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return true;
    L13:
        if ((System.currentTimeMillis() / 1000) >= Long.parseLong(r7)) goto L15;
        return false;
    L15:
        return true;
    L11:
        LogUtils.e(TAG, "isChannelExpired: invalid expiry format: " + r7);
        return true;
    }

    private boolean verifyEvidenceToken(CreateChannelResponse r9, String r10, String r11, AppInfo r12) {
        CreateChannelResponse.EvidenceInfo r8 = r9.getEvidenceInfo();
        if (r8 != null) goto L6;
        LogUtils.d(TAG, "verifyEvidenceToken: no evidence_info in response, skip");
        return true;
    L6:
        String r1 = r8.getEvidenceToken();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        LogUtils.d(TAG, "verifyEvidenceToken: evidence_token is empty, skip");
        return true;
    L10:
        boolean r13 = NetworkConfig.getInstance().isBoeEnv();
        if (r13 == false) goto L13;
        String r0 = ATTEST_ROOT_CERT_BOE;
    L14:
        String r7 = r0;
        String r2 = TAG;
        StringBuilder r3 = new StringBuilder().append("verifyEvidenceToken: env=");
        if (r13 == false) goto L17;
        String r14 = "BOE";
    L18:
        LogUtils.d(r2, r3.append(r14).toString());
        List<CreateChannelResponse.SvcPod> r15 = null;
        CreateChannelResponse.ServiceInfo r16 = r9.getServiceInfo();
        if (r16 == null) goto L27;
        r15 = r16.getAppSvcPodList();
    L27:
        boolean r17 = EvidenceTokenVerifier.verify(r1, r12.appId, r12.appSvcId, r10, r11, r15, r7);     // Catch: Exception -> L24
        LogUtils.d(r2, "verifyEvidenceToken: result=" + r17);     // Catch: Exception -> L24
        return r17;
    L24:
        e = move-exception;
        LogUtils.e(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L17:
        r14 = "Online";
        goto L18
    L13:
        r0 = ATTEST_ROOT_CERT_ONLINE;
        goto L14
    }

    private static int parseKeyVersion(String r4) {
        if (r4 != null) goto L5;
    L10:
        return 0;
    L5:
        if (r4.isEmpty() == true) goto L10;
        return Integer.parseInt(r4);
    L9:
        LogUtils.e(TAG, "parseKeyVersion: non-integer '" + r4 + "', defaulting to 0");
        goto L10
    }
}
