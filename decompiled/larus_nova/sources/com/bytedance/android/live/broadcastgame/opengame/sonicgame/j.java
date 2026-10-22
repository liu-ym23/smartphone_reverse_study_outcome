package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.profit.scoreboard.EventName;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f61067a = null;

    static {
        int[] r100 = new int[EventName.values().length];
        f61067a = r100;
        r100[EventName.ON_ROUND_MESSAGE_START.ordinal()] = 1;
        r100[EventName.ON_ROUND_MESSAGE_FINISH.ordinal()] = 2;
        r100[EventName.ON_ROUND_MESSAGE_SCORE_CHANGE.ordinal()] = 3;
    }
}
