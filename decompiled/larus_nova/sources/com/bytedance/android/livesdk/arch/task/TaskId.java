package com.bytedance.android.livesdk.arch.task;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/arch/task/TaskId;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "MarkOnCreate", "MarkOnStart", "PreloadContent", "CheckShow", "SlotPk", "Record", "LogRecord", "LoadContent", "HandleBehavior", "MarkOnDestroy", "WakeUp", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskId extends Enum<TaskId> {
    public static final TaskId CheckShow = null;
    public static final TaskId HandleBehavior = null;
    public static final TaskId LoadContent = null;
    public static final TaskId LogRecord = null;
    public static final TaskId MarkOnCreate = null;
    public static final TaskId MarkOnDestroy = null;
    public static final TaskId MarkOnStart = null;
    public static final TaskId PreloadContent = null;
    public static final TaskId Record = null;
    public static final TaskId SlotPk = null;
    public static final TaskId WakeUp = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskId[] f103869a = null;
    private final String desc;

    public static TaskId valueOf(String r100) {
        return (TaskId) r27.a.a(TaskId.class, r100);
    }

    public static TaskId[] values() {
        return (TaskId[]) f103869a.clone();
    }

    static {
        TaskId r100 = new TaskId("MarkOnCreate", 0, "回调组件onCreate任务");
        MarkOnCreate = r100;
        TaskId r101 = new TaskId("MarkOnStart", 1, "回调组件onStart任务");
        MarkOnStart = r101;
        TaskId r102 = new TaskId("PreloadContent", 2, "组件内容预加载");
        PreloadContent = r102;
        TaskId r103 = new TaskId("CheckShow", 3, "检查组件是否可以展示");
        CheckShow = r103;
        TaskId r104 = new TaskId("SlotPk", 4, "槽位挤占逻辑");
        SlotPk = r104;
        TaskId r105 = new TaskId("Record", 5, "存档管理");
        Record = r105;
        TaskId r106 = new TaskId("LogRecord", 6, "打印record列表");
        LogRecord = r106;
        TaskId r107 = new TaskId("LoadContent", 7, "加载内容");
        LoadContent = r107;
        TaskId r108 = new TaskId("HandleBehavior", 8, "操作behavior");
        HandleBehavior = r108;
        TaskId r109 = new TaskId("MarkOnDestroy", 9, "回调组件onDestroy任务");
        MarkOnDestroy = r109;
        TaskId r110 = new TaskId("WakeUp", 10, "唤醒任务，取出等待队列中的组件展示");
        WakeUp = r110;
        f103869a = new TaskId[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getDesc() {
        return this.desc;
    }

    public TaskId(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
