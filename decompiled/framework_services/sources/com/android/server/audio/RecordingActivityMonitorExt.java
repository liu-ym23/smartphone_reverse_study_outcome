package com.android.server.audio;

import android.content.Context;
import android.media.AudioRecordingConfiguration;
import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes.dex */
public class RecordingActivityMonitorExt {
    public static RecordingActivityMonitorExt get(RecordingActivityMonitor base) {
        return (RecordingActivityMonitorExt) ExtLoader.get(RecordingActivityMonitorExt.class, base);
    }

    public RecordingActivityMonitorExt(Object base) {
    }

    public void init_onEnd(Context context) {
    }

    public void onRecordingConfigurationChanged_afterCreatingRecordingConfiguration(int event, int riid, AudioRecordingConfiguration config) {
    }

    public void recorderEvent_beforeDispatchCallbacks(int event, int riid) {
    }

    public void releaseRecorder_beforeDispatchCallbacks(int riid) {
    }

    public void onAudioServerDied_beforeRemovingRecordingState(int riid, AudioRecordingConfiguration config) {
    }
}
