package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasCoreScene;", "", "bit", "", "(Ljava/lang/String;II)V", "getBit", "()I", "ENTER_ROOM", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AtlasCoreScene extends Enum<AtlasCoreScene> {
    private static final /* synthetic */ AtlasCoreScene[] $VALUES = null;
    public static final AtlasCoreScene ENTER_ROOM = null;
    private final int bit;

    static {
        AtlasCoreScene r100 = new AtlasCoreScene("ENTER_ROOM", 0, 1);
        ENTER_ROOM = r100;
        $VALUES = new AtlasCoreScene[]{r100};
    }

    public static AtlasCoreScene valueOf(String r100) {
        return (AtlasCoreScene) a.a(AtlasCoreScene.class, r100);
    }

    public static AtlasCoreScene[] values() {
        return (AtlasCoreScene[]) $VALUES.clone();
    }

    public final int getBit() {
        return this.bit;
    }

    private AtlasCoreScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.bit = r102;
    }
}
