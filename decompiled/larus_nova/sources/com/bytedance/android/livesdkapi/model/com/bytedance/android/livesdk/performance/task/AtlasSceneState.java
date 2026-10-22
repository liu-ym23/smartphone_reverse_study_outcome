package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasSceneState;", "", "(Ljava/lang/String;I)V", "IDLE", "BUSY", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum AtlasSceneState extends Enum<AtlasSceneState> {
    private static final /* synthetic */ AtlasSceneState[] $VALUES = null;
    public static final AtlasSceneState BUSY = null;
    public static final AtlasSceneState IDLE = null;

    static {
        AtlasSceneState r100 = new AtlasSceneState("IDLE", 0);
        IDLE = r100;
        AtlasSceneState r101 = new AtlasSceneState("BUSY", 1);
        BUSY = r101;
        $VALUES = new AtlasSceneState[]{r100, r101};
    }

    public static AtlasSceneState valueOf(String r100) {
        return (AtlasSceneState) a.a(AtlasSceneState.class, r100);
    }

    public static AtlasSceneState[] values() {
        return (AtlasSceneState[]) $VALUES.clone();
    }

    private AtlasSceneState(String r100, int r101) {
        super(r100, r101);
    }
}
