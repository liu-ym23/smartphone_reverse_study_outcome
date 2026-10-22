package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes3.dex */
public class State implements Parcelable {
    public static final Parcelable.Creator<State> CREATOR = null;
    private final Map<String, String> extra;
    private final int state;
    private final TaskId taskId;

    /* JADX INFO: compiled from: State.kt */
    public static final class Creator implements Parcelable.Creator<State> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final State createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            if (r8.readInt() != 0) goto L5;
            TaskId r7 = null;
        L6:
            TaskId r9 = (TaskId) ZeusTransformUtils.preCheckCast(r7, TaskId.class, "com.obric.aiagent.plugin");
            int r0 = r8.readInt();
            int r2 = r8.readInt();
            LinkedHashMap r3 = new LinkedHashMap(r2);
            int r4 = 0;
        L7:
            if (r4 == r2) goto L10;
            r3.put(r8.readString(), r8.readString());
            r4 = r4 + 1;
            goto L7
        L10:
            return new State(r9, r0, (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
        L5:
            r7 = TaskId.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ State createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final State[] newArray(int r1) {
            return new State[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ State[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public State() {
        this(null, 0, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getStateName() {
        return "State";
    }

    public boolean isCompletedOrCanceled() {
        return false;
    }

    public boolean isIdle() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        TaskId r0 = this.taskId;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeInt(this.state);
        Map<String, String> r3 = this.extra;
        r4.writeInt(r3.size());
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, String> r7 = r6.next();
        r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public State(TaskId r3, int r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "extra");
        this.taskId = r3;
        this.state = r4;
        this.extra = r6;
    }

    public TaskId getTaskId() {
        return this.taskId;
    }

    public int getState() {
        return this.state;
    }

    public /* synthetic */ State(TaskId r2, int r3, Map r4, int r5, h r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = ao.b();
    L11:
        this(r2, r3, r7);
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String toString() {
        return getStateName() + "(taskId=" + getTaskId() + ", extra=" + getExtra() + ')';
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, State.class) == true) goto L9;
        return false;
    L9:
        if (o.a(getStateName(), ((State) ZeusTransformUtils.preCheckCast(r7, State.class, "com.obric.aiagent.plugin")).getStateName()) == false) goto L16;
        if (o.a(getTaskId(), ((State) ZeusTransformUtils.preCheckCast(r7, State.class, "com.obric.aiagent.plugin")).getTaskId()) == false) goto L16;
        if (o.a(getExtra(), ((State) ZeusTransformUtils.preCheckCast(r7, State.class, "com.obric.aiagent.plugin")).getExtra()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = getStateName().hashCode() * 31;
        TaskId r1 = getTaskId();
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + getExtra().hashCode();
    L5:
        r2 = 0;
        goto L7
    }
}
