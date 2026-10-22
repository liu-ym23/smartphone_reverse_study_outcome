package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ClockTurnOffAlarmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClockTurnOffAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockTurnOffAlarmParams> CREATOR = null;
    private Boolean always;
    private AlarmEntity[] targets;
    private Boolean turnOffAll;

    /* JADX INFO: compiled from: ClockTurnOffAlarmParams.kt */
    public static final class Creator implements Parcelable.Creator<ClockTurnOffAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            Boolean r2 = null;
            if (r10.readInt() != 0) goto L5;
            AlarmEntity[] r4 = null;
        L8:
            int r5 = 1;
            if (r10.readInt() != 0) goto L12;
            Boolean r1 = null;
        L17:
            if (r10.readInt() != 0) goto L20;
        L24:
            ClockTurnOffAlarmParams r6 = new ClockTurnOffAlarmParams(r4, r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L25:
            if (r5 > r3) goto L27;
            r5 = r5 + 1;
        L27:
            if (r5 > r0) goto L29;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L27
        L29:
            return r6;
        L20:
            if (r10.readInt() == 0) goto L22;
            boolean r7 = true;
        L23:
            r2 = Boolean.valueOf(r7);
            goto L24
        L22:
            r7 = false;
            goto L23
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r8 = true;
        L15:
            r1 = Boolean.valueOf(r8);
            goto L17
        L14:
            r8 = false;
            goto L15
        L5:
            int r11 = r10.readInt();
            r4 = new AlarmEntity[r11];
            int r12 = 0;
        L6:
            if (r12 == r11) goto L8;
            r4[r12] = (AlarmEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(ClockTurnOffAlarmParams.class.getClassLoader()), AlarmEntity.class, "com.obric.aiagent.plugin");
            r12 = r12 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams[] newArray(int r1) {
            return new ClockTurnOffAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ClockTurnOffAlarmParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ClockTurnOffAlarmParams copy$default(ClockTurnOffAlarmParams r0, AlarmEntity[] r1, Boolean r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.turnOffAll;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.always;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final AlarmEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.turnOffAll;
    }

    public final Boolean component3() {
        return this.always;
    }

    public final ClockTurnOffAlarmParams copy(AlarmEntity[] r1, Boolean r2, Boolean r3) {
        return new ClockTurnOffAlarmParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockTurnOffAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockTurnOffAlarmParams r6 = (ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (o.a(this.turnOffAll, r6.turnOffAll) == true) goto L15;
        return false;
    L15:
        if (o.a(this.always, r6.always) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        AlarmEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.turnOffAll;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.always;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "ClockTurnOffAlarmParams(targets=" + Arrays.toString(this.targets) + ", turnOffAll=" + this.turnOffAll + ", always=" + this.always + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        r9.writeInt(0);
        o.e(r9, "out");
        AlarmEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r9.writeInt(0);
    L8:
        Boolean r11 = this.turnOffAll;
        if (r11 != null) goto L11;
        r9.writeInt(0);
    L12:
        Boolean r8 = this.always;
        if (r8 != null) goto L15;
        r9.writeInt(0);
        return;
    L15:
        r9.writeInt(1);
        r9.writeInt(r8.booleanValue() ? 1 : 0);
        return;
    L11:
        r9.writeInt(1);
        r9.writeInt(r11.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r9.writeInt(1);
        int r3 = r1.length;
        r9.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r4], Parcelable.class, "com.obric.aiagent.plugin"), r10);
        r4 = r4 + 1;
        goto L6
    }

    public ClockTurnOffAlarmParams(AlarmEntity[] r1, Boolean r2, Boolean r3) {
        this.targets = r1;
        this.turnOffAll = r2;
        this.always = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ClockTurnOffAlarmParams(AlarmEntity[] r2, Boolean r3, Boolean r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final AlarmEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(AlarmEntity[] r1) {
        this.targets = r1;
    }

    public final Boolean getTurnOffAll() {
        return this.turnOffAll;
    }

    public final void setTurnOffAll(Boolean r1) {
        this.turnOffAll = r1;
    }

    public final Boolean getAlways() {
        return this.always;
    }

    public final void setAlways(Boolean r1) {
        this.always = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, ClockTurnOffAlarmParams.class) == false) goto L5;
        AlarmEntity[] r1 = this.targets;
        if (r1 != null) goto L9;
        r1 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.aiagent.plugin")).targets;
    L9:
        Boolean r3 = this.turnOffAll;
        if (r3 != null) goto L12;
        r3 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.aiagent.plugin")).turnOffAll;
    L12:
        Boolean r4 = this.always;
        if (r4 != null) goto L16;
        r4 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.aiagent.plugin")).always;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ClockTurnOffAlarmParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
