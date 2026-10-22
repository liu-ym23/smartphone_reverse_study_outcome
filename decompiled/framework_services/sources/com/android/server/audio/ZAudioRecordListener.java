package com.android.server.audio;

/* JADX INFO: loaded from: classes.dex */
public interface ZAudioRecordListener {
    default void onAudioSourceChanged(int source, boolean active) {
    }

    default void onRecordingUidChanged(int uid, boolean active) {
    }

    default void onAudioRecordChange(ZRecordClientInterface client) {
    }
}
