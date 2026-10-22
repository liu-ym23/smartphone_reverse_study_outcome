package com.bytedance.android.ec.hybrid.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/hybrid/monitor/HybridMonitorScenes;", "", "", "sceneName", "Ljava/lang/String;", "getSceneName", "()Ljava/lang/String;", "EC_STORE_FPS", "EC_WINDOW_FPS", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HybridMonitorScenes extends Enum<HybridMonitorScenes> {
    public static final HybridMonitorScenes EC_STORE_FPS = null;
    public static final HybridMonitorScenes EC_WINDOW_FPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HybridMonitorScenes[] f47546a = null;
    private final String sceneName;

    static {
        HybridMonitorScenes r100 = new HybridMonitorScenes("EC_STORE_FPS", 0, "ec_store_fps");
        EC_STORE_FPS = r100;
        HybridMonitorScenes r101 = new HybridMonitorScenes("EC_WINDOW_FPS", 1, "ec_window_fps");
        EC_WINDOW_FPS = r101;
        f47546a = new HybridMonitorScenes[]{r100, r101};
    }

    public static HybridMonitorScenes valueOf(String r100) {
        return (HybridMonitorScenes) r27.a.a(HybridMonitorScenes.class, r100);
    }

    public static HybridMonitorScenes[] values() {
        return (HybridMonitorScenes[]) f47546a.clone();
    }

    public final String getSceneName() {
        return this.sceneName;
    }

    public HybridMonitorScenes(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneName = r102;
    }
}
