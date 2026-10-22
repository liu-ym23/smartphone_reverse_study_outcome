package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrPcmSegmentPolicy {
    public static final double ABS_SILENCE_RMS = 300.0d;
    public static final long ENDPOINT_SILENCE_MS = 300;
    public static final AsrPcmSegmentPolicy INSTANCE = new AsrPcmSegmentPolicy();
    public static final long MAX_SEGMENT_MS = 6000;
    public static final long MIN_SEGMENT_MS = 2000;
    public static final double SILENCE_RMS_RATIO = 0.18d;
    public static final long WINDOW_MS = 500;

    private AsrPcmSegmentPolicy() {
    }

    public final AsrPcmSegmentParams params(long j10) {
        return new AsrPcmSegmentParams(j10, 2000L, 300L, 0.18d, 300.0d, 500L);
    }
}
