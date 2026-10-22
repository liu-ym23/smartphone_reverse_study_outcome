package com.android.server.companion.transport;

import android.companion.IOnMessageReceivedListener;
import android.content.Context;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transport {
    protected static final boolean DEBUG = false;
    protected static final int HEADER_LENGTH = 12;
    static final int MESSAGE_RESPONSE_FAILURE = 863004019;
    static final int MESSAGE_RESPONSE_SUCCESS = 864257383;
    protected static final String TAG = "CDM_CompanionTransport";
    protected final int mAssociationId;
    protected final Context mContext;
    protected final ParcelFileDescriptor mFd;
    private final SparseArray<Set<IOnMessageReceivedListener>> mListeners;
    protected final AtomicInteger mNextSequence;
    private OnTransportClosedListener mOnTransportClosed;
    protected final SparseArray<CompletableFuture<byte[]>> mPendingRequests;
    protected final InputStream mRemoteIn;
    protected final OutputStream mRemoteOut;

    @FunctionalInterface
    interface OnTransportClosedListener {
        void onClosed(Transport r1);
    }

    protected abstract void sendMessage(int r1, int r2, byte[] r3) throws IOException;

    abstract void start();

    abstract void stop();

    static {
        DEBUG = Build.IS_DEBUGGABLE;
    }

    private static boolean isRequest(int message) {
        if (((-16777216) & message) != 1660944384) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isResponse(int message) {
        if (((-16777216) & message) != 855638016) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isOneway(int message) {
        if (((-16777216) & message) != 1124073472) goto L5;
        return true;
    L5:
        return false;
    }

    Transport(int associationId, ParcelFileDescriptor fd, Context context) {
        this.mListeners = new SparseArray();
        this.mPendingRequests = new SparseArray();
        this.mNextSequence = new AtomicInteger();
        this.mAssociationId = associationId;
        this.mFd = fd;
        this.mRemoteIn = new ParcelFileDescriptor.AutoCloseInputStream(fd);
        this.mRemoteOut = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
        this.mContext = context;
    }

    public void addListener(int message, IOnMessageReceivedListener listener) {
        SparseArray<Set<IOnMessageReceivedListener>> r0 = this.mListeners;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.contains(message) == true) goto L9;
        this.mListeners.put(message, new HashSet());     // Catch: Throwable -> L7
    L9:
        this.mListeners.get(message).add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public int getAssociationId() {
        return this.mAssociationId;
    }

    protected ParcelFileDescriptor getFd() {
        return this.mFd;
    }

    void close() {
        if (this.mOnTransportClosed == null) goto L6;
        this.mOnTransportClosed.onClosed(this);
        return;
    }

    public Future<byte[]> sendMessage(int message, byte[] data) {
        CompletableFuture<byte[]> pending = new CompletableFuture();
        if (isOneway(message) == false) goto L7;
        return sendAndForget(message, data);
    L7:
        if (isRequest(message) == true) goto L9;
        Slog.w(TAG, "Failed to send message 0x" + Integer.toHexString(message));
        pending.completeExceptionally(new IllegalArgumentException("The message being sent must be either a one-way or a request."));
        return pending;
    L9:
        return requestForResponse(message, data);
    }

    @Deprecated
    public Future<byte[]> requestForResponse(int message, byte[] data) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Requesting for response");
    L5:
        int sequence = this.mNextSequence.incrementAndGet();
        CompletableFuture<byte[]> pending = new CompletableFuture();
        SparseArray<CompletableFuture<byte[]>> r2 = this.mPendingRequests;
        monitor-enter(r2);
        this.mPendingRequests.put(sequence, pending);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        sendMessage(message, sequence, data);     // Catch: IOException -> L11
    L17:
        return pending;
    L11:
        e = move-exception;
        monitor-enter(this.mPendingRequests);
        this.mPendingRequests.remove(sequence);     // Catch: Throwable -> L18
        pending.completeExceptionally(e);
    L18:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        throw e;
    }

    private Future<byte[]> sendAndForget(int message, byte[] data) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Sending a one-way message");
    L5:
        CompletableFuture<byte[]> pending = new CompletableFuture();
        sendMessage(message, -1, data);     // Catch: IOException -> L8
        pending.complete(null);     // Catch: IOException -> L8
    L10:
        return pending;
    L8:
        e = move-exception;
        pending.completeExceptionally(e);
        goto L10
    }

    protected final void handleMessage(int message, int sequence, byte[] data) throws IOException {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Received message 0x" + Integer.toHexString(message) + " sequence " + sequence + " length " + data.length + " from association " + this.mAssociationId);
    L6:
        if (isOneway(message) == false) goto L9;
        processOneway(message, data);
        return;
    L9:
        if (isRequest(message) == false) goto L15;
        processRequest(message, sequence, data);     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to respond to 0x" + Integer.toHexString(message), e);
        return;
    L15:
        if (isResponse(message) == false) goto L17;
        processResponse(message, sequence, data);
        return;
    L17:
        Slog.w(TAG, "Unknown message 0x" + Integer.toHexString(message));
    }

    private void processOneway(int message, byte[] data) {
        switch(message) {
            case 1131446919: goto L4;
            case 1132491640: goto L4;
            case 1132755335: goto L4;
            default: goto L3;
        };
    L3:
        Slog.w(TAG, "Ignoring unknown message 0x" + Integer.toHexString(message));
        return;
    L4:
        callback(message, data);
    }

    private void processRequest(int message, int sequence, byte[] data) throws IOException {
        switch(message) {
            case 1667729539: goto L10;
            case 1669362552: goto L9;
            case 1669491075: goto L12;
            case 1669494629: goto L10;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unknown request 0x" + Integer.toHexString(message));
        sendMessage(MESSAGE_RESPONSE_FAILURE, sequence, EmptyArray.BYTE);
        return;
    L9:
        sendMessage(MESSAGE_RESPONSE_SUCCESS, sequence, data);
        return;
    L10:
        callback(message, data);
        sendMessage(MESSAGE_RESPONSE_SUCCESS, sequence, EmptyArray.BYTE);
        return;
    L12:
        callback(message, data);     // Catch: Exception -> L7
        sendMessage(MESSAGE_RESPONSE_SUCCESS, sequence, EmptyArray.BYTE);     // Catch: Exception -> L7
        return;
    L8:
        Slog.w(TAG, "Failed to restore permissions");
        sendMessage(MESSAGE_RESPONSE_FAILURE, sequence, EmptyArray.BYTE);
    }

    private void callback(int message, byte[] data) {
        SparseArray<Set<IOnMessageReceivedListener>> r0 = this.mListeners;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.contains(message) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Set<IOnMessageReceivedListener> listenersToCall = this.mListeners.get(message);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.d(TAG, "Message 0x" + Integer.toHexString(message) + " is received from associationId " + this.mAssociationId + ", sending data length " + data.length + " to the listener(s).");
        Iterator<IOnMessageReceivedListener> r1 = listenersToCall.iterator();
    L14:
        if (r1.hasNext() == false) goto L20;
        IOnMessageReceivedListener listener = r1.next();
        listener.onMessageReceived(getAssociationId(), data);     // Catch: RemoteException -> L18
        goto L14
    }

    private void processResponse(int message, int sequence, byte[] data) {
        SparseArray<CompletableFuture<byte[]>> r0 = this.mPendingRequests;
        monitor-enter(r0);
        CompletableFuture<byte[]> future = (CompletableFuture) this.mPendingRequests.removeReturnOld(sequence);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (future != null) goto L9;
        Slog.w(TAG, "Ignoring unknown sequence " + sequence);
        return;
    L9:
        switch(message) {
            case 863004019: goto L12;
            case 864257383: goto L11;
            default: goto L10;
        };
    L10:
        Slog.w(TAG, "Ignoring unknown response 0x" + Integer.toHexString(message));
        return;
    L11:
        future.complete(data);
        return;
    L12:
        future.completeExceptionally(new RuntimeException("Remote failure"));
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void setOnTransportClosedListener(OnTransportClosedListener callback) {
        this.mOnTransportClosed = callback;
    }
}
