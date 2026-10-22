package com.bytedance.android.livesdk.performance.gc.opt.blocker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/performance/gc/opt/blocker/GcBlockScene;", "", "", "getSceneName", "SCROLL", "EXIT", "LIVE_ROOM", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GcBlockScene extends Enum<GcBlockScene> {
    public static final GcBlockScene EXIT = null;
    public static final GcBlockScene LIVE_ROOM = null;
    public static final GcBlockScene SCROLL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GcBlockScene[] f154608a = null;

    static {
        GcBlockScene r100 = new GcBlockScene("SCROLL", 0);
        SCROLL = r100;
        GcBlockScene r101 = new GcBlockScene("EXIT", 1);
        EXIT = r101;
        GcBlockScene r102 = new GcBlockScene("LIVE_ROOM", 2);
        LIVE_ROOM = r102;
        f154608a = new GcBlockScene[]{r100, r101, r102};
    }

    public static GcBlockScene valueOf(String r100) {
        return (GcBlockScene) r27.a.a(GcBlockScene.class, r100);
    }

    public static GcBlockScene[] values() {
        return (GcBlockScene[]) f154608a.clone();
    }

    public final String getSceneName() {
        return "LIVE_" + name();
    }

    public GcBlockScene(String r100, int r101) {
        super(r100, r101);
    }
}
