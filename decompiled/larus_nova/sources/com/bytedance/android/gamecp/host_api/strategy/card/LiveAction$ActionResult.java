package com.bytedance.android.gamecp.host_api.strategy.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/gamecp/host_api/strategy/card/LiveAction$ActionResult", "", "Lcom/bytedance/android/gamecp/host_api/strategy/card/LiveAction$ActionResult;", "", "type", "I", "getType", "()I", "SUCCESS", "FAILED", "UNDEFINED", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAction$ActionResult extends Enum<LiveAction$ActionResult> {
    public static final LiveAction$ActionResult FAILED = null;
    public static final LiveAction$ActionResult SUCCESS = null;
    public static final LiveAction$ActionResult UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAction$ActionResult[] f57430a = null;
    private final int type;

    static {
        LiveAction$ActionResult r100 = new LiveAction$ActionResult("SUCCESS", 0, 1);
        SUCCESS = r100;
        LiveAction$ActionResult r101 = new LiveAction$ActionResult("FAILED", 1, -1);
        FAILED = r101;
        LiveAction$ActionResult r102 = new LiveAction$ActionResult("UNDEFINED", 2, 0);
        UNDEFINED = r102;
        f57430a = new LiveAction$ActionResult[]{r100, r101, r102};
    }

    public static LiveAction$ActionResult valueOf(String r100) {
        return (LiveAction$ActionResult) a.a(LiveAction$ActionResult.class, r100);
    }

    public static LiveAction$ActionResult[] values() {
        return (LiveAction$ActionResult[]) f57430a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LiveAction$ActionResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
