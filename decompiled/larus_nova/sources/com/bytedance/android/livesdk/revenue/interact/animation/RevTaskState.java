package com.bytedance.android.livesdk.revenue.interact.animation;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/interact/animation/RevTaskState;", "", GXAnimation.STATE_START, "COMPLETE", "CANCEL", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevTaskState extends Enum<RevTaskState> {
    public static final RevTaskState CANCEL = null;
    public static final RevTaskState COMPLETE = null;
    public static final RevTaskState START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevTaskState[] f157166a = null;

    static {
        RevTaskState r100 = new RevTaskState(GXAnimation.STATE_START, 0);
        START = r100;
        RevTaskState r101 = new RevTaskState("COMPLETE", 1);
        COMPLETE = r101;
        RevTaskState r102 = new RevTaskState("CANCEL", 2);
        CANCEL = r102;
        f157166a = new RevTaskState[]{r100, r101, r102};
    }

    public static RevTaskState valueOf(String r100) {
        return (RevTaskState) a.a(RevTaskState.class, r100);
    }

    public static RevTaskState[] values() {
        return (RevTaskState[]) f157166a.clone();
    }

    public RevTaskState(String r100, int r101) {
        super(r100, r101);
    }
}
