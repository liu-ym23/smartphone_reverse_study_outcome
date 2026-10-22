package com.bytedance.crypto.e2eetrans;

import android.os.SystemClock;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class CryptoSessionImpl implements CryptoSession {
    private static final int CIPHER_MAGIC = -487660818;
    private static final int CIPHER_VERSION = 2;
    private static final int DK_LEN = 32;
    private static final int MAX_ACCOUNT_ID_LEN = 128;
    private static final int MAX_APP_ID_LEN = 64;
    private static final int MAX_DATA_ID_LEN = 256;
    private static final long MAX_TIMEOUT_MILLIS = 86400000;
    private static final int NONCE_LEN = 12;
    private static final String TAG = "CryptoSessionImpl";
    private static final int TAG_LEN = 16;
    private static final int WRAPPED_DK_FIELD_LEN = 4;
    private final String accountId;
    private final String appId;
    private final IAttestationService attestationService;
    private byte[] cachedAuthMessage;
    private final long createElapsedRealtime;
    private byte[] finishMessage;
    private PublicKey localAkPub;
    private byte[] randomNonce;
    private final Role role;
    private final SecureRandom secureRandom;
    private String sessionId;
    private State state;
    private final long timeoutMillis;
    private byte[] tmk;
    private byte[] transcriptHash;

    public static final enum Role extends Enum<Role> {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final Role INITIATOR = null;
        public static final Role RESPONDER = null;

        static {
            Role r0 = new Role("INITIATOR", 0);
            INITIATOR = r0;
            Role r1 = new Role("RESPONDER", 1);
            RESPONDER = r1;
            $VALUES = new Role[]{r0, r1};
        }

        private Role(String r1, int r2) {
            super(r1, r2);
        }

        public static Role valueOf(String r2) {
            return (Role) ZeusTransformUtils.preCheckCast(Enum.valueOf(Role.class, r2), Role.class, "com.obric.aiagent.plugin");
        }

        public static Role[] values() {
            return (Role[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Role[].class, "com.obric.aiagent.plugin");
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State CREATED = null;
        public static final State EXCHANGED = null;
        public static final State READY = null;

        static {
            State r0 = new State("CREATED", 0);
            CREATED = r0;
            State r1 = new State("EXCHANGED", 1);
            EXCHANGED = r1;
            State r3 = new State("READY", 2);
            READY = r3;
            State r5 = new State("CLOSED", 3);
            CLOSED = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.aiagent.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.aiagent.plugin");
        }
    }

    private CryptoSessionImpl(Role r3, String r4, String r5, IAttestationService r6, long r7) {
        IAttestationService r8 = (IAttestationService) ZeusTransformUtils.wrapperContextForParams(r6, IAttestationService.class, "com.obric.aiagent.plugin");
        this.secureRandom = new SecureRandom();
        this.role = r3;
        this.accountId = r4;
        this.appId = r5;
        this.attestationService = r8;
        this.timeoutMillis = r7;
        this.createElapsedRealtime = SystemClock.elapsedRealtime();
        this.sessionId = UUID.randomUUID().toString();
        this.state = State.CREATED;
    }

    private String buildChallenge(byte[] r2, String r3, String r4, String r5) {
        return CryptoUtils.byteArrayToHexString(sha256(concat(r2, concat(r3.getBytes(StandardCharsets.UTF_8), concat(r4.getBytes(StandardCharsets.UTF_8), r5.getBytes(StandardCharsets.UTF_8))))));
    }

    private void checkNotClosed() {
        if (this.state == State.CLOSED) goto L6;
        return;
    L6:
        throw new CryptoException(CryptoException.Code.SESSION_EXPIRED, "Session is closed");
    }

    private void checkNotExpired() {
        if ((SystemClock.elapsedRealtime() - this.createElapsedRealtime) > this.timeoutMillis) goto L5;
        return;
    L5:
        close();
        throw new CryptoException(CryptoException.Code.SESSION_EXPIRED, "Session expired");
    }

    private void checkReady() {
        checkNotClosed();
        checkNotExpired();
        if (this.state != State.READY) goto L6;
        return;
    L6:
        throw new CryptoException(CryptoException.Code.SESSION_NOT_READY, "Session is not ready, complete handshake first");
    }

    private byte[] concat(byte[] r3, byte[] r4) {
        byte[] r2 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r2, 0, r3.length);
        System.arraycopy(r4, 0, r2, r3.length, r4.length);
        return r2;
    }

    private boolean constantTimeEquals(String r2, String r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return false;
    L6:
        return constantTimeEquals(r2.getBytes(StandardCharsets.UTF_8), r3.getBytes(StandardCharsets.UTF_8));
    L7:
        return false;
    }

    private boolean constantTimeEquals(byte[] r5, byte[] r6) {
        if (r5.length == r6.length) goto L5;
        return false;
    L5:
        int r4 = 0;
        int r0 = 0;
    L7:
        if (r4 >= r5.length) goto L9;
        r0 = r0 | (r5[r4] ^ r6[r4]);
        r4 = r4 + 1;
        goto L7
    L9:
        if (r0 != 0) goto L13;
        return true;
    L13:
        return false;
    }

    public static CryptoSessionImpl createInitiator(String r7, String r8, IAttestationService r9, long r10) {
        IAttestationService r4 = (IAttestationService) ZeusTransformUtils.wrapperContextForParams(r9, IAttestationService.class, "com.obric.aiagent.plugin");
        validateAccountId(r7);
        validateAppId(r8);
        if (r4 == null) goto L7;
        validateTimeoutMillis(r10);
        CryptoSessionImpl r11 = new CryptoSessionImpl(Role.INITIATOR, r7, r8, r4, r10);
        r11.generateInitiatorAuthMaterials();
        return r11;
    L7:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "attestationService is null");
    }

    public static CryptoSessionImpl createResponder(String r7, String r8, IAttestationService r9, long r10, byte[] r12) {
        IAttestationService r4 = (IAttestationService) ZeusTransformUtils.wrapperContextForParams(r9, IAttestationService.class, "com.obric.aiagent.plugin");
        validateAccountId(r7);
        validateAppId(r8);
        if (r4 == null) goto L17;
        validateTimeoutMillis(r10);
        if (r12 == null) goto L15;
        if (r12.length == 0) goto L15;
        if (r12.length > 8385) goto L13;
        CryptoSessionImpl r11 = new CryptoSessionImpl(Role.RESPONDER, r7, r8, r4, r10);
        r11.processInitiatorAuthAndGenerateReply(r12);
        return r11;
    L13:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "initiatorAuthMessage is too long");
    L15:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "initiatorAuthMessage is empty");
    L17:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "attestationService is null");
    }

    private void generateInitiatorAuthMaterials() {
        byte[] r0 = new byte[32];
        this.randomNonce = r0;
        this.secureRandom.nextBytes(r0);
        String r1 = buildChallenge(this.randomNonce, this.accountId, this.appId, this.sessionId);
        AuthMessage r2 = new AuthMessage();
        r2.sessionId = this.sessionId;
        r2.randomNonce = this.randomNonce;
        List<X509Certificate> r3 = this.attestationService.getCertificateChain(r1);
        r2.certChain = r3;
        this.localAkPub = getLeafPublicKey(r3);
        byte[] r4 = r2.serialize();
        this.cachedAuthMessage = r4;
        this.transcriptHash = sha256(r4);
    }

    private PublicKey getLeafPublicKey(List<X509Certificate> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        if (r2.get(0) == null) goto L14;
        PublicKey r4 = ((X509Certificate) ZeusTransformUtils.preCheckCast(r2.get(0), X509Certificate.class, "com.obric.aiagent.plugin")).getPublicKey();
        if (r4 == null) goto L12;
        return r4;
    L12:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "Leaf certificate public key is null");
    L14:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "Certificate chain is empty");
    }

    private byte[] hmacSha256(byte[] r3, byte[] r4) {
        Mac r0 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L5
        r0.init(new SecretKeySpec(r3, "HmacSHA256"));     // Catch: Exception -> L5
        return r0.doFinal(r4);
    L5:
        e = move-exception;
        throw new RuntimeException("HmacSHA256 not available", e);
    }

    private void processInitiatorAuthAndGenerateReply(byte[] r10) {
        AuthMessage r0 = AuthMessage.deserialize(r10);
        String r1 = r0.sessionId;
        if (r1 == null) goto L26;
        if (r1.isEmpty() == true) goto L26;
        String r2 = r0.sessionId;
        byte[] r3 = r0.randomNonce;
        if (this.attestationService.validateCertificateChain(r0.certChain) == false) goto L24;
        PublicKey r4 = getLeafPublicKey(r0.certChain);
        if (constantTimeEquals(this.attestationService.extractChallenge((X509Certificate) ZeusTransformUtils.preCheckCast(r0.certChain.get(0), X509Certificate.class, "com.obric.aiagent.plugin")), buildChallenge(r3, this.accountId, this.appId, r2)) == false) goto L22;
        byte[] r5 = new byte[32];
        this.randomNonce = r5;
        this.secureRandom.nextBytes(r5);
        String r6 = buildChallenge(this.randomNonce, this.accountId, this.appId, r2);
        AuthMessage r7 = new AuthMessage();
        r7.sessionId = r2;
        r7.randomNonce = this.randomNonce;
        List<X509Certificate> r8 = this.attestationService.getCertificateChain(r6);
        r7.certChain = r8;
        this.localAkPub = getLeafPublicKey(r8);
        this.cachedAuthMessage = r7.serialize();
        byte[] r9 = this.attestationService.generateSharedSecret(r4);
        byte[] r11 = concat(r4.getEncoded(), this.localAkPub.getEncoded());
        this.tmk = HKDFHelper.deriveKey(r9, r3, (this.accountId + "|" + r2 + "|" + this.appId + "|" + CryptoUtils.byteArrayToHexString(sha256(r11)).substring(0, 32)).getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L14 Exception -> L16
        Arrays.fill(r9, (byte) 0);
        Arrays.fill(r11, (byte) 0);
        byte[] r12 = sha256(concat(r10, this.cachedAuthMessage));
        this.transcriptHash = r12;
        this.finishMessage = hmacSha256(this.tmk, r12);
        this.sessionId = r2;
        this.state = State.CREATED;
        return;
    L14:
        th = move-exception;
        Arrays.fill(r9, (byte) 0);
        Arrays.fill(r11, (byte) 0);
        throw th;
    L16:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Derive TMK failed", e);     // Catch: Throwable -> L14
    L22:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "Initiator challenge verification failed, accountId or appId mismatch");
    L24:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "Initiator cert chain validation failed");
    L26:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "initiator sessionId is empty");
    }

    private int readInt(byte[] r2, int r3) {
        return ((((r2[r3] & 255) << 24) | ((r2[r3 + 1] & 255) << 16)) | ((r2[r3 + 2] & 255) << 8)) | (r2[r3 + 3] & 255);
    }

    private byte[] sha256(byte[] r2) {
        return MessageDigest.getInstance("SHA-256").digest(r2);
    L4:
        e = move-exception;
        throw new RuntimeException("SHA-256 not available", e);
    }

    private static void validateAccountId(String r2) {
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        if (r2.getBytes(StandardCharsets.UTF_8).length > 128) goto L9;
        return;
    L9:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "accountId is too long");
    L11:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "accountId is empty");
    }

    private static void validateAppId(String r2) {
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        if (r2.getBytes(StandardCharsets.UTF_8).length > 64) goto L9;
        return;
    L9:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "appId is too long");
    L11:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "appId is empty");
    }

    private static void validateDataId(String r2) {
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        if (r2.getBytes(StandardCharsets.UTF_8).length > 256) goto L9;
        return;
    L9:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "dataId is too long");
    L11:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "dataId is empty");
    }

    private static void validateTimeoutMillis(long r2) {
        if (r2 <= 0) goto L8;
        if (r2 > MAX_TIMEOUT_MILLIS) goto L8;
        return;
    L8:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "invalid timeoutMillis");
    }

    private static void validateVersion(int r2) {
        if (r2 <= 0) goto L5;
        return;
    L5:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "version must be positive");
    }

    private void writeInt(ByteArrayOutputStream r1, int r2) {
        r1.write((r2 >> 24) & 255);
        r1.write((r2 >> 16) & 255);
        r1.write((r2 >> 8) & 255);
        r1.write(r2 & 255);
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession, java.lang.AutoCloseable
    public void close() {
        State r0 = this.state;
        State r1 = State.CLOSED;
        if (r0 != r1) goto L5;
        return;
    L5:
        this.state = r1;
        byte[] r2 = this.tmk;
        if (r2 == null) goto L8;
        Arrays.fill(r2, (byte) 0);
        this.tmk = null;
    L8:
        byte[] r3 = this.randomNonce;
        if (r3 == null) goto L11;
        Arrays.fill(r3, (byte) 0);
        this.randomNonce = null;
    L11:
        byte[] r4 = this.finishMessage;
        if (r4 == null) goto L14;
        Arrays.fill(r4, (byte) 0);
        this.finishMessage = null;
    L14:
        byte[] r5 = this.transcriptHash;
        if (r5 == null) goto L17;
        Arrays.fill(r5, (byte) 0);
        this.transcriptHash = null;
    L17:
        byte[] r6 = this.cachedAuthMessage;
        if (r6 == null) goto L20;
        Arrays.fill(r6, (byte) 0);
        this.cachedAuthMessage = null;
    L20:
        this.localAkPub = null;
        IAttestationService r7 = this.attestationService;
        if (r7 == null) goto L23;
        r7.destroy();
    L23:
        LogUtils.i(TAG, "Session closed, key materials wiped");
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public void confirmHandshake(byte[] r4) {
        checkNotClosed();
        checkNotExpired();
        if (r4 == null) goto L27;
        if (r4.length == 0) goto L27;
        Role r0 = this.role;
        if (r0 != Role.INITIATOR) goto L14;
        if (this.state == State.EXCHANGED) goto L14;
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Initiator must call processAuthMessage first");
    L14:
        if (r0 != Role.RESPONDER) goto L21;
        if (this.state == State.CREATED) goto L21;
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Invalid state for confirmHandshake");
    L21:
        if (constantTimeEquals(hmacSha256(this.tmk, this.transcriptHash), r4) == false) goto L25;
        this.state = State.READY;
        LogUtils.i(TAG, "Handshake confirmed, session is READY");
        return;
    L25:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Finish message verification failed");
    L27:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "peerFinishMessage is empty");
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public byte[] decrypt(byte[] r11, String r12, String r13, int r14) {
        checkReady();
        checkNotExpired();
        if (r11 == null) goto L60;
        if (r11.length == 0) goto L60;
        validateVersion(r14);
        validateDataId(r13);
        validateAppId(r12);
        if (this.appId.equals(r12) == false) goto L58;
    L55:
        e = move-exception;
        throw e;
    L52:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.TAMPERED, "Decrypt failed", e);
    L9:
        if (r11.length < 5) goto L51;
        if (readInt(r11, 0) != CIPHER_MAGIC) goto L49;
        int r3 = r11[4] & 255;     // Catch: Exception -> L52 CryptoException -> L55
        if (r3 != 2) goto L47;
        int r2 = readInt(r11, 5);     // Catch: Exception -> L52 CryptoException -> L55
        if (r2 < 60) goto L45;
        int r4 = r2 + 9;     // Catch: Exception -> L52 CryptoException -> L55
        if (r4 > r11.length) goto L45;
        byte[] r5 = Arrays.copyOfRange(r11, 9, r4);     // Catch: Exception -> L52 CryptoException -> L55
        int r6 = r4 + 12;     // Catch: Exception -> L52 CryptoException -> L55
        if (r6 > r11.length) goto L43;
        byte[] r7 = Arrays.copyOfRange(r11, r4, r6);     // Catch: Exception -> L52 CryptoException -> L55
        int r8 = r6 + 16;     // Catch: Exception -> L52 CryptoException -> L55
        if (r8 > r11.length) goto L41;
        byte[] r9 = Arrays.copyOfRange(r11, r6, r8);     // Catch: Exception -> L52 CryptoException -> L55
        if (r8 > r11.length) goto L39;
        byte[] r15 = Arrays.copyOfRange(r11, r8, r11.length);     // Catch: Exception -> L52 CryptoException -> L55
        byte[] r10 = Arrays.copyOfRange(r5, 0, 12);     // Catch: Exception -> L52 CryptoException -> L55
        byte[] r16 = Arrays.copyOfRange(r5, 12, r5.length);     // Catch: Exception -> L52 CryptoException -> L55
        byte[] r17 = AES.gcmXcrypt(2, this.tmk, "dk_wrap_v1".getBytes(StandardCharsets.UTF_8), r10, r16);     // Catch: Exception -> L52 CryptoException -> L55
        if (r17 == null) goto L37;
        if (r17.length != 32) goto L37;
        byte[] r18 = (this.accountId + "|" + r12 + "|" + r13 + "|" + r14).getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L52 CryptoException -> L55
        byte[] r19 = concat(r15, r9);     // Catch: Exception -> L52 CryptoException -> L55
        byte[] r110 = AES.gcmXcrypt(2, r17, r18, r7, r19);     // Catch: Exception -> L52 CryptoException -> L55
        if (r110 == null) goto L35;
        if (r110.length == 0) goto L35;
        Arrays.fill(r17, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r10, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r16, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r7, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r9, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r15, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        Arrays.fill(r19, (byte) 0);     // Catch: Exception -> L52 CryptoException -> L55
        return r110;
    L35:
        throw new CryptoException(CryptoException.Code.TAMPERED, "Decrypt failed, data may be tampered");     // Catch: Exception -> L52 CryptoException -> L55
    L37:
        throw new CryptoException(CryptoException.Code.UNWRAP_FAILED, "Unwrap DK failed");     // Catch: Exception -> L52 CryptoException -> L55
    L39:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Cipher too short");     // Catch: Exception -> L52 CryptoException -> L55
    L41:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Cipher too short for tag");     // Catch: Exception -> L52 CryptoException -> L55
    L43:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Cipher too short for iv");     // Catch: Exception -> L52 CryptoException -> L55
    L45:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid wrappedDK length");     // Catch: Exception -> L52 CryptoException -> L55
    L47:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Unsupported cipher version: " + r3);     // Catch: Exception -> L52 CryptoException -> L55
    L49:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Invalid cipher magic");     // Catch: Exception -> L52 CryptoException -> L55
    L51:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "Cipher too short for magic");     // Catch: Exception -> L52 CryptoException -> L55
    L58:
        throw new CryptoException(CryptoException.Code.APPID_MISMATCH, "appId not match the session appId");
    L60:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "ciphertext is empty");
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public byte[] encrypt(byte[] r11, String r12, String r13, int r14) {
        checkReady();
        checkNotExpired();
        if (r11 == null) goto L33;
        if (r11.length == 0) goto L33;
        validateVersion(r14);
        validateDataId(r13);
        validateAppId(r12);
        if (this.appId.equals(r12) == false) goto L31;
        byte[] r2 = new byte[32];     // Catch: Exception -> L25 CryptoException -> L28
        this.secureRandom.nextBytes(r2);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r4 = new byte[12];     // Catch: Exception -> L25 CryptoException -> L28
        this.secureRandom.nextBytes(r4);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r5 = AES.gcmXcrypt(1, this.tmk, "dk_wrap_v1".getBytes(StandardCharsets.UTF_8), r4, r2);     // Catch: Exception -> L25 CryptoException -> L28
        if (r5.length != 48) goto L24;
        byte[] r6 = concat(r4, r5);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r15 = (this.accountId + "|" + r12 + "|" + r13 + "|" + r14).getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r16 = new byte[12];     // Catch: Exception -> L25 CryptoException -> L28
        this.secureRandom.nextBytes(r16);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r17 = AES.gcmXcrypt(1, r2, r15, r16, r11);     // Catch: Exception -> L25 CryptoException -> L28
        if (r17 == null) goto L22;
        if (r17.length == 0) goto L22;
        if (r17.length < 16) goto L20;
        byte[] r18 = Arrays.copyOfRange(r17, 0, r17.length - 16);     // Catch: Exception -> L25 CryptoException -> L28
        byte[] r19 = Arrays.copyOfRange(r17, r17.length - 16, r17.length);     // Catch: Exception -> L25 CryptoException -> L28
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Exception -> L25 CryptoException -> L28
        writeInt(r3, CIPHER_MAGIC);     // Catch: Exception -> L25 CryptoException -> L28
        r3.write(2);     // Catch: Exception -> L25 CryptoException -> L28
        writeInt(r3, r6.length);     // Catch: Exception -> L25 CryptoException -> L28
        r3.write(r6);     // Catch: Exception -> L25 CryptoException -> L28
        r3.write(r16);     // Catch: Exception -> L25 CryptoException -> L28
        r3.write(r19);     // Catch: Exception -> L25 CryptoException -> L28
        r3.write(r18);     // Catch: Exception -> L25 CryptoException -> L28
        Arrays.fill(r2, (byte) 0);     // Catch: Exception -> L25 CryptoException -> L28
        Arrays.fill(r4, (byte) 0);     // Catch: Exception -> L25 CryptoException -> L28
        Arrays.fill(r5, (byte) 0);     // Catch: Exception -> L25 CryptoException -> L28
        Arrays.fill(r16, (byte) 0);     // Catch: Exception -> L25 CryptoException -> L28
        Arrays.fill(r17, (byte) 0);     // Catch: Exception -> L25 CryptoException -> L28
        return r3.toByteArray();
    L20:
        throw new CryptoException(CryptoException.Code.TAMPERED, "Encrypt output too short");     // Catch: Exception -> L25 CryptoException -> L28
    L22:
        throw new CryptoException(CryptoException.Code.TAMPERED, "Encrypt failed");     // Catch: Exception -> L25 CryptoException -> L28
    L24:
        throw new CryptoException(CryptoException.Code.TAMPERED, "Wrap DK failed");     // Catch: Exception -> L25 CryptoException -> L28
    L28:
        e = move-exception;
        throw e;
    L25:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.TAMPERED, "Encrypt failed", e);
    L31:
        throw new CryptoException(CryptoException.Code.APPID_MISMATCH, "appId not match the session appId");
    L33:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "plaintext is empty");
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public byte[] getAuthMessage() {
        checkNotClosed();
        checkNotExpired();
        byte[] r1 = this.cachedAuthMessage;
        if (r1 == null) goto L7;
        Object r6 = r1.clone();
    L6:
        return (byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.aiagent.plugin");
    L7:
        String r2 = buildChallenge(this.randomNonce, this.accountId, this.appId, this.sessionId);
        AuthMessage r3 = new AuthMessage();
        r3.sessionId = this.sessionId;
        r3.randomNonce = this.randomNonce;
        List<X509Certificate> r4 = this.attestationService.getCertificateChain(r2);
        r3.certChain = r4;
        this.localAkPub = getLeafPublicKey(r4);
        byte[] r5 = r3.serialize();
        this.cachedAuthMessage = r5;
        r6 = r5.clone();
        goto L6
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public byte[] getFinishMessage() {
        checkNotClosed();
        checkNotExpired();
        if (this.role != Role.RESPONDER) goto L11;
        byte[] r2 = this.finishMessage;
        if (r2 == null) goto L9;
        return (byte[]) ZeusTransformUtils.preCheckCast(r2.clone(), byte[].class, "com.obric.aiagent.plugin");
    L9:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Finish message not ready");
    L11:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "getFinishMessage can only be called by responder");
    }

    @Override // com.bytedance.crypto.e2eetrans.CryptoSession
    public byte[] processAuthMessage(byte[] r10) {
        checkNotClosed();
        checkNotExpired();
        if (this.role != Role.INITIATOR) goto L32;
        if (this.state != State.CREATED) goto L30;
        AuthMessage r0 = AuthMessage.deserialize(r10);
        if (this.sessionId.equals(r0.sessionId) == false) goto L28;
        byte[] r1 = this.randomNonce;
        if (this.attestationService.validateCertificateChain(r0.certChain) == false) goto L26;
        PublicKey r2 = getLeafPublicKey(r0.certChain);
        if (constantTimeEquals(this.attestationService.extractChallenge((X509Certificate) ZeusTransformUtils.preCheckCast(r0.certChain.get(0), X509Certificate.class, "com.obric.aiagent.plugin")), buildChallenge(r0.randomNonce, this.accountId, this.appId, this.sessionId)) == false) goto L24;
        byte[] r3 = this.attestationService.generateSharedSecret(r2);
        byte[] r4 = concat(this.localAkPub.getEncoded(), r2.getEncoded());
        this.tmk = HKDFHelper.deriveKey(r3, r1, (this.accountId + "|" + this.sessionId + "|" + this.appId + "|" + CryptoUtils.byteArrayToHexString(sha256(r4)).substring(0, 32)).getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L16 Exception -> L18
        Arrays.fill(r3, (byte) 0);
        Arrays.fill(r4, (byte) 0);
        byte[] r11 = sha256(concat(this.cachedAuthMessage, r10));
        this.transcriptHash = r11;
        byte[] r12 = hmacSha256(this.tmk, r11);
        this.finishMessage = r12;
        this.state = State.EXCHANGED;
        return (byte[]) ZeusTransformUtils.preCheckCast(r12.clone(), byte[].class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        Arrays.fill(r3, (byte) 0);
        Arrays.fill(r4, (byte) 0);
        throw th;
    L18:
        e = move-exception;
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Derive TMK failed", e);     // Catch: Throwable -> L16
    L24:
        throw new CryptoException(CryptoException.Code.CHALLENGE_FAILED, "Responder challenge verification failed, accountId or appId mismatch");
    L26:
        throw new CryptoException(CryptoException.Code.CERT_INVALID, "Responder cert chain validation failed");
    L28:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "SessionId mismatch");
    L30:
        throw new CryptoException(CryptoException.Code.HANDSHAKE_FAILED, "Invalid state for processAuthMessage: " + this.state);
    L32:
        throw new CryptoException(CryptoException.Code.INVALID_PARAMS, "processAuthMessage can only be called by initiator");
    }
}
