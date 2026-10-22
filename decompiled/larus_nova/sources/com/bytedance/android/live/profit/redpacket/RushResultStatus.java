package com.bytedance.android.live.profit.redpacket;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RushResultStatus;", "", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "RUSH_RESULT_SUCCESSED", "RUSH_RESULT_FAILED", "RUSH_RESULT_EXPIRED", "RUSH_RESULT_LYNX", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RushResultStatus extends Enum<RushResultStatus> {
    public static final RushResultStatus RUSH_RESULT_EXPIRED = null;
    public static final RushResultStatus RUSH_RESULT_FAILED = null;
    public static final RushResultStatus RUSH_RESULT_LYNX = null;
    public static final RushResultStatus RUSH_RESULT_SUCCESSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RushResultStatus[] f88578a = null;
    private final String statusMsg;

    static {
        RushResultStatus r100 = new RushResultStatus("RUSH_RESULT_SUCCESSED", 0, "successed");
        RUSH_RESULT_SUCCESSED = r100;
        RushResultStatus r101 = new RushResultStatus("RUSH_RESULT_FAILED", 1, "failed");
        RUSH_RESULT_FAILED = r101;
        RushResultStatus r102 = new RushResultStatus("RUSH_RESULT_EXPIRED", 2, AiBotPollingAuthResult.STATUS_EXPIRED);
        RUSH_RESULT_EXPIRED = r102;
        RushResultStatus r103 = new RushResultStatus("RUSH_RESULT_LYNX", 3, "lynx");
        RUSH_RESULT_LYNX = r103;
        f88578a = new RushResultStatus[]{r100, r101, r102, r103};
    }

    public static RushResultStatus valueOf(String r100) {
        return (RushResultStatus) r27.a.a(RushResultStatus.class, r100);
    }

    public static RushResultStatus[] values() {
        return (RushResultStatus[]) f88578a.clone();
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public RushResultStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.statusMsg = r102;
    }
}
