package com.stepos.base.task.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskType {

    /* renamed from: a, reason: collision with root package name */
    public static final TaskType f6410a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TaskType[] f6411b;

    static {
        TaskType taskType = new TaskType("TEXT_GENERATION", 0);
        TaskType taskType2 = new TaskType("VISION_UNDERSTANDING", 1);
        TaskType taskType3 = new TaskType("EMBEDDING", 2);
        TaskType taskType4 = new TaskType("IMAGE_GENERATION", 3);
        TaskType taskType5 = new TaskType("OBJECT_DETECTION", 4);
        TaskType taskType6 = new TaskType("SPEECH_RECOGNITION", 5);
        TaskType taskType7 = new TaskType("SPEECH_SYNTHESIS", 6);
        TaskType taskType8 = new TaskType("GENERIC", 7);
        f6410a = taskType8;
        TaskType[] taskTypeArr = {taskType, taskType2, taskType3, taskType4, taskType5, taskType6, taskType7, taskType8};
        f6411b = taskTypeArr;
        a.a(taskTypeArr);
    }

    public TaskType() {
        throw null;
    }

    public static TaskType valueOf(String str) {
        return (TaskType) Enum.valueOf(TaskType.class, str);
    }

    public static TaskType[] values() {
        return (TaskType[]) f6411b.clone();
    }
}
