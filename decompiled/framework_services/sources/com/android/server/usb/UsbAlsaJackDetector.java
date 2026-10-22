package com.android.server.usb;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbAlsaJackDetector implements Runnable {
    private static final String TAG = "UsbAlsaJackDetector";
    private UsbAlsaDevice mAlsaDevice;
    private boolean mStopJackDetect;

    private static native boolean nativeHasJackDetect(int r0);

    private native boolean nativeInputJackConnected(int r1);

    private native boolean nativeJackDetect(int r1);

    private native boolean nativeOutputJackConnected(int r1);

    private UsbAlsaJackDetector(UsbAlsaDevice device) {
        this.mStopJackDetect = false;
        this.mAlsaDevice = device;
    }

    public static UsbAlsaJackDetector startJackDetect(UsbAlsaDevice device) {
        if (nativeHasJackDetect(device.getCardNum()) == true) goto L6;
        return null;
    L6:
        UsbAlsaJackDetector jackDetector = new UsbAlsaJackDetector(device);
        new Thread(jackDetector, "USB jack detect thread").start();
        return jackDetector;
    }

    public boolean isInputJackConnected() {
        return nativeInputJackConnected(this.mAlsaDevice.getCardNum());
    }

    public boolean isOutputJackConnected() {
        return nativeOutputJackConnected(this.mAlsaDevice.getCardNum());
    }

    public void pleaseStop() {
        monitor-enter(this);
        this.mStopJackDetect = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean jackDetectCallback() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mStopJackDetect == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mAlsaDevice.updateOutputWiredDeviceConnectionState(true);     // Catch: Throwable -> L8
        this.mAlsaDevice.updateInputWiredDeviceConnectionState(true);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        nativeJackDetect(this.mAlsaDevice.getCardNum());
    }
}
