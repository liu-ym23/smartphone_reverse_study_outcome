package com.stepos.core.common.telemetry;

import java.util.List;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FailStage {
    public static final FailStage INSTANCE = new FailStage();
    public static final String UNKNOWN = "UNKNOWN";
    public static final String BINDER_ENTRY = "BINDER_ENTRY";
    public static final String QUEUE_WAIT = "QUEUE_WAIT";
    public static final String DISPATCH_GATE_WAIT = "DISPATCH_GATE_WAIT";
    public static final String PRIORITY_ARBITRATE = "PRIORITY_ARBITRATE";
    public static final String CIRCUIT_BREAKER = "CIRCUIT_BREAKER";
    public static final String FLOW_CONTROL = "FLOW_CONTROL";
    public static final String ORCHESTRATION = "ORCHESTRATION";
    public static final String BACKEND_SELECT = "BACKEND_SELECT";
    public static final String MODEL_LOOKUP = "MODEL_LOOKUP";
    public static final String MODEL_LOAD = "MODEL_LOAD";
    public static final String MODEL_LOAD_BACKOFF = "MODEL_LOAD_BACKOFF";
    public static final String MODEL_DRAIN_WAIT = "MODEL_DRAIN_WAIT";
    public static final String INPUT_CONVERT = "INPUT_CONVERT";
    public static final String INFERENCE = "INFERENCE";
    public static final String IMAGE_PREPROCESS = "IMAGE_PREPROCESS";
    public static final String VIT_ENCODE = "VIT_ENCODE";
    public static final String AUDIO_PREPROCESS = "AUDIO_PREPROCESS";
    public static final String AUDIO_ENCODE = "AUDIO_ENCODE";
    public static final String PREFILL = "PREFILL";
    public static final String DECODE = "DECODE";
    public static final String FLOW_MATCH = "FLOW_MATCH";
    public static final String HIFT = "HIFT";
    public static final String OUTPUT_CONVERT = "OUTPUT_CONVERT";
    public static final String CALLBACK_DELIVER = "CALLBACK_DELIVER";
    private static final List<String> ALL = m.b0(UNKNOWN, BINDER_ENTRY, QUEUE_WAIT, DISPATCH_GATE_WAIT, PRIORITY_ARBITRATE, CIRCUIT_BREAKER, FLOW_CONTROL, ORCHESTRATION, BACKEND_SELECT, MODEL_LOOKUP, MODEL_LOAD, MODEL_LOAD_BACKOFF, MODEL_DRAIN_WAIT, INPUT_CONVERT, INFERENCE, IMAGE_PREPROCESS, VIT_ENCODE, AUDIO_PREPROCESS, AUDIO_ENCODE, PREFILL, DECODE, FLOW_MATCH, HIFT, OUTPUT_CONVERT, CALLBACK_DELIVER);

    private FailStage() {
    }

    public final List<String> getALL() {
        return ALL;
    }
}
