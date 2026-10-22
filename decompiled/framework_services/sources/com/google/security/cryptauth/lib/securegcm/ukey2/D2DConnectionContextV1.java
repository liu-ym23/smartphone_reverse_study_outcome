package com.google.security.cryptauth.lib.securegcm.ukey2;

import java.io.PrintStream;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class D2DConnectionContextV1 {
    private final long contextPtr;

    private static native byte[] decode_message_from_peer(long r0, byte[] r2, byte[] r3) throws CryptoException;

    private static native byte[] encode_message_to_peer(long r0, byte[] r2, byte[] r3) throws BadHandleException;

    private static native long from_saved_session(byte[] r0);

    private static native int get_sequence_number_for_decoding(long r0) throws BadHandleException;

    private static native int get_sequence_number_for_encoding(long r0) throws BadHandleException;

    private static native byte[] get_session_unique(long r0) throws BadHandleException;

    private static native byte[] save_session(long r0) throws BadHandleException;

    static {
        String path = System.getProperty("java.library.path");
        if (path == null) goto L7;
        List<String> paths = List.of(path.split(";"));
        final PrintStream r2 = System.out;
        r2.getClass();
        paths.forEach(new D2DConnectionContextV1$$ExternalSyntheticLambda0(r2));
        System.loadLibrary("ukey2_jni");
        return;
    L7:
        throw new RuntimeException("Path isn't set.");
    }

    D2DConnectionContextV1(@Nonnull long contextPtr) {
        this.contextPtr = contextPtr;
    }

    @Nonnull
    public byte[] encodeMessageToPeer(@Nonnull byte[] payload, @Nullable byte[] associatedData) throws BadHandleException {
        return encode_message_to_peer(this.contextPtr, payload, associatedData);
    }

    @Nonnull
    public byte[] decodeMessageFromPeer(@Nonnull byte[] message, @Nullable byte[] associatedData) throws CryptoException {
        return decode_message_from_peer(this.contextPtr, message, associatedData);
    }

    @Nonnull
    public byte[] getSessionUnique() throws BadHandleException {
        return get_session_unique(this.contextPtr);
    }

    public int getSequenceNumberForEncoding() throws BadHandleException {
        return get_sequence_number_for_encoding(this.contextPtr);
    }

    public int getSequenceNumberForDecoding() throws BadHandleException {
        return get_sequence_number_for_decoding(this.contextPtr);
    }

    @Nonnull
    public byte[] saveSession() throws BadHandleException {
        return save_session(this.contextPtr);
    }

    public static D2DConnectionContextV1 fromSavedSession(@Nonnull byte[] savedSessionInfo) {
        return new D2DConnectionContextV1(from_saved_session(savedSessionInfo));
    }
}
