package com.android.server.companion.securechannel;

import android.content.Context;
import android.os.Build;
import android.util.Slog;
import com.google.security.cryptauth.lib.securegcm.ukey2.AlertException;
import com.google.security.cryptauth.lib.securegcm.ukey2.BadHandleException;
import com.google.security.cryptauth.lib.securegcm.ukey2.CryptoException;
import com.google.security.cryptauth.lib.securegcm.ukey2.D2DConnectionContextV1;
import com.google.security.cryptauth.lib.securegcm.ukey2.D2DHandshakeContext;
import com.google.security.cryptauth.lib.securegcm.ukey2.HandshakeException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* JADX INFO: loaded from: classes.dex */
public class SecureChannel {
    private static final boolean DEBUG = false;
    private static final int HEADER_LENGTH = 6;
    private static final String TAG = "CDM_SecureChannel";
    private static final int VERSION = 1;
    private String mAlias;
    private final Callback mCallback;
    private byte[] mClientInit;
    private D2DConnectionContextV1 mConnectionContext;
    private final int mFlags;
    private D2DHandshakeContext mHandshakeContext;
    private final Object mHandshakeLock;
    private volatile boolean mInProgress;
    private final InputStream mInput;
    private final OutputStream mOutput;
    private final byte[] mPreSharedKey;
    private boolean mPskVerified;
    private D2DHandshakeContext.Role mRole;
    private volatile boolean mStopped;
    private int mVerificationResult;
    private final AttestationVerifier mVerifier;

    public interface Callback {
        void onError(Throwable r1);

        void onSecureConnection();

        void onSecureMessageReceived(byte[] r1);
    }

    private static final enum MessageType extends Enum<MessageType> {
        private static final /* synthetic */ MessageType[] $VALUES = null;
        public static final MessageType ATTESTATION = null;
        public static final MessageType AVF_RESULT = null;
        public static final MessageType HANDSHAKE_FINISH = null;
        public static final MessageType HANDSHAKE_INIT = null;
        public static final MessageType PRE_SHARED_KEY = null;
        public static final MessageType SECURE_MESSAGE = null;
        public static final MessageType UNKNOWN = null;
        private final short mValue;

        /* JADX INFO: renamed from: -$$Nest$fgetmValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ short m2970$$Nest$fgetmValue(MessageType r0) {
            return r0.mValue;
        }

        /* JADX INFO: renamed from: -$$Nest$smshouldEncrypt, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2971$$Nest$smshouldEncrypt(MessageType r0) {
            return shouldEncrypt(r0);
        }

        private static /* synthetic */ MessageType[] $values() {
            return new MessageType[]{HANDSHAKE_INIT, HANDSHAKE_FINISH, PRE_SHARED_KEY, ATTESTATION, AVF_RESULT, SECURE_MESSAGE, UNKNOWN};
        }

        public static MessageType valueOf(String name) {
            return (MessageType) Enum.valueOf(MessageType.class, name);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }

        static {
            HANDSHAKE_INIT = new MessageType("HANDSHAKE_INIT", 0, 18505);
            HANDSHAKE_FINISH = new MessageType("HANDSHAKE_FINISH", 1, 18502);
            PRE_SHARED_KEY = new MessageType("PRE_SHARED_KEY", 2, 20555);
            ATTESTATION = new MessageType("ATTESTATION", 3, 16724);
            AVF_RESULT = new MessageType("AVF_RESULT", 4, 22098);
            SECURE_MESSAGE = new MessageType("SECURE_MESSAGE", 5, 21325);
            UNKNOWN = new MessageType("UNKNOWN", 6, 0);
            $VALUES = $values();
        }

        private MessageType(String r1, int r2, int value) {
            super(r1, r2);
            this.mValue = (short) value;
        }

        static MessageType from(short value) {
            MessageType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            MessageType messageType = r0[r2];
            if (value == messageType.mValue) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return messageType;
        L9:
            return UNKNOWN;
        }

        private static boolean shouldEncrypt(MessageType type) {
            if (type != HANDSHAKE_INIT) goto L5;
        L7:
            return false;
        L5:
            if (type == HANDSHAKE_FINISH) goto L7;
            return true;
        }
    }

