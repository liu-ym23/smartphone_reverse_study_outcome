package com.stepos.ailauncher.taskstore.entity;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", "", "<init>", "(Ljava/lang/String;I)V", "INLINE", "URL", "FILE", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoContentType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoContentType[] $VALUES;

    @SerializedName("inline")
    public static final TaskInfoContentType INLINE = new TaskInfoContentType("INLINE", 0);

    @SerializedName("url")
    public static final TaskInfoContentType URL = new TaskInfoContentType("URL", 1);

    @SerializedName(Const.STR_FILE)
    public static final TaskInfoContentType FILE = new TaskInfoContentType("FILE", 2);

    private static final /* synthetic */ TaskInfoContentType[] $values() {
        return new TaskInfoContentType[]{INLINE, URL, FILE};
    }

    static {
        TaskInfoContentType[] taskInfoContentTypeArr$values = $values();
        $VALUES = taskInfoContentTypeArr$values;
        $ENTRIES = a.a(taskInfoContentTypeArr$values);
    }

    private TaskInfoContentType(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoContentType> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoContentType valueOf(String str) {
        return (TaskInfoContentType) Enum.valueOf(TaskInfoContentType.class, str);
    }

    public static TaskInfoContentType[] values() {
        return (TaskInfoContentType[]) $VALUES.clone();
    }
}
