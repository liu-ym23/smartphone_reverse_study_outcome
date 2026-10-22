package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTaskGetTaskInfoParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/EventTaskGetTaskInfoParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "taskId", "", "taskType", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getTaskType", "()Ljava/lang/Integer;", "setTaskType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/EventTaskGetTaskInfoParams;", "describeContents", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskGetTaskInfoParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<EventTaskGetTaskInfoParams> CREATOR = null;
    private String taskId;
    private Integer taskType;

    /* JADX INFO: compiled from: EventTaskGetTaskInfoParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EventTaskGetTaskInfoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskGetTaskInfoParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            EventTaskGetTaskInfoParams r1 = new EventTaskGetTaskInfoParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            ParcelUtils.skipValueSafely(r5, r6);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskGetTaskInfoParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EventTaskGetTaskInfoParams[] newArray(int r1) {
            return new EventTaskGetTaskInfoParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskGetTaskInfoParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTaskGetTaskInfoParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EventTaskGetTaskInfoParams copy$default(EventTaskGetTaskInfoParams r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.taskType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.taskId;
    }

    public final Integer component2() {
        return this.taskType;
    }

    public final EventTaskGetTaskInfoParams copy(String r1, Integer r2) {
        return new EventTaskGetTaskInfoParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EventTaskGetTaskInfoParams) == true) goto L8;
        return false;
    L8:
        EventTaskGetTaskInfoParams r6 = (EventTaskGetTaskInfoParams) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskType, r6.taskType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.taskType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskGetTaskInfoParams(taskId=" + this.taskId + ", taskType=" + this.taskType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.taskId);
        Integer r1 = this.taskType;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public EventTaskGetTaskInfoParams(String r1, Integer r2) {
        this.taskId = r1;
        this.taskType = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ EventTaskGetTaskInfoParams(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final void setTaskType(Integer r1) {
        this.taskType = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.taskId != null) goto L5;
    L7:
        return false;
    L5:
        if (this.taskType == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof EventTaskGetTaskInfoParams) == false) goto L5;
        String r0 = this.taskId;
        if (r0 != null) goto L9;
        r0 = ((EventTaskGetTaskInfoParams) r2).taskId;
    L9:
        Integer r1 = this.taskType;
        if (r1 != null) goto L13;
        r1 = ((EventTaskGetTaskInfoParams) r2).taskType;
    L13:
        return new EventTaskGetTaskInfoParams(r0, r1);
    L5:
        return this;
    }
}
