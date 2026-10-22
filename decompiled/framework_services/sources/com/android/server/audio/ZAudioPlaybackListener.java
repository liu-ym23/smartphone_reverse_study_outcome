package com.android.server.audio;

/* JADX INFO: loaded from: classes.dex */
public interface ZAudioPlaybackListener {
    default void onAudioStreamChanged(int streamType, boolean active) {
    }

    default void onPlaybackUidChanged(int uid, boolean active) {
    }

    default void onPlaybackChange(ZPlaybackClientInterface client) {
    }
}
