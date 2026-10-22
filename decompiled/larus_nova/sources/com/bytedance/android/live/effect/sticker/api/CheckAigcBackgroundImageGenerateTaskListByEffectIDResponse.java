package com.bytedance.android.live.effect.sticker.api;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse;", "", "()V", "taskMap", "", "", "Lcom/bytedance/android/live/effect/sticker/api/AigcBackgroundImageGenerateTaskMap;", "getTaskMap", "()Ljava/util/Map;", "setTaskMap", "(Ljava/util/Map;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse {

    @SerializedName("task_map_by_effect")
    private Map<Long, AigcBackgroundImageGenerateTaskMap> taskMap;

    public CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse() {
        this.taskMap = MapsKt.emptyMap();
    }

    public final Map<Long, AigcBackgroundImageGenerateTaskMap> getTaskMap() {
        return this.taskMap;
    }

    public final void setTaskMap(Map<Long, AigcBackgroundImageGenerateTaskMap> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskMap = r100;
    }
}
