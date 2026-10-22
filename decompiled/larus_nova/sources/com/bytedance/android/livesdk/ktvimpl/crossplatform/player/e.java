package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f143814a = null;

    static {
        int[] r100 = new int[MusicPanel.Track.values().length];
        f143814a = r100;
        r100[MusicPanel.Track.ALL_SUPPORT.ordinal()] = 1;
        r100[MusicPanel.Track.ORIGIN_ONLY.ordinal()] = 2;
        r100[MusicPanel.Track.ACCOMPANIMENT_ONLY.ordinal()] = 3;
        r100[MusicPanel.Track.NONE.ordinal()] = 4;
    }
}
