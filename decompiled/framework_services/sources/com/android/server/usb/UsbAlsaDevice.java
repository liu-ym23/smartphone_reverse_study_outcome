package com.android.server.usb;

import android.hardware.audio.common.V2_0.AudioDevice;
import android.media.AudioDeviceAttributes;
import android.media.IAudioService;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.audio.AudioService;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbAlsaDevice {
    protected static final boolean DEBUG = false;
    private static final String[] DIRECTION_STR = null;
    private static final int INPUT = 0;
    private static final int NUM_DIRECTIONS = 2;
    private static final int OUTPUT = 1;
    private static final String TAG = "UsbAlsaDevice";
    private final String mAlsaCardDeviceString;
    private IAudioService mAudioService;
    private final int mCardNum;
    private final String mDeviceAddress;
    private String mDeviceDescription;
    private String mDeviceName;
    private final int mDeviceNum;
    private final int[] mDeviceType;
    private final boolean[] mHasDevice;
    private boolean mHasJackDetect;
    private final boolean mIsDock;
    private final boolean[] mIsHeadset;
    private boolean[] mIsSelected;
    private UsbAlsaJackDetector mJackDetector;
    private int[] mState;

    private native void nativeSetVolume(int r1, float r2);

    static {
        DIRECTION_STR = new String[]{"INPUT", "OUTPUT"};
    }

    public UsbAlsaDevice(IAudioService audioService, int card, int device, String deviceAddress, boolean hasOutput, boolean hasInput, boolean isInputHeadset, boolean isOutputHeadset, boolean isDock) {
        this.mHasDevice = new boolean[2];
        this.mIsHeadset = new boolean[2];
        this.mDeviceType = new int[2];
        this.mIsSelected = new boolean[2];
        this.mState = new int[2];
        this.mDeviceName = "";
        this.mDeviceDescription = "";
        this.mHasJackDetect = true;
        this.mAudioService = audioService;
        this.mCardNum = card;
        this.mDeviceNum = device;
        this.mDeviceAddress = deviceAddress;
        this.mHasDevice[1] = hasOutput;
        this.mHasDevice[0] = hasInput;
        this.mIsHeadset[0] = isInputHeadset;
        this.mIsHeadset[1] = isOutputHeadset;
        this.mIsDock = isDock;
        initDeviceType();
        this.mAlsaCardDeviceString = getAlsaCardDeviceString();
    }

    public int getCardNum() {
        return this.mCardNum;
    }

    public int getDeviceNum() {
        return this.mDeviceNum;
    }

    public String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public String getAlsaCardDeviceString() {
        if (this.mCardNum >= 0) goto L5;
    L9:
        Slog.e(TAG, "Invalid alsa card or device alsaCard: " + this.mCardNum + " alsaDevice: " + this.mDeviceNum);
        return null;
    L5:
        if (this.mDeviceNum < 0) goto L9;
        return AudioService.makeAlsaAddressString(this.mCardNum, this.mDeviceNum);
    }

    public boolean hasOutput() {
        return this.mHasDevice[1];
    }

    public boolean hasInput() {
        return this.mHasDevice[0];
    }

    public boolean isOutputHeadset() {
        return this.mIsHeadset[1];
    }

    public boolean isInputHeadset() {
        return this.mIsHeadset[0];
    }

    public boolean isDock() {
        return this.mIsDock;
    }

    private synchronized boolean isInputJackConnected() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mJackDetector != null) goto L8;
        monitor-exit(this);
        return true;
    L8:
        boolean r0 = this.mJackDetector.isInputJackConnected();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    private synchronized boolean isOutputJackConnected() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mJackDetector != null) goto L8;
        monitor-exit(this);
        return true;
    L8:
        boolean r0 = this.mJackDetector.isOutputJackConnected();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    private synchronized void startJackDetect() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mJackDetector == null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mHasJackDetect == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.mJackDetector = UsbAlsaJackDetector.startJackDetect(this);     // Catch: Throwable -> L15
        if (this.mJackDetector != null) goto L17;
        this.mHasJackDetect = false;     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
    }

    private synchronized void stopJackDetect() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mJackDetector == null) goto L8;
        this.mJackDetector.pleaseStop();     // Catch: Throwable -> L6
    L8:
        this.mJackDetector = null;     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public synchronized void start() {
        monitor-enter(this);
        startOutput();     // Catch: Throwable -> L6
        startInput();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void startInput() {
        monitor-enter(this);
        startDevice(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void startOutput() {
        monitor-enter(this);
        startDevice(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startDevice(int direction) {
        if (this.mIsSelected[direction] == false) goto L5;
        return;
    L5:
        this.mIsSelected[direction] = true;
        this.mState[direction] = 0;
        startJackDetect();
        if (direction != 1) goto L8;
        nativeSetVolume(this.mCardNum, 1.0f);
    L8:
        updateWiredDeviceConnectionState(direction, true);
    }

    public synchronized void stop() {
        monitor-enter(this);
        stopOutput();     // Catch: Throwable -> L6
        stopInput();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void stopInput() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsSelected[0] == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mIsSelected[1] == true) goto L12;
        stopJackDetect();     // Catch: Throwable -> L10
    L12:
        updateInputWiredDeviceConnectionState(false);     // Catch: Throwable -> L10
        this.mIsSelected[0] = false;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized void stopOutput() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsSelected[1] == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mIsSelected[0] == true) goto L12;
        stopJackDetect();     // Catch: Throwable -> L10
    L12:
        updateOutputWiredDeviceConnectionState(false);     // Catch: Throwable -> L10
        this.mIsSelected[1] = false;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private void initDeviceType() {
        int[] r0 = this.mDeviceType;
        int r2 = 0;
        if (this.mHasDevice[0] == true) goto L5;
        int r1 = 0;
    L9:
        r0[0] = r1;
        int[] r3 = this.mDeviceType;
        if (this.mHasDevice[1] == true) goto L12;
    L19:
        r3[1] = r2;
        return;
    L12:
        if (this.mIsDock == false) goto L15;
        r2 = 4096;
        goto L19
    L15:
        if (this.mIsHeadset[1] == false) goto L17;
        r2 = 67108864;
        goto L19
    L17:
        r2 = 16384;
        goto L19
    L5:
        if (this.mIsHeadset[0] == false) goto L7;
        r1 = AudioDevice.IN_USB_HEADSET;
        goto L9
    L7:
        r1 = AudioDevice.IN_USB_DEVICE;
        goto L9
    }

    public int getOutputDeviceType() {
        return this.mDeviceType[1];
    }

    public int getInputDeviceType() {
        return this.mDeviceType[0];
    }

    private boolean updateWiredDeviceConnectionState(int direction, boolean enable) {
        if (this.mIsSelected[direction] == true) goto L7;
        Slog.e(TAG, "Updating wired device connection state on unselected device");
        return false;
    L7:
        if (this.mDeviceType[direction] != 0) goto L11;
        Slog.d(TAG, "Unable to set device connection state as " + DIRECTION_STR[direction] + " device type is none");
        return false;
    L11:
        if (this.mAlsaCardDeviceString != null) goto L14;
        Slog.w(TAG, "Failed to update " + DIRECTION_STR[direction] + " device connection state failed as alsa card device string is null");
        return false;
    L14:
        if (direction != 0) goto L16;
        boolean connected = isInputJackConnected();
    L17:
        Slog.i(TAG, DIRECTION_STR[direction] + " JACK connected: " + connected);
        if (enable == false) goto L21;
        if (connected == false) goto L21;
        int state = 1;
    L23:
        if (state == this.mState[direction]) goto L30;
        this.mState[direction] = state;
        AudioDeviceAttributes attributes = new AudioDeviceAttributes(this.mDeviceType[direction], this.mAlsaCardDeviceString, this.mDeviceName);
        this.mAudioService.setWiredDeviceConnectionState(attributes, state, TAG);     // Catch: RemoteException -> L27
    L28:
        Slog.e(TAG, "RemoteException in setWiredDeviceConnectionState for " + DIRECTION_STR[direction]);
        return false;
    L30:
        return true;
    L21:
        state = 0;
        goto L23
    L16:
        connected = isOutputJackConnected();
        goto L17
    }

    public synchronized boolean updateInputWiredDeviceConnectionState(boolean enable) {
        monitor-enter(this);
        boolean r0 = updateWiredDeviceConnectionState(0, enable);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean updateOutputWiredDeviceConnectionState(boolean enable) {
        monitor-enter(this);
        boolean r0 = updateWiredDeviceConnectionState(1, enable);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = "UsbAlsaDevice: [card: " + this.mCardNum + ", device: " + this.mDeviceNum + ", name: " + this.mDeviceName + ", hasOutput: " + this.mHasDevice[1] + ", hasInput: " + this.mHasDevice[0] + "]";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(DualDumpOutputStream dump, String idName, long id) {
        monitor-enter(this);
        long token = dump.start(idName, id);     // Catch: Throwable -> L6
        dump.write("card", 1120986464257L, this.mCardNum);     // Catch: Throwable -> L6
        dump.write("device", 1120986464258L, this.mDeviceNum);     // Catch: Throwable -> L6
        dump.write("name", 1138166333443L, this.mDeviceName);     // Catch: Throwable -> L6
        dump.write("has_output", 1133871366148L, this.mHasDevice[1]);     // Catch: Throwable -> L6
        dump.write("has_input", 1133871366149L, this.mHasDevice[0]);     // Catch: Throwable -> L6
        dump.write("address", 1138166333446L, this.mDeviceAddress);     // Catch: Throwable -> L6
        dump.end(token);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized String toShortString() {
        monitor-enter(this);
        String r0 = "[card:" + this.mCardNum + " device:" + this.mDeviceNum + " " + this.mDeviceName + "]";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized String getDeviceName() {
        monitor-enter(this);
        String r0 = this.mDeviceName;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setDeviceNameAndDescription(String deviceName, String deviceDescription) {
        monitor-enter(this);
        this.mDeviceName = deviceName;     // Catch: Throwable -> L6
        this.mDeviceDescription = deviceDescription;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof UsbAlsaDevice) == true) goto L5;
        return false;
    L5:
        UsbAlsaDevice other = (UsbAlsaDevice) obj;
        if (this.mCardNum == other.mCardNum) goto L8;
        return false;
    L8:
        if (this.mDeviceNum == other.mDeviceNum) goto L10;
        return false;
    L10:
        if (Arrays.equals(this.mHasDevice, other.mHasDevice) == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.mIsHeadset, other.mIsHeadset) == true) goto L14;
        return false;
    L14:
        if (this.mIsDock != other.mIsDock) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return (((((((((((((1 * 31) + this.mCardNum) * 31) + this.mDeviceNum) * 31) + (!this.mHasDevice[1] ? 1 : 0)) * 31) + (!this.mHasDevice[0] ? 1 : 0)) * 31) + (!this.mIsHeadset[0] ? 1 : 0)) * 31) + (!this.mIsHeadset[1] ? 1 : 0)) * 31) + (!this.mIsDock ? 1 : 0);
    }
}
