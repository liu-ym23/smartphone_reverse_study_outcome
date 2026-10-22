package com.android.server.companion.transport;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* JADX INFO: loaded from: classes.dex */
class RawTransport extends Transport {
    private volatile boolean mStopped;

    /* JADX INFO: renamed from: $r8$lambda$kOck5G0Ky7-AcKXjGkOrtQvK6ss, reason: not valid java name */
    public static /* synthetic */ void m2973$r8$lambda$kOck5G0Ky7AcKXjGkOrtQvK6ss(RawTransport r0) {
        r0.lambda$start$0();
    }

    RawTransport(int associationId, ParcelFileDescriptor fd, Context context) {
        super(associationId, fd, context);
    }

    @Override // com.android.server.companion.transport.Transport
    void start() {
        if (Transport.DEBUG == false) goto L5;
        Slog.d("CDM_CompanionTransport", "Starting raw transport.");
    L5:
        new Thread(new RawTransport$$ExternalSyntheticLambda0(this)).start();
    }

    private /* synthetic */ void lambda$start$0() {
    L13:
    L6:
        e = move-exception;
        if (this.mStopped == true) goto L17;
        Slog.w("CDM_CompanionTransport", "Trouble during transport", e);
        close();
        return;
    L17:
        return;
    L3:
        if (this.mStopped == true) goto L18;
        receiveMessage();     // Catch: IOException -> L6
        goto L13
    }

    @Override // com.android.server.companion.transport.Transport
    void stop() {
        if (Transport.DEBUG == false) goto L5;
        Slog.d("CDM_CompanionTransport", "Stopping raw transport.");
    L5:
        this.mStopped = true;
    }

    @Override // com.android.server.companion.transport.Transport
    void close() {
        stop();
        if (Transport.DEBUG == false) goto L5;
        Slog.d("CDM_CompanionTransport", "Closing raw transport.");
    L5:
        IoUtils.closeQuietly(this.mRemoteIn);
        IoUtils.closeQuietly(this.mRemoteOut);
        super.close();
    }

    @Override // com.android.server.companion.transport.Transport
    protected void sendMessage(int message, int sequence, byte[] data) throws IOException {
        if (Transport.DEBUG == false) goto L5;
        Slog.e("CDM_CompanionTransport", "Sending message 0x" + Integer.toHexString(message) + " sequence " + sequence + " length " + data.length + " to association " + this.mAssociationId);
    L5:
        OutputStream r0 = this.mRemoteOut;
        monitor-enter(r0);
        ByteBuffer header = ByteBuffer.allocate(12).putInt(message).putInt(sequence).putInt(data.length);     // Catch: Throwable -> L11
        this.mRemoteOut.write(header.array());     // Catch: Throwable -> L11
        this.mRemoteOut.write(data);     // Catch: Throwable -> L11
        this.mRemoteOut.flush();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "RawTransport{mAssociationId=" + this.mAssociationId + '}';
    }

    private void receiveMessage() throws IOException {
        InputStream r0 = this.mRemoteIn;
        monitor-enter(r0);
        byte[] headerBytes = new byte[12];     // Catch: Throwable -> L8
        Streams.readFully(this.mRemoteIn, headerBytes);     // Catch: Throwable -> L8
        ByteBuffer header = ByteBuffer.wrap(headerBytes);     // Catch: Throwable -> L8
        int message = header.getInt();     // Catch: Throwable -> L8
        int sequence = header.getInt();     // Catch: Throwable -> L8
        int length = header.getInt();     // Catch: Throwable -> L8
        byte[] data = new byte[length];     // Catch: Throwable -> L8
        Streams.readFully(this.mRemoteIn, data);     // Catch: Throwable -> L8
        handleMessage(message, sequence, data);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
