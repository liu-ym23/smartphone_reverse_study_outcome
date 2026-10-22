package com.stepos.aiengine.algorithm.vad;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/algorithm/vad/VadParamKeys;", "", "<init>", "()V", "THRESHOLD", "", "MIN_SPEECH_RMS", "SPEECH_START_MS", "SILENCE_DURATION_MS", "LEADING_SILENCE_TIMEOUT_MS", "MAX_DURATION_MS", "LEVEL_ENABLED", "LEVEL_INTERVAL_MS", "FEED_ORDERED", "FEED_SEQ", "FEED_EOF", "FEED_TOTAL", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VadParamKeys {
    public static final String FEED_EOF = "vad.feed.eof";
    public static final String FEED_ORDERED = "vad.feed.ordered";
    public static final String FEED_SEQ = "vad.feed.seq";
    public static final String FEED_TOTAL = "vad.feed.total";
    public static final VadParamKeys INSTANCE = new VadParamKeys();
    public static final String LEADING_SILENCE_TIMEOUT_MS = "vad.leading_silence_timeout_ms";
    public static final String LEVEL_ENABLED = "vad.level_enabled";
    public static final String LEVEL_INTERVAL_MS = "vad.level_interval_ms";
    public static final String MAX_DURATION_MS = "vad.max_duration_ms";
    public static final String MIN_SPEECH_RMS = "vad.min_speech_rms";
    public static final String SILENCE_DURATION_MS = "vad.silence_duration_ms";
    public static final String SPEECH_START_MS = "vad.speech_start_ms";
    public static final String THRESHOLD = "vad.threshold";
}
