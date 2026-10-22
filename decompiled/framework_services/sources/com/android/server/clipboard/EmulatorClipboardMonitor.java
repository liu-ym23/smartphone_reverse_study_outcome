package com.android.server.clipboard;

import android.content.ClipData;
import android.os.PersistableBundle;
import android.os.SystemProperties;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.VmSocketAddress;
import android.util.Slog;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
class EmulatorClipboardMonitor implements Consumer<ClipData> {
    private static final int HOST_PORT = 5000;
    private static final boolean LOG_CLIBOARD_ACCESS = false;
    private static final int MAX_CLIPBOARD_BYTES = 134217728;
    private static final String PIPE_NAME = "pipe:clipboard";
    private static final String TAG = "EmulatorClipboardMonitor";
    private final Thread mHostMonitorThread;
    private FileDescriptor mPipe;

    public static /* synthetic */ void $r8$lambda$6XdF9Wq0zBE4L9ePnTl3z_2l0ic(String r0, FileDescriptor r1) {
        lambda$setHostClipboard$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$I665hZBuK4A9PXws4VUFbdMwhbk(EmulatorClipboardMonitor r0, Consumer r1) {
        r0.lambda$new$0(r1);
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(ClipData r1) {
        accept2(r1);
    }

    static {
        LOG_CLIBOARD_ACCESS = SystemProperties.getBoolean("ro.boot.qemu.log_clipboard_access", false);
    }

    private static byte[] createOpenHandshake() {
        byte[] bits = Arrays.copyOf(PIPE_NAME.getBytes(), PIPE_NAME.length() + 1);
        bits[PIPE_NAME.length()] = 0;
        return bits;
    }

    private synchronized FileDescriptor getPipeFD() {
        monitor-enter(this);
        FileDescriptor r0 = this.mPipe;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void setPipeFD(FileDescriptor fd) {
        monitor-enter(this);
        this.mPipe = fd;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static FileDescriptor openPipeImpl() {
        FileDescriptor fd = Os.socket(OsConstants.AF_VSOCK, OsConstants.SOCK_STREAM, 0);     // Catch: ErrnoException -> L8
        Os.connect(fd, new VmSocketAddress(5000, OsConstants.VMADDR_CID_HOST));     // Catch: Throwable -> L5
        byte[] handshake = createOpenHandshake();     // Catch: Throwable -> L5
        writeFully(fd, handshake, 0, handshake.length);     // Catch: Throwable -> L5
        return fd;
    L6:
        Os.close(fd);     // Catch: ErrnoException -> L8
        return null;
    L9:
        return null;
    }

    private static FileDescriptor openPipe() throws InterruptedException {
        FileDescriptor fd = openPipeImpl();
    L3:
        if (fd != null) goto L5;
        Thread.sleep(100);
        fd = openPipeImpl();
        goto L3
    L5:
        return fd;
    }

    private byte[] receiveMessage(FileDescriptor fd) throws ErrnoException, InterruptedIOException, EOFException, ProtocolException {
        byte[] lengthBits = new byte[4];
        readFully(fd, lengthBits, 0, lengthBits.length);
        ByteBuffer bb = ByteBuffer.wrap(lengthBits);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        int msgLen = bb.getInt();
        if (msgLen < 0) goto L9;
        if (msgLen > 134217728) goto L9;
        byte[] msg = new byte[msgLen];
        readFully(fd, msg, 0, msg.length);
        return msg;
    L9:
        throw new ProtocolException("Clipboard message length: " + msgLen + " out of bounds.");
    }

    private static void sendMessage(FileDescriptor fd, byte[] msg) throws ErrnoException, InterruptedIOException {
        byte[] lengthBits = new byte[4];
        ByteBuffer bb = ByteBuffer.wrap(lengthBits);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putInt(msg.length);
        writeFully(fd, lengthBits, 0, lengthBits.length);
        writeFully(fd, msg, 0, msg.length);
    }

    EmulatorClipboardMonitor(final Consumer<ClipData> setAndroidClipboard) {
        this.mPipe = null;
        this.mHostMonitorThread = new Thread(new EmulatorClipboardMonitor$$ExternalSyntheticLambda0(this, setAndroidClipboard));
        this.mHostMonitorThread.start();
    }

    private /* synthetic */ void lambda$new$0(Consumer setAndroidClipboard) {
        FileDescriptor fd = null;
    L4:
        if (Thread.interrupted() == true) goto L20;
        if (fd != null) goto L10;
        fd = openPipe();     // Catch: Throwable -> L8
        setPipeFD(fd);     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        Slog.w(TAG, "Failure to read from host clipboard", e);
        setPipeFD(null);
        Os.close(fd);     // Catch: ErrnoException -> L18
    L19:
        fd = null;
    L10:
        byte[] receivedData = receiveMessage(fd);     // Catch: Throwable -> L8
        String str = new String(receivedData);     // Catch: Throwable -> L8
        ClipData clip = new ClipData("host clipboard", new String[]{"text/plain"}, new ClipData.Item(str));     // Catch: Throwable -> L8
        PersistableBundle bundle = new PersistableBundle();     // Catch: Throwable -> L8
        bundle.putBoolean("com.android.systemui.SUPPRESS_CLIPBOARD_OVERLAY", true);     // Catch: Throwable -> L8
        clip.getDescription().setExtras(bundle);     // Catch: Throwable -> L8
        if (LOG_CLIBOARD_ACCESS == false) goto L13;
        Slog.i(TAG, "Setting the guest clipboard to '" + str + "'");     // Catch: Throwable -> L8
    L13:
        setAndroidClipboard.accept(clip);     // Catch: Throwable -> L8
        goto L4
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(ClipData clip) {
        FileDescriptor fd = getPipeFD();
        if (fd == null) goto L6;
        setHostClipboard(fd, getClipString(clip));
        return;
    }

    private String getClipString(ClipData clip) {
        if (clip != null) goto L6;
        return "";
    L6:
        if (clip.getItemCount() != 0) goto L8;
        return "";
    L8:
        CharSequence text = clip.getItemAt(0).getText();
        if (text != null) goto L12;
        return "";
    L12:
        return text.toString();
    }

    private static void setHostClipboard(final FileDescriptor fd, final String value) {
        Thread t = new Thread(new EmulatorClipboardMonitor$$ExternalSyntheticLambda1(value, fd));
        t.start();
    }

    private static /* synthetic */ void lambda$setHostClipboard$1(String value, FileDescriptor fd) {
        if (LOG_CLIBOARD_ACCESS == false) goto L12;
        Slog.i(TAG, "Setting the host clipboard to '" + value + "'");
    L12:
        sendMessage(fd, value.getBytes());     // Catch: IllegalArgumentException -> L7 Throwable -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to set host clipboard " + e.getMessage());
        return;
    }

    private static void readFully(FileDescriptor fd, byte[] buf, int offset, int size) throws ErrnoException, InterruptedIOException, EOFException {
    L2:
        if (size <= 0) goto L8;
        int r = Os.read(fd, buf, offset, size);
        if (r <= 0) goto L7;
        offset = offset + r;
        size = size - r;
        goto L2
    L7:
        throw new EOFException();
    }

    private static void writeFully(FileDescriptor fd, byte[] buf, int offset, int size) throws ErrnoException, InterruptedIOException {
    L2:
        if (size <= 0) goto L8;
        int r = Os.write(fd, buf, offset, size);
        if (r <= 0) goto L7;
        offset = offset + r;
        size = size - r;
        goto L2
    L7:
        throw new ErrnoException("write", OsConstants.EIO);
    }
}
