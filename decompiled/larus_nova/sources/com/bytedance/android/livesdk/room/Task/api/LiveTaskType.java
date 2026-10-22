package com.bytedance.android.livesdk.room.Task.api;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/room/Task/api/LiveTaskType;", "", "BOOT", AccountType.MAIN, "POST", BridgeSyncType.ASYNC, "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveTaskType extends Enum<LiveTaskType> {
    public static final LiveTaskType ASYNC = null;
    public static final LiveTaskType BOOT = null;
    public static final LiveTaskType MAIN = null;
    public static final LiveTaskType POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveTaskType[] f157553a = null;

    static {
        LiveTaskType r100 = new LiveTaskType("BOOT", 0);
        BOOT = r100;
        LiveTaskType r101 = new LiveTaskType(AccountType.MAIN, 1);
        MAIN = r101;
        LiveTaskType r102 = new LiveTaskType("POST", 2);
        POST = r102;
        LiveTaskType r103 = new LiveTaskType(BridgeSyncType.ASYNC, 3);
        ASYNC = r103;
        f157553a = new LiveTaskType[]{r100, r101, r102, r103};
    }

    public static LiveTaskType valueOf(String r100) {
        return (LiveTaskType) a.a(LiveTaskType.class, r100);
    }

    public static LiveTaskType[] values() {
        return (LiveTaskType[]) f157553a.clone();
    }

    public LiveTaskType(String r100, int r101) {
        super(r100, r101);
    }
}
