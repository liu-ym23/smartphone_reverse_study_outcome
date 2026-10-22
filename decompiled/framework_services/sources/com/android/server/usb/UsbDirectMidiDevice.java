package com.android.server.usb;

import android.content.Context;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.midi.MidiDeviceServer;
import android.media.midi.MidiManager;
import android.media.midi.MidiReceiver;
import android.os.Bundle;
import android.util.Log;
import com.android.internal.midi.MidiEventMultiScheduler;
import com.android.internal.midi.MidiEventScheduler;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.usb.descriptors.UsbACMidi10Endpoint;
import com.android.server.usb.descriptors.UsbDescriptor;
import com.android.server.usb.descriptors.UsbDescriptorParser;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import com.android.server.usb.descriptors.UsbInterfaceDescriptor;
import com.android.server.usb.descriptors.UsbMidiBlockParser;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDirectMidiDevice implements Closeable {
    private static final int BULK_TRANSFER_NUMBER_OF_RETRIES = 20;
    private static final int BULK_TRANSFER_TIMEOUT_MILLISECONDS = 50;
    private static final boolean DEBUG = true;
    private static final byte MESSAGE_TYPE_MIDI_1_CHANNEL_VOICE = 2;
    private static final byte MESSAGE_TYPE_MIDI_2_CHANNEL_VOICE = 4;
    private static final String TAG = "UsbDirectMidiDevice";
    private static final int THREAD_JOIN_TIMEOUT_MILLISECONDS = 200;
    private final MidiDeviceServer.Callback mCallback;
    private Context mContext;
    private int mDefaultMidiProtocol;
    private ArrayList<ArrayList<Integer>> mInputUsbEndpointCableCounts;
    private ArrayList<ArrayList<UsbEndpoint>> mInputUsbEndpoints;
    private boolean mIsOpen;
    private final boolean mIsUniversalMidiDevice;
    private final Object mLock;
    private UsbMidiBlockParser mMidiBlockParser;
    private ArrayList<ArrayList<MidiEventMultiScheduler>> mMidiEventMultiSchedulers;
    private final InputReceiverProxy[] mMidiInputPortReceivers;
    private String mName;
    private final int mNumInputs;
    private final int mNumOutputs;
    private ArrayList<ArrayList<Integer>> mOutputUsbEndpointCableCounts;
    private ArrayList<ArrayList<UsbEndpoint>> mOutputUsbEndpoints;
    private UsbDescriptorParser mParser;
    private PowerBoostSetter mPowerBoostSetter;
    private MidiDeviceServer mServer;
    private boolean mServerAvailable;
    private final boolean mShouldCallSetInterface;
    private ArrayList<Thread> mThreads;
    private final String mUniqueUsbDeviceIdentifier;
    private UsbDevice mUsbDevice;
    private ArrayList<UsbDeviceConnection> mUsbDeviceConnections;
    private ArrayList<UsbInterfaceDescriptor> mUsbInterfaces;

    private static final class InputReceiverProxy extends MidiReceiver {
        private MidiReceiver mReceiver;

        /* synthetic */ InputReceiverProxy(UsbDirectMidiDeviceIA r1) {
            this();
        }

        private InputReceiverProxy() {
        }

        @Override // android.media.midi.MidiReceiver
        public void onSend(byte[] msg, int offset, int count, long timestamp) throws IOException {
            MidiReceiver receiver = this.mReceiver;
            if (receiver == null) goto L6;
            receiver.send(msg, offset, count, timestamp);
            return;
        }

        public void setReceiver(MidiReceiver receiver) {
            this.mReceiver = receiver;
        }

        @Override // android.media.midi.MidiReceiver
        public void onFlush() throws IOException {
            MidiReceiver receiver = this.mReceiver;
            if (receiver == null) goto L6;
            receiver.flush();
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsOpen, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9175$$Nest$fgetmIsOpen(UsbDirectMidiDevice r0) {
        return r0.mIsOpen;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsUniversalMidiDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9176$$Nest$fgetmIsUniversalMidiDevice(UsbDirectMidiDevice r0) {
        return r0.mIsUniversalMidiDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9177$$Nest$fgetmLock(UsbDirectMidiDevice r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerBoostSetter, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerBoostSetter m9178$$Nest$fgetmPowerBoostSetter(UsbDirectMidiDevice r0) {
        return r0.mPowerBoostSetter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServerAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9179$$Nest$fgetmServerAvailable(UsbDirectMidiDevice r0) {
        return r0.mServerAvailable;
    }

    /* JADX INFO: renamed from: -$$Nest$mcloseLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9180$$Nest$mcloseLocked(UsbDirectMidiDevice r0) {
        r0.closeLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$misChannelVoiceMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9181$$Nest$misChannelVoiceMessage(UsbDirectMidiDevice r0, byte[] r1) {
        return r0.isChannelVoiceMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mopenLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9182$$Nest$mopenLocked(UsbDirectMidiDevice r0) {
        return r0.openLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mswapEndiannessPerWord, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m9183$$Nest$mswapEndiannessPerWord(UsbDirectMidiDevice r0, byte[] r1, int r2) {
        return r0.swapEndiannessPerWord(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smlogByteArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9184$$Nest$smlogByteArray(String r0, byte[] r1, int r2, int r3) {
        logByteArray(r0, r1, r2, r3);
    }

    public static UsbDirectMidiDevice create(Context context, UsbDevice usbDevice, UsbDescriptorParser parser, boolean isUniversalMidiDevice, String uniqueUsbDeviceIdentifier) {
        UsbDirectMidiDevice midiDevice = new UsbDirectMidiDevice(usbDevice, parser, isUniversalMidiDevice, uniqueUsbDeviceIdentifier);
        if (midiDevice.register(context) == true) goto L6;
        IoUtils.closeQuietly(midiDevice);
        Log.e(TAG, "createDeviceServer failed");
        return null;
    L6:
        return midiDevice;
    }

    private UsbDirectMidiDevice(UsbDevice usbDevice, UsbDescriptorParser parser, boolean isUniversalMidiDevice, String uniqueUsbDeviceIdentifier) {
        this.mMidiBlockParser = new UsbMidiBlockParser();
        this.mDefaultMidiProtocol = 1;
        this.mLock = new Object();
        UsbDirectMidiDeviceIA r1 = null;
        this.mPowerBoostSetter = null;
        this.mCallback = new AnonymousClass1(this);
        this.mUsbDevice = usbDevice;
        this.mParser = parser;
        this.mUniqueUsbDeviceIdentifier = uniqueUsbDeviceIdentifier;
        this.mIsUniversalMidiDevice = isUniversalMidiDevice;
        if (parser.calculateMidiInterfaceDescriptorsCount() <= 1) goto L5;
        boolean r2 = true;
    L6:
        this.mShouldCallSetInterface = r2;
        if (isUniversalMidiDevice == false) goto L9;
        ArrayList<UsbInterfaceDescriptor> midiInterfaceDescriptors = parser.findUniversalMidiInterfaceDescriptors();
    L10:
        this.mUsbInterfaces = new ArrayList();
        if (this.mUsbDevice.getConfigurationCount() <= 0) goto L26;
        UsbConfiguration usbConfiguration = this.mUsbDevice.getConfiguration(0);
        int interfaceIndex = 0;
    L14:
        if (interfaceIndex >= usbConfiguration.getInterfaceCount()) goto L24;
        UsbInterface usbInterface = usbConfiguration.getInterface(interfaceIndex);
        Iterator<UsbInterfaceDescriptor> r7 = midiInterfaceDescriptors.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        UsbInterfaceDescriptor midiInterfaceDescriptor = r7.next();
        UsbInterface midiInterface = midiInterfaceDescriptor.toAndroid(this.mParser);
        if (areEquivalent(usbInterface, midiInterface) == false) goto L17;
        this.mUsbInterfaces.add(midiInterfaceDescriptor);
    L22:
        interfaceIndex = interfaceIndex + 1;
        goto L14
    L24:
        if (this.mUsbDevice.getConfigurationCount() <= 1) goto L26;
        Log.w(TAG, "Skipping some USB configurations. Count: " + this.mUsbDevice.getConfigurationCount());
    L26:
        int numInputs = 0;
        int numOutputs = 0;
        int interfaceIndex2 = 0;
    L28:
        if (interfaceIndex2 >= this.mUsbInterfaces.size()) goto L38;
        UsbInterfaceDescriptor interfaceDescriptor = this.mUsbInterfaces.get(interfaceIndex2);
        int endpointIndex = 0;
    L31:
        if (endpointIndex >= interfaceDescriptor.getNumEndpoints()) goto L37;
        UsbEndpointDescriptor endpoint = interfaceDescriptor.getEndpointDescriptor(endpointIndex);
        if (endpoint.getDirection() != 0) goto L35;
        numOutputs = numOutputs + getNumJacks(endpoint);
    L36:
        endpointIndex = endpointIndex + 1;
        goto L31
    L35:
        numInputs = numInputs + getNumJacks(endpoint);
        goto L36
    L37:
        interfaceIndex2 = interfaceIndex2 + 1;
        goto L28
    L38:
        this.mNumInputs = numInputs;
        this.mNumOutputs = numOutputs;
        Log.d(TAG, "Created UsbDirectMidiDevice with " + numInputs + " inputs and " + numOutputs + " outputs. isUniversalMidiDevice: " + isUniversalMidiDevice);
        this.mMidiInputPortReceivers = new InputReceiverProxy[numOutputs];
        int port = 0;
    L39:
        if (port >= numOutputs) goto L41;
        this.mMidiInputPortReceivers[port] = new InputReceiverProxy(r1);
        port = port + 1;
        goto L39
    L41:
        this.mPowerBoostSetter = new PowerBoostSetter();
        return;
    L9:
        midiInterfaceDescriptors = parser.findLegacyMidiInterfaceDescriptors();
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private int calculateDefaultMidiProtocol() {
        UsbManager manager = (UsbManager) this.mContext.getSystemService(UsbManager.class);
        int interfaceIndex = 0;
    L4:
        if (interfaceIndex >= this.mUsbInterfaces.size()) goto L24;
        UsbInterfaceDescriptor interfaceDescriptor = this.mUsbInterfaces.get(interfaceIndex);
        boolean doesInterfaceContainInput = false;
        boolean doesInterfaceContainOutput = false;
        int endpointIndex = 0;
    L7:
        if (endpointIndex >= interfaceDescriptor.getNumEndpoints()) goto L16;
        if (doesInterfaceContainInput == false) goto L11;
        if (doesInterfaceContainOutput == true) goto L16;
    L11:
        UsbEndpointDescriptor endpoint = interfaceDescriptor.getEndpointDescriptor(endpointIndex);
        if (endpoint.getDirection() != 0) goto L14;
        doesInterfaceContainOutput = true;
    L15:
        endpointIndex = endpointIndex + 1;
        goto L7
    L14:
        doesInterfaceContainInput = true;
    L16:
        if (doesInterfaceContainInput == false) goto L23;
        if (doesInterfaceContainOutput == false) goto L23;
        UsbDeviceConnection connection = manager.openDevice(this.mUsbDevice);
        UsbInterface usbInterface = interfaceDescriptor.toAndroid(this.mParser);
        if (updateUsbInterface(usbInterface, connection) == false) goto L23;
        int defaultMidiProtocol = this.mMidiBlockParser.calculateMidiType(connection, interfaceDescriptor.getInterfaceNumber(), interfaceDescriptor.getAlternateSetting());
        connection.close();
        return defaultMidiProtocol;
    L23:
        interfaceIndex = interfaceIndex + 1;
        goto L4
    L24:
        Log.w(TAG, "Cannot find interface with both input and output endpoints");
        return 1;
    }

    private boolean openLocked() {
        Log.d(TAG, "openLocked()");
        UsbManager manager = (UsbManager) this.mContext.getSystemService(UsbManager.class);
        this.mUsbDeviceConnections = new ArrayList();
        this.mInputUsbEndpoints = new ArrayList();
        this.mOutputUsbEndpoints = new ArrayList();
        this.mInputUsbEndpointCableCounts = new ArrayList();
        this.mOutputUsbEndpointCableCounts = new ArrayList();
        this.mMidiEventMultiSchedulers = new ArrayList();
        this.mThreads = new ArrayList();
        int interfaceIndex = 0;
    L4:
        if (interfaceIndex >= this.mUsbInterfaces.size()) goto L22;
        ArrayList<UsbEndpoint> inputEndpoints = new ArrayList();
        ArrayList<UsbEndpoint> outputEndpoints = new ArrayList();
        ArrayList<Integer> inputEndpointCableCounts = new ArrayList();
        ArrayList<Integer> outputEndpointCableCounts = new ArrayList();
        ArrayList<MidiEventMultiScheduler> midiEventMultiSchedulers = new ArrayList();
        UsbInterfaceDescriptor interfaceDescriptor = this.mUsbInterfaces.get(interfaceIndex);
        int endpointIndex = 0;
    L7:
        if (endpointIndex >= interfaceDescriptor.getNumEndpoints()) goto L14;
        UsbEndpointDescriptor endpoint = interfaceDescriptor.getEndpointDescriptor(endpointIndex);
        if (endpoint.getDirection() != 0) goto L11;
        outputEndpoints.add(endpoint.toAndroid(this.mParser));
        outputEndpointCableCounts.add(Integer.valueOf(getNumJacks(endpoint)));
        MidiEventMultiScheduler scheduler = new MidiEventMultiScheduler(getNumJacks(endpoint));
        midiEventMultiSchedulers.add(scheduler);
    L12:
        endpointIndex = endpointIndex + 1;
        goto L7
    L11:
        inputEndpoints.add(endpoint.toAndroid(this.mParser));
        inputEndpointCableCounts.add(Integer.valueOf(getNumJacks(endpoint)));
        goto L12
    L14:
        if (outputEndpoints.isEmpty() == true) goto L16;
    L17:
        UsbDeviceConnection connection = manager.openDevice(this.mUsbDevice);
        UsbInterface usbInterface = interfaceDescriptor.toAndroid(this.mParser);
        if (updateUsbInterface(usbInterface, connection) == false) goto L21;
        this.mUsbDeviceConnections.add(connection);
        this.mInputUsbEndpoints.add(inputEndpoints);
        this.mOutputUsbEndpoints.add(outputEndpoints);
        this.mInputUsbEndpointCableCounts.add(inputEndpointCableCounts);
        this.mOutputUsbEndpointCableCounts.add(outputEndpointCableCounts);
        this.mMidiEventMultiSchedulers.add(midiEventMultiSchedulers);
    L21:
        interfaceIndex = interfaceIndex + 1;
        goto L4
    L16:
        if (inputEndpoints.isEmpty() == true) goto L21;
    L22:
        int connectionIndex = 0;
        int outputIndex = 0;
    L24:
        if (connectionIndex >= this.mMidiEventMultiSchedulers.size()) goto L33;
        int endpointIndex2 = 0;
    L27:
        if (endpointIndex2 >= this.mMidiEventMultiSchedulers.get(connectionIndex).size()) goto L32;
        int cableCount = this.mOutputUsbEndpointCableCounts.get(connectionIndex).get(endpointIndex2).intValue();
        MidiEventMultiScheduler multiScheduler = this.mMidiEventMultiSchedulers.get(connectionIndex).get(endpointIndex2);
        int cableNumber = 0;
    L29:
        if (cableNumber >= cableCount) goto L31;
        MidiEventScheduler scheduler2 = multiScheduler.getEventScheduler(cableNumber);
        this.mMidiInputPortReceivers[outputIndex].setReceiver(scheduler2.getReceiver());
        outputIndex = outputIndex + 1;
        cableNumber = cableNumber + 1;
        goto L29
    L31:
        endpointIndex2 = endpointIndex2 + 1;
        goto L27
    L32:
        connectionIndex = connectionIndex + 1;
        goto L24
    L33:
        final MidiReceiver[] outputReceivers = this.mServer.getOutputPortReceivers();
        int portStartNumber = 0;
        int connectionIndex2 = 0;
    L35:
        if (connectionIndex2 >= this.mInputUsbEndpoints.size()) goto L41;
        int portStartNumber2 = portStartNumber;
        int endpointIndex3 = 0;
    L38:
        if (endpointIndex3 >= this.mInputUsbEndpoints.get(connectionIndex2).size()) goto L40;
        final UsbDeviceConnection connectionFinal = this.mUsbDeviceConnections.get(connectionIndex2);
        final UsbEndpoint endpointFinal = this.mInputUsbEndpoints.get(connectionIndex2).get(endpointIndex3);
        final int portStartFinal = portStartNumber2;
        final int cableCountFinal = this.mInputUsbEndpointCableCounts.get(connectionIndex2).get(endpointIndex3).intValue();
        final String r2 = "UsbDirectMidiDevice input thread " + portStartFinal;
        Thread newThread = new AnonymousClass2(this, r2, cableCountFinal, connectionFinal, endpointFinal, outputReceivers, portStartFinal);
        newThread.start();
        this.mThreads.add(newThread);
        portStartNumber2 = portStartNumber2 + cableCountFinal;
        endpointIndex3 = endpointIndex3 + 1;
        outputReceivers = outputReceivers;
        goto L38
    L40:
        connectionIndex2 = connectionIndex2 + 1;
        portStartNumber = portStartNumber2;
        goto L35
    L41:
        int portStartNumber3 = 0;
        int connectionIndex3 = 0;
    L43:
        if (connectionIndex3 >= this.mOutputUsbEndpoints.size()) goto L49;
        int portStartNumber4 = portStartNumber3;
        int endpointIndex4 = 0;
    L46:
        if (endpointIndex4 >= this.mOutputUsbEndpoints.get(connectionIndex3).size()) goto L48;
        final UsbDeviceConnection connectionFinal2 = this.mUsbDeviceConnections.get(connectionIndex3);
        final UsbEndpoint endpointFinal2 = this.mOutputUsbEndpoints.get(connectionIndex3).get(endpointIndex4);
        final int cableCountFinal2 = this.mOutputUsbEndpointCableCounts.get(connectionIndex3).get(endpointIndex4).intValue();
        final MidiEventMultiScheduler multiSchedulerFinal = this.mMidiEventMultiSchedulers.get(connectionIndex3).get(endpointIndex4);
        final String r3 = "UsbDirectMidiDevice output write thread " + portStartNumber4;
        Thread newThread2 = new AnonymousClass3(this, r3, cableCountFinal2, multiSchedulerFinal, endpointFinal2, connectionFinal2);
        newThread2.start();
        this.mThreads.add(newThread2);
        portStartNumber4 = portStartNumber4 + cableCountFinal2;
        endpointIndex4 = endpointIndex4 + 1;
        goto L46
    L48:
        connectionIndex3 = connectionIndex3 + 1;
        portStartNumber3 = portStartNumber4;
        goto L43
    L49:
        this.mIsOpen = true;
        return true;
    }

    private boolean register(Context context) {
        this.mContext = context;
        MidiManager midiManager = (MidiManager) context.getSystemService(MidiManager.class);
        if (midiManager != null) goto L7;
        Log.e(TAG, "No MidiManager in UsbDirectMidiDevice.register()");
        return false;
    L7:
        if (this.mIsUniversalMidiDevice == false) goto L9;
        this.mDefaultMidiProtocol = calculateDefaultMidiProtocol();
    L10:
        Bundle properties = new Bundle();
        String manufacturer = this.mUsbDevice.getManufacturerName();
        String product = this.mUsbDevice.getProductName();
        String version = this.mUsbDevice.getVersion();
        if (manufacturer != null) goto L13;
    L21:
        String name = product;
    L22:
        String name2 = name + "#" + this.mUniqueUsbDeviceIdentifier;
        if (this.mIsUniversalMidiDevice == false) goto L25;
        String name3 = name2 + " MIDI 2.0";
    L26:
        this.mName = name3;
        properties.putString("name", name3);
        properties.putString("manufacturer", manufacturer);
        properties.putString("product", product);
        properties.putString("version", version);
        properties.putString("serial_number", this.mUsbDevice.getSerialNumber());
        properties.putParcelable("usb_device", this.mUsbDevice);
        this.mServerAvailable = true;
        this.mServer = midiManager.createDeviceServer(this.mMidiInputPortReceivers, this.mNumInputs, null, null, properties, 1, this.mDefaultMidiProtocol, this.mCallback);
        if (this.mServer != null) goto L29;
        return false;
    L29:
        return true;
    L25:
        name3 = name2 + " MIDI 1.0";
        goto L26
    L13:
        if (manufacturer.isEmpty() == true) goto L21;
        if (product != null) goto L17;
    L20:
        name = manufacturer;
        goto L22
    L17:
        if (product.isEmpty() == true) goto L20;
        name = manufacturer + " " + product;
        goto L22
    L9:
        this.mDefaultMidiProtocol = -1;
        goto L10
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsOpen == false) goto L9;
        closeLocked();     // Catch: Throwable -> L7
    L9:
        this.mServerAvailable = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (this.mServer == null) goto L19;
        IoUtils.closeQuietly(this.mServer);
        return;
    }

    private void closeLocked() {
        Log.d(TAG, "closeLocked()");
        Iterator<Thread> r0 = this.mThreads.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Thread thread = r0.next();
        if (thread == null) goto L4;
        thread.interrupt();
        goto L4
    L9:
        Iterator<Thread> r1 = this.mThreads.iterator();
    L11:
        if (r1.hasNext() == false) goto L20;
        Thread thread2 = r1.next();
        if (thread2 == null) goto L11;
        thread2.join(200);     // Catch: InterruptedException -> L17
    L18:
        Log.w(TAG, "thread join interrupted");
    L20:
        this.mThreads = null;
        int i = 0;
    L22:
        if (i >= this.mMidiInputPortReceivers.length) goto L24;
        this.mMidiInputPortReceivers[i].setReceiver(null);
        i = i + 1;
        goto L22
    L24:
        int connectionIndex = 0;
    L26:
        if (connectionIndex >= this.mMidiEventMultiSchedulers.size()) goto L32;
        int endpointIndex = 0;
    L29:
        if (endpointIndex >= this.mMidiEventMultiSchedulers.get(connectionIndex).size()) goto L31;
        MidiEventMultiScheduler multiScheduler = this.mMidiEventMultiSchedulers.get(connectionIndex).get(endpointIndex);
        multiScheduler.close();
        endpointIndex = endpointIndex + 1;
        goto L29
    L31:
        connectionIndex = connectionIndex + 1;
        goto L26
    L32:
        this.mMidiEventMultiSchedulers = null;
        Iterator<UsbDeviceConnection> r2 = this.mUsbDeviceConnections.iterator();
    L34:
        if (r2.hasNext() == false) goto L36;
        UsbDeviceConnection connection = r2.next();
        connection.close();
        goto L34
    L36:
        this.mUsbDeviceConnections = null;
        this.mInputUsbEndpoints = null;
        this.mOutputUsbEndpoints = null;
        this.mInputUsbEndpointCableCounts = null;
        this.mOutputUsbEndpointCableCounts = null;
        this.mIsOpen = false;
    }

    private byte[] swapEndiannessPerWord(byte[] inputArray, int size) {
        int numberOfExcessBytes = size & 3;
        if (numberOfExcessBytes == 0) goto L5;
        Log.e(TAG, "size not multiple of 4: " + size);
    L5:
        byte[] outputArray = new byte[size - numberOfExcessBytes];
        int i = 0;
    L7:
        if ((i + 3) >= size) goto L10;
        outputArray[i] = inputArray[i + 3];
        outputArray[i + 1] = inputArray[i + 2];
        outputArray[i + 2] = inputArray[i + 1];
        outputArray[i + 3] = inputArray[i];
        i = i + 4;
        goto L7
    L10:
        return outputArray;
    }

    private static void logByteArray(String prefix, byte[] value, int offset, int count) {
        StringBuilder builder = new StringBuilder(prefix);
        int i = offset;
    L4:
        if (i >= (offset + count)) goto L9;
        builder.append(String.format("0x%02X", new Object[]{Byte.valueOf(value[i])}));
        if (i == (value.length - 1)) goto L8;
        builder.append(", ");
    L8:
        i = i + 1;
        goto L4
    L9:
        Log.d(TAG, builder.toString());
    }

    private boolean updateUsbInterface(UsbInterface usbInterface, UsbDeviceConnection connection) {
        if (usbInterface != null) goto L6;
        Log.e(TAG, "Usb Interface is null");
        return false;
    L6:
        if (connection != null) goto L10;
        Log.e(TAG, "UsbDeviceConnection is null");
        return false;
    L10:
        if (connection.claimInterface(usbInterface, true) == true) goto L14;
        Log.e(TAG, "Can't claim interface");
        return false;
    L14:
        if (this.mShouldCallSetInterface == true) goto L16;
        Log.w(TAG, "no alternate interface");
    L19:
        return true;
    L16:
        if (connection.setInterface(usbInterface) == true) goto L19;
        Log.w(TAG, "Can't set interface");
        goto L19
    }

    private boolean areEquivalent(UsbInterface interface1, UsbInterface interface2) {
        if (interface1.getId() == interface2.getId()) goto L5;
    L39:
        return false;
    L5:
        if (interface1.getAlternateSetting() != interface2.getAlternateSetting()) goto L39;
        if (interface1.getInterfaceClass() != interface2.getInterfaceClass()) goto L39;
        if (interface1.getInterfaceSubclass() != interface2.getInterfaceSubclass()) goto L39;
        if (interface1.getInterfaceProtocol() != interface2.getInterfaceProtocol()) goto L39;
        if (interface1.getEndpointCount() != interface2.getEndpointCount()) goto L39;
        if (interface1.getName() != null) goto L21;
        if (interface2.getName() == null) goto L23;
        return false;
    L23:
        int i = 0;
    L25:
        if (i >= interface1.getEndpointCount()) goto L37;
        UsbEndpoint endpoint1 = interface1.getEndpoint(i);
        UsbEndpoint endpoint2 = interface2.getEndpoint(i);
        if (endpoint1.getAddress() != endpoint2.getAddress()) goto L36;
        if (endpoint1.getAttributes() != endpoint2.getAttributes()) goto L36;
        if (endpoint1.getMaxPacketSize() != endpoint2.getMaxPacketSize()) goto L36;
        if (endpoint1.getInterval() != endpoint2.getInterval()) goto L36;
        i = i + 1;
    L36:
        return false;
    L37:
        return true;
    L21:
        if (interface1.getName().equals(interface2.getName()) == true) goto L23;
        return false;
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        dump.write("num_inputs", 1120986464257L, this.mNumInputs);
        dump.write("num_outputs", 1120986464258L, this.mNumOutputs);
        dump.write("is_universal", 1133871366147L, this.mIsUniversalMidiDevice);
        dump.write("name", 1138166333444L, this.mName);
        if (this.mIsUniversalMidiDevice == false) goto L5;
        this.mMidiBlockParser.dump(dump, "block_parser", 1146756268037L);
    L5:
        dump.end(token);
    }

    private boolean isChannelVoiceMessage(byte[] umpMessage) {
        byte messageType = (byte) ((umpMessage[0] >> 4) & 15);
        if (messageType == 2) goto L5;
        if (messageType == 4) goto L5;
        return false;
    L5:
        return true;
    }

    private int getNumJacks(UsbEndpointDescriptor usbEndpointDescriptor) {
        UsbDescriptor classSpecificEndpointDescriptor = usbEndpointDescriptor.getClassSpecificEndpointDescriptor();
        if (classSpecificEndpointDescriptor != null) goto L5;
        return 1;
    L5:
        if ((classSpecificEndpointDescriptor instanceof UsbACMidi10Endpoint) == false) goto L10;
        UsbACMidi10Endpoint midiEndpoint = (UsbACMidi10Endpoint) classSpecificEndpointDescriptor;
        return midiEndpoint.getNumJacks();
    L10:
        return 1;
    }
}
