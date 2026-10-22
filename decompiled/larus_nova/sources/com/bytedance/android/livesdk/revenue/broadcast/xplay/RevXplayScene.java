package com.bytedance.android.livesdk.revenue.broadcast.xplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/broadcast/xplay/RevXplayScene;", "", "", "sceneId", "I", "getSceneId", "()I", "Video", "TalkRoom", "RevenueLink", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevXplayScene extends Enum<RevXplayScene> {
    public static final RevXplayScene RevenueLink = null;
    public static final RevXplayScene TalkRoom = null;
    public static final RevXplayScene Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevXplayScene[] f157099a = null;
    private final int sceneId;

    static {
        RevXplayScene r100 = new RevXplayScene("Video", 0, 1);
        Video = r100;
        RevXplayScene r101 = new RevXplayScene("TalkRoom", 1, 2);
        TalkRoom = r101;
        RevXplayScene r102 = new RevXplayScene("RevenueLink", 2, 3);
        RevenueLink = r102;
        f157099a = new RevXplayScene[]{r100, r101, r102};
    }

    public static RevXplayScene valueOf(String r100) {
        return (RevXplayScene) a.a(RevXplayScene.class, r100);
    }

    public static RevXplayScene[] values() {
        return (RevXplayScene[]) f157099a.clone();
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public RevXplayScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.sceneId = r102;
    }
}
