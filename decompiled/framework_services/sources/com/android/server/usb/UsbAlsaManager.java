package com.android.server.usb;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.usb.UsbDevice;
import android.media.AudioManager;
import android.media.IAudioService;
import android.os.Bundle;
import android.os.FileObserver;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.alsa.AlsaCardsParser;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.usb.descriptors.UsbDescriptorParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbAlsaManager {
    private static final int ALSA_DEVICE_TYPE_CAPTURE = 2;
    private static final int ALSA_DEVICE_TYPE_MIDI = 3;
    private static final int ALSA_DEVICE_TYPE_PLAYBACK = 1;
    private static final int ALSA_DEVICE_TYPE_UNKNOWN = 0;
    private static final String ALSA_DIRECTORY = "/dev/snd/";
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private static final int USB_DENYLIST_INPUT = 2;
    private static final int USB_DENYLIST_OUTPUT = 1;
    private static final int USB_PRODUCTID_PS4CONTROLLER_ZCT1 = 1476;
    private static final int USB_PRODUCTID_PS4CONTROLLER_ZCT2 = 2508;
    private static final int USB_PRODUCTID_PS5CONTROLLER = 3302;
    private static final int USB_VENDORID_SONY = 1356;
    private static boolean mIsSingleMode;
    static final List<DenyListEntry> sDeviceDenylist = null;
    private final HashSet<Integer> mAlsaCards;
    private final ArrayList<UsbAlsaDevice> mAlsaDevices;
    private final FileObserver mAlsaObserver;
    private HashMap<Integer, Stack<UsbAlsaDevice>> mAttachedDevices;
    private IAudioService mAudioService;
    private final AlsaCardsParser mCardsParser;
    private final Context mContext;
    private final boolean mHasMidiFeature;
    private final HashMap<String, UsbAlsaMidiDevice> mMidiDevices;
    private UsbAlsaMidiDevice mPeripheralMidiDevice;

    private static class DenyListEntry {
        final int mFlags;
        final int mProductId;
        final int mVendorId;

        DenyListEntry(int vendorId, int productId, int flags) {
            this.mVendorId = vendorId;
            this.mProductId = productId;
            this.mFlags = flags;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$malsaFileAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9148$$Nest$malsaFileAdded(UsbAlsaManager r0, String r1) {
        r0.alsaFileAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$malsaFileRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9149$$Nest$malsaFileRemoved(UsbAlsaManager r0, String r1) {
        r0.alsaFileRemoved(r1);
    }

    static {
        TAG = UsbAlsaManager.class.getSimpleName();
        mIsSingleMode = true;
        sDeviceDenylist = Arrays.asList(new DenyListEntry[]{new DenyListEntry(USB_VENDORID_SONY, USB_PRODUCTID_PS4CONTROLLER_ZCT1, 1), new DenyListEntry(USB_VENDORID_SONY, USB_PRODUCTID_PS4CONTROLLER_ZCT2, 1), new DenyListEntry(USB_VENDORID_SONY, USB_PRODUCTID_PS5CONTROLLER, 1)});
    }

    private static boolean isDeviceDenylisted(int vendorId, int productId, int flags) {
        Iterator<DenyListEntry> r0 = sDeviceDenylist.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        DenyListEntry entry = r0.next();
        if (entry.mVendorId != vendorId) goto L4;
        if (entry.mProductId != productId) goto L4;
        if ((entry.mFlags & flags) == 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        return false;
    }

    UsbAlsaManager(Context context) {
        this.mCardsParser = new AlsaCardsParser();
        this.mAlsaDevices = new ArrayList();
        this.mAttachedDevices = new HashMap();
        this.mMidiDevices = new HashMap();
        this.mPeripheralMidiDevice = null;
        this.mAlsaCards = new HashSet();
        final File r1 = new File(ALSA_DIRECTORY);
        final int r2 = 768;
        this.mAlsaObserver = new AnonymousClass1(this, r1, r2);
        this.mContext = context;
        this.mHasMidiFeature = context.getPackageManager().hasSystemFeature("android.software.midi");
    }

    public void systemReady() {
        this.mAudioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        this.mAlsaObserver.startWatching();
    }

    private synchronized void selectAlsaDevice(UsbAlsaDevice alsaDevice) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if ("true".equals(SystemProperties.get("vendor.audio.gaming.enabled", "false")) == false) goto L8;
        mIsSingleMode = false;     // Catch: Throwable -> L6
    L8:
        int isDisabled = Settings.Secure.getInt(this.mContext.getContentResolver(), "usb_audio_automatic_routing_disabled", 0);     // Catch: Throwable -> L6
        if (isDisabled == 0) goto L12;
        monitor-exit(this);
        return;
    L12:
        alsaDevice.start();     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    private synchronized void deselectAlsaDevice(UsbAlsaDevice selectedDevice) {
        monitor-enter(this);
        selectedDevice.stop();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private int getAlsaDeviceListIndexFor(String deviceAddress) {
        int index = 0;
    L4:
        if (index >= this.mAlsaDevices.size()) goto L9;
        if (this.mAlsaDevices.get(index).getDeviceAddress().equals(deviceAddress) == true) goto L7;
        index = index + 1;
        goto L4
    L7:
        return index;
    L9:
        return -1;
    }

    private void addDeviceToAttachedDevicesMap(int deviceType, UsbAlsaDevice device) {
        if (deviceType != 0) goto L5;
        Slog.i(TAG, "Ignore caching device as the type is NONE, device=" + device);
        return;
    L5:
        Stack<UsbAlsaDevice> devices = this.mAttachedDevices.get(Integer.valueOf(deviceType));
        if (devices != null) goto L8;
        this.mAttachedDevices.put(Integer.valueOf(deviceType), new Stack());
        devices = this.mAttachedDevices.get(Integer.valueOf(deviceType));
    L8:
        devices.push(device);
    }

    private void addAlsaDevice(UsbAlsaDevice device) {
        this.mAlsaDevices.add(0, device);
        addDeviceToAttachedDevicesMap(device.getInputDeviceType(), device);
        addDeviceToAttachedDevicesMap(device.getOutputDeviceType(), device);
    }

    private void removeDeviceFromAttachedDevicesMap(int deviceType, UsbAlsaDevice device) {
        Stack<UsbAlsaDevice> devices = this.mAttachedDevices.get(Integer.valueOf(deviceType));
        if (devices != null) goto L5;
        return;
    L5:
        devices.remove(device);
        if (devices.isEmpty() == false) goto L9;
        this.mAttachedDevices.remove(Integer.valueOf(deviceType));
        return;
    }

    private UsbAlsaDevice removeAlsaDevice(String deviceAddress) {
        int index = getAlsaDeviceListIndexFor(deviceAddress);
        if (index <= (-1)) goto L6;
        UsbAlsaDevice device = this.mAlsaDevices.remove(index);
        removeDeviceFromAttachedDevicesMap(device.getOutputDeviceType(), device);
        removeDeviceFromAttachedDevicesMap(device.getInputDeviceType(), device);
        return device;
    L6:
        return null;
    }

    private UsbAlsaDevice selectDefaultDevice(int deviceType) {
        Stack<UsbAlsaDevice> devices = this.mAttachedDevices.get(Integer.valueOf(deviceType));
        if (devices != null) goto L5;
        return null;
    L5:
        if (devices.isEmpty() == true) goto L14;
        UsbAlsaDevice alsaDevice = devices.peek();
        Slog.d(TAG, "select default device:" + alsaDevice);
        if (AudioManager.isInputDevice(deviceType) == false) goto L10;
        alsaDevice.startInput();
    L11:
        return alsaDevice;
    L10:
        alsaDevice.startOutput();
        goto L11
    L14:
        return null;
    }

    private void deselectCurrentDevice(int deviceType) {
        if (deviceType != 0) goto L4;
        return;
    L4:
        Stack<UsbAlsaDevice> devices = this.mAttachedDevices.get(Integer.valueOf(deviceType));
        if (devices != null) goto L7;
        return;
    L7:
        if (devices.isEmpty() == true) goto L16;
        UsbAlsaDevice alsaDevice = devices.peek();
        Slog.d(TAG, "deselect current device:" + alsaDevice);
        if (AudioManager.isInputDevice(deviceType) == false) goto L12;
        alsaDevice.stopInput();
        return;
    L12:
        alsaDevice.stopOutput();
        return;
    }

    void usbDeviceAdded(String deviceAddress, UsbDevice usbDevice, UsbDescriptorParser parser) {
        this.mCardsParser.scan();
        AlsaCardsParser.AlsaCardRecord cardRec = this.mCardsParser.findCardNumFor(deviceAddress);
        if (cardRec == null) goto L5;
        waitForAlsaDevice(cardRec.getCardNum(), true);
        if (parser.hasInput() == true) goto L11;
    L13:
        boolean hasInput = false;
    L15:
        if (parser.hasOutput() == true) goto L17;
    L19:
        boolean hasOutput = false;
    L21:
        if (hasInput == true) goto L23;
        if (hasOutput == true) goto L23;
    L34:
        addMidiDevice(deviceAddress, usbDevice, parser, cardRec);
        logDevices("deviceAdded()");
        return;
    L23:
        boolean isInputHeadset = parser.isInputHeadset();
        boolean isOutputHeadset = parser.isOutputHeadset();
        boolean isDock = parser.isDock();
        if (this.mAudioService != null) goto L27;
        Slog.e(TAG, "no AudioService");
        return;
    L27:
        UsbAlsaDevice alsaDevice = new UsbAlsaDevice(this.mAudioService, cardRec.getCardNum(), 0, deviceAddress, hasOutput, hasInput, isInputHeadset, isOutputHeadset, isDock);
        alsaDevice.setDeviceNameAndDescription(usbDevice.getProductName(), cardRec.getCardDescription());
        if (mIsSingleMode == false) goto L31;
        deselectCurrentDevice(alsaDevice.getInputDeviceType());
        deselectCurrentDevice(alsaDevice.getOutputDeviceType());
    L33:
        addAlsaDevice(alsaDevice);
        selectAlsaDevice(alsaDevice);
        goto L34
    L31:
        if (this.mAlsaDevices.isEmpty() == true) goto L33;
        deselectAlsaDevice(this.mAlsaDevices.get(0));
        goto L33
    L17:
        if (isDeviceDenylisted(usbDevice.getVendorId(), usbDevice.getProductId(), 1) == true) goto L19;
        hasOutput = true;
        goto L21
    L11:
        if (isDeviceDenylisted(usbDevice.getVendorId(), usbDevice.getProductId(), 2) == true) goto L13;
        hasInput = true;
        goto L15
    L5:
        if (parser.hasAudioInterface() == false) goto L36;
        Slog.e(TAG, "usbDeviceAdded(): cannot find sound card for " + deviceAddress);
        return;
    }

    private void addMidiDevice(String deviceAddress, UsbDevice usbDevice, UsbDescriptorParser parser, AlsaCardsParser.AlsaCardRecord cardRec) {
        boolean hasMidi = parser.hasMIDIInterface();
        boolean hasMidi2 = parser.containsUniversalMidiDeviceEndpoint();
        if (this.mHasMidiFeature == false) goto L22;
        if (hasMidi == false) goto L23;
        if (hasMidi2 == true) goto L24;
        Bundle properties = new Bundle();
        String manufacturer = usbDevice.getManufacturerName();
        String product = usbDevice.getProductName();
        String version = usbDevice.getVersion();
        if (manufacturer != null) goto L9;
    L17:
        String name = product;
    L18:
        properties.putString("name", name);
        properties.putString("manufacturer", manufacturer);
        properties.putString("product", product);
        properties.putString("version", version);
        properties.putString("serial_number", usbDevice.getSerialNumber());
        properties.putInt("alsa_card", cardRec.getCardNum());
        properties.putInt("alsa_device", 0);
        properties.putParcelable("usb_device", usbDevice);
        int numLegacyMidiInputs = parser.calculateNumLegacyMidiInputs();
        int numLegacyMidiOutputs = parser.calculateNumLegacyMidiOutputs();
        UsbAlsaMidiDevice midiDevice = UsbAlsaMidiDevice.create(this.mContext, properties, cardRec.getCardNum(), 0, numLegacyMidiInputs, numLegacyMidiOutputs);
        if (midiDevice == null) goto L25;
        this.mMidiDevices.put(deviceAddress, midiDevice);
        return;
    L25:
        return;
    L9:
        if (manufacturer.isEmpty() == true) goto L17;
        if (product != null) goto L13;
    L16:
        name = manufacturer;
        goto L18
    L13:
        if (product.isEmpty() == true) goto L16;
        name = manufacturer + " " + product;
        goto L18
    L24:
        return;
    L23:
        return;
    }

    synchronized void usbDeviceRemoved(String deviceAddress) {
        monitor-enter(this);
        UsbAlsaDevice alsaDevice = removeAlsaDevice(deviceAddress);     // Catch: Throwable -> L8
        Slog.i(TAG, "USB Audio Device Removed: " + alsaDevice);     // Catch: Throwable -> L8
        if (alsaDevice == null) goto L15;
        waitForAlsaDevice(alsaDevice.getCardNum(), false);     // Catch: Throwable -> L8
        deselectAlsaDevice(alsaDevice);     // Catch: Throwable -> L8
        if (mIsSingleMode == false) goto L11;
        selectDefaultDevice(alsaDevice.getOutputDeviceType());     // Catch: Throwable -> L8
        selectDefaultDevice(alsaDevice.getInputDeviceType());     // Catch: Throwable -> L8
        goto L15
    L11:
        if (this.mAlsaDevices.isEmpty() == true) goto L15;
        if (this.mAlsaDevices.get(0) == null) goto L15;
        selectAlsaDevice(this.mAlsaDevices.get(0));     // Catch: Throwable -> L8
    L15:
        UsbAlsaMidiDevice midiDevice = this.mMidiDevices.remove(deviceAddress);     // Catch: Throwable -> L8
        if (midiDevice == null) goto L18;
        Slog.i(TAG, "USB MIDI Device Removed: " + deviceAddress);     // Catch: Throwable -> L8
        IoUtils.closeQuietly(midiDevice);     // Catch: Throwable -> L8
    L18:
        logDevices("usbDeviceRemoved()");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setPeripheralMidiState(boolean enabled, int card, int device) {
        if (this.mHasMidiFeature == true) goto L5;
        return;
    L5:
        if (enabled == false) goto L11;
        if (this.mPeripheralMidiDevice != null) goto L11;
        Bundle properties = new Bundle();
        Resources r = this.mContext.getResources();
        properties.putString("name", r.getString(17042298));
        properties.putString("manufacturer", r.getString(17042297));
        properties.putString("product", r.getString(17042299));
        properties.putInt("alsa_card", card);
        properties.putInt("alsa_device", device);
        this.mPeripheralMidiDevice = UsbAlsaMidiDevice.create(this.mContext, properties, card, device, 1, 1);
        return;
    L11:
        if (enabled == false) goto L13;
        return;
    L13:
        if (this.mPeripheralMidiDevice == null) goto L18;
        IoUtils.closeQuietly(this.mPeripheralMidiDevice);
        this.mPeripheralMidiDevice = null;
        return;
    }

    private boolean waitForAlsaDevice(int card, boolean isAdded) {
        HashSet<Integer> r1 = this.mAlsaCards;
        monitor-enter(r1);
        long timeoutMs = SystemClock.elapsedRealtime() + 2500;     // Catch: Throwable -> L14
    L6:
        if ((this.mAlsaCards.contains(Integer.valueOf(card)) ^ isAdded) == false) goto L19;
        if (timeoutMs <= SystemClock.elapsedRealtime()) goto L19;
        long waitTimeMs = timeoutMs - SystemClock.elapsedRealtime();
        if (waitTimeMs <= 0) goto L6;
        this.mAlsaCards.wait(waitTimeMs);     // Catch: Throwable -> L14 InterruptedException -> L16
    L17:
        Slog.d(TAG, "usb: InterruptedException while waiting for ALSA file.");     // Catch: Throwable -> L14
    L19:
        boolean cardFound = this.mAlsaCards.contains(Integer.valueOf(card));     // Catch: Throwable -> L14
        if ((isAdded ^ cardFound) == true) goto L22;
    L24:
        Slog.i(TAG, "waitForAlsaDevice for device card=" + card + ", isAdded=" + isAdded + ", found=" + cardFound);     // Catch: Throwable -> L14
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return cardFound;
    L22:
        if (timeoutMs <= SystemClock.elapsedRealtime()) goto L24;
        Slog.e(TAG, "waitForAlsaDevice(" + card + ") timeout");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private int getCardNumberFromAlsaFilePath(String path) {
        int type = 0;
        if (path.startsWith("pcmC") == false) goto L11;
        if (path.endsWith("p") == false) goto L8;
        type = 1;
    L14:
        if (type != 0) goto L23;
        Slog.i(TAG, "Unknown type file(" + path + ") added.");
        return -1;
    L23:
        int c_index = path.indexOf(67);     // Catch: Exception -> L20
        int d_index = path.indexOf(68);     // Catch: Exception -> L20
        return Integer.parseInt(path.substring(c_index + 1, d_index));
    L20:
        e = move-exception;
        Slog.e(TAG, "Could not parse ALSA file name " + path, e);
        return -1;
    L8:
        if (path.endsWith("c") == false) goto L14;
        type = 2;
        goto L14
    L11:
        if (path.startsWith("midiC") == false) goto L14;
        type = 3;
        goto L14
    }

    private void alsaFileAdded(String path) {
        Slog.i(TAG, "alsaFileAdded(" + path + ")");
        int card = getCardNumberFromAlsaFilePath(path);
        if (card != (-1)) goto L5;
        return;
    L5:
        HashSet<Integer> r1 = this.mAlsaCards;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mAlsaCards.contains(Integer.valueOf(card)) == true) goto L12;
        Slog.d(TAG, "Adding ALSA device card=" + card);     // Catch: Throwable -> L10
        this.mAlsaCards.add(Integer.valueOf(card));     // Catch: Throwable -> L10
        this.mAlsaCards.notifyAll();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
    }

    private void alsaFileRemoved(String path) {
        int card = getCardNumberFromAlsaFilePath(path);
        if (card != (-1)) goto L5;
        return;
    L5:
        HashSet<Integer> r1 = this.mAlsaCards;
        monitor-enter(r1);
        this.mAlsaCards.remove(Integer.valueOf(card));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        dump.write("cards_parser", 1120986464257L, this.mCardsParser.getScanStatus());
        Iterator<UsbAlsaDevice> r2 = this.mAlsaDevices.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        UsbAlsaDevice usbAlsaDevice = r2.next();
        usbAlsaDevice.dump(dump, "alsa_devices", 2246267895810L);
        goto L4
    L6:
        Iterator<String> r3 = this.mMidiDevices.keySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String deviceAddr = r3.next();
        this.mMidiDevices.get(deviceAddr).dump(deviceAddr, dump, "alsa_midi_devices", 2246267895812L);
        goto L8
    L10:
        dump.end(token);
    }

    public void logDevicesList(String title) {
    }

    public void logDevices(String title) {
    }
}
