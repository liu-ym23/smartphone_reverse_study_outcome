package com.stepos.core.common.util;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseStreamParamKeys {
    public static final int DEFAULT_STREAM_MAX_DURATION_MS = 180000;
    public static final String EVENT_DELTA = "asr.delta";
    public static final String EVENT_DONE = "asr.done";
    public static final String EVENT_SPEECH_START = "asr.speech_start";
    public static final String EVENT_TYPE = "asr.event_type";
    public static final String EVENT_WARNING = "asr.warning";
    public static final String FEED_EOF = "asr.sse.feed.eof";
    public static final String FEED_ORDERED = "asr.sse.feed.ordered";
    public static final String FEED_SEQ = "asr.sse.feed.seq";
    public static final String FEED_TOTAL = "asr.sse.feed.total";
    public static final AsrSseStreamParamKeys INSTANCE = new AsrSseStreamParamKeys();
    public static final int MAX_STREAM_MAX_DURATION_MS = 600000;
    public static final int MIN_STREAM_MAX_DURATION_MS = 1000;
    public static final String SEGMENT_END_MS = "asr.segment.end_ms";
    public static final String SEGMENT_INDEX = "asr.segment.index";
    public static final String SEGMENT_START_MS = "asr.segment.start_ms";
    public static final String STREAM_MAX_DURATION_MS = "asr.sse.stream.max_duration_ms";
    public static final String VAD_ENABLED = "vad.enabled";
    public static final String VAD_GATE = "asr.sse.feed.vad_gate";
    public static final String WARNING_CODE = "asr.warning_code";
    public static final String WARNING_MESSAGE = "asr.warning_message";

    private AsrSseStreamParamKeys() {
    }
}
