package com.bytedance.apm.trace.api;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum TracingMode extends Enum<TracingMode> {
    public static final TracingMode BATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TracingMode[] f190625a = null;

    static {
        TracingMode r100 = new TracingMode();
        BATCH = r100;
        f190625a = new TracingMode[]{r100};
    }

    public TracingMode() {
        super("BATCH", 0);
    }

    public static TracingMode[] values() {
        return (TracingMode[]) f190625a.clone();
    }

    public static TracingMode valueOf(String r100) {
        return (TracingMode) a.a(TracingMode.class, r100);
    }
}
