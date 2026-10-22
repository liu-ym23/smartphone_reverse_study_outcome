package com.stepos.ailauncher.taskstore.entity;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "MARKDOWN", "HTML", "IMAGE", "VIDEO", "AUDIO", "FILE", "CODE", "LINK", "SLIDES", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoPartType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoPartType[] $VALUES;

    @SerializedName("text")
    public static final TaskInfoPartType TEXT = new TaskInfoPartType("TEXT", 0);

    @SerializedName("markdown")
    public static final TaskInfoPartType MARKDOWN = new TaskInfoPartType("MARKDOWN", 1);

    @SerializedName("html")
    public static final TaskInfoPartType HTML = new TaskInfoPartType("HTML", 2);

    @SerializedName("image")
    public static final TaskInfoPartType IMAGE = new TaskInfoPartType("IMAGE", 3);

    @SerializedName("video")
    public static final TaskInfoPartType VIDEO = new TaskInfoPartType("VIDEO", 4);

    @SerializedName("audio")
    public static final TaskInfoPartType AUDIO = new TaskInfoPartType("AUDIO", 5);

    @SerializedName(Const.STR_FILE)
    public static final TaskInfoPartType FILE = new TaskInfoPartType("FILE", 6);

    @SerializedName("code")
    public static final TaskInfoPartType CODE = new TaskInfoPartType("CODE", 7);

    @SerializedName("link")
    public static final TaskInfoPartType LINK = new TaskInfoPartType("LINK", 8);

    @SerializedName("slides")
    public static final TaskInfoPartType SLIDES = new TaskInfoPartType("SLIDES", 9);

    private static final /* synthetic */ TaskInfoPartType[] $values() {
        return new TaskInfoPartType[]{TEXT, MARKDOWN, HTML, IMAGE, VIDEO, AUDIO, FILE, CODE, LINK, SLIDES};
    }

    static {
        TaskInfoPartType[] taskInfoPartTypeArr$values = $values();
        $VALUES = taskInfoPartTypeArr$values;
        $ENTRIES = a.a(taskInfoPartTypeArr$values);
    }

    private TaskInfoPartType(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoPartType> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoPartType valueOf(String str) {
        return (TaskInfoPartType) Enum.valueOf(TaskInfoPartType.class, str);
    }

    public static TaskInfoPartType[] values() {
        return (TaskInfoPartType[]) $VALUES.clone();
    }
}
