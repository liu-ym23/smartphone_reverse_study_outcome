package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.ss.ttm.player.MediaPlayer;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f189496a = null;

    static {
        f189496a = new IntRange(100000, 199999);
        new IntRange(600, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_LIVE_FRAME_RENDER_TIME);
    }

    public static final boolean a(int r100) {
        return f189496a.contains(r100 & (-1073741825));
    }
}
