package com.android.server.display;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
class HighBrightnessModeMetadata {
    private final ArrayDeque<HbmEvent> mEvents;
    private long mRunningStartTimeMillis;

    HighBrightnessModeMetadata() {
        this.mEvents = new ArrayDeque();
        this.mRunningStartTimeMillis = -1;
    }

    public long getRunningStartTimeMillis() {
        return this.mRunningStartTimeMillis;
    }

    public void setRunningStartTimeMillis(long setTime) {
        this.mRunningStartTimeMillis = setTime;
    }

    public ArrayDeque<HbmEvent> getHbmEventQueue() {
        return this.mEvents;
    }

    public void addHbmEvent(HbmEvent hbmEvent) {
        this.mEvents.addFirst(hbmEvent);
    }
}
