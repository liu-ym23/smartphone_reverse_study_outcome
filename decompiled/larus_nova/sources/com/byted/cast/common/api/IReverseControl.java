package com.byted.cast.common.api;

import com.byted.cast.common.bean.DramaBean;

/* JADX INFO: loaded from: classes39.dex */
public interface IReverseControl {
    public static final String COMPLETED = "COMPLETED";
    public static final String LOADING = "LOADING";
    public static final String NO_MEDIA_PRESENT = "NO_MEDIA_PRESENT";
    public static final String PAUSED_PLAYBACK = "PAUSED_PLAYBACK";
    public static final String PLAYING = "PLAYING";
    public static final String STOPPED = "STOPPED";

    /* JADX INFO: renamed from: com.byted.cast.common.api.IReverseControl$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getDramaId(IReverseControl r100) {
            return "";
        }

        public static DramaBean[] $default$getDramaList(IReverseControl r100) {
            return null;
        }
    }

    long getCurrentPosition();

    String getDramaId();

    DramaBean[] getDramaList();

    long getDuration();

    String getPlayState();
}
