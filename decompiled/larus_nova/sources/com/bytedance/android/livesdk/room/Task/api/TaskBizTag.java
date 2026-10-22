package com.bytedance.android.livesdk.room.Task.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/room/Task/api/TaskBizTag;", "", "ENTER_ROOM_CORE", "LIVE_PLAY_ACTIVITY_SCENE", "TECH", "COMMON", "COMMERCE", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskBizTag extends Enum<TaskBizTag> {
    public static final TaskBizTag COMMERCE = null;
    public static final TaskBizTag COMMON = null;
    public static final TaskBizTag ENTER_ROOM_CORE = null;
    public static final TaskBizTag LIVE_PLAY_ACTIVITY_SCENE = null;
    public static final TaskBizTag TECH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskBizTag[] f157554a = null;

    static {
        TaskBizTag r100 = new TaskBizTag("ENTER_ROOM_CORE", 0);
        ENTER_ROOM_CORE = r100;
        TaskBizTag r101 = new TaskBizTag("LIVE_PLAY_ACTIVITY_SCENE", 1);
        LIVE_PLAY_ACTIVITY_SCENE = r101;
        TaskBizTag r102 = new TaskBizTag("TECH", 2);
        TECH = r102;
        TaskBizTag r103 = new TaskBizTag("COMMON", 3);
        COMMON = r103;
        TaskBizTag r104 = new TaskBizTag("COMMERCE", 4);
        COMMERCE = r104;
        f157554a = new TaskBizTag[]{r100, r101, r102, r103, r104};
    }

    public static TaskBizTag valueOf(String r100) {
        return (TaskBizTag) a.a(TaskBizTag.class, r100);
    }

    public static TaskBizTag[] values() {
        return (TaskBizTag[]) f157554a.clone();
    }

    public TaskBizTag(String r100, int r101) {
        super(r100, r101);
    }
}
