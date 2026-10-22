package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/performance/task/AtlasTask;", "", "name", "", "task", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/Runnable;)V", "getName", "()Ljava/lang/String;", "getTask", "run", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AtlasTask {
    private final String name;
    private final Runnable task;

    public final void run() {
        this.task.run();
    }

    public final String getName() {
        return this.name;
    }

    public final Runnable getTask() {
        return this.task;
    }

    public AtlasTask(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "task");
        this.name = r100;
        this.task = r101;
    }
}
