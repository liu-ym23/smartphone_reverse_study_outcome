package com.android.server.accessibility;

import android.accessibilityservice.IBrailleDisplayConnection;
import android.accessibilityservice.IBrailleDisplayController;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
class BrailleDisplayConnection extends IBrailleDisplayConnection.Stub {
    static final int BUS_BLUETOOTH = 5;
    static final int BUS_UNKNOWN = -1;
    static final int BUS_USB = 3;
    private static final String LOG_TAG = "BrailleDisplayConnection";
    private static final Set<File> sConnectedNodes = null;
    private IBrailleDisplayController mController;
    private File mHidrawNode;
    private Thread mInputThread;
    private final Object mLock;
    private OutputStream mOutputStream;
    private HandlerThread mOutputThread;
    private BrailleDisplayScanner mScanner;
    private final AccessibilityServiceConnection mServiceConnection;

    /* JADX INFO: renamed from: com.android.server.accessibility.BrailleDisplayConnection$1, reason: invalid class name */
    class AnonymousClass1 implements BrailleDisplayScanner {
        private static final String HIDRAW_DEVICE_GLOB = "hidraw*";
        final /* synthetic */ NativeInterface val$nativeInterface;

        /* JADX INFO: renamed from: $r8$lambda$gAVzAwZTottxrrE8vfjrQ-KdaEM, reason: not valid java name */
        public static /* synthetic */ byte[] m674$r8$lambda$gAVzAwZTottxrrE8vfjrQKdaEM(NativeInterface r0, Integer r1) {
            return lambda$getDeviceReportDescriptor$0(r0, r1);
        }

