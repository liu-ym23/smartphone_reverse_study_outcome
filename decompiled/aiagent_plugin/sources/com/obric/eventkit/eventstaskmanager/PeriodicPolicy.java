package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PeriodicPolicy implements Parcelable {
    public static final Parcelable.Creator<PeriodicPolicy> CREATOR = null;
    private final boolean daily;
    private final boolean everyOffDay;
    private final boolean everyWorkDay;
    public String expireDate;
    public boolean isSingleTask;
    private final int monthly;
    private final String startDate;
    private final int[] weekly;
    private final String yearly;

    public static final class Creator implements Parcelable.Creator<PeriodicPolicy> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PeriodicPolicy createFromParcel(Parcel r18) {
            int r1 = r18.readInt();
            o.e(r18, "parcel");
            if (r18.readInt() == 0) goto L5;
            boolean r5 = true;
        L6:
            int[] r6 = r18.createIntArray();
            int r7 = r18.readInt();
            String r8 = r18.readString();
            if (r18.readInt() == 0) goto L9;
            boolean r9 = true;
        L11:
            if (r18.readInt() == 0) goto L13;
            boolean r10 = true;
        L14:
            boolean r4 = r5;
            boolean r11 = r9;
            boolean r12 = r10;
            PeriodicPolicy r2 = new PeriodicPolicy(r4, r6, r7, r8, r11, r12, null, false, r18.readString(), 192, null);
            int r13 = Math.min(r1, 2);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L15:
            if (r15 > r13) goto L26;
            if (r15 != 1) goto L21;
            Object r16 = com.obric.a.a.b(r18, r14);
            if (r16 == null) goto L25;
            r2.expireDate = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
        L25:
            r15 = r15 + 1;
            goto L15
        L21:
            if (r15 != 2) goto L25;
            Object r17 = com.obric.a.a.b(r18, r14);
            if (r17 == null) goto L25;
            r2.isSingleTask = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L26:
            if (r15 > r1) goto L28;
            com.obric.a.a.a(r18, r14);
            r15 = r15 + 1;
            goto L26
        L28:
            return r2;
        L13:
            r10 = false;
            goto L14
        L9:
            r9 = false;
            goto L11
        L5:
            r5 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PeriodicPolicy createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PeriodicPolicy[] newArray(int r1) {
            return new PeriodicPolicy[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PeriodicPolicy[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PeriodicPolicy() {
        this(false, null, 0, null, false, false, null, false, null, 511, null);
    }

    public PeriodicPolicy(boolean r1, int[] r2, int r3, String r4, boolean r5, boolean r6, String r7, boolean r8, String r9) {
        this.daily = r1;
        this.weekly = r2;
        this.monthly = r3;
        this.yearly = r4;
        this.everyOffDay = r5;
        this.everyWorkDay = r6;
        this.expireDate = r7;
        this.isSingleTask = r8;
        this.startDate = r9;
    }

    public /* synthetic */ PeriodicPolicy(boolean r3, int[] r4, int r5, String r6, boolean r7, boolean r8, String r9, boolean r10, String r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = false;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r10 = false;
    L27:
        if ((r12 & 256) == 0) goto L29;
        r11 = null;
    L29:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ PeriodicPolicy copy$default(PeriodicPolicy r10, boolean r11, int[] r12, int r13, String r14, boolean r15, boolean r16, String r17, boolean r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.daily;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int[] r3 = r10.weekly;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.monthly;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.yearly;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.everyOffDay;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.everyWorkDay;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.expireDate;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.isSingleTask;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.startDate;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public static /* synthetic */ void getExpireDate$annotations() {
    }

    public static /* synthetic */ void isSingleTask$annotations() {
    }

    public final boolean component1() {
        return this.daily;
    }

    public final int[] component2() {
        return this.weekly;
    }

    public final int component3() {
        return this.monthly;
    }

    public final String component4() {
        return this.yearly;
    }

    public final boolean component5() {
        return this.everyOffDay;
    }

    public final boolean component6() {
        return this.everyWorkDay;
    }

    public final String component7() {
        return this.expireDate;
    }

    public final boolean component8() {
        return this.isSingleTask;
    }

    public final String component9() {
        return this.startDate;
    }

    public final PeriodicPolicy copy(boolean r12, int[] r13, int r14, String r15, boolean r16, boolean r17, String r18, boolean r19, String r20) {
        return new PeriodicPolicy(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r2 = r5.getClass();
    L9:
        if (o.a(PeriodicPolicy.class, r2) == true) goto L11;
        return false;
    L11:
        o.a(r5, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.PeriodicPolicy");
        PeriodicPolicy r6 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r5, PeriodicPolicy.class, "com.obric.aiagent.plugin");
        if (this.daily == r6.daily) goto L15;
        return false;
    L15:
        if (this.monthly == r6.monthly) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.weekly, r6.weekly) == true) goto L21;
        return false;
    L21:
        if (o.a(this.yearly, r6.yearly) == true) goto L24;
        return false;
    L24:
        if (o.a(this.expireDate, r6.expireDate) == true) goto L27;
        return false;
    L27:
        if (this.everyOffDay == r6.everyOffDay) goto L30;
        return false;
    L30:
        if (this.everyWorkDay == r6.everyWorkDay) goto L33;
        return false;
    L33:
        if (o.a(this.startDate, r6.startDate) == true) goto L35;
        return false;
    L35:
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean getDaily() {
        return this.daily;
    }

    public final boolean getEveryOffDay() {
        return this.everyOffDay;
    }

    public final boolean getEveryWorkDay() {
        return this.everyWorkDay;
    }

    public final String getExpireDate() {
        return this.expireDate;
    }

    public final int getMonthly() {
        return this.monthly;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final int[] getWeekly() {
        return this.weekly;
    }

    public final String getYearly() {
        return this.yearly;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.daily) * 31) + this.monthly) * 31;
        int[] r1 = this.weekly;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = Arrays.hashCode(r1);
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.yearly;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((r4 + r6) * 31) + Boolean.hashCode(this.everyOffDay)) * 31) + Boolean.hashCode(this.everyWorkDay)) * 31;
        String r8 = this.expireDate;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + Boolean.hashCode(this.isSingleTask)) * 31;
        String r11 = this.startDate;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final boolean isSingleTask() {
        return this.isSingleTask;
    }

    public final void setExpireDate(String r1) {
        this.expireDate = r1;
    }

    public final void setSingleTask(boolean r1) {
        this.isSingleTask = r1;
    }

    public String toString() {
        return "PeriodicPolicy(daily=" + this.daily + ", weekly=" + Arrays.toString(this.weekly) + ", monthly=" + this.monthly + ", yearly=" + this.yearly + ", everyOffDay=" + this.everyOffDay + ", everyWorkDay=" + this.everyWorkDay + ", expireDate=" + this.expireDate + ", isSingleTask=" + this.isSingleTask + ", startDate=" + this.startDate + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        o.e(r1, "out");
        r1.writeInt(this.daily ? 1 : 0);
        r1.writeIntArray(this.weekly);
        r1.writeInt(this.monthly);
        r1.writeString(this.yearly);
        r1.writeInt(this.everyOffDay ? 1 : 0);
        r1.writeInt(this.everyWorkDay ? 1 : 0);
        r1.writeString(this.startDate);
        r1.writeValue(this.expireDate);
        r1.writeValue(Boolean.valueOf(this.isSingleTask));
    }
}
