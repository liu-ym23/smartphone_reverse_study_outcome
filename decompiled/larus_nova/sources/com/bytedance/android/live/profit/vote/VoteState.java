package com.bytedance.android.live.profit.vote;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/vote/VoteState;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "code", "J", "getCode", "()J", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RESUMED", "PAUSED", "FINISHED", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteState extends Enum<VoteState> {
    public static final a Companion = null;
    public static final VoteState FINISHED = null;
    public static final VoteState PAUSED = null;
    public static final VoteState RESUMED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteState[] f89193a = null;
    private final long code;

    public static final class a {
        public a() {
        }
    }

    static {
        VoteState r100 = new VoteState("RESUMED", 0, 1);
        RESUMED = r100;
        VoteState r101 = new VoteState("PAUSED", 1, 2);
        PAUSED = r101;
        VoteState r102 = new VoteState("FINISHED", 2, 3);
        FINISHED = r102;
        f89193a = new VoteState[]{r100, r101, r102};
        Companion = new a();
    }

    public static VoteState valueOf(String r100) {
        return (VoteState) r27.a.a(VoteState.class, r100);
    }

    public static VoteState[] values() {
        return (VoteState[]) f89193a.clone();
    }

    public final long getCode() {
        return this.code;
    }

    public VoteState(String r100, int r101, long r102) {
        super(r100, r101);
        this.code = r102;
    }
}
