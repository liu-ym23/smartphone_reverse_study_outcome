package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.monitorV2.event.HybridEvent;

/* JADX INFO: loaded from: classes12.dex */
public interface g {
    void onEventCreated(HybridEvent r100);

    void onEventSampled(HybridEvent r100);

    void onEventTerminated(HybridEvent r100);

    void onEventUpdated(HybridEvent r100);

    void onEventUploaded(HybridEvent r100);
}
