package com.bytedance.android.service.manager.push.trace;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum PushTraceSceneType extends Enum<PushTraceSceneType> {
    private static final /* synthetic */ PushTraceSceneType[] $VALUES = null;
    public static final PushTraceSceneType ALLIANCE_WAKEUP = null;
    public static final PushTraceSceneType PULL = null;
    public static final PushTraceSceneType PUSH = null;

    static {
        PushTraceSceneType r100 = new PushTraceSceneType("ALLIANCE_WAKEUP", 0);
        ALLIANCE_WAKEUP = r100;
        PushTraceSceneType r101 = new PushTraceSceneType("PULL", 1);
        PULL = r101;
        PushTraceSceneType r102 = new PushTraceSceneType(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 2);
        PUSH = r102;
        $VALUES = new PushTraceSceneType[]{r100, r101, r102};
    }

    public static PushTraceSceneType[] values() {
        return (PushTraceSceneType[]) $VALUES.clone();
    }

    public static PushTraceSceneType valueOf(String r100) {
        return (PushTraceSceneType) a.a(PushTraceSceneType.class, r100);
    }

    private PushTraceSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
