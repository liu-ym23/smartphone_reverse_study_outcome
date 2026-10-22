package com.obric.audiocodecsdk.encoder;

/* JADX INFO: loaded from: classes3.dex */
public class LameInterf {
    public static native void close(long handle);

    public static native int encode(long handle, short[] bufferL, short[] bufferR, int samples, byte[] mp3buf);

    public static native int flush(long handle, byte[] mp3buf);

    public static native long init(int inSampleRate, int inChannel, int outSampleRate, int outBitrate, int quality);

    public static native String version();

    public LameInterf() {
    }

    static {
        System.loadLibrary("lamemp3");
    }
}
