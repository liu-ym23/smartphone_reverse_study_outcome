package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TaskState;", "", GXAnimation.STATE_START, "COMPLETE", "CANCEL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TaskState extends Enum<TaskState> {
    public static final TaskState CANCEL = null;
    public static final TaskState COMPLETE = null;
    public static final TaskState START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskState[] f79371a = null;

    static {
        TaskState r100 = new TaskState(GXAnimation.STATE_START, 0);
        START = r100;
        TaskState r101 = new TaskState("COMPLETE", 1);
        COMPLETE = r101;
        TaskState r102 = new TaskState("CANCEL", 2);
        CANCEL = r102;
        f79371a = new TaskState[]{r100, r101, r102};
    }

    public static TaskState valueOf(String r100) {
        return (TaskState) r27.a.a(TaskState.class, r100);
    }

    public static TaskState[] values() {
        return (TaskState[]) f79371a.clone();
    }

    public TaskState(String r100, int r101) {
        super(r100, r101);
    }
}
