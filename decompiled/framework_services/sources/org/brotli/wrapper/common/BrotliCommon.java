package org.brotli.wrapper.common;

import android.hardware.tv.mediaquality.ParameterName;
import com.android.server.usb.descriptors.UsbASFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliCommon {
    private static final byte[] RFC_DICTIONARY_MD5 = null;
    private static final byte[] RFC_DICTIONARY_SHA_1 = null;
    private static final byte[] RFC_DICTIONARY_SHA_256 = null;
    public static final int RFC_DICTIONARY_SIZE = 122784;
    private static boolean isDictionaryDataSet;
    private static final Object mutex = null;

    public BrotliCommon() {
    }

    static {
        RFC_DICTIONARY_MD5 = new byte[]{-106, -50, -51, ParameterName.LOW_BLUE_LIGHT, -25, -90, 102, -43, -86, 54, ParameterName.COLOR_TEMPERATURE_BLUE_GAIN, -41, ParameterName.COLOR_TUNER_SATURATION_FLESH, 53, -77, 42};
        RFC_DICTIONARY_SHA_1 = new byte[]{114, -76, 16, ParameterName.TREBLE, -53, 97, -87, ParameterName.COLOR_TEMPERATURE_RED_OFFSET, ParameterName.LEVEL_RANGE, -93, -60, ParameterName.COLOR_TUNER_SATURATION_RED, 76, ParameterName.COLOR_TEMPERATURE_RED_OFFSET, -99, -91, 13, -102, 118, ParameterName.COLOR_TUNER_HUE_FLESH};
        RFC_DICTIONARY_SHA_256 = new byte[]{ParameterName.CVRR, -28, ParameterName.LOW_BLUE_LIGHT, -79, -75, ParameterName.DE_CONTOUR, -62, ParameterName.GLOBE_DIMMING, 6, -44, -46, ParameterName.COLOR_TEMPERATURE_BLUE_GAIN, -48, 126, ParameterName.DIGITAL_OUTPUT, -48, 104, 119, -40, -50, 123, ParameterName.COLOR_TUNER_HUE_RED, UsbASFormat.EXT_FORMAT_TYPE_I, 127, 55, -113, 49, 54, 83, -13, ParameterName.DTS_VIRTUAL_X, 112};
        mutex = new Object();
    }

    public static boolean checkDictionaryDataMd5(byte[] digest) {
        return Arrays.equals(RFC_DICTIONARY_MD5, digest);
    }

    public static boolean checkDictionaryDataSha1(byte[] digest) {
        return Arrays.equals(RFC_DICTIONARY_SHA_1, digest);
    }

    public static boolean checkDictionaryDataSha256(byte[] digest) {
        return Arrays.equals(RFC_DICTIONARY_SHA_256, digest);
    }

    public static ByteBuffer makeNative(byte[] data) {
        ByteBuffer result = ByteBuffer.allocateDirect(data.length);
        result.put(data);
        return result;
    }

    public static void setDictionaryData(byte[] data) {
        if (data.length != 122784) goto L18;
        Object r0 = mutex;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (isDictionaryDataSet == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        setDictionaryData(makeNative(data));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L18:
        throw new IllegalArgumentException("invalid dictionary size");
    }

    public static void setDictionaryData(InputStream src) throws IOException {
        Object r0 = mutex;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isDictionaryDataSet == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ByteBuffer copy = ByteBuffer.allocateDirect(RFC_DICTIONARY_SIZE);     // Catch: Throwable -> L8
        byte[] buffer = new byte[4096];     // Catch: Throwable -> L8
    L11:
        int readBytes = src.read(buffer);     // Catch: Throwable -> L8
        if (readBytes == (-1)) goto L19;
        if (copy.remaining() < readBytes) goto L17;
        copy.put(buffer, 0, readBytes);     // Catch: Throwable -> L8
        goto L11
    L17:
        throw new IllegalArgumentException("invalid dictionary size");     // Catch: Throwable -> L8
    L19:
        if (copy.remaining() != 0) goto L24;
        setDictionaryData(copy);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        throw new IllegalArgumentException("invalid dictionary size " + copy.remaining());     // Catch: Throwable -> L8
    }

    public static void setDictionaryData(ByteBuffer data) {
        if (data.isDirect() == false) goto L26;
        if (data.capacity() != 122784) goto L24;
        Object r0 = mutex;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (isDictionaryDataSet == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        if (CommonJNI.nativeSetDictionaryData(data) == false) goto L20;
        isDictionaryDataSet = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L20:
        throw new RuntimeException("setting dictionary failed");     // Catch: Throwable -> L12
    L24:
        throw new IllegalArgumentException("invalid dictionary size");
    L26:
        throw new IllegalArgumentException("direct byte buffer is expected");
    }
}
