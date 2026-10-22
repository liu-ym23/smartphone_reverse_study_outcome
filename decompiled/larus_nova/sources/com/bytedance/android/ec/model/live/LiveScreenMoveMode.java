package com.bytedance.android.ec.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/live/LiveScreenMoveMode;", "", "LIVE_SCREEN_MOVE_NONE", "LIVE_SCREEN_MOVE_UP", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum LiveScreenMoveMode extends Enum<LiveScreenMoveMode> {
    public static final LiveScreenMoveMode LIVE_SCREEN_MOVE_NONE = null;
    public static final LiveScreenMoveMode LIVE_SCREEN_MOVE_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveScreenMoveMode[] f47886a = null;

    static {
        LiveScreenMoveMode r100 = new LiveScreenMoveMode("LIVE_SCREEN_MOVE_NONE", 0);
        LIVE_SCREEN_MOVE_NONE = r100;
        LiveScreenMoveMode r101 = new LiveScreenMoveMode("LIVE_SCREEN_MOVE_UP", 1);
        LIVE_SCREEN_MOVE_UP = r101;
        f47886a = new LiveScreenMoveMode[]{r100, r101};
    }

    public static LiveScreenMoveMode valueOf(String r100) {
        return (LiveScreenMoveMode) r27.a.a(LiveScreenMoveMode.class, r100);
    }

    public static LiveScreenMoveMode[] values() {
        return (LiveScreenMoveMode[]) f47886a.clone();
    }

    public LiveScreenMoveMode(String r100, int r101) {
        super(r100, r101);
    }
}
