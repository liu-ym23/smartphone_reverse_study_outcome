package com.bytedance.android.live.broadcast.corepath;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/corepath/TaskLevel;", "", "System", "Normal", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskLevel extends Enum<TaskLevel> {
    public static final TaskLevel Normal = null;
    public static final TaskLevel System = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskLevel[] f59094a = null;

    static {
        TaskLevel r100 = new TaskLevel("System", 0);
        System = r100;
        TaskLevel r101 = new TaskLevel("Normal", 1);
        Normal = r101;
        f59094a = new TaskLevel[]{r100, r101};
    }

    public static TaskLevel valueOf(String r100) {
        return (TaskLevel) a.a(TaskLevel.class, r100);
    }

    public static TaskLevel[] values() {
        return (TaskLevel[]) f59094a.clone();
    }

    public TaskLevel(String r100, int r101) {
        super(r100, r101);
    }
}
