package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/BetaApplyStage;", "", "NOT_SIGNED_UP", "SIGN_UP_FINISH", "UN_SUPPORT", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BetaApplyStage extends Enum<BetaApplyStage> {
    public static final BetaApplyStage NOT_SIGNED_UP = null;
    public static final BetaApplyStage SIGN_UP_FINISH = null;
    public static final BetaApplyStage UN_SUPPORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BetaApplyStage[] f51519a = null;

    static {
        BetaApplyStage r100 = new BetaApplyStage("NOT_SIGNED_UP", 0);
        NOT_SIGNED_UP = r100;
        BetaApplyStage r101 = new BetaApplyStage("SIGN_UP_FINISH", 1);
        SIGN_UP_FINISH = r101;
        BetaApplyStage r102 = new BetaApplyStage("UN_SUPPORT", 2);
        UN_SUPPORT = r102;
        f51519a = new BetaApplyStage[]{r100, r101, r102};
    }

    public static BetaApplyStage valueOf(String r100) {
        return (BetaApplyStage) r27.a.a(BetaApplyStage.class, r100);
    }

    public static BetaApplyStage[] values() {
        return (BetaApplyStage[]) f51519a.clone();
    }

    public BetaApplyStage(String r100, int r101) {
        super(r100, r101);
    }
}
