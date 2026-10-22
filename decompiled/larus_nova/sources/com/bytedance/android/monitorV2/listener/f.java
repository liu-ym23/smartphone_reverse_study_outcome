package com.bytedance.android.monitorV2.listener;

/* JADX INFO: loaded from: classes12.dex */
public interface f {
    void onEventCreated(com.bytedance.android.monitorV2.event.c r100);

    void onEventSampled(com.bytedance.android.monitorV2.event.c r100);

    void onEventTerminated(com.bytedance.android.monitorV2.event.c r100);

    void onEventUpdated(com.bytedance.android.monitorV2.event.c r100);

    void onEventUploaded(com.bytedance.android.monitorV2.event.c r100);
}
