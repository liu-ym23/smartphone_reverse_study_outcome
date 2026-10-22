package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59312a = 0;

    static {
    }

    public static boolean a(long r100, int r101) {
        StringBuilder r102 = new StringBuilder("gameId = ");
        r102.append(r100);
        r102.append(" gameKind = ");
        r102.append(r101);
        r102.append(", 主播游戏状态为 ");
        if (r100 <= 0) goto L9;
        if (r101 == 6) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        boolean r104 = true;
    L10:
        r102.append(r104);
        ALogger.d("AnchorGameState", r102.toString());
        if (r100 <= 0) goto L17;
        if (r101 == 6) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        return true;
    L14:
        r105 = false;
    L17:
        return false;
    L6:
        r103 = false;
    L9:
        r104 = false;
        goto L10
    }
}
