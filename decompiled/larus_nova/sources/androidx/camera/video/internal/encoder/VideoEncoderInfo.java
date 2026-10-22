package androidx.camera.video.internal.encoder;

import android.util.Range;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoEncoderInfo extends EncoderInfo {

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.VideoEncoderInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isSizeSupportedAllowSwapping(VideoEncoderInfo r100, int r101, int r102) {
            if (r100.isSizeSupported(r101, r102) == false) goto L5;
        L10:
            return true;
        L5:
            if (r100.canSwapWidthHeight() == true) goto L7;
        L9:
            return false;
        L7:
            if (r100.isSizeSupported(r102, r101) == false) goto L9;
            goto L9
        }
    }

    boolean canSwapWidthHeight();

    int getHeightAlignment();

    Range<Integer> getSupportedBitrateRange();

    Range<Integer> getSupportedHeights();

    Range<Integer> getSupportedHeightsFor(int r100);

    Range<Integer> getSupportedWidths();

    Range<Integer> getSupportedWidthsFor(int r100);

    int getWidthAlignment();

    boolean isSizeSupported(int r100, int r101);

    boolean isSizeSupportedAllowSwapping(int r100, int r101);
}
