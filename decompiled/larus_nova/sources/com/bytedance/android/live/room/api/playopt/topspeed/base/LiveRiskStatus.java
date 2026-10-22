package com.bytedance.android.live.room.api.playopt.topspeed.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/playopt/topspeed/base/LiveRiskStatus;", "", "", "code", "I", "getCode", "()I", "LOW_RISK", "HIGH_RISK", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRiskStatus extends Enum<LiveRiskStatus> {
    public static final LiveRiskStatus HIGH_RISK = null;
    public static final LiveRiskStatus LOW_RISK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRiskStatus[] f99077a = null;
    private final int code;

    static {
        LiveRiskStatus r100 = new LiveRiskStatus("LOW_RISK", 0, 0);
        LOW_RISK = r100;
        LiveRiskStatus r101 = new LiveRiskStatus("HIGH_RISK", 1, 1);
        HIGH_RISK = r101;
        f99077a = new LiveRiskStatus[]{r100, r101};
    }

    public static LiveRiskStatus valueOf(String r100) {
        return (LiveRiskStatus) a.a(LiveRiskStatus.class, r100);
    }

    public static LiveRiskStatus[] values() {
        return (LiveRiskStatus[]) f99077a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public LiveRiskStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
