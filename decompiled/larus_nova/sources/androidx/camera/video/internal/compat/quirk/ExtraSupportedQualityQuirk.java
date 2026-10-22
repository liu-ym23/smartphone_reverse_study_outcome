package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExtraSupportedQualityQuirk implements Quirk {
    private static final String MOTO_C_FRONT_CAM_ID = "1";

    public ExtraSupportedQualityQuirk() {
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }

    private static Range<Integer> getSupportedBitrateRange(EncoderProfilesProxy.VideoProfileProxy r100, Function<VideoEncoderConfig, VideoEncoderInfo> r101) {
        VideoEncoderInfo r102 = r101.apply(VideoConfigUtil.toVideoEncoderConfig(r100));
        if (r102 == null) goto L6;
        return r102.getSupportedBitrateRange();
    L6:
        return VideoSpec.BITRATE_RANGE_AUTO;
    }

    private Map<Integer, EncoderProfilesProxy> getExtraEncoderProfilesForMotoC(CameraInfoInternal r100, EncoderProfilesProvider r101, Function<VideoEncoderConfig, VideoEncoderInfo> r102) {
        if ("1".equals(r100.getCameraId()) == true) goto L5;
    L14:
        return null;
    L5:
        if (r101.hasProfile(4) == true) goto L14;
        EncoderProfilesProxy r103 = r101.getAll(1);
        EncoderProfilesProxy.VideoProfileProxy r104 = EncoderProfilesUtil.getFirstVideoProfile(r103);
        if (r104 != null) goto L10;
        return null;
    L10:
        Range<Integer> r105 = getSupportedBitrateRange(r104, r102);
        Size r106 = SizeUtil.RESOLUTION_480P;
        EncoderProfilesProxy.VideoProfileProxy r107 = EncoderProfilesUtil.deriveVideoProfile(r104, r106, r105);
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy r108 = EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r103.getDefaultDurationSeconds(), r103.getRecommendedFileFormat(), r103.getAudioProfiles(), Collections.singletonList(r107));
        HashMap r109 = new HashMap();
        r109.put(4, r108);
        Size r110 = new Size(r104.getWidth(), r104.getHeight());
        if (SizeUtil.getArea(r106) <= SizeUtil.getArea(r110)) goto L13;
        r109.put(1, r108);
    L13:
        return r109;
    }

    public Map<Integer, EncoderProfilesProxy> getExtraEncoderProfiles(CameraInfoInternal r100, EncoderProfilesProvider r101, Function<VideoEncoderConfig, VideoEncoderInfo> r102) {
        if (isMotoC() == false) goto L7;
        return getExtraEncoderProfilesForMotoC(r100, r101, r102);
    L7:
        return Collections.emptyMap();
    }
}
