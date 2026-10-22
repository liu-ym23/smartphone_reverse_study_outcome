package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/StateType;", "", "STREAMING", "PAUSED", "STOPPED", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StateType extends Enum<StateType> {
    public static final StateType PAUSED = null;
    public static final StateType STOPPED = null;
    public static final StateType STREAMING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StateType[] f58999a = null;

    static {
        StateType r100 = new StateType("STREAMING", 0);
        STREAMING = r100;
        StateType r101 = new StateType("PAUSED", 1);
        PAUSED = r101;
        StateType r102 = new StateType("STOPPED", 2);
        STOPPED = r102;
        f58999a = new StateType[]{r100, r101, r102};
    }

    public static StateType valueOf(String r100) {
        return (StateType) a.a(StateType.class, r100);
    }

    public static StateType[] values() {
        return (StateType[]) f58999a.clone();
    }

    public StateType(String r100, int r101) {
        super(r100, r101);
    }
}
