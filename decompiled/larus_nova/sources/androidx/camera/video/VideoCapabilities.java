package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoCapabilities {
    public static final VideoCapabilities EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.video.VideoCapabilities$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static VideoValidatedEncoderProfilesProxy $default$findNearestHigherSupportedEncoderProfilesFor(VideoCapabilities r100, Size r101, DynamicRange r102) {
            return null;
        }

        public static VideoValidatedEncoderProfilesProxy $default$getProfiles(VideoCapabilities r100, Quality r101, DynamicRange r102) {
            return null;
        }

        public static boolean $default$isStabilizationSupported(VideoCapabilities r100) {
            return false;
        }

        public static Quality $default$findNearestHigherSupportedQualityFor(VideoCapabilities r100, Size r101, DynamicRange r102) {
            return Quality.NONE;
        }
    }

    VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size r100, DynamicRange r101);

    Quality findNearestHigherSupportedQualityFor(Size r100, DynamicRange r101);

    VideoValidatedEncoderProfilesProxy getProfiles(Quality r100, DynamicRange r101);

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Quality> getSupportedQualities(DynamicRange r100);

    boolean isQualitySupported(Quality r100, DynamicRange r101);

    boolean isStabilizationSupported();

    static {
        EMPTY = new AnonymousClass1();
    }
}
