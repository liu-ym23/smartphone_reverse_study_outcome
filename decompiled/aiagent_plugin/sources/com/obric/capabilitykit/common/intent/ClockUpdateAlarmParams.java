package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ClockUpdateAlarmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClockUpdateAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private AlarmEntity target;
    private String time;

    /* JADX INFO: compiled from: ClockUpdateAlarmParams.kt */
    public static final class Creator implements Parcelable.Creator<ClockUpdateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams createFromParcel(Parcel r17) {
            int r1 = r17.readInt();
            o.e(r17, "parcel");
            AlarmEntity r6 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r17.readParcelable(ClockUpdateAlarmParams.class.getClassLoader()), AlarmEntity.class, "com.obric.aiagent.plugin");
            String r7 = r17.readString();
            String r8 = r17.readString();
            boolean r5 = false;
            if (r17.readInt() != 0) goto L5;
            Integer[] r9 = null;
        L9:
            if (r17.readInt() != 0) goto L12;
            Boolean r10 = null;
        L15:
            ClockUpdateAlarmParams r2 = new ClockUpdateAlarmParams(r6, r7, r8, r9, r10, r17.readString(), null, 64, null);
            int r3 = Math.min(r1, 1);
            ClassLoader r11 = getClass().getClassLoader();
            int r12 = 1;
        L16:
            if (r12 > r3) goto L22;
            if (r12 != 1) goto L21;
            Object r13 = a.b(r17, r11);
            if (r13 == null) goto L21;
            r2.repeatType = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.aiagent.plugin");
        L21:
            r12 = r12 + 1;
        L22:
            if (r12 > r1) goto L24;
            a.a(r17, r11);
            r12 = r12 + 1;
            goto L22
        L24:
            return r2;
        L12:
            if (r17.readInt() == 0) goto L14;
            r5 = true;
        L14:
            r10 = Boolean.valueOf(r5);
            goto L15
        L5:
            int r4 = r17.readInt();
            r9 = new Integer[r4];
            int r14 = 0;
        L6:
            if (r14 == r4) goto L9;
            r9[r14] = Integer.valueOf(r17.readInt());
            r14 = r14 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams[] newArray(int r1) {
            return new ClockUpdateAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ClockUpdateAlarmParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ClockUpdateAlarmParams copy$default(ClockUpdateAlarmParams r5, AlarmEntity r6, String r7, String r8, Integer[] r9, Boolean r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.target;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.time;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.date;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.repeatDayOfWeek;
    L14:
        Integer[] r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.closeInHoliday;
    L17:
        Boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.name;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.repeatType;
    L23:
        AlarmEntity r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final AlarmEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.date;
    }

    public final Integer[] component4() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component5() {
        return this.closeInHoliday;
    }

    public final String component6() {
        return this.name;
    }

    public final Integer component7() {
        return this.repeatType;
    }

    public final ClockUpdateAlarmParams copy(AlarmEntity r9, String r10, String r11, Integer[] r12, Boolean r13, String r14, Integer r15) {
        return new ClockUpdateAlarmParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockUpdateAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r6 = (ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (o.a(this.date, r6.date) == true) goto L18;
        return false;
    L18:
        if (o.a(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L21;
        return false;
    L21:
        if (o.a(this.closeInHoliday, r6.closeInHoliday) == true) goto L24;
        return false;
    L24:
        if (o.a(this.name, r6.name) == true) goto L27;
        return false;
    L27:
        if (o.a(this.repeatType, r6.repeatType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        AlarmEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.date;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer[] r10 = this.repeatDayOfWeek;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.closeInHoliday;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.name;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.repeatType;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(1);
        o.e(r6, "out");
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r8 = this.repeatDayOfWeek;
        if (r8 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r9 = this.closeInHoliday;
        if (r9 != null) goto L11;
        r6.writeInt(0);
    L12:
        r6.writeString(this.name);
        r6.writeValue(this.repeatType);
        return;
    L11:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r6.writeInt(1);
        int r2 = r8.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r8[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public ClockUpdateAlarmParams(AlarmEntity r1, String r2, String r3, Integer[] r4, Boolean r5, String r6, Integer r7) {
        this.target = r1;
        this.time = r2;
        this.date = r3;
        this.repeatDayOfWeek = r4;
        this.closeInHoliday = r5;
        this.name = r6;
        this.repeatType = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r2, String r3, String r4, Integer[] r5, Boolean r6, String r7, Integer r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final void setTarget(AlarmEntity r1) {
        this.target = r1;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String r1) {
        this.time = r1;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final void setRepeatDayOfWeek(Integer[] r1) {
        this.repeatDayOfWeek = r1;
    }

    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final void setCloseInHoliday(Boolean r1) {
        this.closeInHoliday = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final void setRepeatType(Integer r1) {
        this.repeatType = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, ClockUpdateAlarmParams.class) == false) goto L5;
        AlarmEntity r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        AlarmEntity r4 = r1;
        String r2 = this.time;
        if (r2 != null) goto L12;
        r2 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).time;
    L12:
        String r5 = r2;
        String r3 = this.date;
        if (r3 != null) goto L15;
        r3 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).date;
    L15:
        String r6 = r3;
        Integer[] r7 = this.repeatDayOfWeek;
        if (r7 != null) goto L18;
        r7 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).repeatDayOfWeek;
    L18:
        Integer[] r8 = r7;
        Boolean r9 = this.closeInHoliday;
        if (r9 != null) goto L21;
        r9 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).closeInHoliday;
    L21:
        Boolean r10 = r9;
        String r11 = this.name;
        if (r11 != null) goto L24;
        r11 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).name;
    L24:
        String r13 = r11;
        Integer r14 = this.repeatType;
        if (r14 != null) goto L28;
        r14 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.aiagent.plugin")).repeatType;
    L28:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ClockUpdateAlarmParams(r4, r5, r6, r8, r10, r13, r14), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