        AnonymousClass1(NativeInterface r1) {
            this.val$nativeInterface = r1;
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.BrailleDisplayScanner
        public Collection<Path> getHidrawNodePaths(Path directory) {
            List<Path> result = new ArrayList();
            DirectoryStream<Path> hidrawNodePaths = Files.newDirectoryStream(directory, HIDRAW_DEVICE_GLOB);     // Catch: IOException -> L14
            Iterator<Path> r2 = hidrawNodePaths.iterator();     // Catch: Throwable -> L9
        L6:
            if (r2.hasNext() == false) goto L12;
            Path path = r2.next();     // Catch: Throwable -> L9
            result.add(path);     // Catch: Throwable -> L9
            goto L23
        L12:
            hidrawNodePaths.close();     // Catch: IOException -> L14
            return result;
        L9:
            th = move-exception;
            if (hidrawNodePaths != null) goto L25;
        L22:
            throw th;     // Catch: IOException -> L14
        L25:
            hidrawNodePaths.close();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L14
        L23:
            return null;
        }

        private <T> T readFromFileDescriptor(Path path, Function<Integer, T> readFn) {
            FileInputStream stream = new FileInputStream(path.toFile());     // Catch: IOException -> L6
            T r1 = readFn.apply(Integer.valueOf(stream.getFD().getInt$()));     // Catch: Throwable -> L8
            stream.close();     // Catch: IOException -> L6
            return r1;
        L8:
            th = move-exception;
            stream.close();     // Catch: Throwable -> L11
        L13:
            throw th;     // Catch: IOException -> L6
        L11:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L6
        L14:
            return null;
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.BrailleDisplayScanner
        public byte[] getDeviceReportDescriptor(Path path) {
            path.getClass();
            final NativeInterface r0 = this.val$nativeInterface;
            return (byte[]) readFromFileDescriptor(path, new BrailleDisplayConnection$1$$ExternalSyntheticLambda2(r0));
        }

        private static /* synthetic */ byte[] lambda$getDeviceReportDescriptor$0(NativeInterface nativeInterface, Integer fd) {
            int descSize = nativeInterface.getHidrawDescSize(fd.intValue());
            if (descSize > 0) goto L5;
            return null;
        L5:
            return nativeInterface.getHidrawDesc(fd.intValue(), descSize);
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.BrailleDisplayScanner
        public String getUniqueId(Path path) {
            path.getClass();
            final NativeInterface r0 = this.val$nativeInterface;
            r0.getClass();
            return (String) readFromFileDescriptor(path, new BrailleDisplayConnection$1$$ExternalSyntheticLambda3(r0));
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.BrailleDisplayScanner
        public int getDeviceBusType(Path path) {
            path.getClass();
            final NativeInterface r0 = this.val$nativeInterface;
            r0.getClass();
            Integer busType = (Integer) readFromFileDescriptor(path, new BrailleDisplayConnection$1$$ExternalSyntheticLambda1(r0));
            if (busType != null) goto L7;
            return -1;
        L7:
            return busType.intValue();
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.BrailleDisplayScanner
        public String getName(Path path) {
            path.getClass();
            final NativeInterface r0 = this.val$nativeInterface;
            r0.getClass();
            return (String) readFromFileDescriptor(path, new BrailleDisplayConnection$1$$ExternalSyntheticLambda0(r0));
        }
    }

    interface BrailleDisplayScanner {
        int getDeviceBusType(Path r1);

        byte[] getDeviceReportDescriptor(Path r1);

        Collection<Path> getHidrawNodePaths(Path r1);

        String getName(Path r1);

        String getUniqueId(Path r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BusType {
    }

    private static class DefaultNativeInterface implements NativeInterface {
        /* synthetic */ DefaultNativeInterface(BrailleDisplayConnectionIA r1) {
            this();
        }

        private DefaultNativeInterface() {
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.NativeInterface
        public int getHidrawDescSize(int fd) {
            return BrailleDisplayConnection.m671$$Nest$smnativeGetHidrawDescSize(fd);
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.NativeInterface
        public byte[] getHidrawDesc(int fd, int descSize) {
            return BrailleDisplayConnection.m670$$Nest$smnativeGetHidrawDesc(fd, descSize);
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.NativeInterface
        public String getHidrawUniq(int fd) {
            return BrailleDisplayConnection.m673$$Nest$smnativeGetHidrawUniq(fd);
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.NativeInterface
        public int getHidrawBusType(int fd) {
            return BrailleDisplayConnection.m669$$Nest$smnativeGetHidrawBusType(fd);
        }

        @Override // com.android.server.accessibility.BrailleDisplayConnection.NativeInterface
        public String getHidrawName(int fd) {
            return BrailleDisplayConnection.m672$$Nest$smnativeGetHidrawName(fd);
        }
    }

    interface NativeInterface {
        int getHidrawBusType(int r1);

        byte[] getHidrawDesc(int r1, int r2);

        int getHidrawDescSize(int r1);

        String getHidrawName(int r1);

        String getHidrawUniq(int r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$-dj1Q9MgvDf4wIlWfzOqiOFYLG0, reason: not valid java name */
    public static /* synthetic */ void m667$r8$lambda$dj1Q9MgvDf4wIlWfzOqiOFYLG0(BrailleDisplayConnection r0) {
        r0.lambda$startReadingLocked$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$WZFx05r6K5Q-kQ2A6oLnh-C5u38, reason: not valid java name */
    public static /* synthetic */ void m668$r8$lambda$WZFx05r6K5QkQ2A6oLnhC5u38(BrailleDisplayConnection r0, byte[] r1) {
        r0.lambda$write$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeGetHidrawBusType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m669$$Nest$smnativeGetHidrawBusType(int r0) {
        return nativeGetHidrawBusType(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeGetHidrawDesc, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m670$$Nest$smnativeGetHidrawDesc(int r0, int r1) {
        return nativeGetHidrawDesc(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeGetHidrawDescSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m671$$Nest$smnativeGetHidrawDescSize(int r0) {
        return nativeGetHidrawDescSize(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeGetHidrawName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m672$$Nest$smnativeGetHidrawName(int r0) {
        return nativeGetHidrawName(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeGetHidrawUniq, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m673$$Nest$smnativeGetHidrawUniq(int r0) {
        return nativeGetHidrawUniq(r0);
    }

    private static native int nativeGetHidrawBusType(int r0);

    private static native byte[] nativeGetHidrawDesc(int r0, int r1);

    private static native int nativeGetHidrawDescSize(int r0);

    private static native String nativeGetHidrawName(int r0);

    private static native String nativeGetHidrawUniq(int r0);

    static {
        sConnectedNodes = new ArraySet();
    }

    BrailleDisplayConnection(Object lock, AccessibilityServiceConnection serviceConnection) {
        lock.getClass();
        this.mLock = lock;
        this.mScanner = getDefaultNativeScanner(new DefaultNativeInterface(null));
        serviceConnection.getClass();
        this.mServiceConnection = serviceConnection;
    }

    static BrailleDisplayScanner createScannerForShell() {
        return getDefaultNativeScanner(new DefaultNativeInterface(null));
    }

    void connectLocked(String expectedUniqueId, String expectedName, int expectedBusType, IBrailleDisplayController controller) {
        expectedUniqueId.getClass();
        controller.getClass();
        this.mController = controller;
        boolean r0 = false;
        Path devicePath = Path.of("/dev", new String[0]);
        List<Pair<File, byte[]>> result = new ArrayList();
        Collection<Path> hidrawNodePaths = this.mScanner.getHidrawNodePaths(devicePath);
        boolean r6 = true;
        if (hidrawNodePaths != null) goto L6;
        Slog.w(LOG_TAG, "Unable to access the HIDRAW node directory");
        sendConnectionErrorLocked(1);
        return;
    L6:
        boolean unableToGetDescriptor = false;
        Iterator<Path> r9 = hidrawNodePaths.iterator();
    L8:
        if (r9.hasNext() == false) goto L32;
        Path path = r9.next();
        byte[] descriptor = this.mScanner.getDeviceReportDescriptor(path);
        if (descriptor == null) goto L11;
        String uniqueId = this.mScanner.getUniqueId(path);
        if (uniqueId == null) goto L15;
        boolean matchesIdentifier = expectedUniqueId.equalsIgnoreCase(uniqueId);
    L24:
        if (isBrailleDisplay(descriptor) == false) goto L30;
        if (this.mScanner.getDeviceBusType(path) != expectedBusType) goto L30;
        if (matchesIdentifier == false) goto L30;
        result.add(Pair.create(path.toFile(), descriptor));
    L30:
        r0 = false;
        r6 = true;
        goto L8
    L15:
        String name = this.mScanner.getName(path);
        if (TextUtils.isEmpty(expectedName) == true) goto L21;
        if (expectedName.equals(name) == false) goto L21;
        boolean r16 = r6;
    L22:
        matchesIdentifier = r16;
    L21:
        r16 = r0;
        goto L22
    L11:
        unableToGetDescriptor = true;
        goto L8
    L32:
        if (result.size() == 1) goto L39;
        int errorCode = 2;
        if (unableToGetDescriptor == false) goto L36;
        Slog.w(LOG_TAG, "Unable to access some HIDRAW node's descriptor");
        errorCode = 2 | 1;
    L37:
        sendConnectionErrorLocked(errorCode);
        return;
    L36:
        Slog.w(LOG_TAG, "Unable to find a unique Braille display matching the provided device");
        goto L37
    L39:
        this.mHidrawNode = (File) result.get(0).first;
        byte[] reportDescriptor = (byte[]) result.get(0).second;
        if (sConnectedNodes.contains(this.mHidrawNode) == false) goto L43;
        Slog.w(LOG_TAG, "Unable to find an unused Braille display matching the provided device");
        sendConnectionErrorLocked(2);
        return;
    L43:
        sConnectedNodes.add(this.mHidrawNode);
        startReadingLocked();
        this.mServiceConnection.onBrailleDisplayConnectedLocked(this);     // Catch: RemoteException -> L46
        this.mController.onConnected(this, reportDescriptor);     // Catch: RemoteException -> L46
        return;
    L46:
        e = move-exception;
        Slog.e(LOG_TAG, "Error calling onConnected", e);
        disconnect();
    }

    private void sendConnectionErrorLocked(int errorCode) {
        this.mController.onConnectionFailed(errorCode);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(LOG_TAG, "Error calling onConnectionFailed", e);
    }

    static boolean isBrailleDisplay(byte[] descriptor) {
        boolean foundMatch = false;
        int i = 0;
    L4:
        if (i >= descriptor.length) goto L20;
        byte itemInfo = descriptor[i];
        if (isHidItemShort(itemInfo) == false) goto L7;
        int dataSize = getHidItemDataSize(itemInfo);
        if ((i + dataSize) >= descriptor.length) goto L11;
        if (dataSize != 1) goto L18;
        byte itemData = descriptor[i + 1];
        if (isHidItemBrailleDisplayUsagePage(itemInfo, itemData) == false) goto L18;
        foundMatch = true;
    L18:
        i = (i + dataSize) + 1;
        goto L4
    L11:
        Slog.w(LOG_TAG, "Item " + itemInfo + " specifies size past the remaining bytes");
        return false;
    L7:
        Slog.w(LOG_TAG, "Item " + itemInfo + " declares unsupported long type");
        return false;
    L20:
        return foundMatch;
    }

    private static boolean isHidItemShort(byte itemInfo) {
        if ((itemInfo & 240) == 240) goto L5;
        return true;
    L5:
        return false;
    }

    private static int getHidItemDataSize(byte itemInfo) {
        switch((itemInfo & 3)) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 4;
    L5:
        return 2;
    L6:
        return 1;
    L7:
        return 0;
    }

    private static boolean isHidItemBrailleDisplayUsagePage(byte itemInfo, byte itemData) {
        byte itemType = (byte) (itemInfo & 252);
        if (itemType == 4) goto L5;
    L7:
        return false;
    L5:
        if (itemData != 65) goto L7;
        return true;
    }

    private void assertServiceIsConnectedLocked() {
        if (this.mServiceConnection.isConnectedLocked() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Accessibility service is not connected");
    }

    public void disconnect() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        closeInputLocked();     // Catch: Throwable -> L7
        closeOutputLocked();     // Catch: Throwable -> L7
        this.mServiceConnection.onBrailleDisplayDisconnectedLocked();     // Catch: Throwable -> L7
        this.mController.onDisconnected();     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        sConnectedNodes.remove(this.mHidrawNode);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        Slog.e(LOG_TAG, "Error calling onDisconnected");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void write(final byte[] buffer) {
        buffer.getClass();
        if (buffer.length <= IBinder.getSuggestedMaxIpcSizeBytes()) goto L6;
        Slog.e(LOG_TAG, "Requested write of size " + buffer.length + " which is larger than maximum " + IBinder.getSuggestedMaxIpcSizeBytes());
        disconnect();
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertServiceIsConnectedLocked();     // Catch: Throwable -> L12
        if (this.mOutputThread == null) goto L23;
    L18:
        this.mOutputThread.getThreadHandler().post(new BrailleDisplayConnection$$ExternalSyntheticLambda0(this, buffer));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L23:
        this.mOutputStream = new FileOutputStream(this.mHidrawNode);     // Catch: Throwable -> L12 Exception -> L14
        this.mOutputThread = new HandlerThread("BrailleDisplayConnection output thread", 10);     // Catch: Throwable -> L12
        this.mOutputThread.setDaemon(true);     // Catch: Throwable -> L12
        this.mOutputThread.start();     // Catch: Throwable -> L12
        goto L18
    L14:
        e = move-exception;
        Slog.e(LOG_TAG, "Unable to create write stream", e);     // Catch: Throwable -> L12
        disconnect();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$write$0(byte[] buffer) {
        this.mOutputStream.write(buffer);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        Slog.d(LOG_TAG, "Error writing to connected Braille display", e);
        disconnect();
    }

    private void startReadingLocked() {
        this.mInputThread = new Thread(new BrailleDisplayConnection$$ExternalSyntheticLambda1(this), "BrailleDisplayConnection input thread");
        this.mInputThread.setDaemon(true);
        this.mInputThread.start();
    }

    private /* synthetic */ void lambda$startReadingLocked$1() {
        Process.setThreadPriority(10);
        InputStream inputStream = new FileInputStream(this.mHidrawNode);     // Catch: IOException -> L20
        byte[] buffer = new byte[IBinder.getSuggestedMaxIpcSizeBytes()];     // Catch: Throwable -> L10
    L6:
        if (Thread.interrupted() == true) goto L18;
        if (this.mHidrawNode.exists() == false) goto L9;
        int readSize = inputStream.read(buffer);     // Catch: Throwable -> L10
        if (readSize <= 0) goto L6;
        this.mController.onInput(Arrays.copyOfRange(buffer, 0, readSize));     // Catch: Throwable -> L10 RemoteException -> L16
    L16:
        e = move-exception;
        Slog.e(LOG_TAG, "Error calling onInput", e);     // Catch: Throwable -> L10
        disconnect();     // Catch: Throwable -> L10
        goto L18
    L9:
        disconnect();     // Catch: Throwable -> L10
    L18:
        inputStream.close();     // Catch: IOException -> L20
        return;
    L10:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L20
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Slog.d(LOG_TAG, "Error reading from connected Braille display", e);
        disconnect();
    }

    private void closeInputLocked() {
        if (this.mInputThread == null) goto L5;
        this.mInputThread.interrupt();
    L5:
        this.mInputThread = null;
    }

    private void closeOutputLocked() {
        if (this.mOutputThread == null) goto L5;
        this.mOutputThread.quit();
    L5:
        this.mOutputThread = null;
        if (this.mOutputStream != null) goto L13;
    L11:
        this.mOutputStream = null;
        return;
    L13:
        this.mOutputStream.close();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(LOG_TAG, "Unable to close output stream", e);
        goto L11
    }

    static BrailleDisplayScanner getDefaultNativeScanner(NativeInterface nativeInterface) {
        nativeInterface.getClass();
        return new AnonymousClass1(nativeInterface);
    }

    BrailleDisplayScanner setTestData(List<Bundle> brailleDisplays) {
        brailleDisplays.getClass();
        final Map<Path, Bundle> brailleDisplayMap = new ArrayMap();
        Iterator<Bundle> r1 = brailleDisplays.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Bundle brailleDisplay = r1.next();
        Path hidrawNodePath = Path.of(brailleDisplay.getString("HIDRAW_PATH"), new String[0]);
        brailleDisplayMap.put(hidrawNodePath, brailleDisplay);
        goto L4
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mScanner = new AnonymousClass2(this, brailleDisplayMap);     // Catch: Throwable -> L11
        BrailleDisplayScanner r3 = this.mScanner;     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }
}
