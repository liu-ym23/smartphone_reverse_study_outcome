package com.obric.capabilitykit.entity.app;

/* JADX INFO: loaded from: classes4.dex */
public final class AuditoryRecordingState {
    public static final int FINISHED = 1;
    public static final AuditoryRecordingState INSTANCE = null;
    public static final int RECORDING = 0;

    static {
        INSTANCE = new AuditoryRecordingState();
    }

    private AuditoryRecordingState() {
    }
}
