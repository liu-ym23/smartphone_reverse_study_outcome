package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamParamKeys;", "", "<init>", "()V", "VAD_ENABLED", "", "STREAM_MAX_DURATION_MS", "DEFAULT_STREAM_MAX_DURATION_MS", "", "MIN_STREAM_MAX_DURATION_MS", "MAX_STREAM_MAX_DURATION_MS", "FEED_ORDERED", "FEED_SEQ", "FEED_EOF", "FEED_TOTAL", "VAD_GATE", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrSseStreamParamKeys {
    public static final int DEFAULT_STREAM_MAX_DURATION_MS = 180000;
    public static final String FEED_EOF = "asr.sse.feed.eof";
    public static final String FEED_ORDERED = "asr.sse.feed.ordered";
    public static final String FEED_SEQ = "asr.sse.feed.seq";
    public static final String FEED_TOTAL = "asr.sse.feed.total";
    public static final AsrSseStreamParamKeys INSTANCE = new AsrSseStreamParamKeys();
    public static final int MAX_STREAM_MAX_DURATION_MS = 600000;
    public static final int MIN_STREAM_MAX_DURATION_MS = 1000;
    public static final String STREAM_MAX_DURATION_MS = "asr.sse.stream.max_duration_ms";
    public static final String VAD_ENABLED = "vad.enabled";
    public static final String VAD_GATE = "asr.sse.feed.vad_gate";
}
