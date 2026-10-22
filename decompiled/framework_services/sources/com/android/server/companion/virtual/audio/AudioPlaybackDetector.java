package com.android.server.companion.virtual.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AudioPlaybackDetector extends AudioManager.AudioPlaybackCallback {
    private final AudioManager mAudioManager;
    private AudioPlaybackCallback mAudioPlaybackCallback;

    interface AudioPlaybackCallback {
        void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> r1);
    }

    AudioPlaybackDetector(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService(AudioManager.class);
    }

    void register(AudioPlaybackCallback callback) {
        this.mAudioPlaybackCallback = callback;
        this.mAudioManager.registerAudioPlaybackCallback(this, null);
    }

    void unregister() {
        if (this.mAudioPlaybackCallback == null) goto L6;
        this.mAudioPlaybackCallback = null;
        this.mAudioManager.unregisterAudioPlaybackCallback(this);
        return;
    }

    @Override // android.media.AudioManager.AudioPlaybackCallback
    public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
        super.onPlaybackConfigChanged(configs);
        if (this.mAudioPlaybackCallback == null) goto L6;
        this.mAudioPlaybackCallback.onPlaybackConfigChanged(configs);
        return;
    }
}
