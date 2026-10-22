package androidx.camera.core;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureLatencyEstimate {
    public static final long UNDEFINED_CAPTURE_LATENCY = -1;
    public static final ImageCaptureLatencyEstimate UNDEFINED_IMAGE_CAPTURE_LATENCY = null;
    public static final long UNDEFINED_PROCESSING_LATENCY = -1;
    private final long mCaptureLatencyMillis;
    private final long mProcessingLatencyMillis;
    private final long mTotalCaptureLatencyMillis;

    private long computeTotalCaptureLatencyMillis(long r100, long r101) {
        if (r100 != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (r101 == (-1)) goto L9;
        return r100 + r101;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mCaptureLatencyMillis), Long.valueOf(this.mProcessingLatencyMillis), Long.valueOf(this.mTotalCaptureLatencyMillis)});
    }

    static {
        UNDEFINED_IMAGE_CAPTURE_LATENCY = new ImageCaptureLatencyEstimate(-1, -1);
    }

    public String toString() {
        return "captureLatencyMillis=" + this.mCaptureLatencyMillis + ", processingLatencyMillis=" + this.mProcessingLatencyMillis + ", totalCaptureLatencyMillis=" + this.mTotalCaptureLatencyMillis;
    }

    public long getCaptureLatencyMillis() {
        return this.mCaptureLatencyMillis;
    }

    public long getProcessingLatencyMillis() {
        return this.mProcessingLatencyMillis;
    }

    public long getTotalCaptureLatencyMillis() {
        return this.mTotalCaptureLatencyMillis;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageCaptureLatencyEstimate) == true) goto L8;
        return false;
    L8:
        ImageCaptureLatencyEstimate r101 = (ImageCaptureLatencyEstimate) r100;
        if (this.mCaptureLatencyMillis == r101.getCaptureLatencyMillis()) goto L11;
    L15:
        return false;
    L11:
        if (this.mProcessingLatencyMillis != r101.getProcessingLatencyMillis()) goto L15;
        if (this.mTotalCaptureLatencyMillis != r101.getTotalCaptureLatencyMillis()) goto L15;
        return true;
    }

    public ImageCaptureLatencyEstimate(long r100, long r101) {
        this.mCaptureLatencyMillis = r100;
        this.mProcessingLatencyMillis = r101;
        this.mTotalCaptureLatencyMillis = computeTotalCaptureLatencyMillis(r100, r101);
    }
}
