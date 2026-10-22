package com.android.server.am;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Slog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class LmkdConnection {
    private static final int LMKD_REPLY_MAX_SIZE = 222;
    private static final String TAG = "ActivityManager";
    private final ByteBuffer mInputBuf;
    private final DataInputStream mInputData;
    private final LmkdConnectionListener mListener;
    private InputStream mLmkdInputStream;
    private final Object mLmkdInputStreamLock;
    private boolean mLmkdNotify;
    private OutputStream mLmkdOutputStream;
    private final Object mLmkdOutputStreamLock;
    private LocalSocket mLmkdSocket;
    private final Object mLmkdSocketLock;
    private final MessageQueue mMsgQueue;
    private ByteBuffer mReplyBuf;
    private final Object mReplyBufLock;

    interface LmkdConnectionListener {
        boolean handleUnsolicitedMessage(DataInputStream r1, int r2);

        boolean isReplyExpected(ByteBuffer r1, ByteBuffer r2, int r3);

        boolean onConnect(OutputStream r1);

        void onDisconnect();
    }

    /* JADX INFO: renamed from: -$$Nest$mfileDescriptorEventHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1515$$Nest$mfileDescriptorEventHandler(LmkdConnection r0, FileDescriptor r1, int r2) {
        return r0.fileDescriptorEventHandler(r1, r2);
    }

    LmkdConnection(MessageQueue msgQueue, LmkdConnectionListener listener) {
        this.mLmkdSocketLock = new Object();
        this.mLmkdSocket = null;
        this.mLmkdOutputStreamLock = new Object();
        this.mLmkdOutputStream = null;
        this.mLmkdInputStreamLock = new Object();
        this.mLmkdInputStream = null;
        this.mInputBuf = ByteBuffer.allocate(LMKD_REPLY_MAX_SIZE);
        this.mInputData = new DataInputStream(new ByteArrayInputStream(this.mInputBuf.array()));
        this.mReplyBufLock = new Object();
        this.mLmkdNotify = false;
        this.mReplyBuf = null;
        this.mMsgQueue = msgQueue;
        this.mListener = listener;
    }

    public boolean connect() {
        Object r0 = this.mLmkdSocketLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLmkdSocket == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        LocalSocket socket = openSocket();     // Catch: Throwable -> L8
        if (socket != null) goto L46;
        Slog.w(TAG, "Failed to connect to lowmemorykiller, retry later");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L46:
        OutputStream ostream = socket.getOutputStream();     // Catch: Throwable -> L8 IOException -> L40
        InputStream istream = socket.getInputStream();     // Catch: Throwable -> L8 IOException -> L40
        goto L41
    L17:
        if (this.mListener != null) goto L19;
    L23:
        Object r3 = this.mLmkdOutputStreamLock;     // Catch: Throwable -> L8
        monitor-enter(r3);     // Catch: Throwable -> L8
        Object r6 = this.mLmkdInputStreamLock;     // Catch: Throwable -> L33
        monitor-enter(r6);     // Catch: Throwable -> L33
        this.mLmkdSocket = socket;     // Catch: Throwable -> L35
        this.mLmkdOutputStream = ostream;     // Catch: Throwable -> L35
        this.mLmkdInputStream = istream;     // Catch: Throwable -> L35
        monitor-exit(r6);     // Catch: Throwable -> L35
        monitor-exit(r3);     // Catch: Throwable -> L33
        this.mMsgQueue.addOnFileDescriptorEventListener(this.mLmkdSocket.getFileDescriptor(), 5, new AnonymousClass1(this));     // Catch: Throwable -> L8
        this.mLmkdSocketLock.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L19:
        if (this.mListener.onConnect(ostream) == true) goto L23;
        Slog.w(TAG, "Failed to communicate with lowmemorykiller, retry later");     // Catch: Throwable -> L8
        IoUtils.closeQuietly(socket);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L41:
        IoUtils.closeQuietly(socket);     // Catch: Throwable -> L8
        return false;
    }

    private int fileDescriptorEventHandler(FileDescriptor fd, int events) {
        if (this.mListener != null) goto L6;
        return 0;
    L6:
        if ((events & 1) == 0) goto L9;
        processIncomingData();
    L9:
        if ((events & 4) == 0) goto L44;
        Object r0 = this.mLmkdSocketLock;
        monitor-enter(r0);
        this.mMsgQueue.removeOnFileDescriptorEventListener(this.mLmkdSocket.getFileDescriptor());     // Catch: Throwable -> L33
        IoUtils.closeQuietly(this.mLmkdSocket);     // Catch: Throwable -> L33
        Object r2 = this.mLmkdOutputStreamLock;     // Catch: Throwable -> L33
        monitor-enter(r2);     // Catch: Throwable -> L33
        Object r3 = this.mLmkdInputStreamLock;     // Catch: Throwable -> L35
        monitor-enter(r3);     // Catch: Throwable -> L35
        this.mLmkdOutputStream = null;     // Catch: Throwable -> L37
        this.mLmkdInputStream = null;     // Catch: Throwable -> L37
        this.mLmkdSocket = null;     // Catch: Throwable -> L37
        monitor-exit(r3);     // Catch: Throwable -> L37
        monitor-exit(r2);     // Catch: Throwable -> L35
        monitor-exit(r0);     // Catch: Throwable -> L33
        Object r4 = this.mReplyBufLock;
        monitor-enter(r4);
    L26:
        th = move-exception;
        throw th;
    L24:
        if (this.mReplyBuf == null) goto L28;
        this.mReplyBuf = null;     // Catch: Throwable -> L26
        this.mLmkdNotify = true;     // Catch: Throwable -> L26
        this.mReplyBufLock.notifyAll();     // Catch: Throwable -> L26
    L28:
        monitor-exit(r4);     // Catch: Throwable -> L26
        this.mListener.onDisconnect();
        return 0;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L44:
        return 5;
    }

    private void processIncomingData() {
        int len = read(this.mInputBuf);
        if (len <= 0) goto L30;
        this.mInputData.reset();     // Catch: IOException -> L23
        Object r1 = this.mReplyBufLock;     // Catch: IOException -> L23
        monitor-enter(r1);     // Catch: IOException -> L23
    L11:
        th = move-exception;
        throw th;     // Catch: IOException -> L23
        goto L24
    L7:
        if (this.mReplyBuf == null) goto L17;
        if (this.mListener.isReplyExpected(this.mReplyBuf, this.mInputBuf, len) == false) goto L14;
        this.mReplyBuf.put(this.mInputBuf.array(), 0, len);     // Catch: Throwable -> L11
        this.mReplyBuf.rewind();     // Catch: Throwable -> L11
        this.mLmkdNotify = true;     // Catch: Throwable -> L11
        this.mReplyBufLock.notifyAll();     // Catch: Throwable -> L11
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L11
        goto L24
    L31:
        return;
    L14:
        if (this.mListener.handleUnsolicitedMessage(this.mInputData, len) == true) goto L19;
        this.mReplyBuf = null;     // Catch: Throwable -> L11
        this.mLmkdNotify = true;     // Catch: Throwable -> L11
        this.mReplyBufLock.notifyAll();     // Catch: Throwable -> L11
        Slog.e(TAG, "Received an unexpected packet from lmkd");     // Catch: Throwable -> L11
        goto L19
    L17:
        if (this.mListener.handleUnsolicitedMessage(this.mInputData, len) == true) goto L19;
        Slog.w(TAG, "Received an unexpected packet from lmkd");     // Catch: Throwable -> L11
    L24:
        Slog.e(TAG, "Failed to parse lmkd data buffer. Size = " + len);
        return;
    }

    public boolean isConnected() {
        Object r0 = this.mLmkdSocketLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mLmkdSocket == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean waitForConnection(long timeoutMs) {
        Object r0 = this.mLmkdSocketLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mLmkdSocket == null) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L23:
        this.mLmkdSocketLock.wait(timeoutMs);     // Catch: Throwable -> L8 InterruptedException -> L17
        if (this.mLmkdSocket != null) goto L15;
        r2 = false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L19:
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    private LocalSocket openSocket() {
        LocalSocket socket = new LocalSocket(3);     // Catch: IOException -> L4
        socket.connect(new LocalSocketAddress("lmkd", LocalSocketAddress.Namespace.RESERVED));     // Catch: IOException -> L4
        return socket;
    L4:
        ex = move-exception;
        Slog.e(TAG, "Connection failed: " + ex.toString());
        return null;
    }

    private boolean write(ByteBuffer buf) {
        boolean result = false;
        Object r1 = this.mLmkdOutputStreamLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLmkdOutputStream != null) goto L15;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L15:
        this.mLmkdOutputStream.write(buf.array(), 0, buf.position());     // Catch: Throwable -> L8 IOException -> L10
        result = true;
        goto L11
    }

    private int read(ByteBuffer buf) {
        int result = -1;
        Object r1 = this.mLmkdInputStreamLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLmkdInputStream != null) goto L17;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L17:
        result = this.mLmkdInputStream.read(buf.array(), 0, buf.array().length);     // Catch: Throwable -> L8 IOException -> L10
        goto L11
    }

    public boolean exchange(ByteBuffer req, ByteBuffer repl) {
        if (repl == null) goto L4;
        boolean result = false;
        long waitTime = 500;
        long endTime = SystemClock.uptimeMillis() + 500;
        Object r5 = this.mReplyBufLock;
        monitor-enter(r5);
        this.mReplyBuf = repl;     // Catch: Throwable -> L18
        this.mLmkdNotify = false;     // Catch: Throwable -> L18
        if (write(req) == true) goto L10;
    L26:
        this.mReplyBuf = null;     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
        return result;
    L10:
        if (this.mLmkdNotify == true) goto L24;
        if (waitTime <= 0) goto L24;
        this.mReplyBufLock.wait(waitTime);     // Catch: Throwable -> L18 InterruptedException -> L20
        if (this.mReplyBuf == null) goto L16;
        boolean result2 = true;
    L17:
        result = result2;
    L22:
        waitTime = endTime - SystemClock.uptimeMillis();     // Catch: Throwable -> L18
        goto L10
    L16:
        result2 = false;
    L21:
        result = false;
    L24:
        if (this.mLmkdNotify == true) goto L26;
        Slog.i(TAG, "lmkdconnect exchange wait timeout:" + waitTime);     // Catch: Throwable -> L18
        result = false;
    L18:
        th = move-exception;
        throw th;
    L4:
        return write(req);
    }
}
