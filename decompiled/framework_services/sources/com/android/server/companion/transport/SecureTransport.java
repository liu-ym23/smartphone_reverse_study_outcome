package com.android.server.companion.transport;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import com.android.server.companion.securechannel.AttestationVerifier;
import com.android.server.companion.securechannel.SecureChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
class SecureTransport extends Transport implements SecureChannel.Callback {
    private final BlockingQueue<byte[]> mRequestQueue;
    private final SecureChannel mSecureChannel;
    private volatile boolean mShouldProcessRequests;

    public static /* synthetic */ void $r8$lambda$NpzH_C9jUjEknX6CvYQb4u1741I(SecureTransport r0) {
        r0.lambda$onSecureConnection$0();
    }

    SecureTransport(int associationId, ParcelFileDescriptor fd, Context context, int flags) {
        super(associationId, fd, context);
        this.mShouldProcessRequests = false;
        this.mRequestQueue = new ArrayBlockingQueue(500);
        this.mSecureChannel = new SecureChannel(this.mRemoteIn, this.mRemoteOut, this, context, flags);
    }

    SecureTransport(int associationId, ParcelFileDescriptor fd, Context context, byte[] preSharedKey, AttestationVerifier verifier, int flags) {
        super(associationId, fd, context);
        this.mShouldProcessRequests = false;
        this.mRequestQueue = new ArrayBlockingQueue(500);
        this.mSecureChannel = new SecureChannel(this.mRemoteIn, this.mRemoteOut, this, preSharedKey, verifier, flags);
    }

    @Override // com.android.server.companion.transport.Transport
    void start() {
        this.mSecureChannel.start();
    }

    @Override // com.android.server.companion.transport.Transport
    void stop() {
        this.mSecureChannel.stop();
        this.mShouldProcessRequests = false;
    }

    @Override // com.android.server.companion.transport.Transport
    void close() {
        this.mSecureChannel.close();
        this.mShouldProcessRequests = false;
        super.close();
    }

    @Override // com.android.server.companion.transport.Transport
    protected void sendMessage(int message, int sequence, byte[] data) throws IOException {
        if (this.mShouldProcessRequests == true) goto L6;
        establishSecureConnection();
    L6:
        if (Transport.DEBUG == false) goto L13;
        Slog.d("CDM_CompanionTransport", "Queueing message 0x" + Integer.toHexString(message) + " sequence " + sequence + " length " + data.length + " to association " + this.mAssociationId);
    L13:
        this.mRequestQueue.add(ByteBuffer.allocate(data.length + 12).putInt(message).putInt(sequence).putInt(data.length).put(data).array());     // Catch: IllegalStateException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w("CDM_CompanionTransport", "Failed to queue message 0x" + Integer.toHexString(message) + " . Request buffer is full; detaching transport.", e);
        close();
    }

    private void establishSecureConnection() {
        Slog.d("CDM_CompanionTransport", "Establishing secure connection.");
        this.mSecureChannel.establishSecureConnection();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.e("CDM_CompanionTransport", "Failed to initiate secure channel handshake.", e);
        close();
    }

    @Override // com.android.server.companion.securechannel.SecureChannel.Callback
    public void onSecureConnection() {
        this.mShouldProcessRequests = true;
        Slog.d("CDM_CompanionTransport", "Secure connection established.");
        new Thread(new SecureTransport$$ExternalSyntheticLambda0(this)).start();
    }

    private /* synthetic */ void lambda$onSecureConnection$0() {
    L3:
        if (this.mShouldProcessRequests == false) goto L8;
        byte[] request = this.mRequestQueue.take();     // Catch: Exception -> L6
        this.mSecureChannel.sendSecureMessage(request);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.e("CDM_CompanionTransport", "Failed to send secure message.", e);
        close();
        goto L3
    }

    @Override // com.android.server.companion.securechannel.SecureChannel.Callback
    public void onSecureMessageReceived(byte[] data) {
        ByteBuffer payload = ByteBuffer.wrap(data);
        int message = payload.getInt();
        int sequence = payload.getInt();
        int length = payload.getInt();
        byte[] content = new byte[length];
        payload.get(content);
        handleMessage(message, sequence, content);     // Catch: IOException -> L5
        return;
    }

    @Override // com.android.server.companion.securechannel.SecureChannel.Callback
    public void onError(Throwable error) {
        Slog.e("CDM_CompanionTransport", "Secure transport encountered an error.", error);
        if (this.mSecureChannel.isStopped() == false) goto L6;
        close();
        return;
    }

    public String toString() {
        return "SecureTransport{mAssociationId=" + this.mAssociationId + ", mSecureChannel=" + this.mSecureChannel + '}';
    }
}
