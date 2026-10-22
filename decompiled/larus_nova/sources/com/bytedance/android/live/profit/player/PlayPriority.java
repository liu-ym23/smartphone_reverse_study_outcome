package com.bytedance.android.live.profit.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/player/PlayPriority;", "", "Normal", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayPriority extends Enum<PlayPriority> {
    public static final PlayPriority Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayPriority[] f88302a = null;

    static {
        PlayPriority r100 = new PlayPriority();
        Normal = r100;
        f88302a = new PlayPriority[]{r100};
    }

    public static PlayPriority valueOf(String r100) {
        return (PlayPriority) r27.a.a(PlayPriority.class, r100);
    }

    public static PlayPriority[] values() {
        return (PlayPriority[]) f88302a.clone();
    }

    public PlayPriority() {
        super("Normal", 0);
    }
}
