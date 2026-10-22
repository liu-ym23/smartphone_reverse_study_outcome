package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum TaskType extends Enum<TaskType> implements Parcelable {
    private static final /* synthetic */ d.d.a $ENTRIES = null;
    private static final /* synthetic */ TaskType[] $VALUES = null;
    public static final TaskType COMPLEX = null;
    public static final Parcelable.Creator<TaskType> CREATOR = null;
    public static final TaskType OAUTO = null;
    public static final TaskType SIMPLE = null;

    private static final /* synthetic */ TaskType[] $values() {
        return new TaskType[]{SIMPLE, OAUTO, COMPLEX};
    }

    public static d.d.a<TaskType> getEntries() {
        return $ENTRIES;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(name());
    }

    private TaskType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SIMPLE = new TaskType("SIMPLE", 0);
        OAUTO = new TaskType("OAUTO", 1);
        COMPLEX = new TaskType("COMPLEX", 2);
        TaskType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static TaskType valueOf(String r2) {
        return (TaskType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TaskType.class, r2), TaskType.class, "com.obric.aiagent.plugin");
    }

    public static TaskType[] values() {
        return (TaskType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TaskType[].class, "com.obric.aiagent.plugin");
    }
}
