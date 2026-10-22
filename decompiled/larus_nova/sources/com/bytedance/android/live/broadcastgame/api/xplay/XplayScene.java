package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/XplayScene;", "", "", "sceneId", "I", "getSceneId", "()I", "Video", "TalkRoom", "RevenueLink", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayScene extends Enum<XplayScene> {
    public static final XplayScene RevenueLink = null;
    public static final XplayScene TalkRoom = null;
    public static final XplayScene Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayScene[] f59438a = null;
    private final int sceneId;

    static {
        XplayScene r100 = new XplayScene("Video", 0, 1);
        Video = r100;
        XplayScene r101 = new XplayScene("TalkRoom", 1, 2);
        TalkRoom = r101;
        XplayScene r102 = new XplayScene("RevenueLink", 2, 3);
        RevenueLink = r102;
        f59438a = new XplayScene[]{r100, r101, r102};
    }

    public static XplayScene valueOf(String r100) {
        return (XplayScene) r27.a.a(XplayScene.class, r100);
    }

    public static XplayScene[] values() {
        return (XplayScene[]) f59438a.clone();
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public XplayScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.sceneId = r102;
    }
}
