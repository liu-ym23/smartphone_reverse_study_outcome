package androidx.camera.video.internal.workaround;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Set<Size> mExtraSupportedSizes;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int r100, int r101) {
        return VideoEncoderInfo.CC.$default$isSizeSupportedAllowSwapping(this, r100, r101);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    private VideoEncoderInfoWrapper(VideoEncoderInfo r100) {
        HashSet r101 = new HashSet();
        this.mExtraSupportedSizes = r101;
        this.mVideoEncoderInfo = r100;
        int r102 = r100.getWidthAlignment();
        int r103 = ((int) Math.ceil(4096.0d / ((double) r102))) * r102;
        this.mSupportedWidths = Range.create(Integer.valueOf(r102), Integer.valueOf(r103));
        int r104 = r100.getHeightAlignment();
        int r105 = ((int) Math.ceil(2160.0d / ((double) r104))) * r104;
        this.mSupportedHeights = Range.create(Integer.valueOf(r104), Integer.valueOf(r105));
        r101.addAll(MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes());
    }

    private void addExtraSupportedSize(Size r100) {
        this.mExtraSupportedSizes.add(r100);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int r100) {
        if (this.mSupportedWidths.contains(Integer.valueOf(r100)) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Preconditions.checkArgument(r101, "Not supported width: " + r100 + " which is not in " + this.mSupportedWidths + " or can not be divided by alignment " + this.mVideoEncoderInfo.getWidthAlignment());
        return this.mSupportedHeights;
    L5:
        if ((r100 % this.mVideoEncoderInfo.getWidthAlignment()) != 0) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int r100) {
        if (this.mSupportedHeights.contains(Integer.valueOf(r100)) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Preconditions.checkArgument(r101, "Not supported height: " + r100 + " which is not in " + this.mSupportedHeights + " or can not be divided by alignment " + this.mVideoEncoderInfo.getHeightAlignment());
        return this.mSupportedWidths;
    L5:
        if ((r100 % this.mVideoEncoderInfo.getHeightAlignment()) != 0) goto L7;
        r101 = true;
        goto L8
    }

    public static VideoEncoderInfo from(VideoEncoderInfo r100, Size r101) {
        boolean r102 = false;
        if ((r100 instanceof VideoEncoderInfoWrapper) == false) goto L6;
    L12:
        if (r102 == false) goto L14;
        r100 = new VideoEncoderInfoWrapper(r100);
    L14:
        if (r101 != null) goto L16;
    L18:
        return r100;
    L16:
        if ((r100 instanceof VideoEncoderInfoWrapper) == false) goto L18;
        ((VideoEncoderInfoWrapper) r100).addExtraSupportedSize(r101);
        goto L18
    L6:
        if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) goto L8;
    L7:
        r102 = true;
        goto L12
    L8:
        if (r101 == null) goto L12;
        if (r100.isSizeSupportedAllowSwapping(r101.getWidth(), r101.getHeight()) == true) goto L12;
        Logger.w(TAG, String.format("Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s", new Object[]{r101, r100.getSupportedWidths(), r100.getSupportedHeights()}));
        goto L7
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int r100, int r101) {
        if (this.mVideoEncoderInfo.isSizeSupported(r100, r101) == false) goto L5;
        return true;
    L5:
        Iterator<Size> r102 = this.mExtraSupportedSizes.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Size r103 = r102.next();
        if (r103.getWidth() != r100) goto L7;
        if (r103.getHeight() != r101) goto L7;
        return true;
    L14:
        if (this.mSupportedWidths.contains(Integer.valueOf(r100)) == true) goto L16;
    L22:
        return false;
    L16:
        if (this.mSupportedHeights.contains(Integer.valueOf(r101)) == false) goto L22;
        if ((r100 % this.mVideoEncoderInfo.getWidthAlignment()) != 0) goto L22;
        if ((r101 % this.mVideoEncoderInfo.getHeightAlignment()) != 0) goto L22;
        return true;
    }
}
