package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEncoderConfigVideoProfileResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncVdPrflRslvr";
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final EncoderProfilesProxy.VideoProfileProxy mVideoProfile;
    private final VideoSpec mVideoSpec;

    private int resolveFrameRate() {
        int r100 = this.mVideoProfile.getFrameRate();
        Range<Integer> r101 = this.mExpectedFrameRateRange;
        Range<Integer> r102 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        if (Objects.equals(r101, r102) == true) goto L5;
        int r103 = ((Integer) this.mExpectedFrameRateRange.clamp(Integer.valueOf(r100))).intValue();
    L6:
        Object[] r104 = new Object[3];
        r104[0] = Integer.valueOf(r103);
        r104[1] = Integer.valueOf(r100);
        if (Objects.equals(this.mExpectedFrameRateRange, r102) == false) goto L9;
        Object r105 = this.mExpectedFrameRateRange;
    L10:
        r104[2] = r105;
        Logger.d(TAG, String.format("Resolved frame rate %dfps [Video profile frame rate: %dfps, Expected operating range: %s]", r104));
        return r103;
    L9:
        r105 = "<UNSPECIFIED>";
        goto L10
    L5:
        r103 = r100;
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public VideoEncoderConfig get() {
        int r110 = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + r110 + "fps");
        Range<Integer> r100 = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using resolved VIDEO bitrate from EncoderProfiles");
        int r101 = VideoConfigUtil.scaleAndClampBitrate(this.mVideoProfile.getBitrate(), this.mDynamicRange.getBitDepth(), this.mVideoProfile.getBitDepth(), r110, this.mVideoProfile.getFrameRate(), this.mSurfaceSize.getWidth(), this.mVideoProfile.getWidth(), this.mSurfaceSize.getHeight(), this.mVideoProfile.getHeight(), r100);
        int r102 = this.mVideoProfile.getProfile();
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(r101).setFrameRate(r110).setProfile(r102).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, r102)).build();
    }

    @Override // androidx.core.util.Supplier
    public /* bridge */ /* synthetic */ VideoEncoderConfig get() {
        return get();
    }

    public VideoEncoderConfigVideoProfileResolver(String r100, Timebase r101, VideoSpec r102, Size r103, EncoderProfilesProxy.VideoProfileProxy r104, DynamicRange r105, Range<Integer> r106) {
        this.mMimeType = r100;
        this.mInputTimebase = r101;
        this.mVideoSpec = r102;
        this.mSurfaceSize = r103;
        this.mVideoProfile = r104;
        this.mDynamicRange = r105;
        this.mExpectedFrameRateRange = r106;
    }
}
