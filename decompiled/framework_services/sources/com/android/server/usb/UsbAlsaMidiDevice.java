package com.android.server.usb;

import android.content.Context;
import android.media.midi.MidiDeviceServer;
import android.media.midi.MidiManager;
import android.media.midi.MidiReceiver;
import android.os.Bundle;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import com.android.internal.midi.MidiEventScheduler;
import com.android.internal.util.dump.DualDumpOutputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbAlsaMidiDevice implements Closeable {
    private static final int BUFFER_SIZE = 512;
    private static final String TAG = "UsbAlsaMidiDevice";
    private final int mAlsaCard;
    private final int mAlsaDevice;
    private final MidiDeviceServer.Callback mCallback;
    private MidiEventScheduler[] mEventSchedulers;
    private FileDescriptor[] mFileDescriptors;
    private FileInputStream[] mInputStreams;
    private boolean mIsOpen;
    private final Object mLock;
    private final InputReceiverProxy[] mMidiInputPortReceivers;
    private final int mNumInputs;
    private final int mNumOutputs;
    private FileOutputStream[] mOutputStreams;
    private int mPipeFD;
    private StructPollfd[] mPollFDs;
    private PowerBoostSetter mPowerBoostSetter;
    private MidiDeviceServer mServer;
    private boolean mServerAvailable;

    private final class InputReceiverProxy extends MidiReceiver {
        private MidiReceiver mReceiver;

        /* synthetic */ InputReceiverProxy(UsbAlsaMidiDevice r1, UsbAlsaMidiDeviceIA r2) {
            this(r1);
        }

        private InputReceiverProxy(UsbAlsaMidiDevice r1) {
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

    /* JADX INFO: renamed from: -$$Nest$fgetmInputStreams, reason: not valid java name */
    static /* bridge */ /* synthetic */ FileInputStream[] m9150$$Nest$fgetmInputStreams(UsbAlsaMidiDevice r0) {
        return r0.mInputStreams;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsOpen, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9151$$Nest$fgetmIsOpen(UsbAlsaMidiDevice r0) {
        return r0.mIsOpen;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9152$$Nest$fgetmLock(UsbAlsaMidiDevice r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPollFDs, reason: not valid java name */
    static /* bridge */ /* synthetic */ StructPollfd[] m9153$$Nest$fgetmPollFDs(UsbAlsaMidiDevice r0) {
        return r0.mPollFDs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerBoostSetter, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerBoostSetter m9154$$Nest$fgetmPowerBoostSetter(UsbAlsaMidiDevice r0) {
        return r0.mPowerBoostSetter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServerAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9155$$Nest$fgetmServerAvailable(UsbAlsaMidiDevice r0) {
        return r0.mServerAvailable;
    }

    /* JADX INFO: renamed from: -$$Nest$mcloseLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9156$$Nest$mcloseLocked(UsbAlsaMidiDevice r0) {
        r0.closeLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mopenLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9157$$Nest$mopenLocked(UsbAlsaMidiDevice r0) {
        return r0.openLocked();
    }

    private native void nativeClose(FileDescriptor[] r1);

    private native FileDescriptor[] nativeOpen(int r1, int r2, int r3, int r4);

    public static UsbAlsaMidiDevice create(Context context, Bundle properties, int card, int device, int numInputs, int numOutputs) {
        UsbAlsaMidiDevice midiDevice = new UsbAlsaMidiDevice(card, device, numInputs, numOutputs);
        if (midiDevice.register(context, properties) == true) goto L6;
        IoUtils.closeQuietly(midiDevice);
        Log.e(TAG, "createDeviceServer failed");
        return null;
    L6:
        return midiDevice;
    }

    private UsbAlsaMidiDevice(int card, int device, int numInputs, int numOutputs) {
        this.mLock = new Object();
        this.mPipeFD = -1;
        UsbAlsaMidiDeviceIA r0 = null;
        this.mPowerBoostSetter = null;
        this.mCallback = new AnonymousClass1(this);
        this.mAlsaCard = card;
        this.mAlsaDevice = device;
        this.mNumInputs = numInputs;
        this.mNumOutputs = numOutputs;
        this.mMidiInputPortReceivers = new InputReceiverProxy[numOutputs];
        int port = 0;
    L3:
        if (port >= numOutputs) goto L5;
        this.mMidiInputPortReceivers[port] = new InputReceiverProxy(this, r0);
        port = port + 1;
        goto L3
    L5:
        this.mPowerBoostSetter = new PowerBoostSetter();
    }

    private boolean openLocked() {
        int inputStreamCount = this.mNumInputs;
        if (inputStreamCount <= 0) goto L5;
        inputStreamCount = inputStreamCount + 1;
    L5:
        int outputStreamCount = this.mNumOutputs;
        FileDescriptor[] fileDescriptors = nativeOpen(this.mAlsaCard, this.mAlsaDevice, inputStreamCount, outputStreamCount);
        if (fileDescriptors != null) goto L9;
        Log.e(TAG, "nativeOpen failed");
        return false;
    L9:
        this.mFileDescriptors = fileDescriptors;
        this.mPollFDs = new StructPollfd[inputStreamCount];
        this.mInputStreams = new FileInputStream[inputStreamCount];
        int i = 0;
    L10:
        if (i >= inputStreamCount) goto L12;
        FileDescriptor fd = fileDescriptors[i];
        StructPollfd pollfd = new StructPollfd();
        pollfd.fd = fd;
        pollfd.events = (short) OsConstants.POLLIN;
        this.mPollFDs[i] = pollfd;
        this.mInputStreams[i] = new FileInputStream(fd);
        i = i + 1;
        goto L10
    L12:
        this.mOutputStreams = new FileOutputStream[outputStreamCount];
        this.mEventSchedulers = new MidiEventScheduler[outputStreamCount];
        int i2 = 0;
    L13:
        if (i2 >= outputStreamCount) goto L15;
        this.mOutputStreams[i2] = new FileOutputStream(fileDescriptors[inputStreamCount + i2]);
        MidiEventScheduler scheduler = new MidiEventScheduler();
        this.mEventSchedulers[i2] = scheduler;
        this.mMidiInputPortReceivers[i2].setReceiver(scheduler.getReceiver());
        i2 = i2 + 1;
        goto L13
    L15:
        final MidiReceiver[] outputReceivers = this.mServer.getOutputPortReceivers();
        if (inputStreamCount <= 0) goto L18;
        final String r6 = "UsbAlsaMidiDevice input thread";
        new AnonymousClass2(this, r6, outputReceivers).start();
    L18:
        int port = 0;
    L19:
        if (port >= outputStreamCount) goto L21;
        final MidiEventScheduler eventSchedulerF = this.mEventSchedulers[port];
        final FileOutputStream outputStreamF = this.mOutputStreams[port];
        final int portF = port;
        final String r9 = "UsbAlsaMidiDevice output thread " + port;
        new AnonymousClass3(this, r9, eventSchedulerF, outputStreamF, portF).start();
        port = port + 1;
        goto L19
    L21:
        this.mIsOpen = true;
        return true;
    }

    private boolean register(Context context, Bundle properties) {
        MidiManager midiManager = (MidiManager) context.getSystemService(MidiManager.class);
        if (midiManager != null) goto L6;
        Log.e(TAG, "No MidiManager in UsbAlsaMidiDevice.register()");
        return false;
    L6:
        this.mServerAvailable = true;
        this.mServer = midiManager.createDeviceServer(this.mMidiInputPortReceivers, this.mNumInputs, null, null, properties, 1, -1, this.mCallback);
        if (this.mServer != null) goto L9;
        return false;
    L9:
        return true;
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
        int i = 0;
    L4:
        if (i >= this.mEventSchedulers.length) goto L6;
        this.mMidiInputPortReceivers[i].setReceiver(null);
        this.mEventSchedulers[i].close();
        i = i + 1;
        goto L4
    L6:
        this.mEventSchedulers = null;
        int i2 = 0;
    L8:
        if (i2 >= this.mInputStreams.length) goto L10;
        IoUtils.closeQuietly(this.mInputStreams[i2]);
        i2 = i2 + 1;
        goto L8
    L10:
        this.mInputStreams = null;
        int i3 = 0;
    L12:
        if (i3 >= this.mOutputStreams.length) goto L14;
        IoUtils.closeQuietly(this.mOutputStreams[i3]);
        i3 = i3 + 1;
        goto L12
    L14:
        this.mOutputStreams = null;
        nativeClose(this.mFileDescriptors);
        this.mFileDescriptors = null;
        this.mIsOpen = false;
    }

    public void dump(String deviceAddr, DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        dump.write("device_address", 1138166333443L, deviceAddr);
        dump.write("card", 1120986464257L, this.mAlsaCard);
        dump.write("device", 1120986464258L, this.mAlsaDevice);
        dump.end(token);
    }
}
