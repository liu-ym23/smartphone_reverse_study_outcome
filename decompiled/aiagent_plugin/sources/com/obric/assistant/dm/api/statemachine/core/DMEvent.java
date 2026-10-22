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

/* JADX INFO: compiled from: DMEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DMEvent implements Parcelable {
    public static final Parcelable.Creator<DMEvent> CREATOR = null;
    private final Map<String, String> extra;
    private final TaskId taskId;
    private final long timestamp;

    /* JADX INFO: compiled from: DMEvent.kt */
    public static final class Creator implements Parcelable.Creator<DMEvent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMEvent createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            if (r7.readInt() != 0) goto L5;
            TaskId r6 = null;
        L6:
            TaskId r8 = (TaskId) ZeusTransformUtils.preCheckCast(r6, TaskId.class, "com.obric.aiagent.plugin");
            int r0 = r7.readInt();
            LinkedHashMap r2 = new LinkedHashMap(r0);
            int r3 = 0;
        L7:
            if (r3 == r0) goto L10;
            r2.put(r7.readString(), r7.readString());
            r3 = r3 + 1;
            goto L7
        L10:
            return new DMEvent(r8, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"), r7.readLong());
        L5:
            r6 = TaskId.CREATOR.createFromParcel(r7);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DMEvent[] newArray(int r1) {
            return new DMEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DMEvent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public DMEvent() {
        this(null, null, 0, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEventName() {
        return "DMEvent";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        TaskId r0 = this.taskId;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Map<String, String> r7 = this.extra;
        r5.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r8.next();
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        r5.writeLong(this.timestamp);
        return;
    L5:
        r5.writeInt(1);
        r0.writeToParcel(r5, r6);
        goto L6
    }

    public DMEvent(TaskId r3, Map<String, String> r4, long r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "extra");
        this.taskId = r3;
        this.extra = r6;
        this.timestamp = r5;
    }

    public TaskId getTaskId() {
        return this.taskId;
    }

    public /* synthetic */ DMEvent(TaskId r2, Map r3, long r4, int r6, h r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r5 = ao.b();
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = System.currentTimeMillis();
    L11:
        this(r2, r5, r4);
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return getEventName() + "(taskId=" + getTaskId() + ", timestamp=" + getTimestamp() + ", extra=" + getExtra() + ')';
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, DMEvent.class) == true) goto L9;
        return false;
    L9:
        if (o.a(getEventName(), ((DMEvent) ZeusTransformUtils.preCheckCast(r7, DMEvent.class, "com.obric.aiagent.plugin")).getEventName()) == false) goto L16;
        if (o.a(getTaskId(), ((DMEvent) ZeusTransformUtils.preCheckCast(r7, DMEvent.class, "com.obric.aiagent.plugin")).getTaskId()) == false) goto L16;
        if (o.a(getExtra(), ((DMEvent) ZeusTransformUtils.preCheckCast(r7, DMEvent.class, "com.obric.aiagent.plugin")).getExtra()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = getEventName().hashCode() * 31;
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
