package com.bytedance.apm.trace.api.wrapper;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum TracingWrapperMode extends Enum<TracingWrapperMode> {
    public static final TracingWrapperMode PARALLEL_WRAPPER_MODE = null;
    public static final TracingWrapperMode SERIAL_WRAPPER_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TracingWrapperMode[] f190626a = null;

    static {
        TracingWrapperMode r100 = new TracingWrapperMode("PARALLEL_WRAPPER_MODE", 0);
        PARALLEL_WRAPPER_MODE = r100;
        TracingWrapperMode r101 = new TracingWrapperMode("SERIAL_WRAPPER_MODE", 1);
        SERIAL_WRAPPER_MODE = r101;
        f190626a = new TracingWrapperMode[]{r100, r101};
    }

    public static TracingWrapperMode[] values() {
        return (TracingWrapperMode[]) f190626a.clone();
    }

    public static TracingWrapperMode valueOf(String r100) {
        return (TracingWrapperMode) a.a(TracingWrapperMode.class, r100);
    }

    public TracingWrapperMode(String r100, int r101) {
        super(r100, r101);
    }
}
