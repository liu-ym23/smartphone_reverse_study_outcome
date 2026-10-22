package com.bytedance.android.live.broadcast.api.framework.model;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/OperationType;", "", GXAnimation.STATE_START, "PAUSE", "RESUME", "STOP", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType PAUSE = null;
    public static final OperationType RESUME = null;
    public static final OperationType START = null;
    public static final OperationType STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationType[] f58996a = null;

    static {
        OperationType r100 = new OperationType(GXAnimation.STATE_START, 0);
        START = r100;
        OperationType r101 = new OperationType("PAUSE", 1);
        PAUSE = r101;
        OperationType r102 = new OperationType("RESUME", 2);
        RESUME = r102;
        OperationType r103 = new OperationType("STOP", 3);
        STOP = r103;
        f58996a = new OperationType[]{r100, r101, r102, r103};
    }

    public static OperationType valueOf(String r100) {
        return (OperationType) a.a(OperationType.class, r100);
    }

    public static OperationType[] values() {
        return (OperationType[]) f58996a.clone();
    }

    public OperationType(String r100, int r101) {
        super(r100, r101);
    }
}
