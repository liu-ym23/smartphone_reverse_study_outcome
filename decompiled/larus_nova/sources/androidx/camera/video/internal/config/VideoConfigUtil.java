package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoConfigUtil {
    private static final Timebase DEFAULT_TIME_BASE = null;
    private static final Map<String, Map<Integer, VideoEncoderDataSpace>> MIME_TO_DATA_SPACE_MAP = null;
    private static final String TAG = "VideoConfigUtil";

    static {
        HashMap r100 = new HashMap();
        MIME_TO_DATA_SPACE_MAP = r100;
        DEFAULT_TIME_BASE = Timebase.UPTIME;
        HashMap r101 = new HashMap();
        VideoEncoderDataSpace r102 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
        r101.put(1, r102);
        VideoEncoderDataSpace r103 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG;
        r101.put(2, r103);
        VideoEncoderDataSpace r104 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ;
        r101.put(4096, r104);
        r101.put(8192, r104);
        HashMap r105 = new HashMap();
        r105.put(1, r102);
        r105.put(2, r103);
        r105.put(4096, r104);
        r105.put(8192, r104);
        HashMap r110 = new HashMap();
        r110.put(1, r102);
        r110.put(4, r103);
        r110.put(4096, r104);
        r110.put(16384, r104);
        r110.put(2, r102);
        r110.put(8, r103);
        r110.put(8192, r104);
        r110.put(32768, r104);
        HashMap r106 = new HashMap();
        r106.put(256, r103);
        r106.put(512, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT709);
        r100.put("video/hevc", r101);
        r100.put("video/av01", r105);
        r100.put("video/x-vnd.on2.vp9", r110);
        r100.put("video/dolby-vision", r106);
    }

    private VideoConfigUtil() {
    }

    private static String getDynamicRangeDefaultMime(DynamicRange r100) {
        int r101 = r100.getEncoding();
        if (r101 != 1) goto L5;
        return KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
    L5:
        if (r101 != 3) goto L7;
        return "video/hevc";
    L7:
        if (r101 != 4) goto L9;
        return "video/hevc";
    L9:
        if (r101 != 5) goto L11;
        return "video/hevc";
    L11:
        if (r101 != 6) goto L15;
        return "video/dolby-vision";
    L15:
        throw new UnsupportedOperationException("Unsupported dynamic range: " + r100 + "\nNo supported default mime type available.");
    }

    public static VideoEncoderConfig toVideoEncoderConfig(EncoderProfilesProxy.VideoProfileProxy r100) {
        return VideoEncoderConfig.builder().setMimeType(r100.getMediaType()).setProfile(r100.getProfile()).setResolution(new Size(r100.getWidth(), r100.getHeight())).setFrameRate(r100.getFrameRate()).setBitrate(r100.getBitrate()).setInputTimebase(DEFAULT_TIME_BASE).build();
    }

    public static VideoEncoderDataSpace mimeAndProfileToEncoderDataSpace(String r100, int r101) {
        Map<Integer, VideoEncoderDataSpace> r102 = MIME_TO_DATA_SPACE_MAP.get(r100);
        if (r102 == null) goto L7;
        VideoEncoderDataSpace r103 = r102.get(Integer.valueOf(r101));
        if (r103 == null) goto L7;
        return r103;
    L7:
        Logger.w(TAG, String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", new Object[]{r100, Integer.valueOf(r101)}));
        return VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
    }

    public static VideoMimeInfo resolveVideoMimeInfo(MediaSpec r110, DynamicRange r111, VideoValidatedEncoderProfilesProxy r112) {
        Preconditions.checkState(r111.isFullySpecified(), "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + r111 + "]");
        String r100 = MediaSpec.outputFormatToVideoMime(r110.getOutputFormat());
        if (r112 == null) goto L19;
        Set<Integer> r101 = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(r111);
        Set<Integer> r102 = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(r111);
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r103 = r112.getVideoProfiles().iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        EncoderProfilesProxy.VideoProfileProxy r104 = r103.next();
        if (r101.contains(Integer.valueOf(r104.getHdrFormat())) == false) goto L6;
        if (r102.contains(Integer.valueOf(r104.getBitDepth())) == false) goto L6;
        String r105 = r104.getMediaType();
        if (Objects.equals(r100, r105) == true) goto L14;
        if (r110.getOutputFormat() != (-1)) goto L6;
        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + r100 + ", dynamic range: " + r111 + "]");
    L18:
        r100 = r105;
    L20:
        if (r104 == null) goto L22;
    L27:
        VideoMimeInfo.Builder r113 = VideoMimeInfo.builder(r100);
        if (r104 == null) goto L31;
        r113.setCompatibleVideoProfile(r104);
    L31:
        return r113.build();
    L22:
        if (r110.getOutputFormat() != (-1)) goto L24;
        r100 = getDynamicRangeDefaultMime(r111);
    L24:
        if (r112 != null) goto L26;
        Logger.d(TAG, "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + r100 + ", dynamic range: " + r111 + "]");
        goto L27
    L26:
        Logger.d(TAG, "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + r100 + ", dynamic range: " + r111 + "]");
        goto L27
    L14:
        Logger.d(TAG, "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + r100 + "]");
    L19:
        r104 = null;
        goto L20
    }

    public static VideoEncoderConfig resolveVideoEncoderConfig(VideoMimeInfo r110, Timebase r111, VideoSpec r112, Size r113, DynamicRange r210, Range<Integer> r211) {
        EncoderProfilesProxy.VideoProfileProxy r100 = r110.getCompatibleVideoProfile();
        if (r100 == null) goto L5;
        Supplier r101 = new VideoEncoderConfigVideoProfileResolver(r110.getMimeType(), r111, r112, r113, r100, r210, r211);
    L7:
        return (VideoEncoderConfig) r101.get();
    L5:
        r101 = new VideoEncoderConfigDefaultResolver(r110.getMimeType(), r111, r112, r113, r210, r211);
        goto L7
    }

    public static int scaleAndClampBitrate(int r110, int r111, int r210, int r211, int r212, int r213, int r214, int r215, int r216, Range<Integer> r217) {
        int r100 = (int) ((((((double) r110) * new Rational(r111, r210).doubleValue()) * new Rational(r211, r212).doubleValue()) * new Rational(r213, r214).doubleValue()) * new Rational(r215, r216).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        String r101 = String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), Integer.valueOf(r211), Integer.valueOf(r212), Integer.valueOf(r213), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), Integer.valueOf(r100)});
    L7:
        if (VideoSpec.BITRATE_RANGE_AUTO.equals(r217) == true) goto L11;
        r100 = ((Integer) r217.clamp(Integer.valueOf(r100))).intValue();
        if (Logger.isDebugEnabled(TAG) == false) goto L11;
        r101 = r101 + String.format("\nClamped to range %s -> %dbps", new Object[]{r217, Integer.valueOf(r100)});
    L11:
        Logger.d(TAG, r101);
        return r100;
    L5:
        r101 = "";
        goto L7
    }
}
