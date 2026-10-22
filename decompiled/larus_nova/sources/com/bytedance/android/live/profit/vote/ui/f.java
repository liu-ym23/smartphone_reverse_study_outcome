package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteCompare;
import com.bytedance.android.live.profit.vote.VoteState;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f89348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f89349b = null;

    static {
        int[] r100 = new int[VoteState.values().length];
        f89348a = r100;
        r100[VoteState.RESUMED.ordinal()] = 1;
        r100[VoteState.PAUSED.ordinal()] = 2;
        r100[VoteState.FINISHED.ordinal()] = 3;
        int[] r101 = new int[VoteCompare.values().length];
        f89349b = r101;
        r101[VoteCompare.Draw.ordinal()] = 1;
        r101[VoteCompare.LeftWin.ordinal()] = 2;
        r101[VoteCompare.RightWin.ordinal()] = 3;
    }
}
