package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasLiveScene;", "", "(Ljava/lang/String;I)V", "ENTER_FEED", "ENTER", "WATCH", "EXIT", "DEFAULT", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AtlasLiveScene extends Enum<AtlasLiveScene> {
    private static final /* synthetic */ AtlasLiveScene[] $VALUES = null;
    public static final AtlasLiveScene DEFAULT = null;
    public static final AtlasLiveScene ENTER = null;
    public static final AtlasLiveScene ENTER_FEED = null;
    public static final AtlasLiveScene EXIT = null;
    public static final AtlasLiveScene WATCH = null;

    static {
        AtlasLiveScene r100 = new AtlasLiveScene("ENTER_FEED", 0);
        ENTER_FEED = r100;
        AtlasLiveScene r101 = new AtlasLiveScene("ENTER", 1);
        ENTER = r101;
        AtlasLiveScene r102 = new AtlasLiveScene("WATCH", 2);
        WATCH = r102;
        AtlasLiveScene r103 = new AtlasLiveScene("EXIT", 3);
        EXIT = r103;
        AtlasLiveScene r104 = new AtlasLiveScene("DEFAULT", 4);
        DEFAULT = r104;
        $VALUES = new AtlasLiveScene[]{r100, r101, r102, r103, r104};
    }

    public static AtlasLiveScene valueOf(String r100) {
        return (AtlasLiveScene) a.a(AtlasLiveScene.class, r100);
    }

    public static AtlasLiveScene[] values() {
        return (AtlasLiveScene[]) $VALUES.clone();
    }

    private AtlasLiveScene(String r100, int r101) {
        super(r100, r101);
    }
}
