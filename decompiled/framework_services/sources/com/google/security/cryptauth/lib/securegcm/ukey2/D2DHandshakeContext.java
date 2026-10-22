package com.google.security.cryptauth.lib.securegcm.ukey2;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes3.dex */
public class D2DHandshakeContext {
    private final long contextPtr;

    public static final enum NextProtocol extends Enum<NextProtocol> {
        private static final /* synthetic */ NextProtocol[] $VALUES = null;
        public static final NextProtocol AES_256_CBC_HMAC_SHA256 = null;
        public static final NextProtocol AES_256_GCM_SIV = null;

        private static /* synthetic */ NextProtocol[] $values() {
            return new NextProtocol[]{AES_256_GCM_SIV, AES_256_CBC_HMAC_SHA256};
        }

        private NextProtocol(String r1, int r2) {
            super(r1, r2);
        }

        public static NextProtocol valueOf(String name) {
            return (NextProtocol) Enum.valueOf(NextProtocol.class, name);
        }

        public static NextProtocol[] values() {
            return (NextProtocol[]) $VALUES.clone();
        }

        static {
            AES_256_GCM_SIV = new NextProtocol("AES_256_GCM_SIV", 0);
            AES_256_CBC_HMAC_SHA256 = new NextProtocol("AES_256_CBC_HMAC_SHA256", 1);
            $VALUES = $values();
        }
    }

    public static final enum Role extends Enum<Role> {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final Role INITIATOR = null;
        public static final Role RESPONDER = null;

        private static /* synthetic */ Role[] $values() {
            return new Role[]{INITIATOR, RESPONDER};
        }

        private Role(String r1, int r2) {
            super(r1, r2);
        }

        public static Role valueOf(String name) {
            return (Role) Enum.valueOf(Role.class, name);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        static {
            INITIATOR = new Role("INITIATOR", 0);
            RESPONDER = new Role("RESPONDER", 1);
            $VALUES = $values();
        }
    }

    private static native long create_context(boolean r0, int[] r1);

    private static native byte[] get_next_handshake_message(long r0) throws BadHandleException;

    private static native byte[] get_verification_string(long r0, int r2) throws BadHandleException, HandshakeException;

    private static native boolean is_handshake_complete(long r0) throws BadHandleException;

    private static native void parse_handshake_message(long r0, byte[] r2) throws AlertException, BadHandleException, HandshakeException;

    private static native long to_connection_context(long r0) throws HandshakeException;

    static {
        System.loadLibrary("ukey2_jni");
    }

    public D2DHandshakeContext(@Nonnull Role role) throws HandshakeException {
        this(role, new NextProtocol[]{NextProtocol.AES_256_CBC_HMAC_SHA256});
    }

    public D2DHandshakeContext(@Nonnull Role role, @Nonnull NextProtocol[] nextProtocols) throws HandshakeException {
        boolean r1 = true;
        if (nextProtocols.length < 1) goto L15;
        int[] nextProtocolCodes = new int[nextProtocols.length];
        int i = 0;
    L6:
        if (i >= nextProtocols.length) goto L9;
        nextProtocolCodes[i] = nextProtocols[i].ordinal();
        i = i + 1;
        goto L6
    L9:
        if (role == Role.INITIATOR) goto L12;
        r1 = false;
    L12:
        this.contextPtr = create_context(r1, nextProtocolCodes);
        return;
    L15:
        throw new HandshakeException("Need more than one supported next protocol!");
    }

    public static D2DHandshakeContext forInitiator() throws HandshakeException {
        return new D2DHandshakeContext(Role.INITIATOR);
    }

    public static D2DHandshakeContext forInitiator(NextProtocol[] nextProtocols) throws HandshakeException {
        return new D2DHandshakeContext(Role.INITIATOR, nextProtocols);
    }

    public static D2DHandshakeContext forResponder() throws HandshakeException {
        return new D2DHandshakeContext(Role.RESPONDER);
    }

    public static D2DHandshakeContext forResponder(NextProtocol[] nextProtocols) throws HandshakeException {
        return new D2DHandshakeContext(Role.RESPONDER, nextProtocols);
    }

    public boolean isHandshakeComplete() throws BadHandleException {
        return is_handshake_complete(this.contextPtr);
    }

    @Nonnull
    public byte[] getNextHandshakeMessage() throws BadHandleException {
        return get_next_handshake_message(this.contextPtr);
    }

    @Nonnull
    public void parseHandshakeMessage(@Nonnull byte[] message) throws AlertException, BadHandleException, HandshakeException {
        parse_handshake_message(this.contextPtr, message);
    }

    @Nonnull
    public byte[] getVerificationString(int length) throws BadHandleException, HandshakeException {
        return get_verification_string(this.contextPtr, length);
    }

    public D2DConnectionContextV1 toConnectionContext() throws HandshakeException {
        return new D2DConnectionContextV1(to_connection_context(this.contextPtr));
    }
}
