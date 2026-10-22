package com.bytedance.android.live.profit.redpacket;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketCurState;", "", "", "stateName", "Ljava/lang/String;", "getStateName", "()Ljava/lang/String;", "Waiting", "Available", "Rushed", "Expired", "Empty", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketCurState extends Enum<RedPacketCurState> {
    public static final RedPacketCurState Available = null;
    public static final RedPacketCurState Empty = null;
    public static final RedPacketCurState Expired = null;
    public static final RedPacketCurState Rushed = null;
    public static final RedPacketCurState Waiting = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketCurState[] f88490a = null;
    private final String stateName;

    static {
        RedPacketCurState r100 = new RedPacketCurState("Waiting", 0, "countdown");
        Waiting = r100;
        RedPacketCurState r101 = new RedPacketCurState("Available", 1, "grabbing");
        Available = r101;
        RedPacketCurState r102 = new RedPacketCurState("Rushed", 2, "grabbed");
        Rushed = r102;
        RedPacketCurState r103 = new RedPacketCurState("Expired", 3, AiBotPollingAuthResult.STATUS_EXPIRED);
        Expired = r103;
        RedPacketCurState r104 = new RedPacketCurState("Empty", 4, CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED);
        Empty = r104;
        f88490a = new RedPacketCurState[]{r100, r101, r102, r103, r104};
    }

    public static RedPacketCurState valueOf(String r100) {
        return (RedPacketCurState) r27.a.a(RedPacketCurState.class, r100);
    }

    public static RedPacketCurState[] values() {
        return (RedPacketCurState[]) f88490a.clone();
    }

    public final String getStateName() {
        return this.stateName;
    }

    public RedPacketCurState(String r100, int r101, String r102) {
        super(r100, r101);
        this.stateName = r102;
    }
}
