package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/player/ReplayPlayerScene;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", EffectConstants.NORMAL, "PRE_PLAY", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayPlayerScene extends Enum<ReplayPlayerScene> {
    public static final ReplayPlayerScene NORMAL = null;
    public static final ReplayPlayerScene PRE_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayPlayerScene[] f118034a = null;
    private final String desc;

    static {
        ReplayPlayerScene r100 = new ReplayPlayerScene(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        ReplayPlayerScene r101 = new ReplayPlayerScene("PRE_PLAY", 1, "pre_play");
        PRE_PLAY = r101;
        f118034a = new ReplayPlayerScene[]{r100, r101};
    }

    public static ReplayPlayerScene valueOf(String r100) {
        return (ReplayPlayerScene) r27.a.a(ReplayPlayerScene.class, r100);
    }

    public static ReplayPlayerScene[] values() {
        return (ReplayPlayerScene[]) f118034a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public ReplayPlayerScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
