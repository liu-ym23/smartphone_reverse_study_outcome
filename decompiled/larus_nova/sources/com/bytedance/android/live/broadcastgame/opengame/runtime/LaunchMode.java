package com.bytedance.android.live.broadcastgame.opengame.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/runtime/LaunchMode;", "", "FROM_PANEL", "FROM_DEBUG", "FROM_PREVIEW", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LaunchMode extends Enum<LaunchMode> {
    public static final LaunchMode FROM_DEBUG = null;
    public static final LaunchMode FROM_PANEL = null;
    public static final LaunchMode FROM_PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchMode[] f60770a = null;

    static {
        LaunchMode r100 = new LaunchMode("FROM_PANEL", 0);
        FROM_PANEL = r100;
        LaunchMode r101 = new LaunchMode("FROM_DEBUG", 1);
        FROM_DEBUG = r101;
        LaunchMode r102 = new LaunchMode("FROM_PREVIEW", 2);
        FROM_PREVIEW = r102;
        f60770a = new LaunchMode[]{r100, r101, r102};
    }

    public static LaunchMode valueOf(String r100) {
        return (LaunchMode) r27.a.a(LaunchMode.class, r100);
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) f60770a.clone();
    }

    public LaunchMode(String r100, int r101) {
        super(r100, r101);
    }
}
