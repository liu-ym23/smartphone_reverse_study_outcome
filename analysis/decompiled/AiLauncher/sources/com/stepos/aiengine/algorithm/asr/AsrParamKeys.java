package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrParamKeys;", "", "<init>", "()V", "TURN_DETECTION_SERVER_VAD", "", "REALTIME_TURN_DETECTION_TYPE", "REALTIME_TURN_DETECTION_SILENCE_MS", "REALTIME_TURN_DETECTION_THRESHOLD", "REALTIME_SEGMENTATION_MAX_CHARS", "REALTIME_SEGMENTATION_PUNCT_WINDOW", "REALTIME_FEED_ORDERED", "REALTIME_FEED_SEQ", "REALTIME_FEED_EOF", "REALTIME_FEED_TOTAL", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrParamKeys {
    public static final AsrParamKeys INSTANCE = new AsrParamKeys();
    public static final String REALTIME_FEED_EOF = "asr.realtime.feed.eof";
    public static final String REALTIME_FEED_ORDERED = "asr.realtime.feed.ordered";
    public static final String REALTIME_FEED_SEQ = "asr.realtime.feed.seq";
    public static final String REALTIME_FEED_TOTAL = "asr.realtime.feed.total";
    public static final String REALTIME_SEGMENTATION_MAX_CHARS = "asr.realtime.segmentation.max_chars";
    public static final String REALTIME_SEGMENTATION_PUNCT_WINDOW = "asr.realtime.segmentation.punct_window";
    public static final String REALTIME_TURN_DETECTION_SILENCE_MS = "asr.realtime.turn_detection.silence_duration_ms";
    public static final String REALTIME_TURN_DETECTION_THRESHOLD = "asr.realtime.turn_detection.threshold";
    public static final String REALTIME_TURN_DETECTION_TYPE = "asr.realtime.turn_detection.type";
    public static final String TURN_DETECTION_SERVER_VAD = "server_vad";
}
