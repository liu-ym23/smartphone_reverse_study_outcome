package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasSlideScene;", "", "(Ljava/lang/String;I)V", "IDLE", "DRAG", "SETTLING", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AtlasSlideScene extends Enum<AtlasSlideScene> {
    private static final /* synthetic */ AtlasSlideScene[] $VALUES = null;
    public static final AtlasSlideScene DRAG = null;
    public static final AtlasSlideScene IDLE = null;
    public static final AtlasSlideScene SETTLING = null;

    static {
        AtlasSlideScene r100 = new AtlasSlideScene("IDLE", 0);
        IDLE = r100;
        AtlasSlideScene r101 = new AtlasSlideScene("DRAG", 1);
        DRAG = r101;
        AtlasSlideScene r102 = new AtlasSlideScene("SETTLING", 2);
        SETTLING = r102;
        $VALUES = new AtlasSlideScene[]{r100, r101, r102};
    }

    public static AtlasSlideScene valueOf(String r100) {
        return (AtlasSlideScene) a.a(AtlasSlideScene.class, r100);
    }

    public static AtlasSlideScene[] values() {
        return (AtlasSlideScene[]) $VALUES.clone();
    }

    private AtlasSlideScene(String r100, int r101) {
        super(r100, r101);
    }
}
