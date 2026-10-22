package com.bytedance.android.live.effect.sticker.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/CheckAigcBackgroundImageGenerateTaskByTaskIDResponse;", "", "()V", "taskMap", "Lcom/bytedance/android/live/effect/sticker/api/AigcBackgroundImageGenerateTaskMap;", "getTaskMap", "()Lcom/bytedance/android/live/effect/sticker/api/AigcBackgroundImageGenerateTaskMap;", "setTaskMap", "(Lcom/bytedance/android/live/effect/sticker/api/AigcBackgroundImageGenerateTaskMap;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckAigcBackgroundImageGenerateTaskByTaskIDResponse {

    @SerializedName("task_map")
    private AigcBackgroundImageGenerateTaskMap taskMap;

    public CheckAigcBackgroundImageGenerateTaskByTaskIDResponse() {
        this.taskMap = new AigcBackgroundImageGenerateTaskMap();
    }

    public final AigcBackgroundImageGenerateTaskMap getTaskMap() {
        return this.taskMap;
    }

    public final void setTaskMap(AigcBackgroundImageGenerateTaskMap r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskMap = r100;
    }
}
