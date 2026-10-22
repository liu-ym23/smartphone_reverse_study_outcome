package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ObricConditionalTaskRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricConditionalTaskSweepRequest implements Parcelable {
    public static final Parcelable.Creator<ObricConditionalTaskSweepRequest> CREATOR = null;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("task_list")
    private final List<ObricConditionalTaskCreateRequest> taskList;

    /* JADX INFO: compiled from: ObricConditionalTaskRequest.kt */
    public static final class Creator implements Parcelable.Creator<ObricConditionalTaskSweepRequest> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskSweepRequest createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            LinkedHashMap r0 = null;
            int r1 = 0;
            if (r7.readInt() != 0) goto L5;
            ArrayList r2 = null;
        L8:
            List r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
            if (r7.readInt() == 0) goto L16;
            int r3 = r7.readInt();
            LinkedHashMap r4 = new LinkedHashMap(r3);
        L12:
            if (r1 == r3) goto L14;
            r4.put(r7.readString(), r7.readString());
            r1 = r1 + 1;
            goto L12
        L14:
            r0 = r4;
        L16:
            return new ObricConditionalTaskSweepRequest(r6, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        L5:
            int r8 = r7.readInt();
            r2 = new ArrayList(r8);
            int r5 = 0;
        L6:
            if (r5 == r8) goto L8;
            r2.add(ObricConditionalTaskCreateRequest.CREATOR.createFromParcel(r7));
            r5 = r5 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricConditionalTaskSweepRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskSweepRequest[] newArray(int r1) {
            return new ObricConditionalTaskSweepRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricConditionalTaskSweepRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricConditionalTaskSweepRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObricConditionalTaskSweepRequest copy$default(ObricConditionalTaskSweepRequest r1, List r2, Map r3, int r4, Object r5) {
        List<ObricConditionalTaskCreateRequest> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.taskList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.extra;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<ObricConditionalTaskCreateRequest> component1() {
        return this.taskList;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    public final ObricConditionalTaskSweepRequest copy(List<ObricConditionalTaskCreateRequest> r2, Map<String, String> r3) {
        return new ObricConditionalTaskSweepRequest((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ObricConditionalTaskSweepRequest.class) == true) goto L8;
        return false;
    L8:
        ObricConditionalTaskSweepRequest r6 = (ObricConditionalTaskSweepRequest) ZeusTransformUtils.preCheckCast(r5, ObricConditionalTaskSweepRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskList, r6.taskList) == true) goto L12;
        return false;
    L12:
        if (o.a(this.extra, r6.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<ObricConditionalTaskCreateRequest> r0 = this.taskList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.extra;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricConditionalTaskSweepRequest(taskList=" + this.taskList + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r7, int r8) {
        o.e(r7, "dest");
        List<ObricConditionalTaskCreateRequest> r0 = this.taskList;
        if (r0 != null) goto L5;
        r7.writeInt(0);
    L9:
        Map<String, String> r6 = this.extra;
        if (r6 != null) goto L12;
        r7.writeInt(0);
        return;
    L12:
        r7.writeInt(1);
        r7.writeInt(r6.size());
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        Map.Entry<String, String> r10 = r9.next();
        r7.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        r7.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L14
    L19:
        return;
    L5:
        r7.writeInt(1);
        r7.writeInt(r0.size());
        Iterator<ObricConditionalTaskCreateRequest> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((ObricConditionalTaskCreateRequest) ZeusTransformUtils.preCheckCast(r1.next(), ObricConditionalTaskCreateRequest.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L7
    }

    public ObricConditionalTaskSweepRequest(List<ObricConditionalTaskCreateRequest> r3, Map<String, String> r4) {
        List<ObricConditionalTaskCreateRequest> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.taskList = r5;
        this.extra = r6;
    }

    public /* synthetic */ ObricConditionalTaskSweepRequest(List r2, Map r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = null;
    L8:
        this(r6, r7);
    }

    public final List<ObricConditionalTaskCreateRequest> getTaskList() {
        return this.taskList;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }
}
