package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import com.bytedance.livesdk.ktvcommon.download.model.MusicType;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f142477a = null;

    static {
        int[] r100 = new int[MusicType.values().length];
        f142477a = r100;
        r100[MusicType.FULL_TRACK.ordinal()] = 1;
        r100[MusicType.MIDI.ordinal()] = 2;
        r100[MusicType.LYRIC.ordinal()] = 3;
        r100[MusicType.ACCOMPANIMENT_TRACK.ordinal()] = 4;
    }
}
