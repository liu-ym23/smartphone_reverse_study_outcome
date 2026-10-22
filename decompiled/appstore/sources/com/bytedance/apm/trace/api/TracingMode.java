package com.bytedance.apm.trace.api;

/* JADX INFO: loaded from: classes.dex */
public final enum TracingMode extends Enum<TracingMode> {
    private static final /* synthetic */ TracingMode[] $VALUES = null;
    public static final TracingMode BATCH = null;

    static {
        TracingMode r10 = new TracingMode("BATCH", 0);
        BATCH = r10;
        $VALUES = new TracingMode[]{r10};
    }

    private TracingMode(String r10, int r11) {
        super(r10, r11);
    }

    public static TracingMode valueOf(String r10) {
        return (TracingMode) Enum.valueOf(TracingMode.class, r10);
    }

    public static TracingMode[] values() {
        return (TracingMode[]) $VALUES.clone();
    }
}
