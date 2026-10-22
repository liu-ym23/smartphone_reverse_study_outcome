package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\b\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0006\u0010\u001a\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasAsyncExecutor;", "", "()V", "TAG", "", "atlasTasks", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasTask;", "init", "", "liveSceneState", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasLiveScene;", "liveSlideState", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasSlideScene;", "state", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasSceneState;", "check", "executeLiveAsyncTask", "", "name", "asyncTask", "Ljava/lang/Runnable;", "executeLiveTask", "atlasTask", "isAsync", "mayRunTasks", LiveCommonConstants.REASON_ON_DEDTROY, "onLiveSceneChanged", "scene", "onStateChanged", "runTask", "task", "runTasks", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AtlasAsyncExecutor {
    public static final AtlasAsyncExecutor INSTANCE = null;
    public static final String TAG = "AtlasAsyncExecutor";
    private static final LinkedBlockingQueue<AtlasTask> atlasTasks = null;
    private static boolean init;
    private static AtlasLiveScene liveSceneState;
    private static AtlasSlideScene liveSlideState;
    private static AtlasSceneState state;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AtlasSceneState.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[AtlasSceneState.IDLE.ordinal()] = 1;
        }
    }

    private AtlasAsyncExecutor() {
    }

    public final void init() {
        init = true;
        ALogger.i(TAG, "init success");
    }

    static {
        INSTANCE = new AtlasAsyncExecutor();
        atlasTasks = new LinkedBlockingQueue();
        state = AtlasSceneState.IDLE;
        liveSceneState = AtlasLiveScene.DEFAULT;
        liveSlideState = AtlasSlideScene.IDLE;
    }

    private final boolean check() {
        if (init == true) goto L6;
        return false;
    L6:
        return true;
    }

    private final void mayRunTasks() {
        if (atlasTasks.isEmpty() == false) goto L5;
        return;
    L5:
        AtlasSceneState r100 = state;
        if (WhenMappings.$EnumSwitchMapping$0[r100.ordinal()] != 1) goto L10;
        runTasks();
        return;
    }

    private final void onStateChanged() {
        if (liveSceneState != AtlasLiveScene.ENTER_FEED) goto L5;
    L10:
        state = AtlasSceneState.BUSY;
    L11:
        ALogger.d(TAG, "onStateChanged " + state);
        mayRunTasks();
        return;
    L5:
        if (liveSceneState == AtlasLiveScene.ENTER) goto L10;
        if (liveSlideState == AtlasSlideScene.SETTLING) goto L10;
        state = AtlasSceneState.IDLE;
        goto L11
    }

    private final void runTasks() {
    L3:
        LinkedBlockingQueue<AtlasTask> r100 = atlasTasks;
        if (r100.isEmpty() == true) goto L9;
        AtlasTask r101 = r100.take();     // Catch: InterruptedException -> L7
        runTask(r101.getTask());     // Catch: InterruptedException -> L7
        ALogger.d(TAG, "runTask submit " + r101.getName());     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        ALogger.e(TAG, "runTask error:" + e.getMessage());
        goto L3
    }

    public final void onDestroy() {
        if (check() == true) goto L5;
        return;
    L5:
        init = false;
        liveSlideState = AtlasSlideScene.IDLE;
        liveSceneState = AtlasLiveScene.DEFAULT;
        state = AtlasSceneState.IDLE;
        atlasTasks.clear();
        ALogger.i(TAG, "onDestroy success");
    }

    private final void runTask(Runnable r100) {
        TTExecutors.getNormalExecutor().submit(r100);
    }

    public final void onLiveSceneChanged(AtlasLiveScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (check() == true) goto L5;
        return;
    L5:
        liveSceneState = r100;
        ALogger.d(TAG, "onLiveSceneChanged " + r100);
        onStateChanged();
    }

    public final void executeLiveAsyncTask(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "asyncTask");
        executeLiveTask(r100, r101, true);
    }

    public final void executeLiveTask(String r100, Runnable r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "atlasTask");
        if (check() == true) goto L6;
        runTask(r101);
        ALogger.i(TAG, "runTask origin:" + r100);
        return;
    L6:
        AtlasTask r103 = new AtlasTask(r100, r101);
        atlasTasks.put(r103);     // Catch: Exception -> L9
        ALogger.i(TAG, "runTask store:" + r100);     // Catch: Exception -> L9
        mayRunTasks();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r103.run();
        ALogger.e(TAG, "runTask error:" + r100 + ' ' + e.getMessage());
    }
}
