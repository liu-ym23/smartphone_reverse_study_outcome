package com.bytedance.applet.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/task/PlaybackState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlaybackState extends Enum<PlaybackState> {
    public static final PlaybackState PAUSED = null;
    public static final PlaybackState PLAYING = null;
    public static final PlaybackState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlaybackState[] f192230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f192231b = null;

    public static EnumEntries<PlaybackState> getEntries() {
        return f192231b;
    }

    static {
        PlaybackState r100 = new PlaybackState("PLAYING", 0);
        PLAYING = r100;
        PlaybackState r101 = new PlaybackState("PAUSED", 1);
        PAUSED = r101;
        PlaybackState r102 = new PlaybackState("STOPPED", 2);
        STOPPED = r102;
        PlaybackState[] r103 = {r100, r101, r102};
        f192230a = r103;
        f192231b = EnumEntriesKt.enumEntries(r103);
    }

    public static PlaybackState[] values() {
        return (PlaybackState[]) f192230a.clone();
    }

    public static PlaybackState valueOf(String r100) {
        return (PlaybackState) r27.a.a(PlaybackState.class, r100);
    }

    public PlaybackState(String r100, int r101) {
        super(r100, r101);
    }
}
