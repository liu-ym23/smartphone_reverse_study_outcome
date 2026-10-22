package com.android.server.usb;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.dump.DumpUtils;
import com.android.server.usb.descriptors.UsbDescriptor;
import com.android.server.usb.descriptors.UsbDescriptorParser;
import com.android.server.usb.descriptors.UsbDeviceDescriptor;
import com.android.server.usb.descriptors.UsbInterfaceDescriptor;
import com.android.server.usb.descriptors.report.TextReportCanvas;
import com.android.server.usb.descriptors.tree.UsbDescriptorsTree;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public class UsbHostManager {
    private static final boolean DEBUG = false;
    private static final int LINUX_FOUNDATION_VID = 7531;
    private static final int MAX_CONNECT_RECORDS = 32;
    private static final int MAX_UNIQUE_CODE_GENERATION_ATTEMPTS = 10;
    private static final String TAG = null;
    static final SimpleDateFormat sFormat = null;
    private final ArrayMap<String, ConnectionRecord> mConnected;
    private final LinkedList<ConnectionRecord> mConnections;
    private final Context mContext;
    private UsbProfileGroupSettingsManager mCurrentSettings;
    private final HashMap<String, UsbDevice> mDevices;
    private Object mHandlerLock;
    private final boolean mHasMidiFeature;
    private final String[] mHostDenyList;
    private ConnectionRecord mLastConnect;
    private final Object mLock;
    private final HashMap<String, ArrayList<UsbDirectMidiDevice>> mMidiDevices;
    private final HashSet<String> mMidiUniqueCodes;
    private int mNumConnects;
    private final UsbPermissionManager mPermissionManager;
    private final Random mRandom;
    private Object mSettingsLock;
    private final UsbAlsaManager mUsbAlsaManager;
    private ComponentName mUsbDeviceConnectionHandler;

    class ConnectionRecord {
        static final int CONNECT = 0;
        static final int CONNECT_BADDEVICE = 2;
        static final int CONNECT_BADPARSE = 1;
        static final int DISCONNECT = -1;
        private static final int kDumpBytesPerLine = 16;
        final byte[] mDescriptors;
        String mDeviceAddress;
        final int mMode;
        long mTimestamp;

        ConnectionRecord(UsbHostManager this$0, String deviceAddress, int mode, byte[] descriptors) {
            this.mTimestamp = System.currentTimeMillis();
            this.mDeviceAddress = deviceAddress;
            this.mMode = mode;
            this.mDescriptors = descriptors;
        }

        private String formatTime() {
            return new StringBuilder(UsbHostManager.sFormat.format(new Date(this.mTimestamp))).toString();
        }

        void dump(DualDumpOutputStream dump, String idName, long id) {
            long token = dump.start(idName, id);
            dump.write("device_address", 1138166333441L, this.mDeviceAddress);
            dump.write("mode", 1159641169922L, this.mMode);
            dump.write("timestamp", 1112396529667L, this.mTimestamp);
            if (this.mMode == (-1)) goto L5;
            UsbDescriptorParser parser = new UsbDescriptorParser(this.mDeviceAddress, this.mDescriptors);
            UsbDeviceDescriptor deviceDescriptor = parser.getDeviceDescriptor();
            dump.write("manufacturer", 1120986464260L, deviceDescriptor.getVendorID());
            dump.write("product", 1120986464261L, deviceDescriptor.getProductID());
            long isHeadSetToken = dump.start("is_headset", 1146756268038L);
            dump.write("in", 1133871366145L, parser.isInputHeadset());
            dump.write("out", 1133871366146L, parser.isOutputHeadset());
            dump.end(isHeadSetToken);
        L5:
            dump.end(token);
        }

        void dumpShort(IndentingPrintWriter pw) {
            if (this.mMode == (-1)) goto L5;
            pw.println(formatTime() + " Connect " + this.mDeviceAddress + " mode:" + this.mMode);
            UsbDescriptorParser parser = new UsbDescriptorParser(this.mDeviceAddress, this.mDescriptors);
            UsbDeviceDescriptor deviceDescriptor = parser.getDeviceDescriptor();
            pw.println("manfacturer:0x" + Integer.toHexString(deviceDescriptor.getVendorID()) + " product:" + Integer.toHexString(deviceDescriptor.getProductID()));
            pw.println("isHeadset[in: " + parser.isInputHeadset() + " , out: " + parser.isOutputHeadset() + "], isDock: " + parser.isDock());
            return;
        L5:
            pw.println(formatTime() + " Disconnect " + this.mDeviceAddress);
        }

        void dumpTree(IndentingPrintWriter pw) {
            if (this.mMode == (-1)) goto L5;
            pw.println(formatTime() + " Connect " + this.mDeviceAddress + " mode:" + this.mMode);
            UsbDescriptorParser parser = new UsbDescriptorParser(this.mDeviceAddress, this.mDescriptors);
            StringBuilder stringBuilder = new StringBuilder();
            UsbDescriptorsTree descriptorTree = new UsbDescriptorsTree();
            descriptorTree.parse(parser);
            descriptorTree.report(new TextReportCanvas(parser, stringBuilder));
            stringBuilder.append("isHeadset[in: " + parser.isInputHeadset() + " , out: " + parser.isOutputHeadset() + "], isDock: " + parser.isDock());
            pw.println(stringBuilder.toString());
            return;
        L5:
            pw.println(formatTime() + " Disconnect " + this.mDeviceAddress);
        }

        void dumpList(IndentingPrintWriter pw) {
            if (this.mMode == (-1)) goto L9;
            pw.println(formatTime() + " Connect " + this.mDeviceAddress + " mode:" + this.mMode);
            UsbDescriptorParser parser = new UsbDescriptorParser(this.mDeviceAddress, this.mDescriptors);
            StringBuilder stringBuilder = new StringBuilder();
            TextReportCanvas canvas = new TextReportCanvas(parser, stringBuilder);
            Iterator<UsbDescriptor> r3 = parser.getDescriptors().iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            UsbDescriptor descriptor = r3.next();
            descriptor.report(canvas);
            goto L6
        L8:
            pw.println(stringBuilder.toString());
            pw.println("isHeadset[in: " + parser.isInputHeadset() + " , out: " + parser.isOutputHeadset() + "], isDock: " + parser.isDock());
            return;
        L9:
            pw.println(formatTime() + " Disconnect " + this.mDeviceAddress);
        }

        void dumpRaw(IndentingPrintWriter pw) {
            if (this.mMode == (-1)) goto L16;
            pw.println(formatTime() + " Connect " + this.mDeviceAddress + " mode:" + this.mMode);
            int length = this.mDescriptors.length;
            StringBuilder r1 = new StringBuilder();
            r1.append("Raw Descriptors ");
            r1.append(length);
            r1.append(" bytes");
            pw.println(r1.toString());
            int dataOffset = 0;
            int line = 0;
        L6:
            if (line >= (length / 16)) goto L12;
            StringBuilder sb = new StringBuilder();
            int offset = 0;
        L9:
            if (offset >= 16) goto L11;
            sb.append(String.format("0x%02X", new Object[]{Byte.valueOf(this.mDescriptors[dataOffset])}));
            sb.append(" ");
            offset = offset + 1;
            dataOffset = dataOffset + 1;
            goto L9
        L11:
            pw.println(sb.toString());
            line = line + 1;
            goto L6
        L12:
            StringBuilder sb2 = new StringBuilder();
        L13:
            if (dataOffset >= length) goto L15;
            sb2.append(String.format("0x%02X", new Object[]{Byte.valueOf(this.mDescriptors[dataOffset])}));
            sb2.append(" ");
            dataOffset = dataOffset + 1;
            goto L13
        L15:
            pw.println(sb2.toString());
            return;
        L16:
            pw.println(formatTime() + " Disconnect " + this.mDeviceAddress);
        }
    }

    public static /* synthetic */ void $r8$lambda$Sq1_ySYK5qJSYgVk_skxot4cnGI(UsbHostManager r0) {
        r0.monitorUsbHostBus();
    }

    private native void monitorUsbHostBus();

    private native ParcelFileDescriptor nativeOpenDevice(String r1);

    static {
        TAG = UsbHostManager.class.getSimpleName();
        sFormat = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    }

    public UsbHostManager(Context context, UsbAlsaManager alsaManager, UsbPermissionManager permissionManager) {
        this.mLock = new Object();
        this.mDevices = new HashMap();
        this.mSettingsLock = new Object();
        this.mHandlerLock = new Object();
        this.mConnections = new LinkedList();
        this.mConnected = new ArrayMap();
        this.mMidiDevices = new HashMap();
        this.mMidiUniqueCodes = new HashSet();
        this.mRandom = new Random();
        this.mContext = context;
        this.mHostDenyList = context.getResources().getStringArray(R.array.fingerprint_error_vendor);
        this.mUsbAlsaManager = alsaManager;
        this.mPermissionManager = permissionManager;
        String deviceConnectionHandler = context.getResources().getString(R.string.config_defaultContentProtectionService);
        if (TextUtils.isEmpty(deviceConnectionHandler) == true) goto L5;
        setUsbDeviceConnectionHandler(ComponentName.unflattenFromString(deviceConnectionHandler));
    L5:
        this.mHasMidiFeature = context.getPackageManager().hasSystemFeature("android.software.midi");
    }

    public void setCurrentUserSettings(UsbProfileGroupSettingsManager settings) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        this.mCurrentSettings = settings;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private UsbProfileGroupSettingsManager getCurrentUserSettings() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        UsbProfileGroupSettingsManager r1 = this.mCurrentSettings;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUsbDeviceConnectionHandler(ComponentName usbDeviceConnectionHandler) {
        Object r0 = this.mHandlerLock;
        monitor-enter(r0);
        this.mUsbDeviceConnectionHandler = usbDeviceConnectionHandler;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ComponentName getUsbDeviceConnectionHandler() {
        Object r0 = this.mHandlerLock;
        monitor-enter(r0);
        ComponentName r1 = this.mUsbDeviceConnectionHandler;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isDenyListed(String deviceAddress) {
        int count = this.mHostDenyList.length;
        int i = 0;
    L3:
        if (i >= count) goto L9;
        if (deviceAddress.startsWith(this.mHostDenyList[i]) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean isDenyListed(int clazz, int subClass) {
        if (clazz != 9) goto L6;
        return true;
    L6:
        if (clazz != 3) goto L9;
        if (subClass != 1) goto L9;
        return true;
    L9:
        return false;
    }

    private void addConnectionRecord(String deviceAddress, int mode, byte[] rawDescriptors) {
        this.mNumConnects++;
    L4:
        if (this.mConnections.size() < 32) goto L6;
        this.mConnections.removeFirst();
        goto L4
    L6:
        ConnectionRecord rec = new ConnectionRecord(this, deviceAddress, mode, rawDescriptors);
        this.mConnections.add(rec);
        if (mode == (-1)) goto L9;
        this.mLastConnect = rec;
    L9:
        if (mode != 0) goto L11;
        this.mConnected.put(deviceAddress, rec);
        return;
    L11:
        if (mode != (-1)) goto L16;
        this.mConnected.remove(deviceAddress);
        return;
    }

    private void logUsbDevice(UsbDescriptorParser descriptorParser) {
        int vid = 0;
        int pid = 0;
        String mfg = "<unknown>";
        String product = "<unknown>";
        String version = "<unknown>";
        String serial = "<unknown>";
        UsbDeviceDescriptor deviceDescriptor = descriptorParser.getDeviceDescriptor();
        if (deviceDescriptor == null) goto L6;
        vid = deviceDescriptor.getVendorID();
        pid = deviceDescriptor.getProductID();
        mfg = deviceDescriptor.getMfgString(descriptorParser);
        product = deviceDescriptor.getProductString(descriptorParser);
        version = deviceDescriptor.getDeviceReleaseString();
        serial = deviceDescriptor.getSerialString(descriptorParser);
    L6:
        if (vid != LINUX_FOUNDATION_VID) goto L8;
        return;
    L8:
        boolean hasAudio = descriptorParser.hasAudioInterface();
        boolean hasHid = descriptorParser.hasHIDInterface();
        boolean hasStorage = descriptorParser.hasStorageInterface();
        String attachedString = "USB device attached: " + String.format("vidpid %04x:%04x", new Object[]{Integer.valueOf(vid), Integer.valueOf(pid)});
        Slog.d(TAG, (attachedString + String.format(" mfg/product/ver/serial %s/%s/%s/%s", new Object[]{mfg, product, version, serial})) + String.format(" hasAudio/HID/Storage: %b/%b/%b", new Object[]{Boolean.valueOf(hasAudio), Boolean.valueOf(hasHid), Boolean.valueOf(hasStorage)}));
    }

    private boolean usbDeviceAdded(String deviceAddress, int deviceClass, int deviceSubclass, byte[] descriptors) {
        if (isDenyListed(deviceAddress) == false) goto L6;
        return false;
    L6:
        if (isDenyListed(deviceClass, deviceSubclass) == false) goto L8;
        return false;
    L8:
        if (descriptors != null) goto L11;
        Slog.e(TAG, "Failed to add device as the descriptor is null");
        return false;
    L11:
        UsbDescriptorParser parser = new UsbDescriptorParser(deviceAddress, descriptors);
        if (deviceClass == 0) goto L14;
    L16:
        logUsbDevice(parser);
        Object r8 = this.mLock;
        monitor-enter(r8);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (this.mDevices.get(deviceAddress) == null) goto L25;
        Slog.w(TAG, "device already on mDevices list: " + deviceAddress);     // Catch: Throwable -> L23
        monitor-exit(r8);     // Catch: Throwable -> L23
        return false;
    L25:
        UsbDevice.Builder newDeviceBuilder = parser.toAndroidUsbDeviceBuilder();     // Catch: Throwable -> L23
        boolean r9 = true;
        if (newDeviceBuilder != null) goto L28;
        Slog.e(TAG, "Couldn't create UsbDevice object.");     // Catch: Throwable -> L23
        addConnectionRecord(deviceAddress, 2, parser.getRawDescriptors());     // Catch: Throwable -> L23
        r9 = true;
    L52:
        monitor-exit(r8);     // Catch: Throwable -> L23
        return r9;
    L28:
        UsbSerialReader serialNumberReader = new UsbSerialReader(this.mContext, this.mPermissionManager, newDeviceBuilder.serialNumber);     // Catch: Throwable -> L23
        UsbDevice newDevice = newDeviceBuilder.build(serialNumberReader);     // Catch: Throwable -> L23
        serialNumberReader.setDevice(newDevice);     // Catch: Throwable -> L23
        this.mDevices.put(deviceAddress, newDevice);     // Catch: Throwable -> L23
        Slog.d(TAG, "Added device " + newDevice);     // Catch: Throwable -> L23
        ComponentName usbDeviceConnectionHandler = getUsbDeviceConnectionHandler();     // Catch: Throwable -> L23
        if (usbDeviceConnectionHandler != null) goto L31;
        getCurrentUserSettings().deviceAttached(newDevice);     // Catch: Throwable -> L23
    L32:
        this.mUsbAlsaManager.usbDeviceAdded(deviceAddress, newDevice, parser);     // Catch: Throwable -> L23
        if (this.mHasMidiFeature == false) goto L50;
        String uniqueUsbDeviceIdentifier = generateNewUsbDeviceIdentifier();     // Catch: Throwable -> L23
        ArrayList<UsbDirectMidiDevice> midiDevices = new ArrayList();     // Catch: Throwable -> L23
        if (parser.containsUniversalMidiDeviceEndpoint() == false) goto L46;
        UsbDirectMidiDevice midiDevice = UsbDirectMidiDevice.create(this.mContext, newDevice, parser, true, uniqueUsbDeviceIdentifier);     // Catch: Throwable -> L23
        if (midiDevice == null) goto L39;
        midiDevices.add(midiDevice);     // Catch: Throwable -> L23
    L41:
        if (parser.containsLegacyMidiDeviceEndpoint() == false) goto L48;
        UsbDirectMidiDevice midiDevice2 = UsbDirectMidiDevice.create(this.mContext, newDevice, parser, false, uniqueUsbDeviceIdentifier);     // Catch: Throwable -> L23
        if (midiDevice2 == null) goto L45;
        midiDevices.add(midiDevice2);     // Catch: Throwable -> L23
        goto L48
    L45:
        Slog.e(TAG, "Legacy Midi Device is null.");     // Catch: Throwable -> L23
    L48:
        if (midiDevices.isEmpty() == true) goto L51;
        this.mMidiDevices.put(deviceAddress, midiDevices);     // Catch: Throwable -> L23
    L51:
        addConnectionRecord(deviceAddress, 0, descriptors);     // Catch: Throwable -> L23
        FrameworkStatsLog.write(77, newDevice.getVendorId(), newDevice.getProductId(), parser.hasAudioInterface(), parser.hasHIDInterface(), parser.hasStorageInterface(), 1, 0);     // Catch: Throwable -> L23
        goto L52
    L39:
        Slog.e(TAG, "Universal Midi Device is null.");     // Catch: Throwable -> L23
        goto L41
    L46:
        r9 = true;
        goto L48
    L50:
        r9 = true;
        goto L51
    L31:
        getCurrentUserSettings().deviceAttachedForFixedHandler(newDevice, usbDeviceConnectionHandler);     // Catch: Throwable -> L23
        goto L32
    L14:
        if (checkUsbInterfacesDenyListed(parser) == true) goto L16;
        return false;
    }

    private void usbDeviceRemoved(String deviceAddress) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        UsbDevice device = this.mDevices.remove(deviceAddress);     // Catch: Throwable -> L14
        if (device == null) goto L23;
        Slog.d(TAG, "Removed device at " + deviceAddress + ": " + device.getProductName());     // Catch: Throwable -> L14
        this.mUsbAlsaManager.usbDeviceRemoved(deviceAddress);     // Catch: Throwable -> L14
        this.mPermissionManager.usbDeviceRemoved(device);     // Catch: Throwable -> L14
        ArrayList<UsbDirectMidiDevice> midiDevices = this.mMidiDevices.remove(deviceAddress);     // Catch: Throwable -> L14
        if (midiDevices == null) goto L18;
        Iterator<UsbDirectMidiDevice> r5 = midiDevices.iterator();     // Catch: Throwable -> L14
    L10:
        if (r5.hasNext() == false) goto L17;
        UsbDirectMidiDevice midiDevice = r5.next();     // Catch: Throwable -> L14
        if (midiDevice == null) goto L10;
        IoUtils.closeQuietly(midiDevice);     // Catch: Throwable -> L14
        goto L10
    L17:
        Slog.i(TAG, "USB MIDI Devices Removed: " + deviceAddress);     // Catch: Throwable -> L14
    L18:
        getCurrentUserSettings().usbDeviceRemoved(device);     // Catch: Throwable -> L14
        ConnectionRecord current = this.mConnected.get(deviceAddress);     // Catch: Throwable -> L14
        addConnectionRecord(deviceAddress, -1, null);     // Catch: Throwable -> L14
        if (current == null) goto L24;
        UsbDescriptorParser parser = new UsbDescriptorParser(deviceAddress, current.mDescriptors);     // Catch: Throwable -> L14
        FrameworkStatsLog.write(77, device.getVendorId(), device.getProductId(), parser.hasAudioInterface(), parser.hasHIDInterface(), parser.hasStorageInterface(), 0, System.currentTimeMillis() - current.mTimestamp);     // Catch: Throwable -> L14
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L14
        return;
    L23:
        Slog.d(TAG, "Removed device at " + deviceAddress + " was already gone");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void systemReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Runnable runnable = new UsbHostManager$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L7
        new Thread(null, runnable, "UsbService host thread").start();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void getDeviceList(Bundle devices) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<String> r1 = this.mDevices.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String name = r1.next();     // Catch: Throwable -> L8
        devices.putParcelable(name, this.mDevices.get(name));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor openDevice(String deviceAddress, UsbUserPermissionManager permissions, String packageName, int pid, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isDenyListed(deviceAddress) == true) goto L16;
        UsbDevice device = this.mDevices.get(deviceAddress);     // Catch: Throwable -> L11
        if (device == null) goto L14;
        permissions.checkPermission(device, packageName, pid, uid);     // Catch: Throwable -> L11
        ParcelFileDescriptor r2 = nativeOpenDevice(deviceAddress);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L14:
        throw new IllegalArgumentException("device " + deviceAddress + " does not exist or is restricted");     // Catch: Throwable -> L11
    L16:
        throw new SecurityException("USB device is on a restricted bus");     // Catch: Throwable -> L11
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        Object r2 = this.mHandlerLock;
        monitor-enter(r2);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUsbDeviceConnectionHandler == null) goto L9;
        DumpUtils.writeComponentName(dump, "default_usb_host_connection_handler", 1146756268033L, this.mUsbDeviceConnectionHandler);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        Object r3 = this.mLock;
        monitor-enter(r3);
        Iterator<String> r4 = this.mDevices.keySet().iterator();     // Catch: Throwable -> L16
    L14:
        if (r4.hasNext() == false) goto L18;
        String name = r4.next();     // Catch: Throwable -> L16
        com.android.internal.usb.DumpUtils.writeDevice(dump, "devices", 2246267895810L, this.mDevices.get(name));     // Catch: Throwable -> L16
        goto L14
    L18:
        dump.write("num_connects", 1120986464259L, this.mNumConnects);     // Catch: Throwable -> L16
        Iterator<ConnectionRecord> r5 = this.mConnections.iterator();     // Catch: Throwable -> L16
    L20:
        if (r5.hasNext() == false) goto L22;
        ConnectionRecord rec = r5.next();     // Catch: Throwable -> L16
        rec.dump(dump, "connections", 2246267895812L);     // Catch: Throwable -> L16
        goto L20
    L22:
        Iterator<ArrayList<UsbDirectMidiDevice>> r6 = this.mMidiDevices.values().iterator();     // Catch: Throwable -> L16
    L24:
        if (r6.hasNext() == false) goto L30;
        ArrayList<UsbDirectMidiDevice> directMidiDevices = r6.next();     // Catch: Throwable -> L16
        Iterator<UsbDirectMidiDevice> r7 = directMidiDevices.iterator();     // Catch: Throwable -> L16
    L27:
        if (r7.hasNext() == false) goto L24;
        UsbDirectMidiDevice directMidiDevice = r7.next();     // Catch: Throwable -> L16
        directMidiDevice.dump(dump, "midi_devices", 2246267895813L);     // Catch: Throwable -> L16
        goto L27
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L16
        dump.end(token);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void dumpDescriptors(IndentingPrintWriter pw, String[] args) {
        if (this.mLastConnect == null) goto L19;
        pw.println("Last Connected USB Device:");
        if (args.length > 1) goto L7;
    L18:
        this.mLastConnect.dumpShort(pw);
        return;
    L7:
        if (args[1].equals("-dump-short") == true) goto L18;
        if (args[1].equals("-dump-tree") == false) goto L13;
        this.mLastConnect.dumpTree(pw);
        return;
    L13:
        if (args[1].equals("-dump-list") == false) goto L16;
        this.mLastConnect.dumpList(pw);
        return;
    L16:
        if (args[1].equals("-dump-raw") == false) goto L23;
        this.mLastConnect.dumpRaw(pw);
        return;
    L23:
        return;
    L19:
        pw.println("No USB Devices have been connected.");
    }

    private boolean checkUsbInterfacesDenyListed(UsbDescriptorParser parser) {
        boolean shouldIgnoreDevice = false;
        Iterator<UsbDescriptor> r1 = parser.getDescriptors().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        UsbDescriptor descriptor = r1.next();
        if ((descriptor instanceof UsbInterfaceDescriptor) == false) goto L4;
        UsbInterfaceDescriptor iface = (UsbInterfaceDescriptor) descriptor;
        shouldIgnoreDevice = isDenyListed(iface.getUsbClass(), iface.getUsbSubclass());
        if (shouldIgnoreDevice == true) goto L4;
    L12:
        if (shouldIgnoreDevice == false) goto L15;
        return false;
    L15:
        return true;
    }

    private String generateNewUsbDeviceIdentifier() {
        int numberOfAttempts = 0;
    L4:
        if (numberOfAttempts <= 10) goto L6;
        Slog.w(TAG, "MIDI unique code array resetting");
        this.mMidiUniqueCodes.clear();
        numberOfAttempts = 0;
    L6:
        String code = "";
        int i = 0;
    L8:
        if (i >= 3) goto L10;
        code = code + this.mRandom.nextInt(10);
        i = i + 1;
        goto L8
    L10:
        numberOfAttempts = numberOfAttempts + 1;
        if (this.mMidiUniqueCodes.contains(code) == true) goto L4;
        this.mMidiUniqueCodes.add(code);
        return code;
    }
}
