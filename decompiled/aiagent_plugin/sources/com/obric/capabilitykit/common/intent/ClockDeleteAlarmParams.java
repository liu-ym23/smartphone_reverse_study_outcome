package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ClockDeleteAlarmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClockDeleteAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockDeleteAlarmParams> CREATOR = null;
    private Boolean deleteAll;
    private AlarmEntity target;

    /* JADX INFO: compiled from: ClockDeleteAlarmParams.kt */
    public static final class Creator implements Parcelable.Creator<ClockDeleteAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockDeleteAlarmParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            AlarmEntity r2 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r7.readParcelable(ClockDeleteAlarmParams.class.getClassLoader()), AlarmEntity.class, "com.obric.aiagent.plugin");
            int r5 = 1;
            if (r7.readInt() != 0) goto L6;
            Boolean r3 = null;
        L10:
            ClockDeleteAlarmParams r1 = new ClockDeleteAlarmParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
        L11:
            if (r5 > r4) goto L13;
            r5 = r5 + 1;
        L13:
            if (r5 > r0) goto L15;
            a.a(r7, r6);
            r5 = r5 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r8 = true;
        L9:
            r3 = Boolean.valueOf(r8);
            goto L10
        L8:
            r8 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockDeleteAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockDeleteAlarmParams[] newArray(int r1) {
            return new ClockDeleteAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockDeleteAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClockDeleteAlarmParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClockDeleteAlarmParams copy$default(ClockDeleteAlarmParams r0, AlarmEntity r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deleteAll;
    L9:
        return r0.copy(r1, r2);
    }

    public final AlarmEntity component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.deleteAll;
    }

    public final ClockDeleteAlarmParams copy(AlarmEntity r1, Boolean r2) {
        return new ClockDeleteAlarmParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockDeleteAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockDeleteAlarmParams r6 = (ClockDeleteAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockDeleteAlarmParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.deleteAll, r6.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AlarmEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.deleteAll;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClockDeleteAlarmParams(target=" + this.target + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        Boolean r4 = this.deleteAll;
        if (r4 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r4.booleanValue() ? 1 : 0);
    }

    public ClockDeleteAlarmParams(AlarmEntity r1, Boolean r2) {
        this.target = r1;
        this.deleteAll = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ClockDeleteAlarmParams(AlarmEntity r2, Boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final void setTarget(AlarmEntity r1) {
        this.target = r1;
    }

    public final Boolean getDeleteAll() {
        return this.deleteAll;
    }

    public final void setDeleteAll(Boolean r1) {
        this.deleteAll = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ClockDeleteAlarmParams.class) == false) goto L5;
        AlarmEntity r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((ClockDeleteAlarmParams) ZeusTransformUtils.preCheckCast(r4, ClockDeleteAlarmParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        Boolean r3 = this.deleteAll;
        if (r3 != null) goto L13;
        r3 = ((ClockDeleteAlarmParams) ZeusTransformUtils.preCheckCast(r4, ClockDeleteAlarmParams.class, "com.obric.aiagent.plugin")).deleteAll;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ClockDeleteAlarmParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
