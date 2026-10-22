package com.bytedance.android.live.profit.vote;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/vote/VoteCompare;", "", "Draw", "LeftWin", "RightWin", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteCompare extends Enum<VoteCompare> {
    public static final VoteCompare Draw = null;
    public static final VoteCompare LeftWin = null;
    public static final VoteCompare RightWin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteCompare[] f89192a = null;

    static {
        VoteCompare r100 = new VoteCompare("Draw", 0);
        Draw = r100;
        VoteCompare r101 = new VoteCompare("LeftWin", 1);
        LeftWin = r101;
        VoteCompare r102 = new VoteCompare("RightWin", 2);
        RightWin = r102;
        f89192a = new VoteCompare[]{r100, r101, r102};
    }

    public static VoteCompare valueOf(String r100) {
        return (VoteCompare) r27.a.a(VoteCompare.class, r100);
    }

    public static VoteCompare[] values() {
        return (VoteCompare[]) f89192a.clone();
    }

    public VoteCompare(String r100, int r101) {
        super(r100, r101);
    }
}
