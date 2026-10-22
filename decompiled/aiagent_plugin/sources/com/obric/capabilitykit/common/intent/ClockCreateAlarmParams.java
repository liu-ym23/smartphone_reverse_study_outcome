package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ClockCreateAlarmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClockCreateAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockCreateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private String time;

    /* JADX INFO: compiled from: ClockCreateAlarmParams.kt */
    public static final class Creator implements Parcelable.Creator<ClockCreateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            o.e(r14, "parcel");
            String r3 = r14.readString();
            String r4 = r14.readString();
            boolean r5 = false;
            if (r14.readInt() != 0) goto L5;
            Integer[] r6 = null;
        L9:
            if (r14.readInt() != 0) goto L12;
            Boolean r1 = null;
        L15:
            ClockCreateAlarmParams r12 = new ClockCreateAlarmParams(r3, r4, r6, r1, r14.readString(), null, 32, null);
            int r2 = Math.min(r0, 1);
            ClassLoader r13 = getClass().getClassLoader();
            int r7 = 1;
        L16:
            if (r7 > r2) goto L22;
            if (r7 != 1) goto L21;
            Object r8 = a.b(r14, r13);
            if (r8 == null) goto L21;
            r12.repeatType = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        L21:
            r7 = r7 + 1;
        L22:
            if (r7 > r0) goto L24;
            a.a(r14, r13);
            r7 = r7 + 1;
            goto L22
        L24:
            return r12;
        L12:
            if (r14.readInt() == 0) goto L14;
            r5 = true;
        L14:
            r1 = Boolean.valueOf(r5);
            goto L15
        L5:
            int r9 = r14.readInt();
            r6 = new Integer[r9];
            int r10 = 0;
        L6:
            if (r10 == r9) goto L9;
            r6[r10] = Integer.valueOf(r14.readInt());
            r10 = r10 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams[] newArray(int r1) {
            return new ClockCreateAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ClockCreateAlarmParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ClockCreateAlarmParams copy$default(ClockCreateAlarmParams r4, String r5, String r6, Integer[] r7, Boolean r8, String r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.time;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.date;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.repeatDayOfWeek;
    L11:
        Integer[] r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.closeInHoliday;
    L14:
        Boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.name;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.repeatType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.date;
    }

    public final Integer[] component3() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component4() {
        return this.closeInHoliday;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.repeatType;
    }

    public final ClockCreateAlarmParams copy(String r8, String r9, Integer[] r10, Boolean r11, String r12, Integer r13) {
        return new ClockCreateAlarmParams(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockCreateAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockCreateAlarmParams r6 = (ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.time, r6.time) == true) goto L12;
        return false;
    L12:
        if (o.a(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (o.a(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L18;
        return false;
    L18:
        if (o.a(this.closeInHoliday, r6.closeInHoliday) == true) goto L21;
        return false;
    L21:
        if (o.a(this.name, r6.name) == true) goto L24;
        return false;
    L24:
        if (o.a(this.repeatType, r6.repeatType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.time;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer[] r7 = this.repeatDayOfWeek;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.closeInHoliday;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.name;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.repeatType;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClockCreateAlarmParams(time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(1);
        o.e(r6, "out");
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r0 = this.repeatDayOfWeek;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r1 = this.closeInHoliday;
        if (r1 != null) goto L11;
        r6.writeInt(0);
    L12:
        r6.writeString(this.name);
        r6.writeValue(this.repeatType);
        return;
    L11:
        r6.writeInt(1);
        r6.writeInt(r1.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r6.writeInt(1);
        int r2 = r0.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r0[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public ClockCreateAlarmParams(String r1, String r2, Integer[] r3, Boolean r4, String r5, Integer r6) {
        this.time = r1;
        this.date = r2;
        this.repeatDayOfWeek = r3;
        this.closeInHoliday = r4;
        this.name = r5;
        this.repeatType = r6;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ ClockCreateAlarmParams(String r2, String r3, Integer[] r4, Boolean r5, String r6, Integer r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
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
    public IntentParams mergeParams(Object r11) {
        if (ZeusTransformUtils.instanceOf(r11, ClockCreateAlarmParams.class) == false) goto L5;
        String r1 = this.time;
        if (r1 != null) goto L9;
        r1 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).time;
    L9:
        String r4 = r1;
        String r2 = this.date;
        if (r2 != null) goto L12;
        r2 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).date;
    L12:
        String r5 = r2;
        Integer[] r3 = this.repeatDayOfWeek;
        if (r3 != null) goto L15;
        r3 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).repeatDayOfWeek;
    L15:
        Integer[] r6 = r3;
        Boolean r7 = this.closeInHoliday;
        if (r7 != null) goto L18;
        r7 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).closeInHoliday;
    L18:
        Boolean r8 = r7;
        String r9 = this.name;
        if (r9 != null) goto L21;
        r9 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).name;
    L21:
        String r10 = r9;
        Integer r12 = this.repeatType;
        if (r12 != null) goto L25;
        r12 = ((ClockCreateAlarmParams) ZeusTransformUtils.preCheckCast(r11, ClockCreateAlarmParams.class, "com.obric.aiagent.plugin")).repeatType;
    L25:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new ClockCreateAlarmParams(r4, r5, r6, r8, r10, r12), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.time;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        StringBuilder r4 = r0.append(r3).append('|');
        String r5 = this.date;
        if (r5 == null) goto L9;
        String r6 = r5.toString();
    L10:
        StringBuilder r7 = r4.append(r6).append('|');
        Integer[] r8 = this.repeatDayOfWeek;
        if (r8 == null) goto L14;
        r2 = i.a(r8, null, null, null, 0, null, null, 63, null);
    L14:
        return r7.append(r2).toString();
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
