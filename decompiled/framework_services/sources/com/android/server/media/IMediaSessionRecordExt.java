package com.android.server.media;

import android.media.AudioSystem;
import android.media.MediaMetadata;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaSessionRecordExt {
    public static IMediaSessionRecordExt get(MediaSessionRecord base) {
        return (IMediaSessionRecordExt) ExtLoader.get(IMediaSessionRecordExt.class, base);
    }

    public IMediaSessionRecordExt() {
    }

    public IMediaSessionRecordExt(Object base) {
    }

    public void init(int uid, int userId, String pkg, String tag) {
    }

    public int getSid() {
        return 0;
    }

    public void setMetadata_onEnd(MediaMetadata metadata) {
    }

    public void setPlaybackState_onEnd(PlaybackState state) {
    }

    public void setExtras_onEnd(Bundle extras) {
    }

    boolean postAdjustLocalVolume_shouldApplyDedicatedStreamType(int stream) {
        return AudioSystem.isStreamActive(stream, 0);
    }
}
