package com.android.server.audio;

import android.content.Context;
import android.media.AudioPlaybackConfiguration;
import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes.dex */
public class PlaybackActivityMonitorExt {
    public static final int PLAYBACK_EVENT_ATTRIBUTES_CHANGED = 1001;
    public static final int PLAYBACK_EVENT_SESSION_CHANGED = 1002;
    public static final int PLAYBACK_EVENT_TRACKED = 1000;

    public interface PlaybackConfigProvider {
        AudioPlaybackConfiguration getByPiid(int r1);
    }

    public static PlaybackActivityMonitorExt get(PlaybackActivityMonitor base) {
        return (PlaybackActivityMonitorExt) ExtLoader.get(PlaybackActivityMonitorExt.class, base);
    }

    public PlaybackActivityMonitorExt(Object base) {
    }

    public void init_beforeInitEventHandler(Context context, PlaybackConfigProvider playbackConfigProvider) {
    }

    public void trackPlayer_onEnd(int piid) {
    }

    public void playerAttributes_beforeDispatchPlaybackChange(int piid) {
    }

    public void playerSessionId_beforeDispatchPlaybackChange(int piid) {
    }

    public void playerEvent_beforeDispatchPlaybackChange(int event, int piid) {
    }

    public void releasePlayer_beforeDispatchPlaybackChange(int piid) {
    }

    public void portMuteEvent_beforeDispatchPlaybackChange(int piid) {
    }

    public void portFormatEvent_beforeDispatchPlaybackChange(int piid) {
    }
}
