package com.bytedance.android.live.recharge.platform.core.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/config/TaskGoldRewardReqFrom;", "", "", "value", "I", "getValue", "()I", "ReqFromUndefine", "GoldToolBar", "ExchangePopup", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TaskGoldRewardReqFrom extends Enum<TaskGoldRewardReqFrom> {
    public static final TaskGoldRewardReqFrom ExchangePopup = null;
    public static final TaskGoldRewardReqFrom GoldToolBar = null;
    public static final TaskGoldRewardReqFrom ReqFromUndefine = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskGoldRewardReqFrom[] f90230a = null;
    private final int value;

    static {
        TaskGoldRewardReqFrom r100 = new TaskGoldRewardReqFrom("ReqFromUndefine", 0, 0);
        ReqFromUndefine = r100;
        TaskGoldRewardReqFrom r101 = new TaskGoldRewardReqFrom("GoldToolBar", 1, 1);
        GoldToolBar = r101;
        TaskGoldRewardReqFrom r102 = new TaskGoldRewardReqFrom("ExchangePopup", 2, 2);
        ExchangePopup = r102;
        f90230a = new TaskGoldRewardReqFrom[]{r100, r101, r102};
    }

    public static TaskGoldRewardReqFrom valueOf(String r100) {
        return (TaskGoldRewardReqFrom) a.a(TaskGoldRewardReqFrom.class, r100);
    }

    public static TaskGoldRewardReqFrom[] values() {
        return (TaskGoldRewardReqFrom[]) f90230a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TaskGoldRewardReqFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
