package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskRecordV2 extends EventTaskRecord {
    public static final Parcelable.Creator<ConditionTaskRecordV2> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new ConditionTaskRecordV2$Companion$CREATOR$1();
    }

    public ConditionTaskRecordV2(long r11, String r13, long r14, String r16, int r17) {
        super(2, r11, r13, r14, r16, r17);
        this.id = r11;
        this.taskId = r13;
        this.triggerTime = r14;
        this.sourceFrom = r16;
        this.result = r17;
    }

    public ConditionTaskRecordV2(long r2, String r4, long r5, String r7, int r8, Parcel r9) {
        o.e(r9, "parcel");
        this(r2, r4, r5, r7, r8);
        readExtensionFieldFromParcel$eventstaskkit_release(r9);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r9, 0);
    }

    public static /* synthetic */ ConditionTaskRecordV2 copy$default(ConditionTaskRecordV2 r7, long r8, String r10, long r11, String r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L5;
        long r0 = r7.getId();
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r2 = r7.getTaskId();
    L11:
        if ((r15 & 4) == 0) goto L13;
        long r3 = r7.getTriggerTime();
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r5 = r7.getSourceFrom();
    L19:
        if ((r15 & 16) == 0) goto L21;
        int r6 = r7.getResult();
    L23:
        return r7.copy(r0, r2, r3, r5, r6);
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public final long component1() {
        return getId();
    }

    public final String component2() {
        return getTaskId();
    }

    public final long component3() {
        return getTriggerTime();
    }

    public final String component4() {
        return getSourceFrom();
    }

    public final int component5() {
        return getResult();
    }

    public final ConditionTaskRecordV2 copy(long r9, String r11, long r12, String r14, int r15) {
        return new ConditionTaskRecordV2(r9, r11, r12, r14, r15);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ConditionTaskRecordV2.class) == true) goto L8;
        return false;
    L8:
        ConditionTaskRecordV2 r10 = (ConditionTaskRecordV2) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordV2.class, "com.obric.aiagent.plugin");
        if (getId() == r10.getId()) goto L12;
        return false;
    L12:
        if (o.a(getTaskId(), r10.getTaskId()) == true) goto L15;
        return false;
    L15:
        if (getTriggerTime() == r10.getTriggerTime()) goto L18;
        return false;
    L18:
        if (o.a(getSourceFrom(), r10.getSourceFrom()) == true) goto L21;
        return false;
    L21:
        if (getResult() == r10.getResult()) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public int getResult() {
        return this.result;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getTaskId() {
        return this.taskId;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r0 = Long.hashCode(getId()) * 31;
        int r2 = 0;
        if (getTaskId() != null) goto L5;
        int r1 = 0;
    L6:
        int r3 = (((r0 + r1) * 31) + Long.hashCode(getTriggerTime())) * 31;
        if (getSourceFrom() == null) goto L11;
        r2 = getSourceFrom().hashCode();
    L11:
        return ((r3 + r2) * 31) + Integer.hashCode(getResult());
    L5:
        r1 = getTaskId().hashCode();
        goto L6
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public String toString() {
        return "ConditionTaskRecordV2(id=" + getId() + ", taskId=" + getTaskId() + ", triggerTime=" + getTriggerTime() + ", sourceFrom=" + getSourceFrom() + ", result=" + getResult() + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        o.e(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
