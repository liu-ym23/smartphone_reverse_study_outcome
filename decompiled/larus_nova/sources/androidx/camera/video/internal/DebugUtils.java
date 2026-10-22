package androidx.camera.video.internal;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.Api28Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugUtils {
    private static final String AUDIO_CAPS_PREFIX = "[AudioCaps] ";
    private static final String CODEC_CAPS_PREFIX = "[CodecCaps] ";
    private static final String ENCODER_CAPS_PREFIX = "[EncoderCaps] ";
    private static final String TAG = "DebugUtils";
    private static final String VIDEO_CAPS_PREFIX = "[VideoCaps] ";

    private DebugUtils() {
    }

    private static String formatInterval(long r110) {
        TimeUnit r100 = TimeUnit.MILLISECONDS;
        long r101 = r100.toHours(r110);
        TimeUnit r102 = TimeUnit.HOURS;
        long r103 = r100.toMinutes(r110 - r102.toMillis(r101));
        long r104 = r110 - r102.toMillis(r101);
        TimeUnit r105 = TimeUnit.MINUTES;
        long r106 = r100.toSeconds(r104 - r105.toMillis(r103));
        long r111 = ((r110 - r102.toMillis(r101)) - r105.toMillis(r103)) - TimeUnit.SECONDS.toMillis(r106);
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(r101), Long.valueOf(r103), Long.valueOf(r106), Long.valueOf(r111)});
    }

    public static String readableBufferInfo(MediaCodec.BufferInfo r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("Dump BufferInfo: " + r100.toString() + "\n");
        r101.append("\toffset: " + r100.offset + "\n");
        r101.append("\tsize: " + r100.size + "\n");
        StringBuilder r102 = new StringBuilder("\tflag: ");
        r102.append(r100.flags);
        r101.append(r102.toString());
        ArrayList r103 = new ArrayList();
        if ((r100.flags & 4) == 0) goto L6;
        r103.add("EOS");
    L6:
        if ((r100.flags & 2) == 0) goto L9;
        r103.add("CODEC_CONFIG");
    L9:
        if ((r100.flags & 1) == 0) goto L12;
        r103.add("KEY_FRAME");
    L12:
        if ((r100.flags & 8) == 0) goto L15;
        r103.add("PARTIAL_FRAME");
    L15:
        if (r103.isEmpty() == true) goto L17;
        r101.append(" (");
        r101.append(TextUtils.join(" | ", r103));
        r101.append(")");
    L17:
        r101.append("\n");
        r101.append("\tpresentationTime: " + r100.presentationTimeUs + " (" + readableUs(r100.presentationTimeUs) + ")\n");
        return r101.toString();
    }

    public static String readableMs(long r100) {
        return formatInterval(r100);
    }

    public static String readableUs(long r100) {
        return readableMs(TimeUnit.MICROSECONDS.toMillis(r100));
    }

    private static void stringToLog(String r100) {
        if (Logger.isInfoEnabled(TAG) == false) goto L8;
        Scanner r101 = new Scanner(r100);
    L6:
        if (r101.hasNextLine() == false) goto L10;
        Logger.i(TAG, r101.nextLine());
        goto L6
    L10:
        return;
    }

    private static String toString(MediaCodecInfo.CodecProfileLevel r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return String.format("{level=%d, profile=%d}", new Object[]{Integer.valueOf(r100.level), Integer.valueOf(r100.profile)});
    }

    public static String dumpMediaCodecListForFormat(MediaCodecList r110, MediaFormat r111) {
        StringBuilder r100 = new StringBuilder();
        logToString(r100, "[Start] Dump MediaCodecList for mediaFormat " + r111);
        String r101 = r111.getString("mime");
        MediaCodecInfo[] r112 = r110.getCodecInfos();
        int r102 = r112.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        MediaCodecInfo r104 = r112[r103];
        if (r104.isEncoder() == false) goto L18;
        boolean r105 = true;
        if (r101 == null) goto L10;
        boolean r106 = true;
    L21:
        Preconditions.checkArgument(r106);     // Catch: IllegalArgumentException -> L17
        MediaCodecInfo.CodecCapabilities r107 = r104.getCapabilitiesForType(r101);     // Catch: IllegalArgumentException -> L17
        if (r107 != null) goto L15;
        r105 = false;
    L15:
        Preconditions.checkArgument(r105);     // Catch: IllegalArgumentException -> L17
        logToString(r100, "[Start] [" + r104.getName() + "]");     // Catch: IllegalArgumentException -> L17
        dumpCodecCapabilities(r100, r107, r111);     // Catch: IllegalArgumentException -> L17
        logToString(r100, "[End] [" + r104.getName() + "]");     // Catch: IllegalArgumentException -> L17
    L17:
        logToString(r100, "[" + r104.getName() + "] does not support mime " + r101);
        goto L18
    L10:
        r106 = false;
    L18:
        r103 = r103 + 1;
        goto L3
    L19:
        logToString(r100, "[End] Dump MediaCodecList");
        String r113 = r100.toString();
        stringToLog(r113);
        return r113;
    }

    private static void logToString(StringBuilder r100, String r101) {
        r100.append(r101);
        r100.append("\n");
    }

    private static void dumpAudioCapabilities(StringBuilder r100, MediaCodecInfo.AudioCapabilities r101, MediaFormat r102) {
        logToString(r100, "[AudioCaps] getBitrateRange = " + r101.getBitrateRange());
        logToString(r100, "[AudioCaps] getMaxInputChannelCount = " + r101.getMaxInputChannelCount());
        if (Build.VERSION.SDK_INT < 31) goto L5;
        logToString(r100, "[AudioCaps] getMinInputChannelCount = " + Api31Impl.getMinInputChannelCount(r101));
        logToString(r100, "[AudioCaps] getInputChannelCountRanges = " + Arrays.toString(Api31Impl.getInputChannelCountRanges(r101)));
    L5:
        logToString(r100, "[AudioCaps] getSupportedSampleRateRanges = " + Arrays.toString(r101.getSupportedSampleRateRanges()));
        logToString(r100, "[AudioCaps] getSupportedSampleRates = " + Arrays.toString(r101.getSupportedSampleRates()));
        int r103 = r102.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Throwable -> L8
        logToString(r100, "[AudioCaps] isSampleRateSupported for " + r103 + " = " + r101.isSampleRateSupported(r103));     // Catch: Throwable -> L8
        return;
    L8:
        logToString(r100, "[AudioCaps] mediaFormat does not contain sample rate");
    }

    private static void dumpCodecCapabilities(StringBuilder r100, MediaCodecInfo.CodecCapabilities r101, MediaFormat r102) {
        logToString(r100, "[CodecCaps] isFormatSupported = " + r101.isFormatSupported(r102));     // Catch: ClassCastException -> L5
    L6:
        logToString(r100, "[CodecCaps] getDefaultFormat = " + r101.getDefaultFormat());
        if (r101.profileLevels == null) goto L13;
        StringBuilder r103 = new StringBuilder("[");
        ArrayList r104 = new ArrayList();
        MediaCodecInfo.CodecProfileLevel[] r105 = r101.profileLevels;
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r104.add(toString(r105[r107]));
        r107 = r107 + 1;
        goto L9
    L11:
        r103.append(TextUtils.join(", ", r104));
        r103.append("]");
        logToString(r100, "[CodecCaps] profileLevels = " + r103);
    L13:
        if (r101.colorFormats == null) goto L15;
        logToString(r100, "[CodecCaps] colorFormats = " + Arrays.toString(r101.colorFormats));
    L15:
        MediaCodecInfo.VideoCapabilities r108 = r101.getVideoCapabilities();
        if (r108 == null) goto L18;
        dumpVideoCapabilities(r100, r108, r102);
    L18:
        MediaCodecInfo.AudioCapabilities r109 = r101.getAudioCapabilities();
        if (r109 == null) goto L21;
        dumpAudioCapabilities(r100, r109, r102);
    L21:
        MediaCodecInfo.EncoderCapabilities r110 = r101.getEncoderCapabilities();
        if (r110 == null) goto L28;
        dumpEncoderCapabilities(r100, r110, r102);
        return;
    L28:
        return;
    L5:
        logToString(r100, "[CodecCaps] isFormatSupported=false");
        goto L6
    }

    private static void dumpEncoderCapabilities(StringBuilder r100, MediaCodecInfo.EncoderCapabilities r101, MediaFormat r102) {
        logToString(r100, "[EncoderCaps] getComplexityRange = " + r101.getComplexityRange());
        if (Build.VERSION.SDK_INT < 28) goto L9;
        logToString(r100, "[EncoderCaps] getQualityRange = " + Api28Impl.getQualityRange(r101));
    L9:
        logToString(r100, "[EncoderCaps] isBitrateModeSupported = " + r101.isBitrateModeSupported(r102.getInteger("bitrate-mode")));     // Catch: Throwable -> L7
        return;
    L7:
        logToString(r100, "[EncoderCaps] mediaFormat does not contain bitrate mode");
    }

    private static void dumpVideoCapabilities(StringBuilder r110, MediaCodecInfo.VideoCapabilities r111, MediaFormat r112) {
        logToString(r110, "[VideoCaps] getBitrateRange = " + r111.getBitrateRange());
        logToString(r110, "[VideoCaps] getSupportedWidths = " + r111.getSupportedWidths() + ", getWidthAlignment = " + r111.getWidthAlignment());
        logToString(r110, "[VideoCaps] getSupportedHeights = " + r111.getSupportedHeights() + ", getHeightAlignment = " + r111.getHeightAlignment());
        int r100 = 0;
        boolean r101 = true;
        int r102 = r112.getInteger("width");     // Catch: Throwable -> L10
        int r103 = r112.getInteger("height");     // Catch: Throwable -> L10
        if (r102 <= 0) goto L7;
        if (r103 <= 0) goto L7;
        boolean r104 = true;
    L8:
        Preconditions.checkArgument(r104);     // Catch: Throwable -> L10
        boolean r105 = true;
    L12:
        if (r105 == true) goto L38;
    L20:
        logToString(r110, "[VideoCaps] getSupportedFrameRates = " + r111.getSupportedFrameRates());
        int r113 = r112.getInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE);     // Catch: Throwable -> L27
        if (r113 > 0) goto L25;
        r101 = false;
    L25:
        Preconditions.checkArgument(r101);     // Catch: Throwable -> L27
        r100 = r113;
    L28:
        if (r105 == false) goto L30;
        logToString(r110, "[VideoCaps] getSupportedFrameRatesFor " + r102 + "x" + r103 + " = " + r111.getSupportedFrameRatesFor(r102, r103));
    L30:
        if (r105 == false) goto L42;
        if (r100 <= 0) goto L43;
        logToString(r110, "[VideoCaps] areSizeAndRateSupported for " + r102 + "x" + r103 + ", " + r100 + " = " + r111.areSizeAndRateSupported(r102, r103, r100));
        return;
    L43:
        return;
    L42:
        return;
    L27:
        logToString(r110, "[VideoCaps] mediaFormat does not contain frame rate");
        goto L28
    L38:
        logToString(r110, "[VideoCaps] getSupportedHeightsFor " + r102 + " = " + r111.getSupportedHeightsFor(r102));     // Catch: IllegalArgumentException -> L15
    L40:
        logToString(r110, "[VideoCaps] getSupportedWidthsFor " + r103 + " = " + r111.getSupportedWidthsFor(r103));     // Catch: IllegalArgumentException -> L18
    L19:
        logToString(r110, "[VideoCaps] isSizeSupported for " + r102 + "x" + r103 + " = " + r111.isSizeSupported(r102, r103));
    L18:
        logToString(r110, "[VideoCaps] could not getSupportedWidthsFor " + r103);
    L15:
        logToString(r110, "[VideoCaps] could not getSupportedHeightsFor " + r102);
    L7:
        r104 = false;
    L10:
        logToString(r110, "[VideoCaps] mediaFormat does not contain valid width and height");
        r102 = 0;
        r103 = 0;
        r105 = false;
        goto L12
    }

    public static String dumpCodecCapabilities(String r100, MediaCodec r101, MediaFormat r102) {
        StringBuilder r103 = new StringBuilder();
        MediaCodecInfo.CodecCapabilities r104 = r101.getCodecInfo().getCapabilitiesForType(r100);     // Catch: IllegalArgumentException -> L9
        if (r104 == null) goto L6;
        boolean r105 = true;
    L7:
        Preconditions.checkArgument(r105);     // Catch: IllegalArgumentException -> L9
        dumpCodecCapabilities(r103, r104, r102);     // Catch: IllegalArgumentException -> L9
    L11:
        return r103.toString();
    L6:
        r105 = false;
    L9:
        logToString(r103, "[" + r101.getName() + "] does not support mime " + r100);
        goto L11
    }
}
