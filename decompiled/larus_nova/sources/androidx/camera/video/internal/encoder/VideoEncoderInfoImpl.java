package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEncoderInfoImpl extends EncoderInfoImpl implements VideoEncoderInfo {
    public static final Function<VideoEncoderConfig, VideoEncoderInfo> FINDER = null;
    private static final String TAG = "VideoEncoderInfoImpl";
    private final MediaCodecInfo.VideoCapabilities mVideoCapabilities;

    public static /* synthetic */ VideoEncoderInfo a(VideoEncoderConfig r100) {
        return lambda$static$0(r100);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int r100, int r101) {
        return VideoEncoderInfo.CC.$default$isSizeSupportedAllowSwapping(this, r100, r101);
    }

    static {
        FINDER = new r0();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoCapabilities.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoCapabilities.getBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mVideoCapabilities.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mVideoCapabilities.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoCapabilities.getWidthAlignment();
    }

    public static VideoEncoderInfoImpl from(VideoEncoderConfig r100) throws InvalidConfigException {
        return new VideoEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(r100), r100.getMimeType());
    }

    private static /* synthetic */ VideoEncoderInfo lambda$static$0(VideoEncoderConfig r100) {
        return VideoEncoderInfoWrapper.from(from(r100), null);
    L5:
        e = move-exception;
        Logger.w(TAG, "Unable to find a VideoEncoderInfoImpl", e);
        return null;
    }

    private static IllegalArgumentException toIllegalArgumentException(Throwable r100) {
        if ((r100 instanceof IllegalArgumentException) == false) goto L7;
        return (IllegalArgumentException) r100;
    L7:
        return new IllegalArgumentException(r100);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int r100) {
        return this.mVideoCapabilities.getSupportedHeightsFor(r100);
    L4:
        th = move-exception;
        throw toIllegalArgumentException(th);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int r100) {
        return this.mVideoCapabilities.getSupportedWidthsFor(r100);
    L4:
        th = move-exception;
        throw toIllegalArgumentException(th);
    }

    public VideoEncoderInfoImpl(MediaCodecInfo r100, String r101) throws InvalidConfigException {
        super(r100, r101);
        MediaCodecInfo.VideoCapabilities r102 = this.mCodecCapabilities.getVideoCapabilities();
        Objects.requireNonNull(r102);
        this.mVideoCapabilities = r102;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int r100, int r101) {
        return this.mVideoCapabilities.isSizeSupported(r100, r101);
    }
}
