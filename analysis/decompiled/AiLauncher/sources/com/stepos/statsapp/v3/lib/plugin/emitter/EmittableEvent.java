package com.stepos.statsapp.v3.lib.plugin.emitter;

import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;

/* loaded from: classes2.dex */
public class EmittableEvent {
    private long eventId;
    private TrackerPayload eventPayload;
    private String packageName;

    public EmittableEvent(String str, long j10, TrackerPayload trackerPayload) {
        this.packageName = str;
        this.eventId = j10;
        this.eventPayload = trackerPayload;
    }

    public long getId() {
        return this.eventId;
    }

    public TrackerPayload getPayload() {
        return this.eventPayload;
    }
}
