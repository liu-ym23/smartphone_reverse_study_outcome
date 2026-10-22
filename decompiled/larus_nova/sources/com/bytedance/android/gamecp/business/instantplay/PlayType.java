package com.bytedance.android.gamecp.business.instantplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/instantplay/PlayType;", "", "TEAM_PLAY", "INTERACTION_PLAY", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayType extends Enum<PlayType> {
    public static final PlayType INTERACTION_PLAY = null;
    public static final PlayType TEAM_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayType[] f56116a = null;

    static {
        PlayType r100 = new PlayType("TEAM_PLAY", 0);
        TEAM_PLAY = r100;
        PlayType r101 = new PlayType("INTERACTION_PLAY", 1);
        INTERACTION_PLAY = r101;
        f56116a = new PlayType[]{r100, r101};
    }

    public static PlayType valueOf(String r100) {
        return (PlayType) r27.a.a(PlayType.class, r100);
    }

    public static PlayType[] values() {
        return (PlayType[]) f56116a.clone();
    }

    public PlayType(String r100, int r101) {
        super(r100, r101);
    }
}
