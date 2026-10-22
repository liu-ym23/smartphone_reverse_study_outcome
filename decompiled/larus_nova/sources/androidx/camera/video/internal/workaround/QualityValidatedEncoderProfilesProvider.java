package androidx.camera.video.internal.workaround;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class QualityValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final Map<Integer, Quality> CAMCORDER_TO_VIDEO_QUALITY_MAP = null;
    private final CameraInfoInternal mCameraInfo;
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    static {
        HashMap r100 = new HashMap();
        CAMCORDER_TO_VIDEO_QUALITY_MAP = r100;
        r100.put(1, Quality.HIGHEST);
        r100.put(8, Quality.UHD);
        r100.put(6, Quality.FHD);
        r100.put(5, Quality.HD);
        r100.put(4, Quality.SD);
        r100.put(0, Quality.LOWEST);
    }

    private boolean isDeviceValidQuality(int r100) {
        Quality r101 = CAMCORDER_TO_VIDEO_QUALITY_MAP.get(Integer.valueOf(r100));
        if (r101 == null) goto L15;
        Iterator r102 = this.mQuirks.getAll(VideoQualityQuirk.class).iterator();
    L6:
        if (r102.hasNext() == false) goto L25;
        VideoQualityQuirk r103 = (VideoQualityQuirk) r102.next();
        if (r103 == null) goto L6;
        if (r103.isProblematicVideoQuality(this.mCameraInfo, r101) == false) goto L6;
        if (workaroundBySurfaceProcessing(r103) == true) goto L6;
        return false;
    L25:
        return true;
    L15:
        return true;
    }

    private static boolean workaroundBySurfaceProcessing(Quirk r100) {
        if ((r100 instanceof SurfaceProcessingQuirk) == true) goto L5;
    L7:
        return false;
    L5:
        if (((SurfaceProcessingQuirk) r100).workaroundBySurfaceProcessing() == false) goto L7;
        return true;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        if (hasProfile(r100) == true) goto L7;
        return null;
    L7:
        return this.mProvider.getAll(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (this.mProvider.hasProfile(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDeviceValidQuality(r100) == false) goto L7;
        return true;
    }

    public QualityValidatedEncoderProfilesProvider(EncoderProfilesProvider r100, CameraInfoInternal r101, Quirks r102) {
        this.mProvider = r100;
        this.mCameraInfo = r101;
        this.mQuirks = r102;
    }
}
