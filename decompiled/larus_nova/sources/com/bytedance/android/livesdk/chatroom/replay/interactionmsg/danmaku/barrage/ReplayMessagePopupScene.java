package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/barrage/ReplayMessagePopupScene;", "", "PORTRAIT_DANMAKU", "LANDSCAPE_DANMAKU", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayMessagePopupScene extends Enum<ReplayMessagePopupScene> {
    public static final ReplayMessagePopupScene LANDSCAPE_DANMAKU = null;
    public static final ReplayMessagePopupScene PORTRAIT_DANMAKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayMessagePopupScene[] f108988a = null;

    static {
        ReplayMessagePopupScene r100 = new ReplayMessagePopupScene("PORTRAIT_DANMAKU", 0);
        PORTRAIT_DANMAKU = r100;
        ReplayMessagePopupScene r101 = new ReplayMessagePopupScene("LANDSCAPE_DANMAKU", 1);
        LANDSCAPE_DANMAKU = r101;
        f108988a = new ReplayMessagePopupScene[]{r100, r101};
    }

    public static ReplayMessagePopupScene valueOf(String r100) {
        return (ReplayMessagePopupScene) r27.a.a(ReplayMessagePopupScene.class, r100);
    }

    public static ReplayMessagePopupScene[] values() {
        return (ReplayMessagePopupScene[]) f108988a.clone();
    }

    public ReplayMessagePopupScene(String r100, int r101) {
        super(r100, r101);
    }
}
