package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasSceneSensor;", "", "()V", "coreSceneState", "", "isAtlasCoreScene", "", "onFeedEnter", "", "onFeedExit", "onModuleStart", TextureRenderKeys.KEY_MODULE_NAME, "", "onModuleStop", "release", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AtlasSceneSensor {
    public static final AtlasSceneSensor INSTANCE = null;
    private static int coreSceneState;

    private AtlasSceneSensor() {
    }

    public final void onFeedExit() {
    }

    public final void release() {
        coreSceneState = 0;
    }

    static {
        INSTANCE = new AtlasSceneSensor();
    }

    public final boolean isAtlasCoreScene() {
        if (coreSceneState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onFeedEnter() {
        AtlasAsyncExecutor.INSTANCE.onLiveSceneChanged(AtlasLiveScene.ENTER_FEED);
    }

    public final void onModuleStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        if (Intrinsics.areEqual(r100, IPerformanceManager.MODULE_ENTER_ROOM) == false) goto L6;
        coreSceneState |= AtlasCoreScene.ENTER_ROOM.getBit();
        AtlasAsyncExecutor.INSTANCE.onLiveSceneChanged(AtlasLiveScene.ENTER);
        return;
    }

    public final void onModuleStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        if (Intrinsics.areEqual(r100, IPerformanceManager.MODULE_ENTER_ROOM) == false) goto L6;
        coreSceneState &= ~AtlasCoreScene.ENTER_ROOM.getBit();
        AtlasAsyncExecutor.INSTANCE.onLiveSceneChanged(AtlasLiveScene.WATCH);
        return;
    }
}
