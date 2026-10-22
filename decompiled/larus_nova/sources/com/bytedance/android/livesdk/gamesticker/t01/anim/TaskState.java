package com.bytedance.android.livesdk.gamesticker.t01.anim;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/anim/TaskState;", "", "CREATE", GXAnimation.STATE_START, GXAnimation.STATE_END, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskState extends Enum<TaskState> {
    public static final TaskState CREATE = null;
    public static final TaskState END = null;
    public static final TaskState START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskState[] f125752a = null;

    static {
        TaskState r100 = new TaskState("CREATE", 0);
        CREATE = r100;
        TaskState r101 = new TaskState(GXAnimation.STATE_START, 1);
        START = r101;
        TaskState r102 = new TaskState(GXAnimation.STATE_END, 2);
        END = r102;
        f125752a = new TaskState[]{r100, r101, r102};
    }

    public static TaskState valueOf(String r100) {
        return (TaskState) r27.a.a(TaskState.class, r100);
    }

    public static TaskState[] values() {
        return (TaskState[]) f125752a.clone();
    }

    public TaskState(String r100, int r101) {
        super(r100, r101);
    }
}
