package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEncoderConfigDefaultResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncCfgDefaultRslvr";
    private static final Range<Integer> VALID_FRAME_RATE_RANGE = null;
    private static final int VIDEO_BITRATE_BASE = 14000000;
    private static final int VIDEO_BIT_DEPTH_BASE = 8;
    private static final int VIDEO_FRAME_RATE_BASE = 30;
    static final int VIDEO_FRAME_RATE_FIXED_DEFAULT = 30;
    private static final Size VIDEO_SIZE_BASE = null;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final VideoSpec mVideoSpec;

    static {
        VIDEO_SIZE_BASE = new Size(1280, 720);
        VALID_FRAME_RATE_RANGE = new Range(1, 60);
    }

    private int resolveFrameRate() {
        Range<Integer> r100 = this.mExpectedFrameRateRange;
        Range<Integer> r101 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        if (Objects.equals(r100, r101) == true) goto L5;
        int r102 = ((Integer) VALID_FRAME_RATE_RANGE.clamp((Integer) this.mExpectedFrameRateRange.getUpper())).intValue();
    L6:
        Object[] r103 = new Object[2];
        r103[0] = Integer.valueOf(r102);
        if (Objects.equals(this.mExpectedFrameRateRange, r101) == false) goto L9;
        Object r104 = this.mExpectedFrameRateRange;
    L10:
        r103[1] = r104;
        Logger.d(TAG, String.format("Default resolved frame rate: %dfps. [Expected operating range: %s]", r103));
        return r102;
    L9:
        r104 = "<UNSPECIFIED>";
        goto L10
    L5:
        r102 = 30;
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public VideoEncoderConfig get() {
        int r110 = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + r110 + "fps");
        Range<Integer> r100 = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using fallback VIDEO bitrate");
        int r101 = this.mDynamicRange.getBitDepth();
        int r102 = this.mSurfaceSize.getWidth();
        Size r103 = VIDEO_SIZE_BASE;
        int r104 = VideoConfigUtil.scaleAndClampBitrate(14000000, r101, 8, r110, 30, r102, r103.getWidth(), this.mSurfaceSize.getHeight(), r103.getHeight(), r100);
        int r105 = DynamicRangeUtil.dynamicRangeToCodecProfileLevelForMime(this.mMimeType, this.mDynamicRange);
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(r104).setFrameRate(r110).setProfile(r105).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, r105)).build();
    }

    @Override // androidx.core.util.Supplier
    public /* bridge */ /* synthetic */ VideoEncoderConfig get() {
        return get();
    }

    public VideoEncoderConfigDefaultResolver(String r100, Timebase r101, VideoSpec r102, Size r103, DynamicRange r104, Range<Integer> r105) {
        this.mMimeType = r100;
        this.mInputTimebase = r101;
        this.mVideoSpec = r102;
        this.mSurfaceSize = r103;
        this.mDynamicRange = r104;
        this.mExpectedFrameRateRange = r105;
    }
}
