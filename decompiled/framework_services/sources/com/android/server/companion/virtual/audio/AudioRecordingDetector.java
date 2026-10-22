package com.android.server.companion.virtual.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AudioRecordingDetector extends AudioManager.AudioRecordingCallback {
    private final AudioManager mAudioManager;
    private AudioRecordingCallback mAudioRecordingCallback;

    interface AudioRecordingCallback {
        void onRecordingConfigChanged(List<AudioRecordingConfiguration> r1);
    }

    AudioRecordingDetector(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService(AudioManager.class);
    }

    void register(AudioRecordingCallback callback) {
        this.mAudioRecordingCallback = callback;
        this.mAudioManager.registerAudioRecordingCallback(this, null);
    }

    void unregister() {
        if (this.mAudioRecordingCallback == null) goto L6;
        this.mAudioRecordingCallback = null;
        this.mAudioManager.unregisterAudioRecordingCallback(this);
        return;
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
        super.onRecordingConfigChanged(configs);
        if (this.mAudioRecordingCallback == null) goto L6;
        this.mAudioRecordingCallback.onRecordingConfigChanged(configs);
        return;
    }
}
