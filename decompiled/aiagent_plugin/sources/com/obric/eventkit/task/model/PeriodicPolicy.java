package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ConditionTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PeriodicPolicy implements Parcelable {
    public static final Parcelable.Creator<PeriodicPolicy> CREATOR = null;
    private final boolean daily;
    private final boolean everyOffDay;
    private final boolean everyWorkDay;
    private String expireDate;
    private boolean isSingleTask;
    private final int monthly;
    private final String startDate;
    private final int[] weekly;
    private final String yearly;

    /* JADX INFO: compiled from: ConditionTask.kt */
    public static final class Creator implements Parcelable.Creator<PeriodicPolicy> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PeriodicPolicy createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            if (r12.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            int[] r4 = r12.createIntArray();
            int r5 = r12.readInt();
            String r6 = r12.readString();
            if (r12.readInt() == 0) goto L9;
            boolean r7 = true;
        L11:
            if (r12.readInt() == 0) goto L13;
            boolean r8 = true;
        L14:
            String r9 = r12.readString();
            if (r12.readInt() == 0) goto L17;
            boolean r10 = true;
        L19:
            return new PeriodicPolicy(r3, r4, r5, r6, r7, r8, r9, r10, r12.readString());
        L17:
            r10 = false;
            goto L19
        L13:
            r8 = false;
            goto L14
        L9:
            r7 = false;
            goto L11
        L5:
            r3 = false;
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
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PeriodicPolicy() {
        this(false, null, 0, null, false, false, null, false, null, 511, null);
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
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "PeriodicPolicy(daily=" + this.daily + ", weekly=" + Arrays.toString(this.weekly) + ", monthly=" + this.monthly + ", yearly=" + this.yearly + ", everyOffDay=" + this.everyOffDay + ", everyWorkDay=" + this.everyWorkDay + ", expireDate=" + this.expireDate + ", isSingleTask=" + this.isSingleTask + ", startDate=" + this.startDate + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.daily ? 1 : 0);
        r1.writeIntArray(this.weekly);
        r1.writeInt(this.monthly);
        r1.writeString(this.yearly);
        r1.writeInt(this.everyOffDay ? 1 : 0);
        r1.writeInt(this.everyWorkDay ? 1 : 0);
        r1.writeString(this.expireDate);
        r1.writeInt(this.isSingleTask ? 1 : 0);
        r1.writeString(this.startDate);
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

    public final boolean getDaily() {
        return this.daily;
    }

    public final int[] getWeekly() {
        return this.weekly;
    }

    public final int getMonthly() {
        return this.monthly;
    }

    public final String getYearly() {
        return this.yearly;
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

    public final void setExpireDate(String r1) {
        this.expireDate = r1;
    }

    public final boolean isSingleTask() {
        return this.isSingleTask;
    }

    public final void setSingleTask(boolean r1) {
        this.isSingleTask = r1;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r7, "null cannot be cast to non-null type com.obric.eventkit.task.model.PeriodicPolicy");
        PeriodicPolicy r4 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin");
        if (this.daily == ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).daily) goto L16;
        return false;
    L16:
        if (this.monthly == ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).monthly) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.weekly, ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).weekly) == true) goto L22;
        return false;
    L22:
        if (o.a(this.yearly, ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).yearly) == true) goto L25;
        return false;
    L25:
        if (o.a(this.expireDate, ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).expireDate) == true) goto L28;
        return false;
    L28:
        if (this.everyOffDay == ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).everyOffDay) goto L31;
        return false;
    L31:
        if (this.everyWorkDay == ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).everyWorkDay) goto L34;
        return false;
    L34:
        if (o.a(this.startDate, ((PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7, PeriodicPolicy.class, "com.obric.aiagent.plugin")).startDate) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r3 = null;
        goto L10
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
}
