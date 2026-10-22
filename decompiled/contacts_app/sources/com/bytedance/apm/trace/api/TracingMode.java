package com.bytedance.apm.trace.api;

/* JADX INFO: loaded from: classes2.dex */
public final enum TracingMode extends Enum<TracingMode> {
    private static final /* synthetic */ TracingMode[] $VALUES = null;
    public static final TracingMode BATCH = null;

    private TracingMode(String r1, int r2) {
        super(r1, r2);
    }

    public static TracingMode valueOf(String r1) {
        return (TracingMode) Enum.valueOf(TracingMode.class, r1);
    }

    public static TracingMode[] values() {
        return (TracingMode[]) $VALUES.clone();
    }

    static {
        TracingMode r0 = new TracingMode("BATCH", 0);
        BATCH = r0;
        $VALUES = new TracingMode[]{r0};
    }
}