    public static /* synthetic */ void $r8$lambda$iCAm1ptJuD73fs84njR5KGHZPAU(SecureChannel r0) {
        r0.lambda$start$0();
    }

    static {
        DEBUG = Build.IS_DEBUGGABLE;
    }

    public SecureChannel(InputStream in, OutputStream out, Callback callback, byte[] preSharedKey) {
        this(in, out, callback, preSharedKey, null, 0);
    }

    public SecureChannel(InputStream in, OutputStream out, Callback callback, Context context, int flags) {
        this(in, out, callback, null, new AttestationVerifier(context, flags), flags);
    }

    public SecureChannel(InputStream in, OutputStream out, Callback callback, byte[] preSharedKey, AttestationVerifier verifier, int flags) {
        this.mVerificationResult = 1;
        this.mHandshakeLock = new Object();
        this.mInput = in;
        this.mOutput = out;
        this.mCallback = callback;
        this.mPreSharedKey = preSharedKey;
        this.mVerifier = verifier;
        this.mFlags = flags;
    }

    public void start() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Starting secure channel.");
    L5:
        this.mStopped = false;
        new Thread(new SecureChannel$$ExternalSyntheticLambda0(this)).start();
    }

    private /* synthetic */ void lambda$start$0() {
        exchangeHandshake();     // Catch: Exception -> L7
        exchangeAuthentication();     // Catch: Exception -> L7
        this.mInProgress = false;     // Catch: Exception -> L7
        this.mCallback.onSecureConnection();     // Catch: Exception -> L7
    L4:
        if (this.mStopped == true) goto L19;
        receiveSecureMessage();     // Catch: Exception -> L7
        goto L4
    L19:
        return;
    L7:
        e = move-exception;
        if (this.mStopped == false) goto L13;
        return;
    L13:
        Slog.e(TAG, "Secure channel encountered an error.", e);
        close();
        this.mCallback.onError(e);
    }

    public void stop() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Stopping secure channel.");
    L5:
        this.mStopped = true;
        this.mInProgress = false;
    }

    public void close() {
        stop();
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Closing secure channel.");
    L5:
        IoUtils.closeQuietly(this.mInput);
        IoUtils.closeQuietly(this.mOutput);
        KeyStoreUtils.cleanUp(this.mAlias);
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public void establishSecureConnection() throws IOException, SecureChannelException, HandshakeException {
        if (isSecured() == false) goto L7;
        Slog.d(TAG, "Channel is already secure.");
        return;
    L7:
        if (this.mInProgress == false) goto L16;
        Slog.w(TAG, "Channel has already started establishing secure connection.");
        return;
    L16:
        this.mInProgress = true;     // Catch: BadHandleException -> L13
        initiateHandshake();     // Catch: BadHandleException -> L13
        return;
    L13:
        e = move-exception;
        throw new SecureChannelException("Failed to initiate handshake protocol.", e);
    }

    public void sendSecureMessage(byte[] data) throws IOException {
        if (isSecured() == true) goto L11;
        Slog.d(TAG, "Cannot send a message without a secure connection.");
        throw new IllegalStateException("Channel is not secured yet.");
    L11:
        sendMessage(MessageType.SECURE_MESSAGE, data);     // Catch: BadHandleException -> L6
        return;
    L6:
        e = move-exception;
        throw new SecureChannelException("Failed to encrypt data.", e);
    }

    private void receiveSecureMessage() throws IOException, CryptoException {
        if (isSecured() == true) goto L11;
        Slog.d(TAG, "Received a message without a secure connection. Message will be ignored.");
        this.mCallback.onError(new IllegalStateException("Connection is not secure."));
        return;
    L11:
        byte[] receivedMessage = readMessage(MessageType.SECURE_MESSAGE);     // Catch: SecureChannelException -> L8
        this.mCallback.onSecureMessageReceived(receivedMessage);     // Catch: SecureChannelException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Ignoring received message.", e);
    }

    private byte[] readMessage(MessageType expected) throws IOException, SecureChannelException, CryptoException {
        if (DEBUG == true) goto L5;
    L8:
        InputStream r0 = this.mInput;
        monitor-enter(r0);
        byte[] headerBytes = new byte[6];     // Catch: Throwable -> L21
        Streams.readFully(this.mInput, headerBytes);     // Catch: Throwable -> L21
        ByteBuffer header = ByteBuffer.wrap(headerBytes);     // Catch: Throwable -> L21
        int version = header.getInt();     // Catch: Throwable -> L21
        short type = header.getShort();     // Catch: Throwable -> L21
        if (version == 1) goto L14;
        Streams.skipByReading(this.mInput, Long.MAX_VALUE);     // Catch: Throwable -> L21
        throw new SecureChannelException("Secure channel version mismatch. Currently on version 1. Skipping rest of data.");     // Catch: Throwable -> L21
    L14:
        if (type != MessageType.m2970$$Nest$fgetmValue(expected)) goto L29;
        byte[] lengthBytes = new byte[4];     // Catch: Throwable -> L21
        Streams.readFully(this.mInput, lengthBytes);     // Catch: Throwable -> L21
        int length = ByteBuffer.wrap(lengthBytes).getInt();     // Catch: Throwable -> L21
        byte[] data = new byte[length];     // Catch: Throwable -> L21 OutOfMemoryError -> L26
        Streams.readFully(this.mInput, data);     // Catch: Throwable -> L21
        if (MessageType.m2971$$Nest$smshouldEncrypt(expected) == true) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return data;
    L23:
        byte[] r7 = this.mConnectionContext.decodeMessageFromPeer(data, headerBytes);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r7;
    L26:
        error = move-exception;
        Streams.skipByReading(this.mInput, Long.MAX_VALUE);     // Catch: Throwable -> L21
        throw new SecureChannelException("Payload is too large.", error);     // Catch: Throwable -> L21
    L29:
        Streams.skipByReading(this.mInput, Long.MAX_VALUE);     // Catch: Throwable -> L21
        throw new SecureChannelException("Unexpected message type. Expected " + expected.name() + "; Found " + MessageType.from(type).name() + ". Skipping rest of data.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L5:
        if (isSecured() == false) goto L7;
        Slog.d(TAG, "Waiting to receive next secure message.");
        goto L8
    L7:
        Slog.d(TAG, "Waiting to receive next " + expected + " message.");
        goto L8
    }

    private void sendMessage(MessageType messageType, byte[] payload) throws IOException, BadHandleException {
        OutputStream r0 = this.mOutput;
        monitor-enter(r0);
        byte[] header = ByteBuffer.allocate(6).putInt(1).putShort(MessageType.m2970$$Nest$fgetmValue(messageType)).array();     // Catch: Throwable -> L8
        if (MessageType.m2971$$Nest$smshouldEncrypt(messageType) == false) goto L10;
        byte[] data = this.mConnectionContext.encodeMessageToPeer(payload, header);     // Catch: Throwable -> L8
    L11:
        this.mOutput.write(header);     // Catch: Throwable -> L8
        this.mOutput.write(ByteBuffer.allocate(4).putInt(data.length).array());     // Catch: Throwable -> L8
        this.mOutput.write(data);     // Catch: Throwable -> L8
        this.mOutput.flush();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        data = payload;
    L8:
        th = move-exception;
        throw th;
    }

    private void initiateHandshake() throws IOException, BadHandleException, HandshakeException {
        Object r0 = this.mHandshakeLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionContext == null) goto L11;
        Slog.d(TAG, "Ukey2 handshake is already completed.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mRole = D2DHandshakeContext.Role.INITIATOR;     // Catch: Throwable -> L9
        this.mHandshakeContext = D2DHandshakeContext.forInitiator();     // Catch: Throwable -> L9
        this.mClientInit = this.mHandshakeContext.getNextHandshakeMessage();     // Catch: Throwable -> L9
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Sending Ukey2 Client Init message");     // Catch: Throwable -> L9
    L14:
        sendMessage(MessageType.HANDSHAKE_INIT, constructHandshakeInitMessage(this.mClientInit));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private byte[] handleHandshakeCollision(byte[] handshakeInitMessage) throws IOException, HandshakeException, BadHandleException, CryptoException {
        ByteBuffer buffer = ByteBuffer.wrap(handshakeInitMessage);
        if (buffer.get() != 0) goto L5;
        boolean isClientInit = true;
    L6:
        byte[] handshakeMessage = new byte[buffer.remaining()];
        buffer.get(handshakeMessage);
        if (this.mHandshakeContext == null) goto L20;
        if (isClientInit == false) goto L20;
        Slog.w(TAG, "Detected a Ukey2 handshake role collision. Negotiating a role.");
        if (compareByteArray(this.mClientInit, handshakeMessage) >= 0) goto L14;
        Slog.d(TAG, "Assigned: Responder");
        this.mHandshakeContext = null;
        return handshakeMessage;
    L14:
        Slog.d(TAG, "Assigned: Initiator; Discarding received Client Init");
        ByteBuffer nextInitMessage = ByteBuffer.wrap(readMessage(MessageType.HANDSHAKE_INIT));
        if (nextInitMessage.get() == 0) goto L19;
        byte[] nextHandshakeMessage = new byte[nextInitMessage.remaining()];
        nextInitMessage.get(nextHandshakeMessage);
        return nextHandshakeMessage;
    L19:
        throw new HandshakeException("Failed to resolve Ukey2 handshake role collision.");
    L20:
        return handshakeMessage;
    L5:
        isClientInit = false;
        goto L6
    }

    private void exchangeHandshake() throws IOException, HandshakeException, BadHandleException, CryptoException, AlertException {
        if (this.mConnectionContext == null) goto L6;
        Slog.d(TAG, "Ukey2 handshake is already completed.");
        return;
    L6:
        byte[] handshakeInitMessage = readMessage(MessageType.HANDSHAKE_INIT);
        this.mInProgress = true;
        Object r1 = this.mHandshakeLock;
        monitor-enter(r1);
        completeHandshake(handshakeInitMessage);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void completeHandshake(byte[] initMessage) throws IOException, HandshakeException, BadHandleException, CryptoException, AlertException {
        byte[] handshakeMessage = handleHandshakeCollision(initMessage);
        if (this.mHandshakeContext != null) goto L15;
        this.mRole = D2DHandshakeContext.Role.RESPONDER;
        this.mHandshakeContext = D2DHandshakeContext.forResponder();
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "Receiving Ukey2 Client Init message");
    L7:
        this.mHandshakeContext.parseHandshakeMessage(handshakeMessage);
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Sending Ukey2 Server Init message");
    L10:
        sendMessage(MessageType.HANDSHAKE_INIT, constructHandshakeInitMessage(this.mHandshakeContext.getNextHandshakeMessage()));
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Receiving Ukey2 Client Finish message");
    L13:
        this.mHandshakeContext.parseHandshakeMessage(readMessage(MessageType.HANDSHAKE_FINISH));
    L22:
        if (this.mHandshakeContext.isHandshakeComplete() == true) goto L24;
        Slog.e(TAG, "Failed to complete Ukey2 Handshake");
        throw new IllegalStateException("Ukey2 Handshake did not complete as expected.");
    L24:
        if (DEBUG == false) goto L26;
        Slog.d(TAG, "Ukey2 Handshake completed successfully");
    L26:
        this.mConnectionContext = this.mHandshakeContext.toConnectionContext();
        return;
    L15:
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "Receiving Ukey2 Server Init message");
    L17:
        this.mHandshakeContext.parseHandshakeMessage(handshakeMessage);
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "Sending Ukey2 Client Finish message");
    L20:
        sendMessage(MessageType.HANDSHAKE_FINISH, this.mHandshakeContext.getNextHandshakeMessage());
        goto L22
    }

    private void exchangeAuthentication() throws IOException, GeneralSecurityException, BadHandleException, CryptoException {
        if (this.mPreSharedKey == null) goto L6;
        exchangePreSharedKey();
    L6:
        if (this.mVerifier == null) goto L9;
        exchangeAttestation();
        return;
    }

    private void exchangePreSharedKey() throws IOException, GeneralSecurityException, BadHandleException, CryptoException {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Exchanging pre-shared keys.");
    L5:
        sendMessage(MessageType.PRE_SHARED_KEY, constructToken(this.mRole, this.mPreSharedKey));
        byte[] receivedAuthToken = readMessage(MessageType.PRE_SHARED_KEY);
        if (this.mRole != D2DHandshakeContext.Role.INITIATOR) goto L8;
        D2DHandshakeContext.Role r2 = D2DHandshakeContext.Role.RESPONDER;
    L9:
        byte[] expectedAuthToken = constructToken(r2, this.mPreSharedKey);
        this.mPskVerified = Arrays.equals(receivedAuthToken, expectedAuthToken);
        if (this.mPskVerified == false) goto L16;
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "The pre-shared key was successfully authenticated.");
        return;
    L17:
        return;
    L16:
        throw new SecureChannelException("Failed to verify the hash of pre-shared key.");
    L8:
        r2 = D2DHandshakeContext.Role.INITIATOR;
        goto L9
    }

    private void exchangeAttestation() throws IOException, GeneralSecurityException, BadHandleException, CryptoException {
        if (this.mVerificationResult != 0) goto L7;
        Slog.d(TAG, "Remote attestation was already verified.");
        return;
    L7:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Exchanging device attestation.");
    L10:
        if (this.mAlias != null) goto L12;
        this.mAlias = generateAlias();
    L12:
        byte[] localChallenge = constructToken(this.mRole, this.mConnectionContext.getSessionUnique());
        KeyStoreUtils.generateAttestationKeyPair(this.mAlias, localChallenge);
        byte[] localAttestation = KeyStoreUtils.getEncodedCertificateChain(this.mAlias);
        sendMessage(MessageType.ATTESTATION, localAttestation);
        byte[] remoteAttestation = readMessage(MessageType.ATTESTATION);
        if (this.mRole != D2DHandshakeContext.Role.INITIATOR) goto L15;
        D2DHandshakeContext.Role r4 = D2DHandshakeContext.Role.RESPONDER;
    L16:
        byte[] expectedChallenge = constructToken(r4, this.mConnectionContext.getSessionUnique());
        this.mVerificationResult = this.mVerifier.verifyAttestation(remoteAttestation, expectedChallenge);
        byte[] verificationResult = ByteBuffer.allocate(4).putInt(this.mVerificationResult).array();
        sendMessage(MessageType.AVF_RESULT, verificationResult);
        byte[] remoteVerificationResult = readMessage(MessageType.AVF_RESULT);
        if (ByteBuffer.wrap(remoteVerificationResult).getInt() != 0) goto L27;
        if (this.mVerificationResult != 0) goto L25;
        if (DEBUG == false) goto L28;
        Slog.d(TAG, "Remote attestation was successfully verified.");
        return;
    L28:
        return;
    L25:
        throw new SecureChannelException("Failed to verify remote attestation.");
    L27:
        throw new SecureChannelException("Remote device failed to verify local attestation.");
    L15:
        r4 = D2DHandshakeContext.Role.INITIATOR;
        goto L16
    }

    private boolean isSecured() {
        if (this.mConnectionContext != null) goto L6;
        return false;
    L6:
        if (this.mPskVerified == false) goto L8;
    L9:
        return true;
    L8:
        if (this.mVerificationResult == 0) goto L9;
        return false;
    }

    private byte[] constructHandshakeInitMessage(byte[] r4) {
        return ByteBuffer.allocate(r4.length + 1).put((byte) (!D2DHandshakeContext.Role.INITIATOR.equals(this.mRole) ? 1 : 0)).put(r4).array();
    }

    private byte[] constructToken(D2DHandshakeContext.Role role, byte[] authValue) throws GeneralSecurityException {
        MessageDigest hash = MessageDigest.getInstance("SHA-256");
        if (role != D2DHandshakeContext.Role.INITIATOR) goto L5;
        String roleName = "Initiator";
    L6:
        byte[] roleUtf8 = roleName.getBytes(StandardCharsets.UTF_8);
        int tokenLength = roleUtf8.length + authValue.length;
        return hash.digest(ByteBuffer.allocate(tokenLength).put(roleUtf8).put(authValue).array());
    L5:
        roleName = "Responder";
        goto L6
    }

    private int compareByteArray(byte[] a, byte[] b) {
        if (a != b) goto L6;
        return 0;
    L6:
        if (a.length != b.length) goto L8;
        int i = 0;
    L11:
        if (i >= a.length) goto L18;
        if (a[i] != b[i]) goto L15;
        i = i + 1;
        goto L11
    L15:
        return a[i] - b[i];
    L18:
        return 0;
    L8:
        return a.length - b.length;
    }

    private String generateAlias() {
    L2:
        String alias = "secure-channel-" + UUID.randomUUID();
        if (KeyStoreUtils.aliasExists(alias) == true) goto L2;
        return alias;
    }
}
